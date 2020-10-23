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

import me.kennedydev.diamondduels.cmds.cmdKit;
import me.kennedydev.diamondduels.main.Main;


public class Inventories {

    private static File customConfigFile;
    private static FileConfiguration customConfig;
   	private static ArrayList<String> players = new ArrayList<String>();
	static int numInventories;
    
	
    public static FileConfiguration getConfig() {
        return Inventories.customConfig;
    }

    public static void createFile() {
        customConfigFile = new File(Main.main.getDataFolder().getPath(), "inventories.yml");
        
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            Main.main.saveResource("inventories.yml", false);
         }
        
        customConfig= new YamlConfiguration();
        
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
   
    public static void load(){
    	try {
            ConfigurationSection section = getConfig().getConfigurationSection("players");
            
            for (String key : section.getKeys(false)) {
            	players.add(key);
            }
    	}catch (Exception e){
    		Bukkit.broadcastMessage("Couldn't load inventory list. It might be empty.");
    	}
    }

    public static void saveConfig() {
    	if(Inventories.customConfig == null || Inventories.customConfigFile == null) {
    		return;
    	}
    	try {
    		Inventories.getConfig().save(Inventories.customConfigFile);
    	}catch (IOException e) {
    		
    	}
    }
        
    public static void addInventory(Player player, String inventory) {
    	
    	getConfig().set("players." + player.getUniqueId().toString() + ".inv", cmdKit.getInv());
    	Bukkit.broadcastMessage(getInventorySerialized(player));
    	Bukkit.broadcastMessage("Should have saved");
    	
    }
    
    public static String getInventorySerialized(Player player){
    	
    	String inventoryString = getConfig().getString("players." + player.getUniqueId().toString() + ".inv");
    	
    	return inventoryString;
    }
    
    public static int getNumIventories() {
    	return numInventories;
    }

}
