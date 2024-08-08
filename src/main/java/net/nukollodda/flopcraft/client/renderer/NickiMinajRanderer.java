package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.flopcraft.entities.flops.traders.NickiMinaj;

public class NickiMinajRanderer extends HumanoidMobRenderer<NickiMinaj, PlayerModel<NickiMinaj>> {
    public NickiMinajRanderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ArrowLayer<>(context, this));
        this.addLayer(new BeeStingerLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(NickiMinaj pEntity) {
        return ResourceLocation.withDefaultNamespace("flopcraft:textures/entities/nicki_minaj.png");
    }
}
