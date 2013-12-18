package net.minecraft.src;import modchu.model.ModchuModel_IModelCaps;import modchu.model.ModchuModel_ModelCapsHelper;import modchu.model.ModchuModel_ModelPlate;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.MultiModelSkirtFloats;import net.minecraft.util.MathHelper;public class MultiModel extends MultiModelSkirtFloats {	public ModchuModel_ModelRenderer ChignonR;	public ModchuModel_ModelRenderer ChignonL;	public ModchuModel_ModelRenderer ChignonB;	public ModchuModel_ModelRenderer Tail;	public ModchuModel_ModelRenderer SideTailR;	public ModchuModel_ModelRenderer SideTailL;	public ModchuModel_ModelRenderer Skirt;	public ModchuModel_ModelRenderer SkirtTop;	public ModchuModel_ModelRenderer SkirtFront;	public ModchuModel_ModelRenderer SkirtRight;	public ModchuModel_ModelRenderer SkirtLeft;	public ModchuModel_ModelRenderer SkirtBack;	public MultiModel() {		this(0.0F);	}	public MultiModel(float f) {		this(f, 0.0F);	}	public MultiModel(float f, float f1) {		this(f, f1, 64, 32);	}	public MultiModel(float f, float f1, int i, int j) {		super(f, f1, i, j);	}	@Override	public void initModel(float f, float f1) {		initModel(f, f1, true);	}	public void initModel(float f, float f1, boolean isAfterInit) {		bipedCloak = new ModchuModel_ModelRenderer(this);		bipedEars = new ModchuModel_ModelRenderer(this);		bipedHead = new ModchuModel_ModelRenderer(this, 0, 0);		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);		bipedHeadwear = new ModchuModel_ModelRenderer(this, 24, 0);		bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);		bipedBody = new ModchuModel_ModelRenderer(this, 32, 8);		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);		bipedRightArm = new ModchuModel_ModelRenderer(this, 48, 0);		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);		bipedLeftArm = new ModchuModel_ModelRenderer(this, 56, 0);		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);		bipedRightLeg = new ModchuModel_ModelRenderer(this, 32, 19);		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);		bipedLeftLeg = new ModchuModel_ModelRenderer(this, 32, 19);		bipedLeftLeg.mirror = true;		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);		Skirt = new ModchuModel_ModelRenderer(this, 0, 16);		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);		ChignonR = new ModchuModel_ModelRenderer(this, 24, 18);		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);		ChignonL = new ModchuModel_ModelRenderer(this, 24, 18);		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);		ChignonB = new ModchuModel_ModelRenderer(this, 52, 10);		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);		Tail = new ModchuModel_ModelRenderer(this, 46, 20);		Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);		SideTailR = new ModchuModel_ModelRenderer(this, 58, 21);		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);		SideTailL = new ModchuModel_ModelRenderer(this, 58, 21);		SideTailL.mirror = true;		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);		upperBody = new ModchuModel_ModelRenderer(this);		lowerBody = new ModchuModel_ModelRenderer(this);		hip = new ModchuModel_ModelRenderer(this);		mainFrame = new ModchuModel_ModelRenderer(this, 0, 0);		mainFrame.setRotationPoint(0F, 8F, 0F);		if (isAfterInit) afterInit(f, f1);	}	@Override	public void armsinit(float f, float f1) {		// 手持ち		Arms[0] = new ModchuModel_ModelRenderer(this, 0, 0);		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);		Arms[1] = new ModchuModel_ModelRenderer(this, 0, 0);		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);		Arms[1].isInvertX = true;		HeadMount = new ModchuModel_ModelRenderer(this, "HeadMount");		HeadMount.setRotationPoint(0F, 0F, 0F);		HeadTop = new ModchuModel_ModelRenderer(this, "HeadTop");		HeadTop.setRotationPoint(0.0F, -8.0F, 0.0F);	}	@Override	public void actionPartsInit(float f, float f1) {		rightArm = new ModchuModel_ModelRenderer(this, 48, 0);		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);		rightArmPlus = new ModchuModel_ModelRenderer(this);		//rightArmPlus.setTextureOffset(52, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModchuModel_ModelRenderer(this, 48, 3);		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		rightArmPlus2 = new ModchuModel_ModelRenderer(this);		rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);		rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);		rightArmPlus2.rotateAngleX = 1.570796313F;		rightHand = new ModchuModel_ModelRenderer(this, 48, 6);		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);		rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);		leftArm = new ModchuModel_ModelRenderer(this, 56, 0);		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);		leftArmPlus = new ModchuModel_ModelRenderer(this);		//leftArmPlus.setTextureOffset(60, 0.addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModchuModel_ModelRenderer(this, 56, 3);		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new ModchuModel_ModelRenderer(this);		leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);		leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);		leftArmPlus2.rotateAngleX = 1.570796313F;		leftHand = new ModchuModel_ModelRenderer(this, 56, 6);		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);		leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);		rightLeg = new ModchuModel_ModelRenderer(this, 32, 19);		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus = new ModchuModel_ModelRenderer(this);		rightLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);		rightLegPlus.rotateAngleX = 1.570796313F;		rightLeg2 = new ModchuModel_ModelRenderer(this, 32, 23);		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		rightLegPlus2 = new ModchuModel_ModelRenderer(this);		rightLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);		rightLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLeg = new ModchuModel_ModelRenderer(this, 32, 19);		leftLeg.mirror = true;		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus = new ModchuModel_ModelRenderer(this);		leftLegPlus.mirror = true;		leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);		leftLegPlus.rotateAngleX = 1.570796313F;		leftLeg2 = new ModchuModel_ModelRenderer(this, 32, 23);		leftLeg2.mirror = true;		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);		leftLegPlus2 = new ModchuModel_ModelRenderer(this);		leftLegPlus2.mirror = true;		leftLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);		leftLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);		leftLegPlus2.rotateAngleX = 1.570796313F;		rightHand.showModel = leftHand.showModel = rightArm.showModel =				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;		setCapsValue(caps_aimedBowBan, false);		setCapsValue(caps_sneakBan, false);		setCapsValue(caps_waitBan, false);		setCapsValue(caps_sittingBan, false);		setCapsValue(caps_sleepingBan, false);	}	/**	 * ふんわりスカート初期化	 */	@Override	public void skirtFloatsInit(float f, float f1) {		if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) return;		//ふんわりスカート上		SkirtTop = new ModchuModel_ModelRenderer(this, 8, 16);		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXZTop);		SkirtTop.setRotationPoint(-4.0F, -4.0F, -4.0F);		//ふんわりスカート前		SkirtFront = new ModchuModel_ModelRenderer(this, 8, 24);		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXYFront);		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート右		SkirtRight = new ModchuModel_ModelRenderer(this, 0, 24);		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeZYRight);		SkirtRight.setRotationPoint(8.0F, 0.0F, 0.0F);		//ふんわりスカート左		SkirtLeft = new ModchuModel_ModelRenderer(this, 16, 24);		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeZYLeft);		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート後ろ		SkirtBack = new ModchuModel_ModelRenderer(this, 24, 24);		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, ModchuModel_ModelPlate.planeXYBack);		SkirtBack.setRotationPoint(0.0F, 0.0F, 8.0F);	}	@Override	public void defaultAddChild() {		defaultAddChildSetting();		defaultSkirtFloatsAddChild();	}	public void defaultAddChildSetting() {		if (bipedRightArm != null) bipedRightArm.clearChildModels();		if (bipedLeftArm != null) bipedLeftArm.clearChildModels();		if (bipedRightLeg != null) bipedRightLeg.clearChildModels();		if (bipedLeftLeg != null) bipedLeftLeg.clearChildModels();		if (bipedHeadwear != null) bipedHeadwear.clearChildModels();		if (Skirt != null) Skirt.clearChildModels();		if (ChignonR != null) ChignonR.clearChildModels();		if (ChignonL != null) ChignonL.clearChildModels();		if (ChignonB != null) ChignonB.clearChildModels();		if (Tail != null) Tail.clearChildModels();		if (SideTailR != null) SideTailR.clearChildModels();		if (SideTailL != null) SideTailL.clearChildModels();		if (HeadMount != null) HeadMount.clearChildModels();		if (HeadTop != null) HeadTop.clearChildModels();		if (bipedHead != null) {			bipedHead.clearChildModels();			if (bipedHeadwear != null) bipedHead.addChild(bipedHeadwear);			if (ChignonR != null) bipedHead.addChild(ChignonR);			if (ChignonL != null) bipedHead.addChild(ChignonL);			if (ChignonB != null) bipedHead.addChild(ChignonB);			if (Tail != null) bipedHead.addChild(Tail);			if (SideTailR != null) bipedHead.addChild(SideTailR);			if (SideTailL != null) bipedHead.addChild(SideTailL);		}		if (bipedBody != null) {			bipedBody.clearChildModels();			if (bipedHead != null) bipedBody.addChild(bipedHead);			if (bipedRightArm != null) bipedBody.addChild(bipedRightArm);			if (bipedLeftArm != null) bipedBody.addChild(bipedLeftArm);		}		if (upperBody != null) {			upperBody.clearBoneChildModels();			if (bipedBody != null) upperBody.addBoneChild(bipedBody);		}		if (lowerBody != null) {			lowerBody.clearBoneChildModels();			if (Skirt != null) lowerBody.addBoneChild(Skirt);			if (bipedRightLeg != null) lowerBody.addBoneChild(bipedRightLeg);			if (bipedLeftLeg != null) lowerBody.addBoneChild(bipedLeftLeg);		}		if (hip != null) {			hip.clearBoneChildModels();			if (bipedBody != null) hip.addBoneChild(bipedBody);			if (bipedRightLeg != null) hip.addBoneChild(bipedRightLeg);			if (bipedLeftLeg != null) hip.addBoneChild(bipedLeftLeg);		}		if (bipedHead != null && HeadMount != null) bipedHead.addChild(HeadMount);		if (bipedHead != null && HeadTop != null) bipedHead.addChild(HeadTop);		if (Arms != null) {			if (bipedRightArm != null && Arms[0] != null) bipedRightArm.addChild(Arms[0]);			if (bipedLeftArm != null && Arms[1] != null) bipedLeftArm.addChild(Arms[1]);			if (Arms[0] != null && rightHand != null) rightHand.removeChild((ModchuModel_ModelRenderer) Arms[0]);			if (Arms[1] != null && leftHand != null) leftHand.removeChild((ModchuModel_ModelRenderer) Arms[1]);			if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 6.5F, 0F);			if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);		}		if (mainFrame != null) {			((ModchuModel_ModelRenderer) mainFrame).clearChildModels();			if (bipedBody != null) mainFrame.addChild(bipedBody);			if (Skirt != null) mainFrame.addChild(Skirt);			if (bipedRightLeg != null) mainFrame.addChild(bipedRightLeg);			if (bipedLeftLeg != null) mainFrame.addChild(bipedLeftLeg);		}		boolean b = true;		setCapsValue(caps_visible, bipedLeftArm, b);		setCapsValue(caps_visible, bipedRightArm, b);		setCapsValue(caps_visible, bipedLeftLeg, b);		setCapsValue(caps_visible, bipedRightLeg, b);	}	@Override	public void defaultSkirtFloatsAddChild() {		if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) return;		if (SkirtTop != null) {			if (SkirtFront != null) SkirtTop.addChild(SkirtFront);			if (SkirtRight != null) SkirtTop.addChild(SkirtRight);			if (SkirtLeft != null) SkirtTop.addChild(SkirtLeft);			if (SkirtBack != null) SkirtTop.addChild(SkirtBack);		}		if (Skirt != null) {			if (SkirtTop != null) Skirt.addChild(SkirtTop);			setCapsValue(caps_visible, Skirt, false);		}	}	@Override	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		//f = 移動時に増加する		//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。		//f2 = 時間で常に増え続けている		//f3 = 向いている方角方向で変化		//f4 = 向いている上下方向で変化		//f5 = スケール値？		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		bipedHead.rotateAngleY = f3 / 57.29578F;		bipedHead.rotateAngleX = f4 / 57.29578F;		bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;		bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak) && !ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding) && ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;			bipedLeftArm.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;			bipedRightArm.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;		} else {			bipedRightArm.rotateAngleZ = 0.0F;			bipedLeftArm.rotateAngleZ = 0.0F;		}		bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;		bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;		bipedRightLeg.rotateAngleY = bipedLeftLeg.rotateAngleY = bipedRightLeg.rotateAngleZ = bipedLeftLeg.rotateAngleZ = 0.0F;		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding)) {			// 乗り物に乗っている			bipedRightArm.rotateAngleX += -0.6283185F;			bipedLeftArm.rotateAngleX += -0.6283185F;			bipedRightLeg.rotateAngleX = -1.256637F;			bipedLeftLeg.rotateAngleX = -1.256637F;			bipedRightLeg.rotateAngleY = 0.3141593F;			bipedLeftLeg.rotateAngleY = -0.3141593F;		}		// アイテム持ってるときの腕振りを抑える		if (heldItem[1] != 0 && !ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[1];		}		if (heldItem[0] != 0 && !ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[0];		}		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ =				bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ =				upperBody.rotateAngleX = upperBody.rotateAngleY = upperBody.rotateAngleZ =				Skirt.rotateAngleX = Skirt.rotateAngleY = Skirt.rotateAngleZ = 0.0F;		bipedBody.rotationPointY = 3.5F;		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak)) {			// しゃがみ			upperBody.rotateAngleX = 0.5F;			bipedHead.rotateAngleX -= 0.5F;			bipedHead.rotationPointY = -3.5F;			bipedBody.rotationPointZ = 2.0F;			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 7.0F - 1.0F;			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 3.6F;			Skirt.rotationPointY = 9.0F - 0.5F;			Skirt.rotationPointZ = 3.0F;		} else {			// 通常立ち			upperBody.rotateAngleX = 0.0F;			Skirt.rotationPointZ = 0.0F;			Skirt.rotationPointY = 9.0F;			bipedHead.rotationPointY = -4.0F;			bipedBody.rotationPointZ = 0.0F;			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 7.0F;		}		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow)) {			// 弓構え			float f6 = MathHelper.sin(onGrounds[dominantArm] * 3.141593F);			float f7 = MathHelper.sin((1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);			bipedRightArm.rotateAngleZ = 0.0F;			bipedLeftArm.rotateAngleZ = 0.0F;			bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F) + bipedHead.rotateAngleY;			bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F) + bipedHead.rotateAngleY + 0.4F;			bipedRightArm.rotateAngleX = -1.470796F;			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;			bipedRightArm.rotationPointX = -3F;			bipedLeftArm.rotationPointX = 3F;		} else {			if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsWait)) {				// 待機状態				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;				bipedRightArm.rotateAngleY = 0.0F;				bipedRightArm.rotateAngleZ = -0.4F;				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;				bipedLeftArm.rotateAngleY = 0.0F;				bipedLeftArm.rotateAngleZ = 0.4F;			} else {				// 呼吸 腕等				bipedRightArm.rotateAngleZ += 0.5F;				bipedLeftArm.rotateAngleZ -= 0.5F;				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;			}		}	}	@Override	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) return;		float motionY = (float) ModchuModel_ModelCapsHelper.getCapsValueDouble(this, caps_motionY);		SkirtFront.rotationPointX = SkirtBack.rotationPointX = SkirtRight.rotationPointZ = SkirtLeft.rotationPointZ = motionY * 4.0F;		SkirtFront.rotateAngleX = SkirtRight.rotateAngleZ = motionY;		SkirtLeft.rotateAngleZ = SkirtBack.rotateAngleX = -motionY;		SkirtFront.scaleX = SkirtBack.scaleX = SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);	}	@Override	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		if (bipedHead != null) bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);		if (bipedHeadwear != null) bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);		if (bipedBody != null) bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);		if (bipedRightArm != null) bipedRightArm.setRotationPoint(-3.0F, -3.0F, 0.0F);		if (bipedLeftArm != null) bipedLeftArm.setRotationPoint(3.0F, -3.0F, 0.0F);		if (bipedRightLeg != null) bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);		if (bipedLeftLeg != null) bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);		if (Skirt != null) Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);		if (ModchuModel_ModelCapsHelper.getCapsValueByte(entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_PFLM) {			bipedHead.rotateAngleZ = 0.0F;		}		upperBody.setRotationPoint(0.0F, 0.0F, 0.0F);		upperBody.setRotateAngle(0.0F, 0.0F, 0.0F);		lowerBody.setRotationPoint(0.0F, 0.0F, 0.0F);		lowerBody.setRotateAngle(0.0F, 0.0F, 0.0F);		hip.setRotationPoint(0.0F, 0.0F, 0.0F);		hip.setRotateAngle(0.0F, 0.0F, 0.0F);	}	@Override	public void setMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		action1Reset(f, f1, f2, f3, f4, f5, entityCaps);		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		bipedHead.rotationPointY = -3.5F;		bipedBody.rotationPointY = 3.5F;		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);		mainFrame.setRotateAngle(0.0F, 0.0F, 0.0F);		rightArm.rotateAngleZ = 1.57F;		leftArm.rotateAngleZ = -1.57F;		bipedHead.rotateAngleX = bipedHead.rotateAngleY = bipedHead.rotateAngleZ = bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ = 0.0F;	}	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		if ((onGrounds[0] > -9990F || onGrounds[1] > -9990F) && !ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow) && !ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {			// 腕振り			float f6, f7, f8;			f6 = MathHelper.sin(MathHelper.sqrt_float(onGrounds[0]) * (float) Math.PI * 2.0F);			f7 = MathHelper.sin(MathHelper.sqrt_float(onGrounds[1]) * (float) Math.PI * 2.0F);			bipedBody.rotateAngleY = (f6 - f7) * 0.2F;			// R			if (onGrounds[0] > 0F) {				f6 = 1.0F - onGrounds[0];				f6 *= f6;				f6 *= f6;				f6 = 1.0F - f6;				f7 = MathHelper.sin(f6 * (float) Math.PI);				f8 = MathHelper.sin(onGrounds[0] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;				bipedRightArm.rotateAngleX -= f7 * 1.2D + f8;				bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;				bipedRightArm.rotateAngleZ = MathHelper.sin(onGrounds[0] * 3.141593F) * -0.4F;			}			// L			if (onGrounds[1] > 0F) {				f6 = 1.0F - onGrounds[1];				f6 *= f6;				f6 *= f6;				f6 = 1.0F - f6;				f7 = MathHelper.sin(f6 * (float) Math.PI);				f8 = MathHelper.sin(onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;				bipedLeftArm.rotateAngleZ = MathHelper.sin(onGrounds[1] * 3.141593F) * 0.4F;			}		}	}	@Override	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		ModchuModel_ModelRenderer arm = getBipedRightArm(entityCaps);		Object entity = getCapsValue(entityCaps, entityCaps.caps_Entity);		if (entity != null && getCapsValue(entityCaps, entityCaps.caps_currentEquippedItem) != null) {			//地図を持っている時			if (dominantArm == 0) {				arm.rotationPointX = -3.0F;				arm.rotationPointY = 1.5F;				arm.rotationPointZ = 0.0F;			} else {				arm.rotationPointX = -8.0F;				arm.rotationPointY = 4.0F;				arm.rotationPointZ = 0.0F;			}		} else {			//素手時			if (dominantArm == 0) {				arm.rotateAngleX = 0.0F;				arm.rotateAngleY = 0.0F;				arm.rotateAngleZ = 0.5F;				arm.rotationPointY = 4.0F;			} else {				arm.rotateAngleX = 0.0F;				arm.rotateAngleY = 0.0F;				arm.rotateAngleZ = -0.5F;				arm.rotationPointX = 8.0F;				arm.rotationPointY = 4.0F;				arm.rotationPointZ = 0.0F;			}			float f6, f7, f8;			// L			if (onGrounds[1] > 0F) {				f6 = 1.0F - onGrounds[1];				f7 = MathHelper.sin(f6 * (float) Math.PI);				f8 = MathHelper.cos(f6 * (float) Math.PI);				//Modchu_Debug.mDebug("f7="+f7);				//arm.rotateAngleZ += f7 * 1.2F;				//arm.rotateAngleX = Modchu_Debug.debaf1;				//arm.rotateAngleY = Modchu_Debug.debaf2;				//arm.rotateAngleZ = Modchu_Debug.debaf3;				arm.rotateAngleX = 0.2F - f8 * 1.4F;				arm.rotateAngleY = 0.1F;				arm.rotateAngleZ = 0.1F;				//arm.rotateAngleY -= f7 * 0.4F;				//Modchu_Debug.dDebug("debaf1="+Modchu_Debug.debaf1+" 2="+Modchu_Debug.debaf2+" 3="+Modchu_Debug.debaf3);				//arm.rotationPointX += Modchu_Debug.debaf1;				//arm.rotationPointY += Modchu_Debug.debaf2;				//arm.rotationPointZ += Modchu_Debug.debaf3;				arm.rotationPointX -= f8 * 6F;				//arm.rotationPointY -= f8 * 6F;				arm.rotationPointZ -= f8 * 7F;			}		}	}	@Override	public void showAllParts() {		// 表示制限を解除してすべての部品を表示/*		setCapsValue(caps_visible, bipedHead, true);		setCapsValue(caps_visible, bipedBody, true);		setCapsValue(caps_visible, bipedRightArm, true);		setCapsValue(caps_visible, bipedLeftArm, true);		setCapsValue(caps_visible, Skirt, true);		setCapsValue(caps_visible, bipedRightLeg, true);		setCapsValue(caps_visible, bipedLeftLeg, true);*/	}	@Override	public int showArmorParts(ModchuModel_IModelCaps entityCaps, int parts, int index) {		// 鎧の表示用		boolean f;		// 兜		f = parts == 3 ? true : false;		setArmorBipedHeadShowModel(entityCaps, f);		// 鎧		f = parts == 2 ? true : false;		setArmorBipedBodyShowModel(entityCaps, f);		setArmorBipedRightArmShowModel(entityCaps, f);		setArmorBipedLeftArmShowModel(entityCaps, f);		// 脚甲		f = parts == 1 ? true : false;		setArmorSkirtShowModel(entityCaps, f);		// 臑当		f = parts == 0 ? true : false;		setArmorBipedRightLegShowModel(entityCaps, f);		setArmorBipedLeftLegShowModel(entityCaps, f);		return -1;	}	@Override	public void defaultPartsSettingBefore(ModchuModel_IModelCaps entityCaps) {		String[] s = {				"bipedCloak", "bipedEars", "SkirtTop", "SkirtFront", "SkirtLeft",				"SkirtRight", "SkirtBack", "rightArm", "rightArm2", "rightArmPlus",				"rightArmPlus2", "rightHand", "rightLeg", "rightLeg2", "rightLegPlus",				"rightLegPlus2", "leftArm", "leftArm2", "leftArmPlus", "leftArmPlus2",				"leftHand", "leftLeg", "leftLeg2", "leftLegPlus", "leftLegPlus2",				"HeadMount", "mainFrame", "j", "k", "field_78121_j", "field_78122_k"		};		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);		String[] s1 = {				"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",				"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",				"f", "g", "h", "i", "field_78116_c",				"field_78114_d", "field_78115_e", "field_78112_f", "field_78113_g", "field_78123_h",				"field_78124_i"		};		String[] s2 = {				"Head", "Headwear", "Body", "RightArm", "LeftArm",				"RightLeg", "LeftLeg", "Head", "Headwear", "Body",				"RightArm", "LeftArm", "RightLeg", "LeftLeg", "bipedHead",				"Headwear", "Body", "RightArm", "LeftArm", "RightLeg",				"LeftLeg"		};		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);	}	@Override	public void showModelSettingReflects(ModchuModel_IModelCaps entityCaps) {		super.showModelSettingReflects(entityCaps);		//if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) {		setCapsValue(entityCaps, caps_indexOfAllVisible, "Skirt", ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_armorType));		//}	}	/**	 * 身長	 */	@Override	public float getHeight() {		return getHeight(null);	}	@Override	public float getHeight(ModchuModel_IModelCaps pEntityCaps) {		return 1.35F;	}	/**	 * 横幅	 */	@Override	public float getWidth() {		return getWidth(null);	}	@Override	public float getWidth(ModchuModel_IModelCaps pEntityCaps) {		return 0.5F;	}	@Override	public float getyOffset() {		return getyOffset(null);	}	@Override	public float getyOffset(ModchuModel_IModelCaps pEntityCaps) {		return 1.17F;	}	@Override	public float[] getArmorModelsSize() {		return new float[]{		0.1F, 0.5F		};	}	/**	 * 他Mobを頭に乗せた時の他Mob基準位置調整	 */	@Override	public float getMountedYOffset() {		return getMountedYOffset(null);	}	@Override	public float getMountedYOffset(ModchuModel_IModelCaps pEntityCaps) {		float d = 1.0F;		if (isRiding) {			//d -= 0.1D;		}		;		return d;	}	@Override	public ModchuModel_ModelRenderer getBipedRightArm(ModchuModel_IModelCaps entityCaps) {		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction) && ModchuModel_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0 | ModchuModel_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {			if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;			return leftArm;		} else {			if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return bipedRightArm;			return bipedLeftArm;		}	}	@Override	public void setArmorSkirtShowModel(ModchuModel_IModelCaps entityCaps, boolean b) {		if (Skirt != null) {			if (ModchuModel_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) {				setCapsValue(caps_visible, Skirt, b);			} else {				setCapsValue(caps_visible, SkirtTop, b);				setCapsValue(caps_visible, SkirtFront, b);				setCapsValue(caps_visible, SkirtRight, b);				setCapsValue(caps_visible, SkirtLeft, b);				setCapsValue(caps_visible, SkirtBack, b);			}		}	}	@Override	public ModchuModel_ModelRenderer getArms(int i) {		return (ModchuModel_ModelRenderer) Arms[i];	}	@Override	public ModchuModel_ModelRenderer getHeadMount() {		return HeadMount;	}	@Override	public String getUsingTexture() {		return "default";	}	@Override	public void actionRelease6(ModchuModel_IModelCaps entityCaps) {		super.actionRelease6(entityCaps);		mainFrame.setRotationPoint(0.0F, 8.0F, 0.0F);		Skirt.rotateAngleX = 0.0F;		Skirt.rotateAngleY = 0.0F;		Skirt.rotateAngleZ = 0.0F;	}	@Override	public void action6(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IModelCaps entityCaps) {		Skirt.rotateAngleX = Skirt.rotateAngleY = Skirt.rotateAngleZ = 0.0F;		super.action6(f, f1, f2, f3, f4, f5, entityCaps);		mainFrame.rotationPointY += 8.0F;		Skirt.rotationPointY = 9.0F;	}}