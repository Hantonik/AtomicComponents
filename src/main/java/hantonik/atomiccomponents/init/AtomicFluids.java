package hantonik.atomiccomponents.init;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccore.registration.FluidDeferredRegisterExtension;
import hantonik.atomiccore.registration.ModelFluidAttributes;
import hantonik.atomiccore.registration.object.FluidObject;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

@SuppressWarnings("unused")
public final class AtomicFluids {
    public static final FluidDeferredRegisterExtension FLUIDS = new FluidDeferredRegisterExtension(AtomicComponents.MOD_ID);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ALUMINUM = FLUIDS.register("molten_aluminum", hotBuilder().temperature(934), Material.LAVA, 14);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LEAD = FLUIDS.register("molten_lead", hotBuilder().temperature(601), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_TITANIUM = FLUIDS.register("molten_titanium", hotBuilder().temperature(1941), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_TIN = FLUIDS.register("molten_tin", hotBuilder().temperature(505), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_SILVER = FLUIDS.register("molten_silver", hotBuilder().temperature(1235), Material.LAVA, 12);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_BRONZE = FLUIDS.register("molten_bronze", hotBuilder().temperature(1223), Material.LAVA, 10);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_STEEL = FLUIDS.register("molten_steel", hotBuilder().temperature(1783), Material.LAVA, 13);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_COPPER = FLUIDS.register("molten_copper", hotBuilder().temperature(1358), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_IRON = FLUIDS.register("molten_iron", hotBuilder().temperature(1811), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_GOLD = FLUIDS.register("molten_gold", hotBuilder().temperature(1337), Material.LAVA, 12);

    private static FluidAttributes.Builder coolBuilder() {
        return ModelFluidAttributes.builder().sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY);
    }

    private static FluidAttributes.Builder hotBuilder() {
        return ModelFluidAttributes.builder().density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA);
    }
}
