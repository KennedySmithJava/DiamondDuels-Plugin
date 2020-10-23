package me.kennedydev.diamondduels.admincmds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.files.GUI;
import me.kennedydev.diamondduels.main.Util;

public class AdminTabCompleter implements TabCompleter {
	
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if (args.length == 1) {
        	
                commands.add("arena");
                commands.add("settings");
                commands.add("duels");
                commands.add("gui");
                
            StringUtil.copyPartialMatches(args[0], commands, completions);
            
            
        } 
        else if (args.length == 2) {
        	
            if (args[0].equals("arena")) {
            	
                    commands.addAll(dd.getArenaCommands());
                    
            }
            
            if (args[0].equals("settings")) {
            	
                commands.addAll(dd.getSettingsCommands());
                
            }
            
            if (args[0].equals("duels")) {
            	
                commands.addAll(dd.getDuelsCommands());
                
            }
            
            if (args[0].equals("gui")) {
            	
                commands.addAll(dd.getGUICommands());
                
                
            }
            
            StringUtil.copyPartialMatches(args[1], commands, completions);
        }
        
        else if (args.length == 3) {
        	
        	
            if (args[0].equals("arena")) {
            	
            	
		            if (args[1].equals("setspawn1")) {
		                	
		                    commands.addAll(Arenas.getArenaList());
		                    
		            }
		            
		            if (args[1].equals("setspawn2")) {
		            	
		                commands.addAll(Arenas.getArenaList());
		                
		            }
		            
		            if (args[1].equals("delete")) {
		            	
		                commands.addAll(Arenas.getArenaList());
		                
		            }           
		            if (args[1].equals("rename")) {
		            	
		                commands.addAll(Arenas.getArenaList());
		                
		            }
		            
		            if (args[1].equals("tp")) {
		            	
		                commands.addAll(Arenas.getArenaList());
		                
		            }
		            if (args[1].equals("info")) {
		            	
		                commands.addAll(Arenas.getArenaList());
		                
		            }
            	
            }
        	
            

            

            
            StringUtil.copyPartialMatches(args[2], commands, completions);
        }
        
        
        else if (args.length == 4) {
        	
            if (args[0].equals("gui")) {
                
                if (args[1].equals("setslot")) {
                	
                    commands.addAll(Util.getMaterialList());
                    
                }
        	
        }
        
            StringUtil.copyPartialMatches(args[3], commands, completions);
        }
        
        Collections.sort(completions);
        return completions;
    }


}
