package net.minecraft.src;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.move.render.ModelRotationRenderer;
import net.minecraft.move.render.RendererData;

import org.lwjgl.opengl.GL11;

public class MultiModelSmart extends MultiModelBaseBiped
{
    public static int Scale = 0;
    public static int NoScaleStart = 1;
    public static int NoScaleEnd = 2;
    public MultiModelSmart dependentModel;
    public static final float Whole = ((float)Math.PI * 2F);
    public static final float Half = (float)Math.PI;
    public static final float Quarter = ((float)Math.PI / 2F);
    public static final float Eighth = ((float)Math.PI / 4F);
    public static final float Sixteenth = 0.3926991F;
    public static final float Thirtytwoth = 0.1963495F;
    public static final float Sixtyfourth = 0.09817477F;
    public static float FrequenceFactor = 0.6662F;
    public static float RadiantToAngle = (180F / (float)Math.PI);
    public boolean isClimb;
    public boolean isClimbJump;
    public int feetClimbType;
    public int handsClimbType;
    public boolean isHandsVineClimbing;
    public boolean isFeetVineClimbing;
    public boolean isCeilingClimb;
    public boolean isSwim;
    public boolean isDive;
    public boolean isCrawl;
    public boolean isCrawlClimb;
    public boolean isJump;
    public boolean isHeadJump;
    public boolean isFlying;
    public boolean isSlide;
    public boolean isLevitate;
    public boolean isFalling;
    public boolean isGenericSneaking;
    public boolean isAngleJumping;
    public int angleJumpType;
    public float smallOverGroundHeight;
    public int overGroundBlockId;
    public int scaleArmType;
    public int scaleLegType;
    public float totalVerticalDistance;
    public float currentVerticalSpeed;
    public float totalDistance;
    public float currentSpeed;
    public double distance;
    public double verticalDistance;
    public double horizontalDistance;
    public float currentCameraAngle;
    public float currentVerticalAngle;
    public float currentHorizontalAngle;
    public float actualRotation;
    public float forwardRotation;
    public float workingAngle;
    public Modchu_ModelRotationRenderer bipedOuter;
    public Modchu_ModelRotationRenderer bipedBody;
    public Modchu_ModelRotationRenderer bipedBreast;
    public Modchu_ModelRotationRenderer bipedNeck;
    public Modchu_ModelRotationRenderer bipedHead;
    public Modchu_ModelRotationRenderer bipedHeadwear;
    public Modchu_ModelRotationRenderer bipedRightShoulder;
    public Modchu_ModelRotationRenderer bipedRightArm;
    public Modchu_ModelRotationRenderer bipedLeftShoulder;
    public Modchu_ModelRotationRenderer bipedLeftArm;
    public Modchu_ModelRotationRenderer bipedPelvic;
    public Modchu_ModelRotationRenderer bipedRightLeg;
    public Modchu_ModelRotationRenderer bipedLeftLeg;
    public Object bipedEars;
    public Object bipedCloak;
    public boolean wasSwim;
    public boolean wasDive;
    public boolean wasFlying;
    public boolean wasCeilingClimb;
    public boolean disabled;
    public boolean attemptToCallRenderCape;
    public RendererData prevOuterRenderData;

	public Modchu_ModelRotationRenderer ChignonR;
	public Modchu_ModelRotationRenderer ChignonL;
	public Modchu_ModelRotationRenderer ChignonB;
	public Modchu_ModelRotationRenderer Tail;
	public Modchu_ModelRotationRenderer SideTailR;
	public Modchu_ModelRotationRenderer SideTailL;
	public Modchu_ModelRotationRenderer Skirt;
	public boolean rendererDataVersion = false;
	public static Class clazz;

    public MultiModelSmart(float f)
    {
        this(f, Scale, Scale);
    }

    public MultiModelSmart(float f, int f1, int f2)
    {
    	super(f, 0.0F);
    	scaleArmType = f1;
    	scaleLegType = f2;
    	textureWidth = 64;
    	textureHeight = 32;
    }

	@Override
	public void initModel(float f, float f1) {
        bipedOuter = new Modchu_ModelRotationRenderer(this, -1, -1, (Modchu_ModelRotationRenderer)null);
        bipedOuter.setRotationPoint(0.0F, 8.0F, 0.0F);
        bipedOuter.fadeEnabled = true;

        super.bipedCloak = (ModelRenderer) (bipedCloak = null);
        //super.bipedCloak.showModel = false;

        super.bipedEars = (ModelRenderer) (bipedEars = null);
        //super.bipedEars.showModel = false;

        super.bipedBody = bipedBody = new Modchu_ModelRotationRenderer(this, 32, 8, bipedOuter);
        bipedBody.addBox(-3F, 0.0F, -2F, 6, 7, 4, f);
        bipedBody.setRotationPoint(0.0F, 8.0F, 0.0F);

        bipedBreast = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBody);
        bipedBreast.setRotationPoint(0.0F, 8.0F, 0.0F);

        bipedNeck = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
        bipedNeck.setRotationPoint(0.0F, 8.0F, 0.0F);

        super.bipedHead = bipedHead = new Modchu_ModelRotationRenderer(this, 0, 0, bipedNeck);
        bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
        bipedHead.setRotationPoint(0.0F, 8.0F, 0.0F);

        super.bipedHeadwear = bipedHeadwear = new Modchu_ModelRotationRenderer(this, 24, 0, bipedHead);
        bipedHeadwear.addBox(-4F, 0.0F, 1.0F, 8, 4, 3, f);
        bipedHeadwear.setRotationPoint(0.0F, 8.0F, 0.0F);

        bipedRightShoulder = new Modchu_ModelRotationRenderer(this, 40, 16, bipedBreast);
        bipedRightShoulder.addBox(-3.0F, -2.0F, -2.0F, 8, 8, 8, f);
        bipedRightShoulder.setRotationPoint(-1.5F, 9.5F, 0.0F);

