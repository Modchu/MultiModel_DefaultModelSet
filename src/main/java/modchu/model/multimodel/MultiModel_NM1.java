package modchu.model.multimodel;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_NM1 extends MultiModel_SR2 {
	public ModchuModel_ModelRenderer Headwear;
	public ModchuModel_ModelRenderer HornR1;
	public ModchuModel_ModelRenderer HornR2;
	public ModchuModel_ModelRenderer HornR3;
	public ModchuModel_ModelRenderer HornR4;
	public ModchuModel_ModelRenderer HeadwearR;
	public ModchuModel_ModelRenderer HornL1;
	public ModchuModel_ModelRenderer HornL2;
	public ModchuModel_ModelRenderer HornL3;
	public ModchuModel_ModelRenderer HornL4;
	public ModchuModel_ModelRenderer HeadwearL;
	public ModchuModel_ModelRenderer ArmR1;
	public ModchuModel_ModelRenderer ArmL1;
	public ModchuModel_ModelRenderer HandR1;
	public ModchuModel_ModelRenderer HandR2;
	public ModchuModel_ModelRenderer HandL1;
	public ModchuModel_ModelRenderer HandL2;
	public ModchuModel_ModelRenderer LegR1;
	public ModchuModel_ModelRenderer LegR2;
	public ModchuModel_ModelRenderer LegR3;
	public ModchuModel_ModelRenderer LegR4;
	public ModchuModel_ModelRenderer LegR5;
	public ModchuModel_ModelRenderer LegR6;
	public ModchuModel_ModelRenderer LegL1;
	public ModchuModel_ModelRenderer LegL2;
	public ModchuModel_ModelRenderer LegL3;
	public ModchuModel_ModelRenderer LegL4;
	public ModchuModel_ModelRenderer LegL5;
	public ModchuModel_ModelRenderer LegL6;
	public ModchuModel_ModelRenderer bootR1;
	public ModchuModel_ModelRenderer bootR2;
	public ModchuModel_ModelRenderer bootL1;
	public ModchuModel_ModelRenderer bootL2;
	public ModchuModel_ModelRenderer eyeR1;
	public ModchuModel_ModelRenderer eyeL1;
	public ModchuModel_ModelRenderer Breast;
	public ModchuModel_ModelRenderer Cachusya;
	public ModchuModel_ModelRenderer tie;	public MultiModel_NM1() {
		this(0.0F);
	}	public MultiModel_NM1(float f) {
		this(f, 0.0F);
	}	public MultiModel_NM1(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_NM1(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new ModchuModel_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		Headwear = new ModchuModel_ModelRenderer(this, 0, 28);
		Headwear.addBox(-4.0F, 0.0F, 1.0F, 8, 12, 3, f);
		Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		Headwear.setRotateAngleX(0.2094395F);
		bipedBody = new ModchuModel_ModelRenderer(this, 32, 0);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 9, 4, f);
		bipedBody.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedRightArm = new ModchuModel_ModelRenderer(this, 0, 16);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, -2.0F, 0.0F);
		bipedLeftArm = new ModchuModel_ModelRenderer(this, 8, 16);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, -2.0F, 0.0F);
		bipedRightLeg = new ModchuModel_ModelRenderer(this, 32, 13);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, f);
		bipedRightLeg.setRotationPoint(-1.0F, 13F, 0.0F);
		bipedLeftLeg = new ModchuModel_ModelRenderer(this, 32, 13);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, f);
		bipedLeftLeg.setRotationPoint(1.0F, 13F, 0.0F);
		Skirt = new ModchuModel_ModelRenderer(this, 36, 44);
		Skirt.addBox(-4F, -3F, -3.5F, 8, 14, 6, f);
		Skirt.setRotationPoint(0.0F, -4.0F, 0.0F);
		ChignonB = new ModchuModel_ModelRenderer(this, 24, 58);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR1 = new ModchuModel_ModelRenderer(this, 52, 28);
		HornR1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
		HornR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR1.setRotateAngleZ(-0.3839724F);
		HornR2 = new ModchuModel_ModelRenderer(this, 58, 18);
		HornR2.addBox(-6.9F, -11.3F, 0.0F, 1, 4, 1, f);
		HornR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR2.setRotateAngleZ(0.2792527F);
		HornR3 = new ModchuModel_ModelRenderer(this, 52, 22);
		HornR3.addBox(-4.2F, -13F, 0.0F, 1, 4, 1, f);
		HornR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR3.setRotateAngleZ(0.0523599F);
		HornR4 = new ModchuModel_ModelRenderer(this, 53, 18);
		HornR4.addBox(-2.4F, -15.2F, 0.0F, 1, 2, 1, f);
		HornR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornR4.setRotateAngleZ(-0.0872665F);
		HeadwearR = new ModchuModel_ModelRenderer(this, 0, 0);
		HeadwearR.addBox(-4F, 0.0F, -4F, 1, 4, 2, f);
		HeadwearR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmR1 = new ModchuModel_ModelRenderer(this, 28, 29);
		ArmR1.addBox(-2F, 4.5F, -1F, 2, 1, 2, f + 0.5F);
		ArmR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandR1 = new ModchuModel_ModelRenderer(this, 16, 24);
		HandR1.addBox(-2F, 7.5F, -1F, 2, 2, 2, f + 0.4F);
		HandR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandR2 = new ModchuModel_ModelRenderer(this, 16, 16);
		HandR2.addBox(-2F, 6F, -1F, 2, 3, 2, f + 0.2F);
		HandR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR1 = new ModchuModel_ModelRenderer(this, 0, 47);
		LegR1.addBox(-2.5F, 2.0F, -2F, 1, 2, 4, f);
		LegR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR2 = new ModchuModel_ModelRenderer(this, 0, 43);
		LegR2.addBox(-2F, 2.4F, -3F, 3, 2, 1, f);
		LegR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR3 = new ModchuModel_ModelRenderer(this, 11, 44);
		LegR3.addBox(-2F, 5F, 0.0F, 3, 1, 3, f);
		LegR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR4 = new ModchuModel_ModelRenderer(this, 5, 53);
		LegR4.addBox(-1F, 2.7F, -5F, 1, 1, 2, f);
		LegR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR5 = new ModchuModel_ModelRenderer(this, 0, 53);
		LegR5.addBox(-1F, 2.7F, -3.5F, 1, 2, 1, f);
		LegR5.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegR6 = new ModchuModel_ModelRenderer(this, 28, 35);
		LegR6.addBox(-3F, 13F, -2F, 3, 11, 4, f + 0.1F);
		LegR6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR1 = new ModchuModel_ModelRenderer(this, 0, 57);
		bootR1.addBox(-1.0F, 10F, -3F, 2, 1, 1, f);
		bootR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR2 = new ModchuModel_ModelRenderer(this, 0, 53);
		bootR2.addBox(-0.5F, 8F, -6F, 1, 2, 1, f);
		bootR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootR2.setRotateAngleX(0.2792527F);
		HornL1 = new ModchuModel_ModelRenderer(this, 52, 28);
		HornL1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
		HornL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL1.setRotateAngleZ(0.3839724F);
		HornL2 = new ModchuModel_ModelRenderer(this, 58, 18);
		HornL2.addBox(5.9F, -11.3F, 0.0F, 1, 4, 1, f);
		HornL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL2.setRotateAngleZ(-0.2792527F);
		HornL3 = new ModchuModel_ModelRenderer(this, 52, 22);
		HornL3.addBox(3.2F, -13F, 0.0F, 1, 4, 1, f);
		HornL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL3.setRotateAngleZ(-0.0523599F);
		HornL4 = new ModchuModel_ModelRenderer(this, 53, 18);
		HornL4.addBox(1.4F, -15.2F, 0.0F, 1, 2, 1, f);
		HornL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		HornL4.setRotateAngleZ(0.0872665F);
		HeadwearL = new ModchuModel_ModelRenderer(this, 24, 0);
		HeadwearL.addBox(3F, 0.0F, -4F, 1, 4, 2, f);
		HeadwearL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ArmL1 = new ModchuModel_ModelRenderer(this, 41, 29);
		ArmL1.addBox(0.0F, 4.5F, -1F, 2, 1, 2, f + 0.5F);
		ArmL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandL1 = new ModchuModel_ModelRenderer(this, 24, 24);
		HandL1.addBox(0.0F, 7.5F, -1F, 2, 2, 2, f + 0.4F);
		HandL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HandL2 = new ModchuModel_ModelRenderer(this, 24, 16);
		HandL2.addBox(0.0F, 6F, -1F, 2, 3, 2, f + 0.2F);
		HandL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL1 = new ModchuModel_ModelRenderer(this, 0, 47);
		LegL1.addBox(1.5F, 2.0F, -2F, 1, 2, 4, f);
		LegL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL2 = new ModchuModel_ModelRenderer(this, 0, 43);
		LegL2.addBox(-1F, 2.4F, -3F, 3, 2, 1, f);
		LegL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL3 = new ModchuModel_ModelRenderer(this, 11, 44);
		LegL3.addBox(-1F, 5F, 0.0F, 3, 1, 3, f);
		LegL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL4 = new ModchuModel_ModelRenderer(this, 5, 53);
		LegL4.addBox(0.0F, 2.7F, -5F, 1, 1, 2, f);
		LegL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL5 = new ModchuModel_ModelRenderer(this, 0, 53);
		LegL5.addBox(0.0F, 2.7F, -3.5F, 1, 2, 1, f);
		LegL5.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegL6 = new ModchuModel_ModelRenderer(this, 28, 35);
		LegL6.addBox(0.0F, 13F, -2F, 3, 11, 4, f + 0.1F);
		LegL6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL1 = new ModchuModel_ModelRenderer(this, 0, 57);
		bootL1.addBox(-1.0F, 10F, -3F, 2, 1, 1, f);
		bootL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL2 = new ModchuModel_ModelRenderer(this, 0, 53);
		bootL2.addBox(-0.5F, 8F, -6F, 1, 2, 1, f);
		bootL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bootL2.setRotateAngleX(0.2792527F);
		Breast = new ModchuModel_ModelRenderer(this, 53, 0);
		Breast.addBox(0.0F, -2.5F, 0.0F, 3, 5, 2, f);
		Breast.setRotationPoint(0.0F, -1.0F, -2F);
		Breast.setRotateAngleZ(((float) Math.PI / 2F));
		Breast.setRotateAngleY(((float) Math.PI * 2F / 9F));
		eyeR = new ModchuModel_ModelRenderer(this, 32, 0);
		eyeR.addPlate(-4F, -4F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModchuModel_ModelRenderer(this, 47, 0);
		eyeL.addPlate(0.0F, -4F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR1 = new ModchuModel_ModelRenderer(this, 52, 13);
		eyeR1.addPlate(-4F, -4F, -4.002F, 4, 4, 0, f);
		eyeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL1 = new ModchuModel_ModelRenderer(this, 56, 13);
		eyeL1.addPlate(0.0F, -4F, -4.002F, 4, 4, 0, f);
		eyeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cachusya = new ModchuModel_ModelRenderer(this, 0, 7);
		Cachusya.addPlate(-2F, -9F, -4F, 4, 1, 0, f);
		Cachusya.setRotationPoint(0.0F, 0.0F, 0.0F);
		tie = new ModchuModel_ModelRenderer(this, 24, 6);
		tie.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, f + 0.1F);
		tie.setRotationPoint(-0.5F, -8F + f1, -2.1F);
		mainFrame = new ModchuModel_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);		setCapsValue(null, caps_visible, HornR1, false);
		setCapsValue(null, caps_visible, HornR2, false);
		setCapsValue(null, caps_visible, HornR3, false);
		setCapsValue(null, caps_visible, HornR4, false);
		setCapsValue(null, caps_visible, HornL1, false);
		setCapsValue(null, caps_visible, HornL2, false);
		setCapsValue(null, caps_visible, HornL3, false);
		setCapsValue(null, caps_visible, HornL4, false);
		setCapsValue(null, caps_visible, ArmR1, false);
		setCapsValue(null, caps_visible, HandR1, false);
		setCapsValue(null, caps_visible, HandR2, false);
		setCapsValue(null, caps_visible, ArmL1, false);
		setCapsValue(null, caps_visible, HandL1, false);
		setCapsValue(null, caps_visible, HandL2, false);
		setCapsValue(null, caps_visible, LegR1, false);
		setCapsValue(null, caps_visible, LegR2, false);
		setCapsValue(null, caps_visible, LegR3, false);
		setCapsValue(null, caps_visible, LegR4, false);
		setCapsValue(null, caps_visible, LegR5, false);
		setCapsValue(null, caps_visible, LegL1, false);
		setCapsValue(null, caps_visible, LegL2, false);
		setCapsValue(null, caps_visible, LegL3, false);
		setCapsValue(null, caps_visible, LegL4, false);
		setCapsValue(null, caps_visible, LegL5, false);
		setCapsValue(null, caps_visible, bipedLeftLeg, false);
		setCapsValue(null, caps_visible, bipedRightLeg, false);
		setCapsValue(null, caps_visible, bootR1, false);
		setCapsValue(null, caps_visible, bootR2, false);
		setCapsValue(null, caps_visible, bootL1, false);
		setCapsValue(null, caps_visible, bootL2, false);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModchuModel_ModelRenderer(this, 0, 16);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm.setRotationPoint(-3.0F, 1.5F + f1, 0.0F);		rightArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus.setTextureOffset(4, 16)).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModchuModel_ModelRenderer(this, 0, 19);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		rightArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(4, 16)).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(4, 16)).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModchuModel_ModelRenderer(this, 0, 22);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);		leftArm = new ModchuModel_ModelRenderer(this, 8, 16);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm.setRotationPoint(3.0F, 1.5F + f1, 0.0F);		leftArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus.setTextureOffset(12, 16)).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModchuModel_ModelRenderer(this, 8, 20);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);		leftArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(12, 16)).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(12, 16)).addPlate(-1.0F, -1.0F, -4.01F, 2, 2, 4, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModchuModel_ModelRenderer(this, 8, 24);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);		rightLeg = new ModchuModel_ModelRenderer(this, 32, 13);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModchuModel_ModelRenderer(this, 32, 18);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -6.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModchuModel_ModelRenderer(this, 32, 13);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModchuModel_ModelRenderer(this);
		leftLegPlus.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModchuModel_ModelRenderer(this, 32, 18);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModchuModel_ModelRenderer(this);
		leftLegPlus2.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(36, 13)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(39, 13)).addPlate(-1.5F, -2.0F, -6.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedHead.removeChild(Tail);
		bipedHead.addChild(Headwear);
		bipedHead.addChild(Cachusya);
		bipedHead.addChild(eyeR1);
		bipedHead.addChild(eyeL1);
		bipedHead.addChild(HornR1);
		bipedHead.addChild(HornR2);
		bipedHead.addChild(HornR3);
		bipedHead.addChild(HornR4);
		bipedHead.addChild(HeadwearR);
		bipedHead.addChild(HornL1);
		bipedHead.addChild(HornL2);
		bipedHead.addChild(HornL3);
		bipedHead.addChild(HornL4);
		bipedHead.addChild(HornL4);
		bipedHead.addChild(HeadwearL);
		bipedBody.addChild(Breast);
		bipedBody.addChild(tie);
		bipedRightArm.addChild(ArmR1);
		bipedRightArm.addChild(HandR1);
		bipedRightArm.addChild(HandR2);
		bipedLeftArm.addChild(ArmL1);
		bipedLeftArm.addChild(HandL1);
		bipedLeftArm.addChild(HandL2);
		bipedRightLeg.addChild(LegR1);
		bipedRightLeg.addChild(LegR2);
		bipedRightLeg.addChild(LegR3);
		bipedRightLeg.addChild(LegR4);
		bipedRightLeg.addChild(LegR5);
		bipedRightLeg.addChild(bootR1);
		bipedRightLeg.addChild(bootR2);
		bipedLeftLeg.addChild(LegL1);
		bipedLeftLeg.addChild(LegL2);
		bipedLeftLeg.addChild(LegL3);
		bipedLeftLeg.addChild(LegL4);
		bipedLeftLeg.addChild(LegL5);
		bipedLeftLeg.addChild(bootL1);
		bipedLeftLeg.addChild(bootL2);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Arms[0].setRotationPoint(0.5F, 9.0F, 0F);
		Arms[1].setRotationPoint(-0.5F, 9.0F, 0F);
		Arms[0].rotateAngleX =
		Arms[0].rotateAngleY =
		Arms[0].rotateAngleZ =
		Arms[1].rotateAngleX =
		Arms[1].rotateAngleY =
		Arms[1].rotateAngleZ = 0F;
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = (float)ticksExisted + f2 + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);		eyeR.showModel = eyeL.showModel =
		eyeR1.showModel = eyeL1.showModel = false;
		Skirt.showModel = true;
		HornR1.showModel = HornR2.showModel =
		HornR3.showModel = HornR4.showModel =
		HornL1.showModel = HornL2.showModel =
		HornL3.showModel = HornL4.showModel =
		ArmR1.showModel = HandR1.showModel =
		HandR2.showModel = ArmL1.showModel =
		HandL1.showModel = HandL2.showModel =
		LegR1.showModel = LegR2.showModel =
		LegR3.showModel = LegR4.showModel =
		LegR5.showModel = LegL1.showModel =
		LegL2.showModel = LegL3.showModel =
		LegL4.showModel = LegL5.showModel = false;
		LegR6.showModel = LegR6.showModel = true;
		bipedLeftLeg.showModel = bipedRightLeg.showModel =
		bootR1.showModel = bootR2.showModel =
		bootL1.showModel = bootL2.showModel = false;
		byte entityType = Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType);		if (entityType == entityCaps.entityType_LMM				&& entityType == entityCaps.entityType_ModchuLMM						&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {			boolean isWorkingDelay = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWorkingDelay);
			if (isWorkingDelay) {
//-@-125
				int maidMode = (Integer) Modchu_Reflect.invokeMethod(entityliving.getClass(), "getMaidModeInt", entityliving);				int i = 0x00C0;
				int i1 = 0x0021;
//@-@125
/*//125delete
				int maidMode = (Integer)getObjectInvokeMethod(LMM_EntityLittleMaid, "getMaidMode", entityliving);
				int i = 4;
				int i1 = 7;
*///125delete
				if (maidMode == i | maidMode == i1) {
					eyeR1.showModel = eyeL1.showModel = true;
					Skirt.showModel = false;
					HornR1.showModel = HornR2.showModel =
					HornR3.showModel = HornR4.showModel =
					HornL1.showModel = HornL2.showModel =
					HornL3.showModel = HornL4.showModel =
					ArmR1.showModel = HandR1.showModel =
					HandR2.showModel = ArmL1.showModel =
					HandL1.showModel = HandL2.showModel =
					LegR1.showModel = LegR2.showModel =
					LegR3.showModel = LegR4.showModel =
					LegR5.showModel = LegL1.showModel =
					LegL2.showModel = LegL3.showModel =
					LegL4.showModel = LegL5.showModel = true;
					LegR6.showModel = LegR6.showModel = false;
					bipedLeftLeg.showModel = bipedRightLeg.showModel =
					bootR1.showModel = bootR2.showModel =
					bootL1.showModel = bootL2.showModel = true;
				}
			}
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		bipedHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F + (float) Math.PI) * 1.6F * f1 * 0.5F;
		bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F) * 1.6F * f1 * 0.5F;
		bipedRightArm.rotateAngleZ =
		bipedLeftArm.rotateAngleZ = 0.0F;
		bipedRightLeg.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F) * 1.0F * f1;
		bipedLeftLeg.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.5656F + (float) Math.PI) * 1.0F * f1;
		bipedRightLeg.rotateAngleY =
		bipedLeftLeg.rotateAngleY = 0.0F;
		bipedBody.rotationPointY = 8.0F;
		bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = -3.5F;
		bipedLeftArm.rotationPointX = 3.0F;
		bipedLeftArm.rotationPointZ = 0.0F;
		Breast.rotationPointY = -2.5F;		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
			bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}		bipedRightArm.rotateAngleY =		bipedLeftArm.rotateAngleY = 0.0F;		int version = Modchu_Main.getMinecraftVersion();		boolean flag = version > 189;		// アイテム持ってるときの腕振りを抑える+表示角オフセット		if (heldItem[1] != 0) {			if (heldItem[1] == 3) {				bipedLeftArm.rotateAngleX = flag ? bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F : -0.8F;				bipedLeftArm.rotateAngleY = flag ? 0.5235988F : -0.4F;				if (flag) {					if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) Arms[1].setRotateAngle(-0.24F, -0.48F, 0.36F);					//Arms[1].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");				}			} else {				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[1];			}		}		if (heldItem[0] != 0) {			if (heldItem[0] == 3) {				bipedRightArm.rotateAngleX = flag ? bipedRightArm.rotateAngleX * 0.5F - 0.9424779F : -0.8F;				bipedRightArm.rotateAngleY = flag ? -0.5235988F : -0.4F;				if (flag) {					if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) Arms[0].setRotateAngle(-0.12F, -0.22F, -0.56F);					//Arms[0].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");				}			} else {				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[0];			}		}		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		bipedBody.rotateAngleX =
		bipedBody.rotateAngleY =
		bipedBody.rotateAngleZ = 0.0F;
		bipedBody.rotationPointZ = 0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			upperBody.rotateAngleX = 0.5F;
			bipedHead.rotateAngleX -= 0.5F;
			bipedHead.rotationPointY = -3F;
			//bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 2.4F;
			bipedBody.rotationPointY -= 1.0F;
			Skirt.rotateAngleX = -upperBody.rotateAngleX;
			Skirt.rotationPointY = 4.3F;
			//Skirt.rotationPointZ = 3.0F;
		} else {
			upperBody.rotateAngleX = 0.0F;
			bipedHead.rotationPointY = -3F;
			bipedRightLeg.rotationPointX = -1.5F;
			bipedLeftLeg.rotationPointX = 1.5F;
			bipedRightLeg.rotationPointY =
			bipedLeftLeg.rotationPointY = 5.5F;
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
			Skirt.rotationPointY = 5.5F;
			Skirt.rotationPointZ =
			Skirt.rotateAngleX = 0.0F;
		}		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
			bipedRightArm.rotateAngleY = 0.0F;
			bipedRightArm.rotateAngleZ = -0.4F;
			bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
			bipedLeftArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.4F;
			Arms[0].rotationPointX -= 2.0F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			Arms[1].rotationPointX += 2.0F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			float f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[dominantArm] * (float) Math.PI);
			float f9 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * (float) Math.PI);
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f7 * 0.6F);
			bipedLeftArm.rotateAngleY = 0.1F - f7 * 0.6F;
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedLeftArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f7 * 1.2F - f9 * 0.4F;
			bipedLeftArm.rotateAngleX -= f7 * 1.2F - f9 * 0.4F;
			bipedRightArm.rotateAngleZ += Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX -= Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX -= bipedHead.rotateAngleX;
			bipedRightArm.rotateAngleY += bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY += bipedHead.rotateAngleY;
		} else {
			if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
				bipedRightArm.rotateAngleZ += 0.3F;
				bipedLeftArm.rotateAngleZ -= 0.3F;
				bipedRightArm.rotateAngleZ += Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			}
		}
		breastFloats(f, f1, f2, f3, f4, f5, entityCaps);		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void defaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {
		int i = Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType);
		//bipedRightLeg Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "bipedRightLeg", i, false);
		//bipedLeftLeg Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "bipedLeftLeg", i, false);
		//HornR Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "HornR", i, false);
		//HornL Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "HornL", i, false);
		//ArmR Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "ArmR", i, false);
		//ArmL Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "ArmL", i, false);
		//LegR Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "LegR", i, false);
		//LegL Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "LegL", i, false);
		//HandR Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "HandR", i, false);
		//HandL Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "HandL", i, false);
		//bootR Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "bootR", i, false);
		//bootL Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "bootL", i, false);
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		boolean b = bipedRightLeg.showModel;
		boolean b1 = bipedLeftLeg.showModel;
		super.actionInit1(entityCaps);
		setCapsValue(entityCaps, caps_visible, rightLeg, b);
		setCapsValue(entityCaps, caps_visible, rightLeg2, b);
		setCapsValue(entityCaps, caps_visible, rightLegPlus, b);
		setCapsValue(entityCaps, caps_visible, rightLegPlus2, b);
		setCapsValue(entityCaps, caps_visible, leftLeg, b);
		setCapsValue(entityCaps, caps_visible, leftLeg2, b);
		setCapsValue(entityCaps, caps_visible, leftLegPlus, b);
		setCapsValue(entityCaps, caps_visible, leftLegPlus2, b);
		bipedRightArm.removeChild(ArmR1);
		bipedRightArm.removeChild(HandR1);
		bipedRightArm.removeChild(HandR2);
		bipedLeftArm.removeChild(ArmL1);
		bipedLeftArm.removeChild(HandL1);
		bipedLeftArm.removeChild(HandL2);
		bipedRightLeg.removeChild(LegR1);
		bipedRightLeg.removeChild(LegR2);
		bipedRightLeg.removeChild(LegR3);
		bipedRightLeg.removeChild(LegR4);
		bipedRightLeg.removeChild(LegR5);
		bipedRightLeg.removeChild(bootR1);
		bipedRightLeg.removeChild(bootR2);
		bipedLeftLeg.removeChild(LegL1);
		bipedLeftLeg.removeChild(LegL2);
		bipedLeftLeg.removeChild(LegL3);
		bipedLeftLeg.removeChild(LegL4);
		bipedLeftLeg.removeChild(LegL5);
		bipedLeftLeg.removeChild(bootL1);
		bipedLeftLeg.removeChild(bootL2);
		rightArm2.addChild(ArmR1);
		rightArm2.addChild(HandR1);
		rightArm2.addChild(HandR2);
		leftArm2.addChild(ArmL1);
		leftArm2.addChild(HandL1);
		leftArm2.addChild(HandL2);
		rightLeg.addChild(LegR1);
		rightLeg.addChild(LegR2);
		rightLeg.addChild(LegR3);
		rightLeg.addChild(LegR4);
		rightLeg.addChild(LegR5);
		rightLeg2.addChild(bootR1);
		rightLeg2.addChild(bootR2);
		leftLeg.addChild(LegL1);
		leftLeg.addChild(LegL2);
		leftLeg.addChild(LegL3);
		leftLeg.addChild(LegL4);
		leftLeg.addChild(LegL5);
		leftLeg2.addChild(bootL1);
		leftLeg2.addChild(bootL2);
		bootR1.rotationPointY = bootR2.rotationPointY = bootL1.rotationPointY = bootL2.rotationPointY = -5.5F;
		HandR1.rotationPointY = HandR2.rotationPointY = HandL1.rotationPointY = HandL2.rotationPointY = -3.0F;
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease1(entityCaps);
		bipedRightArm.addChild(ArmR1);
		bipedRightArm.addChild(HandR1);
		bipedRightArm.addChild(HandR2);
		bipedLeftArm.addChild(ArmL1);
		bipedLeftArm.addChild(HandL1);
		bipedLeftArm.addChild(HandL2);
		bipedRightLeg.addChild(LegR1);
		bipedRightLeg.addChild(LegR2);
		bipedRightLeg.addChild(LegR3);
		bipedRightLeg.addChild(LegR4);
		bipedRightLeg.addChild(LegR5);
		bipedRightLeg.addChild(bootR1);
		bipedRightLeg.addChild(bootR2);
		bipedLeftLeg.addChild(LegL1);
		bipedLeftLeg.addChild(LegL2);
		bipedLeftLeg.addChild(LegL3);
		bipedLeftLeg.addChild(LegL4);
		bipedLeftLeg.addChild(LegL5);
		bipedLeftLeg.addChild(bootL1);
		bipedLeftLeg.addChild(bootL2);
		rightArm2.removeChild(ArmR1);
		rightArm2.removeChild(HandR1);
		rightArm2.removeChild(HandR2);
		leftArm2.removeChild(ArmL1);
		leftArm2.removeChild(HandL1);
		leftArm2.removeChild(HandL2);
		rightLeg.removeChild(LegR1);
		rightLeg.removeChild(LegR2);
		rightLeg.removeChild(LegR3);
		rightLeg.removeChild(LegR4);
		rightLeg.removeChild(LegR5);
		rightLeg2.removeChild(bootR1);
		rightLeg2.removeChild(bootR2);
		leftLeg.removeChild(LegL1);
		leftLeg.removeChild(LegL2);
		leftLeg.removeChild(LegL3);
		leftLeg.removeChild(LegL4);
		leftLeg.removeChild(LegL5);
		leftLeg2.removeChild(bootL1);
		leftLeg2.removeChild(bootL2);
		bootR1.rotationPointY = bootR2.rotationPointY = bootL1.rotationPointY = bootL2.rotationPointY = 0.0F;
		HandR1.rotationPointY = HandR2.rotationPointY = HandL1.rotationPointY = HandL2.rotationPointY = 0.0F;
	}	@Override	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {		super.showModelSettingReflects(entityCaps);		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) > 1) {			setCapsValue(entityCaps, caps_visible, Skirt, true);		}	}}