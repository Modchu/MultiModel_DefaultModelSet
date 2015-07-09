package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_LayerArmorBaseMasterBasis;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.multimodel.base.MultiModelBaseBiped;

import org.lwjgl.opengl.GL11;

public class ModchuModel_LayerArmorBaseMaster extends Modchu_LayerArmorBaseMasterBasis  {

	public ModchuModel_LayerArmorBaseMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		Object render = Modchu_AS.get(Modchu_AS.renderManagerGetEntityRenderObject, entityLivingBase);
		ModchuModel_ModelDataBase modelData = ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase);
		MultiModelBaseBiped modelInner = modelData.models[1];
		MultiModelBaseBiped modelOuter = modelData.models[2];
		//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer render="+render);
		if (modelInner != null
				| modelOuter != null); else return;
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(render);
		ModchuModel_ModelBaseNihil modelFATT = (ModchuModel_ModelBaseNihil) Modchu_Reflect.getFieldObject(master.getClass(), "modelFATT", master);
		//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer s----------------------------");
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
			if (i1 < 0
					| Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(render.getClass(), "shouldRenderPass", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), int.class, float.class }, render, new Object[]{ entityLivingBase, i, f6 })) < 0) continue;
			if (modelInner != null) {
				modelInner.setLivingAnimations(entityLivingBase, f, f1, f2);
				modelInner.setModelAttributes(modelData.models[0]);
				if (modelData.textures[1][i] != null) Modchu_AS.set(Modchu_AS.renderBindTexture, render, modelData.textures[1][i]);
				modelInner.render(modelData, f, f1, f3, f4, f5, f6, modelData.textures[1][i] != null ? modelFATT.isRendering : false);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer modelInner modelData.textures[1]["+i+"]="+modelData.textures[1][i]);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer isRendering="+modelFATT.isRendering);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer modelInner="+modelInner);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer modelInner.bipedBody.showModel="+modelInner.bipedBody.showModel);
			}
			if (modelOuter != null) {
				modelOuter.setLivingAnimations(entityLivingBase, f, f1, f2);
				modelOuter.setModelAttributes(modelData.models[0]);
				if (modelData.textures[2][i] != null) Modchu_AS.set(Modchu_AS.renderBindTexture, render, modelData.textures[2][i]);
				modelOuter.render(modelData, f, f1, f3, f4, f5, f6, modelData.textures[2][i] != null ? modelFATT.isRendering : false);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer modelOuter modelData.textures[2]["+i+"]="+modelData.textures[2][i]);
				//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer modelOuter="+modelOuter);
			}
		}
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
		//Modchu_Debug.mDebug("PFLM_LayerArmorBaseMaster doRenderLayer e----------------------------");
	}
/*
	private void func_177182_a(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6, int i) {
		Object itemStack = func_177176_a(entityLivingBase, i);
		Object item = itemStack != null ? Modchu_AS.get(Modchu_AS.itemStackGetItem, itemStack) : null;
		if (item != null
				&& Modchu_Reflect.loadClass("ItemArmor").isInstance(item)) {
			Object modelBase = func_177175_a(i);
			modelBase.setModelAttributes(field_177190_a.getMainModel());
			modelBase.setLivingAnimations(entityLivingBase, f, f1, f2);
			modelBase = net.minecraftforge.client.ForgeHooksClient.getArmorModel(entityLivingBase, itemStack, i, modelBase);
			func_177179_a(modelBase, i);
			boolean flag = func_177180_b(i);
			field_177190_a.bindTexture(getArmorResource(entityLivingBase, itemStack, flag ? 2 : 1, null));

			int j = itemArmor.getColor(itemStack);
			if (j != -1) { //Allow this for anything, not only cloth.
				float f7 = (float) (j >> 16 & 255) / 255.0F;
				float f8 = (float) (j >> 8 & 255) / 255.0F;
				float f9 = (float) (j & 255) / 255.0F;
				Modchu_GlStateManager.color(field_177184_f * f7, field_177185_g * f8, field_177192_h * f9, field_177187_e);
				modelBase.render(entityLivingBase, f, f1, f3, f4, f5, f6);
				field_177190_a.bindTexture(getArmorResource(entityLivingBase, itemStack, flag ? 2 : 1, "overlay"));
			}
			// Non-cloth
			Modchu_GlStateManager.color(field_177184_f, field_177185_g, field_177192_h, field_177187_e);
			modelBase.render(entityLivingBase, f, f1, f3, f4, f5, f6);

			// Default, Why is this a switch? there were no breaks.
			if (!field_177193_i
					&& itemStack.isItemEnchanted()) {
				func_177183_a(entityLivingBase, modelBase, f, f1, f2, f3, f4, f5, f6);
			}
		}
	}
*/
}
