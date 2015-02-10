package modchu.model.multimodel.base;import java.util.HashMap;
import java.util.Random;import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Reflect;
import modchu.lib.characteristic.Modchu_IEntityCapsBase;
import modchu.lib.characteristic.Modchu_ModelRenderer;
import modchu.model.ModchuModel_CustomModel;
import modchu.model.ModchuModel_IEntityCaps;public class MultiModelCustom extends MultiModel {	public ModchuModel_CustomModel customModel;
	public Modchu_ModelRenderer dummy;
	public String modelName;	public MultiModelCustom() {
		this(0.0F);
	}	public MultiModelCustom(float f) {
		this(f, 0.0F);
	}	public MultiModelCustom(float f, float f1) {
		this(null, f, f1 , 64, 32);
	}	public MultiModelCustom(float f, float f1, int i, int j) {
		this(null, f, f1, i, j);
	}	public MultiModelCustom(String s, float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 32 : j);
		if (s != null); else s = "1";
		modelName = s;
		init(f, f1);
		Modchu_Debug.mlDebug1("public MultiModelCustom s="+s);
		//Modchu_Debug.mlDebug("public MultiModelCustom modelSize="+modelSize);
		customModel = new ModchuModel_CustomModel(this, s, null, null, f, 0.0F, null);
	}	public MultiModelCustom(float f, MultiModelBaseBiped multiModelBaseBiped, String textureName) {
		this(f, multiModelBaseBiped, textureName, null);
	}	public MultiModelCustom(float f, MultiModelBaseBiped multiModelBaseBiped, String textureName, HashMap map) {
		super(f, 0.0F, 64, 32);
		init(f, 0.0F);
		Modchu_Debug.mlDebug1("public MultiModelCustom 2 textureName="+textureName);
		customModel = new ModchuModel_CustomModel(this, null, multiModelBaseBiped, textureName, f, 0.0F, map);
	}	private void init(float f, float f1) {
		dummy = new Modchu_ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}	@Override	public void initSkirtFloats() {	}	@Override
	public String getUsingTexture() {
		return "default_Custom";
	}	@Override
	public void initModel(float f, float f1, Object... o) {
		initModel(f, f1, true);
	}	public void initModel(float f, float f1, boolean isAfterInit) {
		bipedHead = new Modchu_ModelRenderer(this);
		bipedHeadwear = new Modchu_ModelRenderer(this);
		bipedBody = new Modchu_ModelRenderer(this);
		bipedRightArm = new Modchu_ModelRenderer(this);
		bipedLeftArm = new Modchu_ModelRenderer(this);
		bipedRightLeg = new Modchu_ModelRenderer(this);
		bipedLeftLeg = new Modchu_ModelRenderer(this);
		mainFrame = new Modchu_ModelRenderer(this);
		Skirt = new Modchu_ModelRenderer(this);
		bipedHead.addChild(bipedHeadwear);
		bipedBody.addChild(bipedHead);
		bipedBody.addChild(bipedRightArm);
		bipedBody.addChild(bipedLeftArm);
		bipedBody.addChild(bipedRightLeg);
		bipedBody.addChild(bipedLeftLeg);
		mainFrame.addChild(bipedBody);
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this);
		rightArmPlus = new Modchu_ModelRenderer(this);
		rightArm2 = new Modchu_ModelRenderer(this);
		rightArmPlus2 = new Modchu_ModelRenderer(this);
		rightHand = new Modchu_ModelRenderer(this);
		leftArm = new Modchu_ModelRenderer(this);
		leftArmPlus = new Modchu_ModelRenderer(this);
		leftArm2 = new Modchu_ModelRenderer(this);
		leftArmPlus2 = new Modchu_ModelRenderer(this);
		leftHand = new Modchu_ModelRenderer(this);
		rightLeg = new Modchu_ModelRenderer(this);
		rightLegPlus = new Modchu_ModelRenderer(this);
		rightLeg2 = new Modchu_ModelRenderer(this);
		rightLegPlus2 = new Modchu_ModelRenderer(this);
		leftLeg = new Modchu_ModelRenderer(this);
		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLeg2 = new Modchu_ModelRenderer(this);
		leftLegPlus2 = new Modchu_ModelRenderer(this);		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
		SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
		SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
		SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
		SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
		if (customModel != null) customModel.skirtFloatsInit(f, f1);
	}	@Override
	public void render(ModchuModel_IEntityCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
		customModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}    public void superRender(ModchuModel_IEntityCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
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
	}	@Override
	public void setLivingAnimations(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
		customModel.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		customModel.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
	}	public void superSetLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float renderPartialTicks) {
		super.setLivingAnimationsLM(entityCaps, f, f1, renderPartialTicks);
	}    @Override
	public void setRotationAngles(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	customModel.setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}	public void superSetRotationAngles(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	super.setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}    @Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}	public void superSetRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, ModchuModel_IEntityCaps entityCaps) {
    	super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
	}	@Override
	public void renderItems(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItems(entityCaps);
		else super.renderItems(entityCaps);
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.defaultPartsSettingBefore(entityCaps);
		else super.defaultPartsSettingBefore(entityCaps);
	}	public void superDefaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
	}	@Override
	public void defaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.defaultPartsSettingAfter(entityCaps);
		else super.defaultPartsSettingAfter(entityCaps);
	}	public void superDefaultPartsSettingAfter(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingAfter(entityCaps);
	}	@Override
	public void showModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.showModelSettingReflects(entityCaps);
		else super.showModelSettingReflects(entityCaps);
	}	public void superShowModelSettingReflects(ModchuModel_IEntityCaps entityCaps) {
		super.showModelSettingReflects(entityCaps);
	}	@Override
	public void actionInit(ModchuModel_IEntityCaps entityCaps, int i) {
		if (customModel != null) customModel.actionInit(entityCaps, i);
		else super.actionInit(entityCaps, i);
	}	@Override
	public void actionRelease(ModchuModel_IEntityCaps entityCaps, int i) {
		if (customModel != null) customModel.actionRelease(entityCaps, i);
		else super.actionRelease(entityCaps, i);
	}	public void superActionRelease(ModchuModel_IEntityCaps entityCaps, int i) {
		super.actionRelease(entityCaps, i);
	}	@Override
	public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action(f, f1, f2, f3, f4, f5, i, entityCaps);
		else super.action(f, f1, f2, f3, f4, f5, i, entityCaps);
	}	public void superAction(float f, float f1, float f2, float f3, float f4, float f5, int i, ModchuModel_IEntityCaps entityCaps) {
		super.action(f, f1, f2, f3, f4, f5, i, entityCaps);
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getHeight(entityCaps);
		return f > 0.0F ? f : 1.35F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getWidth(entityCaps);
		return f > 0.0F ? f : 0.5F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.getYOffset(entityCaps);
		return f > -100.0F ? f : 1.62F;
	}	@Override
	public float getRidingYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.getRidingYOffset(entityCaps);
		return f > -100.0F ? f : 1.62F;
	}	@Override
	public float getRidingHeight(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getRidingHeight(entityCaps);
		return f > 0.0F ? f : 1.35F;
	}	@Override
	public float getRidingWidth(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getRidingWidth(entityCaps);
		return f > 0.0F ? f : 0.5F;
	}	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getMountedYOffset(entityCaps);
		return f > 0.0F ? f : 0.75F;
	}	@Override
	public double getSittingYOffset(ModchuModel_IEntityCaps entityCaps) {
		double d = -100.0F;
		if (customModel != null) d = customModel.getSittingYOffset(entityCaps);
		return d > -100.0D ? d : -0.35D;
	}	@Override
	public float ridingViewCorrection(ModchuModel_IEntityCaps entityCaps) {
		float f = -100.0F;
		if (customModel != null) f = customModel.ridingViewCorrection(entityCaps);
		return f > -100.0F ? f : 0.0F;
	}	@Override
	public float getModelScale(ModchuModel_IEntityCaps entityCaps) {
		float f = 0.0F;
		if (customModel != null) f = customModel.getModelScale(entityCaps);
		return f > 0.0F ? f : 0.9375F;
	}	@Override
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedHeadShowModel(entityCaps, b);
	}	public void superSetArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedBodyShowModel(entityCaps, b);
	}	public void superSetArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedBodyShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedRightArmShowModel(entityCaps, b);
	}	public void superSetArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedRightArmShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedLeftArmShowModel(entityCaps, b);
	}	public void superSetArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedLeftArmShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedRightLegShowModel(entityCaps, b);
	}	public void superSetArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedRightLegShowModel(entityCaps, b);
	}	@Override
	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedLeftLegShowModel(entityCaps, b);
	}	public void superSetArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorBipedLeftLegShowModel(entityCaps, b);
	}	@Override
	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorSkirtShowModel(entityCaps, b);
	}	public void superSetArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
	}	@Override
	public Object getCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return customModel != null ? customModel.getCapsValue(entityCaps, pIndex, pArg) : super.getCapsValue(entityCaps, pIndex, pArg);
	}	public Object superGetCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return super.getCapsValue(entityCaps, pIndex, pArg);
	}	@Override
	public boolean setCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return customModel != null ? customModel.setCapsValue(entityCaps, pIndex, pArg) : super.setCapsValue(entityCaps, pIndex, pArg);
	}	public boolean superSetCapsValue(ModchuModel_IEntityCaps entityCaps, int pIndex, Object ...pArg) {
		return super.setCapsValue(entityCaps, pIndex, pArg);
	}	@Override
	public void changeModel(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.changeModel(entityCaps);
	}	public void superChangeModel(ModchuModel_IEntityCaps entityCaps) {
		super.changeModel(entityCaps);
	}	@Override
	public void changeColor(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.changeColor(entityCaps);
	}	public void superChangeColor(ModchuModel_IEntityCaps entityCaps) {
		super.changeColor(entityCaps);
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setDefaultPause(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	public void superSetDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public float[] getArmorModelsSize() {
		float[] f = null;
		if (customModel != null) f = customModel.getArmorModelsSize();
		return f != null ? f : new float[] {0.1F, 0.5F};
	}	public float[] superGetArmorModelsSize() {
		return new float[] {0.1F, 0.5F};
	}	@Override
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {
		if (customModel != null) customModel.renderFirstPersonHand(entityCaps, f, i);
	}	public void superRenderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, float f, int i) {
		super.renderFirstPersonHand(entityCaps, f, i);
	}	@Override
	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superSetRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public int showArmorParts(ModchuModel_IEntityCaps entityCaps, int i, int i2) {
		int i1 = -1;
		if (customModel != null) i1 = customModel.showArmorParts(entityCaps, i, i2);
		if (i1 < -1) return -1;
		return i1;
	}	@Override
	public void defaultSkirtFloatsAddChild() {
		if (customModel != null) customModel.defaultSkirtFloatsAddChild();
	}	public void superDefaultSkirtFloatsAddChild() {
		super.defaultSkirtFloatsAddChild();
	}	@Override
	public void actionPartsAddChild() {
		if (customModel != null) customModel.actionPartsAddChild();
	}	public void superActionPartsAddChild() {
		super.actionPartsAddChild();
	}	@Override
	public void boneProcessing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.boneProcessing(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superBoneProcessing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.boneProcessing(f, f1, f2, f3, f4, f5, entityCaps);
	}	@Override
	public void defaultAddChild() {
		//Modchu_Debug.mDebug("defaultAddChild 1");
		if (customModel != null) customModel.defaultAddChild();
	}	public void superDefaultAddChild() {
		super.defaultAddChild();
	}	@Override
	public void showAllParts(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.showAllParts(entityCaps);
	}	public void superShowAllParts(ModchuModel_IEntityCaps entityCaps) {
	}	@Override
	public Modchu_ModelRenderer getBipedHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedHead(entityCaps);
		return bipedHead;
	}	@Override
	public Modchu_ModelRenderer getDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getDominantArm(entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedRightArm;
		return bipedLeftArm;
	}	@Override
	public Modchu_ModelRenderer getBipedRightArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedRightArm(entityCaps);
		return bipedRightArm;
	}	@Override
	public Modchu_ModelRenderer getBipedLeftArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedLeftArm(entityCaps);
		return bipedLeftArm;
	}	@Override
	public Modchu_ModelRenderer getBipedRightLeg(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedRightLeg(entityCaps);
		return bipedRightLeg;
	}	@Override
	public Modchu_ModelRenderer getBipedLeftLeg(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getBipedLeftLeg(entityCaps);
		return bipedLeftLeg;
	}	@Override
	public Modchu_ModelRenderer getNotDominantArm(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) return customModel.getNotDominantArm(entityCaps);
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, entityCaps, caps_dominantArm, getCapsValue(caps_armorType)) == 0) return bipedLeftArm;
		return bipedRightArm;
	}	@Override
	public void worldEventLoad(Object event) {
		if (customModel != null) customModel.worldEventLoad(event);
	}
	///
	@Override
	public void headMountRenderItems(ModchuModel_IEntityCaps entityCaps, Object itemstack, int addSupport) {
		if (customModel != null) customModel.headMountRenderItems(entityCaps, itemstack, addSupport);
		else super.headMountRenderItems(entityCaps, itemstack, addSupport);
	}	public void superHeadMountRenderItems(Object entityCaps, Object itemstack, int addSupport) {
		super.headMountRenderItems((ModchuModel_IEntityCaps) entityCaps, itemstack, addSupport);
	}	@Override
	public Object getRightArm(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getRightArm(entityCaps) : super.getRightArm(entityCaps);
	}	public Object superGetRightArm(Object entityCaps) {
		return super.getRightArm((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public boolean armSwingFlag(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.armSwingFlag(entityCaps) : super.armSwingFlag(entityCaps);
	}	public boolean superArmSwingFlag(Object entityCaps) {
		return super.armSwingFlag((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void armsinit(float f, float f1) {
		if (customModel != null) customModel.armsinit(f, f1);
		else super.armsinit(f, f1);
	}	public void superArmsinit(float f, float f1) {
		super.armsinit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		if (customModel != null) customModel.defaultAddChildSetting();
		else super.defaultAddChildSetting();
	}	public void superDefaultAddChildSetting() {
		super.defaultAddChildSetting();
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
		else super.skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superSkirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.skirtFloats(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void setMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setMotionDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setMotionDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superSetMotionDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.setMotionDefaultPause(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.armSwing(f, f1, f2, f3, f4, f5, entityCaps);
		else super.armSwing(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superArmSwing(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.armSwing(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public Modchu_ModelRenderer getArms(int i) {
		return (Modchu_ModelRenderer) (customModel != null ? customModel.getArms(i) : super.getArms(i));
	}	public Modchu_ModelRenderer superGetArms(int i) {
		return super.getArms(i);
	}	@Override
	public Modchu_ModelRenderer getHeadMount() {
		return (Modchu_ModelRenderer) (customModel != null ? customModel.getHeadMount() : super.getHeadMount());
	}	public Modchu_ModelRenderer superGetHeadMount() {
		return super.getHeadMount();
	}	@Override
	public void actionRelease6(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease6(entityCaps);
		else super.actionRelease6(entityCaps);
	}	public void superActionRelease6(Object entityCaps) {
		super.actionRelease6((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void motionModelCorrectionBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, entityCaps);
		else super.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superMotionModelCorrectionBefore(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.motionModelCorrectionBefore(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void motionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
		else super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superMotionModelCorrectionAfter(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.motionModelCorrectionAfter(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public float getLeashOffset(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getLeashOffset(entityCaps) : super.getLeashOffset(entityCaps);
	}	public float superGetLeashOffset(Object entityCaps) {
		return super.getLeashOffset((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public boolean isItemHolder(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.isItemHolder(entityCaps) : super.isItemHolder(entityCaps);
	}	public boolean superIsItemHolder(Object entityCaps) {
		return super.isItemHolder((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void afterInit(float f, float f1) {
		if (customModel != null) customModel.afterInit(f, f1);
		else super.afterInit(f, f1);
	}	public void superAfterInit(float f, float f1) {
		super.afterInit(f, f1);
	}	@Override
	public void bonesInit(float f, float f1) {
		if (customModel != null) customModel.bonesInit(f, f1);
		else super.bonesInit(f, f1);
	}	public void superBonesInit(float f, float f1) {
		super.bonesInit(f, f1);
	}	@Override
	public void actionInit1(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit1(entityCaps);
		else super.actionInit1(entityCaps);
	}	public void superActionInit1(Object entityCaps) {
		super.actionInit1((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit2(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit2(entityCaps);
		else super.actionInit2(entityCaps);
	}	public void superActionInit2(Object entityCaps) {
		super.actionInit2((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit3(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit3(entityCaps);
		else super.actionInit3(entityCaps);
	}	public void superActionInit3(Object entityCaps) {
		super.actionInit3((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit4(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit4(entityCaps);
		else super.actionInit4(entityCaps);
	}	public void superActionInit4(Object entityCaps) {
		super.actionInit4((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit5(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit5(entityCaps);
		else super.actionInit5(entityCaps);
	}	public void superActionInit5(Object entityCaps) {
		super.actionInit5((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit6(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit6(entityCaps);
		else super.actionInit6(entityCaps);
	}	public void superActionInit6(Object entityCaps) {
		super.actionInit6((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit7(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit7(entityCaps);
		else super.actionInit7(entityCaps);
	}	public void superActionInit7(Object entityCaps) {
		super.actionInit7((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit8(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit8(entityCaps);
		else super.actionInit8(entityCaps);
	}	public void superActionInit8(Object entityCaps) {
		super.actionInit8((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit9(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit9(entityCaps);
		else super.actionInit9(entityCaps);
	}	public void superActionInit9(Object entityCaps) {
		super.actionInit9((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionInit30(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionInit30(entityCaps);
		else super.actionInit30(entityCaps);
	}	public void superActionInit30(Object entityCaps) {
		super.actionInit30((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease1(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease1(entityCaps);
		else super.actionRelease1(entityCaps);
	}	public void superActionRelease1(Object entityCaps) {
		super.actionRelease1((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease2(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease2(entityCaps);
		else super.actionRelease2(entityCaps);
	}	public void superActionRelease2(Object entityCaps) {
		super.actionRelease2((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease3(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease3(entityCaps);
		else super.actionRelease3(entityCaps);
	}	public void superActionRelease3(Object entityCaps) {
		super.actionRelease3((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease4(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease4(entityCaps);
		else super.actionRelease4(entityCaps);
	}	public void superActionRelease4(Object entityCaps) {
		super.actionRelease4((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease5(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease5(entityCaps);
		else super.actionRelease5(entityCaps);
	}	public void superActionRelease5(Object entityCaps) {
		super.actionRelease5((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease7(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease7(entityCaps);
		else super.actionRelease7(entityCaps);
	}	public void superActionRelease7(Object entityCaps) {
		super.actionRelease7((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease8(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease8(entityCaps);
		else super.actionRelease8(entityCaps);
	}	public void superActionRelease8(Object entityCaps) {
		super.actionRelease8((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease9(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease9(entityCaps);
		else super.actionRelease9(entityCaps);
	}	public void superActionRelease9(Object entityCaps) {
		super.actionRelease9((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void actionRelease30(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.actionRelease30(entityCaps);
		else super.actionRelease30(entityCaps);
	}	public void superActionRelease30(Object entityCaps) {
		super.actionRelease30((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action1(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action1(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction1(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action1Reset(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action1Reset(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction1Reset(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action1Reset(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action2(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action2(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action2(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction2(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action2(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action3(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action3(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action3(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction3(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action3(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action4(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action4(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action4(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction4(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action4(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action5(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action5(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action5(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction5(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action5(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action6(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action6(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action6(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction6(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action6(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action7(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action7(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action7(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction7(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action7(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action8(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action8(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action8(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction8(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action8(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action9(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action9(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action9(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction9(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action9(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void action30(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.action30(f, f1, f2, f3, f4, f5, entityCaps);
		else super.action30(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superAction30(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.action30(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void IKProcessing(Modchu_ModelRenderer modchu_ModelRenderer) {
		if (customModel != null) customModel.IKProcessing(modchu_ModelRenderer);
		else super.IKProcessing(modchu_ModelRenderer);
	}	public void superIKProcessing(Object modchu_ModelRenderer) {
		super.IKProcessing((Modchu_ModelRenderer) modchu_ModelRenderer);
	}	@Override
	public void setArmorBipedOtherShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		if (customModel != null) customModel.setArmorBipedOtherShowModel(entityCaps, b);
		else super.setArmorBipedOtherShowModel(entityCaps, b);
	}	public void superSetArmorBipedOtherShowModel(Object entityCaps, boolean b) {
		super.setArmorBipedOtherShowModel((ModchuModel_IEntityCaps) entityCaps, b);
	}	@Override
	public int[] getMotionModelRendererSettingInt(String s) {
		return customModel != null ? customModel.getMotionModelRendererSettingInt(s) : super.getMotionModelRendererSettingInt(s);
	}	public int[] superGetMotionModelRendererSettingInt(String s) {
		return super.getMotionModelRendererSettingInt(s);
	}	@Override
	public HashMap<String, String> getMotionRenameMap() {
		return (HashMap<String, String>) (customModel != null ? customModel.getMotionRenameMap() : super.getMotionRenameMap());
	}	public HashMap<String, String> superGetMotionRenameMap() {
		return super.getMotionRenameMap();
	}	@Override
	public void setMotionRenameMap(HashMap map) {
		if (customModel != null) customModel.setMotionRenameMap(map);
		else super.setMotionRenameMap(map);
	}	public void superSetMotionRenameMap(HashMap map) {
		super.setMotionRenameMap(map);
	}	@Override
	public String getMotionRenameMap(String s) {
		return customModel != null ? customModel.getMotionRenameMap(s) : super.getMotionRenameMap(s);
	}	public String superGetMotionRenameMap(String s) {
		return super.getMotionRenameMap(s);
	}	@Override
	public void putMotionRenameMap(String s, String s1) {
		if (customModel != null) customModel.putMotionRenameMap(s, s1);
		else super.putMotionRenameMap(s, s1);
	}	public void superPutMotionRenameMap(String s, String s1) {
		super.putMotionRenameMap(s, s1);
	}	@Override
	public void motionRenameMapClear() {
		if (customModel != null) customModel.motionRenameMapClear();
		else super.motionRenameMapClear();
	}	public void superMotionRenameMapClear() {
		super.motionRenameMapClear();
	}	@Override
	public Modchu_ModelRenderer getStringModelRendererMap(String s) {
		return (Modchu_ModelRenderer) (customModel != null ? customModel.getStringModelRendererMap(s) : super.getStringModelRendererMap(s));
	}	public Modchu_ModelRenderer superGetStringModelRendererMap(String s) {
		return super.getStringModelRendererMap(s);
	}	@Override
	public void putStringModelRendererMap(String s, Modchu_ModelRenderer modchu_ModelRenderer) {
		if (customModel != null) customModel.putStringModelRendererMap(s, modchu_ModelRenderer);
		else super.putStringModelRendererMap(s, modchu_ModelRenderer);
	}	public void superPutStringModelRendererMap(String s, Object modchu_ModelRenderer) {
		super.putStringModelRendererMap(s, (Modchu_ModelRenderer) modchu_ModelRenderer);
	}	@Override
	public void renderEars(float par1) {
		if (customModel != null) customModel.renderEars(par1);
		else super.renderEars(par1);
	}	public void superRenderEars(float par1) {
		super.renderEars(par1);
	}	@Override
	public void renderCloak(float par1) {
		if (customModel != null) customModel.renderCloak(par1);
		else super.renderCloak(par1);
	}	public void superRenderCloak(float par1) {
		super.renderCloak(par1);
	}	@Override
	public void renderItemsLM(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsLM(entityCaps);
		else super.renderItemsLM(entityCaps);
	}	public void superRenderItemsLM(Object entityCaps) {
		super.renderItemsLM((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void renderItemsHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsHead(entityCaps);
		else super.renderItemsHead(entityCaps);
	}	public void superRenderItemsHead(Object entityCaps) {
		super.renderItemsHead((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void renderItemsArmorHead(ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.renderItemsArmorHead(entityCaps);
		else super.renderItemsArmorHead(entityCaps);
	}	public void superRenderItemsArmorHead(Object entityCaps) {
		super.renderItemsArmorHead((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack) {
		return customModel != null ? customModel.addSupportChecks(entityCaps, itemstack) : super.addSupportChecks(entityCaps, itemstack);
	}	public int superAddSupportChecks(Object entityCaps, Object itemstack) {
		return super.addSupportChecks((ModchuModel_IEntityCaps) entityCaps, itemstack);
	}	@Override
	public int addSupportChecks(ModchuModel_IEntityCaps entityCaps, Object itemstack, int type) {
		return customModel != null ? customModel.addSupportChecks(entityCaps, itemstack, type) : super.addSupportChecks(entityCaps, itemstack, type);
	}	public int superAddSupportChecks(Object entityCaps, Object itemstack, int type) {
		return super.addSupportChecks((ModchuModel_IEntityCaps) entityCaps, itemstack, type);
	}	@Override
	public float Physical_Hammer(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.Physical_Hammer(entityCaps) : super.Physical_Hammer(entityCaps);
	}	public float superPhysical_Hammer(Object entityCaps) {
		return super.Physical_Hammer((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void renderFirstPersonHand(ModchuModel_IEntityCaps entityCaps, int i) {
		super.renderFirstPersonHand(entityCaps, i);
	}	@Override
	public void setRotationAnglesGulliverBefore(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superSetRotationAnglesGulliverBefore(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void setRotationAnglesGulliverAfter(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (customModel != null) customModel.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		else super.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
	}	public void superSetRotationAnglesGulliverAfter(float f, float f1, float f2, float f3, float f4, float f5, Object entityCaps) {
		super.setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, (ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public boolean isGulliver() {
		return super.isGulliver();
	}	public boolean superIsGulliver() {
		return super.isGulliver();
	}	@Override
	public void setLivingAnimationsAfter(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		if (customModel != null) customModel.setLivingAnimationsAfter(entityCaps, f, f1, f2);
		else super.setLivingAnimationsAfter(entityCaps, f, f1, f2);
	}	public void superSetLivingAnimationsAfter(Object entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsAfter((ModchuModel_IEntityCaps) entityCaps, f, f1, f2);
	}	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, boolean pIsRender) {
		super.render(entity, par2, par3, par4, par5, par6, par7, pIsRender);
	}	@Override
	public void render(Modchu_IEntityCapsBase modchu_IModelCapsBase, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		super.render(modchu_IModelCapsBase, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}	public void superRender(Object modchu_IModelCapsBase, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		super.render((Modchu_IEntityCapsBase) modchu_IModelCapsBase, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
	}	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}	public void superSetRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}	@Override
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		super.setLivingAnimations(entityLivingBase, par2, par3, par4);
	}	public void superSetLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
	}	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		return super.getCapsValue(pIndex, pArg);
	}	public Object superGetCapsValue(int pIndex, Object... pArg) {
		return super.getCapsValue(pIndex, pArg);
	}	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.getCapsValue(modchu_IModelCapsBase, pIndex, pArg);
	}	public Object superGetCapsValue(Object modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.getCapsValue((Modchu_IEntityCapsBase) modchu_IModelCapsBase, pIndex, pArg);
	}	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return super.setCapsValue(pIndex, pArg);
	}	public boolean superSetCapsValue(int pIndex, Object... pArg) {
		return super.setCapsValue(pIndex, pArg);
	}	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.setCapsValue(modchu_IModelCapsBase, pIndex, pArg);
	}	public boolean superSetCapsValue(Object modchu_IModelCapsBase, int pIndex, Object... pArg) {
		return super.setCapsValue((Modchu_IEntityCapsBase) modchu_IModelCapsBase, pIndex, pArg);
	}	@Override
	public void changeModel(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.changeModel(modchu_IModelCapsBase);
	}	public void superChangeModel(Object modchu_IModelCapsBase) {
		super.changeModel((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public boolean preRender(Modchu_IEntityCapsBase modchu_IModelCapsBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		return super.preRender(modchu_IModelCapsBase, par2, par3, par4, par5, par6, par7);
	}	@Override
	public boolean preRender(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return customModel != null ? customModel.preRender(entityCaps, par2, par3, par4, par5, par6, par7) : super.preRender(entityCaps, par2, par3, par4, par5, par6, par7);
	}	public boolean superPreRender(Object entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return super.preRender((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}	@Override
	public void renderExtention(Modchu_IEntityCapsBase modchu_IModelCapsBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderExtention(modchu_IModelCapsBase, par2, par3, par4, par5, par6, par7);
	}	@Override
	public void renderExtention(ModchuModel_IEntityCaps entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (customModel != null) customModel.renderExtention(entityCaps, par2, par3, par4, par5, par6, par7);
		else super.renderExtention(entityCaps, par2, par3, par4, par5, par6, par7);
	}	public void superRenderExtention(Object entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderExtention((ModchuModel_IEntityCaps) entityCaps, par2, par3, par4, par5, par6, par7);
	}	@Override
	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, modchu_IModelCapsBase);
	}	public void superSetDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Object modchu_IModelCapsBase) {
		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, (Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public float[] getTextureLightColor(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getTextureLightColor(modchu_IModelCapsBase);
	}	@Override
	public float[] getTextureLightColor(ModchuModel_IEntityCaps entityCaps) {
		return customModel != null ? customModel.getTextureLightColor(entityCaps) : super.getTextureLightColor(entityCaps);
	}	public float[] superGetTextureLightColor(Object entityCaps) {
		return super.getTextureLightColor((ModchuModel_IEntityCaps) entityCaps);
	}	@Override
	public void renderItems(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.renderItems(modchu_IModelCapsBase);
	}	public void superRenderItems(Object modchu_IModelCapsBase) {
		super.renderItems((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public void renderFirstPersonHand(Modchu_IEntityCapsBase modchu_IModelCapsBase, int i) {
		super.renderFirstPersonHand(modchu_IModelCapsBase, i);
	}	public void superRenderFirstPersonHand(Object modchu_IModelCapsBase, int i) {
		super.renderFirstPersonHand((Modchu_IEntityCapsBase) modchu_IModelCapsBase, i);
	}	@Override
	public int showArmorParts(Modchu_IEntityCapsBase modchu_IModelCapsBase, int parts, int index) {
		return super.showArmorParts(modchu_IModelCapsBase, parts, index);
	}	public int superShowArmorParts(Object modchu_IModelCapsBase, int parts, int index) {
		return super.showArmorParts((Modchu_IEntityCapsBase) modchu_IModelCapsBase, parts, index);
	}	@Override
	public float getHeight(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getHeight(modchu_IModelCapsBase);
	}	public float superGetHeight(Object modchu_IModelCapsBase) {
		return super.getHeight((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public float getWidth(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getWidth(modchu_IModelCapsBase);
	}	public float superGetWidth(Object modchu_IModelCapsBase) {
		return super.getWidth((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public float getYOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getYOffset(modchu_IModelCapsBase);
	}	public float supergetYOffset(Object modchu_IModelCapsBase) {
		return super.getYOffset((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public float getMountedYOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getMountedYOffset(modchu_IModelCapsBase);
	}	public float superGetMountedYOffset(Object modchu_IModelCapsBase) {
		return super.getMountedYOffset((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public float getLeashOffset(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.getLeashOffset(modchu_IModelCapsBase);
	}	@Override
	public boolean isItemHolder(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		return super.isItemHolder(modchu_IModelCapsBase);
	}	@Override
	public void showAllParts(Modchu_IEntityCapsBase modchu_IModelCapsBase) {
		super.showAllParts(modchu_IModelCapsBase);
	}	public void superShowAllParts(Object modchu_IModelCapsBase) {
		super.showAllParts((Modchu_IEntityCapsBase) modchu_IModelCapsBase);
	}	@Override
	public void renderBody(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		if (customModel != null) customModel.renderBody(entityCaps, f, f1, f2, f3, f4, f5, b);
		else super.renderBody(entityCaps, f, f1, f2, f3, f4, f5, b);
	}	public void superRenderBody(Object entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		super.renderBody((ModchuModel_IEntityCaps) entityCaps, f, f1, f2, f3, f4, f5, b);
	}	@Override
	public void renderFace(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		if (customModel != null) customModel.renderFace(entityCaps, f, f1, f2, f3, f4, f5, b);
		else super.renderFace(entityCaps, f, f1, f2, f3, f4, f5, b);
	}	public void superRenderFace(Object entityCaps, float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
		super.renderFace((ModchuModel_IEntityCaps) entityCaps, f, f1, f2, f3, f4, f5, b);
	}	@Override
	public int setFaceTexture(int pIndex) {
		return customModel != null ? customModel.setFaceTexture(pIndex) : super.setFaceTexture(pIndex);
	}	public int superSetFaceTexture(int pIndex) {
		return super.setFaceTexture(pIndex);
	}	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
	}	public void superRender(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
	}	@Override
	public Modchu_ModelRenderer getRandomModelBox(Random random) {
		return (Modchu_ModelRenderer) (customModel != null ? customModel.getRandomModelBox(random) : super.getRandomModelBox(random));
	}	public Modchu_ModelRenderer superGetRandomModelBox(Object random) {
		return super.getRandomModelBox((Random) random);
	}	@Override
	public boolean canSpawnHear(Object world, int pX, int pY, int pZ) {
		return customModel != null ? customModel.canSpawnHear(world, pX, pY, pZ) : super.canSpawnHear(world, pX, pY, pZ);
	}	public boolean superCanSpawnHear(Object world, int pX, int pY, int pZ) {
		return super.canSpawnHear(world, pX, pY, pZ);
	}}