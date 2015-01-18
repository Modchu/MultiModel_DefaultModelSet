package modchu.model.multimodel;import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModel;public class MultiModel_QB extends MultiModel {	public Modchu_ModelRenderer rightLeg;
	public Modchu_ModelRenderer leftLeg;
	public Modchu_ModelRenderer rightear;
	public Modchu_ModelRenderer leftear;
	public Modchu_ModelRenderer rightLegbottom;
	public Modchu_ModelRenderer leftLegbottom;
	public Modchu_ModelRenderer rightearhair;
	public Modchu_ModelRenderer leftearhair;
	public Modchu_ModelRenderer tail1;
	public Modchu_ModelRenderer tail2;
	public Modchu_ModelRenderer tail3;
	public Modchu_ModelRenderer ringR;
	public Modchu_ModelRenderer ringL;
	private boolean sleepingInit;	public MultiModel_QB() {
		this(0.0F);
	}	public MultiModel_QB(float f) {
		this(f, 0.0F);
	}	public MultiModel_QB(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_QB(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-3.0F, -2.5F, -2.0F, 6, 5, 4, f);
		bipedHead.setRotationPoint(-2.5F, 0.0F, 0.0F);
		bipedBody = new Modchu_ModelRenderer(this, 0, 9);
		bipedBody.addBox(-2.5F, -1.0F, -3.0F, 5, 2, 6, f);
		bipedBody.setRotationPoint(0.5F, 0.0F, 1.0F);
		bipedRightArm = new Modchu_ModelRenderer(this, 0, 17);
		bipedRightArm.addBox(-1.001F, 0.0F, -1.001F, 2, 4, 2, f);
		bipedRightArm.setRotationPoint(0.0F, 0.0F, 2.0F);
		bipedLeftArm = new Modchu_ModelRenderer(this, 0, 17);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-0.999F, 0.0F, -1.001F, 2, 4, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 0.0F, 2.0F);
		rightLeg = new Modchu_ModelRenderer(this, 8, 17);
		rightLeg.addBox(-1.001F, -1.5F, -1.501F, 2, 3, 3, f);
		rightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftLeg = new Modchu_ModelRenderer(this, 8, 17);
		leftLeg.mirror = true;
		leftLeg.addBox(-0.999F, -1.5F, -1.501F, 2, 3, 3, f);
		leftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightLegbottom = new Modchu_ModelRenderer(this, 0, 23);
		rightLegbottom.addBox(-1.001F, -0.5F, -2.001F, 2, 1, 4, f);
		rightLegbottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftLegbottom = new Modchu_ModelRenderer(this, 0, 23);
		leftLegbottom.mirror = true;
		leftLegbottom.addBox(-0.999F, -0.5F, -2.001F, 2, 1, 4, f);
		leftLegbottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightearhair = new Modchu_ModelRenderer(this, 12, 23);
		rightearhair.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, f);
		rightearhair.setRotationPoint(-1.0F, 1.0F, 1.0F);
		leftearhair = new Modchu_ModelRenderer(this, 12, 23);
		leftearhair.mirror = true;
		leftearhair.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, f);
		leftearhair.setRotationPoint(4.0F, 1.0F, 1.0F);
		rightear = new Modchu_ModelRenderer(this, 16, 0);
		rightear.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightear.setRotationPoint(-1.0F, -1.0F, 1.0F);
		leftear = new Modchu_ModelRenderer(this, 16, 0);
		leftear.mirror = true;
		leftear.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftear.setRotationPoint(3.0F, -1.0F, 1.0F);
		tail1 = new Modchu_ModelRenderer(this, 24, 0);
		tail1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);
		tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail2 = new Modchu_ModelRenderer(this, 20, 5);
		tail2.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 5, f);
		tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail3 = new Modchu_ModelRenderer(this, 22, 13);
		tail3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
		ringR = new Modchu_ModelRenderer(this, 8, 23);
		ringR.addPlate(-1.5F, -1.5F, 0.0F, 3, 3, 0);
		ringR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ringL = new Modchu_ModelRenderer(this, 8, 23);
		ringL.addPlate(-1.5F, -1.5F, 0.0F, 3, 3, 0);
		ringL.setRotationPoint(0.0F, 0.0F, 0.0F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		Skirt = new Modchu_ModelRenderer(this);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedBody.addChild(rightLeg);
		bipedBody.addChild(leftLeg);
		rightLeg.addChild(rightLegbottom);
		leftLeg.addChild(leftLegbottom);
		bipedHead.addChild(rightearhair);
		bipedHead.addChild(leftearhair);
		bipedHead.addChild(rightear);
		bipedHead.addChild(leftear);
		bipedBody.addChild(tail1);
		tail1.addChild(tail2);
		tail2.addChild(tail3);
		bipedHead.addChild(ringR);
		bipedHead.addChild(ringL);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		float ff1 = mh_sin(f2 * 0.09F) * 0.05F;
		Arms[0].setRotationPoint(0.5F, 3.0F, 0F);
		Arms[1].setRotationPoint(-0.5F, 3.0F, 0F);
		HeadMount.setRotationPoint(0F, 3.5F, 0F);
		HeadTop.setRotationPoint(0.0F, -2.5F, 0.0F);
		if (sleepingInit) {
			sleepingInit = false;
			bipedBody.rotateAngleX = 0.0F;
			bipedBody.rotateAngleY = 0.0F;
			bipedBody.rotateAngleZ = 0.0F;
		}
		bipedHead.rotateAngleY = f3 / 57.29578F;
		bipedHead.rotateAngleX = f4 / 57.29578F;
		bipedHead.rotateAngleZ = 0.0F;
		bipedBody.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 1.4F * f1 * 0.1F;
		bipedBody.rotationPointX = 0.0F;
		bipedBody.rotationPointZ = 0.0F;
		bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = 0.0F;
		bipedRightArm.rotationPointZ = bipedLeftArm.rotationPointZ = -2.0F;
		rightLeg.rotationPointY = leftLeg.rotationPointY = 1.5F;
		rightLeg.rotationPointZ = leftLeg.rotationPointZ = 2.5F;
		rightLegbottom.rotationPointY = leftLegbottom.rotationPointY = 2.0F;
		rightLegbottom.rotationPointZ = leftLegbottom.rotationPointZ = -1.0F;
		rightLeg.rotationPointX = -2.0F;
		leftLeg.rotationPointX = 2.0F;
		tail1.rotationPointX = 0.0F;
		tail2.rotationPointX = 0.0F;
		tail3.rotationPointX = 0.0F;
		tail1.rotationPointY = 0.5F;
		tail2.rotationPointY = 0.5F;
		tail3.rotationPointY = 0.0F;
		tail1.rotationPointZ = 4.0F;
		tail2.rotationPointZ = 4.5F;
		tail3.rotationPointZ = 3.5F;
		tail2.rotateAngleX = tail3.rotateAngleX = 0.0F;
		tail1.rotateAngleY = tail2.rotateAngleY = tail3.rotateAngleY = 0.0F;
		tail1.rotateAngleZ = tail2.rotateAngleZ = tail3.rotateAngleZ = 0.0F;
		rightLeg.rotateAngleX = leftLeg.rotateAngleX = bipedBody.rotateAngleX * 2.5F;
		rightLeg.rotateAngleY = leftLeg.rotateAngleY = 0.0F;
		rightLeg.rotateAngleZ = leftLeg.rotateAngleZ = 0.0F;
		bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = 0.0F;
		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
		bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
		tail1.rotateAngleX = -0.2F;
		bipedHead.rotationPointY = -3.0F;
		bipedHead.rotationPointX = 0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			// 乗り物に乗っている
			float f15 = 1.5F;
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSitting)) f15 = 1.0F;
			float f9 = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.3F);
			if (f9 < 0) {
				f9 = -f9 * 2;
			}
			float f11 = f9 * 3.0F;
			bipedBody.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 3.3F * f1 + 4.8F;			bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = -Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 1.4F * f1;
			bipedBody.rotationPointY = f11 * f1 - f1 * 3F + 5F + f15;
			bipedBody.rotationPointZ = -f11 * f1 - f1 * 1.5F + 3F;
			rightLeg.rotationPointX = -3.0F;
			leftLeg.rotationPointX = 3.0F;
			rightLeg.rotationPointY = leftLeg.rotationPointY = 2.0F;
			rightLeg.rotationPointZ = leftLeg.rotationPointZ = 2.0F;
			if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
				tail1.rotationPointX = 0.0F;
				tail1.rotationPointY = -1.0F;
				tail1.rotationPointZ = 2.5F;
				tail2.rotationPointY = 0.0F;
				tail2.rotationPointX = 0.0F;
				tail2.rotationPointZ -= 0.5F;
				//bipedHead.rotationPointY = 0.0F + f15;
				bipedHead.rotationPointZ = 2.5F;
				tail1.rotateAngleX = bipedBody.rotateAngleX + 2.0F;
				tail1.rotateAngleY = 2.0F - ff1;
				tail1.rotateAngleZ = -ff1;
				tail2.rotateAngleX = -0.6F - ff1;
				tail2.rotateAngleY = -ff1 * 0.5F;
				tail2.rotateAngleZ = 0.5F - ff1;
				tail3.rotateAngleY = -ff1 * 0.5F;
			} else {
				//bipedHead.rotationPointY = 0.0F + f15;
			}
			bipedBody.rotateAngleX = bipedBody.rotateAngleX < 5.2F && f > 0 ? 5.2F : bipedBody.rotateAngleX;
			bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX > 0.0F ? 0.5F : bipedRightArm.rotateAngleX;
			//bipedHead.rotationPointY = -0.5F + f15;
			bipedHead.rotateAngleX -= bipedBody.rotateAngleX;
			bipedHead.rotationPointY = 0.0F;
			bipedHead.rotationPointZ = bipedBody.rotationPointZ - 8.0F;
		} else {
			bipedHead.rotationPointZ = bipedBody.rotationPointZ - 2.0F;
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			// しゃがみ
			float f12 = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding) ? -5F : 0F;
			//bipedHead.rotationPointY = 9.0F + f12;
			bipedBody.rotationPointY = 12.0F + f12;
			bipedBody.rotateAngleX = 0.1F;
			rightLeg.rotationPointY = 1.0F;
			leftLeg.rotationPointY = 1.0F;
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
				bipedBody.rotationPointY += 1.8F;
				//bipedHead.rotationPointY += 2.8F;
				rightLeg.rotationPointX += 1.0F;
				leftLeg.rotationPointX -= 1.0F;
			}
		}
		if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			//bipedHead.rotationPointY = 9F;
			bipedBody.rotationPointY = 12F;
			bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
		}
		armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		bipedRightArm.rotationPointX = -1.5F;
		bipedLeftArm.rotationPointX = 1.5F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = 0.5F;
			bipedRightArm.rotationPointZ = bipedLeftArm.rotationPointZ = -2.5F;
			bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
			bipedRightArm.rotateAngleZ = -0.4F;
			bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
			bipedLeftArm.rotateAngleZ = 0.4F;
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
				bipedRightArm.rotateAngleX += 1.5F;
				bipedLeftArm.rotateAngleX += 1.5F;
			}
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			// 弓構え
			float f13 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[dominantArm] * 3.141593F);
			float f14 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, (1.0F - (1.0F - onGrounds[dominantArm]) * (1.0F - onGrounds[dominantArm])) * 3.141593F);
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = -(0.1F - f13 * 0.6F) + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleY = (0.1F - f13 * 0.6F) + bipedHead.rotateAngleY + 0.4F;
			bipedRightArm.rotateAngleX = -1.470796F;
			bipedLeftArm.rotateAngleX = -1.470796F;
			bipedRightArm.rotateAngleX -= f13 * 1.2F - f14 * 0.4F;
			bipedLeftArm.rotateAngleX -= f13 * 1.2F - f14 * 0.4F;
			bipedRightArm.rotateAngleZ += Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX += Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedLeftArm.rotateAngleX += bipedHead.rotateAngleX;
			bipedRightArm.rotationPointX = -2.0F;
			bipedLeftArm.rotationPointX = 2.0F;
			bipedRightArm.rotationPointZ += 1.5F;
			bipedLeftArm.rotationPointZ += 1.5F;
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
				bipedRightArm.rotationPointZ = bipedLeftArm.rotationPointZ -= 4.0F;
			}
		}		rightearhair.rotationPointX = -3.0F;
		leftearhair.rotationPointX = 3.0F;
		rightearhair.rotationPointY = leftearhair.rotationPointY = -3.0F;
		rightearhair.rotationPointZ = leftearhair.rotationPointZ = 1.0F;		rightear.rotationPointX = -3.0F;
		leftear.rotationPointX = 3.0F;
		rightear.rotationPointY = leftear.rotationPointY = -2.5F;
		rightear.rotationPointZ = leftear.rotationPointZ = 1.0F;		ringR.rotationPointZ = ringL.rotationPointZ = 1.2F;
		ringR.rotateAngleX = ringL.rotateAngleX = 1.570796313F;		rightearhair.rotateAngleZ = ff1 + 0.25F;
		leftearhair.rotateAngleZ = -rightearhair.rotateAngleZ;
		ringR.rotateAngleZ = ff1 + 0.25F;
		ringL.rotateAngleZ = -ringR.rotateAngleZ;
		ringR.rotationPointX = -ff1 - 4.0F;
		ringL.rotationPointX = ff1 * 2 + 4.0F;
		ringR.rotationPointY = -ff1 + 1.0F;
		ringL.rotationPointY = -ff1 + 1.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSleeping)) {
			sleepingInit = true;
			bipedHead.rotationPointX = 1F;
			//bipedHead.rotationPointY = 0F;
			bipedHead.rotationPointZ = -1F;
			bipedBody.rotationPointY = 9F;
			bipedBody.rotationPointZ = -3F;
			bipedRightArm.rotationPointY = 2.0F;
			bipedLeftArm.rotationPointY = bipedRightArm.rotationPointY;
			rightLeg.rotationPointY = 0.5F;
			leftLeg.rotationPointY = 0.5F;
			rightLegbottom.rotationPointY = 1.5F;
			leftLegbottom.rotationPointY = 1.5F;
			tail1.rotationPointX = 0.0F;
			tail1.rotationPointY = 0.0F;
			tail1.rotationPointZ = 3.5F;
			tail2.rotationPointY = 1.0F;
			tail2.rotationPointX = 2.0F;
			tail2.rotationPointZ = 3.0F;
			tail3.rotationPointY = 0.0F;
			tail3.rotationPointX = 1.0F;
			tail3.rotationPointZ = 3.0F;			//bipedHead.rotateAngleX = 1.770796313F + f4 / 57.29578F;
			bipedHead.rotateAngleX = 0.870796313F + f4 / 57.29578F;
			//bipedHead.rotateAngleX -= bipedBody.rotateAngleX;
			bipedHead.rotateAngleY = -1.77F;
			bipedHead.rotateAngleZ = -0.6F + f3 / 57.29578F;
			bipedBody.rotateAngleX = 1.570796313F;
			bipedBody.rotateAngleY = 0.0F;
			bipedBody.rotateAngleZ = 1.570796313F;			bipedRightArm.rotateAngleX = -1.57F;
			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX;
			tail1.rotateAngleX = bipedBody.rotateAngleX - 1.8F;
			tail1.rotateAngleY = 0.2F;			tail2.rotateAngleX = 0.0F;
			tail2.rotateAngleY = 1.5F;
			tail2.rotateAngleZ = 0.5F;
			tail3.rotateAngleX = 0.0F;
			tail3.rotateAngleY = 1.0F;
			tail3.rotateAngleZ = 0.0F;
		}
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (armSwingFlag(entityCaps)) {
			// 腕振り
			float f6, f7, f8;
			f6 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[0]) * (float) Math.PI * 2.0F);
			f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, onGrounds[1]) * (float) Math.PI * 2.0F);
			bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
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
			} else {
				bipedRightArm.rotateAngleX += bipedBody.rotateAngleY;
			}
			// L
			if (onGrounds[1] > 0F) {
				f6 = 1.0F - onGrounds[1];
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f6 * (float) Math.PI);
				f8 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= f7 * 1.2D + f8;
				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedLeftArm.rotateAngleZ = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, onGrounds[1] * 3.141593F) * 0.4F;
			} else {
				bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
			}
		}
	}	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
		Modchu_ModelRenderer arm = getDominantArm(entityCaps);
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entity != null
				&& entityCaps.getCapsValue(entityCaps.caps_currentEquippedItem) != null) {
			//地図を持っている時
			if (dominantArm == 0) {
				arm.rotationPointX = -8.0F;
				arm.rotationPointY = 5.5F;
				arm.rotationPointZ = 0.0F;
			} else {
				arm.rotationPointX = -7.5F;
				arm.rotationPointY = 5.5F;
				arm.rotationPointZ = 0.0F;
			}
		} else {
			//素手時
			if (dominantArm == 0) {
				arm.rotationPointY += 3.0F;
			} else {
				arm.rotationPointX -= 4.0F;
				arm.rotationPointY += 1.0F;
			}
		}
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s1 = {
				"rightLegbottom", "leftLegbottom", "rightearhair", "leftearhair"
		};
		String[] s2 = {
				"rightLeg_b", "leftLeg_b", "r_earhair", "l_earhair"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		entityCaps.setCapsValue(caps_freeVariable, "sneakBan", true);
		entityCaps.setCapsValue(caps_freeVariable, "waitBan", true);
		entityCaps.setCapsValue(caps_freeVariable, "sittingBan", true);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		entityCaps.setCapsValue(caps_freeVariable, "sneakBan", false);
		entityCaps.setCapsValue(caps_freeVariable, "waitBan", false);
		entityCaps.setCapsValue(caps_freeVariable, "sittingBan", false);		bipedBody.rotateAngleX = 0.0F;
		bipedBody.rotateAngleY = 0.0F;
		bipedBody.rotateAngleZ = 0.0F;
		bipedHead.rotateAngleX = 0.0F;
		bipedHead.rotateAngleY = 0.0F;
		bipedHead.rotateAngleZ = 0.0F;
		bipedHead.rotationPointX = 0.0F;
		bipedHead.rotationPointZ = 0.0F;
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		//Modchu_Debug.dDebug("action1 QB");
		float speed = Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_actionSpeed) / 1200;
		if (speed < 0.0F) return;
		//Modchu_Debug.dDebug("action1 QB speed="+speed);		int actionCount = Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionCount);
		float f6 = (float) (actionCount) / 10000F;
		float maxf = 0.544F;
		float minf = -0.388F;
		//Modchu_Debug.dDebug("action1 QB actionCount="+actionCount);		bipedRightArm.rotateAngleX = -f6 * 1.86567233F;
		bipedRightArm.rotateAngleY = 0.0F;
		bipedRightArm.rotateAngleZ = 0.0F;
		if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_freeVariable, "actionReverse")) {
			if (f6 < maxf + speed) f6 += speed;
		} else {
			if (f6 > minf - speed) f6 -= speed;
		}
		if (f6 > maxf) {
			f6 = maxf;
			entityCaps.setCapsValue(caps_freeVariable, "actionReverse", true);
		}
		if (f6 < minf) {
			f6 = minf;
			entityCaps.setCapsValue(caps_freeVariable, "actionReverse", false);
		}
		float y = 16.0F;
		if (f6 > 0.0F) {
			bipedHead.rotationPointY = bipedBody.rotationPointY - y + (f6 * 2.61778528F);
		} else {
			bipedBody.rotationPointY -= f6 * 4.10447914F;
			bipedHead.rotationPointY = bipedBody.rotationPointY - y - (f6 * 2.61778528F);
		}
		bipedHead.rotationPointX = f6 * 2.10447914F;
		bipedHead.rotateAngleX = -f6 * 0.2F;
		bipedHead.rotateAngleY = f6 * 0.2F;
		bipedHead.rotateAngleZ = f6;
		bipedLeftArm.rotateAngleX = -bipedRightArm.rotateAngleX;
		bipedLeftArm.rotateAngleY = bipedRightArm.rotateAngleY;
		bipedLeftArm.rotateAngleZ = bipedRightArm.rotateAngleZ;
		bipedBody.rotateAngleZ = f6;
		entityCaps.setCapsValue(caps_actionCount, (int) (f6 * 10000));
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 0.85F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.7F;
	}	@Override
	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {
		return 0.85F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.47F;
	}	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.4F;
	}	@Override
	public float Physical_Hammer(ModchuModel_IEntityCaps entityCaps) {
		return Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_Physical_Hammer) == 1.0F ? 1.2F : Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_Physical_Hammer);
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}