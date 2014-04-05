package modchu.model;

import modchu.lib.replacepoint.Modchu_ModelRendererReplacePoint;
import modchu.model.replacepoint.ModchuModel_ModelPlateBaseReplacePoint;

public class ModchuModel_ModelPlate extends ModchuModel_ModelPlateBaseReplacePoint {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public ModchuModel_ModelPlate(Modchu_ModelRendererReplacePoint pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
