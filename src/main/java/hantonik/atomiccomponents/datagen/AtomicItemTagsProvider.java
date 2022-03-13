package hantonik.atomiccomponents.datagen;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicItems;
import hantonik.atomiccomponents.init.AtomicTags;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.util.Arrays;
import java.util.function.Supplier;

public class AtomicItemTagsProvider extends ItemTagsProvider {
    public AtomicItemTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), new AtomicBlockTagsProvider(event), AtomicComponents.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        copy(AtomicTags.Blocks.ORES_ALUMINUM, AtomicTags.Items.ORES_ALUMINUM);
        copy(AtomicTags.Blocks.ORES_LEAD, AtomicTags.Items.ORES_LEAD);
        copy(AtomicTags.Blocks.ORES_TITANIUM, AtomicTags.Items.ORES_TITANIUM);
        copy(AtomicTags.Blocks.ORES_TIN, AtomicTags.Items.ORES_TIN);
        copy(AtomicTags.Blocks.ORES_SILVER, AtomicTags.Items.ORES_SILVER);

        copy(AtomicTags.Blocks.STORAGE_BLOCKS_COKE, AtomicTags.Items.STORAGE_BLOCKS_COKE);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_GRAPHITE, AtomicTags.Items.STORAGE_BLOCKS_GRAPHITE);

        copy(AtomicTags.Blocks.STORAGE_BLOCKS_RAW_ALUMINUM, AtomicTags.Items.STORAGE_BLOCKS_RAW_ALUMINUM);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_RAW_LEAD, AtomicTags.Items.STORAGE_BLOCKS_RAW_LEAD);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_RAW_TITANIUM, AtomicTags.Items.STORAGE_BLOCKS_RAW_TITANIUM);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_RAW_TIN, AtomicTags.Items.STORAGE_BLOCKS_RAW_TIN);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_RAW_SILVER, AtomicTags.Items.STORAGE_BLOCKS_RAW_SILVER);

        copy(AtomicTags.Blocks.STORAGE_BLOCKS_ALUMINUM, AtomicTags.Items.STORAGE_BLOCKS_ALUMINUM);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_LEAD, AtomicTags.Items.STORAGE_BLOCKS_LEAD);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_TITANIUM, AtomicTags.Items.STORAGE_BLOCKS_TITANIUM);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_TIN, AtomicTags.Items.STORAGE_BLOCKS_TIN);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_SILVER, AtomicTags.Items.STORAGE_BLOCKS_SILVER);

        copy(AtomicTags.Blocks.STORAGE_BLOCKS_STEEL, AtomicTags.Items.STORAGE_BLOCKS_STEEL);
        copy(AtomicTags.Blocks.STORAGE_BLOCKS_BRONZE, AtomicTags.Items.STORAGE_BLOCKS_BRONZE);

        addItemsToTag(AtomicTags.Items.SILICON, AtomicItems.SILICON);

        addItemsToTag(AtomicTags.Items.COALS_COKE, AtomicItems.COKE);

        addItemsToTag(AtomicTags.Items.DUSTS_SILICON, AtomicItems.SILICON_DUST);

        addItemsToTag(AtomicTags.Items.DUSTS_COKE, AtomicItems.COKE_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_CARBON, AtomicItems.CARBON_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_GRAPHITE, AtomicItems.GRAPHITE_DUST);

        addItemsToTag(AtomicTags.Items.DUSTS_IRON, AtomicItems.IRON_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_GOLD, AtomicItems.GOLD_DUST);

        addItemsToTag(AtomicTags.Items.DUSTS_COPPER, AtomicItems.COPPER_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_ALUMINUM, AtomicItems.ALUMINUM_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_LEAD, AtomicItems.LEAD_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_TITANIUM, AtomicItems.TITANIUM_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_TIN, AtomicItems.TIN_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_SILVER, AtomicItems.SILVER_DUST);

        addItemsToTag(AtomicTags.Items.DUSTS_STEEL, AtomicItems.STEEL_DUST);
        addItemsToTag(AtomicTags.Items.DUSTS_BRONZE, AtomicItems.BRONZE_DUST);

        addItemsToTag(AtomicTags.Items.RAW_MATERIALS_ALUMINUM, AtomicItems.RAW_ALUMINUM);
        addItemsToTag(AtomicTags.Items.RAW_MATERIALS_LEAD, AtomicItems.RAW_LEAD);
        addItemsToTag(AtomicTags.Items.RAW_MATERIALS_TITANIUM, AtomicItems.RAW_TITANIUM);
        addItemsToTag(AtomicTags.Items.RAW_MATERIALS_TIN, AtomicItems.RAW_TIN);
        addItemsToTag(AtomicTags.Items.RAW_MATERIALS_SILVER, AtomicItems.RAW_SILVER);

        addItemsToTag(AtomicTags.Items.BLENDS_STEEL, AtomicItems.STEEL_BLEND);
        addItemsToTag(AtomicTags.Items.BLENDS_BRONZE, AtomicItems.BRONZE_BLEND);

        addItemsToTag(AtomicTags.Items.PLATES_IRON, AtomicItems.IRON_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_GOLD, AtomicItems.GOLD_PLATE);

        addItemsToTag(AtomicTags.Items.PLATES_COPPER, AtomicItems.COPPER_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_ALUMINUM, AtomicItems.ALUMINUM_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_LEAD, AtomicItems.LEAD_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_TITANIUM, AtomicItems.TITANIUM_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_TIN, AtomicItems.TIN_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_SILVER, AtomicItems.SILVER_PLATE);

        addItemsToTag(AtomicTags.Items.PLATES_STEEL, AtomicItems.STEEL_PLATE);
        addItemsToTag(AtomicTags.Items.PLATES_BRONZE, AtomicItems.BRONZE_PLATE);

        addItemsToTag(AtomicTags.Items.RODS_GRAPHITE, AtomicItems.GRAPHITE_ROD);

        addItemsToTag(AtomicTags.Items.RODS_IRON, AtomicItems.IRON_ROD);
        addItemsToTag(AtomicTags.Items.RODS_GOLD, AtomicItems.GOLD_ROD);

        addItemsToTag(AtomicTags.Items.RODS_COPPER, AtomicItems.COPPER_ROD);
        addItemsToTag(AtomicTags.Items.RODS_ALUMINUM, AtomicItems.ALUMINUM_ROD);
        addItemsToTag(AtomicTags.Items.RODS_LEAD, AtomicItems.LEAD_ROD);
        addItemsToTag(AtomicTags.Items.RODS_TITANIUM, AtomicItems.TITANIUM_ROD);
        addItemsToTag(AtomicTags.Items.RODS_TIN, AtomicItems.TIN_ROD);
        addItemsToTag(AtomicTags.Items.RODS_SILVER, AtomicItems.SILVER_ROD);

        addItemsToTag(AtomicTags.Items.RODS_STEEL, AtomicItems.STEEL_ROD);
        addItemsToTag(AtomicTags.Items.RODS_BRONZE, AtomicItems.BRONZE_ROD);

        addItemsToTag(AtomicTags.Items.GEARS_IRON, AtomicItems.IRON_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_GOLD, AtomicItems.GOLD_GEAR);

        addItemsToTag(AtomicTags.Items.GEARS_COPPER, AtomicItems.COPPER_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_ALUMINUM, AtomicItems.ALUMINUM_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_LEAD, AtomicItems.LEAD_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_TITANIUM, AtomicItems.TITANIUM_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_TIN, AtomicItems.TIN_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_SILVER, AtomicItems.SILVER_GEAR);

        addItemsToTag(AtomicTags.Items.GEARS_STEEL, AtomicItems.STEEL_GEAR);
        addItemsToTag(AtomicTags.Items.GEARS_BRONZE, AtomicItems.BRONZE_GEAR);

        addItemsToTag(AtomicTags.Items.INGOTS_GRAPHITE, AtomicItems.GRAPHITE_INGOT);

        addItemsToTag(AtomicTags.Items.INGOTS_ALUMINUM, AtomicItems.ALUMINUM_INGOT);
        addItemsToTag(AtomicTags.Items.INGOTS_LEAD, AtomicItems.LEAD_INGOT);
        addItemsToTag(AtomicTags.Items.INGOTS_TITANIUM, AtomicItems.TITANIUM_INGOT);
        addItemsToTag(AtomicTags.Items.INGOTS_TIN, AtomicItems.TIN_INGOT);
        addItemsToTag(AtomicTags.Items.INGOTS_SILVER, AtomicItems.SILVER_INGOT);

        addItemsToTag(AtomicTags.Items.INGOTS_STEEL, AtomicItems.STEEL_INGOT);
        addItemsToTag(AtomicTags.Items.INGOTS_BRONZE, AtomicItems.BRONZE_INGOT);

        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_COKE, AtomicBlocks.COKE_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_GRAPHITE, AtomicBlocks.GRAPHITE_BLOCK);

        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_RAW_ALUMINUM, AtomicBlocks.RAW_ALUMINUM_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_RAW_LEAD, AtomicBlocks.RAW_LEAD_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_RAW_TITANIUM, AtomicBlocks.RAW_TITANIUM_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_RAW_TIN, AtomicBlocks.RAW_TIN_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_RAW_SILVER, AtomicBlocks.RAW_SILVER_BLOCK);

        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_ALUMINUM, AtomicBlocks.ALUMINUM_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_LEAD, AtomicBlocks.LEAD_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_TITANIUM, AtomicBlocks.TITANIUM_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_TIN, AtomicBlocks.TIN_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_SILVER, AtomicBlocks.SILVER_BLOCK);

        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_STEEL, AtomicBlocks.STEEL_BLOCK);
        addItemsToTag(AtomicTags.Items.STORAGE_BLOCKS_BRONZE, AtomicBlocks.BRONZE_BLOCK);

        addItemsToTag(AtomicTags.Items.ORES_ALUMINUM, AtomicBlocks.ALUMINUM_ORE, AtomicBlocks.DEEPSLATE_ALUMINUM_ORE);
        addItemsToTag(AtomicTags.Items.ORES_LEAD, AtomicBlocks.LEAD_ORE, AtomicBlocks.DEEPSLATE_LEAD_ORE);
        addItemsToTag(AtomicTags.Items.ORES_TITANIUM, AtomicBlocks.TITANIUM_ORE, AtomicBlocks.DEEPSLATE_TITANIUM_ORE);
        addItemsToTag(AtomicTags.Items.ORES_TIN, AtomicBlocks.TIN_ORE, AtomicBlocks.DEEPSLATE_TIN_ORE);
        addItemsToTag(AtomicTags.Items.ORES_SILVER, AtomicBlocks.SILVER_ORE, AtomicBlocks.DEEPSLATE_SILVER_ORE);

        appendToTag(AtomicTags.Items.BLENDS, AtomicTags.Items.BLENDS_STEEL);
        appendToTag(AtomicTags.Items.BLENDS, AtomicTags.Items.BLENDS_BRONZE);

        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_IRON);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_GOLD);

        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_COPPER);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_ALUMINUM);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_LEAD);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_TITANIUM);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_TIN);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_SILVER);

        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_STEEL);
        appendToTag(AtomicTags.Items.PLATES, AtomicTags.Items.PLATES_BRONZE);

        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_IRON);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_GOLD);

        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_COPPER);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_ALUMINUM);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_LEAD);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_TITANIUM);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_TIN);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_SILVER);

        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_STEEL);
        appendToTag(AtomicTags.Items.GEARS, AtomicTags.Items.GEARS_BRONZE);

        appendToTag(AtomicTags.Items.COALS, AtomicTags.Items.COALS_COKE);
        appendToTag(ItemTags.COALS, AtomicTags.Items.COALS_COKE);

        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_SILICON);

        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_COKE);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_CARBON);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_GRAPHITE);

        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_IRON);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_GOLD);

        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_COPPER);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_ALUMINUM);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_LEAD);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_TITANIUM);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_TIN);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_SILVER);

        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_STEEL);
        appendToTag(Tags.Items.DUSTS, AtomicTags.Items.DUSTS_BRONZE);

        appendToTag(Tags.Items.RAW_MATERIALS, AtomicTags.Items.RAW_MATERIALS_ALUMINUM);
        appendToTag(Tags.Items.RAW_MATERIALS, AtomicTags.Items.RAW_MATERIALS_LEAD);
        appendToTag(Tags.Items.RAW_MATERIALS, AtomicTags.Items.RAW_MATERIALS_TITANIUM);
        appendToTag(Tags.Items.RAW_MATERIALS, AtomicTags.Items.RAW_MATERIALS_TIN);
        appendToTag(Tags.Items.RAW_MATERIALS, AtomicTags.Items.RAW_MATERIALS_SILVER);

        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_GRAPHITE);

        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_IRON);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_GOLD);

        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_COPPER);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_ALUMINUM);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_LEAD);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_TITANIUM);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_TIN);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_SILVER);

        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_STEEL);
        appendToTag(Tags.Items.RODS, AtomicTags.Items.RODS_BRONZE);

        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_GRAPHITE);

        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_ALUMINUM);
        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_LEAD);
        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_TITANIUM);
        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_TIN);
        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_SILVER);

        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_STEEL);
        appendToTag(Tags.Items.INGOTS, AtomicTags.Items.INGOTS_BRONZE);

        appendToTag(Tags.Items.ORES, AtomicTags.Items.ORES_ALUMINUM);
        appendToTag(Tags.Items.ORES, AtomicTags.Items.ORES_LEAD);
        appendToTag(Tags.Items.ORES, AtomicTags.Items.ORES_TIN);
        appendToTag(Tags.Items.ORES, AtomicTags.Items.ORES_TITANIUM);
        appendToTag(Tags.Items.ORES, AtomicTags.Items.ORES_SILVER);

        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_COKE);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_GRAPHITE);

        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_ALUMINUM);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_LEAD);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_TIN);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_TITANIUM);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_SILVER);

        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_STEEL);
        appendToTag(Tags.Items.STORAGE_BLOCKS, AtomicTags.Items.STORAGE_BLOCKS_BRONZE);
    }

    @SafeVarargs
    private void addItemsToTag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        tag(tag).add(Arrays.stream(items).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }

    @SafeVarargs
    private void appendToTag(TagKey<Item> tag, TagKey<Item>... toAppend) {
        tag(tag).addTags(toAppend);
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " Item Tags";
    }
}
