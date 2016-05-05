package modchu.model;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_LayerArmorBaseMasterBasis;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class ModchuModel_LayerArmorBaseMaster extends Modchu_LayerArmorBaseMasterBasis  {

	public ModchuModel_LayerArmorBaseMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster doRenderLayer");
		Object render = Modchu_AS.get(Modchu_AS.renderManagerGetEntityRenderObject, entityLivingBase);
		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase);
		MultiModelBaseBiped modelInner = modelData.models[1];
		MultiModelBaseBiped modelOuter = modelData.models[2];
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster doRenderLayer render="+render);
		if (modelInner != null
				| modelOuter != null); else return;
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(render);
		ModchuModel_ModelBaseNihil modelFATT = (ModchuModel_ModelBaseNihil) Modchu_Reflect.getFieldObject(master.getClass(), "modelFATT", master);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster doRenderLayer s----------------------------");
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		if (ModchuModel_ConfigData.AlphaBlend) {
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		} else {
			GL11.glDisable(GL11.GL_BLEND);
		}
		for (int i = 0; i < 4; i++) {
			int i1 = Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(render.getClass(), "setArmorModel", new Class[]{ Object.class, Object.class, int.class, float.class, int.class }, render, new Object[]{ null, entityLivingBase, i, f6, 0 }));
			int i2 = Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(render.getClass(), "shouldRenderPass", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), int.class, float.class }, render, new Object[]{ entityLivingBase, i, f6 }));
			//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster doRenderLayer i1="+i1+" i2="+i2);

			if (i1 < 0
					| i2 < 0) continue;
			renderArmor(modelData, modelFATT, render, modelInner, i, 1, entityLivingBase, f, f1, f2, f3, f4, f5, f6);
			renderArmor(modelData, modelFATT, render, modelOuter, i, 2, entityLivingBase, f, f1, f2, f3, f4, f5, f6);
		}
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster doRenderLayer e----------------------------");
	}

	protected void renderArmor(ModchuModel_ModelDataBase modelData, ModchuModel_ModelBaseNihil modelFATT, Object render, MultiModelBaseBiped multiModelBaseBiped, int i, int i1, Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		multiModelBaseBiped.setLivingAnimations(entityLivingBase, f, f1, f2);
		multiModelBaseBiped.setModelAttributes(modelData.models[0]);
		Object texture = modelData.textures[i1][i];
		if (texture != null) Modchu_AS.set(Modchu_AS.renderBindTexture, render, texture);
		float[] armorColors = Modchu_CastHelper.FloatArray(modelData.getCapsValue(modelData.caps_freeVariable, "itemArmorColorFloat"+i));
		if (armorColors != null) {
			Modchu_GlStateManager.color(1.0F * armorColors[0], 1.0F * armorColors[1], 1.0F * armorColors[2], 1.0F);
		}
		multiModelBaseBiped.render(modelData, f, f1, f3, f4, f5, f6, texture != null ? modelFATT.isRendering : false);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderArmor texture="+texture);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderArmor isRendering="+modelFATT.isRendering);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderArmor multiModelBaseBiped="+multiModelBaseBiped);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderArmor multiModelBaseBiped.bipedBody.showModel="+multiModelBaseBiped.bipedBody.showModel);
		Object itemStack = getArmorItemStack(entityLivingBase, i);
		if (
				//!skipRenderGlint &&
				Modchu_AS.getBoolean("ItemStack", "hasEffect", itemStack)) {
			renderEnchantedGlint(modelData, modelFATT, render, entityLivingBase, multiModelBaseBiped, i, i1, f, f1, f2, f3, f4, f5, f6);
		}
	}

	protected void renderEnchantedGlint(ModchuModel_ModelDataBase modelData, ModchuModel_ModelBaseNihil modelFATT, Object render, Object entityLivingBase, MultiModelBaseBiped multiModelBaseBiped, int i, int i1, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		float f7 = (float) Modchu_AS.getInt(Modchu_AS.entityTicksExisted , entityLivingBase) + f2;
		int version = Modchu_Main.getMinecraftVersion();
		Object textureGlint = Modchu_AS.get("LayerArmorBase", version > 180 ? "ENCHANTED_ITEM_GLINT_RES" : "field_177188_b");
		if (textureGlint != null) Modchu_AS.set(Modchu_AS.renderBindTexture, render, textureGlint);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderEnchantedGlint textureGlint="+textureGlint);
/*
		Object texture = modelData.textures[i1 + 4][i];
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderEnchantedGlint i="+i+" i1="+i1);
		//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderEnchantedGlint texture="+texture);
		if (texture != null) {
			//Modchu_Debug.mDebug("ModchuModel_LayerArmorBaseMaster renderEnchantedGlint texture.getClass()="+texture.getClass());
			Modchu_AS.set(Modchu_AS.renderBindTexture, render, texture);
		}
*/
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
			Modchu_GlStateManager.rotate(30.0F - (float) i2 * 60.0F, 0.0F, 0.0F, 1.0F);
			Modchu_GlStateManager.translate(0.0F, f7 * (0.001F + (float) i2 * 0.003F) * 20.0F, 0.0F);
			Modchu_GlStateManager.matrixMode(5888);
			multiModelBaseBiped.render(modelData, f, f1, f3, f4, f5, f6, modelFATT.isRendering);
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
/*
	private void renderArmorLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6, int i) {
		Object itemStack = func_177176_a(entityLivingBase, i);
		Object item = itemStack != null ? Modchu_AS.get(Modchu_AS.itemStackGetItem, itemStack) : null;
		if (item != null
				&& Modchu_Reflect.loadClass("ItemArmor").isInstance(item)) {
			Object modelBase = func_177175_a(i);
			modelBase.setModelAttributes(renderer.getMainModel());
			modelBase.setLivingAnimations(entityLivingBase, f, f1, f2);
			modelBase = net.minecraftforge.client.ForgeHooksClient.getArmorModel(entityLivingBase, itemStack, i, modelBase);
			func_177179_a(modelBase, i);
			boolean flag = func_177180_b(i);
			renderer.bindTexture(getArmorResource(entityLivingBase, itemStack, flag ? 2 : 1, null));

			int j = itemArmor.getColor(itemStack);
			if (j != -1) { //Allow this for anything, not only cloth.
				float f7 = (float) (j >> 16 & 255) / 255.0F;
				float f8 = (float) (j >> 8 & 255) / 255.0F;
				float f9 = (float) (j & 255) / 255.0F;
				Modchu_GlStateManager.color(colorR * f7, colorG * f8, colorB * f9, alpha);
				modelBase.render(entityLivingBase, f, f1, f3, f4, f5, f6);
				renderer.bindTexture(getArmorResource(entityLivingBase, itemStack, flag ? 2 : 1, "overlay"));
			}
			// Non-cloth
			Modchu_GlStateManager.color(colorR, colorG, colorB, alpha);
			modelBase.render(entityLivingBase, f, f1, f3, f4, f5, f6);

			// Default, Why is this a switch? there were no breaks.
			if (!skipRenderGlint
					&& itemStack.isItemEnchanted()) {
				renderEnchantedGlint(entityLivingBase, modelBase, f, f1, f2, f3, f4, f5, f6);
			}
		}
	}
*/

}
