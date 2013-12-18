package modchu.model;

import modchu.model.replacepoint.ModchuModel_ModelPlateBaseReplacePoint;
import modchu.model.replacepoint.ModchuModel_ModelRendererReplacePoint;

public class ModchuModel_ModelPlate extends ModchuModel_ModelPlateBaseReplacePoint {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public ModchuModel_ModelPlate(ModchuModel_ModelRendererReplacePoint pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
