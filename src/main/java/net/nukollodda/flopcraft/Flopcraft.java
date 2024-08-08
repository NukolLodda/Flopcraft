package net.nukollodda.flopcraft;

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
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.block.FlopWoodTypes;
import net.nukollodda.flopcraft.block.entity.ent.FlopBlockEntities;
import net.nukollodda.flopcraft.block.fluids.FlopFluidTypes;
import net.nukollodda.flopcraft.block.fluids.FlopFluids;
import net.nukollodda.flopcraft.client.gui.YassificationAltarScreen;
import net.nukollodda.flopcraft.effect.FlopEffects;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.client.menu.FlopMenuTypes;
import net.nukollodda.flopcraft.loot.FlopLootModifiers;
import net.nukollodda.flopcraft.network.FlopMessages;
import net.nukollodda.flopcraft.painting.FlopPaintings;
import net.nukollodda.flopcraft.recipes.FlopRecipes;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.tabs.FlopCreativeTabs;

@Mod(Flopcraft.MODID)
public class Flopcraft {
    public static final String MODID = "flopcraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Flopcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FlopSounds.register(modEventBus);
        FlopItems.register(modEventBus);
        FlopBlocks.register(modEventBus);
        FlopCreativeTabs.register(modEventBus);
        FlopEntities.register(modEventBus);
        FlopPaintings.register(modEventBus);
        FlopEffects.register(modEventBus);
        FlopBlockEntities.register(modEventBus);
        FlopFluids.register(modEventBus);
        FlopFluidTypes.register(modEventBus);
        FlopLootModifiers.register(modEventBus);
        FlopMenuTypes.register(modEventBus);
        FlopRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // if the below doesn't work, put it in here
        });
        FlopMessages.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(FlopItems.CHARLI_XCX_SPAWN_EGG.get());
            event.accept(FlopItems.CUPCAKKE_SPAWN_EGG.get());
            event.accept(FlopItems.JIAFEI_SPAWN_EGG.get());
            event.accept(FlopItems.LOVELY_PEACHES_SPAWN_EGG.get());
            event.accept(FlopItems.KAMALA_HARRIS_SPAWN_EGG.get());
            event.accept(FlopItems.MARIAH_CAREY_SPAWN_EGG.get());
            event.accept(FlopItems.NICKI_MINAJ_SPAWN_EGG.get());
            event.accept(FlopItems.RANVISION_SPAWN_EGG.get());
            event.accept(FlopItems.TWINK_SPAWN_EGG.get());
            event.accept(FlopItems.TWINK_SIVAN_SPAWN_EGG.get());
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(FlopItems.CVM_FLUID_BUCKET);
            event.accept(FlopItems.POOSAY_JUICE_BUCKET);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(net.nukollodda.flopcraft.block.FlopWoodTypes.LOVELY_PEACH);

            ItemBlockRenderTypes.setRenderLayer(FlopFluids.SOURCE_CVM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(FlopFluids.SOURCE_POOSAY_JUICE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FlopBlocks.MARIAH_CAREY_ICE_BLOCK.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(FlopFluids.FLOWING_CVM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(FlopFluids.FLOWING_POOSAY_JUICE.get(), RenderType.translucent());

            MenuScreens.register(FlopMenuTypes.CVM_INFUSION_ALTER_MENU.get(), YassificationAltarScreen::new);
        }
    }

}
