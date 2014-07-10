package net.bunnehrealm.realmarena.commands;

import net.bunnehrealm.realmarena.RealmArenas;



import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RaCommand implements CommandExecutor{
	RealmArenas plugin = RealmArenas.plugin;	
	public RaCommand(RealmArenas instance){
		this.plugin = instance;
	}


	@Override
	public boolean onCommand(CommandSender cs, Command command,
			String label, String[] args) {
	
		if(label.equalsIgnoreCase("ra")){
			if(!(cs instanceof Player)){
				cs.sendMessage("This is a player only command.");
				
			}
			else{
				Player p = (Player) cs;
				if(args.length == 0){
					wrongCommand(p);
				}
				else{
					if(args.length == 1){
						if(args[0].equalsIgnoreCase("create")){
							if(!(p.hasPermission("realmarenas.create") && p.isOp())){
								p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
							}
							else{
								if(args.length != 3){
									p.sendMessage(ChatColor.RED + "The correct usage is " + ChatColor.GOLD + "/ra create <name> <type>");
								}
								else{
									if(args[2].equalsIgnoreCase("tdm")){
										
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public void wrongCommand(Player p){
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThat is not a detected argument. Type &6/ra ?"));
	}

}
