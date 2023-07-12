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
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.client.renderer.twink.Variant;
import slay.nukolussy.modussy.entities.custom.twink.Twink;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class TwinkRenderer extends MobRenderer<Twink, PlayerModel<Twink>> {
    private static final Map<Variant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(Variant.class), (type) -> {
        type.put(Variant.BEACH, new ResourceLocation("modussy:textures/entities/twink_1.png"));
        type.put(Variant.FLOWER, new ResourceLocation("modussy:textures/entities/twink_2.png"));
        type.put(Variant.PINK, new ResourceLocation("modussy:textures/entities/twink_3.png"));
    });
    public TwinkRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new ArrowLayer<>(context, this));
        this.addLayer(new BeeStingerLayer<>(this));
    }

    public @NotNull ResourceLocation getTextureLocation(Twink entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}
