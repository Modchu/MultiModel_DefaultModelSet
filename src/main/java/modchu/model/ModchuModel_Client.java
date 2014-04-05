package modchu.model;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.replacepoint.Modchu_ClientReplacePoint;

public class ModchuModel_Client extends Modchu_ClientReplacePoint {

	public static void setTexture(String s) {
		if (s != null) Modchu_AS.get(Modchu_AS.renderEngineBindTexture, s);
	}
}
