package modchu.model;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IModelBaseDuo;
import modchu.lib.Modchu_IModelBaseDuoMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_CastHelper;
import modchu.model.multimodel.base.MultiModelBaseBiped;

import org.lwjgl.opengl.GL11;

public class ModchuModel_ModelBaseDuoMaster implements Modchu_IModelBaseDuoMaster {
	public Modchu_IModelBaseDuo base;
	public int renderCount;

	public ModchuModel_ModelBaseDuoMaster(Modchu_IModelBaseDuo modelBaseDuo, Object render) {
		base = modelBaseDuo;
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, Object entityCaps, boolean isRendering) {
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		renderBefore(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		//Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render entityCaps="+entityCaps+" base.getIsAlphablend()="+base.getIsAlphablend());
		if (base.getIsAlphablend()) {
			if (base.getIsModelAlphablend()) {
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0f);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		Object modelInner = base.getModelInner();
		int renderParts = base.getRenderParts();
		float[] textureLightColor = base.getTextureLightColor();
		if (modelInner != null) {
			Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render modelInner entityCaps="+entityCaps);
			Object[] textureInner = base.getTextureInner();
			if (textureInner != null) {
				if (textureInner[renderParts] != null) {
					// 通常パーツ
					ModchuModel_Client.setTexture(textureInner[renderParts]);
					render(modelInner, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				render(modelInner, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			Object[] textureInnerLight = base.getTextureInnerLight();
			if (textureInnerLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureInnerLight[renderParts] != null) {
					ModchuModel_Client.setTexture(textureInnerLight[renderParts]);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								textureLightColor[0],
								textureLightColor[1],
								textureLightColor[2],
								textureLightColor[3]);
					}
					render(modelInner, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					int lighting = base.getLighting();
					ModchuModel_Client.setLightmapTextureCoords(lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
		renderMiddle(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		Object modelOuter = base.getModelOuter();
		if (modelOuter != null) {
			Object[] textureOuter = base.getTextureOuter();
			if (textureOuter != null) {
				// 通常パーツ
				if (textureOuter[renderParts] != null) {
					ModchuModel_Client.setTexture(textureOuter[renderParts]);
					render(modelOuter, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				render(modelOuter, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			Object[] textureOuterLight = base.getTextureOuterLight();
			if (textureOuterLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureOuterLight[renderParts] != null) {
					ModchuModel_Client.setTexture(textureOuterLight[renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								textureLightColor[0],
								textureLightColor[1],
								textureLightColor[2],
								textureLightColor[3]);
					}
					render(modelOuter, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					int lighting = base.getLighting();
					ModchuModel_Client.setLightmapTextureCoords(lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
		renderCount++;
		renderAfter(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	private void render(Object modelInner, Object entityCaps, float par2, float par3, float par4, float par5, float par6, float par7, boolean isRendering) {
		if (modelInner instanceof MultiModelBaseBiped) {
			((MultiModelBaseBiped) modelInner).render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			return;
		}
		Modchu_Reflect.invokeMethod(modelInner.getClass(), "render", new Class[]{ Modchu_Reflect.loadClass("MMM_IModelCaps"), float.class, float.class, float.class, float.class, float.class, float.class, boolean.class }, modelInner, new Object[]{ entityCaps, par2, par3, par4, par5, par6, par7, isRendering });
	}

	private void renderBefore(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, Object entityCaps, boolean isRendering) {
		float f9 = 1.0F;
		if (Modchu_Main.getMinecraftVersion() < 80) {
			f9 = (Float) Modchu_Reflect.invokeMethod("Entity", "func_382_a", "getEntityBrightness", new Class[]{ float.class }, entity, new Object[]{ 1.0F });
		}
		//ModchuModel_ConfigData.transparency -= 0.001F;
		//if (ModchuModel_ConfigData.transparency < 0.0F) ModchuModel_ConfigData.transparency = 1.0F;
		//Modchu_Debug.mdDebug("transparency="+ModchuModel_ConfigData.transparency);
		float f10 = ModchuModel_ConfigData.transparency;
		//if (f10 <= 0.5F) f10 = 0.501F;

		int renderParts = base.getRenderParts();
		Object o = entityCaps != null
				&& entityCaps instanceof ModchuModel_IEntityCaps ? ((ModchuModel_IEntityCaps) entityCaps).getCapsValue(((ModchuModel_IEntityCaps) entityCaps).caps_freeVariable, "itemArmorColorFloat"+renderParts) : null;
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
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

	private void renderMiddle(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, Object entityCaps, boolean isRendering) {
		float f9 = 1.0F;
		if (Modchu_Main.getMinecraftVersion() < 80) {
			f9 = Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("Entity", "func_382_a", "getEntityBrightness", new Class[]{ float.class }, entity, new Object[]{ 1.0F }));
		}
		float f10 = ModchuModel_ConfigData.transparency;
		//if (f10 <= 0.5F) f10 = 0.501F;

		int renderParts = base.getRenderParts();
		Object o = entityCaps != null
				&& entityCaps instanceof ModchuModel_IEntityCaps ? ((ModchuModel_IEntityCaps) entityCaps).getCapsValue(((ModchuModel_IEntityCaps) entityCaps).caps_freeVariable, "itemArmorColorFloat"+renderParts) : null;
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
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

		if (f10 != 1.0F)
			GL11.glColor4f(f9, f9, f9, f10);
	}

	private void renderAfter(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, Object entityCaps, boolean isRendering) {
		if (ModchuModel_ConfigData.transparency != 1.0F)
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		else GL11.glColor3f(1.0F, 1.0F, 1.0F);
		//GL11.glColor4f(1.0F, 1.0F, 1.0F, ModchuModel_ConfigData.transparency);
		//GL11.glDepthMask(true);
		//GL11.glDepthMask(false);
		//GL11.glDisable(GL11.GL_BLEND);
		//GL11.glDisable(GL11.GL_ALPHA_TEST);
	//GL11.glDepthFunc(GL11.GL_LEQUAL);
	}
}