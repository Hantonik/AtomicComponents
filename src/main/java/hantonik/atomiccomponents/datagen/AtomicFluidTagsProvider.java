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
        this.tag(AtomicFluids.MOLTEN_LEAD.getLocalTag()).add(AtomicFluids.MOLTEN_LEAD.get(), AtomicFluids.MOLTEN_LEAD.getFlowing());
        this.tag(AtomicFluids.MOLTEN_LEAD.getForgeTag()).addTag(AtomicFluids.MOLTEN_LEAD.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_TITANIUM.getLocalTag()).add(AtomicFluids.MOLTEN_TITANIUM.get(), AtomicFluids.MOLTEN_TITANIUM.getFlowing());
        this.tag(AtomicFluids.MOLTEN_TITANIUM.getForgeTag()).addTag(AtomicFluids.MOLTEN_TITANIUM.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_TIN.getLocalTag()).add(AtomicFluids.MOLTEN_TIN.get(), AtomicFluids.MOLTEN_TIN.getFlowing());
        this.tag(AtomicFluids.MOLTEN_TIN.getForgeTag()).addTag(AtomicFluids.MOLTEN_TIN.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_SILVER.getLocalTag()).add(AtomicFluids.MOLTEN_SILVER.get(), AtomicFluids.MOLTEN_SILVER.getFlowing());
        this.tag(AtomicFluids.MOLTEN_SILVER.getForgeTag()).addTag(AtomicFluids.MOLTEN_SILVER.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_BRONZE.getLocalTag()).add(AtomicFluids.MOLTEN_BRONZE.get(), AtomicFluids.MOLTEN_BRONZE.getFlowing());
        this.tag(AtomicFluids.MOLTEN_BRONZE.getForgeTag()).addTag(AtomicFluids.MOLTEN_BRONZE.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_STEEL.getLocalTag()).add(AtomicFluids.MOLTEN_STEEL.get(), AtomicFluids.MOLTEN_STEEL.getFlowing());
        this.tag(AtomicFluids.MOLTEN_STEEL.getForgeTag()).addTag(AtomicFluids.MOLTEN_STEEL.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_COPPER.getLocalTag()).add(AtomicFluids.MOLTEN_COPPER.get(), AtomicFluids.MOLTEN_COPPER.getFlowing());
        this.tag(AtomicFluids.MOLTEN_COPPER.getForgeTag()).addTag(AtomicFluids.MOLTEN_COPPER.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_IRON.getLocalTag()).add(AtomicFluids.MOLTEN_IRON.get(), AtomicFluids.MOLTEN_IRON.getFlowing());
        this.tag(AtomicFluids.MOLTEN_IRON.getForgeTag()).addTag(AtomicFluids.MOLTEN_IRON.getLocalTag());

        this.tag(AtomicFluids.MOLTEN_GOLD.getLocalTag()).add(AtomicFluids.MOLTEN_GOLD.get(), AtomicFluids.MOLTEN_GOLD.getFlowing());
        this.tag(AtomicFluids.MOLTEN_GOLD.getForgeTag()).addTag(AtomicFluids.MOLTEN_GOLD.getLocalTag());
    }

    @Override
    public String getName() {
        return AtomicComponents.MOD_NAME + " Fluid Tags";
    }
}
