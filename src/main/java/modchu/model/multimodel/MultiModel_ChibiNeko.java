package modchu.model.multimodel;import java.util.Map;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_EntityCapsHelper;import modchu.lib.Modchu_Main;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_ChibiNeko extends MultiModel_SR2 {	public ModchuModel_ModelRenderer Prim;
	public ModchuModel_ModelRenderer Tail2;
	public ModchuModel_ModelRenderer Tail3;
	public ModchuModel_ModelRenderer Tail4;
	public ModchuModel_ModelRenderer Tail5;
	public ModchuModel_ModelRenderer Tail6;
	public ModchuModel_ModelRenderer Ahoge;
	public ModchuModel_ModelRenderer Skirt21;
	public ModchuModel_ModelRenderer Skirt22;
	public ModchuModel_ModelRenderer Skirt23;
	public ModchuModel_ModelRenderer Skirt24;
	public ModchuModel_ModelRenderer Skirt25;
	public ModchuModel_ModelRenderer Skirt26;
	public ModchuModel_ModelRenderer Skirt27;
	public ModchuModel_ModelRenderer Skirt28;
	public ModchuModel_ModelRenderer Skirt29;
	public ModchuModel_ModelRenderer Skirt210;
	public ModchuModel_ModelRenderer Skirt211;
	public ModchuModel_ModelRenderer Skirt212;
	public ModchuModel_ModelRenderer Skirt213;
	public ModchuModel_ModelRenderer Skirt214;
	public ModchuModel_ModelRenderer Skirt215;
	public ModchuModel_ModelRenderer Skirt216;
	public ModchuModel_ModelRenderer Band1;
	public ModchuModel_ModelRenderer EarL1;
	public ModchuModel_ModelRenderer EarL2;
	public ModchuModel_ModelRenderer EarR1;
	public ModchuModel_ModelRenderer EarR2;
	public ModchuModel_ModelRenderer EarLi1;
	public ModchuModel_ModelRenderer EarLi2;
	public ModchuModel_ModelRenderer EarRi1;
	public ModchuModel_ModelRenderer EarRi2;
	public ModchuModel_ModelRenderer Shippo1;
	public ModchuModel_ModelRenderer Shippo2;
	public ModchuModel_ModelRenderer Shippo3;
	public ModchuModel_ModelRenderer Shippo4;
	public ModchuModel_ModelRenderer Shippo5;
	public ModchuModel_ModelRenderer Shippo6;
	public ModchuModel_ModelRenderer Glass;
	public ModchuModel_ModelRenderer DrowaR1;
	public ModchuModel_ModelRenderer DrowaL1;
	public ModchuModel_ModelRenderer DrowaR2;
	public ModchuModel_ModelRenderer DrowaL2;
	public ModchuModel_ModelRenderer pink;
	private Map sizeMap;	private static final float Scale = 0.4F;	public MultiModel_ChibiNeko() {
		this(0.0F);
	}	public MultiModel_ChibiNeko(float f) {
		this(f, 0.0F);
	}	public MultiModel_ChibiNeko(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_ChibiNeko(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureHeight = 64;
		textureWidth = 64;
		f1 += 8F;
		bipedHead = new ModchuModel_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f - Scale);
		bipedBody = new ModchuModel_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f - Scale);
		bipedRightLeg = new ModchuModel_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-2F, 0.0F, -2F, 3, 9, 4, f - Scale);
		bipedLeftLeg = new ModchuModel_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0.0F, -2F, 3, 9, 4, f - Scale);		pink = new ModchuModel_ModelRenderer(this, 0, 8);
		pink.addPlate(-4f, -2.7f, -3.653f, 2, 1, 0);
		pink.addPlate(2f, -2.7f, -3.653f, 2, 1, 0);		DrowaR1 = new ModchuModel_ModelRenderer(this, 46, 25);
		DrowaR1.addBox(-2F, -0.0F, -2F, 3, 2, 4, f - 0.1F);
		DrowaR1.setRotationPoint(0.0F, 0.0F, 0.0F);		DrowaL1 = new ModchuModel_ModelRenderer(this, 46, 25);
		DrowaL1.mirror = true;
		DrowaL1.addBox(-1F, -0.0F, -2F, 3, 2, 4, f - 0.1F);
		DrowaL1.setRotationPoint(0.0F, 0.0F, 0.0F);		Skirt = new ModchuModel_ModelRenderer(this, 0, 16);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);		DrowaR2 = new ModchuModel_ModelRenderer(this, 46, 25);
		DrowaR2.addBox(-1.5F, 0F, -2F, 3, 2, 4, f);
		DrowaR2.setRotationPoint(-1.5F, -0.5F, 0.0F);		DrowaL2 = new ModchuModel_ModelRenderer(this, 46, 25);
		DrowaL2.mirror = true;
		DrowaL2.addBox(-1.5F, 0F, -2F, 3, 2, 4, f);
		DrowaL2.setRotationPoint(1.5F, -0.5F, 0.0F);		bipedRightArm = new ModchuModel_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f - Scale);
		bipedRightArm.setRotationPoint(-2.1F, 4.5F + 2 * Scale, 0F);
		bipedLeftArm = new ModchuModel_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f - Scale);
		bipedLeftArm.setRotationPoint(2.1F, 4.5F + 2 * Scale, 0.0F);		eyeR = new ModchuModel_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -4.9F, -4.001F, 4, 4, 0, f - Scale);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new ModchuModel_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f - Scale);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);		Glass = new ModchuModel_ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f - Scale);
		Glass.setRotationPoint(0.0F, -4.5F + 2.0F * Scale, -4.0F);		Prim = new ModchuModel_ModelRenderer(this, 4, 0);
		Prim.addPlate(-2F, -7.7F, -3.5F, 4, 1, 0, f - Scale / 2);
		Prim.setRotationPoint(0.0F, -0.0F + Scale, 0.0F);		ChignonB = new ModchuModel_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.5F, 3.1F, 4, 4, 2, f - 0.5F);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);		Tail = new ModchuModel_ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -6.5F, 4.5F, 2, 2, 2, f + 0.1F);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);		Tail2 = new ModchuModel_ModelRenderer(this, 46, 15);
		Tail2.addBox(0F, 1F, 0F, 2, 7, 2, f);
		Tail2.setRotationPoint(-1F, -6.0F, 4.7F);
		Tail2.isHidden = true;		Tail3 = new ModchuModel_ModelRenderer(this, 54, 15);
		Tail3.addBox(0F, 1F, 0F, 0, 8, 2, f + 0.0001F);
		Tail3.setRotationPoint(-0.5F, -6.8F, 4.5F);		Tail4 = new ModchuModel_ModelRenderer(this, 54, 15);
		Tail4.addPlate(0F, 1F, 0F, 2, 8, 0, f);
		Tail4.setRotationPoint(-1.0F, -6.8F, 5.0F);		Tail5 = new ModchuModel_ModelRenderer(this, 54, 15);
		Tail5.addBox(0F, 1F, 0F, 0, 8, 2, f + 0.0001F);
		Tail5.setRotationPoint(0.5F, -6.8F, 4.5F);		Tail6 = new ModchuModel_ModelRenderer(this, 54, 15);
		Tail6.mirror = true;
		Tail6.addPlate(0F, 1F, 0F, 2, 8, 0, f);
		Tail6.setRotationPoint(-1.0F, -6.8F, 6.0F);		Ahoge = new ModchuModel_ModelRenderer(this, 0, 1);
		Ahoge.addBox(0F, 0F, 0F, 0, 3, 4, f + 0.0001F);
		Ahoge.setRotationPoint(0F, -6.8F + Scale, -3.8F + Scale);		Skirt21 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt21.addPlate(-1.6F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt21.setRotationPoint(0F, -5.5F, 0F);		Skirt22 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt22.addPlate(-1.6F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt22.setRotationPoint(0F, -5.5F, 0F);		Skirt23 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt23.addPlate(0F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt23.setRotationPoint(0F, -6F, 0F);		Skirt24 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt24.addPlate(0F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt24.setRotationPoint(0F, -6F, 0F);		Skirt25 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt25.addPlate(0F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt25.setRotationPoint(0F, -6F, 0F);		Skirt26 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt26.addPlate(0F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt26.setRotationPoint(0F, -6F, 0F);		Skirt27 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt27.addPlate(-1.6F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt27.setRotationPoint(0F, -5.5F, 0F);		Skirt28 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt28.addPlate(-1.6F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt28.setRotationPoint(0F, -5.5F, 0F);		Skirt29 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt29.addPlate(-1.6F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt29.setRotationPoint(0F, -5.5F, 0F);		Skirt210 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt210.addPlate(-1.6F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt210.setRotationPoint(0F, -5.5F, 0F);		Skirt211 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt211.addPlate(0F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt211.setRotationPoint(0F, -6F, 0F);		Skirt212 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt212.addPlate(0F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt212.setRotationPoint(0F, -6F, 0F);		Skirt213 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt213.addPlate(0F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt213.setRotationPoint(0F, -6F, 0F);		Skirt214 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt214.addPlate(0F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt214.setRotationPoint(0F, -6F, 0F);		Skirt215 = new ModchuModel_ModelRenderer(this, 0, 32);
		Skirt215.addPlate(-1.6F + 14F, -12F, 0F, 30, 12, 0, f);
		Skirt215.setRotationPoint(0F, -5.5F, 0F);		Skirt216 = new ModchuModel_ModelRenderer(this, 0, 44);
		Skirt216.addPlate(-1.6F + 14F, 0F, 0F, 30, 12, 0, f);
		Skirt216.setRotationPoint(0F, -5.5F, 0F);		Band1 = new ModchuModel_ModelRenderer(this, 0, 56);
		Band1.addBox(-3F, 0F, -2F, 6, 4, 4, f);
		Band1.setRotationPoint(0F, -3.5F, 0F);		EarL1 = new ModchuModel_ModelRenderer(this, 0, 16);
		EarL1.addPlate(0F, 0F, 0F, 16, 16, 0, f);
		EarL1.setRotationPoint(3.0F - Scale, -6.5F, -0.4F);
		EarL1.setRotateAngleDeg(8F, 80F, -40F);		EarL2 = new ModchuModel_ModelRenderer(this, 0, 16);
		EarL2.mirror = true;
		EarL2.addPlate(-16F, 0F, 0F, 16, 16, 0, f);
		EarL2.setRotationPoint(3.0F - Scale, -6.5F, -0.4F);
		EarL2.setRotateAngleDeg(60F, -100F, 40F);		EarR1 = new ModchuModel_ModelRenderer(this, 0, 16);
		EarR1.addPlate(0F, 0F, 0F, 16, 16, 0, f);
		EarR1.setRotationPoint(-(3.0F - Scale), -6.5F, -0.4F);
		EarR1.setRotateAngleDeg(60F, 100F, -40F);		EarR2 = new ModchuModel_ModelRenderer(this, 0, 16);
		EarR2.mirror = true;
		EarR2.addPlate(-16F, 0F, 0F, 16, 16, 0, f);
		EarR2.setRotationPoint(-(3.0F - Scale), -6.5F, -0.4F);
		EarR2.setRotateAngleDeg(8F, -80F, 40F);		EarLi1 = new ModchuModel_ModelRenderer(this, 16, 16);
		EarLi1.addPlate(0F, 0F, 0F, 16, 16, 0, f);
		EarLi1.setRotationPoint(3.0F - Scale, -6.5F, -0.5F);
		EarLi1.setRotateAngleDeg(8F, 80F, -40F);		EarLi2 = new ModchuModel_ModelRenderer(this, 16, 16);
		EarLi2.mirror = true;
		EarLi2.addPlate(-16F, 0F, 0F, 16, 16, 0, f);
		EarLi2.setRotationPoint(3.0F - Scale, -6.5F, -0.5F);
		EarLi2.setRotateAngleDeg(60F, -100F, 40F);		EarRi1 = new ModchuModel_ModelRenderer(this, 16, 16);
		EarRi1.addPlate(0F, 0F, 0F, 16, 16, 0, f);
		EarRi1.setRotationPoint(-(3.0F - Scale), -6.5F, -0.5F);
		EarRi1.setRotateAngleDeg(60F, 100F, -40F);		EarRi2 = new ModchuModel_ModelRenderer(this, 16, 16);
		EarRi2.mirror = true;
		EarRi2.addPlate(-16F, 0F, 0F, 16, 16, 0, f);
		EarRi2.setRotationPoint(-(3.0F - Scale), -6.5F, -0.5F);
		EarRi2.setRotateAngleDeg(8F, -80F, 40F);		Shippo1 = new ModchuModel_ModelRenderer(this, 60, 16);
		Shippo1.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo1.setRotationPoint(0F, 3.6F + Scale, 2F - Scale);
		Shippo1.setRotateAngleDeg(125F, 0F, 0F);		Shippo2 = new ModchuModel_ModelRenderer(this, 60, 18);
		Shippo2.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo2.setRotationPoint(0F, 1.7F, 0F);
		Shippo2.setRotateAngleDeg(20F, 0F, 0F);		Shippo3 = new ModchuModel_ModelRenderer(this, 60, 20);
		Shippo3.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo3.setRotationPoint(0F, 1.7F, 0F);
		Shippo3.setRotateAngleDeg(10F, 0F, 0F);		Shippo4 = new ModchuModel_ModelRenderer(this, 60, 22);
		Shippo4.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo4.setRotationPoint(0F, 1.8F, 0F);
		Shippo4.setRotateAngleDeg(5F, 0F, 0F);		Shippo5 = new ModchuModel_ModelRenderer(this, 60, 24);
		Shippo5.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo5.setRotationPoint(0F, 1.8F, 0F);
		Shippo5.setRotateAngleDeg(-5F, 0F, 0F);		Shippo6 = new ModchuModel_ModelRenderer(this, 60, 27);
		Shippo6.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
		Shippo6.setRotationPoint(0F, 1.7F, 0F);
		Shippo6.setRotateAngleDeg(-15F, 0F, 0F);		mainFrame = new ModchuModel_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);		int i = ModchuModel_ModelRenderer.ZYX;
		Prim.setRotatePriority(i);
		i = ModchuModel_ModelRenderer.YZX;
		DrowaR2.setRotatePriority(i);
		DrowaL2.setRotatePriority(i);
		Glass.setRotatePriority(i);
		EarL1.setRotatePriority(i);
		EarL2.setRotatePriority(i);
		EarR1.setRotatePriority(i);
		EarR2.setRotatePriority(i);
		EarLi1.setRotatePriority(i);
		EarLi2.setRotatePriority(i);
		EarRi1.setRotatePriority(i);
		EarRi2.setRotatePriority(i);
		Skirt21.setRotatePriority(i);
		Skirt22.setRotatePriority(i);
		Skirt23.setRotatePriority(i);
		Skirt24.setRotatePriority(i);
		Skirt25.setRotatePriority(i);
		Skirt26.setRotatePriority(i);
		Skirt27.setRotatePriority(i);
		Skirt28.setRotatePriority(i);
		Skirt29.setRotatePriority(i);
		Skirt210.setRotatePriority(i);
		Skirt211.setRotatePriority(i);
		Skirt212.setRotatePriority(i);
		Skirt213.setRotatePriority(i);
		Skirt214.setRotatePriority(i);
		Skirt215.setRotatePriority(i);
		Skirt216.setRotatePriority(i);		Band1.setScale(0.9F, 0.35F, 0.9F);
		Glass.setScale(0.47F, 0.47F, 1.0F);
		EarL1.setScale(0.25F, 0.25F, 1.0F);
		EarL2.setScale(0.25F, 0.25F, 1.0F);
		EarR1.setScale(0.25F, 0.25F, 1.0F);
		EarR2.setScale(0.25F, 0.25F, 1.0F);
		EarLi1.setScale(0.2F, 0.2F, 1.0F);
		EarLi2.setScale(0.2F, 0.2F, 1.0F);
		EarRi1.setScale(0.2F, 0.2F, 1.0F);
		EarRi2.setScale(0.2F, 0.2F, 1.0F);		Skirt21.setScale(0.22F, 0.22F, 1.0F);
		Skirt22.setScale(0.22F, 0.22F, 1.0F);
		Skirt23.setScale(0.22F, 0.22F, 1.0F);
		Skirt24.setScale(0.22F, 0.22F, 1.0F);
		Skirt25.setScale(0.22F, 0.22F, 1.0F);
		Skirt26.setScale(0.22F, 0.22F, 1.0F);
		Skirt27.setScale(0.22F, 0.22F, 1.0F);
		Skirt28.setScale(0.22F, 0.22F, 1.0F);
		Skirt29.setScale(0.22F, 0.22F, 1.0F);
		Skirt210.setScale(0.22F, 0.22F, 1.0F);
		Skirt211.setScale(0.22F, 0.22F, 1.0F);
		Skirt212.setScale(0.22F, 0.22F, 1.0F);
		Skirt213.setScale(0.22F, 0.22F, 1.0F);
		Skirt214.setScale(0.22F, 0.22F, 1.0F);
		Skirt215.setScale(0.22F, 0.22F, 1.0F);
		Skirt216.setScale(0.22F, 0.22F, 1.0F);
		pink.setScale(0.75F, 0.75F, 1F);		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void actionPartsInit(float f, float f1) {
		f = f - Scale;
		super.actionPartsInit(f, f1);
		rightArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus.setTextureOffset(50, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;		rightArm2 = new ModchuModel_ModelRenderer(this, 48, 3);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		rightArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;		leftArmPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;		leftArm2 = new ModchuModel_ModelRenderer(this, 56, 3);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);		leftArmPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f);
		((ModchuModel_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;		rightLegPlus = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -3.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;		rightLegPlus2 = new ModchuModel_ModelRenderer(this);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -1.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) rightLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;		leftLegPlus = new ModchuModel_ModelRenderer(this);
		leftLegPlus.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -3.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;		leftLegPlus2 = new ModchuModel_ModelRenderer(this);
		leftLegPlus2.mirror = true;
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -1.01F, 3, 4, 4, f);
		((ModchuModel_ModelRenderer) leftLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;
		rightHand.showModel = leftHand.showModel = rightArm.showModel =
				leftArm.showModel = rightArmPlus.showModel = rightArmPlus2.showModel =
				leftArmPlus.showModel = leftArmPlus2.showModel = rightLegPlus.showModel =
				rightLegPlus2.showModel = leftLegPlus.showModel = leftLegPlus2.showModel =
				rightArm2.showModel = leftArm2.showModel = rightLeg.showModel =
				rightLeg2.showModel = leftLeg.showModel = leftLeg2.showModel = false;
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.removeChild(ChignonR);
		bipedHead.removeChild(ChignonL);
		bipedHead.removeChild(SideTailR);
		bipedHead.removeChild(SideTailL);
		bipedHead.addChild(pink);
		bipedRightLeg.addChild(DrowaR1);
		bipedLeftLeg.addChild(DrowaL1);
		bipedHead.addChild(Glass);
		bipedHead.addChild(Prim);
		bipedHead.addChild(Tail);
		bipedHead.addChild(Tail2);
		bipedHead.addChild(Tail3);
		bipedHead.addChild(Tail4);
		bipedHead.addChild(Tail5);
		bipedHead.addChild(Tail6);
		bipedHead.addChild(Ahoge);
		bipedHead.addChild(EarL1);
		bipedHead.addChild(EarL2);
		bipedHead.addChild(EarR1);
		bipedHead.addChild(EarR2);
		bipedHead.addChild(EarLi1);
		bipedHead.addChild(EarLi2);
		bipedHead.addChild(EarRi1);
		bipedHead.addChild(EarRi2);
		bipedBody.addChild(Shippo1);
		Shippo1.addChild(Shippo2);
		Shippo2.addChild(Shippo3);
		Shippo3.addChild(Shippo4);
		Shippo4.addChild(Shippo5);
		Shippo5.addChild(Shippo6);
		Skirt.addChild(Skirt21);
		Skirt.addChild(Skirt22);
		Skirt.addChild(Skirt23);
		Skirt.addChild(Skirt24);
		Skirt.addChild(Skirt25);
		Skirt.addChild(Skirt26);
		Skirt.addChild(Skirt27);
		Skirt.addChild(Skirt28);
		Skirt.addChild(Skirt29);
		Skirt.addChild(Skirt210);
		Skirt.addChild(Skirt211);
		Skirt.addChild(Skirt212);
		Skirt.addChild(Skirt213);
		Skirt.addChild(Skirt214);
		Skirt.addChild(Skirt215);
		Skirt.addChild(Skirt216);
		Skirt.addChild(DrowaR2);
		Skirt.addChild(DrowaL2);
		Skirt.addChild(Band1);
	}	@Override
	public void actionPartsAddChild() {
		super.actionPartsAddChild();
		rightArm.removeChild(rightArmPlus);
		rightArm2.removeChild(rightHand);
		rightArm2.removeChild(rightArmPlus2);
		if (Arms[0] != null) rightArm2.addChild(Arms[0]);		leftArm.removeChild(leftArmPlus);
		leftArm2.removeChild(leftHand);
		leftArm2.removeChild(leftArmPlus2);
		if (Arms[1] != null) leftArm2.addChild(Arms[1]);		rightLeg.removeChild(rightLegPlus);
		rightLeg2.removeChild(rightLegPlus2);
		leftLeg.removeChild(leftLegPlus);
		leftLeg2.removeChild(leftLegPlus2);
	}	@Override
	public void defaultSkirtFloatsAddChild() {
	}	@Override
	public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
		bipedBody.setRotationPoint(0.0F, -3.0F * Scale, 0.0F);
		bipedRightLeg.setRotationPoint(-0.9F, 15.0F + Scale, 0.0F);
		bipedLeftLeg.setRotationPoint(0.9F, 15.0F + Scale, 0.0F);
		HeadTop.setRotationPoint(0.0F, -6.0F, 0.0F);
		bipedRightArm.setRotationPoint(-2.1F, 4.5F + 2 * Scale, 0F);		bipedLeftArm.setRotationPoint(2.1F, 4.5F + 2 * Scale, 0.0F);		int version = Modchu_Main.getMinecraftVersion();		if (version > 189) Arms[1].setRotateAngle(0.0F, 0.0F, 0.0F);	}	@Override
	public void setLivingAnimationsLM(ModchuModel_IEntityCaps entityCaps, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityCaps, f, f1, f2);
		Object entityliving = Modchu_EntityCapsHelper.getCapsValue(entityCaps, entityCaps.caps_Entity);
		if (entityliving != null); else return;		setCapsValue(entityCaps, caps_visible, pink, (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)));
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, entityliving);
		float f3 = (float)ticksExisted + f2 + Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		if (0.0F > mh_sin(f3 * 0.17F) + mh_sin(f3 * 0.17F + 0.02F) + mh_sin(f3 * 0.11F) + mh_sin(f3 * 0.7F) + 3.1F) {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -0.5235988F;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 0.5235988F;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = ((float) Math.PI / 2F);
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -((float) Math.PI / 2F);
			EarR1.rotateAngleY = EarRi1.rotateAngleY = ((float) Math.PI / 2F);
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -((float) Math.PI / 2F);
		} else {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -((float) Math.PI * 2F / 9F);
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = ((float) Math.PI * 2F / 9F);
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 1.396263F;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -1.745329F;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 1.745329F;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -1.396263F;
		}
	}	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		bipedRightArm.rotateAngleX =
				bipedRightArm.rotateAngleY =
				bipedRightArm.rotateAngleZ =
				bipedLeftArm.rotateAngleX =
				bipedLeftArm.rotateAngleY =
				bipedLeftArm.rotateAngleZ =
		bipedRightLeg.rotateAngleX =
				bipedRightLeg.rotateAngleY =
				bipedRightLeg.rotateAngleZ =
				bipedLeftLeg.rotateAngleX =
				bipedLeftLeg.rotateAngleY =
				bipedLeftLeg.rotateAngleZ = 0.0F;
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);		float t = f2;
		float idFactor = Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_entityIdFactor);
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_isLookSuger)) t *= 2F;
		Ahoge.rotateAngleY = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, t * 0.2F + Modchu_AS.getFloat(Modchu_AS.mathHelperCos, t * 0.05F + idFactor) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX = Modchu_AS.getFloat(Modchu_AS.mathHelperCos, t * 0.02F + Modchu_AS.getFloat(Modchu_AS.mathHelperCos, t * 0.05F + idFactor) * 1.0F) * 0.0015F;
		Ahoge.rotateAngleZ = 0.02F;
		bipedHead.rotationPointZ = 0.0F;
		bipedRightArm.rotationPointY = -4.5F + 4 * Scale;
		bipedLeftArm.rotationPointY = -4.5F + 4 * Scale;
		DrowaR2.rotationPointY = -2.0F;
		DrowaR2.rotationPointZ = 0.0F;
		DrowaL2.rotationPointY = -2.0F;
		DrowaL2.rotationPointZ = 0.0F;		if (bipedHead.rotateAngleX > Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_convertDegtoRad, 10F)) Tail2.rotateAngleX = Tail3.rotateAngleX = Tail4.rotateAngleX = Tail5.rotateAngleX = Tail6.rotateAngleX = -Modchu_EntityCapsHelper.getCapsValueFloat(this, entityCaps, caps_convertDegtoRad, 10F);
		else Tail2.rotateAngleX = Tail3.rotateAngleX = Tail4.rotateAngleX = Tail5.rotateAngleX = Tail6.rotateAngleX = -bipedHead.rotateAngleX;//+bipedBody.rotateAngleX);
		Shippo1.rotateAngleX = 125F / 180F * (float) Math.PI + 0.025F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.6F + idFactor);
		Shippo2.rotateAngleX = 20F / 180F * (float) Math.PI;
		Shippo3.rotateAngleX = 10F / 180F * (float) Math.PI;
		Shippo4.rotateAngleX = 5F / 180F * (float) Math.PI;
		Shippo5.rotateAngleX = -5F / 180F * (float) Math.PI;
		Shippo6.rotateAngleX = -15F / 180F * (float) Math.PI;
		Shippo1.rotateAngleY = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, t * 0.3F + idFactor);
		Shippo2.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.3F + 0.000005F + idFactor);
		Shippo3.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.3F + 0.00001F + idFactor);
		Shippo4.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.3F + 0.000015F + idFactor);
		Shippo5.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.3F + 0.00002F + idFactor);
		Shippo6.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.3F + 0.000025F + idFactor);		Skirt.rotationPointX = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsRiding)) {
			Shippo1.rotateAngleX = 125F / 180F * (float) Math.PI + 0.025F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.4F + idFactor);
			Shippo1.rotateAngleY = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, t * 0.2F + idFactor);
			Shippo2.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0002F + idFactor);
			Shippo3.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0004F + idFactor);
			Shippo4.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0006F + idFactor);
			Shippo5.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0008F + idFactor);
			Shippo6.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.001F + idFactor);
			Skirt.rotateAngleX -= 0.8F;
		} else {
			setRotationAnglesGulliverBefore(f, f1, f2, f3, f4, f5, entityCaps);
		}
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
			Shippo1.rotateAngleX = 145F / 180F * (float) Math.PI;
			Shippo2.rotateAngleX = Shippo3.rotateAngleX = Shippo4.rotateAngleX = Shippo5.rotateAngleX = Shippo6.rotateAngleX = 0F;
			Shippo1.rotateAngleY = Shippo2.rotateAngleZ = Shippo3.rotateAngleZ = Shippo4.rotateAngleZ = Shippo5.rotateAngleZ = Shippo6.rotateAngleZ = 0F;
		}
		bipedHead.rotationPointY = -5.0F + 5.0F * Scale;
		bipedBody.rotationPointY = 12.0F + Scale;
		bipedRightLeg.rotationPointY = 2.5F + Scale;
		bipedLeftLeg.rotationPointY = 2.5F + Scale;
		Skirt.rotationPointY = 3.0F + 2.0F * Scale;
		Skirt.rotationPointZ = 0.0F;
		if (Modchu_EntityCapsHelper.getCapsValueBoolean(this, entityCaps, caps_getIsSneak)) {
			Shippo1.rotateAngleX = 125F / 180F * (float) Math.PI + 0.025F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.4F + idFactor);
			Shippo1.rotateAngleY = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, t * 0.2F + idFactor);
			Shippo2.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0002F + idFactor);
			Shippo3.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0004F + idFactor);
			Shippo4.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0006F + idFactor);
			Shippo5.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.0008F + idFactor);
			Shippo6.rotateAngleZ = 0.2F * Modchu_AS.getFloat(Modchu_AS.mathHelperSin, -t * 0.2F + 0.001F + idFactor);
			//Skirt.rotateAngleX += 0.3F;
			//Skirt.rotationPointZ = 3.0F;
			//bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 3.0F;
			//bipedHead.rotationPointY = 8.5F + 5.0F * Scale;
		}
		if (0.0F > mh_sin(t * 0.17F) + mh_sin(t * 0.17F + 0.02F) + mh_sin(t * 0.11F) + mh_sin(t * 0.7F) + 3.10F) {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -30F / 180F * (float) Math.PI;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 30F / 180F * (float) Math.PI;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 90F / 180F * (float) Math.PI;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -90F / 180F * (float) Math.PI;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 90F / 180F * (float) Math.PI;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -90F / 180F * (float) Math.PI;
		} else {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -40F / 180F * (float) Math.PI;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 40F / 180F * (float) Math.PI;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 80F / 180F * (float) Math.PI;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -100F / 180F * (float) Math.PI;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 100F / 180F * (float) Math.PI;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -80F / 180F * (float) Math.PI;
		}		setRotationAnglesGulliverAfter(f, f1, f2, f3, f4, f5, entityCaps);
		skirtFloats(f, f1, t, f3, f4, f5, entityCaps);
	}	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		if (Modchu_EntityCapsHelper.getCapsValueInt(this, null, caps_skirtFloats) < 2) return;
		float motionY = (float) Modchu_EntityCapsHelper.getCapsValueDouble(this, entityCaps, caps_skirtFloatsMotionY);;
		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);		Skirt21.rotateAngleZ += motionY;
		Skirt22.rotateAngleX += motionY;
		Skirt22.rotateAngleZ += motionY;
		Skirt23.rotateAngleX += motionY;
		Skirt23.rotateAngleZ += motionY;
		Skirt24.rotateAngleX += motionY;
		Skirt24.rotateAngleZ += motionY;
		Skirt25.rotateAngleX += motionY;
		Skirt25.rotateAngleZ += motionY;
		Skirt26.rotateAngleX += motionY;
		Skirt26.rotateAngleZ += motionY;
		Skirt27.rotateAngleZ += motionY;
		Skirt28.rotateAngleZ += motionY;
		Skirt29.rotateAngleZ += motionY;
		Skirt210.rotateAngleY += motionY;
		Skirt210.rotateAngleZ += motionY;
		Skirt211.rotateAngleY += motionY;
		Skirt211.rotateAngleZ += motionY;
		Skirt212.rotateAngleY += motionY;
		Skirt212.rotateAngleZ += motionY;
		Skirt213.rotateAngleY += motionY;
		Skirt213.rotateAngleZ += motionY;
		Skirt214.rotateAngleY += motionY;
		Skirt214.rotateAngleZ += motionY;
		Skirt215.rotateAngleY += motionY;
		Skirt215.rotateAngleZ += motionY;
		Skirt216.rotateAngleZ += motionY;
	}	@Override
	public void defaultPartsSettingBefore(ModchuModel_IEntityCaps entityCaps) {
		super.defaultPartsSettingBefore(entityCaps);
		String[] s = {
				"Skirt21", "Skirt22", "Skirt23", "Skirt24", "Skirt25",
				"Skirt26", "Skirt27", "Skirt27", "Skirt28", "Skirt29",
				"Skirt210", "Skirt211", "Skirt212", "Skirt213", "Skirt214",
				"Skirt215", "Skirt216"
		};
		setCapsValue(entityCaps, caps_showPartsHideList, (Object) s);
	}	@Override
	public void action1(float f, float f1, float f2, float f3, float f4, float f5, ModchuModel_IEntityCaps entityCaps) {
		super.action1(f, f1, f2, f3, f4, f5, entityCaps);
		rightArm2.rotationPointX = 1.0F - (1.0F * Scale);
		leftArm2.rotationPointX = 0.0F - (1.0F * Scale);
		leftArm2.rotationPointY = 4.0F - (1.0F * Scale);
		rightHand.rotationPointY = 3.0F;
		leftHand.rotationPointY = 3.0F;		rightLeg.rotationPointY += 1.5F - (1.5F * Scale) / 2.0F;
		rightLeg2.rotationPointY -= 1.5F - (1.5F * Scale) / 2.0F;
		leftLeg.rotationPointY += 1.5F - (1.5F * Scale) / 2.0F;
		leftLeg2.rotationPointY -= 1.5F - (1.5F * Scale) / 2.0F;
	}	@Override
	public float getHeight(ModchuModel_IEntityCaps entityCaps) {
		return 1.25F;
	}	@Override
	public float getWidth(ModchuModel_IEntityCaps entityCaps) {
		return 0.5F;
	}	@Override
	public float getYOffset(ModchuModel_IEntityCaps entityCaps) {
		return 1.07F;
	}	@Override
	public void setArmorBipedHeadShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		bipedHead.isHidden = !b;
		super.setArmorBipedHeadShowModel(entityCaps, b);
	}	@Override
	public void setArmorSkirtShowModel(ModchuModel_IEntityCaps entityCaps, boolean b) {
		super.setArmorSkirtShowModel(entityCaps, b);
		Skirt.isHidden = !b;
	}
}