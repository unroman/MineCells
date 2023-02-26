package com.github.mim1q.minecells.client.render.blockentity.statue;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class KingStatueModel extends Model {
  private final ModelPart root;

  public KingStatueModel(ModelPart root) {
    super(RenderLayer::getEntityCutoutNoCull);
    this.root = root.getChild("root");
  }

  // Generated by Blockbench
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

    ModelPartData main = root.addChild("main", ModelPartBuilder.create().uv(0, 72).cuboid(-5.0F, -43.0F, -3.0F, 10.0F, 6.0F, 6.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 6.0F, 0.0F, 0.0F, -0.0873F, 0.0F));
    ModelPartData chest = main.addChild("chest", ModelPartBuilder.create().uv(40, 40).cuboid(-6.0F, -8.0F, -3.5F, 12.0F, 8.0F, 7.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -43.0F, -0.5F, -0.1309F, 0.0873F, 0.0F));
    ModelPartData right_arm = chest.addChild("right_arm", ModelPartBuilder.create().uv(96, 0).cuboid(-4.0F, -1.0F, -1.5F, 4.0F, 10.0F, 4.0F, new Dilation(0.01F)).uv(44, 86).mirrored().cuboid(-5.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-6.0F, -6.0F, 0.0F, -1.0472F, 0.4363F, 0.0F));
    right_arm.addChild("right_arm_lower", ModelPartBuilder.create().uv(90, 86).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.005F)), ModelTransform.of(-2.0F, 9.0F, 2.5F, -1.3963F, 0.0F, 0.0F));
    ModelPartData left_arm = chest.addChild("left_arm", ModelPartBuilder.create().uv(96, 0).cuboid(0.0F, -1.0F, -1.5F, 4.0F, 10.0F, 4.0F, new Dilation(0.01F)).uv(44, 86).cuboid(-1.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.01F)), ModelTransform.of(6.0F, -6.0F, 0.0F, -0.0873F, 0.0F, -0.2182F));
    left_arm.addChild("left_arm_lower", ModelPartBuilder.create().uv(90, 86).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.005F)), ModelTransform.of(2.0F, 9.0F, 2.5F, -0.4363F, 0.0F, 0.0F));
    ModelPartData head = chest.addChild("head", ModelPartBuilder.create().uv(71, 47).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -8.5F, -0.5F, 0.3054F, 0.2618F, 0.0F));
    head.addChild("right_spike_r1", ModelPartBuilder.create().uv(97, 16).mirrored().cuboid(-4.5F, -8.0F, 0.5F, 4.0F, 14.0F, 0.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-4.5F, -10.0F, -4.25F, -0.7854F, 1.0472F, -0.7854F));
    head.addChild("middle_spike_r1", ModelPartBuilder.create().uv(96, 64).cuboid(-2.5F, -12.0F, 1.0F, 5.0F, 18.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -10.0F, -4.75F, -0.3491F, 0.0F, 0.0F));
    head.addChild("left_spike_r1", ModelPartBuilder.create().uv(97, 16).cuboid(0.5F, -8.0F, 0.75F, 4.0F, 14.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(4.5F, -10.0F, -4.25F, -0.6981F, -0.8727F, 0.6981F));
    ModelPartData waist = main.addChild("waist", ModelPartBuilder.create().uv(33, 55).cuboid(-6.0F, 0.0F, -3.5F, 12.0F, 8.0F, 7.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -37.0F, -0.5F, 0.0F, -0.1745F, 0.0F));
    waist.addChild("belt_r1", ModelPartBuilder.create().uv(114, 112).cuboid(-4.0F, 0.0F, 0.0F, 7.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 2.0F, -3.75F, -0.1309F, 0.0F, 0.0F));
    ModelPartData left_leg = waist.addChild("left_leg", ModelPartBuilder.create().uv(95, 40).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.01F)).uv(0, 107).cuboid(-4.0F, -4.0F, -3.5F, 7.0F, 14.0F, 7.0F, new Dilation(0.01F)), ModelTransform.of(3.5F, 8.0F, 0.0F, -0.1745F, -0.0873F, 0.0F));
    left_leg.addChild("left_leg_lower", ModelPartBuilder.create().uv(24, 86).cuboid(-2.5F, 0.0F, 0.0F, 5.0F, 14.0F, 5.0F, new Dilation(0.005F)), ModelTransform.of(0.0F, 10.0F, -2.5F, 0.1745F, 0.0F, 0.0F));
    ModelPartData right_leg = waist.addChild("right_leg", ModelPartBuilder.create().uv(95, 40).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-3.5F, 8.0F, 0.0F, -0.2618F, 0.4363F, 0.0F));
    right_leg.addChild("right_pants_r1", ModelPartBuilder.create().uv(0, 107).mirrored().cuboid(-3.5F, -7.0F, -3.5F, 7.0F, 14.0F, 7.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-0.5F, 3.0F, 0.0F, 0.0F, -0.2182F, 0.0F));
    right_leg.addChild("right_leg_lower", ModelPartBuilder.create().uv(24, 86).mirrored().cuboid(-2.5F, 0.0F, 0.0F, 5.0F, 14.0F, 5.0F, new Dilation(0.005F)).mirrored(false), ModelTransform.of(0.0F, 10.0F, -2.5F, 0.3491F, 0.0F, 0.0F));
    ModelPartData collar = root.addChild("collar", ModelPartBuilder.create().uv(29, 112).cuboid(-8.0F, -11.0F, 4.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -50.0F, 3.0F, -0.3491F, 0.0F, 0.0F));
    collar.addChild("collar_right_r1", ModelPartBuilder.create().uv(69, 87).mirrored().cuboid(-9.0F, -10.0F, -0.75F, 10.0F, 16.0F, 0.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-7.0F, 0.0F, 4.0F, -0.3491F, -1.2217F, 0.0F));
    collar.addChild("collar_left_r1", ModelPartBuilder.create().uv(69, 87).cuboid(-1.0F, -10.0F, -0.75F, 10.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(7.0F, 0.0F, 4.0F, -0.3491F, 1.2217F, 0.0F));
    ModelPartData cape = root.addChild("cape", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, 3.0F));
    ModelPartData segment1 = cape.addChild("segment1", ModelPartBuilder.create().uv(32, 70).cuboid(0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.pivot(-8.0F, -51.0F, 4.0F));
    segment1.addChild("right1_r1", ModelPartBuilder.create().uv(0, 85).mirrored().cuboid(-12.0F, -8.0F, 0.0F, 12.0F, 16.0F, 0.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.9599F, 0.0F));
    segment1.addChild("left1_r1", ModelPartBuilder.create().uv(0, 85).cuboid(0.0F, -8.0F, 0.0F, 12.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(16.0F, 0.0F, 0.0F, 0.0F, 0.9599F, 0.0F));
    ModelPartData segment2 = segment1.addChild("segment2", ModelPartBuilder.create().uv(0, 16).cuboid(-8.0F, 0.0F, 17.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(8.0F, 8.0F, -17.0F, 0.1745F, 0.0F, 0.0F));
    segment2.addChild("right2_r1", ModelPartBuilder.create().uv(0, 56).mirrored().cuboid(-16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-8.0F, 8.0F, 17.0F, 0.0F, -0.9163F, 0.0F));
    segment2.addChild("left2_r1", ModelPartBuilder.create().uv(0, 56).cuboid(0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(8.0F, 8.0F, 17.0F, 0.0F, 1.0036F, 0.0F));
    ModelPartData segment3 = segment2.addChild("segment3", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 0.0F, -1.0F, 16.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, 16.0F, 18.0F, -0.0873F, 0.0F, 0.0F));
    segment3.addChild("right3_r1", ModelPartBuilder.create().uv(0, 40).mirrored().cuboid(-20.0F, -8.0F, 0.0F, 20.0F, 16.0F, 0.0F, new Dilation(0.01F)).mirrored(false), ModelTransform.of(-8.0F, 8.0F, -1.0F, 0.0F, -0.8727F, 0.0F));
    segment3.addChild("left3_r1", ModelPartBuilder.create().uv(0, 40).cuboid(0.0F, -8.0F, 0.0F, 20.0F, 16.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(8.0F, 8.0F, -1.0F, 0.0F, 0.9599F, 0.0F));
    return TexturedModelData.of(modelData, 128, 128);
  }
  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }
}