package slay.nukolussy.modussy.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import slay.nukolussy.modussy.client.models.LovelyPeachesBossModel;
import slay.nukolussy.modussy.entities.flops.bosses.LovelyPeachesBoss;

public class LovelyPeachesBossRenderer extends MobRenderer<LovelyPeachesBoss, LovelyPeachesBossModel<LovelyPeachesBoss>> {
    public LovelyPeachesBossRenderer(EntityRendererProvider.Context context) {
		super(context, new LovelyPeachesBossModel<>(context.bakeLayer(LovelyPeachesBossModel.LAYER_LOCATION)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(LovelyPeachesBoss entity) {
        return new ResourceLocation("modussy:textures/entities/lovely_peaches_boss.png");
    }
}

