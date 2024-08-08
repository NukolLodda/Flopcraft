package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.flopcraft.client.models.LovelyPeachesModel;
import net.nukollodda.flopcraft.entities.flops.figures.LovelyPeaches;

public class LovelyPeachesRenderer extends MobRenderer<LovelyPeaches, LovelyPeachesModel<LovelyPeaches>> {
    public LovelyPeachesRenderer(EntityRendererProvider.Context context) {
        super(context, new LovelyPeachesModel<>(context.bakeLayer(LovelyPeachesModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(LovelyPeaches pEntity) {
        return ResourceLocation.withDefaultNamespace("flopcraft:textures/entities/lovely_peaches.png");
    }
}
