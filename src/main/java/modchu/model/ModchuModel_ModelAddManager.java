package modchu.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_FileManager;
import modchu.lib.Modchu_LMMManager;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.Modchu_Version;
import modchu.model.multimodel.base.MultiModel;
import modchu.model.multimodel.base.MultiModelBaseBiped;
import modchu.model.multimodel.base.MultiModelCustom;
import modchu.model.multimodel.base.MultiModelOtherModel;

public class ModchuModel_ModelAddManager {
	public static final String addLmmModelString = ";lmmModel";

	static void addCustomModel() {
		Modchu_Debug.mDebug("ModchuModel_Main addCustomModel()");
		File cfgdir = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), "/config/CustomModel/");
		ModchuModel_CustomModel.sampleCfgCopy();
		if (!cfgdir.exists()) {
			Modchu_Debug.systemLogDebug("ModchuModel_Main addCustomModel() cfgdir not found !! cfgdir="+cfgdir);
			return;
		}
		ArrayList<File> list = Modchu_FileManager.listFiles(cfgdir.getAbsolutePath(), "*.cfg", null, "CustomModel_", true);
		if (list != null
				&& !list.isEmpty()) {
			Modchu_Debug.mDebug("ModchuModel_Main addCustomModel() list != null");
			for (File f : list) {
				String name = Modchu_Main.lastIndexProcessing(f.getName(), "_");
				addPflmAndLmmCustomModel(name);
			}
		}
		addOtherCustomModel();
		Modchu_Debug.mDebug("ModchuModel_Main addCustomModel() end.");
	}

	private static void addPflmAndLmmCustomModel(String name) {
		if (name != null
				&& !name.isEmpty()); else return;
		try {
			int i1 = name.indexOf(".");
			if (i1 > -1) name = name.substring(0, i1);
			Modchu_Debug.mDebug("ModchuModel_Main addPflmAndLmmCustomModel() name="+name);
			ModchuModel_TextureBoxBase mtb = ModchuModel_TextureManagerBase.instance.textures.get("default_Custom");
			if (mtb != null); else return;
			ModchuModel_TextureBoxBase mtb2 = mtb.duplicate();
			String s1 = "default_Custom"+name;
			mtb2.fileName = s1;
			mtb2.textureName = s1;
			ModchuModel_TextureManagerBase.instance.textures.put(s1, mtb2);
			ModchuModel_TextureManagerBase.instance.modelClassNameMap.put("Custom"+name, MultiModelCustom.class.getName());
			Modchu_Debug.mlDebug("addPflmTextureManagerModel modelMap.put modelName=Custom"+name);
			if (!addLMMModelFlag()) return;
			MultiModelBaseBiped[] mlm2 = new MultiModelBaseBiped[3];
			Object[] o0 = new Object[]{ name };
			mlm2[0] = new MultiModelCustom(0.0F, 0.0F, 64, 32, o0);
			float[] lsize2 = mlm2[0].getArmorModelsSize();
			mlm2[1] = new MultiModelCustom(lsize2[0], 0.0F, 64, 32, o0);
			mlm2[2] = new MultiModelCustom(lsize2[1], 0.0F, 64, 32, o0);
			Modchu_Debug.mDebug("ModchuModel_Main addPflmAndLmmCustomModel() mlm2[0]="+mlm2[0]);
			String s0 = "Custom"+name;
			addLmmTextureManagerModel(s0, MultiModelCustom.class, mlm2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void addOtherCustomModel() {
		ArrayList<File> list = Modchu_FileManager.listFiles(Modchu_Main.modsDir.getAbsolutePath(), "*.zip", null, "MultiModelOtherCustomModel", false);
		list.addAll(Modchu_FileManager.listFiles(new File(Modchu_Main.modsDir, Modchu_Version.getMinecraftVersionString()).getAbsolutePath(), "*.zip", null, "MultiModelOtherCustomModel", true));
		if (list != null
				&& !list.isEmpty()) {
			ZipFile zipFile = null;
			InputStream inputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader breader = null;
			try {
				for (File file1 : list) {
					//String s = file1.toString();
					String s = file1.getAbsolutePath();
					zipFile = null;
					try {
						zipFile = new ZipFile(s);
					} catch (Exception e) {
						Modchu_Debug.lDebug("ModchuModel_Main addCustomModel() Exception !! s="+s, 2, e);
						e.printStackTrace();
						continue;
					}
					//Modchu_Debug.mlDebug("ModchuModel_Main addCustomModel() zipFile="+zipFile);
					for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
						ZipEntry entry = e.nextElement();
						String name = entry.getName();
						if (entry.isDirectory()
								| name.lastIndexOf(".cfg") < 0) continue;
						Modchu_Debug.mlDebug(name);
						inputStream = zipFile.getInputStream(entry);
						inputStreamReader = new InputStreamReader(zipFile.getInputStream(entry));
						breader = new BufferedReader(inputStreamReader);
						String rl;
						HashMap<String, Object> tempMap = new HashMap();
						while ((rl = breader.readLine()) != null) {
							addOtherCustomModelSetting(rl, tempMap);
						}
						tempMap = null;
					}
					zipFile.close();
					zipFile = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (zipFile != null) zipFile.close();
				} catch (Exception e) {
				}
				try {
					if (inputStream != null) inputStream.close();
				} catch (Exception e) {
				}
				try {
					if (breader != null) breader.close();
				} catch (Exception e) {
				}
				try {
					if (inputStreamReader != null) inputStreamReader.close();
				} catch (Exception e) {
				}
			}
		}
	}

	private static void addOtherCustomModelSetting(String s, HashMap<String, Object> tempMap) {
		boolean debug = false;
		//if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() s="+s);
		s = s.replaceAll(" ", "");
		s = s.replaceAll("	", "");
		String[] s0 = s.split("=");
		if (s0 != null
				&& s0.length > 0
				&& !s0[0].isEmpty()); else {
			if (tempMap.containsKey("tempOtherCustomModelTextureName")
					&& tempMap.containsKey("tempOtherCustomModelName")
					&& tempMap.containsKey("tempOtherCustomModelClassName")) {
				Object[] o = pflmAddTempOtherCustomModel(tempMap);
				//if (o != null) lmmAddTempOtherCustomModel(o);
			}
			return;
		}
		String s1 = s0[0];
		String s2 = s0.length > 1 ? s0[1] : null;
		if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() s1="+s1+" s2="+s2);
		if (s1.equals("name")) {
			tempMap.put("tempOtherCustomModelName", s2);
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelName="+s0);
			return;
		}
		if (s1.equals("modelsize")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0) {
				tempMap.put("tempOtherCustomModelSize", Modchu_Main.stringArrayToFloatArray(s3));
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() modelsize s1[0]="+s3[0]);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() else !! modelsize s1="+s3);
			}
			return;
		}
		if (s1.equals("model")) {
			tempMap.put("tempOtherCustomModelClassName", s2);
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelClassName="+s2);
			return;
		}
		if (s1.startsWith("armorModel")) {
			int i = Modchu_CastHelper.Int(Modchu_Main.lastIndexProcessing(s1, "armorModel"));
			tempMap.put("tempOtherCustomModelArmorClassName"+i, s2);
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelArmorClassName"+i+"="+s2);
			return;
		}
		if (s1.equals("renderDummyEntityInvokeMethod")) {
			ArrayList list = tempMap.containsKey("tempOtherCustomModelRenderDummyEntityInvokeMethod") ? Modchu_CastHelper.ArrayList(tempMap.get("tempOtherCustomModelRenderDummyEntityInvokeMethod")) : new ArrayList();
			list.add(s2);
			tempMap.put("tempOtherCustomModelRenderDummyEntityInvokeMethod", list);
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelRenderDummyEntityInvokeMethod="+s2);
			return;
		}
		if (s1.equals("renderDummyEntity")) {
			tempMap.put("tempOtherCustomModelRenderDummyEntity", s2);
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() renderDummyEntity s2="+s2);
			return;
		}
		if (s1.equals("defaultScale")) {
			tempMap.put("tempOtherCustomModelDefaultScale", Modchu_CastHelper.Float(s2));
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelDefaultScale="+s2);
			return;
		}
		if (s1.equals("guiViewScale")) {
			tempMap.put("tempOtherCustomModelGuiViewScale", Modchu_CastHelper.Float(s2));
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelGuiViewScale="+s2);
			return;
		}
		if (s1.equals("guiPositionCorrection")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0) {
				tempMap.put("tempOtherCustomModelGuiPositionCorrection", Modchu_Main.stringArrayToFloatArray(s3));
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelGuiPositionCorrection="+s3);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() else !! tempOtherCustomModelGuiPositionCorrection s1="+s3);
			}
			return;
		}
		if (s1.equals("positionCorrection")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0) {
				tempMap.put("tempOtherCustomModelPositionCorrection", Modchu_Main.stringArrayToFloatArray(s3));
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelPositionCorrection="+s3);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() positionCorrection s1="+s3);
			}
			return;
		}
		if (s1.equals("texture")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0) {
				String[] s4 = new String[16];
				for (int i1 = 0; i1 < 16; i1++) {
					s4[i1] = i1 < s3.length ? s3[i1] : s3[0];
					if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() s2["+i1+"]="+s4[i1]);
				}
				tempMap.put("tempOtherCustomModelTextureName", s4);
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelTextureName="+s4);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelTextureName s1="+s3);
			}
			return;
		}
		if (s1.equals("armorTexture")) {
			if (s2.indexOf(",") > -1) {
				String[] s3 = s2.split(",");
				tempMap.put("tempOtherCustomModelArmorTextureName", s3);
			} else {
				tempMap.put("tempOtherCustomModelArmorTextureName", new String[]{ s2 });
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelArmorTextureName="+s2);
			}
			return;
		}
		if (s1.equals("isChild")) {
			tempMap.put("tempOtherCustomModelIsChild", Modchu_CastHelper.Boolean(s2));
			if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomModelIsChild="+Modchu_CastHelper.Boolean(s2));
			return;
		}
		if (s1.equals("otherConstructorObject")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0
					&& tempMap.containsKey("tempOtherCustomOtherConstructor")) {
				Object[] o = Modchu_Main.stringArrayToObjectArray(s3, Modchu_CastHelper.ClassArray(tempMap.get("tempOtherCustomOtherConstructor")));
				tempMap.put("tempOtherCustomOtherConstructorObject", o);
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomOtherConstructorObject="+o);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() else !! tempOtherCustomOtherConstructorObject s1="+s3+" tempMap.containsKey="+tempMap.containsKey("tempOtherCustomOtherConstructor"));
			}
			return;
		}
		if (s1.equals("otherConstructor")) {
			String[] s3 = s2.split(",");
			if (s3 != null
					&& s3.length > 0) {
				tempMap.put("tempOtherCustomOtherConstructor", Modchu_Main.stringArrayToClassArray(s3));
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() tempOtherCustomOtherConstructor="+s3);
			} else {
				if (debug) Modchu_Debug.lDebug("addOtherCustomModelSetting() else !! tempOtherCustomOtherConstructor s1="+s3);
			}
			return;
		}
	}

	private static Object[] pflmAddTempOtherCustomModel(HashMap<String, Object> tempMap) {
		boolean debug = false;
		String tempOtherCustomModelName = Modchu_CastHelper.String(tempMap.get("tempOtherCustomModelName"));
		String[] tempOtherCustomModelTextureName = Modchu_CastHelper.StringArray(tempMap.get("tempOtherCustomModelTextureName"));
		String[] tempOtherCustomModelArmorTextureName = Modchu_CastHelper.StringArray(tempMap.containsKey("tempOtherCustomModelArmorTextureName") ? tempMap.get("tempOtherCustomModelArmorTextureName") : null);
		String tempOtherCustomModelClassName = Modchu_CastHelper.String(tempMap.get("tempOtherCustomModelClassName"));
		String tempOtherCustomModelArmorClassName0 = Modchu_CastHelper.String(tempMap.containsKey("tempOtherCustomModelArmorClassName0") ? tempMap.get("tempOtherCustomModelArmorClassName0") : null);
		if (debug) Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() tempOtherCustomModelArmorClassName0="+tempOtherCustomModelArmorClassName0);
		String tempOtherCustomModelArmorClassName1 = Modchu_CastHelper.String(tempMap.containsKey("tempOtherCustomModelArmorClassName1") ? tempMap.get("tempOtherCustomModelArmorClassName1") : null);
		String tempOtherCustomModelRenderDummyEntity = Modchu_CastHelper.String(tempMap.containsKey("tempOtherCustomModelRenderDummyEntity") ? tempMap.get("tempOtherCustomModelRenderDummyEntity") : null);
		ArrayList tempOtherCustomModelRenderDummyEntityInvokeMethod = Modchu_CastHelper.ArrayList(tempMap.containsKey("tempOtherCustomModelRenderDummyEntityInvokeMethod") ? tempMap.get("tempOtherCustomModelRenderDummyEntityInvokeMethod") : null);
		Class[] tempOtherCustomOtherConstructor = Modchu_CastHelper.ClassArray(tempMap.containsKey("tempOtherCustomOtherConstructor") ? tempMap.get("tempOtherCustomOtherConstructor") : null);
		Object[] tempOtherCustomOtherConstructorObject = Modchu_CastHelper.ObjectArray(tempMap.containsKey("tempOtherCustomOtherConstructorObject") ? tempMap.get("tempOtherCustomOtherConstructorObject") : null);
		float[] tempOtherCustomModelSize = Modchu_CastHelper.FloatArray(tempMap.containsKey("tempOtherCustomModelSize") ? tempMap.get("tempOtherCustomModelSize") : new float[]{ 0.0F, 0.0F, 0.0F });
		float[] tempOtherCustomModelPositionCorrection = Modchu_CastHelper.FloatArray(tempMap.containsKey("tempOtherCustomModelPositionCorrection") ? tempMap.get("tempOtherCustomModelPositionCorrection") : new float[]{ 0.0F, 0.0F, 0.0F });
		float[] tempOtherCustomModelGuiPositionCorrection = Modchu_CastHelper.FloatArray(tempMap.containsKey("tempOtherCustomModelGuiPositionCorrection") ? tempMap.get("tempOtherCustomModelGuiPositionCorrection") : tempOtherCustomModelPositionCorrection);
		float tempOtherCustomModelDefaultScale = Modchu_CastHelper.Float(tempMap.containsKey("tempOtherCustomModelDefaultScale") ? tempMap.get("tempOtherCustomModelDefaultScale") : 1.0F);
		float tempOtherCustomModelGuiViewScale = Modchu_CastHelper.Float(tempMap.containsKey("tempOtherCustomModelGuiViewScale") ? tempMap.get("tempOtherCustomModelGuiViewScale") : 1.0F);
		boolean tempOtherCustomModelIsChild = Modchu_CastHelper.Boolean(tempMap.containsKey("tempOtherCustomModelIsChild") ? tempMap.get("tempOtherCustomModelIsChild") : true);

		String fileName = "other_Custom"+ tempOtherCustomModelName;
		ModchuModel_TextureBoxBase mtb = new ModchuModel_TextureBoxBase();
		mtb.fileName = fileName;
		mtb.textureName = fileName;
		if (debug) Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() mtb.textureName="+mtb.textureName);
		String name = fileName;
		int i1 = name.indexOf("_");
		mtb.packegeName = i1 > -1 ? name.substring(0, i1) : name;
		mtb.textures = new HashMap();
		for (int i = 0; i < 16; i++) {
			mtb.textures.put(i, Modchu_Main.newResourceLocation(tempOtherCustomModelTextureName[i]));
		}
		mtb.armors = new TreeMap();
		if (tempOtherCustomModelArmorTextureName != null) {
			Modchu_Debug.lDebug("pflmAddTempOtherCustomModel tempOtherCustomModelArmorTextureName != null");
			Map<Integer, Object> map = new HashMap();
			if (tempOtherCustomModelArmorTextureName.length > 0
					&& tempOtherCustomModelArmorTextureName[0] != null
					&& !tempOtherCustomModelArmorTextureName[0].isEmpty()) {
				map.put(ModchuModel_TextureManagerBase.tx_armor1, Modchu_Main.newResourceLocation(tempOtherCustomModelArmorTextureName[0]));
				Modchu_Debug.lDebug("pflmAddTempOtherCustomModel map.put tx_armor1 tempOtherCustomModelArmorTextureName[0]="+tempOtherCustomModelArmorTextureName[0]);
			}
			if (tempOtherCustomModelArmorTextureName.length > 1
					&& tempOtherCustomModelArmorTextureName[1] != null
					&& !tempOtherCustomModelArmorTextureName[1].isEmpty()) {
				map.put(ModchuModel_TextureManagerBase.tx_armor2, Modchu_Main.newResourceLocation(tempOtherCustomModelArmorTextureName[1]));
				Modchu_Debug.lDebug("pflmAddTempOtherCustomModel map.put tx_armor2 tempOtherCustomModelArmorTextureName[1]="+tempOtherCustomModelArmorTextureName[1]);
			}
			mtb.armors.put("default", map);
		}
		mtb.modelName = i1 > -1 ? name.substring(i1 + 1) : name;
		//ltb1.textureDir = null;
		Object[] o1 = ModchuModel_TextureManagerBase.instance.newOtherModel(tempOtherCustomModelClassName, tempOtherCustomModelArmorClassName0, tempOtherCustomModelArmorClassName1, tempOtherCustomOtherConstructor, tempOtherCustomOtherConstructorObject, tempOtherCustomModelSize, tempOtherCustomModelIsChild);
		if (o1 != null); else {
			Modchu_Debug.systemLogDebug("pflmAddTempOtherCustomModel() new model failure !! tempOtherCustomModelClassName="+tempOtherCustomModelClassName);
			return null;
		}
		if (debug) {
			Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() o1="+o1);
			Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() o1[0]="+o1[0]);
			Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() o1[1]="+o1[1]);
			Modchu_Debug.lDebug("pflmAddTempOtherCustomModel() o1[2]="+o1[2]);
		}
		HashMap<String, Object> map = new HashMap();
		if (tempOtherCustomModelPositionCorrection != null
				&& tempOtherCustomModelPositionCorrection.length > 2) {
			map.put("positionCorrection", tempOtherCustomModelPositionCorrection);
		}
		if (tempOtherCustomModelGuiPositionCorrection != null
				&& tempOtherCustomModelGuiPositionCorrection.length > 2) {
			map.put("guiPositionCorrection", tempOtherCustomModelGuiPositionCorrection);
		}
		if (tempOtherCustomModelDefaultScale != 1.0F) map.put("defaultScale", tempOtherCustomModelDefaultScale);
		if (tempOtherCustomModelGuiViewScale != 1.0F) map.put("guiViewScale", tempOtherCustomModelGuiViewScale);
		if (tempOtherCustomModelRenderDummyEntity != null) map.put("renderDummyEntity", tempOtherCustomModelRenderDummyEntity);
		if (tempOtherCustomModelRenderDummyEntityInvokeMethod != null) map.put("renderDummyEntityInvokeMethod", tempOtherCustomModelRenderDummyEntityInvokeMethod);
		MultiModelOtherModel[] o2 = ModchuModel_TextureManagerBase.instance.newMultiModelOtherModel(o1, map);
		ModchuModel_TextureManagerBase.instance.textures.put(mtb.textureName, mtb);
		ModchuModel_TextureManagerBase.instance.otherModelDataMap.put(Modchu_Main.lastIndexProcessing(fileName, "_"), new Object[]{ tempMap.clone(), map.clone() });
		//addPflmAndLmmCustomModel(tempOtherCustomModelName);
		tempMap.clear();
		return new Object[]{ mtb, o2 };
	}

	private static void lmmAddTempOtherCustomModel(Object[] o) {
		if (addLMMModelFlag()
				&& o != null); else return;
		boolean debug = false;
		ModchuModel_TextureBoxBase mtb = (ModchuModel_TextureBoxBase) o[0];
		Object[] models = (Object[]) o[1];
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() mtb.fileName="+mtb.fileName);
		Object ltb = Modchu_LMMManager.newModchu_LmmTextureBox(mtb);
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() ltb="+ltb);
		if (ltb != null); else {
			Modchu_Debug.systemLogDebug("lmmAddTempOtherCustomModel() ltb == null !! mtb="+mtb+" mtb.fileName="+mtb.fileName);
			String Modchu_LmmTextureBoxString = Modchu_Main.getModchuCharacteristicClassName(Modchu_LMMManager.getModchuLmmTextureBoxString());
			Modchu_Debug.systemLogDebug("lmmAddTempOtherCustomModel() Modchu_LmmTextureBox class="+(Modchu_Reflect.loadClass(Modchu_LmmTextureBoxString)));
			return;
		}
		if (models != null); else {
			Modchu_Debug.systemLogDebug("lmmAddTempOtherCustomModel() models == null !! return");
			return;
		}
		Object[] o1 = Modchu_Reflect.newInstanceArray(Modchu_LMMManager.getLMMModelMultiBaseClass(), 3);
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() o1="+o1);
		Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() ModchuLmmModel="+ModchuLmmModel);
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() models[0].getClass()="+models[0].getClass());
		o1[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ models[0].getClass(), 0.0F });
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() o1[0]="+o1[0]);
		float[] f1 = (float[]) Modchu_Reflect.invokeMethod(o1[0].getClass(), "getArmorModelsSize", o1[0]);
		if (f1 != null) {
			o1[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ models[0].getClass(), f1[0] });
			o1[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ models[0].getClass(), f1[1] });
		}
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() o1[1]="+o1[1]);
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() o1[2]="+o1[2]);
		Modchu_LMMManager.setTextureBoxModels(ltb, o1);
