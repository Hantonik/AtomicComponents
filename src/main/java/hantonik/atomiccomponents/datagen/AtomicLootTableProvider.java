package hantonik.atomiccomponents.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicItems;
import net.minecraft.block.Block;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
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
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> lootTables;

    public AtomicLootTableProvider(GatherDataEvent event) {
        super(event.getGenerator());

        this.lootTables = ImmutableList.of(Pair.of(AtomicBlockLootTables::new, LootParameterSets.BLOCK));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return this.lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach(((location, lootTable) -> LootTableManager.validate(validationtracker, location, lootTable)));
        map.keySet().removeIf(location -> !location.getNamespace().equals(AtomicComponents.MOD_ID));
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " LootTables";
    }

    private static class AtomicBlockLootTables extends BlockLootTables {
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
            for (Block block : ForgeRegistries.BLOCKS.getValues().stream().filter(block -> AtomicComponents.MOD_ID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()) && !Objects.requireNonNull(block.getRegistryName()).getPath().toLowerCase(Locale.ROOT).contains("ore") && !Objects.requireNonNull(block.getRegistryName()).getPath().toLowerCase(Locale.ROOT).contains("molten")).collect(Collectors.toSet()))
                this.dropSelf(block);
        }

        private void addOres() {
            this.dropOther(AtomicBlocks.COPPER_ORE.get(), AtomicItems.COPPER_INGOT.get());
            this.dropOther(AtomicBlocks.LEAD_ORE.get(), AtomicItems.LEAD_INGOT.get());
            this.dropOther(AtomicBlocks.TITANIUM_ORE.get(), AtomicItems.TITANIUM_INGOT.get());
            this.dropOther(AtomicBlocks.TIN_ORE.get(), AtomicItems.TIN_INGOT.get());
            this.dropOther(AtomicBlocks.SILVER_ORE.get(), AtomicItems.SILVER_INGOT.get());
        }
    }
}
