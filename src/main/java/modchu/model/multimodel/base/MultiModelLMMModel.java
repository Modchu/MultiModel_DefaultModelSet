package modchu.model.multimodel.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsBase;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_LMMManager;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelRenderer;
import modchu.model.ModchuModel_ModelRendererBase;

public class MultiModelLMMModel extends MultiModelBaseBiped {
	public Object model;
	protected Class iDummyEntityCapsClass;
	public ModchuModel_ModelRenderer dummy;

	public MultiModelLMMModel() {
		this(0.0F);
	}

	public MultiModelLMMModel(float f) {
		this(f, 0.0F);
	}

	public MultiModelLMMModel(float f, Object model1) {
		this(f, 0.0F, model1);
	}

	public MultiModelLMMModel(float f, float f1) {
		this(f, f1, 64, 32);
	}

	public MultiModelLMMModel(float f, float f1, Object model1) {
		this(f, f1, 64, 32, model1);
	}

	public MultiModelLMMModel(float f, float f1, int i, int j) {
		this(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j, null);
	}

	public MultiModelLMMModel(float f, float f1, int i, int j, Object model1) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
		init(f, f1, i, j, model1);
	}

	protected void init(float f, float f1, int i, int j, Object model1) {
		model = model1;
		iDummyEntityCapsClass = Modchu_LMMManager.getLMMIModelCapsClass();
		dummy = new ModchuModel_ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}

	@Override
	public void initModel(float psize, float pyoffset, Object... o) {
		mainFrame = new ModchuModel_ModelRenderer(this, "mainFrame");
		afterInit(psize, pyoffset);
	}

	@Override
	public void defaultAddChild() {
	}

	@Override
	public void afterInit(float f, float f1) {
		armsinit(f, f1);
	}

	@Override
	public void armsinit(float f, float f1) {
		if (!Modchu_LMMManager.isLMR) return;
		// 手持ち
		Arms[0] = new ModchuModel_ModelRenderer(this, "Arms0");
		Arms[0].setRotationPoint(0.0F, 0.0F, 0.0F);
		Arms[1] = new ModchuModel_ModelRenderer(this, "Arms1");
		Arms[1].setRotationPoint(0.0F, 0.0F, 0.0F);
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190) Arms[1].isInvertX = true;
		HeadMount = new ModchuModel_ModelRenderer(this, "HeadMount");
		HeadMount.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadTop = new ModchuModel_ModelRenderer(this, "HeadTop");
		HeadTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		Modchu_Debug.mDebug("MultiModelLMMModel armsinit end.");
	}

	@Override
	public void changeModel(ModchuModel_IEntityCaps entityCaps) {
		super.changeModel(entityCaps);
		initDummyEntityCaps(entityCaps);
	}

	protected void initDummyEntityCaps(ModchuModel_IEntityCaps entityCaps) {
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		Object dummyEntityCaps = Modchu_Reflect.newInstance(Modchu_Main.getModchuCharacteristicClass(Modchu_LMMManager.getModchuLMMModelCapsString()), new Class[]{ Modchu_EntityCapsBase.class }, new Object[]{ entityCaps });
		setDummyEntityCaps(entityCaps, dummyEntityCaps);
		Object render = Modchu_AS.get(Modchu_AS.renderManagerGetEntityClassRenderObject, Modchu_LMMManager.getLMMEntityLittleMaidClass());
		Modchu_Reflect.setFieldObject(model.getClass(), "render", model, render);
	}

	@Override
	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		if (model != null); else return;
		setRotationAngles(f, f1, f2, pheadYaw, pheadPitch, f5, entityCaps);
		int armorType = getArmorType();
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else {
			initDummyEntityCaps(entityCaps);
			return;
		}
		try {
			Modchu_Reflect.invokeMethod(model.getClass(), "render", new Class[]{ iDummyEntityCapsClass, float.class, float.class,
				float.class, float.class, float.class, float.class, boolean.class }, model, new Object[]{ dummyEntityCaps, f, f1, f2, pheadYaw, pheadPitch, f5, getIsRendering(entityCaps, armorType) });
			//Modchu_Debug.mDebug("MultiModelLMMModel render call");
		} catch (Exception e) {
			Modchu_Debug.lDebug1("MultiModelLMMModel render Exception !!", 2, e);
		}
	}

	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		if (model != null); else return;
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return;
		f *= 0.1F;
		f1 *= 0.1F;
		try {
			Modchu_Reflect.invokeMethod(model.getClass(), "setLivingAnimations", new Class[]{ iDummyEntityCapsClass, float.class, float.class, float.class }, model, new Object[]{ dummyEntityCaps, f, f1, renderPartialTicks });
		} catch (Exception e) {
			Modchu_Debug.lDebug1("MultiModelLMMModel setLivingAnimationsLM Exception !!", 2, e);
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return;
		Field fi = Modchu_Reflect.getField(model.getClass(), "heldItem");
		if (fi != null) Modchu_Reflect.setFieldObject(fi, model, heldItem);
		setDefaultPause(f, f1, f2, pheadYaw, pheadPitch, f5, entityCaps);
		f *= 0.1F;
		f1 *= 0.1F;
		//f5 *= 0.4F;
		setEntityCapsToModelAttributes(entityCaps);
		Method method = Modchu_Reflect.getMethod(model.getClass(), "setRotationAngles", new Class[]{
			float.class, float.class, float.class, float.class, float.class, float.class, iDummyEntityCapsClass }, -1);
		try {
			if (method != null) {
				Modchu_Reflect.invoke(method, model, new Object[]{ f, f1, f2, pheadYaw, pheadPitch, f5, dummyEntityCaps });
				//Modchu_Debug.lDebug1("MultiModelLMMModel setRotationAnglesLM method="+method+" model="+model);
			} else {
				Modchu_Debug.lDebug1("MultiModelLMMModel setRotationAnglesLM else method == null !! model="+model);
			}
		} catch (Exception e) {
			Modchu_Debug.lDebug1("MultiModelLMMModel setRotationAnglesLM Exception !!", 2, e);
		}
		setRotationAnglesLMR(f, f1, f2, pheadYaw, pheadPitch, f5, entityCaps);
	}

	private void setRotationAnglesLMR(float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
		//Modchu_Debug.mDebug("MultiModelLMMModel setRotationAnglesLMR");
		if (!Modchu_LMMManager.isLMR) return;
		//Modchu_Debug.mdDebug("heldItem[0]="+heldItem[0]);
		//Modchu_Debug.mdDebug("heldItem[1]="+heldItem[1], 1);
		Object[] itemstacks = Modchu_CastHelper.ObjectArray(entityCaps.getCapsValue(entityCaps.caps_Items));
		if (heldItem[1] != 0
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (itemstacks != null
					&& itemstacks[1] != null) {
				Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstacks[1]);
				if (item.equals(Modchu_AS.get(Modchu_AS.getItem, "shield"))) Arms[1].setRotationPoint(0.0F, -0.25F, 0.0F);
			}
			if (heldItem[1] == 3) {
				if (!Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) Arms[1].setRotateAngle(-0.36F, -0.64F, 2.95F);
				//Arms[1].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
				//Modchu_Debug.mdDebug("setRotationAnglesLMR "+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
			}
		}
		if (heldItem[0] != 0
				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)) {
			if (heldItem[0] == 3) {
				Arms[0].setRotateAngle(-0.32F, -0.27F, 5.24F);
				//Arms[0].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
				//Modchu_Debug.mdDebug("setRotationAnglesLMR "+Modchu_Debug.debaf1+" "+Modchu_Debug.debaf2+" "+Modchu_Debug.debaf3+" ");
			}
		}
		if (itemstacks != null
				&& itemstacks[1] != null) {
			Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstacks[1]);
			if (item.equals(Modchu_AS.get(Modchu_AS.getItem, "bow"))) {
				//Modchu_Debug.mDebug("MultiModelLMMModel setRotationAnglesLMR bow");
				Arms[1].rotateAngleX = -3.14F;
			}
		}
		//Arms[0].setRotateAngle(0.0F, 0.0F, 0.0F);
		//Arms[1].setRotateAngle(0.0F, 0.0F, 0.0F);
		//Arms[0].setRotateAngle(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
		//Modchu_Debug.debaf1 = 0.0F;
		//Modchu_Debug.debaf2 = 0.0F;
		//Modchu_Debug.debaf3 = 0.0F;
	}

	@Override
	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, ModchuModel_IEntityCaps entityCaps) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 189) {
			Arms[0].setRotationPoint(0.0F, 0.0F, 0.0F);
			Arms[1].setRotationPoint(0.0F, 0.0F, 0.0F);
			Arms[0].setRotateAngle(0.0F, 0.0F, 0.0F);
			Arms[1].setRotateAngle(0.0F, 0.0F, 0.0F);
		}
	}

	protected void setEntityCapsToModelAttributes(ModchuModel_IEntityCaps entityCaps) {
		boolean isRiding = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding);
		Modchu_Reflect.setFieldObject(model.getClass(), "isRiding", model, isRiding);
		boolean isSneak = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak);
		Modchu_Reflect.setFieldObject(model.getClass(), "isSneak", model, isSneak);
		boolean aimedBow = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow);
		Modchu_Reflect.setFieldObject(model.getClass(), "aimedBow", model, aimedBow);
		boolean isWait = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait);
		Modchu_Reflect.setFieldObject(model.getClass(), "isWait", model, isWait);
		Modchu_Reflect.setFieldObject(model.getClass(), "onGrounds", model, onGrounds);
	}

	@Override
	public void renderItemsLM(ModchuModel_IEntityCaps entityCaps) {
		// 手持ちの表示
		Modchu_GlStateManager.pushMatrix();
		if (Modchu_LMMManager.isLMR) {
			Object o = Modchu_Reflect.getFieldObject(model.getClass(), "Arms", model);
			Object[] arms = Modchu_CastHelper.ObjectArray(o);
			if (arms != null) {
				// R
				Modchu_Reflect.invokeMethod(arms[0].getClass(), "loadMatrix", arms[0]);
				Modchu_GlStateManager.translate(0F, 0.05F, -0.05F);
				Modchu_GlStateManager.translate(Arms[0].rotationPointX, Arms[0].rotationPointY, Arms[0].rotationPointZ);
				Modchu_GlStateManager.rotate(Arms[0].rotateAngleX * ModchuModel_ModelRendererBase.radFactor, 1.0F, 0.0F, 0.0F);
				Modchu_GlStateManager.rotate(Arms[0].rotateAngleY * ModchuModel_ModelRendererBase.radFactor, 0.0F, 1.0F, 0.0F);
				Modchu_GlStateManager.rotate(Arms[0].rotateAngleZ * ModchuModel_ModelRendererBase.radFactor, 0.0F, 0.0F, 1.0F);
				Arms[0].renderItems("Hand", this, entityCaps, false, 0);
				// L
				Modchu_Reflect.invokeMethod(arms[1].getClass(), "loadMatrix", arms[1]);
				Modchu_GlStateManager.translate(0F, 0.05F, -0.05F);
				Modchu_GlStateManager.translate(Arms[1].rotationPointX, Arms[1].rotationPointY, Arms[1].rotationPointZ);
				Modchu_GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);
				Modchu_GlStateManager.rotate(Arms[1].rotateAngleX * ModchuModel_ModelRendererBase.radFactor, 1.0F, 0.0F, 0.0F);
				Modchu_GlStateManager.rotate(Arms[1].rotateAngleY * ModchuModel_ModelRendererBase.radFactor, 0.0F, 1.0F, 0.0F);
				Modchu_GlStateManager.rotate(Arms[1].rotateAngleZ * ModchuModel_ModelRendererBase.radFactor, 0.0F, 0.0F, 1.0F);
				Arms[1].renderItems("Hand", this, entityCaps, false, 1);
			}
		} else {
			Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
			if (dummyEntityCaps != null); else return;
			if (Modchu_Reflect.getFieldObject(model.getClass(), "render", model) != null) Modchu_Reflect.invokeMethod(model.getClass(), "renderItems", new Class[]{ iDummyEntityCapsClass }, model, new Object[]{ dummyEntityCaps });
		}
		renderItemsHead(entityCaps);
		renderItemsArmorHead(entityCaps);
		Modchu_GlStateManager.popMatrix();
	}

	@Override
	public void headMountLoadMatrix() {
		Object headMount = Modchu_Reflect.getFieldObject(model.getClass(), "HeadMount", model, -1);
		if (headMount != null) Modchu_Reflect.invokeMethod(headMount.getClass(), "loadMatrix", headMount);
		Modchu_GlStateManager.translate(0.0F, 0.3F, 0.0F);
	}

	@Override
	public void headTopLoadMatrix() {
		Object headTop = Modchu_Reflect.getFieldObject(model.getClass(), "HeadTop", model, -1);
		if (headTop != null) Modchu_Reflect.invokeMethod(headTop.getClass(), "loadMatrix", headTop);
		Modchu_GlStateManager.translate(0.0F, 0.3F, 0.0F);
	}

	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps, int renderArmIndex) {
	}

	@Override
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
	}

	@Override
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {
		if (model != null); else return;
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "renderFirstPersonHand", new Class[]{ iDummyEntityCapsClass }, -1);
		if (method != null) Modchu_Reflect.invoke(method, model, new Object[]{ dummyEntityCaps });
	}

	@Override
	public void showAllParts(ModchuModel_IEntityCaps entityCaps) {
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "showAllParts", new Class[]{ iDummyEntityCapsClass }, -1);
		if (method != null) Modchu_Reflect.invoke(method, model, new Object[]{ dummyEntityCaps });
	}

	@Override
	public int showArmorParts(ModchuModel_IEntityCaps entityCaps, int parts, int index) {
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return -1;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "showArmorParts", new Class[]{ int.class, int.class }, -1);
		if (method != null) return Modchu_CastHelper.Int(Modchu_Reflect.invoke(method, model, new Object[]{ parts, index }));
		return -1;
	}

	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 1.62F;
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return f;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "getHeight", new Class[]{ iDummyEntityCapsClass }, -1);
		if (method != null) f = Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(model.getClass(), "getHeight", new Class[]{ iDummyEntityCapsClass }, model, new Object[]{ dummyEntityCaps }));
		return f;
	}

	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.5F;
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return f;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "getWidth", new Class[]{ iDummyEntityCapsClass }, -1);
		if (method != null) f = Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(model.getClass(), "getWidth", new Class[]{ iDummyEntityCapsClass }, model, new Object[]{ dummyEntityCaps }));
		return f;
	}

	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = super.getYOffset(entityCaps);
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return f;
		Method method = Modchu_Reflect.getMethod(model.getClass(), "getYOffset", new Class[]{ iDummyEntityCapsClass }, -1);
		if (method != null) f = Modchu_CastHelper.Float(Modchu_Reflect.invoke(method, model, new Object[]{ dummyEntityCaps }));
		return f;
	}

	@Override
	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		Object dummyEntityCaps = getDummyEntityCaps(entityCaps);
		if (dummyEntityCaps != null); else return f;
		return Modchu_CastHelper.Float(reflectOther("getRidingHeight", new Class[]{ iDummyEntityCapsClass }, new Object[]{ dummyEntityCaps }));
	}

	@Override
	public float getLeashOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.4F;
	}

	@Override
	public boolean isItemHolder(ModchuModel_IEntityCaps entityCaps) {
		return true;
	}

	@Override
	public float[] getArmorModelsSize() {
		return new float[]{ 0.1F, 0.5F };
	}

	public int getArmorType() {
		float[] f = getArmorModelsSize();
		return modelSize == f[0] ? 1 : modelSize == f[1] ? 2 : 0;
	}

	public boolean getIsRendering(ModchuModel_IEntityCaps entityCaps, int i) {
		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering);
	}

	public Object getDummyEntityCaps(ModchuModel_IEntityCaps entityCaps) {
		return entityCaps.getCapsValue(caps_freeVariable, "dummyEntityCaps");
	}

	public void setDummyEntityCaps(ModchuModel_IEntityCaps entityCaps, Object dummyEntityCaps) {
		entityCaps.setCapsValue(caps_freeVariable, "dummyEntityCaps", dummyEntityCaps);
	}

	private Object reflectOther(String s, Class[] iDummyEntityCapsClass, Object[] o) {
		if (model != null
				&& o != null) {
			Method method = Modchu_Reflect.getMethod(model.getClass(), s, iDummyEntityCapsClass, -1);
			if (method != null) return Modchu_Reflect.invoke(method, model, o);
		}
		return null;
	}

	@Override
	public Object getCapsValueModel(int pIndex, Object... pArg) {
		return Modchu_Reflect.invokeMethod(model.getClass(), "getCapsValue", new Class[]{ int.class, Object[].class }, model, new Object[]{ pIndex, pArg });
	}

	@Override
	public boolean setCapsValueModel(int pIndex, Object... pArg) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(model.getClass(), "setCapsValue", new Class[]{ int.class, Object[].class }, model, new Object[]{ pIndex, pArg }));
	}

}
