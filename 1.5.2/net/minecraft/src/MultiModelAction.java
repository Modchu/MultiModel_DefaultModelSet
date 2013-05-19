package net.minecraft.src;

/**
 * Action機能追加用class
 */
public abstract class MultiModelAction extends MultiModelBaseBiped {

    public MMM_ModelRenderer rightArm;
    public MMM_ModelRenderer rightArm2;
    public MMM_ModelRenderer rightArmPlus;
    public MMM_ModelRenderer rightArmPlus2;
    public MMM_ModelRenderer rightHand;
    public MMM_ModelRenderer rightLeg;
    public MMM_ModelRenderer rightLeg2;
    public MMM_ModelRenderer rightLegPlus;
    public MMM_ModelRenderer rightLegPlus2;
    public MMM_ModelRenderer leftArm;
    public MMM_ModelRenderer leftArm2;
    public MMM_ModelRenderer leftArmPlus;
    public MMM_ModelRenderer leftArmPlus2;
    public MMM_ModelRenderer leftHand;
    public MMM_ModelRenderer leftLeg;
    public MMM_ModelRenderer leftLeg2;
    public MMM_ModelRenderer leftLegPlus;
    public MMM_ModelRenderer leftLegPlus2;

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelAction() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelAction(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelAction(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelAction(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    }

    /**
     * ショートカットアクション時に呼ばれる
     */
    public void actionInit(MMM_IModelCaps entityCaps, int i) {
    	setCapsValue(caps_runActionNumber, i);
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

    public void actionInit1(MMM_IModelCaps entityCaps) {
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
    		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    	}
    	if (bipedLeftArm != null
    			&& bipedLeftArm instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    	}
    	if (rightHand != null) {
    		rightHand.addChild(Arms[0]);
    		rightHand.addChild(Arms[2]);
    	}
    	if (leftHand != null) {
    		leftHand.addChild(Arms[1]);
    		leftHand.addChild(Arms[3]);
    	}
    	Arms[0].setRotationPoint(0.5F, 0.0F, 0.0F);
    	Arms[1].setRotationPoint(-0.5F, 0.0F, 0.0F);
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

    public void actionInit2(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(entityCaps, caps_actionCount, 0);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit3(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit4(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit5(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit6(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit7(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit8(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit9(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    public void actionInit30(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, true);
    }

    /**
     * ショートカットアクション解除時に呼ばれる。
     */
    public void actionRelease(MMM_IModelCaps entityCaps, int i) {
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

    public void actionRelease1(MMM_IModelCaps entityCaps) {
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
    				&& rightHand != null) ((Modchu_ModelRenderer) rightHand).removeChild(Arms[0]);
    		if (Arms[1] != null
    				&& leftHand != null) ((Modchu_ModelRenderer) leftHand).removeChild(Arms[1]);
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

    public void actionRelease2(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease3(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease4(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease5(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease6(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease7(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease8(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease9(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void actionRelease30(MMM_IModelCaps entityCaps) {
    	setCapsValue(entityCaps, caps_shortcutKeysAction, false);
    }

    public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, MMM_IModelCaps entityCaps) {
    	switch(i) {
    	case 1:
    		action1(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 2:
    		action2(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 3:
    		action3(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 4:
    		action4(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 5:
    		action5(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 6:
    		action6(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 7:
    		action7(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 8:
    		action8(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	case 9:
    		action9(f, f1, f2, f3, f4, f5, entityCaps);
    		break;
    	}
    }

    public void action1(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// ｳｯｰｳｯｰｳﾏｳﾏ(ﾟ∀ﾟ)
    	float speed = Modchu_ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed) / 10;
    	//Modchu_Debug.mDebug("action1 entityCaps != null?"+(entityCaps != null));
    	//Modchu_Debug.mDebug("action1 "+(Modchu_ModelCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed))+" speed="+speed+" Type="+getCapsValue(this, entityCaps, caps_armorType));
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
    	Modchu_Debug.mDebug("f6="+f6);
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

    public void action2(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// 手を上げるモーション
    	((MMM_ModelRenderer) getCapsValue(entityCaps, caps_bipedRightArm, entityCaps)).rotateAngleX -= 0.2F;
    	((MMM_ModelRenderer) getCapsValue(entityCaps, caps_bipedRightArm, entityCaps)).rotateAngleY -= 1.0F;
    	((MMM_ModelRenderer) getCapsValue(entityCaps, caps_bipedRightArm, entityCaps)).rotateAngleZ += Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0 ? 2.1F : -2.1F;
    }

    public void action3(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// 手を上げて振るモーション
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
    	((MMM_ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps)).rotateAngleZ = 2.0F - ((float) (actionCount - 15)) / 20.0F;
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 1) ((MMM_ModelRenderer) getCapsValue(entityCaps, caps_bipedRightArm)).rotateAngleZ = -((MMM_ModelRenderer) getCapsValue(entityCaps, caps_bipedRightArm)).rotateAngleZ;
    	if (actionCount > 30) {
    		setCapsValue(entityCaps, caps_actionReverse, true);
    		setCapsValue(entityCaps, caps_actionCount, 30);
    	}
    	if (actionCount < 0) {
    		setCapsValue(entityCaps, caps_actionReverse, false);
    		setCapsValue(entityCaps, caps_actionCount, 0);
    	}
    }

    public void action4(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	// 両手を前に出すモーション
    	if (Modchu_ModelCapsHelper.getCapsValueFloat(this, caps_onGround, entityCaps, (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm))) > 0.0F) {
    		bipedRightArm.rotateAngleX += bipedLeftArm.rotateAngleX += -1.57F;
    		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
    	} else {
    		bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = -1.57F;
    		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
    	}
    }

    public void action5(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	//
    }

    public void action6(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    public void action7(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    public void action8(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    public void action9(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    public void action30(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	//デバック用
    	if (mod_Modchu_ModchuLib.mod_modchu_modchulib.getPackage() == null) return;
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
    }

    @Override
    public void syncModel(MMM_IModelCaps entityCaps, MultiModelBaseBiped model) {
    	super.syncModel(entityCaps, model);
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 3) bipedBody.rotateAngleZ = model.bipedBody.rotateAngleZ;
    }

    @Override
    public void setArmorBipedRightArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
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
    public void setArmorBipedLeftArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
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
    public void setArmorBipedRightLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
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
    public void setArmorBipedLeftLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
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
