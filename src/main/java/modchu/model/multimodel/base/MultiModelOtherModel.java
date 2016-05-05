package modchu.model.multimodel.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_ASAlmighty;
import modchu.lib.Modchu_ASBase;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelRenderer;

import org.lwjgl.opengl.GL11;

public class MultiModelOtherModel extends MultiModelBaseBiped {
	public Object model;
	private float defaultScale = 1.0F;
	private float guiViewScale = 1.0F;
	private float[] positionCorrection = new float[]{ 0.0F, 0.0F, 0.0F };
	private float[] guiPositionCorrection = new float[]{ 0.0F, 0.0F, 0.0F };
	private Object renderDummyEntity;
	private String renderDummyEntityClassName;
	private ArrayList<String> renderDummyEntityInvokeMethod;
	private boolean initRenderDummyEntityFlag = false;
/*
	public MultiModelOtherModel() {
		this(0.0F);
	}

	public MultiModelOtherModel(float f) {
		this(f, 0.0F);
	}
*/
	public MultiModelOtherModel(float f, Object model1) {
		this(f, 0.0F, model1);
	}

	public MultiModelOtherModel(float f, Object model1, HashMap<String, Object> dataMap) {
		this(f, 0.0F, model1, dataMap);
	}

	public MultiModelOtherModel(float f, float f1) {
		this(f, f1, 64, 32);
	}

	public MultiModelOtherModel(float f, float f1, Object model1) {
		this(f, f1, 64, 32, model1);
	}

	public MultiModelOtherModel(float f, float f1, Object model1, HashMap<String, Object> dataMap) {
		this(f, f1, 64, 32, model1, dataMap);
	}

	public MultiModelOtherModel(float f, float f1, int i, int j) {
		this(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j, null);
	}

	public MultiModelOtherModel(float f, float f1, int i, int j, Object model1) {
		this(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j, model1, null);
	}

	public MultiModelOtherModel(float f, float f1, int i, int j, Object model1, HashMap<String, Object> dataMap) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
		if (model1 != null); else {
			if (f == 0.0F) {
				Modchu_Debug.systemLogDebug("new MultiModelOtherModel model1 == null !!");
				Modchu_Debug.lCalledFrom();
			}
		}
		model = model1;
		mainFrame = new ModchuModel_ModelRenderer(this, "mainFrame");
		if (dataMap != null
				&& !dataMap.isEmpty()) {
			for (Entry<String, Object> en : ((Map<String, Object>) dataMap).entrySet()) {
				String s2 = en.getKey();
				Object o2 = en.getValue();
				if (s2.startsWith("defaultScale")) {
					defaultScale = Modchu_CastHelper.Float(o2);
					continue;
				}
				if (s2.startsWith("guiViewScale")) {
					guiViewScale = Modchu_CastHelper.Float(o2);
					continue;
				}
				if (s2.startsWith("positionCorrection")) {
					float[] f2 = Modchu_CastHelper.FloatArray(o2);
					if (f2 != null
							&& f2.length > 2) positionCorrection = f2;
					continue;
				}
				if (s2.startsWith("guiPositionCorrection")) {
					float[] f2 = Modchu_CastHelper.FloatArray(o2);
					if (f2 != null
							&& f2.length > 2) guiPositionCorrection = f2;
					continue;
				}
				if (s2.startsWith("renderDummyEntityInvokeMethod")) {
					renderDummyEntityInvokeMethod = Modchu_CastHelper.ArrayList(o2);
					continue;
				}
				if (s2.startsWith("renderDummyEntity")) {
					renderDummyEntityClassName = Modchu_CastHelper.String(o2);
					//Modchu_Debug.lDebug("MultiModelOtherModel renderDummyEntityClassName="+renderDummyEntityClassName);
					continue;
				}
			}
		}
	}

	@Override
	public void armsinit(float f, float f1) {
		// 手持ち
		Arms[0] = new ModchuModel_ModelRenderer(this, 0, 0);
		Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
		Arms[1] = new ModchuModel_ModelRenderer(this, 0, 0);
		Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
		Arms[1].isInvertX = true;
		HeadMount = new ModchuModel_ModelRenderer(this, "HeadMount");
		HeadMount.setRotationPoint(0F, 0F, 0F);
		HeadTop = new ModchuModel_ModelRenderer(this, "HeadTop");
		HeadTop.setRotationPoint(0.0F, -8.0F, 0.0F);
	}

	@Override
	public void changeModel(ModchuModel_IEntityCaps o) {
		super.changeModel(o);
		initRenderDummyEntity();
	}

	@Override
	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		//Modchu_Debug.mDebug("MultiModelOtherModel render model="+model);
		if (model != null); else return;
		if (renderDummyEntity != null) {
			Modchu_AS.set(Modchu_AS.entityOnUpdate, renderDummyEntity);
			//Modchu_Debug.mDebug("MultiModelOtherModel render entityOnUpdate");
		} else if (!initRenderDummyEntityFlag) {
			initRenderDummyEntity();
		}
		renderScaleSetting();
		Object entity = renderDummyEntity != null ? renderDummyEntity : entityCaps.getCapsValue(entityCaps.caps_Entity);
		try {
			Modchu_AS.set(Modchu_AS.modelBaseRender, model, entity, f, f1, f2, pheadYaw, pheadPitch, f5);
		} catch (Exception e) {
			Modchu_Debug.lDebug1("MultiModelOtherModel render Exception !!", 2, e);
		}
		mainFrame.render(f5);
	}

	@Override
	public void defaultAddChild() {
		Object rightArm = Modchu_AS.get(Modchu_AS.modelRightArm, model);
		if (rightArm != null
				&& Arms[0] != null) {
			List childModels = Modchu_AS.getList("ModelRenderer", "childModels", rightArm);
			if (childModels != null
					&& !childModels.contains(Arms[0])) Modchu_AS.set("ModelRenderer", "addChild", rightArm, new Class[]{ Modchu_Reflect.loadClass("ModelRenderer") }, Arms[0]);
		}
/*
		Object leftArm = Modchu_AS.get(Modchu_AS.modelLeftArm, model);
		if (leftArm != null
				&& Arms[0] != null) Modchu_AS.set("ModelRenderer", "addChild", leftArm, new Class[]{ Modchu_Reflect.loadClass("ModelRenderer") }, Arms[1]);
*/
	}

	protected void renderScaleSetting() {
		Object currentScreen = Modchu_AS.get(Modchu_AS.minecraftCurrentScreen);
		float scale = currentScreen != null ? guiViewScale : defaultScale;
		if (scale != 1.0F) GL11.glScalef(scale, scale, scale);
		float[] position = currentScreen != null ? guiPositionCorrection : positionCorrection;
		if (position[0] != 0.0F
				| position[1] != 0.0F
				| position[2] != 0.0F) {
			GL11.glTranslatef(position[0], position[1], position[2]);
		}
	}

	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		if (model != null); else return;
		//Modchu_Debug.lDebug1("MultiModelOtherModel setLivingAnimationsLM ");
		try {
			Object entity = renderDummyEntity != null ? renderDummyEntity : entityCaps.getCapsValue(entityCaps.caps_Entity);
			Modchu_AS.set(Modchu_AS.modelBaseSetLivingAnimations, model, renderDummyEntity != null ? renderDummyEntity : entity, f, f1, renderPartialTicks);
		} catch (Exception e) {
			Modchu_Debug.lDebug1("MultiModelOtherModel setLivingAnimationsLM isVanillaModel Exception !! renderDummyEntity="+renderDummyEntity);
			Modchu_Debug.lDebug1("MultiModelOtherModel setLivingAnimationsLM isVanillaModel Exception !! model="+model);
			Modchu_Debug.lDebug1("MultiModelOtherModel setLivingAnimationsLM isVanillaModel Exception !!", 2, e);
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
	}
