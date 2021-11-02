package hantonik.atomiccomponents;

import hantonik.atomiccomponents.client.model.fluid.FluidTextureModel;
import hantonik.atomiccomponents.configs.AtomicConfigs;
import hantonik.atomiccomponents.datagen.*;
import hantonik.atomiccomponents.init.AtomicBlocks;
import hantonik.atomiccomponents.init.AtomicFluids;
import hantonik.atomiccomponents.init.AtomicItems;
import hantonik.atomiccomponents.utils.ModelHelper;
import hantonik.atomiccomponents.world.AtomicWorldGenerator;
import hantonik.atomiccore.AtomicCore;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
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

        AtomicFluids.FLUIDS.load(bus);

        AtomicConfigs.setup();
    }

    @SubscribeEvent
    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting common setup");

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new AtomicWorldGenerator());

        event.enqueueWork(AtomicWorldGenerator::setup);

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed common setup");
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting client setup");

        IResourceManager manager = Minecraft.getInstance().getResourceManager();

        if (manager instanceof IReloadableResourceManager)
            ((IReloadableResourceManager) manager).registerReloadListener(ModelHelper.LISTENER);

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed client setup");
    }

    @SubscribeEvent
    public void registerModelLoaders(final ModelRegistryEvent event) {
        LOGGER.debug(AtomicCore.MOD_MARKER, "Starting model registry setup");

        ModelLoaderRegistry.registerLoader(new ResourceLocation(AtomicComponents.MOD_ID, "fluid_texture"), FluidTextureModel.LOADER);

        LOGGER.debug(AtomicCore.MOD_MARKER, "Completed model registry setup");
    }

    public static final ItemGroup ITEMS_GROUP = new ItemGroup(MOD_ID + "_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AtomicItems.TITANIUM_INGOT.get());
        }
    };

    public static final ItemGroup BLOCKS_GROUP = new ItemGroup(MOD_ID + "_blocks") {
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
                event.getGenerator().addProvider(new AtomicBlockTagsProvider(event));
                event.getGenerator().addProvider(new AtomicFluidTagsProvider(event));
                event.getGenerator().addProvider(new AtomicItemTagsProvider(event));
                event.getGenerator().addProvider(new AtomicLootTableProvider(event));
                event.getGenerator().addProvider(new AtomicRecipeProvider(event));
            }
        }
    }
}
