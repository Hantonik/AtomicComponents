package hantonik.atomiccomponents.init;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.utils.ComponentsTimeUtils;
import hantonik.atomiccore.items.AttributedItem;
import hantonik.atomiccore.items.BasicItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class AtomicItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AtomicComponents.MOD_ID);

    // MATERIALS
    public static final RegistryObject<AttributedItem> COKE = register("coke", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isBurnable(true).burningTime(1800).burningTemperature(973)));

    public static final RegistryObject<Item> SILICON = register("silicon", AtomicComponents.ITEMS_GROUP);

    public static final RegistryObject<Item> GRAPHITE_INGOT = register("graphite_ingot", AtomicComponents.ITEMS_GROUP);

    public static final RegistryObject<AttributedItem> ALUMINUM_INGOT = register("aluminum_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> LEAD_INGOT = register("lead_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> TITANIUM_INGOT = register("titanium_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> TIN_INGOT = register("tin_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> SILVER_INGOT = register("silver_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    public static final RegistryObject<AttributedItem> BRONZE_INGOT = register("bronze_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_INGOT = register("steel_ingot", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    // RAW
    public static final RegistryObject<AttributedItem> RAW_ALUMINUM = register("raw_aluminum", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> RAW_LEAD = register("raw_lead", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> RAW_TITANIUM = register("raw_titanium", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> RAW_TIN = register("raw_tin", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> RAW_SILVER = register("raw_silver", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.INGOT_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    // PLATES
    public static final RegistryObject<AttributedItem> IRON_PLATE = register("iron_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1811).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_IRON)));
    public static final RegistryObject<AttributedItem> GOLD_PLATE = register("gold_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1337).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_GOLD)));

    public static final RegistryObject<AttributedItem> COPPER_PLATE = register("copper_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1358).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_COPPER)));
    public static final RegistryObject<AttributedItem> ALUMINUM_PLATE = register("aluminum_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> LEAD_PLATE = register("lead_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> TITANIUM_PLATE = register("titanium_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> TIN_PLATE = register("tin_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> SILVER_PLATE = register("silver_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    public static final RegistryObject<AttributedItem> BRONZE_PLATE = register("bronze_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_PLATE = register("steel_plate", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.PLATE_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    // DUSTS
    public static final RegistryObject<AttributedItem> COKE_DUST = register("coke_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isBurnable(true).burningTime(1080).burningTemperature(973)));
    public static final RegistryObject<AttributedItem> CARBON_DUST = register("carbon_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isBurnable(true).burningTime(900).burningTemperature(573)));

    public static final RegistryObject<Item> SILICON_DUST = register("silicon_dust", AtomicComponents.ITEMS_GROUP);

    public static final RegistryObject<Item> GRAPHITE_DUST = register("graphite_dust", AtomicComponents.ITEMS_GROUP);

    public static final RegistryObject<AttributedItem> IRON_DUST = register("iron_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1811).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_IRON)));
    public static final RegistryObject<AttributedItem> GOLD_DUST = register("gold_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1337).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_GOLD)));

    public static final RegistryObject<AttributedItem> COPPER_DUST = register("copper_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1358).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_COPPER)));
    public static final RegistryObject<AttributedItem> ALUMINUM_DUST = register("aluminum_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> LEAD_DUST = register("lead_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> TITANIUM_DUST = register("titanium_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> TIN_DUST = register("tin_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> SILVER_DUST = register("silver_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    public static final RegistryObject<AttributedItem> BRONZE_DUST = register("bronze_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_DUST = register("steel_dust", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    // BLENDS
    public static final RegistryObject<AttributedItem> BRONZE_BLEND = register("bronze_blend", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_BLEND = register("steel_blend", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.DUST_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    // GEARS
    public static final RegistryObject<AttributedItem> IRON_GEAR = register("iron_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1811).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_IRON)));
    public static final RegistryObject<AttributedItem> GOLD_GEAR = register("gold_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1337).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_GOLD)));

    public static final RegistryObject<AttributedItem> COPPER_GEAR = register("copper_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1358).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_COPPER)));
    public static final RegistryObject<AttributedItem> ALUMINUM_GEAR = register("aluminum_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> LEAD_GEAR = register("lead_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> TITANIUM_GEAR = register("titanium_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> TIN_GEAR = register("tin_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> SILVER_GEAR = register("silver_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    public static final RegistryObject<AttributedItem> BRONZE_GEAR = register("bronze_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_GEAR = register("steel_gear", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.GEAR_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    // RODS
    public static final RegistryObject<Item> GRAPHITE_ROD = register("graphite_rod", AtomicComponents.ITEMS_GROUP);

    public static final RegistryObject<AttributedItem> IRON_ROD = register("iron_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1811).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_IRON)));
    public static final RegistryObject<AttributedItem> GOLD_ROD = register("gold_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1337).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_GOLD)));

    public static final RegistryObject<AttributedItem> COPPER_ROD = register("copper_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1358).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_COPPER)));
    public static final RegistryObject<AttributedItem> ALUMINUM_ROD = register("aluminum_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(934).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_ALUMINUM)));
    public static final RegistryObject<AttributedItem> LEAD_ROD = register("lead_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(601).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_LEAD)));
    public static final RegistryObject<AttributedItem> TITANIUM_ROD = register("titanium_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<AttributedItem> TIN_ROD = register("tin_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(505).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_TIN)));
    public static final RegistryObject<AttributedItem> SILVER_ROD = register("silver_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1235).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_SILVER)));

    public static final RegistryObject<AttributedItem> BRONZE_ROD = register("bronze_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1223).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_BRONZE)));
    public static final RegistryObject<AttributedItem> STEEL_ROD = register("steel_rod", () -> new AttributedItem(p -> p.tab(AtomicComponents.ITEMS_GROUP), a -> a.isFusible(true).meltingTemperature(1783).meltingTime(ComponentsTimeUtils.ROD_MELTING).melted(AtomicFluids.MOLTEN_STEEL)));

    private static RegistryObject<Item> register(String name, CreativeModeTab tab) {
        return register(name, () -> new BasicItem(p -> p.tab(tab)));
    }

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
