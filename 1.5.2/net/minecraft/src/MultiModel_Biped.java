package net.minecraft.src;

public class MultiModel_Biped extends MultiModelSkirtFloats
{
    /**
     * Records whether the model should be rendered holding an item in the left hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right hand, and if that item is a block.
     */
    public int heldItemRight;
    public boolean isSneak;

    /** Records whether the model should be rendered aiming a bow. */
    public boolean aimedBow;

	public MultiModel_Biped() {
		this(0.0F);
	}

	public MultiModel_Biped(float f) {
		this(f, 0.0F);
	}

	public MultiModel_Biped(float f, float f1) {
		this(f, f1 , 64, 32);
	}

	public MultiModel_Biped(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		bipedCloak = new Modchu_ModelRenderer(this, 0, 0);
		bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, f);
		bipedEars = new Modchu_ModelRenderer(this, 24, 0);
		bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, f);
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHeadwear = new Modchu_ModelRenderer(this, 32, 0);
		bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f + 0.5F);
    	bipedHead.addChild(bipedHeadwear);
		bipedBody = new Modchu_ModelRenderer(this, 16, 16);
		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, f);
		bipedRightArm = new Modchu_ModelRenderer(this, 40, 16);
		bipedRightArm.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRenderer(this, 40, 16);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedLeftArm);
		bipedRightLeg = new Modchu_ModelRenderer(this, 0, 16);
		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 0, 16);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedLeftLeg);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		actionPartsInit(f, f1);
	}

	@Override
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRenderer[18];
    	// �莝��
    	Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRenderer) Arms[1]).isInvertX = true;
    	// �o�C�v���_�N�g�G�t�F�N�^�[
    	Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[2].setRotationPoint(-3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[3].setRotationPoint(3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).isInvertX = true;
    	// �e�[���\�[�h
    	Arms[4] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[4].setRotationPoint(-2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
    	Arms[5] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[5].setRotationPoint(2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[5]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);


//		Arms[8] = new Modchu_ModelRenderer(this, "HeadTop");
//		Arms[8].setRotationPoint(0F, -3F, 1F);
    	if (HeadMount != null) {
    		if (bipedHead instanceof Modchu_ModelRenderer) {
    			((Modchu_ModelRenderer) bipedHead).removeChild(HeadMount);
    		} else {
    			bipedHead.childModels.remove(HeadMount);
    		}
    	}
    	HeadMount = new Modchu_ModelRenderer(this, "HeadMount");
    	HeadMount.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(HeadMount);
    	bipedBody.addChild(Arms[4]);
    	bipedBody.addChild(Arms[5]);
    	bipedRightArm.addChild(Arms[0]);
    	bipedRightArm.addChild(Arms[2]);
    	bipedLeftArm.addChild(Arms[1]);
    	bipedLeftArm.addChild(Arms[3]);
    }

    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 40, 16);
    	rightArm.addBox(-2.0F, -1.0F, -1.0F, 4, 6, 4, f);
    	bipedBody.addChild(rightArm);

    	rightArm2 = new Modchu_ModelRenderer(this, 40, 24);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, f);
    	rightArm.addChild(rightArm2);

    	leftArm = new Modchu_ModelRenderer(this, 40, 16);
    	leftArm.mirror = true;
    	leftArm.addBox(0.0F, -1.0F, -1.0F, 4, 6, 4, f);
    	bipedBody.addChild(leftArm);

    	leftArm2 = new Modchu_ModelRenderer(this, 40, 24);
    	leftArm2.mirror = true;
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, f);
    	leftArm.addChild(leftArm2);

    	rightLeg = new Modchu_ModelRenderer(this, 0, 16);
    	rightLeg.addBox(-2.5F, 0.0F, -2F, 4, 6, 4, f);
    	bipedBody.addChild(rightLeg);

    	rightLeg2 = new Modchu_ModelRenderer(this, 0, 22);
    	rightLeg2.addBox(-1.1F, 0.0F, -1.5F, 4, 6, 4, f);
    	rightLeg.addChild(rightLeg2);

    	leftLeg = new Modchu_ModelRenderer(this, 0, 16);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-0.5F, 0.0F, -2F, 4, 6, 4, f);
    	bipedBody.addChild(leftLeg);

    	leftLeg2 = new Modchu_ModelRenderer(this, 0, 22);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-0.9F, 0.0F, -1.5F, 4, 6, 4, f);
    	leftLeg.addChild(leftLeg2);

    	rightHand = new Modchu_ModelRenderer(this, 40, 24);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 4, 4, 4, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftHand = new Modchu_ModelRenderer(this, 40, 24);
    	leftHand.mirror = true;
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 4, 4, 4, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	rightArmPlus = new Modchu_ModelRenderer(this);
    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	rightLegPlus = new Modchu_ModelRenderer(this);
    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus2 = new Modchu_ModelRenderer(this);

    	rightHand.showModel = leftHand.showModel =
    		rightArm.showModel = leftArm.showModel =
    			rightArmPlus.showModel = rightArmPlus2.showModel =
    				leftArmPlus.showModel = leftArmPlus2.showModel =
    					rightLegPlus.showModel = rightLegPlus2.showModel =
    						leftLegPlus.showModel = leftLegPlus2.showModel =
    							rightArm2.showModel = leftArm2.showModel =
    								rightLeg.showModel = rightLeg2.showModel =
    									leftLeg.showModel = leftLeg2.showModel = false;
    	setCapsValue(caps_aimedBowBan, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);
    	setCapsValue(caps_sleepingBan, false);
    }

    /**
     * Sets the models various rotation angles.
     */
    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
		reset(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		bipedHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding) && Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1;
			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1;
			bipedLeftArm.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
			bipedRightArm.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
		} else {
			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
		}
		bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		bipedRightLeg.rotateAngleY = 0.0F;
		bipedLeftLeg.rotateAngleY = 0.0F;

		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding)) {
			bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
			bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
			bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
		}

		if (heldItemLeft != 0 && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemLeft;
		}

		if (heldItemRight != 0 && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemRight;
		}

		bipedRightArm.rotateAngleY = 0.0F;
		bipedLeftArm.rotateAngleY = 0.0F;
		float var7;
		float var8;
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak)) {
			bipedBody.rotateAngleX = 0.5F;
			bipedHead.rotationPointY = 1.0F;
			bipedRightLeg.rotateAngleX -= 0.5F;
			bipedLeftLeg.rotateAngleX -= 0.5F;
		} else {
			bipedBody.rotateAngleX = 0.0F;
			bipedHead.rotationPointY = 0.0F;
		}

		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow)) {
			var7 = 0.0F;
			var8 = 0.0F;
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - var7 * 0.6F) + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY = 0.1F - var7 * 0.6F + bipedHead.rotateAngleY + 0.4F;
			bipedRightArm.rotateAngleX = -((float) Math.PI / 2F) + bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F) + bipedHead.rotateAngleX;
			bipedRightArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedLeftArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
		} else {
			if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsWait)) {
				// �ҋ@���
				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedRightArm.rotateAngleZ = -0.4F;
				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				bipedLeftArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.4F;
			} else {
				// �ċz �r��
				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
		}
	}

    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	float[] lgrounds = null;
    	float onGroundR = 0;
    	float onGroundL = 0;
    	if (entityCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds, entityCaps);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = onGround;
    	}
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
    		// �r�U��
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedRightArm.rotateAngleZ = MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedLeftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    		}
    	}
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedRightArm.setRotationPoint(-6.0F, 0.0F, 0.0F);
    	bipedLeftArm.setRotationPoint(6.0F, 0.0F, 0.0F);
    	bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    	bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
    	Arms[0].setRotationPoint(0.0F, 9.5F, 0F);
    	Arms[1].setRotationPoint(0.0F, 9.5F, 0F);
    }

    /**
     * renders the ears (specifically, deadmau5's)
     */
    @Override
	public void renderEars(float f)
	{
		bipedEars.rotateAngleY = bipedHead.rotateAngleY;
		bipedEars.rotateAngleX = bipedHead.rotateAngleX;
		bipedEars.rotationPointX = 0.0F;
		bipedEars.rotationPointY = 0.0F;
		bipedEars.render(f);
	}

    /**
     * Renders the cloak of the current biped (in most cases, it's a player)
     */
    @Override
	public void renderCloak(float f)
	{
		bipedCloak.render(f);
	}

    @Override
	public int showArmorParts(MMM_IModelCaps entityCaps, int parts) {
		// �Z�̕\���p
		boolean f;
		// ��
		f = parts == 3 ? true : false;
		setArmorBipedHeadShowModel(entityCaps, f);
		// �Z
		f = parts == 2 ? true : false;
		setArmorBipedBodyShowModel(entityCaps, f);
		setArmorBipedRightArmShowModel(entityCaps, f);
		setArmorBipedLeftArmShowModel(entityCaps, f);
		// �r�b
		//f = parts == 1 | parts == 0 ? true : false;
		// �a��
		f = parts == 0 ? true : false;
		setArmorBipedRightLegShowModel(entityCaps, f);
		setArmorBipedLeftLegShowModel(entityCaps, f);

		return -1;
	}

    @Override
	public float getHeight() {
		return 1.81F;
	}

    @Override
	public float getWidth() {
		return 0.6F;
	}

	@Override
	public float[] getArmorModelsSize() {
		return new float[] {0.5F, 1.0F};
	}

    @Override
    public void defaultPartsSettingBefore() {
    	String[] s = {
    			"rightArm", "rightArm2", "rightArmPlus", "rightArmPlus2", "rightHand",
    			"rightLeg", "rightLeg2", "rightLegPlus", "rightLegPlus2", "leftArm",
    			"leftArm2", "leftArmPlus", "leftArmPlus2", "leftHand", "leftLeg",
    			"leftLeg2", "leftLegPlus", "leftLegPlus2", "HeadMount", "mainFrame"
    	};
    	setCapsValue(caps_showPartsHideList, (Object) s);
    	String[] s1 = {
    			"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
    			"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
    			"f", "g", "h", "i", "j",
    			"k",
    			"field_78116_c", "field_78114_d", "field_78115_e", "field_78112_f", "field_78113_g",
    			"field_78123_h", "field_78124_i", "field_78121_j", "field_78122_k"
    	};
    	String[] s2 = {
    			"Head", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
    			"RightArm", "LeftArm", "RightLeg", "LeftLeg", "bipedCloak",
    			"bipedEars",
    			"bipedHead", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "bipedEars", "bipedCloak"
    	};
    	setCapsValue(caps_showPartsRenemeMap, s1, s2);
    }

    @Override
    public void action1(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		float f6 = bipedBody.rotateAngleZ;
		if (f6 > 0.0F) {
			bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F - (f6 * 0.30889264F);
		} else {
			bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F - (f6 * 2.30889264F);
		}
		rightArm.rotationPointX = -5.0F;
		rightArm.rotationPointY = 2.0F;
		rightArm.rotationPointZ = -1.0F;
		leftArm.rotationPointX = 5.0F;
		leftArm.rotationPointY = 3.5F;
		leftArm.rotationPointZ = -1.0F;
		leftArm2.rotationPointX = 1.5F;
		leftArm2.rotationPointY = 6.0F;
		leftArm2.rotationPointZ = 0.0F;
		rightHand.rotationPointX = 0.0F;
		rightHand.rotationPointY = 3.0F;
		rightHand.rotationPointZ = 0.0F;
		leftHand.rotationPointX = 0.0F;
		leftHand.rotationPointY = 3.0F;
		leftHand.rotationPointZ = 0.0F;

		rightLeg2.rotationPointX = -1.5F;
		rightLeg2.rotationPointY = 5.5F;
		rightLeg2.rotationPointZ = 0.0F;
		leftLeg.rotationPointX = 0.5F;
		leftLeg2.rotationPointX = 0.0F;
		leftLeg2.rotationPointY = 5.5F;
		leftLeg2.rotationPointZ = 0.0F;
		Arms[0].setRotationPoint(0.0F, 0.0F, 0.0F);
		Arms[1].setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void action2(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// ����グ�郂�[�V����
    	super.action2(f, f1, f2, f3, f4, f5, entityCaps);
    	((ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps)).rotationPointX += Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0 ? 2.0F : -2.0F;
    }

    @Override
    public void action3(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// ����グ�ĐU�郂�[�V����
    	super.action3(f, f1, f2, f3, f4, f5, entityCaps);
    	((ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps)).rotationPointX += Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0 ? 2.0F : -2.0F;
    }
}
