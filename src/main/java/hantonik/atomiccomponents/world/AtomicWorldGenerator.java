package hantonik.atomiccomponents.world;

import hantonik.atomiccomponents.init.AtomicBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class AtomicWorldGenerator {
    private static final List<OreConfiguration.TargetBlockState> ORE_LEAD_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, AtomicBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AtomicBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
    private static final List<OreConfiguration.TargetBlockState> ORE_TITANIUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, AtomicBlocks.TITANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AtomicBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));
    private static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, AtomicBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AtomicBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    private static final List<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, AtomicBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AtomicBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

    private static final ConfiguredFeature<?, ?> ORE_LEAD_FEATURE = FeatureUtils.register("ore_lead", Feature.ORE.configured(new OreConfiguration(ORE_LEAD_TARGET_LIST, 9)));
    private static final ConfiguredFeature<?, ?> ORE_LEAD_SMALL_FEATURE = FeatureUtils.register("ore_lead_small", Feature.ORE.configured(new OreConfiguration(ORE_LEAD_TARGET_LIST, 4)));
    private static final ConfiguredFeature<?, ?> ORE_TITANIUM_FEATURE = FeatureUtils.register("ore_titanium", Feature.ORE.configured(new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 5)));
    private static final ConfiguredFeature<?, ?> ORE_TITANIUM_SMALL_FEATURE = FeatureUtils.register("ore_titanium_small", Feature.ORE.configured(new OreConfiguration(ORE_TITANIUM_TARGET_LIST, 2)));
    private static final ConfiguredFeature<?, ?> ORE_TIN_FEATURE = FeatureUtils.register("ore_tin", Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, 14)));
    private static final ConfiguredFeature<?, ?> ORE_TIN_SMALL_FEATURE = FeatureUtils.register("ore_tin_small", Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, 6)));
    private static final ConfiguredFeature<?, ?> ORE_SILVER_FEATURE = FeatureUtils.register("ore_silver", Feature.ORE.configured(new OreConfiguration(ORE_SILVER_TARGET_LIST, 6)));
    private static final ConfiguredFeature<?, ?> ORE_SILVER_SMALL_FEATURE = FeatureUtils.register("ore_silver_small", Feature.ORE.configured(new OreConfiguration(ORE_SILVER_TARGET_LIST, 2)));

    public static final PlacedFeature ORE_LEAD_UPPER = PlacementUtils.register("ore_lead_upper", ORE_LEAD_FEATURE.placed(commonOrePlacement(22, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(75)))));
    public static final PlacedFeature ORE_LEAD_MIDDLE = PlacementUtils.register("ore_lead_middle", ORE_LEAD_FEATURE.placed(commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(20)))));
    public static final PlacedFeature ORE_LEAD_SMALL = PlacementUtils.register("ore_lead_small", ORE_LEAD_SMALL_FEATURE.placed(commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-45), VerticalAnchor.absolute(27)))));

    public static final PlacedFeature ORE_TITANIUM_MIDDLE = PlacementUtils.register("ore_titanium_middle", ORE_TITANIUM_FEATURE.placed(rareOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(17)))));
    public static final PlacedFeature ORE_TITANIUM_MIDDLE_SMALL = PlacementUtils.register("ore_titanium_middle_small", ORE_TITANIUM_SMALL_FEATURE.placed(rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-17), VerticalAnchor.absolute(23)))));
    public static final PlacedFeature ORE_TITANIUM_LOWER = PlacementUtils.register("ore_titanium_lower", ORE_TITANIUM_FEATURE.placed(commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-35)))));
    public static final PlacedFeature ORE_TITANIUM_LOWER_SMALL = PlacementUtils.register("ore_titanium_lower_small", ORE_TITANIUM_SMALL_FEATURE.placed(commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-27)))));

    public static final PlacedFeature ORE_TIN_UPPER = PlacementUtils.register("ore_tin_upper", ORE_TIN_FEATURE.placed(commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(40), VerticalAnchor.absolute(85)))));
    public static final PlacedFeature ORE_TIN_MIDDLE = PlacementUtils.register("ore_tin_middle", ORE_TIN_FEATURE.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(25)))));
    public static final PlacedFeature ORE_TIN_LOWER = PlacementUtils.register("ore_tin_lower", ORE_TIN_FEATURE.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-48)))));
    public static final PlacedFeature ORE_TIN_SMALL = PlacementUtils.register("ore_tin_small", ORE_TIN_SMALL_FEATURE.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(92)))));

    public static final PlacedFeature ORE_SILVER_UPPER = PlacementUtils.register("ore_silver_upper", ORE_SILVER_FEATURE.placed(commonOrePlacement(17, HeightRangePlacement.triangle(VerticalAnchor.absolute(22), VerticalAnchor.absolute(47)))));
    public static final PlacedFeature ORE_SILVER_SMALL = PlacementUtils.register("ore_silver_small", ORE_SILVER_SMALL_FEATURE.placed(commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(15), VerticalAnchor.absolute(52)))));

    @SubscribeEvent
    public void onBiomesLoading(BiomeLoadingEvent event) {
        Biome.BiomeCategory category = event.getCategory();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (!category.equals(Biome.BiomeCategory.NETHER) && !category.equals(Biome.BiomeCategory.THEEND)) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_LEAD_UPPER);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_LEAD_MIDDLE);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_LEAD_SMALL);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TITANIUM_MIDDLE);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TITANIUM_MIDDLE_SMALL);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TITANIUM_LOWER);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TITANIUM_LOWER_SMALL);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TIN_UPPER);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TIN_MIDDLE);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TIN_LOWER);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_TIN_SMALL);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_SILVER_UPPER);
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_SILVER_SMALL);
        }
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier modifier1, PlacementModifier modifier2) {
        return List.of(modifier1, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(count), modifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(count), modifier);
    }
}
