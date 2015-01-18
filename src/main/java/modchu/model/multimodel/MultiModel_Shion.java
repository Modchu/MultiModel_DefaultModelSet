package modchu.model.multimodel;import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModel;public class MultiModel_Shion extends MultiModel {	public Modchu_ModelRenderer longtail;
	public Modchu_ModelRenderer Headwear;
	public Modchu_ModelRenderer HeadwearR;
	public Modchu_ModelRenderer HeadwearL;
	public Modchu_ModelRenderer SkirtR;
	public Modchu_ModelRenderer SkirtL;
	public Modchu_ModelRenderer obi;
	public Modchu_ModelRenderer sodeR;
	public Modchu_ModelRenderer sodeL;
	public Modchu_ModelRenderer WsodeR;
	public Modchu_ModelRenderer WsodeL;
	public Modchu_ModelRenderer kanzasi;
	public Modchu_ModelRenderer osageL1;
	public Modchu_ModelRenderer osageL2;
	public Modchu_ModelRenderer osageL3;
	public Modchu_ModelRenderer osageL4;
	public Modchu_ModelRenderer osageR1;
	public Modchu_ModelRenderer osageR2;
	public Modchu_ModelRenderer osageR3;
	public Modchu_ModelRenderer osageR4;
	public Modchu_ModelRenderer osageLRib;
	public Modchu_ModelRenderer eyeL;
	public Modchu_ModelRenderer eyeR;
	private boolean sneakSkirt;	public MultiModel_Shion() {
		this(0.0F);
	}	public MultiModel_Shion(float f) {
		this(f, 0.0F);
	}	public MultiModel_Shion(float f, float f1) {
		this(f, f1, 64, 32);
	}	public MultiModel_Shion(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		super.initModel(f, f1, false);
		longtail = new Modchu_ModelRenderer(this, 46, 19);
		longtail.addBox(-1F, 0.0F, 2.0F, 2, 12, 1, f + 0.2F);
		longtail.setRotationPoint(0.0F, -6.5F, 5F);
		SideTailR = new Modchu_ModelRenderer(this, 24, 0);
		SideTailR.addBox(-4.2F, -5.5F, -4.1F, 1, 6, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new Modchu_ModelRenderer(this, 24, 0);
		SideTailL.mirror = true;
		SideTailL.addBox(3.2F, -5.5F, -4.1F, 1, 6, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Headwear = new Modchu_ModelRenderer(this, 52, 16);
		Headwear.addBox(-1.5F, 0.0F, -3F, 3, 8, 3, f);
		Headwear.setRotationPoint(0.0F, -1F, 4F);
		HeadwearR = new Modchu_ModelRenderer(this, 52, 16);
		HeadwearR.addBox(-4F, 0.0F, -3F, 3, 6, 3, f);
		HeadwearR.setRotationPoint(0.0F, -1F, 4F);
		HeadwearL = new Modchu_ModelRenderer(this, 52, 16);
		HeadwearL.addBox(1.0F, 0.0F, -3F, 3, 6, 3, f);
		HeadwearL.setRotationPoint(0.0F, -1F, 4F);
		SkirtR = new Modchu_ModelRenderer(this, 0, 18);
		SkirtR.addBox(-3F, -1F, -3F, 4, 8, 6, f + 0.01F);
		SkirtR.setRotationPoint(0.5F, 0.0F, 0.0F);
		SkirtL = new Modchu_ModelRenderer(this, 12, 18);
		SkirtL.addBox(-1F, -1F, -3F, 4, 8, 6, f + 0.01F);
		SkirtL.setRotationPoint(-0.5F, 0.0F, 0.0F);
		obi = new Modchu_ModelRenderer(this, 52, 27);
		obi.addBox(-2.5F, 2.0F, 1.5F, 5, 4, 1, f);
		obi.setRotationPoint(0.0F, -3.5F, 0.0F);
		sodeR = new Modchu_ModelRenderer(this, 36, 0);
		sodeR.addBox(-2F, -1F, -1F, 4, 6, 2, f + 0.1F);
		sodeR.setRotationPoint(1.0F, 1.5F, 0.0F);
		sodeL = new Modchu_ModelRenderer(this, 36, 0);
		sodeL.addBox(-2F, -1F, -1F, 4, 6, 2, f + 0.1F);
		sodeL.setRotationPoint(-1.0F, 1.5F, 0.0F);
		WsodeR = new Modchu_ModelRenderer(this, 36, 0);
		WsodeR.addBox(-2F, -1F, 1.0F, 2, 6, 2, f);
		WsodeR.setRotationPoint(1.0F, 1.5F, 0.0F);
		WsodeL = new Modchu_ModelRenderer(this, 36, 0);
		WsodeL.addBox(0.0F, -1F, 1.0F, 2, 6, 2, f);
		WsodeL.setRotationPoint(-1.0F, 1.5F, 0.0F);
		kanzasi = new Modchu_ModelRenderer(this, 0, 16);
		kanzasi.addBox(-7F, -8F, 5F, 1, 7, 1, f);
		kanzasi.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		setCapsValue(null, caps_visible, Skirt, false);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(bipedHeadwear);
		bipedHead.removeChild(Tail);
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.addChild(longtail);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(SideTailL);
		bipedHead.addChild(Headwear);
		bipedHead.addChild(HeadwearR);
		bipedHead.addChild(HeadwearL);
		bipedRightLeg.addChild(SkirtR);
		bipedLeftLeg.addChild(SkirtL);
		bipedBody.removeChild(Skirt);		bipedBody.addChild(obi);
		bipedRightArm.addChild(sodeR);
		bipedLeftArm.addChild(sodeL);
		bipedRightArm.addChild(WsodeR);
		bipedLeftArm.addChild(WsodeL);
		bipedHead.addChild(kanzasi);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		sodeL.rotationPointY = 0.0F;
		sodeR.rotationPointY = 0.0F;
		SkirtR.rotationPointY = SkirtL.rotationPointY = 0.0F;
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		bipedRightLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F) * 1.4F * f1) / 1.5F;
		bipedLeftLeg.rotateAngleX = (Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f * 0.6662F + 3.141593F) * 1.4F * f1) / 1.5F;
		setCapsValue(entityCaps, caps_visible, sodeL, true);
		setCapsValue(entityCaps, caps_visible, sodeR, true);
		setCapsValue(entityCaps, caps_visible, WsodeL, false);
		setCapsValue(entityCaps, caps_visible, WsodeR, false);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			bipedRightLeg.rotateAngleY = 0.0F;
			bipedLeftLeg.rotateAngleY = 0.0F;
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		boolean modchuRemodelingModel = Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_modchuRemodelingModel);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			if (!modchuRemodelingModel) {
				bipedRightLeg.rotateAngleX -= 0.5F;
				bipedLeftLeg.rotateAngleX -= 0.5F;
			}
			if (modchuRemodelingModel) {
				if (!sneakSkirt) {
					sneakSkirt = true;
					bipedRightLeg.removeChild(SkirtR);
					bipedLeftLeg.removeChild(SkirtL);
					mainFrame.addChild(SkirtR);
					mainFrame.addChild(SkirtL);
				}
				SkirtR.setRotationPoint(-1.0F, 7.3F, 0.0F);
				SkirtL.setRotationPoint(1.0F, 7.3F, 0.0F);
			}
		} else {
			if (modchuRemodelingModel && sneakSkirt) {
				sneakSkirt = false;
				((Modchu_ModelRenderer) mainFrame).removeChild(SkirtR);
				((Modchu_ModelRenderer) mainFrame).removeChild(SkirtL);
				bipedRightLeg.addChild(SkirtR);
				bipedLeftLeg.addChild(SkirtL);
				SkirtR.setRotationPoint(0.5F, 0.0F, 0.0F);
				SkirtL.setRotationPoint(-0.5F, 0.0F, 0.0F);
			}
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsWait) && !Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			setCapsValue(entityCaps, caps_visible, sodeL, false);
			setCapsValue(entityCaps, caps_visible, sodeR, false);
			setCapsValue(entityCaps, caps_visible, WsodeL, true);
			setCapsValue(entityCaps, caps_visible, WsodeR, true);
		}
		ChignonB.rotateAngleX = 0.0873F;
		Headwear.rotationPointY = -1F;
		Headwear.rotationPointZ = 4F;
		HeadwearR.rotationPointY = HeadwearL.rotationPointY = -2F;
		HeadwearR.rotationPointZ = HeadwearL.rotationPointZ = 4F;
		longtail.rotationPointY = -6F;
		longtail.rotationPointZ = 3.5F;
		Headwear.rotateAngleX = HeadwearR.rotateAngleX = longtail.rotateAngleX = HeadwearL.rotateAngleX = bipedHead.rotateAngleX <= 0.0F ? -bipedHead.rotateAngleX : -bipedHead.rotateAngleX / 2.0F;
		longtail.rotateAngleY = mh_sin(f2 * 0.05F) * 0.06F;
		kanzasi.rotateAngleX = -0.175F;
		kanzasi.rotateAngleY = -0.175F;
		kanzasi.rotateAngleZ = 1.396F;
		obi.rotateAngleX = 0.0873F;
		if (modchuRemodelingModel) {
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
				upperBody.rotateAngleX = 0.0F;
				bipedHead.rotateAngleX += 0.5F;
				bipedHead.rotationPointZ = 0.0F;
				bipedBody.rotationPointZ = 0.0F;
				bipedRightLeg.rotationPointZ =
				bipedLeftLeg.rotationPointZ = 0.0F;
				if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
					bipedRightArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
					bipedRightArm.rotateAngleY = 0.0F;
					bipedRightArm.rotateAngleZ = -0.4F;
					bipedLeftArm.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f2 * 0.067F) * 0.05F - 0.7F;
					bipedLeftArm.rotateAngleY = 0.0F;
					bipedLeftArm.rotateAngleZ = 0.4F;
					bipedRightArm.rotationPointZ = 0.0F;
					bipedLeftArm.rotationPointZ = 0.0F;
					setCapsValue(entityCaps, caps_visible, sodeL, false);
					setCapsValue(entityCaps, caps_visible, sodeR, false);
					setCapsValue(entityCaps, caps_visible, WsodeL, true);
					setCapsValue(entityCaps, caps_visible, WsodeR, true);
				} else {
					bipedRightArm.rotateAngleX = -2.2F;
					bipedRightArm.rotateAngleY = -1.0F;
					bipedRightArm.rotateAngleZ = 2.0F;
					bipedLeftArm.rotateAngleX = 1.9F;
					bipedLeftArm.rotateAngleY = 2.0F;
					bipedLeftArm.rotateAngleZ = 2.3F;
				}
			} else {
				bipedHead.rotationPointZ = 0.0F;
				bipedBody.rotationPointZ = 0.0F;
				bipedRightArm.rotationPointZ = 0.0F;
				bipedLeftArm.rotationPointZ = 0.0F;
			}
			if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
				Object entity = entityCaps.getCapsValue(entityCaps.caps_Entity);
				if (entity != null && Modchu_Reflect.getFieldObject("Entity", "field_70154_o", "ridingEntity", entity) != null) {
					bipedRightArm.rotateAngleX += -0.6283185F;
					bipedLeftArm.rotateAngleX += -0.6283185F;
					bipedRightLeg.rotateAngleX = -1.256637F;
					bipedLeftLeg.rotateAngleX = -1.256637F;
					bipedRightLeg.rotateAngleY = 0.3141593F;
					bipedLeftLeg.rotateAngleY = -0.3141593F;
				} else {
					bipedRightLeg.rotateAngleX = bipedLeftLeg.rotateAngleX = 1.570796313F;
					bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 6.0F;
					bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = -2.0F;
				}
			}
		}
		boolean eyeFlag = true;
		Object itemstack = getCapsValue(entityCaps, caps_currentArmor, 3);
		if (itemstack != null) {
			int addSupport = addSupportChecks(entityCaps, itemstack, 1);
			if (addSupport == 3 |
					addSupport == 4) eyeFlag = false;
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			if (eyeFlag) {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			}
		} else {
			if (!eyeFlag
					| (eyeFlag
							&& 0.0D > (mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D)) {
				setCapsValue(entityCaps, caps_visible, eyeL, false);
				setCapsValue(entityCaps, caps_visible, eyeR, false);
			} else {
				setCapsValue(entityCaps, caps_visible, eyeL, true);
				setCapsValue(entityCaps, caps_visible, eyeR, true);
			}
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_actionFlag)) {
			setCapsValue(entityCaps, caps_visible, sodeL, true);
			setCapsValue(entityCaps, caps_visible, sodeR, true);
			setCapsValue(entityCaps, caps_visible, WsodeL, false);
			setCapsValue(entityCaps, caps_visible, WsodeR, false);
		}
		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void actionPartsAddChild() {
		super.actionPartsAddChild();
		setCapsValue(null, caps_visible, sodeL, false);
		setCapsValue(null, caps_visible, sodeR, false);
		setCapsValue(null, caps_visible, WsodeL, false);
		setCapsValue(null, caps_visible, WsodeR, false);
		bipedRightArm.removeChild(sodeR);
		bipedLeftArm.removeChild(sodeL);
		bipedRightArm.removeChild(WsodeR);
		bipedLeftArm.removeChild(WsodeL);
		rightArm.addChild(sodeR);
		leftArm.addChild(sodeL);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		bipedRightArm.removeChild(sodeR);
		bipedLeftArm.removeChild(sodeL);
		sodeL.rotationPointY = -0.5F;
		sodeR.rotationPointY = -0.5F;
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
		bipedRightArm.removeChild(sodeR);
		bipedLeftArm.removeChild(sodeL);
		sodeL.rotationPointY = -0.5F;
		sodeR.rotationPointY = -0.5F;
		SkirtR.rotationPointY = SkirtL.rotationPointY = Skirt.rotationPointY - 18.0F;
	}	@Override
	public String getUsingTexture() {
		return null;
	}
}