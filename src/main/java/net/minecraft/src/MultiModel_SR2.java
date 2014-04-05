package net.minecraft.src;import modchu.lib.characteristic.Modchu_AS;import modchu.lib.characteristic.Modchu_ModelRenderer;import modchu.model.ModchuModel_IModelCaps;import modchu.model.ModchuModel_ModelCapsHelper;public class MultiModel_SR2 extends MultiModel {	public Modchu_ModelRenderer eyeR;	public Modchu_ModelRenderer eyeL;	public MultiModel_SR2()	{		this(0.0F);	}	public MultiModel_SR2(float f)	{		this(f, 0.0F);	}	public MultiModel_SR2(float f, float f1)	{		this(f, f1 , 64, 32);	}	public MultiModel_SR2(float f, float f1, int i, int j) {		super(f, f1, i, j);	}	@Override	public void initModel(float f, float f1, boolean isAfterInit) {		super.initModel(f, f1, false);		// 追加パーツ		eyeR = new Modchu_ModelRenderer(this, 32, 19);		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);		eyeL = new Modchu_ModelRenderer(this, 42, 19);		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		if (isAfterInit) afterInit(f, f1);	}	@Override	public void defaultAddChildSetting() {		super.defaultAddChildSetting();		if (eyeR != null) bipedHead.addChild(eyeR);		if (eyeL != null) bipedHead.addChild(eyeL);	}	@Override	public void setLivingAnimationsLM(ModchuModel_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);		Object entityliving = getCapsValue(entityCaps, entityCaps.caps_Entity);		if (entityliving != null) ;else return;		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);		float f3 = (float)ticksExisted + renderPartialTicks + ModchuModel_ModelCapsHelper.getCapsValueFloat(this, caps_entityIdFactor);		// 目パチ		if( 0 > Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.05F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.13F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.7F) + 2.55F) {			setCapsValue(caps_visible, eyeR, true);			setCapsValue(caps_visible, eyeL, true);		} else {			setCapsValue(caps_visible, eyeR, false);			setCapsValue(caps_visible, eyeL, false);		}	}	@Override	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IModelCaps entityCaps) {		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);		if (ModchuModel_ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {			setCapsValue(caps_visible, eyeL, true);			setCapsValue(caps_visible, eyeR, false);		}	}	@Override	public String getUsingTexture() {		return null;	}}