/*
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map textures = Modchu_CastHelper.Map(getLmmTextureManagerTextures());
			if (textures != null) {
				textures.put(mtb.fileName, ltb);
				if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() textures.put ltb="+ltb);
			}
		} else {
			List textures = Modchu_CastHelper.List(getLmmTextureManagerTextures());
			if (textures != null) {
				textures.add(ltb);
				if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() textures.add ltb="+ltb);
			}
		}
*/
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() 2");
		addLmmTextureManagerModel(mtb.fileName, MultiModelCustom.class, o1);
		if (debug) Modchu_Debug.lDebug("lmmAddTempOtherCustomModel() 3 end.");
	}

	static void lmmTextureManagerInit() {
		if (!addLMMModelFlag()) return;
		boolean debug = false;
		if (Modchu_LMMManager.getLmmTextureManagerInstance() != null); else {
			Modchu_Debug.systemLogDebug("lmmTextureManagerInit() instance null !!", 2, null);
			return;
		}
		Map models = Modchu_LMMManager.getLmmTextureManagerModels();
		if (models != null
				&& !models.isEmpty()); else {
			Modchu_Debug.systemLogDebug("lmmTextureManagerInit() models null !!", 2, null);
			return;
		}

		boolean initFlag = false;
		// PFLM側にLMMテクスチャ登録
		if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures models="+models);
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map textures = Modchu_CastHelper.Map(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures="+textures);
			if (textures != null
					&& !textures.isEmpty()); else {
				Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM textures null !!", 2, null);
				return;
			}
			for (Entry<String, Object> en : ((Map<String, Object>) textures).entrySet()) {
				try {
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures s-------------------------");
					String fileName = en.getKey();
					if (fileName != null
							&& !fileName.isEmpty()); else {
						Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM fileName == null !!", 2, null);
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
						continue;
					}
					fileName = fileName.replaceAll("/", ".");
					Object ltb = en.getValue();
					if (fileName.startsWith("textures.entity.")) fileName = fileName.substring(16);
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM fileName="+fileName);
					Object[] o1 = Modchu_LMMManager.getTextureBoxModels(ltb);
					Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
					if (o1 != null
							&& o1.length > 0
							&& o1[0] != null
							&& (o1[0] instanceof MultiModelBaseBiped
							| ModchuLmmModel.isInstance(o1[0]))) {
						// 逆輸入チェック
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o1[0] instanceof MultiModelBaseBiped continue fileName="+fileName);
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
						continue;
					}
					if (o1 != null
							&& o1.length > 0
							&& o1[0] != null); else {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o1[0] == null continue");
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
						continue;
					}
					ModchuModel_TextureBoxBase mtb = new ModchuModel_TextureBoxBase();
					mtb.fileName = fileName;
					String name = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "name", ltb));
					int i1 = name.indexOf("_");
					mtb.textureName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureName", ltb)) + addLmmModelString;
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM mtb.textureName="+mtb.textureName);
					mtb.packegeName = i1 > -1 ? name.substring(0, i1) : name;
					mtb.textures = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "textures", ltb));
					mtb.armors = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "armors", ltb));
					mtb.modelName = (i1 > -1 ? name.substring(i1 + 1) : name) + addLmmModelString;
					//ltb1.textureDir = null;
					MultiModelBaseBiped[] mlm = new MultiModelBaseBiped[3];
