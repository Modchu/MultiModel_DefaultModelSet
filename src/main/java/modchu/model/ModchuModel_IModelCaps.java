package modchu.model;import modchu.lib.replacepoint.Modchu_IModelCapsReplacePoint;import modchu.model.multimodel.MultiModelBaseBiped;/** * モデル共通化用インターフェース。 */public interface ModchuModel_IModelCaps extends Modchu_IModelCapsReplacePoint, ModchuModel_IModelCapsConstant {	public Object getCapsValue(MultiModelBaseBiped model, ModchuModel_IModelCaps entityCaps, int pIndex, Object ...pArg);	public Object getCapsValue(MultiModelBaseBiped model, int pIndex, Object ...pArg);	public Object getCapsValue(ModchuModel_IModelCaps entityCaps, int pIndex, Object ...pArg);	public boolean setCapsValue(MultiModelBaseBiped model, ModchuModel_IModelCaps entityCaps, int pIndex, Object... pArg);	public boolean setCapsValue(MultiModelBaseBiped model, int pIndex, Object... pArg);	public boolean setCapsValue(ModchuModel_IModelCaps entityCaps, int pIndex, Object... pArg);}