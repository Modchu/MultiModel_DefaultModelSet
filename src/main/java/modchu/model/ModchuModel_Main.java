package modchu.model;import java.io.File;import java.lang.reflect.Method;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Config;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EventSystem;import modchu.lib.Modchu_FileManager;import modchu.lib.Modchu_IEntityCapsBase;import modchu.lib.Modchu_IRenderLivingBase;import modchu.lib.Modchu_LMMManager;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.lib.Modchu_Version;import modchu.model.multimodel.base.MultiModelBaseBiped;import modchu.model.multimodel.base.MultiModel_Biped;import modchu.model.multimodel.base.MultiModel_Player;public class ModchuModel_Main {	public static final String version = "28a";	private static final int requestModchuLibVersion = 1502;	public static modc_ModchuModel baseModInstance;	public static Modchu_IRenderLivingBase renderPlayerDummyInstance;	public static final String modName = "ModchuModel";	public static final String versionString = ""+ Modchu_Version.getMinecraftVersion() + "-" + version;	public static String newVersion = "";	public static boolean isDev = false;	public static boolean isPFLMF = false;	public static boolean isFavBlock = false;	public static boolean isDecoBlock = false;	public static boolean isBTW = false;	public static boolean isSSP = false;	public static boolean isGulliver = false;	public static boolean isShaders = false;	public static boolean isShader = false;	public static boolean isSmartMoving = false;	public static boolean oldRender = false;	public static boolean initModsLoaded = false;	public static boolean newRelease = false;	private static boolean addRendererFlag;	public static HashMap<String, Object[]> checkModelsBox = new HashMap();	public static ArrayList<String> ngPlayerModelList = new ArrayList();	public static ArrayList<String> showModelList = new ArrayList();	private static Modchu_EventSystem eventSystem;	private static File mainCfgfile;	public static File cfgfile;	private static int initModsLoadedCount = 0;	private static final int maxInitModsLoadedCount = 6;	public static Method sizeMultiplier;	public static Class BipedClass;	public static Class BipedClass2;	public String getName() {		return modName;	}	public String getVersion() {		return versionString;	}	public static void load() {		Modchu_Debug.systemLogDebug("[ModchuModel_Main] 1 - (1 / 2) load()");		int i1 = Modchu_Main.getVersionStringConversionInt(Modchu_Main.lastIndexProcessing(Modchu_Main.getVersion(), "-"));		if (i1 < requestModchuLibVersion) {			Modchu_Debug.systemLogDebug("ModchuModel_Main ModchuLib Version is old !! VersionInt="+i1);			Modchu_Main.setRuntimeException("ModchuModel_Main ModchuLib Version is old !!");		} else {			Modchu_Debug.lDebug("ModchuModel_Main ModchuLib VersionInt="+i1);		}		//対応MOD導入チェック class直チェック		String className1[] = {				"net.minecraft.decoblock.DecoBlock", "net.minecraft.favstar.BlockFav", "EntityPlayerSP2", "net.minecraft.src.EntityPlayerSP2", "Shaders",				"Shader", "mod_SmartMovingMp"		};		String test2 = null;		for (int n = 0 ; n < className1.length ; n++){			try {				test2 = className1[n];				test2 = ""+Class.forName(test2);				Modchu_Debug.lDebug(test2 + " Check ok.");				if(n == 0) isDecoBlock = true;				if(n == 1) isFavBlock = true;				if(n == 2						| n == 3) {					try {						String s = className1[n];						if (s != null) {							Object o = Modchu_Reflect.getFieldObject(s, "armor", -1);							if (o != null) isSSP = true;						}					} catch(Exception e) {					}				}				if(n == 4) isShaders = true;				if(n == 5) isShader = true;				if(n == 6) isSmartMoving = true;			} catch (ClassNotFoundException e) {			}		}		isDev = Modchu_Main.checkDev("MultiModel_DefaultModelSet");		Modchu_Debug.mDebug("[ModchuModel_Main] load() isDev="+isDev);		mainCfgfile = new File(Modchu_Main.cfgdir, "ModchuModel.cfg");		cfgfile = new File(Modchu_Main.cfgdir, "ModchuModel_ShowModel.cfg");		loadcfg();		if (ModchuModel_ConfigData.versionCheck) startVersionCheckThread();		eventSystem = new Modchu_EventSystem("modchumodel");		Modchu_Debug.systemLogDebug("[ModchuModel_Main] 1 - (2 / 2) load() end.");	}	public static void modsLoaded() {		modsLoadedCountSetting();		if (initModsLoaded) return;		initModsLoadedCount = 0;		renderPlayerDummyInstance = (Modchu_IRenderLivingBase) Modchu_Main.newModchuCharacteristicObject("Modchu_RenderPlayerDummy", ModchuModel_RenderMasterBase.class);		//Modchu_Debug.lDebug("ModchuModel_Main loadInit() renderPlayerDummyInstance="+renderPlayerDummyInstance);		if (renderPlayerDummyInstance != null) {			Object master = Modchu_Main.getModchuCharacteristicObjectMaster(renderPlayerDummyInstance);			if (master != null) {				Modchu_Debug.lDebug("ModchuModel_Main addRenderer end. renderPlayerDummyInstance.master.getClass()="+master.getClass());			} else {				Modchu_Debug.systemLogDebug("ModchuModel_Main addRenderer end. renderPlayerDummyInstance.master == null !!", 2, null);				String s = "ModchuModel_Main addRenderer renderPlayerDummyInstance.master == null error !!";				Modchu_Main.setRuntimeException(s);				return;			}		} else {			Modchu_Debug.systemLogDebug("ModchuModel_Main addRenderer end. renderPlayerDummyInstance == null !!", 2, null);			String s = "ModchuModel_Main addRenderer renderPlayerDummyInstance == null error !!";			Modchu_Main.setRuntimeException(s);			return;		}		Modchu_AS.set(Modchu_AS.renderRenderManager, renderPlayerDummyInstance);		if (Modchu_Main.isForge) addRenderer(null);		// テクスチャパック、モデルの読み込み		Modchu_FileManager.getModFile("ModchuModel", "MultiModel");		modsLoadedCountSetting();		String[] s0 = Modchu_Main.getMinecraftVersion() > 159 ? new String[]{ "/assets/minecraft/textures/entity/littleMaid/",				"/assets/modchulib/textures/entity/littleMaid/"}		: new String[]{				"/assets/minecraft/textures/entity/littleMaid/",				"/assets/modchulib/textures/entity/littleMaid/",				"/mob/littleMaid/" };		ModchuModel_TextureManagerBase.instance.addSearch(new String[]{ "ModchuModel" }, s0,				new String[]{				"modchu.model.multimodel.base."+ModchuModel_TextureManagerBase.instance.modelClassName+"_",				"modchu.model.multimodel."+ModchuModel_TextureManagerBase.instance.modelClassName+"_",				ModchuModel_TextureManagerBase.instance.modelClassName+"_"				});		modsLoadedCountSetting();		// テクスチャパックの構築		ModchuModel_TextureManagerBase.instance.init();		modsLoadedCountSetting();		//Modchu_Debug.lDebug("ModchuModel_Main modsLoaded() "+initModsLoadedCount);		List list = Modchu_CastHelper.List(Modchu_Main.isForge ? Modchu_Reflect.invokeMethod("Loader", "getActiveModList", Modchu_Reflect.invokeMethod("Loader", "instance")) : Modchu_Reflect.invokeMethod("ModLoader", "getLoadedMods"));		String name = null;		if (list != null				&& !list.isEmpty()) {			for (Object o1 : list) {				name = Modchu_Main.isForge ? Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("ModContainer", "getName", o1)) : o1.getClass().getSimpleName();				//Modchu_Debug.mDebug("ModchuModel_Main modsLoaded getActiveModList name="+name);				if (name.equals("DecoBlock")) {					isDecoBlock = true;					Modchu_Debug.lDebug("[ModchuModel_Main] DecoBlock Check ok.");				}				else if (name.equals("FavBlock")) {					isFavBlock = true;					Modchu_Debug.lDebug("[ModchuModel_Main] FavBlock Check ok.");				}				else if (name.equals("FCBetterThanWolves")) {					isBTW = true;					Modchu_Debug.lDebug("[ModchuModel_Main] FCBetterThanWolves Check ok.");				}				else if (name.startsWith("SmartMoving")						| name.equals("mod_SmartMoving")) {					if (!Modchu_Main.isRelease()) {						isSmartMoving = true;						Modchu_Debug.lDebug("SmartMoving Check ok.");					}				}			}		}		if (Modchu_Main.isModUse("modchu.pflmf.modc_PFLMF")) {			isPFLMF = true;			Modchu_Debug.lDebug("[ModchuModel_Main] modc_PFLMF Check ok.");		} else {			Modchu_Debug.lDebug("[ModchuModel_Main] modc_PFLMF Check out.");		}		if (isSmartMoving) {			ModchuModel_ConfigData.skirtFloats = false;			ModchuModel_TextureManagerBase.instance.modelClassName = "MultiModelSmart";			BipedClass = Modchu_Reflect.loadClass("MultiModelSmart_Biped");			BipedClass2 = Modchu_Reflect.loadClass("MultiModelSmart_Player");			ModchuModel_TextureManagerBase.instance.addSearch(new String[]{ ModchuModel_TextureManagerBase.instance.modelClassName, "playerformlittlemaid" }, new String[]{ "/mob/littleMaid/" }, new String[]{ ModchuModel_TextureManagerBase.instance.modelClassName+"_" });		} else {			BipedClass = MultiModel_Biped.class;			BipedClass2 = MultiModel_Player.class;		}		modsLoadedCountSetting();		ModchuModel_ModelAddManager.addCustomModel();		modsLoadedCountSetting();		ModchuModel_ModelAddManager.lmmTextureManagerInit();		modsLoadedCountSetting();		sizeMultiplier = Modchu_Reflect.getMethod("Entity", "getSizeMultiplier", -1);		initModsLoaded = true;	}	private static void modsLoadedCountSetting() {		initModsLoadedCount++;		Modchu_Debug.systemLogDebug(new StringBuilder().append("[ModchuModel_Main] 2 - (").append(initModsLoadedCount).append(" / ").append(maxInitModsLoadedCount).append(") modsLoaded()").toString());	}	public static void addRenderer(Object map) {		Modchu_Debug.lDebug("ModchuModel_Main addRenderer");		if (addRendererFlag) return;		addRendererFlag = true;		Class c = Modchu_Main.getModchuCharacteristicClass("Modchu_EntityPlayerDummy");		if (c != null) Modchu_Main.addRenderer(c, renderPlayerDummyInstance);		else {			String s = "ModchuModel_Main addRenderer Modchu_EntityPlayerDummy.class == null error !!";			Modchu_Debug.systemLogDebug(s);			Modchu_Main.setRuntimeException(s);		}	}	public static void worldEventLoad(Object event) {		//Modchu_Debug.lDebug("ModchuModel_Main worldEventLoad ");		if (!initModsLoaded) Modchu_Main.setRuntimeException("ModchuModel_Main initModsLoaded error !! initModsLoadedCount="+initModsLoadedCount);		//Modchu_Debug.lDebug("ModchuModel_Main worldEventLoad 1");		ModchuModel_TextureManagerBase.instance.worldEventLoad(event);		//Modchu_Debug.lDebug("ModchuModel_Main worldEventLoad 2");		if (!Modchu_LMMManager.isLMM) return;		ModchuModel_ModelAddManager.worldEventLoad(event);	}	public static void loadcfg() {		// cfg読み込み		if (Modchu_Main.cfgdir.exists()) {			if (!mainCfgfile.exists()) {				// cfgファイルが無い = 新規作成				String s[] = {						"AlphaBlend=true", "skirtFloats=true", "skirtFloatsVolume=1.0D", "breastFloats=true", "breastFloatsVolume=1.0D",						"transparency=1.0F", "modchuRemodelingModel=true", "useInvisibilityBody=true", "useInvisibilityArmor=false", "useInvisibilityItem=false",						"versionCheck=true",  "debugCustomModelMessage=false", "modelForLittleMaidMob=true"				};				Modchu_Config.writerConfig(mainCfgfile, s);			} else {				// cfgファイルがある				ModchuModel_ConfigData.AlphaBlend = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "AlphaBlend", ModchuModel_ConfigData.AlphaBlend));				ModchuModel_ConfigData.skirtFloats = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "skirtFloats", ModchuModel_ConfigData.skirtFloats));				ModchuModel_ConfigData.skirtFloatsVolume = Modchu_CastHelper.Double(Modchu_Config.loadConfig(mainCfgfile, "skirtFloatsVolume", ModchuModel_ConfigData.skirtFloatsVolume));				ModchuModel_ConfigData.breastFloats = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "breastFloats", ModchuModel_ConfigData.breastFloats));				ModchuModel_ConfigData.breastFloatsVolume = Modchu_CastHelper.Double(Modchu_Config.loadConfig(mainCfgfile, "breastFloatsVolume", ModchuModel_ConfigData.breastFloatsVolume));				ModchuModel_ConfigData.transparency = Modchu_CastHelper.Float(Modchu_Config.loadConfig(mainCfgfile, "transparency", ModchuModel_ConfigData.transparency));				ModchuModel_ConfigData.modchuRemodelingModel = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "modchuRemodelingModel", ModchuModel_ConfigData.modchuRemodelingModel));				ModchuModel_ConfigData.useInvisibilityBody = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityBody", ModchuModel_ConfigData.useInvisibilityBody));				ModchuModel_ConfigData.useInvisibilityArmor = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityArmor", ModchuModel_ConfigData.useInvisibilityArmor));				ModchuModel_ConfigData.useInvisibilityItem = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityItem", ModchuModel_ConfigData.useInvisibilityItem));				ModchuModel_ConfigData.versionCheck = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "versionCheck", ModchuModel_ConfigData.versionCheck));				ModchuModel_ConfigData.modelForLittleMaidMob = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "modelForLittleMaidMob", ModchuModel_ConfigData.modelForLittleMaidMob));				Modchu_Debug.debugCustomModelMessage = Modchu_CastHelper.Boolean(Modchu_Config.loadConfig(mainCfgfile, "debugCustomModelMessage", Modchu_Debug.debugCustomModelMessage));				String k[] = {						"AlphaBlend", "skirtFloats", "skirtFloatsVolume", "breastFloats", "breastFloatsVolume",						"transparency", "modchuRemodelingModel", "useInvisibilityBody", "useInvisibilityArmor", "useInvisibilityItem",						"versionCheck", "debugCustomModelMessage", "modelForLittleMaidMob"				};				String k1[] = {						""+ModchuModel_ConfigData.AlphaBlend, ""+ModchuModel_ConfigData.skirtFloats, ""+ModchuModel_ConfigData.skirtFloatsVolume, ""+ModchuModel_ConfigData.breastFloats, ""+ModchuModel_ConfigData.breastFloatsVolume,						""+ModchuModel_ConfigData.transparency, ""+ModchuModel_ConfigData.modchuRemodelingModel, ""+ModchuModel_ConfigData.useInvisibilityBody, ""+ModchuModel_ConfigData.useInvisibilityArmor, ""+ModchuModel_ConfigData.useInvisibilityItem,						""+ModchuModel_ConfigData.versionCheck, ""+Modchu_Debug.debugCustomModelMessage, ""+ModchuModel_ConfigData.modelForLittleMaidMob				};				Modchu_Config.writerSupplementConfig(mainCfgfile, k, k1);			}			if (cfgfile.exists()) Modchu_Config.loadConfig(showModelList, cfgfile);		}		cfgMaxMinCheck();	}	public static void cfgMaxMinCheck() {		if (ModchuModel_ConfigData.skirtFloatsVolume < 0.0D) ModchuModel_ConfigData.skirtFloatsVolume = 0.0D;		if (ModchuModel_ConfigData.skirtFloatsVolume > 2.0D) ModchuModel_ConfigData.skirtFloatsVolume = 2.0D;		if (ModchuModel_ConfigData.breastFloatsVolume < 0.0D) ModchuModel_ConfigData.breastFloatsVolume = 0.0D;		if (ModchuModel_ConfigData.breastFloatsVolume > 2.0D) ModchuModel_ConfigData.breastFloatsVolume = 2.0D;		if (ModchuModel_ConfigData.transparency < 0.0F) ModchuModel_ConfigData.transparency = 0.0F;		if (ModchuModel_ConfigData.transparency > 1.0F) ModchuModel_ConfigData.transparency = 1.0F;	}	private static void startVersionCheckThread() {		ModchuModel_ThreadVersionCheck var0 = new ModchuModel_ThreadVersionCheck();		var0.start();	}	public static boolean checkRelease(String s) {		return Modchu_Main.compareToVersionString(s, versionString);	}	public static void setNewRelease(String s) {		newRelease = true;		newVersion = s;	}	public static void eventRegister(Object o) {		eventSystem.register(o);	}	public static void modchuLibEventUnRegister(Object o) {		eventSystem.unRegister(o);	}	public static boolean modchuLibEvent(String s) {		return eventSystem.isEvent(s);	}	public static Object[] modchuLibEvent(String s, Object[] o) {		return eventSystem.event(s, o);	}	public static int getCapsInt(String s) {		int i = 0;		i = (Integer) Modchu_Reflect.getFieldObject(Modchu_IEntityCapsBase.class, s);		if (i > 0) return i;		i = (Integer) Modchu_Reflect.getFieldObject(Modchu_IEntityCapsBase.class, s);		return i;	}	public static void reverseActionRequest(int i) {		reverseActionRequest(Modchu_AS.get(Modchu_AS.minecraftThePlayer), i);	}	public static void reverseActionRequest(Object entity, int i) {		int actionRequestNumber = getActionRequestNumber(entity, false);		boolean actionFlag = getActionFlag(entity);		Modchu_Debug.mDebug("ModchuModel_Main reverseActionRequest actionFlag="+actionFlag+" entity="+entity);		if (actionFlag				&& actionRequestNumber == i) {			setActionRequest(entity, new boolean[]{ true, false, false });			Modchu_Debug.mDebug("setActionRequest false.解除要求");		} else {			setActionRequestNumber(entity, i, false);			setActionRequest(entity, new boolean[]{ true, true, false });			Modchu_Debug.mDebug("setActionRequest true.実行要求");		}	}	public static boolean getActionFlag() {		return getActionFlag(false);	}	public static boolean getActionFlag(boolean b) {		return getActionFlag(Modchu_AS.get(Modchu_AS.minecraftThePlayer), b);	}	public static boolean getActionFlag(Object entity) {		return getActionFlag(entity, false);	}	public static boolean getActionFlag(Object entity, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) return modelData.getCapsValueBoolean(modelData.caps_actionFlag, b);		return false;	}	public static boolean[] getActionRequest() {		return getActionRequest(false);	}	public static boolean[] getActionRequest(boolean b) {		return getActionRequest(Modchu_AS.get(Modchu_AS.minecraftThePlayer), b);	}	public static boolean[] getActionRequest(Object entity) {		return getActionRequest(entity, false);	}	public static boolean[] getActionRequest(Object entity, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) return modelData.getCapsValueBooleanArray(modelData.caps_actionRequest);		return null;	}	public static void setActionRequest(boolean[] b) {		setActionRequest(Modchu_AS.get(Modchu_AS.minecraftThePlayer), b);	}	public static void setActionRequest(Object entity, boolean[] b) {		//Modchu_Debug.mDebug("ModchuModel_Main setActionRequest entity="+entity+" ThePlayer="+Modchu_AS.get(Modchu_AS.minecraftThePlayer));		//Modchu_Debug.mDebug("ModchuModel_Main setActionRequest b[0]="+b[0]);		Modchu_Debug.mDebug("ModchuModel_Main setActionRequest entity="+entity);		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		Modchu_Debug.mDebug("ModchuModel_Main setActionRequest modelData="+modelData);		if (modelData != null) modelData.setCapsValue(modelData.caps_actionRequest, b);	}	public static int getActionRequestNumber(Object entity) {		return getActionRequestNumber(Modchu_AS.get(Modchu_AS.minecraftThePlayer), false);	}	public static int getActionRequestNumber(Object entity, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) return modelData.getCapsValueInt(modelData.caps_actionRequestNumber, b);		return -1;	}	public static void setActionRequestNumber(int i) {		setActionRequestNumber(i, false);	}	public static void setActionRequestNumber(int i, boolean b) {		setActionRequestNumber(Modchu_AS.get(Modchu_AS.minecraftThePlayer), i, b);	}	public static void setActionRequestNumber(Object entity, int i) {		setActionRequestNumber(entity, i, false);	}	public static void setActionRequestNumber(Object entity, int i, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) modelData.setCapsValue(modelData.caps_actionRequestNumber, i, b);	}	public static int getActionReleaseNumber() {		return getActionReleaseNumber(false);	}	public static int getActionReleaseNumber(boolean b) {		return getActionReleaseNumber(Modchu_AS.get(Modchu_AS.minecraftThePlayer), b);	}	public static int getActionReleaseNumber(Object entity) {		return getActionReleaseNumber(entity, false);	}	public static int getActionReleaseNumber(Object entity, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) return modelData.getCapsValueInt(modelData.caps_actionReleaseNumber, b);		return -1;	}	public static void setActionReleaseNumber(int i) {		setActionReleaseNumber(i, false);	}	public static void setActionReleaseNumber(int i, boolean b) {		setActionReleaseNumber(Modchu_AS.get(Modchu_AS.minecraftThePlayer), i, b);	}	public static void setActionReleaseNumber(Object entity, int i) {		setActionReleaseNumber(entity, i, false);	}	public static void setActionReleaseNumber(Object entity, int i, boolean b) {		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entity);		if (modelData != null) modelData.setCapsValue(modelData.caps_actionReleaseNumber, i);	}	public static boolean isLMMModel(Object model) {		Class c = Modchu_LMMManager.getLMMAbstractModelBaseClass();		return c != null				&& c.isInstance(model);	}	public static boolean isPFLMModel(Object model) {		return model instanceof MultiModelBaseBiped;	}	public static boolean bipedCheck() {		return bipedCheck(Modchu_AS.get(Modchu_AS.minecraftThePlayer));	}	public static boolean bipedCheck(Object entityOrModel) {		if (entityOrModel != null); else return false;		if (Modchu_Reflect.loadClass("Entity").isInstance(entityOrModel)) {			ModchuModel_ModelDataBase data = ModchuModel_ModelDataMaster.instance.getPlayerData(entityOrModel);			if (data != null); else return false;			entityOrModel = data.models[0];		}		Object model = Modchu_Main.getModchuCharacteristicObjectMaster(entityOrModel);		boolean b = model != null				&& (BipedClass.isInstance(model)				| BipedClass2.isInstance(model));		//Modchu_Debug.mDebug("bipedCheck model="+model+" return "+b);		return b;	}}