package hantonik.atomiccomponents.init;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.items.BurnableItem;
import hantonik.atomiccore.items.BasicItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class AtomicItems {
    public static final List<Supplier<Item>> BLOCK_ITEMS = new ArrayList<>();
    public static final Map<RegistryObject<Item>, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    // MATERIALS
    public static final RegistryObject<Item> COPPER_INGOT = register("copper_ingot", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> LEAD_INGOT = register("lead_ingot", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TITANIUM_INGOT = register("titanium_ingot", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TIN_INGOT = register("tin_ingot", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", AtomicComponents.MATERIALS_GROUP);

    // ALLOYS
    public static final RegistryObject<Item> BRONZE_INGOT = register("bronze_ingot", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot", AtomicComponents.MATERIALS_GROUP);

    // PLATES
    public static final RegistryObject<Item> IRON_PLATE = register("iron_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> GOLD_PLATE = register("gold_plate", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> COPPER_PLATE = register("copper_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> LEAD_PLATE = register("lead_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TITANIUM_PLATE = register("titanium_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TIN_PLATE = register("tin_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> SILVER_PLATE = register("silver_plate", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> BRONZE_PLATE = register("bronze_plate", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_PLATE = register("steel_plate", AtomicComponents.MATERIALS_GROUP);

    // DUSTS
    public static final RegistryObject<Item> COAL_DUST = register("coal_dust", () -> new BurnableItem(p -> p.tab(AtomicComponents.MATERIALS_GROUP), 900));

    public static final RegistryObject<Item> IRON_DUST = register("iron_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> GOLD_DUST = register("gold_dust", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> COPPER_DUST = register("copper_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> LEAD_DUST = register("lead_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TITANIUM_DUST = register("titanium_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TIN_DUST = register("tin_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> SILVER_DUST = register("silver_dust", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> BRONZE_DUST = register("bronze_dust", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_DUST = register("steel_dust", AtomicComponents.MATERIALS_GROUP);

    // BLENDS
    public static final RegistryObject<Item> BRONZE_BLEND = register("bronze_blend", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_BLEND = register("steel_blend", AtomicComponents.MATERIALS_GROUP);

    // GEARS
    public static final RegistryObject<Item> IRON_GEAR = register("iron_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> GOLD_GEAR = register("gold_gear", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> COPPER_GEAR = register("copper_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> LEAD_GEAR = register("lead_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TITANIUM_GEAR = register("titanium_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TIN_GEAR = register("tin_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> SILVER_GEAR = register("silver_gear", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> BRONZE_GEAR = register("bronze_gear", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_GEAR = register("steel_gear", AtomicComponents.MATERIALS_GROUP);

    // RODS
    public static final RegistryObject<Item> IRON_ROD = register("iron_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> GOLD_ROD = register("gold_rod", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> COPPER_ROD = register("copper_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> LEAD_ROD = register("lead_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TITANIUM_ROD = register("titanium_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> TIN_ROD = register("tin_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> SILVER_ROD = register("silver_rod", AtomicComponents.MATERIALS_GROUP);

    public static final RegistryObject<Item> BRONZE_ROD = register("bronze_rod", AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Item> STEEL_ROD = register("steel_rod", AtomicComponents.MATERIALS_GROUP);

    @SubscribeEvent
    public void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        BLOCK_ITEMS.stream().map(Supplier::get).forEach(registry::register);
        ITEMS.forEach((reg, item) -> {
            registry.register(item.get());
            reg.updateReference(registry);
        });
    }

    private static RegistryObject<Item> register(String name, ItemGroup group) {
        return register(name, () -> new BasicItem(p -> p.tab(group)));
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        ResourceLocation loc = new ResourceLocation(AtomicComponents.MOD_ID, name);

        RegistryObject<Item> reg = RegistryObject.of(loc, ForgeRegistries.ITEMS);
        ITEMS.put(reg, () -> item.get().setRegistryName(loc));

        return reg;
    }
}
