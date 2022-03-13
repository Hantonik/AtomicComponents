package hantonik.atomiccomponents.blocks;

import hantonik.atomiccore.block.BasicBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

import java.util.function.Function;

public class BasicOreBlock extends BasicBlock {
    public BasicOreBlock(Function<Properties, Properties> properties, boolean tool) {
        super(Material.STONE, p -> tool ? properties.apply(Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()) : properties.apply(Properties.of(Material.STONE).sound(SoundType.STONE)));
    }

    public BasicOreBlock(Function<Properties, Properties> properties) {
        this(p -> properties.apply(Properties.of(Material.STONE)), true);
    }
}