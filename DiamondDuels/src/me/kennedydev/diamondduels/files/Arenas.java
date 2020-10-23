package me.kennedydev.diamondduels.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.main.Main;
import me.kennedydev.diamondduels.main.Messages;

public class Arenas {

	private static File customConfigFile;
	private static FileConfiguration customConfig;
	private static ArrayList<String> arenas = new ArrayList<String>();
	static int numArenas;

	public static FileConfiguration getConfig() {
		return Arenas.customConfig;
	}

	public static void createFile() {
		customConfigFile = new File(Main.main.getDataFolder().getPath(), "arenas.yml");

		if (!customConfigFile.exists()) {
			customConfigFile.getParentFile().mkdirs();
			Main.main.saveResource("arenas.yml", false);
		}

		customConfig = new YamlConfiguration();

		try {
			customConfig.load(customConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void load() {
		try {
			ConfigurationSection section = getConfig().getConfigurationSection("arenas");

			for (String key : section.getKeys(false)) {
				arenas.add(key);
			}
		} catch (Exception e) {
			Bukkit.broadcastMessage("Couldn't load arena list. It might be empty.");
		}
	}

	public static void saveConfig() {
		if (Arenas.customConfig == null || Arenas.customConfigFile == null) {
			return;
		}
		try {
			Arenas.getConfig().save(Arenas.customConfigFile);
		} catch (IOException e) {

		}
	}

	public static void addArena(String name, String displayname, Player sender) {

		/*
		 * ALREADY HANDLED BY COMMAND ARGUEMENTS
		 * 
		 * 
		 * if(displayname == null || displayname.isEmpty() || displayname.isBlank()) {
		 * sender.sendMessage("Please enter valid display name for the arena."); return;
		 * }
		 */

		getConfig().set("arenas." + name + ".displayname", displayname);


		saveConfig();

	}

	public static String getArenaDisplayname(String arena) {
		String string = getConfig().getString("arenas." + arena + ".displayname");
		return string;
	}

	public static void setSpawn1(String arenaName, String worldName, double x, double y, double z) {
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.world")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.x")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.y")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.z")

		) {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.world", worldName);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.x", x);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.y", y);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.z", z);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.x")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.x", x);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.y")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.y", y);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.z")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.z", z);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint1.location.world")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.world", worldName);
		} else {
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.world", worldName);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.x", x);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.y", y);
			getConfig().set("arenas." + arenaName + ".spawnpoint1.location.z", z);
		}

		saveConfig();

	}

	public static void setSpawn2(String arenaName, String worldName, double x, double y, double z) {
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.world")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.x")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.y")
				&& !getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.z")

		) {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.world", worldName);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.x", x);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.y", y);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.z", z);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.x")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.x", x);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.y")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.y", y);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.z")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.z", z);
		}
		if (!getConfig().isSet("arenas." + arenaName + ".spawnpoint2.location.world")) {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.world", worldName);
		} else {
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.world", worldName);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.x", x);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.y", y);
			getConfig().set("arenas." + arenaName + ".spawnpoint2.location.z", z);
		}

		saveConfig();
	}

	public static boolean arenaExists(String arenaName) {

		if (getConfig().isSet("arenas." + arenaName)) {
			return true;
		}

		return false;

	}

	public static double getSpawnpointX(String arenaName, String spawnpoint) {
		// CHECK IF OBJECT IS DOUBLE WHEN USING
		double cord;
		if (!getConfig().isSet("arenas." + arenaName + "." + spawnpoint + ".location.x")) {
			return (Double) null;
		}
		cord = getConfig().getDouble("arenas." + arenaName + "." + spawnpoint + ".location.x");
		return cord;
	}
	
	public static double getSpawnpointY(String arenaName, String spawnpoint) {
		double cord;
		if (!getConfig().isSet("arenas." + arenaName + "." + spawnpoint + ".location.y")) {
			return (Double) null;
		}
		cord = getConfig().getDouble("arenas." + arenaName + "." + spawnpoint + ".location.y");
		return cord;
	}
	
	public static double getSpawnpointZ(String arenaName, String spawnpoint) {
		double cord;
		if (!getConfig().isSet("arenas." + arenaName + "." + spawnpoint + ".location.z")) {
			return (Double) null;
		}
		cord = getConfig().getDouble("arenas." + arenaName + "." + spawnpoint + ".location.z");
		return cord;
	}
	
	public static float getSpawnpointRotation(String arenaName, String spawnpoint) {
		float rotation;
		rotation = Float.parseFloat(getConfig().getString("arenas." + arenaName + "." + spawnpoint + ".location.x"));
		return rotation;
	}

	public static Object getSpawnpointWorldName(String arenaName, String spawnpoint) {

		String worldName;
		if (!getConfig().isSet("arenas." + arenaName + "." + spawnpoint + ".location.world")) {
			return null;
		}

		worldName = getConfig().getString("arenas." + arenaName + "." + spawnpoint + ".location.world");
		return worldName;
	}

    public static ArrayList<String> getArenaList(){
    	arenas.clear();
    	try {
            ConfigurationSection section = getConfig().getConfigurationSection("arenas");
            for (String key : section.getKeys(false)) {
            	arenas.add(key);
            }
    	}catch (Exception e){
    		Bukkit.broadcastMessage("Couldn't load arena list. Have you added any?");
    	}
    	return arenas;
    }
    
	public static void deleteArena(String arenaName) {
		getConfig().set("arenas." + arenaName, null);
	}
	
	public static boolean locationsSet(String arenaName, String spawnpoint) {
		
		if(getConfig().isSet("arenas." + arenaName + "." + spawnpoint + ".location")) {
			return true;
		}
		
		return false;
		
	}
	
	public static void renameArena(String arenaName, String displayName) {
		
		Arenas.getConfig().set("arenas." + arenaName + ".displayname", displayName);
		
	}
	
	public static int getNumArenas() {
		return numArenas;
	}

}
