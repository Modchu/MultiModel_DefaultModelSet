package modchu.model.replacepoint;

import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.replace.ModchuModel_ClientReplacePointBase;

public class ModchuModel_ClientReplacePoint extends ModchuModel_ClientReplacePointBase {

	public static void setTexture(String s) {
		if (s != null) {
			Object renderEngine = Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", Modchu_Main.getMinecraft());
			Modchu_Reflect.invokeMethod(renderEngine.getClass(), "func_78342_b", "bindTexture", new Class[]{ String.class }, renderEngine, new Object[]{ s });
		}
	}
}
