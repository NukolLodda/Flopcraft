package slay.nukolussy.modussy.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.datagen.tags.ModTags;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
        Advancement cvmInfusion = makeAdvancement(consumer, existingFileHelper, ModBlocks.CVM_INFUSION_ALTER.get().asItem(), "cvm_infusion",
                "textures/item/cvm.png", "has_cvm_infusion",
                InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.CVM_INFUSION_ALTER.get()));
        Advancement cupcakkeDuplication = makeAdvancement(consumer, existingFileHelper, ModItems.CVMTITPLASM.get(), "cupcakke_duplication",
                "textures/item/cvmtitplasm.png", "did_cupcakke_fission",
                SummonedEntityTrigger.TriggerInstance.summonedEntity(
                        EntityPredicate.Builder.entity().of(ModEntities.CUPCAKKE.get())));
        Advancement cupcakkeRemixes = makeAdvancement(consumer, existingFileHelper, ModItems.DISC_C1.get(), "cupcakke_remix",
                "textures/item/disc_c1.png", "has_cupcakke_remix",
                InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DISC_C1.get(), ModItems.DISC_C2.get(),
                        ModItems.DISC_C3.get(), ModItems.DISC_C4.get(), ModItems.DISC_C5.get(), ModItems.DISC_C6.get(),
                        ModItems.DISC_C7.get(), ModItems.DISC_C8.get(), ModItems.DISC_C9.get(), ModItems.DISC_C10.get(),
                        ModItems.DISC_C11.get(), ModItems.DISC_C12.get(), ModItems.DISC_C13.get(), ModItems.DISC_C14.get(),
                        ModItems.DISC_C15.get(), ModItems.DISC_C16.get(), ModItems.DISC_C17.get(), ModItems.DISC_C18.get(),
                        ModItems.DISC_C19.get(), ModItems.DISC_C20.get(), ModItems.DISC_C21.get(), ModItems.DISC_C22.get(),
                        ModItems.DISC_C23.get(), ModItems.DISC_C24.get(), ModItems.DISC_C25.get(), ModItems.DISC_C26.get(),
                        ModItems.DISC_C27.get(), ModItems.DISC_JC1.get(), ModItems.DISC_JC2.get(), ModItems.DISC_JC3.get(),
                        ModItems.DISC_CJ1.get()));
        Advancement fallenWig = makeAdvancement(consumer, existingFileHelper, ModItems.HAIRUSSY.get(), "fallen_wig",
                "textures/item/hairussy.png", "has_hairussy",
                InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HAIRUSSY.get()));
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
        Advancement modussy = makeAdvancement(consumer, existingFileHelper, );
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
                        Component.translatable("advancements.modussy." + name),
                        Component.translatable("advancements.modussy." + name + ".description"),
                        new ResourceLocation(Modussy.MODID, framePath), FrameType.TASK,
                        true, true, false))
                .addCriterion(criterionName, criterionTrigger)
                .save(consumer, new ResourceLocation(Modussy.MODID, Modussy.MODID), fileHelper);
    }
}
