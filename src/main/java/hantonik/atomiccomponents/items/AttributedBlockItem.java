package hantonik.atomiccomponents.items;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.registration.object.FluidObject;
import hantonik.atomiccore.utils.Localizable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class AttributedBlockItem extends BlockItem implements IAttributed {
    @Nullable
    private final FluidObject<? extends Fluid> melted;
    private final int meltingTemperature;
    private final int burningTemperature;
    private final boolean burnable;
    private final boolean fusible;

    public AttributedBlockItem(Block block, Properties properties, AttributedItem.Attributes attributes) {
        super(block, properties);

        this.meltingTemperature = attributes.meltingTemperature;
        this.burningTemperature = attributes.burningTemperature;
        this.burnable = attributes.burnable;
        this.fusible = attributes.fusible;
        this.melted = attributes.melted;
    }

    public AttributedBlockItem(Block block, Properties properties) {
        this(block, properties, AttributedItem.Attributes.create());
    }

    public AttributedBlockItem(Block block, Function<Properties, Properties> properties, Function<AttributedItem.Attributes, AttributedItem.Attributes> attributes) {
        this(block, properties.apply(new Properties()), attributes.apply(AttributedItem.Attributes.create()));
    }

    public AttributedBlockItem(Block block, Function<Properties, Properties> properties) {
        this(block, properties.apply(new Properties()), AttributedItem.Attributes.create());
    }

    @Override
    public FluidObject<? extends Fluid> getMelted() {
        return this.melted;
    }

    @Override
    public int getMeltingTemperature() {
        return this.meltingTemperature;
    }

    @Override
    public int getBurningTemperature() {
        return this.burningTemperature;
    }

    @Override
    public boolean isBurnable() {
        return this.burnable;
    }

    @Override
    public boolean isFusible() {
        return this.fusible;
    }

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag tag = stack.getTag();

        if (!tag.contains("MeltingTemperature"))
            tag.putInt("MeltingTemperature", this.meltingTemperature);
        else {
            tag.remove("MeltingTemperature");
            tag.putInt("MeltingTemperature", this.meltingTemperature);
        }

        if (!tag.contains("BurningTemperature"))
            tag.putInt("BurningTemperature", this.burningTemperature);
        else {
            tag.remove("BurningTemperature");
            tag.putInt("BurningTemperature", this.burningTemperature);
        }

        if (!tag.contains("Burnable"))
            tag.putBoolean("Burnable", this.burnable);
        else {
            tag.remove("Burnable");
            tag.putBoolean("Burnable", this.burnable);
        }

        if (!tag.contains("Fusible"))
            tag.putBoolean("Fusible", this.fusible);
        else {
            tag.remove("Fusible");
            tag.putBoolean("Fusible", this.fusible);
        }

        if (!tag.contains("MeltedFluid"))
            tag.putString("MeltedFluid", this.melted.get().getRegistryName().toString());
        else {
            tag.remove("MeltedFluid");
            tag.putString("MeltedFluid", this.melted.get().getRegistryName().toString());
        }

        return tag;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        Component holdComponent = Localizable.of("attributes." + AtomicComponents.MOD_ID + ".hold_for_info").args(new TextComponent("SHIFT").withStyle(ChatFormatting.GREEN)).build().withStyle(ChatFormatting.GRAY);

        Component meltingTemperatureComponent = new TextComponent(Localizable.of("attributes." + AtomicComponents.MOD_ID + ".melting_temperature").buildString() + ": ").withStyle(ChatFormatting.GRAY).append(new TextComponent(this.meltingTemperature + "K").withStyle(ChatFormatting.BLUE));
        Component burningTemperatureComponent = new TextComponent(Localizable.of("attributes." + AtomicComponents.MOD_ID + ".burning_temperature").buildString() + ": ").withStyle(ChatFormatting.GRAY).append(new TextComponent(this.burningTemperature + "K").withStyle(ChatFormatting.RED));

        if (!Screen.hasShiftDown()) {
            if (this.fusible)
                components.remove(meltingTemperatureComponent);

            if (this.burnable)
                components.remove(burningTemperatureComponent);

            components.add(holdComponent);
        } else {
            components.remove(holdComponent);

            if (this.fusible)
                components.add(meltingTemperatureComponent);

            if (this.burnable)
                components.add(burningTemperatureComponent);
        }

        super.appendHoverText(stack, level, components, flag);
    }
}
