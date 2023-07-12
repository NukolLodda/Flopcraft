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
import slay.nukolussy.modussy.item.ModItem;

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
                        pOutput.accept(ModBlocks.SHENSEIUM_ORE.get());
                        pOutput.accept(ModBlocks.CVM_INFUSION_ALTER.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> CVMSUMABLES = CREATIVE_MODE_TABS.register("cvmsumables", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItem.CUPCAKE.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.cvmsumables"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.CUPCAKE.get());
                        pOutput.accept(ModItem.CVM.get());
                        pOutput.accept(ModItem.CVMIUM.get());
                        pOutput.accept(ModItem.JIAFEI_PRODUCT.get());
                        pOutput.accept(ModItem.JIAFEI_PERFUME.get());
                        pOutput.accept(ModItem.JIAFEI_SEED.get());
                        pOutput.accept(ModItem.FLOPTROPICA_TICKET.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> SLAY_TOOLS = CREATIVE_MODE_TABS.register("slay_tools", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItem.ARANA_GRANDE.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.slay_tools"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.SLAGINIUM_YASSIFIER.get());
                        pOutput.accept(ModItem.SLAGINIUM_YASSIFIER_PLUS.get());
                        pOutput.accept(ModItem.SLAGINIUM_YASSIFIER_PREMIUM.get());
                        pOutput.accept(ModItem.SLAGINIUM_YASSIFIER_DELUXE.get());
                        pOutput.accept(ModItem.SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(ModItem.INFUSED_SLAGINIUM_PICKAXOL.get());
                        pOutput.accept(ModItem.FLOPIUM_PICKAXOL.get());
                        pOutput.accept(ModItem.MYSTICAL_FLOPIUM_PICKAXOL.get());
                        pOutput.accept(ModItem.ARANA_GRANDE.get());
                        pOutput.accept(ModItem.JIAFEI_AXE.get());
                        pOutput.accept(ModItem.JIAFEI_HAMMER.get());
                        pOutput.accept(ModItem.JIAFEI_SICKLE.get());
                        pOutput.accept(ModItem.JIAFEI_PICKAXE.get());
                        pOutput.accept(ModItem.JIAFEI_SHOVEL.get());
                        pOutput.accept(ModItem.JIAFEI_BOOTS.get());
                        pOutput.accept(ModItem.JIAFEI_LEGGINGS.get());
                        pOutput.accept(ModItem.JIAFEI_CHESTPLATE.get());
                        pOutput.accept(ModItem.JIAFEI_HELMET.get());
                        pOutput.accept(ModItem.DEELDO.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASS_DISCS = CREATIVE_MODE_TABS.register("yass_discs", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItem.SEE_TINH.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yass_discs"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.AFTER_LIKE.get());
                        pOutput.accept(ModItem.BACK_BEAT.get());
                        pOutput.accept(ModItem.BAD_ROMANCE.get());
                        pOutput.accept(ModItem.BAD_HOEMANCE.get());
                        pOutput.accept(ModItem.BOLLYWOOD.get());
                        pOutput.accept(ModItem.CPR.get());
                        pOutput.accept(ModItem.CUPID.get());
                        pOutput.accept(ModItem.DEEPTHROAT.get());
                        pOutput.accept(ModItem.DEJE_BULLYING.get());
                        pOutput.accept(ModItem.DRIVERS.get());
                        pOutput.accept(ModItem.GET_INTO.get());
                        pOutput.accept(ModItem.GIMME_MORE.get());
                        pOutput.accept(ModItem.GOD_WOMAN.get());
                        pOutput.accept(ModItem.HALLO_AUS.get());
                        pOutput.accept(ModItem.HIP_DONT.get());
                        pOutput.accept(ModItem.I_AM.get());
                        pOutput.accept(ModItem.IEVEN_POLKKA.get());
                        pOutput.accept(ModItem.INTO_YOU.get());
                        pOutput.accept(ModItem.JIAFEI.get());
                        pOutput.accept(ModItem.JIAFEI_REMIX.get());
                        pOutput.accept(ModItem.METRO.get());
                        pOutput.accept(ModItem.MISERY.get());
                        pOutput.accept(ModItem.NEED_DOCTOR.get());
                        pOutput.accept(ModItem.PINK_VENOM.get());
                        pOutput.accept(ModItem.POKER_FACE.get());
                        pOutput.accept(ModItem.PON_MI.get());
                        pOutput.accept(ModItem.POP.get());
                        pOutput.accept(ModItem.RESONANCE.get());
                        pOutput.accept(ModItem.ROUND_LIFE.get());
                        pOutput.accept(ModItem.SAY_SO.get());
                        pOutput.accept(ModItem.SEKALALI.get());
                        pOutput.accept(ModItem.SEE_TINH.get());
                        pOutput.accept(ModItem.SSERAFIM.get());
                        pOutput.accept(ModItem.SOLO.get());
                        pOutput.accept(ModItem.TELEPHONE.get());
                        pOutput.accept(ModItem.TITANIC.get());
                        pOutput.accept(ModItem.TUKAH_TAKA.get());
                        pOutput.accept(ModItem.VAGINA.get());
                        pOutput.accept(ModItem.WEDNESDAY.get());
                        pOutput.accept(ModItem.WHAM.get());
                    })).build());

    public static RegistryObject<CreativeModeTab> YASSIFYING_INGREDIENTS = CREATIVE_MODE_TABS.register("yassifying_ingredients", () ->
            CreativeModeTab.builder()
                    .icon(() -> ModItem.CVMTITPLASM.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.yassifying_ingredients"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.CVMTITPLASM.get());
                        pOutput.accept(ModItem.FLOPIUM.get());
                        pOutput.accept(ModItem.GAGASTONE.get());
                        pOutput.accept(ModItem.GAGINA.get());
                        pOutput.accept(ModItem.HAIRUSSY.get());
                        pOutput.accept(ModItem.MYSTICAL_FLOPIUM.get());
                        pOutput.accept(ModItem.SCARUSSY.get());
                        pOutput.accept(ModItem.SLAGINIUM.get());
                        pOutput.accept(ModItem.INFUSED_SLAGINIUM.get());
                        pOutput.accept(ModItem.SHENSEIUM.get());
                        pOutput.accept(ModItem.POSEI.get());
                        pOutput.accept(ModItem.WONYOUNG_ESSENCE.get());
                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


    /*
    papi-blocks - uses shenseium ore
    cvmsumables - uses cupcakkes
    slaytools - uses arana grande
    yass discs - uses see tinh
    yassifying ingredients - uses cvmtitplasm
     */

}