/*
					Object[] o2 = newMultiModelLMMModel(o1);
					if (o2 != null
							&& o2[0] != null) {
						for (int i = 0; i < o2.length; i++) {
							mlm[i] = o2[i] instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) o2[i] : null;
						}
						mtb.models = mlm;
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures.add mtb.models="+mtb.models+" mtb.modelName="+mtb.modelName);
					} else {
						Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM textures.add o2 == null !! o1="+o1+" fileName"+fileName+" mtb.modelName="+mtb.modelName, 2, null);
					}
*/
					ModchuModel_TextureManagerBase.instance.modelClassNameMap.put(mtb.modelName, o1[0].getClass().getName());
					ModchuModel_TextureManagerBase.instance.textures.put(mtb.textureName, mtb);
					initFlag = true;
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures.add fileName="+fileName);
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			List textures = Modchu_CastHelper.List(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures="+textures);
			if (textures != null
					&& !textures.isEmpty()); else {
				Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM textures null !!", 2, null);
				return;
			}
			for (Object ltb : textures) {
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures s-------------------------");
				String textureName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureName", ltb));
				if (textureName != null
						&& !textureName.isEmpty()); else {
					Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM textureName == null !!", 2, null);
					String fileName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb));
					Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM fileName="+fileName);
					String modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb));
					Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM modelName="+modelName);
					continue;
				}
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM fileName="+textureName);
				Object[] o1 = Modchu_LMMManager.getTextureBoxModels(ltb);
				Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
				if (o1 != null
						&& o1.length > 0
						&& o1[0] != null
						&& (o1[0] instanceof MultiModelBaseBiped
						| ModchuLmmModel.isInstance(o1[0]))) {
					// 逆輸入チェック
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o1[0] instanceof ModchuModel continue fileName="+textureName);
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
					continue;
				}
				if (o1 != null
						&& o1.length > 0
						&& o1[0] != null); else {
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o1[0] == null continue");
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
					continue;
				}
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o1[0]="+o1[0]);
				ModchuModel_TextureBoxBase mtb = new ModchuModel_TextureBoxBase();
				mtb.fileName = textureName;
				mtb.packegeName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "packegeName", ltb));
				mtb.textureName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureName", ltb)) + addLmmModelString;
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM mtb.textureName="+mtb.textureName);
				mtb.textures = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "textures", ltb));
				mtb.armors = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "armors", ltb));
				mtb.modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb)) + addLmmModelString;
				mtb.textureDir = Modchu_CastHelper.StringArray(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureDir", ltb));
				if (Modchu_Main.getMinecraftVersion() < 160) {
					if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM oldLMMMapSetting textures ----------s");
					mtb.textures = oldLMMMapSetting(mtb.textures, mtb);
					if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM oldLMMMapSetting textures ----------e");
					if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM oldLMMMapSetting armors ----------s");
					Map map = new TreeMap<String, Map<Integer, Object>>();
					for (Entry<String, Map<Integer, Object>> en : ((Map<String, Map<Integer, Object>>) mtb.armors).entrySet()) {
						String s = en.getKey();
						Map map1 = en.getValue();
						map1 = oldLMMMapSetting(map1, mtb);
						map.put(s, map1);
					}
					mtb.armors = map;
					if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM oldLMMMapSetting armors ----------e");
				}
				MultiModelBaseBiped[] mlm = new MultiModelBaseBiped[3];
/*
				Object[] o2 = newMultiModelLMMModel(o1);
				if (o2 != null
						&& o2[0] != null) {
					for (int i = 0; i < o2.length; i++) {
						mlm[i] = o2[i] instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) o2[i] : null;
					}
					mtb.models = mlm;
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures.add mtb.models="+mtb.models+" mtb.modelName="+mtb.modelName);
				} else {
					Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM textures.add o2 == null !! o1="+o1+" fileName"+textureName+" mtb.modelName="+mtb.modelName, 2, null);
				}
*/
				ModchuModel_TextureManagerBase.instance.modelClassNameMap.put(mtb.modelName, o1[0].getClass().getName());
				ModchuModel_TextureManagerBase.instance.textures.put(mtb.textureName, mtb);
				initFlag = true;
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures.add fileName="+textureName);
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures e-------------------------");
			}
		}
