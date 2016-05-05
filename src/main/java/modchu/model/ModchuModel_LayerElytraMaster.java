package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_LayerElytraMasterBasis;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class ModchuModel_LayerElytraMaster extends Modchu_LayerElytraMasterBasis  {

	public ModchuModel_LayerElytraMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		//Modchu_Debug.mDebug("ModchuModel_LayerElytraMaster doRenderLayer s----------------------------");
		ModchuModel_ModelDataBase entityCaps = ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase);
		Modchu_GlStateManager.pushMatrix();
		Object model = entityCaps.getCapsValue(entityCaps.caps_model, 0);
		float f7 = model instanceof MultiModelBaseBiped ? ((MultiModelBaseBiped) model).getRenderCorrectionYOffset(entityCaps) : 0.0F;
		Modchu_GlStateManager.translate(0.0F, f7, 0.0F);
		super.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
		Modchu_GlStateManager.popMatrix();
		//Modchu_Debug.mDebug("ModchuModel_LayerElytraMaster doRenderLayer e----------------------------");
	}

}
