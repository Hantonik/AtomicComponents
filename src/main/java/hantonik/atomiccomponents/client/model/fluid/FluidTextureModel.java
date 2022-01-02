package hantonik.atomiccomponents.client.model.fluid;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.datafixers.util.Pair;
import hantonik.atomiccomponents.registration.ModelFluidAttributes;
import hantonik.atomiccomponents.utils.helpers.ModelHelper;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class FluidTextureModel implements IModelGeometry<FluidTextureModel> {
    public static Loader LOADER = new Loader();

    private final int color;

    public FluidTextureModel(int color) {
        this.color = color;
    }

    private static boolean isMissing(Material material) {
        return MissingTextureAtlasSprite.getLocation().equals(material.texture());
    }

    private static void getTexture(IModelConfiguration owner, String name, Collection<Material> textures, Set<Pair<String,String>> missingTextureErrors) {
        Material material = owner.resolveTexture(name);

        if (isMissing(material))
            missingTextureErrors.add(Pair.of(name, owner.getModelName()));

        textures.add(material);
    }

    @Override
    public Collection<Material> getTextures(IModelConfiguration owner, Function<ResourceLocation,UnbakedModel> modelGetter, Set<Pair<String,String>> missingTextureErrors) {
        Set<Material> textures = new HashSet<>();

        getTexture(owner, "still", textures, missingTextureErrors);
        getTexture(owner, "flowing", textures, missingTextureErrors);

        Material overlay = owner.resolveTexture("overlay");

        if (!isMissing(overlay))
            textures.add(overlay);

        return textures;
    }

    @Override
    public BakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material,TextureAtlasSprite> spriteGetter, ModelState modelTransform, ItemOverrides overrides, ResourceLocation modelLocation) {
        Material still = owner.resolveTexture("still");
        Material flowing = owner.resolveTexture("flowing");
        Material overlay = owner.resolveTexture("overlay");

        ResourceLocation overlayLocation = isMissing(overlay) ? null : overlay.texture();

        BakedModel baked = new SimpleBakedModel.Builder(owner, overrides).particle(spriteGetter.apply(still)).build();

        return new Baked(baked, still.texture(), flowing.texture(), overlayLocation, this.color);
    }

    private static class Baked extends BakedModelWrapper<BakedModel> {
        private final ResourceLocation still;
        private final ResourceLocation flowing;
        private final ResourceLocation overlay;

        private final int color;

        public Baked(BakedModel originalModel, ResourceLocation still, ResourceLocation flowing, @Nullable ResourceLocation overlay, int color) {
            super(originalModel);

            this.still = still;
            this.flowing = flowing;
            this.overlay = overlay;
            this.color = color;
        }

        public ResourceLocation getStill() {
            return this.still;
        }

        public ResourceLocation getFlowing() {
            return this.flowing;
        }

        public ResourceLocation getOverlay() {
            return this.overlay;
        }

        public int getColor() {
            return this.color;
        }
    }

    private static class Loader implements IModelLoader<FluidTextureModel>, ModelFluidAttributes.IFluidModelProvider {
        private final Map<Fluid,Baked> modelCache = new HashMap<>();

        @Nullable
        private Baked getFluidModel(Fluid fluid) {
            return ModelHelper.getBakedModel(fluid.defaultFluidState().createLegacyBlock(), Baked.class);
        }

        @Nullable
        private Baked getCachedModel(Fluid fluid) {
            return this.modelCache.computeIfAbsent(fluid, this::getFluidModel);
        }

        @Override
        @Nullable
        public ResourceLocation getStillTexture(Fluid fluid) {
            Baked model = getCachedModel(fluid);

            return model == null ? null : model.getStill();
        }

        @Override
        @Nullable
        public ResourceLocation getFlowingTexture(Fluid fluid) {
            Baked model = getCachedModel(fluid);

            return model == null ? null : model.getFlowing();
        }

        @Override
        @Nullable
        public ResourceLocation getOverlayTexture(Fluid fluid) {
            Baked model = getCachedModel(fluid);

            return model == null ? null : model.getOverlay();
        }

        @Override
        public int getColor(Fluid fluid) {
            Baked model = getCachedModel(fluid);

            return model == null ? -1 : model.getColor();
        }

        @Override
        public void onResourceManagerReload(ResourceManager resourceManager) {
            this.modelCache.clear();
        }

        @Override
        public FluidTextureModel read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
            int color = -1;

            if (modelContents.has("color")) {
                String colorString = GsonHelper.getAsString(modelContents, "color");

                int length = colorString.length();

                if (colorString.charAt(0) == '-' || (length != 6 && length != 8))
                    throw new JsonSyntaxException("Invalid color '" + colorString + "'");

                try {
                    color = (int)Long.parseLong(colorString, 16);

                    if (length == 6)
                        color |= 0xFF000000;
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException("Invalid color '" + colorString + "'");
                }
            }

            return new FluidTextureModel(color);
        }
    }
}
