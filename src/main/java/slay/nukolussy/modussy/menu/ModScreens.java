package slay.nukolussy.modussy.menu;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import slay.nukolussy.modussy.world.inventory.JiafeiTrade;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void clientLoad(FMLCommonSetupEvent event) {
    }
}
