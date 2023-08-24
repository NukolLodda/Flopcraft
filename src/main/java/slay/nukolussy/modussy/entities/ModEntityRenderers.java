package slay.nukolussy.modussy.entities;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.client.renderer.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderes(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.CUPCAKKE.get(), CupcakKeRenderer::new);
        event.registerEntityRenderer(ModEntities.JIAFEI.get(), JiafeiRenderer::new);
        event.registerEntityRenderer(ModEntities.LOVELY_PEACHES.get(), LovelyPeachesRenderer::new);
        event.registerEntityRenderer(ModEntities.NICKI_MINAJ.get(), NickiMinajRanderer::new);
        event.registerEntityRenderer(ModEntities.TWINK.get(), TwinkRenderer::new);
    }
}
