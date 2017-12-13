package modchu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelBox;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelPlateMaster;
import modchu.lib.Modchu_ModelRenderer;
import modchu.lib.Modchu_Reflect;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class ModchuModel_ModelRenderer extends Modchu_ModelRenderer {

	public ModchuModel_ModelRenderer(Object modelBase) {
		super(modelBase);
	}

	public ModchuModel_ModelRenderer(Object modelBase, String s) {
		super(modelBase, s);
	}

	public ModchuModel_ModelRenderer(Object modelBase, int x, int y) {
		super(modelBase, x, y);
	}

	public ModchuModel_ModelRenderer(Object modelBase, int x, int y, String s) {
		super(modelBase, x, y, s);
	}

	public ModchuModel_ModelRenderer(Object modelBase, int x, int y, float scaleX, float scaleY, float scaleZ) {
		super(modelBase, x, y, scaleX, scaleY, scaleZ);
	}

	public ModchuModel_ModelRenderer(Object modelBase, int x, int y, String s, float scaleX, float scaleY, float scaleZ) {
		super(modelBase, x, y, s, scaleX, scaleY, scaleZ);
	}

	protected void renderItemsOption(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale) {
		super.renderItemsOption(entityLiving, pRealBlock, enumAction, itemstack, scale);
		if (!ModchuModel_Main.isGulliver) return;
		ModchuModel_ModelDataBase entityCaps = ModchuModel_ModelDataMaster.instance.getPlayerData(entityLiving);
		boolean isGliding = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_freeVariable, "isGliding");
		boolean isRafting = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_freeVariable, "isRafting");
		if (!isGliding
				&& !isRafting) {
			float f = (Float) Modchu_Reflect.invoke(ModchuModel_Main.sizeMultiplier, entityLiving);
			if (f > 1.0F) f = 1.0F / f;
			else if (f < 0.2F) f = 3.0F;
			else if (f < 0.35F) f = 2.25F;
			else if (f < 0.5F) f = 1.5F;
			Modchu_GlStateManager.scale(f, f, f);
			return;
		}
		if (isGliding
				| isRafting) {
			float f1 = 2.0F;
			Modchu_GlStateManager.scale(f1, f1, f1);
			Object model = entityCaps.getCapsValue(entityCaps.caps_model, 0);
			float height = model != null
					&& model instanceof MultiModelBaseBiped ? ((MultiModelBaseBiped) model).getHeight(entityCaps) : 1.8F;
			if (isGliding) {
				//Modchu_GlStateManager.translate(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
				Modchu_GlStateManager.translate(0.0F, 1.8F - height - 0.6F, 0.13F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf4, 1.0F, 0.0F, 0.0F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf5, 0.0F, 1.0F, 0.0F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf6, 0.0F, 0.0F, 1.0F);
				Modchu_GlStateManager.rotate(22.0F, 1.0F, 0.0F, 0.0F);
				Modchu_GlStateManager.rotate(44.3F, 0.0F, 1.0F, 0.0F);
				Modchu_GlStateManager.rotate(-26.0F, 0.0F, 0.0F, 1.0F);
			}
			if (isRafting) {
				//Modchu_GlStateManager.translate(Modchu_Debug.debaf1, Modchu_Debug.debaf2, Modchu_Debug.debaf3);
				float f = 0.39F;
				if (height < 1.0F) f += 1.0F - height;
				else if (height < 1.5F) f += 1.5F - height;
				Modchu_GlStateManager.translate(-0.15F, f, -0.04F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf4, 1.0F, 0.0F, 0.0F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf5, 0.0F, 1.0F, 0.0F);
				//Modchu_GlStateManager.rotate(Modchu_Debug.debaf6, 0.0F, 0.0F, 1.0F);
				Modchu_GlStateManager.rotate(13.5F, 1.0F, 0.0F, 0.0F);
				Modchu_GlStateManager.rotate(-82F, 0.0F, 1.0F, 0.0F);
				Modchu_GlStateManager.rotate(-6.6F, 0.0F, 0.0F, 1.0F);
			}
			//Modchu_Debug.dDebug("translate x="+Modchu_Debug.debaf1+" y="+Modchu_Debug.debaf2+" z="+Modchu_Debug.debaf3);
			//Modchu_Debug.dDebug("rotate x="+Modchu_Debug.debaf4+" y="+Modchu_Debug.debaf5+" z="+Modchu_Debug.debaf6, 1);
		}
	}

	protected void renderItemsModOption(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemstack, float scale) {
		super.renderItemsModOption(entityLiving, pRealBlock, enumAction, itemstack, scale);
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 170
				| version > 179) return;
		ModchuModel_ModelDataBase entityCaps = ModchuModel_ModelDataMaster.instance.getPlayerData(entityLiving);
		if (entityCaps != null
				&& entityCaps instanceof ModchuModel_IEntityCaps
				&& Modchu_EntityCapsHelper.getCapsValueByte(null, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {
		} else {
			Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack);
			Class c = item.getClass();
			String itemClassName = c.getName().toLowerCase();
			String itemClassSimpleName = c.getSimpleName().toLowerCase();
			//Modchu_Debug.lDebug1("itemClassName="+itemClassName);
			if (itemClassSimpleName.startsWith("gvcitem")
					| itemClassName.startsWith("handmadeguns")) {
				Class ItemRenderType = Modchu_Reflect.loadClass("IItemRenderer$ItemRenderType");
				//Modchu_Debug.lDebug1("ItemRenderType="+ItemRenderType);
				if (ItemRenderType != null) {
					Enum itemRenderType = Modchu_AS.getEnum(ItemRenderType, "EQUIPPED");
					//Modchu_Debug.lDebug1("itemRenderType="+itemRenderType);
					if (itemRenderType != null) {
						Object IitemRenderer = Modchu_AS.get("MinecraftForgeClient", "getItemRenderer", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), ItemRenderType }, new Object[]{ itemstack, itemRenderType });
						//Modchu_Debug.lDebug1("IitemRenderer="+IitemRenderer);
						if (IitemRenderer != null) {
							//Modchu_Debug.dDebug("x="+Modchu_Debug.debaf1+" y="+Modchu_Debug.debaf2+" z="+Modchu_Debug.debaf3);
							//Modchu_GlStateManager.rotate(Modchu_Debug.debaf1, 1.0F, 0.0F, 0.0F);
							//Modchu_GlStateManager.rotate(Modchu_Debug.debaf2, 0.0F, 1.0F, 0.0F);
							//Modchu_GlStateManager.rotate(Modchu_Debug.debaf3, 0.0F, 0.0F, 1.0F);
							//Modchu_Debug.debaf1 = 91.4F;
							//Modchu_Debug.debaf2 = 194F;
							//Modchu_Debug.debaf3 = 70F;
							Modchu_GlStateManager.rotate(91.4F, 1.0F, 0.0F, 0.0F);
							Modchu_GlStateManager.rotate(194F, 0.0F, 1.0F, 0.0F);
							Modchu_GlStateManager.rotate(70F, 0.0F, 0.0F, 1.0F);
						}
					}
				}
			}
		}
	}

}