package net.minecraft.src;

/**
 * Action�@�\�ǉ��pclass
 */
public abstract class MultiModelAction extends MultiModelBaseBiped {

    public Modchu_ModelRenderer rightArm;
    public Modchu_ModelRenderer rightArm2;
    public Modchu_ModelRenderer rightArmPlus;
    public Modchu_ModelRenderer rightArmPlus2;
    public Modchu_ModelRenderer rightHand;
    public Modchu_ModelRenderer rightLeg;
    public Modchu_ModelRenderer rightLeg2;
    public Modchu_ModelRenderer rightLegPlus;
    public Modchu_ModelRenderer rightLegPlus2;
    public Modchu_ModelRenderer leftArm;
    public Modchu_ModelRenderer leftArm2;
    public Modchu_ModelRenderer leftArmPlus;
    public Modchu_ModelRenderer leftArmPlus2;
    public Modchu_ModelRenderer leftHand;
    public Modchu_ModelRenderer leftLeg;
    public Modchu_ModelRenderer leftLeg2;
    public Modchu_ModelRenderer leftLegPlus;
    public Modchu_ModelRenderer leftLegPlus2;

    /**
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelAction() {
    	this(0.0F);
    }

    /**
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelAction(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelAction(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelAction(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    }

    /**
     * �V���[�g�J�b�g�A�N�V�������ɌĂ΂��
     */
    public void actionInit(Modchu_IModelCaps entityCaps, int i) {
    	setCapsValue(entityCaps, caps_runActionNumber, i);
    	switch(i) {
    	case 1:
    		actionInit1(entityCaps);
    		break;
    	case 2:
    		actionInit2(entityCaps);
    		break;
    	case 3:
    		actionInit3(entityCaps);
    		break;
    	case 4:
    		actionInit4(entityCaps);
    		break;
    	case 5:
    		actionInit5(entityCaps);
    		break;
    	case 6:
    		actionInit6(entityCaps);
    		break;
    	case 7:
    		actionInit7(entityCaps);
    		break;
    	case 8:
    		actionInit8(entityCaps);
    		break;
    	case 9:
    		actionInit9(entityCaps);
    		break;
    	case 30:
    		actionInit30(entityCaps);
    		break;
    	}
    }

