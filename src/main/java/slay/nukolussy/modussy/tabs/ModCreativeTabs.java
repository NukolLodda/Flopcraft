package slay.nukolussy.modussy.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.ModItems;

@Mod.EventBusSubscriber(modid = Modussy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Modussy.MODID);

    public static RegistryObject<CreativeModeTab> PAPI_BLOCKS = CREATIVE_MODE_TABS.register("papi_blocks", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SHENSEIUM_ORE.get()))
                    .title(Component.translatable("itemGroup.papiblocks"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CVM_INFUSION_ALTER.get());
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
                        pOutput.accept(ModBlocks.FLOPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.GAGASTONE_BLOCK.get());
                        pOutput.accept(ModBlocks.GAGINA_BLOCK.get());
                        pOutput.accept(ModBlocks.INFUSED_SLAGINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SHENSEIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SLAGINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SHENSEIUM_ORE.get());
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
                    })).build());

    public static RegistryObject<CreativeModeTab> SLAY_TOOLS = CREATIVE_MODE_TABS.register("slay_tools", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItems.ARANA_GRANDE.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.slay_tools"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ARANA_GRANDE.get());
                        pOutput.accept(ModItems.CLITMAS_BUTTPLUG.get());
                        pOutput.accept(ModItems.DEELDO.get());
                        pOutput.accept(ModItems.ROSETOY.get());
                        pOutput.accept(ModItems.SLAGINIUM_YASSIFIER.get());
                        pOutput.accept(ModItems.SLAGINIUM_YASSIFIER_PLUS.get());
                        pOutput.accept(ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get());
                        pOutput.accept(ModItems.SLAGINIUM_YASSIFIER_DELUXE.get());
                        pOutput.accept(ModItems.SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(ModItems.INFUSED_SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(ModItems.FLOPIUM_PICKAXOL.get());
                        pOutput.accept(ModItems.KYLIE_JENNER_LIPSTICK.get());
                        pOutput.accept(ModItems.LANCVM_CREAM.get());
                        pOutput.accept(ModItems.MYSTICAL_FLOPIUM_PICKAXOL.get());
                        pOutput.accept(ModItems.JIAFEI_AXE.get());
                        pOutput.accept(ModItems.JIAFEI_HAMMER.get());
                        pOutput.accept(ModItems.JIAFEI_SICKLE.get());
                        pOutput.accept(ModItems.JIAFEI_PICKAXE.get());
                        pOutput.accept(ModItems.JIAFEI_SHOVEL.get());
                        pOutput.accept(ModItems.BRA.get());
                        pOutput.accept(ModItems.THONGS.get());
                        pOutput.accept(ModItems.JIAFEI_BOOTS.get());
                        pOutput.accept(ModItems.JIAFEI_LEGGINGS.get());
                        pOutput.accept(ModItems.JIAFEI_CHESTPLATE.get());
                        pOutput.accept(ModItems.JIAFEI_HELMET.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASS_DISCS = CREATIVE_MODE_TABS.register("yass_discs", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItems.DISC_C18.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yass_discs"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DISC_C1.get());
                        pOutput.accept(ModItems.DISC_C2.get());
                        pOutput.accept(ModItems.DISC_C3.get());
                        pOutput.accept(ModItems.DISC_C4.get());
                        pOutput.accept(ModItems.DISC_C5.get());
                        pOutput.accept(ModItems.DISC_C6.get());
                        pOutput.accept(ModItems.DISC_C7.get());
                        pOutput.accept(ModItems.DISC_C8.get());
                        pOutput.accept(ModItems.DISC_C9.get());
                        pOutput.accept(ModItems.DISC_C10.get());
                        pOutput.accept(ModItems.DISC_C11.get());
                        pOutput.accept(ModItems.DISC_C12.get());
                        pOutput.accept(ModItems.DISC_C13.get());
                        pOutput.accept(ModItems.DISC_C14.get());
                        pOutput.accept(ModItems.DISC_C15.get());
                        pOutput.accept(ModItems.DISC_C16.get());
                        pOutput.accept(ModItems.DISC_C17.get());
                        pOutput.accept(ModItems.DISC_C18.get());
                        pOutput.accept(ModItems.DISC_C20.get());
                        pOutput.accept(ModItems.DISC_C19.get());
                        pOutput.accept(ModItems.DISC_C21.get());
                        pOutput.accept(ModItems.DISC_C22.get());
                        pOutput.accept(ModItems.DISC_C23.get());
                        pOutput.accept(ModItems.DISC_C24.get());
                        pOutput.accept(ModItems.DISC_C25.get());
                        pOutput.accept(ModItems.DISC_C26.get());
                        pOutput.accept(ModItems.DISC_C27.get());
                        pOutput.accept(ModItems.DISC_CJ1.get());
                        pOutput.accept(ModItems.DISC_CPM1.get());
                        pOutput.accept(ModItems.DISC_CUPCAKKE1.get());
                        pOutput.accept(ModItems.DISC_CUPCAKKE2.get());
                        pOutput.accept(ModItems.DISC_CUPCAKKE3.get());
                        pOutput.accept(ModItems.DISC_CUPCAKKE4.get());
                        pOutput.accept(ModItems.DISC_DB1.get());
                        pOutput.accept(ModItems.DISC_DEJE_BULLYING.get());
                        pOutput.accept(ModItems.DISC_J1.get());
                        pOutput.accept(ModItems.DISC_J2.get());
                        pOutput.accept(ModItems.DISC_J3.get());
                        pOutput.accept(ModItems.DISC_J4.get());
                        pOutput.accept(ModItems.DISC_J5.get());
                        pOutput.accept(ModItems.DISC_JC1.get());
                        pOutput.accept(ModItems.DISC_JC2.get());
                        pOutput.accept(ModItems.DISC_JC3.get());
                        pOutput.accept(ModItems.DISC_JIAFEI.get());
                        pOutput.accept(ModItems.DISC_PM1.get());
                        pOutput.accept(ModItems.DISC_PONMI.get());
                        pOutput.accept(ModItems.DISC_RANVISION.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASSIFYING_INGREDIENTS = CREATIVE_MODE_TABS.register("yassifying_ingredients", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItems.CVMTITPLASM.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yassifying_ingredients"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BARBIE_CRYSTALS.get());
                        pOutput.accept(ModItems.BLOOD_CLUMP.get());
                        pOutput.accept(ModItems.CUPCAKE.get());
                        pOutput.accept(ModItems.CVM.get());
                        pOutput.accept(ModItems.CVMIUM.get());
                        pOutput.accept(ModItems.CVMTITPLASM.get());
                        pOutput.accept(ModItems.FLOPIUM.get());
                        pOutput.accept(ModItems.FLOPTROPICA_TICKET.get());
                        pOutput.accept(ModItems.GAGASTONE.get());
                        pOutput.accept(ModItems.GAGINA.get());
                        pOutput.accept(ModItems.HAIRUSSY.get());
                        pOutput.accept(ModItems.JIAFEI_PRODUCT.get());
                        pOutput.accept(ModItems.JIAFEI_PERFUME.get());
                        pOutput.accept(ModItems.JIAFEI_SEED.get());
                        pOutput.accept(ModItems.JIAFEI_TRIM_TEMPLATE.get());
                        pOutput.accept(ModItems.JIAFEI_UPGRADE_TEMPLATE.get());
                        pOutput.accept(ModItems.LOVELY_PEACH.get());
                        pOutput.accept(ModItems.MYSTICAL_FLOPIUM.get());
                        pOutput.accept(ModItems.SCARUSSY.get());
                        pOutput.accept(ModItems.SLAGINIUM.get());
                        pOutput.accept(ModItems.INFUSED_SLAGINIUM.get());
                        pOutput.accept(ModItems.POSEI.get());
                        pOutput.accept(ModItems.SHENSEIUM.get());
                        pOutput.accept(ModItems.BLOODY_TAMPON.get());
                        pOutput.accept(ModItems.EXTRA_BLOODY_TAMPON.get());
                        pOutput.accept(ModItems.TAMPON.get());
                        pOutput.accept(ModItems.TWINK_EGG.get());
                        pOutput.accept(ModItems.TWINK_EGG_SHELLS.get());
                        pOutput.accept(ModItems.WONYOUNG_ESSENCE.get());
                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
