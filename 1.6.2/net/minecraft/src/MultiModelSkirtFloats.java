package net.minecraft.src;

/**
 * SkirtFloats機能追加用class
 */
public abstract class MultiModelSkirtFloats extends MultiModelAction {

    private double motionY = 0.0D;

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelSkirtFloats() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelSkirtFloats(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelSkirtFloats(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelSkirtFloats(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    	skirtFloatsInit(psize, pyoffset);
    }

    /**
     * ふんわりスカート初期化
     */
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void setLivingAnimationsLM(MMM_IModelCaps entityCaps, float f, float f1, float f2) {
    	super.setLivingAnimationsLM(entityCaps, f, f1, f2);
    	if (Modchu_ModelCapsHelper.getCapsValueInt(this, caps_skirtFloats) == 2) {
//-@-151
    		EntityLivingBase entityliving = (EntityLivingBase) getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
    		setMotionY(entityliving.motionY + 0.0784000015258789D > 0 ? 0 : (entityliving.motionY + 0.0784000015258789D) * mod_Modchu_ModchuLib.skirtFloatsVolume);
    	}
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entityCaps);
    	skirtFloats(f, f1, f2, f3, f4, f5, entityCaps);
    }

    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    }

    private boolean getSkirtFloats() {
    	return mod_Modchu_ModchuLib.skirtFloats;
    }

    @Override
    public Object getCapsValue(int pIndex, Object ...pArg) {
    	switch (pIndex) {
    	case caps_skirtFloats:
    		return getSkirtFloats();
    	case caps_motionY:
    		return getMotionY();
    	}
    	return super.getCapsValue(pIndex, pArg);
    }

    @Override
    public boolean setCapsValue(int pIndex, Object ...pArg) {
    	switch (pIndex) {
    	case caps_motionY:
    		if (pArg != null
    		&& pArg.length > 0
    		&& pArg[0] != null) {
    			setMotionY((Double) pArg[0]);
    			return true;
    		}
    	}
    	return super.setCapsValue(pIndex, pArg);
    }

    private double getMotionY() {
    	return motionY;
    }

    private void setMotionY(double f) {
    	motionY = f;
    }
}
