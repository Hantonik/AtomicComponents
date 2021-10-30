package hantonik.atomiccomponents.utils.managers;

import com.google.common.collect.Maps;
import hantonik.atomiccomponents.configs.AtomicConfigs;
import hantonik.atomiccore.utils.helpers.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DynamicResourceManager implements IResourceManagerReloadListener {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        if (!AtomicConfigs.ENABLE_DEFAULT_RECIPES.get()) {
            // TODO
        }
    }

    private static void removeRecipe(ItemStack output, IRecipeType<?> type) {
        RecipeHelper.getRecipes()
                .getOrDefault(type, Maps.newHashMap())
                .values().stream()
                .filter(r -> r.getResultItem().sameItem(output))
                .map(IRecipe::getId)
                .forEach(r -> RecipeHelper.getRecipes().get(type).remove(r));
    }

    @SubscribeEvent
    public void onAddReloadListener(AddReloadListenerEvent event) {
        event.addListener(this);
    }
}
