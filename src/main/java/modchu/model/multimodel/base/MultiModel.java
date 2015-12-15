package modchu.model.multimodel.base;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.Modchu_ModelPlateMaster;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;public class MultiModel extends MultiModelMaidBone {	public ModchuModel_ModelRenderer ChignonR;
	public ModchuModel_ModelRenderer ChignonL;
	public ModchuModel_ModelRenderer ChignonB;
	public ModchuModel_ModelRenderer Tail;
	public ModchuModel_ModelRenderer SideTailR;
	public ModchuModel_ModelRenderer SideTailL;	public MultiModel() {
		this(0.0F);
	}	public MultiModel(float f) {
		this(f, 0.0F);
	}	public MultiModel(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel(float f, float f1, int i, int j, Object... o) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j, (Object[]) o);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {		super.initModel(f, f1, false);		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHeadwear.setTextureOffset(24, 0);
		bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
		bipedBody.setTextureOffset(32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedRightArm.setTextureOffset(48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setTextureOffset(56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightLeg.setTextureOffset(32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setTextureOffset(32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		Skirt.setTextureOffset(0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		ChignonR = new ModchuModel_ModelRenderer(this, 24, 18, "ChignonR");
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new ModchuModel_ModelRenderer(this, 24, 18, "ChignonL");
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonB = new ModchuModel_ModelRenderer(this, 52, 10, "ChignonB");
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail = new ModchuModel_ModelRenderer(this, 46, 20, "Tail");
		Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModchuModel_ModelRenderer(this, 58, 21, "SideTailR");
		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModchuModel_ModelRenderer(this, 58, 21, "SideTailL");
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);				//ModelBase modelBase = new ModelBiped();		//test = new ModelRenderer(modelBase);		//test.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);		if (isAfterInit) afterInit(f, f1);
	}	@Override	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {		super.render(entityCaps, f, f1, f2, pheadYaw, pheadPitch, f5, pIsRender);		//test.render(f5);	}	@Override
	public void actionPartsInit(float f, float f1) {		super.actionPartsInit(f, f1);
		rightArm.setTextureOffset(48, 0);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		//rightArmPlus.setTextureOffset(52, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2.setTextureOffset(48, 3);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand.setTextureOffset(48, 6);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm.setTextureOffset(56, 0);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		//leftArmPlus.setTextureOffset(60, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2.setTextureOffset(56, 3);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand.setTextureOffset(56, 6);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg.setTextureOffset(32, 19);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		((ModchuModel_ModelRenderer) rightLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2.setTextureOffset(32, 23);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg.setTextureOffset(32, 19);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2.setTextureOffset(32, 23);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;	}	/**
	 * ふんわりスカート初期化
	 */
	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;		super.skirtFloatsInit(f, f1);
		//ふんわりスカート上
		SkirtTop.setTextureOffset(8, 16);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, Modchu_ModelPlateMaster.planeXZTop);
		SkirtTop.setRotationPoint(-4.0F, -4.0F, -4.0F);		//ふんわりスカート前
		SkirtFront.setTextureOffset(8, 24);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, Modchu_ModelPlateMaster.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート右
		SkirtRight.setTextureOffset(0, 24);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, Modchu_ModelPlateMaster.planeZYRight);
		SkirtRight.setRotationPoint(8.0F, 0.0F, 0.0F);		//ふんわりスカート左
		SkirtLeft.setTextureOffset(16, 24);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, Modchu_ModelPlateMaster.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート後ろ
		SkirtBack.setTextureOffset(24, 24);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, Modchu_ModelPlateMaster.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 8.0F);
	}	@Override	public void defaultAddChildSetting() {		super.defaultAddChildSetting();
		if (ChignonR != null) ChignonR.clearChildModels();
		if (ChignonL != null) ChignonL.clearChildModels();
		if (ChignonB != null) ChignonB.clearChildModels();
		if (Tail != null) Tail.clearChildModels();
		if (SideTailR != null) SideTailR.clearChildModels();
		if (SideTailL != null) SideTailL.clearChildModels();
		if (bipedHead != null) {
			if (ChignonR != null) bipedHead.addChild(ChignonR);
			if (ChignonL != null) bipedHead.addChild(ChignonL);
			if (ChignonB != null) bipedHead.addChild(ChignonB);
			if (Tail != null) bipedHead.addChild(Tail);
			if (SideTailR != null) bipedHead.addChild(SideTailR);
			if (SideTailL != null) bipedHead.addChild(SideTailL);
		}
	}	@Override	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {			bipedRightLeg.rotateAngleX -= 1.0F;			bipedLeftLeg.rotateAngleX -= 1.0F;		}	}
}