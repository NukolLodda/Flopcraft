package slay.nukolussy.modussy.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import slay.nukolussy.modussy.client.models.LovelyPeachesModel;
import slay.nukolussy.modussy.entities.flops.special.LovelyPeaches;
public class LovelyPeachesRenderer extends MobRenderer<LovelyPeaches, LovelyPeachesModel<LovelyPeaches>> {
    public LovelyPeachesRenderer(EntityRendererProvider.Context context) {
		super(context, new LovelyPeachesModel<>(context.bakeLayer(LovelyPeachesModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LovelyPeaches entity) {
        return new ResourceLocation("modussy:textures/entities/lovely_peaches.png");
    }
}

