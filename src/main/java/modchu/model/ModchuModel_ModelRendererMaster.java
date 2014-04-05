package modchu.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IModelRenderer;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelBox;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelPlateFreeShape;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.lib.replace.Modchu_IModelCapsBase;
import modchu.lib.replace.Modchu_ModelBoxBaseBase;
import modchu.lib.replace.Modchu_ModelRendererBase;
import modchu.lib.replacepoint.Modchu_ModelMultiReplacePoint;
import modchu.lib.replacepoint.Modchu_ModelRendererReplacePoint;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ModchuModel_ModelRendererMaster implements Modchu_IModelRenderer {
	public Modchu_ModelRenderer base;

	public float preRotationPointX;
	public float preRotationPointY;
	public float preRotationPointZ;
	public float preRotateAngleX;
	public float preRotateAngleY;
	public float preRotateAngleZ;
	public boolean angleFirst;
	public Modchu_ModelRenderer parentModel;
	public String boxName;
	private static Random rnd = new Random();
	public List<Modchu_ModelRenderer> boneChildModels = new ArrayList();
	public List<Modchu_ModelRenderer> boneSpecialChildModels = new ArrayList();
	public boolean upsideDownRotation = false;
	private ConcurrentHashMap<String, Object> freeVariableMap;
	private ConcurrentHashMap<String, TextureOffset> textureOffsetMap;
	private ItemStack itemstack;

	//littleMaidMob共通
	private int textureOffsetX;
	private int textureOffsetY;
	private boolean compiled = false;
	private int displayList;
	private Modchu_ModelMultiReplacePoint baseModel;
	public Modchu_ModelRenderer pearent;

	//SmartMoving共通
	public Modchu_ModelRenderer pearentBase;
	public static final int XYZ = Modchu_ModelRenderer.RotZYX;
	public static final int XZY = Modchu_ModelRenderer.RotYZX;
	public static final int YXZ = Modchu_ModelRenderer.RotZXY;
	public static final int YZX = Modchu_ModelRenderer.RotXZY;
	public static final int ZXY = Modchu_ModelRenderer.RotYXZ;
	public static final int ZYX = Modchu_ModelRenderer.RotXYZ;
	public boolean ignoreRender;
	public boolean forceRender;
	public boolean ignoreBase;
	public boolean ignoreSuperRotation;
	public boolean fadeEnabled;
	public boolean fadeOffsetX;
	public boolean fadeOffsetY;
	public boolean fadeOffsetZ;
	public boolean fadeRotateAngleX;
	public boolean fadeRotateAngleY;
	public boolean fadeRotateAngleZ;
	public boolean fadeRotationPointX;
	public boolean fadeRotationPointY;
	public boolean fadeRotationPointZ;
	public Object previous;
	public float offsetX = 0.0F;
	public float offsetY = 0.0F;
	public float offsetZ = 0.0F;

/*//b181delete
	public List cubeList;
	public List childModels;
	private TexturedQuad faces[];
*///b181delete
/*//b173delete
	public static float textureWidth;
	public static float textureHeight;
*///b173delete

	public ModchuModel_ModelRendererMaster(Modchu_ModelRenderer renderBase, Modchu_ModelMultiReplacePoint modelBase, int i, int j, String s, Modchu_ModelRenderer modelRenderer) {
		base = renderBase;
		pearentBase = modelRenderer;
		if (pearentBase != null) pearentBase.addChild(base);
		preRotationPointX = 0.0F;
		preRotationPointY = 0.0F;
		preRotationPointZ = 0.0F;
		preRotateAngleX = 0.0F;
		preRotateAngleY = 0.0F;
		preRotateAngleZ = 0.0F;
		base.scaleX = 1.0F;
		base.scaleY = 1.0F;
		base.scaleZ = 1.0F;
		base.rotatePriority = ZYX;
		angleFirst = false; // 変換を当てる順番
		parentModel = null; // 同じ回転軸になる親
		textureOffsetX = i;
		textureOffsetY = j;
		boxName = s;
		base.adjust = true;
		base.matrix = BufferUtils.createFloatBuffer(16);
		base.isInvertX = false;
		baseModel = modelBase;
		pearent = null;
/*//b181delete
		cubeList = new ArrayList();
		setTextureSize((int)((MultiModel) modelbase).textureWidth, (int)((MultiModel) modelbase).textureHeight);
		modelbase.boxList.add(base);
*///b181delete
	}

	@Override
	public Modchu_ModelRenderer setTextureOffset(int i, int j) {
		textureOffsetX = i;
		textureOffsetY = j;
		return base;
	}

	@Override
	public int getTextureOffsetX() {
		return textureOffsetX;
	}

	@Override
	public int getTextureOffsetY() {
		return textureOffsetY;
	}

	@Override
	public ConcurrentHashMap<String, TextureOffset> getTextureOffsetMap() {
		return textureOffsetMap;
	}

	@Override
	public void setTextureOffset(String s, int par2, int par3) {
		textureOffsetMap.put(s, new TextureOffset(par2, par3));
	}

	@Override
	public TextureOffset getTextureOffset(String s) {
		return textureOffsetMap.get(s);
	}

	@Override
	public Modchu_ModelRenderer addCubeList(Object object) {
		if (upsideDownRotation) {
			Modchu_ModelRenderer container = new Modchu_ModelRenderer(baseModel, textureOffsetX, textureOffsetY);
			Modchu_Reflect.invokeMethod(container.cubeList.getClass(), "add", new Class[]{ Modchu_Reflect.getTopSuperClass(object) }, container.cubeList, new Object[]{ object });
			//container.cubeList.add((ModchuModel_ModelBoxBaseBase) object);
			addChild(container);
		} else Modchu_Reflect.invokeMethod(base.cubeList.getClass(), "add", new Class[]{ Modchu_Reflect.getTopSuperClass(object) }, base.cubeList, new Object[]{ object });
		//cubeList.add((ModchuModel_ModelBoxBaseBase) object);
		return base;
	}

	@Override
	public void addChild(Modchu_ModelRenderer modelRenderer) {
		if (base.childModels == null) {
			base.childModels = new ArrayList();
		}
		base.childModels.add(modelRenderer);
		modelRenderer.pearent = base;
	}

	@Override
	public Modchu_ModelRenderer addBox(String pName, float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth) {
		addParts(Modchu_ModelBox.class, pName, pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth) {
		return addBox(pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
	}

	@Override
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust) {
		addParts(Modchu_ModelBox.class, pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust, boolean b) {
		addParts(Modchu_ModelBox.class, pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust, b);
		return base;
	}

	@Override
	public Modchu_ModelRendererBase addParts(Class pModelBoxBase, String pName, Object... pArg) {
		pName = (new StringBuilder()).append(boxName).append(".").append(pName).toString();
		TextureOffset ltextureoffset = getTextureOffset(pName);
		if (ltextureoffset != null) ;else ltextureoffset = new TextureOffset(0, 0);
		int tempTextureOffsetX = textureOffsetX;
		int tempTextureOffsetY = textureOffsetY;
		setTextureOffset(ltextureoffset.textureOffsetX, ltextureoffset.textureOffsetY);
		addCubeList(((Modchu_ModelBoxBaseBase) base.superGetModelBoxBase(pModelBoxBase, getArg(pArg))).setBoxName(pName));
		setTextureOffset(tempTextureOffsetX, tempTextureOffsetY);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Object... pArg) {
		addCubeList(getModelBoxBaseObject(pModelBoxBase, getArg(pArg)));
		return base;
	}

	@Override
	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Class constructorClass, Object... pArg) {
		addCubeList(getModelBoxBaseObject(pModelBoxBase, constructorClass, getArg(pArg)));
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, String pName, Object... pArg) {
		pName = (new StringBuilder()).append(boxName).append(".").append(pName).toString();
		Object o = getModelBoxBaseObject(pModelBoxBase, pArg);
		addCubeList(Modchu_Reflect.invokeMethod(o.getClass(), "setBoxName", new Class[]{ String.class }, o, new Object[]{ pName }));
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, Object... pArg) {
		addCubeList(getModelBoxBaseObject(pModelBoxBase, pArg));
		return base;
	}

	@Override
	public Object getModelBoxBaseObject(Class pModelBoxBase, Object... pArg) {
		return Modchu_Reflect.newInstance(pModelBoxBase, new Class[]{ Modchu_ModelRendererReplacePoint.class, Object[].class }, new Object[]{ base, pArg });
	}

	@Override
	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
		addParts(ModchuModel_ModelPlate.class, f, f1, f2, i, j, k, 0.0F);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
		addParts(ModchuModel_ModelPlate.class, f, f1, f2, i, j, k, f3);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py) {
		float[][] vt = { { textureOffsetX / base.textureWidth, (textureOffsetY + 1) / base.textureHeight }, { (textureOffsetX + 1) / base.textureWidth, (textureOffsetY + 1) / base.textureHeight }, { (textureOffsetX + 1) / base.textureWidth, textureOffsetY / base.textureHeight }, { textureOffsetX / base.textureWidth, textureOffsetY / base.textureHeight } };
		addParts(Modchu_ModelPlateFreeShape.class, vertex, vt, vertexN, null, 0.0F);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN) {
		addParts(Modchu_ModelPlateFreeShape.class, vertex, texUV, vertexN, null, 0.0F);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4) {
		addParts(Modchu_ModelPlateFreeShape.class, var1, var2, var3, var4, 0.0F);
		return base;
	}

	@Override
	public Modchu_ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		return makeBall(var1, var2, var3, var4, var5, var6);
	}

	public Object[] getArg(Object ... pArg) {
		Object lobject[] = new Object[pArg.length + 2];
		lobject[0] = textureOffsetX;
		lobject[1] = textureOffsetY;
		for (int li = 0; li < pArg.length; li++) {
			lobject[2 + li] = pArg[li];
		}
		return lobject;
	}

	/**
	 * 描画用のボックス、子供をクリアする
	 */
	@Override
	public void clearCubeList() {
		if (base.cubeList != null) base.cubeList.clear();
		compiled = false;
		clearChildModels();
	}

	@Override
	public void renderItemsHead(Modchu_ModelMultiReplacePoint pModelMulti, ModchuModel_IModelCaps pEntityCaps, float scale, int addSupport) {
		ItemStack lis = (ItemStack) pEntityCaps.getCapsValue(Modchu_IModelCapsBase.caps_HeadMount);
		Entity lentity = (Entity) pEntityCaps.getCapsValue(Modchu_IModelCapsBase.caps_Entity);

		renderItems(lentity, pModelMulti.render, true, null, lis, scale, addSupport);
	}

	@Override
	public void renderItemsHead(Modchu_ModelMultiReplacePoint pModelMulti, ModchuModel_IModelCaps pEntityCaps, ItemStack lis, float scale, int addSupport) {
		Entity lentity = (Entity) pEntityCaps.getCapsValue(Modchu_IModelCapsBase.caps_Entity);

		renderItems(lentity, pModelMulti.render, true, null, lis, scale, addSupport);
	}

	@Override
	public boolean renderItems(Modchu_ModelMultiReplacePoint pModelMulti, ModchuModel_IModelCaps pEntityCaps, boolean pRealBlock, int pIndex) {
		ItemStack[] litemstacks = (ItemStack[]) ModchuModel_ModelCapsHelper.getCapsValue(pEntityCaps, Modchu_IModelCapsBase.caps_Items);
		if (litemstacks == null) return false;
		EnumAction[] lactions = (EnumAction[]) ModchuModel_ModelCapsHelper.getCapsValue(pEntityCaps, Modchu_IModelCapsBase.caps_Actions);
		Entity lentity = (Entity) pEntityCaps.getCapsValue(Modchu_IModelCapsBase.caps_Entity);

		renderItems(lentity, pModelMulti.render, pRealBlock, lactions[pIndex], litemstacks[pIndex]);
		return true;
	}

	@Override
	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack, float scale, int addSupport) {
		if (pEntityLiving != null) ;else return;
		itemstack = pItemStack;
		switch (addSupport) {
		case 0:
		case 1:
		case 2:
			renderDecoBlock(pEntityLiving, pRender, pRealBlock, pAction, scale, addSupport);
			return;
		}
		renderItems(pEntityLiving, pRender, pRealBlock, pAction, pItemStack, scale);
	}

	@Override
	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack) {
		if (pEntityLiving != null) ;
		else return;
		itemstack = pItemStack;
		renderItems(pEntityLiving, pRender, pRealBlock, pAction, pItemStack, 1.0F);
	}

	@Override
	public void renderItems(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack itemstack, float scale) {
		if (itemstack != null && pEntityLiving != null) ;else return;

		// アイテムのレンダリング
		GL11.glPushMatrix();
		RenderHelper.disableStandardItemLighting();
		int version = Modchu_Main.getMinecraftVersion();
		Item item = itemstack.getItem();
		Block block = (Block) Modchu_AS.get(Modchu_AS.getBlockItemStack, itemstack);
		boolean skullFlag = Modchu_AS.getBoolean(Modchu_AS.isSkull, item);
		// アイテムの種類による表示位置の補正
		if (base.adjust) {
//			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

			float sx = scale;
			float sy = scale;
			float sz = scale;
			if (pRealBlock
					&& block != null) {
				if (skullFlag) {
					scale = 1.0625F * scale;
					sx = scale;
					sy = -scale;
					sz = -scale;
					GL11.glScalef(sx, sy, sz);
				} else {
					float f2 = 0.625F;
					scale = f2 * scale;
					GL11.glTranslatef(0F, -scale * 0.495F, 0F);
					if (Modchu_AS.getBoolean(Modchu_AS.isPlanter, block)) {
						GL11.glRotatef(12F, 0F, 1F, 0);
					} else {
//-@-125
						GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
//@-@125
						// 125deleteGL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
					}
					GL11.glScalef(scale, -scale, -scale);
				}
			} else {
				float var6;
//-@-132
				boolean flag2 = version > 169
						| (version < 170
								&& Modchu_AS.getInt(Modchu_AS.itemStackItemID, itemstack) < 256);
				if (pRealBlock && skullFlag) {
					scale = 1.0625F * scale;
					sx = scale;
					sy = -scale;
					sz = -scale;
				} else
				//@-@132
				if (flag2
						&& block != null
						&& RenderBlocks.renderItemIn3d(block.getRenderType())) {
					var6 = 0.5F;
//					GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
					GL11.glTranslatef(0.0F, 0.1875F, -0.2125F);
					var6 *= 0.75F;
					GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
				} else if (item instanceof ItemBow) {
					var6 = 0.625F;
					GL11.glTranslatef(-0.05F, 0.125F, 0.3125F);
					GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				} else if (item.isFull3D()) {
					var6 = 0.625F;

					if (item.shouldRotateAroundWhenRendering()) {
						GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
						GL11.glTranslatef(0.0F, -0.125F, 0.0F);
					}

					if (pAction == EnumAction.block) {
						GL11.glTranslatef(0.05F, 0.0F, -0.1F);
						GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
					}

					GL11.glTranslatef(0.0F, 0.1875F, 0.1F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				} else {
					var6 = 0.375F;
					GL11.glTranslatef(0.15F, 0.15F, -0.05F);
					//	GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
					GL11.glScalef(var6, var6, var6);
					GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
				}
				GL11.glScalef(sx, sy, sz);
			}
		}
//-@-132
		if (pRealBlock
				&& skullFlag) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			String var6 = "";
			if (itemstack.hasTagCompound()
					&& itemstack.getTagCompound().hasKey("SkullOwner")) {
				var6 = itemstack.getTagCompound().getString("SkullOwner");
			}
			if (version > 169) {
				Object skullRenderer = Modchu_Reflect.getFieldObject(TileEntitySkullRenderer.class, "field_147536_b");
				Modchu_Reflect.invokeMethod(skullRenderer.getClass(), "func_147530_a", new Class[]{ float.class, float.class, float.class, int.class, float.class, int.class, String.class }, skullRenderer, new Object[]{ -0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), var6 });
			} else {
				Object skullRenderer = Modchu_Reflect.getFieldObject(TileEntitySkullRenderer.class, "skullRenderer");
				Modchu_Reflect.invokeMethod(skullRenderer.getClass(), "func_82393_a", new Class[]{ float.class, float.class, float.class, int.class, float.class, int.class, String.class }, skullRenderer, new Object[]{ -0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), var6 });
			}
		} else
