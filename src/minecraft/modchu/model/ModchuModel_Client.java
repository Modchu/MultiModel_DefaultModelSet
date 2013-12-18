package modchu.model;

import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.replacepoint.ModchuModel_ClientReplacePoint;

public class ModchuModel_Client extends ModchuModel_ClientReplacePoint {

	public static void setTexture(String s) {
		if (s != null) {
			Object renderEngine = Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", Modchu_Main.getMinecraft());
			Modchu_Reflect.invokeMethod(renderEngine.getClass(), "func_78342_b", "bindTexture", new Class[]{ String.class }, renderEngine, new Object[]{ s });
		}
	}
}
