package net.minecraft.src;



import org.lwjgl.opengl.GL11;

public class MultiModelSmart_Aug extends MultiModelSmart {

	public Modchu_ModelRotationRenderer sidetailUpperR;
	public Modchu_ModelRotationRenderer sidetailUpperL;

	public Modchu_ModelRotationRenderer shaggyB;
	public Modchu_ModelRotationRenderer shaggyR;
	public Modchu_ModelRotationRenderer shaggyL;

	public Modchu_ModelRotationRenderer sensor1;
	public Modchu_ModelRotationRenderer sensor2;
	public Modchu_ModelRotationRenderer sensor3;
	public Modchu_ModelRotationRenderer sensor4;

	public Modchu_ModelRotationRenderer eyeR;
	public Modchu_ModelRotationRenderer eyeL;


    public MultiModelSmart_Aug(float var1)
    {
        this(var1, Scale, Scale);
    }

    public MultiModelSmart_Aug(float var1, int var2, int var3)
    {
        super(var1, var2, var3);

		// 変更パーツ
		SideTailR = new Modchu_ModelRotationRenderer(this, 46, 20, bipedHead);
		SideTailR.addBox(-1.5F, -0.5F, -1.0F, 2, 10, 2, var1);
		SideTailR.setRotationPointLM(0F, 0.0F + var2, 0.0F);
		SideTailR.setPreRotationPointLM(-5F, -7.8F, 1.9F);
		SideTailL = new Modchu_ModelRotationRenderer(this, 54, 20, bipedHead);
		SideTailL.addBox(0.5F, -0.5F, -1.0F, 2, 10, 2, var1);
		SideTailL.setRotationPointLM(0F, 0.0F + var2, 0.0F);
		SideTailL.setPreRotationPointLM(4F, -7.8F, 1.9F);
		ChignonR = new Modchu_ModelRotationRenderer(this, 0, 18, bipedHead);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, var1);
		ChignonR.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		ChignonR.setPreRotationPointLM(0.0F, -1.5F, 0.0F);
		ChignonL.setPreRotationPointLM(0.0F, -1.5F, 0.0F);

		// 増加パーツ
		sidetailUpperR = new Modchu_ModelRotationRenderer(this, 52, 10, bipedHead);
		sidetailUpperR.addBoxLM(-4.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperR.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sidetailUpperR.setPreRotationPointLM(-3.5F, -9.5F, 1.9F);
		sidetailUpperL = new Modchu_ModelRotationRenderer(this, 52, 15, bipedHead);
		sidetailUpperL.addBoxLM(0.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperL.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sidetailUpperL.setPreRotationPointLM(3.5F, -9.5F, 1.9F);

		shaggyB = new Modchu_ModelRotationRenderer(this, 24, 0, bipedHead);
		shaggyB.addPlate(-5.0F, 0.0F, 0.0F, 10, 4, 4);
		shaggyB.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		shaggyB.setRotateAngleX(0.4F);
		shaggyB.setPreRotationPointLM(0.0F, -1.0F + var2, 4.0F);
		shaggyR = new Modchu_ModelRotationRenderer(this, 24, 4, bipedHead);
		shaggyR.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 5);
		shaggyR.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		shaggyR.setRotateAngleZ(0.4F);
		shaggyR.setPreRotationPointLM(-4.0F, -1.0F + var2, 0.0F);
		shaggyL = new Modchu_ModelRotationRenderer(this, 34, 4, bipedHead);
		shaggyL.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 1);
		shaggyL.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		shaggyL.setRotateAngleZ(-0.4F);
		shaggyL.setPreRotationPointLM(4.0F, -1.0F + var2, 0.0F);

