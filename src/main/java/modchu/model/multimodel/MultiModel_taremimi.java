package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_taremimi extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer ChignonR;
	public Modchu_ModelRenderer ChignonL;
	public Modchu_ModelRenderer ChignonB;
	public Modchu_ModelRenderer WTail;
	public Modchu_ModelRenderer SideTailR;
	public Modchu_ModelRenderer SideTailL;
	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer DogEL;
	public Modchu_ModelRenderer DogER;
	public Modchu_ModelRenderer Wansippo1;
	public Modchu_ModelRenderer Wansippo2;
	public Modchu_ModelRenderer Wansippo3;
	public Modchu_ModelRenderer Wansippo4;	public MultiModel_taremimi() {
		this(0.0F);
	}	public MultiModel_taremimi(float f) {
		this(f, 0.0F);
	}	public MultiModel_taremimi(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_taremimi(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		WTail = new Modchu_ModelRenderer(this, 46, 19);
		WTail.addBox(-2F, -7.1F, 3F, 4, 11, 2, f);
		WTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		DogEL = new Modchu_ModelRenderer(this, 0, 0);
		DogEL.setMirror(true);
		DogEL.addBox(0.0F, -7F, 5F, 3, 6, 1, f + 0.1F);
		DogEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		DogER = new Modchu_ModelRenderer(this, 0, 0);
		DogER.addBox(-3F, -7F, 5F, 3, 6, 1, f + 0.1F);
		DogER.setRotationPoint(0.0F, 0.0F, 0.0F);
		Wansippo1 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 3, f + 0.2F);
		Wansippo1.setRotationPoint(0.0F, 2.5F, 2.0F);
		Wansippo2 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo2.addBox(-0.5F, -1F, 2.0F, 1, 2, 3, f + 0.3F);
		Wansippo2.setRotationPoint(0.0F, 2.5F, 2.0F);
		Wansippo3 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo3.addBox(-0.5F, -4F, 4F, 1, 4, 3, f + 0.3F);
		Wansippo3.setRotationPoint(0.0F, 2.5F, 2.0F);
		Wansippo4 = new Modchu_ModelRenderer(this, 1, 17);
		Wansippo4.addBox(-0.5F, -4.5F, 3F, 1, 1, 2, f + 0.3F);
		Wansippo4.setRotationPoint(0.0F, 2.5F, 2.0F);
		DogER.rotateAngleY = -1.5708F;
		DogEL.rotateAngleY = 1.5708F;
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(WTail);
		bipedHead.addChild(Prim);
		bipedHead.addChild(DogEL);
		bipedHead.addChild(DogER);
		bipedBody.addChild(Wansippo1);
		bipedBody.addChild(Wansippo2);
		bipedBody.addChild(Wansippo3);
		bipedBody.addChild(Wansippo4);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Wansippo1.setRotationPointZ(Wansippo2.setRotationPointZ(Wansippo3.setRotationPointZ(Wansippo4.setRotationPointZ(2F))));
		Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.275F))));
		Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.2F) * 0.05F))));
		Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.2F) * 0.5F))));
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.1F))));
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.5F) * 1.0F))));
			Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.5F) * 1.0F))));
		}
		DogER.rotateAngleX = DogEL.rotateAngleX = mh_sin(f2 * 0.05F) * 0.06F + 0.2F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}