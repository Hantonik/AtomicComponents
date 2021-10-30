package hantonik.atomiccomponents.world;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AtomicWorldGenerator {
    private static ConfiguredFeature<?, ?> COPPER_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> LEAD_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> TITANIUM_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> TIN_ORE_FEATURE;
    private static ConfiguredFeature<?, ?> SILVER_ORE_FEATURE;
    
    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (!category.equals(Biome.Category.NETHER) && !category.equals(Biome.Category.THEEND)) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, COPPER_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, LEAD_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TITANIUM_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, TIN_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SILVER_ORE_FEATURE);
        }
    }

    public static void setup() {
        int size, rate, height;
        OreFeatureConfig config;

        // COPPER ORE
        size = 12;
        rate = 20;
        height = 70;
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AtomicBlocks.COPPER_ORE.get().defaultBlockState(), size);

        COPPER_ORE_FEATURE = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .range(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AtomicComponents.MOD_ID, "copper_ore"), COPPER_ORE_FEATURE);

        // LEAD ORE
        size = 7;
        rate = 5;
        height = 30;
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AtomicBlocks.LEAD_ORE.get().defaultBlockState(), size);

        LEAD_ORE_FEATURE = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .range(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AtomicComponents.MOD_ID, "lead_ore"), LEAD_ORE_FEATURE);

        // TITANIUM ORE
        size = 5;
        rate = 3;
        height = 18;
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AtomicBlocks.TITANIUM_ORE.get().defaultBlockState(), size);

        TITANIUM_ORE_FEATURE = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .range(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AtomicComponents.MOD_ID, "titanium_ore"), TITANIUM_ORE_FEATURE);

        // TIN ORE
        size = 14;
        rate = 10;
        height = 55;
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AtomicBlocks.TIN_ORE.get().defaultBlockState(), size);

        TIN_ORE_FEATURE = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .range(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AtomicComponents.MOD_ID, "tin_ore"), TIN_ORE_FEATURE);

        // SILVER ORE
        size = 6;
        rate = 6;
        height = 20;
        config = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AtomicBlocks.SILVER_ORE.get().defaultBlockState(), size);

        SILVER_ORE_FEATURE = Feature.ORE.configured(config)
                .range(height)
                .squared()
                .range(rate);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AtomicComponents.MOD_ID, "silver_ore"), SILVER_ORE_FEATURE);
    }
}
