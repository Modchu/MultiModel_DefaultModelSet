package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelPlate;
import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_Elsa2 extends MultiModel_SR2 {	public MultiModel_Elsa2() {
		this(0.0F);
	}	public MultiModel_Elsa2(float f) {
		this(f, 0.0F);
	}	public MultiModel_Elsa2(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Elsa2(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0F, 4F, 0F);		bipedHeadwear = new Modchu_ModelRenderer(this, 34, -3);
		bipedHeadwear.addBox(-4F, 0F, 1F, 8, 4, 3, f);
		bipedHeadwear.setRotationPoint(0F, 0F, 0F);		bipedBody = new Modchu_ModelRenderer(this, 32, 4);
		bipedBody.addBox(-3F, 0F, -2F, 6, 9, 4, f);
		bipedBody.setRotationPoint(0F, 4.5F, 0F);		bipedRightArm = new Modchu_ModelRenderer(this, 42, 17);
		bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);
		bipedRightArm.setRotationPoint(-3F, 1.0F, 0F);		bipedLeftArm = new Modchu_ModelRenderer(this, 50, 17);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(0F, -1F, -1F, 2, 10, 2, f);
		bipedLeftArm.setRotationPoint(3F, 1.0F, 0F);		bipedRightLeg = new Modchu_ModelRenderer(this, 28, 17);
		bipedRightLeg.addBox(-2F, 0F, -2F, 3, 11, 4, f);
		bipedRightLeg.setRotationPoint(-1F, 6F, 0F);		bipedLeftLeg = new Modchu_ModelRenderer(this, 28, 17);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0F, -2F, 3, 11, 4, f);
		bipedLeftLeg.setRotationPoint(1F, 6F, 0F);		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -3F, -3F, 8, 10, 6, f);
		Skirt.setRotationPoint(0F, 13F, 0F);		ChignonR = new Modchu_ModelRenderer(this, 0, 2);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0F, 0F, 0F);		ChignonL = new Modchu_ModelRenderer(this, 0, 2);
		ChignonL.mirror = true;
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0F, 0F, 0F);		ChignonB = new Modchu_ModelRenderer(this, 24, 2);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0F, 0F, 0F);		Tail = new Modchu_ModelRenderer(this, 52, 5);
		Tail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);
		Tail.setRotationPoint(0F, -5.2F, 5F);		SideTailR = new Modchu_ModelRenderer(this, 58, 18);
		SideTailR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);
		SideTailR.setRotationPoint(-4.5F, -5.5F, 1.7F);		SideTailL = new Modchu_ModelRenderer(this, 58, 18);
		SideTailL.mirror = true;
		SideTailL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);
		SideTailL.setRotationPoint(4.5F, -5.5F, 1.7F);		// 追加パーツ
		eyeR = new Modchu_ModelRenderer(this, 17, 0);
		eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 21, 0);
		eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this, 42, 17);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		rightArmPlus = new Modchu_ModelRenderer(this);		rightArm2 = new Modchu_ModelRenderer(this, 42, 22);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		rightArm2.setRotationPoint(0.0F, 5.0F, 0.0F);		rightArmPlus2 = new Modchu_ModelRenderer(this);		rightHand = new Modchu_ModelRenderer(this, 42, 25);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm = new Modchu_ModelRenderer(this, 50, 17);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		leftArmPlus = new Modchu_ModelRenderer(this);		leftArm2 = new Modchu_ModelRenderer(this, 50, 22);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new Modchu_ModelRenderer(this);		leftHand = new Modchu_ModelRenderer(this, 50, 25);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg = new Modchu_ModelRenderer(this, 28, 17);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new Modchu_ModelRenderer(this);		rightLeg2 = new Modchu_ModelRenderer(this, 28, 22);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new Modchu_ModelRenderer(this);		leftLeg = new Modchu_ModelRenderer(this, 28, 17);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLegPlus.mirror = true;
		leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new Modchu_ModelRenderer(this, 28, 22);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new Modchu_ModelRenderer(this);		rightHand.showModel = leftHand.showModel = rightArm.showModel = leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel = leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel = rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel = rightArm2.showModel = leftArm2.showModel = rightLeg.showModel = rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		//上
		SkirtTop = new Modchu_ModelRenderer(this, 6, 16);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 6, ModchuModel_ModelPlate.planeXZTop);
		SkirtTop.setRotationPoint(-4.0F, -3.0F, -3.0F);		//前
		SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 10, ModchuModel_ModelPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//右
		SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 6, 10, ModchuModel_ModelPlate.planeZYRight);
		SkirtRight.setRotationPoint(8.0F, 0.0F, 0.0F);		//左
		SkirtLeft = new Modchu_ModelRenderer(this, 14, 22);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 6, 10, ModchuModel_ModelPlate.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//後ろ
		SkirtBack = new Modchu_ModelRenderer(this, 20, 22);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 10, ModchuModel_ModelPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 6.0F);
		setCapsValue(null, caps_visible, Skirt, false);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Arms[0].setRotationPoint(-0.7F, 8.5F, 0F);
		Arms[1].setRotationPoint(0.7F, 8.5F, 0F);
		mainFrame.setRotationPoint(0F, 0F, 0F);
		bipedHead.rotationPointY += 4.0F;
		bipedBody.rotationPointY += 1.0F;
		bipedRightArm.rotationPointX += 1.0F;
		bipedLeftArm.rotationPointX -= 1.0F;
		bipedRightArm.rotationPointY += 4.5F;
		bipedLeftArm.rotationPointY += 4.5F;
		bipedRightLeg.rotationPointX = -1.0F;
		bipedLeftLeg.rotationPointX = 1.0F;
		bipedRightLeg.rotationPointY += 5.5F;
		bipedLeftLeg.rotationPointY += 5.5F;
		Skirt.rotationPointY += 2.5F;
		bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F + 3.141593F) * 1.6F * f1 * 0.5F;
		bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F) * 1.6F * f1 * 0.5F;
		bipedRightLeg.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F) * 1.0F * f1;
		bipedLeftLeg.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F + 3.141593F) * 1.0F * f1;		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			// 乗り物に乗っている
			bipedRightArm.rotateAngleX += -0.6283185F;
			bipedLeftArm.rotateAngleX += -0.6283185F;
			bipedRightLeg.rotateAngleX = -1.256637F;
			bipedLeftLeg.rotateAngleX = -1.256637F;
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		// アイテム持ってるときの腕振りを抑える
		if (heldItem[1] != 0) {
			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[1];
		}
		if (heldItem[0] != 0) {
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[0];
		}		if (armSwingFlag(entityCaps)) {
			// 腕振り
			float f6, f7, f8;
			f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[0]) * (float) Math.PI * 2.0F);
			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[1]) * (float) Math.PI * 2.0F);
			// R
			if (onGrounds[0] > 0F) {
				f6 = 1.0F - onGrounds[0];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[0] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedRightArm.rotateAngleX -= f7 * 1.2D + f8;
			} else {
				bipedRightArm.rotateAngleX += bipedBody.rotateAngleY;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;
			} else {
				bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
			}
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			// しゃがみ
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 6.2F;
			//Skirt.rotationPointZ += 3.5F;
			//bipedRightLeg.rotateAngleX -= 0.5F;
			//bipedLeftLeg.rotateAngleX -= 0.5F;
			//bipedHead.rotationPointY += 1.0F;
			//bipedBody.rotationPointY += 1.0F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			//待機状態の特別表示
			bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
			bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			// 弓構え
			float f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[dominantArm] * 3.141593F);
			float f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (1.0F - (1.0F - onGrounds[dominantArm])) * 3.141593F);
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			bipedRightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
		} else {
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
				// 呼吸 腕等
				bipedRightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			}
		}
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float) getMotionY();
		Skirt.rotationPointY = 10.0F;		SkirtFront.rotationPointX = SkirtBack.rotationPointX = motionY * 4.0F;
		SkirtRight.rotationPointZ = motionY * 4.0F;
		SkirtLeft.rotationPointZ = motionY * 4.0F;		SkirtFront.rotateAngleX = motionY;
		SkirtRight.rotateAngleZ = motionY / 2.0F;
		SkirtLeft.rotateAngleZ = -motionY / 2.0F;
		SkirtBack.rotateAngleX = -motionY;		SkirtFront.scaleX = SkirtBack.scaleX = 1.0F - (motionY * 1.0F);
		SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		hip.rotateAngleZ = 0.0F;		rightArm2.rotationPointY += 1.0F;
		leftArm2.rotationPointY += 1.0F;
		bipedHead.rotationPointX = 0.0F;
		rightLeg.rotationPointX -= 0.5F;
		leftLeg.rotationPointX += 0.5F;
		Arms[0].setRotationPoint(-0.7F, 0.0F, 0F);
		Arms[1].setRotationPoint(0.7F, 0.0F, 0F);
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.rotationPointY += 4.0F;
		Skirt.rotationPointY += 9.5F;
		Arms[0].setRotationPoint(-0.7F, 0.0F, 0F);
		Arms[1].setRotationPoint(0.7F, 0.0F, 0F);
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.58F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.5F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.4F;
	}	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.85F;
	}
}