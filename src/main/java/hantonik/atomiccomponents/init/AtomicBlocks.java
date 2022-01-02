package hantonik.atomiccomponents.init;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.blocks.BasicOreBlock;
import hantonik.atomiccomponents.items.AttributedBlockItem;
import hantonik.atomiccomponents.items.AttributedItem;
import hantonik.atomiccore.block.BasicBlock;
import hantonik.atomiccore.items.BasicBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

import static hantonik.atomiccomponents.items.AttributedItem.Attributes.create;

@SuppressWarnings("unused")
public final class AtomicBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AtomicComponents.MOD_ID);

    // MATERIALS
    public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", Material.METAL, SoundType.METAL, 2.85F, 4.15F, true, create().isFusible(true).meltingTemperature(601), AtomicComponents.BLOCKS_GROUP);
    public static final RegistryObject<Block> TITANIUM_BLOCK = register("titanium_block", Material.METAL, SoundType.METAL, 5.25F, 6.5F, true, create().isFusible(true).meltingTemperature(1941).melted(AtomicFluids.MOLTEN_TITANIUM), AtomicComponents.BLOCKS_GROUP);
    public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", Material.METAL, SoundType.METAL, 2.5F, 3.75F, true, create().isFusible(true).meltingTemperature(505), AtomicComponents.BLOCKS_GROUP);
    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", Material.METAL, SoundType.METAL, 3.5F, 5.25F, true, create().isFusible(true).meltingTemperature(1235), AtomicComponents.BLOCKS_GROUP);

    // ALLOYS
    public static final RegistryObject<Block> BRONZE_BLOCK = register("bronze_block", Material.METAL, SoundType.METAL, 4.25F, 5.5F, true, create().isFusible(true).meltingTemperature(1223), AtomicComponents.BLOCKS_GROUP);
    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", Material.METAL, SoundType.METAL, 5.0F, 6.25F, true, create().isFusible(true).meltingTemperature(1783), AtomicComponents.BLOCKS_GROUP);

    // ORES
    public static final RegistryObject<Block> LEAD_ORE = register("lead_ore", () -> new BasicOreBlock(p -> p.strength(2.5F, 3.75F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(601)));
    public static final RegistryObject<Block> TITANIUM_ORE = register("titanium_ore", () -> new BasicOreBlock(p -> p.strength(4.0F, 5.5F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () -> new BasicOreBlock(p -> p.strength(3.25F, 4.75F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(505)));
    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new BasicOreBlock(p -> p.strength(3.0F, 4.5F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1235)));

    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", () -> new BasicOreBlock(p -> BlockBehaviour.Properties.copy(LEAD_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.0F, 3.75F).sound(SoundType.DEEPSLATE)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(621)));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = register("deepslate_titanium_ore", () -> new BasicOreBlock(p -> BlockBehaviour.Properties.copy(TITANIUM_ORE.get()).color(MaterialColor.DEEPSLATE).strength(5.5F, 5.5F).sound(SoundType.DEEPSLATE)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1961).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () -> new BasicOreBlock(p -> BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.75F, 4.75F).sound(SoundType.DEEPSLATE)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(525)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", () -> new BasicOreBlock(p -> BlockBehaviour.Properties.copy(SILVER_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 4.5F).sound(SoundType.DEEPSLATE)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1255)));

    // RAW ORES
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = register("raw_lead_block", () -> new BasicOreBlock(p -> p.strength(2.5F, 3.75F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(601)));
    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = register("raw_titanium_block", () -> new BasicOreBlock(p -> p.strength(4.0F, 5.5F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1941).melted(AtomicFluids.MOLTEN_TITANIUM)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = register("raw_tin_block", () -> new BasicOreBlock(p -> p.strength(3.25F, 4.75F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(505)));
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = register("raw_silver_block", () -> new BasicOreBlock(p -> p.strength(3.0F, 4.5F)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(AtomicComponents.BLOCKS_GROUP), a -> a.isFusible(true).meltingTemperature(1235)));

    private static RegistryObject<Block> register(String name, Supplier<Block> block, CreativeModeTab tab) {
        return register(name, block, b -> () -> new BasicBlockItem(b.get(), p -> p.tab(tab)));
    }

    private static RegistryObject<Block> register(String name, Material material, SoundType sound, float hardness, float resistance, boolean tool, CreativeModeTab tab) {
        return register(name, () -> new BasicBlock(material, p -> tool ? p.sound(sound).strength(hardness, resistance).requiresCorrectToolForDrops() : p.sound(sound).strength(hardness, resistance)), b -> () -> new BasicBlockItem(b.get(), p -> p.tab(tab)));
    }

    private static RegistryObject<Block> register(String name, Material material, SoundType sound, float hardness, float resistance, boolean tool, AttributedItem.Attributes attributes, CreativeModeTab tab) {
        return register(name, () -> new BasicBlock(material, p -> tool ? p.sound(sound).strength(hardness, resistance).requiresCorrectToolForDrops() : p.sound(sound).strength(hardness, resistance)), b -> () -> new AttributedBlockItem(b.get(), p -> p.tab(tab), a -> attributes));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Function<RegistryObject<Block>, Supplier<? extends BlockItem>> item) {
        var reg = BLOCKS.register(name, block);
        AtomicItems.ITEMS.register(name, () -> item.apply(reg).get());

        return reg;
    }
}
