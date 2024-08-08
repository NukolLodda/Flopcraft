package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nukollodda.flopcraft.entities.FlopEntities;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlopEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FlopEntities.CHARLI_XCX.get(), CharliXCXRenderer::new);
        event.registerEntityRenderer(FlopEntities.CUPCAKKE.get(), CupcakKeRenderer::new);
        event.registerEntityRenderer(FlopEntities.GIRLBOSS_SIVAN.get(), GirlbossSivanRenderer::new);
        event.registerEntityRenderer(FlopEntities.JIAFEI.get(), JiafeiRenderer::new);
        event.registerEntityRenderer(FlopEntities.LOVELY_PEACHES.get(), LovelyPeachesRenderer::new);
        event.registerEntityRenderer(FlopEntities.LOVELY_PEACHES_BOSS.get(), LovelyPeachesBossRenderer::new);
        event.registerEntityRenderer(FlopEntities.KAMALA_HARRIS.get(), KamalaHarrisRenderer::new);
        event.registerEntityRenderer(FlopEntities.MARIAH_CAREY.get(), MariahCareyRenderer::new);
        event.registerEntityRenderer(FlopEntities.NICKI_MINAJ.get(), NickiMinajRanderer::new);
        event.registerEntityRenderer(FlopEntities.RANVISION.get(), RanvisionRenderer::new);
        event.registerEntityRenderer(FlopEntities.TWINK.get(), TwinkRenderer::new);
        event.registerEntityRenderer(FlopEntities.TWINK_SIVAN.get(), TwinkSivanRenderer::new);

        event.registerEntityRenderer(FlopEntities.LOVELY_PEACH.get(), context ->
             new ThrownItemRenderer<>(context, 3.0f, true));

        event.registerEntityRenderer(FlopEntities.TAMPONS.get(), context ->
                new ThrownItemRenderer<>(context, 1.5f, false));

        event.registerEntityRenderer(FlopEntities.BLOODY_TAMPONS.get(), context ->
                new ThrownItemRenderer<>(context, 1.5f, false));

        event.registerEntityRenderer(FlopEntities.EXTRA_BLOODY_TAMPONS.get(), context ->
                new ThrownItemRenderer<>(context, 1.5f, false));

        event.registerEntityRenderer(FlopEntities.KAMALOCONUT.get(), context ->
                new ThrownItemRenderer<>(context, 1.5f, false));

        event.registerEntityRenderer(FlopEntities.TWINK_EGG.get(), context ->
                new ThrownItemRenderer<>(context, 1.5f, false));

    }
}
