package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_chrno extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer RibonL;
	public Modchu_ModelRenderer RibonR;
	public Modchu_ModelRenderer CatEL;
	public Modchu_ModelRenderer CatER;
	public Modchu_ModelRenderer Icewing1;
	public Modchu_ModelRenderer Icewing2;
	public Modchu_ModelRenderer Icewing3;
	public Modchu_ModelRenderer Icewing4;
	public Modchu_ModelRenderer Icewing5;
	public Modchu_ModelRenderer Icewing6;
	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer Rightarm1;
	public Modchu_ModelRenderer Rightarm2;
	public Modchu_ModelRenderer Leftarm1;
	public Modchu_ModelRenderer Leftarm2;	public MultiModel_chrno() {
		this(0.0F);
	}	public MultiModel_chrno(float f) {
		this(f, 0.0F);
	}	public MultiModel_chrno(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_chrno(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		Skirt.setRotationPoint(0.0F, -4F + f1, 0.0F);		RibonL = new Modchu_ModelRenderer(this, 52, 10);
		RibonL.setMirror(true);
		RibonL.addBox(-5F, -10F, 3.5F, 4, 4, 2, f);
		RibonL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		RibonL.rotateAngleX = 6.108653F;
		RibonR = new Modchu_ModelRenderer(this, 52, 10);
		RibonR.setMirror(true);
		RibonR.addBox(1.0F, -10F, 3.5F, 4, 4, 2, f);
		RibonR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		RibonR.rotateAngleX = 6.108653F;
		CatEL = new Modchu_ModelRenderer(this, 0, 0);
		CatEL.addBox(1.0F, -4F, 7F, 3, 3, 1, f);
		CatEL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		CatEL.rotateAngleX = -5.934119F;
		CatER = new Modchu_ModelRenderer(this, 0, 4);
		CatER.addBox(-4F, -4F, 7F, 3, 3, 1, f);
		CatER.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		CatER.rotateAngleX = -5.934119F;
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		Icewing1 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing1.setMirror(true);
		Icewing1.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing1.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Icewing2 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing2.setMirror(true);
		Icewing2.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing2.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Icewing3 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing3.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing3.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Icewing4 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing4.setMirror(true);
		Icewing4.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing4.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Icewing5 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing5.setMirror(true);
		Icewing5.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing5.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Icewing6 = new Modchu_ModelRenderer(this, 0, 16);
		Icewing6.addBox(-1F, 5F, 4F, 2, 5, 1, f);
		Icewing6.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
		Rightarm1 = new Modchu_ModelRenderer(this, 48, 0);
		Rightarm1.addBox(-2F, 2.8F, -1F, 2, 5, 2);
		Rightarm1.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
		Rightarm2 = new Modchu_ModelRenderer(this, 48, 5);
		Rightarm2.addBox(-6.8F, -3.8F, -0.98F, 2, 3, 2);
		Rightarm2.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
		Leftarm1 = new Modchu_ModelRenderer(this, 56, 0);
		Leftarm1.addBox(0.0F, 2.8F, -1F, 2, 5, 2);
		Leftarm1.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
		Leftarm2 = new Modchu_ModelRenderer(this, 56, 5);
		Leftarm2.addBox(4.8F, -3.8F, -0.98F, 2, 3, 2);
		Leftarm2.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(RibonL);
		bipedHead.addChild(RibonR);
		bipedHead.addChild(CatEL);
		bipedHead.addChild(CatER);
		bipedHead.addChild(Prim);
		bipedBody.addChild(Icewing1);
		bipedBody.addChild(Icewing2);
		bipedBody.addChild(Icewing3);
		bipedBody.addChild(Icewing4);
		bipedBody.addChild(Icewing5);
		bipedBody.addChild(Icewing6);
		bipedBody.addChild(Rightarm1);
		bipedBody.addChild(Leftarm1);
		bipedBody.addChild(Rightarm2);
		bipedBody.addChild(Leftarm2);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		Icewing1.setRotateAngleZ(0.8726646F);
		Icewing2.setRotateAngleZ(1.570796F);
		Icewing3.setRotateAngleZ(2.094395F);
		Icewing4.setRotateAngleZ(5.235988F);
		Icewing5.setRotateAngleZ(4.712389F);
		Icewing6.setRotateAngleZ(4.18879F);
		Rightarm1.rotateAngleZ = 1.047F;
		Rightarm2.rotateAngleZ = -1.047F;
		Leftarm1.rotateAngleZ = -1.047F;
		Leftarm2.rotateAngleZ = 1.047F;
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		if (31.41593F >= mh_abs(f2)) {
			f2 %= 31.41593F;
		}
		Icewing1.setRotateAngleX(Icewing2.setRotateAngleX(Icewing3.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
		Icewing4.setRotateAngleX(Icewing5.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
		if (armSwingFlag(entityCaps)) {
			Icewing1.setRotateAngleY(Icewing2.setRotateAngleY(Icewing3.setRotateAngleY(bipedBody.getRotateAngleY())));
			Icewing4.setRotateAngleY(Icewing5.setRotateAngleY(Icewing6.setRotateAngleY(bipedBody.getRotateAngleY())));
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, Leftarm1, true);
			setCapsValue(entityCaps, caps_visible, Leftarm2, true);
			setCapsValue(entityCaps, caps_visible, Rightarm1, true);
			setCapsValue(entityCaps, caps_visible, Rightarm2, true);
			setCapsValue(entityCaps, caps_visible, bipedRightArm, false);
			setCapsValue(entityCaps, caps_visible, bipedLeftArm, false);
			Arms[0].setRotationPoint(0.0F, 0.0F, 0.0F);
			Arms[1].setRotationPoint(0.0F, 0.0F, 0.0F);
			Icewing3.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f2 * f2 * 0.6662F) * 0.2F));
			bipedRightArm.setRotateAngleX(0.0F);
			bipedRightArm.setRotateAngleY(0.0F);
			bipedRightArm.setRotateAngleZ(0.0F);
			Rightarm1.rotationPointY = Rightarm2.rotationPointY = Leftarm1.rotationPointY = Leftarm2.rotationPointY = mh_sin(f2 * 0.05F) * 0.2F - 4.0F;
		} else {
			setCapsValue(entityCaps, caps_visible, Leftarm1, false);
			setCapsValue(entityCaps, caps_visible, Leftarm2, false);
			setCapsValue(entityCaps, caps_visible, Rightarm1, false);
			setCapsValue(entityCaps, caps_visible, Rightarm2, false);
			setCapsValue(entityCaps, caps_visible, bipedRightArm, true);
			setCapsValue(entityCaps, caps_visible, bipedLeftArm, true);
			Arms[0].setRotationPoint(0.5F, 6.5F, 0.0F);
			Arms[1].setRotationPoint(-0.5F, 6.5F, 0.0F);
		}
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		super.actionInit1(entityCaps);
		bipedLeftArm.isHidden = true;
		bipedRightArm.isHidden = true;
		bipedLeftLeg.isHidden = true;
		bipedRightLeg.isHidden = true;
		Rightarm1.isHidden = true;
		Rightarm2.isHidden = true;
		Leftarm1.isHidden = true;
		Leftarm2.isHidden = true;
		setCapsValue(entityCaps, caps_visible, Leftarm1, true);
		setCapsValue(entityCaps, caps_visible, Leftarm2, true);
		setCapsValue(entityCaps, caps_visible, Rightarm1, true);
		setCapsValue(entityCaps, caps_visible, Rightarm2, true);
		setCapsValue(entityCaps, caps_visible, bipedRightArm, false);
		setCapsValue(entityCaps, caps_visible, bipedLeftArm, false);
		bipedRightArm.removeChild((Modchu_ModelRenderer) Arms[0]);
		bipedLeftArm.removeChild((Modchu_ModelRenderer) Arms[1]);
		Rightarm2.removeChild((Modchu_ModelRenderer) Arms[0]);
		Leftarm2.removeChild((Modchu_ModelRenderer) Arms[1]);
		if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 0.0F, 0F);
		if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 0.0F, 0F);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		super.actionRelease1(entityCaps);
		bipedLeftArm.isHidden = false;
		bipedRightArm.isHidden = false;
		bipedLeftLeg.isHidden = false;
		bipedRightLeg.isHidden = false;
		Rightarm1.isHidden = false;
		Rightarm2.isHidden = false;
		Leftarm1.isHidden = false;
		Leftarm2.isHidden = false;
		setCapsValue(entityCaps, caps_visible, Leftarm1, false);
		setCapsValue(entityCaps, caps_visible, Leftarm2, false);
		setCapsValue(entityCaps, caps_visible, Rightarm1, false);
		setCapsValue(entityCaps, caps_visible, Rightarm2, false);
		setCapsValue(entityCaps, caps_visible, bipedRightArm, true);
		setCapsValue(entityCaps, caps_visible, bipedLeftArm, true);
	}/*
	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps)
	{
		return 0.8F;
	}
*/
	@Override
	public Modchu_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag) && Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 1 | Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 6) {
			if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;
			return leftArm;
		} else {
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
				if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return Rightarm1;
				return Leftarm1;
			} else {
				if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return bipedRightArm;
				return bipedLeftArm;
			}
		}
	}	@Override
	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedRightArmShowModel(entityCaps, b);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, Rightarm1, b);
			setCapsValue(entityCaps, caps_visible, Rightarm2, b);
		} else {
			setCapsValue(entityCaps, caps_visible, Rightarm1, false);
			setCapsValue(entityCaps, caps_visible, Rightarm2, false);
		}
	}	@Override
	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedLeftArmShowModel(entityCaps, b);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, Leftarm1, b);
			setCapsValue(entityCaps, caps_visible, Leftarm2, b);
		} else {
			setCapsValue(entityCaps, caps_visible, Leftarm1, false);
			setCapsValue(entityCaps, caps_visible, Leftarm2, false);
		}
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}