package hantonik.atomiccomponents.registration.object;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public class FluidObject<F extends ForgeFlowingFluid> implements Supplier<F>, IItemProvider {
    @Nullable
    private final Supplier<? extends FlowingFluidBlock> block;
    private final Supplier<? extends F> still;
    private final Supplier<? extends F> flowing;
    private Tags.IOptionalNamedTag<Fluid> localTag;
    private Tags.IOptionalNamedTag<Fluid> forgeTag;
    protected ResourceLocation id;

    public FluidObject(ResourceLocation id, String tagName, Supplier<? extends F> still, Supplier<? extends F> flowing, @Nullable Supplier<? extends FlowingFluidBlock> block) {
        this.id = id;
        this.localTag = FluidTags.createOptional(id);
        this.forgeTag = FluidTags.createOptional(new ResourceLocation("forge", tagName));
        this.still = still;
        this.flowing = flowing;
        this.block = block;
    }

    @Deprecated
    public FluidObject(Supplier<? extends F> still, Supplier<? extends F> flowing, @Nullable Supplier<? extends FlowingFluidBlock> block) {
        this.still = still;
        this.flowing = flowing;
        this.block = block;
    }

    public ResourceLocation getId() {
        if (this.id == null)
            this.id = Objects.requireNonNull(this.getStill().getRegistryName(), "Fluid has null ID");

        return this.id;
    }

    public F getStill() {
        return Objects.requireNonNull(this.still.get(), "Fluid object missing still fluid");
    }

    public F get() {
        return this.getStill();
    }

    public F getFlowing() {
        return Objects.requireNonNull(this.flowing.get(), "Fluid object missing flowing fluid");
    }

    @Nullable
    public FlowingFluidBlock getBlock() {
        return this.block == null ? null : this.block.get();
    }

    public Item asItem() {
        return this.still.get().getBucket();
    }

    public Tags.IOptionalNamedTag<Fluid> getLocalTag() {
        if (this.localTag == null)
            this.localTag = FluidTags.createOptional(this.getId());

        return this.localTag;
    }

    public Tags.IOptionalNamedTag<Fluid> getForgeTag() {
        if (this.forgeTag == null)
            this.forgeTag = FluidTags.createOptional(new ResourceLocation("forge", this.getId().getPath()));

        return this.forgeTag;
    }
}
