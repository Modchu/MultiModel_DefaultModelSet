package modchu.model;

import modchu.model.replacepoint.ModchuModel_ModelBoxBaseReplacePoint;
import modchu.model.replacepoint.ModchuModel_ModelRendererReplacePoint;

public class ModchuModel_ModelBox extends ModchuModel_ModelBoxBaseReplacePoint {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public ModchuModel_ModelBox(ModchuModel_ModelRendererReplacePoint pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
