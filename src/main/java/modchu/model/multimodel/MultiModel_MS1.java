package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelPlate;
import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_MS1 extends MultiModel_SR2 {
	public Modchu_ModelRenderer Goggles1;
	public Modchu_ModelRenderer Goggles2;
	public Modchu_ModelRenderer Goggles3;
	public Modchu_ModelRenderer GogglesR;
	public Modchu_ModelRenderer GogglesL;
	public Modchu_ModelRenderer Goggles1A;
	public Modchu_ModelRenderer Goggles2A;
	public Modchu_ModelRenderer Goggles3A;
	public Modchu_ModelRenderer GogglesRA;
	public Modchu_ModelRenderer GogglesLA;
	public Modchu_ModelRenderer Cheek_R;
	public Modchu_ModelRenderer Cheek_L;	public MultiModel_MS1() {
		this(0.0F);
	}	public MultiModel_MS1(float f) {
		this(f, 0.0F);
	}	public MultiModel_MS1(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_MS1(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		super.initModel(f, f1, false);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-3.5F, -2F, -3F, 7, 7, 6, f);
		Skirt.setRotationPoint(0.0F, 7F + f1, 0.0F);
		Goggles1A = new Modchu_ModelRenderer(this, 0, 32);
		Goggles1A.addBox(-4F, -5.5F, -5F, 8, 4, 1, f);
		Goggles1A.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles2A = new Modchu_ModelRenderer(this, 0, 37);
		Goggles2A.addBox(-4F, -4F, -6F, 8, 1, 1, f);
		Goggles2A.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles3A = new Modchu_ModelRenderer(this, 0, 39);
		Goggles3A.addBox(-3.5F, -5.5F, -5.5F, 7, 4, 1, f);
		Goggles3A.setRotationPoint(0.0F, 0.0F, 0.0F);
		GogglesRA = new Modchu_ModelRenderer(this, 0, 44);
		GogglesRA.addBox(-5.1F, -4.5F, -5F, 1, 2, 3, f);
		GogglesRA.setRotationPoint(0.0F, 0.0F, 0.0F);
		GogglesLA = new Modchu_ModelRenderer(this, 0, 44);
		GogglesLA.mirror = true;
		GogglesLA.addBox(4.1F, -4.5F, -5F, 1, 2, 3, f);
		GogglesLA.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles1 = new Modchu_ModelRenderer(this, 0, 32);
		Goggles1.addBox(-4F, -7F, -7.3F, 8, 4, 1, f + 0.1F);
		Goggles1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles1.setRotateAngleX(-0.4886921F);
		Goggles2 = new Modchu_ModelRenderer(this, 0, 37);
		Goggles2.addBox(-4F, -5.5F, -8.3F, 8, 1, 1, f);
		Goggles2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles2.setRotateAngleX(-0.4886921F);
		Goggles3 = new Modchu_ModelRenderer(this, 0, 39);
		Goggles3.addBox(-3.5F, -7F, -7.8F, 7, 4, 1, f + 0.1F);
		Goggles3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Goggles3.setRotateAngleX(-0.4886921F);
		GogglesR = new Modchu_ModelRenderer(this, 0, 44);
		GogglesR.addBox(-5.1F, -5.5F, -7F, 1, 2, 3, f);
		GogglesR.setRotationPoint(0.0F, 0.0F, 0.0F);
		GogglesR.setRotateAngleX(-0.4886921F);
		GogglesL = new Modchu_ModelRenderer(this, 0, 44);
		GogglesL.mirror = true;
		GogglesL.addBox(4.1F, -5.5F, -7F, 1, 2, 3, f);
		GogglesL.setRotationPoint(0.0F, 0.0F, 0.0F);
		GogglesL.setRotateAngleX(-0.4886921F);
		Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPoint(0.0F, 1.0F, 0.0F);
		Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedHead.removeChild(eyeR);
		bipedHead.removeChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 0, 0);
		eyeR.addPlate(-4F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 4, 0);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		setCapsValue(null, caps_visible, Tail, false);
		setCapsValue(null, caps_visible, SideTailR, false);
		setCapsValue(null, caps_visible, SideTailL, false);
		setCapsValue(null, caps_visible, ChignonR, false);
		setCapsValue(null, caps_visible, ChignonL, false);
		setCapsValue(null, caps_visible, ChignonB, false);
		setCapsValue(null, caps_visible, Goggles1, true);
		setCapsValue(null, caps_visible, Goggles2, true);
		setCapsValue(null, caps_visible, Goggles3, true);
		setCapsValue(null, caps_visible, GogglesR, true);
		setCapsValue(null, caps_visible, GogglesL, true);
		setCapsValue(null, caps_visible, Goggles1A, false);
		setCapsValue(null, caps_visible, Goggles2A, false);
		setCapsValue(null, caps_visible, Goggles3A, false);
		setCapsValue(null, caps_visible, GogglesRA, false);
		setCapsValue(null, caps_visible, GogglesLA, false);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(Goggles1A);
		bipedHead.addChild(Goggles2A);
		bipedHead.addChild(Goggles3A);
		bipedHead.addChild(GogglesRA);
		bipedHead.addChild(GogglesLA);
		bipedHead.addChild(Goggles1);
		bipedHead.addChild(Goggles2);
		bipedHead.addChild(Goggles3);
		bipedHead.addChild(GogglesR);
		bipedHead.addChild(GogglesL);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		textureWidth = 64;
		textureHeight = 64;
		//ふんわりスカート上
		SkirtTop = new Modchu_ModelRenderer(this, 6, 16);
		SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 7, 6, ModchuModel_ModelPlate.planeXZTop);
		SkirtTop.setRotationPoint(-3.5F, -2.0F, -3.0F);		//ふんわりスカート前
		SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 7, 7, ModchuModel_ModelPlate.planeXYFront);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート右
		SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
		SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 6, 7, ModchuModel_ModelPlate.planeZYRight);
		SkirtRight.setRotationPoint(7.0F, 0.0F, 0.0F);		//ふんわりスカート左
		SkirtLeft = new Modchu_ModelRenderer(this, 13, 22);
		SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 6, 7, ModchuModel_ModelPlate.planeZYLeft);
		SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);		//ふんわりスカート後ろ
		SkirtBack = new Modchu_ModelRenderer(this, 18, 22);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 7, 7, ModchuModel_ModelPlate.planeXYBack);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 6.0F);
		setCapsValue(null, caps_visible, Skirt, false);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) {
			setCapsValue(entityCaps, caps_visible, Cheek_R, true);
			setCapsValue(entityCaps, caps_visible, Cheek_L, true);
		} else {
			setCapsValue(entityCaps, caps_visible, Cheek_R, false);
			setCapsValue(entityCaps, caps_visible, Cheek_L, false);
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, eyeR, false);
			setCapsValue(entityCaps, caps_visible, eyeL, true);
		}
		Skirt.rotationPointY -= 3.0F;
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"Cheek_R", "Cheek_L"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
	}	@Override
	public void defaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {
		int i = Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_armorType);
		//GogglesA Default off
		setCapsValue(entityCaps, caps_defaultShowPartsMap, "GogglesA", i, false);
	}	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
		setCapsValue(entityCaps, caps_visible, Tail, false);
		setCapsValue(entityCaps, caps_visible, SideTailR, false);
		setCapsValue(entityCaps, caps_visible, SideTailL, false);
		setCapsValue(entityCaps, caps_visible, ChignonR, false);
		setCapsValue(entityCaps, caps_visible, ChignonL, false);
		setCapsValue(entityCaps, caps_visible, ChignonB, false);
		setCapsValue(entityCaps, caps_visible, Goggles1, true);
		setCapsValue(entityCaps, caps_visible, Goggles2, true);
		setCapsValue(entityCaps, caps_visible, Goggles3, true);
		setCapsValue(entityCaps, caps_visible, GogglesR, true);
		setCapsValue(entityCaps, caps_visible, GogglesL, true);
		setCapsValue(entityCaps, caps_visible, Goggles1A, false);
		setCapsValue(entityCaps, caps_visible, Goggles2A, false);
		setCapsValue(entityCaps, caps_visible, Goggles3A, false);
		setCapsValue(entityCaps, caps_visible, GogglesRA, false);
		setCapsValue(entityCaps, caps_visible, GogglesLA, false);
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
		Skirt.rotationPointY -= 2.0F;
	}
}