package modchu.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Config;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.multimodel.MultiModelBaseBiped;

public class ModchuModel_Config extends Modchu_Config {
	public static ConcurrentHashMap<String, ConcurrentHashMap> configPartsMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configModelRendererMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configShowPartsNemeMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configShowPartsHideMap= new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configShowPartsRenemeMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configDefaultShowPartsMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configIndexOfAllSetVisibleMap = new ConcurrentHashMap();
	public static ConcurrentHashMap<String, ConcurrentHashMap> configIndexOfAllSetVisibleBooleanMap = new ConcurrentHashMap();
	public static boolean loadShowModelListInitFlag = false;
	private static String getConfigShowPartsHideMapFlagString;
	private static String getConfigShowPartsRenemeMapFlagString;

	public static ConcurrentHashMap<String, ConcurrentHashMap> getPartsMap() {
		return configPartsMap;
	}

	public static ConcurrentHashMap<String, Boolean> getConfigShowPartsMap(String s, int i, int i2) {
		if (configPartsMap != null) return configPartsMap.get(new StringBuilder().append(s).append(",").append(i).append(",").append(i2).toString());
		//Modchu_Debug.mDebug("getConfigShowPartsMap return null");
		return null;
	}

	public static int getConfigShowPartsMapBoolean(String s, String s1, int i, int i2) {
		if (configPartsMap != null) {
			ConcurrentHashMap<String, Boolean> map = configPartsMap.get(new StringBuilder().append(s).append(",").append(i).append(",").append(i2).toString());
			if (map != null
					&& map.containsKey(s1)) return map.get(s1) ? 1 : 0;
		}
		//Modchu_Debug.mDebug("getConfigShowPartsMapBoolean return false");
		return -1;
	}

	public static void setConfigShowPartsMap(String s, int i, int i2, ConcurrentHashMap<String, Boolean> map) {
		//Modchu_Debug.mDebug("setConfigShowPartsMap s="+s+" i="+i+" i2="+i2+" map="+(map != null));
		String s1 = new StringBuilder().append(s).append(",").append(i).append(",").append(i2).toString();
		if (map != null
				&& !map.isEmpty()) configPartsMap.put(s1, map);
		else if (configPartsMap.containsKey(s1)) configPartsMap.remove(s1);
		//Modchu_Debug.mDebug("setConfigShowPartsMap s="+s+" i="+i+" i2="+i2+" map.size()="+map.size());
	}

