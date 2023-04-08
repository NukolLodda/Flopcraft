package slay.nukolussy.modussy.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import slay.nukolussy.modussy.entity.custom.Jiafei;

public class JiafeiRenderer extends HumanoidMobRenderer<Jiafei, HumanoidModel<Jiafei>> {
    public JiafeiRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
    }

    @Override
    public ResourceLocation getTextureLocation(Jiafei entity) {
        return new ResourceLocation("modussy:textures/entities/jiafei.png");
    }
}
