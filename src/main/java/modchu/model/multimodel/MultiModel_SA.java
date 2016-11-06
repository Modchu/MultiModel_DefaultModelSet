package modchu.model.multimodel;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_EntityCapsHelper;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModel_Aug;public class MultiModel_SA extends MultiModel_Aug {
	public ModchuModel_ModelRenderer ChignonAug_R;
	public ModchuModel_ModelRenderer ChignonAug_L;
	public ModchuModel_ModelRenderer Chignon_RB;
	public ModchuModel_ModelRenderer Chignon_LB;
	public ModchuModel_ModelRenderer Chignon_U;
	public ModchuModel_ModelRenderer SideTailAug_RU;
	public ModchuModel_ModelRenderer SideTailAug_RB;
	public ModchuModel_ModelRenderer SideTailAug_LU;
	public ModchuModel_ModelRenderer SideTailAug_LB;
	public ModchuModel_ModelRenderer SideTail_RBU;
	public ModchuModel_ModelRenderer SideTail_RBB;
	public ModchuModel_ModelRenderer SideTail_LBU;
	public ModchuModel_ModelRenderer SideTail_LBB;
	public ModchuModel_ModelRenderer SideTailUpper_LB;
	public ModchuModel_ModelRenderer SideTailUpper_RB;
	public ModchuModel_ModelRenderer Tail_T;
	public ModchuModel_ModelRenderer Tail_U;
	public ModchuModel_ModelRenderer Tail_B;
	public ModchuModel_ModelRenderer Headwear_F;
	public ModchuModel_ModelRenderer Headwear_B;
	public ModchuModel_ModelRenderer Headwear_R;
	public ModchuModel_ModelRenderer Headwear_L;
	public ModchuModel_ModelRenderer Shaggy_F;
	public ModchuModel_ModelRenderer LongHair_F;
	public ModchuModel_ModelRenderer LongHair_B;
	public ModchuModel_ModelRenderer LongHair_R;
	public ModchuModel_ModelRenderer LongHair_L;
	public ModchuModel_ModelRenderer Cheek_R;
	public ModchuModel_ModelRenderer Cheek_L;
	public ModchuModel_ModelRenderer Breast1;
	public ModchuModel_ModelRenderer Breast2;	public MultiModel_SA() {
		this(0.0F);
	}	public MultiModel_SA(float f) {
		this(f, 0.0F);
	}	public MultiModel_SA(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_SA(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new ModchuModel_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new ModchuModel_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedRightArm = new ModchuModel_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
		bipedLeftArm = new ModchuModel_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
		bipedRightLeg = new ModchuModel_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
		bipedLeftLeg = new ModchuModel_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		Skirt = new ModchuModel_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		ChignonR = new ModchuModel_ModelRenderer(this, 8, 48);
		ChignonR.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonR.setRotationPoint(-4F, -5.5F, 1.7F);
		ChignonR.rotateAngleY = -((float) Math.PI / 2F);
		ChignonL = new ModchuModel_ModelRenderer(this, 8, 48);
		ChignonL.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonL.setRotationPoint(4F, -5.5F, 1.7F);
		ChignonL.rotateAngleY = ((float) Math.PI / 2F);
		ChignonB = new ModchuModel_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new ModchuModel_ModelRenderer(this, 26, 40);
		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new ModchuModel_ModelRenderer(this, 26, 40);
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		ChignonAug_R = new ModchuModel_ModelRenderer(this, 0, 48);
		ChignonAug_R.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonAug_R.setRotationPoint(-4F, -7F, 1.7F);
		ChignonAug_R.setRotateAngleY(-((float) Math.PI / 2F));
		ChignonAug_L = new ModchuModel_ModelRenderer(this, 0, 52);
		ChignonAug_L.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonAug_L.setRotationPoint(4F, -7F, 1.7F);
		ChignonAug_L.setRotateAngleY(((float) Math.PI / 2F));
		Chignon_RB = new ModchuModel_ModelRenderer(this, 0, 56);
		Chignon_RB.addBox(-4.5F, -7F, 4F, 3, 3, 1, f);
		Chignon_RB.setRotationPoint(0.0F, -1.5F, 0.0F);
		Chignon_LB = new ModchuModel_ModelRenderer(this, 0, 60);
		Chignon_LB.addBox(1.5F, -7F, 4F, 3, 3, 1, f);
		Chignon_LB.setRotationPoint(0.0F, -1.5F, 0.0F);
		Chignon_U = new ModchuModel_ModelRenderer(this, 0, 42);
		Chignon_U.addBox(-2F, -17.2F, 3F, 4, 4, 2, f);
		Chignon_U.setRotationPoint(0.0F, 8.0F, 0.0F);
		SideTailAug_RU = new ModchuModel_ModelRenderer(this, 32, 40);
		SideTailAug_RU.addBox(-2F, -0.5F, -1F, 2, 10, 2, f);
		SideTailAug_RU.setRotationPoint(-4.5F, -7.8F, 1.9F);
		SideTailAug_RB = new ModchuModel_ModelRenderer(this, 32, 52);
		SideTailAug_RB.addBox(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTailAug_RB.setRotationPoint(-1F, 9.5F, 1.0F);
		SideTailAug_LU = new ModchuModel_ModelRenderer(this, 40, 40);
		SideTailAug_LU.addBox(0.0F, -0.5F, -1F, 2, 10, 2, f);
		SideTailAug_LU.setRotationPoint(4.5F, -7.8F, 1.9F);
		SideTailAug_LB = new ModchuModel_ModelRenderer(this, 40, 52);
		SideTailAug_LB.addBox(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTailAug_LB.setRotationPoint(1.0F, 9.5F, 1.0F);
		SideTail_RBU = new ModchuModel_ModelRenderer(this, 48, 40);
		SideTail_RBU.addBox(-1F, -0.5F, -0.5F, 2, 10, 2, f);
		SideTail_RBU.setRotationPoint(-3F, -7.8F, 5F);
		SideTail_RBB = new ModchuModel_ModelRenderer(this, 48, 52);
		SideTail_RBB.addBox(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTail_RBB.setRotationPoint(0.0F, 9.5F, 1.5F);
		SideTail_LBU = new ModchuModel_ModelRenderer(this, 56, 40);
		SideTail_LBU.addBox(-1F, -0.5F, -0.5F, 2, 10, 2, f);
		SideTail_LBU.setRotationPoint(3F, -7.8F, 5F);
		SideTail_LBB = new ModchuModel_ModelRenderer(this, 56, 52);
		SideTail_LBB.addBox(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTail_LBB.setRotationPoint(0.0F, 9.5F, 1.5F);
		sidetailUpperR = new ModchuModel_ModelRenderer(this, 0, 32);
		sidetailUpperR.addBox(-4F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		sidetailUpperR.setRotationPoint(-3.5F, -9.5F, 1.9F);
		sidetailUpperL = new ModchuModel_ModelRenderer(this, 0, 37);
		sidetailUpperL.addBox(0.0F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		sidetailUpperL.setRotationPoint(3.5F, -9.5F, 1.9F);
		SideTailUpper_RB = new ModchuModel_ModelRenderer(this, 12, 32);
		SideTailUpper_RB.addBox(-4F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		SideTailUpper_RB.setRotationPoint(-3F, -9.5F, 3.5F);
		SideTailUpper_RB.setRotateAngleY(((float) Math.PI / 2F));
		SideTailUpper_LB = new ModchuModel_ModelRenderer(this, 12, 37);
		SideTailUpper_LB.addBox(0.0F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		SideTailUpper_LB.setRotationPoint(3F, -9.5F, 3.5F);
		SideTailUpper_LB.setRotateAngleY(-((float) Math.PI / 2F));
		Tail_T = new ModchuModel_ModelRenderer(this, 12, 42);
		Tail_T.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 3, f);
		Tail_T.setRotationPoint(0.0F, -8.3F, 4F);
		Tail_U = new ModchuModel_ModelRenderer(this, 8, 52);
		Tail_U.addBox(-1.5F, 0.0F, 0.0F, 3, 9, 3, f);
		Tail_U.setRotationPoint(0.0F, -6.8F, 4F);
		Tail_B = new ModchuModel_ModelRenderer(this, 20, 52);
		Tail_B.addBox(-1.5F, 0.0F, -3F, 3, 9, 3, f);
		Tail_B.setRotationPoint(0.0F, 9.0F, 3F);
		Headwear_F = new ModchuModel_ModelRenderer(this, 24, 16);
		Headwear_F.addPlate(-4F, 0.0F, 0.0F, 8, 4, 0, f);
		Headwear_F.setRotationPoint(0.0F, 0.0F, -4F);
		Headwear_B = new ModchuModel_ModelRenderer(this, 24, 20);
		Headwear_B.addPlate(-4F, 0.0F, 0.0F, 8, 4, 4, f);
		Headwear_B.setRotationPoint(0.0F, 0.0F, 4F);
		Headwear_R = new ModchuModel_ModelRenderer(this, 44, 0);
		Headwear_R.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 5, f);
		Headwear_R.setRotationPoint(-4F, 0.0F, 0.0F);
		Headwear_L = new ModchuModel_ModelRenderer(this, 44, 4);
		Headwear_L.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f);
		Headwear_L.setRotationPoint(4F, 0.0F, 0.0F);
		Shaggy_F = new ModchuModel_ModelRenderer(this, 34, 0);
		Shaggy_F.addPlate(-5F, 0.0F, 0.0F, 10, 4, 0, f);
		Shaggy_F.setRotationPoint(0.0F, -1.0F, -4F);
		Shaggy_F.setRotateAngleX(-0.4F);
		shaggyB = new ModchuModel_ModelRenderer(this, 24, 0);
		shaggyB.addPlate(-5F, 0.0F, 0.0F, 10, 4, 4, f);
		shaggyB.setRotationPoint(0.0F, -1.0F, 4F);
		shaggyB.setRotateAngleX(0.4F);
		shaggyR = new ModchuModel_ModelRenderer(this, 24, 4);
		shaggyR.addPlate(0.0F, 0.0F, -5F, 10, 4, 5, f);
		shaggyR.setRotationPoint(-4F, -1.0F, 0.0F);
		shaggyR.setRotateAngleZ(0.4F);
		shaggyL = new ModchuModel_ModelRenderer(this, 34, 4);
		shaggyL.addPlate(0.0F, 0.0F, -5F, 10, 4, 1, f);
		shaggyL.setRotationPoint(4F, -1.0F, 0.0F);
		shaggyL.setRotateAngleZ(-0.4F);
		LongHair_F = new ModchuModel_ModelRenderer(this, 34, 32);
		LongHair_F.addPlate(-5F, 0.0F, 0.0F, 10, 8, 4, f);
		LongHair_F.setRotationPoint(0.0F, -1.0F, -4F);
		LongHair_F.setRotateAngleY((float) Math.PI);
		LongHair_F.setRotateAngleX(0.202458F);
		LongHair_B = new ModchuModel_ModelRenderer(this, 24, 32);
		LongHair_B.addPlate(-5F, 0.0F, 0.0F, 10, 8, 4, f);
		LongHair_B.setRotationPoint(0.0F, -1.0F, 4F);
		LongHair_B.setRotateAngleX(0.202458F);
		LongHair_R = new ModchuModel_ModelRenderer(this, 44, 32);
		LongHair_R.addPlate(0.0F, 0.0F, -5F, 10, 8, 5, f);
		LongHair_R.setRotationPoint(-4F, -1.0F, 0.0F);
		LongHair_R.setRotateAngleZ(0.202458F);
		LongHair_L = new ModchuModel_ModelRenderer(this, 54, 32);
		LongHair_L.addPlate(0.0F, 0.0F, -5F, 10, 8, 1, f);
		LongHair_L.setRotationPoint(4F, -1.0F, 0.0F);
		LongHair_L.setRotateAngleZ(-0.202458F);
		sensor1 = new ModchuModel_ModelRenderer(this, 0, 0);
		sensor1.addPlate(-8F, -4F, -8.0F, 8, 4, 0, f);
		sensor1.setRotationPoint(-5.0F, -7.0F, 4.0F);
		sensor2 = new ModchuModel_ModelRenderer(this, 0, 4);
		sensor2.addPlate(0.0F, -4F, 0.0F, 8, 4, 0, f);
		sensor2.setRotationPoint(0.0F, -8.0F, 0.0F);
		sensor3 = new ModchuModel_ModelRenderer(this, 0, 20);
		sensor3.addPlate(0.0F, -4F, -0F, 8, 4, 1, f);
		sensor3.setRotationPoint(0.0F, -8.0F, 0.0F);
		sensor4 = new ModchuModel_ModelRenderer(this, 0, 16);
		sensor4.addPlate(0.0F, -4F, -8F, 8, 4, 1, f);
		sensor4.setRotationPoint(0.0F, -8.0F, 0.0F);
		eyeR = new ModchuModel_ModelRenderer(this, 42, 19);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModchuModel_ModelRenderer(this, 46, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Cheek_R = new ModchuModel_ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPoint(0.0F, 1.0F, 0.0F);
		Cheek_L = new ModchuModel_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPoint(0.0F, 1.0F, 0.0F);
		Breast1 = new ModchuModel_ModelRenderer(this, 17, 49);
		Breast1.addBox(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
		Breast1.setRotationPoint(0.0F, -2.5F, -2F);
		Breast1.setRotateAngleZ(((float) Math.PI / 2F));
		Breast1.setRotateAngleY(0.4363323F);
		Breast2 = new ModchuModel_ModelRenderer(this, 56, 16);
		Breast2.addBox(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
		Breast2.setRotationPoint(0.0F, -2.5F, -2F);
		Breast2.setRotateAngleZ(((float) Math.PI / 2F));
		Breast2.setRotateAngleY(((float) Math.PI * 2F / 9F));
		mainFrame = new ModchuModel_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		textureWidth = 64;
		textureHeight = 64;
		super.skirtFloatsInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(Tail);
		bipedHead.addChild(ChignonAug_R);
		bipedHead.addChild(ChignonAug_L);
		bipedHead.addChild(Chignon_RB);
		bipedHead.addChild(Chignon_LB);
		bipedHead.addChild(Chignon_U);
		bipedHead.addChild(SideTailAug_RU);
		bipedHead.addChild(SideTailAug_LU);
		SideTailAug_RU.addChild(SideTailAug_RB);
		SideTailAug_LU.addChild(SideTailAug_LB);
		bipedHead.addChild(SideTail_RBU);
		bipedHead.addChild(SideTail_LBU);
		SideTail_RBU.addChild(SideTail_RBB);
		SideTail_LBU.addChild(SideTail_LBB);
		bipedHead.addChild(sidetailUpperR);
		bipedHead.addChild(sidetailUpperL);
		bipedHead.addChild(SideTailUpper_LB);
		bipedHead.addChild(SideTailUpper_RB);
		bipedHead.addChild(Tail_T);
		bipedHead.addChild(Tail_U);
		Tail_U.addChild(Tail_B);
		bipedHead.addChild(Headwear_F);
		bipedHead.addChild(Headwear_B);
		bipedHead.addChild(Headwear_R);
		bipedHead.addChild(Headwear_L);
		bipedHead.addChild(Shaggy_F);
		bipedHead.addChild(shaggyB);
		bipedHead.addChild(shaggyR);
		bipedHead.addChild(shaggyL);
		bipedHead.addChild(LongHair_F);
		bipedHead.addChild(LongHair_B);
		bipedHead.addChild(LongHair_R);
		bipedHead.addChild(LongHair_L);
		bipedHead.addChild(sensor1);
		bipedHead.addChild(sensor2);
		bipedHead.addChild(sensor3);
		bipedHead.addChild(sensor4);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
		bipedBody.addChild(Breast1);
		bipedBody.addChild(Breast2);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			Cheek_R.setVisible(true);
			Cheek_L.setVisible(true);
		} else {
			Cheek_R.setVisible(false);
			Cheek_L.setVisible(false);
		}
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = (float)ticksExisted + f2 + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		float f4 = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			f3 *= 8.0F;
			f4 = -0.2F;
		} else {
			f4 = (1F - Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_healthFloat) / 20F) * 0.5F;
		}
		sensor1.rotateAngleX = 0.0F;
		sensor1.rotateAngleY = -((float) Math.PI * 2F / 9F);
		sensor1.rotateAngleZ = mh_sin(f3 * 0.067F) * 0.05F - f4;
		sensor2.rotateAngleX = sensor2.rotateAngleZ = -(mh_sin(f3 * 0.067F) * 0.05F - f4);
		sensor2.rotateAngleY = ((float) Math.PI * 2F / 9F);
		sensor3.rotateAngleX = (mh_sin(f3 * 0.067F) * 0.05F + 0.370796F) - f4;
		sensor3.rotateAngleY = mh_sin(f3 * 0.09F) * 0.4F;
		sensor3.rotateAngleZ = mh_cos(f3 * 0.09F) * 0.2F;
		sensor4.rotateAngleX = mh_sin(f3 * 0.067F) * 0.05F + f4;
		sensor4.rotateAngleY = mh_cos(f3 * 0.09F) * 0.5F;
		sensor4.rotateAngleZ = mh_sin(f3 * 0.09F) * 0.2F;
	}	@Override	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		Breast1.setRotationPoint(0.0F, -2.5F, -2F);		Breast2.setRotationPoint(0.0F, -2.5F, -2F);	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		SideTailR.rotateAngleX = SideTailL.rotateAngleX = 0.0F;
		sensor1.rotationPointY = -8.0F;
		if (bipedHead.getRotateAngleX() < 0.0F) {
			SideTailAug_RU.setRotateAngleX(-bipedHead.getRotateAngleX());
			SideTailAug_LU.setRotateAngleX(-bipedHead.getRotateAngleX());
			SideTailAug_RB.setRotateAngleX(0.0F);
			SideTailAug_LB.setRotateAngleX(0.0F);
			SideTail_RBU.setRotateAngleX(-bipedHead.getRotateAngleX());
			SideTail_LBU.setRotateAngleX(-bipedHead.getRotateAngleX());
			SideTail_RBB.setRotateAngleX(0.0F + Skirt.getRotateAngleX());
			SideTail_LBB.setRotateAngleX(0.0F + Skirt.getRotateAngleX());
			Tail_U.setRotateAngleX(-bipedHead.getRotateAngleX());
			Tail_B.setRotateAngleX(0.0F + Skirt.getRotateAngleX());
		} else {
			SideTailAug_RU.setRotateAngleX(0.0F);
			SideTailAug_LU.setRotateAngleX(0.0F);
			SideTailAug_RB.setRotateAngleX(-bipedHead.getRotateAngleX() + Skirt.getRotateAngleX());
			SideTailAug_LB.setRotateAngleX(-bipedHead.getRotateAngleX() + Skirt.getRotateAngleX());
			SideTail_RBU.setRotateAngleX(0.0F);
			SideTail_LBU.setRotateAngleX(0.0F);
			SideTail_RBB.setRotateAngleX(-bipedHead.getRotateAngleX() + Skirt.getRotateAngleX());
			SideTail_LBB.setRotateAngleX(-bipedHead.getRotateAngleX() + Skirt.getRotateAngleX());
			Tail_U.setRotateAngleX(0.0F);
			Tail_B.setRotateAngleX(-bipedHead.getRotateAngleX() + Skirt.getRotateAngleX());
		}
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"Cheek_R", "Cheek_L"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
		String[] s1 = {
				"ChignonAug_R", "ChignonAug_L", "SideTailAug_RU", "SideTailAug_RB", "SideTailAug_LU",
				"SideTailAug_LB", "SideTail_RBU", "SideTail_RBB", "SideTail_LBU", "SideTail_LBB",
				"SideTailUpper_LB", "SideTailUpper_RB"
		};
		String[] s2 = {
				"ChignonA_R", "ChignonA_L", "SideTA_RU", "SideTA_RB", "SideTA_LU",
				"SideTA_LB", "SideT_RBU", "SideT_RBB", "SideT_LBU", "SideT_LBB",
				"SideTU_LB", "SideTU_RB"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}
}