package hantonik.atomiccomponents;

import hantonik.atomiccomponents.configs.AtomicConfigs;
import hantonik.atomiccomponents.datagen.AtomicBlockTagsProvider;
import hantonik.atomiccomponents.datagen.AtomicItemTagsProvider;
import hantonik.atomiccomponents.datagen.AtomicLootTableProvider;
import hantonik.atomiccomponents.datagen.AtomicRecipeProvider;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicItems;
import hantonik.atomiccomponents.init.AtomicTiles;
import hantonik.atomiccomponents.utils.managers.DynamicResourceManager;
import hantonik.atomiccomponents.world.AtomicWorldGenerator;
import hantonik.atomiccore.AtomicCore;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

@Mod(AtomicComponents.MOD_ID)
public final class AtomicComponents {
    public static final String MOD_ID = "atomiccomponents";
    public static final String MOD_NAME = "AtomicComponents";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static final Marker CONFIG_MARKER = new MarkerManager.Log4jMarker("CONFIG");

    public AtomicComponents() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);

        bus.register(new AtomicBlocks());
        bus.register(new AtomicItems());
        bus.register(new AtomicTiles());

        AtomicConfigs.setup();
    }

    @SubscribeEvent
    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting common setup");

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new AtomicWorldGenerator());
        MinecraftForge.EVENT_BUS.register(new DynamicResourceManager());

        event.enqueueWork(AtomicWorldGenerator::setup);

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed common setup");
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting client setup");

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed client setup");
    }

    public static final ItemGroup MATERIALS_GROUP = new ItemGroup(MOD_ID + "_materials") {
        @Override
        public ItemStack makeIcon() {
            return ItemStack.EMPTY;
        }
    };

    @EventBusSubscriber(modid = MOD_ID, bus = Bus.MOD)
    public static class DataGenerators {
        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            if (event.includeServer()) {
                event.getGenerator().addProvider(new AtomicBlockTagsProvider(event));
                event.getGenerator().addProvider(new AtomicItemTagsProvider(event));
                event.getGenerator().addProvider(new AtomicLootTableProvider(event));
                event.getGenerator().addProvider(new AtomicRecipeProvider(event));
            }
        }
    }
}
