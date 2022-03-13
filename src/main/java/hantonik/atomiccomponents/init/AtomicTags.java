package hantonik.atomiccomponents.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class AtomicTags {
    public static class Blocks {
        public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");
        public static final TagKey<Block> ORES_ALUMINUM = forgeTag("ores/aluminum");
        public static final TagKey<Block> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final TagKey<Block> ORES_TIN = forgeTag("ores/tin");
        public static final TagKey<Block> ORES_SILVER = forgeTag("ores/silver");

        public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_ALUMINUM = forgeTag("storage_blocks/raw_aluminum");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TITANIUM = forgeTag("storage_blocks/raw_titanium");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = forgeTag("storage_blocks/raw_tin");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Block> STORAGE_BLOCKS_COKE = forgeTag("storage_blocks/coke");
        public static final TagKey<Block> STORAGE_BLOCKS_GRAPHITE = forgeTag("storage_blocks/graphite");

        public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Block> STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/aluminum");
        public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final TagKey<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final TagKey<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final TagKey<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static TagKey<Block> tag(String modID, String name) {
            return BlockTags.create(new ResourceLocation(modID, name));
        }

        static TagKey<Block> forgeTag(String  name) {
            return tag("forge", name);
        }

        static TagKey<Block> category(String modID, String name) {
            return BlockTags.create(new ResourceLocation(modID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PLATES = forgeCategory("plates");
        public static final TagKey<Item> COALS = forgeCategory("coals");
        public static final TagKey<Item> GEARS = forgeCategory("gears");
        public static final TagKey<Item> BLENDS = forgeCategory("blends");

        public static final TagKey<Item> SILICON = forgeTag("silicon");

        public static final TagKey<Item> COALS_COKE = forgeTag("coals/coke");

        public static final TagKey<Item> INGOTS_GRAPHITE = forgeTag("ingots/graphite");

        public static final TagKey<Item> INGOTS_LEAD = forgeTag("ingots/lead");
        public static final TagKey<Item> INGOTS_ALUMINUM = forgeTag("ingots/aluminum");
        public static final TagKey<Item> INGOTS_TITANIUM = forgeTag("ingots/titanium");
        public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");

        public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");
        public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");

        public static final TagKey<Item> DUSTS_COKE = forgeTag("dusts/coke");
        public static final TagKey<Item> DUSTS_CARBON = forgeTag("dusts/carbon");
        public static final TagKey<Item> DUSTS_GRAPHITE = forgeTag("dusts/graphite");

        public static final TagKey<Item> DUSTS_IRON = forgeTag("dusts/iron");
        public static final TagKey<Item> DUSTS_GOLD = forgeTag("dusts/gold");

        public static final TagKey<Item> DUSTS_COPPER = forgeTag("dusts/copper");
        public static final TagKey<Item> DUSTS_LEAD = forgeTag("dusts/lead");
        public static final TagKey<Item> DUSTS_ALUMINUM = forgeTag("dusts/aluminum");
        public static final TagKey<Item> DUSTS_TITANIUM = forgeTag("dusts/titanium");
        public static final TagKey<Item> DUSTS_TIN = forgeTag("dusts/tin");
        public static final TagKey<Item> DUSTS_SILVER = forgeTag("dusts/silver");

        public static final TagKey<Item> DUSTS_SILICON = forgeTag("dusts/silicon");

        public static final TagKey<Item> DUSTS_STEEL = forgeTag("dusts/steel");
        public static final TagKey<Item> DUSTS_BRONZE = forgeTag("dusts/bronze");

        public static final TagKey<Item> BLENDS_STEEL = forgeTag("blends/steel");
        public static final TagKey<Item> BLENDS_BRONZE = forgeTag("blends/bronze");

        public static final TagKey<Item> PLATES_IRON = forgeTag("plates/iron");
        public static final TagKey<Item> PLATES_GOLD = forgeTag("plates/gold");

        public static final TagKey<Item> PLATES_COPPER = forgeTag("plates/copper");
        public static final TagKey<Item> PLATES_LEAD = forgeTag("plates/lead");
        public static final TagKey<Item> PLATES_ALUMINUM = forgeTag("plates/aluminum");
        public static final TagKey<Item> PLATES_TITANIUM = forgeTag("plates/titanium");
        public static final TagKey<Item> PLATES_TIN = forgeTag("plates/tin");
        public static final TagKey<Item> PLATES_SILVER = forgeTag("plates/silver");

        public static final TagKey<Item> PLATES_STEEL = forgeTag("plates/steel");
        public static final TagKey<Item> PLATES_BRONZE = forgeTag("plates/bronze");

        public static final TagKey<Item> RODS_GRAPHITE = forgeTag("rods/graphite");

        public static final TagKey<Item> RODS_IRON = forgeTag("rods/iron");
        public static final TagKey<Item> RODS_GOLD = forgeTag("rods/gold");

        public static final TagKey<Item> RODS_COPPER = forgeTag("rods/copper");
        public static final TagKey<Item> RODS_LEAD = forgeTag("rods/lead");
        public static final TagKey<Item> RODS_ALUMINUM = forgeTag("rods/aluminum");
        public static final TagKey<Item> RODS_TITANIUM = forgeTag("rods/titanium");
        public static final TagKey<Item> RODS_TIN = forgeTag("rods/tin");
        public static final TagKey<Item> RODS_SILVER = forgeTag("rods/silver");

        public static final TagKey<Item> RODS_STEEL = forgeTag("rods/steel");
        public static final TagKey<Item> RODS_BRONZE = forgeTag("rods/bronze");

        public static final TagKey<Item> GEARS_IRON = forgeTag("gears/iron");
        public static final TagKey<Item> GEARS_GOLD = forgeTag("gears/gold");

        public static final TagKey<Item> GEARS_COPPER = forgeTag("gears/copper");
        public static final TagKey<Item> GEARS_LEAD = forgeTag("gears/lead");
        public static final TagKey<Item> GEARS_ALUMINUM = forgeTag("gears/aluminum");
        public static final TagKey<Item> GEARS_TITANIUM = forgeTag("gears/titanium");
        public static final TagKey<Item> GEARS_TIN = forgeTag("gears/tin");
        public static final TagKey<Item> GEARS_SILVER = forgeTag("gears/silver");

        public static final TagKey<Item> GEARS_STEEL = forgeTag("gears/steel");
        public static final TagKey<Item> GEARS_BRONZE = forgeTag("gears/bronze");

        public static final TagKey<Item> RAW_MATERIALS_LEAD = forgeTag("raw_materials/lead");
        public static final TagKey<Item> RAW_MATERIALS_ALUMINUM = forgeTag("raw_materials/aluminum");
        public static final TagKey<Item> RAW_MATERIALS_TITANIUM = forgeTag("raw_materials/titanium");
        public static final TagKey<Item> RAW_MATERIALS_TIN = forgeTag("raw_materials/tin");
        public static final TagKey<Item> RAW_MATERIALS_SILVER = forgeTag("raw_materials/silver");

        public static final TagKey<Item> ORES_LEAD = forgeTag("ores/lead");
        public static final TagKey<Item> ORES_ALUMINUM = forgeTag("ores/aluminum");
        public static final TagKey<Item> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final TagKey<Item> ORES_TIN = forgeTag("ores/tin");
        public static final TagKey<Item> ORES_SILVER = forgeTag("ores/silver");

        public static final TagKey<Item> STORAGE_BLOCKS_COKE = forgeTag("storage_blocks/coke");
        public static final TagKey<Item> STORAGE_BLOCKS_GRAPHITE = forgeTag("storage_blocks/graphite");

        public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = forgeTag("storage_blocks/raw_lead");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_ALUMINUM = forgeTag("storage_blocks/raw_aluminum");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_TITANIUM = forgeTag("storage_blocks/raw_titanium");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = forgeTag("storage_blocks/raw_tin");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SILVER = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final TagKey<Item> STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/aluminum");
        public static final TagKey<Item> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final TagKey<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final TagKey<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final TagKey<Item> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final TagKey<Item> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static TagKey<Item> tag(String modID, String name) {
            return ItemTags.create(new ResourceLocation(modID, name));
        }

        static TagKey<Item> forgeTag(String name) {
            return tag("forge", name);
        }

        static TagKey<Item> category(String modID, String name) {
            return ItemTags.create(new ResourceLocation(modID, name));
        }

        static TagKey<Item> forgeCategory(String name) {
            return category("forge", name);
        }
    }
}
