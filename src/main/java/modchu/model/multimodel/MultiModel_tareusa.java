package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_tareusa extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer ChignonR;
	public Modchu_ModelRenderer ChignonL;
	public Modchu_ModelRenderer ChignonB;
	public Modchu_ModelRenderer SideTailR;
	public Modchu_ModelRenderer SideTailL;
	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer UsaEL;
	public Modchu_ModelRenderer UsaER;
	public Modchu_ModelRenderer UsaEL1;
	public Modchu_ModelRenderer UsaER1;
	public Modchu_ModelRenderer Usasippo;	public MultiModel_tareusa() {
		this(0.0F);
	}	public MultiModel_tareusa(float f) {
		this(f, 0.0F);
	}	public MultiModel_tareusa(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_tareusa(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		UsaEL = new Modchu_ModelRenderer(this, 0, 0);
		UsaEL.setMirror(true);
		UsaEL.addBox(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
		UsaEL.setRotationPoint(0F, 0F, 0F);
		UsaER = new Modchu_ModelRenderer(this, 0, 0);
		UsaER.addBox(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
		UsaER.setRotationPoint(0.0F, 0.0F, 0.0F);
		UsaEL1 = new Modchu_ModelRenderer(this, 0, 0);
		UsaEL1.setMirror(true);
		UsaEL1.addBox(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
		UsaEL1.setRotationPoint(0F, 0F, 0F);
		UsaER1 = new Modchu_ModelRenderer(this, 0, 0);
		UsaER1.addBox(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
		UsaER1.setRotationPoint(0.0F, 0.0F, 0.0F);		Usasippo = new Modchu_ModelRenderer(this, 24, 0);
		Usasippo.addBox(-1.5F, -0.1F, 0.0F, 3, 3, 3, f);
		Usasippo.setRotationPoint(0.0F, 1.5F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 32, 19);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
		eyeR = new Modchu_ModelRenderer(this, 42, 19);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);		Usasippo.setRotationPointZ(2.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.addChild(Prim);
		bipedHead.addChild(UsaEL);
		bipedHead.addChild(UsaER);
		bipedHead.addChild(UsaEL1);
		bipedHead.addChild(UsaER1);
		bipedBody.addChild(Usasippo);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(eyeR);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.3F);
		UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.2F) * 0.1F + 0.2F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.5F);
		}
		if (armSwingFlag(entityCaps)) {
			Usasippo.rotateAngleY = mh_sin(f2 * 0.2F) * 0.2F;
			Usasippo.setRotateAngleX(0.0F);
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			Usasippo.setRotateAngleY(0.0F);
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Usasippo.setRotateAngleY(0.0F);
			Usasippo.setRotateAngleX(mh_sin(f2 * 0.3F) * 0.1F);
			UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.1F) * 0.06F + 0.2F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Usasippo.setRotateAngleY(0.0F);
		}		UsaEL.rotationPointX = UsaEL1.rotationPointX = 2.5F;
		UsaER.rotationPointX = UsaER1.rotationPointX = -2.5F;
		UsaEL.rotationPointY = UsaER.rotationPointY = UsaEL1.rotationPointY = UsaER1.rotationPointY = -8F;
		UsaEL.rotationPointZ = UsaER.rotationPointZ = UsaEL1.rotationPointZ = UsaER1.rotationPointZ = -0.5F;		UsaEL1.rotateAngleX = UsaEL.rotateAngleX + 1.5708F;
		UsaER1.rotateAngleX = UsaER.rotateAngleX + 1.5708F;		UsaER.rotateAngleY = UsaER1.rotateAngleY = mh_sin(f2 * 0.1F) * 0.06F - 1.920F;
		UsaEL.rotateAngleY = UsaEL1.rotateAngleY = mh_sin(f2 * 0.1F) * -0.06F + 1.920F;	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"bipedHeadwear", "d"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
	}	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
		setCapsValue(entityCaps, caps_visible, bipedHeadwear, false);
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}