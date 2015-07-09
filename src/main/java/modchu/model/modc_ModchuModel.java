package modchu.model;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;

public class modc_ModchuModel {

	public modc_ModchuModel() {
	}

	public String getName() {
		return ModchuModel_Main.modName;
	}

	public String getVersion() {
		return ModchuModel_Main.versionString;
	}

	public void load() {
		Modchu_Main.eventRegister(this);
		Modchu_Debug.lDebug("modc_ModchuModel load");
		if (Modchu_Main.isServer) {
			Modchu_Debug.systemDebug("modc_ModchuModel isServer return.", 999);
			Modchu_Debug.lDebug("modc_ModchuModel isServer return.");
			return;
		}
		Modchu_Debug.lDebug("modc_ModchuModel load (1 / 3)");
		boolean errorFlag = false;
		String errorString = null;
		try {
			ModchuModel_Main.baseModInstance = this;
			Modchu_Debug.lDebug("modc_ModchuModel load (2 / 3)");
			ModchuModel_Main.load();
		} catch(Error e) {
			errorString = "ModchuModel_Main load() Error !!";
			Modchu_Debug.lDebug(errorString, 2, e);
			e.printStackTrace();
			errorFlag = true;
		} catch(Exception e) {
			errorString = "ModchuModel_Main load() Exception !!";
			Modchu_Debug.lDebug(errorString, 2, e);
			e.printStackTrace();
			errorFlag = true;
		}
		if (errorFlag) {
			try {
				Modchu_Main.setRuntimeException(errorString);
				Modchu_Debug.lDebug("ModchuModel_Main="+ModchuModel_Main.class);
				Class[] c1 = ModchuModel_Main.class.getDeclaredClasses();
				Modchu_Debug.lDebug("ModchuModel_Main.getDeclaredClasses()="+c1);
				if (c1 != null) {
					for (Class c : c1) {
						Modchu_Debug.lDebug("ModchuModel_Main.getDeclaredClasses() c="+c);
					}
				}
			} catch (Error e) {
				Modchu_Debug.lDebug("ModchuModel_Main errorFlag check Error !!", 2, e);
				e.printStackTrace();
			} catch (Exception e) {
				Modchu_Debug.lDebug("ModchuModel_Main errorFlag check Exception !!", 2, e);
				e.printStackTrace();
			}
		}
		Modchu_Debug.lDebug("modc_ModchuModel load (3 / 3) end.");
	}

	public boolean modEnabled() {
		return true;
	}

	public void modsLoaded() {
		ModchuModel_Main.modsLoaded();
	}

	public void addRenderer(Object map) {
		ModchuModel_Main.addRenderer(map);
	}

	public static Object getModsLoadedLoadScreen() {
		return Modchu_Main.newResourceLocation("textures/gui/title/modchumodel_title.png");
	}

	public void worldEventLoad(Object event) {
		Modchu_Debug.mDebug("modc_ModchuModel worldEventLoad");
		ModchuModel_Main.worldEventLoad(event);
	}

	public String getPriorities() {
		return null;
	}
}
