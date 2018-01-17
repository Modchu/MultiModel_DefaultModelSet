package modchu.model;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_FileManager;
import modchu.lib.Modchu_LMMManager;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.Modchu_SearchFileManager;
import modchu.model.multimodel.base.MultiModel;
import modchu.model.multimodel.base.MultiModelBaseBiped;
import modchu.model.multimodel.base.MultiModelCustom;
import modchu.model.multimodel.base.MultiModelLMMModel;
import modchu.model.multimodel.base.MultiModelOtherModel;

public class ModchuModel_TextureManagerBase {

	public static ModchuModel_TextureManagerBase instance = new ModchuModel_TextureManagerBase();

	public String nameTextureIndex = "config/mod_ModchuModel_textureList.cfg";
	public String defaultModelName = "Orign";
	public String modelClassName = "MultiModel";
	public String defaultModelMaidBoneName = "maidbone";
	public String defaultUsingTexture;

	public static final int tx_oldwild				= 0x10; //16;
	public static final int tx_oldarmor1			= 0x11; //17;
	public static final int tx_oldarmor2			= 0x12; //18;
	public static final int tx_oldeye				= 0x13; //19;
	public static final int tx_gui					= 0x20; //32;
	public static final int tx_wild					= 0x30; //48;
	public static final int tx_armor1				= 0x40; //64;
	public static final int tx_armor2				= 0x50; //80;
	public static final int tx_armoroverlay1	= 0x45; //69;
	public static final int tx_armoroverlay2	= 0x55; //85;
	public static final int tx_eye					= 0x60; //96;
	public static final int tx_eyecontract		= 0x60; //96;
	public static final int tx_eyewild				= 0x70; //112;
	public static final int tx_armor1light		= 0x80; //128;
	public static final int tx_armor2light		= 0x90; //144;
	public static String[] armorFilenamePrefix;
	/**
	 * 旧タイプのファイル名
	 */
	public static String defNames[] = {
		"mob_littlemaid0.png", "mob_littlemaid1.png",
		"mob_littlemaid2.png", "mob_littlemaid3.png",
		"mob_littlemaid4.png", "mob_littlemaid5.png",
		"mob_littlemaid6.png", "mob_littlemaid7.png",
		"mob_littlemaid8.png", "mob_littlemaid9.png",
		"mob_littlemaida.png", "mob_littlemaidb.png",
		"mob_littlemaidc.png", "mob_littlemaidd.png",
		"mob_littlemaide.png", "mob_littlemaidf.png",
		"mob_littlemaidw.png",
		"mob_littlemaid_a00.png", "mob_littlemaid_a01.png"
	};

	/**
	 * ローカルで保持しているモデルの初期化用クラス名マップ
	 */
	public Map<String, String> modelClassNameMap = new HashMap();
	/**
	 * ロードに失敗したモデルクラス名マップ
	 */
	public Map<String, String[]> missingModelClassDataMap = new HashMap();
	/**
	 * OtherCustomモデル初期化用データマップ
	 */
	public Map<String, Object[]> otherModelDataMap = new HashMap();
	/**
	 * ローカルで保持しているテクスチャパック
	 */
	public Map<String, ModchuModel_TextureBoxBase> textures = new TreeMap();
	/**
	 * 部分使用用テクスチャパック
	 */
	public Map<String, ModchuModel_TextureBoxBase> partsTextures = new TreeMap();

	public List<Object[]> searchPrefix = new ArrayList();
	public HashMap<String, LinkedList<String>> searchSettledListMap = new HashMap();

	public static ArrayList<String> modelNewInstanceNgList = new ArrayList();
	public static ArrayList<String> partsNameList = new ArrayList();
	public static HashMap<Object, Map> entityModelMapData = new HashMap();
	public static HashMap<String, Object[]> dummyModelMapData = new HashMap();

	public void init() {
		int progress = 0;
		if (ModchuModel_Main.isDev) {
			try {
/*
				//String s0 = getClass().getName()+".class";
				//Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() isDev s0="+s0);
				//ClassLoader classLoader = ModchuModel_TextureManagerBase.class.getClassLoader();
				URL url = getJarFileURL(this);
				//Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() isDev url="+url);
				String s1 = url != null ? url.toString() : null;
				if (s1 != null) {
					if (s1.startsWith("file:/")) {
						s1 = s1.substring(6);
					}
					if (s1.startsWith("file:\\")) {
						s1 = s1.substring(6);
					}
					if (s1.startsWith("file:")) {
						s1 = s1.substring(5);
					}
				}
				//Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() isDev s1="+s1);
				Modchu_FileManager.addMinecraftJar(new File(s1));
*/
				List<File> list = Modchu_FileManager.getClassPathFileList("MultiModel");
				for (File file : list) {
					Modchu_FileManager.addMinecraftJar(file);
				}
			} catch(Exception e) {
				Modchu_Debug.systemLogDebug("ModchuModel_TextureManagerBase init() isDev Exception !!");
				Modchu_Debug.systemLogDebug("", e);
				e.printStackTrace();
			}
		}
		partsNameList.add("_Custom");
		modelClassNameMap.put(defaultModelName, "modchu.model.multimodel.base.MultiModel");
		modelClassNameMap.put(defaultModelMaidBoneName, "modchu.model.multimodel.base.MultiModelMaidBone");
		progress = 1;
		ModchuModel_Main.setSubProgress2(progress);
		loadTextures();
		progress = 90;
		ModchuModel_Main.setSubProgress2(progress);
		// 必須モデルのロード
		Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() MultiModel load.");
		MultiModelBaseBiped[] models = null;
		try {
			models = new MultiModel[3];
			Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() MultiModel load models="+models);
			models[0] = new MultiModel(0.0F);
			if (models[0] != null); else {
				Modchu_Main.setRuntimeException("MultiModel.class not found !!");
			}
			Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() MultiModel load models[0]="+models[0]);
			defaultUsingTexture = models[0].getUsingTexture();
			float[] f = ((MultiModel) models[0]).getArmorModelsSize();
			models[1] = new MultiModel(f[0]);
			models[2] = new MultiModel(f[1]);
		} catch(Exception e) {
			Modchu_Debug.systemLogDebug("ModchuModel_TextureManagerBase init() MultiModel load models Exception !!");
			Modchu_Debug.systemLogDebug("", e);
			e.printStackTrace();
		}
		progress = 100;
		ModchuModel_Main.setSubProgress2(progress);
		Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() MultiModel load end.");
	}