/*
		if (debug) {
			Object ltb = ModchuModel_TextureManagerBase.instance.getTextureBox("default_Orign;lmmModel");
			Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM default_Orign;lmmModel ltb="+ltb);
			if (ltb != null); else {
				ltb = ModchuModel_TextureManagerBase.instance.getTextureBox("default_Orign");
				Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM default_Orign ltb="+ltb);
				ModchuModel_TextureBoxBase mtb = new ModchuModel_TextureBoxBase();
				mtb.fileName = "default_Orign";
				mtb.packegeName = "default";
				mtb.textureName = mtb.fileName + addLmmModelString;
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM mtb.textureName="+mtb.textureName);
				mtb.textures = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "textures", ltb));
				mtb.armors = Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(ltb.getClass(), "armors", ltb));
				mtb.modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb)) + addLmmModelString;
				mtb.textureDir = Modchu_CastHelper.StringArray(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureDir", ltb));
				MultiModelBaseBiped[] mlm = new MultiModelBaseBiped[3];
				Class ModelLittleMaid_Orign = Modchu_LMMManager.getModelLittleMaidOrignClass();
				ModchuModel_TextureManagerBase.instance.modelClassNameMap.put(mtb.modelName, ModelLittleMaid_Orign.getName());
				ModchuModel_TextureManagerBase.instance.textures.put(mtb.textureName, mtb);
			}
		}
*/
		// PFLM側にLMMモデル登録
		if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM models="+models);
		for (Entry<String, Object[]> en : ((Map<String, Object[]>) models).entrySet()) {
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM modelMap s-------------------------");
			String key = en.getKey();
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM key="+key);
			Object[] o = en.getValue();
			Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
			// 逆輸入チェック
			if (o[0] instanceof MultiModelBaseBiped
					| ModchuLmmModel.isInstance(o[0])) {
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM not add continue.");
				continue;
			}
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM add");
			ArrayList<String> nameList = getLmmTextureManagerModelNameToTextureName(key);
			key = key+addLmmModelString;
			if (nameList != null
					&& !nameList.isEmpty()) {
				//for (String s : nameList) {
				String s = nameList.get(0);
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM s^^^^^^^^^^^^^^^^^^^^");
				if (s != null
						&& !s.isEmpty()); else {
					Modchu_Debug.systemLogDebug("lmmTextureManagerInit() LMM to PFLM s == null !!", 2, null);
					continue;
				}
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM s="+s);
/*
				Object[] o2 = newMultiModelLMMModel(o);
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM o2="+o2);
				MultiModelBaseBiped[] mlm = new MultiModelBaseBiped[3];
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM mlm="+mlm);
				if (o2 != null
						&& o2[0] != null) {
					for (int i = 0; i < o2.length; i++) {
						if (o2[i] instanceof MultiModelBaseBiped) {
							mlm[i] = (MultiModelBaseBiped) o2[i];
							if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM MultiModelBaseBiped ok o2["+i+"]="+o2[i]);
						} else {
							if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM !MultiModelBaseBiped o2["+i+"]="+o2[i]);
						}
					}
*/
					ModchuModel_TextureManagerBase.instance.modelClassNameMap.put(key, o[0].getClass().getName());
					if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM modelMap.put key="+key+" o[0].getClass().getName()="+o[0].getClass().getName());
					initFlag = true;
				//} else {
					//if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM textures.add o2 == null !! key="+("_"+key));
				//}
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM e^^^^^^^^^^^^^^^^^^^^");
				//}
			}
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM modelMap e-------------------------");
		}
		if (initFlag) {
			if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() LMM to PFLM initFlag");
			ModchuModel_TextureManagerBase.instance.setModels();
			//initTextureManager();
		}

		if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model start");
		// LMM側にPFLMモデル登録
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map modelNames = Modchu_LMMManager.getLmmTextureManagerModelNames();
			Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
			if (ModchuLmmModel != null) {
				for (Entry<String, String> en : ((Map<String, String>) ModchuModel_TextureManagerBase.instance.modelClassNameMap).entrySet()) {
					String key = en.getKey();
					String className = en.getValue();
					if (className == MultiModel.class.getName()) continue;
					Class c = Modchu_Reflect.loadClass(className);
					if (!(MultiModelBaseBiped.class).isAssignableFrom(c)
							| ModchuLmmModel.isAssignableFrom(c)) {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model !isAssignableFrom className="+className);
						continue;
					}
					Object[] mlm = Modchu_Reflect.newInstanceArray(ModchuLmmModel, 3);
					mlm[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, 0.0F });
					if (mlm[0] != null); else {
						Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model model == null !! className="+className);
						continue;
					}
					String name = Modchu_Main.lastIndexProcessing(className, "_");
					if (name.indexOf("_") > -1) {
						name = Modchu_Main.lastIndexProcessing(name, "_");
					} else {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model not put !indexOf name="+name);
						continue;
					}
					float[] lsize = Modchu_CastHelper.FloatArray(Modchu_Reflect.invokeMethod(mlm[0].getClass(), "getArmorModelsSize", mlm[0]));
					mlm[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[0] });
					mlm[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[1] });
					if (!models.containsKey(name)) {
						models.put(name, mlm);
						if (modelNames != null) modelNames.put(key, name);
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model models.put name="+name);
					} else {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model not put models.containsKey name="+name);
					}
				}
				Modchu_LMMManager.setLmmTextureManagerModels(models);
				Modchu_LMMManager.setLmmTextureManagerModelNames(models);
			}
		} else {
			//Modchu_Debug.mDebug("lmmTextureManagerInit()");
			Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
			if (ModchuLmmModel != null) {
				for (Entry<String, String> en : ((Map<String, String>) ModchuModel_TextureManagerBase.instance.modelClassNameMap).entrySet()) {
					String key = en.getKey();
					String className = en.getValue();
					if (className == MultiModel.class.getName()) continue;
					Class c = Modchu_Reflect.loadClass(className);
					if (!(MultiModelBaseBiped.class).isAssignableFrom(c)
							| ModchuLmmModel.isAssignableFrom(c)) {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model isAssignableFrom check out className="+className);
						continue;
					}
					String name = className;
					if (name.indexOf("_") > -1) {
						name = Modchu_Main.lastIndexProcessing(name, "_");
					} else {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model not put !indexOf name="+name);
						continue;
					}
					Object[] mlm = Modchu_Reflect.newInstanceArray(Modchu_LMMManager.getMMMModelMultiBaseClass(), 3);
					mlm[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, 0.0F });
					if (mlm[0] != null); else {
						Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model model == null !! className="+className);
						continue;
					}
					float[] lsize = Modchu_CastHelper.FloatArray(Modchu_Reflect.invokeMethod(mlm[0].getClass(), "getArmorModelsSize", mlm[0]));
					mlm[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[0] });
					mlm[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[1] });
					if (!models.containsKey(name)) {
						models.put(name, mlm);
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model models.put name="+name);
					} else {
						if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model not put models.containsKey name="+name);
					}
					//if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM put mlm[0].getClass()="+mlm[0].getClass());
				}
				Modchu_LMMManager.setLmmTextureManagerModels(models);
			} else {
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model ModchuLmmModel == null !!");
			}
			for (Entry<String, Object[]> en : ((Map<String, Object[]>) ModchuModel_TextureManagerBase.instance.otherModelDataMap).entrySet()) {
				String key = en.getKey();
				Object[] o1 = ModchuModel_TextureManagerBase.instance.newMultiModelOtherModel(key);
				Object[] mlm = Modchu_Reflect.newInstanceArray(Modchu_LMMManager.getMMMModelMultiBaseClass(), 3);
				mlm[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ o1[0], 0.0F });
				if (mlm[0] != null); else {
					Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model otherModelDataMap model == null !! o1[0]="+o1[0]);
					continue;
				}
				float[] lsize = Modchu_CastHelper.FloatArray(Modchu_Reflect.invokeMethod(mlm[0].getClass(), "getArmorModelsSize", mlm[0]));
				mlm[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ o1[1], lsize[0] });
				mlm[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ o1[2], lsize[1] });
				models.put(key, mlm);
				if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() PFLM to LMM model otherModelDataMap put key="+key);
			}
		}
		lmmTextureManagerSetModels();