		sensor1 = new Modchu_ModelRotationRenderer(this, 0, 0, bipedHead);
		sensor1.addPlate(-8.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor1.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sensor1.setPreRotationPointLM(0.0F, -8.0F + var2, 0.0F);
		sensor2 = new Modchu_ModelRotationRenderer(this, 0, 4, bipedHead);
		sensor2.addPlate(0.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor2.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sensor2.setPreRotationPointLM(0.0F, -8.0F + var2, 0.0F);
		sensor3 = new Modchu_ModelRotationRenderer(this, 44, 0, bipedHead);
		sensor3.addPlate(0.0F, -7.0F, -4.0F, 4, 8, 1);
		sensor3.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sensor3.setPreRotationPointLM(0.0F, -8.0F + var2, 0.0F);
		sensor4 = new Modchu_ModelRotationRenderer(this, 34, 0, bipedHead);
		sensor4.addPlate(0.0F, -4.0F, -10.0F, 10, 4, 1);
		sensor4.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		sensor4.setPreRotationPointLM(0.0F, -8.0F + var2, 0.0F);

		eyeR = new Modchu_ModelRotationRenderer(this, 32, 19, bipedHead);
		eyeR.addPlate(-4.0F, -4.9F, -4.001F, 4, 4, 0);
		eyeR.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);
		eyeL = new Modchu_ModelRotationRenderer(this, 42, 19, bipedHead);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0);
		eyeL.setRotationPointLM(0.0F, 0.0F + var2, 0.0F);

		// 未使用パーツ
		((Modchu_ModelRotationRenderer) bipedHeadwear).setVisible(false);
		Tail.setVisible(false);
		ChignonB.setVisible(false);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		if (bipedHead.showModel) {
		sidetailUpperR.preRotateRender(f5);
		sidetailUpperL.preRotateRender(f5);

		shaggyB.preRotateRender(f5);
		shaggyR.preRotateRender(f5);
		shaggyL.preRotateRender(f5);

		sensor1.preRotateRender(f5);
		sensor2.preRotateRender(f5);
		sensor3.preRotateRender(f5);
		sensor4.preRotateRender(f5);

		eyeR.preRotateRender(f5);
		eyeL.preRotateRender(f5);
		}
	}

	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f,
			float f1, float f2) {
		super.setLivingAnimationsLM(entityliving, f, f1, f2);

			float f3 = (float)entityliving.ticksExisted + f2;
			float f4 = 0.0F;
			sensor1.rotateAngleY = -40.0F / 57.29578F;
			sensor2.rotateAngleY = 40.0F / 57.29578F;
			sensor1.rotateAngleX = sensor1.rotateAngleZ = (mh_sin(f3 * 0.067F) * 0.05F - f4);
			sensor2.rotateAngleX = sensor2.rotateAngleZ = -(mh_sin(f3 * 0.067F) * 0.05F - f4);
			sensor3.rotateAngleX = mh_sin(f3 * 0.067F) * 0.05F - 1.2F - f4;
			sensor3.rotateAngleY = mh_sin(f3 * 0.09F) * 0.4F;
			sensor3.rotateAngleZ = mh_cos(f3 * 0.09F) * 0.2F;
			sensor4.rotateAngleX = mh_sin(f3 * 0.067F) * 0.05F + f4;
			sensor4.rotateAngleY = mh_cos(f3 * 0.09F) * 0.5F;
			sensor4.rotateAngleZ = mh_sin(f3 * 0.09F) * 0.2F;
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5);

		SideTailR.rotateAngleX =  SideTailL.rotateAngleX = -((Modchu_ModelRotationRenderer) bipedHead).getRotateAngleX() / 1.5F;

		if (aimedBow) {
			eyeR.showModel = false;
			eyeL.showModel = true;
		} else {
			if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F)
				+ Math.random() * 0.10000000149011612D
				+ 0.18000000715255737D) {
				eyeL.showModel = true;
				eyeR.showModel = true;
			} else {
				eyeL.showModel = false;
				eyeR.showModel = false;
			}
		}
        bipedOuter.rotateAngleY = 0.0F;
	}

	@Override
	public void defaultPartsSettingBefore() {
		super.defaultPartsSettingBefore();
		String[] s1 = {
				"sidetailUpperR", "sidetailUpperL"
		};
		String[] s2 = {
				"s_tailUR", "s_tailUL"
		};
		addShowPartsReneme(s1, s2);
	}
}
