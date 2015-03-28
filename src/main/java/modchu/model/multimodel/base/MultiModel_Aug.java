package modchu.model.multimodel.base;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_EntityCapsHelper;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;public class MultiModel_Aug extends MultiModel_SR2 {	public ModchuModel_ModelRenderer sidetailUpperR;
	public ModchuModel_ModelRenderer sidetailUpperL;	public ModchuModel_ModelRenderer shaggyB;
	public ModchuModel_ModelRenderer shaggyR;
	public ModchuModel_ModelRenderer shaggyL;	public ModchuModel_ModelRenderer sensor1;
	public ModchuModel_ModelRenderer sensor2;
	public ModchuModel_ModelRenderer sensor3;
	public ModchuModel_ModelRenderer sensor4;	public MultiModel_Aug() {
		this(0.0F);
	}	public MultiModel_Aug(float f) {
		this(f, 0.0F);
	}	public MultiModel_Aug(float f, float f1) {
		this(f, f1 , 64, 32);
	}	public MultiModel_Aug(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);		// 再構成パーツ
		ChignonR = new ModchuModel_ModelRenderer(this, 0, 18, "ChignonR");
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, -1.5F, 0.0F);
		SideTailR = new ModchuModel_ModelRenderer(this, "SideTailR");
		SideTailR.setTextureOffset(46, 20).addBox(-1.5F, -0.5F, -1.0F, 2, 10, 2, f);
		SideTailR.setRotationPoint(-5F, -7.8F, 1.9F);
		SideTailL = new ModchuModel_ModelRenderer(this, "SideTailL");
		SideTailL.setTextureOffset(54, 20).addBox(0.5F, -0.5F, -1.0F, 2, 10, 2, f);
		SideTailL.setRotationPoint(4.0F, -7.8F, 1.9F);		// 増加パーツ
		shaggyB = new ModchuModel_ModelRenderer(this, 24, 0, "shaggyB");
		shaggyB.addPlate(-5.0F, 0.0F, 0.0F, 10, 4, 4, f);
		shaggyB.setRotationPoint(0.0F, -1.0F, 4.0F);
		shaggyB.setRotateAngleX(0.4F);
		shaggyR = new ModchuModel_ModelRenderer(this, 34, 4, "shaggyR");
		shaggyR.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 1, f);
		shaggyR.setRotationPoint(4.0F, -1.0F, 0.0F);
		shaggyR.setRotateAngleZ(-0.4F);
		shaggyL = new ModchuModel_ModelRenderer(this, 24, 4, "shaggyL");
		shaggyL.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 5, f);
		shaggyL.setRotationPoint(-4.0F, -1.0F, 0.0F);
		shaggyL.setRotateAngleZ(0.4F);		sensor1 = new ModchuModel_ModelRenderer(this, 0, 0, "sensor1");
		sensor1.addPlate(-8.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor1.setRotationPoint(0.0F, -8.0F, 0.0F);
		sensor2 = new ModchuModel_ModelRenderer(this, 0, 4, "sensor2");
		sensor2.addPlate(0.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor2.setRotationPoint(0.0F, -8.0F, 0.0F);
		sensor3 = new ModchuModel_ModelRenderer(this, 44, 0, "sensor3");
		sensor3.addPlate(0.0F, -7.0F, -4.0F, 4, 8, 1);
		sensor3.setRotationPoint(0.0F, -8.0F, 0.0F);
		sensor4 = new ModchuModel_ModelRenderer(this, 34, 0, "sensor4");
		sensor4.addPlate(0.0F, -4.0F, -10.0F, 10, 4, 1);
		sensor4.setRotationPoint(0.0F, -8.0F, 0.0F);		sidetailUpperR = new ModchuModel_ModelRenderer(this, 52, 10, "sidetailUpperR");
		sidetailUpperR.addBox(-4.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperR.setRotationPoint(1.2F, -1.5F, 0.0F);
		sidetailUpperL = new ModchuModel_ModelRenderer(this, 52, 15, "sidetailUpperL");
		sidetailUpperL.addBox(0.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperL.setRotationPoint(-0.5F, -1.5F, 0.0F);
		ChignonL.setRotationPoint(0.0F, -1.5F, 0.0F);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(ChignonB);
		if (shaggyB != null
				&& !shaggyB.cubeList.isEmpty()) bipedHead.addChild(shaggyB);
		if (shaggyR != null
				&& !shaggyR.cubeList.isEmpty()) bipedHead.addChild(shaggyR);
		if (shaggyL != null
				&& !shaggyL.cubeList.isEmpty()) bipedHead.addChild(shaggyL);
		if (sensor1 != null
				&& !sensor1.cubeList.isEmpty()) bipedHead.addChild(sensor1);
		if (sensor2 != null
				&& !sensor2.cubeList.isEmpty()) bipedHead.addChild(sensor2);
		if (sensor3 != null
				&& !sensor3.cubeList.isEmpty()) bipedHead.addChild(sensor3);
		if (sensor4 != null
				&& !sensor4.cubeList.isEmpty()) bipedHead.addChild(sensor4);
		if (sidetailUpperR != null
				&& !sidetailUpperR.cubeList.isEmpty()) SideTailR.addChild(sidetailUpperR);
		if (sidetailUpperL != null
				&& !sidetailUpperL.cubeList.isEmpty()) SideTailL.addChild(sidetailUpperL);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
		Object entityliving = entityCaps.getCapsValue(entityCaps.caps_Entity);
		if (entityliving != null); else return;		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = ticksExisted + renderPartialTicks + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		float f4 = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			f3 *= 8.0F;
			f4 = -0.2F;
		} else {
			f4 = (1F - Modchu_CastHelper.Float(entityCaps.getCapsValue(caps_health), false) / 20F) * 0.5F;
		}
		float f5 = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.067F) * 0.05F - f4;
		float f6 = 40.0F / 57.29578F;
		sensor1.setRotateAngle(f5, -f6, f5);
		sensor2.setRotateAngle(-f5, f6, -f5);
		sensor3.setRotateAngle(Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.067F) * 0.05F - 1.2F - f4, Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.09F) * 0.4F, Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f3 * 0.09F) * 0.2F);
		sensor4.setRotateAngle(Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.067F) * 0.05F + f4, Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f3 * 0.09F) * 0.5F, Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f3 * 0.09F) * 0.2F);
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
		SideTailR.rotateAngleX = SideTailL.rotateAngleX = -bipedHead.rotateAngleX / 1.5F;
		float y = -8.0F;
		sensor1.rotationPointY = sensor2.rotationPointY = sensor3.rotationPointY = sensor4.rotationPointY = y;
		y = -1.0F;
		shaggyB.rotationPointY = shaggyR.rotationPointY = shaggyL.rotationPointY = y;
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s1 = {
				"sidetailUpperR", "sidetailUpperL"
		};
		String[] s2 = {
				"s_tailUR", "s_tailUL"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}
}