package slay.nukolussy.modussy.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import slay.nukolussy.modussy.client.models.LovelyPeachesModel;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;

public class LovelyPeachesRenderer extends MobRenderer<LovelyPeaches, LovelyPeachesModel<LovelyPeaches>> {
    public LovelyPeachesRenderer(EntityRendererProvider.Context context) {
        super(context, new LovelyPeachesModel<>(context.bakeLayer(LovelyPeachesModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(LovelyPeaches pEntity) {
        return new ResourceLocation("modussy:textures/entities/lovely_peaches.png");
    }
}