    public void actionInit1(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	boolean b = false;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	setCapsValue(caps_visible, bipedLeftLeg, b);
    	setCapsValue(caps_visible, bipedRightLeg, b);
    	b = true;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);
    	if (bipedRightArm != null
    			&& bipedRightArm instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) bipedRightArm).removeChild((Modchu_ModelRenderer) Arms[0]);
    	}
    	if (bipedLeftArm != null
    			&& bipedLeftArm instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) bipedLeftArm).removeChild((Modchu_ModelRenderer) Arms[1]);
    	}
    	if (rightHand != null) {
    		rightHand.addChild(Arms[0]);
    	}
    	if (leftHand != null) {
    		leftHand.addChild(Arms[1]);
    	}
    	Arms[0].setRotationPoint(0.5F, 0.0F, 0.0F);
    	Arms[1].setRotationPoint(-0.5F, 0.0F, 0.0F);
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

    public void actionInit2(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(entityCaps, caps_actionCount, 0);
    	setCapsValue(caps_waitBan, true);
    }

    public void actionInit3(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, true);
    }

    public void actionInit4(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, true);
    }

    public void actionInit5(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit6(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit7(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit8(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit9(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit30(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    /**
     * �V���[�g�J�b�g�A�N�V�����������ɌĂ΂��B
     */
    public void actionRelease(Modchu_IModelCaps entityCaps, int i) {
    	switch(i) {
    	case 1:
    		actionRelease1(entityCaps);
    		break;
    	case 2:
    		actionRelease2(entityCaps);
    		break;
    	case 3:
    		actionRelease3(entityCaps);
    		break;
    	case 4:
    		actionRelease4(entityCaps);
    		break;
    	case 5:
    		actionRelease5(entityCaps);
    		break;
    	case 6:
    		actionRelease6(entityCaps);
    		break;
    	case 7:
    		actionRelease7(entityCaps);
    		break;
    	case 8:
    		actionRelease8(entityCaps);
    		break;
    	case 9:
    		actionRelease9(entityCaps);
    		break;
    	case 30:
    		actionRelease30(entityCaps);
    		break;
    	}
    }

    public void actionRelease1(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);

    	boolean b = true;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	setCapsValue(caps_visible, bipedLeftLeg, b);
    	setCapsValue(caps_visible, bipedRightLeg, b);
    	b = false;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);

    	if (Arms != null) {
    		if (Arms[0] != null) bipedRightArm.addChild(Arms[0]);
    		if (Arms[1] != null) bipedLeftArm.addChild(Arms[1]);
    		if (Arms[0] != null
    				&& rightHand != null) ((Modchu_ModelRenderer) rightHand).removeChild((Modchu_ModelRenderer) Arms[0]);
    		if (Arms[1] != null
    				&& leftHand != null) ((Modchu_ModelRenderer) leftHand).removeChild((Modchu_ModelRenderer) Arms[1]);
    		if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    		if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	}

    	bipedBody.rotateAngleX = 0.0F;
    	bipedBody.rotateAngleY = 0.0F;
    	bipedBody.rotateAngleZ = 0.0F;
    	bipedHead.rotateAngleX = 0.0F;
    	bipedHead.rotateAngleY = 0.0F;
    	bipedHead.rotateAngleZ = 0.0F;
    	bipedHead.rotationPointX = 0.0F;
    	bipedHead.rotationPointZ = 0.0F;
    }

    public void actionRelease2(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease3(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease4(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease5(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease6(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease7(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease8(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease9(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease30(Modchu_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, Modchu_IModelCaps entityCaps) {
    	Modchu_Reflect.invokeMethod(MultiModelAction.class, "action"+i, new Class[]{ float.class, float.class, float.class, float.class, float.class, float.class, Modchu_IModelCaps.class }, this, new Object[]{ f, f1, f2, f3, f4, f5, entityCaps }, -1);
    }

    public void action1(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    	// �������ϳ�(߁��)
    	float speed = Modchu_ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed) / 10;
    	//Modchu_Debug.mDebug("action1 entityCaps != null?"+(entityCaps != null));
    	//Modchu_Debug.Debug("action1 "+(Modchu_ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed))+" speed="+speed+" Type="+getCapsValue(this, entityCaps, caps_armorType));
    	if (speed < 0.0F) return;

    	rightArm.rotationPointX = bipedRightArm.rotationPointX;
    	rightArm.rotationPointY = bipedRightArm.rotationPointY;
    	rightArm.rotationPointZ = bipedRightArm.rotationPointZ;
    	leftArm.rotationPointX = bipedLeftArm.rotationPointX;
    	leftArm.rotationPointY = bipedLeftArm.rotationPointY;
    	leftArm.rotationPointZ = bipedLeftArm.rotationPointZ;
    	rightArm2.rotationPointX = 0.0F;
    	rightArm2.rotationPointY = 4.0F;
    	rightArm2.rotationPointZ = 0.0F;
    	leftArm2.rotationPointX = 0.0F;
    	leftArm2.rotationPointY = 4.0F;
    	leftArm2.rotationPointZ = 0.0F;

    	rightLeg.rotationPointX = bipedRightLeg.rotationPointX;
    	rightLeg.rotationPointY = bipedRightLeg.rotationPointY;
    	rightLeg.rotationPointZ = bipedRightLeg.rotationPointZ;
    	leftLeg.rotationPointX = -rightLeg.rotationPointX;
    	leftLeg.rotationPointY = bipedLeftLeg.rotationPointY;
    	leftLeg.rotationPointZ = bipedLeftLeg.rotationPointZ;
    	rightLeg2.rotationPointY = bipedRightLeg.rotationPointY;
    	leftLeg2.rotationPointY = rightLeg2.rotationPointY;

    	rightArm.rotateAngleX = bipedRightArm.rotateAngleX;
    	rightArm.rotateAngleZ = bipedRightArm.rotateAngleZ;
    	leftArm.rotateAngleX = bipedLeftArm.rotateAngleX;
    	leftArm.rotateAngleZ = bipedLeftArm.rotateAngleZ;

    	float f6 = bipedBody.rotateAngleZ;
    	//actionSpeed = 0.1F;
    	//left
    	//float f1 = 0.5359998F;
    	//middle
    	//float f1 = 0.07F;
    	//right
    	//float f1 = -0.3820023F;

    	rightArm2.rotateAngleX = 0.0F;
    	rightLeg.rotationPointZ = -0.01F;
    	leftLeg.rotationPointZ = -0.01F;
    	rightLeg2.rotationPointZ = -0.02F;
    	rightLeg2.rotationPointX = -0.001F;
    	leftLeg2.rotationPointX = 0.001F;

    	rightArm.rotateAngleY = f6 * 0.09328361F;
    	rightHand.rotateAngleX = -f6 * 1.86567233F;
    	rightHand.rotateAngleZ = 0.0F;
    	if (!Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionReverse)) {
    		if (f6 < 0.5F) {
    			f6 += speed;
    		} else setCapsValue(entityCaps, caps_actionReverse, true);
    	} else {
    		if (f6 > -0.3F) {
    			f6 -= speed;
    		} else setCapsValue(entityCaps, caps_actionReverse, false);
    	}
    	if (f6 > 0.5449998F) f6 = 0.5449998F;
    	if (f6 < -0.3880023F) f6 = -0.3880023F;
    	//f1 = 0.5449998F;
    	//f1 = 0.01F;
    	if (f6 > 0.0F) {
    		bipedBody.rotateAngleX += f6 * 0.186567233F;
    		bipedBody.rotationPointY += f6 * 4.10447914F;
    		rightLeg.rotationPointY -= f6 * 0.93283616F;
    		rightLeg2.rotationPointY -= f6 * 0.93283616F;
    		leftLeg.rotationPointY -= f6 * 1.86567233F;
    		leftLeg2.rotationPointY -= f6 * 1.30889264F;
    		leftLeg2.rotationPointZ = -f6 * 0.74626893F;
    		rightArm.rotateAngleZ = 2.05619449F - (f6 * 1.1194034F);
    		rightArm2.rotateAngleZ = 1.3619449F + (f6 * 1.3059706F);
    		leftArm.rotateAngleX = -rightArm.rotateAngleX;
    		leftArm.rotateAngleY = -rightArm.rotateAngleY;
    		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
    		rightLeg.rotateAngleX = f6 * 0.186567233F;
    		rightLeg.rotateAngleZ = -f6 * 1.30597063F;
    		leftLeg.rotateAngleX = -f6 * 0.186567233F;
    		leftLeg.rotateAngleY = f6 * 0.5597017F;
    		leftLeg.rotateAngleZ = -f6 * 1.02611976F;
    		leftLeg2.rotateAngleX = f6 * 1.30597063F;
    		leftArm2.rotateAngleX = -rightArm2.rotateAngleX;
    		leftArm2.rotateAngleY = -rightArm2.rotateAngleY;
    		leftArm2.rotateAngleZ = -rightArm2.rotateAngleZ;
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 3.5F + (f6 * 2.61778528F);
    	} else {
    		bipedBody.rotationPointY -= f6 * 4.10447914F;
    		leftLeg.rotationPointY -= f6 * 0.14592575F;
    		rightLeg2.rotationPointY += f6 * 1.30889264F;
    		leftLeg2.rotationPointY -= f6 * 1.30889264F;
    		leftLeg2.rotationPointZ = -0.02F;
    		rightLeg.rotationPointY -= -f6 * 2.61778528F;
    		leftLeg.rotationPointY -= -f6 * 2.61778528F;
    		rightArm.rotateAngleX = 0.0F;
    		rightArm.rotateAngleZ = 2.05619449F + (f6 * 1.8324496927929884191796750961971F);
    		rightArm2.rotateAngleZ = 1.3619449F - (f6 * 0.52355705F);
    		leftArm.rotateAngleX = -rightArm.rotateAngleX;
    		leftArm.rotateAngleY = -rightArm.rotateAngleY;
    		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
    		leftArm2.rotateAngleX = -rightArm2.rotateAngleX;
    		leftArm2.rotateAngleY = -rightArm2.rotateAngleY;
    		leftArm2.rotateAngleZ = -rightArm2.rotateAngleZ;
    		rightLeg.rotateAngleX = 0.0F;
    		rightLeg.rotateAngleY = f6 * 0.52355705F;
    		rightLeg.rotateAngleZ = -f6 * 1.30597063F;
    		rightLeg2.rotateAngleX = -f6 * 1.30889264F;
    		leftLeg.rotateAngleX = 0.0F;
    		leftLeg.rotateAngleY = 0.0F;
    		leftLeg.rotateAngleZ = -f6 * 1.30597063F;
    		leftLeg2.rotateAngleX = 0.0F;
    		leftLeg2.rotateAngleZ = 0.0F;
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 3.5F - (f6 * 2.61778528F);
    	}
    	bipedHead.rotationPointX = f6 * 2.10447914F;
    	bipedHead.rotateAngleX = -f6 * 0.2F;
    	bipedHead.rotateAngleY = f6 * 0.2F;
    	bipedHead.rotateAngleZ = f6;
    	leftHand.rotateAngleX = -rightHand.rotateAngleX;
    	leftHand.rotateAngleY = rightHand.rotateAngleY;
    	leftHand.rotateAngleZ = rightHand.rotateAngleZ;
    	bipedBody.rotateAngleZ = f6;
    }

    public void action2(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    	// ����グ�郂�[�V����
    	Modchu_ModelRenderer arm = (Modchu_ModelRenderer) getCapsValue(this, caps_bipedRightArm, entityCaps);
    	arm.rotateAngleX -= 0.2F;
    	arm.rotateAngleY -= 1.0F;
    	arm.rotateAngleZ = Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0 ? 2.1F : -2.1F;
    }

    public void action3(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    	// ����グ�ĐU�郂�[�V����
    	//Modchu_Debug.mDebug("armorType="+armorType+" actionSpeed="+actionSpeed);
    	float actionSpeed = Modchu_ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed);
    	if (actionSpeed < 0.0F) return;
    	int i = (int) (actionSpeed * 2);
    	if (i < 0) i = 0;
    	boolean actionReverse = Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionReverse);
    	int actionCount = Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_actionCount);
    	actionCount = (int) (actionReverse ? actionCount - i : actionCount + i);
    	setCapsValue(entityCaps, caps_actionCount, actionCount);
    	//Modchu_Debug.mDebug("actionReverse="+actionReverse+" actionCount="+actionCount+" "+((float) (actionCount - 15)) / 30.0F);
    	Modchu_ModelRenderer arm = (Modchu_ModelRenderer) getCapsValue(this, caps_bipedRightArm, entityCaps);
    	arm.rotateAngleZ = 2.0F - ((float) (actionCount - 15)) / 20.0F;
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 1) arm.rotateAngleZ = -arm.rotateAngleZ;
    	if (actionCount > 30) {
    		setCapsValue(entityCaps, caps_actionReverse, true);
    		setCapsValue(entityCaps, caps_actionCount, 30);
    	}
    	if (actionCount < 0) {
    		setCapsValue(entityCaps, caps_actionReverse, false);
    		setCapsValue(entityCaps, caps_actionCount, 0);
    	}
    }

    public void action4(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    	// �����O�ɏo�����[�V����
    	if (onGrounds[dominantArm] > 0F) {
    		switch(dominantArm) {
    		case 0:
    			bipedRightArm.rotateAngleX += -1.57F;
    			bipedLeftArm.rotateAngleX = -1.57F;
    			break;
    		case 1:
    			bipedLeftArm.rotateAngleX += -1.57F;
    			bipedRightArm.rotateAngleX = -1.57F;
    			break;
    		}
    	} else {
    		bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = -1.57F;
    	}
    	bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
    	bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
    }

    public void action5(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    	// ������グ�郂�[�V����
    	Modchu_ModelRenderer arm = (Modchu_ModelRenderer) getCapsValue(this, caps_bipedRightArm, entityCaps);
    	//arm.rotateAngleX -= 0.2F;
    	//arm.rotateAngleY -= 1.0F;
    	arm.rotateAngleZ = Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0 ? 2.4F : -2.4F;
    	arm = (Modchu_ModelRenderer) getCapsValue(this, caps_notDominantArm, entityCaps);
    	//arm.rotateAngleX -= 0.2F;
    	//arm.rotateAngleY -= 1.0F;
    	arm.rotateAngleZ = Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0 ? -2.4F : 2.4F;
    }

    public void action6(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    }

    public void action7(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    }

    public void action8(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    }

    public void action9(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
    }

    public void action30(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
/*
    	//�f�o�b�N�p
    	if (mod_Modchu_ModchuLib.modchu_Main.getPackage() == null) return;
    	boolean b = true;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);
*/
    }

    @Override
    public void setArmorBipedRightArmShowModel(Modchu_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightArm, false);
    		if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    		if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    		if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	}
    	else setCapsValue(caps_visible, bipedRightArm, b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(Modchu_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftArm, false);
    		if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    		if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    		if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	}
    	else setCapsValue(caps_visible, bipedLeftArm, b);
    }

    @Override
    public void setArmorBipedRightLegShowModel(Modchu_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightLeg, false);
    		if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    		if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	}
    	else setCapsValue(caps_visible, bipedRightLeg, b);
    }

    @Override
    public void setArmorBipedLeftLegShowModel(Modchu_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftLeg, false);
    		if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    		if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	}
    	else setCapsValue(caps_visible, bipedLeftLeg, b);
    }
}
