package modchu.model;

import modchu.lib.Modchu_IModelBaseDuo;
import modchu.lib.characteristic.Modchu_ModelBaseDuo;

import org.lwjgl.opengl.GL11;

public class ModchuModel_ModelBaseDuoMaster implements Modchu_IModelBaseDuo {
	public Modchu_ModelBaseDuo base;
	public int renderCount;

	public ModchuModel_ModelBaseDuoMaster(Modchu_ModelBaseDuo modelBaseDuo, Object render) {
		base = modelBaseDuo;
	}

	@Override
	public boolean render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, ModchuModel_IModelCaps entityCaps, boolean isRendering) {
		boolean lri = (renderCount & 0x0f) == 0;
		if (base.modelInner != null) {
			if (base.textureInner != null) {
				if (base.textureInner[base.renderParts] != null) {
					// 通常パーツ
					if (base.isAlphablend) {
						if (base.isModelAlphablend) {
							GL11.glEnable(GL11.GL_ALPHA_TEST);
							GL11.glEnable(GL11.GL_BLEND);
							GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
						} else {
							GL11.glDisable(GL11.GL_BLEND);
						}
					}
					ModchuModel_Client.setTexture(base.textureInner[base.renderParts]);
					base.modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					if (base.isAlphablend) {
						if (base.isModelAlphablend) {
							GL11.glDisable(GL11.GL_ALPHA_TEST);
						}
					}
				}
			} else {
				// ほぼエンチャントエフェクト用
				base.modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (base.textureInnerLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (base.textureInnerLight[base.renderParts] != null) {
					ModchuModel_Client.setTexture(base.textureInnerLight[base.renderParts]);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (base.textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								base.textureLightColor[0],
								base.textureLightColor[1],
								base.textureLightColor[2],
								base.textureLightColor[3]);
					}
					base.modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					ModchuModel_Client.setLightmapTextureCoords(base.lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
		if (base.modelOuter != null) {
			if (base.textureOuter != null) {
				// 通常パーツ
				if (base.textureOuter[base.renderParts] != null) {
					ModchuModel_Client.setTexture(base.textureOuter[base.renderParts]);
					base.modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				base.modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (base.textureOuterLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (base.textureOuterLight[base.renderParts] != null) {
					ModchuModel_Client.setTexture(base.textureOuterLight[base.renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (base.textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								base.textureLightColor[0],
								base.textureLightColor[1],
								base.textureLightColor[2],
								base.textureLightColor[3]);
					}
					base.modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					ModchuModel_Client.setLightmapTextureCoords(base.lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
//		isAlphablend = false;
		renderCount++;
		return false;
	}
}