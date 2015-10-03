package modchu.model;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_FileManager;
import modchu.lib.Modchu_LMMManager;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
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

	public static final int tx_oldwild		= 0x10; //16;
	public static final int tx_oldarmor1	= 0x11; //17;
	public static final int tx_oldarmor2	= 0x12; //18;
	public static final int tx_oldeye		= 0x13; //19;
	public static final int tx_gui			= 0x20; //32;
	public static final int tx_wild			= 0x30; //48;
	public static final int tx_armor1		= 0x40; //64;
	public static final int tx_armor2		= 0x50; //80;
	public static final int tx_eye			= 0x60; //96;
	public static final int tx_eyecontract	= 0x60; //96;
	public static final int tx_eyewild		= 0x70; //112;
	public static final int tx_armor1light	= 0x80; //128;
	public static final int tx_armor2light	= 0x90; //144;
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
	 * OtherCustomモデル初期化用データマップ
	 */
	public Map<String, Object[]> otherModelDataMap = new HashMap();
	/**
	 * ローカルで保持しているテクスチャパック
	 */
	public Map<String, ModchuModel_TextureBoxBase> textures = new TreeMap();

	public List<Object[]> searchPrefix = new ArrayList();
	private LinkedList<String> searchSettledList = new LinkedList();

	public static ArrayList<String> modelNewInstanceNgList = new ArrayList();
	public static HashMap<Object, Map> entityModelMapData = new HashMap();
	public static HashMap<String, Object[]> dummyModelMapData = new HashMap();

	public void init() {
		modelClassNameMap.put(defaultModelName, "modchu.model.multimodel.base.MultiModel");
		modelClassNameMap.put(defaultModelMaidBoneName, "modchu.model.multimodel.base.MultiModelMaidBone");
		loadTextures();
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
		Modchu_Debug.lDebug("ModchuModel_TextureManagerBase init() MultiModel load end.");
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

	/**
	 * 追加対象となる検索対象ファイル群とそれぞれの検索文字列を設定する。
	 */
	public void addSearch(String pName, String pTextureDir, String pClassPrefix) {
		if (searchPrefix != null
				&& !searchPrefix.isEmpty()) {
			for (Object[] lss : searchPrefix) {
				String[] s1 = (String[]) lss[0];
				String[] s2 = (String[]) lss[1];
				String[] s3 = (String[]) lss[2];
				if (s1[0].equals(pName)
						&& s2[0].equals(pTextureDir)
						&& s3[0].equals(pClassPrefix)) {
					return;
				}
			}
		}
		searchPrefix.add(new Object[] { new String[] { pName }, new String[] { pTextureDir }, new String[] { pClassPrefix }});
	}

	public void addSearch(String[] pName, String[] pTextureDir, String[] pClassPrefix) {
		searchPrefix.add(new Object[] { pName, pTextureDir, pClassPrefix });
	}

	/**
	 * テクスチャ名称の一致する物を返す。
	 */
	public ModchuModel_TextureBoxBase getTextureBox(String pName) {
		//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getTextureBox pName="+pName);
		if (pName != null
				&& !pName.isEmpty()); else return null;
		if (pName.indexOf("_") < 0) pName = new StringBuilder().append(pName).append("_").append(ModchuModel_TextureManagerBase.instance.defaultModelName).toString();
		pName = textureNameCheck(pName);
		if (pName != null
				&& !pName.isEmpty()); else return null;
		return textures.get(pName);
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
		Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures");
		// アーマーのファイル名を識別するための文字列を獲得する
		if (!Modchu_Main.isServer) {
			getArmorPrefix();
		}

		// ファイルを解析してテクスチャを追加
		List<File> jarList = Modchu_FileManager.getMinecraftJarList();
		File assetsDir = new File(".", "assets");
		for (Object[] lss : searchPrefix) {
			String[] s1 = (String[]) lss[0];
			String[] s2 = (String[]) lss[1];
			String[] s3 = (String[]) lss[2];

			// jar
			if (jarList.isEmpty()) {
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures jarList.isEmpty() error !!");
			} else {
				loadTextures(lss[0], lss[1], lss[2], jarList);
			}

			// mods
			for (String fileName : s1) {
				Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures mods load Modchu_FileManager.getFileList("+fileName+")="+Modchu_FileManager.getFileList(fileName));
				loadTextures(lss[0], lss[1], lss[2], Modchu_FileManager.getFileList(fileName));
			}

			// assets
			loadTextures(lss[0], lss[1], lss[2], assetsDir);
		}
		buildCrafterTexture();
		setModels();

		//setDefaultTexture(Modchu_Reflect.loadClass("EntityLivingBase"), getTextureBox("default_" + defaultModelName));
		Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures end.");
/*
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			String key = en.getKey();
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures textures key="+key);
		}
*/
		return false;
	}

	private void loadTextures(Object o, Object o1, Object o2, List<File> list) {
		for (File file : list) {
			loadTextures(o, o1, o2, file);
		}
	}

	private void loadTextures(Object o, Object o1, Object o2, File file) {
		String[] s1 = (String[]) o;
		String[] s2 = (String[]) o1;
		String[] s3 = (String[]) o2;
		boolean lflag = false;
		for (String s4 : s1) {
			for (String s5 : s2) {
				for (String s6 : s3) {
					String[] lst = new String[]{ s4, s5, s6 };
					Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures [%s] [%s] [%s]", s4, s5, s6);
					Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures file="+file);
					if (file.isDirectory()) {
						// ディレクトリ
						lflag = addTexturesDir(file, lst);
					} else {
						if (file.isFile()) {
							// zip
							//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase loadTextures zip");
							if (addTexturesZip(file, lst)) {
								Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures-file-done.");
							} else {
								Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures-file-fail.");
							}
						}
					}
					Modchu_Debug.tDebug("ModchuModel_TextureManagerBase loadTextures %s-%s.", file.getName(), lflag ? "done" : "fail");
				}
			}
		}
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
	public void addModelClass(String fname, String[] pSearch) {
		// モデルを追加
		int lfindprefix = fname.indexOf(pSearch[2]);
		//Modchu_Debug.tDebug("addModelClass 1 pSearch[2]="+pSearch[2]);
		//Modchu_Debug.tDebug("addModelClass 2 fname="+fname+" lfindprefix="+lfindprefix);
		if (lfindprefix > -1
				&& fname.endsWith(".class")) {
			String cn = Modchu_FileManager.classNameProcessing(fname);
			int version = Modchu_Main.getMinecraftVersion();
			String pn = version > 162 ? fname.substring(pSearch[2].length() + lfindprefix) : fname.substring(pSearch[2].length() + lfindprefix).replace(".class", "");
			if (version > 162) pn = pn.substring(0, pn.length() - 6);
			//Modchu_Debug.tDebug("addModelClass cn="+cn+" pn="+pn);
			if (modelClassNameMap.containsKey(pn)) return;

			Class lclass;
			try {
				lclass = Modchu_Reflect.loadClass(cn, -1);
				if (lclass != null) {
					if (!(MultiModelBaseBiped.class).isAssignableFrom(lclass) || Modifier.isAbstract(lclass.getModifiers())) {
						Modchu_Debug.tDebug("getModelClass-fail.");
						return;
					}
/*
					MultiModelBaseBiped mlm[] = new MultiModelBaseBiped[3];
					Constructor<MultiModelBaseBiped> cm = lclass.getConstructor(float.class);
					mlm[0] = cm.newInstance(0.0F);
					float[] lsize = mlm[0].getArmorModelsSize();
					//Modchu_Debug.mDebug("getModelClass lclass="+lclass+" lsize[0]="+lsize[0]+" lsize[1]="+lsize[1]);
					mlm[1] = cm.newInstance(lsize[0]);
					mlm[2] = cm.newInstance(lsize[1]);
*/
					modelClassNameMap.put(pn, cn);
					Modchu_Debug.tDebug("addModelClass-%s:%s", pn, cn);
				} else {
					Modchu_Debug.tDebug("addModelClass-class == null !!: %s", cn);
				}
			}
			catch (Exception exception) {
				Modchu_Debug.tDebug("addModelClass-Exception: %s", fname);
				exception.printStackTrace();
			}
			catch (Error error) {
				Modchu_Debug.tDebug("addModelClass-Error: %s", fname);
			}
		}
	}

	public void addTextureName(String fname, String[] pSearch) {
		// パッケージにテクスチャを登録
		String s = fname
				+ (pSearch != null
				&& pSearch.length > 0 ? pSearch[0] : "")
				+ (pSearch != null
						&& pSearch.length > 1 ? pSearch[1] : "");
		if (getSearchSettledList().contains(s)) {
			//Modchu_Debug.mDebug("ModchuModel_TextureManagerBase addTextureName getSearchSettledList().contains return.");
			return;
		}
		getSearchSettledList().add(s);
		if (!fname.startsWith("/")) fname = (new StringBuilder()).append("/").append(fname).toString();

		int i1 = fname.indexOf(pSearch[1]);
		if (i1 > -1) {
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName fname="+fname);
			int i = fname.lastIndexOf("/");
			if (pSearch[1].length() < i) {
				String pn = fname.substring(pSearch[1].length() + i1, i);
				pn = pn.replace('/', '.');
				String fn = fname.substring(i);
				int lindex = getIndex(fn);
				if (lindex > -1) {
					String an = null;
					if (lindex == tx_oldarmor1) {
						lindex = tx_armor1;
						an = "default";
					}
					if (lindex == tx_oldarmor2) {
						lindex = tx_armor2;
						an = "default";
					}
					if (lindex == tx_oldwild) {
						lindex = tx_wild + 12;
					}
					pn = textureNameCheck(pn);
					ModchuModel_TextureBoxBase lts = getTextureBox(pn);
					if (lts == null) {
						lts = new ModchuModel_TextureBoxBase(pn, pSearch);
						textures.put(pn, lts);
						Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName texturePack-%s", pn);
					}
					lts.addTexture(lindex, fname);
				}
			}
		} else {
			Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTextureName else fname="+fname);
		}
	}

	public boolean addTexturesZip(File file, String[] pSearch) {
		//
		if (file == null || file.isDirectory()) {
			return false;
		}
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
				//Modchu_Debug.tDebug("addTextureZip zipentry.getName()="+zipentry.getName());
				if (!zipentry.isDirectory()) {
					if (zipentry.getName().endsWith(".class")) {
						//Modchu_Debug.tDebug("addTextureZip zipentry. addModelClass");
						addModelClass(zipentry.getName(), pSearch);
					} else {
						addTextureName(zipentry.getName(), pSearch);
					}
				}
			} while(true);

			zipinputstream.close();
			fileinputstream.close();

			return true;
		} catch (Exception e) {
			Modchu_Debug.lDebug("addTextureZip-Exception.", 2, e);
			return false;
		}
	}

	public boolean addTexturesDir(File file, String[] lst) {
		return addTexturesDir(file, lst, true);
	}

	public boolean addTexturesDir(File file, String[] lst, boolean debug) {
		// modsフォルダに突っ込んであるものも検索、再帰で。
		if (file == null) {
			return false;
		}

		try {
			for (File t : file.listFiles()) {
				if (debug) Modchu_Debug.tDebug("ModchuModel_TextureManagerBase addTexturesDir t="+t);
				if (t.isDirectory()) {
					addTexturesDir(t, lst);
				} else {
					String s = t.getPath().replace('\\', '/');
					if (t.getName().endsWith(".class")) {
						addModelClass(t.getAbsolutePath(), lst);
					} else {
						int i = s.indexOf(lst[1]);
						if (i > -1) {
							// 対象はテクスチャディレクトリ
							//addTextureName(s.substring(i), lst);
							addTextureName(s, lst);
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			Modchu_Debug.lDebug("ModchuModel_TextureManagerBase addTexturesDir Exception.", 2, e);
			return false;
		}
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

	public ModchuModel_TextureBoxBase getNextPackege(ModchuModel_TextureBoxBase pNowBox, int pColor) {
		// 次のテクスチャパッケージの名前を返す
		boolean b = false;
		ModchuModel_TextureBoxBase lreturn = null;
/*
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			Modchu_Debug.mDebug("ModchuModel_TextureManagerBase getNextPackege ltb.textureName="+ltb.textureName+" ltb.hasColor(pColor)="+ltb.hasColor(pColor));
		}
*/
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				if (b) {
					return ltb;
				}
				if (lreturn == null) {
					lreturn = ltb;
				}
			}
			if (ltb == pNowBox) {
				b = true;
			}
		}
		//if (lreturn != null) return lreturn;
		return textures != null
				&& !textures.isEmpty() ? getTextureManagerTextures(0) : null;
	}

	public ModchuModel_TextureBoxBase getPrevPackege(ModchuModel_TextureBoxBase pNowBox, int pColor) {
		//Modchu_Debug.mDebug("getPrevPackege");
		// 前のテクスチャパッケージの名前を返す
		ModchuModel_TextureBoxBase lreturn = null;
		for (Entry<String, ModchuModel_TextureBoxBase> en : textures.entrySet()) {
			ModchuModel_TextureBoxBase ltb = en.getValue();
			if (ltb == pNowBox) {
				if (lreturn != null) {
					//Modchu_Debug.mDebug("getPrevPackege return lreturn="+lreturn);
					return lreturn;
				}
			}
			if (ltb.hasColor(pColor)
					&& ltb.textureName != null
					&& !ltb.textureName.isEmpty()) {
				//Modchu_Debug.mDebug("getPrevPackege hasColor lreturn="+ltb);
				lreturn = ltb;
			}
		}
		//if (lreturn != null) return lreturn;
		return textures != null
				&& textures.size() > 0 ? getTextureManagerTextures(textures.size() - 1) : null;
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
		return lreturn;
	}

	public String getRandomTextureString(Random pRand) {
		return getTextureBox(pRand.nextInt(textures.size())).textureName;
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
	public LinkedList getSearchSettledList() {
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
		s = instance.textureNameCheck(s);
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
		boolean debug = true;
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
		if (s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) < 0) {
			String s1 = getModelClassName(s);
			c = s1 != null && !s1.isEmpty() ? Modchu_Reflect.loadClass(s1, -1) : null;
			if (debug) Modchu_Debug.lDebug("ModchuModel_TextureManagerBase modelNewInstance 2-2 s="+s+" c="+c);
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
						models[0] = new MultiModelCustom(s4, 0.0F, 0.0F, 64, 32);
						if (models[0] != null) {
							float[] lsize = ((MultiModelCustom) models[0]).getArmorModelsSize();
							models[1] = new MultiModelCustom(s4, lsize[0], 0.0F, 64, 32);
							models[2] = new MultiModelCustom(s4, lsize[1], 0.0F, 64, 32);
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

	private static Object modelNewInstance(Class c, Class[] c1, Object[] o) {
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
		Object[] o = instance.otherModelDataMap.get(s);
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
			Object[] o = instance.otherModelDataMap.get(s);
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

	private static Object getNewInstanceOtherModel(String s, Class[] c, Object[] o, float f) {
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
		for (Entry<String, String> en : ((Map<String, String>) instance.modelClassNameMap).entrySet()) {
			String key = en.getKey();
			//Modchu_Debug.mDebug1("getModelClassName key="+key);
			if (key.equals(s)) {
				return en.getValue();
			}
		}
		return s;
	}

	public float[] getArmorModelsSize(Object o) {
		Object o1 = Modchu_Reflect.invokeMethod(o.getClass(), "getArmorModelsSize", o, -1);
		return o1 != null ? Modchu_CastHelper.FloatArray(o1) : new float[]{ 0.1F, 0.5F };
	}

	public String getPackege(int i, int j) {
		return getTextureBoxTextureName(getTextureManagerTextures(j));
	}

	public String getModelSpecificationArmorPackege(String s) {
		s = Modchu_Main.lastIndexProcessing(s, "_");
		String s1 = null;
		ModchuModel_TextureBoxBase ltb;
		for (int i = 0 ; i < textures.size() ; ++i) {
			ltb = getTextureManagerTextures(i);
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

	public ModchuModel_TextureBoxBase getTextureBox(int i) {
		return getTextureManagerTextures(i);
	}

	public Object[] getTextureModels(Object entity, int i, Object[] option) {
		return getTextureModels(entity, i, false, option);
	}

	public Object[] getTextureModels(Object entity, int i, boolean b, Object[] option) {
		ModchuModel_TextureBoxBase ltb = getTextureManagerTextures(i);
		return ltb != null ? modelNewInstance(entity, getTextureBoxTextureName(ltb), b, true, option) : null;
	}

	public Object checkTexturePackege(String s, int i) {
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
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
		boolean debug = true;
		if (debug) Modchu_Debug.mDebug("checkTextureArmorPackege s="+s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
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
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
		//Modchu_Debug.mDebug("textureManagerGetTextureName s="+s+" i="+i+" ltb="+ltb);
		if (ltb != null) return getTextureBoxTextureName(ltb, i);
		Modchu_Debug.Debug1("textureManagerGetTextureName null !! default change. s="+textureNameCheck(s)+" i="+i);
		ltb = getTextureBox(textureNameCheck(null));
		if (ltb != null) return getTextureBoxTextureName(ltb, i);
		return null;
	}

	public boolean textureColorChack(String s, int i) {
		s = textureNameCheck(s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
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
			if (defaultModelName != null) {
				s = "default_"+defaultModelName;
				//s = "default";
				Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase textureNameCheck default setting.");
			}
			else Modchu_Debug.lDebug1("ModchuModel_TextureManagerBase textureNameCheck defaultModelName == null !!");
		} else {
			if (s.indexOf("_") < 0
					&& defaultModelName != null
					&& instance.modelClassNameMap != null
					&& !instance.modelClassNameMap.containsKey(s)) s = s+"_"+defaultModelName;
		}
		return s;
	}

	public Object textureManagerGetArmorTexture(String s, int i, Object itemstack) {
		return textureManagerGetArmorTexture(s, i, itemstack, false);
	}

	public Object textureManagerGetArmorTexture(String s, int i, Object itemstack, boolean debug) {
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName s="+s+" i="+i+" itemstack != null ? "+(itemstack != null));
		s = textureNameCheck(s);
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName s="+s+" ltb="+ltb);
		if (ltb != null) {
			if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName return="+(((ModchuModel_TextureBoxBase) ltb).getArmorTextureName(i, itemstack)));
			return ((ModchuModel_TextureBoxBase) ltb).getArmorTextureName(i, itemstack);
		}
		if (debug) Modchu_Debug.Debug("textureManagerGetArmorTextureName return null !! s="+s+" i="+i+" itemstack="+itemstack);
		return null;
	}

	public String textureManagerGetNextPackege(String s, int i) {
		return textureManagerGetPackege(s, i, 0);
	}

	public String textureManagerGetPrevPackege(String s, int i) {
		return textureManagerGetPackege(s, i, 1);
	}

	public String textureManagerGetPackege(String s, int i, int i1) {
		ModchuModel_TextureBoxBase ltb = getTextureBox(s);
		if (ltb != null); else ltb = getTextureBox(0);
		if (ltb != null) {
			ltb = i1 == 0 ? instance.getNextPackege(ltb, i) :
				instance.getPrevPackege(ltb, i);
			return getTextureBoxTextureName(ltb);
		}
		Modchu_Debug.mDebug("textureManagerGetPackege return null !! s="+s+" i="+i);
		return null;
	}

	public String textureManagerGetNextArmorPackege(String s) {
		return textureManagerGetArmorPackege(s, 0);
	}

	public String textureManagerGetPrevArmorPackege(String s) {
		return textureManagerGetArmorPackege(s, 1);
	}

	public String textureManagerGetArmorPackege(String s, int i) {
		//Modchu_Debug.mDebug("textureManagerGetArmorPackege s="+s+" i="+i);
		int index = -1;
		String s2 = s;
		int i2 = s != null && !s.isEmpty() ? s.lastIndexOf(defaultModelName) : -1;
		if (i2 > -1) {
			s2 = s.substring(0, i2 - 1);
		}
		//Modchu_Debug.mDebug("textureManagerGetArmorPackege s2="+s2);
		index = textureManagerGetArmorPackegeIndex(s2);
		if (index == -1) {
			index = textureManagerGetArmorPackegeIndex("default");
			if (index == -1) {
				Modchu_Debug.mDebug("textureManagerGetArmorPackege return index == -1 !!");
				return null;
			}
		}
		boolean flag = false;
		ModchuModel_TextureBoxBase ltb;
		for (int i1 = 0; i1 < textures.size(); i1++) {
			index = i == 0 ? index + 1 : index - 1;
			if (index >= textures.size()) index = 0;
			if (index < 0) index = textures.size() - 1;
			ltb = getTextureManagerTextures(index);
			//ltb = i == 0 ? Modchu_Reflect.invokeMethod(ModchuModel_TextureManagerBase, "getNextArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb}) :
			//Modchu_Reflect.invokeMethod(ModchuModel_TextureManagerBase, "getPrevArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb});
			//Modchu_Debug.mDebug("textureManagerGetArmorPackege index for index="+index+" s="+(String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb));
			if (getTextureBoxHasArmor(ltb)) {
				s = getTextureBoxFileName(ltb);
				if (!s.isEmpty()
						&& !s.equals(s2)) {
					//Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.textures.size()="+textures.size());
					//Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.s="+s);
					flag = true;
					break;
				}
			}
		}
		if (!flag) Modchu_Debug.mDebug("textureManagerGetArmorPackege !flag !!");
		i2 = s.lastIndexOf(defaultModelName);
		if (i2 > -1) s = s.substring(0, i2);
		//Modchu_Debug.mDebug("textureManagerGetArmorPackege return s="+s);
		return s;
	}

	private int textureManagerGetArmorPackegeIndex(String s) {
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
			ltb = getTextureManagerTextures(i);
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

	public String[] setTexturePackege(String textureName, String textureArmorName, int color, int prevNextNormal, boolean armorOnly, boolean autoArmorSelect) {
		if (!armorOnly) {
			String s = textureName;
			switch(prevNextNormal) {
			case 0:
				s = instance.textureManagerGetPrevPackege(textureName, color);
				break;
			case 1:
				s = instance.textureManagerGetNextPackege(textureName, color);
				break;
			case 2:
				break;
			}
			//Modchu_Debug.mDebug("PFLM_Main setTexturePackege s="+s);
			if (s != null
					&& !s.isEmpty()); else return null;
			textureName = s;
			if (autoArmorSelect) {
				textureArmorName = textureName;
				String s1 = getArmorName(textureArmorName, prevNextNormal);
				if (s1 != null
						&& !s1.isEmpty()) textureArmorName = s1;
			}
		} else {
			textureArmorName = prevNextNormal == 0 ? instance.textureManagerGetPrevArmorPackege(textureArmorName) : instance.textureManagerGetNextArmorPackege(textureArmorName);
		}
		return new String[]{ textureName, textureArmorName };
	}

	public static String getArmorName(String s) {
		return getArmorName(s, 0);
	}

	public static String getArmorName(String s, int i) {
		if (s == null) return "";
		String s1 = s;
		ModchuModel_TextureBoxBase ltb = instance.getTextureBox(s);
		if (ltb != null
				&& instance.getTextureBoxHasArmor(ltb)) {
			Modchu_Debug.mDebug("getArmorName getTextureBoxHasArmor true s1="+s1);
		} else {
			Modchu_Debug.mDebug("getArmorName getTextureBoxHasArmor ltb == null. s1="+s1);
			s1 = instance.getModelSpecificationArmorPackege(s);
			Modchu_Debug.mDebug("getArmorName getTextureBoxHasArmor 1 s1="+s1);
			if (s1 != null) return s1;
			boolean flag = specificationArmorCheckBoolean(s);
			Modchu_Debug.mDebug("getArmorName getTextureBoxHasArmor 2 flag="+flag);
			s1 = specificationArmorCheck(s);
			Modchu_Debug.mDebug("getArmorName getTextureBoxHasArmor 3 s1="+s1);
			if (!flag) {
				if (i == 1) {
					s1 = s1 != null ? s1.indexOf("_Biped") > -1 ? "_Biped" : "erasearmor" : "erasearmor";
				} else {
					s1 = s1 != null ? s1.indexOf("_Biped") > -1 ? "_Biped" : "default" : "default";
				}
			} else {
				s1 = "erasearmor";
			}
			s1 = s1 + "_" + instance.defaultModelName;
			if (s.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) > -1
					&& s1.lastIndexOf(ModchuModel_ModelAddManager.addLmmModelString) < 0) s1 = s1 + ModchuModel_ModelAddManager.addLmmModelString;
		}
		Modchu_Debug.mDebug("getArmorName return s1="+s1+" i="+i);
		return s1;
	}

	public static String specificationArmorCheck(String s) {
		s = Modchu_Main.lastIndexProcessing(s, "_");
		String[] cheackModelName = specificationArmorCheckModelName();
		boolean flag = false;
		for (String s2 : cheackModelName) {
			if (s.startsWith(s2)) s = "erasearmor";
		}
		return s;
	}

	public static boolean specificationArmorCheckBoolean(String s) {
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

	public static String[] specificationArmorCheckModelName() {
		return new String[] {
				"Elsa"
		};
	}

	public static String[] specificationArmorCheckIndexofName() {
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

	public ModchuModel_TextureBoxBase getTextureManagerTextures(int i) {
		return (ModchuModel_TextureBoxBase) Modchu_Main.getMapValue(textures, i);
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
		return defaultUsingTexture+"_"+ModchuModel_TextureManagerBase.instance.defaultModelName;
	}

}
