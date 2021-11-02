package hantonik.atomiccomponents.registration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemProperties {
    public static final Item.Properties BUCKET_PROPS = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC);

    public static final Item.Properties EGG_PROPS = new Item.Properties().tab(ItemGroup.TAB_MISC);
}
