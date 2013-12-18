package net.minecraft.src;

import java.util.EnumSet;
import java.util.Random;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.model.ModchuModel_Main;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="mod_ModchuModel", name="mod_ModchuModel")
public class mod_ModchuModel implements ITickHandler {

	public static mod_ModchuModel mod_ModchuModel;
	public static boolean isServer = false;

	static {
		isServer = FMLCommonHandler.instance().getSide().isServer();
		//Modchu_Debug.Debug("static isServer="+isServer);
	}

	public mod_ModchuModel()
	{
		if (isServer) return;
	}

	public String getName() {
		return ModchuModel_Main.modName;
	}

	public String getVersion() {
		return ModchuModel_Main.versionString;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	//public void load() {
		Modchu_Debug.lDebug("mod_ModchuModel modchu_Main preInit");
		if (isServer) {
			Modchu_Debug.systemDebug("mod_ModchuModel isServer return.", 999);
			Modchu_Debug.lDebug("mod_ModchuModel isServer return.");
			return;
		}
		mod_ModchuModel = this;
		ModchuModel_Main ModchuModel_Main = new ModchuModel_Main();
		ModchuModel_Main.load();
		if (!isServer) {
			TickRegistry.registerTickHandler(this, Side.CLIENT);
		} else {
			TickRegistry.registerTickHandler(this, Side.SERVER);
		}
		//ModLoader.setInGameHook(this, true, true);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	//public void modsLoaded() {
		if (isServer) return;
		Modchu_Debug.lDebug("mod_ModchuModel init");
		((mod_Modchu_ModchuLib) Modchu_Main.mod_Modchu_ModchuLib).loadCheckThread.register(Modchu_Reflect.getMethod("modchu.model.ModchuModel_Main", "modsLoaded"));
	}

	public boolean onTickInGame(float f, Minecraft minecraft)
	{
		if (isServer) return false;
		return ModchuModel_Main.onTickInGame(f, (Object) minecraft);
	}

	public void modsLoaded() {
	}

	public void load() {
	}

	public String getPriorities() {
		return null;
	}

	public boolean doTickInGUI(TickType type, boolean end, Object... tickData) {
		return false;
	}

	public boolean doTickInGame(TickType type, boolean end, Object... tickData) {
		return false;
		//if (isServer) return false;
		//return ModchuModel_Main.onTickInGame(0.0F, null);
	}

	public void generateSurface(World w, Random random, int i, int j) {
	}

	public void generateNether(World w, Random random, int i, int j) {
	}

	public int addFuel(int itemId, int damage) {
		return 0;
	}

	public void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
	}

	public void takenFromFurnace(EntityPlayer player, ItemStack item) {
	}

	public void onClientLogout(INetworkManager manager) {
	}

	public void onClientLogin(EntityPlayer player) {
	}

	public void serverDisconnect() {
	}

	public void serverConnect(NetHandler handler) {
	}

	public void receiveCustomPacket(Packet250CustomPayload packet) {
	}

	public void clientChat(String text) {
	}

	public void onItemPickup(EntityPlayer player, ItemStack item) {
	}

	public void serverCustomPayload(NetServerHandler handler, Packet250CustomPayload packet) {
	}

	public void serverChat(NetServerHandler source, String message) {
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (isServer) return;
		ModchuModel_Main.onTickInGame(0.0F, null);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return null;
	}
}
