package hantonik.atomiccomponents.registration;

import hantonik.atomiccomponents.client.model.fluid.FluidTextureModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

public class ModelFluidAttributes extends FluidAttributes {
    public static final IFluidModelProvider MODEL_PROVIDER = DistExecutor.unsafeRunForDist(() -> () -> FluidTextureModel.LOADER, () -> () -> IFluidModelProvider.EMPTY);

    public static FluidAttributes.Builder builder() {
        return new Builder(ModelFluidAttributes::new);
    }

    private final Fluid fluid;

    protected ModelFluidAttributes(FluidAttributes.Builder builder, Fluid fluid) {
        super(builder, fluid);

        this.fluid = fluid;
    }

    @Override
    public ResourceLocation getStillTexture() {
        ResourceLocation texture = MODEL_PROVIDER.getStillTexture(this.fluid);

        if (texture == null)
            return super.getStillTexture();

        return texture;
    }

    @Override
    public ResourceLocation getFlowingTexture() {
        ResourceLocation texture = MODEL_PROVIDER.getFlowingTexture(this.fluid);

        if (texture == null)
            return super.getFlowingTexture();

        return texture;
    }

    @Nullable
    @Override
    public ResourceLocation getOverlayTexture() {
        return MODEL_PROVIDER.getOverlayTexture(this.fluid);
    }

    @Override
    public int getColor() {
        return MODEL_PROVIDER.getColor(this.fluid);
    }

    public static class Builder extends FluidAttributes.Builder {
        private static final ResourceLocation FALLBACK_STILL = new ResourceLocation("block/water_still");
        private static final ResourceLocation FALLBACK_FLOWING = new ResourceLocation("block/water_flow");

        protected Builder(BiFunction<FluidAttributes.Builder,Fluid,FluidAttributes> factory) {
            super(FALLBACK_STILL, FALLBACK_FLOWING, factory);
        }
    }

    public interface IFluidModelProvider {
        IFluidModelProvider EMPTY = new IFluidModelProvider() {};

        @Nullable
        default ResourceLocation getStillTexture(Fluid fluid) {
            return null;
        }

        @Nullable
        default ResourceLocation getFlowingTexture(Fluid fluid) {
            return null;
        }

        @Nullable
        default ResourceLocation getOverlayTexture(Fluid fluid) {
            return null;
        }

        default int getColor(Fluid fluid) {
            return -1;
        }
    }
}
