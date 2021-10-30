package hantonik.atomiccomponents.blocks;

import hantonik.atomiccore.block.BasicBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BasicOreBlock extends BasicBlock {
    public BasicOreBlock(Properties properties) {
        super(properties.requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).sound(SoundType.STONE));
    }

    public BasicOreBlock(int harvestLevel, float hardness, float resistance) {
        super(Material.STONE, SoundType.STONE, ToolType.PICKAXE, harvestLevel, hardness, resistance);
    }
}