	public static final URL getJarFileURL(Object object) {
		try {
			final ClassLoader loader = object.getClass().getClassLoader();
			final String name = object.getClass().getName().replace('.', '/') + ".class";
			final URL url = loader.getResource(name);
			final Pattern p = Pattern.compile("^jar\\:(.+?\\.jar)\\!\\/(.*)");
			final Matcher m = p.matcher(url.toString());
			if (m.matches()) {
				final MatchResult res = m.toMatchResult();
				return new URL(res.group(1));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public String[] getSearch(String pName) {
		for (Object[] lss : searchPrefix) {
			String[] s1 = (String[]) lss[0];
			if (s1[0].equals(pName)) {
				return s1;
			}
		}
		return null;
	}

	@Deprecated
	public void addSearch(String pName, String pTextureDir, String pClassPrefix) {
		addSearch(pName, pTextureDir);
	}

	/**
	 * 追加対象となる検索対象ファイル群とそれぞれの検索文字列を設定する。
	 */
	public void addSearch(String pName, String pTextureDir) {
		if (searchPrefix != null
				&& !searchPrefix.isEmpty()) {
			for (Object[] lss : searchPrefix) {
				String[] s1 = (String[]) lss[0];
				String[] s2 = (String[]) lss[1];
				if (s1[0].equals(pName)
						&& s2[0].equals(pTextureDir)) {
					return;
				}
			}
		}
		searchPrefix.add(new Object[] { new String[] { pName }, new String[] { pTextureDir }});
	}

	public void addSearch(String[] pName, String[] pTextureDir) {
		searchPrefix.add(new Object[] { pName, pTextureDir });
	}

	/**
	 * テクスチャ名称の一致する物を返す。
	 */
	public ModchuModel_TextureBoxBase getTextureBox(String pName, boolean b) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox 1 pName="+pName);
		if (pName != null
				&& !pName.isEmpty()); else {
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox 2 pName == null. return null.");
			return null;
		}
		pName = textureNameCheck(pName);
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox 3 pName="+pName);
		if (pName != null
				&& !pName.isEmpty()); else {
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox 4 pName == null. return null.");
			return null;
		}
		ModchuModel_TextureBoxBase modchuModel_TextureBoxBase = textures.get(pName);
		if (b) {
			if (modchuModel_TextureBoxBase != null); else {
				modchuModel_TextureBoxBase = partsTextures.get(pName);
			}
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox end. return modchuModel_TextureBoxBase="+modchuModel_TextureBoxBase);
		return modchuModel_TextureBoxBase;
	}

	/**
	 * 渡されたTextureBoxBaseを判定してTextureBoxを返す。
	 * @param pBoxBase
	 * @return
	 */
/*
	public ModchuModel_TextureBoxBase getTextureBox(ModchuModel_TextureBoxBase pBoxBase) {
		if (pBoxBase instanceof ModchuModel_TextureBoxBase) {
			return (ModchuModel_TextureBoxBase)pBoxBase;
		} else if (pBoxBase instanceof ModchuModel_TextureBoxServer) {
			return getTextureBox(pBoxBase.textureName);
		}
		return null;
	}

	public ModchuModel_TextureBoxServer getTextureBoxServer(String pName) {
		for (ModchuModel_TextureBoxServer lbox : textureServer) {
			if (lbox.textureName.equals(pName)) {
				return lbox;
			}
		}
		return null;
	}

	public ModchuModel_TextureBoxServer getTextureBoxServer(int pIndex) {
//		Modchu_Debug.tDebug("getTextureBoxServer: %d / %d", pIndex, textureServer.size());
		if (textureServer.size() > pIndex) {
			return textureServer.get(pIndex);
		}
		return null;
	}
*/
	public void getArmorPrefix() {
		// アーマーファイルのプリフィックスを獲得
		armorFilenamePrefix = Modchu_AS.getStringArray(Modchu_AS.renderBipedBipedArmorFilenamePrefix);
	}

	public boolean loadTextures() {
		boolean debug = false;
		long time = debug ? Modchu_Main.getMillisecond() : 0L;
		if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures");
		// アーマーのファイル名を識別するための文字列を獲得する
		if (!Modchu_Main.isServer) {
			getArmorPrefix();
		}
		List<File> searchFiles = new LinkedList();
		// mods
		searchFiles.add(Modchu_Main.modsDir);
		// jar
		List<File> jarList = ModchuModel_ConfigData.loadMinecraftJar ? Modchu_FileManager.getMinecraftJarList() : null;
		if (jarList != null
				&& !jarList.isEmpty()) searchFiles.addAll(jarList);
		// assets
		//File assetsDir = new File(".", "assets");
		//searchFiles.add(assetsDir);

		int progress = 5;
		ModchuModel_Main.setSubProgress2(progress);
		if (searchFiles != null
				&& !searchFiles.isEmpty())
		for (File file : searchFiles) {
			boolean versionNameCheck = file.getAbsolutePath().equalsIgnoreCase(Modchu_Main.modsDir.getAbsolutePath());
			if (loadTextures(searchPrefix, file, true, versionNameCheck, Modchu_Main.isRelease(), false, false, debug)) {
				if (!versionNameCheck) {
					Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 1 addModResourcePack file.getAbsolutePath()="+file.getAbsolutePath(), debug);
					Modchu_FileManager.addModResourcePack(file);
				}
			}
		}

		// 開発環境assets
		if (!Modchu_Main.isRelease()) {
			LinkedList<File> resourcesList = Modchu_FileManager.getClassLoaderResourcesFileList(getClass());
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures resourcesList="+resourcesList, debug);
			if (resourcesList != null
					&& !resourcesList.isEmpty())
			for (File file : resourcesList) {
				String path = file.getAbsolutePath();
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures path="+path, debug);
				if (checkAssetsBin(path)) {
					if (loadTextures(searchPrefix, file, true, false, true, true, false, debug)) {
						Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures assets addModResourcePack file.getAbsolutePath()="+file.getAbsolutePath(), debug);
						Modchu_FileManager.addModResourcePack(file);
					} else {
						Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures assets else file.getAbsolutePath()="+file.getAbsolutePath(), debug);
					}
				} else if (file.isFile()) {
					if (loadTextures_r_File(searchPrefix, null, file, true, true, false, debug)) {
						Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures assets loadTextures_r_File addModResourcePack file.getAbsolutePath()="+file.getAbsolutePath(), debug);
						Modchu_FileManager.addModResourcePack(file);
					}
				}
			}
		}

		progress = 75;
		ModchuModel_Main.setSubProgress2(progress);

		buildCrafterTexture();
		setModels();

/*
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			String key = en.getKey();
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures textures key="+key);
		}
*/

		if (debug) {
			Modchu_Debug.mDebug("ModchuModel_TextureManagerBase loadTextures time="+time);
			time = Modchu_Main.getMillisecond() - time;
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures end.", debug);
		}
		return false;
	}

	private boolean checkAssetsBin(String path) {
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase checkAssetsBin path="+path);
		boolean b = path.lastIndexOf("\\bin") == (path.length() - 4);
		if (!b) return false;
		//String path1 = path.substring(0, path.length() - 4);
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase checkAssetsBin path1="+path1);
		File file = new File(path, "modchu");
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase checkAssetsBin file.exists()="+file.exists());
		if (file.exists()) {
			return true;
		}
		return false;
	}

	private boolean loadTextures(List<Object[]> list, File file, boolean isLoadZipFile, boolean versionNameCheck, boolean isLoadClassFile, boolean b, boolean addVersionNameResourcePackFlag, boolean debug) {
		if (list != null
				&& !list.isEmpty()
				&& file != null); else return b;
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null)
			for (File t : files) {
				if (debug) Modchu_Debug.tDebug1("ModchuModel_TextureManagerBase loadTextures 1 t="+t, debug);
				if (t.isDirectory()) {
					boolean flag = versionNameCheck
							&& !Modchu_Main.ngVersionName(t.getName());
					if (addVersionNameResourcePackFlag) {
						if (loadTextures(list, t, isLoadZipFile, false, isLoadClassFile, b, false, debug)) {
							if (versionNameCheck) {
								if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 2 addModResourcePack t.getAbsolutePath()="+t.getAbsolutePath(), debug);
								String path = t.getAbsolutePath();
								if (path.indexOf("assets") > -1) {
									File t1 = new File(path.substring(0, path.length() - 7));
									Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 3 addModResourcePack t1.getAbsolutePath()="+t1.getAbsolutePath(), debug);
									Modchu_FileManager.addModResourcePack(t1);
								} else {
									Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 4 addModResourcePack t.getAbsolutePath()="+t.getAbsolutePath(), debug);
									Modchu_FileManager.addModResourcePack(t);
								}
							}
							b = true;
						} else {
							if (versionNameCheck) {
								Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 5 versionNameCheck not addModResourcePack t.getAbsolutePath()="+t.getAbsolutePath(), debug);
							}
						}
					}
					else if (flag
							| !versionNameCheck) {
						if (loadTextures(list, t, isLoadZipFile, versionNameCheck, isLoadClassFile, b, versionNameCheck, debug)) {
							b = true;
						} else {
							if (versionNameCheck) {
								Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures 6 versionNameCheck not addModResourcePack t.getAbsolutePath()="+t.getAbsolutePath(), debug);
							}
						}
					}
				} else if (t.isFile()) {
					if (loadTextures_r_File(list, file, t, isLoadZipFile, isLoadClassFile, b, debug)) b = true;
				}
			}
		} else if (file.isFile()) {
			if (loadTextures_r_File(list, null, file, isLoadZipFile, isLoadClassFile, b, debug)) b = true;
		}
		return b;
	}

	private boolean loadTextures_r_File(List<Object[]> list, File mainFile, File file, boolean isLoadZipFile, boolean isLoadClassFile, boolean b, boolean debug) {
		if (!file.isFile()) return b;
		String path = file.getAbsolutePath();
		String s = path.toLowerCase();
		if (isLoadZipFile) {
			boolean isZip = s.lastIndexOf(".zip") > -1;
			boolean isJar = s.lastIndexOf(".jar") > -1;
			if (isZip
					| isJar) {
				for (Object[] o0 : list) {
					String[] s0 = (String[]) o0[0];
					String[] s1 = (String[]) o0[1];
					for (String s2 : s0) {
						s2 = s2.toLowerCase();
						if (s.indexOf(s2) > -1) {
							if (addTexturesZip(file, s1, isLoadClassFile, debug)) b = true;
						}
					}
				}
				return b;
			}
		}
		if (isLoadClassFile
				&& s.endsWith(".class")) {
			addModelClass(path, debug);
		}
		else if (s.lastIndexOf(".png") > -1) {
			for (Object[] o0 : list) {
				String[] s1 = (String[]) o0[1];
				if (addTextureName(s1, mainFile, file, false, debug)) b = true;
			}
		}
		return b;
	}

	public void setModels() {
		Modchu_Debug.tDebug("ModchuModel_TextureManagerBase setModels 1 modelNameList.size()="+(modelClassNameMap != null ? modelClassNameMap.size() : null));
/*
		if (modelNameList != null
				&& !modelNameList.isEmpty()) {
			for (Entry<String, MultiModelBaseBiped[]> le : modelNameList.entrySet()) {
				String key = le.getKey();
				MultiModelBaseBiped[] value = le.getValue();
				String ls = value != null
						&& value.length > 0 ? value[0].getUsingTexture() : null;
				//Modchu_Debug.tDebug("ModchuModel_TextureManagerBase setModels ls="+ls);
				if (ls != null) {
					String textureName = ls + "_" + key;
					if (getTextureBox(textureName) == null) {
						ModchuModel_TextureBoxBase lbox = null;
						if (textures != null
								&& !textures.isEmpty()) {
							for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
								ModchuModel_TextureBoxBase ltb = en.getValue();
								String packegeName = ltb.packegeName;
								if (packegeName != null
										&& ls != null
										&& packegeName.equals(ls)) {
									lbox = ltb;
									break;
								}
							}
						}
						if (lbox != null) {
							lbox = (ModchuModel_TextureBoxBase) lbox.duplicate();
							lbox.setModels(key, null, value);
							textures.put(textureName, lbox);
						}
					}
				}
			}
		}
*/
		Modchu_Debug.tDebug("Loaded Texture Lists.(%d)", textures.size());
		if (textures != null
				&& !textures.isEmpty()) {
			for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
				ModchuModel_TextureBoxBase lbox = en.getValue();
				Modchu_Debug.tDebug("texture: %s(%s)", lbox.textureName, lbox.fileName);
			}
/*
			for (int li = textures.size() - 1; li >= 0; li--) {
				if (textures.get(li).models == null) {
					textures.remove(li);
				}
			}
			Modchu_Debug.tDebug("Rebuild Texture Lists.(%d)", textures.size());
			for (Modchu_TextureBoxBase lbox : textures) {
				Modchu_Debug.tDebug("texture: %s(%s) - hasModel:%b", lbox.textureName, lbox.fileName, lbox.models != null);
			}
*/
		}
	}

