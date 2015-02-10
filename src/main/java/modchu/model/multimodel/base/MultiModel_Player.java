package modchu.model.multimodel.base;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.characteristic.Modchu_CastHelper;import modchu.lib.characteristic.Modchu_ModelRenderer;import modchu.model.ModchuModel_IEntityCaps;public class MultiModel_Player extends MultiModel_Biped {
	public Modchu_ModelRenderer bipedJacket;
	public Modchu_ModelRenderer bipedRightSleeve;
	public Modchu_ModelRenderer bipedLeftSleeve;
	public Modchu_ModelRenderer bipedRightPants;
	public Modchu_ModelRenderer bipedLeftPants;
	public boolean slimFlag;	private Modchu_ModelRenderer rightArmSleeve;	private Modchu_ModelRenderer rightArmSleeve2;	private Modchu_ModelRenderer leftArmSleeve;	private Modchu_ModelRenderer leftArmSleeve2;	private Modchu_ModelRenderer rightLegPants;	private Modchu_ModelRenderer rightLegPants2;	private Modchu_ModelRenderer leftLegPants;	private Modchu_ModelRenderer leftLegPants2;	public MultiModel_Player() {
		this(0.0F);
	}	public MultiModel_Player(Object... o) {
		this(0.0F, o);
	}	public MultiModel_Player(float f) {
		this(f, 0.0F);
	}	public MultiModel_Player(float f, Object... o) {
		this(f, 0.0F, o);
	}	public MultiModel_Player(float f, float f1) {
		this(f, f1, 64, f == 0.0F ? 64 : 64);
	}	public MultiModel_Player(float f, float f1, Object... o) {
		this(f, f1, 64, f == 0.0F ? 64 : 64, o);
	}	public MultiModel_Player(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	public MultiModel_Player(float f, float f1, int i, int j, Object... o) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j, o);
	}	@Override
	public void initModel(float f, float f1, Object... o) {
		initModel(f, f1, true, (Object[]) o);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit, Object... o) {
		slimFlag = o != null				&& o.length > 0				&& f == 0.0F ? Modchu_CastHelper.Boolean(o[0]) : false;		if (f != 0.0F) textureHeight = 32;		super.initModel(f, f1, false, (Object[]) o);
		if (slimFlag) {
			bipedLeftArm = new Modchu_ModelRenderer(this, 32, 48);
			bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, f);
			bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
			bipedRightArm = new Modchu_ModelRenderer(this, 40, 16);
			bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, f);
			bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
		}
		if (f == 0.0F) {
			bipedJacket = new Modchu_ModelRenderer(this, 16, 32);
			bipedJacket.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, f + 0.49F);
			if (slimFlag) {
				bipedRightSleeve = new Modchu_ModelRenderer(this, 40, 32);
				bipedRightSleeve.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.249F);
				bipedLeftSleeve = new Modchu_ModelRenderer(this, 48, 48);
				bipedLeftSleeve.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.249F);
			} else {
				bipedRightSleeve = new Modchu_ModelRenderer(this, 40, 32);
				bipedRightSleeve.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.49F);
				bipedLeftSleeve = new Modchu_ModelRenderer(this, 48, 48);
				bipedLeftSleeve.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.49F);
			}
			bipedRightPants = new Modchu_ModelRenderer(this, 0, 32);
			bipedRightPants.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.49F);
			bipedLeftPants = new Modchu_ModelRenderer(this, 0, 48);
			bipedLeftPants.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.49F);
		}		if (isAfterInit) afterInit(f, f1);
	}	@Override	public void actionPartsInit(float f, float f1) {		super.actionPartsInit(f, f1);		if (modelSize != 0.0F) return;		rightArm = new Modchu_ModelRenderer(this, 40, 16);		rightArm.addBox(-2.0F, -1.0F, -1.0F, 3, 6, 4, f);		rightArm2 = new Modchu_ModelRenderer(this, 40, 24);		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 6, 4, f);		leftArm = new Modchu_ModelRenderer(this, 32, 48);		leftArm.addBox(0.0F, -1.0F, -1.0F, 3, 6, 4, f);		leftArm2 = new Modchu_ModelRenderer(this, 32, 56);		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 6, 4, f);		rightArmSleeve = new Modchu_ModelRenderer(this, 40, 32);		rightArmSleeve.addBox(-2.0F, -1.0F, -1.0F, 3, 6, 4, f);		rightArmSleeve2 = new Modchu_ModelRenderer(this, 40, 40);		rightArmSleeve2.addBox(-1.0F, 0.0F, -1.0F, 3, 6, 4, f);		leftArmSleeve = new Modchu_ModelRenderer(this, 48, 48);		leftArmSleeve.addBox(0.0F, -1.0F, -1.0F, 3, 6, 4, f);		leftArmSleeve2 = new Modchu_ModelRenderer(this, 48, 56);		leftArmSleeve2.addBox(-1.0F, 0.0F, -1.0F, 3, 6, 4, f);		rightLegPants = new Modchu_ModelRenderer(this, 0, 32);		rightLegPants.addBox(-2.5F, 0.0F, -2F, 4, 6, 4, f);		rightLegPants2 = new Modchu_ModelRenderer(this, 0, 38);		rightLegPants2.addBox(-1.1F, 0.0F, -1.5F, 4, 6, 4, f);		leftLegPants = new Modchu_ModelRenderer(this, 0, 48);		leftLegPants.addBox(-0.5F, 0.0F, -2F, 4, 6, 4, f);		leftLegPants2 = new Modchu_ModelRenderer(this, 0, 54);		leftLegPants2.addBox(-0.9F, 0.0F, -1.5F, 4, 6, 4, f);		rightHand.showModel = leftHand.showModel = rightArm.showModel =				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =						rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel =								rightArmSleeve.showModel = rightArmSleeve2.showModel = leftArmSleeve.showModel =										leftArmSleeve2.showModel = rightLegPants.showModel = rightLegPants2.showModel =												leftLegPants.showModel = leftLegPants2.showModel =	false;	}	@Override	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {		super.setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);		if (!slimFlag) return;		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		if (modelSize != 0.0F) return;		if (bipedBody != null) {
			if (bipedJacket != null) bipedBody.addChild(bipedJacket);
		}
		if (bipedRightSleeve != null) bipedRightArm.addChild(bipedRightSleeve);
		if (bipedLeftSleeve != null) bipedLeftArm.addChild(bipedLeftSleeve);
		if (bipedRightPants != null) bipedRightLeg.addChild(bipedRightPants);
		if (bipedLeftPants != null) bipedLeftLeg.addChild(bipedLeftPants);
	}	@Override
	public void actionPartsAddChild() {		super.actionPartsAddChild();
		if (modelSize != 0.0F) return;		boolean b = false;		setCapsValue(null, caps_visible, bipedRightSleeve, b);		setCapsValue(null, caps_visible, bipedLeftSleeve, b);		setCapsValue(null, caps_visible, bipedRightPants, b);		setCapsValue(null, caps_visible, bipedLeftPants, b);		b = true;		if (rightArm != null) setCapsValue(null, caps_visible, rightArmSleeve, b);		if (rightArm2 != null) setCapsValue(null, caps_visible, rightArmSleeve2, b);		if (leftArm != null) setCapsValue(null, caps_visible, leftArmSleeve, b);		if (leftArm2 != null) setCapsValue(null, caps_visible, leftArmSleeve2, b);		if (rightLeg != null) setCapsValue(null, caps_visible, rightLegPants, b);		if (rightLeg2 != null) setCapsValue(null, caps_visible, rightLegPants2, b);		if (leftLeg != null) setCapsValue(null, caps_visible, leftLegPants, b);		if (leftLeg2 != null) setCapsValue(null, caps_visible, leftLegPants2, b);		if (rightArm != null) {			if (rightArmSleeve != null) rightArm.addChild(rightArmSleeve);			if (rightArm2 != null) rightArm2.addChild(rightArmSleeve2);		}		if (leftArm != null) {			if (leftArmSleeve != null) leftArm.addChild(leftArmSleeve);			if (leftArm2 != null					&& leftArmSleeve2 != null) leftArm2.addChild(leftArmSleeve2);		}		if (rightLeg != null) {			if (rightLegPants != null) rightLeg.addChild(rightLegPants);			if (rightLeg2 != null					&& rightLegPants2 != null) rightLeg2.addChild(rightLegPants2);		}		if (leftLeg != null) {			if (leftLegPants != null) leftLeg.addChild(leftLegPants);			if (leftLeg2 != null					&& leftLegPants2 != null) leftLeg2.addChild(leftLegPants2);		}	}	@Override
	public void actionRelease(ModchuModel_IEntityCaps entityCaps, int i) {
		super.actionRelease(entityCaps, i);
		if (modelSize != 0.0F) return;		boolean b = true;		setCapsValue(null, caps_visible, bipedRightSleeve, b);		setCapsValue(null, caps_visible, bipedLeftSleeve, b);		setCapsValue(null, caps_visible, bipedRightPants, b);		setCapsValue(null, caps_visible, bipedLeftPants, b);		b = false;		setCapsValue(null, caps_visible, rightArmSleeve, b);		setCapsValue(null, caps_visible, rightArmSleeve2, b);		setCapsValue(null, caps_visible, leftArmSleeve, b);		setCapsValue(null, caps_visible, leftArmSleeve2, b);		setCapsValue(null, caps_visible, rightLegPants, b);		setCapsValue(null, caps_visible, rightLegPants2, b);		setCapsValue(null, caps_visible, leftLegPants, b);		setCapsValue(null, caps_visible, leftLegPants2, b);	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		String[] s = {
				"rightArm", "rightArm2", "rightArmPlus", "rightArmPlus2", "rightHand",
				"rightLeg", "rightLeg2", "rightLegPlus", "rightLegPlus2", "leftArm",
				"leftArm2", "leftArmPlus", "leftArmPlus2", "leftHand", "leftLeg",
				"leftLeg2", "leftLegPlus", "leftLegPlus2", "HeadMount", "mainFrame"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
		String[] s1 = {
				"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
				"bipedRightLeg", "bipedLeftLeg", "bipedJacket", "bipedRightSleeve", "bipedLeftSleeve",
				"bipedRightPants", "bipedLeftPants", "c", "d", "e",
				"f", "g", "h", "i", "j",
				"k", "field_78116_c", "field_78114_d", "field_78115_e", "field_78112_f",
				"field_78113_g", "field_78123_h", "field_78124_i", "field_78121_j", "field_78122_k"
		};
		String[] s2 = {
				"Head", "Headwear", "Body", "RightArm", "LeftArm",
				"RightLeg", "LeftLeg", "Jacket", "RightSleeve", "LeftSleeve",
				"RightPants", "LeftPants", "Head", "Headwear", "Body",
				"RightArm", "LeftArm", "RightLeg", "LeftLeg", "bipedCloak",
				"bipedEars", "bipedHead", "Headwear", "Body", "RightArm",
				"LeftArm", "RightLeg", "LeftLeg", "bipedEars", "bipedCloak"
		};
		setCapsValue(entityCaps, caps_showPartsRenemeMap, s1, s2);
	}
	public void setArmorBipedBodyShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		super.setArmorBipedBodyShowModel(entityCaps, b);		setCapsValue(entityCaps, caps_visible, bipedJacket, modelSize == 0.0F);	}	public void setArmorBipedRightArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		super.setArmorBipedRightArmShowModel(entityCaps, b);		setCapsValue(entityCaps, caps_visible, bipedRightSleeve, modelSize == 0.0F);	}	public void setArmorBipedLeftArmShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		super.setArmorBipedLeftArmShowModel(entityCaps, b);		setCapsValue(entityCaps, caps_visible, bipedLeftSleeve, modelSize == 0.0F);	}	public void setArmorBipedRightLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		super.setArmorBipedRightLegShowModel(entityCaps, b);		setCapsValue(entityCaps, caps_visible, bipedRightPants, modelSize == 0.0F);	}	public void setArmorBipedLeftLegShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {		super.setArmorBipedLeftLegShowModel(entityCaps, b);		setCapsValue(entityCaps, caps_visible, bipedLeftPants, modelSize == 0.0F);	}}