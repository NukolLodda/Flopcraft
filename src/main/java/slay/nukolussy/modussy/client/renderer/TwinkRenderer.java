package slay.nukolussy.modussy.client.renderer;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.client.renderer.twink.Variant;
import slay.nukolussy.modussy.entity.custom.Twink;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class TwinkRenderer extends MobRenderer<Twink, HumanoidModel<Twink>> {
    private static final Map<Variant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(Variant.class), (p_114874_) -> {
        p_114874_.put(Variant.FEM, new ResourceLocation("modussy:textures/entities/twink_1.png"));
        p_114874_.put(Variant.SUIT, new ResourceLocation("modussy:textures/entities/twink_2.png"));
        p_114874_.put(Variant.FLOWER, new ResourceLocation("modussy:textures/entities/twink_3.png"));
        p_114874_.put(Variant.FLANNEL, new ResourceLocation("modussy:textures/entities/twink_4.png"));
    });
    public TwinkRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
    }

    public @NotNull ResourceLocation getTextureLocation(Twink entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
