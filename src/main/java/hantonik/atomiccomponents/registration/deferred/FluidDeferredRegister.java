package hantonik.atomiccomponents.registration.deferred;

import hantonik.atomiccomponents.registration.ItemProperties;
import hantonik.atomiccomponents.registration.DelayedSupplier;
import hantonik.atomiccomponents.registration.FluidBuilder;
import hantonik.atomiccomponents.registration.object.FluidObject;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FluidDeferredRegister extends DeferredRegisterWrapper<Fluid> {
    private final DeferredRegister<Block> blockRegister;
    private final DeferredRegister<Item> itemRegister;

    public FluidDeferredRegister(String modID) {
        super(ForgeRegistries.FLUIDS, modID);

        this.blockRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, modID);
        this.itemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, modID);
    }

    public void load(IEventBus bus) {
        super.register(bus);

        this.blockRegister.register(bus);
        this.itemRegister.register(bus);
    }

    public <I extends Fluid> RegistryObject<I> registerFluid(final String name, final Supplier<? extends I> sup) {
        return this.register.register(name, sup);
    }

    public <F extends ForgeFlowingFluid> FluidObject<F> register(String name, String tagName, FluidBuilder builder, Function<Properties, ? extends F> still, Function<Properties, ? extends F> flowing, Function<Supplier<? extends FlowingFluid>, ? extends FlowingFluidBlock> block) {
        DelayedSupplier<F> stillDelayed = new DelayedSupplier<>();
        DelayedSupplier<F> flowingDelayed = new DelayedSupplier<>();

        RegistryObject<FlowingFluidBlock> blockObj = this.blockRegister.register(name + "_fluid", () -> block.apply(stillDelayed));
        builder.bucket(this.itemRegister.register(name + "_bucket", () -> new BucketItem(stillDelayed, ItemProperties.BUCKET_PROPS)));

        Properties props = builder.block(blockObj).build(stillDelayed, flowingDelayed);

        Supplier<F> stillSup = registerFluid(name, () -> still.apply(props));
        stillDelayed.setSupplier(stillSup);
        Supplier<F> flowingSup = registerFluid("flowing_" + name, () -> flowing.apply(props));
        flowingDelayed.setSupplier(flowingSup);

        return new FluidObject<>(resource(name), tagName, stillSup, flowingSup, blockObj);
    }

    public <F extends ForgeFlowingFluid> FluidObject<F> register(String name, FluidBuilder builder, Function<Properties, ? extends F> still, Function<Properties, ? extends F> flowing, Function<Supplier<? extends FlowingFluid>, ? extends FlowingFluidBlock> block) {
        return register(name, name, builder, still, flowing, block);
    }

    public <F extends ForgeFlowingFluid> FluidObject<F> register(String name, String tagName, FluidAttributes.Builder builder, Function<Properties, ? extends F> still, Function<Properties, ? extends F> flowing, Material material, int lightLevel) {
        return register(name, tagName, new FluidBuilder(builder).explosionResistance(100F), still, flowing, (fluid) -> new FlowingFluidBlock(fluid, Block.Properties.of(material).air().strength(100.0F).noDrops().lightLevel((state) -> lightLevel)));
    }

    public <F extends ForgeFlowingFluid> FluidObject<F> register(String name, FluidAttributes.Builder builder, Function<Properties, ? extends F> still, Function<Properties, ? extends F> flowing, Material material, int lightLevel) {
        return register(name, name, builder, still, flowing, material, lightLevel);
    }

    public FluidObject<ForgeFlowingFluid> register(String name, String tagName, FluidAttributes.Builder builder, Material material, int lightLevel) {
        return register(name, tagName, builder, ForgeFlowingFluid.Source::new, ForgeFlowingFluid.Flowing::new, material, lightLevel);
    }

    public FluidObject<ForgeFlowingFluid> register(String name, FluidAttributes.Builder builder, Material material, int lightLevel) {
        return register(name, name, builder, material, lightLevel);
    }
}
