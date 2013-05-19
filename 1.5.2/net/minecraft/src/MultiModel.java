package net.minecraft.src;

/*//b181delete
import java.util.HashMap;
import java.util.Map;
*///b181delete
//b173deleteimport java.util.List;

public class MultiModel extends MultiModelSkirtFloats {

    public MMM_ModelRenderer ChignonR;
    public MMM_ModelRenderer ChignonL;
    public MMM_ModelRenderer ChignonB;
    public MMM_ModelRenderer Tail;
    public MMM_ModelRenderer SideTailR;
    public MMM_ModelRenderer SideTailL;
    public MMM_ModelRenderer Skirt;
    public MMM_ModelRenderer SkirtTop;
    public MMM_ModelRenderer SkirtFront;
    public MMM_ModelRenderer SkirtRight;
    public MMM_ModelRenderer SkirtLeft;
    public MMM_ModelRenderer SkirtBack;

    public MultiModel() {
    	this(0.0F);
    }

    public MultiModel(float f) {
    	this(f, 0.0F);
    }

    public MultiModel(float f, float f1) {
    	this(f, f1, 64, 32);
    }

    public MultiModel(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 += 8F;
    	bipedCloak = new Modchu_ModelRenderer(this);
    	bipedEars = new Modchu_ModelRenderer(this);
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) bipedHead).addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	((Modchu_ModelRenderer) bipedHead).addChild(HeadMount);
    	bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
    	((Modchu_ModelRenderer) bipedHeadwear).addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
    	((Modchu_ModelRenderer) bipedHead).addChild(bipedHeadwear);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 8);
    	((Modchu_ModelRenderer) bipedBody).addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	((Modchu_ModelRenderer) bipedRightArm).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	((Modchu_ModelRenderer) bipedBody).addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	((Modchu_ModelRenderer) bipedLeftArm).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	((Modchu_ModelRenderer) bipedBody).addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	((Modchu_ModelRenderer) bipedRightLeg).addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	((Modchu_ModelRenderer) bipedBody).addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedLeftLeg.mirror = true;
    	((Modchu_ModelRenderer) bipedLeftLeg).addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	((Modchu_ModelRenderer) bipedBody).addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	((Modchu_ModelRenderer) Skirt).addBox(-4F, -4F, -4F, 8, 8, 8, f);
    	((Modchu_ModelRenderer) bipedBody).addChild(Skirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 18);
    	((Modchu_ModelRenderer) ChignonR).addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
    	((Modchu_ModelRenderer) ChignonR).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 18);
    	((Modchu_ModelRenderer) ChignonL).addBox(4F, -7F, 0.2F, 1, 3, 3, f);
    	((Modchu_ModelRenderer) ChignonL).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(ChignonL);
    	ChignonB = new Modchu_ModelRenderer(this, 52, 10);
    	((Modchu_ModelRenderer) ChignonB).addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
    	((Modchu_ModelRenderer) ChignonB).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(ChignonB);
    	Tail = new Modchu_ModelRenderer(this, 46, 20);
    	((Modchu_ModelRenderer) Tail).addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
    	((Modchu_ModelRenderer) Tail).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 58, 21);
    	((Modchu_ModelRenderer) SideTailR).addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	((Modchu_ModelRenderer) SideTailR).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailL.mirror = true;
    	((Modchu_ModelRenderer) SideTailL).addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	((Modchu_ModelRenderer) SideTailL).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(SideTailL);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) mainFrame).setRotationPoint(0F, 0F + f1, 0F);
    	((Modchu_ModelRenderer) mainFrame).addChild(bipedHead);
    	((Modchu_ModelRenderer) mainFrame).addChild(bipedBody);

    	actionPartsInit(f, f1);
    }

    @Override
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRenderer[18];
    	// 手持ち
    	Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[0]).setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[1]).setRotationPoint(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRenderer) Arms[1]).isInvertX = true;
    	// バイプロダクトエフェクター
    	Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[2]).setRotationPoint(-3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[3]).setRotationPoint(3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).isInvertX = true;
    	// テールソード
    	Arms[4] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[4]).setRotationPoint(-2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
    	Arms[5] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[5]).setRotationPoint(2F, 0F, 0F);
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
    	((Modchu_ModelRenderer) HeadMount).setRotationPoint(0F, 0F, 0F);
    	((Modchu_ModelRenderer) bipedHead).addChild(HeadMount);
    	((Modchu_ModelRenderer) bipedBody).addChild(Arms[4]);
    	((Modchu_ModelRenderer) bipedBody).addChild(Arms[5]);
    	((Modchu_ModelRenderer) bipedRightArm).addChild(Arms[0]);
    	((Modchu_ModelRenderer) bipedRightArm).addChild(Arms[2]);
    	((Modchu_ModelRenderer) bipedLeftArm).addChild(Arms[1]);
    	((Modchu_ModelRenderer) bipedLeftArm).addChild(Arms[3]);
    }

    /**
     * action用手足分割パーツ初期化
     */
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 48, 0);
    	((Modchu_ModelRenderer) rightArm).addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	((Modchu_ModelRenderer) rightArm).setRotationPoint(-3.0F, 9.5F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	//((Modchu_ModelRenderer) rightArmPlus).setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	rightArmPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightArm).addChild(rightArmPlus);

    	rightArm2 = new Modchu_ModelRenderer(this, 48, 3);
    	((Modchu_ModelRenderer) rightArm2).addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) rightArm2).setRotationPoint(0.0F, 2.0F, 0.0F);
    	((Modchu_ModelRenderer) rightArm).addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightArmPlus2).setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) rightArmPlus2).setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightArm2).addChild(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 48, 6);
    	((Modchu_ModelRenderer) rightHand).addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) rightHand).setRotationPoint(0.0F, 3.0F, 0.0F);
    	((Modchu_ModelRenderer) rightArm2).addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 56, 0);
    	((Modchu_ModelRenderer) leftArm).addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	((Modchu_ModelRenderer) leftArm).setRotationPoint(3.0F, 9.5F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	//((Modchu_ModelRenderer) leftArmPlus).setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	leftArmPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftArm).addChild(leftArmPlus);

    	leftArm2 = new Modchu_ModelRenderer(this, 56, 3);
    	((Modchu_ModelRenderer) leftArm2).addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) leftArm2).setRotationPoint(0.0F, 2.0F, 0.0F);
    	((Modchu_ModelRenderer) leftArm).addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) leftArmPlus2).setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) leftArmPlus2).setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftArm2).addChild(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 56, 6);
    	((Modchu_ModelRenderer) leftHand).addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) leftHand).setRotationPoint(0.0F, 3.0F, 0.0F);
    	((Modchu_ModelRenderer) leftArm2).addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	((Modchu_ModelRenderer) rightLeg).addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLeg).setRotationPoint(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus).setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightLeg).addChild(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	((Modchu_ModelRenderer) rightLeg2).addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	((Modchu_ModelRenderer) rightLeg2).setRotationPoint(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) rightLeg).addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus2).setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLegPlus2).setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightLeg2).addChild(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	leftLeg.mirror = true;
    	((Modchu_ModelRenderer) leftLeg).addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLeg).setRotationPoint(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus).setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftLeg).addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.mirror = true;
    	((Modchu_ModelRenderer) leftLeg2).addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	((Modchu_ModelRenderer) leftLeg2).setRotationPoint(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) leftLeg).addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus2).setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLegPlus2).setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	leftLegPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftLeg2).addChild(leftLegPlus2);

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
     * ふんわりスカート初期化
     */
    public void skirtFloatsInit(float f, float f1) {
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) return;
    	//ふんわりスカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	((Modchu_ModelRenderer) SkirtTop).setRotationPoint(-4.0F, -4.0F, 4.0F);
    	if (Skirt != null) ((Modchu_ModelRenderer) Skirt).addChild(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	((Modchu_ModelRenderer) SkirtFront).setRotationPoint(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChild(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	((Modchu_ModelRenderer) SkirtRight).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChild(SkirtRight);

    	//ふんわりスカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
    	((Modchu_ModelRenderer) SkirtLeft).setMirror(true);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	((Modchu_ModelRenderer) SkirtLeft).setRotationPoint(8.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChild(SkirtLeft);

    	//ふんわりスカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	((Modchu_ModelRenderer) SkirtBack).setRotationPoint(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChild(SkirtBack);
    	if (Skirt != null) setCapsValue(caps_visible, Skirt, false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	//f = 移動時に増加する
    	//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。
    	//f2 = 時間で常に増え続けている
    	//f3 = 向いている方角方向で変化
    	//f4 = 向いている上下方向で変化
    	//f5 = スケール値？
    	reset(f, f1, f2, f3, f4, f5, entityCaps);
    	//if (!Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_firstPerson)) {
    		bipedHead.rotateAngleY = f3 / 57.29578F;
    		bipedHead.rotateAngleX = f4 / 57.29578F;
    		bipedRightArm.rotateAngleX = MathHelper
    				.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
    		bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
    				* 0.5F;
    		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding) && Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
    			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    			bipedLeftArm.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
    			bipedRightArm.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
    		} else {
    			bipedRightArm.rotateAngleZ = 0.0F;
    			bipedLeftArm.rotateAngleZ = 0.0F;
    		}
    		bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
    				* f1;
    		bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F)
    				* 1.4F * f1;
    		bipedRightLeg.rotateAngleY = 0.0F;
    		bipedLeftLeg.rotateAngleY = 0.0F;
    		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsRiding)) {
    			// 乗り物に乗っている
    			bipedRightArm.rotateAngleX += -0.6283185F;
    			bipedLeftArm.rotateAngleX += -0.6283185F;
    			bipedRightLeg.rotateAngleX = -1.256637F;
    			bipedLeftLeg.rotateAngleX = -1.256637F;
    			bipedRightLeg.rotateAngleY = 0.3141593F;
    			bipedLeftLeg.rotateAngleY = -0.3141593F;
    		}
    		// アイテム持ってるときの腕振りを抑える
    		if (heldItemLeft != 0 && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
    			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemLeft;
    		}
    		if (heldItemRight != 0 && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
    			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemRight;
    		}
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;

    		armSwing(f, f1, f2, f3, f4, f5, entityCaps);

    		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
    		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsSneak)) {
    			// しゃがみ
    			bipedBody.rotateAngleX = 0.5F;
    			Skirt.rotateAngleX = -0.5F;
    			bipedRightLeg.rotateAngleX -= 0.5F;
    			bipedLeftLeg.rotateAngleX -= 0.5F;
    			bipedHead.rotationPointY = 1.0F;
    			bipedBody.rotationPointY = 3.5F;
    			bipedBody.rotationPointZ = 1.0F;
    			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F - 1.0F;
    			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.25F;
    			Skirt.rotationPointY = 5.5F - 0.5F;
    			Skirt.rotationPointZ = -1.0F;
    		} else {
    			// 通常立ち
    			bipedBody.rotateAngleX = 0.0F;
    			Skirt.rotationPointZ = 0.0F;
    			Skirt.rotateAngleX = 0.0F;
    			Skirt.rotationPointY = 5.5F;
    			bipedHead.rotationPointY = 0.0F;
    			bipedBody.rotationPointY = 3.5F;
    			bipedBody.rotationPointZ = 0.0F;
    			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F;
    		}
    		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow)) {
    			// 弓構え
    			float f6 = MathHelper.sin(onGround * 3.141593F);
    			float f7 = MathHelper.sin((1.0F - (1.0F - onGround)
    					* (1.0F - onGround)) * 3.141593F);
    			bipedRightArm.rotateAngleZ = 0.0F;
    			bipedLeftArm.rotateAngleZ = 0.0F;
    			bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F)
    					+ bipedHead.rotateAngleY;
    			bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F)
    					+ bipedHead.rotateAngleY + 0.4F;
    			bipedRightArm.rotateAngleX = -1.470796F;
    			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
    			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
    			bipedRightArm.rotationPointX = -3F;
    			bipedLeftArm.rotationPointX = 3F;
    		} else {
    			if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_getIsWait)) {
    				// 待機状態
    				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;
    				bipedRightArm.rotateAngleY = 0.0F;
    				bipedRightArm.rotateAngleZ = -0.4F;
    				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;
    				bipedLeftArm.rotateAngleY = 0.0F;
    				bipedLeftArm.rotateAngleZ = 0.4F;
    			} else {
    				// 呼吸 腕等
    				bipedRightArm.rotateAngleZ += 0.5F;
    				bipedLeftArm.rotateAngleZ -= 0.5F;
    				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    			}
    		}
    	//}
    	//
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedRightArm).getRotateAngleX(), 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedLeftArm).getRotateAngleX(), 0F, 0F);
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) return;
    	float motionY = Modchu_ModelCapsHelper.getCapsValueFloat(this, caps_motionY);
    	SkirtFront.rotationPointX =
    			SkirtBack.rotationPointX = motionY * 4.0F;
    	SkirtRight.rotationPointY = motionY * 4.0F;
    	SkirtLeft.rotationPointY = 8.0F - motionY * 4.0F;

    	SkirtTop.rotateAngleX = -1.570796313F;
    	SkirtBack.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX = 1.570796313F;
    	SkirtRight.rotateAngleX = -1.570796313F;
    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtLeft.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX += motionY;
    	SkirtRight.rotateAngleY += motionY;
    	SkirtLeft.rotateAngleY = -motionY;
    	SkirtBack.rotateAngleX -= motionY;

    	((Modchu_ModelRenderer) SkirtFront).scaleX = ((Modchu_ModelRenderer) SkirtBack).scaleX = 1.0F - (motionY * 1.0F);
    	((Modchu_ModelRenderer) SkirtRight).scaleZ = ((Modchu_ModelRenderer) SkirtLeft).scaleZ = 1.0F - (motionY * 1.0F);
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	if (bipedHead != null) ((Modchu_ModelRenderer) bipedHead).setRotationPoint(0.0F, 0.0F, 0.0F);
    	if (bipedHeadwear != null) ((Modchu_ModelRenderer) bipedHeadwear).setRotationPoint(0.0F, 0.0F, 0.0F);
    	if (bipedBody != null) ((Modchu_ModelRenderer) bipedBody).setRotationPoint(0.0F, -3.0F, 0.0F);
    	if (bipedRightArm != null) ((Modchu_ModelRenderer) bipedRightArm).setRotationPoint(-3.0F, -3.0F, 0.0F);
    	if (bipedLeftArm != null) ((Modchu_ModelRenderer) bipedLeftArm).setRotationPoint(3.0F, -3.0F, 0.0F);
    	if (bipedRightLeg != null) ((Modchu_ModelRenderer) bipedRightLeg).setRotationPoint(-1.5F, 15F, 0.0F);
    	if (bipedLeftLeg != null) ((Modchu_ModelRenderer) bipedLeftLeg).setRotationPoint(1.5F, 15F, 0.0F);
    	if (Skirt != null) ((Modchu_ModelRenderer) Skirt).setRotationPoint(0.0F, 4.0F, 0.0F);
    }

    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	float[] lgrounds = null;
    	float onGroundR = 0F;
    	float onGroundL = 0F;
    	if (entityCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds, entityCaps);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = Modchu_ModelCapsHelper.getCapsValueFloat(this, caps_onGround, entityCaps);
    	}
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow) && !Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_oldwalking)) {
    		// 腕振り
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
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	InventoryPlayer inventoryPlayer = (InventoryPlayer) getCapsValue(caps_Inventory);
    	if (inventoryPlayer != null
    			&& inventoryPlayer.getCurrentItem() != null) {
    		//地図を持っている時
    		bipedRightArm.rotationPointX = -3.0F;
    		bipedRightArm.rotationPointY = 1.5F;
    		bipedRightArm.rotationPointZ = 0.0F;
    		bipedLeftArm.rotationPointX = -4.5F;
    		bipedLeftArm.rotationPointY = 1.5F;
    		bipedLeftArm.rotationPointZ = 0.0F;
    	} else {
    		//素手時
    		//setOnGround(((EntityPlayer) entity).getSwingProgress(1.0F));
    		bipedRightArm.rotateAngleX = 0.0F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = 0.5F;
    		bipedLeftArm.rotateAngleX = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.0F;

    		bipedRightArm.rotationPointY = 4.0F;
    		bipedLeftArm.rotationPointX = 4.0F;
    		bipedLeftArm.rotationPointY = 8.0F;
    		bipedLeftArm.rotationPointZ = -2.0F;
    	}
    }

    @Override
    public void showAllParts() {
    	// 表示制限を解除してすべての部品を表示
/*
    	setCapsValue(caps_visible, bipedHead, true);
    	setCapsValue(caps_visible, bipedBody, true);
    	setCapsValue(caps_visible, bipedRightArm, true);
    	setCapsValue(caps_visible, bipedLeftArm, true);
    	setCapsValue(caps_visible, Skirt, true);
    	setCapsValue(caps_visible, bipedRightLeg, true);
    	setCapsValue(caps_visible, bipedLeftLeg, true);
*/
    }

    @Override
    public int showArmorParts(MMM_IModelCaps entityCaps, int parts) {
    	// 鎧の表示用
    	boolean f;
    	// 兜
    	f = parts == 3 ? true : false;
    	setArmorBipedHeadShowModel(entityCaps, f);
    	// 鎧
    	f = parts == 2 ? true : false;
    	setArmorBipedBodyShowModel(entityCaps, f);
    	setArmorBipedRightArmShowModel(entityCaps, f);
    	setArmorBipedLeftArmShowModel(entityCaps, f);
    	// 脚甲
    	f = parts == 1 ? true : false;
    	setArmorSkirtShowModel(entityCaps, f);
    	// 臑当
    	f = parts == 0 ? true : false;
    	setArmorBipedRightLegShowModel(entityCaps, f);
    	setArmorBipedLeftLegShowModel(entityCaps, f);

    	return -1;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	String[] s = {
    			"bipedCloak", "bipedEars", "SkirtTop", "SkirtFront", "SkirtLeft",
    			"SkirtRight", "SkirtBack", "rightArm", "rightArm2", "rightArmPlus",
    			"rightArmPlus2", "rightHand", "rightLeg", "rightLeg2", "rightLegPlus",
    			"rightLegPlus2", "leftArm", "leftArm2", "leftArmPlus", "leftArmPlus2",
    			"leftHand", "leftLeg", "leftLeg2", "leftLegPlus", "leftLegPlus2",
    			"HeadMount", "mainFrame", "j", "k", "field_78121_j",
    			"field_78122_k"
    	};
    	setCapsValue(caps_showPartsHideList, (Object) s);
    	String[] s1 = {
    			"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
    			"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
    			"f", "g", "h", "i",
    			"field_78116_c", "field_78114_d", "field_78115_e", "field_78112_f", "field_78113_g",
    			"field_78123_h", "field_78124_i"
    	};
    	String[] s2 = {
    			"Head", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
    			"RightArm", "LeftArm", "RightLeg", "LeftLeg",
    			"bipedHead", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg"
    	};
    	setCapsValue(caps_showPartsRenemeMap, s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setCapsValue(caps_indexOfAllVisible, "Skirt", Modchu_ModelCapsHelper.getCapsValueInt(this, caps_armorType));
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) == 2) {
    		if (Skirt != null) setCapsValue(caps_visible, Skirt, false);
    	}
    }

    /**
     * 身長
     */
    @Override
    public float getHeight() {
    	return 1.35F;
    }

    /**
     * 横幅
     */
    @Override
    public float getWidth() {
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return 1.17F;
    }

    @Override
    public float[] getArmorModelsSize() {
    	return new float[] {0.1F, 0.5F};
    }

    /**
     * 他Mobを頭に乗せた時の他Mob基準位置調整
     */
    @Override
    public float getMountedYOffset() {
    	float d = 1.0F;
    	if(isRiding) {
    		//d -= 0.1D;
    	};
    	return d;
    }

    @Override
    public MMM_ModelRenderer getBipedRightArm(MMM_IModelCaps entityCaps) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, entityCaps, caps_runActionNumber) == 1) {
    		if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0) return bipedRightArm;
    		return bipedLeftArm;
    	}
    }

    @Override
    public void setArmorSkirtShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	if (Skirt != null
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) {
    		//Skirt.isHidden = !b;
    		setCapsValue(caps_visible, Skirt, b);
    	}
    }

    @Override
    public MMM_ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    @Override
    public MMM_ModelRenderer getHeadMount() {
    	return HeadMount;
    }

    @Override
    public String getUsingTexture() {
    	return "default";
    }
}