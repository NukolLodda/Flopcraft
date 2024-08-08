package net.nukollodda.flopcraft.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.ModBlocks;
import net.nukollodda.flopcraft.item.FlopItems;

@Mod.EventBusSubscriber(modid = Flopcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlopCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Flopcraft.MODID);

    public static RegistryObject<CreativeModeTab> PAPI_BLOCKS = CREATIVE_MODE_TABS.register("papi_blocks", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SHENSEIUM_ORE.get()))
                    .title(Component.translatable("itemGroup.papiblocks"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CVM_INFUSION_ALTER.get());
                        pOutput.accept(ModBlocks.BRAT_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BRAT_ORE.get());
                        pOutput.accept(ModBlocks.SHENSEIUM_ORE.get());
                        pOutput.accept(ModBlocks.GIRL_YESS_PUMPKIN.get());
                        pOutput.accept(ModBlocks.MARIAH_CAREY_ICE_BLOCK.get());
                        pOutput.accept(ModBlocks.YASSIFICATION_DETECTOR.get());
                        pOutput.accept(ModBlocks.AESTHETIC_STORE_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOPBUCKS_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOPDONALDS_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOPOTLE_BLOCK.get());
                        pOutput.accept(ModBlocks.JIAFEI_EXPRESS_BLOCK.get());
                        pOutput.accept(ModBlocks.LANCVM_BLOCK.get());
                        pOutput.accept(ModBlocks.RANPAPI_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOP_AIRLINE_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOP_AIRLINE_TICKET_SCANNER.get());
                        pOutput.accept(ModBlocks.BARBIE_LANTERN.get());
                        pOutput.accept(ModBlocks.BRAT_BLOCK.get());
                        pOutput.accept(ModBlocks.FLOPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.GAGASTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.GAGINA_BLOCK.get());
                        pOutput.accept(ModBlocks.INFUSED_SLAGINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SHENSEIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SLAGINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.HARDENED_PERIOD_CVM.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_LOG.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_LEAVES.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_PLANKS.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_STAIRS.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_SLABS.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_BUTTON.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_DOOR.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_FENCE.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LOVELY_PEACH_SAPLING.get());
                        //pOutput.accept(ModBlocks.LOVELY_PEACH_WALL_SIGN.get());
                        //pOutput.accept(ModBlocks.LOVELY_PEACH_WALL_HANGING_SIGN.get());

                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_LOG.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_LEAVES.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_PLANKS.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_STAIRS.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_SLABS.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_BUTTON.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_DOOR.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_FENCE.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.KAMALOCONUT_PALM_SAPLING.get());
                        //pOutput.accept(ModBlocks.KAMALOCONUT_PALM_WALL_SIGN.get());
                        //pOutput.accept(ModBlocks.KAMALOCONUT_PALM_WALL_HANGING_SIGN.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> SLAY_TOOLS = CREATIVE_MODE_TABS.register("slay_tools", () ->
            CreativeModeTab.builder()
                    .icon(() -> FlopItems.ARANA_GRANDE.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.slay_tools"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(FlopItems.ARANA_GRANDE.get());
                        pOutput.accept(FlopItems.BRATIFICATIONER.get());
                        pOutput.accept(FlopItems.CLITMAS_BUTTPLUG.get());
                        pOutput.accept(FlopItems.DEELDO.get());
                        pOutput.accept(FlopItems.ENDER_DRAGON_DEELDO.get());
                        pOutput.accept(FlopItems.ROSETOY.get());
                        pOutput.accept(FlopItems.SLAGINIUM_YASSIFIER.get());
                        pOutput.accept(FlopItems.SLAGINIUM_YASSIFIER_PLUS.get());
                        pOutput.accept(FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get());
                        pOutput.accept(FlopItems.SLAGINIUM_YASSIFIER_DELUXE.get());
                        pOutput.accept(FlopItems.SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(FlopItems.INFUSED_SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(FlopItems.FLOPIUM_PICKAXOL.get());
                        pOutput.accept(FlopItems.KYLIE_JENNER_LIPSTICK.get());
                        pOutput.accept(FlopItems.LANCVM_CREAM.get());
                        pOutput.accept(FlopItems.MYSTICAL_FLOPIUM_PICKAXOL.get());
                        pOutput.accept(FlopItems.JIAFEI_AXE.get());
                        pOutput.accept(FlopItems.JIAFEI_HAMMER.get());
                        pOutput.accept(FlopItems.JIAFEI_SICKLE.get());
                        pOutput.accept(FlopItems.JIAFEI_PICKAXE.get());
                        pOutput.accept(FlopItems.JIAFEI_SHOVEL.get());
                        pOutput.accept(FlopItems.BRA.get());
                        pOutput.accept(FlopItems.THONGS.get());
                        pOutput.accept(FlopItems.JIAFEI_BOOTS.get());
                        pOutput.accept(FlopItems.JIAFEI_LEGGINGS.get());
                        pOutput.accept(FlopItems.JIAFEI_CHESTPLATE.get());
                        pOutput.accept(FlopItems.JIAFEI_HELMET.get());
                        pOutput.accept(FlopItems.RANPAPI_TABLET.get());
                        pOutput.accept(FlopItems.TWINK_TRANSFORMER.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASS_DISCS = CREATIVE_MODE_TABS.register("yass_discs", () ->
            CreativeModeTab.builder()
                    .icon(() -> FlopItems.DISC_C18.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yass_discs"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(FlopItems.DISC_C1.get());
                        pOutput.accept(FlopItems.DISC_C2.get());
                        pOutput.accept(FlopItems.DISC_C3.get());
                        pOutput.accept(FlopItems.DISC_C4.get());
                        pOutput.accept(FlopItems.DISC_C5.get());
                        pOutput.accept(FlopItems.DISC_C6.get());
                        pOutput.accept(FlopItems.DISC_C7.get());
                        pOutput.accept(FlopItems.DISC_C8.get());
                        pOutput.accept(FlopItems.DISC_C9.get());
                        pOutput.accept(FlopItems.DISC_C10.get());
                        pOutput.accept(FlopItems.DISC_C11.get());
                        pOutput.accept(FlopItems.DISC_C12.get());
                        pOutput.accept(FlopItems.DISC_C13.get());
                        pOutput.accept(FlopItems.DISC_C14.get());
                        pOutput.accept(FlopItems.DISC_C15.get());
                        pOutput.accept(FlopItems.DISC_C16.get());
                        pOutput.accept(FlopItems.DISC_C17.get());
                        pOutput.accept(FlopItems.DISC_C18.get());
                        pOutput.accept(FlopItems.DISC_C20.get());
                        pOutput.accept(FlopItems.DISC_C19.get());
                        pOutput.accept(FlopItems.DISC_C21.get());
                        pOutput.accept(FlopItems.DISC_C22.get());
                        pOutput.accept(FlopItems.DISC_C23.get());
                        pOutput.accept(FlopItems.DISC_C24.get());
                        pOutput.accept(FlopItems.DISC_C25.get());
                        pOutput.accept(FlopItems.DISC_C26.get());
                        pOutput.accept(FlopItems.DISC_C27.get());
                        pOutput.accept(FlopItems.DISC_C28.get());
                        pOutput.accept(FlopItems.DISC_C29.get());
                        pOutput.accept(FlopItems.DISC_C30.get());
                        pOutput.accept(FlopItems.DISC_C31.get());
                        pOutput.accept(FlopItems.DISC_C32.get());
                        pOutput.accept(FlopItems.DISC_CJ1.get());
                        pOutput.accept(FlopItems.DISC_CPM1.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE1.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE2.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE3.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE4.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE5.get());
                        pOutput.accept(FlopItems.DISC_CUPCAKKE6.get());
                        pOutput.accept(FlopItems.DISC_DB1.get());
                        pOutput.accept(FlopItems.DISC_DEJE_BULLYING.get());
                        pOutput.accept(FlopItems.DISC_J1.get());
                        pOutput.accept(FlopItems.DISC_J2.get());
                        pOutput.accept(FlopItems.DISC_J3.get());
                        pOutput.accept(FlopItems.DISC_J4.get());
                        pOutput.accept(FlopItems.DISC_J5.get());
                        pOutput.accept(FlopItems.DISC_J6.get());
                        pOutput.accept(FlopItems.DISC_J7.get());
                        pOutput.accept(FlopItems.DISC_JC1.get());
                        pOutput.accept(FlopItems.DISC_JC2.get());
                        pOutput.accept(FlopItems.DISC_JC3.get());
                        pOutput.accept(FlopItems.DISC_JIAFEI.get());
                        pOutput.accept(FlopItems.DISC_K1.get());
                        pOutput.accept(FlopItems.DISC_K2.get());
                        pOutput.accept(FlopItems.DISC_K3.get());
                        pOutput.accept(FlopItems.DISC_PM1.get());
                        pOutput.accept(FlopItems.DISC_PONMI.get());
                        pOutput.accept(FlopItems.DISC_RANVISION.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASSIFYING_INGREDIENTS = CREATIVE_MODE_TABS.register("yassifying_ingredients", () ->
            CreativeModeTab.builder()
                    .icon(() -> FlopItems.CVMTITPLASM.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yassifying_ingredients"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(FlopItems.BARBIE_CRYSTALS.get());
                        pOutput.accept(FlopItems.BLOOD_CLUMP.get());
                        pOutput.accept(FlopItems.BRAT.get());
                        pOutput.accept(FlopItems.BRAT_APPLE.get());
                        pOutput.accept(FlopItems.CUPCAKE.get());
                        pOutput.accept(FlopItems.CVM.get());
                        pOutput.accept(FlopItems.CVMIUM.get());
                        pOutput.accept(FlopItems.CVM_PIE.get());
                        pOutput.accept(FlopItems.CVMTITPLASM.get());
                        pOutput.accept(FlopItems.FLOPIUM.get());
                        pOutput.accept(FlopItems.FLOPTROPICA_TICKET.get());
                        pOutput.accept(FlopItems.GAGASTONE.get());
                        pOutput.accept(FlopItems.GAGINA.get());
                        pOutput.accept(FlopItems.HAIRUSSY.get());
                        pOutput.accept(FlopItems.JIAFEI_PRODUCT.get());
                        pOutput.accept(FlopItems.JIAFEI_PERFUME.get());
                        pOutput.accept(FlopItems.JIAFEI_SEED.get());
                        pOutput.accept(FlopItems.JIAFEI_TRIM_TEMPLATE.get());
                        pOutput.accept(FlopItems.JIAFEI_UPGRADE_TEMPLATE.get());
                        pOutput.accept(FlopItems.LOVELY_PEACH.get());
                        pOutput.accept(FlopItems.KAMALOCONUT.get());
                        pOutput.accept(FlopItems.MYSTICAL_FLOPIUM.get());
                        pOutput.accept(FlopItems.SCARUSSY.get());
                        pOutput.accept(FlopItems.SLAGINIUM.get());
                        pOutput.accept(FlopItems.INFUSED_SLAGINIUM.get());
                        pOutput.accept(FlopItems.POSEI.get());
                        pOutput.accept(FlopItems.SHENSEIUM.get());
                        pOutput.accept(FlopItems.BLOODY_TAMPON.get());
                        pOutput.accept(FlopItems.EXTRA_BLOODY_TAMPON.get());
                        pOutput.accept(FlopItems.TAMPON.get());
                        pOutput.accept(FlopItems.TWINK_EGG.get());
                        pOutput.accept(FlopItems.TWINK_EGG_SHELLS.get());
                        pOutput.accept(FlopItems.TWINK_EGG_PILE.get());
                        pOutput.accept(FlopItems.WONYOUNG_ESSENCE.get());
                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