        super.bipedRightArm = bipedRightArm = new Modchu_ModelRotationRenderer(this, 48, 0, bipedRightShoulder);
        bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, f);

        bipedLeftShoulder = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
        bipedLeftShoulder.mirror = true;
        bipedLeftShoulder.setRotationPoint(1.5F, 9.5F, 0.0F);

        super.bipedLeftArm = bipedLeftArm = new Modchu_ModelRotationRenderer(this, 56, 0, bipedLeftShoulder);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, f);

        bipedPelvic = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBody);
        bipedPelvic.setRotationPoint(0.0F, 14.0F, 0.0F);

        super.bipedRightLeg = bipedRightLeg = new Modchu_ModelRotationRenderer(this, 32, 19, bipedPelvic);
        bipedRightLeg.addBox(-1.0F, 0.0F, -2F, 3, 9, 4, f);
        bipedRightLeg.setRotationPoint(0.0F, 7F, 0.0F);

        super.bipedLeftLeg = bipedLeftLeg = new Modchu_ModelRotationRenderer(this, 32, 19, bipedPelvic);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-2.0F, 0.0F, -2F, 3, 9, 4, f);
        bipedLeftLeg.setRotationPoint(0.0F, 7F, 0.0F);

        Skirt = new Modchu_ModelRotationRenderer(this, 0, 16, bipedBody);
        Skirt.addBox(-4F, -2F, -4F, 8, 8, 8, f);
        Skirt.setRotationPoint(0.0F, 7F, 0.0F);

        ChignonR = new Modchu_ModelRotationRenderer(this, 24, 18, bipedHead);
        ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
        ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);

        ChignonL = new Modchu_ModelRotationRenderer(this, 24, 18, bipedHead);
        ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
        ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);

        ChignonB = new Modchu_ModelRotationRenderer(this, 52, 10, bipedHead);
        ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
        ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);

        Tail = new Modchu_ModelRotationRenderer(this, 46, 20, bipedHead);
        Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
        Tail.setRotationPoint(0.0F, 0.0F, 0.0F);

        SideTailR = new Modchu_ModelRotationRenderer(this, 58, 21, bipedHead);
        SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
        SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);

        SideTailL = new Modchu_ModelRotationRenderer(this, 58, 21, bipedHead);
        SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
        SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
        SideTailL.mirror = true;


	}

	public void armsinit(float f, float f1) {
		Arms = new Modchu_ModelRotationRenderer[18];
		// 手持ち
		Arms[0] = new Modchu_ModelRotationRenderer(this, 0, 0, getBipedRightArm());
		Arms[1] = new Modchu_ModelRotationRenderer(this, 0, 0, getBipedRightArm());
		((Modchu_ModelRotationRenderer) Arms[1]).isInvertX = true;
		// バイプロダクトエフェクター
		Arms[2] = new Modchu_ModelRotationRenderer(this);
		Arms[2].setRotationPoint(-3F, 9F, 6F);
		((Modchu_ModelRotationRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
		Arms[3] = new Modchu_ModelRotationRenderer(this);
		Arms[3].setRotationPoint(3F, 9F, 6F);
		((Modchu_ModelRotationRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
		((Modchu_ModelRotationRenderer) Arms[3]).isInvertX = true;
		// テールソード
		Arms[4] = new Modchu_ModelRotationRenderer(this);
		Arms[4].setRotationPoint(-2F, 0F, 0F);
		((Modchu_ModelRotationRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
		Arms[5] = new Modchu_ModelRotationRenderer(this);
		Arms[5].setRotationPoint(2F, 0F, 0F);
		((Modchu_ModelRotationRenderer) Arms[5]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);

		if (HeadMount != null) {
			bipedHead.childModels.remove(HeadMount);
		}
		HeadMount = new Modchu_ModelRotationRenderer(this, 0, 0, bipedHead);
		HeadMount.setRotationPoint(0.0F, -24.0F, 0.0F);
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5) {
		reset();
		if (!firstPerson && !isInventory)
		{
			//
			bipedOuter.rotationPointY = 8.0F;
			bipedBody.rotationPointY = 0.0F;
			Skirt.rotationPointY = 7.0F;
			Skirt.rotateAngleX = 0.0F;

			if (isSleeping)
			{
				prevOuterRenderData.rotateAngleX = 0.0F;
				prevOuterRenderData.rotateAngleY = 0.0F;
				prevOuterRenderData.rotateAngleZ = 0.0F;
			}
			bipedOuter.previous = prevOuterRenderData;
			bipedOuter.rotateAngleY = actualRotation / RadiantToAngle;
			bipedOuter.fadeRotateAngleY = true;
			boolean flag = false;
			boolean flag1 = onGround > 0.0F;

			//
			bipedHead.rotationPointY = 1.0F;
			if (isClimb || isCrawlClimb)
			{
				bipedOuter.rotateAngleY = forwardRotation / RadiantToAngle;
				bipedHead.rotateAngleY = 0.0F;
				bipedHead.rotateAngleX = f4 / RadiantToAngle;
				bipedLeftLeg.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedRightLeg.rotationOrder = Modchu_ModelRotationRenderer.YZX;
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
					f50 = FrequenceFactor;
					f52 = 1.0F;
					f53 = 0.0F;
					f6 = FrequenceFactor;
					f17 = 2.0F;
					f27 = -((float)Math.PI / 2F);
					break;

				case 1:
					f50 = FrequenceFactor;
					f52 = 1.0F;
					f53 = 0.0F;
					f6 = FrequenceFactor;
					f17 = 2.0F;
					f27 = -2.5F;
					break;

				default:
					f50 = FrequenceFactor;
					f52 = 1.0F;
					f53 = 0.0F;
					f6 = FrequenceFactor;
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
					f36 = FrequenceFactor;
					f43 = 3F;
					f47 = -0.5F;
					f54 = FrequenceFactor;
					f55 = 0.5F;
					f56 = 0.0F;
					break;

				default:
					f36 = FrequenceFactor;
					f43 = 0.0F;
					f47 = 0.0F;
					f54 = FrequenceFactor;
					f55 = 0.0F;
					f56 = 0.0F;
					break;
				}

				float f57 = Math.min(0.5F, currentVerticalSpeed);
				float f58 = Math.min(0.5F, f1);
				bipedRightArm.rotateAngleX = MathHelper.cos(totalVerticalDistance * f6 + (float)Math.PI) * f57 * f17 + f27;
				bipedLeftArm.rotateAngleX = MathHelper.cos(totalVerticalDistance * f6) * f57 * f17 + f27;
				bipedRightArm.rotateAngleY = MathHelper.cos(f * f50 + ((float)Math.PI / 2F)) * f58 * f52 + f53;
				bipedLeftArm.rotateAngleY = MathHelper.cos(f * f50) * f58 * f52 + f53;

				if (isHandsVineClimbing)
				{
					//Modchu_Debug.mDebug("isHandsVineClimbing");
					bipedLeftArm.rotateAngleY *= 1.0F + f50;
					bipedRightArm.rotateAngleY *= 1.0F + f50;
					bipedLeftArm.rotateAngleY += ((float)Math.PI / 4F);
					bipedRightArm.rotateAngleY -= ((float)Math.PI / 4F);
					setScales(bipedLeftArm, bipedRightArm, Math.abs(MathHelper.cos(bipedRightArm.rotateAngleX)), Math.abs(MathHelper.cos(bipedLeftArm.rotateAngleX)));
				}

				if (!isFeetVineClimbing)
				{
					//Modchu_Debug.mDebug("!isFeetVineClimbing");
					bipedRightLeg.rotateAngleX = MathHelper.cos(totalVerticalDistance * f36) * f43 * f57 + f47;
					bipedLeftLeg.rotateAngleX = MathHelper.cos(totalVerticalDistance * f36 + (float)Math.PI) * f43 * f57 + f47;
				}

				bipedRightLeg.rotateAngleZ = -(MathHelper.cos(f * f54) - 1.0F) * f58 * f55 + f56;
				bipedLeftLeg.rotateAngleZ = -(MathHelper.cos(f * f54 + ((float)Math.PI / 2F)) + 1.0F) * f58 * f55 + f56;

				if (isFeetVineClimbing)
				{
					//Modchu_Debug.mDebug("isFeetVineClimbing");
					float f59 = (MathHelper.cos(totalDistance + (float)Math.PI) + 1.0F) * 0.1963495F + 0.3926991F;
					bipedRightLeg.rotateAngleX = -f59;
					bipedLeftLeg.rotateAngleX = -f59;
					float f61 = Math.max(0.0F, MathHelper.cos(totalDistance - ((float)Math.PI / 2F))) * 0.09817477F;
					bipedLeftLeg.rotateAngleZ += -f61;
					bipedRightLeg.rotateAngleZ += f61;
					setScales(bipedLeftLeg, bipedRightLeg, Math.abs(MathHelper.cos(bipedRightLeg.rotateAngleX)), Math.abs(MathHelper.cos(bipedLeftLeg.rotateAngleX)));
				}

				if (isCrawlClimb)
				{
					//Modchu_Debug.mDebug("isCrawlClimb");
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

					bipedBody.rotateAngleX = f64;
					bipedHead.rotateAngleX = -f64;
					bipedRightLeg.rotateAngleX = f65;
					bipedLeftLeg.rotateAngleX = f65;
					bipedRightLeg.rotateAngleZ = f66;
					bipedLeftLeg.rotateAngleZ = -f66;
				}

				if (i == 0 && feetClimbType != 0)
				{
					bipedBody.rotateAngleX = 0.5F;
					bipedHead.rotateAngleX -= 0.5F;
					bipedBody.rotationPointZ = -4F;
					bipedLeftArm.rotationPointZ = -4F;
					bipedRightArm.rotationPointZ = -4F;
				}
			}
			else if (isClimbJump)
			{
				//Modchu_Debug.mDebug("isClimbJump");
				bipedRightArm.rotateAngleX = 3.534292F;
				bipedLeftArm.rotateAngleX = 3.534292F;
				bipedRightArm.rotateAngleZ = -0.1963495F;
				bipedLeftArm.rotateAngleZ = 0.1963495F;
			}
			else if (isCeilingClimb)
			{
				//Modchu_Debug.mDebug("isCeilingClimb");
				float f7 = f * 0.7F;
				float f18 = Factor(f1, 0.0F, 0.1295155F);
				float f28 = Factor(f1, 0.1295155F, 0.0F);
				float f37 = horizontalDistance >= 0.014999999664723873D ? currentHorizontalAngle : currentCameraAngle;
				bipedLeftArm.rotateAngleX = (MathHelper.cos(f7) * 0.52F + (float)Math.PI) * f18 + (float)Math.PI * f28;
				bipedRightArm.rotateAngleX = (MathHelper.cos(f7 + (float)Math.PI) * 0.52F - (float)Math.PI) * f18 - (float)Math.PI * f28;
				bipedLeftLeg.rotateAngleX = -MathHelper.cos(f7) * 0.12F * f18;
				bipedRightLeg.rotateAngleX = -MathHelper.cos(f7 + (float)Math.PI) * 0.32F * f18;
				float f44 = MathHelper.cos(f7) * 0.44F * f18;
				bipedOuter.rotateAngleY = f44 + f37;
				bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = -f44;
				bipedRightLeg.rotateAngleY = bipedLeftLeg.rotateAngleY = -f44;
				bipedHead.rotateAngleY = -f44;
			}
			else if (isSwim)
			{
				//Modchu_Debug.mDebug("isSwim");

				float f8 = f;
				float f19 = Factor(f1, 0.1567992F, 0.5226446F);
				float f29 = Math.min(Factor(f1, 0.0F, 0.1567992F), Factor(f1, 0.5226446F, 0.1567992F));
				float f38 = Factor(f1, 0.1567992F, 0.0F);
				float f45 = f38 + f29;
				float f48 = horizontalDistance >= (isGenericSneaking ? 0.0050000000000000001D : 0.014999999664723873D) ? currentHorizontalAngle : f3;
				bipedHead.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
				bipedHead.rotateAngleY = MathHelper.cos(f8 / 2.0F - ((float)Math.PI / 2F)) * f19;
				bipedHead.rotateAngleX = -((float)Math.PI / 4F) * f45;
				bipedHead.rotationPointZ = -2F;
				bipedOuter.fadeRotateAngleX = true;
				bipedOuter.rotateAngleX = ((float)Math.PI / 2F) - 0.3926991F * f45;
				bipedOuter.rotateAngleY = f48;
				bipedBody.rotateAngleY = MathHelper.cos(f8 / 2.0F - ((float)Math.PI / 2F)) * f19;
				bipedRightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedLeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedRightArm.rotateAngleZ = 2.356194F + MathHelper.cos(f2 * 0.1F) * f45 * 0.8F;
				bipedLeftArm.rotateAngleZ = -2.356194F - MathHelper.cos(f2 * 0.1F) * f45 * 0.8F;
				bipedRightArm.rotateAngleX = ((f8 * 0.5F) % ((float)Math.PI * 2F) - (float)Math.PI) * f19 + 0.3926991F * f45;
				bipedLeftArm.rotateAngleX = ((f8 * 0.5F + (float)Math.PI) % ((float)Math.PI * 2F) - (float)Math.PI) * f19 + 0.3926991F * f45;
				bipedRightLeg.rotateAngleX = MathHelper.cos(f8) * 0.5226446F * f19;
				bipedLeftLeg.rotateAngleX = MathHelper.cos(f8 + (float)Math.PI) * 0.5226446F * f19;
				float f51 = 0.3926991F * f45 + MathHelper.cos(f2 * 0.1F) * 0.4F * (f38 - f29);
				bipedRightLeg.rotateAngleZ = f51;
				bipedLeftLeg.rotateAngleZ = -f51;

				if (scaleLegType != NoScaleStart)
				{
					setScales(bipedLeftLeg, bipedRightLeg, 1.0F + (MathHelper.cos(f2 * 0.1F + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29, 1.0F + (MathHelper.cos(f2 * 0.1F + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29);
				}

				if (scaleArmType != NoScaleStart)
				{
					setScales(bipedLeftArm, bipedRightArm, 1.0F + (MathHelper.cos(f2 * 0.1F - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29, 1.0F + (MathHelper.cos(f2 * 0.1F - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f29);
				}
				//
				bipedOuter.rotationPointY = -2.0F;
				//Modchu_Debug.mDebug("f3="+f3);
				//bipedOuter.rotateAngleY = f3 / (float)Math.PI;
			}
			else if (isDive)
			{
				//Modchu_Debug.mDebug("isDive");
				//
				bipedOuter.rotationPointY = 0.0F;

				float f9 = totalDistance * 0.7F;
				float f20 = Factor(currentSpeed, 0.0F, 0.1567992F);
				float f30 = Factor(currentSpeed, 0.1567992F, 0.0F);
				float f39 = (double)totalDistance >= (isGenericSneaking ? 0.0050000000000000001D : 0.014999999664723873D) ? currentHorizontalAngle : currentCameraAngle;
				bipedHead.rotateAngleX = -((float)Math.PI / 4F);
				bipedHead.rotationPointZ = -2F;
				bipedOuter.fadeRotateAngleX = true;
				bipedOuter.rotateAngleX = isLevitate ? 1.178097F : isJump ? 0.0F : ((float)Math.PI / 2F) - currentVerticalAngle;
				bipedOuter.rotateAngleY = f39;
				bipedRightLeg.rotateAngleZ = (MathHelper.cos(f9) + 1.0F) * 0.5226446F * f20 + 0.3926991F * f30;
				bipedLeftLeg.rotateAngleZ = (MathHelper.cos(f9 + (float)Math.PI) - 1.0F) * 0.5226446F * f20 - 0.3926991F * f30;

				if (scaleLegType != NoScaleStart)
				{
					setScales(bipedLeftLeg, bipedRightLeg, 1.0F + (MathHelper.cos(f9 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f20, 1.0F + (MathHelper.cos(f9 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f20);
				}

				bipedRightArm.rotateAngleZ = (MathHelper.cos(f9 + (float)Math.PI) * 0.5226446F * 2.5F + ((float)Math.PI / 2F)) * f20 + 2.356194F * f30;
				bipedLeftArm.rotateAngleZ = (MathHelper.cos(f9) * 0.5226446F * 2.5F - ((float)Math.PI / 2F)) * f20 - 2.356194F * f30;

				if (scaleArmType != NoScaleStart)
				{
					setScales(bipedLeftArm, bipedRightArm, 1.0F + (MathHelper.cos(f9 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f20, 1.0F + (MathHelper.cos(f9 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f20);
				}
			}
			else if (isCrawl)
			{
				//Modchu_Debug.mDebug("isCrawl");
				//
				bipedOuter.rotationPointY = 1.0F;
				bipedPelvic.rotationPointY = 11.5F;

				float f10 = f * 1.3F;
				float f21 = Factor(f1, 0.0F, 0.1295155F);
				float f31 = Factor(f1, 0.1295155F, 0.0F);
				bipedHead.rotateAngleZ = -f3 / RadiantToAngle;
				bipedHead.rotateAngleX = -((float)Math.PI / 4F);
				bipedHead.rotationPointZ = -2F;
				bipedBody.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedBody.rotateAngleX = 1.374447F;
				bipedBody.rotationPointY = 3F;
				bipedBody.rotateAngleZ = MathHelper.cos(f10 + ((float)Math.PI / 2F)) * 0.09817477F * f21;
				bipedBody.rotateAngleY = MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F * f21;
				bipedRightLeg.rotateAngleX = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) * 0.09817477F + 0.1963495F) * f21 + 0.1963495F * f31;
				bipedLeftLeg.rotateAngleX = (MathHelper.cos(f10 - (float)Math.PI - ((float)Math.PI / 2F)) * 0.09817477F + 0.1963495F) * f21 + 0.1963495F * f31;
				bipedRightLeg.rotateAngleZ = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) + 1.0F) * 0.25F * f21 + 0.1963495F * f31;
				bipedLeftLeg.rotateAngleZ = (MathHelper.cos(f10 - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21 - 0.1963495F * f31;

				if (scaleLegType != NoScaleStart)
				{
					setScales(bipedLeftLeg, bipedRightLeg, 1.0F + (MathHelper.cos((f10 + ((float)Math.PI / 2F)) - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21, 1.0F + (MathHelper.cos(f10 - ((float)Math.PI / 2F) - ((float)Math.PI / 2F)) - 1.0F) * 0.25F * f21);
				}

				bipedRightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedLeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedRightArm.rotateAngleX = 3.926991F;
				bipedLeftArm.rotateAngleX = 3.926991F;
				bipedRightArm.rotateAngleZ = (MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F + 0.1963495F) * f21 + 0.3926991F * f31;
				bipedLeftArm.rotateAngleZ = (MathHelper.cos(f10 + (float)Math.PI) * 0.09817477F - 0.1963495F) * f21 - 0.3926991F * f31;
				bipedRightArm.rotateAngleY = -((float)Math.PI / 2F);
				bipedLeftArm.rotateAngleY = ((float)Math.PI / 2F);

				if (scaleArmType != NoScaleStart)
				{
					setScales(bipedLeftArm, bipedRightArm, 1.0F + (MathHelper.cos(f10 + ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f21, 1.0F + (MathHelper.cos(f10 - ((float)Math.PI / 2F)) - 1.0F) * 0.15F * f21);
				}
			}
			else if (isSlide)
			{
				//Modchu_Debug.mDebug("isSlide");
				float f11 = f * 0.7F;
				float f22 = Factor(f1, 0.0F, 1.0F) * 0.8F;
				bipedHead.rotateAngleZ = -f3 / RadiantToAngle;
				bipedHead.rotateAngleX = -1.178097F;
				bipedHead.rotationPointZ = -2F;
				bipedOuter.fadeRotateAngleY = false;
				bipedOuter.rotateAngleY = currentHorizontalAngle;
				bipedOuter.rotationPointY = 5F;
				bipedOuter.rotateAngleX = ((float)Math.PI / 2F);
				bipedBody.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
				bipedBody.offsetY = -0.4F;
				bipedBody.rotationPointY = 6.5F;
				bipedBody.rotateAngleX = MathHelper.cos(f11 - ((float)Math.PI / 4F)) * 0.09817477F * f22;
				bipedBody.rotateAngleY = MathHelper.cos(f11 + ((float)Math.PI / 4F)) * 0.09817477F * f22;
				bipedRightLeg.rotateAngleX = MathHelper.cos(f11 + (float)Math.PI) * 0.09817477F * f22 + 0.09817477F;
				bipedLeftLeg.rotateAngleX = MathHelper.cos(f11 + ((float)Math.PI / 2F)) * 0.09817477F * f22 + 0.09817477F;
				bipedRightLeg.rotateAngleZ = 0.1963495F;
				bipedLeftLeg.rotateAngleZ = -0.1963495F;
				bipedRightArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedLeftArm.rotationOrder = Modchu_ModelRotationRenderer.YZX;
				bipedRightArm.rotateAngleX = (MathHelper.cos(f11 + ((float)Math.PI / 2F)) * 0.09817477F * f22 + (float)Math.PI) - 0.09817477F;
				bipedLeftArm.rotateAngleX = (MathHelper.cos(f11 - (float)Math.PI) * 0.09817477F * f22 + (float)Math.PI) - 0.09817477F;
				bipedRightArm.rotateAngleZ = 0.3926991F;
				bipedLeftArm.rotateAngleZ = -0.3926991F;
				bipedRightArm.rotateAngleY = -((float)Math.PI / 2F);
				bipedLeftArm.rotateAngleY = ((float)Math.PI / 2F);
			}
			else if (isFlying)
			{
				//Modchu_Debug.mDebug("isFlying");
				float f12 = totalDistance * 0.08F;
				float f23 = Factor(currentSpeed, 0.0F, 1.0F);
				float f32 = Factor(currentSpeed, 1.0F, 0.0F);
				float f40 = f2 * 0.15F;
				float f46 = isJump ? Math.abs(currentVerticalAngle) : currentVerticalAngle;
				float f49 = horizontalDistance >= 0.05000000074505806D ? currentHorizontalAngle : currentCameraAngle;
				bipedOuter.fadeRotateAngleX = true;
				bipedOuter.rotateAngleX = (((float)Math.PI / 2F) - f46) * f23;
				bipedOuter.rotateAngleY = f49;
				bipedHead.rotateAngleX = -bipedOuter.rotateAngleX / 2.0F;
				bipedRightArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
				bipedLeftArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
				bipedRightArm.rotateAngleY = MathHelper.cos(f40) * 0.3926991F * f32;
				bipedLeftArm.rotateAngleY = MathHelper.cos(f40) * 0.3926991F * f32;
				bipedRightArm.rotateAngleZ = (MathHelper.cos(f12 + (float)Math.PI) * 0.09817477F + 2.748894F) * f23 + ((float)Math.PI / 2F) * f32;
				bipedLeftArm.rotateAngleZ = (MathHelper.cos(f12) * 0.09817477F - 2.748894F) * f23 - ((float)Math.PI / 2F) * f32;
				bipedRightLeg.rotateAngleX = MathHelper.cos(f12) * 0.09817477F * f23 + MathHelper.cos(f40 + (float)Math.PI) * 0.09817477F * f32;
				bipedLeftLeg.rotateAngleX = MathHelper.cos(f12 + (float)Math.PI) * 0.09817477F * f23 + MathHelper.cos(f40) * 0.09817477F * f32;
				bipedRightLeg.rotateAngleZ = 0.09817477F;
				bipedLeftLeg.rotateAngleZ = -0.09817477F;
			}
			else if (isHeadJump)
			{
				//Modchu_Debug.mDebug("isHeadJump");
				bipedOuter.fadeRotateAngleX = true;
				bipedOuter.rotateAngleX = ((float)Math.PI / 2F) - currentVerticalAngle;
				bipedOuter.rotateAngleY = currentHorizontalAngle;
				bipedHead.rotateAngleX = -bipedOuter.rotateAngleX / 2.0F;
				float f13 = Math.min(Factor(currentVerticalAngle, ((float)Math.PI / 2F), 0.0F), Factor(currentVerticalAngle, -((float)Math.PI / 2F), 0.0F));
				bipedRightArm.rotateAngleX = f13 * -((float)Math.PI / 4F);
				bipedLeftArm.rotateAngleX = f13 * -((float)Math.PI / 4F);
				bipedRightLeg.rotateAngleX = f13 * -((float)Math.PI / 4F);
				bipedLeftLeg.rotateAngleX = f13 * -((float)Math.PI / 4F);
				float f24 = Factor(currentVerticalAngle, ((float)Math.PI / 2F), -((float)Math.PI / 2F));

				if (overGroundBlockId > 0 && Block.blocksList[overGroundBlockId].blockMaterial.isSolid())
				{
					f24 = Math.min(f24, smallOverGroundHeight / 5F);
				}

				bipedRightArm.rotateAngleZ = 2.748894F + f24 * ((float)Math.PI / 4F);
				bipedLeftArm.rotateAngleZ = -2.748894F - f24 * ((float)Math.PI / 4F);
				float f33 = Factor(currentVerticalAngle, -((float)Math.PI / 2F), ((float)Math.PI / 2F));
				bipedRightLeg.rotateAngleZ = 0.09817477F * f33;
				bipedLeftLeg.rotateAngleZ = -0.09817477F * f33;
			}
			else if (isFalling)
			{
				//Modchu_Debug.mDebug("isFalling");
				float f14 = totalDistance * 0.1F;
				bipedRightArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
				bipedLeftArm.rotationOrder = Modchu_ModelRotationRenderer.XZY;
				bipedRightArm.rotateAngleY = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * ((float)Math.PI / 4F);
				bipedLeftArm.rotateAngleY = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * ((float)Math.PI / 4F);
				bipedRightArm.rotateAngleZ = MathHelper.cos(f14) * ((float)Math.PI / 4F) + ((float)Math.PI / 2F);
				bipedLeftArm.rotateAngleZ = MathHelper.cos(f14) * ((float)Math.PI / 4F) - ((float)Math.PI / 2F);
				bipedRightLeg.rotateAngleX = MathHelper.cos(f14 + (float)Math.PI + ((float)Math.PI / 2F)) * 0.3926991F + 0.1963495F;
				bipedLeftLeg.rotateAngleX = MathHelper.cos(f14 + ((float)Math.PI / 2F)) * 0.3926991F + 0.1963495F;
				bipedRightLeg.rotateAngleZ = MathHelper.cos(f14) * 0.3926991F + 0.1963495F;
				bipedLeftLeg.rotateAngleZ = MathHelper.cos(f14) * 0.3926991F - 0.1963495F;
			}
			else
			{
				flag = true;
				//
				bipedHead.rotationPointY = 8.0F;
			}

			if (flag)
			{
				bipedNeck.ignoreBase = true;
				bipedHead.rotateAngleY = (actualRotation + f3) / RadiantToAngle;
				bipedHead.rotateAngleX = f4 / RadiantToAngle;

				if (isSleeping)
				{
					bipedNeck.ignoreBase = false;
					bipedHead.rotateAngleY = 0.0F;
					bipedHead.rotateAngleX = ((float)Math.PI / 4F);
					bipedBody.rotationPointZ = -17F;
				}

				if (isAngleJumping)
				{
					//Modchu_Debug.mDebug("isAngleJumping");
					float f15 = (float)angleJumpType * ((float)Math.PI / 4F);
					bipedPelvic.rotateAngleY -= bipedOuter.rotateAngleY;
					bipedPelvic.rotateAngleY += currentCameraAngle;
					float f25 = 1.0F - Math.abs(f15 - (float)Math.PI) / ((float)Math.PI / 2F);
					float f34 = -Math.min(f15 - (float)Math.PI, 0.0F) / ((float)Math.PI / 2F);
					float f41 = Math.max(f15 - (float)Math.PI, 0.0F) / ((float)Math.PI / 2F);
					bipedLeftLeg.rotateAngleX = 0.1963495F * (1.0F + f41);
					bipedRightLeg.rotateAngleX = 0.1963495F * (1.0F + f34);
					bipedLeftLeg.rotateAngleY = -f15;
					bipedRightLeg.rotateAngleY = -f15;
					bipedLeftLeg.rotateAngleZ = 0.1963495F * f25;
					bipedRightLeg.rotateAngleZ = -0.1963495F * f25;
					bipedLeftLeg.rotationOrder = Modchu_ModelRotationRenderer.ZXY;
					bipedRightLeg.rotationOrder = Modchu_ModelRotationRenderer.ZXY;
					bipedLeftArm.rotateAngleZ = -0.3926991F * f41;
					bipedRightArm.rotateAngleZ = 0.3926991F * f34;
					bipedLeftArm.rotateAngleX = -((float)Math.PI / 4F) * f25;
					bipedRightArm.rotateAngleX = -((float)Math.PI / 4F) * f25;
				}
				else
				{
					bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
					bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
					bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
					bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
				}

				if (isRiding)
				{
					bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
					bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
					bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
					bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
					bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
					bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
					//
					bipedHead.rotationPointY = 8.0F;
					bipedOuter.rotationPointY = 8.0F;
				}

				if (heldItemLeft != 0)
				{
					bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemLeft;
				}

				if (heldItemRight != 0)
				{
					bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemRight;
				}
			}

			if (onGround > -9990F)
			{
				float f16 = MathHelper.sin(MathHelper.sqrt_float(onGround) * ((float)Math.PI * 2F)) * 0.2F;

				if (flag)
				{
					bipedBody.rotateAngleY += f16;
					bipedBody.rotationOrder = Modchu_ModelRotationRenderer.YXZ;
					getNotDominantArm().rotateAngleX += f16;
				}
				else if (flag1)
				{
					getBipedRightShoulder().ignoreSuperRotation = true;
					getBipedRightShoulder().rotateAngleX = f4 / RadiantToAngle;
					getBipedRightShoulder().rotateAngleY = workingAngle / RadiantToAngle;
					getBipedRightShoulder().rotateAngleZ = (float)Math.PI;
					getBipedRightShoulder().rotationOrder = Modchu_ModelRotationRenderer.ZYX;
					getBipedRightArm().reset();
				}

				if (flag || flag1)
				{
					float f26 = 1.0F - onGround;
					f26 = 1.0F - f26 * f26 * f26;
					float f35 = MathHelper.sin(f26 * (float)Math.PI);
					float f42 = MathHelper.sin(onGround * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
					if (getHandedness() == 0) {
						getBipedRightArm().rotateAngleX -= (double)f35 * 1.2D + (double)f42;
						getBipedRightArm().rotateAngleY += f16 * 2.0F;
						getBipedRightArm().rotateAngleZ -= MathHelper.sin(onGround * (float)Math.PI) * 0.4F;
					} else {
						getBipedRightArm().rotateAngleX -= (double)f35 * 1.2D + (double)f42;
						getBipedRightArm().rotateAngleY -= f16 * 2.0F;
						getBipedRightArm().rotateAngleZ -= MathHelper.sin(onGround * (float)Math.PI) * 0.4F;
					}
				}
			}

			if (flag)
			{
				if (isSneak && !isAngleJumping)
				{
					bipedBody.rotateAngleX += 0.5F;
					bipedRightLeg.rotateAngleX += -0.5F;
					bipedLeftLeg.rotateAngleX += -0.5F;
					bipedRightArm.rotateAngleX += -0.1F;
					bipedLeftArm.rotateAngleX += -0.1F;
					bipedPelvic.offsetY = -0.137F;
					bipedPelvic.offsetZ = -0.051F;
					bipedBreast.offsetY = -0.014F;
					bipedBreast.offsetZ = -0.057F;
					bipedNeck.offsetY = 0.0621F;

					//
					bipedHead.rotationPointY = 6F;
					Skirt.rotationPointY = 7.0F;
					Skirt.rotationPointZ = -0.5F;
					bipedOuter.rotationPointY = 0.0F;
					bipedBody.rotationPointY = 6.0F;
					bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = -4.0F;
					bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 1.0F;
					if (isRiding)
					{
						//
						Skirt.rotationPointY = 5.0F;
						bipedHead.rotationPointY = 6.0F;
						bipedOuter.rotationPointY = 0.0F;
					}
				}

				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;

				if (aimedBow)
				{
					getBipedRightArm().rotateAngleZ = 0.0F;
					getNotDominantArm().rotateAngleZ = 0.0F;
					getBipedRightArm().rotateAngleY = (-0.1F + bipedHead.rotateAngleY) - bipedOuter.rotateAngleY;
					getNotDominantArm().rotateAngleY = (0.1F + bipedHead.rotateAngleY + 0.4F) - bipedOuter.rotateAngleY;
					getBipedRightArm().rotateAngleX = -((float)Math.PI / 2F) + bipedHead.rotateAngleX;
					getNotDominantArm().rotateAngleX = -((float)Math.PI / 2F) + bipedHead.rotateAngleX;
					getBipedRightArm().rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
					getNotDominantArm().rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
					getBipedRightArm().rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
					getNotDominantArm().rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
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
				//dependentModel.setRotationAngles(f, f1, f2, f3, f4, f5);
			}
			if (!isSneak) {
				bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = -5.0F;
			}
			if (isWait && !aimedBow) {
				// 待機状態
				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedRightArm.rotateAngleZ = -0.4F;
				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
				bipedLeftArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.4F;
			} else {
				// 呼吸 腕等
				bipedRightArm.rotateAngleZ += 0.5F;
				bipedLeftArm.rotateAngleZ -= 0.5F;
				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
			if (isSleeping) {
				//
				bipedHead.rotationPointY = 0.0F;
			}
			if (flag)
			{
				bipedHead.rotateAngleY = 0.0F;
				bipedOuter.rotateAngleY = 0.0F;
			} else {
				if (isClimb || isCrawlClimb || isCrawlClimb || isFlying || isSwim || isDive || isCeilingClimb || isHeadJump || isFalling || isAngleJumping)
				{
					bipedOuter.rotateAngleY = 0.0F;
				}
			}
		}
		else
		{
			bipedBody.ignoreBase = true;
			bipedHead.ignoreBase = true;
			bipedHeadwear.ignoreBase = true;
			//bipedEars.ignoreBase = true;
			//bipedCloak.ignoreBase = true;
			bipedRightArm.ignoreBase = true;
			bipedLeftArm.ignoreBase = true;
			bipedRightLeg.ignoreBase = true;
			bipedLeftLeg.ignoreBase = true;
			superSetRotationAngles(f, f1, f2, f3, f4, f5);

			//Modchu_Debug.mDebug("bipedBody.isHidden="+bipedBody.isHidden);
			//bipedBody.offsetY = 0.0F;
			//bipedBody.rotationPointY = 12.0F;
			//bipedBody.showModel = true;
			//bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 8.0F;
		}
        bipedOuter.rotateAngleY = 0.0F;
	}

	public void superSetRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.superSetRotationAngles(f, f1, f2, f3, f4, f5);
		//f = 移動時に増加する
		//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。
		//f2 = 時間で常に増え続けている
		//f3 = 向いている方角方向で変化
		//f4 = 向いている上下方向で変化
		//f5 = スケール値？
		reset(f, f1, f2, f3, f4, f5);
		if (!firstPerson) {
			bipedHead.rotateAngleY = f3 / 57.29578F;
			bipedHead.rotateAngleX = f4 / 57.29578F;
			bipedHeadwear.rotateAngleY = bipedHead.rotateAngleY;
			bipedHeadwear.rotateAngleX = bipedHead.rotateAngleX;
			bipedRightArm.rotateAngleX = MathHelper
					.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
					* 0.5F;
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
					* f1;
			bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F)
					* 1.4F * f1;
			bipedRightLeg.rotateAngleY = 0.0F;
			bipedLeftLeg.rotateAngleY = 0.0F;
			if (isRiding) {
				// 乗り物に乗っている
				bipedRightArm.rotateAngleX += -0.6283185F;
				bipedLeftArm.rotateAngleX += -0.6283185F;
				bipedRightLeg.rotateAngleX = -1.256637F;
				bipedLeftLeg.rotateAngleX = -1.256637F;
				bipedRightLeg.rotateAngleY = 0.3141593F;
				bipedLeftLeg.rotateAngleY = -0.3141593F;
			}
			// アイテム持ってるときの腕振りを抑える
			if (heldItemLeft != 0) {
				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F
						- 0.3141593F * (float) heldItemLeft;
			}
			if (heldItemRight != 0) {
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F
						- 0.3141593F * (float) heldItemRight;
			}
			bipedRightArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleY = 0.0F;
			armSwing(f, f1, f2, f3, f4, f5);
			if (isSneak) {
				// しゃがみ
				bipedBody.rotateAngleX = 0.5F;
				bipedRightLeg.rotationPointZ = 3F;
				bipedLeftLeg.rotationPointZ = 3F;
				bipedRightLeg.rotationPointY = 6F + 8F;
				bipedLeftLeg.rotationPointY = 6F + 8F;
				bipedHead.rotationPointY = 1.0F + 8F;
				bipedHeadwear.rotationPointY = 1.0F + 8F;
				bipedHeadwear.rotateAngleX += 0.5F;
				Skirt.preRotationPointY = -1.2F;
				Skirt.preRotationPointZ = 2.7F;
				Skirt.preRotateAngleX = 0.2F;
			} else {
				// 通常立ち
				bipedBody.rotateAngleX = 0.0F;
				bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
				bipedBody.rotationPointY = 8.0F;
				bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 15.0F;
				bipedHead.rotationPointY = bipedHeadwear.rotationPointY = 8F;
				Skirt.preRotationPointY = 0.0F;
				Skirt.preRotationPointZ = 0.0F;
				Skirt.preRotateAngleX = 0.0F;
			}
			if (isWait && !aimedBow) {
				// 待機状態
				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedRightArm.rotateAngleZ = -0.4F;
				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
				bipedLeftArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.4F;
			}
			if (aimedBow) {
				// 弓構え
				float f6 = MathHelper.sin(onGround * 3.141593F);
				float f7 = MathHelper.sin((1.0F - (1.0F - onGround)
						* (1.0F - onGround)) * 3.141593F);
				bipedRightArm.rotateAngleZ = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.0F;
				bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F)
						+ bipedHead.rotateAngleY;
				bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F)
						+ bipedHead.rotateAngleY + 0.4F;
				bipedRightArm.rotateAngleX = -1.470796F;
				bipedLeftArm.rotateAngleX = -1.470796F;
				bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
				bipedLeftArm.rotateAngleX += bipedHead.rotateAngleX;
				bipedRightArm.rotationPointX = -3F;
				bipedLeftArm.rotationPointX = 3F;
			} else {
				if (!isWait) {
					// 呼吸 腕等
					bipedRightArm.rotateAngleZ += 0.5F;
					bipedLeftArm.rotateAngleZ -= 0.5F;
					bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
					bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
					bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
					bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
				}
			}
		} else {
		}
	}

    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5) {
    	float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
    	float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getaimedBow() && !getOldwalking()) {
    		// 腕振り
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedRightArm.rotateAngleZ = MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedLeftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    		}
    	}
    }

    @Override
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5) {
    	if (((EntityPlayer) entity).inventory.getCurrentItem() != null) {
    		//地図を持っている時
    		bipedRightArm.rotationPointX = -3.0F;
    		bipedRightArm.rotationPointY = 1.5F;
    		bipedRightArm.rotationPointZ = 0.0F;
    		bipedLeftArm.rotationPointX = -4.5F;
    		bipedLeftArm.rotationPointY = 1.5F;
    		bipedLeftArm.rotationPointZ = 0.0F;
    	} else {
    		//素手時
    		//setOnGround(((EntityPlayer) entity).getSwingProgress(1.0F));
    		bipedRightArm.rotateAngleX = 0.0F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = 0.5F;
    		bipedLeftArm.rotateAngleX = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.0F;

    		bipedRightArm.rotationPointY = 4.0F;
    		bipedLeftArm.rotationPointX = 4.0F;
    		bipedLeftArm.rotationPointY = 8.0F;
    		bipedLeftArm.rotationPointZ = -2.0F;
    	}
    }

	public void setScales(Modchu_ModelRotationRenderer mrrpflmR,Modchu_ModelRotationRenderer mrrpflmL,float f, float f1)
    {
        if (scaleArmType == Scale)
        {
        	mrrpflmR.scaleY = f;
        	mrrpflmL.scaleY = f1;
        }
        else if (scaleArmType == NoScaleEnd)
        {
        	mrrpflmR.offsetY -= (1.0F - f) * 0.5F;
        	mrrpflmL.offsetY -= (1.0F - f1) * 0.5F;
        }
    }

	public static float Factor(float var0, float f, float f1)
    {
        return f > f1 ? (var0 <= f1 ? 1.0F : (var0 >= f ? 0.0F : (f - var0) / (f - f1))) : (var0 >= f1 ? 1.0F : (var0 <= f ? 0.0F : (var0 - f) / (f1 - f)));
    }

    public void reset()
    {
        bipedOuter.reset();
        bipedBody.reset();
        bipedBreast.reset();
        bipedNeck.reset();
        bipedHead.reset();
        bipedHeadwear.reset();
        bipedRightShoulder.reset();
        bipedRightArm.reset();
        bipedLeftShoulder.reset();
        bipedLeftArm.reset();
        bipedPelvic.reset();
        bipedRightLeg.reset();
        bipedLeftLeg.reset();
        bipedOuter.setRotationPoint(0.0F, 8.0F, 0.0F);
        bipedRightShoulder.setRotationPoint(-2.5F, 2.0F, 0.0F);
        bipedLeftShoulder.setRotationPoint(2.5F, 2.0F, 0.0F);
        bipedPelvic.setRotationPoint(0.0F, 12.0F, 0.0F);
        bipedRightLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
        bipedLeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
        Arms[0].setRotationPoint(0.0F, 6.5F, 0.0F);
        Arms[1].setRotationPoint(0.0F, 6.5F, 0.0F);
    }

    public void renderEars(float par1)
    {
    }

    /**
     * Renders the cloak of the current biped (in most cases, it's a player)
     */
    public void renderCloak(float f)
    {
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bipedHead.render(f5);
		bipedBody.render(f5);
		bipedRightArm.render(f5);
		bipedLeftArm.render(f5);
		bipedRightLeg.render(f5);
		bipedLeftLeg.render(f5);
		bipedHeadwear.render(f5);
		if (bipedHead.showModel) {
			Tail.render(f5);
			ChignonR.render(f5);
			ChignonL.render(f5);
			ChignonB.render(f5);
			SideTailR.render(f5);
			SideTailL.render(f5);
		}
		if (Skirt.showModel) {
			Skirt.render(f5);
		}
		GL11.glPushMatrix();
		for(int i = 0; i < Arms.length
				&& Arms[i] != null; i++) {
			((Modchu_ModelRotationRenderer) Arms[i]).base = getBipedRightArm();
			Arms[i].render(f5);
		}
		HeadMount.render(f5);
		GL11.glPopMatrix();
	}

    @Override
    public ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    @Override
    public int showArmorParts(int parts) {
    	// 鎧の表示用
    	boolean f;
    	// 兜
    	f = parts == 3 ? true : false;
    	setArmorBipedHeadShowModel(f);
    	// 鎧
    	f = parts == 2 ? true : false;
    	setArmorBipedBodyShowModel(f);
    	setArmorBipedRightArmShowModel(f);
    	setArmorBipedLeftArmShowModel(f);
    	// 脚甲
    	f = parts == 1 ? true : false;
    	setArmorSkirtShowModel(f);
    	// 臑当
    	f = parts == 0 ? true : false;
    	setArmorBipedRightLegShowModel(f);
    	setArmorBipedLeftLegShowModel(f);

    	return -1;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	String[] s = {
    			"bipedCloak", "bipedEars", "SkirtTop", "SkirtFront", "SkirtLeft",
    			"SkirtRight", "SkirtBack", "rightArm", "rightArm2", "rightArmPlus",
    			"rightArmPlus2", "rightHand", "rightLeg", "rightLeg2", "rightLegPlus",
    			"rightLegPlus2", "leftArm", "leftArm2", "leftArmPlus", "leftArmPlus2",
    			"leftHand", "leftLeg", "leftLeg2", "leftLegPlus", "leftLegPlus2",
    			"HeadMount", "mainFrame", "p", "q"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
    			"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
    			"f", "g", "n", "o"
    	};
    	String[] s2 = {
    			"Head", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
    			"RightArm", "LeftArm", "RightLeg", "LeftLeg"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getSkirtFloats()) {
    		if (getGuiParts().get("Skirt") != null) indexOfAllSetVisible("Skirt");
    	}
    	if (getSkirtFloats()
    			&& Skirt != null) setVisible(Skirt, false);
    }

	public float getHeight() {
		return 1.35F;
	}

	public float getWidth() {
		return 0.5F;
	}

	public float getRidingHeight() {
		return getHeight();
	}

	public float getRidingWidth() {
		return getWidth();
	}

	public float getyOffset() {
	    return 1.17F;
	}

	public float getRidingyOffset() {
	    return getyOffset();
	}

	public double getMountedYOffset() {
		double d = 1.0D;
		if(isRiding) {
	    	//d -= 0.1D;
	    };
	    return d;
	}

	public double getSittingyOffset() {
	    return -0.35D;
	}

	public double getSleepingyOffset() {
	    return -0.9D;
	}

	public float ridingViewCorrection() {
		return 0.0F;
	}

	public float getModelScale() {
	    return 0.9375F;
	}

	public void equippedItemPositionFlower() {
		GL11.glTranslatef(0.0F, 1.0F, 0.0F);
	}

	public boolean isItemHolder() {
    	// アイテムを持っているときに手を前に出すかどうか。
    	return false;
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	if (Skirt != null
    			&& !getSkirtFloats()) {
    		Skirt.isHidden = !b;
    		setVisible(Skirt, b);
    	}
    }

    @Override
    public ModelRenderer getHeadMount() {
    	return HeadMount;
    }

	@Override
	public void reset(float f, float f1, float f2, float f3, float f4, float f5) {
		bipedRightArm.setRotationPoint(-2.5F, 9.5F, 0.0F);
		bipedLeftArm.setRotationPoint(2.5F, 9.5F, 0.0F);
		bipedRightLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		bipedLeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
	}

	@Override
	public float[] getArmorModelsSize() {
		return null;
	}

    public ModelRotationRenderer getBipedRightArm() {
    	if (getHandedness() == 0) return bipedRightArm;
    	return bipedLeftArm;
    }

    public ModelRotationRenderer getNotDominantArm() {
    	if (getHandedness() == 0) return bipedLeftArm;
    	return bipedRightArm;
    }

    public ModelRotationRenderer getBipedRightShoulder() {
    	if (getHandedness() == 0) return bipedRightShoulder;
    	return bipedLeftShoulder;
    }

    public ModelRotationRenderer getNotDominantShoulder() {
    	if (getHandedness() == 0) return bipedLeftShoulder;
    	return bipedRightShoulder;
    }
}
