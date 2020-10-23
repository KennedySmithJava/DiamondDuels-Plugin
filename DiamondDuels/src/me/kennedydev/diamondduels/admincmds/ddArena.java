package me.kennedydev.diamondduels.admincmds;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Main;
import me.kennedydev.diamondduels.main.Messages;

public class ddArena {

	
	@SuppressWarnings("unused")
	private Main plugin;
	private Player sender;
	
	public static ArrayList<String> arenaCommands = new ArrayList<String>((Arrays.asList("create [arena] [displayname]", "delete [arena]", "rename [arena] [newDisplayname]", "list", "tp [arena]", "info [arena]", "setspawn1 [arena]", "setspawn2 [arena]")));;
	public static ArrayList<String> settingsCommands = new ArrayList<String>((Arrays.asList("setprefix [prefix]", "setcolorcode [char]", "setmessage [messageName] [message]")));;
	public static ArrayList<String> duelsCommands = new ArrayList<String>((Arrays.asList("active", "find [playerName]", "end [playerName]", "new [player1Name] [player2Name]")));;
	
	public ddArena(Main plugin, Player player, String[] args) {
		
		this.plugin = plugin;
		this.sender = player;
		
		
		if(!(sender instanceof Player)) {
			return; //Ends here if command sent by console
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("create")) {
			
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorSetName, sender);
				return;
			}
			if(args.length < 4) {
				Messages.send(Messages.arenaErrorSetDisplayname, sender);
				return;
			}
			String arenaName = args[2];
			String displayName = args[3];
			new ddArenaCreate(arenaName, displayName, sender);
			
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("delete")) {
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorDeleteSpecifyArena, sender);
				return;
			}
			String arenaName = args[2];
			new ddArenaDelete(arenaName, sender);
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("rename")) {
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorRenameSpecifyArena, sender);
				return;
			}
			if(args.length < 4) {
				Messages.send(Messages.arenaErrorRenameSetDisplayname, sender);
				return;
			}
			String arenaName = args[2];
			String displayName = args[3];
			new ddArenaRename(arenaName, displayName, sender);
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("info")) {
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorInfoSpecifyArena, sender);
				return;
			}
			String arenaName = args[2];
			new ddArenaInfo(arenaName, sender);
			
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("list")) {
			new ddArenaList(sender);
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("setspawn1")) {
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorSetspawn1SpecifyArena, sender);
				return;
				}
				String arenaName = args[2];
				if(!Arenas.arenaExists(arenaName)) {
				Messages.send("Arena " + arenaName + " doesn't exist.", sender);
				return;
				}
				new ddArenaSetSpawn1(arenaName, sender);
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("setspawn2")) {
			
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorSetspawn2SpecifyArena, sender);
				return;
				}
				String arenaName = args[2];
				if(!Arenas.arenaExists(arenaName)) {
				Messages.send("Arena " + arenaName + " doesn't exist.", sender);
				return;
				}
				new ddArenaSetSpawn2(arenaName, sender);
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		if (args[1].equalsIgnoreCase("tp")) {
			if(args.length < 3) {
				Messages.send(Messages.arenaErrorTpSpecifyArena, sender);
				return;
				}
			new ddArenaTp(args[2], sender);
		}
					
		/////////////////////////////////////////////////////////////////////////////////////////			
		
	
		
		
	}

	
}
