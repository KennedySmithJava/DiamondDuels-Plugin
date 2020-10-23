package me.kennedydev.diamondduels.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.kennedydev.diamondduels.main.Main;
import me.kennedydev.diamondduels.main.Util;

public class GUI {
	
	private static Inventory gui = null;
	private static File customConfigFile;
	private static FileConfiguration customConfig;
	private static ArrayList<String> slots = new ArrayList<String>();

	public static FileConfiguration getConfig() {
		return GUI.customConfig;
	}

	public static void createFile() {
		customConfigFile = new File(Main.main.getDataFolder().getPath(), "gui.yml");
		if (!customConfigFile.exists()) {
			customConfigFile.getParentFile().mkdirs();
			Main.main.saveResource("gui.yml", false);
		}
		customConfig = new YamlConfiguration();
		try {
			customConfig.load(customConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		

		
	}

	public static void saveConfig() {
		if (GUI.customConfig == null || GUI.customConfigFile == null) {
			return;
		}
		try {
			GUI.getConfig().save(GUI.customConfigFile);
		} catch (IOException e) {
		}
	}
	
	public static void createGUI(int size, String name) {
		
	        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
	        gui = Bukkit.createInventory(null, size, name);
	        
	        // Put the items into the inventory
	        initializeItems();
		
	}
	
    public static void initializeItems() {
    	
    	for(String slotNum : getSlots()) {
    		
    		
    		gui.setItem(Integer.parseInt(slotNum) - 1, 
    				createGUIItem(
    						String.valueOf(slotNum),
    						getMaterial(slotNum), 
    						getDisplayname(slotNum), 
    						getLore(slotNum)));
    	}
    	
    	for(int slot = 0; slot < gui.getSize(); slot++) {
    		
    		if(gui.getItem(slot) == null) {
    			
        		gui.setItem(slot, 
        				createFiller(
        						String.valueOf(slot),
        						"BLUE_STAINED_GLASS_PANE", 
        						" "
        						));
    			}
    			
    		}
    }
    	
    protected static ItemStack createGUIItem(final String slot, final String material, final String name, final ArrayList<String> lore) {
    	
        ItemStack item = null;

        
        try {
        	
        	try {
                item = new ItemStack(Enum.valueOf(Material.class, material), 1);
                
                final ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Util.color(name));
                meta.setLore(lore);
                
                item.setItemMeta(meta);
                
         	} catch (IllegalArgumentException i) {
         		
             	ArrayList<String> loreError = new ArrayList<String>();
         		lore.add(material);
             	
         		item = new ItemStack(Enum.valueOf(Material.class, "BARRIER"), 1);
                 final ItemMeta meta = item.getItemMeta();
                 meta.setLore(loreError);
                 meta.setDisplayName(Util.color("&c&lINVALID BLOCK NAME:"));
                 item.setItemMeta(meta);
         		Bukkit.broadcastMessage("Unkown Material Type: " + material + "in slot: " + slot);
         	}  
        	
        }catch (NullPointerException e) {
        	
     		 item = new ItemStack(Enum.valueOf(Material.class, "LIGHT_GRAY_STAINED_GLASS_PANE"), 1);
             final ItemMeta meta = item.getItemMeta();
             meta.setDisplayName(Util.color(" "));
             item.setItemMeta(meta);
        	
        }
        
        return item;
    }
    
    protected static ItemStack createFiller(final String slot, final String material, final String name) {
    	
    	ItemStack item = null; 
    	
	     try {	
	    	try {
	           item = new ItemStack(Enum.valueOf(Material.class, material), 1);
	           final ItemMeta meta = item.getItemMeta();
	           // Set the name of the item
	           meta.setDisplayName(Util.color(name));
	           item.setItemMeta(meta);
	           
	    	} catch (IllegalArgumentException i) {
	        	ArrayList<String> lore = new ArrayList<String>();
	    		lore.add(material);
	        	
	    		item = new ItemStack(Enum.valueOf(Material.class, "BARRIER"), 1);
	            final ItemMeta meta = item.getItemMeta();
	            meta.setLore(lore);
	            meta.setDisplayName(Util.color(9"&c&lINVALID BLOCK NAME:"));
	            item.setItemMeta(meta);
	    		Bukkit.broadcastMessage("Unkown Material Type: " + material + "in slot: " + slot);
	    	}
	    	
	    }catch (NullPointerException e) {
	    	
	 		 item = new ItemStack(Enum.valueOf(Material.class, "LIGHT_GRAY_STAINED_GLASS_PANE"), 1);
	         final ItemMeta meta = item.getItemMeta();
	         meta.setDisplayName(Util.color(" "));
	         item.setItemMeta(meta);
	    	
	    }

        return item;
    }
    
    public static void openGUI(final HumanEntity ent) {
		createGUI(27, Util.color(getGUIName()));
        ent.openInventory(gui);
    }
    
    public static Inventory getGUI(){
    	return gui;
    }
    
    public static String getGUIName() {
    	return getConfig().getString("gui.gui-name");
    }
    
    public static void newItem(final String slot, final String material, final String name) {
    	
    	getConfig().set("gui.slots." + slot + ".block-material", material);
    	getConfig().set("gui.slots." + slot + ".displayname", name);
    	getConfig().set("gui.slots." + slot + ".type", "static");

    	saveConfig();
    }
    
    //ITEM GET METHODS
    
    public static ArrayList<String> getSlots() {
       	slots.clear();
    	try {
            ConfigurationSection section = getConfig().getConfigurationSection("gui.slots");
            for (String key : section.getKeys(false)) {
            	slots.add(key);
            }
    	}catch (Exception e){
    		Bukkit.broadcastMessage("Couldn't load slot list. Have you added any?");
    	}
    	return slots;
    }
    
    public static boolean slotExists(String slot) {
    	
    	
		return true;
    }
    
    public static void getType(String slot) {

    	
    }
    
    public static String getMaterial(String slot) {
    	
    	if(!getConfig().isSet("gui.slots." + slot + ".block-material")) {
    		getConfig().set("gui.slots." + slot + ".block-material", "BEACON");
    	}
    
    	String fullMaterial = getConfig().getString("gui.slots." + slot + ".block-material");
    	
    	String[] pieces = fullMaterial.split(":");
    	
    	return pieces[0];
    	
    }
    
    public static String getData(String slot) {
    	
    	String fullMaterial = getConfig().getString("gui.slots." + slot + ".block-material");
    	
    	String[] pieces = fullMaterial.split(":");
    	
    	return pieces[1];
    	
    }
    
    public static String getArena(String slot) {

    	return getConfig().getString("gui.slots." + slot + ".arena");
    	
    }
    
    public static String getDisplayname(String slot) {

    	if(!getConfig().isSet("gui.slots." + slot + ".displayname")) {
    		return " ";
    	}
    	
    	return getConfig().getString("gui.slots." + slot + ".displayname");
    	
    }
    
    public static void getEnchanted(String slot) {


    	
    }9
    
    public static void getStackQuantity(String slot) {
    	
    }
    
    public static void getPermissionNecessary(String slot) {
    	
    }

    public static ArrayList<String> getLore(String slot) {
    	
    	ArrayList<String> lore = new ArrayList<String>();
    	
    	
    	try {
            ConfigurationSection section = getConfig().getConfigurationSection("gui.slots." + slot + ".lore-lines");
            
            ArrayList<String> loreLines = new ArrayList<String>();
            
            for (String key : section.getKeys(false)) {
            	
            	loreLines.add(key);
            }
            
            
    	}catch (Exception e){
        	return lore;
    	}
    	
    	
    	
    	
    	try {
            ConfigurationSection section = getConfig().getConfigurationSection("gui.slots." + slot + ".lore-lines");
            for (String key : section.getKeys(false)) {
            	
            	lore.add(getConfig().getString("gui.slots." + slot + ".lore-lines." + key));
            }
            
            return lore;
            
    	}catch (Exception e){
    		Bukkit.broadcastMessage("Unkown error");
    		return null;
    	}
    	
    }
    
    //ITEM IS METHODS
    
    public static boolean isArena(String slot){
    	

    	
    	if(getConfig().isSet("gui.slots." + slot + ".type")) {
        	if(getConfig().getString("gui.slots." + slot + ".type").equalsIgnoreCase("arena")) {
        		return true;
        	}
        	
    	}
    	else {
    		return false;
    	}
    	
		return false;

    }
    
    public static boolean isArenaSet(String slot){
    	
    	if(getConfig().isSet("gui.slots." + slot + ".arena")) {
        	return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
}