/*
		// ModelBaseDuo差し替え
		Object render = Modchu_AS.get(Modchu_AS.renderManagerGetEntityClassRenderObject, Modchu_LMMManager.getLMMEntityLittleMaidClass());
		Modchu_Debug.lDebug("ModelBaseDuo replace render="+render);
		if (render != null) {
			Object modelFATT = Modchu_Main.newModchuCharacteristicObject("Modchu_LMMModelBaseDuo", ModchuModel_ModelBaseDuo.class, render);
			Modchu_Debug.lDebug("ModelBaseDuo replace modelFATT="+modelFATT);
			boolean isModelAlphablend = Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject(Modchu_LMMManager.getMMMLibClass(), "cfg_isModelAlphaBlend"));
			Class c = Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelBaseNihil" : "MMM_ModelBaseNihil");
			Modchu_Reflect.setFieldObject(c, "isModelAlphablend", modelFATT, isModelAlphablend);
			Modchu_Reflect.setFieldObject(c, "isRendering", modelFATT, true);
			Modchu_Reflect.setFieldObject(render.getClass(), "modelFATT", render, modelFATT);
			Modchu_AS.set(Modchu_AS.rendererLivingEntitySetRenderPassModel, render, modelFATT);
		}
*/
		Modchu_Debug.lDebug("lmmTextureManagerInit() end.");
	}

	private static Map<Integer, Object> oldLMMMapSetting(Map<Integer, Object> map, ModchuModel_TextureBoxBase mtb) {
		boolean debug = false;
		Map<Integer, Object> map2 = new HashMap();
		for (Entry<Integer, Object> en : ((Map<Integer, Object>) map).entrySet()) {
			map2.put(en.getKey(), en.getValue());
		}
		map = map2;
		String defaultModelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(Modchu_LMMManager.getMMMTextureManagerString(), "defaultModelName"));
		for (Entry<Integer, Object> en : ((Map<Integer, Object>) map).entrySet()) {
			int i = en.getKey();
			String s = (String) en.getValue();
			if (s != null
					&& s.indexOf("/mob/littleMaid") < 0) {
				if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM mtb.textureDir[1]="+mtb.textureDir[1]);
				if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM mtb.fileName="+mtb.fileName);
				if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM s="+s);
				map.put(i, (new StringBuilder()).append(mtb.textureDir[1]).append(mtb.fileName.replace('.', '/').replace("_"+defaultModelName, "")).append(s).toString());
				if (debug) Modchu_Debug.lDebug("ModchuModel_ModelAddManager oldLMMMapSetting() LMM to PFLM map.get("+i+")="+map.get(i));
			}
		}
		return map;
	}

	public static ArrayList<String> getLmmTextureManagerModelNameToTextureName(String key) {
		ArrayList<String> list = new ArrayList();
		boolean debug = false;
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map textures = Modchu_CastHelper.Map(Modchu_LMMManager.getLmmTextureManagerTextures());
			//if (debug) Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName textures="+textures);
			if (textures != null
					&& !textures.isEmpty()); else {
				Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName textures Map null !!");
				return list;
			}
			for (Entry<String, Object> en : ((Map<String, Object>) textures).entrySet()) {
				String fileName = en.getKey();
				//if (debug) Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName fileName="+fileName);
				if (fileName != null
						&& !fileName.isEmpty()); else {
					continue;
				}
				fileName = fileName.replaceAll("/", ".");
				if (fileName.startsWith("textures.entity.")) fileName = fileName.substring(16);
				String modelName = Modchu_Main.lastIndexProcessing(fileName, "_");
				if (modelName.equals(key)) {
					if (fileName != null
							&& !list.contains(fileName)) {
						list.add(fileName);
						//if (debug) Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName list.add");
					}
				} else {
					//if (debug) Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName !modelName.equals(key) modelName="+modelName+" key="+key);
				}
			}
			//if (debug) Modchu_Debug.lDebug("lmmTextureManagerInit() list.size()="+list.size());
		} else {
			List textures = Modchu_CastHelper.List(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (textures != null
					&& !textures.isEmpty()); else {
				Modchu_Debug.lDebug("getLmmTextureManagerModelNameToTextureName textures List null !!");
				return null;
			}
			for (Object ltb : textures) {
				String modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb));
				if (modelName != null
						&& modelName.equals(key)) {
					String fileName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb));
					if (fileName != null
							&& !list.contains(fileName)) list.add(fileName);
				}
			}
		}
		return list;
	}

	public static void addLmmTextureManagerModel(String modelName, Class<? extends MultiModelBaseBiped> c, Object[] mlm) {
		if (!addLMMModelFlag()) return;
		if (modelName != null
				&& !modelName.isEmpty()); else return;
		Object instance = Modchu_LMMManager.getLmmTextureManagerInstance();
		if (instance != null); else return;
		Map models = Modchu_LMMManager.getLmmTextureManagerModels();
		if (models != null); else return;
		Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
		if (ModchuLmmModel != null); else return;
		if (mlm != null) {
			if (!ModchuLmmModel.isInstance(mlm[0])) {
				Object[] model1 = Modchu_Reflect.newInstanceArray(ModchuLmmModel, 3);
				model1[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ mlm[0], 0.0F });
				float[] lsize = Modchu_CastHelper.FloatArray(Modchu_Reflect.invokeMethod(mlm[0].getClass(), "getArmorModelsSize", mlm[0]));
				model1[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ mlm[1], lsize[0] });
				model1[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ MultiModelBaseBiped.class, float.class }, new Object[]{ mlm[2], lsize[1] });
				mlm = model1;
			}
		} else {
			mlm = Modchu_Reflect.newInstanceArray(ModchuLmmModel, 3);
			mlm[0] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, 0.0F });
			float[] lsize = Modchu_CastHelper.FloatArray(Modchu_Reflect.invokeMethod(mlm[0].getClass(), "getArmorModelsSize", mlm[0]));
			mlm[1] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[0] });
			mlm[2] = Modchu_Reflect.newInstance(ModchuLmmModel, new Class[]{ Class.class, float.class }, new Object[]{ c, lsize[1] });
		}
		String name = Modchu_Reflect.getFieldObject(mlm[0].getClass(), "master", mlm[0]).getClass().getName();
		//if (Modchu_Main.getMinecraftVersion() < 170
				//|ModchuModel_Main.isLMMX)
		modelName = Modchu_Main.lastIndexProcessing(modelName, "_");
		models.put(modelName, mlm);
		Modchu_LMMManager.setLmmTextureManagerModels(models);
		Modchu_Debug.lDebug("addLmmTextureManagerModel() modelName="+modelName);
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map modelNames = Modchu_LMMManager.getLmmTextureManagerModelNames();
			if (modelNames != null); else return;
			modelNames.put(modelName, name);
			Modchu_LMMManager.setLmmTextureManagerModelNames(modelNames);
		}
	}

	private static boolean addLMMModelFlag() {
		return ModchuModel_Main.isLMM
				&& ModchuModel_ConfigData.modelForLittleMaidMob;
				//&& Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("net.minecraftforge.common.ForgeVersion", "buildVersion")) < 954;
	}

	public static void lmmTextureManagerSetModels() {
		if (!addLMMModelFlag()) return;
		boolean debug = false;
		Object instance = Modchu_LMMManager.getLmmTextureManagerInstance();
		if (instance != null); else return;
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map textures = Modchu_CastHelper.Map(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (textures != null
					&& !textures.isEmpty()); else {
				Modchu_Debug.Debug("lmmTextureManagerSetModels() textures null !!");
				return;
			}
			for (Entry<String, Object> le : ((Map<String, Object>) textures).entrySet()) {
				Object lcont = le.getValue();
				Modchu_Reflect.setFieldObject(lcont.getClass(), "defaultModel", lcont, null);
				le.setValue(lcont);
			}
			Modchu_Reflect.invokeMethod(instance.getClass(), "setModels", instance);
		} else {
			Map models = Modchu_LMMManager.getLmmTextureManagerModels();
			if (models != null
					&& !models.isEmpty()); else return;
			String defaultModelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(Modchu_LMMManager.getMMMTextureManagerString(), "defaultModelName"));
			//Modchu_Debug.mDebug("lmmTextureManagerSetModels() defaultModelName="+defaultModelName);
			Object[] ldm = (Object[]) models.get(defaultModelName);
			//Modchu_Debug.mDebug("lmmTextureManagerSetModels() ldm="+ldm);
			if (ldm == null && !models.isEmpty()) {
				ldm = (Object[])models.values().toArray()[0];
				//Modchu_Debug.mDebug("lmmTextureManagerSetModels() ldm == null ldm="+ldm);
			}
			List textures = Modchu_CastHelper.List(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (debug) Modchu_Debug.mDebug("lmmTextureManagerSetModels() textures="+textures);
			if (textures != null); else {
				//Modchu_Debug.Debug("lmmTextureManagerSetModels() ModchuModel_TextureManagerBase textures null !!");
				return;
			}
			// PFLMからLMMへテクスチャー追加
			List tempTexturesTextureNameList = new ArrayList();
			for (Object ltb1 : textures) {
				String textureName = Modchu_LMMManager.getTextureBoxTextureName(ltb1);
				if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() texturesFileName setting textureName="+textureName);
				if (textureName != null
						&& !textureName.isEmpty()) tempTexturesTextureNameList.add(textureName);
			}
			for (Entry<String, ModchuModel_TextureBoxBase> en : ((Map<String, ModchuModel_TextureBoxBase>) ModchuModel_TextureManagerBase.instance.textures).entrySet()) {
				ModchuModel_TextureBoxBase mtb = en.getValue();
				Object ltb = Modchu_LMMManager.newModchu_LmmTextureBox(mtb);
				if (!tempTexturesTextureNameList.contains(mtb.textureName)) {
					if (mtb.textureName.indexOf(addLmmModelString) < 0) {
						textures.add(ltb);
						if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() textures.add mtb.textureName="+mtb.textureName);
					}
				} else {
					if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() textures not add mtb.textureName="+mtb.textureName);
				}
			}

			Class ModelMultiBase = Modchu_Reflect.loadClassArray(Modchu_LMMManager.getMMMModelMultiBaseClass());
			Class MMM_TextureBox = Modchu_LMMManager.getMMMTextureBoxClass();
			//Modchu_Debug.mDebug("lmmTextureManagerSetModels() ModelMultiBase="+ModelMultiBase);
/*
			for (Object ltb : textures) {
				String modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb));
				//Modchu_Debug.mDebug("lmmTextureManagerSetModels() modelName="+modelName);
				if (MMM_TextureBox.isInstance(ltb)); else {
					Modchu_Debug.systemLogDebug("lmmTextureManagerSetModels() setModels !MMM_TextureBox ltb="+ltb);
				}
				if (modelName.isEmpty()) {
					Modchu_Reflect.invokeMethod(MMM_TextureBox, "setModels", new Class[]{ String.class, ModelMultiBase, ModelMultiBase }, ltb, new Object[]{ defaultModelName, null, ldm });
				} else {
					Object[] model1 = Modchu_CastHelper.ObjectArray(models.get(modelName));
					if (ModelMultiBase.isInstance(model1)
							&& ModelMultiBase.isInstance(ldm)) {
						Modchu_Reflect.invokeMethod(MMM_TextureBox, "setModels", new Class[]{ String.class, ModelMultiBase, ModelMultiBase }, ltb, new Object[]{ modelName, model1, ldm });
					} else {
						if (debug) {
							if (!ModelMultiBase.isInstance(model1)) Modchu_Debug.mDebug("lmmTextureManagerSetModels() setModels !ModelMultiBase.isInstance model1="+model1+" modelName="+modelName);
							if (!ModelMultiBase.isInstance(ldm)) Modchu_Debug.mDebug("lmmTextureManagerSetModels() setModels !ModelMultiBase.isInstance ldm="+ldm+" modelName="+modelName);
						}
					}
				}
			}
*/
			for (Entry<String, Object[]> le : ((Map<String, Object[]>) models).entrySet()) {
				String key = le.getKey();
				Object[] value = le.getValue();
				if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() key="+key);
				if (value != null) {
					for (Object ltb : textures) {
						String modelName = Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "modelName", ltb));
						//if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() modelName="+modelName);
						if (modelName != null
								&& modelName.equals(key)) {
							Modchu_Reflect.invokeMethod(MMM_TextureBox, "setModels", new Class[]{ String.class, ModelMultiBase, ModelMultiBase }, ltb, new Object[]{ key, value, ldm });
							//textures.add(ltb);
							if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() setModels key="+key);
						}
					}
				}
			}
			for (int li = textures.size() - 1; li >= 0; li--) {
				Object ltb = textures.get(li);
				if (Modchu_LMMManager.getTextureBoxModels(ltb) == null) {
					if (debug) Modchu_Debug.Debug("lmmTextureManagerSetModels() textures remove ltb textureName="+Modchu_LMMManager.getTextureBoxTextureName(ltb));
					textures.remove(li);
				}
			}
			Modchu_LMMManager.setLmmTextureManagerTextures(textures);
			Modchu_Reflect.invokeMethod(instance.getClass(), "initTextureList", new Class[]{ boolean.class }, instance, new Object[]{ true });
		}
