package modchu.model.multimodel.base;import java.lang.reflect.Field;import java.util.Map.Entry;import java.util.concurrent.ConcurrentHashMap;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.model.ModchuModel_ConfigData;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;/** * SkirtFloats機能追加用class */public abstract class MultiModelSkirtFloats extends MultiModelAction {	private double motionY = 0.0D;	public ConcurrentHashMap<String, ModchuModel_ModelRenderer> breastFloatsModelRendererMap;	/**	 * コンストラクタは全て継承させること	 */	public MultiModelSkirtFloats() {		this(0.0F);	}	/**	 * コンストラクタは全て継承させること	 */	public MultiModelSkirtFloats(float psize) {		this(psize, 0.0F);	}	/**	 * コンストラクタは全て継承させること	 */	public MultiModelSkirtFloats(float psize, float pyoffset) {		this(psize, pyoffset, 64, 32);	}	public MultiModelSkirtFloats(float psize, float pyoffset, int par3, int par4, Object... o) {		super(psize, pyoffset, par3 < 0 ? 64 : par3, par4 < 0 ? 32 : par4, (Object[]) o);	}	@Override	public void afterInit(float f, float f1) {		armsinit(f, f1);		skirtFloatsInit(f, f1);		bonesInit(f, f1);		actionPartsInit(f, f1);		defaultAddChild();		initSkirtFloats();	}	/**	 * ふんわりスカート初期化	 */	public void skirtFloatsInit(float f, float f1) {	}	public void initSkirtFloats() {		String[] breastNames = getBreastName();		if (breastNames != null				&& breastNames.length > 0); else return;		Field[] fields = getClass().getFields();		breastFloatsModelRendererMap = new ConcurrentHashMap();		for (Field f : fields) {			String name = f.getName();			try {				Object o = f.get(this);				if (o instanceof ModchuModel_ModelRenderer) {					name = name != null							&& !name.isEmpty() ? name.toLowerCase() : null;					if (name != null							&& !name.isEmpty()); else continue;					for (String s : breastNames) {						if (name != null								&& name.indexOf(s) > -1) {							breastFloatsModelRendererMap.put(name, (ModchuModel_ModelRenderer) o);							break;						}					}				}			} catch (Exception e) {			}		}	}	public void defaultSkirtFloatsAddChild() {	}	@Override	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {		super.setLivingAnimationsLM(entityCaps, f, f1, f2);		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_skirtFloats) == 2				| Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_breastFloats)) {			Object entityliving = entityCaps != null ? entityCaps.getCapsValue(entityCaps.caps_Entity) : null;			//Modchu_Debug.mDebug1("MultiModelSkirtFloats setLivingAnimationsLM entityliving="+entityliving);			if (entityliving != null) {				double motionY = Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70181_x", "motionY", entityliving)) + 0.0784000015258789D;				setMotionY(motionY);				//Modchu_Debug.mDebug1("MultiModelSkirtFloats setLivingAnimationsLM this="+this+" motionY="+motionY);			} else {				setMotionY(0D);				//Modchu_Debug.mDebug("MultiModelSkirtFloats setLivingAnimationsLM else motionY=0D");			}		}	}	@Override	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);		breastFloats(f, f1, f2, f3, f4, f5, entityCaps);	}	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {	}	public void breastFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		//Modchu_Debug.mDebug("MultiModelSkirtFloats breastFloats");		//Modchu_Debug.mDebug("MultiModelSkirtFloats breastFloats this="+this);		//Modchu_Debug.mDebug("MultiModelSkirtFloats breastFloats breastFloatsModelRendererMap="+breastFloatsModelRendererMap);		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_breastFloats)				&& breastFloatsModelRendererMap != null				&& !breastFloatsModelRendererMap.isEmpty()); else return;		String[] breastNames = getBreastName();		if (breastNames != null				&& breastNames.length > 0); else return;		double maxBreastFloatsMotionY = getMaxBreastFloatsMotionY();		double minBreastFloatsMotionY = getMinBreastFloatsMotionY();		for (Entry<String, ModchuModel_ModelRenderer> en : breastFloatsModelRendererMap.entrySet()) {			ModchuModel_ModelRenderer modelRenderer = en.getValue();			double breastFloatsMotionY = getBreastFloatsMotionY(modelRenderer);			breastFloatsMotionY = Modchu_Main.normalize(breastFloatsMotionY, minBreastFloatsMotionY, maxBreastFloatsMotionY, minBreastFloatsMotionY, maxBreastFloatsMotionY);			modelRenderer.rotationPointY += breastFloatsMotionY;			//Modchu_Debug.mdDebug("MotionY="+motionY);			//Modchu_Debug.mDebug1("MultiModelSkirtFloats breastFloats this="+this+" motionY="+motionY);			//Modchu_Debug.mDebug("breastFloatsMotionY="+breastFloatsMotionY, 1);			//Modchu_Debug.mDebug("key="+en.getKey()+" modelRenderer="+modelRenderer+" modelRenderer.getBoxName()="+modelRenderer.getBoxName());		}	}	public double getMaxBreastFloatsMotionY() {		return 1.0D;	}	public double getMinBreastFloatsMotionY() {		return -2.0D;	}	public String[] getBreastName() {		return new String[]{ "breast" };	}	private boolean getSkirtFloats() {		return ModchuModel_ConfigData.skirtFloats;	}	private boolean getBreastFloats() {		return ModchuModel_ConfigData.breastFloats;	}	@Override	public Object getCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {		switch (pIndex) {		case caps_skirtFloats:			return getSkirtFloats();		case caps_breastFloats:			return getBreastFloats();		case caps_motionY:			return getMotionY();		case caps_skirtFloatsMotionY:			return getSkirtFloatsMotionY(pArg != null					&& pArg.length > 0 ? (ModchuModel_ModelRenderer) pArg[0] : null);		case caps_breastFloatsMotionY:			return getBreastFloatsMotionY(pArg != null			&& pArg.length > 0 ? (ModchuModel_ModelRenderer) pArg[0] : null);		}		return super.getCapsValue(entityCaps, pIndex, pArg);	}	@Override	public boolean setCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {		switch (pIndex) {		case caps_motionY:			if (pArg != null && pArg.length > 0 && pArg[0] != null) {				setMotionY((Double) pArg[0]);				return true;			}		}		return super.setCapsValue(entityCaps, pIndex, pArg);	}	protected double getMotionY() {		return motionY;	}	private void setMotionY(double f) {		motionY = f;	}	protected double getSkirtFloatsMotionY(ModchuModel_ModelRenderer modelRenderer) {		double d = getMotionY();		if (modelRenderer != null				&& modelRenderer.freeVariableContainsKey("skirtFloatsVolume")) {			d *= Modchu_CastHelper.Double(modelRenderer.getFreeVariable("skirtFloatsVolume"));		} else {			d *= ModchuModel_ConfigData.skirtFloatsVolume;		}		return d > 0.0F ? 0.0F : d;	}	protected double getBreastFloatsMotionY(ModchuModel_ModelRenderer modelRenderer) {		if (modelRenderer != null				&& modelRenderer.freeVariableContainsKey("breastFloatsVolume")) {			return getMotionY() * Modchu_CastHelper.Double(modelRenderer.getFreeVariable("breastFloatsVolume"));		}		return getMotionY() * ModchuModel_ConfigData.breastFloatsVolume;	}}