	public void buildCrafterTexture() {
		String textureName = "Crafter_Biped";
		ModchuModel_TextureBoxBase lbox = new ModchuModel_TextureBoxBase(textureName, new String[] {"", "", ""});
		lbox.fileName = "";
		int version = Modchu_Main.getMinecraftVersion();
		lbox.addTexture(0x0c, version > 162 ? "textures/entity/steve.png" : "/mob/char.png");
		if (armorFilenamePrefix != null && armorFilenamePrefix.length > 0) {
			for (String ls : armorFilenamePrefix) {
				Map<Integer, Object> lmap = new HashMap();
				lmap.put(tx_armor1, Modchu_Main.newResourceLocation((new StringBuilder()).append(version > 162 ? "textures/models/armor/" : "/armor/").append(ls).append(version > 162 ? "_layer_2.png" : "_2.png").toString()));
				lmap.put(tx_armor2, Modchu_Main.newResourceLocation((new StringBuilder()).append(version > 162 ? "textures/models/armor/" : "/armor/").append(ls).append(version > 162 ? "_layer_1.png" : "_1.png").toString()));
				lbox.armors.put(ls, lmap);
			}
		}

		textures.put(textureName, lbox);
	}

/*
	public boolean loadTextureServer() {
		// サーバー用テクスチャ名称のインデクッスローダー
		// 先ずは手持ちのテクスチャパックを追加する。
		textureServer.clear();
		for (ModchuModel_TextureBoxBase lbox : textures) {
			textureServer.add(new ModchuModel_TextureBoxServer(lbox));
		}
		// ファイルからロード
		//File lfile = MinecraftServer.getServer().getFile(nameTextureIndex);
		File lfile = Modchu_AS.getFile(Modchu_AS.minecraftServerGetFile, nameTextureIndex);
		if (lfile.exists() && lfile.isFile()) {
			try {
				FileReader fr = new FileReader(lfile);
				BufferedReader br = new BufferedReader(fr);
				String ls;

				while ((ls = br.readLine()) != null) {
					String lt[] = ls.split(",");
					if (lt.length >= 7) {
						// ファイルのほうが優先
						ModchuModel_TextureBoxServer lbox = getTextureBoxServer(lt[6]);
						if (lbox == null) {
							lbox = new ModchuModel_TextureBoxServer();
							textureServer.add(lbox);
						}
						lbox.contractColor	= Modchu_HelperBase.getHexToInt(lt[0]);
						lbox.wildColor		= Modchu_HelperBase.getHexToInt(lt[1]);
						lbox.setModelSize(
								Float.valueOf(lt[2]),
								Float.valueOf(lt[3]),
								Float.valueOf(lt[4]),
								Float.valueOf(lt[5]));
						lbox.textureName	= lt[6];
					}
				}

				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Modchu_Debug.tDebug("Loaded ServerBoxList.(%d)", textureServer.size());
			for (int li = 0; li < textureServer.size(); li++) {
				ModchuModel_TextureBoxServer lbox = textureServer.get(li);
				Modchu_Debug.tDebug("%04d=%s:%04x:%04x", li, lbox.textureName, lbox.contractColor, lbox.wildColor);
			}
			return true;
		} else {
		}

		return false;
	}

	public void saveTextureServer() {
		// サーバー用テクスチャ名称のインデクッスセーバー
		File lfile = Modchu_AS.getFile(Modchu_AS.minecraftServerGetFile, nameTextureIndex);
		try {
			FileWriter fw = new FileWriter(lfile);
			BufferedWriter bw = new BufferedWriter(fw);

			for (ModchuModel_TextureBoxServer lbox : textureServer) {
				bw.write(String.format(
						"%04x,%04x,%f,%f,%f,%f,%s",
						lbox.getContractColorBits(),
						lbox.getWildColorBits(),
						lbox.getHeight(null),
						lbox.getWidth(null),
						lbox.getYOffset(null),
						lbox.getMountedYOffset(null),
						lbox.textureName));
				bw.newLine();
			}

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initTextureList(boolean pFlag) {
		Modchu_Debug.tDebug("Clear TextureBoxServer.");
		textureServerIndex.clear();
		textureServer.clear();
		if (pFlag) {
			int li = 0;
			for (ModchuModel_TextureBoxBase lbc : textures) {
				ModchuModel_TextureBoxServer lbs = new ModchuModel_TextureBoxServer(lbc);
				textureServer.add(lbs);
				textureServerIndex.put(lbc, li++);
			}
			Modchu_Debug.tDebug("Rebuild TextureBoxServer(%d).", textureServer.size());
		}
	}
*/
	public boolean addModelClass(String fname, boolean debug) {
		// モデルを追加
		boolean b = false;
		//Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addModelClass 1 fname="+fname, debug);
		if (fname.endsWith(".class")); else return b;
		int i1 = fname.lastIndexOf("/");
		if (i1 < 0) i1 = fname.lastIndexOf("\\");
		String temp = fname;
		if (i1 > -1) temp = fname.substring(i1 + 1).toLowerCase();
		if (!temp.startsWith("multimodel")) return b;
		if (fname.indexOf("_") < 0) return b;
		String cn = Modchu_FileManager.classNameProcessing(fname);
		int version = Modchu_Main.getMinecraftVersion();
		String pn = Modchu_Main.lastIndexProcessing(cn, "\\");
		pn = Modchu_Main.lastIndexProcessing(pn, "_");
		if (modelClassNameMap.containsKey(pn)) return false;
		Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addModelClass cn="+cn+" pn="+pn, debug);

		Class lclass;
		try {
			lclass = Modchu_Reflect.loadClass(cn, -1, Modchu_Main.isRelease());
			if (lclass != null) {
				if (!(MultiModelBaseBiped.class).isAssignableFrom(lclass)
						| Modifier.isAbstract(lclass.getModifiers())) {
					Modchu_Debug.tDebug("ModchuModel_TextureManagerBase getModelClass-fail.", debug);
					String s1 = !(MultiModelBaseBiped.class).isAssignableFrom(lclass) ? "!isAssignableFrom class" : "";
					if (Modifier.isAbstract(lclass.getModifiers())) {
						s1 = s1 + "isAbstract class";
					}
					String[] o1 = new String[] {
							cn,
							"load missing class"
							};
					missingModelClassDataMap.put(pn, o1);
					return b;
				}
/*
				MultiModelBaseBiped mlm[] = new MultiModelBaseBiped[3];
				Constructor<MultiModelBaseBiped> cm = lclass.getConstructor(float.class);
				mlm[0] = cm.newInstance(0.0F);
				float[] lsize = mlm[0].getArmorModelsSize();
				//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase addModelClass lclass="+lclass+" lsize[0]="+lsize[0]+" lsize[1]="+lsize[1]);
				mlm[1] = cm.newInstance(lsize[0]);
				mlm[2] = cm.newInstance(lsize[1]);
*/
				modelClassNameMap.put(pn, cn);
				b = true;
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addModelClass-%s:%s", pn, cn, debug);
			} else {
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addModelClass-class == null !!: %s", cn, debug);
				String[] o1 = new String[] {
						cn,
						"load missing class"
						};
				missingModelClassDataMap.put(pn, o1);
			}
		}
		catch (Exception exception) {
			String ss = "ModchuModel_TextureManagerBase addModelClass-Exception: "+fname;
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.lDebug(ss, 2, exception);
			} else {
				Modchu_Debug.tDebug(ss);
			}
		}
		catch (Error error) {
			String ss = "ModchuModel_TextureManagerBase addModelClass-Error: "+fname;
			if (!Modchu_Main.isRelease()) {
				Modchu_Debug.lDebug(ss, 2, error);
			} else {
				Modchu_Debug.tDebug(ss);
			}
		}
		return b;
	}

	public boolean addTextureName(String[] pSearch, File mainfile, File file, boolean isZipContents, boolean debug) {
		String mainFname = mainfile != null ? mainfile.getAbsolutePath() : null;
		String fname = file.getAbsolutePath();
		return addTextureName(pSearch, mainFname, fname, isZipContents, debug);
	}

	public boolean addTextureName(String[] pSearch, String mainFname, String fname, boolean isZipContents, boolean debug) {
		// パッケージにテクスチャを登録
		fname = Modchu_FileManager.textureNameProcessing(fname);
		for (String s : pSearch) {
			if (Modchu_Main.isDev) {
				if (s.startsWith("/")
						| s.startsWith("\\")) s = s.substring(1);
			}
			if (fname.indexOf("\\") > -1) {
				s = s.replace("/", "\\");
			}
			String fname1 = fileNameProcessing(mainFname, fname, s, isZipContents, debug);
			if (fname1 != null); else continue;
			String textureName = textureNameProcessing(fname1, s, isZipContents, debug);
			if (textureName != null); else continue;
			String pngName = pngProcessing(fname1, isZipContents, debug);
			if (pngName != null); else continue;
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 1 s="+s, debug);
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 2 fname1="+fname1, debug);
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 3 textureName="+textureName, debug);
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 4 pngName="+pngName, debug);
			int index = getIndex(pngName);
			if (index < 0) continue;
			String an = null;
			if (index == tx_oldarmor1) {
				index = tx_armor1;
				an = "default";
			}
			if (index == tx_oldarmor2) {
				index = tx_armor2;
				an = "default";
			}
			if (index == tx_oldwild) {
				index = tx_wild + 12;
			}
			ModchuModel_TextureBoxBase textureBox = getTextureBox(textureName, true);
			if (textureBox == null) {
				textureBox = new ModchuModel_TextureBoxBase(textureName, pSearch);
				if (checkPartsName(fname1)) partsTextures.put(textureName, textureBox);
				else textures.put(textureName, textureBox);
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 5 textures.put", debug);
			} else {
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 6 textureBox != null", debug);
			}

			int version = Modchu_Main.getMinecraftVersion();
			if (version < 160) {
				if (fname1.indexOf("/") > -1
						&& !fname1.startsWith("/")) {
					fname1 = "/"+ fname1;
				}
			}
			textureBox.addTexture(index, fname1);
			return true;
		}
		return false;
	}

	private String fileNameProcessing(String mainFname, String fname, String s, boolean isZipContents, boolean debug) {
		String fname1 = fname;
		int version = Modchu_Main.getMinecraftVersion();
		int i1 = fname1.indexOf("assets");
		if (i1 < 0) i1 = fname1.indexOf("textures");
		if (i1 < 0) i1 = fname1.indexOf("sounds");
		if (i1 < 0) i1 = fname1.indexOf("mods");
		if (i1 > 0) {
			fname1 = fname1.substring(i1);
		} else if (!isZipContents
				&& mainFname != null
				&& fname1.length() > mainFname.length()) {
			fname1 = fname1.substring(mainFname.length());
		}
		if (fname1.indexOf(":\\") > -1) {
			String ss = "fileNameProcessing :\\ error !! mainFname="+mainFname+" fname="+fname;
			Modchu_Main.setRuntimeException(ss);
			return null;
		}
		i1 = fname1.indexOf(s);
		if (i1 < 0) {
			if (s.startsWith("\\")
					| s.startsWith(".")) {
				s = s.substring(1);
				i1 = fname1.indexOf(s);
			}
			else if (fname1.startsWith("/")
					&& !s.startsWith("/")) {
				i1 = fname1.indexOf("/"+s);
			}
			else if (!fname1.startsWith("/")
					&& s.startsWith("/")) {
				String temp = "/" + fname1;
				i1 = temp.indexOf(s);
			}
		}
		if (i1 > -1) {
			if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase fileNameProcessing 1 s="+s+" ok. fname1="+fname1+" isZipContents="+isZipContents, debug);
			if (isZipContents) {
				if (i1 > 0) fname1 = fname1.substring(i1);
				if (fname1.startsWith("/")
								| fname1.startsWith(".")) fname1 = fname1.substring(1);
				if (fname1.startsWith("assets.minecraft.")) fname1 = fname1.substring(17);
			} else {
				if (fname1.startsWith("\\")) fname1 = fname1.substring(1);
				if (fname1.startsWith("assets\\minecraft\\")) fname1 = fname1.substring(17);
			}

			if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase fileNameProcessing 2 fname1="+fname1, debug);
		} else {
			if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName 3 i1 < 0 fname1="+fname1+" s="+s, debug);
			return null;
		}
		return fname1;
	}

	private String textureNameProcessing(String fname, String s, boolean isZipContents, boolean debug) {
		if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase textureNameProcessing 1 s="+s+" fname="+fname, debug);
		if (fname.startsWith("/")
				&& !s.startsWith("/")) {
			s = "/" + s;
		}
		else if (!fname.startsWith("/")
				&& s.startsWith("/")) {
			fname = "/" + fname;
		}
		String textureName = isZipContents ? fname.substring(s.length()) : fname;
		if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase textureNameProcessing 2 textureName="+textureName, debug);
		int i = textureName.lastIndexOf("/");
		if (i < 0) {
			i = textureName.lastIndexOf("\\");
		}
		if (i > 0) {
			textureName = textureName.substring(0, i);
			if (isZipContents) textureName = textureName.replace('/', '.').replace("\\", ".");
			else {
				i = textureName.lastIndexOf("/");
				if (i < 0) {
					i = textureName.lastIndexOf("\\");
				}
				if (i > -1) textureName = textureName.substring(i + 1);
			}
			if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase textureNameProcessing 3 textureName="+textureName, debug);
			textureName = textureNameCheck(textureName);
		} else {
			textureName = null;
		}
		if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase textureNameProcessing 4 textureName="+textureName, debug);
		return textureName;
	}

	private String pngProcessing(String textureName, boolean isZipContents, boolean debug) {
		int i = textureName.lastIndexOf("/");
		if (i < 0) {
			i = textureName.lastIndexOf("\\");
		}
		if (i < 0) return null;
		String pngName = textureName.substring(i + 1);
		return pngName;
	}

	public boolean addTexturesZip(File file, String[] pSearch, boolean isLoadClassFile, boolean debug) {
		if (file == null
				| file.isDirectory()) {
			return false;
		}
		boolean b = false;
		try {
			FileInputStream fileinputstream = new FileInputStream(file);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			do {
				zipentry = zipinputstream.getNextEntry();
				if(zipentry == null)
				{
					break;
				}
				String s = zipentry.getName();
				//Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureZip s="+s);
				if (!zipentry.isDirectory()) {
					if (isLoadClassFile
							&& s.endsWith(".class")) {
						//Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureZip zipentry. addModelClass");
						addModelClass(s, debug);
					} else if (s.lastIndexOf(".png") > -1) {
						b = addTextureName(pSearch, null, s, true, debug);
					}
				}
			} while(true);
			zipinputstream.close();
			fileinputstream.close();
		} catch (Exception e) {
			Modchu_Debug.lDebug("ModchuModel_TextureManagerBase addTextureZip-Exception.");
			Modchu_Debug.lDebug("", 2, e);
		}
		return b;
	}

	public int getIndex(String name) {
		// 名前からインデックスを取り出す
		for (int i = 0; i < defNames.length; i++) {
			if (name.endsWith(defNames[i])) {
				return i;
			}
		}

		Pattern p = Pattern.compile("_([0-9a-f]+).png");
		Matcher m = p.matcher(name);
		if (m.find()) {
			return Integer.decode("0x" + m.group(1));
		}

		return -1;
	}

	public ModchuModel_TextureBoxBase getNextPackege(ModchuModel_TextureBoxBase pNowBox, int pColor, boolean b) {
		// 次のテクスチャパッケージの名前を返す
		boolean b1 = false;
		ModchuModel_TextureBoxBase lreturn = null;
/*
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege ltb.textureName="+ltb.textureName+" ltb.hasColor(pColor)="+ltb.hasColor(pColor));
		}
*/
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege pNowBox.textureName="+pNowBox.textureName);
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb != null
					&& ltb != pNowBox
					&& ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				if (b1) {
					//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege b1 ltb.textureName="+ltb.textureName);
					return ltb;
				}
				if (lreturn == null) {
					//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege lreturn = ltb.");
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege b1 = true.");
				b1 = true;
			}
		}
		lreturn = getTextureManagerTextures(0, b);
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege end. lreturn.textureName="+lreturn.textureName);
		return lreturn;
	}

	public ModchuModel_TextureBoxBase getPrevPackege(ModchuModel_TextureBoxBase pNowBox, int pColor, boolean b) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getPrevPackege");
		// 前のテクスチャパッケージの名前を返す
		ModchuModel_TextureBoxBase lreturn = null;
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb == pNowBox
					&& ltb != lreturn) {
				if (lreturn != null) {
					if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getPrevPackege return lreturn="+lreturn);
					return lreturn;
				}
			}
			if (ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				lreturn = ltb;
				if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getPrevPackege hasColor lreturn="+lreturn);
			}
		}
		lreturn = textures != null
				&& textures.size() > -1 ? getTextureManagerTextures(textures.size() - 1, b) : null;
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getPrevPackege end. textures.size() - 1="+(textures.size() - 1));
		return lreturn;
	}

	/**
	 * ローカルで読み込まれているテクスチャパックの数。
	 */
	public int getTextureCount() {
		return textures.size();
	}

	public ModchuModel_TextureBoxBase getNextArmorPackege(ModchuModel_TextureBoxBase pNowBox) {
		// 次のテクスチャパッケージの名前を返す
		boolean f = false;
		ModchuModel_TextureBoxBase lreturn = null;
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb.hasArmor()) {
				if (f) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				f = true;
			}
		}
		if (lreturn != null); else {
			for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
				ModchuModel_TextureBoxBase ltb = en.getValue();
				if (ltb.hasArmor()) return ltb;
			}
		}
		return lreturn;
	}

	public ModchuModel_TextureBoxBase getPrevArmorPackege(ModchuModel_TextureBoxBase pNowBox) {
		// 前のテクスチャパッケージの名前を返す
		ModchuModel_TextureBoxBase lreturn = null;
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb == pNowBox) {
				if (lreturn != null) {
					break;
				}
			}
			if (ltb.hasArmor()) {
				lreturn = ltb;
			}
		}
		if (lreturn != null); else {
			ModchuModel_TextureBoxBase ltb1 = null;
			for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
				ModchuModel_TextureBoxBase ltb = en.getValue();
				if (ltb.hasArmor()) ltb1 = ltb;
			}
			return ltb1;
		}
		return lreturn;
	}

	public String getRandomTextureString(Random pRand, boolean b) {
		return getTextureBox(pRand.nextInt(textures.size()), b).textureName;
	}

	public ModchuModel_TextureBoxBase getRandomTexture(Random pRand) {
		if (textures.isEmpty()) {
			return null;
		} else {
			// 野生色があるものをリストアップ
			List<ModchuModel_TextureBoxBase> llist = new ArrayList();
			for (Entry<String, ModchuModel_TextureBoxBase> en : ((Map<String, ModchuModel_TextureBoxBase>) textures).entrySet()) {
				ModchuModel_TextureBoxBase lbox = en.getValue();
				if (lbox.getWildColorBits() > 0) {
					llist.add(lbox);
				}
			}
			return llist.get(pRand.nextInt(llist.size()));
		}
	}

	/**
	 * テクスチャパック名に対応するインデックスを返す。
	 * 基本サーバー用。
	 * @param entity
	 * @param pPackName
	 * @return
	 */
