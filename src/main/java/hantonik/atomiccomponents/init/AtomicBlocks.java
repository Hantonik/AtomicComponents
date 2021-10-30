package hantonik.atomiccomponents.init;

import com.google.common.collect.Maps;
import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.blocks.BasicOreBlock;
import hantonik.atomiccore.block.BasicBlock;
import hantonik.atomiccore.items.BasicBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class AtomicBlocks {
    public static final Map<RegistryObject<Block>, Supplier<Block>> BLOCKS = Maps.newLinkedHashMap();

    // MATERIALS
    public static final RegistryObject<Block> COPPER_BLOCK = registerMetal("copper_block", 2, 3.75F, 5.5F, AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> LEAD_BLOCK = registerMetal("lead_block", 2, 2.85F, 4.15F, AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerMetal("titanium_block", 3, 5.25F, 6.5F, AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> TIN_BLOCK = registerMetal("tin_block", 1, 2.5F, 3.75F, AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> SILVER_BLOCK = registerMetal("silver_block", 2, 3.5F, 5.25F, AtomicComponents.MATERIALS_GROUP);

    // ALLOYS
    public static final RegistryObject<Block> BRONZE_BLOCK = registerMetal("bronze_block", 2, 4.25F, 5.5F, AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> STEEL_BLOCK = registerMetal("steel_block", 3, 5.0F, 6.25F, AtomicComponents.MATERIALS_GROUP);

    // ORES
    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () -> new BasicOreBlock(1, 3.0F, 4.5F), AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> LEAD_ORE = register("lead_ore", () -> new BasicOreBlock(2, 2.5F, 3.75F), AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> TITANIUM_ORE = register("titanium_ore", () -> new BasicOreBlock(3, 4.0F, 5.5F), AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () -> new BasicOreBlock(1, 3.25F, 4.75F), AtomicComponents.MATERIALS_GROUP);
    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new BasicOreBlock(2, 3.0F, 4.5F), AtomicComponents.MATERIALS_GROUP);

    @SubscribeEvent
    public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        BLOCKS.forEach((reg, block) -> {
            registry.register(block.get());
            reg.updateReference(registry);
        });
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, ItemGroup group) {
        return register(name, block, b -> () -> new BasicBlockItem(b.get(), p -> p.tab(group)));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Function<RegistryObject<Block>, Supplier<? extends BlockItem>> item) {
        ResourceLocation location = new ResourceLocation(AtomicComponents.MOD_ID, name);
        RegistryObject<Block> registryObject = RegistryObject.of(location, ForgeRegistries.BLOCKS);

        BLOCKS.put(registryObject, () -> block.get().setRegistryName(location));
        AtomicItems.BLOCK_ITEMS.add(() -> item.apply(registryObject).get().setRegistryName(location));

        return registryObject;
    }

    private static RegistryObject<Block> registerMetal(String name, int harvestLevel, float hardness, float resistance, ItemGroup group) {
        return register(name, () -> new BasicBlock(Material.METAL, SoundType.METAL, ToolType.PICKAXE, harvestLevel, hardness, resistance), group);
    }
}
