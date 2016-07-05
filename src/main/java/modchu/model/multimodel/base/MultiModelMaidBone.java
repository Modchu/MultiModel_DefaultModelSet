package modchu.model.multimodel.base;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelRenderer;

public class MultiModelMaidBone extends MultiModelSkirtFloats {

	public ModchuModel_ModelRenderer Skirt;
	public ModchuModel_ModelRenderer SkirtTop;
	public ModchuModel_ModelRenderer SkirtFront;
	public ModchuModel_ModelRenderer SkirtRight;
	public ModchuModel_ModelRenderer SkirtLeft;
	public ModchuModel_ModelRenderer SkirtBack;
	private ModchuModel_ModelRenderer test;
	private ModchuModel_ModelRenderer test2;

	public MultiModelMaidBone() {
		this(0.0F);
	}

	public MultiModelMaidBone(float f) {
		this(f, 0.0F);
	}

	public MultiModelMaidBone(float f, float f1) {
		this(f, f1, 64, 32);
	}

	public MultiModelMaidBone(float f, float f1, int i, int j, Object... o) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j, (Object[]) o);
	}

	@Override
	public void initModel(float f, float f1, Object... o) {
		initModel(f, f1, true);
	}

	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedCloak = new ModchuModel_ModelRenderer(this, "bipedCloak");
		bipedEars = new ModchuModel_ModelRenderer(this, "bipedEars");
		bipedHead = new ModchuModel_ModelRenderer(this, "bipedHead");
		bipedHeadwear = new ModchuModel_ModelRenderer(this, "bipedHeadwear");
		bipedBody = new ModchuModel_ModelRenderer(this, "bipedBody");
		bipedRightArm = new ModchuModel_ModelRenderer(this, "bipedRightArm");
		bipedLeftArm = new ModchuModel_ModelRenderer(this, "bipedLeftArm");
		bipedRightLeg = new ModchuModel_ModelRenderer(this, "bipedRightLeg");
		bipedLeftLeg = new ModchuModel_ModelRenderer(this, "bipedLeftLeg");
		Skirt = new ModchuModel_ModelRenderer(this, "Skirt");
		mainFrame = new ModchuModel_ModelRenderer(this, "mainFrame");
		mainFrame.setRotationPoint(0F, 8F, 0F);

		if (isAfterInit) {
			afterInit(f, f1);
			bipedHead.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedHeadwear.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedBody.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedRightArm.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedLeftArm.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedRightLeg.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			bipedLeftLeg.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			Skirt.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
			mainFrame.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
/*
			test = new ModchuModel_ModelRenderer(this, "test");
			test.setTextureOffset(0, 0);
			test.addBox(-4.0F, -15.0F, 1.0F, 8, 9, 3, f + 13.0F);
			test2 = new ModchuModel_ModelRenderer(this, "test2");
			test2.setTextureOffset(0, 0);
			//test2.addBox(-4.0F, -15.0F, 1.0F, 8, 9, 3, f + 13.0F);
*/
		}
	}

	@Override
	public void armsinit(float f, float f1) {
		// 手持ち
		Arms[0] = new ModchuModel_ModelRenderer(this, "Arms0");
		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
		Arms[1] = new ModchuModel_ModelRenderer(this, "Arms1");
		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190) Arms[1].isInvertX = true;
		HeadMount = new ModchuModel_ModelRenderer(this, "HeadMount");
		HeadMount.setRotationPoint(0F, 0F, 0F);
		HeadTop = new ModchuModel_ModelRenderer(this, "HeadTop");
		HeadTop.setRotationPoint(0.0F, -8.0F, 0.0F);
	}

	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModchuModel_ModelRenderer(this, "rightArm");
		rightArmPlus = new ModchuModel_ModelRenderer(this, "rightArmPlus");
		rightArm2 = new ModchuModel_ModelRenderer(this, "rightArm2");
		rightArmPlus2 = new ModchuModel_ModelRenderer(this, "rightArmPlus2");
		rightHand = new ModchuModel_ModelRenderer(this, "rightHand");
		leftArm = new ModchuModel_ModelRenderer(this, "leftArm");
		leftArmPlus = new ModchuModel_ModelRenderer(this, "leftArmPlus");
		leftArm2 = new ModchuModel_ModelRenderer(this, "leftArm2");
		leftArmPlus2 = new ModchuModel_ModelRenderer(this, "leftArmPlus2");
		leftHand = new ModchuModel_ModelRenderer(this, "leftHand");
		rightLeg = new ModchuModel_ModelRenderer(this, "rightLeg");
		rightLegPlus = new ModchuModel_ModelRenderer(this, "rightLegPlus");
		rightLeg2 = new ModchuModel_ModelRenderer(this, "rightLeg2");
		rightLegPlus2 = new ModchuModel_ModelRenderer(this, "rightLegPlus2");
		leftLeg = new ModchuModel_ModelRenderer(this, "leftLeg");
		leftLegPlus = new ModchuModel_ModelRenderer(this, "leftLegPlus");
		leftLeg2 = new ModchuModel_ModelRenderer(this, "leftLeg2");
		leftLegPlus2 = new ModchuModel_ModelRenderer(this, "leftLegPlus2");
		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}

	/**
	 * ふんわりスカート初期化
	 */
	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		SkirtTop = new ModchuModel_ModelRenderer(this, "SkirtTop");
		SkirtFront = new ModchuModel_ModelRenderer(this, "SkirtFront");
		SkirtRight = new ModchuModel_ModelRenderer(this, "SkirtRight");
		SkirtLeft = new ModchuModel_ModelRenderer(this, "SkirtLeft");
		SkirtBack = new ModchuModel_ModelRenderer(this, "SkirtBack");
	}

	@Override
	public void defaultAddChild() {
		defaultAddChildSetting();
		defaultSkirtFloatsAddChild();
	}

	public void defaultAddChildSetting() {
		if (bipedRightArm != null) bipedRightArm.clearChildModels();
		if (bipedLeftArm != null) bipedLeftArm.clearChildModels();
		if (bipedRightLeg != null) bipedRightLeg.clearChildModels();
		if (bipedLeftLeg != null) bipedLeftLeg.clearChildModels();
		if (bipedHeadwear != null) bipedHeadwear.clearChildModels();
		if (Skirt != null) Skirt.clearChildModels();
		if (HeadMount != null) HeadMount.clearChildModels();
		if (HeadTop != null) HeadTop.clearChildModels();
		if (bipedHead != null) {
			bipedHead.clearChildModels();
			if (bipedHeadwear != null) bipedHead.addChild(bipedHeadwear);
		}
		if (bipedBody != null) {
			bipedBody.clearChildModels();
			if (bipedHead != null) bipedBody.addChild(bipedHead);
			if (bipedRightArm != null) bipedBody.addChild(bipedRightArm);
			if (bipedLeftArm != null) bipedBody.addChild(bipedLeftArm);
			if (bipedRightLeg != null) bipedBody.addChild(bipedRightLeg);
			if (bipedLeftLeg != null) bipedBody.addChild(bipedLeftLeg);
			if (Skirt != null) bipedBody.addChild(Skirt);
		}
		if (upperBody != null) {
			upperBody.clearBoneChildModels();
			upperBody.clearBoneSpecialChildModels();
			if (bipedBody != null) upperBody.addBoneChild(bipedBody);
			if (bipedRightLeg != null) upperBody.addBoneSpecialChild(bipedRightLeg);
			if (bipedLeftLeg != null) upperBody.addBoneSpecialChild(bipedLeftLeg);
		}
		if (lowerBody != null) {
			lowerBody.clearBoneChildModels();
			lowerBody.clearBoneSpecialChildModels();
			if (bipedRightLeg != null) lowerBody.addBoneChild(bipedRightLeg);
			if (bipedLeftLeg != null) lowerBody.addBoneChild(bipedLeftLeg);
		}
		if (hip != null) {
			hip.clearBoneChildModels();
			hip.clearBoneSpecialChildModels();
			if (bipedBody != null) hip.addBoneChild(bipedBody);
			if (bipedRightLeg != null) hip.addBoneChild(bipedRightLeg);
			if (bipedLeftLeg != null) hip.addBoneChild(bipedLeftLeg);
		}
		if (rightShoulder != null) {
			rightShoulder.clearBoneChildModels();
			rightShoulder.clearBoneSpecialChildModels();
			if (bipedRightArm != null) rightShoulder.addBoneChild(bipedRightArm);
		}
		if (leftShoulder != null) {
			leftShoulder.clearBoneChildModels();
			leftShoulder.clearBoneSpecialChildModels();
			if (bipedLeftArm != null) leftShoulder.addBoneChild(bipedLeftArm);
		}
		if (center != null) {
			center.clearBoneChildModels();
			center.clearBoneSpecialChildModels();
		}
		if (leftLegIK != null) {
			leftLegIK.clearBoneChildModels();
			leftLegIK.clearBoneSpecialChildModels();
			if (bipedLeftLeg != null) leftLegIK.addBoneChild(bipedLeftLeg);
		}
		if (rightLegIK != null) {
			rightLegIK.clearBoneChildModels();
			rightLegIK.clearBoneSpecialChildModels();
			if (bipedRightLeg != null) rightLegIK.addBoneChild(bipedRightLeg);
		}
		if (bipedHead != null && HeadMount != null) bipedHead.addChild(HeadMount);
		if (bipedHead != null && HeadTop != null) bipedHead.addChild(HeadTop);
		if (Arms != null) {
			if (bipedRightArm != null && Arms[0] != null) bipedRightArm.addChild(Arms[0]);
			if (bipedLeftArm != null && Arms[1] != null) bipedLeftArm.addChild(Arms[1]);
			if (Arms[0] != null && rightHand != null) rightHand.removeChild(Arms[0]);
			if (Arms[1] != null && leftHand != null) leftHand.removeChild(Arms[1]);
			if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
			if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		}
		if (mainFrame != null) {
			mainFrame.clearChildModels();
			if (bipedBody != null) mainFrame.addChild(bipedBody);
		}
		boolean b = true;
		setCapsValue(null, caps_visible, bipedLeftArm, b);
		setCapsValue(null, caps_visible, bipedRightArm, b);
		setCapsValue(null, caps_visible, bipedLeftLeg, b);
		setCapsValue(null, caps_visible, bipedRightLeg, b);
		b = false;
		setCapsValue(null, caps_visible, leftArm, b);
		setCapsValue(null, caps_visible, rightArm, b);
		setCapsValue(null, caps_visible, leftLeg, b);
		setCapsValue(null, caps_visible, rightLeg, b);

		if (test != null) {
			bipedHead.addChild(test);
			test.clearChildModels();
			if (test2 != null) test.addChild(test2);
		}
	}

	@Override
	public void defaultSkirtFloatsAddChild() {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		if (SkirtTop != null) {
			if (SkirtFront != null) SkirtTop.addChild(SkirtFront);
			if (SkirtRight != null) SkirtTop.addChild(SkirtRight);
			if (SkirtLeft != null) SkirtTop.addChild(SkirtLeft);
			if (SkirtBack != null) SkirtTop.addChild(SkirtBack);
		}
		if (Skirt != null) {
			if (SkirtTop != null) Skirt.addChild(SkirtTop);
			setCapsValue(null, caps_visible, Skirt, false);
			//Modchu_Debug.mDebug("setRotationAnglesLM Skirt.childModels="+Skirt.childModels);
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		//f = 移動時に増加する
		//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。
		//f2 = 時間で常に増え続けている
		//f3 = 向いている方角方向で変化
		//f4 = 向いている上下方向で変化
		//f5 = スケール値？
		//Modchu_Debug.mdDebug("setRotationAnglesLM f="+f+" f4="+f4, 4);
		//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM this="+this);
		//if (Modchu_CastHelper.Byte(entityCaps.getCapsValue(entityCaps.caps_EntityType)) == entityCaps.entityType_PFLM) Modchu_Debug.mDebug("setRotationAnglesLM bipedRightLeg.rotateAngleX="+bipedRightLeg.rotateAngleX);
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotateAngleY = f3 / 57.29578F;
		boolean isTicksElytraFlying = isTicksElytraFlying(entityCaps);
		float f6 = getTicksElytraFlyingCorrection(entityCaps, isTicksElytraFlying);
		bipedHead.rotateAngleX = isTicksElytraFlying ? -((float)Math.PI / 4.0F) : f4 / 57.29578F;
		float f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F + (float) Math.PI);
		bipedRightArm.rotateAngleX = f7 * 2.0F * f1 * 0.5F / f6;
		float f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F);
		bipedLeftArm.rotateAngleX = f8 * 2.0F * f1 * 0.5F / f6;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)
				&& Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			bipedRightArm.rotateAngleX = f7 * 1.4F * f1 / f6;
			bipedLeftArm.rotateAngleX = f8 * 1.4F * f1 / f6;
			bipedLeftArm.rotateAngleZ = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.2812F) - 1.0F) * 1.0F * f1;
			bipedRightArm.rotateAngleZ = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.2312F) + 1.0F) * 1.0F * f1;
		} else {
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
		}
		bipedRightLeg.rotateAngleX = f8 * 1.4F * f1 / f6;
		bipedLeftLeg.rotateAngleX = f7 * 1.4F * f1 / f6;
		bipedRightLeg.rotateAngleY = bipedLeftLeg.rotateAngleY = bipedRightLeg.rotateAngleZ = bipedLeftLeg.rotateAngleZ = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			// 乗り物に乗っている
			bipedRightArm.rotateAngleX += -0.6283185F;
			bipedLeftArm.rotateAngleX += -0.6283185F;
			bipedRightLeg.rotateAngleX = bipedLeftLeg.rotateAngleX = -1.256637F;
			bipedRightLeg.rotateAngleY = 0.3141593F;
			bipedLeftLeg.rotateAngleY = -bipedRightLeg.rotateAngleY;
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
		// アイテム持ってるときの腕振りを抑える
		//Modchu_Debug.mdDebug("heldItem[0]="+heldItem[0]+" heldItem[1]="+heldItem[1]);
		int version = Modchu_Main.getMinecraftVersion();
		boolean flag = version > 189;
		if (heldItem[1] != 0
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (heldItem[1] == 3) {
				// 剣などのガードポーズ
				bipedLeftArm.rotateAngleX = -0.8F;
				bipedLeftArm.rotateAngleY = -0.4F;
				if (flag) {
					if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) Arms[1].setRotateAngle(-4.6F, 2.45F, 0.12F);
					//Arms[1].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
				}
			} else {
				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[1];
			}
		}
		if (heldItem[0] != 0
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (heldItem[0] == 3) {
				// 剣などのガードポーズ
				bipedRightArm.rotateAngleX = flag ? -1.2F : -0.8F;
				bipedRightArm.rotateAngleY = flag ? -0.7F : -0.4F;
				bipedRightArm.rotateAngleZ = flag ? -0.28F : bipedRightArm.rotateAngleZ;
				//bipedRightArm.rotateAngleX = Modchu_Debug.debaf1;
				//bipedRightArm.rotateAngleY = Modchu_Debug.debaf2;
				//bipedRightArm.rotateAngleZ = Modchu_Debug.debaf3;
				//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
			} else {
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * heldItem[0];
			}
		}

		armSwing(f, f1, f2, f3, f4, f5, entityCaps);

		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ =
				bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ =
				upperBody.rotateAngleX = upperBody.rotateAngleY = upperBody.rotateAngleZ =
				Skirt.rotateAngleX = Skirt.rotateAngleY = Skirt.rotateAngleZ = 0.0F;
		bipedBody.rotationPointY = 3.5F;
		Skirt.rotationPointY = 5.5F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			// しゃがみ
			upperBody.rotateAngleX = 0.5F;
			bipedHead.rotateAngleX -= upperBody.rotateAngleX;
			bipedRightLeg.rotateAngleX += 1.0F;
			bipedLeftLeg.rotateAngleX += 1.0F;
			bipedHead.rotationPointY = -3.0F;
			bipedBody.rotationPointZ = 2.0F;
			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F - 1.0F;
			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.3F;
			Skirt.rotateAngleX = -upperBody.rotateAngleX;
			//Skirt.rotationPointY = 6.0F - 0.5F;
			Skirt.rotationPointZ = -1.0F;
		} else {
			// 通常立ち
			upperBody.rotateAngleX = 0.0F;
			//Skirt.rotationPointZ = 0.0F;
			bipedHead.rotationPointY = -3.5F;
			bipedBody.rotationPointZ = 0.0F;
			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			// 弓構え
			Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
			boolean flag1 = isDominantArmLeft(entityCaps);
			float f9 = flag1 ? -0.4F : 0.0F;
			float f10 = flag1 ? 0.8F : 0.0F;
			bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f9 * 0.6F) + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY = 0.1F - f10 * 0.6F + bipedHead.rotateAngleY + 0.4F;
			float f11 = -((float) Math.PI / 2F) + bipedHead.rotateAngleX;
			bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = f11;
			bipedRightArm.rotationPointX = -3F;
			bipedLeftArm.rotationPointX = -bipedRightArm.rotationPointX;
		} else {
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
				// 待機状態
				float f12 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.062F) * 0.05F - 0.7F;
				bipedRightArm.rotateAngleX = f12;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedRightArm.rotateAngleZ = -0.4F;
				bipedLeftArm.rotateAngleX = f12;
				bipedLeftArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.4F;
			} else {
				// 呼吸 腕等
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 1 bipedRightArm.rotateAngleX="+bipedRightArm.rotateAngleX);
				bipedRightArm.rotateAngleZ += 0.5F;
				bipedLeftArm.rotateAngleZ -= 0.5F;
				float f13 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleZ += f13;
				bipedLeftArm.rotateAngleZ -= f13;
				float f14 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
				bipedRightArm.rotateAngleX += f14;
				bipedLeftArm.rotateAngleX -= f14;
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 2 f2="+f2);
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 2 f2 * 0.067F="+(f2 * 0.067F));
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 2 Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F)="+Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F));
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 2 Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F="+Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F);
				//Modchu_Debug.mDebug("MultiModelMaidBone setRotationAnglesLM 2 bipedRightArm.rotateAngleX="+bipedRightArm.rotateAngleX);
			}
		}
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		//if (Modchu_CastHelper.Byte(entityCaps.getCapsValue(entityCaps.caps_EntityType)) == entityCaps.entityType_PFLM) Modchu_Debug.mDebug("setRotationAnglesLM end. bipedRightLeg.rotateAngleX="+bipedRightLeg.rotateAngleX);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedBody.rotateAngleX="+bipedBody.rotateAngleX);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedBody.rotateAngleY="+bipedBody.rotateAngleY);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedBody.rotateAngleZ="+bipedBody.rotateAngleZ);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedRightLeg.rotateAngleX="+bipedRightLeg.rotateAngleX);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedRightLeg.rotateAngleY="+bipedRightLeg.rotateAngleY);
		//Modchu_Debug.mDebug("setRotationAnglesLM bipedRightLeg.rotateAngleZ="+bipedRightLeg.rotateAngleZ);
	}

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float) Modchu_EntityCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);
		//Modchu_Debug.mdDebug("motionY="+motionY);
		SkirtFront.rotationPointX = SkirtBack.rotationPointX = SkirtRight.rotationPointZ = SkirtLeft.rotationPointZ = motionY * 4.0F;

		SkirtFront.rotateAngleX = SkirtRight.rotateAngleZ = motionY;
		SkirtLeft.rotateAngleZ = SkirtBack.rotateAngleX = -motionY;

		SkirtFront.scaleX = SkirtBack.scaleX = SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);
	}

	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (bipedHead != null) bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (bipedHeadwear != null) bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (bipedBody != null) bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		if (bipedRightArm != null) bipedRightArm.setRotationPoint(-3.5F, -3.2F, 0.0F);
		if (bipedLeftArm != null) bipedLeftArm.setRotationPoint(3.5F, -3.2F, 0.0F);
		if (bipedRightLeg != null) bipedRightLeg.setRotationPoint(-1.5F, 3.5F, 0.0F);
		if (bipedLeftLeg != null) bipedLeftLeg.setRotationPoint(1.5F, 3.5F, 0.0F);
		if (Skirt != null) Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
		if (Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_PFLM) {
			bipedHead.rotateAngleZ = 0.0F;
		}
		upperBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperBody.setRotateAngle(0.0F, 0.0F, 0.0F);
		lowerBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		lowerBody.setRotateAngle(0.0F, 0.0F, 0.0F);
		hip.setRotationPoint(0.0F, 0.0F, 0.0F);
		hip.setRotateAngle(0.0F, 0.0F, 0.0F);
		rightShoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightShoulder.setRotateAngle(0.0F, 0.0F, 0.0F);
		leftShoulder.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftShoulder.setRotateAngle(0.0F, 0.0F, 0.0F);
		center.setRotationPoint(0.0F, 0.0F, 0.0F);
		center.setRotateAngle(0.0F, 0.0F, 0.0F);
		leftLegIK.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftLegIK.setRotateAngle(0.0F, 0.0F, 0.0F);
		rightLegIK.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightLegIK.setRotateAngle(0.0F, 0.0F, 0.0F);
		mainFrame.setRotationPoint(0.0F, 8.0F, 0.0F);
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 189) Arms[1].setRotateAngle(0.0F, 0.0F, 0.0F);
	}

	@Override
	public void setMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotationPointY = -3.5F;
		bipedBody.rotationPointY = 3.5F;
		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame.setRotateAngle(0.0F, 0.0F, 0.0F);

		rightArm.rotateAngleZ = 0.78F;
		leftArm.rotateAngleZ = -0.78F;
		bipedHead.rotateAngleX = bipedHead.rotateAngleY = bipedHead.rotateAngleZ = bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ = 0.0F;
	}

	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (armSwingFlag(entityCaps)) {
			// 腕振り
			float f6, f7, f8;
			f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[0]) * (float) Math.PI * 2.0F);
			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[1]) * (float) Math.PI * 2.0F);
			bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
			// R
			if (onGrounds[0] > 0F) {
				f6 = 1.0F - onGrounds[0];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[0] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedRightArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedRightArm.rotateAngleZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[0] * 3.141593F) * -0.4F;
			}
			// L
			if (onGrounds[1] > 0F) {
				bipedBody.rotateAngleY *= -1.0F;
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedLeftArm.rotateAngleY -= bipedBody.rotateAngleY * 2.0F;
				bipedLeftArm.rotateAngleZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * 3.141593F) * 0.4F;
			}
		}
	}

	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps, int renderArmIndex) {
		//Modchu_Debug.mDebug("MultiModelMaidBone　setRotationAnglesfirstPerson");
		int version = Modchu_Main.getMinecraftVersion();
		boolean flag = version > 189;
		ModchuModel_ModelRenderer arm = !flag ? getDominantArm(entityCaps) : renderArmIndex == 0 ? getBipedRightArm(entityCaps) : getBipedLeftArm(entityCaps);
		if (renderArmIndex != 0) {
			arm.setRotateAngle(0.0F, 0.0F, 0.0F);
		}
		int ck = isFirstPersonCheckItem(entityCaps, renderArmIndex);
		switch (ck) {
		case 1:
			//地図を持っている時
			arm.rotateAngleX = 0.0F;
			arm.rotateAngleY = 0.0F;
			arm.rotateAngleZ = 0.0F;
			if (flag) {
				if (renderArmIndex == 0) {
					arm.rotationPointX = -7.5F;
					arm.rotationPointY = 3.2F;
					arm.rotationPointZ = 0.0F;
					//arm.rotationPointX = Modchu_Debug.debaf1;
					//arm.rotationPointY = Modchu_Debug.debaf2;
					//arm.rotationPointZ = Modchu_Debug.debaf3;
					//arm.rotateAngleX = Modchu_Debug.debaf4;
					//arm.rotateAngleY = Modchu_Debug.debaf5;
					//arm.rotateAngleZ = Modchu_Debug.debaf6;
					//Modchu_Debug.mdDebug("MultiModelMaidBone "+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3);
					//Modchu_Debug.mdDebug("MultiModelMaidBone "+Modchu_Debug.debaf4+" "+Modchu_Debug.debaf5+" "+Modchu_Debug.debaf6, 1);
				} else {
					arm.rotationPointX = 8.5F;
					arm.rotationPointY = 3.2F;
					arm.rotationPointZ = 0.4F;
				}
			} else {
				if (version < 180) {
					if (dominantArm == 0) {
						arm.rotationPointX = -6.2F;
						arm.rotationPointY = 1.8F;
						arm.rotationPointZ = -0.4F;
						//arm.rotationPointX = -4.2F;
						//arm.rotationPointY = 2.0F;
						//arm.rotationPointZ = -1.0F;
					} else {
						arm.rotationPointX = -6.0F;
						arm.rotationPointY = 1.2F;
						arm.rotationPointZ = -0.4F;
					}
					//arm.rotationPointX = Modchu_Debug.debaf1;
					//arm.rotationPointY = Modchu_Debug.debaf2;
					//arm.rotationPointZ = Modchu_Debug.debaf3;
					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3);
					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf4+" "+Modchu_Debug.debaf5+" "+Modchu_Debug.debaf6, 1);
				}
				else if (renderArmIndex == 0) {
					arm.rotationPointX = -3.0F;
					arm.rotationPointY = 1.5F;
					arm.rotationPointZ = 0.0F;

					bipedRightArm.rotateAngleX = -0.6F;
					bipedRightArm.rotateAngleY = -1.0F;
					bipedRightArm.rotateAngleZ = 0.8F;
					//bipedRightArm.rotationPointX += Modchu_Debug.debaf1;
					//bipedRightArm.rotationPointY += Modchu_Debug.debaf2;
					//bipedRightArm.rotationPointZ += Modchu_Debug.debaf3;
					bipedRightArm.rotationPointX += -4.8F;
					bipedRightArm.rotationPointY += 5.0F;
					bipedRightArm.rotationPointZ += 0.8F;

					//bipedLeftArm.rotateAngleX = Modchu_Debug.debaf1;
					//bipedLeftArm.rotateAngleY = Modchu_Debug.debaf2;
					//bipedLeftArm.rotateAngleZ = Modchu_Debug.debaf3;
					bipedLeftArm.rotateAngleX = 0.0F;
					bipedLeftArm.rotateAngleY = -0.4F;
					bipedLeftArm.rotateAngleZ = -0.4F;
					//bipedLeftArm.rotationPointX = Modchu_Debug.debaf1;
					//bipedLeftArm.rotationPointY = Modchu_Debug.debaf2;
					//bipedLeftArm.rotationPointZ = Modchu_Debug.debaf3;
					bipedLeftArm.rotationPointX = 5.2F;
					bipedLeftArm.rotationPointY = 6.0F;
					bipedLeftArm.rotationPointZ = -0.8F;
				} else {
					bipedRightArm.rotationPointX = -10.0F;
					bipedRightArm.rotationPointY = 20.0F;
					bipedRightArm.rotationPointZ = 0.4F;
					bipedRightArm.rotateAngleX = 0.0F;
					bipedRightArm.rotateAngleY = 0.0F;
					bipedRightArm.rotateAngleZ = -1.6F;

					bipedLeftArm.rotationPointX = 12.4F;
					bipedLeftArm.rotationPointY = 20.0F;
					bipedLeftArm.rotationPointZ = -4.4F;
					bipedLeftArm.rotateAngleX = 0.0F;
					bipedLeftArm.rotateAngleY = 0.0F;
					bipedLeftArm.rotateAngleZ = 1.6F;
					//bipedLeftArm.rotationPointX = Modchu_Debug.debaf1;
					//bipedLeftArm.rotationPointY = Modchu_Debug.debaf2;
					//bipedLeftArm.rotationPointZ = Modchu_Debug.debaf3;
					//bipedRightArm.rotateAngleX = Modchu_Debug.debaf4;
					//bipedRightArm.rotateAngleY = Modchu_Debug.debaf5;
					//bipedRightArm.rotateAngleZ = Modchu_Debug.debaf6;
					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3);
					//Modchu_Debug.mdDebug(""+Modchu_Debug.debaf4+" "+Modchu_Debug.debaf5+" "+Modchu_Debug.debaf6, 1);
				}
			}
			break;
		case 0:
			//素手時
			if (renderArmIndex == 0) {
				arm.rotateAngleX = 0.0F;
				arm.rotateAngleY = 0.0F;
				arm.rotateAngleZ = 0.5F;
				arm.rotationPointY = 4.0F;
			} else {
				arm.rotateAngleX = 0.0F;
				arm.rotateAngleY = 0.0F;
				arm.rotateAngleZ = -0.5F;
				arm.rotationPointX = 8.0F;
				arm.rotationPointY = 4.0F;
				arm.rotationPointZ = 0.0F;
				//Modchu_Debug.dDebug("X="+arm.rotationPointX+" Y="+arm.rotationPointY+" Z="+arm.rotationPointZ);
			}
			if (!flag) {
				float f6, f7, f8;
				// L
				if (onGrounds[1] > 0F) {
					f6 = 1.0F - onGrounds[1];
					f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
					f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f6 * (float) Math.PI);
					//Modchu_Debug.mDebug("f7="+f7);
					//arm.rotateAngleZ += f7 * 1.2F;
					//arm.rotateAngleX = Modchu_Debug.debaf1;
					//arm.rotateAngleY = Modchu_Debug.debaf2;
					//arm.rotateAngleZ = Modchu_Debug.debaf3;
					arm.rotateAngleX = 0.2F - f8 * 1.4F;
					arm.rotateAngleY = 0.1F;
					arm.rotateAngleZ = 0.1F;
					//arm.rotateAngleY -= f7 * 0.4F;
					//Modchu_Debug.dDebug("debaf1="+Modchu_Debug.debaf1+" 2="+Modchu_Debug.debaf2+" 3="+Modchu_Debug.debaf3);

					//arm.rotationPointX += Modchu_Debug.debaf1;
					//arm.rotationPointY += Modchu_Debug.debaf2;
					//arm.rotationPointZ += Modchu_Debug.debaf3;
					arm.rotationPointX -= f8 * 6F;
					//arm.rotationPointY -= f8 * 6F;
					arm.rotationPointZ -= f8 * 7F;
				}
			}
			break;
		}
		//Modchu_Debug.mdDebug("X="+arm.rotationPointX+" Y="+arm.rotationPointY+" Z="+arm.rotationPointZ, 3);
		//Modchu_Debug.mdDebug("X="+arm.rotateAngleX+" Y="+arm.rotateAngleY+" Z="+arm.rotateAngleZ, 1);
	}

	@Override
	public void showAllParts(ModchuModel_IEntityCaps entityCaps) {
		int armorType = Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType);
		boolean b = armorType == 0;
		//Modchu_Debug.mDebug("showAllParts armorType="+armorType+" this="+this);
