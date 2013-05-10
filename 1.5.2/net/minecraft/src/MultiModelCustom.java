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
	public ModelRenderer dummy;

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
		dummy = new ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}

	public void superrenderMM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		setRotationAnglesMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
		if (customModel != null
				&& customModel.mainModel != null
				&& customModel.mainModel.mainFrame != null) {
			try {
				Modchu_Reflect.invokeMethod(customModel.mainModel.mainFrame.getClass(), "render", new Class[]{ float.class }, customModel.mainModel.mainFrame, new Object[]{ f5 });
			} catch(Exception e) {
				customModel.mainModel.mainFrame.render(f5);
			}
		} else {
			//Modchu_Debug.mDebug("superrenderMM mainFrame == null !!");
		}
		if (entityCaps != null) {
/*//151delete
			renderStabilizer(entity, (Map) entityCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
*///151delete
//-@-151
			renderStabilizer(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
//@-@151
		}
	}

	@Override
	public void renderMM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		//Modchu_Debug.mDebug("MultiModelCustom render");
		setRotationAnglesMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
		customModel.renderMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
	}

	@Override
	public void setLivingAnimationsMM(float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM start");
		super.setLivingAnimationsMM(f, f1, renderPartialTicks);
		customModel.setLivingAnimationsMM(f, f1, renderPartialTicks);
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM end");
	}

	@Override
	public void setRotationAnglesMM(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAnglesMM(f, f1, f2, f3, f4, f5);
		customModel.setRotationAnglesMM(f, f1, f2, f3, f4, f5);
	}

    @Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
	}

	@Override
	public void renderItems() {
		customModel.renderItems();
	}

	@Override
	public void defaultPartsSettingBefore() {
		customModel.defaultPartsSettingBefore();
	}

	@Override
	public void defaultPartsSettingAfter() {
		customModel.defaultPartsSettingAfter();
	}

    @Override
    public void showModelSettingReflects() {
    	customModel.showModelSettingReflects();
    }

    @Override
    public void actionInit(int i) {
    	customModel.actionInit(i);
    }

    @Override
    public void actionRelease(int i) {
    	customModel.actionRelease(i);
    }

    @Override
    public void action(float f, float f1, float f2, float f3, float f4, float f5, int i) {
    	customModel.action(f, f1, f2, f3, f4, f5, i);
    }

    @Override
    public void syncModel(MultiModelBaseBiped model) {
    	customModel.syncModel(model);
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
    public double getMountedYOffset() {
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
    public void equippedItemPositionFlower() {
    	customModel.equippedItemPositionFlower();
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	customModel.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	customModel.setArmorBipedBodyShowModel(b);
    }

    @Override
    public void setArmorBipedRightArmShowModel(boolean b) {
    	customModel.setArmorBipedRightArmShowModel(b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(boolean b) {
    	customModel.setArmorBipedLeftArmShowModel(b);
    }

    @Override
    public void setArmorBipedRightLegShowModel(boolean b) {
    	customModel.setArmorBipedRightLegShowModel(b);
    }

    @Override
    public void setArmorBipedLeftLegShowModel(boolean b) {
    	customModel.setArmorBipedLeftLegShowModel(b);
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
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
	public void reset(float f, float f1, float f2, float f3, float f4, float f5) {
		if (customModel != null) customModel.reset(f, f1, f2, f3, f4, f5);
	}

	@Override
	public float[] getArmorModelsSize() {
		if (customModel != null) return customModel.getArmorModelsSize();
		return new float[] {0.1F, 0.5F};
	}

	@Override
	public void renderFirstPersonHand(float f) {
		if (customModel != null) customModel.renderFirstPersonHand(f);
	}

	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5) {
		if (customModel != null) customModel.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5);
	}
}