package me.kennedydev.diamondduels.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.kennedydev.diamondduels.main.Util;

public class Kit {
	
	//TUTORIAL USED: https://www.youtube.com/watch?v=EQnwgdvncf8
	//22:50 talks about clicking in GUI
	//TODO: OFFHAND SLOT disabled PRE- 1.9 versions
	//Eventually will be used as new Kit(Player, InventorySave);
	//TODO: Inventory default layout using array list on seperate file, possibly YML for owner customization
	//TODO: Custom item creation using YML (Every custom item with ID: "dd_itemname")
	
	/*
	public static Inventory inv;
	public static String inv_name;
	public static int inv_size = 36;
	
	public static void initialize() {
		
		inv_name = Util.color("&5Test GUI");
		inv = Bukkit.createInventory(null, inv_size);
		
	}
		
	public static Inventory getInventory (Player p) {
		
		
		//THIS SHOULD RETURN PLAYER'S INVENTORY FROM FILE
		
		Inventory toReturn = Bukkit.createInventory(p, inv_size, inv_name);
		Items.addItem(toReturn, "dirt", 1, 1, "LORE", "");
		
		
		
		
		return toReturn;
		
		
	}
	*/
}
