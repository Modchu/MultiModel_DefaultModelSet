package net.minecraft.src;



public class MultiModelSmart_SR2 extends MultiModelSmart {

	public Modchu_ModelRotationRenderer eyeR;
	public Modchu_ModelRotationRenderer eyeL;


    public MultiModelSmart_SR2(float var1)
    {
        this(var1, Scale, Scale);
    }

    public MultiModelSmart_SR2(float var1, int var2, int var3)
    {
        super(var1, var2, var3);

		// ’Ç‰Áƒp[ƒc
		eyeR = new Modchu_ModelRotationRenderer(this, 32, 19, this.bipedHead);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRotationRenderer(this, 42, 19, this.bipedHead);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);

		if (bipedHead.showModel) {
			eyeR.render(f5);
			eyeL.render(f5);
		}

	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5);

		if (aimedBow) {
			eyeL.showModel = true;
			eyeR.showModel = false;
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

}