/*
	public int getIndexTextureBoxServer(Modchu_ITextureEntityBase entity, String pPackName) {
		for (int li = 0; li < textureServer.size(); li++) {
			if (textureServer.get(li).textureName.equals(pPackName)) {
				return li;
			}
		}
		// 見当たらなかったのでEntityに対応するデフォルトを返す
//		int li = textureServerIndex.get(getDefaultTexture(entity));
		Modchu_TextureBoxBase lbox = getDefaultTexture(entity);
		if (lbox != null) {
			pPackName = lbox.textureName;
			for (int li = 0; li < textureServer.size(); li++) {
				if (textureServer.get(li).textureName.equals(pPackName)) {
					return li;
				}
			}
		}
		return 0;
	}
*/
	/**
	 * 指定されたテクスチャパックのサーバー側の管理番号を返す。
	 * @param pBox
	 * @return
	 */
/*
	public int getIndexTextureBoxServerIndex(ModchuModel_TextureBoxBase pBox) {
		return textureServerIndex.get(pBox);
	}
*/
	/**
	 * Entityに対応するデフォルトのテクスチャを設定する。
	 */
/*
	public void setDefaultTexture(Modchu_ITextureEntityBase entity, Modchu_TextureBoxBase pBox) {
		setDefaultTexture(entity.getClass(), pBox);
	}

	public void setDefaultTexture(Class entityClass, ModchuModel_TextureBoxBase pBox) {
		defaultTextures.put(entityClass, pBox);
		Modchu_Debug.tDebug("appendDefaultTexture:%s(%s)",
				entityClass.getSimpleName(), pBox == null ? "NULL" : pBox.textureName);
	}
*/
	/**
	 * Entityに対応するデフォルトモデルを返す。
	 */
/*
	public Modchu_TextureBoxBase getDefaultTexture(Modchu_ITextureEntityBase entity) {
		return getDefaultTexture(entity.getClass());
	}
*/
/*
	public ModchuModel_TextureBoxBase getDefaultTexture(Class entityClass) {
		if (defaultTextures.containsKey(entityClass)) {
			return defaultTextures.get(entityClass);
		} else {
			Class lsuper = entityClass.getSuperclass();
			if (lsuper != null) {
				ModchuModel_TextureBoxBase lbox = getDefaultTexture(lsuper);
				if (lbox != null) {
					setDefaultTexture(entityClass, lbox);
				}
				return lbox;
			}
			return null;
		}
	}
*/
	/*
	 * サーバークライアント間でのテクスチャ管理関数群
	 */
	// ネットワーク越しにテクスチャインデクスを得る際に使う
/*
	public int getRequestStringIndex(String pVal) {
		int lblank = -1;
		for (int li = 0; li < requestString.length; li++) {
			if (requestString[li] == null) {
				lblank = li;
				requestStringCounter[li] = 0;
			} else if (requestString[li].equals(pVal)) {
				// 既に要求中
				return -2;
			}
		}
		if (lblank >= 0) {
			requestString[lblank] = pVal;
		} else {
			Modchu_Debug.tDebug("requestString Overflow!");
		}
		return lblank;
	}

	public String getRequestString(int pIndex) {
		String ls = requestString[pIndex];
		requestString[pIndex] = null;
		return ls;
	}

	public int getRequestIndex(int pTextureServerBoxIndex) {
		int lblank = -1;
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == -1) {
				lblank = li;
				requestIndexCounter[li] = 0;
			} else if (requestIndex[li] == pTextureServerBoxIndex) {
				// 既に要求中
				return -2;
			}
		}
		if (lblank >= 0) {
			requestIndex[lblank] = pTextureServerBoxIndex;
		} else {
			Modchu_Debug.tDebug("requestIndex Overflow!");
		}
		return lblank;
	}

	public boolean clearRequestIndex(int pTextureServerBoxIndex) {
		for (int li = 0; li < requestIndex.length; li++) {
			if (requestIndex[li] == pTextureServerBoxIndex) {
				// 要求中だったので消す。
				requestIndex[li] = -1;
				return true;
			}
		}
		return false;
	}

	public ModchuModel_TextureBoxBase getTextureBoxServerIndex(int pIndex) {
		for (Entry<ModchuModel_TextureBoxBase, Integer> le : textureServerIndex.entrySet()) {
			if (le.getValue() == pIndex) {
				return le.getKey();
			}
		}
		return null;
	}
*/

	/**
	 * テクスチャパックを設定するため、サーバーへ情報を送る。
	 * @param entity
	 * @param pBox
	 */
/*
	public void postSetTexturePack(Modchu_ITextureEntityBase entity, int pColor, ModchuModel_TextureBoxBase[] pBox) {
		// Client
		if (!(entity instanceof Entity)) return;
		// テクスチャパックを設定するため、サーバーへ情報を送る。
		int lindex[] = new int[pBox.length];
		boolean lflag = true;

		// PackeNameからサーバー側のテクスチャインデックスを獲得する。
		for (int li = 0; li < pBox.length; li++) {
			lindex[li] = checkTextureBoxServer((ModchuModel_TextureBox)pBox[li]);
			if (lindex[li] < 0) {
				lflag = false;
			}
		}

		if (lflag) {
			// すべての名称からインデックスを取り出せた場合、サーバーへポストする。
			sendToServerSetTexturePackIndex(entity, pColor, lindex);
		} else {
			// ローカルに設定値がない場合、バッファにジョブをスタックし終了。
			Object lo[] = new Object[1 + pBox.length];
			lo[0] = pColor;
			for (int li = 0; li < pBox.length; li++) {
				lo[li + 1] = pBox[li];
			}
			stackSetTexturePack.put(entity, lo);
		}
	}
*/
	/**
	 * TextureBoxにサーバー識別番号が付与されているかを確認し、なければ問い合わせを行う。
	 * @param pBox
	 * @return
	 */
