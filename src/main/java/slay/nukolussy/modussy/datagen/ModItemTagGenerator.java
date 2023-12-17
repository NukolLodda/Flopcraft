package slay.nukolussy.modussy.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.datagen.tags.ModTags;
import slay.nukolussy.modussy.item.ModItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Modussy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.BARBIE_CRYSTALS).add(ModItems.BARBIE_CRYSTALS.get());
        this.tag(ModTags.Items.FLOPIUM).add(ModItems.FLOPIUM.get());
        this.tag(ModTags.Items.MYSTICAL_FLOPIUM).add(ModItems.MYSTICAL_FLOPIUM.get());
        this.tag(ModTags.Items.SHENSEIUM).add(ModItems.SHENSEIUM.get());
        this.tag(ModTags.Items.SLAGINIUM_INGOT).add(ModItems.SLAGINIUM.get());
        this.tag(ModTags.Items.INFUSED_SLAGINIUM_INGOT).add(ModItems.INFUSED_SLAGINIUM.get());

        this.tag(ItemTags.ARROWS).add(
                ModItems.TAMPON.get(),
                ModItems.BLOODY_TAMPON.get(),
                ModItems.EXTRA_BLOODY_TAMPON.get()
        );

        this.tag(ModTags.Items.ULTIMATE_YASSIFER).add(
                ModItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(ModTags.Items.ELITE_YASSIFER).add(
                ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                ModItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(ModTags.Items.ADVANCED_YASSIFER).add(
                ModItems.SLAGINIUM_YASSIFIER_PLUS.get(),
                ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                ModItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(ModTags.Items.YASSIFER).add(
                ModItems.SLAGINIUM_YASSIFIER.get(),
                ModItems.SLAGINIUM_YASSIFIER_PLUS.get(),
                ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                ModItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(ItemTags.MUSIC_DISCS).add(
                ModItems.DISC_C1.get(),
                ModItems.DISC_C2.get(),
                ModItems.DISC_C3.get(),
                ModItems.DISC_C4.get(),
                ModItems.DISC_C5.get(),
                ModItems.DISC_C6.get(),
                ModItems.DISC_C7.get(),
                ModItems.DISC_C8.get(),
                ModItems.DISC_C9.get(),
                ModItems.DISC_C10.get(),
                ModItems.DISC_C11.get(),
                ModItems.DISC_C12.get(),
                ModItems.DISC_C13.get(),
                ModItems.DISC_C14.get(),
                ModItems.DISC_C15.get(),
                ModItems.DISC_C16.get(),
                ModItems.DISC_C17.get(),
                ModItems.DISC_C18.get(),
                ModItems.DISC_C20.get(),
                ModItems.DISC_C19.get(),
                ModItems.DISC_C21.get(),
                ModItems.DISC_C22.get(),
                ModItems.DISC_C23.get(),
                ModItems.DISC_C24.get(),
                ModItems.DISC_C25.get(),
                ModItems.DISC_C26.get(),
                ModItems.DISC_C27.get(),
                ModItems.DISC_CJ1.get(),
                ModItems.DISC_CPM1.get(),
                ModItems.DISC_CUPCAKKE1.get(),
                ModItems.DISC_CUPCAKKE2.get(),
                ModItems.DISC_CUPCAKKE3.get(),
                ModItems.DISC_CUPCAKKE4.get(),
                ModItems.DISC_DB1.get(),
                ModItems.DISC_DEJE_BULLYING.get(),
                ModItems.DISC_J1.get(),
                ModItems.DISC_J2.get(),
                ModItems.DISC_J3.get(),
                ModItems.DISC_J4.get(),
                ModItems.DISC_J5.get(),
                ModItems.DISC_JC1.get(),
                ModItems.DISC_JC2.get(),
                ModItems.DISC_JC3.get(),
                ModItems.DISC_JIAFEI.get(),
                ModItems.DISC_PM1.get(),
                ModItems.DISC_PONMI.get(),
                ModItems.DISC_RANVISION.get()
        );

        this.tag(ModTags.Items.CUPCAKKE_REMIXES).add(
                ModItems.DISC_C1.get(),
                ModItems.DISC_C2.get(),
                ModItems.DISC_C3.get(),
                ModItems.DISC_C4.get(),
                ModItems.DISC_C5.get(),
                ModItems.DISC_C6.get(),
                ModItems.DISC_C7.get(),
                ModItems.DISC_C8.get(),
                ModItems.DISC_C9.get(),
                ModItems.DISC_C10.get(),
                ModItems.DISC_C11.get(),
                ModItems.DISC_C12.get(),
                ModItems.DISC_C13.get(),
                ModItems.DISC_C14.get(),
                ModItems.DISC_C15.get(),
                ModItems.DISC_C16.get(),
                ModItems.DISC_C17.get(),
                ModItems.DISC_C18.get(),
                ModItems.DISC_C19.get(),
                ModItems.DISC_C20.get(),
                ModItems.DISC_C21.get(),
                ModItems.DISC_C22.get(),
                ModItems.DISC_C23.get(),
                ModItems.DISC_C24.get(),
                ModItems.DISC_C25.get(),
                ModItems.DISC_C26.get(),
                ModItems.DISC_C27.get(),
                ModItems.DISC_JC1.get(),
                ModItems.DISC_JC2.get(),
                ModItems.DISC_JC3.get(),
                ModItems.DISC_CJ1.get()
        );

        this.tag(ModTags.Items.JIAFEI_REMIXES).add(
                ModItems.DISC_J1.get(),
                ModItems.DISC_J2.get(),
                ModItems.DISC_J3.get(),
                ModItems.DISC_J4.get(),
                ModItems.DISC_J5.get(),
                ModItems.DISC_JC1.get(),
                ModItems.DISC_JC2.get(),
                ModItems.DISC_JC3.get(),
                ModItems.DISC_CJ1.get()
        );

        this.tag(ItemTags.TRIM_TEMPLATES).add(ModItems.JIAFEI_TRIM_TEMPLATE.get());
    }
}
