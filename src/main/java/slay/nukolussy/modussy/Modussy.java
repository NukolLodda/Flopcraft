package slay.nukolussy.modussy;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.ModWoodTypes;
import slay.nukolussy.modussy.block.entity.ent.ModBlockEntities;
import slay.nukolussy.modussy.block.fluids.ModFluidTypes;
import slay.nukolussy.modussy.block.fluids.ModFluids;
import slay.nukolussy.modussy.client.gui.CvmInfusionAlterScreen;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.client.menu.ModMenuTypes;
import slay.nukolussy.modussy.loot.ModLootModifiers;
import slay.nukolussy.modussy.network.ModMessages;
import slay.nukolussy.modussy.painting.ModPaintings;
import slay.nukolussy.modussy.recipes.ModRecipes;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

@Mod(Modussy.MODID)
public class Modussy {
    public static final String MODID = "modussy";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Modussy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModSounds.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEntities.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModEffects.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // if the below doesn't work, put it in here
        });
        ModMessages.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.CUPCAKKE_SPAWN_EGG.get());
            event.accept(ModItems.JIAFEI_SPAWN_EGG.get());
            event.accept(ModItems.LOVELY_PEACHES_SPAWN_EGG.get());
            event.accept(ModItems.MARIAH_CAREY_SPAWN_EGG.get());
            event.accept(ModItems.NICKI_MINAJ_SPAWN_EGG.get());
            event.accept(ModItems.RANVISION_SPAWN_EGG.get());
            event.accept(ModItems.TWINK_SPAWN_EGG.get());
            // event.accept(ModItems.TWINK_SIVAN_SPAWN_EGG.get());
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.CVM_FLUID_BUCKET);
            event.accept(ModItems.POOSAY_JUICE_BUCKET);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.LOVELY_PEACH);

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_CVM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_POOSAY_JUICE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MARIAH_CAREY_ICE_BLOCK.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_CVM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_POOSAY_JUICE.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.CVM_INFUSION_ALTER_MENU.get(), CvmInfusionAlterScreen::new);
        }
    }

}
