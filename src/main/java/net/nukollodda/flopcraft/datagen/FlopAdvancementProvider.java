package net.nukollodda.flopcraft.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.entities.FlopEntities;
import net.nukollodda.flopcraft.item.FlopItems;

import java.util.function.Consumer;

public class FlopAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement cvmInfusion = makeAdvancement(consumer, existingFileHelper, FlopBlocks.CVM_INFUSION_ALTER.get().asItem(), "cvm_infusion",
                "textures/item/cvm.png", "has_cvm_infusion",
                InventoryChangeTrigger.TriggerInstance.hasItems(FlopBlocks.CVM_INFUSION_ALTER.get()));
        Advancement cupcakkeDuplication = makeAdvancement(consumer, existingFileHelper, FlopItems.CVMTITPLASM.get(), "cupcakke_duplication",
                "textures/item/cvmtitplasm.png", "did_cupcakke_fission",
                SummonedEntityTrigger.TriggerInstance.summonedEntity(
                        EntityPredicate.Builder.entity().of(FlopEntities.CUPCAKKE.get())));
        Advancement cupcakkeRemixes = makeAdvancement(consumer, existingFileHelper, FlopItems.DISC_C1.get(), "cupcakke_remix",
                "textures/item/disc_c1.png", "has_cupcakke_remix",
                InventoryChangeTrigger.TriggerInstance.hasItems(FlopItems.DISC_C1.get(), FlopItems.DISC_C2.get(),
                        FlopItems.DISC_C3.get(), FlopItems.DISC_C4.get(), FlopItems.DISC_C5.get(), FlopItems.DISC_C6.get(),
                        FlopItems.DISC_C7.get(), FlopItems.DISC_C8.get(), FlopItems.DISC_C9.get(), FlopItems.DISC_C10.get(),
                        FlopItems.DISC_C11.get(), FlopItems.DISC_C12.get(), FlopItems.DISC_C13.get(), FlopItems.DISC_C14.get(),
                        FlopItems.DISC_C15.get(), FlopItems.DISC_C16.get(), FlopItems.DISC_C17.get(), FlopItems.DISC_C18.get(),
                        FlopItems.DISC_C19.get(), FlopItems.DISC_C20.get(), FlopItems.DISC_C21.get(), FlopItems.DISC_C22.get(),
                        FlopItems.DISC_C23.get(), FlopItems.DISC_C24.get(), FlopItems.DISC_C25.get(), FlopItems.DISC_C26.get(),
                        FlopItems.DISC_C27.get(), FlopItems.DISC_C28.get(), FlopItems.DISC_JC1.get(), FlopItems.DISC_JC2.get(), FlopItems.DISC_JC3.get(),
                        FlopItems.DISC_CJ1.get()));
        Advancement fallenWig = makeAdvancement(consumer, existingFileHelper, FlopItems.HAIRUSSY.get(), "fallen_wig",
                "textures/item/hairussy.png", "has_hairussy",
                InventoryChangeTrigger.TriggerInstance.hasItems(FlopItems.HAIRUSSY.get()));
        /*
        Advancement flophood = makeAdvancement(consumer, existingFileHelper, ModItems.INFUSED_SLAGINIUM.get(), "flophood",
                "textures/item/infused_slaginium.png", "has_infused_slaginium",
                PlayerTrigger.TriggerInstance);

        Advancement floptropica = makeAdvancement(consumer, existingFileHelper, ModItems.FLOPTROPICA_TICKET.get(), "floptropica");
        Advancement growJiafei = makeAdvancement(consumer, existingFileHelper, ModBlocks.JIAFEI_SEED.get().asItem(), "grow_jiafei");
        Advancement iconicQueen = makeAdvancement(consumer, existingFileHelper, , "iconic_queen");
        Advancement jiafeiClothing = makeAdvancement(consumer, existingFileHelper, , "jiafei_clothing");
        Advancement jiafeiProducts = makeAdvancement(consumer, existingFileHelper, );
        Advancement jiafeiRemixes = makeAdvancement(consumer, existingFileHelper, );
        Advancement jiafeiTools = makeAdvancement(consumer, existingFileHelper, );
        Advancement magicFlop = makeAdvancement(consumer, existingFileHelper, );
        Advancement meetLovelyPeaches = makeAdvancement(consumer, existingFileHelper, );
        Advancement flopcraft = makeAdvancement(consumer, existingFileHelper, );
        Advancement obtainedCvm = makeAdvancement(consumer, existingFileHelper, );
        Advancement ranpapiRemixes = makeAdvancement(consumer, existingFileHelper, );
        Advancement rosetoy = makeAdvancement(consumer, existingFileHelper, );
        Advancement stillStanding = makeAdvancement(consumer, existingFileHelper, );
        Advancement tamponPower = makeAdvancement(consumer, existingFileHelper, );
        Advancement tealaDunn = makeAdvancement(consumer, existingFileHelper, );
        Advancement trulyMystical = makeAdvancement(consumer, existingFileHelper, );
        Advancement toolSlay = makeAdvancement(consumer, existingFileHelper, );
        Advancement twinkGirlboss = makeAdvancement(consumer, existingFileHelper, );
        Advancement twinkSivan = makeAdvancement(consumer, existingFileHelper, );
        Advancement unthinkable = makeAdvancement(consumer, existingFileHelper, );
        Advancement yassifyAll= makeAdvancement(consumer, existingFileHelper, );
         */
    }

    private static Advancement makeAdvancement(Consumer<Advancement> consumer, ExistingFileHelper fileHelper, Item item,
                                               String name, String framePath, String criterionName,
                                               CriterionTriggerInstance criterionTrigger) {
        return Advancement.Builder.advancement().display(new DisplayInfo(new ItemStack(item),
                        Component.translatable("advancements.flopcraft." + name),
                        Component.translatable("advancements.flopcraft." + name + ".description"),
                        ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, framePath), FrameType.TASK,
                        true, true, false))
                .addCriterion(criterionName, criterionTrigger)
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, Flopcraft.MODID), fileHelper);
    }
}
