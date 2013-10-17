package net.minecraft.src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

public abstract class MultiModelCustom extends MultiModelSkirtFloats {

	public Modchu_CustomModel customModel;
	public Modchu_ModelRenderer dummy;

	public MultiModelCustom()
	{
		this(0.0F);
	}

	public MultiModelCustom(float f)
	{
		this(f, 0.0F);
	}

	public MultiModelCustom(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModelCustom(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		dummy = new Modchu_ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}

	public void skirtFloatsInit(float f, float f1) {
		if (customModel != null) customModel.skirtFloatsInit(f, f1);
	}

    public void superrender(Modchu_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		if (customModel != null
				&& customModel.mainModel != null) {
			Object mainFrame = Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.modchu_Main.MMM_ModelMultiBase, "mainFrame", customModel.mainModel);
			if (mainFrame != null) Modchu_Reflect.invokeMethod(render.getClass(), "render", new Class[]{ float.class }, mainFrame, new Object[]{ f5 });
		} else {
			//Modchu_Debug.mDebug("superrenderMM mainFrame == null !!");
		}
		if (entityCaps != null) {
/*//151delete
			renderStabilizer(entity, (Map) entityCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
*///151delete
//-@-151
			renderStabilizer(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
//@-@151
		}
	}

	@Override
	public void render(Modchu_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		customModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}

	@Override
	public void setLivingAnimations(Modchu_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
		customModel.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
	}

	@Override
	public void setLivingAnimationsLM(Modchu_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
		customModel.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
	}

    @Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Modchu_IModelCaps entityCaps) {
		customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}

	@Override
	public void renderItems(Modchu_IModelCaps entityCaps) {
		customModel.renderItems(entityCaps);
	}

	@Override
	public void defaultPartsSettingBefore(Modchu_IModelCaps entityCaps) {
		customModel.defaultPartsSettingBefore(entityCaps);
	}

	@Override
	public void defaultPartsSettingAfter(Modchu_IModelCaps entityCaps) {
		customModel.defaultPartsSettingAfter(entityCaps);
	}

	@Override
	public void showModelSettingReflects(Modchu_IModelCaps entityCaps) {
		customModel.showModelSettingReflects(entityCaps);
	}

	@Override
	public void actionInit(Modchu_IModelCaps entityCaps, int i) {
		customModel.actionInit(entityCaps, i);
	}

	@Override
	public void actionRelease(Modchu_IModelCaps entityCaps, int i) {
		customModel.actionRelease(entityCaps, i);
	}

	@Override
	public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, Modchu_IModelCaps entityCaps) {
		customModel.action(f, f1, f2, f3, f4, f5, i, entityCaps);
	}

	@Override
	public float getHeight() {
		return getHeight(null);
	}

	@Override
	public float getHeight(Modchu_IModelCaps pEntityCaps) {
		if (customModel != null) return customModel.getHeight(pEntityCaps);
		return 1.35F;
	}

	@Override
	public float getWidth() {
		return getWidth(null);
	}

	@Override
	public float getWidth(Modchu_IModelCaps pEntityCaps) {
		if (customModel != null) return customModel.getWidth(pEntityCaps);
		return 0.5F;
	}

	@Override
	public float getyOffset() {
		return getyOffset(null);
	}

	@Override
	public float getyOffset(Modchu_IModelCaps pEntityCaps) {
		return customModel.getyOffset(pEntityCaps);
	}

	@Override
	public float getMountedYOffset() {
		return getMountedYOffset(null);
	}

	@Override
	public float getRidingyOffset(Modchu_IModelCaps pEntityCaps) {
		return customModel.getRidingyOffset(pEntityCaps);
	}

	@Override
	public float getRidingHeight(Modchu_IModelCaps pEntityCaps) {
		return customModel.getRidingHeight(pEntityCaps);
	}

	@Override
	public float getRidingWidth(Modchu_IModelCaps pEntityCaps) {
		return customModel.getRidingWidth(pEntityCaps);
	}

	@Override
	public float getMountedYOffset(Modchu_IModelCaps pEntityCaps) {
		return customModel.getMountedYOffset(pEntityCaps);
	}

	@Override
	public double getSittingyOffset(Modchu_IModelCaps pEntityCaps) {
		return customModel.getSittingyOffset(pEntityCaps);
	}

	@Override
	public float ridingViewCorrection(Modchu_IModelCaps pEntityCaps) {
		return customModel.ridingViewCorrection(pEntityCaps);
	}

	@Override
	public float getModelScale(Modchu_IModelCaps pEntityCaps) {
		return customModel.getModelScale(pEntityCaps);
	}

	@Override
	public void setArmorBipedHeadShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedHeadShowModel(entityCaps, b);
	}

	@Override
	public void setArmorBipedBodyShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedBodyShowModel(entityCaps, b);
	}

	@Override
	public void setArmorBipedRightArmShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedRightArmShowModel(entityCaps, b);
	}

	@Override
	public void setArmorBipedLeftArmShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedLeftArmShowModel(entityCaps, b);
	}

	@Override
	public void setArmorBipedRightLegShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedRightLegShowModel(entityCaps, b);
	}

	@Override
	public void setArmorBipedLeftLegShowModel(Modchu_IModelCaps entityCaps, boolean b) {
		customModel.setArmorBipedLeftLegShowModel(entityCaps, b);
	}

	@Override
	public void setArmorSkirtShowModel(Modchu_IModelCaps entityCaps, boolean b) {
	}

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		Object o;
		o = customModel.getCapsValue(pIndex, pArg);
		if (o != null) return o;
		return super.getCapsValue(pIndex, pArg);
	}

	public Object superGetCapsValue(int pIndex, Object ...pArg) {
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object ...pArg) {
		return customModel.setCapsValue(pIndex, pArg);
	}

	public boolean superSetCapsValue(int pIndex, Object ...pArg) {
		return super.setCapsValue(pIndex, pArg);
	}

	@Override
	public void changeModel(Modchu_IModelCaps entityCaps) {
		customModel.changeModel(entityCaps);
	}

	@Override
	public void changeColor(Modchu_IModelCaps entityCaps) {
		customModel.changeColor(entityCaps);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
	}

	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
		if (customModel != null) customModel.reset(f, f1, f2, f3, f4, f5, entityCaps);
	}

	@Override
	public float[] getArmorModelsSize() {
		if (customModel != null) return customModel.getArmorModelsSize();
		return new float[] {0.1F, 0.5F};
	}

	@Override
	public void renderFirstPersonHand(Modchu_IModelCaps entityCaps, float f) {
		if (customModel != null) customModel.renderFirstPersonHand(entityCaps, f);
	}

	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}

	@Override
	public int showArmorParts(int i, int i2) {
		if (customModel != null) return customModel.showArmorParts(null, i, i2);
		return -1;
	}

	@Override
	public int showArmorParts(Modchu_IModelCaps entityCaps, int i, int i2) {
		if (customModel != null) return customModel.showArmorParts(entityCaps, i, i2);
		return -1;
	}
}