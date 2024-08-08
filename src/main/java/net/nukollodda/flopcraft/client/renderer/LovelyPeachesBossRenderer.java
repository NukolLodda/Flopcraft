package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.nukollodda.flopcraft.client.models.LovelyPeachesBossModel;
import net.nukollodda.flopcraft.entities.flops.bosses.LovelyPeachesBoss;

public class LovelyPeachesBossRenderer extends MobRenderer<LovelyPeachesBoss, LovelyPeachesBossModel<LovelyPeachesBoss>> {
    public LovelyPeachesBossRenderer(EntityRendererProvider.Context context) {
		super(context, new LovelyPeachesBossModel<>(context.bakeLayer(LovelyPeachesBossModel.LAYER_LOCATION)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(LovelyPeachesBoss entity) {
        return ResourceLocation.withDefaultNamespace("flopcraft:textures/entities/lovely_peaches_boss.png");
    }
}

