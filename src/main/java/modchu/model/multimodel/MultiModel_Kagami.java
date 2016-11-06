package modchu.model.multimodel;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModel_SR2;public class MultiModel_Kagami extends MultiModel_SR2 {
	public ModchuModel_ModelRenderer tailR;
	public ModchuModel_ModelRenderer tailRFA;
	public ModchuModel_ModelRenderer tailRBA;
	public ModchuModel_ModelRenderer tailRBB;
	public ModchuModel_ModelRenderer kamidomeR;
	public ModchuModel_ModelRenderer kamidomeRF;
	public ModchuModel_ModelRenderer kamidomeRB;
	public ModchuModel_ModelRenderer tailL;
	public ModchuModel_ModelRenderer kamidomeL;
	public ModchuModel_ModelRenderer kamidomeLF;
	public ModchuModel_ModelRenderer kamidomeLB;
	public ModchuModel_ModelRenderer tailLFA;
	public ModchuModel_ModelRenderer tailLBA;
	public ModchuModel_ModelRenderer tailLBB;	public MultiModel_Kagami() {
		this(0.0F);
	}	public MultiModel_Kagami(float f) {
		this(f, 0.0F);
	}	public MultiModel_Kagami(float f, float f1) {
		this(f, f1, 64, 64);
	}	public MultiModel_Kagami(float f, float f1, int i, int j) {
		super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
	}	@Override
	public void initModel(float f, float f1, boolean isAfterInit) {
		textureWidth = 64;
		textureHeight = 64;
		super.initModel(f, f1, false);
		tailR = new ModchuModel_ModelRenderer(this, 8, 40);
		tailR.addBox(3.4F, -6.5F, -0.5F, 1, 2, 2);
		tailR.setRotationPoint(0F, 0F, 0F);
		tailRFA = new ModchuModel_ModelRenderer(this, 0, 40);
		tailRFA.addBox(5F, -4F, -1.2F, 1, 7, 1);
		tailRFA.setRotationPoint(0F, 0F, 0F);
		tailRBA = new ModchuModel_ModelRenderer(this, 14, 40);
		tailRBA.addBox(4.8F, -4.2F, -2.266667F, 1, 8, 2);
		tailRBA.setRotationPoint(0F, 0F, 0F);
		tailRBB = new ModchuModel_ModelRenderer(this, 14, 50);
		tailRBB.addBox(5.2F, 2.2F, -1.2F, 1, 4, 1);
		tailRBB.setRotationPoint(0F, 0F, 0F);
		kamidomeR = new ModchuModel_ModelRenderer(this, 8, 34);
		kamidomeR.addBox(4.4F, -6F, 0F, 1, 1, 1);
		kamidomeR.setRotationPoint(0F, 0F, 0F);
		kamidomeRF = new ModchuModel_ModelRenderer(this, 0, 34);
		kamidomeRF.addBox(5F, -3.1F, -4.7F, 1, 2, 1);
		kamidomeRF.setRotationPoint(0F, 0F, 0F);
		kamidomeRB = new ModchuModel_ModelRenderer(this, 0, 37);
		kamidomeRB.addBox(5F, -2.5F, 4.5F, 1, 2, 1);
		kamidomeRB.setRotationPoint(0F, 0F, 0F);
		tailL = new ModchuModel_ModelRenderer(this, 8, 44);
		tailL.addBox(-4.4F, -6.5F, -0.5F, 1, 2, 2);
		tailL.setRotationPoint(0F, 0F, 0F);
		kamidomeL = new ModchuModel_ModelRenderer(this, 8, 36);
		kamidomeL.addBox(-5.4F, -6F, 0F, 1, 1, 1);
		kamidomeL.setRotationPoint(0F, 0F, 0F);
		kamidomeLF = new ModchuModel_ModelRenderer(this, 4, 34);
		kamidomeLF.addBox(-6.1F, -3.1F, -4.7F, 1, 2, 1);
		kamidomeLF.setRotationPoint(0F, 0F, 0F);
		kamidomeLB = new ModchuModel_ModelRenderer(this, 4, 37);
		kamidomeLB.addBox(-6F, -2.533333F, 4.5F, 1, 2, 1);
		kamidomeLB.setRotationPoint(0F, 0F, 0F);
		tailLFA = new ModchuModel_ModelRenderer(this, 4, 40);
		tailLFA.addBox(-6F, -4F, -1.25F, 1, 7, 1);
		tailLFA.setRotationPoint(0F, 0F, 0F);
		tailLBA = new ModchuModel_ModelRenderer(this, 20, 40);
		tailLBA.addBox(-5.9F, -4.2F, -2.3F, 1, 8, 2);
		tailLBA.setRotationPoint(0F, 0F, 0F);
		tailLBB = new ModchuModel_ModelRenderer(this, 20, 50);
		tailLBB.addBox(-6.35F, 2.2F, -1.2F, 1, 4, 1);
		tailLBB.setRotationPoint(0F, 0F, 0F);		tailRFA.rotateAngleX = tailLFA.rotateAngleX = -0.296706F;
		tailRFA.rotateAngleZ = kamidomeRF.rotateAngleY = kamidomeLB.rotateAngleY = -0.1745329F;
		tailRBA.rotateAngleX = tailLBA.rotateAngleX = 0.1570796F;
		tailRBA.rotateAngleY = tailRBB.rotateAngleY = -0.6108652F;
		tailRBA.rotateAngleZ = -0.2268928F;
		kamidomeRF.rotateAngleX = kamidomeLF.rotateAngleX = -0.7330383F;
		kamidomeRF.rotateAngleZ = kamidomeRB.rotateAngleZ = -0.122173F;
		kamidomeRB.rotateAngleX = kamidomeLB.rotateAngleX = 0.7330383F;
		kamidomeRB.rotateAngleY = kamidomeLF.rotateAngleY = tailLFA.rotateAngleZ = 0.1745329F;
		kamidomeLF.rotateAngleZ = kamidomeLB.rotateAngleZ = 0.122173F;
		tailLBA.rotateAngleY = tailLBB.rotateAngleY = 0.6108652F;
		tailLBA.rotateAngleZ = 0.2268928F;
		if (isAfterInit) afterInit(f, f1);
	}	@Override
	public void skirtFloatsInit(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		super.skirtFloatsInit(f, f1);
	}	@Override
	public void defaultAddChildSetting() {
		super.defaultAddChildSetting();
		bipedHead.addChild(tailR);
		bipedHead.addChild(tailRFA);
		bipedHead.addChild(tailRBA);
		bipedHead.addChild(tailRBB);
		bipedHead.addChild(kamidomeR);
		bipedHead.addChild(kamidomeRF);
		bipedHead.addChild(kamidomeRB);
		bipedHead.addChild(tailL);
		bipedHead.addChild(kamidomeL);
		bipedHead.addChild(kamidomeLF);
		bipedHead.addChild(kamidomeLB);
		bipedHead.addChild(tailLFA);
		bipedHead.addChild(tailLBA);
		bipedHead.addChild(tailLBB);
	}
}