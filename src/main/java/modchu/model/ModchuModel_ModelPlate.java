package modchu.model;

import modchu.lib.Modchu_ModelRendererBase;
import modchu.lib.characteristic.Modchu_ModelPlateBase;

public class ModchuModel_ModelPlate extends Modchu_ModelPlateBase {

	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public ModchuModel_ModelPlate(Modchu_ModelRendererBase pMRenderer, Object... pArg) {
		super(pMRenderer, pArg);
		boxSizeX = (Integer)pArg[5];
		boxSizeY = (Integer)pArg[6];
		boxSizeZ = (Integer)pArg[5];
	}
}
