package me.kennedydev.diamondduels.inventory;

import java.io.IOException;

import org.bukkit.entity.Player;

public class invManager {

	
	
	
	
	public static void getInventoryBeforeDuel(Player p) {
		
	}
	
	
	public static void replaceInventory(Player p, String inventoryString){
		try {
			p.getInventory().setContents(invData.itemStackArrayFromBase64(inventoryString));
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
