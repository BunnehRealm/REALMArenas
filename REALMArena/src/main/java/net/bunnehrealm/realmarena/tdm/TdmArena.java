package net.bunnehrealm.realmarena.tdm;

import java.util.ArrayList;

import org.bukkit.Location;

import net.bunnehrealm.realmarena.Arena;

public class TdmArena extends Arena{
	
	public ArrayList<String> redPlayers = new ArrayList<String>();
	public ArrayList<String> bluePlayers = new ArrayList<String>();

	public Location redSpawn;
	
	public Location blueSpawn;
	
	public TdmArena(String name, Location locLobby, Location locSpectate,
			int maxPlayers, Location redSpawn, Location blueSpawn ) {
		super(name, locLobby, locSpectate, maxPlayers);
		this.redSpawn = redSpawn;
		this.blueSpawn = blueSpawn;
	}

	public Location getRedSpawn(){
		return this.redSpawn;
	}
	
	public Location getBlueSpawn(){
		return this.blueSpawn;
	}
	
	public void setRedSpawn(Location loc){
		this.redSpawn = loc;
	}
	
	public void setBlueSpawn(Location loc){
		this.blueSpawn = loc;
	}
	
	public ArrayList<String> getRedPlayers(){
		return this.redPlayers;
	}
	
	public ArrayList<String> getBluePlayers(){
		return this.bluePlayers;
	}
	
}
