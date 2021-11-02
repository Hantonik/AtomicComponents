package hantonik.atomiccomponents.registration.object;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IRegistryDelegate;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings({"unused", "WeakerAccess", "rawtypes"})
public class EnumObject<T extends Enum<T>, I extends IForgeRegistryEntry<? super I>> {
    @SuppressWarnings("unchecked")
    private static final EnumObject EMPTY = new EnumObject(Collections.emptyMap());

    private final Map<T, Supplier<? extends I>> map;

    protected EnumObject(Map<T, Supplier<? extends I>> map) {
        this.map = map;
    }

    @Nullable
    public Supplier<? extends I> getSupplier(T value) {
        return map.get(value);
    }

    public I get(T value) {
        Supplier<? extends I> supplier = map.get(value);

        if (supplier == null)
            throw new NoSuchElementException("Missing key " + value);

        return Objects.requireNonNull(supplier.get(), () -> "No enum object value for " + value);
    }

    @Nullable
    public I getOrNull(T value) {
        Supplier<? extends I> supplier = map.get(value);

        if (supplier == null)
            return null;

        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean contains(IForgeRegistryEntry<? super I> value) {
        return this.map.values().stream().map(Supplier::get).anyMatch(value::equals);
    }

    public List<I> values() {
        return this.map.values().stream().map(Supplier::get).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public void forEach(BiConsumer<T, ? super I> consumer) {
        this.map.forEach((key, sup) -> {
            I value;

            try {
                value = sup.get();
            } catch (NullPointerException e) {
                return;
            }

            if (value != null)
                consumer.accept(key, value);
        });
    }

    public void forEach(Consumer<? super I> consumer) {
        forEach((k, v) -> consumer.accept(v));
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>, I extends IForgeRegistryEntry<? super I>> EnumObject<T,I> empty() {
        return (EnumObject<T,I>) EMPTY;
    }

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    public static class Builder<T extends Enum<T>, I extends IForgeRegistryEntry<? super I>> {
        private final Map<T, Supplier<? extends I>> map;

        public Builder(Class<T> clazz) {
            this.map = new EnumMap<>(clazz);
        }

        public Builder<T,I> put(T key, Supplier<? extends I> value) {
            this.map.put(key, value);

            return this;
        }

        @SuppressWarnings("unchecked")
        public Builder<T,I> putDelegate(T key, IRegistryDelegate<? super I> value) {
            this.map.put(key, () -> (I) value.get());

            return this;
        }

        public Builder<T,I> putAll(Map<T, Supplier<? extends I>> map) {
            this.map.putAll(map);

            return this;
        }

        public Builder<T,I> putAll(EnumObject<T,? extends I> object) {
            this.map.putAll(object.map);

            return this;
        }

        public EnumObject<T,I> build() {
            return new EnumObject<>(map);
        }
    }
}