package hantonik.atomiccomponents.registration;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DelayedSupplier<T> implements Supplier<T> {
    @Nullable
    private Supplier<T> supplier;

    public void setSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if (supplier == null)
            throw new IllegalStateException("Attempted to call DelayedSupplier::get() before the supplier was set");

        return supplier.get();
    }
}
