package modchu.model.multimodel.base;
	public ModchuModel_ModelRenderer dummy;
	public String modelName;
		this(0.0F);
	}
		this(f, 0.0F);
	}
		this(null, f, f1 , 64, 32);
	}
		this(null, f, f1, i, j);
	}
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
		if (s != null); else s = "1";
		modelName = s;
		init(f, f1);
		Modchu_Debug.mlDebug1("public MultiModelCustom s="+s);
		//Modchu_Debug.mlDebug("public MultiModelCustom modelSize="+modelSize);
		customModel = new ModchuModel_CustomModel(this, s, null, null, f, 0.0F, null);
	}
		this(f, multiModelBaseBiped, textureName, null);
	}
		super(f, 0.0F, 64, 32);
		init(f, 0.0F);
		Modchu_Debug.mlDebug1("public MultiModelCustom 2 textureName="+textureName);
		customModel = new ModchuModel_CustomModel(this, null, multiModelBaseBiped, textureName, f, 0.0F, map);
	}
		dummy = new ModchuModel_ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}
	public String getUsingTexture() {
		return "default_Custom";
	}
	public void initModel(float f, float f1, Object... o) {
		initModel(f, f1, true);
	}
		bipedHead = new ModchuModel_ModelRenderer(this);
		bipedHeadwear = new ModchuModel_ModelRenderer(this);
		bipedBody = new ModchuModel_ModelRenderer(this);
		bipedRightArm = new ModchuModel_ModelRenderer(this);
		bipedLeftArm = new ModchuModel_ModelRenderer(this);
		bipedRightLeg = new ModchuModel_ModelRenderer(this);
		bipedLeftLeg = new ModchuModel_ModelRenderer(this);
		mainFrame = new ModchuModel_ModelRenderer(this);
		Skirt = new ModchuModel_ModelRenderer(this);
		bipedHead.addChild(bipedHeadwear);
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(bipedLeftLeg);
		mainFrame.addChild(bipedBody);
		if (isAfterInit) afterInit(f, f1);
	}
	public void actionPartsInit(float f, float f1) {
		rightArm = new ModchuModel_ModelRenderer(this);
		rightArmPlus = new ModchuModel_ModelRenderer(this);
		rightArm2 = new ModchuModel_ModelRenderer(this);
		rightArmPlus2 = new ModchuModel_ModelRenderer(this);
		rightHand = new ModchuModel_ModelRenderer(this);
		leftArm = new ModchuModel_ModelRenderer(this);
		leftArmPlus = new ModchuModel_ModelRenderer(this);
		leftArm2 = new ModchuModel_ModelRenderer(this);
		leftArmPlus2 = new ModchuModel_ModelRenderer(this);
		leftHand = new ModchuModel_ModelRenderer(this);
		rightLeg = new ModchuModel_ModelRenderer(this);
		rightLegPlus = new ModchuModel_ModelRenderer(this);
		rightLeg2 = new ModchuModel_ModelRenderer(this);
		rightLegPlus2 = new ModchuModel_ModelRenderer(this);
		leftLeg = new ModchuModel_ModelRenderer(this);
		leftLegPlus = new ModchuModel_ModelRenderer(this);
		leftLeg2 = new ModchuModel_ModelRenderer(this);
		leftLegPlus2 = new ModchuModel_ModelRenderer(this);
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		SkirtTop = new ModchuModel_ModelRenderer(this, 8, 16);
		SkirtFront = new ModchuModel_ModelRenderer(this, 8, 24);
		SkirtRight = new ModchuModel_ModelRenderer(this, 0, 24);
		SkirtLeft = new ModchuModel_ModelRenderer(this, 16, 24);
		SkirtBack = new ModchuModel_ModelRenderer(this, 24, 24);
		if (customModel != null) customModel.skirtFloatsInit(f, f1);
	}
	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		customModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}
		if (customModel != null) {
			mainFrame.render(f5);
			//Modchu_Debug.mDebug("superRender mainFrame.render");
/*
			Object renderMainframe = customModel.mainModel != null ? Modchu_Reflect.getFieldObject(MultiModelBaseBiped.class, "mainFrame", customModel.mainModel) : mainFrame;
			if (renderMainframe != null) {
				Modchu_Reflect.invokeMethod(renderMainframe.getClass(), "render", new Class[]{ float.class }, renderMainframe, new Object[]{ f5 });
				//Modchu_Debug.mDebug("superRender ");
			} else {
				Modchu_Debug.mDebug("superrender renderMainframe == null !!");
			}
*/
		} else {
			Modchu_Debug.mDebug("superRender customModel == null !!");
		}
	}
	public void setLivingAnimations(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
		customModel.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
	}
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		customModel.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
	}
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
	}
	public void setRotationAngles(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	customModel.setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}
    	super.setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}
    	super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}
	public void renderItems(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItems(entityCaps);
		else super.renderItems(entityCaps);
	}
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.defaultPartsSettingBefore(entityCaps);
		else super.defaultPartsSettingBefore(entityCaps);
	}
		super.defaultPartsSettingBefore(entityCaps);
	}
	public void defaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.defaultPartsSettingAfter(entityCaps);
		else super.defaultPartsSettingAfter(entityCaps);
	}
		super.defaultPartsSettingAfter(entityCaps);
	}
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.showModelSettingReflects(entityCaps);
		else super.showModelSettingReflects(entityCaps);
	}
		super.showModelSettingReflects(entityCaps);
	}
	public void actionInit(ModchuModel_IEntityCaps entityCaps, int i) {
		if (customModel != null) customModel.actionInit(entityCaps, i);
		else super.actionInit(entityCaps, i);
	}
	public void actionRelease(ModchuModel_IEntityCaps entityCaps, int i) {
		if (customModel != null) customModel.actionRelease(entityCaps, i);
		else super.actionRelease(entityCaps, i);
	}
		super.actionRelease(entityCaps, i);
	}
	public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action(f, f1, f2, f3, f4, f5, i, entityCaps);
		else super.action(f, f1, f2, f3, f4, f5, i, entityCaps);
		super.action(f, f1, f2, f3, f4, f5, i, entityCaps);
	}
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getHeight(entityCaps);
		return f > 0.0F ? f : 1.35F;
	}
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getWidth(entityCaps);
		return f > 0.0F ? f : 0.5F;
	}
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.getYOffset(entityCaps);
		return f > -100.0F ? f : 1.62F;
	}
	public float getRidingYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.getRidingYOffset(entityCaps);
		return f > -100.0F ? f : 1.62F;
	}
	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getRidingHeight(entityCaps);
		return f > 0.0F ? f : 1.35F;
	}
	public float getRidingWidth(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getRidingWidth(entityCaps);
		return f > 0.0F ? f : 0.5F;
	}
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getMountedYOffset(entityCaps);
		return f > 0.0F ? f : 0.75F;
	}
	public double getSittingYOffset(ModchuModel_IEntityCaps entityCaps) {
		double d = -100.0F;
		if (customModel != null) d = customModel.getSittingYOffset(entityCaps);
		return d > -100.0D ? d : -0.35D;
	}
	public float ridingViewCorrection(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.ridingViewCorrection(entityCaps);
		return f > -100.0F ? f : 0.0F;
	}
	public float getModelScale(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getModelScale(entityCaps);
		return f > 0.0F ? f : 0.9375F;
	}
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedHeadShowModel(entityCaps, b);
	}
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedBodyShowModel(entityCaps, b);
	}
		super.setArmorBipedBodyShowModel(entityCaps, b);
	}
	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedRightArmShowModel(entityCaps, b);
	}
		super.setArmorBipedRightArmShowModel(entityCaps, b);
	}
	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedLeftArmShowModel(entityCaps, b);
	}
		super.setArmorBipedLeftArmShowModel(entityCaps, b);
	}
	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedRightLegShowModel(entityCaps, b);
	}
		super.setArmorBipedRightLegShowModel(entityCaps, b);
	}
	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedLeftLegShowModel(entityCaps, b);
	}
		super.setArmorBipedLeftLegShowModel(entityCaps, b);
	}
	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorSkirtShowModel(entityCaps, b);
	}
		super.setArmorSkirtShowModel(entityCaps, b);
	}
	public Object getCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return customModel != null ? customModel.getCapsValue(entityCaps, pIndex, pArg) : super.getCapsValue(entityCaps, pIndex, pArg);
	}
		return super.getCapsValue(entityCaps, pIndex, pArg);
	}
	public boolean setCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return customModel != null ? customModel.setCapsValue(entityCaps, pIndex, pArg) : super.setCapsValue(entityCaps, pIndex, pArg);
	}
		return super.setCapsValue(entityCaps, pIndex, pArg);
	}
	public void changeModel(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.changeModel(entityCaps);
	}
		super.changeModel(entityCaps);
	}
	public void changeColor(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.changeColor(entityCaps);
	}
		super.changeColor(entityCaps);
	}
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setDefaultPause(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
	}
	public float[] getArmorModelsSize() {
		float[] f = null;
		if (customModel != null) f = customModel.getArmorModelsSize();
		return f != null ? f : new float[] {0.1F, 0.5F};
	}
		return new float[] {0.1F, 0.5F};
	}
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {
		if (customModel != null) customModel.renderFirstPersonHand(entityCaps, f, i);
	}
		super.renderFirstPersonHand(entityCaps, f, i);
	}
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}
	public int showArmorParts(ModchuModel_IEntityCaps entityCaps, int i, int i2) {
		int i1 = -1;
		if (customModel != null) i1 = customModel.showArmorParts(entityCaps, i, i2);
		if (i1 < -1) return -1;
		return i1;
	}
	public void defaultSkirtFloatsAddChild() {
		if (customModel != null) customModel.defaultSkirtFloatsAddChild();
	}
		super.defaultSkirtFloatsAddChild();
	}
	public void actionPartsAddChild() {
		if (customModel != null) customModel.actionPartsAddChild();
	}
		super.actionPartsAddChild();
	}
	public void boneProcessing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.boneProcessing(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.boneProcessing(f, f1, f2, f3, f4, f5, entityCaps);
	}
	public void defaultAddChild() {
		//Modchu_Debug.mDebug("defaultAddChild 1");
		if (customModel != null) customModel.defaultAddChild();
	}
		super.defaultAddChild();
	}
	public void showAllParts(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.showAllParts(entityCaps);
	}
	}
	public ModchuModel_ModelRenderer getBipedHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedHead(entityCaps);
		return bipedHead;
	}
	public ModchuModel_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getDominantArm(entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedRightArm;
		return bipedLeftArm;
	}
	public ModchuModel_ModelRenderer getBipedLeftArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedLeftArm(entityCaps);
		return bipedLeftArm;
	}
	public ModchuModel_ModelRenderer getBipedRightLeg(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedRightLeg(entityCaps);
		return bipedRightLeg;
	}
	public ModchuModel_ModelRenderer getBipedLeftLeg(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedLeftLeg(entityCaps);
		return bipedLeftLeg;
	}
	public ModchuModel_ModelRenderer getNotDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getNotDominantArm(entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedLeftArm;
		return bipedRightArm;
	}
	public void worldEventLoad(Object event) {
		if (customModel != null) customModel.worldEventLoad(event);
	}
	///
	@Override
	public void headMountRenderItems(ModchuModel_IEntityCaps entityCaps, Object itemstack, int addSupport) {
		if (customModel != null) customModel.headMountRenderItems(entityCaps, itemstack, addSupport);
		else super.headMountRenderItems(entityCaps, itemstack, addSupport);
	}
		super.headMountRenderItems((ModchuModel_IEntityCaps) entityCaps, itemstack, addSupport);
	}
	public Object getRightArm(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getRightArm(entityCaps) : super.getRightArm(entityCaps);
	}
		return super.getRightArm((ModchuModel_IEntityCaps) entityCaps);
	}
	public boolean armSwingFlag(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.armSwingFlag(entityCaps) : super.armSwingFlag(entityCaps);
	}
		return super.armSwingFlag((ModchuModel_IEntityCaps) entityCaps);
	}
	public void armsinit(float f, float f1) {
		if (customModel != null) customModel.armsinit(f, f1);
		else super.armsinit(f, f1);
	}
		super.armsinit(f, f1);
	}
	public void defaultAddChildSetting() {
		if (customModel != null) customModel.defaultAddChildSetting();
		else super.defaultAddChildSetting();
	}
		super.defaultAddChildSetting();
	}
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
		else super.skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.skirtFloats(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void setMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setMotionDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setMotionDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.setMotionDefaultPause(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		else super.armSwing(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.armSwing(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public ModchuModel_ModelRenderer getArms(int i) {
		return (ModchuModel_ModelRenderer) (customModel != null ? customModel.getArms(i) : super.getArms(i));
	}
		return super.getArms(i);
	}
	public ModchuModel_ModelRenderer getHeadMount() {
		return (ModchuModel_ModelRenderer) (customModel != null ? customModel.getHeadMount() : super.getHeadMount());
	}
		return super.getHeadMount();
	}
	public void actionRelease6(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease6(entityCaps);
		else super.actionRelease6(entityCaps);
	}
		super.actionRelease6((ModchuModel_IEntityCaps) entityCaps);
	}
	public void motionModelCorrectionBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, entityCaps);
		else super.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
		else super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public float getLeashOffset(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getLeashOffset(entityCaps) : super.getLeashOffset(entityCaps);
	}
		return super.getLeashOffset((ModchuModel_IEntityCaps) entityCaps);
	}
	public boolean isItemHolder(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.isItemHolder(entityCaps) : super.isItemHolder(entityCaps);
	}
		return super.isItemHolder((ModchuModel_IEntityCaps) entityCaps);
	}
	public void afterInit(float f, float f1) {
		if (customModel != null) customModel.afterInit(f, f1);
		else super.afterInit(f, f1);
	}
		super.afterInit(f, f1);
	}
	public void bonesInit(float f, float f1) {
		if (customModel != null) customModel.bonesInit(f, f1);
		else super.bonesInit(f, f1);
	}
		super.bonesInit(f, f1);
	}
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit1(entityCaps);
		else super.actionInit1(entityCaps);
	}
		super.actionInit1((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit2(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit2(entityCaps);
		else super.actionInit2(entityCaps);
	}
		super.actionInit2((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit3(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit3(entityCaps);
		else super.actionInit3(entityCaps);
	}
		super.actionInit3((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit4(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit4(entityCaps);
		else super.actionInit4(entityCaps);
	}
		super.actionInit4((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit5(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit5(entityCaps);
		else super.actionInit5(entityCaps);
	}
		super.actionInit5((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit6(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit6(entityCaps);
		else super.actionInit6(entityCaps);
	}
		super.actionInit6((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit7(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit7(entityCaps);
		else super.actionInit7(entityCaps);
	}
		super.actionInit7((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit8(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit8(entityCaps);
		else super.actionInit8(entityCaps);
	}
		super.actionInit8((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit9(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit9(entityCaps);
		else super.actionInit9(entityCaps);
	}
		super.actionInit9((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionInit30(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit30(entityCaps);
		else super.actionInit30(entityCaps);
	}
		super.actionInit30((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease1(entityCaps);
		else super.actionRelease1(entityCaps);
	}
		super.actionRelease1((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease2(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease2(entityCaps);
		else super.actionRelease2(entityCaps);
	}
		super.actionRelease2((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease3(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease3(entityCaps);
		else super.actionRelease3(entityCaps);
	}
		super.actionRelease3((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease4(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease4(entityCaps);
		else super.actionRelease4(entityCaps);
	}
		super.actionRelease4((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease5(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease5(entityCaps);
		else super.actionRelease5(entityCaps);
	}
		super.actionRelease5((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease7(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease7(entityCaps);
		else super.actionRelease7(entityCaps);
	}
		super.actionRelease7((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease8(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease8(entityCaps);
		else super.actionRelease8(entityCaps);
	}
		super.actionRelease8((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease9(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease9(entityCaps);
		else super.actionRelease9(entityCaps);
	}
		super.actionRelease9((ModchuModel_IEntityCaps) entityCaps);
	}
	public void actionRelease30(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease30(entityCaps);
		else super.actionRelease30(entityCaps);
	}
		super.actionRelease30((ModchuModel_IEntityCaps) entityCaps);
	}
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action1(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action1(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action1(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action1Reset(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action1Reset(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action2(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action2(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action2(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action2(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action3(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action3(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action3(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action3(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action4(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action4(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action4(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action4(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action5(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action5(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action5(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action5(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action6(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action6(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action6(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action6(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action7(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action7(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action7(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action7(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action8(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action8(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action8(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action8(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action9(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action9(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action9(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action9(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void action30(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action30(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action30(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.action30(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void IKProcessing(ModchuModel_ModelRenderer modchu_ModelRenderer) {
		if (customModel != null) customModel.IKProcessing(modchu_ModelRenderer);
		else super.IKProcessing(modchu_ModelRenderer);
	}
		super.IKProcessing((ModchuModel_ModelRenderer) modchu_ModelRenderer);
	}
	public void setArmorBipedOtherShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedOtherShowModel(entityCaps, b);
		else super.setArmorBipedOtherShowModel(entityCaps, b);
	}
		super.setArmorBipedOtherShowModel((ModchuModel_IEntityCaps) entityCaps, b);
	}
	public int[] getMotionModelRendererSettingInt(String s) {
		return customModel != null ? customModel.getMotionModelRendererSettingInt(s) : super.getMotionModelRendererSettingInt(s);
	}
		return super.getMotionModelRendererSettingInt(s);
	}
	public HashMap<String, String> getMotionRenameMap() {
		return (HashMap<String, String>) (customModel != null ? customModel.getMotionRenameMap() : super.getMotionRenameMap());
	}
		return super.getMotionRenameMap();
	}
	public void setMotionRenameMap(HashMap map) {
		if (customModel != null) customModel.setMotionRenameMap(map);
		else super.setMotionRenameMap(map);
	}
		super.setMotionRenameMap(map);
	}
	public String getMotionRenameMap(String s) {
		return customModel != null ? customModel.getMotionRenameMap(s) : super.getMotionRenameMap(s);
	}
		return super.getMotionRenameMap(s);
	}
	public void putMotionRenameMap(String s, String s1) {
		if (customModel != null) customModel.putMotionRenameMap(s, s1);
		else super.putMotionRenameMap(s, s1);
	}
		super.putMotionRenameMap(s, s1);
	}
	public void motionRenameMapClear() {
		if (customModel != null) customModel.motionRenameMapClear();
		else super.motionRenameMapClear();
	}
		super.motionRenameMapClear();
	}
	public ModchuModel_ModelRenderer getStringModelRendererMap(String s) {
		return (ModchuModel_ModelRenderer) (customModel != null ? customModel.getStringModelRendererMap(s) : super.getStringModelRendererMap(s));
	}
		return super.getStringModelRendererMap(s);
	}
	public void putStringModelRendererMap(String s, ModchuModel_ModelRenderer modchu_ModelRenderer) {
		if (customModel != null) customModel.putStringModelRendererMap(s, modchu_ModelRenderer);
		else super.putStringModelRendererMap(s, modchu_ModelRenderer);
	}
		super.putStringModelRendererMap(s, (ModchuModel_ModelRenderer) modchu_ModelRenderer);
	}
	public void renderEars(float par1) {
		if (customModel != null) customModel.renderEars(par1);
		else super.renderEars(par1);
	}
		super.renderEars(par1);
	}
	public void renderCloak(float par1) {
		if (customModel != null) customModel.renderCloak(par1);
		else super.renderCloak(par1);
	}
		super.renderCloak(par1);
	}
	public void renderItemsLM(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsLM(entityCaps);
		else super.renderItemsLM(entityCaps);
	}
		super.renderItemsLM((ModchuModel_IEntityCaps) entityCaps);
	}
	public void renderItemsHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsHead(entityCaps);
		else super.renderItemsHead(entityCaps);
	}
		super.renderItemsHead((ModchuModel_IEntityCaps) entityCaps);
	}
	public void renderItemsArmorHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsArmorHead(entityCaps);
		else super.renderItemsArmorHead(entityCaps);
	}
		super.renderItemsArmorHead((ModchuModel_IEntityCaps) entityCaps);
	}
	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack) {
		return customModel != null ? customModel.addSupportChecks(entityCaps, itemstack) : super.addSupportChecks(entityCaps, itemstack);
	}
		return super.addSupportChecks((ModchuModel_IEntityCaps) entityCaps, itemstack);
	}
	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack, int type) {
		return customModel != null ? customModel.addSupportChecks(entityCaps, itemstack, type) : super.addSupportChecks(entityCaps, itemstack, type);
	}
		return super.addSupportChecks((ModchuModel_IEntityCaps) entityCaps, itemstack, type);
	}
	public float Physical_Hammer(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.Physical_Hammer(entityCaps) : super.Physical_Hammer(entityCaps);
	}
		return super.Physical_Hammer((ModchuModel_IEntityCaps) entityCaps);
	}
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, int i) {
		super.renderFirstPersonHand(entityCaps, i);
	}
	public void setRotationAnglesGulliverBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public void setRotationAnglesGulliverAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}
		super.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}
	public boolean isGulliver() {
		return super.isGulliver();
	}
		return super.isGulliver();
	}
	public void setLivingAnimationsAfter(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		if (customModel != null) customModel.setLivingAnimationsAfter(entityCaps, f, f1, f2);
		else super.setLivingAnimationsAfter(entityCaps, f, f1, f2);
	}
		super.setLivingAnimationsAfter((ModchuModel_IEntityCaps) entityCaps, f, f1, f2);
	}
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, boolean pIsRender) {
		super.render(entity, par2, par3, par4, par5, par6, par7, pIsRender);
	}
	public void render(Modchu_IEntityCapsBase modchu_IModelCapsBase, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		super.render(modchu_IModelCapsBase, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}
		super.render((Modchu_IEntityCapsBase) modchu_IModelCapsBase, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		super.setLivingAnimations(entityLivingBase, par2, par3, par4);
	}
	}
	public Object getCapsValue(int pIndex, Object... pArg) {
		return super.getCapsValue(pIndex, pArg);
	}
		return super.getCapsValue(pIndex, pArg);
	}
	public Object getCapsValue(Modchu_IEntityCapsBase modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.getCapsValue(modchu_IModelCapsBase, pIndex, pArg);
	}
		return super.getCapsValue((Modchu_IEntityCapsBase) modchu_IModelCapsBase, pIndex, pArg);
	}
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return super.setCapsValue(pIndex, pArg);
	}
		return super.setCapsValue(pIndex, pArg);
	}
	public boolean setCapsValue(Modchu_IEntityCapsBase modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.setCapsValue(modchu_IModelCapsBase, pIndex, pArg);
	}
		return super.setCapsValue((Modchu_IEntityCapsBase) modchu_IModelCapsBase, pIndex, pArg);
	}
	public void changeModel(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.changeModel(modchu_IModelCapsBase);
	}
		super.changeModel((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public boolean preRender(Modchu_IEntityCapsBase modchu_IModelCapsBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		return super.preRender(modchu_IModelCapsBase, par2, par3, par4, par5, par6, par7);
	}
	public boolean preRender(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return customModel != null ? customModel.preRender(entityCaps, par2, par3, par4, par5, par6, par7) : super.preRender(entityCaps, par2, par3, par4, par5, par6, par7);
	}
		return super.preRender((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}
	public void renderExtention(Modchu_IEntityCapsBase modchu_IModelCapsBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderExtention(modchu_IModelCapsBase, par2, par3, par4, par5, par6, par7);
	}
	public void renderExtention(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (customModel != null) customModel.renderExtention(entityCaps, par2, par3, par4, par5, par6, par7);
		else super.renderExtention(entityCaps, par2, par3, par4, par5, par6, par7);
	}
		super.renderExtention((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}
	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, modchu_IModelCapsBase);
	}
		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, (Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public float[] getTextureLightColor(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getTextureLightColor(modchu_IModelCapsBase);
	}
	public float[] getTextureLightColor(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getTextureLightColor(entityCaps) : super.getTextureLightColor(entityCaps);
	}
		return super.getTextureLightColor((ModchuModel_IEntityCaps) entityCaps);
	}
	public void renderItems(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.renderItems(modchu_IModelCapsBase);
	}
		super.renderItems((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public void renderFirstPersonHand(Modchu_IEntityCapsBase modchu_IModelCapsBase, int i) {
		super.renderFirstPersonHand(modchu_IModelCapsBase, i);
	}
		super.renderFirstPersonHand((Modchu_IEntityCapsBase) modchu_IModelCapsBase, i);
	}
	public int showArmorParts(Modchu_IEntityCapsBase modchu_IModelCapsBase, int parts, int index) {
		return super.showArmorParts(modchu_IModelCapsBase, parts, index);
	}
		return super.showArmorParts((Modchu_IEntityCapsBase) modchu_IModelCapsBase, parts, index);
	}
	public float getHeight(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getHeight(modchu_IModelCapsBase);
	}
		return super.getHeight((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public float getWidth(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getWidth(modchu_IModelCapsBase);
	}
		return super.getWidth((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public float getYOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getYOffset(modchu_IModelCapsBase);
	}
		return super.getYOffset((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public float getMountedYOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getMountedYOffset(modchu_IModelCapsBase);
	}
		return super.getMountedYOffset((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public float getLeashOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getLeashOffset(modchu_IModelCapsBase);
	}
	public boolean isItemHolder(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.isItemHolder(modchu_IModelCapsBase);
	}
	public void showAllParts(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.showAllParts(modchu_IModelCapsBase);
	}
		super.showAllParts((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}
	public void renderBody(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		if (customModel != null) customModel.renderBody(entityCaps, f, f1, f2, f3, f4, f5, b);
		else super.renderBody(entityCaps, f, f1, f2, f3, f4, f5, b);
	}
		super.renderBody((ModchuModel_IEntityCaps) entityCaps, f, f1, f2, f3, f4, f5, b);
	}
	public void renderFace(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		if (customModel != null) customModel.renderFace(entityCaps, f, f1, f2, f3, f4, f5, b);
		else super.renderFace(entityCaps, f, f1, f2, f3, f4, f5, b);
	}
		super.renderFace((ModchuModel_IEntityCaps) entityCaps, f, f1, f2, f3, f4, f5, b);
	}
	public int setFaceTexture(int pIndex) {
		return customModel != null ? customModel.setFaceTexture(pIndex) : super.setFaceTexture(pIndex);
	}
		return super.setFaceTexture(pIndex);
	}
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
	}
		super.render(entity, par2, par3, par4, par5, par6, par7);
	}
	public ModchuModel_ModelRenderer getRandomModelBox(Random random) {
		return (ModchuModel_ModelRenderer) (customModel != null ? customModel.getRandomModelBox(random) : super.getRandomModelBox(random));
	}
		return (ModchuModel_ModelRenderer) super.getRandomModelBox((Random) random);
	}
	public boolean canSpawnHear(Object world, int pX, int pY, int pZ) {
		return customModel != null ? customModel.canSpawnHear(world, pX, pY, pZ) : super.canSpawnHear(world, pX, pY, pZ);
	}
		return super.canSpawnHear(world, pX, pY, pZ);
	}