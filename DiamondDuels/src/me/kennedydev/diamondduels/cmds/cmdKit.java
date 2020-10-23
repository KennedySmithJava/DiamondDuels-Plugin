package me.kennedydev.diamondduels.cmds;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.kennedydev.diamondduels.files.Inventories;
import me.kennedydev.diamondduels.inventory.*;
import me.kennedydev.diamondduels.main.Main;

public class cmdKit implements CommandExecutor{

	
	static String inventoryString;
	
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public cmdKit(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("saveinv").setExecutor(this);
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(!(sender instanceof Player)) {
			
			//If not a player
			return true; //Ends here
		}
		
		Player p = (Player) sender;
		
		//TODO: Create permissions file
		if(p.hasPermission("permission")) {
			
			Bukkit.broadcastMessage("Saving");
			
			inventoryString = invData.toBase64(p.getInventory());
			invManager.replaceInventory(p, inventoryString);
			
			Inventories.addInventory(p, inventoryString);
			Inventories.saveConfig();
			
			Bukkit.broadcastMessage("After Save");
		}
		
		
		return false;
	}

	public static String getInv(){
		
		return inventoryString;
		
	}
	
	
}
