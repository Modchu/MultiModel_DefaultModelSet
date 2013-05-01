package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.move.render.ModelCapeRenderer;
import net.minecraft.move.render.ModelEarsRenderer;
import net.minecraft.move.render.ModelRotationRenderer;

public class MultiModelSmart_Biped extends MultiModelSmart {

    public Modchu_ModelRotationRenderer bipedOuter;
    public Modchu_ModelRotationRenderer Body;
    public Modchu_ModelRotationRenderer bipedBreast;
    public Modchu_ModelRotationRenderer bipedNeck;
    public Modchu_ModelRotationRenderer Head;
    public Modchu_ModelRotationRenderer Headwear;
    public Modchu_ModelRotationRenderer bipedRightShoulder;
    public Modchu_ModelRotationRenderer RightArm;
    public Modchu_ModelRotationRenderer bipedLeftShoulder;
    public Modchu_ModelRotationRenderer LeftArm;
    public Modchu_ModelRotationRenderer bipedPelvic;
    public Modchu_ModelRotationRenderer RightLeg;
    public Modchu_ModelRotationRenderer LeftLeg;

    public MultiModelSmart_Biped(float f)
    {
        this(f, Scale, Scale);
    }

    public MultiModelSmart_Biped(float f, int i, int j)
    {
        super(f, i, j);
        scaleArmType = i;
        scaleLegType = j;
        ((Modchu_ModelRotationRenderer) HeadMount).base = Head;
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
        bipedOuter = new Modchu_ModelRotationRenderer(this, -1, -1, null);
        bipedOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedOuter.fadeEnabled = true;
        Body = new Modchu_ModelRotationRenderer(this, 16, 16, bipedOuter);
        Body.addBox(-4F, 0.0F, -2F, 8, 12, 4, f);
        Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedBreast = new Modchu_ModelRotationRenderer(this, -1, -1, Body);
        bipedBreast.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedNeck = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
        bipedNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedCloak = new ModelCapeRenderer(((ModelBase)this), 0, 0, null);
        ((ModelCapeRenderer) bipedCloak).addBox(-5F, 0.0F, -1F, 10, 16, 1, f);
        ((ModelCapeRenderer) bipedCloak).setRotationPoint(0.0F, 0.0F, 2.0F);
        Head = new Modchu_ModelRotationRenderer(this, 0, 0, bipedNeck);
        Head.addBox(-4F, -8F, -4F, 8, 8, 8, f);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedEars = new ModelEarsRenderer(this, 24, 0, null);
        ((ModelEarsRenderer) bipedEars).addBox(-3F, -6F, -1F, 6, 6, 1, f);
        ((ModelEarsRenderer) bipedEars).setRotationPoint(0.0F, 0.0F, 0.0F);
        Headwear = new Modchu_ModelRotationRenderer(this, 32, 0, Head);
        Headwear.addBox(-4F, -8F, -4F, 8, 8, 8, f + 0.5F);
        Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedRightShoulder = new Modchu_ModelRotationRenderer(this, 40, 16, bipedBreast);
        bipedRightShoulder.addBox(-3F, -2F, -2F, 8, 8, 8, f);
        bipedRightShoulder.setRotationPoint(-5F, 2.0F, 0.0F);
        RightArm = new Modchu_ModelRotationRenderer(this, 40, 16, bipedRightShoulder);
        RightArm.addBox(-3F, -2F, -2F, 4, 12, 4, f);
        bipedLeftShoulder = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
        bipedLeftShoulder.mirror = true;
        bipedLeftShoulder.setRotationPoint(5F, 2.0F, 0.0F);
        LeftArm = new Modchu_ModelRotationRenderer(this, 40, 16, bipedLeftShoulder);
        LeftArm.mirror = true;
        LeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, f);
        bipedPelvic = new Modchu_ModelRotationRenderer(this, -1, -1, Body);
        bipedPelvic.setRotationPoint(0.0F, 12F, 0.0F);
        RightLeg = new Modchu_ModelRotationRenderer(this, 0, 16, bipedPelvic);
        RightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
        RightLeg.setRotationPoint(-2F, 0.0F, 0.0F);
        LeftLeg = new Modchu_ModelRotationRenderer(this, 0, 16, bipedPelvic);
        LeftLeg.mirror = true;
        LeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
        LeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);

        bipedRightArm = RightArm;
        bipedLeftArm = LeftArm;
        bipedRightLeg = RightLeg;
        bipedLeftLeg = LeftLeg;
        bipedBody = Body;
        bipedHead = Head;
        bipedHeadwear = Headwear;
        super.bipedOuter = bipedOuter;
        super.bipedBreast = bipedBreast;
        super.bipedNeck = bipedNeck;
        super.bipedRightShoulder = bipedRightShoulder;
        super.bipedLeftShoulder = bipedLeftShoulder;
        super.bipedPelvic = bipedPelvic;
    }

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
		Headwear.render(f5);
		GL11.glPushMatrix();
		HeadMount.render(f5);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		for(int i = 0; i < Arms.length
				&& Arms[i] != null; i++) {
			((Modchu_ModelRotationRenderer) Arms[i]).base = getBipedRightArm();
			Arms[i].render(f5);
		}
		GL11.glPopMatrix();
	}

    public void superSetRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        Head.rotateAngleY = par4 / (180F / (float)Math.PI);
        Head.rotateAngleX = par5 / (180F / (float)Math.PI);
        Headwear.rotateAngleY = Head.rotateAngleY;
        Headwear.rotateAngleX = Head.rotateAngleX;
        RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        RightArm.rotateAngleZ = 0.0F;
        LeftArm.rotateAngleZ = 0.0F;
        RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        RightLeg.rotateAngleY = 0.0F;
        LeftLeg.rotateAngleY = 0.0F;

        if (isRiding)
        {
            RightArm.rotateAngleX += -((float)Math.PI / 5F);
            LeftArm.rotateAngleX += -((float)Math.PI / 5F);
            RightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            LeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            RightLeg.rotateAngleY = ((float)Math.PI / 10F);
            LeftLeg.rotateAngleY = -((float)Math.PI / 10F);
        }

        if (heldItemLeft != 0)
        {
            LeftArm.rotateAngleX = LeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemLeft;
        }

        if (heldItemRight != 0)
        {
            RightArm.rotateAngleX = RightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemRight;
        }

        RightArm.rotateAngleY = 0.0F;
        LeftArm.rotateAngleY = 0.0F;
        float var7;
        float var8;

        if (onGround > -9990.0F)
        {
            var7 = onGround;
            Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var7) * (float)Math.PI * 2.0F) * 0.2F;
            RightArm.rotationPointZ = MathHelper.sin(Body.rotateAngleY) * 5.0F;
            RightArm.rotationPointX = -MathHelper.cos(Body.rotateAngleY) * 5.0F;
            LeftArm.rotationPointZ = -MathHelper.sin(Body.rotateAngleY) * 5.0F;
            LeftArm.rotationPointX = MathHelper.cos(Body.rotateAngleY) * 5.0F;
            RightArm.rotateAngleY += Body.rotateAngleY;
            LeftArm.rotateAngleY += Body.rotateAngleY;
            LeftArm.rotateAngleX += Body.rotateAngleY;
            var7 = 1.0F - onGround;
            var7 *= var7;
            var7 *= var7;
            var7 = 1.0F - var7;
            var8 = MathHelper.sin(var7 * (float)Math.PI);
            float var9 = MathHelper.sin(onGround * (float)Math.PI) * -(Head.rotateAngleX - 0.7F) * 0.75F;
            RightArm.rotateAngleX = (float)((double)RightArm.rotateAngleX - ((double)var8 * 1.2D + (double)var9));
            RightArm.rotateAngleY += Body.rotateAngleY * 2.0F;
            RightArm.rotateAngleZ = MathHelper.sin(onGround * (float)Math.PI) * -0.4F;
        }

        if (isSneak)
        {
            Body.rotateAngleX = 0.5F;
            RightArm.rotateAngleX += 0.4F;
            LeftArm.rotateAngleX += 0.4F;
            RightLeg.rotationPointZ = 4.0F;
            LeftLeg.rotationPointZ = 4.0F;
            RightLeg.rotationPointY = 9.0F;
            LeftLeg.rotationPointY = 9.0F;
            Head.rotationPointY = 1.0F;
        }
        else
        {
            Body.rotateAngleX = 0.0F;
            RightLeg.rotationPointZ = 0.0F;
            LeftLeg.rotationPointZ = 0.0F;
            RightLeg.rotationPointY = 12.0F;
            LeftLeg.rotationPointY = 12.0F;
            Head.rotationPointY = 0.0F;
        }

        RightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        LeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        RightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        LeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

        if (aimedBow)
        {
            var7 = 0.0F;
            var8 = 0.0F;
            RightArm.rotateAngleZ = 0.0F;
            LeftArm.rotateAngleZ = 0.0F;
            RightArm.rotateAngleY = -(0.1F - var7 * 0.6F) + Head.rotateAngleY;
            LeftArm.rotateAngleY = 0.1F - var7 * 0.6F + Head.rotateAngleY + 0.4F;
            RightArm.rotateAngleX = -((float)Math.PI / 2F) + Head.rotateAngleX;
            LeftArm.rotateAngleX = -((float)Math.PI / 2F) + Head.rotateAngleX;
            RightArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            LeftArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            RightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            LeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            RightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
            LeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        }
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
		isRiding = !isRiding ? isSitting : isRiding;
        reset();

        if (firstPerson || isInventory)
        {
            Body.ignoreBase = true;
            Head.ignoreBase = true;
            Headwear.ignoreBase = true;
            ((ModelEarsRenderer) bipedEars).ignoreBase = true;
            ((ModelCapeRenderer) bipedCloak).ignoreBase = true;
            RightArm.ignoreBase = true;
            LeftArm.ignoreBase = true;
            RightLeg.ignoreBase = true;
            LeftLeg.ignoreBase = true;
            RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
            LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            RightLeg.setRotationPoint(-2F, 12F, 0.0F);
            LeftLeg.setRotationPoint(2.0F, 12F, 0.0F);
            //RightArm.rotateAngleZ = 0.5F;
            //LeftArm.rotateAngleZ = -0.5F;
            superSetRotationAngles(f, f1, f2, f3, f4, f5);
            return;
        }

        if (isSleeping)
        {
            prevOuterRenderData.rotateAngleX = 0.0F;
            prevOuterRenderData.rotateAngleY = 0.0F;
            prevOuterRenderData.rotateAngleZ = 0.0F;
        }

        bipedOuter.previous = prevOuterRenderData;
        bipedOuter.rotateAngleY = actualRotation / (180F / (float)Math.PI);
        bipedOuter.fadeRotateAngleY = true;
        boolean flag = false;
        boolean flag1 = onGround > 0.0F;

        if (isClimb || isCrawlClimb)
        {
            bipedOuter.rotateAngleY = forwardRotation / (180F / (float)Math.PI);
            Head.rotateAngleY = 0.0F;
            Head.rotateAngleX = f4 / (180F / (float)Math.PI);
            LeftLeg.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            RightLeg.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            int i = handsClimbType;

            if (isHandsVineClimbing && i == 2)
            {
                i = 1;
            }

            float f6;
            float f17;
            float f27;
            float f50;
            float f52;
            float f53;

            switch (i)
            {
                case 2:
                    f50 = 0.6662F;
                    f52 = 1.0F;
                    f53 = 0.0F;
                    f6 = 0.6662F;
                    f17 = 2.0F;
                    f27 = -((float)Math.PI / 2F);
                    break;

                case 1:
                    f50 = 0.6662F;
                    f52 = 1.0F;
                    f53 = 0.0F;
                    f6 = 0.6662F;
                    f17 = 2.0F;
                    f27 = -2.5F;
                    break;

                default:
                    f50 = 0.6662F;
                    f52 = 1.0F;
                    f53 = 0.0F;
                    f6 = 0.6662F;
                    f17 = 0.0F;
                    f27 = -0.5F;
                    break;
            }

            float f36;
            float f43;
            float f47;
            float f54;
            float f55;
            float f56;

            switch (feetClimbType)
            {
                case 1:
                    f36 = 0.6662F;
                    f43 = 3F;
                    f47 = -0.5F;
                    f54 = 0.6662F;
                    f55 = 0.5F;
                    f56 = 0.0F;
                    break;

                default:
                    f36 = 0.6662F;
                    f43 = 0.0F;
                    f47 = 0.0F;
                    f54 = 0.6662F;
                    f55 = 0.0F;
                    f56 = 0.0F;
                    break;
            }

            float f57 = Math.min(0.5F, currentVerticalSpeed);
            float f58 = Math.min(0.5F, f1);
            RightArm.rotateAngleX = MathHelper.cos(totalVerticalDistance * f6 + (float)Math.PI) * f57 * f17 + f27;
            LeftArm.rotateAngleX = MathHelper.cos(totalVerticalDistance * f6) * f57 * f17 + f27;
            RightArm.rotateAngleY = MathHelper.cos(f * f50 + ((float)Math.PI / 2F)) * f58 * f52 + f53;
            LeftArm.rotateAngleY = MathHelper.cos(f * f50) * f58 * f52 + f53;

            if (isHandsVineClimbing)
            {
                LeftArm.rotateAngleY *= 1.0F + f50;
                RightArm.rotateAngleY *= 1.0F + f50;
                LeftArm.rotateAngleY += ((float)Math.PI / 4F);
                RightArm.rotateAngleY -= ((float)Math.PI / 4F);
                setArmScales(Math.abs(MathHelper.cos(RightArm.rotateAngleX)), Math.abs(MathHelper.cos(LeftArm.rotateAngleX)));
            }

            if (!isFeetVineClimbing)
            {
                RightLeg.rotateAngleX = MathHelper.cos(totalVerticalDistance * f36) * f43 * f57 + f47;
                LeftLeg.rotateAngleX = MathHelper.cos(totalVerticalDistance * f36 + (float)Math.PI) * f43 * f57 + f47;
            }

            RightLeg.rotateAngleZ = -(MathHelper.cos(f * f54) - 1.0F) * f58 * f55 + f56;
            LeftLeg.rotateAngleZ = -(MathHelper.cos(f * f54 + ((float)Math.PI / 2F)) + 1.0F) * f58 * f55 + f56;

            if (isFeetVineClimbing)
            {
                float f59 = (MathHelper.cos(totalDistance + (float)Math.PI) + 1.0F) * 0.1963495F + 0.3926991F;
                RightLeg.rotateAngleX = -f59;
                LeftLeg.rotateAngleX = -f59;
                float f61 = Math.max(0.0F, MathHelper.cos(totalDistance - ((float)Math.PI / 2F))) * 0.09817477F;
                LeftLeg.rotateAngleZ += -f61;
                RightLeg.rotateAngleZ += f61;
                setLegScales(Math.abs(MathHelper.cos(RightLeg.rotateAngleX)), Math.abs(MathHelper.cos(LeftLeg.rotateAngleX)));
            }

            if (isCrawlClimb)
            {
                float f60 = smallOverGroundHeight + 0.25F;
                float f62 = 0.7F;
                float f63 = 0.55F;
                float f64;
                float f65;
                float f66;

                if (f60 < f62)
                {
                    f64 = Math.max(0.0F, (float)Math.acos(f60 / f62));
                    f65 = ((float)Math.PI / 2F) - f64;
                    f66 = 0.1963495F;
                }
                else if (f60 < f62 + f63)
                {
                    f64 = 0.0F;
                    f65 = Math.max(0.0F, (float)Math.acos((f60 - f62) / f63));
                    f66 = 0.1963495F * (f65 / 1.537F);
                }
                else
                {
                    f64 = 0.0F;
                    f65 = 0.0F;
                    f66 = 0.0F;
                }

                Body.rotateAngleX = f64;
                Head.rotateAngleX = -f64;
                RightLeg.rotateAngleX = f65;
                LeftLeg.rotateAngleX = f65;
                RightLeg.rotateAngleZ = f66;
                LeftLeg.rotateAngleZ = -f66;
            }

            if (i == 0 && feetClimbType != 0)
            {
                Body.rotateAngleX = 0.5F;
                Head.rotateAngleX -= 0.5F;
                Body.rotationPointZ = -4F;
                LeftArm.rotationPointZ = -4F;
                RightArm.rotationPointZ = -4F;
            }
        }
        else if (isClimbJump)
        {
            RightArm.rotateAngleX = 3.534292F;
            LeftArm.rotateAngleX = 3.534292F;
            RightArm.rotateAngleZ = -0.1963495F;
            LeftArm.rotateAngleZ = 0.1963495F;
        }
        else if (isCeilingClimb)
        {
            float f7 = f * 0.7F;
            float f18 = Factor(f1, 0.0F, 0.1295155F);
            float f28 = Factor(f1, 0.1295155F, 0.0F);
            float f37 = horizontalDistance >= 0.014999999664723873D ? currentHorizontalAngle : currentCameraAngle;
            LeftArm.rotateAngleX = (MathHelper.cos(f7) * 0.52F + (float)Math.PI) * f18 + (float)Math.PI * f28;
            RightArm.rotateAngleX = (MathHelper.cos(f7 + (float)Math.PI) * 0.52F - (float)Math.PI) * f18 - (float)Math.PI * f28;
            LeftLeg.rotateAngleX = -MathHelper.cos(f7) * 0.12F * f18;
            RightLeg.rotateAngleX = -MathHelper.cos(f7 + (float)Math.PI) * 0.32F * f18;
            float f44 = MathHelper.cos(f7) * 0.44F * f18;
            bipedOuter.rotateAngleY = f44 + f37;
            RightArm.rotateAngleY = LeftArm.rotateAngleY = -f44;
            RightLeg.rotateAngleY = LeftLeg.rotateAngleY = -f44;
            Head.rotateAngleY = -f44;
        }
        else if (isSwim)
        {
            float f8 = f;
            float f19 = Factor(f1, 0.1567992F, 0.5226446F);
            float f29 = Math.min(Factor(f1, 0.0F, 0.1567992F), Factor(f1, 0.5226446F, 0.1567992F));
            float f38 = Factor(f1, 0.1567992F, 0.0F);
            float f45 = f38 + f29;
            float f48 = horizontalDistance >= (isGenericSneaking ? 0.0050000000000000001D : 0.014999999664723873D) ? currentHorizontalAngle : currentCameraAngle;
            Head.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
            Head.rotateAngleY = MathHelper.cos(f8 / 2.0F - ((float)Math.PI / 2F)) * f19;
            Head.rotateAngleX = -((float)Math.PI / 4F) * f45;
            Head.rotationPointZ = -2F;
            bipedOuter.fadeRotateAngleX = true;
            bipedOuter.rotateAngleX = ((float)Math.PI / 2F) - 0.3926991F * f45;
            bipedOuter.rotateAngleY = f48;
            Body.rotateAngleY = MathHelper.cos(f8 / 2.0F - ((float)Math.PI / 2F)) * f19;
            RightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            LeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            RightArm.rotateAngleZ = 2.356194F + MathHelper.cos(f2 * 0.1F) * f45 * 0.8F;
            LeftArm.rotateAngleZ = -2.356194F - MathHelper.cos(f2 * 0.1F) * f45 * 0.8F;
            RightArm.rotateAngleX = ((f8 * 0.5F) % ((float)Math.PI * 2F) - (float)Math.PI) * f19 + 0.3926991F * f45;
            LeftArm.rotateAngleX = ((f8 * 0.5F + (float)Math.PI) % ((float)Math.PI * 2F) - (float)Math.PI) * f19 + 0.3926991F * f45;
            RightLeg.rotateAngleX = MathHelper.cos(f8) * 0.5226446F * f19;
            LeftLeg.rotateAngleX = MathHelper.cos(f8 + (float)Math.PI) * 0.5226446F * f19;
            float f51 = 0.3926991F * f45 + MathHelper.cos(f2 * 0.1F) * 0.4F * (f38 - f29);
            RightLeg.rotateAngleZ = f51;
            LeftLeg.rotateAngleZ = -f51;

            if (scaleLegType != NoScaleStart)
            {
                setLegScales(1.0F + (MathHelper.cos(f2 * 0.1F + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29, 1.0F + (MathHelper.cos(f2 * 0.1F + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29);
            }

            if (scaleArmType != NoScaleStart)
            {
                setArmScales(1.0F + (MathHelper.cos(f2 * 0.1F - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29, 1.0F + (MathHelper.cos(f2 * 0.1F - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29);
            }
        }
        else if (isDive)
        {
            float f9 = totalDistance * 0.7F;
            float f20 = Factor(currentSpeed, 0.0F, 0.1567992F);
            float f30 = Factor(currentSpeed, 0.1567992F, 0.0F);
            float f39 = (double)totalDistance >= (isGenericSneaking ? 0.0050000000000000001D : 0.014999999664723873D) ? currentHorizontalAngle : currentCameraAngle;
            Head.rotateAngleX = -((float)Math.PI / 4F);
            Head.rotationPointZ = -2F;
            bipedOuter.fadeRotateAngleX = true;
            bipedOuter.rotateAngleX = isLevitate ? 1.178097F : isJump ? 0.0F : ((float)Math.PI / 2F) - currentVerticalAngle;
            bipedOuter.rotateAngleY = f39;
            RightLeg.rotateAngleZ = (MathHelper.cos(f9) + 1.0F) * 0.5226446F * f20 + 0.3926991F * f30;
            LeftLeg.rotateAngleZ = (MathHelper.cos(f9 + (float)Math.PI) - 1.0F) * 0.5226446F * f20 - 0.3926991F * f30;

            if (scaleLegType != NoScaleStart)
            {
                setLegScales(1.0F + (MathHelper.cos(f9 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f20, 1.0F + (MathHelper.cos(f9 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f20);
            }

            RightArm.rotateAngleZ = (MathHelper.cos(f9 + (float)Math.PI) * 0.5226446F * 2.5F + ((float)Math.PI / 2F)) * f20 + 2.356194F * f30;
            LeftArm.rotateAngleZ = (MathHelper.cos(f9) * 0.5226446F * 2.5F - ((float)Math.PI / 2F)) * f20 - 2.356194F * f30;

            if (scaleArmType != NoScaleStart)
            {
                setArmScales(1.0F + (MathHelper.cos(f9 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f20, 1.0F + (MathHelper.cos(f9 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f20);
            }
        }
        else if (isCrawl)
        {
            float f10 = f * 1.3F;
            float f21 = Factor(f1, 0.0F, 0.1295155F);
            float f31 = Factor(f1, 0.1295155F, 0.0F);
            Head.rotateAngleZ = -f3 / (180F / (float)Math.PI);
            Head.rotateAngleX = -((float)Math.PI / 4F);
            Head.rotationPointZ = -2F;
            Body.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            Body.rotateAngleX = 1.374447F;
            Body.rotationPointY = 3F;
            Body.rotateAngleZ = MathHelper.cos(f10 + ((float)Math.PI / 2F)) * 0.09817477F * f21;
            Body.rotateAngleY = MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F * f21;
            RightLeg.rotateAngleX = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) * 0.09817477F + 0.1963495F) * f21 + 0.1963495F * f31;
            LeftLeg.rotateAngleX = (MathHelper.cos(f10 - (float)Math.PI - ((float)Math.PI / 2F)) * 0.09817477F + 0.1963495F) * f21 + 0.1963495F * f31;
            RightLeg.rotateAngleZ = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) + 1.0F) * 0.25F * f21 + 0.1963495F * f31;
            LeftLeg.rotateAngleZ = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21 - 0.1963495F * f31;

            if (scaleLegType != NoScaleStart)
            {
                setLegScales(1.0F + (MathHelper.cos((f10 + ((float)Math.PI / 2F)) - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21, 1.0F + (MathHelper.cos(f10 - ((float)Math.PI / 2F) - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21);
            }

            RightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            LeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            RightArm.rotateAngleX = 3.926991F;
            LeftArm.rotateAngleX = 3.926991F;
            RightArm.rotateAngleZ = (MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F + 0.1963495F) * f21 + 0.3926991F * f31;
            LeftArm.rotateAngleZ = (MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F - 0.1963495F) * f21 - 0.3926991F * f31;
            RightArm.rotateAngleY = -((float)Math.PI / 2F);
            LeftArm.rotateAngleY = ((float)Math.PI / 2F);

            if (scaleArmType != NoScaleStart)
            {
                setArmScales(1.0F + (MathHelper.cos(f10 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f21, 1.0F + (MathHelper.cos(f10 - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f21);
            }
        }
        else if (isSlide)
        {
            float f11 = f * 0.7F;
            float f22 = Factor(f1, 0.0F, 1.0F) * 0.8F;
            Head.rotateAngleZ = -f3 / (180F / (float)Math.PI);
            Head.rotateAngleX = -1.178097F;
            Head.rotationPointZ = -2F;
            bipedOuter.fadeRotateAngleY = false;
            bipedOuter.rotateAngleY = currentHorizontalAngle;
            bipedOuter.rotationPointY = 5F;
            bipedOuter.rotateAngleX = ((float)Math.PI / 2F);
            Body.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
            Body.offsetY = -0.4F;
            Body.rotationPointY = 6.5F;
            Body.rotateAngleX = MathHelper.cos(f11 - ((float)Math.PI / 4F)) * 0.09817477F * f22;
            Body.rotateAngleY = MathHelper.cos(f11 + ((float)Math.PI / 4F)) * 0.09817477F * f22;
            RightLeg.rotateAngleX = MathHelper.cos(f11 + (float)Math.PI) * 0.09817477F * f22 + 0.09817477F;
            LeftLeg.rotateAngleX = MathHelper.cos(f11 + ((float)Math.PI / 2F)) * 0.09817477F * f22 + 0.09817477F;
            RightLeg.rotateAngleZ = 0.1963495F;
            LeftLeg.rotateAngleZ = -0.1963495F;
            RightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            LeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
            RightArm.rotateAngleX = (MathHelper.cos(f11 + ((float)Math.PI / 2F)) * 0.09817477F * f22 + (float)Math.PI) - 0.09817477F;
            LeftArm.rotateAngleX = (MathHelper.cos(f11 - (float)Math.PI) * 0.09817477F * f22 + (float)Math.PI) - 0.09817477F;
            RightArm.rotateAngleZ = 0.3926991F;
            LeftArm.rotateAngleZ = -0.3926991F;
            RightArm.rotateAngleY = -((float)Math.PI / 2F);
            LeftArm.rotateAngleY = ((float)Math.PI / 2F);
        }
        else if (isFlying)
        {
            float f12 = totalDistance * 0.08F;
            float f23 = Factor(currentSpeed, 0.0F, 1.0F);
            float f32 = Factor(currentSpeed, 1.0F, 0.0F);
            float f40 = f2 * 0.15F;
            float f46 = isJump ? Math.abs(currentVerticalAngle) : currentVerticalAngle;
            float f49 = horizontalDistance >= 0.05000000074505806D ? currentHorizontalAngle : currentCameraAngle;
            bipedOuter.fadeRotateAngleX = true;
            bipedOuter.rotateAngleX = (((float)Math.PI / 2F) - f46) * f23;
            bipedOuter.rotateAngleY = f49;
            Head.rotateAngleX = -bipedOuter.rotateAngleX / 2.0F;
            RightArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
            LeftArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
            RightArm.rotateAngleY = MathHelper.cos(f40) * 0.3926991F * f32;
            LeftArm.rotateAngleY = MathHelper.cos(f40) * 0.3926991F * f32;
            RightArm.rotateAngleZ = (MathHelper.cos(f12 + (float)Math.PI) * 0.09817477F + 2.748894F) * f23 + ((float)Math.PI / 2F) * f32;
            LeftArm.rotateAngleZ = (MathHelper.cos(f12) * 0.09817477F - 2.748894F) * f23 - ((float)Math.PI / 2F) * f32;
            RightLeg.rotateAngleX = MathHelper.cos(f12) * 0.09817477F * f23 + MathHelper.cos(f40 + (float)Math.PI) * 0.09817477F * f32;
            LeftLeg.rotateAngleX = MathHelper.cos(f12 + (float)Math.PI) * 0.09817477F * f23 + MathHelper.cos(f40) * 0.09817477F * f32;
            RightLeg.rotateAngleZ = 0.09817477F;
            LeftLeg.rotateAngleZ = -0.09817477F;
        }
        else if (isHeadJump)
        {
            bipedOuter.fadeRotateAngleX = true;
            bipedOuter.rotateAngleX = ((float)Math.PI / 2F) - currentVerticalAngle;
            bipedOuter.rotateAngleY = currentHorizontalAngle;
            Head.rotateAngleX = -bipedOuter.rotateAngleX / 2.0F;
            float f13 = Math.min(Factor(currentVerticalAngle, ((float)Math.PI / 2F), 0.0F), Factor(currentVerticalAngle, -((float)Math.PI / 2F), 0.0F));
            RightArm.rotateAngleX = f13 * -((float)Math.PI / 4F);
            LeftArm.rotateAngleX = f13 * -((float)Math.PI / 4F);
            RightLeg.rotateAngleX = f13 * -((float)Math.PI / 4F);
            LeftLeg.rotateAngleX = f13 * -((float)Math.PI / 4F);
            float f24 = Factor(currentVerticalAngle, ((float)Math.PI / 2F), -((float)Math.PI / 2F));

            if (overGroundBlockId > 0 && Block.blocksList[overGroundBlockId].blockMaterial.isSolid())
            {
                f24 = Math.min(f24, smallOverGroundHeight / 5F);
            }

            RightArm.rotateAngleZ = 2.748894F + f24 * ((float)Math.PI / 4F);
            LeftArm.rotateAngleZ = -2.748894F - f24 * ((float)Math.PI / 4F);
            float f33 = Factor(currentVerticalAngle, -((float)Math.PI / 2F), ((float)Math.PI / 2F));
            RightLeg.rotateAngleZ = 0.09817477F * f33;
            LeftLeg.rotateAngleZ = -0.09817477F * f33;
        }
        else if (isFalling)
        {
            float f14 = totalDistance * 0.1F;
            RightArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
            LeftArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
            RightArm.rotateAngleY = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * ((float)Math.PI / 4F);
            LeftArm.rotateAngleY = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * ((float)Math.PI / 4F);
            RightArm.rotateAngleZ = MathHelper.cos(f14) * ((float)Math.PI / 4F) + ((float)Math.PI / 2F);
            LeftArm.rotateAngleZ = MathHelper.cos(f14) * ((float)Math.PI / 4F) - ((float)Math.PI / 2F);
            RightLeg.rotateAngleX = MathHelper.cos(f14 + (float)Math.PI + ((float)Math.PI / 2F)) * 0.3926991F + 0.1963495F;
            LeftLeg.rotateAngleX = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * 0.3926991F + 0.1963495F;
            RightLeg.rotateAngleZ = MathHelper.cos(f14) * 0.3926991F + 0.1963495F;
            LeftLeg.rotateAngleZ = MathHelper.cos(f14) * 0.3926991F - 0.1963495F;
        }
        else
        {
            flag = true;
        }

        if (flag)
        {
            bipedNeck.ignoreBase = true;
            Head.rotateAngleY = (actualRotation + f3) / (180F / (float)Math.PI);
            Head.rotateAngleX = f4 / (180F / (float)Math.PI);

            if (isSleeping)
            {
                bipedNeck.ignoreBase = false;
                Head.rotateAngleY = 0.0F;
                Head.rotateAngleX = ((float)Math.PI / 4F);
                Body.rotationPointZ = -17F;
            }

            if (isAngleJumping)
            {
                float f15 = (float)angleJumpType * ((float)Math.PI / 4F);
                bipedPelvic.rotateAngleY -= bipedOuter.rotateAngleY;
                bipedPelvic.rotateAngleY += currentCameraAngle;
                float f25 = 1.0F - Math.abs(f15 - (float)Math.PI) / ((float)Math.PI / 2F);
                float f34 = -Math.min(f15 - (float)Math.PI, 0.0F) / ((float)Math.PI / 2F);
                float f41 = Math.max(f15 - (float)Math.PI, 0.0F) / ((float)Math.PI / 2F);
                LeftLeg.rotateAngleX = 0.1963495F * (1.0F + f41);
                RightLeg.rotateAngleX = 0.1963495F * (1.0F + f34);
                LeftLeg.rotateAngleY = -f15;
                RightLeg.rotateAngleY = -f15;
                LeftLeg.rotateAngleZ = 0.1963495F * f25;
                RightLeg.rotateAngleZ = -0.1963495F * f25;
                LeftLeg.rotationOrder = Modchu_ModelRotationRenderer.ZXY;
                RightLeg.rotationOrder = Modchu_ModelRotationRenderer.ZXY;
                LeftArm.rotateAngleZ = -0.3926991F * f41;
                RightArm.rotateAngleZ = 0.3926991F * f34;
                LeftArm.rotateAngleX = -((float)Math.PI / 4F) * f25;
                RightArm.rotateAngleX = -((float)Math.PI / 4F) * f25;
            }
            else
            {
                RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
                LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
                RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
                LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
            }

            if (isRiding)
            {
                RightArm.rotateAngleX += -((float)Math.PI / 5F);
                LeftArm.rotateAngleX += -((float)Math.PI / 5F);
                RightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
                LeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
                RightLeg.rotateAngleY = ((float)Math.PI / 10F);
                LeftLeg.rotateAngleY = -((float)Math.PI / 10F);
            }

            if (heldItemLeft != 0)
            {
                LeftArm.rotateAngleX = LeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemLeft;
            }

            if (heldItemRight != 0)
            {
                RightArm.rotateAngleX = RightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemRight;
            }
        }

        if (onGround > -9990F)
        {
            float f16 = MathHelper.sin(MathHelper.sqrt_float(onGround) * ((float)Math.PI * 2F)) * 0.2F;

            if (flag)
            {
                Body.rotateAngleY += f16;
                Body.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
                LeftArm.rotateAngleX += f16;
            }
            else if (flag1)
            {
                bipedRightShoulder.ignoreSuperRotation = true;
                bipedRightShoulder.rotateAngleX = f4 / (180F / (float)Math.PI);
                bipedRightShoulder.rotateAngleY = workingAngle / (180F / (float)Math.PI);
                bipedRightShoulder.rotateAngleZ = (float)Math.PI;
                bipedRightShoulder.rotationOrder = Modchu_ModelRotationRenderer.ZYX;
                RightArm.reset();
            }

            if (flag || flag1)
            {
                float f26 = 1.0F - onGround;
                f26 = 1.0F - f26 * f26 * f26;
                float f35 = MathHelper.sin(f26 * (float)Math.PI);
                float f42 = MathHelper.sin(onGround * (float)Math.PI) * -(Head.rotateAngleX - 0.7F) * 0.75F;
                RightArm.rotateAngleX -= (double)f35 * 1.2D + (double)f42;
                RightArm.rotateAngleY += f16 * 2.0F;
                RightArm.rotateAngleZ -= MathHelper.sin(onGround * (float)Math.PI) * 0.4F;
            }
        }

        if (flag)
        {
            if (isSneak && !isAngleJumping)
            {
                Body.rotateAngleX += 0.5F;
                RightLeg.rotateAngleX += -0.5F;
                LeftLeg.rotateAngleX += -0.5F;
                RightArm.rotateAngleX += -0.1F;
                LeftArm.rotateAngleX += -0.1F;
                bipedPelvic.offsetY = -0.137F;
                bipedPelvic.offsetZ = -0.051F;
                bipedBreast.offsetY = -0.014F;
                bipedBreast.offsetZ = -0.057F;
                bipedNeck.offsetY = 0.0621F;
            }

            RightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
            LeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
            RightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
            LeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;

            if (aimedBow)
            {
                RightArm.rotateAngleZ = 0.0F;
                LeftArm.rotateAngleZ = 0.0F;
                RightArm.rotateAngleY = (-0.1F + Head.rotateAngleY) - bipedOuter.rotateAngleY;
                LeftArm.rotateAngleY = (0.1F + Head.rotateAngleY + 0.4F) - bipedOuter.rotateAngleY;
                RightArm.rotateAngleX = -((float)Math.PI / 2F) + Head.rotateAngleX;
                LeftArm.rotateAngleX = -((float)Math.PI / 2F) + Head.rotateAngleX;
                RightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
                LeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
                RightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
                LeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
            }
        }

        if (bipedOuter.previous != null && !bipedOuter.fadeRotateAngleX)
        {
            bipedOuter.previous.rotateAngleX = bipedOuter.rotateAngleX;
        }

        if (bipedOuter.previous != null && !bipedOuter.fadeRotateAngleY)
        {
            bipedOuter.previous.rotateAngleY = bipedOuter.rotateAngleY;
        }

        bipedOuter.fadeIntermediate(f2);
        bipedOuter.fadeStore(f2);
        wasSwim = isSwim;
        wasDive = isDive;
        wasFlying = isFlying;
        wasCeilingClimb = isCeilingClimb;

        if (dependentModel != null)
        {
            dependentModel.setRotationAngles(f, f1, f2, f3, f4, f5);
        }

        ((ModelCapeRenderer) bipedCloak).ignoreBase = false;
        ((ModelCapeRenderer) bipedCloak).rotateAngleX = 0.09817477F;
    }

    private void setArmScales(float f, float f1)
    {
        if (scaleArmType == Scale)
        {
            RightArm.scaleY = f;
            LeftArm.scaleY = f1;
        }
        else if (scaleArmType == NoScaleEnd)
        {
            RightArm.offsetY -= (1.0F - f) * 0.5F;
            LeftArm.offsetY -= (1.0F - f1) * 0.5F;
        }
    }

    private void setLegScales(float f, float f1)
    {
        if (scaleLegType == Scale)
        {
            RightLeg.scaleY = f;
            LeftLeg.scaleY = f1;
        }
        else if (scaleLegType == NoScaleEnd)
        {
            RightLeg.offsetY -= (1.0F - f) * 0.5F;
            LeftLeg.offsetY -= (1.0F - f1) * 0.5F;
        }
    }

    public void reset()
    {
        bipedOuter.reset();
        Body.reset();
        bipedBreast.reset();
        bipedNeck.reset();
        Head.reset();
        Headwear.reset();
        ((ModelEarsRenderer) bipedEars).reset();
        ((ModelCapeRenderer) bipedCloak).reset();
        bipedRightShoulder.reset();
        RightArm.reset();
        bipedLeftShoulder.reset();
        LeftArm.reset();
        bipedPelvic.reset();
        RightLeg.reset();
        LeftLeg.reset();
        bipedRightShoulder.setRotationPoint(-5F, 2.0F, 0.0F);
        bipedLeftShoulder.setRotationPoint(5F, 2.0F, 0.0F);
        bipedPelvic.setRotationPoint(0.0F, 12F, 0.0F);
        RightLeg.setRotationPoint(-2F, 0.0F, 0.0F);
        LeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
        ((ModelCapeRenderer) bipedCloak).setRotationPoint(0.0F, 0.0F, 2.0F);
        Arms[0].setRotationPoint(-0.5F, 7.5F, 0.0F);
        Arms[1].setRotationPoint(0.5F, 7.5F, 0.0F);
    }

    /**
     * Renders the cloak of the current biped (in most cases, it's a player)
     */
    public void renderCloak(float f)
    {
        attemptToCallRenderCape = true;

        if (!disabled)
        {
            super.renderCloak(f);
        }
    }

	public float getHeight() {
		return 1.81F;
	}

	public float getWidth() {
		return 0.6F;
	}

	public float getyOffset() {
	    return 1.62F;
	}

	public double getMountedYOffset() {
		double d = 0.75D;
	    return d;
	}

	public double getSittingyOffset() {
	    return -0.6D;
	}

	public float firstPersonY() {
	    return 0.0F;
	}

    @Override
	public int showArmorParts(int parts) {
		// äZÇÃï\é¶óp
		boolean f;
		// äï
		f = parts == 3 ? true : false;
		setArmorBipedHeadShowModel(f);
		// äZ
		f = parts == 2 ? true : false;
		setArmorBipedBodyShowModel(f);
		setArmorBipedRightArmShowModel(f);
		setArmorBipedLeftArmShowModel(f);
		// ãrçb
		//f = parts == 1 | parts == 0 ? true : false;
		// ‰aìñ
		f = parts == 0 ? true : false;
		setArmorBipedRightLegShowModel(f);
		setArmorBipedLeftLegShowModel(f);

		return -1;
	}

    @Override
    public void defaultPartsSettingBefore() {
    	String[] s = {
    			"rightArm", "rightArm2", "rightArmPlus", "rightArmPlus2", "rightHand",
    			"rightLeg", "rightLeg2", "rightLegPlus", "rightLegPlus2", "leftArm",
    			"leftArm2", "leftArmPlus", "leftArmPlus2", "leftHand", "leftLeg",
    			"leftLeg2", "leftLegPlus", "leftLegPlus2", "HeadMount", "mainFrame"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
    			"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
    			"f", "g", "h", "i", "j",
    			"k"
    	};
    	String[] s2 = {
    			"Head", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
    			"RightArm", "LeftArm", "RightLeg", "LeftLeg", "bipedCloak",
    			"bipedEars"
    	};
    	addShowPartsReneme(s1, s2);
    }

    public ModelRotationRenderer getBipedRightArm() {
    	if (getHandedness() == 0) return RightArm;
    	return LeftArm;
    }

    public ModelRotationRenderer getNotDominantArm() {
    	if (getHandedness() == 0) return LeftArm;
    	return RightArm;
    }

    @Override
    public void action2(Entity entity) {
    	// éËÇè„Ç∞ÇÈÉÇÅ[ÉVÉáÉì
    	super.action2(entity);
    	getBipedRightArm().rotationPointX += getHandedness() == 0 ? 2.0F : -2.0F;
    }

    public void action3(Entity entity) {
    	// éËÇè„Ç∞ÇƒêUÇÈÉÇÅ[ÉVÉáÉì
    	super.action3(entity);
    	getBipedRightArm().rotationPointX += getHandedness() == 0 ? 2.0F : -2.0F;
    }
}
