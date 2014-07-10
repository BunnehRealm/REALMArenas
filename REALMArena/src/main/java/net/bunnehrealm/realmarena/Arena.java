package net.bunnehrealm.realmarena;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Arena {

	//Get all the arenas
	public static ArrayList<Arena> arenas = new ArrayList<Arena>();
	
	//All the locations needed for a standard arena
	public Location locLobby, locSpectate;
	
	
	public ArrayList<String> players = new ArrayList<String>();
	//Amount of players in the arena
	public int playerCount;
	//Ammount of players allowed in the arena
	public int maxPlayers;
	
	//Name of the Arena
	public String name;
	
	//Boolean telling us if the arena has started or not
	public boolean started = false;
	
	
	public Arena(String name, Location locLobby, Location locSpectate, int maxPlayers){
		this.name = name;
		this.locLobby = locLobby;
		this.locSpectate = locSpectate;
		this.maxPlayers = maxPlayers;
		arenas.add(this);
	}
	
	public Location getLobby(){
		return this.locLobby;
	}
	
	
	public Location getSpectate(){
		return this.locSpectate;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getMaxPlayers(){
		return this.maxPlayers;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLobby(Location loc){
		this.locLobby = loc;
	}
	
	public void setSpectate(Location loc){
		this.locSpectate = loc;
	}
	
	public void setMaxPlayers(int maxPlayers){
		this.maxPlayers = maxPlayers;
	}
	
	public ArrayList<String> getPlayers(){
		return this.players;
	}
	
	public boolean isFull(){
		if(players.size() >= maxPlayers){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean setStarted(Boolean started){
		return this.started = started;
	}

	public boolean isStarted(){
		return this.started;
	}
	
	public void sendPlayers(String msg){
		for(String s : players){
			Bukkit.getPlayer(s).sendMessage(msg);
		}
	}
	
}
