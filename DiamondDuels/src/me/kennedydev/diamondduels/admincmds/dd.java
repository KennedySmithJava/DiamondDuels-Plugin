package me.kennedydev.diamondduels.admincmds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.main.Main;

public class dd implements CommandExecutor {

	
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public static ArrayList<String> arenaCommands = new ArrayList<String>((Arrays.asList("create [arena] [displayname]", "delete [arena]", "rename [arena] [newDisplayname]", "list", "tp [arena]", "info [arena]", "setspawn1 [arena]", "setspawn2 [arena]")));;
	public static ArrayList<String> settingsCommands = new ArrayList<String>((Arrays.asList("setprefix [prefix]", "setcolorcode [char]", "setmessage [messageName] [message]")));;
	public static ArrayList<String> duelsCommands = new ArrayList<String>((Arrays.asList("active", "find [playerName]", "end [playerName]", "new [player1Name] [player2Name]")));;
	public static ArrayList<String> GUICommands = new ArrayList<String>((Arrays.asList("setslot", "edit", "delete", "rename", "move", "preview")));;
	
	public dd(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("dd").setExecutor(this);
		plugin.getCommand("dd").setTabCompleter(new AdminTabCompleter());
		
	}

	
	@Override
	public boolean onCommand(CommandSender player, Command command, String label, String[] args) {

		if(!(player instanceof Player)) {
			return true; //Ends here if command sent by console
		}
		
		Player sender = (Player) player;
		
		if(sender.hasPermission("diamonddeuls.admin")) {
			
			if (args.length == 0) {
				Bukkit.broadcastMessage("Invalid arguments! Did you add any?");
			}
			
			else {
				
				
				if (args[0].equalsIgnoreCase("arena")) {
					new ddArena(plugin, sender, args);
				}
				
				if (args[0].equalsIgnoreCase("gui")) {
					new ddGUI(plugin, sender, args);
				}
				
				
			}
			
			
		}
		
		if(!sender.hasPermission("diamonddeuls.admin")) {
			
		}
	
		return false;
	}
	
	public static ArrayList<String> getArenaCommands(){
		return arenaCommands;
	}
	public static ArrayList<String> getSettingsCommands(){
		return settingsCommands;
	}
	public static ArrayList<String> getDuelsCommands(){
		return duelsCommands;
	}

	public static ArrayList<String> getGUICommands() {
		return GUICommands;
	}
	
}
