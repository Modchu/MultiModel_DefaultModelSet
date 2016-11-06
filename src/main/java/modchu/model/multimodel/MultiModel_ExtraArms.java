package modchu.model.multimodel;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_EntityCapsHelper;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModel;public class MultiModel_ExtraArms extends MultiModel {	public ModchuModel_ModelRenderer Backpack;
	public ModchuModel_ModelRenderer Antena;
	public ModchuModel_ModelRenderer Cwave;
	public ModchuModel_ModelRenderer FirstAidSet;
	public ModchuModel_ModelRenderer FAstamp;
	public ModchuModel_ModelRenderer Binoculars;
	public ModchuModel_ModelRenderer BinocularsL1;
	public ModchuModel_ModelRenderer BinocularsL2;
	public ModchuModel_ModelRenderer BinocularsR1;
	public ModchuModel_ModelRenderer BinocularsR2;
	public ModchuModel_ModelRenderer Bullet1;
	public ModchuModel_ModelRenderer Bullet2;
	public ModchuModel_ModelRenderer Bullet3;
	public ModchuModel_ModelRenderer eyeL;
	public ModchuModel_ModelRenderer eyeR;	public MultiModel_ExtraArms() {
		this(0.0F);
	}	public MultiModel_ExtraArms(float f) {
		this(f, 0.0F);
	}	public MultiModel_ExtraArms(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_ExtraArms(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		f1 += 8F;
		Backpack = new ModchuModel_ModelRenderer(this, 24, 0);
		Backpack.addBox(-2.5F, -3.2F, 2.0F, 5, 5, 3, f);
		Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antena = new ModchuModel_ModelRenderer(this, 40, 0);
		Antena.addBox(0.5F, -9.5F, 4.8F, 1, 7, 1, f - 0.2F);
		Antena.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cwave = new ModchuModel_ModelRenderer(this, 48, 10);
		Cwave.addBox(6.5F, -10.5F, 4.8F, 4, 2, 0, f);
		Cwave.setRotationPoint(0.0F, 0.0F, 0.0F);
		FirstAidSet = new ModchuModel_ModelRenderer(this, 52, 10);
		FirstAidSet.addBox(2.001F, 4F, 0.0F, 2, 3, 4, f);
		FirstAidSet.setRotationPoint(0.0F, -4.0F, -1F);
		FAstamp = new ModchuModel_ModelRenderer(this, 58, 11);
		FAstamp.addBox(0.5F, 3.5F, -3.002F, 3, 3, 0, f - 1.0F);
		FAstamp.setRotationPoint(0.0F, 0.0F, 0.0F);
		Binoculars = new ModchuModel_ModelRenderer(this, 0, 2);
		Binoculars.addBox(-1.5F, 9F, 2.5F, 3, 2, 1, f);
		Binoculars.setRotationPoint(-0.5F, -2.0F, -4.0F);
		BinocularsL1 = new ModchuModel_ModelRenderer(this, 0, 16);
		BinocularsL1.addBox(0.0F, 8F, 2.0F, 2, 2, 2, f - 0.5F);
		BinocularsL1.setRotationPoint(-2.0F, 0.0F, 0.5F);
		BinocularsL2 = new ModchuModel_ModelRenderer(this, 0, 0);
		BinocularsL2.addBox(0.0F, 9.5F, 2.0F, 2, 3, 2, f);
		BinocularsL2.setRotationPoint(-2.0F, 0.0F, 0.5F);
		BinocularsR1 = new ModchuModel_ModelRenderer(this, 0, 16);
		BinocularsR1.addBox(1.5F, 8F, 1.0F, 2, 2, 2, f - 0.3F);
		BinocularsR1.setRotationPoint(-2.0F, 0.0F, 0.5F);
		BinocularsR2 = new ModchuModel_ModelRenderer(this, 0, 0);
		BinocularsR2.addBox(1.5F, 9.5F, 1.0F, 2, 3, 2, f);
		BinocularsR2.setRotationPoint(-2.0F, 0.0F, 0.5F);
		Bullet1 = new ModchuModel_ModelRenderer(this, 0, 6);
		Bullet1.addBox(0.0F, -2F, -2F, 3, 1, 1, f);
		Bullet1.setRotationPoint(0.0F, -3.0F, 0.0F);
		Bullet2 = new ModchuModel_ModelRenderer(this, 0, 6);
		Bullet2.addBox(0.0F, -1F, -3F, 3, 1, 1, f);
		Bullet2.setRotationPoint(0.0F, -3.0F, 0.0F);
		Bullet3 = new ModchuModel_ModelRenderer(this, 0, 6);
		Bullet3.addBox(0.0F, 0.0F, -4F, 3, 1, 1, f);
		Bullet3.setRotationPoint(0.0F, -3.0F, 0.0F);
		eyeL = new ModchuModel_ModelRenderer(this, 32, 19);
		eyeL.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR = new ModchuModel_ModelRenderer(this, 42, 19);
		eyeR.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(ChignonB);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedBody.addChild(Backpack);
		bipedBody.addChild(Bullet1);
		bipedBody.addChild(Bullet2);
		bipedBody.addChild(Bullet3);
		bipedBody.addChild(FirstAidSet);
		Backpack.addChild(Antena);
		Antena.addChild(Cwave);
		FirstAidSet.addChild(FAstamp);
		bipedLeftArm.addChild(Binoculars);
		Binoculars.addChild(BinocularsL1);
		Binoculars.addChild(BinocularsL2);
		Binoculars.addChild(BinocularsR1);
		Binoculars.addChild(BinocularsR2);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = (float)ticksExisted + f2 + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		// 目パチ
		if (0 > Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.05F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.13F) + Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.7F) + 2.55F) {
			setCapsValue(entityCaps, caps_visible, eyeR, false);
			setCapsValue(entityCaps, caps_visible, eyeL, false);
		} else {
			setCapsValue(entityCaps, caps_visible, eyeR, true);
			setCapsValue(entityCaps, caps_visible, eyeL, true);
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		Cwave.setVisible(false);		if (armSwingFlag(entityCaps)) {
			Antena.rotationPointY = 4F;
		}
		Skirt.rotationPointZ = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			Skirt.rotateAngleX += 0.3F;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
			Antena.rotationPointY = 0.0F;
			if (0.0D > (mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.15000000596046448D + 0.10000000149011612D) {
				Cwave.rotationPointX = (int) (Math.random() * 4D) + 0.0F;
				Cwave.setVisible(true);
			} else {
				Cwave.setVisible(false);
			}
		}
		boolean aimedBowBinoculars = Modchu_EntityCapsHelper.getCapsValueBoolean(entityCaps, caps_freeVariable, "aimedBowBinoculars");
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow) || Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait)) {
			if (!aimedBowBinoculars) {
				entityCaps.setCapsValue(caps_freeVariable, "aimedBowBinoculars", true);
				bipedLeftArm.removeChild(Binoculars);
				bipedLeftLeg.addChild(Binoculars);
				if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
					Binoculars.setRotationPoint(0.0F, -10.0F, 0.0F);
				} else {
					Binoculars.setRotationPoint(0.0F, -10.0F, -2.0F);
				}
				float f10 = 2.3F;
				Binoculars.rotateAngleX = f10;
				Binoculars.rotateAngleY = f10 - 0.8F;
				Binoculars.rotateAngleZ = f10;
			}
		} else {
			if (aimedBowBinoculars) {
				entityCaps.setCapsValue(caps_freeVariable, "aimedBowBinoculars", false);
				bipedLeftLeg.removeChild(Binoculars);
				bipedLeftArm.addChild(Binoculars);
				Binoculars.setRotationPoint(-0.49F, -2.0F, -4.0F);
				Binoculars.setRotateAngleX(0.0F);
				Binoculars.setRotateAngleY(0.0F);
				Binoculars.setRotateAngleZ(0.0F);
			}
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, eyeL, true);
			setCapsValue(entityCaps, caps_visible, eyeR, false);
			BinocularsL1.setRotateAngleX(BinocularsL2.setRotateAngleX(0.0F));
			BinocularsR1.setRotateAngleX(BinocularsR2.setRotateAngleX(0.0F));
			BinocularsL1.setRotateAngleY(BinocularsL2.setRotateAngleY(0.0F));
			BinocularsR1.setRotateAngleY(BinocularsR2.setRotateAngleY(0.0F));
			BinocularsL1.setRotateAngleZ(BinocularsL2.setRotateAngleZ(0.0F));
			BinocularsR1.setRotateAngleZ(BinocularsR2.setRotateAngleZ(0.0F));
		}
		FirstAidSet.rotateAngleX = 0.17453F;
		FAstamp.rotateAngleY = -1.5708F;
		FAstamp.rotateAngleZ = 0.0F;
		Cwave.rotateAngleZ = -0.2618F;
		Bullet1.rotateAngleX = Bullet2.rotateAngleX = Bullet3.rotateAngleX = 0.7854F;
		Bullet1.rotateAngleY = Bullet2.rotateAngleY = Bullet3.rotateAngleY = 0.0F;
		Bullet1.rotateAngleZ = Bullet2.rotateAngleZ = Bullet3.rotateAngleZ = 0.5236F;
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"bipedHeadwear", "d"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
		String[] s1 = {
				"FirstAidSet", "Binoculars", "BinocularsL1", "BinocularsL2", "BinocularsR1",
				"BinocularsR2", "BinocularsR1", "BinocularsR2"
		};
		String[] s2 = {
				"FA_Set", "Bino", "BinoL1", "Bino_L2", "Bino_R1",
				"Bino_R2", "Bino_R1", "Bino_R2"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}/*
	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps)
	{
		return 0.8F;
	}
*/
	@Override
	public String getUsingTexture() {
		return null;
	}
}