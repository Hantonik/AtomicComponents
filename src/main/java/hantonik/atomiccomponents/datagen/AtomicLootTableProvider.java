package hantonik.atomiccomponents.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AtomicLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> lootTables;

    public AtomicLootTableProvider(GatherDataEvent event) {
        super(event.getGenerator());

        this.lootTables = ImmutableList.of(Pair.of(AtomicBlockLootTables::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
        map.forEach(((location, lootTable) -> LootTables.validate(validationTracker, location, lootTable)));
        map.keySet().removeIf(location -> !location.getNamespace().equals(AtomicComponents.MOD_ID));
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " LootTables";
    }

    private static class AtomicBlockLootTables extends BlockLoot {
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> AtomicComponents.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace())).collect(Collectors.toList());
        }

        @Override
        protected void addTables() {
            this.addCommon();
            this.addOres();
        }

        private void addCommon() {
            for (Block block : ForgeRegistries.BLOCKS.getValues().stream().filter(block -> AtomicComponents.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()) && (!Objects.requireNonNull(block.getRegistryName()).getPath().toLowerCase(Locale.ROOT).contains("ore") || Objects.requireNonNull(block.getRegistryName()).getPath().toLowerCase(Locale.ROOT).contains("raw")) && !Objects.requireNonNull(block.getRegistryName()).getPath().toLowerCase(Locale.ROOT).contains("molten")).collect(Collectors.toSet()))
                this.dropSelf(block);
        }

        private void addOres() {
            this.add(AtomicBlocks.ALUMINUM_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_ALUMINUM.get()));
            this.add(AtomicBlocks.LEAD_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_LEAD.get()));
            this.add(AtomicBlocks.TITANIUM_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_TITANIUM.get()));
            this.add(AtomicBlocks.TIN_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_TIN.get()));
            this.add(AtomicBlocks.SILVER_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_SILVER.get()));

            this.add(AtomicBlocks.DEEPSLATE_ALUMINUM_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_ALUMINUM.get()));
            this.add(AtomicBlocks.DEEPSLATE_LEAD_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_LEAD.get()));
            this.add(AtomicBlocks.DEEPSLATE_TITANIUM_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_TITANIUM.get()));
            this.add(AtomicBlocks.DEEPSLATE_TIN_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_TIN.get()));
            this.add(AtomicBlocks.DEEPSLATE_SILVER_ORE.get(), (block) -> createOreDrop(block, AtomicItems.RAW_SILVER.get()));
        }
    }
}
