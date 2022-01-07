package hantonik.atomiccomponents;

import hantonik.atomiccomponents.datagen.*;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicFluids;
import hantonik.atomiccomponents.init.AtomicItems;
import hantonik.atomiccomponents.world.AtomicWorldGenerator;
import hantonik.atomiccore.AtomicCore;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AtomicComponents.MOD_ID)
public final class AtomicComponents {
    public static final String MOD_ID = "atomiccomponents";
    public static final String MOD_NAME = "AtomicComponents";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public AtomicComponents() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);

        AtomicBlocks.BLOCKS.register(bus);
        AtomicFluids.FLUIDS.register(bus);
        AtomicItems.ITEMS.register(bus);
    }

    @SubscribeEvent
    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting common setup");

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new AtomicWorldGenerator());

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed common setup");
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting client setup");

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed client setup");
    }

    public static final CreativeModeTab ITEMS_GROUP = new CreativeModeTab(MOD_ID + "_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AtomicItems.TITANIUM_INGOT.get());
        }
    };

    public static final CreativeModeTab BLOCKS_GROUP = new CreativeModeTab(MOD_ID + "_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AtomicBlocks.TITANIUM_BLOCK.get());
        }
    };

    @EventBusSubscriber(modid = MOD_ID, bus = Bus.MOD)
    public static class DataGenerators {
        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            if (event.includeServer()) {
                event.getGenerator().addProvider(new AtomicItemTagsProvider(event));
                event.getGenerator().addProvider(new AtomicBlockTagsProvider(event));
                event.getGenerator().addProvider(new AtomicFluidTagsProvider(event));
                event.getGenerator().addProvider(new AtomicLootTableProvider(event));
                event.getGenerator().addProvider(new AtomicRecipeProvider(event));
            }
        }
    }
}
