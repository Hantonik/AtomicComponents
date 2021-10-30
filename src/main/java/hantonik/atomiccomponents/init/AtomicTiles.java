package hantonik.atomiccomponents.init;

import com.google.common.collect.Lists;
import hantonik.atomiccomponents.AtomicComponents;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.function.Supplier;

public final class AtomicTiles {
    public static final List<Supplier<? extends TileEntityType<?>>> TILES = Lists.newArrayList();

    @SubscribeEvent
    public void onRegisterTiles(RegistryEvent.Register<TileEntityType<?>> event) {
        IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();

        TILES.stream().map(Supplier::get).forEach(registry::register);
    }

    private static <T extends TileEntityType<?>> RegistryObject<T> register(String name, Supplier<TileEntity> tile, Supplier<Block[]> blocks) {
        ResourceLocation location = new ResourceLocation(AtomicComponents.MOD_ID, name);
        TILES.add(() -> TileEntityType.Builder.of(tile, blocks.get()).build(null).setRegistryName(location));

        return RegistryObject.of(location, ForgeRegistries.TILE_ENTITIES);
    }
}
