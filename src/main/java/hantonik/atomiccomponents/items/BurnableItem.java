package hantonik.atomiccomponents.items;

import hantonik.atomiccore.items.BasicItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;

import javax.annotation.Nullable;
import java.util.function.Function;

public class BurnableItem extends BasicItem {
    private final int burnTime;

    public BurnableItem(Function<Properties, Properties> properties, int burnTime) {
        super(properties);

        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
        return this.burnTime;
    }
}