/*
	@Override
	public void renderItems(ModchuModel_IEntityCaps entityCaps) {
		super.renderItems(entityCaps);
	}

	@Override
	public void renderItemsLM(ModchuModel_IEntityCaps entityCaps) {
		//Arms[0].postRender(1.0F);
		super.renderItemsLM(entityCaps);
	}

	@Override
	public void renderItemsHead(ModchuModel_IEntityCaps entityCaps) {
		super.renderItemsHead(entityCaps);
	}

	@Override
	public void renderItemsArmorHead(ModchuModel_IEntityCaps entityCaps) {
		super.renderItemsArmorHead(entityCaps);
	}
*/
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
		Object bipedRightArm = Modchu_AS.get(Modchu_AS.modelRightArm, model);
		if (bipedRightArm != null) Modchu_AS.set(Modchu_AS.modelRendererRender, bipedRightArm, f);
	}

	@Override
	public int showArmorParts(ModchuModel_IEntityCaps entityCaps, int parts, int index) {
		switch(parts) {
		case 0:
		case 1:
			if ((parts == 1
					&& index == 0) | (parts == 0
					&& index == 1)) {
				setArmorBipedRightLegShowModel(entityCaps, true);
				setArmorBipedLeftLegShowModel(entityCaps, true);
			}
			break;
		case 2:
			setArmorBipedBodyShowModel(entityCaps, true);
			setArmorBipedRightArmShowModel(entityCaps, true);
			setArmorBipedLeftArmShowModel(entityCaps, true);
			break;
		case 3:
			setArmorBipedHeadShowModel(entityCaps, true);
			break;
		}
		return -1;
	}

	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.81F;
	}

	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.6F;
	}

	@Override
	public float getLeashOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.0F;
	}

	@Override
	public boolean isItemHolder(ModchuModel_IEntityCaps entityCaps) {
		return false;
	}

	@Override
	public void showAllParts(ModchuModel_IEntityCaps entityCaps) {
		boolean b = Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType) == 0;
		ModchuModel_IEntityCaps entityCaps1 = (ModchuModel_IEntityCaps) entityCaps;
		setArmorBipedHeadShowModel(entityCaps1, b);
		setArmorBipedBodyShowModel(entityCaps1, b);
		setArmorBipedRightArmShowModel(entityCaps1, b);
		setArmorBipedLeftArmShowModel(entityCaps1, b);
		setArmorBipedRightLegShowModel(entityCaps1, b);
		setArmorBipedLeftLegShowModel(entityCaps1, b);
		setArmorBipedOtherShowModel(entityCaps1, b);
	}

	public void setArmorBipedOtherShowModel(ModchuModel_IEntityCaps entityCaps1, boolean b) {
	}

	@Override
	public void initModel(float psize, float pyoffset, Object... o) {
		afterInit(psize, pyoffset);
	}

	@Override
	public float[] getArmorModelsSize() {
		return new float[]{ 0.5F, 1.0F };
	}

	public void initRenderDummyEntity() {
		boolean debug = true;
		initRenderDummyEntityFlag = true;
		if (debug) Modchu_Debug.lDebug1("MultiModelOtherModel initRenderDummyEntity renderDummyEntityClassName="+renderDummyEntityClassName);
		if (renderDummyEntityClassName != null
				&& !renderDummyEntityClassName.isEmpty()) {
			renderDummyEntity = Modchu_Reflect.newInstance(renderDummyEntityClassName, new Class[]{ Modchu_Reflect.loadClass("World") }, new Object[]{ Modchu_AS.get(Modchu_AS.minecraftTheWorld) });
			if (debug) Modchu_Debug.lDebug1("MultiModelOtherModel initRenderDummyEntity renderDummyEntity="+renderDummyEntity);
		}
		if (renderDummyEntityInvokeMethod != null
				&& !renderDummyEntityInvokeMethod.isEmpty()); else return;
		for (String s2 : renderDummyEntityInvokeMethod) {
			if (debug) Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod ok. s2="+s2);
			String[] s1 = s2.split(",");
			if (s1 != null
					&& s1.length > 0) {
				if (debug) Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod="+renderDummyEntityInvokeMethod);
				if (renderDummyEntity != null
						&& s1.length > 2) {
					if (debug) {
						Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod ok. renderDummyEntity="+renderDummyEntity+" s1[0]="+s1[0]);
					}
					int i = Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(Modchu_ASBase.class, s1[0], -1), -1);
					String[] s3 = s1[1].split(",");
					String[] s4 = s1[2].split(",");
					Class[] c1 = Modchu_Main.stringArrayToClassArray(s3);
					Object[] o1 = Modchu_Main.stringArrayToObjectArray(s4, c1);
					if (debug) {
						Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod s1[0]="+s1[0]);
						Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod c1[0]="+c1[0]+" o1[0]="+o1[0]+" o1[0].getClass()="+o1[0].getClass());
					}
					if (i > -1) {
						Object[] o2 = new Object[2];
						o2[0] = i;
						if (o1 != null
								&& o1.length > 0) {
							o2[1] = new Object[o1.length + 1];
							((Object[]) o2[1])[0] = renderDummyEntity;
							for (int i1 = 0; i1 < o1.length; i1++) {
								((Object[]) o2[1])[i1 + 1] = o1[i1];
							}
						} else {
							o2[1] = new Object[]{ renderDummyEntity };
						}
						if (debug) {
							Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod i="+i);
							//Method mothod = Modchu_Reflect.getMethod(Modchu_ASAlmighty.class, "set", new Class[]{ int.class, Object[].class });
							//Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod ok. mothod="+mothod);
						}
						boolean results = Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(Modchu_ASAlmighty.class, "set", new Class[]{ int.class, Object[].class }, null, o2));
						if (debug) Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity renderDummyEntityInvokeMethod set results="+results);
					} else {
						Method mothod = Modchu_Reflect.getMethod(renderDummyEntity.getClass(), s1[0], c1, -1);
						if (mothod != null) {
							if (debug) Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity 2 renderDummyEntityInvokeMethod invokeMethod mothod="+mothod);
							Modchu_Reflect.invoke(mothod, renderDummyEntity, o1);
						} else {
							Modchu_Debug.lDebug1("MultiModelOtherModel initRenderDummyEntity 2 renderDummyEntityInvokeMethod invokeMethod mothod == null !!");
							Modchu_Debug.lDebug1("MultiModelOtherModel initRenderDummyEntity 2 renderDummyEntityInvokeMethod invokeMethod mothod == null !! renderDummyEntity.getClass()="+renderDummyEntity.getClass()+" s1[0]="+s1[0]+" c1="+c1);
						}
					}
				} else {
					if (debug) {
						Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity else renderDummyEntity="+renderDummyEntity);
						Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity else s1.length="+s1.length);
					}
				}
			} else {
				if (debug) Modchu_Debug.lDebug("MultiModelOtherModel initRenderDummyEntity else !! renderDummyEntityInvokeMethod s1="+s1);
			}
		}
	}

}
