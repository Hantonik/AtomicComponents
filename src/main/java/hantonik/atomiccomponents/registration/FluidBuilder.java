package hantonik.atomiccomponents.registration;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.function.Supplier;

public class FluidBuilder {
    private Supplier<? extends Item> bucket;
    private Supplier<? extends LiquidBlock> block;

    private final FluidAttributes.Builder attributes;

    private boolean canMultiply = false;
    private float explosionResistance = 1.0F;

    private int slopeFindDistance = 4;
    private int levelDecreasePerBlock = 1;
    private int tickRate = 5;

    public FluidBuilder canMultiply() {
        this.canMultiply = true;

        return this;
    }

    public ForgeFlowingFluid.Properties build(Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing) {
        ForgeFlowingFluid.Properties properties = (new ForgeFlowingFluid.Properties(still, flowing, this.attributes)).slopeFindDistance(this.slopeFindDistance).levelDecreasePerBlock(this.levelDecreasePerBlock).explosionResistance(this.explosionResistance).tickRate(this.tickRate).block(this.block).bucket(this.bucket);

        if (this.canMultiply)
            properties.canMultiply();

        return properties;
    }

    public FluidBuilder canMultiply(boolean canMultiply) {
        this.canMultiply = canMultiply;

        return this;
    }

    public FluidBuilder bucket(Supplier<? extends Item> bucket) {
        this.bucket = bucket;

        return this;
    }

    public FluidBuilder block(Supplier<? extends LiquidBlock> block) {
        this.block = block;

        return this;
    }

    public FluidBuilder slopeFindDistance(int slopeFindDistance) {
        this.slopeFindDistance = slopeFindDistance;

        return this;
    }

    public FluidBuilder levelDecreasePerBlock(int levelDecreasePerBlock) {
        this.levelDecreasePerBlock = levelDecreasePerBlock;

        return this;
    }

    public FluidBuilder explosionResistance(float explosionResistance) {
        this.explosionResistance = explosionResistance;

        return this;
    }

    public FluidBuilder tickRate(int tickRate) {
        this.tickRate = tickRate;

        return this;
    }

    public FluidBuilder(FluidAttributes.Builder attributes) {
        this.attributes = attributes;
    }
}
