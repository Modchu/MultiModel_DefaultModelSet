package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_usagi extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer WTail;
	public Modchu_ModelRenderer CatEL;
	public Modchu_ModelRenderer CatER;
	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer Usasippo;
	public Modchu_ModelRenderer UsaEL;
	public Modchu_ModelRenderer UsaER;
	private boolean isTaremimi = false;
	private boolean isTareRightmimi;	public MultiModel_usagi() {
		this(0.0F);
	}	public MultiModel_usagi(float f) {
		this(f, 0.0F);
	}	public MultiModel_usagi(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_usagi(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		ChignonR = new Modchu_ModelRenderer(this, 24, 18);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonL = new Modchu_ModelRenderer(this, 24, 18);
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		WTail = new Modchu_ModelRenderer(this, 46, 19);
		WTail.addBox(-2F, -7.1F, 3F, 4, 11, 2, f);
		WTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new Modchu_ModelRenderer(this, 58, 21);
		SideTailR.addBox(-4.2F, -5.8F, -3F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new Modchu_ModelRenderer(this, 58, 21);
		SideTailL.mirror = true;
		SideTailL.addBox(3.2F, -5.8F, -3F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		CatEL = new Modchu_ModelRenderer(this, 0, 1);
		CatEL.mirror = true;
		CatEL.addBox(0.5F, -11F, 1.0F, 3, 5, 1, f);
		CatEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		CatER = new Modchu_ModelRenderer(this, 0, 1);
		CatER.addBox(-3.5F, -11F, 1.0F, 3, 5, 1, f);
		CatER.setRotationPoint(0.0F, 0.0F, 0.0F);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		Usasippo = new Modchu_ModelRenderer(this, 20, 8);
		Usasippo.addBox(-1.5F, -0.1F, 0.0F, 3, 3, 3, f);
		Usasippo.setRotationPoint(0.0F, 1.5F, 0.0F);
		UsaER = new Modchu_ModelRenderer(this, 0, 0);
		UsaER.addBox(-3.4F, -15.5F, 4.5F, 3, 6, 1, f);
		UsaER.setRotationPoint(0.0F, 0.0F, 0.0F);
		UsaEL = new Modchu_ModelRenderer(this, 0, 0);
		UsaEL.mirror = true;
		UsaEL.addBox(0.5F, -15.5F, 4.5F, 3, 6, 1, f);
		UsaEL.setRotationPoint(0.0F, 0.0F, 0.0F);		Usasippo.setRotationPointZ(2.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(Tail);
		bipedHead.addChild(ChignonR);
		bipedHead.addChild(ChignonL);
		bipedHead.addChild(ChignonB);
		bipedHead.addChild(WTail);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(SideTailL);
		bipedHead.addChild(CatEL);
		bipedHead.addChild(CatER);
		bipedHead.addChild(Prim);
		bipedBody.addChild(Usasippo);
		bipedHead.addChild(UsaER);
		bipedHead.addChild(UsaEL);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		UsaER.rotateAngleX = UsaEL.rotateAngleX = 0.6981317F;
		UsaEL.rotationPointX = 0.0F;
		UsaER.rotationPointX = -0.1F;
		UsaEL.rotationPointY = UsaER.rotationPointY = 0.0F;
		UsaEL.rotationPointZ = UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F - 0.2F;
		CatEL.rotationPointZ = CatER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F;
		Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.3F);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			UsaER.rotateAngleX = UsaEL.rotateAngleX = 2.094F;
			UsaEL.rotationPointX = -2F;
			UsaER.rotationPointX = 2.0F;
			UsaEL.rotationPointY = UsaER.rotationPointY = -11.2F;
			UsaEL.rotationPointZ = UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F + 8F;
			Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.5F);
		}
		if (armSwingFlag(entityCaps)) Usasippo.rotateAngleY = mh_sin(f * 0.2F) * 0.5F;		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) Usasippo.setRotateAngleY(0.0F);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Usasippo.setRotateAngleY(mh_cos(f2 * 0.2F) * 0.5F);
			UsaER.rotateAngleX = UsaEL.rotateAngleX = 2.268928F;
			UsaEL.rotationPointX = -2F;
			UsaER.rotationPointX = 2.0F;
			UsaEL.rotationPointY = UsaER.rotationPointY = -13.3F;
			UsaEL.rotationPointZ = UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F + 7.8F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Usasippo.setRotateAngleY(0.0F);
		}		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_modchuRemodelingModel)) {
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
				UsaER.rotateAngleX = UsaEL.rotateAngleX = 2.268928F;
				UsaEL.rotationPointX = -2F;
				UsaER.rotationPointX = 2.0F;
				UsaEL.rotationPointY = UsaER.rotationPointY = -13.3F;
				UsaEL.rotationPointZ = UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F + 7.8F;
			}
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
				if (!isTaremimi && 0.0D > (mh_sin(f2 * 0.1F) * 0.2F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
					isTaremimi = true;
				}
				if (!isTareRightmimi && 0.0D > (mh_sin(f2 * 0.1F) * 0.2F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
					isTareRightmimi = true;
				}
				if (isTaremimi) {
					UsaER.rotateAngleX = 2.268928F;
					if (!isTareRightmimi) {
						UsaEL.rotateAngleX = 2.268928F;
						UsaEL.rotationPointX = -2F;
						UsaEL.rotationPointY = -13.3F;
						UsaEL.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F + 7.8F;
					} else {
						UsaEL.rotateAngleX = 0.6981317F;
						UsaEL.rotationPointX = 0.0F;
						UsaEL.rotationPointY = 0.0F;
						UsaEL.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F - 0.2F;
					}
					UsaER.rotationPointX = 2.0F;
					UsaER.rotationPointY = -13.3F;
					UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F + 7.8F;
				} else {
					UsaER.rotateAngleX = UsaEL.rotateAngleX = 0.6981317F;
					UsaEL.rotationPointX = 0.0F;
					UsaER.rotationPointX = -0.1F;
					UsaEL.rotationPointY = UsaER.rotationPointY = 0.0F;
					UsaEL.rotationPointZ = UsaER.rotationPointZ = mh_cos(f2 * 0.05F) * 0.5F - 0.2F;
				}
				if (isTaremimi && 0.0D > (mh_sin(f2 * 0.1F) * 0.2F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
					isTaremimi = false;
				}
				if (isTareRightmimi && 0.0D > (mh_sin(f2 * 0.1F) * 0.2F) + Math.random() * 0.10000000149011612D + 0.08000000715255737D) {
					isTareRightmimi = false;
				}
			}
		}
		CatER.rotateAngleX = CatEL.rotateAngleX = 0.3839724F;
		CatER.rotateAngleY = 0.2617994F;
		CatEL.rotateAngleY = -0.2617994F;
		UsaER.rotateAngleY = 0.2617994F;
		UsaEL.rotateAngleY = -0.2617994F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}