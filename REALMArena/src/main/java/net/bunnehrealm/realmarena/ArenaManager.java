package net.bunnehrealm.realmarena;

import net.bunnehrealm.utils.InventoryManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ArenaManager {
	
	RealmArenas plugin;
	
	public ArenaManager(RealmArenas plugin){
		this.plugin = plugin;
	}
	public InventoryManager im = new InventoryManager(plugin);
	
	public Arena getArena(String name){
		for(Arena a : Arena.arenas){
			if(a.getName().equalsIgnoreCase(name)){
				return a;
			}
		}
		return null;
	}
	
	public void addPlayers(Player p, String arenaName){
		
		if(getArena(arenaName) != null){
			
			Arena arena = getArena(arenaName);
			
			if(!arena.isFull()){
				
				if(!arena.isStarted()){
					
					im.saveInventory(p.getName());
					
					p.getInventory().clear();
					
					p.getInventory().setHelmet(null);
					p.getInventory().setChestplate(null);
					p.getInventory().setLeggings(null);
					p.getInventory().setBoots(null);
					
					p.setHealth(p.getMaxHealth());
					p.setFireTicks(0);
					
					p.teleport(arena.getLobby());
					
					arena.getPlayers().add(p.getName());
					
					int playersLeft = arena.getMaxPlayers() - arena.getPlayers().size();
					
					arena.sendPlayers(ChatColor.GREEN + p.getName() + ChatColor.BLUE +  " has joined the lobby!");
					
					
				}
				
			}
		}
		
	}
	
}