/*
	public int checkTextureBoxServer(ModchuModel_TextureBox pBox) {
		// Client
		if (textureServerIndex.containsKey(pBox)) {
			return textureServerIndex.get(pBox);
		} else {
			int ll = getRequestStringIndex(pBox.textureName);
			if (ll > -1) {
				sendToServerGetTextureIndex(ll, pBox);
				return -1;
			} else {
				return ll;
			}
		}
	}

	public void sendToServerSetTexturePackIndex(Modchu_ITextureEntityBase entity, int pColor, int[] pIndex) {
		// Client
		// サーバー側へテクスチャパックのインデックスが変更されたことを通知する。
		if (entity instanceof Entity) {
			byte ldata[] = new byte[6 + pIndex.length * 2];
			ldata[0] = ModchuModel_Statics.Server_SetTexturePackIndex;
			ModchuModel_Helper.setInt(ldata, 1, ((Entity)entity).entityId);
			ldata[5] = (byte)pColor;
			int li = 6;
			for (int ll  : pIndex) {
				ModchuModel_Helper.setShort(ldata, li, ll);
				li += 2;
			}
			ModchuModel_Client.sendToServer(ldata);
		}
	}

	public void reciveFromClientSetTexturePackIndex(Entity entity, byte[] pData) {
		// Server
		if (entity instanceof Modchu_ITextureEntityBase) {
			// クライアント側からテクスチャパックのインデックスが変更された通知を受け取ったので処理を行う。
			int lcount = (pData.length - 6) / 2;
			if (lcount < 1) return;
			int lindex[] = new int[lcount];

			for (int li = 0; li < lcount; li++) {
				lindex[li] = ModchuModel_Helper.getShort(pData, 6 + li * 2);
			}
			Modchu_Debug.tDebug("reciveFromClientSetTexturePackIndex: %d, %4x", pData[5], lindex[0]);
			((Modchu_ITextureEntityBase)entity).setTexturePackIndex(pData[5], lindex);
		}
	}

	public void sendToServerGetTextureIndex(int pBufIndex, ModchuModel_TextureBox pBox) {
		// Client
		// サーバー側へテクスチャパックの管理番号を問い合わせる。
		// 呼び出し側のクライアントへのみ返す。
		// 返すときはNameは不要、BufIndexのみで識別させる
		byte ldata[] = new byte[22 + pBox.textureName.length()];
		ldata[0] = ModchuModel_Statics.Server_GetTextureIndex;
		ldata[1] = (byte)pBufIndex;
		ModchuModel_Helper.setShort(ldata, 2, pBox.getContractColorBits());
		ModchuModel_Helper.setShort(ldata, 4, pBox.getWildColorBits());
		ModchuModel_Helper.setFloat(ldata, 6, pBox.getHeight(null));
		ModchuModel_Helper.setFloat(ldata, 10, pBox.getWidth(null));
		ModchuModel_Helper.setFloat(ldata, 14, pBox.getYOffset(null));
		ModchuModel_Helper.setFloat(ldata, 18, pBox.getMountedYOffset(null));
		ModchuModel_Helper.setStr(ldata, 22, pBox.textureName);
		ModchuModel_Client.sendToServer(ldata);
		Modchu_Debug.tDebug("Server_GetTextureIndex: %s", pBox.textureName);
	}

	public void reciveFromClientGetTexturePackIndex(NetServerHandler pHandler, byte[] pData) {
		// Server
		// クライアント側へテクスチャパックの管理番号を返す。
		String lpackname = ModchuModel_Helper.getStr(pData, 22);
		ModchuModel_TextureBoxServer lboxsrv = getTextureBoxServer(lpackname);
		int li;
		if (lboxsrv == null) {
			li = textureServer.size();
			lboxsrv = new ModchuModel_TextureBoxServer();
			textureServer.add(lboxsrv);
		} else {
			li = textureServer.indexOf(lboxsrv);
		}
		lboxsrv.setValue(pData);

		byte ldata[] = new byte[4];
		ldata[0] = ModchuModel_Statics.Client_SetTextureIndex;
		ldata[1] = pData[1];
		ModchuModel_Helper.setShort(ldata, 2, li);
		Modchu_Debug.tDebug("reciveFromClientGetTexturePackIndex: %s, %04x", lpackname, li);
		Modchu_Debug.sendToClient(pHandler, ldata);
	}

	public void reciveFormServerSetTexturePackIndex(byte[] pData) {
		// Client
		// サーバー側からテクスチャパックのインデックスを受け取ったので値を登録する。
		ModchuModel_TextureBox lbox = getTextureBox(getRequestString(pData[1]));
		textureServerIndex.put(lbox, (int)ModchuModel_Helper.getShort(pData, 2));
		Modchu_Debug.tDebug("reciveFormServerSetTexturePackIndex: %s, %04x", lbox.textureName, (int)ModchuModel_Helper.getShort(pData, 2));

		// スタックされたジョブから処理可能な物があれば実行する。
		Map<Modchu_ITextureEntityBase, Object[]> lmap = new HashMap<Modchu_ITextureEntityBase, Object[]>(stackSetTexturePack);
		stackSetTexturePack.clear();
		for (Entry<Modchu_ITextureEntityBase, Object[]> le : lmap.entrySet()) {
			Object lo[] = le.getValue();
			ModchuModel_TextureBox ls[] = new ModchuModel_TextureBox[le.getValue().length - 1];
			int lc = (Integer)lo[0];
			for (int li = 1; li < lo.length; li++) {
				ls[li - 1] = (ModchuModel_TextureBox)lo[li];
			}
			postSetTexturePack(le.getKey(), lc, ls);
		}
	}
*/


	/**
	 * サーバーから設定されたテクスチャインデックスからテクスチャパックを取得する。
	 * @param entity
	 * @param pIndex
	 */
/*
	public void postGetTexturePack(Modchu_ITextureEntityBase entity, int[] pIndex) {
		// Client
		// クライアント側で指定されたインデックスに対してテクスチャパックの名称を返し設定させる
		ModchuModel_TextureBox lbox[] = new ModchuModel_TextureBox[pIndex.length];
		boolean lflag = true;

		// ローカルインデックスに名称が登録されていなければサーバーへ問い合わせる。
		for (int li = 0; li < pIndex.length; li++) {
			lbox[li] = getTextureBoxServerIndex(pIndex[li]);
			if (lbox[li] == null) {
				if (getRequestIndex(pIndex[li]) > -1) {
					sendToServerGetTexturePackName(pIndex[li]);
				}
				lflag = false;
			}
		}

		if (lflag) {
			// 全ての値が取れる場合はEntityへ値を設定する。
			entity.setTexturePackName(lbox);
		} else {
			// 不明値がある場合は処理をスタックする。
			stackGetTexturePack.put(entity, pIndex);
		}
	}

	public void sendToServerGetTexturePackName(int pIndex) {
		// Client
		// サーバー側へテクスチャパックの名称を問い合わせる
		if (pIndex < 0) {
			Modchu_Debug.tDebug("request range out.");
			return;
		}
		byte ldata[] = new byte[3];
		ldata[0] = ModchuModel_Statics.Server_GetTexturePackName;
		ModchuModel_Helper.setShort(ldata, 1, pIndex);
		ModchuModel_Client.sendToServer(ldata);
	}

	public void reciveFromClientGetTexturePackName(NetServerHandler pHandler, byte[] pData) {
		// Server
		// クライアントからテクスチャパックの名称が問い合わせられた。
		int lindex = ModchuModel_Helper.getShort(pData, 1);
		ModchuModel_TextureBoxServer lboxserver = getTextureBoxServer(lindex);

		// Clientへ管理番号に登録されているテクスチャ名称をポストする
		byte ldata[] = new byte[23 + lboxserver.textureName.length()];
		ldata[0] = ModchuModel_Statics.Client_SetTexturePackName;
		ModchuModel_Helper.setShort(ldata, 1, lindex);
		ModchuModel_Helper.setShort(ldata, 3, lboxserver.getContractColorBits());
		ModchuModel_Helper.setShort(ldata, 5, lboxserver.getWildColorBits());
		ModchuModel_Helper.setFloat(ldata, 7, lboxserver.getHeight(null));
		ModchuModel_Helper.setFloat(ldata, 11, lboxserver.getWidth(null));
		ModchuModel_Helper.setFloat(ldata, 15, lboxserver.getYOffset(null));
		ModchuModel_Helper.setFloat(ldata, 19, lboxserver.getMountedYOffset(null));
		ModchuModel_Helper.setStr(ldata, 23, lboxserver.textureName);
		Modchu_Debug.sendToClient(pHandler, ldata);
		Modchu_Debug.tDebug("SetTexturePackName:%04x - %s", lindex, lboxserver.textureName);
	}

	public void reciveFromServerSetTexturePackName(byte[] pData) {
		// Client
		// サーバーからインデックスに対する名称の設定があった。
		String lpackname = ModchuModel_Helper.getStr(pData, 23);
		ModchuModel_TextureBox lbox = getTextureBox(lpackname);
		if (lbox == null) {
			// ローカルには存在しないテクスチャパック
			lbox = getTextureBox("default_Orign").duplicate();
			lbox.textureName = lpackname;
//			lbox = new ModchuModel_TextureBox(lpackname, null);
			lbox.setModelSize(
					ModchuModel_Helper.getFloat(pData, 7),
					ModchuModel_Helper.getFloat(pData, 11),
					ModchuModel_Helper.getFloat(pData, 15),
					ModchuModel_Helper.getFloat(pData, 19));
			textures.add(lbox);
		}
		int lindex = ModchuModel_Helper.getShort(pData, 1);
		textureServerIndex.put(lbox, lindex);
		clearRequestIndex(lindex);

		// 処理可能な物がスタックされている場合は処理を行う。
		Map<Modchu_ITextureEntityBase, int[]> lmap = new HashMap<Modchu_ITextureEntityBase, int[]>(stackGetTexturePack);
		stackGetTexturePack.clear();
		for (Entry<Modchu_ITextureEntityBase, int[]> le : lmap.entrySet()) {
			postGetTexturePack(le.getKey(), le.getValue());
		}
	}
*/
	/**
	 * Request系の値を一定カウントで消去
	 * @param file
	 */
