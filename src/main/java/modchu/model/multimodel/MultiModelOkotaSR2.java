package modchu.model.multimodel;

import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModel_SR2;

public abstract class MultiModelOkotaSR2 extends MultiModel_SR2 {

	public MultiModelOkotaSR2()
	{
		this(0.0F);
	}

	public MultiModelOkotaSR2(float f)
	{
		this(f, 0.0F);
	}

	public MultiModelOkotaSR2(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModelOkotaSR2(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}

	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);

		// 追加パーツ
		eyeL = new Modchu_ModelRenderer(this, 58, 16);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
		eyeR = new Modchu_ModelRenderer(this, 60, 16);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}

	@Override
	protected void eyeAnimations(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
	}

	@Override
	protected void eyeRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		boolean eyeFlag = equipmentCheckOfHead(entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			if (eyeFlag) {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			}
		} else {
			if (!eyeFlag
					| (eyeFlag
							&& 0.0D > (mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D)) {
				setCapsValue(entityCaps, caps_visible, eyeL, false);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			} else {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, true);
			}
		}
	}

}