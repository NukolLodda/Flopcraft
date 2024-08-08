package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.flopcraft.entities.flops.bosses.GirlbossSivan;

public class GirlbossSivanRenderer extends HumanoidMobRenderer<GirlbossSivan, HumanoidModel<GirlbossSivan>> {
    public GirlbossSivanRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(GirlbossSivan entity) {
        return ResourceLocation.withDefaultNamespace("flopcraft:textures/entities/girlboss_sivan.png");
    }
}
