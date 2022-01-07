package hantonik.atomiccomponents.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public final class AtomicTags {
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> RAW_ORES = forgeCategory("raw_ores");

        public static final Tag.Named<Block> RAW_ORES_LEAD = forgeTag("raw_ores/lead");
        public static final Tag.Named<Block> RAW_ORES_TITANIUM = forgeTag("raw_ores/titanium");
        public static final Tag.Named<Block> RAW_ORES_TIN = forgeTag("raw_ores/tin");
        public static final Tag.Named<Block> RAW_ORES_SILVER = forgeTag("raw_ores/silver");

        public static final Tag.Named<Block> ORES_LEAD = forgeTag("ores/lead");
        public static final Tag.Named<Block> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final Tag.Named<Block> ORES_TIN = forgeTag("ores/tin");
        public static final Tag.Named<Block> ORES_SILVER = forgeTag("ores/silver");

        public static final Tag.Named<Block> STORAGE_BLOCKS_COKE = forgeTag("storage_blocks/coke");
        public static final Tag.Named<Block> STORAGE_BLOCKS_GRAPHITE = forgeTag("storage_blocks/graphite");

        public static final Tag.Named<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final Tag.Named<Block> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final Tag.Named<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final Tag.Named<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final Tag.Named<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final Tag.Named<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static Tag.Named<Block> tag(String modID, String name) {
            return BlockTags.bind(new ResourceLocation(modID, name).toString());
        }

        static Tag.Named<Block> forgeTag(String  name) {
            return tag("forge", name);
        }

        static Tags.IOptionalNamedTag<Block> category(String modID, String name) {
            return BlockTags.createOptional(new ResourceLocation(modID, name));
        }

        static Tags.IOptionalNamedTag<Block> forgeCategory(String name) {
            return category("forge", name);
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> PLATES = forgeCategory("plates");
        public static final Tags.IOptionalNamedTag<Item> RAW_ORES = forgeCategory("raw_ores");
        public static final Tags.IOptionalNamedTag<Item> COALS = forgeCategory("coals");
        public static final Tags.IOptionalNamedTag<Item> RAW = forgeCategory("raw");
        public static final Tags.IOptionalNamedTag<Item> GEARS = forgeCategory("gears");
        public static final Tags.IOptionalNamedTag<Item> BLENDS = forgeCategory("blends");

        public static final Tag.Named<Item> COALS_COKE = forgeTag("coals/coke");

        public static final Tag.Named<Item> INGOTS_GRAPHITE = forgeTag("ingots/graphite");

        public static final Tag.Named<Item> INGOTS_LEAD = forgeTag("ingots/lead");
        public static final Tag.Named<Item> INGOTS_TITANIUM = forgeTag("ingots/titanium");
        public static final Tag.Named<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final Tag.Named<Item> INGOTS_SILVER = forgeTag("ingots/silver");

        public static final Tag.Named<Item> INGOTS_STEEL = forgeTag("ingots/steel");
        public static final Tag.Named<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");

        public static final Tag.Named<Item> RAW_LEAD = forgeTag("raw/lead");
        public static final Tag.Named<Item> RAW_TITANIUM = forgeTag("raw/titanium");
        public static final Tag.Named<Item> RAW_TIN = forgeTag("raw/tin");
        public static final Tag.Named<Item> RAW_SILVER = forgeTag("raw/silver");

        public static final Tag.Named<Item> DUSTS_COKE = forgeTag("dusts/coke");
        public static final Tag.Named<Item> DUSTS_CARBON = forgeTag("dusts/carbon");
        public static final Tag.Named<Item> DUSTS_GRAPHITE = forgeTag("dusts/graphite");

        public static final Tag.Named<Item> DUSTS_IRON = forgeTag("dusts/iron");
        public static final Tag.Named<Item> DUSTS_GOLD = forgeTag("dusts/gold");

        public static final Tag.Named<Item> DUSTS_COPPER = forgeTag("dusts/copper");
        public static final Tag.Named<Item> DUSTS_LEAD = forgeTag("dusts/lead");
        public static final Tag.Named<Item> DUSTS_TITANIUM = forgeTag("dusts/titanium");
        public static final Tag.Named<Item> DUSTS_TIN = forgeTag("dusts/tin");
        public static final Tag.Named<Item> DUSTS_SILVER = forgeTag("dusts/silver");

        public static final Tag.Named<Item> DUSTS_STEEL = forgeTag("dusts/steel");
        public static final Tag.Named<Item> DUSTS_BRONZE = forgeTag("dusts/bronze");

        public static final Tag.Named<Item> BLENDS_STEEL = forgeTag("blends/steel");
        public static final Tag.Named<Item> BLENDS_BRONZE = forgeTag("blends/bronze");

        public static final Tag.Named<Item> PLATES_IRON = forgeTag("plates/iron");
        public static final Tag.Named<Item> PLATES_GOLD = forgeTag("plates/gold");

        public static final Tag.Named<Item> PLATES_COPPER = forgeTag("plates/copper");
        public static final Tag.Named<Item> PLATES_LEAD = forgeTag("plates/lead");
        public static final Tag.Named<Item> PLATES_TITANIUM = forgeTag("plates/titanium");
        public static final Tag.Named<Item> PLATES_TIN = forgeTag("plates/tin");
        public static final Tag.Named<Item> PLATES_SILVER = forgeTag("plates/silver");

        public static final Tag.Named<Item> PLATES_STEEL = forgeTag("plates/steel");
        public static final Tag.Named<Item> PLATES_BRONZE = forgeTag("plates/bronze");

        public static final Tag.Named<Item> RODS_GRAPHITE = forgeTag("rods/graphite");

        public static final Tag.Named<Item> RODS_IRON = forgeTag("rods/iron");
        public static final Tag.Named<Item> RODS_GOLD = forgeTag("rods/gold");

        public static final Tag.Named<Item> RODS_COPPER = forgeTag("rods/copper");
        public static final Tag.Named<Item> RODS_LEAD = forgeTag("rods/lead");
        public static final Tag.Named<Item> RODS_TITANIUM = forgeTag("rods/titanium");
        public static final Tag.Named<Item> RODS_TIN = forgeTag("rods/tin");
        public static final Tag.Named<Item> RODS_SILVER = forgeTag("rods/silver");

        public static final Tag.Named<Item> RODS_STEEL = forgeTag("rods/steel");
        public static final Tag.Named<Item> RODS_BRONZE = forgeTag("rods/bronze");

        public static final Tag.Named<Item> GEARS_IRON = forgeTag("gears/iron");
        public static final Tag.Named<Item> GEARS_GOLD = forgeTag("gears/gold");

        public static final Tag.Named<Item> GEARS_COPPER = forgeTag("gears/copper");
        public static final Tag.Named<Item> GEARS_LEAD = forgeTag("gears/lead");
        public static final Tag.Named<Item> GEARS_TITANIUM = forgeTag("gears/titanium");
        public static final Tag.Named<Item> GEARS_TIN = forgeTag("gears/tin");
        public static final Tag.Named<Item> GEARS_SILVER = forgeTag("gears/silver");

        public static final Tag.Named<Item> GEARS_STEEL = forgeTag("gears/steel");
        public static final Tag.Named<Item> GEARS_BRONZE = forgeTag("gears/bronze");

        public static final Tag.Named<Item> RAW_ORES_LEAD = forgeTag("raw_ores/lead");
        public static final Tag.Named<Item> RAW_ORES_TITANIUM = forgeTag("raw_ores/titanium");
        public static final Tag.Named<Item> RAW_ORES_TIN = forgeTag("raw_ores/tin");
        public static final Tag.Named<Item> RAW_ORES_SILVER = forgeTag("raw_ores/silver");

        public static final Tag.Named<Item> ORES_LEAD = forgeTag("ores/lead");
        public static final Tag.Named<Item> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final Tag.Named<Item> ORES_TIN = forgeTag("ores/tin");
        public static final Tag.Named<Item> ORES_SILVER = forgeTag("ores/silver");

        public static final Tag.Named<Item> STORAGE_BLOCKS_COKE = forgeTag("storage_blocks/coke");
        public static final Tag.Named<Item> STORAGE_BLOCKS_GRAPHITE = forgeTag("storage_blocks/graphite");

        public static final Tag.Named<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final Tag.Named<Item> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final Tag.Named<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final Tag.Named<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final Tag.Named<Item> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final Tag.Named<Item> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static Tag.Named<Item> tag(String modID, String name) {
            return ItemTags.bind(new ResourceLocation(modID, name).toString());
        }

        static Tag.Named<Item> forgeTag(String name) {
            return tag("forge", name);
        }

        static Tags.IOptionalNamedTag<Item> category(String modID, String name) {
            return ItemTags.createOptional(new ResourceLocation(modID, name));
        }

        static Tags.IOptionalNamedTag<Item> forgeCategory(String name) {
            return category("forge", name);
        }
    }
}
