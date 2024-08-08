package net.nukollodda.flopcraft.event;

import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.entity.ent.FlopBlockEntities;
import net.nukollodda.flopcraft.client.models.LovelyPeachesBossModel;
import net.nukollodda.flopcraft.client.models.LovelyPeachesModel;
import net.nukollodda.flopcraft.client.models.MariahCareyModel;
import net.nukollodda.flopcraft.client.renderer.LovelyPeachesBossRenderer;
import net.nukollodda.flopcraft.client.renderer.LovelyPeachesRenderer;
import net.nukollodda.flopcraft.client.renderer.MariahCareyRenderer;
import net.nukollodda.flopcraft.entities.FlopEntities;

@Mod.EventBusSubscriber(modid = Flopcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FlopEntities.LOVELY_PEACHES_BOSS.get(), LovelyPeachesBossRenderer::new);
        event.registerEntityRenderer(FlopEntities.LOVELY_PEACHES.get(), LovelyPeachesRenderer::new);
        event.registerEntityRenderer(FlopEntities.MARIAH_CAREY.get(), MariahCareyRenderer::new);
        event.registerBlockEntityRenderer(FlopBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(FlopBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LovelyPeachesBossModel.LAYER_LOCATION, LovelyPeachesBossModel::createBodyLayer);
        event.registerLayerDefinition(LovelyPeachesModel.LAYER_LOCATION, LovelyPeachesModel::createBodyLayer);
        event.registerLayerDefinition(MariahCareyModel.LAYER_LOCATION, MariahCareyModel::createBodyLayer);
    }
}