/*
	public void onUpdate() {
		for (int li = 0; li < requestString.length; li++) {
			// 約30秒で解放
			if (requestString[li] != null && requestStringCounter[li]++ > 600) {
				requestString[li] = null;
				requestStringCounter[li] = 0;
			}
			if (requestIndex[li] != -1 && requestIndexCounter[li]++ > 600) {
				requestIndex[li] = -1;
				requestIndexCounter[li] = 0;
			}
		}
	}
*/
	public LinkedList<String> getSearchSettledList(File file) {
		String path = file.getAbsolutePath();
		LinkedList<String> searchSettledList = null;
		if (!searchSettledListMap.containsKey(path)) {
			searchSettledList = new LinkedList();
			searchSettledListMap.put(path, searchSettledList);
		} else {
			searchSettledList = searchSettledListMap.get(path);
		}
		return searchSettledList;
	}

	// TODO add Modchu
	public Object[] modelNewInstance(Object entity, String s, boolean b, boolean useCustom, Object[] option) {
		return modelNewInstance(entity, s, b, useCustom, option, true);
	}

	public Object[] modelNewInstance(Object entity, String s, boolean b, boolean useCustom, Object[] option, boolean debug) {
		if (s != null
				&& !s.isEmpty()); else return null;
		Map<String, Object[]> map = null;
		Object[] models = null;
		s = textureNameCheck(s);
		String s1 = Modchu_Main.lastIndexProcessing(s, "_");
		if (entity != null) map = entityModelMapData.get(entity);
		else map = dummyModelMapData;
		if (!b) {
			if (map != null) {
				models = map.get(s);
				if (models != null
						&& models[0] != null
						&& models[1] != null
						&& models[2] != null) {
					if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 1 return models. s="+s);
					return models;
				} else {
					if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 1 models == null s="+s);
				}
			}
		}
		if (map != null); else {
			map = new HashMap<String, Object[]>();
			//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase modelNewInstance map = new HashMap");
		}
		if (debug) Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase modelNewInstance 2 s1="+s1+" modelNewInstanceNgList.contains(s1)="+modelNewInstanceNgList.contains(s1));
		models = modelNewInstanceNgList.contains(s1) ? null : modelNewInstance(s, useCustom, option);
		if (debug) Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase modelNewInstance 2.5 models="+models);
		if (models != null
				&& models[0] != null
				&& models[1] != null
				&& models[2] != null) {
			map.put(s, models);
			if (entity != null) entityModelMapData.put(entity, map);
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 3 return models="+models);
			return models;
		}
		if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 4 return models="+models);
		return models;
	}

	public Object[] modelNewInstance(String s, boolean useCustom, Object[] option) {
		if (s != null
				&& !s.isEmpty()); else return null;
		boolean debug = false;
		Object[] models = new Object[3];
/*
		String s1 = s != null ? Modchu_Main.lastIndexProcessing(s, "_") : s;
		boolean defaultFlag = s1 != null
				&& (defaultModelName != null
				&& s1.indexOf(defaultModelName) > -1);
		String s2 = defaultFlag ? "modchu.model.multimodel.base.MultiModel" : new StringBuilder().append(modelClassName).append("_").append(s1).toString();
		String s3 = getModelClassName(s2);
*/
		//Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance s3="+s3);
		Class c = null;
		if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-1 s="+s);
		String s1 = Modchu_Main.lastIndexProcessing(s, "_");
		if (s1.startsWith("Custom")) {
			 s1 = s1.substring(6);
			option = new Object[]{ s1 };
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-1_2 Custom s1="+s1);
		}
		if (s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) < 0) {
			String s2 = getModelClassName(s);
			c = s2 != null && !s2.isEmpty() ? Modchu_Reflect.loadClass(s2, -1) : null;
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-2 s1="+s2+" c="+c);
		}
		if (c != null) {
			Object o = modelNewInstance(c, new Class[]{ float.class, float.class, int.class, int.class, Object[].class }, new Object[]{ 0.0F, 0.0F, -1, -1, option });
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-3 o="+o);
			if (o != null); else {
				o = modelNewInstance(c, new Class[]{ float.class }, new Object[]{ 0.0F });
			}
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-4 o="+o);
			MultiModelBaseBiped multiModelBaseBiped = o != null
					&& o instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) o : null;
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-5 multiModelBaseBiped="+multiModelBaseBiped);
			if (multiModelBaseBiped != null) {
				models[0] = multiModelBaseBiped;
/*//125delete
				if (isSmartMoving
						&& mod_pflm_playerformlittlemaid.playerFormLittleMaidVersion <= 124) {
					boolean isBiped = modc_PFLM_PlayerFormLittleMaid.BipedClass != null ?
							modc_PFLM_PlayerFormLittleMaid.BipedClass.isInstance(models[0]) : s.equalsIgnoreCase("Biped");
					float[] f1 = new float[2];
					f1[0] = isBiped ? 0.5F : 0.1F;
					f1[1] = isBiped ? 1.0F : 0.5F;
					//Modchu_Debug.mDebug("4modelNewInstance o != null isBiped="+isBiped);
					models[1] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, int.class, int.class }, new Object[]{ f1[0], MultiModelSmart.NoScaleStart, MultiModelSmart.Scale });
					models[2] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, int.class, int.class }, new Object[]{ f1[1], MultiModelSmart.NoScaleStart, MultiModelSmart.NoScaleEnd });
					//Modchu_Debug.mDebug("5modelNewInstance o != null models[1] != null ? "+(models[1] != null));
				} else {
*///125delete
					float[] f1 = getArmorModelsSize(models[0]);
					if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-6 getArmorModelsSize f1[0]="+f1[0]+" f1[1]="+f1[1]);
					o = modelNewInstance(c, new Class[]{ float.class, float.class, int.class, int.class, Object[].class }, new Object[]{ f1[0], 0.0F, -1, -1, option });
					if (o != null); else {
						o = modelNewInstance(c, new Class[]{ float.class }, new Object[]{ f1[0] });
					}
					models[1] = o != null
							&& o instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) o : null;
					o = modelNewInstance(c, new Class[]{ float.class, float.class, int.class, int.class, Object[].class }, new Object[]{ f1[1], 0.0F, -1, -1, option });
					if (o != null); else {
						o = modelNewInstance(c, new Class[]{ float.class }, new Object[]{ f1[1] });
					}
					models[2] = o != null
							&& o instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) o : null;
