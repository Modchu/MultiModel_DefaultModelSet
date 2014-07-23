package modchu.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.characteristic.Modchu_Packet;
import modchu.lib.characteristic.Modchu_PacketBasis;

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

	public void modsLoaded() {
		ModchuModel_Main.modsLoaded();
	}

	public void worldEventLoad(Object event) {
		Modchu_Debug.mDebug("modc_ModchuModel worldEventLoad");
		ModchuModel_Main.worldEventLoad(event);
	}

	public String getPriorities() {
		return null;
	}
}
