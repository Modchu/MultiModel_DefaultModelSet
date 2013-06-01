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
	public MMM_ModelRenderer dummy;

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
		dummy = new MMM_ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}

	public void superrender(MMM_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		if (customModel != null
				&& customModel.mainModel != null
				&& customModel.mainModel.mainFrame != null) {
			customModel.mainModel.mainFrame.render(f5);
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
    public void render(MMM_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		//Modchu_Debug.mDebug("MultiModelCustom render");
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		customModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}

	@Override
	public void setLivingAnimations(MMM_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM start");
		super.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
		customModel.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM end");
	}

    @Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, MMM_IModelCaps entityCaps) {
		customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}

	@Override
	public void renderItems(MMM_IModelCaps entityCaps) {
		customModel.renderItems(entityCaps);
	}

	@Override
	public void defaultPartsSettingBefore(MMM_IModelCaps entityCaps) {
		customModel.defaultPartsSettingBefore(entityCaps);
	}

	@Override
	public void defaultPartsSettingAfter(MMM_IModelCaps entityCaps) {
		customModel.defaultPartsSettingAfter(entityCaps);
	}

    @Override
    public void showModelSettingReflects(MMM_IModelCaps entityCaps) {
    	customModel.showModelSettingReflects(entityCaps);
    }

    @Override
    public void actionInit(MMM_IModelCaps entityCaps, int i) {
    	customModel.actionInit(entityCaps, i);
    }

    @Override
    public void actionRelease(MMM_IModelCaps entityCaps, int i) {
    	customModel.actionRelease(entityCaps, i);
    }

    @Override
    public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, MMM_IModelCaps entityCaps) {
    	customModel.action(f, f1, f2, f3, f4, f5, i, entityCaps);
    }

    @Override
    public void syncModel(MMM_IModelCaps entityCaps, MultiModelBaseBiped model) {
    	customModel.syncModel(entityCaps, model);
    }

    @Override
    public float getHeight() {
    	if (customModel != null) return customModel.getHeight();
    	return 1.35F;
    }

    @Override
    public float getWidth() {
    	if (customModel != null) return customModel.getWidth();
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return customModel.getyOffset();
    }

    @Override
    public float getRidingHeight() {
    	return customModel.getRidingHeight();
    }

    @Override
    public float getRidingWidth() {
    	return customModel.getRidingWidth();
    }

    @Override
    public float getRidingyOffset() {
    	return customModel.getRidingyOffset();
    }

    @Override
    public float getMountedYOffset() {
    	return customModel.getMountedYOffset();
    }

    @Override
    public double getSittingyOffset() {
    	return customModel.getSittingyOffset();
    }

    @Override
    public double getSleepingyOffset() {
    	return customModel.getSleepingyOffset();
    }

    @Override
    public float ridingViewCorrection() {
    	return customModel.ridingViewCorrection();
    }

    @Override
    public float getModelScale() {
    	return customModel.getModelScale();
    }

    @Override
    public void setArmorBipedHeadShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedHeadShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedBodyShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedBodyShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedRightArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedRightArmShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedLeftArmShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedRightLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedRightLegShowModel(entityCaps, b);
    }

    @Override
    public void setArmorBipedLeftLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	customModel.setArmorBipedLeftLegShowModel(entityCaps, b);
    }

    @Override
    public void setArmorSkirtShowModel(MMM_IModelCaps entityCaps, boolean b) {
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
	public void changeModel(MMM_IModelCaps entityCaps) {
		customModel.changeModel(entityCaps);
	}

	@Override
	public void changeColor(MMM_IModelCaps entityCaps) {
		customModel.changeColor(entityCaps);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
	}

	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
		if (customModel != null) customModel.reset(f, f1, f2, f3, f4, f5, entityCaps);
	}

	@Override
	public float[] getArmorModelsSize() {
		if (customModel != null) return customModel.getArmorModelsSize();
		return new float[] {0.1F, 0.5F};
	}

	@Override
	public void renderFirstPersonHand(MMM_IModelCaps entityCaps, float f) {
		if (customModel != null) customModel.renderFirstPersonHand(entityCaps, f);
	}

	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}

	@Override
	public int showArmorParts(MMM_IModelCaps entityCaps, int i, int i2) {
		if (customModel != null) return customModel.showArmorParts(entityCaps, i, i2);
		return -1;
	}
}