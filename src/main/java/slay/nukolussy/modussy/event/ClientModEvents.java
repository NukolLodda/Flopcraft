package slay.nukolussy.modussy.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.client.models.LovelyPeachesBossModel;
import slay.nukolussy.modussy.client.models.LovelyPeachesModel;
import slay.nukolussy.modussy.client.renderer.LovelyPeachesBossRenderer;
import slay.nukolussy.modussy.client.renderer.LovelyPeachesRenderer;
import slay.nukolussy.modussy.entities.ModEntities;

@Mod.EventBusSubscriber(modid = Modussy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.LOVELY_PEACHES_BOSS.get(), LovelyPeachesBossRenderer::new);
        event.registerEntityRenderer(ModEntities.LOVELY_PEACHES.get(), LovelyPeachesRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LovelyPeachesBossModel.LAYER_LOCATION, LovelyPeachesBossModel::createBodyLayer);
        event.registerLayerDefinition(LovelyPeachesModel.LAYER_LOCATION, LovelyPeachesModel::createBodyLayer);
    }
}
