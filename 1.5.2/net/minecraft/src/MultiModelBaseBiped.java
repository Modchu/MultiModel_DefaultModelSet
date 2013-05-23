package net.minecraft.src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

/**
 * PlayerFormLittleMaid共通クラス
 */
public abstract class MultiModelBaseBiped extends MMM_ModelMultiMMMBase implements Modchu_IModelCaps {
//-@-151
	public MMM_ModelRenderer bipedHead;
	public MMM_ModelRenderer bipedHeadwear;
	public MMM_ModelRenderer bipedBody;
	public MMM_ModelRenderer bipedRightArm;
	public MMM_ModelRenderer bipedLeftArm;
	public MMM_ModelRenderer bipedRightLeg;
	public MMM_ModelRenderer bipedLeftLeg;
	public MMM_ModelRenderer bipedEars;
	public MMM_ModelRenderer bipedCloak;
//@-@151
	private int armorType = 0;
	private boolean oldwalking = false;
	private boolean firstPerson = false;
	private boolean sneakBan = false;
	private boolean aimedBowBan = false;
	private boolean waitBan = false;
	private boolean sittingBan = false;
	private boolean sleepingBan = false;
	private boolean ridingBan = false;
/*//125delete
    public Entity entity;
*///125delete
/*//b181delete
    public int textureWidth = Modchu_MMM_ModelRenderer.textureWidthPFLM;
    public int textureHeight = Modchu_MMM_ModelRenderer.textureHeightPFLM;
    public boolean field_40333_u;
    private Map modelTextureMap = new HashMap();
*///b181delete
    //b173deletepublic List boxList;

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelBaseBiped(float psize, float pyoffset, int par3, int par4) {
/*//151delete
    	super(psize, pyoffset);
*///151delete
//-@-151
    	super(psize, pyoffset, par3, par4);
//@-@151
    	textureWidth = par3;
    	textureHeight = par4;
    	//b173deleteboxList = new ArrayList();
    	armsinit(psize, pyoffset);
    }

    /**
     * 手持ちアイテム描画用パーツ初期化時に呼ばれる
     */
    public void armsinit(float f, float f1) {
    }

