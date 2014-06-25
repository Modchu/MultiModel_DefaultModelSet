package modchu.model;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_Main;

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
		ModchuModel_Main.baseModInstance = this;
		ModchuModel_Main.load();
		Modchu_Debug.lDebug("modc_ModchuModel load end.");
	}

	public boolean modEnabled() {
		return true;
	}
/*
	public boolean onTickInGame(float f, Object minecraft, byte by, Object... tickData) {
		if (Modchu_Main.isServer) return false;
		return ModchuModel_Main.onTickInGame(f, (Object) minecraft, by, tickData);
	}
*/
	public void modsLoaded() {
		ModchuModel_Main.modsLoaded();
	}

	public String getPriorities() {
		return null;
	}
}
