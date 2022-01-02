package hantonik.atomiccomponents.init;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.registration.FluidDeferredRegisterExtension;
import hantonik.atomiccomponents.registration.ModelFluidAttributes;
import hantonik.atomiccomponents.registration.object.FluidObject;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

@SuppressWarnings("unused")
public final class AtomicFluids {
    public static final FluidDeferredRegisterExtension FLUIDS = new FluidDeferredRegisterExtension(AtomicComponents.MOD_ID);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_TITANIUM = FLUIDS.register("molten_titanium", hotBuilder().temperature(1668), Material.LAVA, 12);

    private static FluidAttributes.Builder coolBuilder() {
        return ModelFluidAttributes.builder().sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY);
    }

    private static FluidAttributes.Builder hotBuilder() {
        return ModelFluidAttributes.builder().density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA);
    }
}