//@-@132
		if (pRealBlock
				&& block != null) {
// 152deleteString s1 = "/terrain.png";
/*//147delete
			if (Modchu_Main.isForge) {
				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", Item.itemsList[itemstack.itemID]);
				//Modchu_Debug.Debug("isForge pRender.func_110776_a s1="+s1);
			}
*///147delete
			// 152deletepRender.func_110776_a(s1);
			loadBlockTexture();
			GL11.glEnable(GL11.GL_CULL_FACE);
			Object renderBlocks = Modchu_AS.get(Modchu_AS.renderRenderBlocks, pRender);
			Class BlockDoublePlant = Modchu_Reflect.loadClass("net.minecraft.block.BlockDoublePlant");
			if (BlockDoublePlant != null
					&& BlockDoublePlant.isInstance(block)) {
				float f1 = 1.8F;
				GL11.glScalef(f1, f1, f1);
				int x = (int) Modchu_AS.getDouble(Modchu_AS.entityPosX, pEntityLiving);
				int y = (int) Modchu_AS.getDouble(Modchu_AS.entityPosY, pEntityLiving);
				int z = (int) Modchu_AS.getDouble(Modchu_AS.entityPosZ, pEntityLiving);
				renderBlockDoublePlant((RenderBlocks) renderBlocks, block, itemstack.getItemDamage(), 0.0D, x, y, z);
			} else {
				Modchu_AS.set(Modchu_AS.renderBlocksRenderBlockAsItem, renderBlocks, block, itemstack.getItemDamage(), 1.0F);
			}
			GL11.glDisable(GL11.GL_CULL_FACE);
		} else {
			// アイテムに色付け
			int renderPasses = item.requiresMultipleRenderPasses() ? 1 : 0;

/*//147delete
			String s1 = "/gui/items.png";
			if (Modchu_Main.isForge) {
				if (renderPasses == 1) renderPasses =
						(Integer) Modchu_Reflect.invokeMethod(Item.class, "getRenderPasses", new Class[]{ int.class },
								item, new Object[]{ itemstack.getItemDamage() }) - 1;
				s1 = (String) Modchu_Reflect.invokeMethod(Item.class, "getTextureFile", item);
				//Modchu_Debug.Debug("isForge pRender.func_110776_a s1="+s1+" renderPasses="+renderPasses);
			} else if (Modchu_Main.isBTW
					&& isBTWItem(item)) {
				s1 = "/btwmodtex/btwitems01.png";
			}
*///147delete
			// 152deletepRender.func_110776_a(s1);
			for (int j = 0; j <= renderPasses; j++) {
				if (!ModchuModel_Main.isSSP
						| renderPasses > 0) {
					int k = item.getColorFromItemStack(itemstack, j);
					float f15 = (k >> 16 & 0xff) / 255F;
					float f17 = (k >> 8 & 0xff) / 255F;
					float f19 = (k & 0xff) / 255F;
					GL11.glColor4f(f15, f17, f19, 1.0F);
				}
				Modchu_AS.set(Modchu_AS.renderManagerItemRendererRenderItem, pEntityLiving, itemstack, j);
				//pRender.renderManager.itemRenderer.renderItem(pEntityLiving, itemstack, j);
			}
		}

		GL11.glPopMatrix();
	}

	@Override
	public boolean renderBlockDoublePlant(RenderBlocks renderBlocks, Object blockDoublePlant, int i, double d, int x, int y, int z) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		World theWorld = ((World) Modchu_AS.get(Modchu_AS.minecraftTheWorld));
		int brightness = ((BlockDoublePlant) blockDoublePlant).getMixedBrightnessForBlock(theWorld, x, y + 2, z);
		//Modchu_Debug.dDebug("brightness="+brightness);
		tessellator.setBrightness(brightness);

		int l = i != 2 && i != 3 ? ((BlockDoublePlant) blockDoublePlant).colorMultiplier(theWorld, x, y, z) : theWorld.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
		//Modchu_Debug.dDebug("l="+l+" x="+x+" y="+y+" z="+z+" i="+i);
		float f = (l >> 16 & 255) / 255.0F;
		float f1 = (l >> 8 & 255) / 255.0F;
		float f2 = (l & 255) / 255.0F;

		if (EntityRenderer.anaglyphEnable) {
			float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
			float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
			float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
			f = f3;
			f1 = f4;
			f2 = f5;
		}
		tessellator.setColorOpaque_F(f, f1, f2);

		boolean flag1 = BlockDoublePlant.func_149887_c(i == 0 ? 8 : i);
		int k1;

		if (flag1) {
			k1 = 0;
		} else {
			k1 = BlockDoublePlant.func_149890_d(i);
		}

		IIcon iicon;
		boolean flag = false;
		for (int i1 = 0; i1 < 3; i1++) {
			flag = i == 0 ? true : i1 > 1;
			iicon = ((BlockDoublePlant) blockDoublePlant).func_149888_a(flag, i);
			renderBlocks.drawCrossedSquares(iicon, -0.5D + (0.001D * i1), -0.25D + (0.5D * i1), -0.5D, 1.0F);
		}
		//Modchu_Debug.mDebug("iicon="+iicon);
		//Modchu_Debug.mDebug("flag1="+flag1+" k1="+k1);
		if (flag1 && k1 == 0) {
			double x2 = -0.5D;
			double y2 = 0.85D;
			double z2 = -0.5D;
			IIcon iicon1 = ((BlockDoublePlant) blockDoublePlant).sunflowerIcons[0];
			double d2 = Math.cos(d * 0.8D) * Math.PI * 0.1D;
			d2 = 1.5D;
			double d3 = Math.cos(d2);
			double d4 = Math.sin(d2);
			double d5 = iicon1.getMinU();
			double d6 = iicon1.getMinV();
			double d7 = iicon1.getMaxU();
			double d8 = iicon1.getMaxV();
			double d9 = 0.3D;
			double d10 = -0.05D;
			double d11 = 0.5D + 0.3D * d3 - 0.5D * d4;
			double d12 = 0.5D + 0.5D * d3 + 0.3D * d4;
			double d13 = 0.5D + 0.3D * d3 + 0.5D * d4;
			double d14 = 0.5D + -0.5D * d3 + 0.3D * d4;
			double d15 = 0.5D + -0.05D * d3 + 0.5D * d4;
			double d16 = 0.5D + -0.5D * d3 + -0.05D * d4;
			double d17 = 0.5D + -0.05D * d3 - 0.5D * d4;
			double d18 = 0.5D + 0.5D * d3 + -0.05D * d4;
			tessellator.addVertexWithUV(x2 + d15, y2 + 1.0D, z2 + d16, d5, d8);
			tessellator.addVertexWithUV(x2 + d17, y2 + 1.0D, z2 + d18, d7, d8);
			tessellator.addVertexWithUV(x2 + d11, y2 + 0.0D, z2 + d12, d7, d6);
			tessellator.addVertexWithUV(x2 + d13, y2 + 0.0D, z2 + d14, d5, d6);
			IIcon iicon2 = ((BlockDoublePlant) blockDoublePlant).sunflowerIcons[1];
			d5 = iicon2.getMinU();
			d6 = iicon2.getMinV();
			d7 = iicon2.getMaxU();
			d8 = iicon2.getMaxV();
			tessellator.addVertexWithUV(x2 + d17, y2 + 1.0D, z2 + d18, d5, d8);
			tessellator.addVertexWithUV(x2 + d15, y2 + 1.0D, z2 + d16, d7, d8);
			tessellator.addVertexWithUV(x2 + d13, y2 + 0.0D, z2 + d14, d7, d6);
			tessellator.addVertexWithUV(x2 + d11, y2 + 0.0D, z2 + d12, d5, d6);
		}
		tessellator.draw();
		return true;
	}

	@Override
	public boolean renderDecoBlock(Entity pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale, int addSupport) {
		//DecoBlock, FavBlock用描画
		Block block = (Block) Modchu_AS.get(Modchu_AS.getBlockItemStack, itemstack);
		boolean flag = false;
		boolean rotate = false;
		boolean translatef = false;
		boolean particle = false;
		int particleFrequency = 98;
		String particleString = null;
		float translatefX = 0.0F;
		float translatefY = 0.5F;
		float translatefZ = 0.0F;
		//addSupport = 0 DecoBlock
		//addSupport = 1 DecoBlockBase
		if (addSupport < 2) {
			translatef = true;
			if (addSupport == 0) {
				flag = rotate = true;
				particle = true;
				particleString = "heart";
			} else if (addSupport == 1) {
				flag = rotate = true;
			}
		}
		//addSupport = 2 FavBlock
		if (addSupport == 2) {
			flag = rotate = true;
			translatef = true;
			translatefX = 0.0F;
			translatefY = 0.4F;
			translatefZ = 0.0F;
			particle = true;
			particleString = "instantSpell";
			particleFrequency = 80;
		}
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);

		if (flag) {
			// 152deletepRender.func_110776_a("/terrain.png");
			GL11.glEnable(GL11.GL_CULL_FACE);
			if (rotate) GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
			else GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
//-@-b173
/*
			int k = itemstack.getItem().getColorFromItemStack(itemstack, 0);
			float f9 = (float)(k >> 16 & 0xff) / 255F;
			float f10 = (float)(k >> 8 & 0xff) / 255F;
			float f12 = (float)(k & 0xff) / 255F;
			GL11.glColor4f(f9, f10, f12, 1.0F);
*/
//@-@b173
			if (scale > 1.0F) GL11.glScalef(scale, scale, scale);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			if (translatef) GL11.glTranslatef(translatefX, translatefY, translatefZ);
			loadBlockTexture();
			Object renderBlocks = Modchu_AS.get(Modchu_AS.renderRenderBlocks, pRender);
			Modchu_AS.get(Modchu_AS.renderBlocksRenderBlockAsItem, renderBlocks, block, itemstack.getItemDamage(), 1.0F);
			particleFrequency -= (int) ((scale - 1.0F) * 10F);
			//Modchu_Debug.mDebug("particleFrequency ="+particleFrequency+" (int)(scale - 1.0F * 10F)="+((int)((scale - 1.0F) * 10F))+" scale="+scale);
			if (particle && rnd.nextInt(100) > particleFrequency) {
				double d = rnd.nextGaussian() * 0.02D;
				double d1 = rnd.nextGaussian() * 0.02D;
				double d2 = rnd.nextGaussian() * 0.02D;
				pEntityLiving.worldObj.spawnParticle(particleString, (pEntityLiving.posX + (rnd.nextFloat() * pEntityLiving.width * 2.0F)) - pEntityLiving.width, pEntityLiving.posY - 0.5D + (rnd.nextFloat() * pEntityLiving.height), (pEntityLiving.posZ + (rnd.nextFloat() * pEntityLiving.width * 2.0F)) - pEntityLiving.width, d, d1, d2);
			}
			GL11.glDisable(GL11.GL_CULL_FACE);
			/*b173//*/GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		return flag;
	}

	private void loadBlockTexture() {
		if (Modchu_Main.getMinecraftVersion() < 160) return;
		Object textureManager = Modchu_AS.get(Modchu_AS.minecraftTextureManager);
		Modchu_AS.set(Modchu_AS.textureManagerBindTexture, textureManager, Modchu_Reflect.invokeMethod("TextureManager", "func_130087_a", "getResourceLocation", new Class[]{ int.class }, textureManager, new Object[]{ 0 }));
		//TextureManager var4 = Minecraft.getMinecraft().getTextureManager();
		//var4.bindTexture(var4.getResourceLocation(0));
	}

	private boolean isBTWItem(Item var1) {
		Class c = Modchu_Reflect.loadClass("net.minecraft.src.forge.ITextureProvider");
		if (c != null) ;
		else Modchu_Reflect.loadClass("forge.ITextureProvider");
		if (c != null) {
			Class[] var3 = var1.getClass().getInterfaces();
			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var3[var4] == c) return true;
			}
		} else {
			c = Modchu_Reflect.loadClass("net.minecraft.src.FCItemMattock");
			if (c != null && c.isInstance(var1)) return true;
			c = Modchu_Reflect.loadClass("FCItemMattock");
			if (c != null && c.isInstance(var1)) return true;
		}
		return false;
	}

	@Override
	public void setRotatePriority(int pValue) {
		// 回転変換を行う順序、rot???を指定する
		base.rotatePriority = pValue;
	}

	@Override
	public void setRotation() {
		// 変換順位の設定
		switch (base.rotatePriority) {
		case Modchu_ModelRenderer.RotXYZ:
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case Modchu_ModelRenderer.RotXZY:
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case Modchu_ModelRenderer.RotYXZ:
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case Modchu_ModelRenderer.RotYZX:
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case Modchu_ModelRenderer.RotZXY:
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		case Modchu_ModelRenderer.RotZYX:
			if (base.rotateAngleX != 0.0F) {
				GL11.glRotatef(base.rotateAngleX * base.radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (base.rotateAngleY != 0.0F) {
				GL11.glRotatef(base.rotateAngleY * base.radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (base.rotateAngleZ != 0.0F) {
				GL11.glRotatef(base.rotateAngleZ * base.radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		}
	}

	@Override
	public void renderObject(float par1, boolean b) {
		// レンダリング、あと子供も
		if (base.showModel) {
			GL11.glScalef(base.scaleX, base.scaleY, base.scaleZ);
			GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, base.matrix);
			if (b) GL11.glCallList(displayList);
		}
		if (base.childModels != null) {
			Modchu_ModelRenderer modelRenderer;
			for (int i = 0; i < base.childModels.size(); i++) {
				modelRenderer = (Modchu_ModelRenderer) base.childModels.get(i);
				if (modelRenderer != null) modelRenderer.render(par1, b);
			}
		}
	}

	@Override
	public void render(float par1) {
		render(par1, base.showModel);
	}

	@Override
	public void render(float par1, boolean b) {
		if (base.isHidden) return;

		if (base.showModel && !compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		if (upsideDownRotation) upsideDownMove();
		GL11.glTranslatef(offsetX, offsetY, offsetZ);

		if (base.rotationPointX != 0.0F || base.rotationPointY != 0.0F || base.rotationPointZ != 0.0F) {
			GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);
		}
		if (base.rotateAngleX != 0.0F || base.rotateAngleY != 0.0F || base.rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, b);
		GL11.glPopMatrix();
	}

	private void upsideDownMove() {
		Modchu_ModelRendererReplacePoint child = (Modchu_ModelRendererReplacePoint) base.childModels.get(0);
		Modchu_ModelBox box = (Modchu_ModelBox) child.cubeList.get(0);
		GL11.glTranslatef(-box.boxSizeX, -box.boxSizeY, -box.boxSizeZ);
	}

	@Override
	public void renderWithRotation(float par1) {
		if (base.isHidden) {
			return;
		}

		if (base.showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);

		setRotation();

		GL11.glCallList(displayList);
		GL11.glPopMatrix();
	}

	@Override
	public void postRender(float par1) {
		if (base.showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		if (base.rotateAngleX != 0.0F || base.rotateAngleY != 0.0F || base.rotateAngleZ != 0.0F) {
			GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);

			setRotation();
		} else if (base.rotationPointX != 0.0F || base.rotationPointY != 0.0F || base.rotationPointZ != 0.0F) {
			GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);
		}

		if (pearent != null) {
			pearent.postRender(par1);
		}
		GL11.glPopMatrix();
	}

	@Override
	public void postRenderAll(float par1, boolean b) {
		if (base.isHidden) {
			return;
		}

		if (b && !compiled) {
			compileDisplayList(par1);
		}

		if (base.rotateAngleX != 0.0F || base.rotateAngleY != 0.0F || base.rotateAngleZ != 0.0F) {
			GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);

			setRotation();
		} else if (base.rotationPointX != 0.0F || base.rotationPointY != 0.0F || base.rotationPointZ != 0.0F) {
			GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);
		}
		// ポストレンダリング、あと子供も
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, base.matrix);

		if (base.childModels != null) {
			for (int i = 0; i < base.childModels.size(); i++) {
				((Modchu_ModelRenderer) base.childModels.get(i)).postRenderAll(par1, b);
			}
		}
	}

	/**
	* Compiles a GL display list for base model
	*/
	@Override
	public void compileDisplayList(float par1) {
		displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		Tessellator tessellator = Tessellator.instance;
		for (int i = 0; i < base.cubeList.size(); i++) {
			base.cubeList.get(i).render(tessellator, par1);
		}

		GL11.glEndList();
		compiled = true;
	}

	@Override
	public void preRotateRender(float f) {
		//
		if (setParentsRotate()
				&& !parentModel.showModel) {
			return;
		}
		if (base.isHidden) {
			return;
		}
		if (!base.showModel) {
			return;
		}
		float f1 = base.rotationPointX;
		float f2 = base.rotationPointY;
		float f3 = base.rotationPointZ;
		float f4 = base.rotateAngleX;
		float f5 = base.rotateAngleY;
		float f6 = base.rotateAngleZ;
		GL11.glPushMatrix();
		postRender(f);
		base.rotationPointX = 0.0F;
		base.rotationPointY = 0.0F;
		base.rotationPointZ = 0.0F;
		base.rotateAngleX = 0.0F;
		base.rotateAngleY = 0.0F;
		base.rotateAngleZ = 0.0F;

		if (!angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		if (preRotateAngleZ != 0.0F) {
			GL11.glRotatef(preRotateAngleZ * 57.29578F, 0.0F, 0.0F, 1.0F);
		}
		if (preRotateAngleY != 0.0F) {
			GL11.glRotatef(preRotateAngleY * 57.29578F, 0.0F, 1.0F, 0.0F);
		}
		if (preRotateAngleX != 0.0F) {
			GL11.glRotatef(preRotateAngleX * 57.29578F, 1.0F, 0.0F, 0.0F);
		}
		if (angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		render(f);

		GL11.glPopMatrix();

		base.rotationPointX = f1;
		base.rotationPointY = f2;
		base.rotationPointZ = f3;
		base.rotateAngleX = f4;
		base.rotateAngleY = f5;
		base.rotateAngleZ = f6;
	}

	@Override
	public void preRotateRenderDeg(float f) {
		// preRotationAngleの値を角度で入れる（90°とか）
		if (setParentsRotate()
				&& !parentModel.showModel) {
			return;
		}
		if (base.isHidden) {
			return;
		}
		if (!base.showModel) {
			return;
		}
		float f1 = base.rotationPointX;
		float f2 = base.rotationPointY;
		float f3 = base.rotationPointZ;
		float f4 = base.rotateAngleX;
		float f5 = base.rotateAngleY;
		float f6 = base.rotateAngleZ;
		GL11.glPushMatrix();
		postRender(f);
		base.rotationPointX = 0.0F;
		base.rotationPointY = 0.0F;
		base.rotationPointZ = 0.0F;
		base.rotateAngleX = 0.0F;
		base.rotateAngleY = 0.0F;
		base.rotateAngleZ = 0.0F;
		if (!angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		if (preRotateAngleZ != 0.0F) {
			GL11.glRotatef(preRotateAngleZ, 0.0F, 0.0F, 1.0F);
		}
		if (preRotateAngleY != 0.0F) {
			GL11.glRotatef(preRotateAngleY, 0.0F, 1.0F, 0.0F);
		}
		if (preRotateAngleX != 0.0F) {
			GL11.glRotatef(preRotateAngleX, 1.0F, 0.0F, 0.0F);
		}
		if (angleFirst) {
			GL11.glTranslatef(preRotationPointX * f, preRotationPointY * f, preRotationPointZ * f);
		}
		render(f);
		GL11.glPopMatrix();
		base.rotationPointX = f1;
		base.rotationPointY = f2;
		base.rotationPointZ = f3;
		base.rotateAngleX = f4;
		base.rotateAngleY = f5;
		base.rotateAngleZ = f6;
	}

	@Override
	public boolean setParentsRotate() {
		// 親があるならその間接情報をコピー
		if (parentModel != null) {
			base.rotationPointX = parentModel.rotationPointX;
			base.rotationPointY = parentModel.rotationPointY;
			base.rotationPointZ = parentModel.rotationPointZ;
			base.rotateAngleX = parentModel.rotateAngleX;
			base.rotateAngleY = parentModel.rotateAngleY;
			base.rotateAngleZ = parentModel.rotateAngleZ;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setPreRotationPointLM(float f, float f1, float f2) {
		preRotationPointX = f;
		preRotationPointY = f1;
		preRotationPointZ = f2;
	}

	@Override
	public void individuallyHidePreRotateRender(float par1) {
		if (!base.isHidden) {
			GL11.glPushMatrix();
			preRotateRender(par1);
			if (base.showModel && !compiled) {
				compileDisplayList(par1);
			}

			Iterator var2;
			Modchu_ModelRenderer var3;

			if (preRotateAngleX == 0.0F
					&& preRotateAngleY == 0.0F
					&& preRotateAngleZ == 0.0F) {
				if (base.rotationPointX == 0.0F
						&& base.rotationPointY == 0.0F
						&& base.rotationPointZ == 0.0F) {
					GL11.glCallList(displayList);

					if (base.childModels != null) {
						var2 = base.childModels.iterator();

						while (var2.hasNext()) {
							var3 = (Modchu_ModelRenderer) var2.next();
							if (var3.showModel) var3.render(par1);
						}
					}
				} else {
					GL11.glPushMatrix();
					GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);
					GL11.glCallList(displayList);

					if (base.childModels != null) {
						var2 = base.childModels.iterator();

						while (var2.hasNext()) {
							var3 = (Modchu_ModelRenderer) var2.next();
							if (var3.showModel) var3.render(par1);
						}
					}

					GL11.glPopMatrix();
				}
			} else {
				GL11.glPushMatrix();
				GL11.glTranslatef(base.rotationPointX * par1, base.rotationPointY * par1, base.rotationPointZ * par1);

				if (preRotateAngleZ != 0.0F) {
					GL11.glRotatef(preRotateAngleZ * (180F / (float) Math.PI), 0.0F, 0.0F, 1.0F);
				}

				if (preRotateAngleY != 0.0F) {
					GL11.glRotatef(preRotateAngleY * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
				}

				if (preRotateAngleX != 0.0F) {
					GL11.glRotatef(preRotateAngleX * (180F / (float) Math.PI), 1.0F, 0.0F, 0.0F);
				}

				GL11.glCallList(displayList);

				if (base.childModels != null) {
					var2 = base.childModels.iterator();

					while (var2.hasNext()) {
						var3 = (Modchu_ModelRenderer) var2.next();
						if (var3.showModel) var3.render(par1);
					}
				}

				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public List<Modchu_ModelRenderer> getBoneChildModels() {
		return boneChildModels;
	}

	@Override
	public void addBoneChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneChildModels != null) ;
		else boneChildModels = new ArrayList();
		if (!boneChildModels.contains(par1ModelRenderer)) boneChildModels.add(par1ModelRenderer);
	}

	@Override
	public List<Modchu_ModelRenderer> getBoneSpecialChildModels() {
		return boneSpecialChildModels;
	}

	@Override
	public void addBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneSpecialChildModels != null) ;
		else boneSpecialChildModels = new ArrayList();
		if (!boneSpecialChildModels.contains(par1ModelRenderer)) boneSpecialChildModels.add(par1ModelRenderer);
	}

	@Override
	public void removeChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (base.childModels != null) ;
		else return;
		if (base.childModels.contains(par1ModelRenderer)) base.childModels.remove(par1ModelRenderer);
	}

	@Override
	public void removeBoneChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneChildModels != null) ;
		else return;
		if (boneChildModels.contains(par1ModelRenderer)) boneChildModels.remove(par1ModelRenderer);
	}

	@Override
	public void removeBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer) {
		if (boneSpecialChildModels != null) ;
		else return;
		if (boneSpecialChildModels.contains(par1ModelRenderer)) boneSpecialChildModels.remove(par1ModelRenderer);
	}

	@Override
	public void clearChildModels() {
		if (base.childModels != null) base.childModels.clear();
	}

	@Override
	public void clearBoneChildModels() {
		if (boneChildModels != null) boneChildModels.clear();
	}

	@Override
	public void clearBoneSpecialChildModels() {
		if (boneSpecialChildModels != null) boneSpecialChildModels.clear();
	}

	private Modchu_ModelRenderer makeBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		float[][] var7 = new float[][]{ { 0.0F, 4.9745197F, -0.0F }, { 0.0F, 3.5175202F, 3.5175202F }, { 2.4997F, 3.5175202F, 2.4872599F }, { 3.5351F, 3.5175202F, -0.0F }, { 2.4997F, 3.5175202F, -2.4872599F }, { 0.0F, 3.5175202F, -3.5175202F }, { -2.4997F, 3.5175202F, -2.4872599F }, { -3.5351F, 3.5175202F, -0.0F }, { -2.4997F, 3.5175202F, 2.4872599F }, { 0.0F, 0.0F, 4.9745197F }, { 3.5351F, 0.0F, 3.5175202F }, { 4.99939F, 0.0F, 0.0F }, { 3.5351F, -0.0F, -3.5175202F }, { 0.0F, -0.0F, -4.9745197F }, { -3.5351F, -0.0F, -3.5175202F }, { -4.99939F, 0.0F, 0.0F }, { -3.5351F, 0.0F, 3.5175202F }, { 0.0F, -3.5175202F, 3.5175202F }, { 2.4997F, -3.5175202F, 2.4872599F }, { 3.5351F, -3.5175202F, 0.0F }, { 2.4997F, -3.5175202F, -2.4872599F }, { 0.0F, -3.5175202F, -3.5175202F }, { -2.4997F, -3.5175202F, -2.4872599F }, { -3.5351F, -3.5175202F, 0.0F }, { -2.4997F, -3.5175202F, 2.4872599F }, { 0.0F, -4.9745197F, 0.0F } };
		float[][] var8 = new float[][]{ { textureOffsetX / base.textureWidth, (textureOffsetY + 1) / base.textureHeight }, { (textureOffsetX + 1) / base.textureWidth, (textureOffsetY + 1) / base.textureHeight }, { (textureOffsetX + 1) / base.textureWidth, textureOffsetY / base.textureHeight }, { textureOffsetX / base.textureWidth, textureOffsetY / base.textureHeight } };
		float[][] var9 = new float[][]{ { 0.0F, 1.0F, 0.0F }, { 0.0F, 0.663167F, 0.748436F }, { 0.527909F, 0.663594F, 0.529984F }, { 0.747673F, 0.664052F, 0.0F }, { 0.527909F, 0.663594F, -0.529984F }, { 0.0F, 0.663167F, -0.748436F }, { -0.527909F, 0.663594F, -0.529984F }, { -0.747673F, 0.664052F, 0.0F }, { -0.527909F, 0.663594F, 0.529984F }, { 0.0F, 0.0F, 0.999969F }, { 0.706076F, 0.0F, 0.70809F }, { 1.0F, 0.0F, 0.0F }, { 0.706107F, 0.0F, -0.70809F }, { 0.0F, 0.0F, -0.999969F }, { -0.706076F, 0.0F, -0.70809F }, { -1.0F, 0.0F, 0.0F }, { -0.706107F, 0.0F, 0.70809F }, { 0.0F, -0.663167F, 0.748436F }, { 0.527909F, -0.663594F, 0.529984F }, { 0.747673F, -0.664052F, 0.0F }, { 0.527909F, -0.663594F, -0.529984F }, { 0.0F, -0.663167F, -0.748436F }, { -0.527909F, -0.663594F, -0.529984F }, { -0.747673F, -0.664052F, 0.0F }, { -0.527909F, -0.663594F, 0.529984F }, { 0.0F, -1.0F, 0.0F } };
		int[][][] var10 = new int[][][]{ { { 1 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } }, { { 1 }, { 0, 2, 3 }, { 0, 1, 2 }, { 0, 2, 3 } }, { { 1 }, { 0, 3, 4 }, { 0, 1, 2 }, { 0, 3, 4 } }, { { 1 }, { 0, 4, 5 }, { 0, 1, 2 }, { 0, 4, 5 } }, { { 1 }, { 0, 5, 6 }, { 0, 1, 2 }, { 0, 5, 6 } }, { { 1 }, { 0, 6, 7 }, { 0, 1, 2 }, { 0, 6, 7 } }, { { 1 }, { 0, 7, 8 }, { 0, 1, 2 }, { 0, 7, 8 } }, { { 1 }, { 0, 8, 1 }, { 0, 1, 2 }, { 0, 8, 1 } }, { { 1 }, { 1, 9, 10, 2 }, { 0, 1, 2, 3 }, { 1, 9, 10, 2 } }, { { 1 }, { 2, 10, 11, 3 }, { 0, 1, 2, 3 }, { 2, 10, 11, 3 } }, { { 1 }, { 3, 11, 12, 4 }, { 0, 1, 2, 3 }, { 3, 11, 12, 4 } }, { { 1 }, { 4, 12, 13, 5 }, { 0, 1, 2, 3 }, { 4, 12, 13, 5 } }, { { 1 }, { 5, 13, 14, 6 }, { 0, 1, 2, 3 }, { 5, 13, 14, 6 } }, { { 1 }, { 6, 14, 15, 7 }, { 0, 1, 2, 3 }, { 6, 14, 15, 7 } }, { { 1 }, { 7, 15, 16, 8 }, { 0, 1, 2, 3 }, { 7, 15, 16, 8 } }, { { 1 }, { 8, 16, 9, 1 }, { 0, 1, 2, 3 }, { 8, 16, 9, 1 } }, { { 1 }, { 9, 17, 18, 10 }, { 0, 1, 2, 3 }, { 9, 17, 18, 10 } }, { { 1 }, { 10, 18, 19, 11 }, { 0, 1, 2, 3 }, { 10, 18, 19, 11 } }, { { 1 }, { 11, 19, 20, 12 }, { 0, 1, 2, 3 }, { 11, 19, 20, 12 } }, { { 1 }, { 12, 20, 21, 13 }, { 0, 1, 2, 3 }, { 12, 20, 21, 13 } }, { { 1 }, { 13, 21, 22, 14 }, { 0, 1, 2, 3 }, { 13, 21, 22, 14 } }, { { 1 }, { 14, 22, 23, 15 }, { 0, 1, 2, 3 }, { 14, 22, 23, 15 } }, { { 1 }, { 15, 23, 24, 16 }, { 0, 1, 2, 3 }, { 15, 23, 24, 16 } }, { { 1 }, { 16, 24, 17, 9 }, { 0, 1, 2, 3 }, { 16, 24, 17, 9 } }, { { 1 }, { 17, 25, 18 }, { 0, 1, 2 }, { 17, 25, 18 } }, { { 1 }, { 18, 25, 19 }, { 0, 1, 2 }, { 18, 25, 19 } }, { { 1 }, { 19, 25, 20 }, { 0, 1, 2 }, { 19, 25, 20 } }, { { 1 }, { 20, 25, 21 }, { 0, 1, 2 }, { 20, 25, 21 } }, { { 1 }, { 21, 25, 22 }, { 0, 1, 2 }, { 21, 25, 22 } }, { { 1 }, { 22, 25, 23 }, { 0, 1, 2 }, { 22, 25, 23 } }, { { 1 }, { 23, 25, 24 }, { 0, 1, 2 }, { 23, 25, 24 } }, { { 1 }, { 24, 25, 17 }, { 0, 1, 2 }, { 24, 25, 17 } } };
		int var11;

		for (var11 = 0; var11 < var7.length; ++var11) {
			var7[var11][0] *= var4 / 8.0F;
			var7[var11][1] *= var5 / 8.0F;
			var7[var11][2] *= var6 / 8.0F;
			var7[var11][0] += var1;
			var7[var11][1] += var2;
			var7[var11][2] += var3;
		}

		for (var11 = 0; var11 < var10.length; ++var11) {
			int var12 = var10[var11][1].length;
			float[][] var13 = new float[var12][3];
			float[][] var14 = new float[var12][2];
			float[][] var15 = new float[var12][3];

			if (var10[var11][0][0] == 1) {
				for (int var16 = 0; var16 < var12; ++var16) {
					var13[var16] = var7[var10[var11][1][var16]];
					var14[var16] = var8[var10[var11][2][var16]];
					var15[var16] = var9[var10[var11][3][var16]];
				}

				addPlateFreeShape(var13, var14, var15, (float[]) null);
			}
		}

		return base;
	}

	@Override
	public void setCompiled(boolean b) {
		compiled = b;
	}

	@Override
	public int getBoxSizeX() {
		return getboxSizeX(0);
	}

	@Override
	public int getBoxSizeY() {
		return getboxSizeY(0);
	}

	@Override
	public int getBoxSizeZ() {
		return getboxSizeZ(0);
	}

	@Override
	public int getboxSizeX(int i) {
		return base.cubeList != null
				&& base.cubeList.size() > i ? (Integer) Modchu_Reflect.getFieldObject(base.cubeList.get(i).getClass(), "boxSizeX", base.cubeList.get(i)) : -1;
	}

	@Override
	public int getboxSizeY(int i) {
		return base.cubeList != null
				&& base.cubeList.size() > i ? (Integer) Modchu_Reflect.getFieldObject(base.cubeList.get(i).getClass(), "boxSizeY", base.cubeList.get(i)) : -1;
	}

	@Override
	public int getboxSizeZ(int i) {
		return base.cubeList != null
				&& base.cubeList.size() > i ? (Integer) Modchu_Reflect.getFieldObject(base.cubeList.get(i).getClass(), "boxSizeZ", base.cubeList.get(i)) : -1;
	}

	@Override
	public Object getFreeVariable(String s) {
		return freeVariableMap != null
				&& !freeVariableMap.isEmpty() ? freeVariableMap.get(s) : null;
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		if (freeVariableMap != null) ;else freeVariableMap = new ConcurrentHashMap();
		freeVariableMap.put(s, o);
	}

	@Override
	public void removeFreeVariable(String s) {
		if (freeVariableMap != null) ;else return;
		if (freeVariableMap.containsKey(s)) freeVariableMap.remove(s);
	}

	@Override
	public void setParentModel(Modchu_ModelRenderer modelRenderer) {
		parentModel = modelRenderer;
	}

	@Override
	public String getBoxName() {
		return boxName;
	}

	@Override
	public void setBoxName(String s) {
		boxName = s;
	}

	//SmartMoving関連↓
	@Override
	public void reset() {
		base.rotatePriority = XYZ;
		base.scaleX = 1.0F;
		base.scaleY = 1.0F;
		base.scaleZ = 1.0F;
		base.rotationPointX = 0.0F;
		base.rotationPointY = 0.0F;
		base.rotationPointZ = 0.0F;
		base.rotateAngleX = 0.0F;
		base.rotateAngleY = 0.0F;
		base.rotateAngleZ = 0.0F;
		ignoreBase = false;
		ignoreSuperRotation = false;
		forceRender = false;
		offsetX = 0.0F;
		offsetY = 0.0F;
		offsetZ = 0.0F;
		fadeOffsetX = false;
		fadeOffsetY = false;
		fadeOffsetZ = false;
		fadeRotateAngleX = false;
		fadeRotateAngleY = false;
		fadeRotateAngleZ = false;
		fadeRotationPointX = false;
		fadeRotationPointY = false;
		fadeRotationPointZ = false;
		previous = null;
	}

	@Override
	public void fadeStore(float var1) {
		if (previous != null) {
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetX", previous, offsetX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetY", previous, offsetY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "offsetZ", previous, offsetZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleX", previous, base.rotateAngleX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleY", previous, base.rotateAngleY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotateAngleZ", previous, base.rotateAngleZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointX", previous, base.rotationPointX);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointY", previous, base.rotationPointY);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "rotationPointZ", previous, base.rotationPointZ);
			Modchu_Reflect.setFieldObject("net.minecraft.move.render.RendererData", "totalTime", previous, var1);
		}
	}

	@Override
	public void fadeIntermediate(float var1) {
		if (previous != null) {
			float totalTime = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "totalTime", previous);
			if (var1 - totalTime <= 2.0F) {
				float previousOffsetX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetX", previous);
				float previousOffsetY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetY", previous);
				float previousOffsetZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "offsetZ", previous);
				float previousRotateAngleX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleX", previous);
				float previousRotateAngleY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleY", previous);
				float previousRotateAngleZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotateAngleZ", previous);
				float previousRotationPointX = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointX", previous);
				float previousRotationPointY = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointY", previous);
				float previousRotationPointZ = (Float) Modchu_Reflect.getFieldObject("net.minecraft.move.render.RendererData", "rotationPointZ", previous);
				offsetX = GetIntermediatePosition(previousOffsetX, offsetX, fadeOffsetX, totalTime, var1);
				offsetY = GetIntermediatePosition(previousOffsetY, offsetY, fadeOffsetY, totalTime, var1);
				offsetZ = GetIntermediatePosition(previousOffsetZ, offsetZ, fadeOffsetZ, totalTime, var1);
				base.rotateAngleX = GetIntermediateAngle(previousRotateAngleX, base.rotateAngleX, fadeRotateAngleX, totalTime, var1);
				base.rotateAngleY = GetIntermediateAngle(previousRotateAngleY, base.rotateAngleY, fadeRotateAngleY, totalTime, var1);
				base.rotateAngleZ = GetIntermediateAngle(previousRotateAngleZ, base.rotateAngleZ, fadeRotateAngleZ, totalTime, var1);
				base.rotationPointX = GetIntermediatePosition(previousRotationPointX, base.rotationPointX, fadeRotationPointX, totalTime, var1);
				base.rotationPointY = GetIntermediatePosition(previousRotationPointY, base.rotationPointY, fadeRotationPointY, totalTime, var1);
				base.rotationPointZ = GetIntermediatePosition(previousRotationPointZ, base.rotationPointZ, fadeRotationPointZ, totalTime, var1);
			}
		}
	}

	private float GetIntermediatePosition(float var1, float var2, boolean var3, float var4, float var5) {
		return var3 && var2 != var1 ? var1 + (var2 - var1) * (var5 - var4) * 0.2F : var2;
	}

	private float GetIntermediateAngle(float var1, float var2, boolean var3, float var4, float var5) {
		if (var3 && var2 != var1) {
			while (var1 >= ((float) Math.PI * 2F)) {
				var1 -= ((float) Math.PI * 2F);
			}

			while (var1 < 0.0F) {
				var1 += ((float) Math.PI * 2F);
			}

			while (var2 >= ((float) Math.PI * 2F)) {
				var2 -= ((float) Math.PI * 2F);
			}

			while (var2 < 0.0F) {
				var2 += ((float) Math.PI * 2F);
			}

			if (var2 > var1 && var2 - var1 > (float) Math.PI) {
				var1 += ((float) Math.PI * 2F);
			}

			if (var2 < var1 && var1 - var2 > (float) Math.PI) {
				var2 += ((float) Math.PI * 2F);
			}

			return var1 + (var2 - var1) * (var5 - var4) * 0.2F;
		} else {
			return var2;
		}
	}
	//SmartMoving関連↑
