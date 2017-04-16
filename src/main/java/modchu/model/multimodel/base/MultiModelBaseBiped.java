package modchu.model.multimodel.base;import java.lang.reflect.Field;import java.util.HashMap;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.Modchu_GlStateManager;import modchu.lib.Modchu_IEntityCapsBase;import modchu.lib.Modchu_IModelBipedMaster;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.model.ModchuModel_ConfigData;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_Main;import modchu.model.ModchuModel_ModelBaseMaster;import modchu.model.ModchuModel_ModelDataBase;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.ModchuModel_TextureManagerBase;/** * PlayerFormLittleMaid共通Model 継承必須クラス */public abstract class MultiModelBaseBiped extends ModchuModel_ModelBaseMaster implements Modchu_IModelBipedMaster {	public ModchuModel_ModelRenderer mainFrame;	public ModchuModel_ModelRenderer HeadMount;	public ModchuModel_ModelRenderer HeadTop;	public ModchuModel_ModelRenderer Arms[];	public ModchuModel_ModelRenderer HardPoint[];	public ModchuModel_ModelRenderer bipedHead;	public ModchuModel_ModelRenderer bipedHeadwear;	public ModchuModel_ModelRenderer bipedBody;	public ModchuModel_ModelRenderer bipedRightArm;	public ModchuModel_ModelRenderer bipedLeftArm;	public ModchuModel_ModelRenderer bipedRightLeg;	public ModchuModel_ModelRenderer bipedLeftLeg;	public ModchuModel_ModelRenderer bipedEars;	public ModchuModel_ModelRenderer bipedCloak;	public float modelSize;	public float itemScale;	public float itemHeadMountScale;	public float itemHeadTopScale;	/**	 * コンストラクタは全て継承させること	 */	public MultiModelBaseBiped() {		this(0.0F);	}	/**	 * コンストラクタは全て継承させること	 */	public MultiModelBaseBiped(float psize) {		this(psize, 0.0F);	}	/**	 * コンストラクタは全て継承させること	 */	public MultiModelBaseBiped(float psize, float pyoffset) {		this(psize, pyoffset, 64, 32);	}	/**	 * コンストラクタは全て継承させること	 */	public MultiModelBaseBiped(float psize, float pyoffset, int par3, int par4, Object... o) {		isSneak = false;		aimedBow = false;		textureWidth = par3 < 0 ? 64 : par3;		textureHeight = par4 < 0 ? 32 : par4;		Arms = new ModchuModel_ModelRenderer[2];		HeadMount = new ModchuModel_ModelRenderer(this, "HeadMount");		HeadTop = new ModchuModel_ModelRenderer(this, "HeadTop");		initModel(psize, pyoffset, (Object[]) o);		modelSize = psize;		itemScale = 1.0F;		itemHeadMountScale = 1.0F;		itemHeadTopScale = 1.0F;		//Modchu_Debug.mDebug("this="+this+" modelSize="+modelSize);	}	public void afterInit(float f, float f1) {		armsinit(f, f1);		defaultAddChild();	}	/**	 * 手持ちアイテム描画用パーツ初期化時に呼ばれる	 */	public void armsinit(float f, float f1) {	}	@Override	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {		String eventName = "multiModelBaseBipedRenderBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ entityCaps, f, f1, f2, pheadYaw, pheadPitch, f5, pIsRender });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) entityCaps = (ModchuModel_IEntityCaps) o[1];				else if (o.length > 2) f = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) f1 = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) f2 = Modchu_CastHelper.Float(o[4]);				else if (o.length > 5) pheadYaw = Modchu_CastHelper.Float(o[5]);				else if (o.length > 6) pheadPitch = Modchu_CastHelper.Float(o[6]);				else if (o.length > 7) f5 = Modchu_CastHelper.Float(o[7]);				else if (o.length > 8) pIsRender = Modchu_CastHelper.Boolean(o[8]);			}		}		if (isCanceled) return;		setRotationAngles(f, f1, f2, pheadYaw, pheadPitch, f5, entityCaps);		modelRender(entityCaps, f, f1, f2, pheadYaw, pheadPitch, f5, pIsRender);		eventName = "multiModelBaseBipedRenderAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ entityCaps, f, f1, f2, pheadYaw, pheadPitch, f5, pIsRender });	}	public void modelRender(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {		if (mainFrame != null) mainFrame.render(f5, pIsRender);	}	@Override	public void setLivingAnimations(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {		String eventName = "multiModelBaseBipedSetLivingAnimationsBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ entityCaps, f, f1, f2 });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) entityCaps = (ModchuModel_IEntityCaps) o[1];				else if (o.length > 2) f = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) f1 = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) f2 = Modchu_CastHelper.Float(o[4]);			}		}		if (isCanceled) return;		entityCaps.setCapsValue(caps_setLivingAnimationsBefore, this, f, f1, f2);		setLivingAnimationsLM(entityCaps, f, f1, f2);		if (entityCaps instanceof ModchuModel_IEntityCaps				&& Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {			setLivingAnimationsAfter(entityCaps, f, f1, f2);		} else {			entityCaps.setCapsValue(caps_setLivingAnimationsAfter, this, f, f1, f2);		}		eventName = "multiModelBaseBipedSetLivingAnimationsAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ entityCaps, f, f1, f2 });	}	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {	}	@Override	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		if (entityCaps != null); else {			Modchu_Debug.mDebug1("setRotationAngles entityCaps == null !! this="+this);			//return;		}		String eventName = "multiModelBaseBipedSetRotationAnglesBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ f, f1, f2, f3, f4, f5, entityCaps });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) f = Modchu_CastHelper.Float(o[1]);				else if (o.length > 2) f1 = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) f2 = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) f3 = Modchu_CastHelper.Float(o[4]);				else if (o.length > 5) f4 = Modchu_CastHelper.Float(o[5]);				else if (o.length > 6) f5 = Modchu_CastHelper.Float(o[6]);				else if (o.length > 7) entityCaps = (ModchuModel_IEntityCaps) o[7];			}		}		if (isCanceled) return;		if (entityCaps != null) entityCaps.setCapsValue(caps_setRotationAnglesBefore, this, f, f1, f2, f3, f4, f5);		setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		if (entityCaps != null) entityCaps.setCapsValue(caps_setRotationAnglesAfter, this, f, f1, f2, f3, f4, f5);		eventName = "multiModelBaseBipedSetRotationAnglesAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ f, f1, f2, f3, f4, f5, entityCaps });	}	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {	}	@Override	public void renderEars(float par1) {	}	@Override	public void renderCloak(float par1) {	}	@Override	public void renderItems(ModchuModel_IEntityCaps entityCaps) {		if (entityCaps != null) {			renderItemsLM(entityCaps);		}	}	public void renderItemsLM(ModchuModel_IEntityCaps entityCaps) {		// 手持ちの表示		Modchu_GlStateManager.pushMatrix();		boolean flag = true;		if (isGulliver()) {			boolean isGliding = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isGliding");			boolean isRafting = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isRafting");			if (isGliding					| isRafting) {				flag = false;			}		}		if (flag) {			// R			armsLoadMatrix(0);			Modchu_GlStateManager.translate(0F, 0.05F, -0.05F);			Arms[0].renderItems("Hand", this, entityCaps, false, itemScale, 0);			// L			armsLoadMatrix(1);			Modchu_GlStateManager.translate(0F, 0.05F, -0.05F);			Arms[1].renderItems("Hand", this, entityCaps, false, itemScale, 1);		} else {			if (mainFrame != null) {				mainFrame.renderItems("mainFrame", this, entityCaps, false, itemScale, 0);				mainFrame.renderItems("mainFrame", this, entityCaps, false, itemScale, 1);			}		}		renderItemsHead(entityCaps);		renderItemsArmorHead(entityCaps);		Modchu_GlStateManager.popMatrix();	}	public void renderItemsHead(ModchuModel_IEntityCaps entityCaps) {		// 頭部装飾品の表示		if (entityCaps != null); else return;		Object itemstack = entityCaps.getCapsValue(caps_HeadMount, 9);		boolean isPlanter = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_isPlanter, itemstack);		boolean isCamouflage = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_isCamouflage, itemstack);		int addSupport = addSupportChecks(entityCaps, itemstack);		//Modchu_Debug.mDebug("renderItemsHead itemstack="+itemstack);		//Modchu_Debug.mDebug("renderItemsHead isPlanter="+isPlanter);		//Modchu_Debug.mDebug("renderItemsHead isCamouflage="+isCamouflage);		//Modchu_Debug.mDebug("renderItemsHead addSupport="+addSupport);		if (isCamouflage				| isPlanter				| addSupport > -1) {			float scale = 1.0F;			Object inventory = entityCaps.getCapsValue(caps_Inventory);			//Modchu_Debug.mDebug("renderItemsHead 2 inventory="+inventory);			if (inventory != null) {				Object pEntity = entityCaps.getCapsValue(caps_Entity);				int slot = Modchu_Reflect.loadClass("EntityPlayer").isInstance(pEntity) ? 10 : 16;				Object itemstack1 = Modchu_AS.get(Modchu_AS.inventoryPlayerGetStackInSlot, inventory, slot);				//Modchu_Debug.mDebug("renderItemsHead 3 itemstack1="+itemstack1);				if (itemstack1 != null) {					Object item2 = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack1);					Object dyePowder = Modchu_AS.get(Modchu_AS.getItem, "dye");					//Modchu_Debug.mDebug("renderItemsHead 4 item2="+item2);					//Modchu_Debug.mDebug("renderItemsHead 5 dyePowder="+dyePowder);					if (item2 == dyePowder) {						scale = 1.0F + (0.2F * Modchu_Main.getMinecraftVersion() > 159 ? Modchu_AS.getFloat(Modchu_AS.itemStackGetItemDamage, itemstack1) : Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemstack1));						//Modchu_Debug.mDebug("renderItemsHead 6 ");					}				}				//Modchu_Debug.mDebug("renderItemsHead addSupport="+addSupport);				if (isPlanter						| (addSupport > -1								&& addSupport < 3)) {					headTopLoadMatrix();					scale = scale * itemHeadTopScale;					HeadTop.renderItemsHead("HeadTop", this, entityCaps, scale, addSupport);					//HeadTop.loadMatrix().renderItemsHead(this, entityCaps);				} else {					headMountLoadMatrix();					scale = scale * itemHeadMountScale;					HeadMount.renderItemsHead("HeadMount", this, entityCaps, scale, addSupport);					//HeadMount.loadMatrix().renderItemsHead(this, entityCaps);				}			}		}	}	public void headMountLoadMatrix() {		HeadMount.loadMatrix();	}	public void headTopLoadMatrix() {		HeadTop.loadMatrix();	}	public void armsLoadMatrix(int i) {		if (Arms != null				&& i < Arms.length) Arms[i].loadMatrix();	}	public void renderItemsArmorHead(ModchuModel_IEntityCaps entityCaps) {		// アーマー頭部装飾品の表示		//Modchu_Debug.mDebug("renderItemsArmorHead");		Object itemstack = Modchu_EntityCapsHelper.getCapsValue(entityCaps, caps_currentArmor, new Object[]{ 3 });		if (itemstack != null) {			//Modchu_Debug.mDebug("renderItemsArmorHead 1");			int addSupport = addSupportChecks(entityCaps, itemstack, 1);			headMountRenderItems(entityCaps, itemstack, addSupport);		}	}	public void headMountRenderItems(ModchuModel_IEntityCaps entityCaps, Object itemstack, int addSupport) {		Object pEntity = Modchu_EntityCapsHelper.getCapsValue(entityCaps, entityCaps.caps_Entity);		if (Modchu_AS.getBoolean(Modchu_AS.isCamouflage, itemstack)				| Modchu_AS.getBoolean(Modchu_AS.isPlanter, itemstack)				| addSupport > -1) {			//Modchu_Debug.mDebug("headMountRenderItems 1");			Object inventory = entityCaps.getCapsValue(caps_Inventory);			float scale = 1.0F;			if (inventory != null) {				int slot = Modchu_Reflect.loadClass("EntityPlayer").isInstance(pEntity) ? 10 : 16;				Object itemstack1 = Modchu_AS.get(Modchu_AS.inventoryPlayerGetStackInSlot, inventory, slot);				if (itemstack1 != null) {					Object item2 = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemstack1);					Object dyePowder = Modchu_AS.get(Modchu_AS.getItem, "dye");					if (item2 == dyePowder) {						scale = 1.0F + (0.2F * Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemstack1));					}				}			}			Modchu_GlStateManager.pushMatrix();			headMountLoadMatrix();			scale = scale * itemHeadMountScale;			HeadMount.renderItemsHead("HeadMount", this, entityCaps, itemstack, scale, addSupport);			Modchu_GlStateManager.popMatrix();			//Modchu_Debug.mDebug("headMountRenderItems end");		}	}	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack) {		return addSupportChecks(entityCaps, itemstack, 0);	}	/**	 * PlayerFormLittleMaidで追加対応したブロック・アイテムかチェック	 * DecoBlock = 0, DecoBlockBase = 1, FavBlock = 2, Item.skull = 3,	 * BlockPumpkin = 4	 */	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack, int type) {		if (itemstack != null); else return -1;		Object block = Modchu_AS.get(Modchu_AS.getBlockItemStack, itemstack);		if (ModchuModel_Main.isDecoBlock) {			if (Modchu_Reflect.loadClass("decoBlock").isInstance(block)) return 0;			if (Modchu_Reflect.loadClass("decoBlockBase").isInstance(block)) return 1;		}		if (ModchuModel_Main.isFavBlock				&& Modchu_Reflect.loadClass("favBlock").isInstance(block)) {			return 2;		}		//type == 0 HeadMount, type == 1 Armor		if (type == 0				&& entityCaps != null				&& entityCaps.getCapsValue(caps_EntityType).equals(entityType_PFLM)) return -1;//-@-132		if (Modchu_AS.getBoolean(Modchu_AS.isSkull, itemstack)) return 3;//@-@132		if (Modchu_AS.getBoolean(Modchu_AS.isPumpkin, itemstack)) return 4;		return -1;	}	public ModchuModel_ModelRenderer getArms(int i) {		return Arms[i];	}	public ModchuModel_ModelRenderer getHeadMount() {		return HeadMount;	}	/**	 * PlayerFormLittleMaid専用Player用処理	 * setRotationAngles 呼び出し後に通常視点時なら呼ばれる。	 * 通常視点時の手の描画位置、角度調整を入れる。	 */	public final void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps, dominantArm);	}	/**	 * Overrideはこちらで。	 */	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps, int renderArmIndex) {	}	/**	 * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、	 * setPartsの前に呼ばれる。自動取得されたリストの編集など	 */	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {	}	/**	 * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、	 * setPartsの後に呼ばれる。デフォルトOFFにする設定など	 */	public void defaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {	}	/**	 * GUI パーツ表示・非表示反映	 */	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {	}	@Override	public void changeModel(ModchuModel_IEntityCaps o) {		showAllParts(o);	}	/**	 * カラー切替時に実行されるコード	 */	public void changeColor(ModchuModel_IEntityCaps entityCaps) {	}	/**	 * 各パーツのaddChild状態をリセットし、すべて再セットするコードを入れる	 * 何度も呼ばれるのでaddChildのみではなく、clearしてからのaddChildを考慮する事	 */	public void defaultAddChild() {	}	/**	 * ボーンパーツ処理	 */	public void boneProcessing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {	}	@Override	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {		return 1.62F;	}	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {		return getHeight(entityCaps);	}	public float getRidingWidth(ModchuModel_IEntityCaps entityCaps) {		return getWidth(entityCaps);	}	public float getRidingYOffset(ModchuModel_IEntityCaps entityCaps) {		return getYOffset(entityCaps);	}	public float getRenderCorrectionYOffset(ModchuModel_ModelDataBase entityCaps) {		return 1.8F - getHeight(entityCaps);	}	/**	 * 他Mobを頭に乗せた時の他Mob基準位置調整	 */	@Override	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {		return 0.75F;	}	/**	 * 座っているポーズ「乗り物に乗っていない」時の位置調整	 */	public double getSittingYOffset(ModchuModel_IEntityCaps entityCaps) {		return -0.35D;	}	/**	 * isModelSize=true時に乗り物に乗っている状態でのカメラ位置調整	 */	public float ridingViewCorrection(ModchuModel_IEntityCaps entityCaps) {		return 0.0F;	}	/**	 * デフォルトモデルスケール	 */	public float getModelScale(ModchuModel_IEntityCaps entityCaps) {		return 0.9375F;	}	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		setCapsValue(entityCaps, caps_visible, bipedHead, b);		setCapsValue(entityCaps, caps_visible, bipedHeadwear, b);	}	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		setCapsValue(entityCaps, caps_visible, bipedBody, b);	}	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag)				&& Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 0				| Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 1) {			setCapsValue(entityCaps, caps_visible, bipedRightArm, false);		} else setCapsValue(entityCaps, caps_visible, bipedRightArm, b);	}	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag)				&& Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 0				| Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 1) {			setCapsValue(entityCaps, caps_visible, bipedLeftArm, false);		} else setCapsValue(entityCaps, caps_visible, bipedLeftArm, b);	}	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag)				&& Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 0				| Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 1) {			setCapsValue(entityCaps, caps_visible, bipedRightLeg, false);		} else setCapsValue(entityCaps, caps_visible, bipedRightLeg, b);	}	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag)				&& Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 0				| Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_actionRequestNumber) == 1) {			setCapsValue(entityCaps, caps_visible, bipedLeftLeg, false);		} else setCapsValue(entityCaps, caps_visible, bipedLeftLeg, b);	}	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {	}	@Override	public Object getCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {		switch (pIndex) {		case caps_getIsSneak:			return getIsSneak(entityCaps);		case caps_getIsRiding:			return getIsRiding(entityCaps);		case caps_isRiding:			return isRiding;		case caps_aimedBow:			return getaimedBow(entityCaps);		case caps_getIsWait:			return getIsWait(entityCaps);		case caps_isSitting:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getIsSitting((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_getIsSleeping:			return getIsSleeping(entityCaps);		case caps_armorType:			return getArmorType();		case caps_isItemHolder:			return isItemHolder(entityCaps);		case caps_bipedHead:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getBipedHead((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_bipedRightArm:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getBipedRightArm((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_bipedLeftArm:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getBipedLeftArm((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_bipedRightLeg:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getBipedRightLeg((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_bipedLeftLeg:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getBipedLeftLeg((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_dominantArmModelRenderer:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getDominantArm((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_notDominantArmModelRenderer:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return getNotDominantArm((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_Physical_Hammer:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return Physical_Hammer((ModchuModel_IEntityCaps) pArg[0]);			break;		case caps_height:			return getHeight(entityCaps);		case caps_width:			return getWidth(entityCaps);		case caps_YOffset:			return getYOffset(entityCaps);		case caps_convertDegtoRad:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) return convertDegtoRad((Float) pArg[0]);			break;		case caps_modchuRemodelingModel:			return getModchuRemodelingModel();		case caps_sittingYOffset:			return getSittingYOffset(entityCaps);		case caps_texture:			if (pArg != null			&& pArg.length > 1			&& pArg[0] != null			&& pArg[1] != null) return getTexture((String) pArg[0], (Integer) pArg[1]);			break;		}		return super.getCapsValue(entityCaps, pIndex, pArg);	}	@Override	public boolean setCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {		switch (pIndex) {		case caps_isRiding:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) {				setIsRiding((Boolean) pArg[0]);				return true;			}			return false;		case caps_isSneak:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) {				setIsSneak((Boolean) pArg[0]);				return true;			}			return false;		case caps_renderFirstPersonHand:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) {				if (pArg.length > 1						&& pArg[1] != null) {					renderFirstPersonHand(entityCaps, (Float) pArg[0], 0);				} else {					renderFirstPersonHand(entityCaps, (Float) pArg[0], (Integer) pArg[1]);				}				return true;			}			return false;		case caps_visible:			if (pArg != null			&& pArg.length > 1			&& pArg[0] != null			&& pArg[1] != null) {				if (pArg.length > 2						&& pArg[2] != null) {					setVisible((ModchuModel_ModelRenderer) pArg[0], (Boolean) pArg[1], (Boolean) pArg[2]);					return true;				}				setVisible((ModchuModel_ModelRenderer) pArg[0], (Boolean) pArg[1]);				return true;			}			return false;		case caps_aimedBow:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) {				setAimedBow((Boolean) pArg[0]);				return true;			}			return false;		case caps_modchuRemodelingModel:			if (pArg != null			&& pArg.length > 0			&& pArg[0] != null) {				setModchuRemodelingModel((Boolean) pArg[0]);				return true;			}			return false;		}		return super.setCapsValue(entityCaps, pIndex, pArg);	}	private int getMaidColor(ModchuModel_IEntityCaps entityCaps) {		Object entityliving = Modchu_EntityCapsHelper.getCapsValue(entityCaps, entityCaps.caps_Entity);		//Modchu_Debug.mDebug("getMaidColor entityliving != null?"+(entityliving != null));		Object o = null;		if (entityCaps != null) o = entityCaps.getCapsValue(caps_maidColor);		if (o != null) return (Integer) o;		if (Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_LMM) {			Field f = Modchu_Reflect.getField(entityliving.getClass(), "maidColor", -1);			if (f != null) {				o = Modchu_Reflect.getFieldObject(f, entityliving, -1);				if (o != null) return (Integer) o;			} else {				f = Modchu_Reflect.getField(entityliving.getClass(), "textureData", -1);				if (f != null) {					o = Modchu_Reflect.getFieldObject(f, entityliving, -1);					if (o != null) {						o = Modchu_Reflect.getFieldObject(o.getClass(), "color", o);						return (Integer) o;					}				}			}		}		if (Modchu_EntityCapsHelper.getCapsValueByte(this, entityCaps, entityCaps.caps_EntityType) == entityCaps.entityType_ModchuLMM) {			Object master = Modchu_Main.getModchuCharacteristicObjectMaster(entityliving);			o = Modchu_Reflect.getFieldObject(master.getClass(), "textureData", master);			if (o != null) {				o = Modchu_Reflect.getFieldObject(o.getClass(), "color", o);				return (Integer) o;			}		}		return 0;	}	private Object getTexture(String s, int i) {		return ModchuModel_TextureManagerBase.instance.textureManagerGetTexture(s, i);	}	private int getArmorType() {		float[] f = getArmorModelsSize();		//Modchu_Debug.mlDebug("getArmorType() modelSize="+modelSize+" "+this);		//Modchu_Debug.mlDebug("getArmorType() modelSize="+modelSize+" f[0]="+f[0]+" f[1]="+f[1]);		return modelSize == f[0] ? 1 : modelSize == f[1] ? 2 : 0;	}	private boolean getIsRiding(ModchuModel_IEntityCaps entityCaps) {		return isRiding				&& !getRidingBan(entityCaps);	}	private void setIsRiding(boolean b) {		isRiding = b;	}	private boolean getIsSneak(ModchuModel_IEntityCaps entityCaps) {		return isSneak				&& !getSneakBan(entityCaps);	}	private void setIsSneak(boolean b) {		isSneak = b;	}	private boolean getIsSleeping(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isSleeping)				&& !getSleepingBan(entityCaps);	}	private boolean getaimedBow(ModchuModel_IEntityCaps entityCaps) {		return aimedBow				&& !getAimedBowBan(entityCaps);	}	private boolean getIsWait(ModchuModel_IEntityCaps entityCaps) {		if (entityCaps != null); else {			//Modchu_Debug.mDebug("getIsWait entityCaps == null !! return false");			return false;		}		//if (!Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_isPlayer)) {			//Modchu_Debug.mDebug("getIsWait caps_isWait="+(entityCaps.getCapsValue(caps_isWait)));			//Modchu_Debug.mDebug("getIsWait getWaitBan="+(getWaitBan(entityCaps)));		//}		return Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isWait)				&& !getWaitBan(entityCaps);	}	private boolean getIsSitting(ModchuModel_IEntityCaps entityCaps) {		if (entityCaps != null) return (Boolean) entityCaps.getCapsValue(caps_isSitting)				&& !getSittingBan(entityCaps);		return false;	}	private boolean getSneakBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "sneakBan");	}	private boolean getAimedBowBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "aimedBowBan");	}	private boolean getWaitBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "waitBan");	}	private boolean getSittingBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "sittingBan");	}	private boolean getSleepingBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "sleepingBan");	}	private boolean getRidingBan(ModchuModel_IEntityCaps entityCaps) {		return Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "ridingBan");	}	private void setAimedBowBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "aimedBowBan", b);	}	private void setSneakBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "sneakBan", b);	}	private void setWaitBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "waitBan", b);	}	private void setSittingBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "sittingBan", b);	}	private void setSleepingBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "sleepingBan", b);	}	private void setRidingBan(ModchuModel_IEntityCaps entityCaps, boolean b) {		entityCaps.setCapsValue(caps_freeVariable, "ridingBan", b);	}	private boolean getAimedBow() {		return aimedBow;	}	private void setAimedBow(boolean b) {		aimedBow = b;	}	private void setVisible(ModchuModel_ModelRenderer renderer, boolean b) {		setVisible(renderer, b, false);	}	private void setVisible(ModchuModel_ModelRenderer renderer, boolean b, boolean b1) {		if (renderer != null				&& renderer.showModel != b); else return;		if (!b1) {			//Modchu_Debug.mDebug("setVisible !b1");			int armorType = getArmorType();			HashMap<String, Boolean> partsShowMap = (HashMap<String, Boolean>) getCapsValue(caps_showPartsMap, armorType);			if (partsShowMap != null) {				String s = (String) getCapsValue(caps_modelRendererName, renderer, armorType);				if (s != null						&& partsShowMap.containsKey(s)) {					//Modchu_Debug.mDebug("setVisible partsShowMap ok. s="+s);					return;				}				//Modchu_Debug.mDebug("setVisible partsShowMap !containsKey s="+s);			} else {				//Modchu_Debug.mDebug("setVisible partsShowMap == null");			}		}		renderer.setVisible(b);	}	private float convertDegtoRad(float deg) {		return deg / 180F * (float) Math.PI;	}	private boolean getModchuRemodelingModel() {		return ModchuModel_ConfigData.modchuRemodelingModel;	}	private void setModchuRemodelingModel(boolean b) {		ModchuModel_ConfigData.modchuRemodelingModel = b;	}	public float Physical_Hammer(ModchuModel_IEntityCaps entityCaps) {		return 1.0F;	}	public ModchuModel_ModelRenderer getBipedHead(ModchuModel_IEntityCaps entityCaps) {		return bipedHead;	}	@Override	public Object getRightArm(Modchu_IEntityCapsBase entityCaps) {		return getRightArm((ModchuModel_IEntityCaps) entityCaps);	}	public Object getRightArm(ModchuModel_IEntityCaps entityCaps) {		return getBipedRightArm(entityCaps);	}	public ModchuModel_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedRightArm;		return bipedLeftArm;	}	public ModchuModel_ModelRenderer getBipedRightArm(ModchuModel_IEntityCaps entityCaps) {		return bipedRightArm;	}	public ModchuModel_ModelRenderer getBipedBody(ModchuModel_IEntityCaps entityCaps) {		return bipedBody;	}	public ModchuModel_ModelRenderer getBipedLeftArm(ModchuModel_IEntityCaps entityCaps) {		return bipedLeftArm;	}	public ModchuModel_ModelRenderer getBipedRightLeg(ModchuModel_IEntityCaps entityCaps) {		return bipedRightLeg;	}	public ModchuModel_ModelRenderer getBipedLeftLeg(ModchuModel_IEntityCaps entityCaps) {		return bipedLeftLeg;	}	public ModchuModel_ModelRenderer getNotDominantArm(ModchuModel_IEntityCaps entityCaps) {		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedLeftArm;		return bipedRightArm;	}	@Override	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, int i) {		renderFirstPersonHand(entityCaps, 0.0625F, i);	}	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {		if (entityCaps != null) {			ModchuModel_ModelRenderer modchu_ModelRenderer = i == 0 ? getDominantArm(entityCaps) : getNotDominantArm(entityCaps);			if (modchu_ModelRenderer != null) modchu_ModelRenderer.render(f);		}	}	public boolean armSwingFlag(ModchuModel_IEntityCaps entityCaps) {		return (onGrounds[0] > -9990F				| onGrounds[1] > -9990F)				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)				&& !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_oldwalking)				&& (!isGulliver()						| (isGulliver()								&& !Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isGliding")));	}	public void setRotationAnglesGulliverBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		if (!isGulliver()) return;		ModchuModel_ModelRenderer bipedRightArm = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps));		ModchuModel_ModelRenderer bipedLeftArm = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedLeftArm, entityCaps));		ModchuModel_ModelRenderer bipedRightLeg = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedRightLeg, entityCaps));		ModchuModel_ModelRenderer bipedLeftLeg = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedLeftLeg, entityCaps));		if (Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isRafting")) {			bipedRightArm.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F * 0.125F + 3.141593F) * 2.0F * f1 * 0.5F);			bipedLeftArm.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 2.0F * f1 * 0.5F);			bipedRightArm.rotateAngleY = 0.0F;			bipedLeftArm.rotateAngleY = 0.0F;			bipedRightArm.rotateAngleZ = 0.0F;			bipedLeftArm.rotateAngleZ = 0.0F;			bipedRightLeg.rotateAngleX = -1.256637F;			bipedLeftLeg.rotateAngleX = -1.256637F;			bipedRightLeg.rotateAngleY = 0.3141593F;			bipedLeftLeg.rotateAngleY = -0.3141593F;		} else if (Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isGliding")) {			bipedRightLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F * 0.25F) * 1.4F * f1 * 0.25F);			bipedLeftLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F * 0.25F + 3.141593F) * 1.4F * f1 * 0.25F);			bipedRightLeg.rotateAngleY = 0.0F;			bipedLeftLeg.rotateAngleY = 0.0F;			bipedRightLeg.rotateAngleZ = 0.0F;			bipedLeftLeg.rotateAngleZ = 0.0F;		}	}	public void setRotationAnglesGulliverAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		if (isGulliver()); else return;		ModchuModel_ModelRenderer bipedRightArm = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedRightArm, entityCaps));		ModchuModel_ModelRenderer bipedLeftArm = ((ModchuModel_ModelRenderer) getCapsValue(caps_bipedLeftArm, entityCaps));		boolean isGliding = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "isGliding");		boolean doesUmbrella = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "doesUmbrella");		if (isGliding				| doesUmbrella) {			bipedRightArm.rotateAngleX = -3.14F;			bipedRightArm.rotateAngleY = 0.0F;			bipedLeftArm.rotateAngleY = 0.0F;			bipedRightArm.rotateAngleZ = 0.0F;			bipedLeftArm.rotateAngleZ = 0.0F;		}		if (isGliding) bipedLeftArm.rotateAngleX = -3.14F;	}	public boolean isGulliver() {		return ModchuModel_Main.isGulliver;	}	public void worldEventLoad(Object event) {	}	// Minecraft 1.8以上用 Armorに対してMainModelを引数として渡して呼ばれる。同期処理等に	public void setModelAttributes(Object model) {	}	// 以下、LMM_EntityCaps側にあってほしいもの	/**	 * LMM専用処理	 * setLivingAnimations 呼び出し後に呼ばれる。	 */	public void setLivingAnimationsAfter(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {		if (bipedHead != null				&& entityCaps != null) {			float angle = Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_interestedAngle, f2);			bipedHead.rotateAngleZ = angle;		}	}}