/*
		if (debug) {
			Map models = getLmmTextureManagerModels();
			for (Entry<String, Object[]> le : ((Map<String, Object[]>) models).entrySet()) {
				String key = le.getKey();
				Object[] value = le.getValue();
				Modchu_Debug.Debug("lmmTextureManagerSetModels() debug models key="+key+" value[0].getClass()="+value[0].getClass());
			}
			List textures = Modchu_CastHelper.List(getLmmTextureManagerTextures());
			for (Object ltb : textures) {
				//Modchu_Debug.Debug("lmmTextureManagerSetModels() debug textures ltb.textureName="+getTextureBoxTextureName(ltb));
				//Modchu_Debug.Debug("lmmTextureManagerSetModels() debug textures ltb.models[0].getClass()="+getTextureBoxModels(ltb)[0].getClass());
				if (getTextureBoxTextureName(ltb).startsWith("other_CustomBat")) {
					Object model = getTextureBoxModels(ltb)[0];
					Modchu_Debug.Debug("lmmTextureManagerSetModels() debug textures model="+model);
					Object master = Modchu_Main.getModchuCharacteristicObjectMaster(model);
					Modchu_Debug.Debug("lmmTextureManagerSetModels() debug textures master.getClass()="+master.getClass());
				}
			}
		}
*/
	}

	public static void worldEventLoad(Object event) {
		Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
		if (ModchuLmmModel != null); else return;
		if (Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX) {
			Map textures = Modchu_CastHelper.Map(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (textures != null
					&& !textures.isEmpty()); else {
				return;
			}
			for (Entry<String, Object> en : ((Map<String, Object>) textures).entrySet()) {
				Object ltb = en.getValue();
				Object[] models = Modchu_LMMManager.getTextureBoxModels(ltb);
				if (models != null) {
					for (Object model : models) {
						if (model != null
								&& ModchuLmmModel.isInstance(model)) Modchu_Reflect.invokeMethod(ModchuLmmModel, "worldEventLoad", new Class[]{ Object.class }, model, new Object[]{ event });
					}
				}
			}
		} else {
			List textures = Modchu_CastHelper.List(Modchu_LMMManager.getLmmTextureManagerTextures());
			if (textures != null
					&& !textures.isEmpty()); else {
				return;
			}
			for (Object ltb : textures) {
				Object[] models = Modchu_LMMManager.getTextureBoxModels(ltb);
				if (models != null) {
					for (Object model : models) {
						if (model != null
								&& ModchuLmmModel.isInstance(model)) Modchu_Reflect.invokeMethod(ModchuLmmModel, "worldEventLoad", new Class[]{ Object.class }, model, new Object[]{ event });
					}
				}
			}
		}
	}

}
