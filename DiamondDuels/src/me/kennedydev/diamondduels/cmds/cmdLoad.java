package me.kennedydev.diamondduels.cmds;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.inventory.*;
import me.kennedydev.diamondduels.main.Main;

public class cmdLoad implements CommandExecutor{

	
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public cmdLoad(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("loadinv").setExecutor(this);
		
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
			
			
			try {
				p.getInventory().setContents(invData.itemStackArrayFromBase64(cmdKit.getInv()));
			} catch (IllegalArgumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
		
		
		return false;
	}

	
	
}
