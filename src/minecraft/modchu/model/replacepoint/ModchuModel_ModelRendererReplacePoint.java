package modchu.model.replacepoint;

import modchu.model.replace.ModchuModel_ModelBase;
import modchu.model.replace.ModchuModel_ModelRendererBase;

public class ModchuModel_ModelRendererReplacePoint extends ModchuModel_ModelRendererBase {

	public ModchuModel_ModelRendererReplacePoint(ModchuModel_ModelBase pModelBase, String pName) {
		super(pModelBase, pName);
	}

	public ModchuModel_ModelRendererReplacePoint(ModchuModel_ModelBase pModelBase, int px, int py) {
		super(pModelBase, px, py);
	}

	public ModchuModel_ModelRendererReplacePoint(ModchuModel_ModelBase pModelBase) {
		super(pModelBase);
	}

	public ModchuModel_ModelRendererReplacePoint(ModchuModel_ModelBase pModelBase, int px, int py, float pScaleX, float pScaleY, float pScaleZ) {
		super(pModelBase, px, py, pScaleX, pScaleY, pScaleZ);
	}

	public ModchuModel_ModelRendererReplacePoint(ModchuModel_ModelBase pModelBase, float pScaleX, float pScaleY, float pScaleZ) {
		super(pModelBase, pScaleX, pScaleY, pScaleZ);
	}
}
