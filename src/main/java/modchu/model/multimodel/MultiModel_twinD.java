package modchu.model.multimodel;import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_twinD extends MultiModel_SR2 {
	public Modchu_ModelRenderer longhearR;
	public Modchu_ModelRenderer longhearL;
	public Modchu_ModelRenderer kamidomeR;
	public Modchu_ModelRenderer kamidomeL;	public MultiModel_twinD() {
		this(0.0F);
	}	public MultiModel_twinD(float f) {
		this(f, 0.0F);
	}	public MultiModel_twinD(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_twinD(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		longhearR = new Modchu_ModelRenderer(this, 52, 13);
		longhearR.addBox(2.5F, -8F, 7.4F, 2, 18, 1);
		longhearR.setRotationPoint(0F, 0F, 0F);		longhearL = new Modchu_ModelRenderer(this, 58, 13);
		longhearL.addBox(-4.5F, -8F, 7.4F, 2, 18, 1);
		longhearL.setRotationPoint(0F, 0F, 0F);		kamidomeR = new Modchu_ModelRenderer(this, 46, 19);
		kamidomeR.addBox(1F, -7F, 6.5F, 2, 2, 1);
		kamidomeR.setRotationPoint(0F, 0F, 0F);		kamidomeL = new Modchu_ModelRenderer(this, 46, 22);
		kamidomeL.addBox(-3F, -7F, 6.5F, 2, 2, 1);
		kamidomeL.setRotationPoint(0F, 0F, 0F);		longhearR.rotateAngleX = longhearL.rotateAngleX = kamidomeR.rotateAngleX =
				kamidomeL.rotateAngleX = 0.296706F;
		longhearR.rotateAngleY = kamidomeR.rotateAngleY = 0.296706F;
		longhearL.rotateAngleY = kamidomeL.rotateAngleY = -0.296706F;
		longhearR.rotateAngleZ = -0.1745329F;
		longhearL.rotateAngleZ = 0.1745329F;
		setCapsValue(null, caps_visible, Tail, false);
		setCapsValue(null, caps_visible, SideTailL, false);
		setCapsValue(null, caps_visible, SideTailR, false);
		setCapsValue(null, caps_visible, ChignonB, false);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(longhearR);
		bipedHead.addChild(longhearL);
		bipedHead.addChild(kamidomeR);
		bipedHead.addChild(kamidomeL);
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"Tail", "SideTailL", "SideTailR", "ChignonB"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
	}	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
		setCapsValue(entityCaps, caps_visible, Tail, false);
		setCapsValue(entityCaps, caps_visible, SideTailL, false);
		setCapsValue(entityCaps, caps_visible, SideTailR, false);
		setCapsValue(entityCaps, caps_visible, ChignonB, false);
	}
}