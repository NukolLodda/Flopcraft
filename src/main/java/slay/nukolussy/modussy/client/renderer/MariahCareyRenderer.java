package slay.nukolussy.modussy.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import slay.nukolussy.modussy.client.models.MariahCareyModel;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;

public class MariahCareyRenderer extends MobRenderer<MariahCarey, MariahCareyModel<MariahCarey>> {
    public MariahCareyRenderer(EntityRendererProvider.Context context) {
        super(context, new MariahCareyModel<>(context.bakeLayer(MariahCareyModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MariahCarey pEntity) {
        return new ResourceLocation("modussy:textures/entities/mariah_carey.png");
    }
}
