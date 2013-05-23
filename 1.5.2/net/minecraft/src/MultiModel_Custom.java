package net.minecraft.src;

public class MultiModel_Custom extends MultiModelCustom {

	public MultiModel_Custom()
	{
		this(0.0F);
	}

	public MultiModel_Custom(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Custom(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModel_Custom(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		String s = "default";
		MMM_ModelMultiBase model = (MMM_ModelMultiBase) mod_Modchu_ModchuLib.modelNewInstance(s)[0];
		customModel = new Modchu_CustomModel(this, model, s, f, 0.0F);
	}

	public MultiModel_Custom(float f, MMM_ModelMultiBase modelBiped, String textureName) {
		super(f, 0.0F, 64, 32);
		customModel = new Modchu_CustomModel(this, modelBiped, textureName, f, 0.0F);
	}

	@Override
	public String getUsingTexture() {
		return customModel != null ? customModel.getUsingTexture() : null;
	}
}