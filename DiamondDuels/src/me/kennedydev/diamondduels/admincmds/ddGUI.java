package me.kennedydev.diamondduels.admincmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.main.Main;

public class ddGUI {

	
	@SuppressWarnings("unused")
	private Main plugin;
	private Player sender;
	
	public ddGUI(Main plugin, Player player, String[] args) {
		
		this.plugin = plugin;
		this.sender = player;
		
		
		if(!(sender instanceof Player)) {
			return; //Ends here if command sent by console
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("setslot")) {
			
			
			if(args.length < 3) {
				
				Bukkit.broadcastMessage("Specify a slot, block and displayname.");
				return;
			}
			
			if(args.length < 4) {
				
				Bukkit.broadcastMessage("Specify a block and displayname.");
				return;
			}
			
			if(args.length < 5) {
				
				Bukkit.broadcastMessage("Specify a displayname.");
				return;
			}
			
			new ddGUISetslot(sender, args[2], args[3], args[4]);
			
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("edit")) {
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("delete")) {
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("rename")) {
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("move")) {
			
			
			
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("preview")) {
			
			new ddGUIPreview(player);
			
		}
		
	
		
		
	}

	
}
