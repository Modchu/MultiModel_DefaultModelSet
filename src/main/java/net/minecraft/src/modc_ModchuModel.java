package net.minecraft.src;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_Main;

public class modc_ModchuModel {

	public static boolean isServer = false;

	static {
		Object o = Modchu_Reflect.invokeMethod("cpw.mods.fml.common.FMLCommonHandler", "instance");
		if (o != null) {
			o = Modchu_Reflect.invokeMethod(o.getClass(), "getSide", o);
			if (o != null) {
				if ((Boolean) Modchu_Reflect.invokeMethod(o.getClass(), "isServer", o)) isServer = true;
			}
		} else {
			isServer = Modchu_Reflect.getFieldObject("ModLoader", "getMinecraftInstance") != null;
		}
	}

	public modc_ModchuModel() {
		if (isServer) return;
	}

	public String getName() {
		return ModchuModel_Main.modName;
	}

	public String getVersion() {
		return ModchuModel_Main.versionString;
	}

	public void load() {
		//Modchu_Main.eventRegister(this);
		Modchu_Debug.lDebug("modc_ModchuModel modchu_Main load");
		if (isServer) {
			Modchu_Debug.systemDebug("modc_ModchuModel isServer return.", 999);
			Modchu_Debug.lDebug("modc_ModchuModel isServer return.");
			return;
		}
		ModchuModel_Main.baseModInstance = this;
		ModchuModel_Main ModchuModel_Main = new ModchuModel_Main();
		ModchuModel_Main.load();
		//ModLoader.setInGameHook(this, true, true);
	}

	public boolean modEnabled() {
		return true;
	}

	public boolean onTickInGame(float f, Object minecraft, byte by, Object... tickData) {
		if (isServer) return false;
		return ModchuModel_Main.onTickInGame(f, (Object) minecraft, by, tickData);
	}

	public void modsLoaded() {
		ModchuModel_Main.modsLoaded();
	}

	public String getPriorities() {
		return null;
	}
}