/*//b181delete
	private void compileDisplayList(float par1) {
		displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		Tessellator var2 = Tessellator.instance;
		Iterator var3 = cubeList.iterator();

		while (var3.hasNext()) {
			ModelBoxPlayerFormLittleMaid var4 = (ModelBoxPlayerFormLittleMaid) var3.next();
			var4.render(var2, par1);
		}

		GL11.glEndList();
		compiled = true;
	}

	public ModelRenderer addBox(String par1Str, float par2, float par3, float par4, int par5, int par6, int par7) {
		par1Str = boxName + "." + par1Str;
		TextureOffsetPlayerFormLittleMaid var8 = baseModel.getTextureOffset(par1Str);
		setTextureOffset(var8.textureOffsetX, var8.textureOffsetY);
		cubeList.add((new ModelBoxPlayerFormLittleMaid(base, textureOffsetX, textureOffsetY, par2, par3, par4, par5, par6, par7, 0.0F)).func_40671_a(par1Str));
		return base;
	}

	public void addBox(float par1, float par2, float par3, int par4, int par5, int par6) {
		cubeList.add(new ModelBoxPlayerFormLittleMaid(base, textureOffsetX, textureOffsetY, par1, par2, par3, par4, par5, par6, 0.0F));
		//return base;
	}

	public void addBox(float par1, float par2, float par3, int par4, int par5, int par6, float par7) {
		cubeList.add(new ModelBoxPlayerFormLittleMaid(base, textureOffsetX, textureOffsetY, par1, par2, par3, par4, par5, par6, par7));
	}

	public void render(float par1) {
		if (!isHidden) {
			if (showModel) {
				if (!compiled) {
					compileDisplayList(par1);
				}

				GL11.glTranslatef(field_82906_o, field_82908_p, field_82907_q);
				Iterator var2;
				ModchuModel_ModelRenderer var3;

				if (rotateAngleX == 0.0F && rotateAngleY == 0.0F && rotateAngleZ == 0.0F) {
					if (rotationPointX == 0.0F && rotationPointY == 0.0F && rotationPointZ == 0.0F) {
						GL11.glCallList(displayList);

						if (childModels != null) {
							var2 = childModels.iterator();

							while (var2.hasNext()) {
								var3 = (ModchuModel_ModelRenderer) var2.next();
								((ModchuModel_ModelRenderer) var3).render(par1);
							}
						}
					} else {
						GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
						GL11.glCallList(displayList);

						if (childModels != null) {
							var2 = childModels.iterator();

							while (var2.hasNext()) {
								var3 = (ModchuModel_ModelRenderer) var2.next();
								((ModchuModel_ModelRenderer) var3).render(par1);
							}
						}

						GL11.glTranslatef(-rotationPointX * par1, -rotationPointY * par1, -rotationPointZ * par1);
					}
				} else {
					GL11.glPushMatrix();
					GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

					if (rotateAngleZ != 0.0F) {
						GL11.glRotatef(rotateAngleZ * (180F / (float) Math.PI), 0.0F, 0.0F, 1.0F);
					}

					if (rotateAngleY != 0.0F) {
						GL11.glRotatef(rotateAngleY * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
					}

					if (rotateAngleX != 0.0F) {
						GL11.glRotatef(rotateAngleX * (180F / (float) Math.PI), 1.0F, 0.0F, 0.0F);
					}

					GL11.glCallList(displayList);

					if (childModels != null) {
						var2 = childModels.iterator();

						while (var2.hasNext()) {
							var3 = (ModchuModel_ModelRenderer) var2.next();
							((ModchuModel_ModelRenderer) var3).render(par1);
						}
					}

					GL11.glPopMatrix();
				}

				GL11.glTranslatef(-field_82906_o, -field_82908_p, -field_82907_q);
			}
		}
	}

	public void renderWithRotation(float par1) {
		if (!isHidden) {
			if (showModel) {
				if (!compiled) {
					compileDisplayList(par1);
				}

				GL11.glPushMatrix();
				GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

				if (rotateAngleY != 0.0F) {
					GL11.glRotatef(rotateAngleY * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
				}

				if (rotateAngleX != 0.0F) {
					GL11.glRotatef(rotateAngleX * (180F / (float) Math.PI), 1.0F, 0.0F, 0.0F);
				}

				if (rotateAngleZ != 0.0F) {
					GL11.glRotatef(rotateAngleZ * (180F / (float) Math.PI), 0.0F, 0.0F, 1.0F);
				}

				GL11.glCallList(displayList);
				GL11.glPopMatrix();
			}
		}
	}

	public void postRender(float par1) {
		if (!isHidden) {
			if (showModel) {
				if (!compiled) {
					compileDisplayList(par1);
				}

				if (rotateAngleX == 0.0F && rotateAngleY == 0.0F && rotateAngleZ == 0.0F) {
					if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
						GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
					}
				} else {
					GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

					if (rotateAngleZ != 0.0F) {
						GL11.glRotatef(rotateAngleZ * (180F / (float) Math.PI), 0.0F, 0.0F, 1.0F);
					}

					if (rotateAngleY != 0.0F) {
						GL11.glRotatef(rotateAngleY * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
					}

					if (rotateAngleX != 0.0F) {
						GL11.glRotatef(rotateAngleX * (180F / (float) Math.PI), 1.0F, 0.0F, 0.0F);
					}
				}
			}
		}
	}
*///b181delete
/*//b173delete
	public ModelRenderer setTextureSize(int i, int j) {
		textureWidth = i;
		textureHeight = j;
		return base;
	}
*///b173delete

}