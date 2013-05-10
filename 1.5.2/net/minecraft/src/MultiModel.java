package net.minecraft.src;

/*//b181delete
import java.util.HashMap;
import java.util.Map;
*///b181delete
//b173deleteimport java.util.List;

public class MultiModel extends MultiModelSkirtFloats {

    public ModelRenderer ChignonR;
    public ModelRenderer ChignonL;
    public ModelRenderer ChignonB;
    public ModelRenderer Tail;
    public ModelRenderer SideTailR;
    public ModelRenderer SideTailL;
    public ModelRenderer Skirt;
    public ModelRenderer SkirtTop;
    public ModelRenderer SkirtFront;
    public ModelRenderer SkirtRight;
    public ModelRenderer SkirtLeft;
    public ModelRenderer SkirtBack;

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
    	bipedCloak = new ModelRenderer(this);
    	bipedEars = new ModelRenderer(this);
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) bipedHead).addBoxMM(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(HeadMount);
    	bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
    	((Modchu_ModelRenderer) bipedHeadwear).addBoxMM(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(bipedHeadwear);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 8);
    	((Modchu_ModelRenderer) bipedBody).addBoxMM(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	((Modchu_ModelRenderer) bipedRightArm).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	((Modchu_ModelRenderer) bipedLeftArm).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	((Modchu_ModelRenderer) bipedRightLeg).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedLeftLeg.mirror = true;
    	((Modchu_ModelRenderer) bipedLeftLeg).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	((Modchu_ModelRenderer) Skirt).addBoxMM(-4F, -4F, -4F, 8, 8, 8, f);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(Skirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 18);
    	((Modchu_ModelRenderer) ChignonR).addBoxMM(-5F, -7F, 0.2F, 1, 3, 3, f);
    	((Modchu_ModelRenderer) ChignonR).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 18);
    	((Modchu_ModelRenderer) ChignonL).addBoxMM(4F, -7F, 0.2F, 1, 3, 3, f);
    	((Modchu_ModelRenderer) ChignonL).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(ChignonL);
    	ChignonB = new Modchu_ModelRenderer(this, 52, 10);
    	((Modchu_ModelRenderer) ChignonB).addBoxMM(-2F, -7.2F, 4F, 4, 4, 2, f);
    	((Modchu_ModelRenderer) ChignonB).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(ChignonB);
    	Tail = new Modchu_ModelRenderer(this, 46, 20);
    	((Modchu_ModelRenderer) Tail).addBoxMM(-1.5F, -6.8F, 4F, 3, 9, 3, f);
    	((Modchu_ModelRenderer) Tail).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 58, 21);
    	((Modchu_ModelRenderer) SideTailR).addBoxMM(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	((Modchu_ModelRenderer) SideTailR).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailL.mirror = true;
    	((Modchu_ModelRenderer) SideTailL).addBoxMM(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	((Modchu_ModelRenderer) SideTailL).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(SideTailL);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) mainFrame).setRotationPointMM(0F, 0F + f1, 0F);
    	((Modchu_ModelRenderer) mainFrame).addChildMM(bipedHead);
    	((Modchu_ModelRenderer) mainFrame).addChildMM(bipedBody);

    	actionPartsInit(f, f1);
    }

    @Override
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRenderer[18];
    	// 手持ち
    	Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[0]).setRotationPointMM(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[1]).setRotationPointMM(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRenderer) Arms[1]).isInvertX = true;
    	// バイプロダクトエフェクター
    	Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[2]).setRotationPointMM(-3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[3]).setRotationPointMM(3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).isInvertX = true;
    	// テールソード
    	Arms[4] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[4]).setRotationPointMM(-2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
    	Arms[5] = new Modchu_ModelRenderer(this, 0, 0);
    	((Modchu_ModelRenderer) Arms[5]).setRotationPointMM(2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[5]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);


//		Arms[8] = new Modchu_ModelRenderer(this, "HeadTop");
//		Arms[8].setRotationPointMM(0F, -3F, 1F);
    	if (HeadMount != null) {
    		if (bipedHead instanceof Modchu_ModelRenderer) {
    			((Modchu_ModelRenderer) bipedHead).removeChild(HeadMount);
    		} else {
    			bipedHead.childModels.remove(HeadMount);
    		}
    	}
    	HeadMount = new Modchu_ModelRenderer(this, "HeadMount");
    	((Modchu_ModelRenderer) HeadMount).setRotationPointMM(0F, 0F, 0F);
    	((Modchu_ModelRenderer) bipedHead).addChildMM(HeadMount);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(Arms[4]);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(Arms[5]);
    	((Modchu_ModelRenderer) bipedRightArm).addChildMM(Arms[0]);
    	((Modchu_ModelRenderer) bipedRightArm).addChildMM(Arms[2]);
    	((Modchu_ModelRenderer) bipedLeftArm).addChildMM(Arms[1]);
    	((Modchu_ModelRenderer) bipedLeftArm).addChildMM(Arms[3]);
    }

    /**
     * action用手足分割パーツ初期化
     */
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 48, 0);
    	((Modchu_ModelRenderer) rightArm).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	((Modchu_ModelRenderer) rightArm).setRotationPointMM(-3.0F, 9.5F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	//((Modchu_ModelRenderer) rightArmPlus).setTextureOffsetMM(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	rightArmPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightArm).addChildMM(rightArmPlus);

    	rightArm2 = new Modchu_ModelRenderer(this, 48, 3);
    	((Modchu_ModelRenderer) rightArm2).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) rightArm2).setRotationPointMM(0.0F, 2.0F, 0.0F);
    	((Modchu_ModelRenderer) rightArm).addChildMM(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightArmPlus2).setTextureOffsetMM(52, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) rightArmPlus2).setTextureOffsetMM(52, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightArm2).addChildMM(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 48, 6);
    	((Modchu_ModelRenderer) rightHand).addBoxMM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) rightHand).setRotationPointMM(0.0F, 3.0F, 0.0F);
    	((Modchu_ModelRenderer) rightArm2).addChildMM(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 56, 0);
    	((Modchu_ModelRenderer) leftArm).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	((Modchu_ModelRenderer) leftArm).setRotationPointMM(3.0F, 9.5F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	//((Modchu_ModelRenderer) leftArmPlus).setTextureOffsetMM(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	leftArmPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftArm).addChildMM(leftArmPlus);

    	leftArm2 = new Modchu_ModelRenderer(this, 56, 3);
    	((Modchu_ModelRenderer) leftArm2).addBoxMM(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) leftArm2).setRotationPointMM(0.0F, 2.0F, 0.0F);
    	((Modchu_ModelRenderer) leftArm).addChildMM(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) leftArmPlus2).setTextureOffsetMM(60, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) leftArmPlus2).setTextureOffsetMM(60, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftArm2).addChildMM(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 56, 6);
    	((Modchu_ModelRenderer) leftHand).addBoxMM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	((Modchu_ModelRenderer) leftHand).setRotationPointMM(0.0F, 3.0F, 0.0F);
    	((Modchu_ModelRenderer) leftArm2).addChildMM(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	((Modchu_ModelRenderer) rightLeg).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLeg).setRotationPointMM(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus).setTextureOffsetMM(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightLeg).addChildMM(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	((Modchu_ModelRenderer) rightLeg2).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	((Modchu_ModelRenderer) rightLeg2).setRotationPointMM(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) rightLeg).addChildMM(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus2).setTextureOffsetMM(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLegPlus2).setTextureOffsetMM(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) rightLeg2).addChildMM(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	leftLeg.mirror = true;
    	((Modchu_ModelRenderer) leftLeg).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLeg).setRotationPointMM(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) bipedBody).addChildMM(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus).setTextureOffsetMM(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftLeg).addChildMM(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.mirror = true;
    	((Modchu_ModelRenderer) leftLeg2).addBoxMM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	((Modchu_ModelRenderer) leftLeg2).setRotationPointMM(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) leftLeg).addChildMM(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus2).setTextureOffsetMM(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLegPlus2).setTextureOffsetMM(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	leftLegPlus2.rotateAngleX = 1.570796313F;
    	((Modchu_ModelRenderer) leftLeg2).addChildMM(leftLegPlus2);

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
    	((Modchu_ModelRenderer) SkirtTop).setRotationPointMM(-4.0F, -4.0F, 4.0F);
    	if (Skirt != null) ((Modchu_ModelRenderer) Skirt).addChildMM(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	((Modchu_ModelRenderer) SkirtFront).setRotationPointMM(0.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChildMM(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	((Modchu_ModelRenderer) SkirtRight).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChildMM(SkirtRight);

    	//ふんわりスカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
    	((Modchu_ModelRenderer) SkirtLeft).setMirror(true);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	((Modchu_ModelRenderer) SkirtLeft).setRotationPointMM(8.0F, 8.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChildMM(SkirtLeft);

    	//ふんわりスカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	((Modchu_ModelRenderer) SkirtBack).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	((Modchu_ModelRenderer) SkirtTop).addChildMM(SkirtBack);
    	if (Skirt != null) setCapsValue(caps_visible, Skirt, false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5) {
    	//f = 移動時に増加する
    	//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。
    	//f2 = 時間で常に増え続けている
    	//f3 = 向いている方角方向で変化
    	//f4 = 向いている上下方向で変化
    	//f5 = スケール値？
    	reset(f, f1, f2, f3, f4, f5);
    	if (!Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_firstPerson)) {
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

    		armSwing(f, f1, f2, f3, f4, f5);

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
    	}
    	//
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedRightArm).getRotateAngleX(), 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedLeftArm).getRotateAngleX(), 0F, 0F);
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5) {
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
    public void reset(float f, float f1, float f2, float f3, float f4, float f5) {
    	if (bipedHead != null) ((Modchu_ModelRenderer) bipedHead).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	if (bipedHeadwear != null) ((Modchu_ModelRenderer) bipedHeadwear).setRotationPointMM(0.0F, 0.0F, 0.0F);
    	if (bipedBody != null) ((Modchu_ModelRenderer) bipedBody).setRotationPointMM(0.0F, -3.0F, 0.0F);
    	if (bipedRightArm != null) ((Modchu_ModelRenderer) bipedRightArm).setRotationPointMM(-3.0F, -3.0F, 0.0F);
    	if (bipedLeftArm != null) ((Modchu_ModelRenderer) bipedLeftArm).setRotationPointMM(3.0F, -3.0F, 0.0F);
    	if (bipedRightLeg != null) ((Modchu_ModelRenderer) bipedRightLeg).setRotationPointMM(-1.5F, 15F, 0.0F);
    	if (bipedLeftLeg != null) ((Modchu_ModelRenderer) bipedLeftLeg).setRotationPointMM(1.5F, 15F, 0.0F);
    	if (Skirt != null) ((Modchu_ModelRenderer) Skirt).setRotationPointMM(0.0F, 4.0F, 0.0F);
    }

    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5) {
    	float[] lgrounds = null;
    	float onGroundR = 0F;
    	float onGroundL = 0F;
    	if (entityCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = Modchu_ModelCapsHelper.getCapsValueFloat(this, caps_onGround);
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
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5) {
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
    public int showArmorParts(int parts) {
    	// 鎧の表示用
    	boolean f;
    	// 兜
    	f = parts == 3 ? true : false;
    	setArmorBipedHeadShowModel(f);
    	// 鎧
    	f = parts == 2 ? true : false;
    	setArmorBipedBodyShowModel(f);
    	setArmorBipedRightArmShowModel(f);
    	setArmorBipedLeftArmShowModel(f);
    	// 脚甲
    	f = parts == 1 ? true : false;
    	setArmorSkirtShowModel(f);
    	// 臑当
    	f = parts == 0 ? true : false;
    	setArmorBipedRightLegShowModel(f);
    	setArmorBipedLeftLegShowModel(f);

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
    public double getMountedYOffset() {
    	double d = 1.0D;
    	if(isRiding) {
    		//d -= 0.1D;
    	};
    	return d;
    }

    @Override
    public ModelRenderer getBipedRightArm() {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 1) {
    		if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_dominantArm) == 0) return bipedRightArm;
    		return bipedLeftArm;
    	}
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	if (Skirt != null
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) < 2) {
    		//Skirt.isHidden = !b;
    		setCapsValue(caps_visible, Skirt, b);
    	}
    }

    @Override
    public ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    @Override
    public ModelRenderer getHeadMount() {
    	return HeadMount;
    }
}