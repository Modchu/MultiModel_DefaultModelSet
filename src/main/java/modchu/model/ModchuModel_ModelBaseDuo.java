package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelCapsLink;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.multimodel.base.MultiModelBaseBiped;

import org.lwjgl.opengl.GL11;

/**
 * アーマーの二重描画用クラス。
 * 必ずInner側にはモデルを設定すること。
 * 通常のRendererで描画するためのクラスなので、Renderをちゃんと記述するならいらないクラスです。
 */
public class ModchuModel_ModelBaseDuo extends ModchuModel_ModelBaseNihil implements Modchu_IModelCapsLink {

	/**
	 * 描画されるアーマーの部位。
	 * shouldRenderPassとかで指定する。
	 */
	public int renderParts;

	public float[] textureLightColor;

	public int shouldRenderPass;

	public ModchuModel_ModelBaseDuo(HashMap<String, Object> map) {
		super(map);
		renderParts = 0;
	}

	@Override
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entityLivingBase);
		if (((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1); else return;
		MultiModelBaseBiped modelInner = entityCaps.models[1];
		MultiModelBaseBiped modelOuter = entityCaps.models[2];
		if (modelInner != null) {
			modelInner.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		if (modelOuter != null) {
			modelOuter.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		isAlphablend = true;
		renderCount = 0;
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		if (((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1); else return;
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		MultiModelBaseBiped modelInner = entityCaps.models[1];
		MultiModelBaseBiped modelOuter = entityCaps.models[2];
		Object[] textureInner = entityCaps.textures[1];
		Object[] textureOuter = entityCaps.textures[2];
		Object[] textureInnerLight = entityCaps.textures[3];
		Object[] textureOuterLight = entityCaps.textures[4];
		Object[] textureInnerOverlay = entityCaps.textures[5];
		Object[] textureOuterOverlay = entityCaps.textures[6];
		renderBefore(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		//Modchu_Debug.mDebug("ModchuModel_ModelBaseDuoMaster render renderCount="+renderCount);
		//Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render entityCaps="+entityCaps+" isAlphablend="+isAlphablend);
		if (isAlphablend
				&& renderCount == 0) {
			if (isModelAlphablend) {
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.0f);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		//Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render modelInner="+modelInner);
		Object itemStack = getArmorItemStack(entity, renderParts);
		//Modchu_Debug.mDebug("ModchuModel_ModelBaseDuoMaster render shouldRenderPass="+shouldRenderPass);
		if (modelInner != null) {
			//Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render modelInner entityCaps="+entityCaps);
			if (textureInner != null) {
				if ((renderCount == 0
						| (shouldRenderPass & 16) == 16)
						&& textureInner[renderParts] != null) setTexture(textureInner[renderParts]);
				if ((renderCount == 0
						&& textureInner[renderParts] != null)
						//| renderCount != 0
						) {
					// 通常パーツ
					//Modchu_Debug.mDebug1("ModchuModel_ModelBaseDuoMaster render modelInner isRendering="+isRendering+" textureInner[renderParts]="+textureInner[renderParts]);
					render(modelInner, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				render(modelInner, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
/*
			if (itemStack != null
					&& Modchu_AS.getBoolean("ItemStack", "hasEffect", itemStack)) {
				boolean isRendering = true;
				//boolean isRendering = textureInnerOverlay[renderParts] != null;
				//if (isRendering) setTexture(textureInnerOverlay[renderParts]);
				//Modchu_Debug.mDebug("ModchuModel_ModelBaseDuo textureInnerOverlay["+renderParts+"]="+textureInnerOverlay[renderParts]);
				renderEnchantedGlint(entityCaps, entity, modelInner, par2, par3, par4, par5, par6, par7, isRendering);
			}
*/
			if (textureInnerLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureInnerLight[renderParts] != null) {
					setTexture(textureInnerLight[renderParts]);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					setLightmapTextureCoords(0x00f000f0);//61680
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
					setLightmapTextureCoords(lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
		renderMiddle(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
		if (modelOuter != null) {
			if (textureOuter != null) {
				// 通常パーツ
				if ((renderCount == 0
						| (shouldRenderPass & 16) == 16)
						&& textureOuter[renderParts] != null) setTexture(textureOuter[renderParts]);
				if ((renderCount == 0
						&& textureOuter[renderParts] != null)
						| renderCount != 0) {
					if (renderCount == 0) setTexture(textureOuter[renderParts]);
					render(modelOuter, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				render(modelOuter, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
/*
			if (itemStack != null
					&& Modchu_AS.getBoolean("ItemStack", "hasEffect", itemStack)) {
				boolean isRendering = true;
				//boolean isRendering = textureOuterOverlay[renderParts] != null;
				//if (isRendering) setTexture(textureOuterOverlay[renderParts]);
				//Modchu_Debug.mDebug("ModchuModel_ModelBaseDuo textureOuterOverlay["+renderParts+"]="+textureOuterOverlay[renderParts]);
				renderEnchantedGlint(entityCaps, entity, modelOuter, par2, par3, par4, par5, par6, par7, isRendering);
			}
*/
			if (textureOuterLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureOuterLight[renderParts] != null) {
					setTexture(textureOuterLight[renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					setLightmapTextureCoords(0x00f000f0);//61680
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
					setLightmapTextureCoords(lighting);
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

	protected void renderEnchantedGlint(ModchuModel_ModelDataBase modelData, Object entityLivingBase, MultiModelBaseBiped multiModelBaseBiped, float f, float f1, float f3, float f4, float f5, float f6, boolean isRendering) {
		float renderPartialTicks = Modchu_AS.getFloat("Timer", "renderPartialTicks", Modchu_AS.get("Minecraft", "timer", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft)));
		float f7 = (float) Modchu_AS.getInt(Modchu_AS.entityTicksExisted , entityLivingBase) + renderPartialTicks;
		int version = Modchu_Main.getMinecraftVersion();
		Object textureGlint = Modchu_AS.get("RendererLivingEntity", "RES_ITEM_GLINT");
		if (textureGlint != null) setTexture(textureGlint);

		Modchu_GlStateManager.enableBlend();
		Modchu_GlStateManager.depthFunc(514);
		Modchu_GlStateManager.depthMask(false);

		float f8 = 0.5F;
		Modchu_GlStateManager.color(f8, f8, f8, 1.0F);

		for (int i2 = 0; i2 < 2; ++i2) {
			Modchu_GlStateManager.disableLighting();
			Modchu_GlStateManager.blendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
			float f9 = 0.76F;
			Modchu_GlStateManager.color(0.5F * f9, 0.25F * f9, 0.8F * f9, 1.0F);
			Modchu_GlStateManager.matrixMode(5890);
			Modchu_GlStateManager.loadIdentity();

			float f10 = 0.33333334F;
			Modchu_GlStateManager.scale(f10, f10, f10);
/*
			Modchu_GlStateManager.rotate(30.0F - (float) i2 * 60.0F, 0.0F, 0.0F, 1.0F);
			Modchu_GlStateManager.translate(0.0F, f7 * (0.001F + (float) i2 * 0.003F) * 20.0F, 0.0F);
*/
			Modchu_GlStateManager.matrixMode(5888);
			multiModelBaseBiped.render(modelData, f, f1, f3, f4, f5, f6, isRendering);
		}

		Modchu_GlStateManager.matrixMode(5890);
		Modchu_GlStateManager.loadIdentity();
		Modchu_GlStateManager.matrixMode(5888);
		Modchu_GlStateManager.enableLighting();
		Modchu_GlStateManager.depthMask(true);
		Modchu_GlStateManager.depthFunc(515);
		Modchu_GlStateManager.disableBlend();
	}

	public Object getArmorItemStack(Object entity, int i) {
		return Modchu_Reflect.loadClass("EntityPlayer").isInstance(entity) ? Modchu_AS.get(Modchu_AS.entityPlayerInventoryPlayerArmorItemInSlot, entity, i) :
			Modchu_Reflect.loadClass("EntityLiving").isInstance(entity) ? Modchu_AS.get(Modchu_AS.entityLivingGetCurrentArmor, entity, i) : null;
	}

	private void render(Object model, Object entityCaps, float par2, float par3, float par4, float par5, float par6, float par7, boolean isRendering) {
		if (model instanceof MultiModelBaseBiped) {
			((MultiModelBaseBiped) model).render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			return;
		}
		Modchu_Reflect.invokeMethod(model.getClass(), "render", new Class[]{ Modchu_Reflect.loadClass("ModchuModel_IEntityCaps"), float.class, float.class, float.class, float.class, float.class, float.class, boolean.class }, model, new Object[]{ entityCaps, par2, par3, par4, par5, par6, par7, isRendering });
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

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		if (((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1); else return;
		MultiModelBaseBiped modelInner = entityCaps.models[1];
		MultiModelBaseBiped modelOuter = entityCaps.models[2];
		if (modelInner != null) {
			modelInner.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
		if (modelOuter != null) {
			modelOuter.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}

	// IModelModchuModel追加分
	@Override
	public void renderItems(Object entity, Object render) {
		ModchuModel_ModelDataBase entityCaps = getModchuModel_ModelDataBase(entity);
		if (((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1); else return;
		MultiModelBaseBiped modelInner = entityCaps.models[1];
		MultiModelBaseBiped modelOuter = entityCaps.models[2];
		if (modelInner != null) {
			modelInner.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(int pParts) {
		if (((ModchuModel_ModelDataBase) tempEntityCaps).models != null
				&& ((ModchuModel_ModelDataBase) tempEntityCaps).models.length > 1); else return;
		MultiModelBaseBiped modelInner = tempEntityCaps.models[1];
		MultiModelBaseBiped modelOuter = tempEntityCaps.models[2];
		if (modelInner != null) {
			modelInner.showArmorParts(tempEntityCaps, pParts, 0);
		}
		if (modelOuter != null) {
			modelOuter.showArmorParts(tempEntityCaps, pParts, 1);
		}
	}

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
	public void showAllParts(ModchuModel_ModelDataBase entityCaps) {
		if (((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1); else return;
		MultiModelBaseBiped modelInner = entityCaps.models[1];
		MultiModelBaseBiped modelOuter = entityCaps.models[2];
		if (modelInner != null) {
			modelInner.showAllParts(entityCaps);
		}
		if (modelOuter != null) {
			modelOuter.showAllParts(entityCaps);
		}
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		MultiModelBaseBiped modelInner = ((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 0 ? ((ModchuModel_ModelDataBase) entityCaps).models[1] : null;
		return modelInner == null ? null : modelInner.getCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		MultiModelBaseBiped modelInner = ((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 0 ? ((ModchuModel_ModelDataBase) entityCaps).models[1] : null;
		MultiModelBaseBiped modelOuter = ((ModchuModel_ModelDataBase) entityCaps).models != null
				&& ((ModchuModel_ModelDataBase) entityCaps).models.length > 1 ? ((ModchuModel_ModelDataBase) entityCaps).models[2] : null;
		if (modelOuter != null) {
			modelOuter.setCapsValue(entityCaps, pIndex, pArg);
		}
		if (modelInner != null) {
			return modelInner.setCapsValue(entityCaps, pIndex, pArg);
		}
		return false;
	}

	public ModchuModel_IEntityCaps getModchuModel_IEntityCaps(Object entityLivingBase) {
		return (ModchuModel_IEntityCaps) getModchuModel_ModelDataBase(entityLivingBase);
	}

}
