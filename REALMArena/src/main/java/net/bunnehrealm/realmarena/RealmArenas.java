package net.bunnehrealm.realmarena;

import java.io.File;

import net.bunnehrealm.utils.InventoryManager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RealmArenas extends JavaPlugin{
	public File playersFile;
	public FileConfiguration players;
	public File arenasFile;
	public FileConfiguration arenas;

	public static RealmArenas plugin;
	
	public InventoryManager im = new InventoryManager(plugin);
	
	@Override
	public void onDisable(){
		plugin = null;
	}
	
	@Override
	public void onEnable(){
		plugin = this;
		
		playersFile = new File(getDataFolder(), "Players.yml");
		players = new YamlConfiguration();
		arenasFile = new File(getDataFolder(), "Arenas.yml");
		arenas = new YamlConfiguration();
		
		
	}
	
	
	
	
	public void firstPlayerRun() throws Exception {
		if (!playersFile.exists()) {
			getLogger().info("Creating a Players.yml file");
			playersFile.getParentFile().mkdirs();
			playersFile.createNewFile();

		}
	}

	public void loadPlayers() {
		try {
			players.load(playersFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePlayers() {
		try {
			players.save(playersFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
