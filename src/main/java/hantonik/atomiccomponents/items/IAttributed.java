package hantonik.atomiccomponents.items;

import hantonik.atomiccomponents.registration.object.FluidObject;
import net.minecraft.world.level.material.Fluid;

public interface IAttributed {
    FluidObject<? extends Fluid> getMelted();
    int getMeltingTemperature();
    int getBurningTemperature();
    boolean isBurnable();
    boolean isFusible();
}
