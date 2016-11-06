package modchu.model.multimodel;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelDataBase;
import modchu.model.ModchuModel_ModelRenderer;
import modchu.model.multimodel.base.MultiModel_SR2;

public abstract class MultiModelBeverlyBase extends MultiModel_SR2 {

	public MultiModelBeverlyBase() {
		this(0.0F);
	}

	public MultiModelBeverlyBase(float f) {
		this(f, 0.0F);
	}

	public MultiModelBeverlyBase(float f, float f1) {
		this(f, f1, 64, 64);
	}

	public MultiModelBeverlyBase(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}

	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		int x;
		int y;
		int z;
		if (Modchu_Main.getMinecraftVersion() < 180) { 
			x = Modchu_AS.getInt(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, entityliving));
			Object boundingBox = Modchu_AS.get(Modchu_AS.entityBoundingBox, entityliving);
			y = Modchu_AS.getInt(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMaxY, boundingBox) + 1.0D);
			z = Modchu_AS.getInt(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosZ, entityliving));
		} else {
			x = (int) Modchu_AS.getDouble(Modchu_AS.entityPosX, entityliving);
			y = (int) Modchu_AS.getDouble(Modchu_AS.entityPosY, entityliving) + 2;
			z = (int) Modchu_AS.getDouble(Modchu_AS.entityPosZ, entityliving);
		}
		if (!Modchu_AS.getBoolean(Modchu_AS.entityIsSneaking, entityliving)) isSneak = !Modchu_AS.getBoolean(Modchu_AS.worldIsAirBlock, entityliving, x, y, z);

		//背負われ
		if (Modchu_Reflect.loadClass("EntityPlayer").isInstance(Modchu_AS.get(Modchu_AS.entityRidingEntity, entityliving))) {
			rightLeg.rotateAngleY = 0.5F;
			leftLeg.rotateAngleY = -0.5F;
		} else {
			rightLeg.rotateAngleY = 0F;
			leftLeg.rotateAngleY = 0F;
		}

	}

	@Override
	public void action4(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		// 両手を前に出すモーション
		if (onGrounds[dominantArm] > 0F) {
			switch (dominantArm) {
			case 0:
				rightArm.rotateAngleX += -1.57F;
				leftArm.rotateAngleX = -1.57F;
				break;
			case 1:
				leftArm.rotateAngleX += -1.57F;
				rightArm.rotateAngleX = -1.57F;
				break;
			}
		} else {
			rightArm.rotateAngleX = leftArm.rotateAngleX = -1.57F;
		}
		rightArm2.rotateAngleX = leftArm2.rotateAngleX = 0.0F;
		rightArm.rotateAngleY = leftArm.rotateAngleY = 0.0F;
		rightArm.rotateAngleZ = leftArm.rotateAngleZ = 0.0F;
	}

	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.99F;
	}

	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.6F;
	}

	@Override
	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {
		return 0.99F;
	}

	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.81F;
	}

	@Override
	public float getRidingYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.61F;
	}

	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 0.7F;
	}

	@Override
	public double getSittingYOffset(ModchuModel_IEntityCaps entityCaps) {
		return -0.5D;
	}

	@Override
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {
		bipedBody.postRender(f);
		if (i == 0) getDominantArm((ModchuModel_IEntityCaps) entityCaps).render(f);
		if (i == 1) getNotDominantArm((ModchuModel_IEntityCaps) entityCaps).render(f);
	}

	@Override
	public ModchuModel_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm) == 0) return rightArm;
		return leftArm;
	}

	@Override
	public ModchuModel_ModelRenderer getNotDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return leftArm;
		return rightArm;
	}

	@Override
	public ModchuModel_ModelRenderer getBipedRightArm(ModchuModel_IEntityCaps entityCaps) {
		return rightArm;
	}

	@Override
	public ModchuModel_ModelRenderer getBipedLeftArm(ModchuModel_IEntityCaps entityCaps) {
		return leftArm;
	}

	@Override
	public ModchuModel_ModelRenderer getBipedRightLeg(ModchuModel_IEntityCaps entityCaps) {
		return rightLeg;
	}

	@Override
	public ModchuModel_ModelRenderer getBipedLeftLeg(ModchuModel_IEntityCaps entityCaps) {
		return leftLeg;
	}

	@Override
	public float getRenderCorrectionYOffset(ModchuModel_ModelDataBase entityCaps) {
		return 1.8F - getHeight(entityCaps);
	}

}