/*//125delete
				}
*///125delete
			} else {
				Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-7 multiModelBaseBiped == null !! s="+s);
			}
		} else {
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-8 c == null s="+s);
			String s4 = Modchu_Main.lastIndexProcessing(s, "_");
			if (s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) > -1) {
				String s5 = Modchu_Main.lastIndexProcessing(s.substring(0, s.indexOf(";")), "_");
				if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-9 s5="+s5);
				Object[] mlm = Modchu_LMMManager.getLMMTextureManagerModels(s5);
				if (mlm != null) {
					if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-10 mlm="+mlm);
					Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
					if (ModchuLmmModel != null) {
						models = newMultiModelLMMModel(mlm);
					}
				} else {
					if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-11 mlm == null !!");
				}
			}
			else if (s4 != null
					&& s4.startsWith("Custom")) {
				Object[] o1 = newMultiModelOtherModel(s4);
				if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-12 c == null o1="+o1);
				if (o1 != null) {
					models = o1;
					if (debug) {
						Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-13 c == null models="+models);
						Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-13 c == null models[0]="+models[0]);
						Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-13 c == null models[1]="+models[1]);
						Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-13 c == null models[2]="+models[2]);
					}
				} else {
					s4 = Modchu_Main.lastIndexProcessing(s4, "Custom");
					if (s4 != null
							&& !s4.isEmpty()) {
						Object[] o0 = new Object[]{ s4 };
						models[0] = new MultiModelCustom(0.0F, 0.0F, 64, 32, o0);
						if (models[0] != null) {
							float[] lsize = ((MultiModelCustom) models[0]).getArmorModelsSize();
							models[1] = new MultiModelCustom(lsize[0], 0.0F, 64, 32, o0);
							models[2] = new MultiModelCustom(lsize[1], 0.0F, 64, 32, o0);
						}
						if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-14 c == null MultiModelCustom models="+models);
					} else {
						if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-15 c == null s == null !!");
					}
				}
			}
			if (models != null); else {
				Modchu_Debug.systemLogDebug("ModchuModel_TextureManagerBase modelNewInstance 2-16 null error !! s="+s);
			}
		}
		if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-17 return models="+models);
		return models;
	}

	private Object modelNewInstance(Class c, Class[] c1, Object[] o) {
		if (c != null); else return null;
		Object o1 = null;
		try {
			Constructor co = Modchu_Reflect.getConstructor(c, c1, -1);
			if (co != null) o1 = Modchu_Reflect.newInstance(c, c1, o);
		} catch(Exception e) {
			Modchu_Debug.systemLogDebug("ModchuModel_TextureManagerBase modelNewInstance newInstance Exception !!");
			Modchu_Debug.systemLogDebug("", e);
		}
		return o1;
	}

	public Object[] newModelCustom(Object[] models, String s) {
		return newModelCustom(models, s, null);
	}

	public Object[] newModelCustom(Object[] models, String s, HashMap map) {
		Class c = MultiModelCustom.class;
		float[] f1;
		if (models != null); else {
/*
			models = new MultiModel[3];
			models[0] = new MultiModel(0.0F);
			f1 = ((MultiModel) models[0]).getArmorModelsSize();
			models[1] = new MultiModel(f1[0]);
			models[2] = new MultiModel(f1[1]);
*/
			Modchu_Debug.mlDebug1("newModelCustom models == null !! return s="+s);
			return null;
		}
		if (s.indexOf("_") < 0
				| c.isInstance(models[0])) {
			if (s.indexOf("_") < 0) Modchu_Debug.mlDebug1("newModelCustom s.indexOf(\"_\") < 0 return s="+s);
			if (c.isInstance(models[0])) Modchu_Debug.mlDebug1("newModelCustom c.isInstance(models[0]) return s="+s);
			return models;
		}
		//Modchu_Debug.mlDebug1("newModelCustom s="+s+" models[0].getClass()="+(models[0] != null ? models[0].getClass() : null));
		if (models[0] != null
				&& models[0] instanceof MultiModelBaseBiped); else {
			Modchu_Debug.lDebug("newModelCustom !MultiModelBaseBiped return null !! models[0]="+models[0]);
			return null;
		}
		if (models[1] != null
				&& models[1] instanceof MultiModelBaseBiped); else {
			Modchu_Debug.lDebug("newModelCustom !MultiModelBaseBiped return null !! models[1]="+models[1]);
			return null;
		}
		if (models[2] != null
				&& models[2] instanceof MultiModelBaseBiped); else {
			Modchu_Debug.lDebug("newModelCustom !MultiModelBaseBiped return null !! models[2]="+models[2]);
			return null;
		}
		Object[] newModels = new Object[3];
		newModels[0] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, MultiModelBaseBiped.class, String.class, HashMap.class }, new Object[]{ 0.0F, models[0], s, map});
		//Modchu_Debug.lDebug("newModelCustom newModels[0]="+newModels[0]);
		if (newModels[0] != null); else {
			Modchu_Debug.lDebug("newModelCustom newInstance error !! newModels[0] == null !!");
			return null;
		}
		if (models[1] != null) {
			f1 = getArmorModelsSize(models[1]);
			newModels[1] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, MultiModelBaseBiped.class, String.class, HashMap.class }, new Object[]{ f1[0], models[1], s, map });
		}
		if (models[2] != null) {
			f1 = getArmorModelsSize(models[2]);
			newModels[2] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, MultiModelBaseBiped.class, String.class, HashMap.class }, new Object[]{ f1[1], models[2], s, map });
		}
		//Modchu_Debug.lDebug("newModelCustom return newModels[0]="+newModels[0]);
		return newModels;
	}

	public Object[] newOtherModel(String s) {
		Object[] o = otherModelDataMap.get(s);
		if (o != null); else return null;
		Map tempMap = (Map) o[0];
		String tempOtherCustomModelClassName = Modchu_CastHelper.String(tempMap.get("tempOtherCustomModelClassName"));
		String tempOtherCustomModelArmorClassName0 = Modchu_CastHelper.String(tempMap.containsKey("tempOtherCustomModelArmorClassName0") ? tempMap.get("tempOtherCustomModelArmorClassName0") : null);
		String tempOtherCustomModelArmorClassName1 = Modchu_CastHelper.String(tempMap.containsKey("tempOtherCustomModelArmorClassName1") ? tempMap.get("tempOtherCustomModelArmorClassName1") : null);
		Class[] tempOtherCustomOtherConstructor = Modchu_CastHelper.ClassArray(tempMap.containsKey("tempOtherCustomOtherConstructor") ? tempMap.get("tempOtherCustomOtherConstructor") : null);
		Object[] tempOtherCustomOtherConstructorObject = Modchu_CastHelper.ObjectArray(tempMap.containsKey("tempOtherCustomOtherConstructorObject") ? tempMap.get("tempOtherCustomOtherConstructorObject") : null);
		float[] tempOtherCustomModelSize = Modchu_CastHelper.FloatArray(tempMap.containsKey("tempOtherCustomModelSize") ? tempMap.get("tempOtherCustomModelSize") : new float[]{ 0.0F, 0.0F, 0.0F });
		float[] tempOtherCustomModelPositionCorrection = Modchu_CastHelper.FloatArray(tempMap.containsKey("tempOtherCustomModelPositionCorrection") ? tempMap.get("tempOtherCustomModelPositionCorrection") : new float[]{ 0.0F, 0.0F, 0.0F });
		float tempOtherCustomModelGuiViewScale = Modchu_CastHelper.Float(tempMap.containsKey("tempOtherCustomModelGuiViewScale") ? tempMap.get("tempOtherCustomModelGuiViewScale") : 1.0F);
		boolean tempOtherCustomModelIsChild = Modchu_CastHelper.Boolean(tempMap.containsKey("tempOtherCustomModelIsChild") ? tempMap.get("tempOtherCustomModelIsChild") : true);

		Object[] o1 =newOtherModel(tempOtherCustomModelClassName, tempOtherCustomModelArmorClassName0, tempOtherCustomModelArmorClassName1, tempOtherCustomOtherConstructor, tempOtherCustomOtherConstructorObject, tempOtherCustomModelSize, tempOtherCustomModelIsChild);
		if (o1 != null); else {
			Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance new model failure !! tempOtherCustomModelClassName="+tempOtherCustomModelClassName);
			return null;
		}
		return o1;
	}

	public Object[] newOtherModel(String s, String s1, String s2, Class[] c, Object[] o, float[] f, boolean isChild) {
		Object[] models = new Object[3];
		float[] f1 = f != null ? f : new float[]{
				0.0F, 0.5F, 1.0F
		};
		//Modchu_Debug.mDebug("newOtherModel s="+s);
		models[0] = getNewInstanceOtherModel(s, c, o, f1[0]);
		if (models[0] != null); else return null;
		Modchu_AS.set(Modchu_AS.modelBaseIsChild, models[0], isChild);
		models[1] = s1 != null
				&& !s1.isEmpty() ? getNewInstanceOtherModel(s1, c, o, f1[1]) : null;
		Modchu_AS.set(Modchu_AS.modelBaseIsChild, models[1], isChild);
		models[2] = s2 != null
				&& !s2.isEmpty() ? getNewInstanceOtherModel(s2, c, o, f1[2]) : null;
		Modchu_AS.set(Modchu_AS.modelBaseIsChild, models[2], isChild);
		return models;
	}

	public Object[] newMultiModelOtherModel(String s) {
		Object[] o1 = newOtherModel(s);
		if (o1 != null) {
			Object[] o = otherModelDataMap.get(s);
			if (o != null) {
				Map map = (Map) o[1];
				return newMultiModelOtherModel(o1, (HashMap<String, Object>) map);
			}
		}
		return null;
	}

	public MultiModelOtherModel[] newMultiModelOtherModel(Object[] models, HashMap<String, Object> map) {
		MultiModelOtherModel[] newModels = new MultiModelOtherModel[3];
		newModels[0] = new MultiModelOtherModel(0.0F, models[0], map);
		float[] f1 = newModels[0].getArmorModelsSize();
		newModels[1] = new MultiModelOtherModel(f1[0], models[1], map);
		newModels[2] = new MultiModelOtherModel(f1[1], models[2], map);
		return newModels;
	}

	public MultiModelLMMModel[] newMultiModelLMMModel(Object[] models) {
		MultiModelLMMModel[] newModels = new MultiModelLMMModel[3];
		//Modchu_Debug.mDebug("newMultiModelLMMModel models[0]="+models[0]);
		Class ModchuLmmModel = Modchu_LMMManager.getModchuLmmModelClass();
		// 逆輸入チェック
		if (models[0] instanceof MultiModelBaseBiped
				| ModchuLmmModel.isInstance(models[0])) {
			if (models[0] instanceof MultiModelBaseBiped) Modchu_Main.setRuntimeException("newMultiModelLMMModel models[0] instanceof MultiModelBaseBiped error !! models[0]="+models[0]);
			if (ModchuLmmModel.isInstance(models[0])) Modchu_Main.setRuntimeException("newMultiModelLMMModel ModchuLmmModel.isInstance(models[0]) error !! models[0]="+models[0]);
			return null;
		}
		newModels[0] = new MultiModelLMMModel(0.0F, models[0]);
		float[] f1 = newModels[0].getArmorModelsSize();
		newModels[1] = new MultiModelLMMModel(f1[0], models[1]);
		newModels[2] = new MultiModelLMMModel(f1[1], models[2]);
		return newModels;
	}

	private Object getNewInstanceOtherModel(String s, Class[] c, Object[] o, float f) {
		if (c != null) {
			if (Modchu_Reflect.getConstructor(s, c, -1) != null) {
				return Modchu_Reflect.newInstance(s, c, o);
			}
		}
		int mode = Modchu_Reflect.getConstructor(s, new Class[]{ float.class }, -1) != null ? 0 : Modchu_Reflect.getConstructor(s, new Class[]{ float.class, boolean.class }, -1) != null ? 1 : -1;
		switch (mode) {
		case -1:
			return Modchu_Reflect.newInstance(s);
		case 0:
			return Modchu_Reflect.newInstance(s, new Class[]{ float.class }, new Object[]{ f });
		case 1:
			return Modchu_Reflect.newInstance(s, new Class[]{ float.class, boolean.class }, new Object[]{ f, false });
		}
		return null;
	}

	public String getModelClassName(String s) {
		//Modchu_Debug.mDebug("getModelClassName s="+s);
		s = Modchu_Main.lastIndexProcessing(s, "_");
		if (modelClassNameMap.containsKey(s)) return modelClassNameMap.get(s);
		return null;
	}

	public String[] getMissingModelClassData(String s) {
		//Modchu_Debug.mDebug("getMissingModelClassName s="+s);
		s = Modchu_Main.lastIndexProcessing(s, "_");
		if (missingModelClassDataMap.containsKey(s)) return missingModelClassDataMap.get(s);
		return null;
	}

	public float[] getArmorModelsSize(Object o) {
		Object o1 = Modchu_Reflect.invokeMethod(o.getClass(), "getArmorModelsSize", o, -1);
		return o1 != null ? Modchu_CastHelper.FloatArray(o1) : new float[]{ 0.1F, 0.5F };
	}

	public String getPackege(int i, int j, boolean b) {
		return getTextureBoxTextureName(getTextureManagerTextures(j, b));
	}

	public String getModelSpecificationArmorPackege(String s, boolean b) {
		s = Modchu_Main.lastIndexProcessing(s, "_");
		String s1 = null;
		ModchuModel_TextureBoxBase ltb;
		for (int i = 0 ; i < textures.size() ; ++i) {
			ltb = getTextureManagerTextures(i, b);
			if (getTextureBoxHasArmor(ltb)) {
				String s2 = Modchu_Main.lastIndexProcessing(getTextureBoxTextureName(ltb), "_");
				if (s2 != null
						&& !s2.isEmpty()
						&& s2.equalsIgnoreCase(s)) {
					//Modchu_Debug.mDebug("ltb.packegeName="+getTextureBoxFileName(ltb));
					return getTextureBoxFileName(ltb);
				}
			}
		}
		return null;
	}

	public Object[] getTextureModels(Object entity, String s, Object[] option) {
		return getTextureModels(entity, s, false, false, option);
	}

	public Object[] getTextureModels(Object entity, String s, boolean b, boolean b1, Object[] option) {
		return modelNewInstance(entity, s, b, true, option);
	}

	public ModchuModel_TextureBoxBase getTextureBox(int i, boolean b) {
		return getTextureManagerTextures(i, b);
	}

	public Object[] getTextureModels(Object entity, int i, boolean b1, Object[] option) {
		return getTextureModels(entity, i, false, b1, option);
	}

	public Object[] getTextureModels(Object entity, int i, boolean b, boolean b1, Object[] option) {
		ModchuModel_TextureBoxBase ltb = getTextureManagerTextures(i, b1);
		return ltb != null ? modelNewInstance(entity, getTextureBoxTextureName(ltb), b, true, option) : null;
	}

	public Object checkTexturePackege(String s, int i) {
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (ltb != null) {
			Object resourceLocation = textureManagerGetTexture(s, i);
			if (resourceLocation != null) {
				//Modchu_Debug.mDebug("checkTexturePackege ok s1="+s1);
				return ltb;
			} else {
				Modchu_Debug.mDebug("checkTexturePackege resourceLocation null !! s="+s+" i="+i);
			}
		} else {
			Modchu_Debug.mDebug("checkTexturePackege ltb null !! s="+s+" i="+i);
		}
		return null;
	}

	public Object checkTextureArmorPackege(String s) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege s="+s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege ltb="+ltb);
		if (ltb != null
				&& getTextureBoxHasArmor(ltb)) {
			Object s1 = textureManagerGetArmorTexture(s, 64, Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item") }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "diamond_helmet") }));
			if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege s1="+s1);
			if (s1 != null) {
				if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege ok return. ltb.textureName="+ltb.textureName);
				return ltb;
			}
		}
		if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege return null.");
		return null;
	}

	public Object textureManagerGetTexture(String s, int i) {
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		//Modchu_Debug.mDebug("textureManagerGetTextureName s="+s+" i="+i+" ltb="+ltb);
		if (ltb != null) {
			Object o = getTextureBoxTextureName(ltb, i);
			//Modchu_Debug.mDebug("textureManagerGetTextureName return. o="+o);
			return o;
		}
		Modchu_Debug.Debug1("textureManagerGetTextureName null !! default change. s="+textureNameCheck(s)+" i="+i);
		ltb = getTextureBox(textureNameCheck(null), true);
		if (ltb != null) return getTextureBoxTextureName(ltb, i);
		return null;
	}

	public boolean textureColorChack(String s, int i) {
		s = textureNameCheck(s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (ltb != null) return getTextureBoxHasColor(ltb, i);
		//Modchu_Debug.mDebug("textureColorChack return null !! s="+s+" i="+i);
		return false;
	}

	public String textureNameCheck(String s) {
		if (s != null
				&& s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) > -1) return s;
		if (s == null
				| (s !=null
				&& s.isEmpty())) {
/*
			if (defaultModelName != null) {
				s = "default_"+defaultModelName;
				//s = "default";
				Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase textureNameCheck default setting.");
			}
			else Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase textureNameCheck defaultModelName == null !!");
*/
		} else {
			if (defaultModelName != null
					&& modelClassNameMap != null
					&& !modelClassNameMap.containsKey(s)) {
				if (s.indexOf("_") < 0) s = new StringBuilder().append(s).append("_").append(defaultModelName).toString();
				else {
					String s1 = Modchu_Main.lastIndexProcessing(s, "_");
/*
					if (s1 != null
							&& !s.isEmpty()); else {
						s = new StringBuilder().append(s).append(defaultModelName).toString();
						//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox pName="+pName);
					}
*/
				}
			}
		}
		return s;
	}

	public Object textureManagerGetArmorTexture(String s, int i, Object itemstack) {
		return textureManagerGetArmorTexture(s, i, itemstack, false);
	}

	public Object textureManagerGetArmorTexture(String s, int i, Object itemstack, boolean debug) {
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName s="+s+" i="+i+" itemstack != null ? "+(itemstack != null));
		s = textureNameCheck(s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName s="+s+" ltb="+ltb);
		if (ltb != null) {
			if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName return="+(((ModchuModel_TextureBoxBase) ltb).getArmorTextureName(i, itemstack)));
			return ((ModchuModel_TextureBoxBase) ltb).getArmorTextureName(i, itemstack);
		}
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName return null !! s="+s+" i="+i+" itemstack="+itemstack);
		return null;
	}

	public String textureManagerGetNextPackege(String s, int i, boolean b) {
		return textureManagerGetPackege(s, i, 0, b);
	}

	public String textureManagerGetPrevPackege(String s, int i, boolean b) {
		return textureManagerGetPackege(s, i, 1, b);
	}

	public String textureManagerGetPackege(String s, int i, int i1, boolean b) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureManagerGetPackege s="+s+" i="+i);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureManagerGetPackege 1 ltb="+ltb);
		if (ltb != null); else ltb = getTextureBox(0, b);
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureManagerGetPackege 2 ltb="+ltb);
		if (ltb != null) {
			ltb = i1 == 1 ? getNextPackege(ltb, i, b) :
				getPrevPackege(ltb, i, b);
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureManagerGetPackege 3 ltb="+ltb);
			return getTextureBoxTextureName(ltb);
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureManagerGetPackege return null !! s="+s+" i="+i);
		return null;
	}

	public String textureManagerGetNextArmorPackege(String s, boolean b) {
		return textureManagerGetArmorPackege(s, 0, b);
	}

	public String textureManagerGetPrevArmorPackege(String s, boolean b) {
		return textureManagerGetArmorPackege(s, 1, b);
	}

	public String textureManagerGetArmorPackege(String s, int i, boolean b) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("textureManagerGetArmorPackege s="+s+" i="+i);
		int index = -1;
		String s2 = textureNameCheck(s);
		int i2 = s != null && !s.isEmpty() ? s.lastIndexOf(defaultModelName) : -1;
		if (i2 > 1) {
			s2 = s.substring(0, i2 - 1);
		}
		//Modchu_Debug.mDebug("textureManagerGetArmorPackege s2="+s2);
		index = textureManagerGetArmorPackegeIndex(s2, b);
		if (index == -1) {
			//index = textureManagerGetArmorPackegeIndex("default", b);
			//if (index == -1) {
				if (debug) Modchu_Debug.mDebug("textureManagerGetArmorPackege return index == -1 !!");
				return null;
			//}
		}
		boolean flag = false;
		ModchuModel_TextureBoxBase ltb;
		for (int i1 = 0; i1 < textures.size(); i1++) {
			index = i == 0 ? index + 1 : index - 1;
			if (index >= textures.size()) index = 0;
			if (index < 0) index = textures.size() - 1;
			ltb = getTextureManagerTextures(index, b);
			//ltb = i == 0 ? Modchu_Reflect.invokeMethod(ModchuModel_TextureManagerBase, "getNextArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb}) :
			//Modchu_Reflect.invokeMethod(ModchuModel_TextureManagerBase, "getPrevArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb});
			if (debug) Modchu_Debug.mDebug("textureManagerGetArmorPackege index for index="+index+" s="+(String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb));
			if (getTextureBoxHasArmor(ltb)) {
				s = getTextureBoxFileName(ltb);
				if (!s.isEmpty()
						&& !s.equals(s2)) {
					//Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.textures.size()="+textures.size());
					if (debug) Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.s="+s);
					flag = true;
					break;
				}
			}
		}
		if (!flag) Modchu_Debug.mDebug("textureManagerGetArmorPackege !flag !!");
		i2 = s.lastIndexOf(defaultModelName);
		if (i2 > -1) s = s.substring(0, i2);
		if (debug) Modchu_Debug.mDebug("textureManagerGetArmorPackege return s="+s);
		return s;
	}

	private int textureManagerGetArmorPackegeIndex(String s, boolean b) {
		if (s != null); else {
			s = "default";
		}
		int i1 = s.indexOf("_");
		if (i1 < 0) {
			s = s + "_" + defaultModelName;
		}
		int index = -1;
		ModchuModel_TextureBoxBase ltb;
		for (int i = 0; i < textures.size(); i++) {
			ltb = getTextureManagerTextures(i, b);
			//Modchu_Debug.mDebug("textureManagerGetArmorPackegeIndex get "+((String) Modchu_Reflect.getFieldObject(ltb.getClass(), "textureName", ltb)));
			if (ltb != null
					&& ltb.hasArmor()
					&& getTextureBoxTextureName(ltb).equals(s)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public String[] setTexturePackege(String textureName, String textureArmorName, int color, int prevNextNormal, boolean armorOnly, boolean autoArmorSelect, boolean b) {
		boolean debug = false;
		if (!armorOnly) {
			String s = textureName;
			switch(prevNextNormal) {
			case 0:
				s = textureManagerGetPrevPackege(textureName, color, b);
				break;
			case 1:
				s = textureManagerGetNextPackege(textureName, color, b);
				break;
			case 2:
				break;
			}
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase setTexturePackege 1 s="+s);
			if (s != null
					&& !s.isEmpty()); else return null;
			textureName = s;
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase setTexturePackege autoArmorSelect="+autoArmorSelect);
			if (autoArmorSelect) {
				textureArmorName = textureName;
				String s1 = getArmorName(textureArmorName, prevNextNormal, b);
				if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase setTexturePackege s1="+s1);
				if (s1 != null
						&& !s1.isEmpty()) textureArmorName = s1;
			}
		} else {
			textureArmorName = prevNextNormal == 0 ? textureManagerGetPrevArmorPackege(textureArmorName, b) : textureManagerGetNextArmorPackege(textureArmorName, b);
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase setTexturePackege 2 textureName="+textureName+" textureArmorName="+textureArmorName);
		return new String[]{ textureName, textureArmorName };
	}

	public String getArmorName(String s, boolean b) {
		return getArmorName(s, 0, b);
	}

	public String getArmorName(String s, int i, boolean b) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName s="+s);
		if (s != null); else return "";
		String s1 = s;
		ModchuModel_TextureBoxBase ltb = getTextureBox(s, true);
		if (ltb != null
				&& getTextureBoxHasArmor(ltb)) {
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName getTextureBoxHasArmor true s1="+s1);
		} else {
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName getTextureBoxHasArmor ltb == null. s1="+s1);
			s1 = getModelSpecificationArmorPackege(s, b);
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName getTextureBoxHasArmor 1 s1="+s1);
			if (s1 != null) return s1;
			boolean flag = specificationArmorCheckBoolean(s);
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName getTextureBoxHasArmor 2 flag="+flag);
			s1 = specificationArmorCheck(s);
			if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName getTextureBoxHasArmor 3 s1="+s1);
			if (!flag) {
				if (i == 1) {
					s1 = s1 != null ? s1.indexOf("_Biped") > -1 ? "_Biped" : "erasearmor" : "erasearmor";
				} else {
					s1 = s1 != null ? s1.indexOf("_Biped") > -1 ? "_Biped" : "default" : "default";
				}
			} else {
				s1 = "erasearmor";
			}
			s1 = s1 + "_" + defaultModelName;
			if (s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) > -1
					&& s1.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) < 0) s1 = s1 + ModchuModel_ModelAddManager.addLmmModelString;
		}
		if (debug) Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getArmorName return s1="+s1+" i="+i);
		return s1;
	}

	public String specificationArmorCheck(String s) {
		s = Modchu_Main.lastIndexProcessing(s, "_");
		String[] cheackModelName = specificationArmorCheckModelName();
		boolean flag = false;
		for (String s2 : cheackModelName) {
			if (s.startsWith(s2)) s = "erasearmor";
		}
		return s;
	}

	public boolean specificationArmorCheckBoolean(String s) {
		String s1 = Modchu_Main.lastIndexProcessing(s, "_");
		String[] cheackModelName = specificationArmorCheckModelName();
		boolean flag = false;
		for (String s2 : cheackModelName) {
			if (s1.startsWith(s2)) flag = true;
		}
		String[] indexofName = specificationArmorCheckIndexofName();
		for (String s2 : indexofName) {
			if (s.indexOf(s2) > -1) flag = true;
		}
		return flag;
	}

	public String[] specificationArmorCheckModelName() {
		return new String[] {
				"Elsa"
		};
	}

	public String[] specificationArmorCheckIndexofName() {
		return new String[] {
				"other_Custom"
		};
	}
/*
	public Object[] getTextureBoxModels(Object ltb) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).models : null;
	}
*/
	public boolean getTextureBoxHasArmor(Object ltb) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).hasArmor() : false;
	}

	public boolean getTextureBoxHasColor(ModchuModel_TextureBoxBase ltb, int i) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).hasColor(i) : false;
	}

	public String getTextureBoxTextureName(Object ltb) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).textureName : null;
	}

	public Object getTextureBoxTextureName(ModchuModel_TextureBoxBase ltb, int i) {
		//Modchu_Debug.mDebug("getTextureBoxTextureName i="+i+" ltb="+ltb);
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).getTextureName(i) : null;
	}

	public String getTextureBoxFileName(Object ltb) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).fileName : null;
	}

	public String getTextureBoxPackegeName(Object ltb) {
		return ltb != null
				&& ltb instanceof ModchuModel_TextureBoxBase ? ((ModchuModel_TextureBoxBase) ltb).packegeName : null;
	}

	public ModchuModel_TextureBoxBase getTextureManagerTextures(int i, boolean b) {
		ModchuModel_TextureBoxBase modchuModel_TextureBoxBase = (ModchuModel_TextureBoxBase) Modchu_Main.getMapValue(textures, i);
		if (modchuModel_TextureBoxBase != null
				| !b) return modchuModel_TextureBoxBase;
		return (ModchuModel_TextureBoxBase) Modchu_Main.getMapValue(partsTextures, i);
	}

	public void worldEventLoad(Object event) {
		if (entityModelMapData != null
				&& !entityModelMapData.isEmpty()) {
			for (Entry<Object, Map> en : ((Map<Object, Map>) entityModelMapData).entrySet()) {
				for (Entry<String, Object[]> en1 : ((Map<String, Object[]>) en.getValue()).entrySet()) {
					Object[] models = en1.getValue();
					if (models != null); else continue;
					for (Object model : models) {
						if (model != null
								&& model instanceof MultiModelBaseBiped) {
							((MultiModelBaseBiped) model).worldEventLoad(event);
						}
					}
				}
			}
		}
		if (dummyModelMapData != null
				&& !dummyModelMapData.isEmpty()) {
			for (Entry<String, Object[]> en1 : ((Map<String, Object[]>) dummyModelMapData).entrySet()) {
				Object[] models = en1.getValue();
				if (models != null); else continue;
				for (Object model : models) {
					if (model != null
							&& model instanceof MultiModelBaseBiped) {
						((MultiModelBaseBiped) model).worldEventLoad(event);
					}
				}
			}
		}
	}

	public String getDefaultTextureName() {
		String s = defaultUsingTexture != null ? defaultUsingTexture : "default";
		return s+"_"+defaultModelName;
	}

	public boolean checkPartsName(String s) {
		if (s != null
				&& !s.isEmpty()); else return false;
		for (String s1 : partsNameList) {
			if (s.indexOf(s1) > -1) return true;
		}
		return false;
	}

	public List<String> textureNameList() {
		List list = new LinkedList();
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			String s = en.getKey();
			ModchuModel_TextureBoxBase modchuModel_TextureBoxBase = en.getValue();
			String textureName = modchuModel_TextureBoxBase.textureName;
			list.add(textureName);
			if (s != textureName) {
				Modchu_Debug.mDebug("ModchuModel_TextureManagerBase textureNameList() s != textureName s="+s+" textureName="+textureName);
			}
		}
		return list;
	}

}