    @Override
    public void render(MMM_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
    	setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
    	mainFrame.render(f5);
    	if (entityCaps != null) {
/*//151delete
    		renderStabilizer(entity, (Map) entityCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
*///151delete
//-@-151
    		renderStabilizer(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
//@-@151
    	}
    }

    public void setLivingAnimations(MMM_IModelCaps entityCaps, float f, float f1, float f2) {
    	setCapsValue(entityCaps, caps_setLivingAnimationsBefore, this, f, f1, f2);
    	setLivingAnimationsLM(entityCaps, f, f1, f2);
//-@-151
    	EntityLiving entityliving = (EntityLiving) getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
    	if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    			&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entityliving)) {
    		setLivingAnimationsAfter(entityCaps, f, f1, f2);
    	} else {
    		setCapsValue(entityCaps, caps_setLivingAnimationsAfter, this, f, f1, f2);
    	}
    }

    public void setLivingAnimationsLM(MMM_IModelCaps entityCaps, float f, float f1, float f2) {
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	if (entityCaps != null) {
    		setCapsValue(entityCaps, caps_setRotationAnglesBefore, this, f, f1, f2, f3, f4, f5);
    		setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
    		setCapsValue(entityCaps, caps_setRotationAnglesAfter, this, f, f1, f2, f3, f4, f5);
    	}
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    public void renderEars(float par1) {
    }

    public void renderCloak(float par1) {
    }

    @Override
    public void renderItems(MMM_IModelCaps entityCaps) {
    	if (entityCaps != null) {
/*//151delete
    		if (mod_Modchu_ModchuLib.oldRenderItems
    				&& mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(pEntity)) {
    			OldRenderItemsLM();
    		} else
*///151delete
    		renderItemsLM(entityCaps);
    	}
    }

	public void renderItemsLM(MMM_IModelCaps entityCaps) {
		// 手持ちの表示
		EntityLiving pEntity = (EntityLiving) getCapsValue(entityCaps, entityCaps.caps_Entity);
		GL11.glPushMatrix();
		boolean lflag = true;
		if (entityCaps != null) {
			ItemStack[] litemstacks = (ItemStack[])entityCaps.getCapsValue(caps_Items);
			EnumAction[] lactions = (EnumAction[])entityCaps.getCapsValue(caps_Actions);
			if (litemstacks != null) {
				Object Arms;
				for (int i = 0; i < litemstacks.length; i++) {
					Arms = getArms(i);
					if (Arms != null
							&& litemstacks[i] != null) {
						Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
						Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, render, false, lactions[i] ,litemstacks[i] });
					}
				}
				lflag = false;
			}
			// 頭部装飾品
			boolean lplanter = (Boolean) entityCaps.getCapsValue(caps_isPlanter);
			ItemStack litemstack = (ItemStack)entityCaps.getCapsValue(caps_HeadMount);
			int addSupport = addSupportChecks(litemstack);
			if ((Boolean) entityCaps.getCapsValue(caps_isCamouflage) || lplanter
					|| addSupport > -1) {
				Object HeadMount = getHeadMount();
				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
				if (lplanter
						|| (addSupport > -1 && addSupport < 3)) {
					equippedItemPositionFlower();
				}
				float scale = 1.0F;
				Object inventory = entityCaps.getCapsValue(caps_Inventory);
				if (inventory != null) {
					int slot = pEntity instanceof EntityPlayer ? 10 : 16;
					ItemStack litemstack1 = (ItemStack) Modchu_Reflect.invokeMethod(InventoryPlayer.class, "func_70301_a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ slot });
					if (litemstack1 != null) {
						Item item2 = litemstack1.getItem();
						if (item2 == item2.dyePowder) {
							scale = 1.0F + (0.2F * litemstack1.getItemDamage());
						}
					}
					Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, render, true, null, litemstack, scale, addSupport });
					//HeadMount.renderItems(pEntity, render, true, null, (ItemStack)entityCaps.getCapsValue(caps_HeadMount));
				}
			}

			// アーマー頭部装飾品 対応
			litemstack = (ItemStack) getCapsValue(caps_armorItemInSlot, 3);
			if (litemstack != null) {
				addSupport = addSupportChecks(litemstack);
				headMountRenderItems(entityCaps, litemstack, addSupport);
			}
		}
		if (lflag) {
			Object Arms = getArms(0);
			if (Arms != null) {
				Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
				Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, render, false, null, pEntity.getHeldItem() });
			}
		}
		GL11.glPopMatrix();
	}