/*
		if (entityCaps instanceof ModchuModel_IEntityCaps
				&& Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {
			Modchu_Debug.mDebug1("MultiModel showAllParts LMM armorType="+armorType+" b="+b);
		} else {
			Modchu_Debug.mDebug1("MultiModel showAllParts entityCaps="+entityCaps);
			float[] f = getArmorModelsSize();
			//Modchu_Debug.mlDebug("modelSize="+modelSize+" "+this);
			//Modchu_Debug.mlDebug("modelSize="+modelSize+" f[0]="+f[0]+" f[1]="+f[1]);
			armorType = modelSize == f[0] ? 1 : modelSize == f[1] ? 2 : 0;
			//Modchu_Debug.mDebug("MultiModel showAllParts LMM armorType="+armorType+" b="+b);
		}
*/
		setArmorBipedHeadShowModel(entityCaps, b);
		setArmorBipedBodyShowModel(entityCaps, b);
		setArmorBipedRightArmShowModel(entityCaps, b);
		setArmorBipedLeftArmShowModel(entityCaps, b);
		setArmorSkirtShowModel(entityCaps, b);
		setArmorBipedRightLegShowModel(entityCaps, b);
		setArmorBipedLeftLegShowModel(entityCaps, b);
		setArmorBipedOtherShowModel(entityCaps, b);
	}

	@Override
	public int showArmorParts(ModchuModel_IEntityCaps entityCaps, int parts, int index) {
		// 鎧の表示用
		switch(parts) {
		case 0:
			setArmorBipedRightLegShowModel(entityCaps, true);
			setArmorBipedLeftLegShowModel(entityCaps, true);
			break;
		case 1:
			setArmorSkirtShowModel(entityCaps, true);
			break;
		case 2:
			setArmorBipedBodyShowModel(entityCaps, true);
			setArmorBipedRightArmShowModel(entityCaps, true);
			setArmorBipedLeftArmShowModel(entityCaps, true);
			break;
		case 3:
			setArmorBipedHeadShowModel(entityCaps, true);
			break;
		}
		return -1;
	}

	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		String[] s = {
				"bipedCloak", "bipedEars", "SkirtTop", "SkirtFront", "SkirtLeft",
				"SkirtRight", "SkirtBack", "rightArm", "rightArm2", "rightArmPlus",
				"rightArmPlus2", "rightHand", "rightLeg", "rightLeg2", "rightLegPlus",
				"rightLegPlus2", "leftArm", "leftArm2", "leftArmPlus", "leftArmPlus2",
				"leftHand", "leftLeg", "leftLeg2", "leftLegPlus", "leftLegPlus2",
				"HeadMount", "mainFrame", "j", "k", "field_78121_j", "field_78122_k"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
		String[] s1 = {
				"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
				"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
				"f", "g", "h", "i", "field_78116_c",
				"field_78114_d", "field_78115_e", "field_78112_f", "field_78113_g", "field_78123_h",
				"field_78124_i"
		};
		String[] s2 = {
				"Head", "Headwear", "Body", "RightArm", "LeftArm",
				"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
				"RightArm", "LeftArm", "RightLeg", "LeftLeg", "bipedHead",
				"Headwear", "Body", "RightArm", "LeftArm", "RightLeg",
				"LeftLeg"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}

	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
		//if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) < 2) {
			setCapsValue(entityCaps, caps_indexOfAllVisible, "Skirt", Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType));
		//} else {
			//if (SkirtTop != null) setCapsValue(entityCaps, caps_indexOfAllVisible, "Skirt", Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType), SkirtTop.showModel);
			if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) > 1) setCapsValue(entityCaps, caps_visible, Skirt, false);
		//}
	}

	/**
	 * 身長
	 */
	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.35F;
	}

	/**
	 * 横幅
	 */
	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.5F;
	}

	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.17F;
	}

	@Override
	public float[] getArmorModelsSize() {
		return new float[]{ 0.1F, 0.5F };
	}

	/**
	 * 他Mobを頭に乗せた時の他Mob基準位置調整
	 */
	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		float d = 1.0F;
		return d;
	}

	@Override
	public ModchuModel_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag) && Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1 | Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 6) {
			if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;
			return leftArm;
		} else {
			if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return bipedRightArm;
			return bipedLeftArm;
		}
	}

	@Override
	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (Skirt != null) {
			if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) {
				setCapsValue(entityCaps, caps_visible, Skirt, b);
			} else {
				setCapsValue(entityCaps, caps_visible, SkirtTop, b);
				setCapsValue(entityCaps, caps_visible, SkirtFront, b);
				setCapsValue(entityCaps, caps_visible, SkirtRight, b);
				setCapsValue(entityCaps, caps_visible, SkirtLeft, b);
				setCapsValue(entityCaps, caps_visible, SkirtBack, b);
			}
		}
	}

	@Override
	public ModchuModel_ModelRenderer getArms(int i) {
		return Arms[i];
	}

	@Override
	public ModchuModel_ModelRenderer getHeadMount() {
		return HeadMount;
	}

	@Override
	public String getUsingTexture() {
		return "default";
	}

	@Override
	public void actionRelease6(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease6(entityCaps);
		mainFrame.setRotationPoint(0.0F, 8.0F, 0.0F);
		Skirt.rotateAngleX = 0.0F;
		Skirt.rotateAngleY = 0.0F;
		Skirt.rotateAngleZ = 0.0F;
	}

	@Override
	public void motionModelCorrectionBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		Skirt.rotateAngleX = Skirt.rotateAngleY = Skirt.rotateAngleZ = 0.0F;
	}

	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		mainFrame.rotationPointY += 8.0F;
		Skirt.rotationPointY = 6.0F;
	}

	@Override
	public float getLeashOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.4F;
	}

	@Override
	public boolean isItemHolder(ModchuModel_IEntityCaps entityCaps) {
		return true;
	}
}