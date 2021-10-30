package hantonik.atomiccomponents.datagen;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class AtomicBlockTagsProvider extends BlockTagsProvider {
    public AtomicBlockTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), AtomicComponents.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_COPPER, AtomicBlocks.COPPER_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_LEAD, AtomicBlocks.LEAD_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_TITANIUM, AtomicBlocks.TITANIUM_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_TIN, AtomicBlocks.TIN_ORE);
        createAndAppend(Tags.Blocks.ORES, AtomicTags.Blocks.ORES_SILVER, AtomicBlocks.SILVER_ORE);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_COPPER, AtomicBlocks.COPPER_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_LEAD, AtomicBlocks.LEAD_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_TITANIUM, AtomicBlocks.TITANIUM_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_TIN, AtomicBlocks.TIN_BLOCK);
        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_SILVER, AtomicBlocks.SILVER_BLOCK);

        createAndAppend(Tags.Blocks.STORAGE_BLOCKS, AtomicTags.Blocks.STORAGE_BLOCKS_STEEL, AtomicBlocks.STEEL_BLOCK);
    }

    @SafeVarargs
    private final <T> T[] resolveAll(IntFunction<T[]> creator, Supplier<? extends T>... suppliers) {
        return Arrays.stream(suppliers).map(Supplier::get).toArray(creator);
    }

    @SafeVarargs
    private final void createTag(ITag.INamedTag<Block> tag, Supplier<? extends Block>... blocks) {
        tag(tag).add(resolveAll(Block[]::new, blocks));
    }

    @SafeVarargs
    private final void appendToTag(ITag.INamedTag<Block> tag, ITag.INamedTag<Block>... toAppend) {
        tag(tag).addTags(toAppend);
    }

    @SafeVarargs
    private final void createAndAppend(ITag.INamedTag<Block> to, ITag.INamedTag<Block> tag, Supplier<? extends Block>... blocks) {
        createTag(tag, blocks);
        appendToTag(to, tag);
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " Block Tags";
    }
}
