package slay.nukolussy.modussy.client.renderer;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import slay.nukolussy.modussy.entities.twink.TwinkSivan;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class TwinkSivanRenderer extends MobRenderer<TwinkSivan, PlayerModel<TwinkSivan>> {
    private static final Map<TwinkSivan.Variant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(TwinkSivan.Variant.class), (type) -> {
    type.put(TwinkSivan.Variant.RUSH, new ResourceLocation("modussy:textures/entities/twink_sivan_1.png"));
    type.put(TwinkSivan.Variant.STARTED, new ResourceLocation("modussy:textures/entities/twink_sivan_2.png"));
    type.put(TwinkSivan.Variant.BATH, new ResourceLocation("modussy:textures/entities/twink_sivan_3.png"));
    type.put(TwinkSivan.Variant.VEST, new ResourceLocation("modussy:textures/entities/twink_sivan_4.png"));
});
    public TwinkSivanRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ArrowLayer<>(context, this));
        this.addLayer(new BeeStingerLayer<>(this));
    }
    @Override
    public ResourceLocation getTextureLocation(TwinkSivan entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
