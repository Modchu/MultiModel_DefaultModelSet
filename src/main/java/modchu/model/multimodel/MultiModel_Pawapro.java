package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_Pawapro extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer tuba1;
	public Modchu_ModelRenderer tuba2;
	public Modchu_ModelRenderer HandR;
	public Modchu_ModelRenderer HandL;
	public Modchu_ModelRenderer RLeg2;
	public Modchu_ModelRenderer LLeg2;
	public Modchu_ModelRenderer eyeRniko;
	public Modchu_ModelRenderer eyeLniko;
	public Modchu_ModelRenderer eyeRFire;
	public Modchu_ModelRenderer eyeLFire;
	public Modchu_ModelRenderer Logo1;
	public Modchu_ModelRenderer Logo2;	public MultiModel_Pawapro() {
		this(0.0F);
	}	public MultiModel_Pawapro(float f) {
		this(f, 0.0F);
	}	public MultiModel_Pawapro(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Pawapro(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		tuba1 = new Modchu_ModelRenderer(this, 0, 29);
		tuba1.addBox(-4F, -5F, -6F, 8, 1, 2, f);
		tuba1.setRotationPoint(0F, 0F, 0F);
		tuba2 = new Modchu_ModelRenderer(this, 0, 29);
		tuba2.addBox(-3F, -4.9F, -7F, 6, 1, 2, f - 0.1F);
		tuba2.setRotationPoint(0F, 0F, 0F);
		ChignonL = new Modchu_ModelRenderer(this, 0, 2);
		ChignonL.addBox(3.5F, -4.5F, -1.8F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0F, 0F, 0F);
		Logo1 = new Modchu_ModelRenderer(this, 24, 0);
		Logo1.addPlate(-4F, -10.5F, -7.2F, 8, 8, 0, f - 3F);
		Logo1.setRotationPoint(0F, 0F, 0F);		bipedBody = new Modchu_ModelRenderer(this, 0, 16);
		bipedBody.addBox(-3F, 0.5F, -2F, 6, 8, 4, f);
		bipedBody.setRotationPoint(0.0F, 8F, 0.0F);
		Skirt = new Modchu_ModelRenderer(this, 28, 18);
		Skirt.addBox(-3F, 7.5F, -2F, 6, 2, 4, f - 0.5F);
		Skirt.setRotationPoint(0F, 0F, 0F);
		Logo2 = new Modchu_ModelRenderer(this, 40, 0);
		Logo2.mirror = true;
		Logo2.addPlate(-4F, -1.5F, 0.5F, 8, 8, 0, f - 1.8F);
		Logo2.setRotationPoint(0F, 0F, 0F);		bipedRightArm = new Modchu_ModelRenderer(this, 20, 22);
		bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3F, 9.5F, 0.0F);
		HandR = new Modchu_ModelRenderer(this, 20, 16);
		HandR.addBox(-2.5F, 4.5F, -1.5F, 3, 3, 3, f);
		HandR.setRotationPoint(0.0F, 0.0F, 0F);		bipedLeftArm = new Modchu_ModelRenderer(this, 20, 22);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3F, 9.5F, 0.0F);
		HandL = new Modchu_ModelRenderer(this, 20, 16);
		HandL.mirror = true;
		HandL.addBox(-0.5F, 4.5F, -1.5F, 3, 3, 3, f);
		HandL.setRotationPoint(0.0F, 0.0F, 0F);		bipedRightLeg = new Modchu_ModelRenderer(this, 28, 24);
		bipedRightLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
		bipedRightLeg.setRotationPoint(-2F, 7F, 0.0F);
		RLeg2 = new Modchu_ModelRenderer(this, 28, 24);
		RLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
		RLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);		bipedLeftLeg = new Modchu_ModelRenderer(this, 28, 24);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
		bipedLeftLeg.setRotationPoint(1.0F, 7F, 0.0F);
		LLeg2 = new Modchu_ModelRenderer(this, 28, 24);
		LLeg2.mirror = true;
		LLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
		LLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);		eyeR = new Modchu_ModelRenderer(this, 32, 0);
		eyeR.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 36, 0);
		eyeL.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeRniko = new Modchu_ModelRenderer(this, 32, 12);
		eyeRniko.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeRniko.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeLniko = new Modchu_ModelRenderer(this, 36, 12);
		eyeLniko.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeLniko.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeRFire = new Modchu_ModelRenderer(this, 32, 4);
		eyeRFire.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeRFire.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeLFire = new Modchu_ModelRenderer(this, 36, 4);
		eyeLFire.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeLFire.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonB);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		((Modchu_ModelRenderer) mainFrame).removeChild(Skirt);
		lowerBody.removeBoneChild(Skirt);
		bipedHead.addChild(tuba1);
		bipedHead.addChild(tuba2);
		bipedHead.addChild(Logo1);
		bipedBody.addChild(Skirt);
		bipedBody.addChild(Logo2);
		bipedRightArm.addChild(HandR);
		bipedLeftArm.addChild(HandL);
		bipedRightLeg.addChild(RLeg2);
		bipedLeftLeg.addChild(LLeg2);
		bipedHead.addChild(eyeRniko);
		bipedHead.addChild(eyeLniko);
		bipedHead.addChild(eyeRFire);
		bipedHead.addChild(eyeLFire);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this, 20, 22);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
		bipedBody.addChild(rightArm);		rightArmPlus = new Modchu_ModelRenderer(this);
		//rightArmPlus.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		//rightArmPlus.rotateAngleX = 1.570796313F;
		//rightArm.addChild(rightArmPlus);		rightArm2 = new Modchu_ModelRenderer(this, 20, 26);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
		rightArm.addChild(rightArm2);		rightArmPlus2 = new Modchu_ModelRenderer(this);		rightHand = new Modchu_ModelRenderer(this);
		rightArm2.addChild(rightHand);		leftArm = new Modchu_ModelRenderer(this, 20, 22);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
		bipedBody.addChild(leftArm);		leftArmPlus = new Modchu_ModelRenderer(this);
		//leftArmPlus.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		//leftArmPlus.rotateAngleX = 1.570796313F;
		//leftArm.addChild(leftArmPlus);		leftArm2 = new Modchu_ModelRenderer(this, 20, 26);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
		leftArm.addChild(leftArm2);		leftArmPlus2 = new Modchu_ModelRenderer(this);		leftHand = new Modchu_ModelRenderer(this);
		leftArm2.addChild(leftHand);		rightLeg = new Modchu_ModelRenderer(this);
		bipedBody.addChild(rightLeg);		rightLegPlus = new Modchu_ModelRenderer(this);		rightLeg2 = new Modchu_ModelRenderer(this);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
		rightLeg.addChild(rightLeg2);		rightLegPlus2 = new Modchu_ModelRenderer(this);		leftLeg = new Modchu_ModelRenderer(this);
		bipedBody.addChild(leftLeg);		leftLegPlus = new Modchu_ModelRenderer(this);		leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
		leftLeg.addChild(leftLeg2);		leftLegPlus2 = new Modchu_ModelRenderer(this);		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = false;
		rightLeg.isHidden = rightLeg2.isHidden = leftLeg.isHidden = leftLeg2.isHidden = true;
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		Skirt.setRotateAngle(0.0F, 0.0F, 0.0F);
		bipedHead.rotationPointY += 4.0F;
		bipedRightArm.rotationPointY += 5.0F;
		bipedLeftArm.rotationPointY += 5.0F;
		bipedRightLeg.rotationPointY += 2.0F;
		bipedLeftLeg.rotationPointY += 2.0F;
		setCapsValue(entityCaps, caps_visible, eyeLniko, false);
		setCapsValue(entityCaps, caps_visible, eyeRniko, false);
		setCapsValue(entityCaps, caps_visible, eyeLFire, false);
		setCapsValue(entityCaps, caps_visible, eyeRFire, false);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, eyeLniko, true);
			setCapsValue(entityCaps, caps_visible, eyeRniko, true);
		}		boolean eyeFlag = true;
		Object itemstack = getCapsValue(entityCaps, caps_currentArmor, 3);
		if (itemstack != null) {
			int addSupport = addSupportChecks(entityCaps, itemstack, 1);
			if (addSupport == 3 |
					addSupport == 4) eyeFlag = false;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			if (eyeFlag) {
				setCapsValue(entityCaps, caps_visible, eyeLFire, true);
				setCapsValue(entityCaps, caps_visible, eyeRFire, true);
				setCapsValue(entityCaps, caps_visible, eyeL, false);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			}
		}
		bipedRightLeg.rotateAngleY = 0.5235988F;
		bipedLeftLeg.rotateAngleY = -0.5235988F;
	}	@Override
	public void actionPartsAddChild() {
		super.actionPartsAddChild();
		boolean b = false;
		setCapsValue(null, caps_visible, bipedLeftArm, b);
		setCapsValue(null, caps_visible, bipedRightArm, b);
		b = true;
		setCapsValue(null, caps_visible, bipedLeftLeg, b);
		setCapsValue(null, caps_visible, bipedRightLeg, b);
		setCapsValue(null, caps_visible, rightArm, b);
		setCapsValue(null, caps_visible, rightArm2, b);
		setCapsValue(null, caps_visible, rightArmPlus, b);
		setCapsValue(null, caps_visible, rightArmPlus2, b);
		setCapsValue(null, caps_visible, rightHand, b);
		setCapsValue(null, caps_visible, leftArm, b);
		setCapsValue(null, caps_visible, leftArm2, b);
		setCapsValue(null, caps_visible, leftArmPlus, b);
		setCapsValue(null, caps_visible, leftArmPlus2, b);
		setCapsValue(null, caps_visible, leftHand, b);
		rightLeg.isHidden = !b;
		rightLeg2.isHidden = !b;
		setCapsValue(null, caps_visible, rightLegPlus, b);
		setCapsValue(null, caps_visible, rightLegPlus2, b);
		leftLeg.isHidden = !b;
		leftLeg2.isHidden = !b;
		setCapsValue(null, caps_visible, leftLegPlus, b);
		setCapsValue(null, caps_visible, leftLegPlus2, b);
		bipedRightArm.removeChild(HandR);
		bipedLeftArm.removeChild(HandL);
		rightHand.addChild(Arms[0]);
		leftHand.addChild(Arms[1]);
		rightHand.addChild(HandR);
		leftHand.addChild(HandL);
		mainFrame.removeChild(bipedRightLeg);
		mainFrame.removeChild(bipedLeftLeg);
		rightLeg2.addChild(bipedRightLeg);
		leftLeg2.addChild(bipedLeftLeg);
		Arms[0].setRotationPoint(0.0F, 3.0F, 0.0F);
		Arms[1].setRotationPoint(0.0F, 3.0F, 0.0F);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease1(entityCaps);
		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		boolean b = true;
		setCapsValue(entityCaps, caps_visible, bipedLeftArm, b);
		setCapsValue(entityCaps, caps_visible, bipedRightArm, b);
		bipedBody.rotateAngleX = 0.0F;
		bipedBody.rotateAngleY = 0.0F;
		bipedBody.rotateAngleZ = 0.0F;
		bipedHead.rotateAngleX = 0.0F;
		bipedHead.rotateAngleY = 0.0F;
		bipedHead.rotateAngleZ = 0.0F;
		bipedHead.rotationPointX = 0.0F;
		bipedHead.rotationPointZ = 0.0F;
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		float f6 = bipedBody.rotateAngleZ;
		if (f6 > 0.0F) {
			bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F + (f6 * 1.30889264F);
		} else {
			bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F - (f6 * 1.30889264F);
		}
		bipedHead.rotationPointX = 0.0F;
		rightHand.rotationPointY = -3.0F;
		leftHand.rotationPointY = -3.0F;
		rightLeg2.rotationPointY = -6.0F;
		leftLeg2.rotationPointY = -6.0F;
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.rotationPointY += 4.0F;
		bipedBody.rotationPointY += 7.5F;
		rightHand.rotationPointX = 1.0F;
		rightHand.rotationPointY = -2.5F;
		rightHand.rotationPointZ = 0.0F;
		leftHand.rotationPointX = -1.0F;
		leftHand.rotationPointY = -2.5F;
		leftHand.rotationPointZ = 0.0F;
		Skirt.rotationPointY -= 4.0F;
		rightLeg2.rotationPointZ -= 8.0F;
		leftLeg2.rotationPointX -= 2.0F;
		leftLeg2.rotationPointY -= 6.0F;
		leftLeg2.rotationPointZ = 0.0F;
	}	@Override
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		bipedHead.isHidden = !b;
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, Logo2, b);
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}