	public static ConcurrentHashMap<String, String> getConfigShowPartsRenemeMap(Object model, String s, int i) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configShowPartsRenemeMap != null
				&& configShowPartsRenemeMap.containsKey(s3)) {
			getConfigShowPartsRenemeMapFlagString = null;
			return configShowPartsRenemeMap.get(s3);
		}
		ConcurrentHashMap<String, String> renemeMap = null;
		boolean flag = getConfigShowPartsRenemeMapFlagString != null ? false : true;
		if (flag
				| (getConfigShowPartsRenemeMapFlagString != null
				&& !getConfigShowPartsRenemeMapFlagString.equals(s))) {
			if (model instanceof MultiModelBaseBiped) {
				ModchuModel_ModelDataBase data = ModchuModel_ModelDataMaster.instance.getPlayerData(Modchu_AS.get(Modchu_AS.minecraftThePlayer));
				((MultiModelBaseBiped) model).defaultPartsSettingBefore(data);
				renemeMap = (ConcurrentHashMap<String, String>) data.getCapsValue(((MultiModelBaseBiped) model).caps_showPartsRenemeMap);
				if (renemeMap != null) {
					setConfigShowPartsRenemeMap(model, s, i, renemeMap);
					getConfigShowPartsRenemeMapFlagString = null;
					return renemeMap;
				}
			}
			getConfigShowPartsRenemeMapFlagString = s;
		}
		renemeMap = new ConcurrentHashMap();
		setConfigShowPartsRenemeMap(model, s, i, renemeMap);
		return renemeMap;
	}

	public static void addConfigShowPartsRenemeMap(Object model, String s, int i, String[] s1, String[] s2) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<String, String> renemeMap = null;
		if (configShowPartsRenemeMap != null
				&& configShowPartsRenemeMap.containsKey(s3)) renemeMap = configShowPartsRenemeMap.get(s3);
		if (renemeMap != null) ;else renemeMap = new ConcurrentHashMap();
		for(int i1 = 0; i1 < s1.length && i1 < s2.length; i1++) {
			renemeMap.put(s1[i1], s2[i1]);
		}
		setConfigShowPartsRenemeMap(model, s, i, renemeMap);
	}

	public static void setConfigShowPartsRenemeMap(Object model, String s, int i, ConcurrentHashMap<String, String> map) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		configShowPartsRenemeMap.put(s3, map);
	}

	public static ConcurrentHashMap<Integer, String> getConfigShowPartsHideMap(Object model, String s, int i) {
		//Modchu_Debug.mDebug("getConfigShowPartsHideMap s="+s);
		if (model != null) ;else {
			//Modchu_Debug.mDebug("getConfigShowPartsHideMap model == null !!");
			return null;
		}
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<Integer, String> hideMap = null;
		if (configShowPartsHideMap != null
				&& configShowPartsHideMap.containsKey(s3)) {
			hideMap = configShowPartsHideMap.get(s3);
			if (!hideMap.isEmpty()) {
				//Modchu_Debug.mDebug("getConfigShowPartsHideMap containsKey ok. s="+s+" hideMap="+configShowPartsHideMap.get(s3));
				getConfigShowPartsHideMapFlagString = null;
				return hideMap;
			}
		}
		boolean flag = getConfigShowPartsHideMapFlagString != null ? false : true;
		if (flag
				| (getConfigShowPartsHideMapFlagString != null
				&& !getConfigShowPartsHideMapFlagString.equals(s3))) {
			Modchu_Debug.mDebug("getConfigShowPartsHideMap flag通過.");
			if (model instanceof MultiModelBaseBiped) {
				Modchu_Debug.mDebug("getConfigShowPartsHideMap MultiModelBaseBiped ok.");
				ModchuModel_ModelDataBase data = ModchuModel_ModelDataMaster.instance.getPlayerData(Modchu_AS.get(Modchu_AS.minecraftThePlayer));
				((MultiModelBaseBiped) model).defaultPartsSettingBefore(data);
				List<String> hideList = null;
				if (data != null) hideList = (List<String>) data.getCapsValue(((MultiModelBaseBiped) model).caps_showPartsHideList);
				if (hideList != null) {
					hideMap = new ConcurrentHashMap();
					for(int i1 = 0; i1 < hideList.size(); i1++) {
						hideMap.put(i1, hideList.get(i1));
					}
					setConfigShowPartsHideMap(model, s, i, hideMap);
					getConfigShowPartsHideMapFlagString = null;
					Modchu_Debug.mDebug("getConfigShowPartsHideMap s="+s+" hideMap="+hideMap);
					return hideMap;
				} else {
					Modchu_Debug.mDebug("getConfigShowPartsHideMap hideList == null !!");
				}
			} else {
				Modchu_Debug.mDebug("getConfigShowPartsHideMap MultiModelBaseBiped false!!");
			}
			getConfigShowPartsHideMapFlagString = s3;
		}
		Modchu_Debug.mDebug("getConfigShowPartsHideMap null. s="+s+" flag="+flag+" getConfigShowPartsHideMapFlagString ="+getConfigShowPartsHideMapFlagString+" getConfigShowPartsHideMapFlagString.equals(s3) ?"+(getConfigShowPartsHideMapFlagString.equals(s3)));
		hideMap = new ConcurrentHashMap();
		setConfigShowPartsHideMap(model, s, i, hideMap);
		return hideMap;
	}

	public static void addConfigShowPartsHideMap(Object model, String s, int i, List<String> hideList) {
		ConcurrentHashMap<Integer, String> map = getConfigShowPartsHideMap(model, s, i);
		int size = map.size();
		for(int i1 = 0; i1 < hideList.size(); i1++) {
			map.put(size + i1, hideList.get(i1));
		}
		setConfigShowPartsHideMap(model, s, i, map);
	}

	public static void addConfigShowPartsHideMap(Object model, String s, int i, String[] s1) {
		ConcurrentHashMap<Integer, String> map = getConfigShowPartsHideMap(model, s, i);
		int size = map.size();
		for(int i1 = 0; i1 < s1.length; i1++) {
			map.put(size + i1, s1[i1]);
		}
		setConfigShowPartsHideMap(model, s, i, map);
	}

	public static void setConfigShowPartsHideMap(Object model, String s, int i, ConcurrentHashMap<Integer, String> hideMap) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		configShowPartsHideMap.put(s3, hideMap);
	}

	public static ConcurrentHashMap<Integer, String> getConfigShowPartsNemeMap(String s, int i) {
		if (s != null) ;else return null;
		//Modchu_Debug.mDebug("getConfigShowPartsNemeMap s="+s+" i="+i);
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<Integer, String> map = null;
		if (configShowPartsNemeMap != null
				&& configShowPartsNemeMap.containsKey(s1)) {
			//Modchu_Debug.mDebug("getConfigShowPartsNemeMap containsKey ok. configShowPartsNemeMap.get(s1)="+configShowPartsNemeMap.get(s1));
			return configShowPartsNemeMap.get(s1);
		}
		Object[] textureModel = ModchuModel_Main.modelNewInstance(null, s, true, false);
		if (textureModel != null) {
			int i1 = 0;
			switch(i) {
			case 0:
				i1 = 0;
				break;
			case 1:
				i1 = 1;
				break;
			case 2:
				i1 = 2;
				break;
			}
			Object model = textureModel[i1];
			Class multiModelCustom = Modchu_Reflect.loadClass("MultiModelCustom");
			if (multiModelCustom != null
					&& multiModelCustom.isInstance(model)) model = Modchu_Reflect.getFieldObject(multiModelCustom, "customModel", model);
			if (model != null) {
				showPartsSetting(model, s, i);
				if (configShowPartsNemeMap != null
						&& configShowPartsNemeMap.containsKey(s1)) {
					//Modchu_Debug.mDebug("getConfigShowPartsNemeMap containsKey ok2. configShowPartsNemeMap.get(s1)="+configShowPartsNemeMap.get(s1));
					return configShowPartsNemeMap.get(s1);
				}
			}
		}
		//Modchu_Debug.mDebug("getConfigShowPartsNemeMap return null");
		return null;
	}

	public static void setConfigShowPartsNemeMap(String s, int i, ConcurrentHashMap<Integer, String> map) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		configShowPartsNemeMap.put(s3, map);
	}

	public static void showPartsSetting(Object model, String s, int i) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap();
		ConcurrentHashMap<String, Field> modelRendererMap1 = new ConcurrentHashMap();
		Field[] fields = model.getClass().getFields();
		String s1;
		int k = 0;
		for (int i1 = 0; i1 < fields.length; i1++) {
			//Modchu_Debug.mDebug("showPartsSetting fields["+i1+"].getType() = "+fields[i1].getType());
			Object o;
			try {
				o = fields[i1].get(model);
				if (Modchu_ModelRenderer.class.isInstance(o)) {
					//Modchu_Debug.mDebug("PFLM_Config showPartsSetting ModchuModel_ModelRenderer.class.isInstance fields["+i1+"].getType() = "+fields[i1].getType());
					try {
						s1 = fields[i1].getName();
						map.put(k, s1);
						modelRendererMap1.put(s1, fields[i1]);
						//Modchu_Debug.mmlDebug("PFLM_Config showPartsSetting put s1="+s1+" fields["+i1+"].getType() = "+fields[i1].getType());
						//Modchu_Debug.mmlDebug("PFLM_Config showPartsSetting put s1="+s1+" o.showModel="+((ModchuModel_ModelRenderer) o).showModel);
					} catch (Exception e) {
					}
					k++;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		setConfigShowPartsNemeMap(s, i, map);
		setConfigModelRendererMap(s, i, modelRendererMap1);
	}

	public static ConcurrentHashMap<String, Boolean> getDefaultShowPartsMap(String s, int i) {
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configDefaultShowPartsMap != null
				&& configDefaultShowPartsMap.containsKey(s1)) return configDefaultShowPartsMap.get(s1);
		return null;
	}

	public static boolean getDefaultShowPartsMapBoolean(String s, String s1, int i) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configDefaultShowPartsMap != null
				&& configDefaultShowPartsMap.containsKey(s2)) {
			ConcurrentHashMap<String, Boolean> defaultShowPartsMap = configDefaultShowPartsMap.get(s2);
			if (defaultShowPartsMap != null
					&& defaultShowPartsMap.containsKey(s1)) return defaultShowPartsMap.get(s1);
		}
		return true;
	}

	public static void putDefaultShowPartsMap(String s, String s1, int i, boolean b) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<String, Boolean> defaultShowPartsMap = null;
		if (configDefaultShowPartsMap != null
				&& configDefaultShowPartsMap.containsKey(s2)) {
			defaultShowPartsMap = configDefaultShowPartsMap.get(s2);
		} else defaultShowPartsMap = new ConcurrentHashMap();
		defaultShowPartsMap.put(s1, b);
		configDefaultShowPartsMap.put(s2, defaultShowPartsMap);
		//Modchu_Debug.mDebug("putDefaultShowPartsMap s1="+s1+" b="+b);
	}

	public static ConcurrentHashMap<String, Field> getConfigModelRendererMap(Object model, String s, int i) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configModelRendererMap != null
				&& configModelRendererMap.containsKey(s3)) return configModelRendererMap.get(s3);
		showPartsSetting(model, s, i);
		if (configModelRendererMap != null
				&& configModelRendererMap.containsKey(s3)) return configModelRendererMap.get(s3);
		Modchu_Debug.mDebug("getConfigModelRendererMap return null");
		return null;
	}

	public static void setConfigModelRendererMap(String s, int i, ConcurrentHashMap<String, Field> map) {
		String s3 = new StringBuilder().append(s).append(",").append(i).toString();
		configModelRendererMap.put(s3, map);
	}

	public static ConcurrentHashMap<String, ConcurrentHashMap> getConfigShowPartsNemeMap() {
		return configShowPartsNemeMap;
	}

	public static ConcurrentHashMap<String, ConcurrentHashMap> getIndexOfAllSetVisibleMap() {
		return configIndexOfAllSetVisibleMap;
	}

	public static ConcurrentHashMap<String, List<String>> getIndexOfAllSetVisibleMap(String s, int i) {
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configIndexOfAllSetVisibleMap != null
				&& configIndexOfAllSetVisibleMap.containsKey(s1)) return configIndexOfAllSetVisibleMap.get(s1);
		ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap();
		setIndexOfAllSetVisibleMap(s, i, map);
		return map;
	}

	public static List<String> getIndexOfAllSetVisibleMap(String s, String s1, int i) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configIndexOfAllSetVisibleMap != null
				&& configIndexOfAllSetVisibleMap.containsKey(s2)) {
			ConcurrentHashMap<String, List<String>> map = configIndexOfAllSetVisibleMap.get(s2);
			if (map != null
					&& map.containsKey(s1)) return map.get(s1);
		}
		List<String> list = new ArrayList();
		setIndexOfAllSetVisibleMap(s, s1, i, list);
		return list;
	}

	public static void setIndexOfAllSetVisibleMap(String s, int i, ConcurrentHashMap<String, List<String>> map) {
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		configIndexOfAllSetVisibleMap.put(s1, map);
	}

	public static void setIndexOfAllSetVisibleMap(String s, String s1, int i, List<String> list) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<String, List<String>> map = null;
		if (configIndexOfAllSetVisibleMap != null
				&& configIndexOfAllSetVisibleMap.containsKey(s2)) {
			map = configIndexOfAllSetVisibleMap.get(s2);
		}
		if (map != null) ;else map = new ConcurrentHashMap();
		if (list != null
				&& !list.isEmpty()) {
			map.put(s1, list);
			configIndexOfAllSetVisibleMap.put(s2, map);
		} else {
			if (configIndexOfAllSetVisibleMap.containsKey(s2)) configIndexOfAllSetVisibleMap.remove(s2);
		}
	}

	public static ConcurrentHashMap<String, ConcurrentHashMap> getIndexOfAllSetVisibleBooleanMap() {
		return configIndexOfAllSetVisibleBooleanMap;
	}

	public static ConcurrentHashMap<String, Boolean> getIndexOfAllSetVisibleBooleanMap(String s, int i) {
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configIndexOfAllSetVisibleBooleanMap != null
				&& configIndexOfAllSetVisibleBooleanMap.containsKey(s1)) return configIndexOfAllSetVisibleBooleanMap.get(s1);
		ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap();
		setIndexOfAllSetVisibleBooleanMap(s, i, map);
		return map;
	}

	public static int getIndexOfAllSetVisibleBooleanMap(String s, String s1, int i) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		if (configIndexOfAllSetVisibleBooleanMap != null
				&& configIndexOfAllSetVisibleBooleanMap.containsKey(s2)) {
			ConcurrentHashMap<String, Boolean> map = configIndexOfAllSetVisibleBooleanMap.get(s2);
			if (map != null
					&& map.containsKey(s1)) return map.get(s1) == true ? 1 : 0;
		}
		return -1;
	}

	public static void setIndexOfAllSetVisibleBooleanMap(String s, int i, ConcurrentHashMap<String, Boolean> map) {
		String s1 = new StringBuilder().append(s).append(",").append(i).toString();
		configIndexOfAllSetVisibleBooleanMap.put(s1, map);
	}

	public static void setIndexOfAllSetVisibleBooleanMap(String s, String s1, int i, boolean b) {
		String s2 = new StringBuilder().append(s).append(",").append(i).toString();
		ConcurrentHashMap<String, Boolean> map = null;
		if (configIndexOfAllSetVisibleBooleanMap != null
				&& configIndexOfAllSetVisibleBooleanMap.containsKey(s2)) {
			map = configIndexOfAllSetVisibleBooleanMap.get(s2);
		}
		if (map != null) ;else map = new ConcurrentHashMap();
		map.put(s1, b);
		configIndexOfAllSetVisibleBooleanMap.put(s2, map);
	}

}