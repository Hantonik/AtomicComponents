package hantonik.atomiccomponents.registration.deferred;

import hantonik.atomiccomponents.registration.object.EnumObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.BiFunction;
import java.util.function.Supplier;

@SuppressWarnings("WeakerAccess")
public abstract class DeferredRegisterWrapper<T extends IForgeRegistryEntry<T>> {
    protected final DeferredRegister<T> register;
    private final String modID;

    protected DeferredRegisterWrapper(IForgeRegistry<T> reg, String modID) {
        this.register = DeferredRegister.create(reg, modID);
        this.modID = modID;
    }

    public void register(IEventBus bus) {
        this.register.register(bus);
    }

    protected ResourceLocation resource(String name) {
        return new ResourceLocation(this.modID, name);
    }

    protected String resourceName(String name) {
        return this.modID + ":" + name;
    }

    protected static <E extends Enum<E> & StringRepresentable, V extends T, T extends IForgeRegistryEntry<T>> EnumObject<E, V> registerEnum(E[] values, String name, BiFunction<String, E, Supplier<? extends V>> register) {
        if (values.length == 0)
            throw new IllegalArgumentException("Must have at least one value");

        EnumObject.Builder<E,V> builder = new EnumObject.Builder<>(values[0].getDeclaringClass());

        for (E value : values)
            builder.put(value, register.apply(value.getSerializedName() + "_" + name, value));

        return builder.build();
    }

    protected static <E extends Enum<E> & StringRepresentable, V extends T, T extends IForgeRegistryEntry<T>> EnumObject<E, V> registerEnum(String name, E[] values, BiFunction<String, E, Supplier<? extends V>> register) {
        if (values.length == 0)
            throw new IllegalArgumentException("Must have at least one value");

        EnumObject.Builder<E, V> builder = new EnumObject.Builder<>(values[0].getDeclaringClass());

        for (E value : values)
            builder.put(value, register.apply(name + "_" + value.getSerializedName(), value));

        return builder.build();
    }
}
