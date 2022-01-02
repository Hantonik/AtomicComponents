package hantonik.atomiccomponents.datagen;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccomponents.init.AtomicFluids;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class AtomicFluidTagsProvider extends FluidTagsProvider {
    public AtomicFluidTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), AtomicComponents.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(AtomicFluids.MOLTEN_TITANIUM.getForgeTag()).add(AtomicFluids.MOLTEN_TITANIUM.get());
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " Fluid Tags";
    }
}