/*//151delete
    public void OldRenderItemsLM() {
    	// 手持ちの表示
    	EntityLiving pEntity = (EntityLiving) getCapsValue(entityCaps, entityCaps.caps_Entity);
    	GL11.glPushMatrix();

    	ItemStack litemstack = null;
    	EnumAction laction;
    	Class pEntityClass = pEntity.getClass();
    	Object obj = null;
    	// int i = 0 R
    	// int i = 1 L
    	for (int i = 0; i < 2 ; i++) {
    		obj = Modchu_Reflect.invokeMethod(pEntity.getClass(), "getSwingStatus", new Class[]{ int.class }, pEntity, new Object[]{ i });
    		litemstack = (ItemStack) Modchu_Reflect.invokeMethod(obj.getClass(), "getItemStack", new Class[]{ pEntity.getClass() }, obj, new Object[]{ pEntity });
    		//litemstack = ((LMM_EntityLittleMaid) pEntity).mstatSwingStatus[i].getItemStack((LMM_EntityLittleMaid) pEntity);
    		int maidDominantArm = (Integer) Modchu_Reflect.getFieldObject(pEntity.getClass(), "maidDominantArm", pEntity);
    		Object maidAvatar = Modchu_Reflect.getFieldObject(pEntity.getClass(), "maidAvatar", pEntity);
    		int itemInUseCount = (Integer) Modchu_Reflect.invokeMethod(EntityPlayer.class, "func_71052_bv", "getItemInUseCount", maidAvatar);
    		laction = maidDominantArm == i && itemInUseCount > 0 ? litemstack.getItemUseAction() : null;
    		//laction = (((LMM_EntityLittleMaid) pEntity).maidDominantArm == i && ((LMM_EntityLittleMaid) pEntity).maidAvatar.getItemInUseCount() > 0) ? litemstack.getItemUseAction() : null;

    		if (litemstack != null) {
    			Object Arms = getArms(i);
    			if (Arms != null) {
    				Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
    				Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, render, false, laction, litemstack });
    			}
    		}
    	}

    	// 頭部装飾品
    	Object maidInventory = Modchu_Reflect.getFieldObject(pEntity.getClass(), "maidInventory", pEntity);
    	litemstack = (ItemStack) Modchu_Reflect.invokeMethod(maidInventory.getClass(), "getHeadMount", maidInventory);
    	if (litemstack != null) {
    		boolean isCamouflage = (Boolean) Modchu_Reflect.invokeMethod(pEntity.getClass(), "isCamouflage", pEntity);
    		boolean isPlanter = (Boolean) Modchu_Reflect.invokeMethod(pEntity.getClass(), "isPlanter", pEntity);
    		int addSupport = addSupportChecks(pEntity, litemstack);
    		if (isCamouflage
    				|| isPlanter
    				|| addSupport > -1) {
    		//if (((LMM_EntityLittleMaid) pEntity).isCamouflage() || ((LMM_EntityLittleMaid) pEntity).isPlanter()) {
    			ItemStack[] litemstack1 = (ItemStack[]) Modchu_Reflect.getFieldObject(InventoryPlayer.class, "field_70462_a", "mainInventory", maidInventory);
    			if (litemstack1 != null) {
    				ItemStack litemstack2 = litemstack1[litemstack1.length - 2];
    				Object HeadMount = getHeadMount();
    				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
    				if (isPlanter
    						|| (addSupport > -1 && addSupport < 3)) {
    					//if (((LMM_EntityLittleMaid) pEntity).isPlanter()) {
    					equippedItemPositionFlower();
    				}
    				float scale = 1.0F;
    				if (litemstack2 != null) {
    					Item item2 = litemstack2.getItem();
    					if (item2 == item2.dyePowder) {
    						scale = 1.0F + (0.2F * litemstack2.getItemDamage());
    					}
    				}
    				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, render, true, null, litemstack, scale, addSupport });
    				//HeadMount.renderItems(pEntity, render, true, null, ((LMM_EntityLittleMaid) pEntity).maidInventory.getHeadMount());
    			}
    		}
    	}

    	GL11.glPopMatrix();
    }
*///151delete
    public void headMountRenderItems(MMM_IModelCaps entityCaps, ItemStack litemstack, int addSupport) {
    	EntityLiving pEntity = (EntityLiving) getCapsValue(entityCaps, entityCaps.caps_Entity);
    	Item item = litemstack.getItem();
    	Block block = null;
    	boolean isCamouflage = false;
    	boolean isPlanter = false;
    	try {
    		block = Block.blocksList[item.itemID];
    		isCamouflage = item instanceof ItemBlock
    				&& block instanceof BlockLeaves
    				|| block instanceof BlockPumpkin;
    		isPlanter = block instanceof BlockFlower;
    	} catch(Exception e) {
    	}
    	if (isCamouflage
    			|| isPlanter
    			|| addSupport > -1) {
    		Object inventory = entityCaps.getCapsValue(caps_Inventory);
    		float scale = 1.0F;
    		if (inventory != null) {
    			int slot = pEntity instanceof EntityPlayer ? 10 : 16;
    			ItemStack litemstack2 = (ItemStack) Modchu_Reflect.invokeMethod(InventoryPlayer.class, "func_70301_a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ slot });
    			Object HeadMount = getHeadMount();
    			if (HeadMount != null) ;else return;
    			Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
    			if (isPlanter
    					|| (addSupport > -1 && addSupport < 3)) {
    				equippedItemPositionFlower();
    			}
    			if (litemstack2 != null) {
    				Item item2 = litemstack2.getItem();
    				if (item2 == item2.dyePowder) {
    					scale = 1.0F + (0.2F * litemstack2.getItemDamage());
    				}
    			}
    		}
    		Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, render, true, null, litemstack, scale, addSupport });
    	}
    }

    /**
     * PlayerFormLittleMaidで追加対応したブロック・アイテムかチェック
     * DecoBlock = 0, DecoBlockBase = 1, FavBlock = 2, Item.skull = 3,
     * BlockPumpkin = 4
     */
    public int addSupportChecks(ItemStack litemstack) {
    	if (litemstack != null) ;else return -1;
    	int flag = -1;
    	Item item = litemstack.getItem();
    	Block block = null;
    	try {
    		block = Block.blocksList[item.itemID];
    		if (mod_Modchu_ModchuLib.isDecoBlock) {
    			if (mod_Modchu_ModchuLib.decoBlock.isInstance(block)) return 0;
    			if (mod_Modchu_ModchuLib.decoBlockBase.isInstance(block)) return 1;
    		}
    		if (mod_Modchu_ModchuLib.isFavBlock
    				&& mod_Modchu_ModchuLib.favBlock.isInstance(block)) {
    			return 2;
    		}
    	} catch(Exception e) {
    	}
//-@-132
    	if (item.itemID == Item.skull.itemID) return 3;
//@-@132
    	if (item instanceof ItemBlock
    			&& block instanceof BlockPumpkin) return 4;
    	return flag;
    }

    public MMM_ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    public MMM_ModelRenderer getHeadMount() {
    	return HeadMount;
    }

    /**
     * PlayerFormLittleMaid専用Player用処理
     * setRotationAngles 呼び出し後に通常視点時なら呼ばれる。
     * 通常視点時の手の描画位置、角度調整を入れる。
     */
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    /**
     * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、
     * setPartsの前に呼ばれる。自動取得されたリストの編集など
     */
    public void defaultPartsSettingBefore(MMM_IModelCaps entityCaps) {
    }

    /**
     * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、
     * setPartsの後に呼ばれる。デフォルトOFFにする設定など
     */
    public void defaultPartsSettingAfter(MMM_IModelCaps entityCaps) {
    }

    /**
     * GUI パーツ表示・非表示反映
     */
    public void showModelSettingReflects(MMM_IModelCaps entityCaps) {
    }

    /**
     * アーマーモデルとメインモデルの同期。
     * アーマーモデルに対して、メインモデルのデータが渡されてくるのでそれに合わせるパーツを同期させる
     */
    public void syncModel(MMM_IModelCaps entityCaps, MultiModelBaseBiped model) {
    }

    /**
     * setRotationAnglesLM実行前に呼ばれる。
     * 各パーツの初期化など。
     */
    public abstract void reset(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps);

    /**
     * カラー切替時に実行されるコード
     */
    public void changeColor(MMM_IModelCaps entityCaps) {
    }

    public float getyOffset() {
    	return 1.62F;
    }

    public float getRidingHeight() {
    	return getHeight();
    }

    public float getRidingWidth() {
    	return getWidth();
    }

    public float getRidingyOffset() {
    	return getyOffset();
    }

    /**
     * 他Mobを頭に乗せた時の他Mob基準位置調整
     */
    public float getMountedYOffset() {
    	return 0.75F;
    }

    /**
     * 座っているポーズ「乗り物に乗っていない」時の位置調整
     */
    public double getSittingyOffset() {
    	return -0.35D;
    }

    /**
     * 寝ているポーズ時の位置調整
     */
    public double getSleepingyOffset() {
    	return -0.9D;
    }

    /**
     * isModelSize=true時に乗り物に乗っている状態でのカメラ位置調整
     */
    public float ridingViewCorrection() {
    	return 0.0F;
    }

    /**
     * デフォルトモデルスケール
     */
    public float getModelScale() {
    	return 0.9375F;
    }

    /**
     * 特殊頭表示アイテム「花系」の位置調整
     */
    public void equippedItemPositionFlower() {
    	GL11.glTranslatef(0F, -0.5F, 0F);
    }

    public void setArmorBipedHeadShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	setCapsValue(caps_visible, bipedHead, b);
    }

    public void setArmorBipedBodyShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	setCapsValue(caps_visible, bipedBody, b);
    }

    public void setArmorBipedRightArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightArm, false);
    	}
    	else setCapsValue(caps_visible, bipedRightArm, b);
    }

    public void setArmorBipedLeftArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftArm, false);
    	}
    	else setCapsValue(caps_visible, bipedLeftArm, b);
    }

    public void setArmorBipedRightLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightLeg, false);
    	}
    	else setCapsValue(caps_visible, bipedRightLeg, b);
    }

    public void setArmorBipedLeftLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
    	if (Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_shortcutKeysAction)
    			&& Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 0
    			| Modchu_ModelCapsHelper.getCapsValueInt(this, caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftLeg, false);
    	}
    	else setCapsValue(caps_visible, bipedLeftLeg, b);
    }

    public void setArmorSkirtShowModel(MMM_IModelCaps entityCaps, boolean b) {
    }

	@Override
	public Object getCapsValue(MultiModelBaseBiped model, MMM_IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return getCapsValue(pIndex, entityCaps, (Object[]) pArg);
	}

	@Override
	public Object getCapsValue(MultiModelBaseBiped model, int pIndex, Object ...pArg) {
		return getCapsValue(pIndex, (Object[]) pArg);
	}

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		return getCapsValue((MMM_IModelCaps) null, pIndex, (Object[]) pArg);
	}

	@Override
	public Object getCapsValue(MMM_IModelCaps entityCaps, int pIndex, Object ...pArg) {
		if (entityCaps != null) {
			Object o = entityCaps instanceof Modchu_IModelCaps ? ((Modchu_IModelCaps) entityCaps).getCapsValue(this, pIndex, pArg) : entityCaps.getCapsValue(pIndex, pArg);
			if (o != null) return o;
		}
		switch (pIndex) {
		case caps_Grounds:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getGrounds((MMM_IModelCaps) pArg[0]);
			break;
		case caps_onGround:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) return getOnGround((MMM_IModelCaps) pArg[0], (Integer) pArg[1]);
				return getGrounds((MMM_IModelCaps) pArg[0])[0];
			}
			break;
		case caps_getIsSneak:
			return getIsSneak();
		case caps_getIsRiding:
			return getIsRiding();
		case caps_isRiding:
			return isRiding;
		case caps_aimedBow:
			return getaimedBow();
		case caps_getIsWait:
			return getIsWait();
		case caps_isSitting:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getIsSitting((MMM_IModelCaps) pArg[0]);
			break;
		case caps_getIsSleeping:
			return getIsSleeping();
		case caps_firstPerson:
			return getFirstPerson();
		case caps_armorType:
			return getArmorType();
		case caps_oldwalking:
			return getOldwalking();
		case caps_isItemHolder:
			return isItemHolder();
		case caps_bipedHead:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getBipedHead((MMM_IModelCaps) pArg[0]);
			break;
		case caps_bipedRightArm:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getBipedRightArm((MMM_IModelCaps) pArg[0]);
			break;
		case caps_notDominantArm:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getNotDominantArm((MMM_IModelCaps) pArg[0]);
			break;
		case caps_Physical_Hammer:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return Physical_Hammer((MMM_IModelCaps) pArg[0]);
			break;
		case caps_height:
			return getHeight();
		case caps_width:
			return getWidth();
		case caps_YOffset:
			return getyOffset();
		case caps_convertDegtoRad:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return convertDegtoRad((Float) pArg[0]);
			break;
		case caps_sneakBan:
			return getSneakBan();
		case caps_aimedBowBan:
			return getAimedBowBan();
		case caps_waitBan:
			return getWaitBan();
		case caps_sittingBan:
			return getSittingBan();
		case caps_sleepingBan:
			return getSleepingBan();
		case caps_ridingBan:
			return getRidingBan();
		case caps_modchuRemodelingModel:
			return getModchuRemodelingModel();
		case caps_sittingyOffset:
			return getSittingyOffset();
		case caps_sleepingyOffset:
			return getSleepingyOffset();
		case caps_texture:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) return getTexture((String) pArg[0], (Integer) pArg[1]);
			break;

		//entityCaps相当機能が無いLMM対策
		case caps_maidColor:
			return getMaidColor((MMM_IModelCaps) pArg[0]);
		}
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(MultiModelBaseBiped model, int pIndex, Object... pArg) {
		return setCapsValue(pIndex, (Object[]) pArg);
	}

	@Override
	public boolean setCapsValue(MultiModelBaseBiped model, MMM_IModelCaps entityCaps, int pIndex, Object... pArg) {
		return setCapsValue(pIndex, (Object[]) pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue((MMM_IModelCaps) null, pIndex, (Object[]) pArg);
	}

	@Override
	public boolean setCapsValue(MMM_IModelCaps entityCaps, int pIndex, Object ...pArg) {
		switch (pIndex) {
		case caps_isRiding:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setIsRiding((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_isSneak:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setIsSneak((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_onGround:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setOnGround((Float) pArg[0]);
				return true;
			}
			return false;
		case caps_oldwalking:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setOldwalking((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_isItemHolder:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setIsItemHolder((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_firstPerson:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setFirstPerson((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_armorType:
			if (pArg != null
			&& pArg[0] != null) {
				setArmorType((Integer) pArg[0]);
				return true;
			}
			return false;
		case caps_renderFirstPersonHand:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				renderFirstPersonHand(entityCaps, (Float) pArg[0]);
				return true;
			}
			return false;
		case caps_visible:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					setVisible((MMM_ModelRenderer) pArg[0], (Boolean) pArg[1], (Boolean) pArg[2]);
					return true;
				}
				setVisible((MMM_ModelRenderer) pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		case caps_sneakBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setSneakBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_aimedBowBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setAimedBowBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_aimedBow:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setAimedBow((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_waitBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setWaitBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_sittingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setSittingBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_sleepingBan:
			if (pArg != null
			&& pArg[0] != null) {
				setSleepingBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_ridingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setRidingBan((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_modchuRemodelingModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setModchuRemodelingModel((Boolean) pArg[0]);
				return true;
			}
			return false;
		case caps_changeModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				changeModel((MMM_IModelCaps) pArg[0]);
				return true;
			}
			return false;
		case caps_syncModel:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				syncModel((MMM_IModelCaps) pArg[0], (MultiModelBaseBiped) pArg[1]);
				return true;
			}
			return false;
		}
		boolean b = super.setCapsValue(pIndex, pArg);
		if (b) return true;
		//Modchu_Debug.mDebug("entityCaps pIndex="+pIndex+" 0x0264="+0x0264);
		if (entityCaps != null) return entityCaps.setCapsValue(pIndex, pArg);
		return false;
	}

	private int getMaidColor(MMM_IModelCaps entityCaps) {
//-@-151
		EntityLiving entityliving = (EntityLiving) getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
		Modchu_Debug.mDebug("getMaidColor entityliving != null?"+(entityliving != null));
		Object o = null;
		if (entityCaps != null) o = entityCaps.getCapsValue(caps_maidColor);
		if (o != null) return (Integer) o;
		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entityliving)) {
			o = (Integer) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.LMM_EntityLittleMaid, "maidColor", entityliving);
		}
		if (o != null) return (Integer) o;
		return 0;
	}

	private String getTexture(String s, int i) {
		return (String) mod_Modchu_ModchuLib.textureManagerGetTexture(s, i);
	}

    private float getOnGround()
    {
    	return onGround;
    }

    private float getOnGround(MMM_IModelCaps entityCaps, int i) {
    	if (Modchu_ModelCapsHelper.getCapsValueInt(entityCaps, caps_dominantArm) == i) {
    		//Modchu_Debug.mDebug("getOnGround()="+getOnGround() +" i="+i);
    		return getGrounds(entityCaps)[i];
    	}
    	return 0.0F;
    }

    private float[] getGrounds(MMM_IModelCaps entityCaps) {
    	float[] f = new float[]{ 0.0F, 0.0F };
    	int i = Modchu_ModelCapsHelper.getCapsValueInt(entityCaps, caps_dominantArm);
    	if (i < f.length) {
    		//Modchu_Debug.mDebug("getOnGround()="+getOnGround() +" i="+i);
    		f[i] = getOnGround();
    	}
    	return f;
    }

    private float setOnGround(float f)
    {
    	return onGround = f;
    }

    private void setIsItemHolder(int i) {
    	heldItemRight = i;
    }

    private boolean getIsRiding()
    {
    	return isRiding && !ridingBan;
    }

    private void setIsRiding(boolean b)
    {
    	isRiding = b;
    }

    private boolean getIsSneak()
    {
    	return isSneak && !sneakBan;
    }

    private void setIsSneak(boolean b)
    {
    	isSneak = b;
    }

    private boolean getIsSleeping()
    {
    	return Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_isSleeping) && !sleepingBan;
    }

    private boolean getaimedBow()
    {
    	return aimedBow && !aimedBowBan;
    }

    private boolean getIsWait()
    {
    	return Modchu_ModelCapsHelper.getCapsValueBoolean(this, caps_isWait) && !waitBan;
    }

    private boolean getIsSitting(MMM_IModelCaps entityCaps)
    {
    	if (entityCaps != null) return (Boolean) entityCaps.getCapsValue(caps_isSitting) && !sittingBan;
    	return false;
    }

    private boolean getFirstPerson()
    {
    	return firstPerson;
    }

    private void setFirstPerson(boolean b)
    {
    	firstPerson = b;
    }

    private boolean getOldwalking()
    {
    	return oldwalking;
    }

    private void setOldwalking(boolean b) {
    	oldwalking = b;
    }

    private int getArmorType()
    {
    	return armorType;
    }

    private void setArmorType(int i)
    {
    	armorType = i;
    }

    private boolean getSneakBan()
    {
    	return sneakBan;
    }

    private boolean getAimedBowBan()
    {
    	return aimedBowBan;
    }

    private boolean getWaitBan()
    {
    	return waitBan;
    }

    private boolean getSittingBan()
    {
    	return sittingBan;
    }

    private boolean getSleepingBan()
    {
    	return sleepingBan;
    }

    private boolean getRidingBan()
    {
    	return ridingBan;
    }

    private void setAimedBowBan(boolean b)
    {
    	aimedBowBan = b;
    }

    private boolean getAimedBow()
    {
    	return aimedBow;
    }

    private void setAimedBow(boolean b)
    {
    	aimedBow = b;
    }

    private void setSneakBan(boolean b)
    {
    	sneakBan = b;
    }

    private void setWaitBan(boolean b)
    {
    	waitBan = b;
    }

    private void setSittingBan(boolean b)
    {
    	sittingBan = b;
    }

    private void setSleepingBan(boolean b)
    {
    	sleepingBan = b;
    }

    private void setRidingBan(boolean b)
    {
    	ridingBan = b;
    }

    private void setVisible(MMM_ModelRenderer renderer, boolean b) {
    	setVisible(renderer, b, false);
    }

    private void setVisible(MMM_ModelRenderer renderer, boolean b, boolean b1) {
    	if (renderer != null
    			&& renderer.showModel != b) ;else return;
    	if (!b1) {
    		HashMap<String, Boolean> partsShowMap = (HashMap<String, Boolean>) getCapsValue(caps_showPartsMap, armorType);
    		if (partsShowMap != null) {
    			String s = (String) getCapsValue(caps_modelRendererName, renderer, armorType);
    			if (s != null
    					&& partsShowMap.containsKey(s)) {
    				return;
    			}
    		}
    	}
    	renderer.setVisible(b);
    }

    private float convertDegtoRad(float deg) {
    	return deg / 180F * (float)Math.PI;
    }

    private boolean getModchuRemodelingModel() {
    	return mod_Modchu_ModchuLib.modchuRemodelingModel;
    }

    private void setModchuRemodelingModel(boolean b) {
    	mod_Modchu_ModchuLib.modchuRemodelingModel = b;
    }

    public float Physical_Hammer(MMM_IModelCaps entityCaps) {
    	return (Float) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.mod_PFLM_PlayerFormLittleMaid, "Physical_Hammer");
    }

    public MMM_ModelRenderer getBipedHead(MMM_IModelCaps entityCaps) {
    	return bipedHead;
    }

    public MMM_ModelRenderer getBipedRightArm(MMM_IModelCaps entityCaps) {
    	if (Modchu_ModelCapsHelper.getCapsValueInt(entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedRightArm;
    	return bipedLeftArm;
    }

    public MMM_ModelRenderer getNotDominantArm(MMM_IModelCaps entityCaps) {
    	if (Modchu_ModelCapsHelper.getCapsValueInt(entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedLeftArm;
    	return bipedRightArm;
    }

    @Override
    public void renderFirstPersonHand(MMM_IModelCaps entityCaps) {
    	renderFirstPersonHand(entityCaps, 0.0625F);
    }

    public void renderFirstPersonHand(MMM_IModelCaps entityCaps, float f) {
    	((MMM_ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps)).render(f);
    }

    abstract int showArmorParts(MMM_IModelCaps entityCaps, int parts, int index);
    // 以下、LMM_EntityCaps側にあってほしいもの
	/**
     * LMM専用処理
     * setLivingAnimations 呼び出し後に呼ばれる。
     */
    public void setLivingAnimationsAfter(MMM_IModelCaps entityCaps, float f, float f1, float f2) {
    	if (bipedHead != null) {
    		float angle = (Float) entityCaps.getCapsValue(caps_interestedAngle, f2);
    		bipedHead.rotateAngleZ = angle;
    	}
    }
}
