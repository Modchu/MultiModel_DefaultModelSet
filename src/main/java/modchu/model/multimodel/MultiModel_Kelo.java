package modchu.model.multimodel;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_EntityCapsHelper;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;public class MultiModel_Kelo extends MultiModelOkotaSR2 {	public ModchuModel_ModelRenderer tailL1;
	public ModchuModel_ModelRenderer tailL2;
	public ModchuModel_ModelRenderer tailR1;
	public ModchuModel_ModelRenderer tailR2;
	public ModchuModel_ModelRenderer BreastPocket;
	public ModchuModel_ModelRenderer LsidePocket;
	public ModchuModel_ModelRenderer RsidePocket;
	public ModchuModel_ModelRenderer Backpack;
	public ModchuModel_ModelRenderer BackpackPocket;
	public ModchuModel_ModelRenderer Zipper;
	public ModchuModel_ModelRenderer SleeveR;
	public ModchuModel_ModelRenderer SleeveL;
	public ModchuModel_ModelRenderer ShoesL;
	public ModchuModel_ModelRenderer ShoesR;
	public ModchuModel_ModelRenderer KeloeyeL1;
	public ModchuModel_ModelRenderer KeloeyeR1;
	public ModchuModel_ModelRenderer KeloeyeL2;
	public ModchuModel_ModelRenderer KeloeyeR2;	public ModchuModel_ModelRenderer headwear;
	public ModchuModel_ModelRenderer rightHandPlus;
	public ModchuModel_ModelRenderer leftHandPlus;	public MultiModel_Kelo() {
		this(0.0F);
	}	public MultiModel_Kelo(float f) {
		this(f, 0.0F);
	}	public MultiModel_Kelo(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Kelo(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		tailL1 = new ModchuModel_ModelRenderer(this, 0, 0);
		tailL1.addBox(1.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailL2 = new ModchuModel_ModelRenderer(this, 27, 16);
		tailL2.addBox(2F, -1F, 4.5F, 3, 3, 3, f);
		tailL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailR1 = new ModchuModel_ModelRenderer(this, 0, 4);
		tailR1.addBox(-3.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tailR2 = new ModchuModel_ModelRenderer(this, 48, 19);
		tailR2.addBox(-5F, -1F, 4.5F, 3, 3, 3, f);
		tailR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModchuModel_ModelRenderer(this, 56, 3);
		SideTailL.mirror = true;
		SideTailL.addBox(3.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModchuModel_ModelRenderer(this, 60, 3);
		SideTailR.addBox(-4.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		headwear = new ModchuModel_ModelRenderer(this, 32, 0);
		headwear.addBox(-4F, -8F, -4.5F, 8, 4, 8, f + 0.5F);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonR = new ModchuModel_ModelRenderer(this, 24, 2);
		ChignonR.addBox(-5F, -11F, -2.5F, 4, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new ModchuModel_ModelRenderer(this, 24, 2);
		ChignonL.addBox(1F, -11F, -2.5F, 4, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeL1 = new ModchuModel_ModelRenderer(this, 28, 0);
		KeloeyeL1.addBox(2F, -10F, -2.5F, 2, 2, 0, f - 0.2F);
		KeloeyeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeR1 = new ModchuModel_ModelRenderer(this, 24, 0);
		KeloeyeR1.addBox(-4F, -10F, -2.5F, 2, 2, 0, f - 0.2F);
		KeloeyeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeL2 = new ModchuModel_ModelRenderer(this, 36, 0);
		KeloeyeL2.addBox(2F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		KeloeyeR2 = new ModchuModel_ModelRenderer(this, 32, 0);
		KeloeyeR2.addBox(-4F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new ModchuModel_ModelRenderer(this, 12, 19);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 3, f + 0.3F);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		Backpack = new ModchuModel_ModelRenderer(this, 48, 25);
		Backpack.addBox(-2F, 1F, 1F, 4, 5, 2, f + 0.3F);
		Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackpackPocket = new ModchuModel_ModelRenderer(this, 48, 27);
		BackpackPocket.addBox(-2F, 3.2F, 0.5F, 4, 2, 2, f + 0.6F);
		BackpackPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		BreastPocket = new ModchuModel_ModelRenderer(this, 24, 16);
		BreastPocket.addBox(1F, 2F, -2.5F, 2, 2, 1, f);
		BreastPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		LsidePocket = new ModchuModel_ModelRenderer(this, 32, 12);
		LsidePocket.addBox(2.5F, 6F, -2.5F, 1, 2, 2, f);
		LsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		RsidePocket = new ModchuModel_ModelRenderer(this, 32, 12);
		RsidePocket.addBox(-3.5F, 6F, -2.5F, 1, 2, 2, f);
		RsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		Zipper = new ModchuModel_ModelRenderer(this, 30, 22);
		Zipper.addBox(-1.5F, -1F, -1.5F, 3, 10, 0, f - 1F);
		Zipper.setRotationPoint(0.0F, 0.0F, 0.0F);
		Skirt = new ModchuModel_ModelRenderer(this, 46, 12);
		Skirt.addBox(-3F, -2F, -2F, 6, 2, 3, f + 0.8F);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightArm = new ModchuModel_ModelRenderer(this, 36, 19);
		bipedRightArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.5F);
		SleeveR = new ModchuModel_ModelRenderer(this, 36, 14);
		SleeveR.addBox(-3F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
		bipedLeftArm = new ModchuModel_ModelRenderer(this, 36, 19);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedLeftArm.setRotationPoint(3.5F, 0.0F, 0.5F);
		SleeveL = new ModchuModel_ModelRenderer(this, 36, 14);
		SleeveL.mirror = true;
		SleeveL.addBox(0F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
		bipedRightLeg = new ModchuModel_ModelRenderer(this, 0, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedRightLeg.setRotationPoint(-1.5F, 0.0F, 0.0F);
		bipedLeftLeg = new ModchuModel_ModelRenderer(this, 0, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedLeftLeg.setRotationPoint(1.5F, 0.0F, 0.0F);
		ShoesR = new ModchuModel_ModelRenderer(this, 0, 16);
		ShoesR.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
		ShoesL = new ModchuModel_ModelRenderer(this, 0, 16);
		ShoesL.mirror = true;
		ShoesL.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
		eyeL = new ModchuModel_ModelRenderer(this, 16, 16);
		eyeL.addBox(0F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR = new ModchuModel_ModelRenderer(this, 8, 16);
		eyeR.addBox(-4F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModchuModel_ModelRenderer(this, 36, 19);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm.setRotationPoint(-3.0F, 1.5F + f1, 0.0F);		rightArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModchuModel_ModelRenderer(this, 36, 23);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		rightArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(42, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModchuModel_ModelRenderer(this, 36, 26);
		rightHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);		rightHandPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightHandPlus.setTextureOffset(39, 29)).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		((ModchuModel_ModelRenderer) rightHandPlus.setTextureOffset(39, 29)).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		rightHandPlus.rotateAngleX = 1.570796313F;		leftArm = new ModchuModel_ModelRenderer(this, 36, 19);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm.setRotationPoint(3.0F, 1.5F + f1, 0.0F);		leftArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModchuModel_ModelRenderer(this, 36, 23);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		leftArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(42, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModchuModel_ModelRenderer(this, 36, 26);
		leftHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);		leftHandPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftHandPlus.setTextureOffset(39, 29)).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		((ModchuModel_ModelRenderer) leftHandPlus.setTextureOffset(39, 29)).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		leftHandPlus.rotateAngleX = 1.570796313F;		rightLeg = new ModchuModel_ModelRenderer(this, 0, 19);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightLegPlus.setTextureOffset(3, 24)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModchuModel_ModelRenderer(this, 0, 24);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModchuModel_ModelRenderer(this);
		//rightLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F - 0.5F, 0.01F, 3, 3, 4, f);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(6, 19)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModchuModel_ModelRenderer(this, 0, 19);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModchuModel_ModelRenderer(this);
		leftLegPlus.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus.setTextureOffset(3, 24)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModchuModel_ModelRenderer(this, 0, 24);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModchuModel_ModelRenderer(this);
		leftLegPlus2.mirror = true;
		//leftLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F, 0.01F, 3, 3, 4, f);
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(6, 19)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel =
				rightHandPlus.showModel = leftHandPlus.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(Tail);
		bipedHead.addChild(tailL1);
		bipedHead.addChild(tailL2);
		bipedHead.addChild(tailR1);
		bipedHead.addChild(tailR2);
		bipedHead.addChild(SideTailL);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(headwear);
		bipedHead.addChild(ChignonR);
		bipedHead.addChild(ChignonL);
		bipedHead.addChild(KeloeyeL1);
		bipedHead.addChild(KeloeyeR1);
		bipedHead.addChild(KeloeyeL2);
		bipedHead.addChild(KeloeyeR2);
		bipedBody.addChild(Backpack);
		bipedBody.addChild(BackpackPocket);
		bipedBody.addChild(BreastPocket);
		bipedBody.addChild(LsidePocket);
		bipedBody.addChild(RsidePocket);
		bipedBody.addChild(Zipper);
		bipedRightArm.addChild(SleeveR);
		bipedLeftArm.addChild(SleeveL);
		bipedRightLeg.addChild(ShoesR);
		bipedLeftLeg.addChild(ShoesL);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		mainFrame.setRotationPoint(0F, -2F, 0F);
		bipedRightLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 1.4F * f1) / 1.5F;
		bipedLeftLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F + 3.141593F) * 1.4F * f1) / 1.5F;
		setCapsValue(entityCaps, caps_visible, KeloeyeL1, true);
		setCapsValue(entityCaps, caps_visible, KeloeyeR1, true);
		setCapsValue(entityCaps, caps_visible, KeloeyeL2, false);
		setCapsValue(entityCaps, caps_visible, KeloeyeR2, false);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			bipedRightLeg.rotateAngleX = -1.256637F;
			bipedLeftLeg.rotateAngleX = -1.256637F;
			bipedRightLeg.rotateAngleY = 0.3141593F;
			bipedLeftLeg.rotateAngleY = -0.3141593F;
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		if (armSwingFlag(entityCaps)) {
			bipedRightArm.rotationPointZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, bipedBody.rotateAngleY) * 4F;
			bipedRightArm.rotationPointX = -Modchu_AS.getFloat(Modchu_AS.mathHelperCos, bipedBody.rotateAngleY) * 3.5F + 1.0F;
			bipedLeftArm.rotationPointZ = -Modchu_AS.getFloat(Modchu_AS.mathHelperSin, bipedBody.rotateAngleY) * 4F;
			bipedLeftArm.rotationPointX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, bipedBody.rotateAngleY) * 3.5F - 1.0F;
		}
		Skirt.rotationPointY = 10.0F;
		bipedHead.rotationPointY =
		bipedRightArm.rotationPointY =
		bipedLeftArm.rotationPointY = 0.0F;
		bipedRightLeg.rotationPointY =
		bipedLeftLeg.rotationPointY = 10.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			upperBody.rotateAngleX = 0.5F;
			bipedBody.rotationPointY = 7.0F;
			bipedRightLeg.rotationPointZ =
					bipedLeftLeg.rotationPointZ -= 0.6F;
			bipedRightLeg.rotationPointY =
					bipedLeftLeg.rotationPointY -= 0.4F;
			//Skirt.rotationPointZ = bipedRightLeg.rotationPointZ + 1.0F;
			Skirt.rotationPointY = 9.5F;
			//Skirt.rotateAngleX += 0.3F;
		} else {
			bipedBody.rotationPointY = 6.0F;
			//Skirt.rotationPointZ = 0.0F;
		}		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, KeloeyeL1, false);
			setCapsValue(entityCaps, caps_visible, KeloeyeR1, false);
			setCapsValue(entityCaps, caps_visible, KeloeyeL2, true);
			setCapsValue(entityCaps, caps_visible, KeloeyeR2, true);
		}
		headwear.rotateAngleX = -0.087F;
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"bipedHeadwear", "ChignonB", "Tail", "d"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
		String[] s1 = {
				"BreastPocket", "LsidePocket", "RsidePocket", "BackpackPocket"
		};
		String[] s2 = {
				"B_Pocket", "L_Pocket", "R_Pocket", "B_packPocket"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
		setCapsValue(entityCaps, caps_visible, bipedHeadwear, false);
		setCapsValue(entityCaps, caps_visible, ChignonB, false);
		setCapsValue(entityCaps, caps_visible, Tail, false);
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) > 1) {			setCapsValue(entityCaps, caps_visible, Skirt, true);		}	}	@Override
	public void actionPartsAddChild() {
		super.actionPartsAddChild();
		setCapsValue(null, caps_visible, rightHandPlus, true);
		setCapsValue(null, caps_visible, leftHandPlus, true);
		bipedRightArm.removeChild(SleeveR);
		bipedLeftArm.removeChild(SleeveL);
		bipedRightLeg.removeChild(ShoesR);
		bipedLeftLeg.removeChild(ShoesL);
		rightArm2.addChild(SleeveR);
		leftArm2.addChild(SleeveL);
		rightLeg2.addChild(ShoesR);
		leftLeg2.addChild(ShoesL);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease1(entityCaps);
/*
		rightHandPlus.showModel = leftHandPlus.showModel = false;
		bipedRightArm.addChild(SleeveR);
		bipedLeftArm.addChild(SleeveL);
		bipedRightLeg.addChild(ShoesR);
		bipedLeftLeg.addChild(ShoesL);
		rightArm2.removeChild(SleeveR);
		leftArm2.removeChild(SleeveL);
		rightLeg2.removeChild(ShoesR);
		leftLeg2.removeChild(ShoesL);
*/
		SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
		SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
		ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
		ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotationPointX = 0.0F;
		bipedBody.rotationPointY = 6.0F;
		//rightArm.rotationPointY = 1.0F;
		rightArm2.rotationPointX = 0.5F;
		//rightArm2.rotationPointY = 3.5F;
		//rightLeg.rotationPointX -= 0.5F;
		//rightLeg2.rotationPointY -= 5.0F;
		rightHand.rotationPointX = rightArm2.rotationPointX;
		//rightHand.rotationPointY = rightArm2.rotationPointY;
		rightHand.rotationPointZ = rightArm2.rotationPointZ + 0.5F;		//leftArm.rotationPointY = 1.0F;
		leftArm2.rotationPointX = 0.0F;
		//leftArm2.rotationPointY = 4.5F;
		//leftLeg.rotationPointX += 0.5F;
		//leftLeg2.rotationPointY -= 5.0F;
		leftHand.rotationPointX = leftArm2.rotationPointX + 0.5F;
		leftHand.rotationPointY = leftArm2.rotationPointY;
		leftHand.rotationPointZ = leftArm2.rotationPointZ + 0.5F;		SleeveR.setRotationPoint(2.0F, -2.0F, 1.0F);
		SleeveL.setRotationPoint(-1.0F, -2.0F, 1.0F);
		ShoesR.setRotationPoint(0.5F, -5.0F, 0.5F);
		ShoesL.setRotationPoint(0.5F, -5.0F, 0.5F);
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.rotationPointY += 3.0F;
		bipedBody.rotationPointY += 2.0F;
		Skirt.rotationPointY += 11.0F;
		rightArm2.rotationPointY -= 1.0F;
		leftArm2.rotationPointY -= 1.0F;
		rightHand.rotationPointX = 0.5F;
		rightHand.rotationPointZ = 0.5F;
		leftHand.rotationPointX = 0.5F;
		leftHand.rotationPointZ = 0.5F;
		SleeveR.setRotationPoint(2.0F, -2.0F, 1.0F);
		SleeveL.setRotationPoint(-1.0F, -2.0F, 1.0F);
		ShoesR.setRotationPoint(0.5F, -5.0F, 0.5F);
		ShoesL.setRotationPoint(0.5F, -5.0F, 0.5F);
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.6F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.7F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.2F;
	}	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		float d = 0.85F;
		return d;
	}	@Override
	public double getSittingYOffset(ModchuModel_IEntityCaps entityCaps) {
		return -0.5D;
	}	@Override
	public float ridingViewCorrection(ModchuModel_IEntityCaps entityCaps) {
		return -0.75F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
	@Override	public String[] getBreastName() {		return null;	}}