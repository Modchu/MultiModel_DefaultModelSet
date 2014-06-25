package modchu.model;

import modchu.lib.Modchu_IModelBaseDuo;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.recompileonly.Modchu_ModelBaseDuo;

import org.lwjgl.opengl.GL11;

public class ModchuModel_ModelBaseDuoMaster implements Modchu_IModelBaseDuo {
	public Modchu_ModelBaseDuo base;
	public int renderCount;

	public ModchuModel_ModelBaseDuoMaster(Modchu_ModelBaseDuo modelBaseDuo, Object render) {
		base = modelBaseDuo;
	}

	@Override
	public boolean render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, ModchuModel_IModelCaps entityCaps, boolean isRendering) {
		//GL11.glPushMatrix();
		renderBefore(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		//boolean lri = (renderCount & 0x0f) == 0;
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
		renderMiddle(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
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
		renderAfter(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		//GL11.glPopMatrix();
		return false;
	}

	private void renderBefore(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, ModchuModel_IModelCaps entityCaps, boolean isRendering) {
		float f9 = 1.0F;
		if (Modchu_Main.getMinecraftVersion() < 80) {
			f9 = (Float) Modchu_Reflect.invokeMethod("Entity", "func_382_a", "getEntityBrightness", new Class[]{ float.class }, entity, new Object[]{ 1.0F });
		}
		//ModchuModel_ConfigData.transparency -= 0.001F;
		//if (ModchuModel_ConfigData.transparency < 0.0F) ModchuModel_ConfigData.transparency = 1.0F;
		//Modchu_Debug.mdDebug("transparency="+ModchuModel_ConfigData.transparency);
		float f10 = ModchuModel_ConfigData.transparency;
		//if (f10 <= 0.5F) f10 = 0.501F;
/*
		Object o = entityCaps.getCapsValue(entityCaps.caps_freeVariable, "itemArmorColorFloat"+base.renderParts);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		if (o != null) {
			float[] f0 = (float[]) o;
			if (f0[0] > 0.0F
					| f0[1] > 0.0F
					| f0[2] > 0.0F) {
				float f11 = 1.0F - f9;
				GL11.glColor4f(f0[0] - f11, f0[1] - f11, f0[2] - f11, f10);
				return;
			}
		}
*/
		if (f10 != 1.0F)
			GL11.glColor4f(f9, f9, f9, f10);
		//GL11.glEnable(GL11.GL_ALPHA_TEST);
		//GL11.glEnable(GL11.GL_BLEND);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		//GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
/*
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		Modchu_AS.set(Modchu_AS.setArmorRendering, base, true);
		GL11.glMatrixMode(GL11.GL_TEXTURE);
		GL11.glLoadIdentity();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
*/
		//Modchu_Debug.mDebug("f9="+f9+" f10="+f10);
		//GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		//GL11.glDisable(GL11.GL_COLOR_MATERIAL);
		//Modchu_AS.set(Modchu_AS.renderHelperEnableStandardItemLighting);
		//GL11.glDisable(GL11.GL_CULL_FACE);
		//GL11.glEnable(GL11.GL_CULL_FACE);
		//GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	//GL11.glDepthFunc(GL11.GL_EQUAL);
		//GL11.glDepthFunc(GL11.GL_LEQUAL);
		//GL11.glDepthMask(true);
		//GL11.glDepthMask(false);

		//GL11.glDisable(GL11.GL_LIGHTING);
		//GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);

	}

	private void renderMiddle(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, ModchuModel_IModelCaps entityCaps, boolean isRendering) {
		float f9 = 1.0F;
		if (Modchu_Main.getMinecraftVersion() < 80) {
			f9 = (Float) Modchu_Reflect.invokeMethod("Entity", "func_382_a", "getEntityBrightness", new Class[]{ float.class }, entity, new Object[]{ 1.0F });
		}
		float f10 = ModchuModel_ConfigData.transparency;
		//if (f10 <= 0.5F) f10 = 0.501F;
/*
		Object o = entityCaps.getCapsValue(entityCaps.caps_freeVariable, "itemArmorColorFloat"+base.renderParts);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		if (o != null) {
			float[] f0 = (float[]) o;
			if (f0[0] > 0.0F
					| f0[1] > 0.0F
					| f0[2] > 0.0F) {
				float f11 = 1.0F - f9;
				GL11.glColor4f(f0[0] - f11, f0[1] - f11, f0[2] - f11, f10);
				return;
			}
		}
*/
		if (f10 != 1.0F)
			GL11.glColor4f(f9, f9, f9, f10);
	}

	private void renderAfter(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, ModchuModel_IModelCaps entityCaps, boolean isRendering) {
		if (ModchuModel_ConfigData.transparency != 1.0F)
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//GL11.glColor4f(1.0F, 1.0F, 1.0F, ModchuModel_ConfigData.transparency);
		//GL11.glDepthMask(true);
		//GL11.glDepthMask(false);
		//GL11.glDisable(GL11.GL_BLEND);
		//GL11.glDisable(GL11.GL_ALPHA_TEST);
	//GL11.glDepthFunc(GL11.GL_LEQUAL);
	}
}