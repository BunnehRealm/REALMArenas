package net.bunnehrealm.utils;

import java.util.List;

import net.bunnehrealm.realmarena.RealmArenas;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {
	
	RealmArenas plugin;
	
	public InventoryManager(RealmArenas plugin){
		this.plugin = plugin;
	}
	ItemStack[] inv;
	ItemStack[] armor; 
	
	public void saveInventory(String name){
		Player p = Bukkit.getPlayer(name);
		
		inv = p.getInventory().getContents();
		armor = p.getInventory().getArmorContents();
		
		RealmArenas.plugin.players.set(p.getUniqueId() + ".items", inv);
		RealmArenas.plugin.players.set(p.getUniqueId() + ".armor", armor);
		RealmArenas.plugin.savePlayers();
	}
	
	public void giveInventory(String name){
		Player p = Bukkit.getPlayer(name);
		
		RealmArenas.plugin.loadPlayers();
		List<?> inv = RealmArenas.plugin.players.getList(p.getUniqueId() + ".items");
		List<?> armor = RealmArenas.plugin.players.getList(p.getUniqueId() + ".armor");
		
		ItemStack[] invStack = inv.toArray(new ItemStack[inv.size()]);
		ItemStack[] armorStack = armor.toArray(new ItemStack[armor.size()]);
		
		p.getInventory().setContents(invStack);
		p.getInventory().setArmorContents(armorStack);
		
		RealmArenas.plugin.players.set(p.getUniqueId() + ".items", null);
		RealmArenas.plugin.players.set(p.getUniqueId() + ".armor", null);
		RealmArenas.plugin.savePlayers();
		
	}

}
