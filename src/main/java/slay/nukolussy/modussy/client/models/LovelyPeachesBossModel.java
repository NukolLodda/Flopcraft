package slay.nukolussy.modussy.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import slay.nukolussy.modussy.Modussy;

// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings

public class LovelyPeachesBossModel<LovelyPeachesBoss extends Entity> extends EntityModel<LovelyPeachesBoss> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Modussy.MODID, "lovely_peaches"), "main");
	private final ModelPart top_leaves;
	private final ModelPart top_leaves2;
	private final ModelPart top_leaves3;
	private final ModelPart top_leaves4;
	private final ModelPart top_leaves5;
	private final ModelPart side_leaves;
	private final ModelPart side_leaves2;
	private final ModelPart side_leaves3;
	private final ModelPart side_leaves4;
	private final ModelPart bb_main;

	public LovelyPeachesBossModel(ModelPart root) {
		this.top_leaves = root.getChild("top_leaves");
		this.top_leaves2 = root.getChild("top_leaves2");
		this.top_leaves3 = root.getChild("top_leaves3");
		this.top_leaves4 = root.getChild("top_leaves4");
		this.top_leaves5 = root.getChild("top_leaves5");
		this.side_leaves = root.getChild("side_leaves");
		this.side_leaves2 = root.getChild("side_leaves2");
		this.side_leaves3 = root.getChild("side_leaves3");
		this.side_leaves4 = root.getChild("side_leaves4");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition top_leaves = partdefinition.addOrReplaceChild("top_leaves", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -112.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition top_leaves2 = partdefinition.addOrReplaceChild("top_leaves2", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -112.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -128.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, 40.0F, 0.0F));

		PartDefinition top_leaves3 = partdefinition.addOrReplaceChild("top_leaves3", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -105.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -121.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 33.0F, 16.0F));

		PartDefinition top_leaves4 = partdefinition.addOrReplaceChild("top_leaves4", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -112.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -128.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, 40.0F, 0.0F));

		PartDefinition top_leaves5 = partdefinition.addOrReplaceChild("top_leaves5", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -112.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -128.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 40.0F, -16.0F));

		PartDefinition side_leaves = partdefinition.addOrReplaceChild("side_leaves", CubeListBuilder.create().texOffs(256, 64).addBox(-8.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 40.0F, -16.0F));

		PartDefinition side_leaves2 = partdefinition.addOrReplaceChild("side_leaves2", CubeListBuilder.create().texOffs(48, 224).addBox(-8.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(208, 80).addBox(-24.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 40.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition side_leaves3 = partdefinition.addOrReplaceChild("side_leaves3", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 40.0F, 16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition side_leaves4 = partdefinition.addOrReplaceChild("side_leaves4", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-8.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -96.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-40.0F, -80.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 40.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -96.0F, -8.0F, 16.0F, 96.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, 8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-24.0F, -96.0F, -24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(8.0F, -96.0F, -24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(8.0F, -96.0F, 8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(LovelyPeachesBoss entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		top_leaves.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top_leaves2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top_leaves3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top_leaves4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top_leaves5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side_leaves.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side_leaves2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side_leaves3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side_leaves4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}