package slay.nukolussy.modussy.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.client.renderer.CupcakKeRenderer;
import slay.nukolussy.modussy.client.renderer.TwinkRenderer;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.entity.custom.Twink;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderes(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.CUPCAKKE.get(), CupcakKeRenderer::new);
        event.registerEntityRenderer(ModEntities.TWINK.get(), TwinkRenderer::new);
    }
}
