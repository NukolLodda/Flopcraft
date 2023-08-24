package slay.nukolussy.modussy.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import slay.nukolussy.modussy.entities.flops.special.MeganTheStallion;

import java.awt.*;

public class MeganTheStallionModel<MeganTheStallion> extends AgeableListModel<slay.nukolussy.modussy.entities.flops.special.MeganTheStallion> {
    private ModelPart[] saddleParts;
    private ModelPart[] ridingParts;
    private Rectangle body;

    @Override
    public void setupAnim(slay.nukolussy.modussy.entities.flops.special.MeganTheStallion pEntity, float pLimbSwing,
                          float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        boolean flag = pEntity.isSaddled();
        boolean flag1 = pEntity.isVehicle();

        for(ModelPart modelpart : this.saddleParts) {
            modelpart.visible = flag;
        }

        for(ModelPart modelpart1 : this.ridingParts) {
            modelpart1.visible = flag1 && flag;
        }

        this.body.y = 11;
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return null;
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return null;
    }
}
