package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModel_SR2;/**
 * 多関節モデル
 * 身長2.25ブロック級
 */
public class MultiModel_Beverly6 extends MultiModelBeverlyBase {	//added fields
	public Modchu_ModelRenderer Ponytail;
	public Modchu_ModelRenderer BunchR;
	public Modchu_ModelRenderer BunchL;
	public Modchu_ModelRenderer hemSkirtR1;
	public Modchu_ModelRenderer hemSkirtL1;
	public Modchu_ModelRenderer hemSkirtR2;
	public Modchu_ModelRenderer hemSkirtL2;
	public Modchu_ModelRenderer breastR;
	public Modchu_ModelRenderer breastL;
	public Modchu_ModelRenderer hipBody;
	protected byte offsetY;
	protected byte headPosY;
	protected byte bodyPosY;
	protected byte legPosY;
	protected boolean isRidingMaster = false;
	private boolean isMatingFlag = false;	public MultiModel_Beverly6() {
		super();
	}	public MultiModel_Beverly6(float f) {
		super(f);
	}	public MultiModel_Beverly6(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Beverly6(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
		if (Modchu_Reflect.getMethod("EntityVillager", "isMating") != null) isMatingFlag = true;
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 128;
		textureHeight = 64;		offsetY = (byte) (f1 + 5); //Global to Local		bodyPosY = 0; //Local waist height = always 0 (ORIGIN)
		headPosY = -9; //Local neck height = 0 - upper bodyLength
		legPosY = 4; //Lcal hip joint height = 0 + lower bodyLength		/* HEAD */
		eyeR = new Modchu_ModelRenderer(this, 17, 0);
		eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);		eyeL = new Modchu_ModelRenderer(this, 21, 0);
		eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);		Ponytail = new Modchu_ModelRenderer(this, 76, 6);
		Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);		BunchR = new Modchu_ModelRenderer(this, 64, 6);
		BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);		BunchL = new Modchu_ModelRenderer(this, 70, 6);
		BunchL.mirror = true;
		BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8, f); // Head
		bipedHead.setTextureOffset(32, 0).addBox(-4F, -8F, -4F, 8, 12, 8, f + 0.3F); // Hire
		bipedHead.setTextureOffset(72, 0).addBox(-2F, -7.2F, 4F, 4, 4, 2, f); // ChignonB
		bipedHead.setTextureOffset(56, 0).addBox(-5F, -7F, 0.2F, 1, 3, 3, f); // ChignonR
		bipedHead.setMirror(true);
		bipedHead.setTextureOffset(64, 0).addBox(4F, -7F, 0.2F, 1, 3, 3, f); // ChignonL		rightArm2 = new Modchu_ModelRenderer(this, 0, 25); //ForeArm
		rightArm2.addBox(-1.001F, -0F, -1.5F, 2, 8, 3, f);		leftArm2 = new Modchu_ModelRenderer(this, 10, 25);
		leftArm2.mirror = true;
		leftArm2.addBox(-0.999F, -0F, -1.5F, 2, 8, 3, f);		rightArm = new Modchu_ModelRenderer(this, 0, 16); //UpperArm
		rightArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);		leftArm = new Modchu_ModelRenderer(this, 10, 16);
		leftArm.mirror = true;
		leftArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);		/* LEGS */
		rightLeg2 = new Modchu_ModelRenderer(this, 0, 47); //Below Knee
		rightLeg2.addBox(-1.6F, -1F, -2F, 3, 10, 4, f);		leftLeg2 = new Modchu_ModelRenderer(this, 0, 47);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.4F, -1F, -2F, 3, 10, 4, f);		rightLeg = new Modchu_ModelRenderer(this, 0, 36); //Above Knee
		rightLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f + 0.2F);		leftLeg = new Modchu_ModelRenderer(this, 0, 36);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f + 0.2F);		/* SKIRT */
		hemSkirtR2 = new Modchu_ModelRenderer(this, 68, 48);
		hemSkirtR2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f + 0.2F);		hemSkirtL2 = new Modchu_ModelRenderer(this, 98, 48);
		hemSkirtL2.mirror = true;
		hemSkirtL2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f + 0.2F);		hemSkirtR1 = new Modchu_ModelRenderer(this, 69, 34);
		hemSkirtR1.addBox(-3F, -1F, -5F, 6, 7, 7, f);		hemSkirtL1 = new Modchu_ModelRenderer(this, 99, 34);
		hemSkirtL1.mirror = true;
		hemSkirtL1.addBox(-3F, -1F, -5F, 6, 7, 7, f);		Skirt = new Modchu_ModelRenderer(this, 18, 48);
		Skirt.addBox(-4F, 0F, -2F, 8, 3, 5, f + 0.6F);		/* BODY */
		breastR = new Modchu_ModelRenderer(this, 20, 20);
		breastR.addBox(-3F, 0F, -3F, 3, 3, 3, f + 0.1F);		breastL = new Modchu_ModelRenderer(this, 32, 20);
		breastL.mirror = true;
		breastL.addBox(0F, 0F, -3F, 3, 3, 3, f + 0.1F);		hipBody = new Modchu_ModelRenderer(this, 18, 39);
		hipBody.addBox(-4F, 0F, -2.4F, 8, 4, 5, f - 0.2F);		bipedBody = new Modchu_ModelRenderer(this, 0, 0);
		bipedBody.setTextureOffset(20, 26).addBox(-3F, -8.5F, -2.1F, 6, 9, 4, f); //body
		bipedBody.setTextureOffset(24, 16).addBox(-1F, -9.8F, -1F, 2, 2, 2, f + 0.5F); //neck		/* LOCAL SPACE */
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, offsetY, 0F);		bipedRightArm = new Modchu_ModelRenderer(this);
		bipedLeftArm = new Modchu_ModelRenderer(this);
		bipedRightLeg = new Modchu_ModelRenderer(this);
		bipedLeftLeg = new Modchu_ModelRenderer(this);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightHand = new Modchu_ModelRenderer(this, 0, 31);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);		leftHand = new Modchu_ModelRenderer(this, 10, 31);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);		rightArmPlus = new Modchu_ModelRenderer(this);
		rightArmPlus2 = new Modchu_ModelRenderer(this);
		leftArmPlus = new Modchu_ModelRenderer(this);
		leftArmPlus2 = new Modchu_ModelRenderer(this);
		rightLegPlus = new Modchu_ModelRenderer(this);
		rightLegPlus2 = new Modchu_ModelRenderer(this);
		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLegPlus2 = new Modchu_ModelRenderer(this);		setCapsValue(null, caps_visible, rightHand, false);
		setCapsValue(null, caps_visible, leftHand, false);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		HeadMount.clearChildModels();
		HeadTop.clearChildModels();
		bipedHead.clearChildModels();
		bipedBody.clearChildModels();
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(rightArm);
		bipedBody.addChild(leftArm);
		upperBody.clearBoneChildModels();
		upperBody.addBoneChild(bipedBody);
		lowerBody.clearBoneChildModels();
		lowerBody.addBoneChild(Skirt);
		lowerBody.addBoneChild(rightLeg);
		lowerBody.addBoneChild(leftLeg);
		hip.clearBoneChildModels();
		hip.addBoneChild(bipedBody);
		hip.addBoneChild(rightLeg);
		hip.addBoneChild(leftLeg);
		bipedHead.addChild(HeadMount);
		bipedHead.addChild(HeadTop);		rightArm.addChild(rightArm2);
		leftArm.addChild(leftArm2);
		rightLeg.addChild(rightLeg2);
		leftLeg.addChild(leftLeg2);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Ponytail);
		bipedHead.addChild(BunchR);
		bipedHead.addChild(BunchL);
		rightLeg2.addChild(hemSkirtR2);
		leftLeg2.addChild(hemSkirtL2);
		rightLeg.addChild(hemSkirtR1);
		leftLeg.addChild(hemSkirtL1);
		bipedBody.addChild(breastR);
		bipedBody.addChild(breastL);
		bipedBody.addChild(hipBody);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		rightArm2.addChild(Arms[0]);
		leftArm2.addChild(Arms[1]);
		((Modchu_ModelRenderer) mainFrame).clearChildModels();
		mainFrame.addChild(bipedBody);
		mainFrame.addChild(rightLeg);
		mainFrame.addChild(leftLeg);
	}	@Override
	public void actionPartsAddChild() {
		rightArm2.removeChild((Modchu_ModelRenderer) Arms[0]);
		leftArm2.removeChild((Modchu_ModelRenderer) Arms[1]);
		rightArm2.addChild(rightHand);
		rightHand.addChild(Arms[0]);
		leftArm2.addChild(leftHand);
		leftHand.addChild(Arms[1]);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	/**
	 * 姿勢制御・初期化
	 */
	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null) ;else return;
		//ふわりスカート
		float velY = (float)Modchu_EntityCapsHelper.getCapsValueDouble(this, entityCaps, caps_motionY) + 0.1F;		float fwBuf10 = velY * 1F;
		fwBuf10 = fwBuf10 > 0.5F ? 0.5F : fwBuf10;
		fwBuf10 = fwBuf10 < -0.5F ? -0.5F : fwBuf10;
		Skirt.rotationPointY += fwBuf10;		float fwBuf11 = velY * 3F;
		fwBuf11 = fwBuf11 > 1F ? 1F : fwBuf11;
		fwBuf11 = fwBuf11 < -2F ? -2F : fwBuf11;
		hemSkirtR1.rotationPointY += fwBuf11;
		hemSkirtL1.rotationPointY += fwBuf11;		float fwBuf12 = velY * 6F;
		fwBuf12 = fwBuf12 > 1F ? 1F : fwBuf12;
		fwBuf12 = fwBuf12 < -3F ? -3F : fwBuf12;
		hemSkirtR2.rotationPointY += fwBuf12;
		hemSkirtL2.rotationPointY += fwBuf12;		float fwBuf2 = velY * 2F;
		fwBuf2 = fwBuf2 > 0.1F ? 0.1F : fwBuf2;
		fwBuf2 = fwBuf2 < -0.7F ? -0.7F : fwBuf2;
		Ponytail.rotateAngleX -= fwBuf2;
		BunchR.rotateAngleZ -= fwBuf2;
		BunchL.rotateAngleZ += fwBuf2;		if (isMatingFlag
				&& Modchu_Reflect.loadClass("EntityVillager").isInstance(entityliving)) { //村人モデルとしての使用時
			//if ((EntityVillager)entityliving.isMating()) { //"KIMASHITAWA-!"
			if ((Boolean) Modchu_Reflect.invokeMethod("EntityVillager", "isMating", entityliving)) {
				bipedHead.rotateAngleX += 0.15F;
				bipedHead.rotateAngleZ += 0.25F;
				rightArm.rotateAngleX -= 0.3F;
				leftArm.rotateAngleX -= 0.3F;
				rightArm2.rotateAngleX -= 2.1F;
				leftArm2.rotateAngleX -= 2.1F;
				rightArm.rotateAngleZ -= 0.3F;
				leftArm.rotateAngleZ += 0.3F;
				rightArm.rotateAngleY -= 0.3F;
				leftArm.rotateAngleY += 0.3F;
				rightArm2.rotateAngleY -= 0.3F;
				leftArm2.rotateAngleY += 0.3F;
			}
		}	}	/**
	 * 姿勢制御・更新差分
	 */
	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		//顔向き
		bipedHead.rotateAngleY += f3 / 57.29578F;
		bipedHead.rotateAngleX += f4 / 57.29578F;
		//ポニテツインテ
		Ponytail.rotateAngleX += BunchR.rotateAngleX = BunchL.rotateAngleX = -bipedHead.rotateAngleX;
		Ponytail.rotateAngleZ -= bipedHead.rotateAngleZ;
		if (bipedHead.rotateAngleZ > 0) {
			BunchR.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		} else {
			BunchL.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		}		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			// 背負われている
			if (isRidingMaster) {
				rightArm2.rotateAngleX -= 1.3F;
				leftArm2.rotateAngleX -= 1.3F;
				rightLeg.rotateAngleX -= 1.1F;
				leftLeg.rotateAngleX -= 1.1F;
				rightLeg2.rotateAngleX += 0.9F;
				leftLeg2.rotateAngleX += 0.9F;
				rightLeg.rotateAngleY += 0.3F;
				leftLeg.rotateAngleY -= 0.3F;
				mainFrame.rotationPointY += 12F;
				mainFrame.rotationPointZ += 1F;
			}
			// 乗り物に乗っている
			else {
				rightArm.rotateAngleX -= 0.1F;
				leftArm.rotateAngleX -= 0.1F;
				rightLeg.rotateAngleX -= 1.3F;
				leftLeg.rotateAngleX -= 1.3F;
				rightLeg2.rotateAngleX += 2.5F;
				leftLeg2.rotateAngleX += 2.5F;
				mainFrame.rotationPointY += 4F;
				mainFrame.rotationPointZ += 1F;
				if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
					mainFrame.rotateAngleY += 0.7F;
					bipedHead.rotateAngleY -= 0.7F;
					if (bipedHead.rotateAngleY < -1.5F) {
						bipedHead.rotateAngleY = -1.5F;
					}
					rightLeg2.rotateAngleX -= 0.5F;
					leftLeg2.rotateAngleX -= 0.5F;
					rightLeg.rotateAngleY += 0.3F;
					leftLeg.rotateAngleY += 0.3F;
					rightLeg2.rotateAngleY += 0.2F;
					leftLeg2.rotateAngleY += 0.2F;
					bipedBody.rotateAngleY += 0.3F;
					hipBody.rotateAngleY += 0.3F;
					hemSkirtR1.rotationPointX += 2F;
					hemSkirtL1.rotationPointX += 2F;
					// hemSkirtR2.rotationPointZ -= 1F;
					//hemSkirtL2.rotationPointZ -= 1F;
				}
			}
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) //しゃがみ
			{
				if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {//膝立ち
					rightLeg.rotateAngleX -= 0.1F;
					leftLeg.rotateAngleX -= 0.2F;
					rightLeg2.rotateAngleX += 1.7F;
					leftLeg2.rotateAngleX += 1.8F;
					mainFrame.rotationPointY += 6F;
				} else {//中腰
					upperBody.rotateAngleX = 0.5F;
					bipedHead.rotateAngleX -= 0.5F;
					bipedHead.rotationPointY += 1.0F;
					bipedBody.rotationPointY += 1.0F;
					rightLeg.rotationPointY -= 1.0F;
					leftLeg.rotationPointY -= 1.0F;
					hipBody.rotateAngleX -= 0.1F + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.03F;
					rightArm.rotateAngleX += 0.1F;
					leftArm.rotateAngleX += 0.1F;
					rightLeg.rotateAngleY -= 0.07F;
					leftLeg.rotateAngleY += 0.07F;
					rightLeg.rotateAngleX -= 0.7F;
					leftLeg.rotateAngleX -= 0.7F;
					rightLeg2.rotateAngleX += 0.32F;
					leftLeg2.rotateAngleX += 0.22F;
					//mainFrame.rotationPointY += 0.4F;
					rightLeg.rotateAngleX += 0.5F;
					leftLeg.rotateAngleX += 0.5F;
				}
				//しゃがみ歩行
				float f15 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f * 0.6565F); //wave1
				float f16 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6565F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave				rightArm.rotateAngleX -= f15 * 0.2F * f1;
				leftArm.rotateAngleX += f15 * 0.2F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;				rightLeg.rotateAngleX += f15 * 0.2F * f1;
				leftLeg.rotateAngleX -= f15 * 0.2F * f1;
				rightLeg2.rotateAngleX += f22 * 0.7F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.7F * f1;				bipedBody.rotateAngleY -= f15 * 0.1F * f1;
				hipBody.rotateAngleY += f15 * 0.1F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.5F;
			} else {
				//通常歩行
				upperBody.rotateAngleX = 0.0F;
				rightLeg.rotationPointZ = leftLeg.rotationPointZ = 0.0F;
				float f15 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f * 0.4444F); //wave1
				float f16 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.4444F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave				rightArm.rotateAngleX -= f15 * 0.7F * f1;
				leftArm.rotateAngleX += f15 * 0.7F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;				rightLeg.rotateAngleX += f15 * 0.9F * f1;
				leftLeg.rotateAngleX -= f15 * 0.9F * f1;
				rightLeg2.rotateAngleX += f22 * 0.9F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.9F * f1;				bipedBody.rotateAngleY -= f15 * 0.2F * f1;
				hipBody.rotateAngleY += f15 * 0.3F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.1F;
			}
		}		// アイテム持ってるときの腕振りを抑える+表示角オフセット
		if (heldItem[1] != 0) {
			leftArm.rotateAngleX = leftArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[1];
		}
		if (heldItem[0] != 0) {
			rightArm.rotateAngleX = rightArm.rotateAngleX * 0.5F - (float) Math.PI * 0.1F * heldItem[0];
		}
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {// 待機状態 腕
			rightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F - 0.5F;
			rightArm.rotateAngleZ -= 0.3F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			leftArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F - 0.5F;
			leftArm.rotateAngleZ += 0.3F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
			breastR.rotationPointX += 0.1F;
			breastL.rotationPointX -= 0.1F;
		} else {
			if (aimedBow) {// 弓構え 腕
				float fr6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[0] * 3.141593F);
				float fl6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * 3.141593F);
				float fr7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (1.0F - (1.0F - onGrounds[0]) * (1.0F - onGrounds[0])) * 3.141593F);
				float fl7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (1.0F - (1.0F - onGrounds[1]) * (1.0F - onGrounds[1])) * 3.141593F);
				rightArm.rotateAngleZ = 0.0F;
				leftArm.rotateAngleZ = 0.0F;
				rightArm.rotateAngleY = -(0.1F - fr6 * 0.6F);
				leftArm.rotateAngleY = 0.1F - fl6 * 0.6F;
				rightArm.rotateAngleX = -1.470796F;
				leftArm.rotateAngleX = -1.470796F;
				rightArm.rotateAngleX -= fr6 * 1.2F - fr7 * 0.4F;
				leftArm.rotateAngleX -= fl6 * 1.2F - fl7 * 0.4F;
				rightArm.rotateAngleZ += Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				rightArm.rotateAngleX += bipedHead.rotateAngleX;
				leftArm.rotateAngleX += bipedHead.rotateAngleX;
				rightArm.rotateAngleY += bipedHead.rotateAngleY;
				leftArm.rotateAngleY += bipedHead.rotateAngleY;
			} else {// 通常
				rightArm.rotateAngleZ += 0.2F;
				leftArm.rotateAngleZ -= 0.2F;
				rightArm2.rotateAngleZ += 0.05F;
				leftArm2.rotateAngleZ -= 0.05F;
				rightArm.rotateAngleZ += Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.057F) * 0.05F;
			}
		}		//脚部追従
		float sinBody1X = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, bipedBody.rotateAngleX);
		float cosBody1X = 1F - Modchu_AS.getFloat(Modchu_AS.mathHelperCos, bipedBody.rotateAngleX);
		float sinBody2X = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float cosBody2X = 1F - Modchu_AS.getFloat(Modchu_AS.mathHelperCos, bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float sinBody2Y = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, bipedBody.rotateAngleY + hipBody.rotateAngleY);
		float cosBody2Y = 1F - Modchu_AS.getFloat(Modchu_AS.mathHelperCos, bipedBody.rotateAngleY + hipBody.rotateAngleY);		bipedHead.rotationPointZ -= -headPosY * sinBody1X;
		bipedHead.rotationPointY += -headPosY * cosBody1X;
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		//INIT POSITION
		bipedHead.setRotationPoint(0F, headPosY, 0F);
		HeadMount.setRotationPoint(0F, 0F, 0F);
		eyeR.setRotationPoint(0F, 0F, 0F);
		eyeL.setRotationPoint(0F, 0F, 0F);
		Ponytail.setRotationPoint(0F, -5.2F, 5F);
		BunchR.setRotationPoint(-4.5F, -5.5F, 1.7F);
		BunchL.setRotationPoint(4.5F, -5.5F, 1.7F);		rightArm.setRotationPoint(-4F, bodyPosY - 7.5F, 0F);
		rightArm2.setRotationPoint(0F, 5F, 0.5F);
		Arms[0].setRotationPoint(-0.5F, 7F, 0F);
		leftArm.setRotationPoint(4F, bodyPosY - 7.5F, 0F);
		leftArm2.setRotationPoint(0F, 5F, 0.5F);
		Arms[1].setRotationPoint(0.5F, 7F, 0F);		rightLeg.setRotationPoint(-2F, legPosY, 0F);
		rightLeg2.setRotationPoint(0F, 6F, 0F);
		leftLeg.setRotationPoint(2F, legPosY, 0F);
		leftLeg2.setRotationPoint(0F, 6F, 0F);		Skirt.setRotationPoint(0F, legPosY - 3F, 0F);
		hemSkirtR1.setRotationPoint(0F, 0F, 2F);
		hemSkirtL1.setRotationPoint(0F, 0F, 2F);
		hemSkirtR2.setRotationPoint(0F, 0F, 1F);
		hemSkirtL2.setRotationPoint(0F, 0F, 1F);		bipedBody.setRotationPoint(0F, bodyPosY, 0F);
		breastR.setRotationPoint(-0.5F, -7.2F, -2.1F);
		breastL.setRotationPoint(0.5F, -7.2F, -2.1F);
		hipBody.setRotationPoint(0F, 0F, 0F);		mainFrame.setRotationPoint(0F, offsetY, 0F);		//INIT ROTATION
		bipedHead.rotateAngleX = 0F;
		bipedHead.rotateAngleY = 0F;
		//bipedHead.rotateAngleZ = 0F;
		Ponytail.rotateAngleX = 0.05F;
		Ponytail.rotateAngleY = 0F;
		Ponytail.rotateAngleZ = 0F;
		BunchR.rotateAngleX = 0F;
		BunchR.rotateAngleY = 0F;
		BunchR.rotateAngleZ = 0.05F;
		BunchL.rotateAngleX = 0F;
		BunchL.rotateAngleY = 0F;
		BunchL.rotateAngleZ = -0.05F;		rightArm.rotateAngleX = 0F;
		rightArm.rotateAngleY = 0F;
		rightArm.rotateAngleZ = 0F;
		rightArm2.rotateAngleX = 0F;
		rightArm2.rotateAngleY = 0F;
		rightArm2.rotateAngleZ = 0F;
		Arms[0].rotateAngleX = 0F;
		Arms[0].rotateAngleY = 0F;
		Arms[0].rotateAngleZ = 0F;
		leftArm.rotateAngleX = 0F;
		leftArm.rotateAngleY = 0F;
		leftArm.rotateAngleZ = 0F;
		leftArm2.rotateAngleX = 0F;
		leftArm2.rotateAngleY = 0F;
		leftArm2.rotateAngleZ = 0F;
		Arms[1].rotateAngleX = 0F;
		Arms[1].rotateAngleY = 0F;
		Arms[1].rotateAngleZ = 0F;		rightLeg.rotateAngleX = -0.05F;
		rightLeg.rotateAngleY = 0.05F;
		rightLeg.rotateAngleZ = -0.05F;
		rightLeg2.rotateAngleX = 0.5F;
		rightLeg2.rotateAngleY = -0.1F;
		rightLeg2.rotateAngleZ = 0.02F;
		leftLeg.rotateAngleX = -0.05F;
		leftLeg.rotateAngleY = -0.05F;
		leftLeg.rotateAngleZ = 0.05F;
		leftLeg2.rotateAngleX = 0.5F;
		leftLeg2.rotateAngleY = 0.1F;
		leftLeg2.rotateAngleZ = -0.02F;		Skirt.rotateAngleX = 0F;
		Skirt.rotateAngleY = 0F;
		Skirt.rotateAngleZ = 0F;
		hemSkirtR1.rotateAngleX = 0F;
		hemSkirtR1.rotateAngleY = 0F;
		hemSkirtR1.rotateAngleZ = 0.05F;
		hemSkirtL1.rotateAngleX = 0F;
		hemSkirtL1.rotateAngleY = 0F;
		hemSkirtL1.rotateAngleZ = -0.05F;
		hemSkirtR2.rotateAngleX = 0F;
		hemSkirtR2.rotateAngleY = 0F;
		hemSkirtR2.rotateAngleZ = -0.03F;
		hemSkirtL2.rotateAngleX = 0F;
		hemSkirtL2.rotateAngleY = 0F;
		hemSkirtL2.rotateAngleZ = 0.03F;		bipedBody.rotateAngleX = -0.1F;
		bipedBody.rotateAngleY = 0F;
		breastR.rotateAngleX = 0.785F;
		breastR.rotateAngleY = 0F;
		breastR.rotateAngleZ = -0.15F;
		breastL.rotateAngleX = 0.785F;
		breastL.rotateAngleY = 0F;
		breastL.rotateAngleZ = 0.15F;
		hipBody.rotateAngleX = 0.2F;
		hipBody.rotateAngleY = 0F;
		hipBody.rotateAngleZ = 0F;		mainFrame.rotateAngleX = 0F;
		mainFrame.rotateAngleY = 0F;
		mainFrame.rotateAngleZ = 0F;
	}	@Override
	public void setMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
		bipedHead.rotationPointY = -7.0F;
		bipedBody.rotationPointY = -4.5F;
		rightArm.setRotationPoint(-4.0F, -6.0F, 0.0F);
		leftArm.setRotationPoint(4.0F, -6.0F, 0.0F);
		rightArm2.setRotationPoint(0.0F, 5.0F, 0.5F);
		leftArm2.setRotationPoint(0.0F, 5.0F, 0.5F);
		rightLeg.setRotationPoint(-2.0F, 1.0F, 0.0F);
		rightLeg2.setRotationPoint(0.0F, 6.5F, 0.0F);
		leftLeg.setRotationPoint(2.0F, 1.0F, 0.0F);
		leftLeg2.setRotationPoint(0.0F, 5.0F, 0.0F);
		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame.setRotateAngle(0.0F, 0.0F, 0.0F);		rightArm.rotateAngleZ = 1.57F;
		leftArm.rotateAngleZ = -1.57F;
		bipedHead.rotateAngleX = bipedHead.rotateAngleY = bipedHead.rotateAngleZ = bipedBody.rotateAngleX = bipedBody.rotateAngleY = bipedBody.rotateAngleZ = 0.0F;
	}	@Override
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
				rightArm.rotateAngleX -= f7 * 1.2D + f8;
				rightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				rightArm.rotateAngleZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[0] * 3.141593F) * -0.4F;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				leftArm.rotateAngleX -= f7 * 1.2D + f8;
				leftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				leftArm.rotateAngleZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * 3.141593F) * 0.4F;
			}
		}
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		boolean b = true;
		setCapsValue(entityCaps, caps_visible, rightArm, b);
		setCapsValue(entityCaps, caps_visible, rightArm2, b);
		setCapsValue(entityCaps, caps_visible, rightHand, b);
		setCapsValue(entityCaps, caps_visible, leftArm, b);
		setCapsValue(entityCaps, caps_visible, leftArm2, b);
		setCapsValue(entityCaps, caps_visible, leftHand, b);
		setCapsValue(entityCaps, caps_visible, rightLeg, b);
		setCapsValue(entityCaps, caps_visible, rightLeg2, b);
		setCapsValue(entityCaps, caps_visible, leftLeg, b);
		setCapsValue(entityCaps, caps_visible, leftLeg2, b);
		entityCaps.setCapsValue(caps_freeVariable, "sneakBan", true);
		entityCaps.setCapsValue(caps_freeVariable, "waitBan", true);
		entityCaps.setCapsValue(caps_freeVariable, "sittingBan", true);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		boolean b = true;
		setCapsValue(entityCaps, caps_visible, rightArm, b);
		setCapsValue(entityCaps, caps_visible, rightArm2, b);
		setCapsValue(entityCaps, caps_visible, leftArm, b);
		setCapsValue(entityCaps, caps_visible, leftArm2, b);
		b = false;
		setCapsValue(entityCaps, caps_visible, rightHand, b);
		setCapsValue(entityCaps, caps_visible, leftHand, b);		bipedHead.rotateAngleX = 0.0F;
		bipedHead.rotateAngleY = 0.0F;
		bipedHead.rotateAngleZ = 0.0F;
		bipedBody.rotateAngleX = 0.0F;
		bipedBody.rotateAngleY = 0.0F;
		bipedBody.rotateAngleZ = 0.0F;
		rightHand.rotateAngleX = 0.0F;
		rightHand.rotateAngleY = 0.0F;
		rightHand.rotateAngleZ = 0.0F;
		leftHand.rotateAngleX = 0.0F;
		leftHand.rotateAngleY = 0.0F;
		leftHand.rotateAngleZ = 0.0F;		entityCaps.setCapsValue(caps_freeVariable, "sneakBan", false);
		entityCaps.setCapsValue(caps_freeVariable, "waitBan", false);
		entityCaps.setCapsValue(caps_freeVariable, "sittingBan", false);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedRightArm.rotationPointX = rightArm.rotationPointX;
		bipedRightArm.rotationPointY = rightArm.rotationPointY;
		bipedRightArm.rotationPointZ = rightArm.rotationPointZ;
		bipedLeftArm.rotationPointX = leftArm.rotationPointX;
		bipedLeftArm.rotationPointY = leftArm.rotationPointY;
		bipedLeftArm.rotationPointZ = leftArm.rotationPointZ;		bipedRightLeg.rotationPointX = rightLeg.rotationPointX;
		bipedRightLeg.rotationPointY = rightLeg.rotationPointY;
		bipedRightLeg.rotationPointZ = rightLeg.rotationPointZ;
		bipedLeftLeg.rotationPointY = leftLeg.rotationPointY;
		bipedLeftLeg.rotationPointZ = leftLeg.rotationPointZ;
		bipedRightLeg.rotationPointY = rightLeg2.rotationPointY;
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);		hip.rotateAngleZ = 0.0F;		rightHand.rotationPointX = leftHand.rotationPointX = 0.0F;
		rightHand.rotationPointZ = -0.5F;
		leftHand.rotationPointZ = -0.5F;
		rightLeg.rotationPointY -= 1.0F;
	}	@Override
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedHeadShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, Ponytail, b);		setCapsValue(entityCaps, caps_visible, BunchR, b);		setCapsValue(entityCaps, caps_visible, BunchL, b);	}	@Override
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, breastR, b);		setCapsValue(entityCaps, caps_visible, breastL, b);		setCapsValue(entityCaps, caps_visible, hipBody, b);	}	@Override
	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedRightLegShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtR1, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtR2, b);
	}	@Override
	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedLeftLegShowModel(entityCaps, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtL1, b);
		setCapsValue(entityCaps, caps_visible, hemSkirtL2, b);
	}	@Override
	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		setCapsValue(entityCaps, caps_visible, Skirt, b);
		Skirt.isHidden = !b;
		//Modchu_Debug.mDebug("setArmorSkirtShowModel b="+b);
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"hemSkirtR1", "hemSkirtL1", "hemSkirtR2", "hemSkirtL2"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
	}
}