package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_chu extends MultiModelOkotaSR2 {	public Modchu_ModelRenderer CatEL;
	public Modchu_ModelRenderer CatER;
	public Modchu_ModelRenderer CatTail;
	public Modchu_ModelRenderer Prim;	public MultiModel_chu()
	{
		this(0.0F);
	}	public MultiModel_chu(float f)
	{
		this(f, 0.0F);
	}	public MultiModel_chu(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}	public MultiModel_chu(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		CatEL = new Modchu_ModelRenderer(this, 0, 4);
		CatEL.addBox(1.0F, -11F, -2F, 3, 3, 1, f);
		CatEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		CatER = new Modchu_ModelRenderer(this, 0, 0);
		CatER.addBox(-4F, -11F, -2F, 3, 3, 1, f);
		CatER.setRotationPoint(0.0F, 0.0F, 0.0F);
		CatTail = new Modchu_ModelRenderer(this, 0, 16);
		CatTail.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 1, f);
		CatTail.setRotationPoint(0.0F, 3F, 0.0F);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		CatTail.setRotationPointZ(2.0F);
		CatTail.setRotateAngleX(-4.363323F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(CatEL);
		bipedHead.addChild(CatER);
		bipedHead.addChild(Prim);
		bipedBody.addChild(CatTail);
	}	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		CatTail.setRotateAngleX(mh_sin(f * 0.6662F) * 0.5F - 4.363323F);		if(armSwingFlag(entityCaps)) {
			CatTail.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY());
		}		if(Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			CatTail.setRotateAngleX(CatTail.getRotateAngleX() + 0.2F);
		}		if(Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			CatTail.setRotateAngleX(mh_sin(f2 * 0.6662F) * 0.1F - 4.363323F);
		}
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}