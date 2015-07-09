package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelCapsLink;
import modchu.model.multimodel.base.MultiModelBaseBiped;

import org.lwjgl.opengl.GL11;

public class ModchuModel_ModelBaseSolo extends ModchuModel_ModelBaseNihil implements Modchu_IModelCapsLink {

	public ModchuModel_ModelBaseSolo(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entityLivingBase);
		MultiModelBaseBiped model = entityCaps.models[0];
		if (model != null) {
			model.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		isAlphablend = true;
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		MultiModelBaseBiped model = entityCaps.models[0];
		Object[] textures = entityCaps.textures[0];
		if (model == null) {
			isAlphablend = false;
			return;
		}
		if (isAlphablend) {
			if (isModelAlphablend) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		if (textures.length > 2 && textures[2] != null) {
			// Actors用
			model.setRotationAngles(par2, par3, par4, par5, par6, par7, entityCaps);
			// Face
			setTexture(textures[2]);
			model.setCapsValue(entityCaps, caps_renderFace, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			// Body
			setTexture(textures[0]);
			model.setCapsValue(entityCaps, caps_renderBody, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		} else {
			// 通常
			if (textures.length > 0 && textures[0] != null) {
				setTexture(textures[0]);
			}
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		}
		isAlphablend = false;
		if (textures.length > 1 && textures[1] != null && renderCount == 0) {
			// 発光パーツ
			setTexture(textures[1]);
			float var4 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDepthFunc(GL11.GL_LEQUAL);

			setLightmapTextureCoords(0x00f000f0);//61680
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, true);

			setLightmapTextureCoords(lighting);

//			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
		}
		renderCount++;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Object entity) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		MultiModelBaseBiped model = entityCaps.models[0];
		if (model != null) {
			model.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}


	// IModelModchuModel追加分

	@Override
	public void renderItems(Object entity, Object render) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		MultiModelBaseBiped model = entityCaps.models[0];
		if (model != null) {
			model.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(int pParts) {
		MultiModelBaseBiped model = tempEntityCaps.models[0];
		if (model != null) {
			model.showArmorParts(tempEntityCaps, pParts, 0);
		}
	}

	/**
	 * Renderer辺でこの変数を設定する。
	 * 設定値はModchu_IModelCapsBaseを継承したEntitiyとかを想定。
	 */
	@Override
	public void setEntityCaps(Modchu_IEntityCapsBase entityCaps) {
		tempEntityCaps = (ModchuModel_ModelDataBase) entityCaps;
	}

	@Override
	public void setArmorRendering(boolean pFlag) {
		isRendering = pFlag;
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return getCapsValue(tempEntityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue(tempEntityCaps, pIndex, pArg);
	}

	@Override
	public void showAllParts() {
		MultiModelBaseBiped model = tempEntityCaps.models[0];
		if (model != null) {
			model.showAllParts(tempEntityCaps);
		}
	}

	public void showAllParts(ModchuModel_ModelDataBase entityCaps) {
		MultiModelBaseBiped model = entityCaps.models[0];
		if (model != null) {
			model.showAllParts(entityCaps);
		}
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		MultiModelBaseBiped model = ((ModchuModel_ModelDataBase) entityCaps).models[0];
		if (capsLink != null) {
			capsLink.getCapsValue(entityCaps, pIndex, pArg);
		}
		return model == null ? null : model.getCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		MultiModelBaseBiped model = ((ModchuModel_ModelDataBase) entityCaps).models[0];
		if (capsLink != null) {
			capsLink.setCapsValue(entityCaps, pIndex, pArg);
		}
		if (model != null) {
			return model.setCapsValue(entityCaps, pIndex, pArg);
		}
		return false;
	}

}
