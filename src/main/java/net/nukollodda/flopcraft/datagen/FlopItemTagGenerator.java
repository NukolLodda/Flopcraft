package net.nukollodda.flopcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.datagen.tags.FlopTags;
import net.nukollodda.flopcraft.item.FlopItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class FlopItemTagGenerator extends ItemTagsProvider {
    public FlopItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                                CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Flopcraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(FlopTags.Items.BARBIE_CRYSTALS).add(FlopItems.BARBIE_CRYSTALS.get());
        this.tag(FlopTags.Items.BRAT).add(FlopItems.BRAT.get());
        this.tag(FlopTags.Items.FLOPIUM).add(FlopItems.FLOPIUM.get());
        this.tag(FlopTags.Items.MYSTICAL_FLOPIUM).add(FlopItems.MYSTICAL_FLOPIUM.get());
        this.tag(FlopTags.Items.SHENSEIUM).add(FlopItems.SHENSEIUM.get());
        this.tag(FlopTags.Items.SLAGINIUM_INGOT).add(FlopItems.SLAGINIUM.get());
        this.tag(FlopTags.Items.INFUSED_SLAGINIUM_INGOT).add(FlopItems.INFUSED_SLAGINIUM.get());

        this.tag(ItemTags.ARROWS).add(
                FlopItems.TAMPON.get(),
                FlopItems.BLOODY_TAMPON.get(),
                FlopItems.EXTRA_BLOODY_TAMPON.get()
        );

        this.tag(FlopTags.Items.ULTIMATE_YASSIFER).add(
                FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(FlopTags.Items.ELITE_YASSIFER).add(
                FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(FlopTags.Items.ADVANCED_YASSIFER).add(
                FlopItems.SLAGINIUM_YASSIFIER_PLUS.get(),
                FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(FlopTags.Items.YASSIFER).add(
                FlopItems.SLAGINIUM_YASSIFIER.get(),
                FlopItems.SLAGINIUM_YASSIFIER_PLUS.get(),
                FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get(),
                FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get()
        );

        this.tag(ItemTags.MUSIC_DISCS).add(
                FlopItems.DISC_C1.get(),
                FlopItems.DISC_C2.get(),
                FlopItems.DISC_C3.get(),
                FlopItems.DISC_C4.get(),
                FlopItems.DISC_C5.get(),
                FlopItems.DISC_C6.get(),
                FlopItems.DISC_C7.get(),
                FlopItems.DISC_C8.get(),
                FlopItems.DISC_C9.get(),
                FlopItems.DISC_C10.get(),
                FlopItems.DISC_C11.get(),
                FlopItems.DISC_C12.get(),
                FlopItems.DISC_C13.get(),
                FlopItems.DISC_C14.get(),
                FlopItems.DISC_C15.get(),
                FlopItems.DISC_C16.get(),
                FlopItems.DISC_C17.get(),
                FlopItems.DISC_C18.get(),
                FlopItems.DISC_C20.get(),
                FlopItems.DISC_C19.get(),
                FlopItems.DISC_C21.get(),
                FlopItems.DISC_C22.get(),
                FlopItems.DISC_C23.get(),
                FlopItems.DISC_C24.get(),
                FlopItems.DISC_C25.get(),
                FlopItems.DISC_C26.get(),
                FlopItems.DISC_C27.get(),
                FlopItems.DISC_C28.get(),
                FlopItems.DISC_C29.get(),
                FlopItems.DISC_C30.get(),
                FlopItems.DISC_C31.get(),
                FlopItems.DISC_C32.get(),
                FlopItems.DISC_CJ1.get(),
                FlopItems.DISC_CPM1.get(),
                FlopItems.DISC_CUPCAKKE1.get(),
                FlopItems.DISC_CUPCAKKE2.get(),
                FlopItems.DISC_CUPCAKKE3.get(),
                FlopItems.DISC_CUPCAKKE4.get(),
                FlopItems.DISC_CUPCAKKE5.get(),
                FlopItems.DISC_CUPCAKKE6.get(),
                FlopItems.DISC_DB1.get(),
                FlopItems.DISC_DEJE_BULLYING.get(),
                FlopItems.DISC_J1.get(),
                FlopItems.DISC_J2.get(),
                FlopItems.DISC_J3.get(),
                FlopItems.DISC_J4.get(),
                FlopItems.DISC_J5.get(),
                FlopItems.DISC_J6.get(),
                FlopItems.DISC_J7.get(),
                FlopItems.DISC_JC1.get(),
                FlopItems.DISC_JC2.get(),
                FlopItems.DISC_JC3.get(),
                FlopItems.DISC_JIAFEI.get(),
                FlopItems.DISC_K1.get(),
                FlopItems.DISC_K2.get(),
                FlopItems.DISC_K3.get(),
                FlopItems.DISC_PM1.get(),
                FlopItems.DISC_PONMI.get(),
                FlopItems.DISC_RANVISION.get()
        );

        this.tag(FlopTags.Items.CUPCAKKE_REMIXES).add(
                FlopItems.DISC_C1.get(),
                FlopItems.DISC_C2.get(),
                FlopItems.DISC_C3.get(),
                FlopItems.DISC_C4.get(),
                FlopItems.DISC_C5.get(),
                FlopItems.DISC_C6.get(),
                FlopItems.DISC_C7.get(),
                FlopItems.DISC_C8.get(),
                FlopItems.DISC_C9.get(),
                FlopItems.DISC_C10.get(),
                FlopItems.DISC_C11.get(),
                FlopItems.DISC_C12.get(),
                FlopItems.DISC_C13.get(),
                FlopItems.DISC_C14.get(),
                FlopItems.DISC_C15.get(),
                FlopItems.DISC_C16.get(),
                FlopItems.DISC_C17.get(),
                FlopItems.DISC_C18.get(),
                FlopItems.DISC_C19.get(),
                FlopItems.DISC_C20.get(),
                FlopItems.DISC_C21.get(),
                FlopItems.DISC_C22.get(),
                FlopItems.DISC_C23.get(),
                FlopItems.DISC_C24.get(),
                FlopItems.DISC_C25.get(),
                FlopItems.DISC_C26.get(),
                FlopItems.DISC_C27.get(),
                FlopItems.DISC_C28.get(),
                FlopItems.DISC_C29.get(),
                FlopItems.DISC_C30.get(),
                FlopItems.DISC_C31.get(),
                FlopItems.DISC_C32.get(),
                FlopItems.DISC_JC1.get(),
                FlopItems.DISC_JC2.get(),
                FlopItems.DISC_JC3.get(),
                FlopItems.DISC_CJ1.get()
        );

        this.tag(FlopTags.Items.JIAFEI_REMIXES).add(
                FlopItems.DISC_J1.get(),
                FlopItems.DISC_J2.get(),
                FlopItems.DISC_J3.get(),
                FlopItems.DISC_J4.get(),
                FlopItems.DISC_J5.get(),
                FlopItems.DISC_J6.get(),
                FlopItems.DISC_J7.get(),
                FlopItems.DISC_JC1.get(),
                FlopItems.DISC_JC2.get(),
                FlopItems.DISC_JC3.get(),
                FlopItems.DISC_CJ1.get()
        );

        this.tag(FlopTags.Items.KAMALA_REMIXES).add(
                FlopItems.DISC_K1.get(),
                FlopItems.DISC_K2.get(),
                FlopItems.DISC_K3.get()
        );
        this.tag(FlopTags.Items.TROYE_REMIXES).add(FlopItems.DISC_C29.get(), FlopItems.DISC_J3.get());
        this.tag(ItemTags.TRIM_TEMPLATES).add(FlopItems.JIAFEI_TRIM_TEMPLATE.get());
    }
}
