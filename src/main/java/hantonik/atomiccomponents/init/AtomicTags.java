package hantonik.atomiccomponents.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public final class AtomicTags {
    public static class Blocks {
        public static final ITag.INamedTag<Block> ORES_COPPER = forgeTag("ores/copper");
        public static final ITag.INamedTag<Block> ORES_LEAD = forgeTag("ores/lead");
        public static final ITag.INamedTag<Block> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final ITag.INamedTag<Block> ORES_TIN = forgeTag("ores/tin");
        public static final ITag.INamedTag<Block> ORES_SILVER = forgeTag("ores/silver");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static ITag.INamedTag<Block> tag(String modID, String name) {
            return BlockTags.bind(new ResourceLocation(modID, name).toString());
        }

        static ITag.INamedTag<Block> forgeTag(String  name) {
            return tag("forge", name);
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> PLATES = forgeCategory("plates");
        public static final Tags.IOptionalNamedTag<Item> GEARS = forgeCategory("gears");
        public static final Tags.IOptionalNamedTag<Item> BLEND = forgeCategory("blend");

        public static final ITag.INamedTag<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_LEAD = forgeTag("ingots/lead");
        public static final ITag.INamedTag<Item> INGOTS_TITANIUM = forgeTag("ingots/titanium");
        public static final ITag.INamedTag<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forgeTag("ingots/silver");

        public static final ITag.INamedTag<Item> INGOTS_STEEL = forgeTag("ingots/steel");
        public static final ITag.INamedTag<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");

        public static final ITag.INamedTag<Item> DUSTS_COAL = forgeTag("dusts/coal");

        public static final ITag.INamedTag<Item> DUSTS_IRON = forgeTag("dusts/iron");
        public static final ITag.INamedTag<Item> DUSTS_GOLD = forgeTag("dusts/gold");

        public static final ITag.INamedTag<Item> DUSTS_COPPER = forgeTag("dusts/copper");
        public static final ITag.INamedTag<Item> DUSTS_LEAD = forgeTag("dusts/lead");
        public static final ITag.INamedTag<Item> DUSTS_TITANIUM = forgeTag("dusts/titanium");
        public static final ITag.INamedTag<Item> DUSTS_TIN = forgeTag("dusts/tin");
        public static final ITag.INamedTag<Item> DUSTS_SILVER = forgeTag("dusts/silver");

        public static final ITag.INamedTag<Item> DUSTS_STEEL = forgeTag("dusts/steel");
        public static final ITag.INamedTag<Item> DUSTS_BRONZE = forgeTag("dusts/bronze");

        public static final ITag.INamedTag<Item> BLEND_STEEL = forgeTag("blend/steel");
        public static final ITag.INamedTag<Item> BLEND_BRONZE = forgeTag("blend/bronze");

        public static final ITag.INamedTag<Item> PLATES_IRON = forgeTag("plates/iron");
        public static final ITag.INamedTag<Item> PLATES_GOLD = forgeTag("plates/gold");

        public static final ITag.INamedTag<Item> PLATES_COPPER = forgeTag("plates/copper");
        public static final ITag.INamedTag<Item> PLATES_LEAD = forgeTag("plates/lead");
        public static final ITag.INamedTag<Item> PLATES_TITANIUM = forgeTag("plates/titanium");
        public static final ITag.INamedTag<Item> PLATES_TIN = forgeTag("plates/tin");
        public static final ITag.INamedTag<Item> PLATES_SILVER = forgeTag("plates/silver");

        public static final ITag.INamedTag<Item> PLATES_STEEL = forgeTag("plates/steel");
        public static final ITag.INamedTag<Item> PLATES_BRONZE = forgeTag("plates/bronze");

        public static final ITag.INamedTag<Item> RODS_IRON = forgeTag("rods/iron");
        public static final ITag.INamedTag<Item> RODS_GOLD = forgeTag("rods/gold");

        public static final ITag.INamedTag<Item> RODS_COPPER = forgeTag("rods/copper");
        public static final ITag.INamedTag<Item> RODS_LEAD = forgeTag("rods/lead");
        public static final ITag.INamedTag<Item> RODS_TITANIUM = forgeTag("rods/titanium");
        public static final ITag.INamedTag<Item> RODS_TIN = forgeTag("rods/tin");
        public static final ITag.INamedTag<Item> RODS_SILVER = forgeTag("rods/silver");

        public static final ITag.INamedTag<Item> RODS_STEEL = forgeTag("rods/steel");
        public static final ITag.INamedTag<Item> RODS_BRONZE = forgeTag("rods/bronze");

        public static final ITag.INamedTag<Item> GEARS_IRON = forgeTag("gears/iron");
        public static final ITag.INamedTag<Item> GEARS_GOLD = forgeTag("gears/gold");

        public static final ITag.INamedTag<Item> GEARS_COPPER = forgeTag("gears/copper");
        public static final ITag.INamedTag<Item> GEARS_LEAD = forgeTag("gears/lead");
        public static final ITag.INamedTag<Item> GEARS_TITANIUM = forgeTag("gears/titanium");
        public static final ITag.INamedTag<Item> GEARS_TIN = forgeTag("gears/tin");
        public static final ITag.INamedTag<Item> GEARS_SILVER = forgeTag("gears/silver");

        public static final ITag.INamedTag<Item> GEARS_STEEL = forgeTag("gears/steel");
        public static final ITag.INamedTag<Item> GEARS_BRONZE = forgeTag("gears/bronze");

        public static final ITag.INamedTag<Item> ORES_COPPER = forgeTag("ores/copper");
        public static final ITag.INamedTag<Item> ORES_LEAD = forgeTag("ores/lead");
        public static final ITag.INamedTag<Item> ORES_TITANIUM = forgeTag("ores/titanium");
        public static final ITag.INamedTag<Item> ORES_TIN = forgeTag("ores/tin");
        public static final ITag.INamedTag<Item> ORES_SILVER = forgeTag("ores/silver");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");

        static ITag.INamedTag<Item> tag(String modID, String name) {
            return ItemTags.bind(new ResourceLocation(modID, name).toString());
        }

        static ITag.INamedTag<Item> forgeTag(String name) {
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
