package hantonik.atomiccomponents.client.model.fluid;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.datafixers.util.Pair;
import hantonik.atomiccomponents.registration.ModelFluidAttributes;
import hantonik.atomiccomponents.utils.ModelHelper;
import lombok.Getter;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
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

    private static boolean isMissing(RenderMaterial material) {
        return MissingTextureSprite.getLocation().equals(material.texture());
    }

    private static void getTexture(IModelConfiguration owner, String name, Collection<RenderMaterial> textures, Set<Pair<String, String>> missingTextureErrors) {
        RenderMaterial material = owner.resolveTexture(name);

        if (isMissing(material))
            missingTextureErrors.add(Pair.of(name, owner.getModelName()));

        textures.add(material);
    }

    @Override
    public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
        Set<RenderMaterial> textures = new HashSet<>();

        getTexture(owner, "still", textures, missingTextureErrors);
        getTexture(owner, "flowing", textures, missingTextureErrors);

        RenderMaterial overlay = owner.resolveTexture("overlay");

        if (!isMissing(overlay))
            textures.add(overlay);

        return textures;
    }

    @Override
    public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
        RenderMaterial still = owner.resolveTexture("still");
        RenderMaterial flowing = owner.resolveTexture("flowing");
        RenderMaterial overlay = owner.resolveTexture("overlay");

        ResourceLocation overlayLocation = isMissing(overlay) ? null : overlay.texture();
        IBakedModel baked = new SimpleBakedModel.Builder(owner, overrides).particle(spriteGetter.apply(still)).build();

        return new BakedModel(baked, still.texture(), flowing.texture(), overlayLocation, this.color);
    }

    private static class BakedModel extends BakedModelWrapper<IBakedModel> {
        @Getter
        private final ResourceLocation still;

        @Getter
        private final ResourceLocation flowing;

        @Getter
        private final ResourceLocation overlay;

        @Getter
        private final int color;

        public BakedModel(IBakedModel originalModel, ResourceLocation still, ResourceLocation flowing, @Nullable ResourceLocation overlay, int color) {
            super(originalModel);

            this.still = still;
            this.flowing = flowing;
            this.overlay = overlay;
            this.color = color;
        }
    }

    private static class Loader implements IModelLoader<FluidTextureModel>, ModelFluidAttributes.IFluidModelProvider {
        private final Map<Fluid, BakedModel> modelCache = new HashMap<>();

        @Nullable
        private BakedModel getFluidModel(Fluid fluid) {
            return ModelHelper.getBakedModel(fluid.defaultFluidState().createLegacyBlock(), BakedModel.class);
        }

        @Nullable
        private BakedModel getCachedModel(Fluid fluid) {
            return this.modelCache.computeIfAbsent(fluid, this::getFluidModel);
        }

        @Override
        @Nullable
        public ResourceLocation getStillTexture(Fluid fluid) {
            BakedModel model = getCachedModel(fluid);
            return model == null ? null : model.still;
        }

        @Override
        @Nullable
        public ResourceLocation getFlowingTexture(Fluid fluid) {
            BakedModel model = getCachedModel(fluid);
            return model == null ? null : model.flowing;
        }

        @Override
        @Nullable
        public ResourceLocation getOverlayTexture(Fluid fluid) {
            BakedModel model = getCachedModel(fluid);
            return model == null ? null : model.overlay;
        }

        @Override
        public int getColor(Fluid fluid) {
            BakedModel model = getCachedModel(fluid);
            return model == null ? -1 : model.color;
        }

        @Override
        public void onResourceManagerReload(IResourceManager resourceManager) {
            this.modelCache.clear();
        }

        @Override
        public FluidTextureModel read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
            int color = -1;

            if (modelContents.has("color")) {
                String colorString = JSONUtils.getAsString(modelContents, "color");
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
