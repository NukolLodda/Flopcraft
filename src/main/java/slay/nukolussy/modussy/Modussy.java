package slay.nukolussy.modussy;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
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
import slay.nukolussy.modussy.block.entity.ent.ModBlockEntities;
import slay.nukolussy.modussy.client.gui.CvmInfusionAlterScreen;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.client.menu.ModMenuTypes;
import slay.nukolussy.modussy.network.ModMessages;
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
        // ModParticleTypes.REGISTER.register(modEventBus);
        ModBlockEntities.register(modEventBus);
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
            event.accept(ModItems.NICKI_MINAJ_SPAWN_EGG.get());
            event.accept(ModItems.TWINK_SPAWN_EGG.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWING_JIAFEI.get(), RenderType.cutout());

            MenuScreens.register(ModMenuTypes.CVM_INFUSION_ALTER_MENU.get(), CvmInfusionAlterScreen::new);
        }
    }

}
