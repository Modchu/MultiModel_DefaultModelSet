package net.minecraft.src;

public class MultiModel_SR2 extends MultiModel {

	public Modchu_ModelRenderer eyeR;
	public Modchu_ModelRenderer eyeL;

	public MultiModel_SR2()
	{
		this(0.0F);
	}

	public MultiModel_SR2(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_SR2(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModel_SR2(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);

		// 追加パーツ
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
	}

	@Override
	public void setLivingAnimationsLM(Modchu_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
		Entity entityliving = (Entity) getCapsValue(entityCaps, entityCaps.caps_Entity);
		if (entityliving != null) ;else return;
		float f3 = (float)entityliving.ticksExisted + renderPartialTicks + Modchu_ModelCapsHelper.getCapsValueFloat(this, caps_entityIdFactor);
		// 目パチ
		if( 0 > MathHelper.sin(f3 * 0.05F) + MathHelper.sin(f3 * 0.13F) + MathHelper.sin(f3 * 0.7F) + 2.55F) {
			setCapsValue(caps_visible, eyeR, true);
			setCapsValue(caps_visible, eyeL, true);
		} else {
			setCapsValue(caps_visible, eyeR, false);
			setCapsValue(caps_visible, eyeL, false);
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Modchu_IModelCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_aimedBow)) {
			setCapsValue(caps_visible, eyeL, true);
			setCapsValue(caps_visible, eyeR, false);
		}
	}

	@Override
	public String getUsingTexture() {
		return null;
	}
}