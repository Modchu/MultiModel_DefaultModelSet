package modchu.model.multimodel.base;import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_SR2 extends MultiModel {	public Modchu_ModelRenderer eyeR;
	public Modchu_ModelRenderer eyeL;	public MultiModel_SR2()
	{
		this(0.0F);
	}	public MultiModel_SR2(float f)
	{
		this(f, 0.0F);
	}	public MultiModel_SR2(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}	public MultiModel_SR2(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);		// 追加パーツ
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		if (eyeR != null) bipedHead.addChild(eyeR);
		if (eyeL != null) bipedHead.addChild(eyeL);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
		eyeAnimations(entityCaps, f, f1, renderPartialTicks);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		eyeRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}	@Override
	public String getUsingTexture() {
		return null;
	}	protected void eyeAnimations(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		Object entityliving = entityCaps != null ? entityCaps.getCapsValue(entityCaps.caps_Entity) : null;
		//Modchu_Debug.mDebug("MultiModel_SR2 eyeAnimations entityliving="+entityliving);
		if (entityliving != null); else return;
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = (float)ticksExisted + renderPartialTicks + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		// 目パチ
		boolean eyeFlag = equipmentCheckOfHead(entityCaps);
		if(eyeFlag
						&& 0 > Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.05F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.13F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.7F) + 2.55F) {
			setCapsValue(entityCaps, caps_visible, eyeR, true);
			setCapsValue(entityCaps, caps_visible, eyeL, true);
		} else {
			setCapsValue(entityCaps, caps_visible, eyeR, false);
			setCapsValue(entityCaps, caps_visible, eyeL, false);
		}
	}	protected void eyeRotationAngles(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, eyeL, true);
			setCapsValue(entityCaps, caps_visible, eyeR, false);
		}
	}	public boolean equipmentCheckOfHead(ModchuModel_IEntityCaps entityCaps) {
		boolean flag = true;
		Object itemstack = getCapsValue(entityCaps, caps_currentArmor, 3);
		if (itemstack != null) {
			int addSupport = addSupportChecks(entityCaps, itemstack, 1);
			if (addSupport == 3 |
					addSupport == 4) flag = false;
		}
		Object inventory = entityCaps.getCapsValue(caps_Inventory);
		if (inventory != null) {
			Object pEntity = entityCaps.getCapsValue(entityCaps.caps_Entity);
			int slot = Modchu_Reflect.loadClass("EntityPlayer").isInstance(pEntity) ? 10 : 16;
			Object itemstack1 = Modchu_AS.get(Modchu_AS.inventoryPlayerGetStackInSlot, inventory, slot);
			if (itemstack1 != null) {
				int addSupport = addSupportChecks(entityCaps, itemstack, 1);
				if (addSupport == 3 |
						addSupport == 4) flag = false;
			}
		}
		return flag;
	}
}