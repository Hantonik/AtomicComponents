package hantonik.atomiccomponents.datagen;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicTags;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class AtomicBlockTagsProvider extends BlockTagsProvider {
    public AtomicBlockTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), AtomicComponents.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        createTag(Tags.Blocks.ORES_IN_GROUND_STONE, AtomicBlocks.ALUMINUM_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_STONE, AtomicBlocks.LEAD_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_STONE, AtomicBlocks.TITANIUM_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_STONE, AtomicBlocks.TIN_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_STONE, AtomicBlocks.SILVER_ORE);

        createTag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, AtomicBlocks.DEEPSLATE_ALUMINUM_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, AtomicBlocks.DEEPSLATE_LEAD_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, AtomicBlocks.DEEPSLATE_TITANIUM_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, AtomicBlocks.DEEPSLATE_TIN_ORE);
        createTag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, AtomicBlocks.DEEPSLATE_SILVER_ORE);

        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_ALUMINUM, AtomicBlocks.ALUMINUM_ORE, AtomicBlocks.DEEPSLATE_ALUMINUM_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_LEAD, AtomicBlocks.LEAD_ORE, AtomicBlocks.DEEPSLATE_LEAD_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_TITANIUM, AtomicBlocks.TITANIUM_ORE, AtomicBlocks.DEEPSLATE_TITANIUM_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_TIN, AtomicBlocks.TIN_ORE, AtomicBlocks.DEEPSLATE_TIN_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_SILVER, AtomicBlocks.SILVER_ORE, AtomicBlocks.DEEPSLATE_SILVER_ORE);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_COKE, AtomicBlocks.COKE_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_GRAPHITE, AtomicBlocks.GRAPHITE_BLOCK);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, AtomicBlocks.RAW_ALUMINUM_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_RAW_LEAD, AtomicBlocks.RAW_LEAD_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM, AtomicBlocks.RAW_TITANIUM_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_RAW_TIN, AtomicBlocks.RAW_TIN_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, AtomicBlocks.RAW_SILVER_BLOCK);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_ALUMINUM, AtomicBlocks.ALUMINUM_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_LEAD, AtomicBlocks.LEAD_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_TITANIUM, AtomicBlocks.TITANIUM_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_TIN, AtomicBlocks.TIN_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_SILVER, AtomicBlocks.SILVER_BLOCK);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_STEEL, AtomicBlocks.STEEL_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_BRONZE, AtomicBlocks.BRONZE_BLOCK);

        this.addHarvest();
    }

    private void addHarvest() {
        // PICKAXE
        appendToTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_DIAMOND_TOOL, AtomicBlocks.TITANIUM_BLOCK, AtomicBlocks.TITANIUM_ORE, AtomicBlocks.DEEPSLATE_TITANIUM_ORE, AtomicBlocks.RAW_TITANIUM_BLOCK, AtomicBlocks.STEEL_BLOCK);
        appendToTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, AtomicBlocks.GRAPHITE_BLOCK, AtomicBlocks.LEAD_BLOCK, AtomicBlocks.LEAD_ORE, AtomicBlocks.DEEPSLATE_LEAD_ORE, AtomicBlocks.RAW_LEAD_BLOCK, AtomicBlocks.SILVER_BLOCK, AtomicBlocks.SILVER_ORE, AtomicBlocks.DEEPSLATE_SILVER_ORE, AtomicBlocks.RAW_SILVER_BLOCK, AtomicBlocks.ALUMINUM_BLOCK, AtomicBlocks.ALUMINUM_ORE, AtomicBlocks.DEEPSLATE_ALUMINUM_ORE, AtomicBlocks.RAW_ALUMINUM_BLOCK, AtomicBlocks.BRONZE_BLOCK);
        appendToTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL, AtomicBlocks.TIN_BLOCK, AtomicBlocks.TIN_ORE, AtomicBlocks.DEEPSLATE_TIN_ORE, AtomicBlocks.RAW_TIN_BLOCK, AtomicBlocks.COKE_BLOCK);
    }

    @SafeVarargs
    private <T> T[] resolveAll(IntFunction<T[]> creator, Supplier<? extends T>... suppliers) {
        return Arrays.stream(suppliers).map(Supplier::get).toArray(creator);
    }

    @SafeVarargs
    private void createTag(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        tag(tag).add(resolveAll(Block[]::new, blocks));
    }

    @SafeVarargs
    private void appendToTag(TagKey<Block> tag, TagKey<Block>... toAppend) {
        tag(tag).addTags(toAppend);
    }

    @SafeVarargs
    private void appendToTags(TagKey<Block> tag1, TagKey<Block> tag2, Supplier<? extends Block>... blocks) {
        tag(tag1).add(resolveAll(Block[]::new, blocks));
        tag(tag2).add(resolveAll(Block[]::new, blocks));
    }

    @SafeVarargs
    private void createAndAppend(TagKey<Block> to, TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        createTag(tag, blocks);
        appendToTag(to, tag);
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " Block Tags";
    }
}
