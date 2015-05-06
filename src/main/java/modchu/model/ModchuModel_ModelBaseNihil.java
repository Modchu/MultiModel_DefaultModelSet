package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_ModelBipedMasterBasis;

public class ModchuModel_ModelBaseNihil extends Modchu_ModelBipedMasterBasis {
	public boolean isAlphablend;
	public boolean isModelAlphablend;
	public Modchu_IEntityCapsBase capsLink;
	public int lighting;
	protected Modchu_IEntityCapsBase tempEntityCaps;
	protected boolean isRendering;
	/**
	 * レンダリングが実行された回数。
	 * ダメージ時などの対策。
	 */
	public int renderCount;

	public ModchuModel_ModelBaseNihil(HashMap<String, Object> map) {
		super(map);
	}

	public void showAllParts() {
		showAllParts(tempEntityCaps);
	}

	public void showAllParts(Modchu_IEntityCapsBase entityCaps) {
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		renderCount++;
	}

	public Modchu_IEntityCapsBase getModchu_IEntityCapsBase(Object entityLivingBase) {
		tempEntityCaps = (Modchu_IEntityCapsBase) (entityLivingBase instanceof ModchuModel_ModelDataBase ? entityLivingBase : ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase));
		return tempEntityCaps;
	}

	public static void setLightmapTextureCoords(int pValue) {
//		int ls = pValue % 65536;
//		int lt = pValue / 65536;
		int ls = pValue & 0xffff;
		int lt = pValue >>> 16;
		Modchu_AS.set(Modchu_AS.openGlHelperSetLightmapTextureCoords, Modchu_AS.get(Modchu_AS.openGlHelperLightmapTexUnit), (float) ls / 1.0F, (float) lt / 1.0F);
	}

	public static void setTexture(Object o) {
/*
		setTexture(o, Modchu_Main.getMinecraftVersion() < 160 ? Modchu_AS.get(Modchu_AS.renderManagerGetEntityRenderObject, Modchu_AS.get(Modchu_AS.minecraftThePlayer)) : null);
	}

	public static void setTexture(Object o, Object render) {
*/
		//if (Modchu_Main.getMinecraftVersion() > 159) 
		//Modchu_Debug.mDebug("ModchuModel_ModelBaseNihil setTexture o="+o);
			Modchu_AS.set(Modchu_AS.renderEngineBindTexture, o);
		//else Modchu_AS.get(Modchu_AS.renderLoadDownloadableImageTexture, render, null, o);
	}
}
