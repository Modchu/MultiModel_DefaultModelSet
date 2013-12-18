package modchu.model;

import modchu.model.replacepoint.ModchuModel_IModelCapsReplacePoint;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityLivingBase;

public interface ModchuModel_IModelBaseModchuModelV160 extends ModchuModel_IModelCapsReplacePoint {

	public void renderItems(EntityLivingBase pEntity, Render pRender);
	public void showArmorParts(int pParts);
	public void setEntityCaps(ModchuModel_IModelCaps pModelCaps);
	public void setRender(Render pRender);
	public void setArmorRendering(boolean pFlag);

}
