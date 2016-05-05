package modchu.model;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelBaseMaster;
import modchu.lib.Modchu_Reflect;

import org.lwjgl.opengl.GL11;

public abstract class ModchuModel_ModelBaseMaster extends Modchu_ModelBaseMaster implements ModchuModel_IEntityCaps {
	public float heldItem[] = new float[] {0.0F, 0.0F};

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, boolean pIsRender) {
		render(getModchuModel_ModelDataBase(entity), par2, par3, par4, par5, par6, par7, pIsRender);
	}

	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
	}

	public void render(Modchu_IEntityCapsBase entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		render((ModchuModel_IEntityCaps) entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		setRotationAngles(par1, par2, par3, par4, par5, par6, getModchuModel_ModelDataBase(entity));
	}

	public void setRotationAngles(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, ModchuModel_IEntityCaps entityCaps) {
	}

	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		setLivingAnimations(getModchuModel_ModelDataBase(entityLivingBase), par2, par3, par4);
	}

	public void setLivingAnimations(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float pRenderPartialTicks) {
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		return getCapsValue(null, pIndex, pArg);
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		return getCapsValue((ModchuModel_IEntityCaps) entityCaps, pIndex, pArg);
	}

	public Object getCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_heldItemLeft:
			return heldItem[1];
		case caps_heldItemRight:
			return heldItem[0];
		case caps_setFaceTexture:
			return setFaceTexture((Integer)pArg[0]);
		case caps_textureLightColor:
			if (!(pArg[0] instanceof Modchu_IEntityCapsBase)) pArg[0] = ModchuModel_ModelDataMaster.instance.getPlayerData(pArg[0]);
			return getTextureLightColor((Modchu_IEntityCapsBase)pArg[0]);
		}
		return super.getCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public Object getCapsValueModel(int pIndex, Object... pArg) {
		return getCapsValue(null, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue(null, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		return setCapsValue((ModchuModel_IEntityCaps) entityCaps, pIndex, pArg);
	}

	public boolean setCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_heldItemLeft:
			heldItem[1] = (Integer)pArg[0];
			return true;
		case caps_heldItemRight:
			heldItem[0] = (Integer)pArg[0];
			return true;
		case caps_changeModel:
			if (!(pArg[0] instanceof Modchu_IEntityCapsBase)) pArg[0] = ModchuModel_ModelDataMaster.instance.getPlayerData(pArg[0]);
			changeModel((Modchu_IEntityCapsBase)pArg[0]);
			return true;
		case caps_renderFace:
			if (!(pArg[0] instanceof ModchuModel_IEntityCaps)) pArg[0] = ModchuModel_ModelDataMaster.instance.getPlayerData(pArg[0]);
			renderFace((ModchuModel_IEntityCaps) pArg[0], (Float)pArg[1], (Float)pArg[2], (Float)pArg[3],
				(Float)pArg[4], (Float)pArg[5], (Float)pArg[6], (Boolean)pArg[7]);
			return true;
		case caps_renderBody:
			if (!(pArg[0] instanceof ModchuModel_IEntityCaps)) pArg[0] = ModchuModel_ModelDataMaster.instance.getPlayerData(pArg[0]);
			renderBody((ModchuModel_IEntityCaps) pArg[0], (Float)pArg[1], (Float)pArg[2], (Float)pArg[3],
				(Float)pArg[4], (Float)pArg[5], (Float)pArg[6], (Boolean)pArg[7]);
			return true;
		}
		return super.setCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValueModel(int pIndex, Object... pArg) {
		return setCapsValue(null, pIndex, pArg);
	}

	@Override
	public void changeModel(Modchu_IEntityCapsBase entityCaps) {
		changeModel((ModchuModel_IEntityCaps) entityCaps);
	}

	public void changeModel(ModchuModel_IEntityCaps entityCaps) {
	}

	@Override
	public boolean preRender(Modchu_IEntityCapsBase entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return preRender((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}

	public boolean preRender(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return true;
	}

	@Override
	public void renderExtention(Modchu_IEntityCapsBase entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		renderExtention((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}

	public void renderExtention(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
	}

	@Override
	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Modchu_IEntityCapsBase entityCaps) {
		setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, (ModchuModel_IEntityCaps) entityCaps);
	}

	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, ModchuModel_IEntityCaps entityCaps) {
	}

	@Override
	public float[] getTextureLightColor(Modchu_IEntityCapsBase entityCaps) {
		return getTextureLightColor((ModchuModel_IEntityCaps) entityCaps);
	}

	public float[] getTextureLightColor(ModchuModel_IEntityCaps entityCaps) {
		return null;
	}

	@Override
	public void renderItems(Modchu_IEntityCapsBase entityCaps) {
		renderItems((ModchuModel_IEntityCaps) entityCaps);
	}

	public void renderItems(ModchuModel_IEntityCaps entityCaps) {
	}

	@Override
	public void renderFirstPersonHand(Modchu_IEntityCapsBase entityCaps, int i) {
		renderFirstPersonHand((ModchuModel_IEntityCaps) entityCaps, i);
	}

	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, int i) {
	}

	@Override
	public int showArmorParts(Modchu_IEntityCapsBase entityCaps, int parts, int index) {
		return showArmorParts((ModchuModel_IEntityCaps) entityCaps, parts, index);
	}

	public abstract int showArmorParts(ModchuModel_IEntityCaps entityCaps, int parts, int index);

	@Override
	public float getHeight(Modchu_IEntityCapsBase entityCaps) {
		return getHeight((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract float getHeight(ModchuModel_IEntityCaps entityCaps);

	@Override
	public float getWidth(Modchu_IEntityCapsBase entityCaps) {
		return getWidth((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract float getWidth(ModchuModel_IEntityCaps entityCaps);

	@Override
	public float getYOffset(Modchu_IEntityCapsBase entityCaps) {
		return getYOffset((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract float getYOffset(ModchuModel_IEntityCaps entityCaps);

	@Override
	public float getMountedYOffset(Modchu_IEntityCapsBase entityCaps) {
		return getMountedYOffset((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract float getMountedYOffset(ModchuModel_IEntityCaps entityCaps);

	@Override
	public float getLeashOffset(Modchu_IEntityCapsBase entityCaps) {
		return getLeashOffset((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract float getLeashOffset(ModchuModel_IEntityCaps entityCaps);

	@Override
	public boolean isItemHolder(Modchu_IEntityCapsBase entityCaps) {
		return isItemHolder((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract boolean isItemHolder(ModchuModel_IEntityCaps entityCaps);

	@Override
	public void showAllParts(Modchu_IEntityCapsBase entityCaps) {
		showAllParts((ModchuModel_IEntityCaps) entityCaps);
	}

	public abstract void showAllParts(ModchuModel_IEntityCaps entityCaps);

	public void renderBody(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
	}

	public void renderFace(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
	}

	/**
	 * 表情をテクスチャのUVマップを変えることで表現
	 * @param pIndex
	 */
	public int setFaceTexture(int pIndex) {
		// u = (int)(pIndex % 2) * 32 / 64
		// v = (int)(pIndex / 2) * 32 / 32
		GL11.glTranslatef(((pIndex & 0x01) * 32) / textureWidth, (((pIndex >>> 1) & 0x01) * 16) / textureHeight , 0F);
		return pIndex / 4;
	}

	private ModchuModel_IEntityCaps getModchuModel_ModelDataBase(Object entityLivingBase) {
		return (ModchuModel_IEntityCaps) (entityLivingBase instanceof ModchuModel_ModelDataBase ? entityLivingBase : ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase));
	}

	public boolean isTicksElytraFlying(ModchuModel_IEntityCaps entityCaps) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190) return false;
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		return Modchu_Reflect.loadClass("EntityLivingBase").isInstance(entity)
				&& Modchu_AS.getInt("EntityLivingBase", "getTicksElytraFlying", entity) > 4;
	}

	public float getTicksElytraFlyingCorrection(ModchuModel_IEntityCaps entityCaps) {
		return getTicksElytraFlyingCorrection(entityCaps, isTicksElytraFlying(entityCaps));
	}

	public float getTicksElytraFlyingCorrection(ModchuModel_IEntityCaps entityCaps, boolean isTicksElytraFlying) {
		float f = 1.0F;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190
				| !isTicksElytraFlying) return f;
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		double motionX = Modchu_AS.getDouble(Modchu_AS.entityMotionX, entity);
		double motionY = Modchu_AS.getDouble(Modchu_AS.entityMotionY, entity);
		double motionZ = Modchu_AS.getDouble(Modchu_AS.entityMotionZ, entity);
		f = (float)(motionX * motionX + motionY * motionY + motionZ * motionZ);
		f = f / 0.2F;
		f = f * f * f;
		if (f < 1.0F) f = 1.0F;
		return f;
	}

	public boolean isDominantArmRight(ModchuModel_IEntityCaps entityCaps) {
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		int version = Modchu_Main.getMinecraftVersion();
		return (version > 189
				&& Modchu_AS.getEnum("EntityLivingBase", "getPrimaryHand", entity) == Modchu_AS.getEnum("EnumHandSide", "RIGHT"))
				| (version < 190
				&& dominantArm == 0);
	}

	public boolean isDominantArmLeft(ModchuModel_IEntityCaps entityCaps) {
		Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
		int version = Modchu_Main.getMinecraftVersion();
		return (version > 189
				&& Modchu_AS.getEnum("EntityLivingBase", "getPrimaryHand", entity) == Modchu_AS.getEnum("EnumHandSide", "LEFT"))
				| (version < 190
				&& dominantArm == 1);
	}

	public int isFirstPersonCheckItem(ModchuModel_IEntityCaps entityCaps, int dominantArm) {
		Object[] itemStacks = Modchu_CastHelper.ObjectArray(entityCaps.getCapsValue(entityCaps.caps_Items));
		int i1 = isDominantArmRight(entityCaps) ? 0 : 1;
		if (itemStacks != null) {
			if (itemStacks.length > i1
				&& itemStacks[i1] != null) {
				//利き手に所持
				return 1;
			}
			if (itemStacks.length > (1 - i1)
				&& itemStacks[1 - i1] != null) {
				//利き手じゃない方に所持
				return 2;
			}
		}
		return 0;
	}

}
