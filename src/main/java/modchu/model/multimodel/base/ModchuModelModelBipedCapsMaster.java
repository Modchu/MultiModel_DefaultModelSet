package modchu.model.multimodel.base;

import java.util.HashMap;
import java.util.Random;

import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelBiped;
import modchu.lib.Modchu_IModelBipedMaster;

public class ModchuModelModelBipedCapsMaster implements Modchu_IModelBipedMaster {
	public Modchu_IModelBiped base;
	public MultiModelBaseBiped model;

	public ModchuModelModelBipedCapsMaster(HashMap<String, Object> map) {
		base = (Modchu_IModelBiped) map.get("base");
		model = map != null
				&& map.containsKey("model") ? (MultiModelBaseBiped) map.get("model") : null;
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (model != null) model.render(entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		if (model != null) model.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}

	@Override
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		if (model != null) model.setLivingAnimations(entityLivingBase, par2, par3, par4);
	}

	@Override
	public Object getRandomModelBox(Random random) {
		return model != null ? model.getRandomModelBox(random) : null;
	}

	@Override
	public Object getRightArm(Modchu_IEntityCapsBase modchu_IEntityCapsBase) {
		return model != null ? model.getRightArm(modchu_IEntityCapsBase) : null;
	}

	@Override
	public void setModelAttributes(Object modelBase) {
		if (model != null) model.setModelAttributes(modelBase);
	}

	@Override
	public void renderEars(float par1) {
		if (model != null) model.renderEars(par1);
	}

	@Override
	public void renderCloak(float par1) {
		if (model != null) model.renderCloak(par1);
	}

}
