package net.nukollodda.flopcraft.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.flopcraft.client.models.MariahCareyModel;
import net.nukollodda.flopcraft.entities.flops.figures.MariahCarey;

public class MariahCareyRenderer extends MobRenderer<MariahCarey, MariahCareyModel<MariahCarey>> {
    public MariahCareyRenderer(EntityRendererProvider.Context context) {
        super(context, new MariahCareyModel<>(context.bakeLayer(MariahCareyModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MariahCarey pEntity) {
        return ResourceLocation.withDefaultNamespace("flopcraft:textures/entities/mariah_carey.png");
    }
}
