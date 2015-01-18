package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelPlate;public class MultiModel_Petit extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer FaceR;
	public Modchu_ModelRenderer FaceL;
	public Modchu_ModelRenderer rightHandPlus;
	public Modchu_ModelRenderer leftHandPlus;	public MultiModel_Petit() {
		this(0.0F);
	}	public MultiModel_Petit(float f) {
		this(f, 0.0F);
	}	public MultiModel_Petit(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Petit(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		f1 += 0.4F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -6.0F, -4.0F, 8, 8, 8, f - 2F);
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-2.0F, 0.0F, -1.0F, 4, 5, 3, f);
		bipedBody = new Modchu_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 7, 4, f - 1.25F);
		bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
		bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
		bipedRightLeg = new Modchu_ModelRenderer(this, 33, 20);
		bipedRightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 33, 20);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8, f - 1.9F);
		ChignonR = new Modchu_ModelRenderer(this, 25, 19);
		ChignonR.addBox(-2.55F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
		ChignonL = new Modchu_ModelRenderer(this, 25, 19);
		ChignonL.addBox(1.6F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-1.5F, -4.2F, 0.9F, 3, 3, 2, f - 0.4F);
		Tail = new Modchu_ModelRenderer(this, 46, 20);
		Tail.addBox(-1.5F, -3.9F, 1F, 3, 9, 3, f - 0.8F);
		SideTailR = new Modchu_ModelRenderer(this, 59, 22);
		SideTailR.addBox(-2.8F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);
		SideTailL = new Modchu_ModelRenderer(this, 59, 22);
		SideTailL.mirror = true;
		SideTailL.addBox(1.7F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);		Prim = new Modchu_ModelRenderer(this, 24, 17);
		Prim.addPlate(-1.5F, -4.7F, -2.1F, 3, 1, 0, f - 0.3F);		FaceR = new Modchu_ModelRenderer(this, 29, 16);
		FaceR.addBox(-2.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);
		FaceL = new Modchu_ModelRenderer(this, 39, 16);
		FaceL.addBox(-0.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);		eyeL = new Modchu_ModelRenderer(this, 0, 16);
		eyeL.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);		eyeR = new Modchu_ModelRenderer(this, 0, 20);
		eyeR.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this, 48, 0);
		rightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
		rightArm.setRotationPoint(-1.0F, -0.5F, 0.0F);		rightArm2 = new Modchu_ModelRenderer(this, 48, 1);
		rightArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
		rightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);		rightHand = new Modchu_ModelRenderer(this, 48, 3);
		rightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightHandPlus = new Modchu_ModelRenderer(this);
		rightHandPlus.setTextureOffset(52, 5).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
		rightHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightHandPlus.rotateAngleX = 1.570796313F;		leftArm = new Modchu_ModelRenderer(this, 56, 0);
		leftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
		leftArm.setRotationPoint(-1.0F, -0.5F, 0.0F);		leftArm2 = new Modchu_ModelRenderer(this, 56, 1);
		leftArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
		leftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);		leftHand = new Modchu_ModelRenderer(this, 56, 3);
		leftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftHandPlus = new Modchu_ModelRenderer(this);
		leftHandPlus.setTextureOffset(60, 5).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
		leftHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftHandPlus.rotateAngleX = 1.570796313F;		rightLeg = new Modchu_ModelRenderer(this, 32, 19);
		rightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
		rightLeg2.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLeg = new Modchu_ModelRenderer(this, 32, 19);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightArmPlus = new Modchu_ModelRenderer(this);
		rightArmPlus2 = new Modchu_ModelRenderer(this);
		leftArmPlus = new Modchu_ModelRenderer(this);
		leftArmPlus2 = new Modchu_ModelRenderer(this);
		rightLegPlus = new Modchu_ModelRenderer(this);
		rightLegPlus2 = new Modchu_ModelRenderer(this);
		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLegPlus2 = new Modchu_ModelRenderer(this);
		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel =
				rightHandPlus.showModel = leftHandPlus.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		//上
		SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXZTop, f - 1.9F);
		SkirtTop.setRotationPoint(-4.0F, -2.0F, -4.0F);		//前
		SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXYFront, f - 1.9F);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//右
		SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeZYRight, f - 1.9F);
		SkirtRight.setRotationPoint(4.0F, 0.0F, 0.0F);		//左
		SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeZYLeft, f - 1.9F);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//後ろ
		SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXYBack, f - 1.9F);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 8.0F);
		setCapsValue(null, caps_visible, Skirt, false);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(Prim);
		bipedHead.addChild(FaceR);
		bipedHead.addChild(FaceL);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		mainFrame.setRotationPoint(0F, 0F, 0F);
		bipedHead.setRotationPoint(0.0F, 15.6F, 0.0F);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.setRotationPoint(0.0F, 14.8F, 0.0F);
		bipedRightArm.setRotationPoint(-1.7F, 2.0F, 0.0F);
		bipedLeftArm.setRotationPoint(1.7F, 2.0F, 0.0F);
		bipedRightLeg.setRotationPoint(-0.2F, 5.5F, 0.0F);
		bipedLeftLeg.setRotationPoint(0.2F, 5.5F, 0.0F);
		Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
		ChignonR.setRotationPoint(0.0F, 0.4F, 0.0F);
		ChignonL.setRotationPoint(0.0F, 0.4F, 0.0F);
		ChignonB.setRotationPoint(0.0F, 0.4F, 0.0F);
		Tail.setRotationPoint(0.0F, 0.4F, 0.0F);
		SideTailR.setRotationPoint(0.0F, 0.4F, 0.0F);
		SideTailL.setRotationPoint(0.0F, 0.4F, 0.0F);
		Prim.setRotationPoint(0.0F, 0.4F, 0.0F);
		FaceR.setRotationPoint(0.0F, 0.0F, 0.0F);
		FaceL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL.setRotationPoint(-0.9F, -2.65F, 0.0F);
		eyeR.setRotationPoint(0.9F, -2.65F, 0.0F);
		Arms[0].setRotationPoint(0.5F, 2.5F, 0F);
		Arms[1].setRotationPoint(-0.5F, 2.5F, 0F);
		HeadMount.setRotationPoint(0F, 0.5F, 0F);
		HeadTop.setRotationPoint(0.0F, -4.0F, 0.0F);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotationPointY = 1.0F;
		bipedBody.rotationPointY = 13.4F;
		bipedRightArm.rotationPointX = -1.7F;
		bipedLeftArm.rotationPointX = 1.7F;
		bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = 2.0F;
		bipedHead.rotationPointZ = 0.0F;
		boolean isSitting = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSitting);
		boolean isRiding = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding);
		bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 5.2F;		if (isSitting
				| isRiding) {
			Skirt.rotationPointY = 4.0F;
			bipedBody.rotationPointY -= isSitting ? 2.5F : 4.0F;
		} else {
			Skirt.rotationPointY = 5.0F;
		}		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			bipedHead.rotationPointY += 0.5F;
			bipedBody.rotationPointY -= 1.0F;
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.1F;
			//Skirt.rotationPointZ = 4.0F;
		} else {
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
		}		boolean eyeFlag = true;
		Object itemstack = getCapsValue(entityCaps, caps_currentArmor, 3);
		if (itemstack != null) {
			int addSupport = addSupportChecks(entityCaps, itemstack, 1);
			if (addSupport == 3 |
					addSupport == 4) eyeFlag = false;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			if (eyeFlag) {
				setCapsValue(entityCaps, caps_visible, eyeR, false);
				setCapsValue(entityCaps, caps_visible, FaceR, false);
			}
		} else {
			if (!eyeFlag
					| (eyeFlag
							&& 0.0D > (mh_sin(f2 * 0.1F) * 0.3F + (Math.random() * 0.1F) + 0.18F))) {
				setCapsValue(entityCaps, caps_visible, eyeL, false);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
				setCapsValue(entityCaps, caps_visible, FaceL, false);
				setCapsValue(entityCaps, caps_visible, FaceR, false);
			} else {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, true);
				setCapsValue(entityCaps, caps_visible, FaceL, true);
				setCapsValue(entityCaps, caps_visible, FaceR, true);
			}
		}
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) return;
		float motionY = (float) getMotionY();
		SkirtFront.rotationPointX = SkirtBack.rotationPointX = motionY * 6.0F;
		SkirtRight.rotationPointZ = SkirtLeft.rotationPointZ = motionY * 2.0F;		SkirtFront.rotationPointY = motionY * 2.0F;
		SkirtFront.rotationPointZ = -motionY * 6.0F;
		SkirtBack.rotationPointY = motionY * 2.0F;
		SkirtBack.rotationPointZ = 8.0F + motionY * 2.0F;
		SkirtLeft.rotationPointX = 4.0F - motionY * 1.0F;		SkirtFront.rotateAngleX = SkirtRight.rotateAngleZ = motionY;
		SkirtLeft.rotateAngleZ = SkirtBack.rotateAngleX = -motionY;		SkirtFront.scaleX = SkirtBack.scaleX = SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.2F);
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		super.actionInit1(entityCaps);
		rightArmPlus.showModel = rightArmPlus2.showModel = leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel = rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel = false;
		rightHandPlus.showModel = leftHandPlus.showModel = true;
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease1(entityCaps);
		rightArmPlus.showModel = rightArmPlus2.showModel = leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel = rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel = rightHandPlus.showModel = leftHandPlus.showModel = false;
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		float f6 = bipedBody.rotateAngleZ;		bipedHead.rotationPointX = -f6 * 1.30597063F;
		//rightLeg.rotationPointY += 0.2F + f6 * 0.93283616F;
		//leftLeg.rotationPointY += 0.5F + f6 * 0.93283616F;
		rightLeg2.rotationPointY -= 1.0F;
		leftLeg2.rotationPointY -= 1.0F - f6 * 0.93283616F;
		rightArm2.rotationPointX = -0.5F;
		leftArm2.rotationPointX = 0.5F;
		rightArm2.rotationPointY = leftArm2.rotationPointY = 1.5F;
		rightHand.rotationPointY = leftHand.rotationPointY = 0.0F;
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.rotationPointY += 5.0F;
		bipedBody.rotationPointY += 10.0F;
		rightLeg.rotationPointY += 1.0F;
		leftLeg.rotationPointY += 1.0F;
		rightLeg2.rotationPointY -= 1.0F;
		leftLeg2.rotationPointY -= 1.0F;
		Skirt.rotationPointY += 14.5F;
		rightArm2.rotationPointY -= 2.0F;
		leftArm2.rotationPointY -= 2.0F;
		rightHand.rotationPointY = 0.0F;
		leftHand.rotationPointY = 0.0F;
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 0.9F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.5F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.7F;
	}	@Override
	public float getRidingYOffset(ModchuModel_IEntityCaps entityCaps) {
		return getYOffset(entityCaps) + 0.4F;
	}	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.6F;
	}	@Override
	public float Physical_Hammer(ModchuModel_IEntityCaps entityCaps) {
		return Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_Physical_Hammer) == 1.0F ? 1.3F : Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_Physical_Hammer);
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}