package modchu.model;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityPlayerDummy;
import modchu.lib.Modchu_IEntityPlayerDummyMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;

public class ModchuModel_EntityPlayerDummyMaster implements Modchu_IEntityPlayerDummyMaster {
	public static Object[] armorItemStack;
	public boolean initFlag;
	public Modchu_IEntityPlayerDummy base;
	public Object popWorld;

	public ModchuModel_EntityPlayerDummyMaster(HashMap<String, Object> map) {
		base = (Modchu_IEntityPlayerDummy) map.get("base");
		Modchu_Debug.mDebug("ModchuModel_EntityPlayerDummyMaster base="+base);
		popWorld = map.get("Object");
		int version = Modchu_Main.getMinecraftVersion();
		armorItemStack = Modchu_Reflect.newInstanceArray("ItemStack", 4);
		armorItemStack[0] = Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item") }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "diamond_helmet") });
		armorItemStack[1] = Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item") }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "diamond_chestplate") });
		armorItemStack[2] = Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item") }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "diamond_leggings") });
		armorItemStack[3] = Modchu_Reflect.newInstance("ItemStack", new Class[]{ Modchu_Reflect.loadClass("Item") }, new Object[]{ Modchu_AS.get(Modchu_AS.getItem, "diamond_boots") });
		if (version > 202) {
			for (int i = 0; i < armorItemStack.length; i++) {
				Object itemStack = armorItemStack[i];
				Object nonNullList = Modchu_AS.get("EntityLiving", "getArmorInventoryList", base);
				//Modchu_Debug.mDebug("ModchuModel_EntityPlayerDummyMaster nonNullList="+nonNullList);
				Modchu_AS.set("NonNullList", "set", new Class[]{ int.class, Object.class }, nonNullList, new Object[]{ i, itemStack });
			}
			//Object nonNullList1 = Modchu_AS.get("EntityLiving", "getArmorInventoryList", base);
			//Modchu_Debug.mDebug("ModchuModel_EntityPlayerDummyMaster nonNullList1="+nonNullList1);
		}
		else if (version > 189) {
			Modchu_AS.set("EntityLiving", "inventoryArmor", base, new Object[]{ armorItemStack });
		}
	}

	@Override
	public void init() {
		if (initFlag) return;
		initFlag = true;
		setMaxHealth(0.0D);
	}

	@Override
	public void preparePlayerToSpawn() {
	}

	@Override
	public boolean onLivingUpdate() {
		return true;
	}

	@Override
	public void moveEntityWithHeading(float f, float f1) {
		base.superMoveEntityWithHeading(f, f1);
	}

	@Override
	public String getHurtSound() {
		return null;
	}

	@Override
	public Object getCreatureAttribute() {
		return null;
	}

	@Override
	public float[] setSize(float f, float f1) {
		return new float[]{ f, f1 };
	}

	@Override
	public double getMountedYOffset() {
		return 0;
	}

	@Override
	public double getYOffset() {
		return 0;
	}

	@Override
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		return false;
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return false;
	}

	@Override
	public Object copyPlayer(Object entityplayer) {
		return entityplayer;
	}

	@Override
	public Object copyInventory(Object inventoryplayer) {
		return inventoryplayer;
	}

	@Override
	public void resetHeight() {
	}

	@Override
	public void updateRidden() {
	}

	@Override
	public boolean attackEntityFrom(Object var1, Object par1DamageSource, int par2) {
		return false;
	}

	@Override
	public boolean attackEntityFrom(Object par1DamageSource, int par2) {
		return false;
	}

	@Override
	public void onDeath(Object par1DamageSource) {
	}

	@Override
	public int setHealth(int i) {
		return i;
	}

	@Override
	public float getHealth() {
		return 0.0F;
	}

	@Override
	public float setHealth(float f) {
		return f;
	}

	@Override
	public double setMaxHealth(double d) {
		return d;
	}

	@Override
	public float getShadowSize() {
		return 0.0F;
	}

	@Override
	public Object getHeldItem() {
		return null;
	}

	@Override
	public Object getItemStackFromSlot(Object entityEquipmentSlotOrInt) {
		int i = getEntityEquipmentSlotToInt(entityEquipmentSlotOrInt);
		return i > 0
				&& i - 1 < armorItemStack.length ? armorItemStack[i] : null;
	}

	@Override
	public void setItemStackToSlot(Object entityEquipmentSlotOrInt, Object itemStack) {
		int i = getEntityEquipmentSlotToInt(entityEquipmentSlotOrInt);
		if (i > 0
				&& i - 1 < armorItemStack.length) armorItemStack[i] = itemStack;
	}

	@Override
	public Object[] getInventory() {
		return null;
	}

	@Override
	public int getMaxHealth() {
		return 0;
	}

	@Override
	public Object getCurrentArmor(int i) {
		return i > 0
				&& i - 1 < armorItemStack.length ? armorItemStack[i] : null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, Object itemStack) {
		armorItemStack[i] = itemStack;
	}

	private int getEntityEquipmentSlotToInt(Object entityEquipmentSlot) {
		int version = Modchu_Main.getMinecraftVersion();
		int i = -1;
		if (version > 189) {
			Class EntityEquipmentSlot = Modchu_Reflect.loadClass("EntityEquipmentSlot");
			if (EntityEquipmentSlot != null
					&& EntityEquipmentSlot.isInstance(entityEquipmentSlot)) {
				i = Modchu_AS.getEnum("EntityEquipmentSlot", "HEAD").equals(entityEquipmentSlot) ? 0 :
					Modchu_AS.getEnum("EntityEquipmentSlot", "CHEST").equals(entityEquipmentSlot) ? 1 :
					Modchu_AS.getEnum("EntityEquipmentSlot", "FEET").equals(entityEquipmentSlot) ? 2 :
					Modchu_AS.getEnum("EntityEquipmentSlot", "LEGS").equals(entityEquipmentSlot) ? 3 : -1;
			} else {
				i = Modchu_CastHelper.Int(entityEquipmentSlot);
			}
		} else {
			i = Modchu_CastHelper.Int(entityEquipmentSlot);
		}
		return i;
	}

}
