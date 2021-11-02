package hantonik.atomiccomponents.datagen;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicFluids;
import hantonik.atomiccomponents.init.AtomicItems;
import hantonik.atomiccomponents.init.AtomicTags;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class AtomicRecipeProvider extends RecipeProvider {
    public AtomicRecipeProvider(GatherDataEvent event) {
        super(event.getGenerator());
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        this.registerCraftingRecipes(consumer);
        this.registerFurnaceRecipes(consumer);

        this.registerSmelteryMeltingRecipes(consumer);
        this.registerSmelteryCastingRecipes(consumer);
    }

    private void registerCraftingRecipes(Consumer<IFinishedRecipe> consumer) {
        this.shapelessCraftingRecipe(AtomicItems.STEEL_BLEND.get(), 2, consumer, "", AtomicTags.Items.DUSTS_IRON, AtomicTags.Items.DUSTS_CARBON, AtomicTags.Items.DUSTS_CARBON);
        this.shapelessCraftingRecipe(AtomicItems.BRONZE_BLEND.get(), 3, consumer, "", AtomicTags.Items.DUSTS_COPPER, AtomicTags.Items.DUSTS_TIN, AtomicTags.Items.DUSTS_TIN);

        this.shapelessCraftingRecipe(AtomicItems.COPPER_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_COPPER);
        this.shapelessCraftingRecipe(AtomicItems.LEAD_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_LEAD);
        this.shapelessCraftingRecipe(AtomicItems.TIN_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_TIN);
        this.shapelessCraftingRecipe(AtomicItems.TITANIUM_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_TITANIUM);
        this.shapelessCraftingRecipe(AtomicItems.SILVER_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_SILVER);

        this.shapelessCraftingRecipe(AtomicItems.STEEL_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_STEEL);
        this.shapelessCraftingRecipe(AtomicItems.BRONZE_INGOT.get(), 9, consumer, "", AtomicTags.Items.STORAGE_BLOCKS_BRONZE);

        ShapedRecipeBuilder.shaped(AtomicBlocks.COPPER_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_COPPER).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_COPPER)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicBlocks.LEAD_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_LEAD).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_LEAD)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicBlocks.TIN_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_TIN).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_TIN)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicBlocks.TITANIUM_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_TITANIUM).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_TITANIUM)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicBlocks.SILVER_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_SILVER).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_SILVER)).save(consumer);

        ShapedRecipeBuilder.shaped(AtomicBlocks.STEEL_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_STEEL).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_STEEL)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicBlocks.BRONZE_BLOCK.get()).define('I', AtomicTags.Items.INGOTS_BRONZE).pattern("III").pattern("III").pattern("III").unlockedBy("has_ingot", has(AtomicTags.Items.INGOTS_BRONZE)).save(consumer);

        ShapedRecipeBuilder.shaped(AtomicItems.IRON_GEAR.get()).define('P', AtomicTags.Items.PLATES_IRON).define('R', AtomicTags.Items.RODS_IRON).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_IRON)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_IRON)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.GOLD_GEAR.get()).define('P', AtomicTags.Items.PLATES_GOLD).define('R', AtomicTags.Items.RODS_GOLD).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_GOLD)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_GOLD)).save(consumer);

        ShapedRecipeBuilder.shaped(AtomicItems.COPPER_GEAR.get()).define('P', AtomicTags.Items.PLATES_COPPER).define('R', AtomicTags.Items.RODS_COPPER).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_COPPER)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_COPPER)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.LEAD_GEAR.get()).define('P', AtomicTags.Items.PLATES_LEAD).define('R', AtomicTags.Items.RODS_LEAD).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_LEAD)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_LEAD)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.TITANIUM_GEAR.get()).define('P', AtomicTags.Items.PLATES_TITANIUM).define('R', AtomicTags.Items.RODS_TITANIUM).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_TITANIUM)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_TITANIUM)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.TIN_GEAR.get()).define('P', AtomicTags.Items.PLATES_TIN).define('R', AtomicTags.Items.RODS_TIN).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_TIN)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_TIN)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.SILVER_GEAR.get()).define('P', AtomicTags.Items.PLATES_SILVER).define('R', AtomicTags.Items.RODS_SILVER).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_SILVER)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_SILVER)).save(consumer);

        ShapedRecipeBuilder.shaped(AtomicItems.BRONZE_GEAR.get()).define('P', AtomicTags.Items.PLATES_BRONZE).define('R', AtomicTags.Items.RODS_BRONZE).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_BRONZE)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_BRONZE)).save(consumer);
        ShapedRecipeBuilder.shaped(AtomicItems.STEEL_GEAR.get()).define('P', AtomicTags.Items.PLATES_STEEL).define('R', AtomicTags.Items.RODS_STEEL).pattern("RPR").pattern("P P").pattern("RPR").unlockedBy("has_plate", has(AtomicTags.Items.PLATES_STEEL)).unlockedBy("has_rode", has(AtomicTags.Items.RODS_STEEL)).save(consumer);
    }

    private void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer) {
        this.blastingRecipe(AtomicTags.Items.BLENDS_STEEL, AtomicItems.STEEL_INGOT.get(), 0.3F, 125, "_from_blend", consumer);
        this.blastingRecipe(AtomicTags.Items.BLENDS_BRONZE, AtomicItems.BRONZE_INGOT.get(), 0.3F, 125, "_from_blend", consumer);

        this.blastingRecipe(AtomicTags.Items.DUSTS_IRON, Items.IRON_INGOT, 0.2F, 120, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_GOLD, Items.GOLD_INGOT, 0.2F, 120, "_from_dust", consumer);

        this.blastingRecipe(AtomicTags.Items.DUSTS_COPPER, AtomicItems.COPPER_INGOT.get(), 0.2F, 120, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_LEAD, AtomicItems.LEAD_INGOT.get(), 0.2F, 120, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_TITANIUM, AtomicItems.TITANIUM_INGOT.get(), 0.2F, 120, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_TIN, AtomicItems.TIN_INGOT.get(), 0.2F, 120, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_SILVER, AtomicItems.SILVER_INGOT.get(), 0.2F, 120, "_from_dust", consumer);

        this.blastingRecipe(AtomicTags.Items.DUSTS_STEEL, AtomicItems.STEEL_INGOT.get(), 0.3F, 135, "_from_dust", consumer);
        this.blastingRecipe(AtomicTags.Items.DUSTS_BRONZE, AtomicItems.BRONZE_INGOT.get(), 0.4F, 120, "_from_dust", consumer);

        this.blastingRecipe(AtomicTags.Items.ORES_COPPER, AtomicItems.COPPER_INGOT.get(), 0.3F, 130, "_from_ore", consumer);
        this.blastingRecipe(AtomicTags.Items.ORES_LEAD, AtomicItems.LEAD_INGOT.get(), 0.3F, 130, "_from_ore", consumer);
        this.blastingRecipe(AtomicTags.Items.ORES_TITANIUM, AtomicItems.TITANIUM_INGOT.get(), 0.3F, 130, "_from_ore", consumer);
        this.blastingRecipe(AtomicTags.Items.ORES_TIN, AtomicItems.TIN_INGOT.get(), 0.3F, 130, "_from_ore", consumer);
        this.blastingRecipe(AtomicTags.Items.ORES_SILVER, AtomicItems.SILVER_INGOT.get(), 0.3F, 130, "_from_ore", consumer);
    }

    private void registerSmelteryMeltingRecipes(Consumer<IFinishedRecipe> consumer) {
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.BLENDS_BRONZE), TinkerFluids.moltenBronze.get(), 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/blend/bronze"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.BLENDS_STEEL), TinkerFluids.moltenSteel.get(), 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/blend/steel"));

        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.STORAGE_BLOCKS_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 1296).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/block"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.INGOTS_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/ingot"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.PLATES_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/plate"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.DUSTS_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/dust"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.GEARS_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 576).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/gear"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.ORES_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 288).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/ore"));
        MeltingRecipeBuilder.melting(Ingredient.of(AtomicTags.Items.RODS_TITANIUM), AtomicFluids.MOLTEN_TITANIUM.get(), 72).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/melting/metal/titanium/rod"));
    }

    private void registerSmelteryCastingRecipes(Consumer<IFinishedRecipe> consumer) {
        ItemCastingRecipeBuilder.basinRecipe(AtomicBlocks.TITANIUM_BLOCK.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 1296).setCoolingTime(1668, 1296).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/block"));

        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_GEAR.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 576).setCast(TinkerSmeltery.gearCast.getMultiUseTag(), false).setCoolingTime(1668, 576).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/gear_gold_cast"));
        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_GEAR.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 576).setCast(TinkerSmeltery.gearCast.getSingleUseTag(), true).setCoolingTime(1668, 576).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/gear_sand_cast"));

        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_INGOT.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 144).setCast(TinkerSmeltery.ingotCast.getMultiUseTag(), false).setCoolingTime(1668, 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/ingot_gold_cast"));
        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_INGOT.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 144).setCast(TinkerSmeltery.ingotCast.getSingleUseTag(), true).setCoolingTime(1668, 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/ingot_sand_cast"));

        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_PLATE.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 144).setCast(TinkerSmeltery.plateCast.getMultiUseTag(), false).setCoolingTime(1668, 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/plate_gold_cast"));
        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_PLATE.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 144).setCast(TinkerSmeltery.plateCast.getSingleUseTag(), true).setCoolingTime(1668, 144).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/plate_sand_cast"));

        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_ROD.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 72).setCast(TinkerSmeltery.rodCast.getMultiUseTag(), false).setCoolingTime(1668, 72).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/rod_gold_cast"));
        ItemCastingRecipeBuilder.tableRecipe(AtomicItems.TITANIUM_ROD.get()).setFluid(AtomicFluids.MOLTEN_TITANIUM.getForgeTag(), 72).setCast(TinkerSmeltery.rodCast.getSingleUseTag(), true).setCoolingTime(1668, 72).build(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "smeltery/casting/metal/titanium/rod_sand_cast"));
    }

    private void shapelessCraftingRecipe(IItemProvider output, Consumer<IFinishedRecipe> consumer, String suffix, IItemProvider[]... inputs) {
        this.shapelessCraftingRecipe(output, 1, consumer, suffix, inputs);
    }

    @SafeVarargs
    private final void shapelessCraftingRecipe(IItemProvider output, Consumer<IFinishedRecipe> consumer, String suffix, ITag.INamedTag<Item>... tags) {
        this.shapelessCraftingRecipe(output, 1, consumer, suffix, tags);
    }

    @SafeVarargs
    private final void shapelessCraftingRecipe(IItemProvider output, int count, Consumer<IFinishedRecipe> consumer, String suffix, ITag.INamedTag<Item>... tags) {
        List<ITag.INamedTag<Item>> items = Lists.newLinkedList();
        ShapelessRecipeBuilder recipeBuilder = ShapelessRecipeBuilder.shapeless(output, count);

        for (ITag.INamedTag<Item> tag : tags) {
            recipeBuilder.requires(tag);

            if (!items.contains(tag))
                items.add(tag);
        }

        for (ITag.INamedTag<Item> tag : items)
            recipeBuilder.unlockedBy("has_" + tag.getName(), has(tag));

        recipeBuilder.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/crafting/shapeless/" + output.asItem().getRegistryName().getPath() + suffix));
    }

    private void shapelessCraftingRecipe(IItemProvider output, int count, Consumer<IFinishedRecipe> consumer, String suffix, IItemProvider[]... inputs) {
        List<IItemProvider> items = Lists.newLinkedList();
        ShapelessRecipeBuilder recipeBuilder = ShapelessRecipeBuilder.shapeless(output, count);

        for (IItemProvider[] inputs1 : inputs) {
            recipeBuilder.requires(Ingredient.of(inputs1));

            for (IItemProvider input : inputs1)
                if (!items.contains(input))
                    items.add(input);
        }

        for (IItemProvider input : items)
            recipeBuilder.unlockedBy("has_" + input.asItem().getRegistryName().getPath(), has(input));

        recipeBuilder.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/crafting/shapeless/" + output.asItem().getRegistryName().getPath() + suffix));
    }

    private void shapedCraftingRecipe(IItemProvider output, Consumer<IFinishedRecipe> consumer, String suffix, IItemProvider[][][] inputs) {
        this.shapedCraftingRecipe(output, 1, consumer, suffix, inputs);
    }

    private void shapedCraftingRecipe(IItemProvider output, Consumer<IFinishedRecipe> consumer, String suffix, List<List<ITag.INamedTag<Item>>> tags) {
        this.shapedCraftingRecipe(output, 1, consumer, suffix, tags);
    }

    private void shapedCraftingRecipe(IItemProvider output, int count, Consumer<IFinishedRecipe> consumer, String suffix, List<List<ITag.INamedTag<Item>>> tags) {
        List<ITag.INamedTag<Item>> items = Lists.newLinkedList();
        Map<JsonElement, Character> keys = Maps.newHashMap();
        ShapedRecipeBuilder recipeBuilder = ShapedRecipeBuilder.shaped(output, count);
        char key = 'A';

        int height = tags.size();
        int width = tags.get(0).size();

        for (List<ITag.INamedTag<Item>> tags1 : tags) {
            StringBuilder patternBuilder = new StringBuilder();

            for (ITag.INamedTag<Item> tag : tags1) {
                Ingredient input = Ingredient.of(tag);

                if (input == Ingredient.EMPTY || input.equals(Ingredient.EMPTY)) {
                    patternBuilder.append(" ");

                    continue;
                }

                if (!keys.containsKey(input.toJson())) {
                    keys.put(input.toJson(), key);
                    recipeBuilder.define(key, input);
                    patternBuilder.append(key);

                    key++;
                } else
                    patternBuilder.append(keys.get(input.toJson()));

                if (!items.contains(tag))
                    items.add(tag);
            }

            recipeBuilder.pattern(patternBuilder.toString());
        }

        items.forEach(tag -> recipeBuilder.unlockedBy("has_" + tag.getName(), has(tag)));

        recipeBuilder.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/crafting/" + width + 'x' + height + '/' + output.asItem().getRegistryName().getPath() + suffix));
    }

    private void shapedCraftingRecipe(IItemProvider output, int count, Consumer<IFinishedRecipe> consumer, String suffix, IItemProvider[][][] inputs) {
        List<IItemProvider> items = Lists.newLinkedList();
        Map<JsonElement, Character> keys = Maps.newHashMap();
        ShapedRecipeBuilder recipeBuilder = ShapedRecipeBuilder.shaped(output, count);
        char key = 'A';

        int height = inputs.length;
        int width = inputs[0].length;

        for (IItemProvider[][] inputs1 : inputs) {
            StringBuilder patternBuilder = new StringBuilder();

            for (IItemProvider[] inputs2 : inputs1) {
                Ingredient input = Ingredient.of(inputs2);

                if (input == Ingredient.EMPTY || input.equals(Ingredient.EMPTY)) {
                    patternBuilder.append(" ");

                    continue;
                }

                if (!keys.containsKey(input.toJson())) {
                    keys.put(input.toJson(), key);
                    recipeBuilder.define(key, input);
                    patternBuilder.append(key);

                    key++;
                } else
                    patternBuilder.append(keys.get(input.toJson()));

                for (IItemProvider itemProvider : inputs2) {
                    if (!items.contains(itemProvider))
                        items.add(itemProvider);
                }
            }

            recipeBuilder.pattern(patternBuilder.toString());
        }

        items.forEach(itemProvider -> recipeBuilder.unlockedBy("has_" + itemProvider.asItem().getRegistryName().getPath(), has(itemProvider)));

        recipeBuilder.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/crafting/" + width + 'x' + height + '/' + output.asItem().getRegistryName().getPath() + suffix));
    }

    private void blastingRecipe(Ingredient input, IItemProvider output, float experience, int cookingTime, String nameSuffix, Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder blastingRecipe = CookingRecipeBuilder.blasting(input, output, experience, (int) ((float) cookingTime / 3) * 2);
        CookingRecipeBuilder smeltingRecipe = CookingRecipeBuilder.smelting(input, output, experience, cookingTime);

        for (Item item : Arrays.stream(input.getItems()).map(ItemStack::getItem).collect(Collectors.toSet()))
            blastingRecipe.unlockedBy("has_" + item.getRegistryName().getPath(), has(item));

        for (Item item : Arrays.stream(input.getItems()).map(ItemStack::getItem).collect(Collectors.toSet()))
            smeltingRecipe.unlockedBy("has_" + item.getRegistryName().getPath(), has(item));

        blastingRecipe.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/blasting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
        smeltingRecipe.save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/smelting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
    }

    private void blastingRecipe(ITag.INamedTag<Item> input, IItemProvider output, float experience, int cookingTime, String nameSuffix, Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blasting(Ingredient.of(input), output, experience, (int) ((float) cookingTime / 3) * 2).unlockedBy("has_" + input.getName(), has(input)).save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/blasting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
        CookingRecipeBuilder.smelting(Ingredient.of(input), output, experience, cookingTime).unlockedBy("has_" + input.getName(), has(input)).save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/smelting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
    }

    private void blastingRecipe(IItemProvider input, IItemProvider output, float experience, int cookingTime, String nameSuffix, Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blasting(Ingredient.of(input), output, experience, (int) ((float) cookingTime / 3) * 2).unlockedBy("has_" + input.asItem().getRegistryName().getPath(), has(input)).save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/blasting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
        CookingRecipeBuilder.smelting(Ingredient.of(input), output, experience, cookingTime).unlockedBy("has_" + input.asItem().getRegistryName().getPath(), has(input)).save(consumer, new ResourceLocation(AtomicComponents.MOD_ID, "/smelting/" + output.asItem().getRegistryName().getPath() + nameSuffix));
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " RecipeProvider";
    }
}
