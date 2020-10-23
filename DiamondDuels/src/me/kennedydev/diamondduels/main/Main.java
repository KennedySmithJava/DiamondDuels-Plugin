package me.kennedydev.diamondduels.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.files.GUI;
import me.kennedydev.diamondduels.files.Inventories;
import me.kennedydev.diamondduels.admincmds.AdminCommands;
import me.kennedydev.diamondduels.cmds.cmdKit;
import me.kennedydev.diamondduels.cmds.cmdLoad;
import me.kennedydev.diamondduels.inventory.Kit;
import me.kennedydev.diamondduels.listeners.guiListeners;

public class Main extends JavaPlugin {
	
	
	public static Main main;
	
	
	
	@Override
	public void onEnable(){
		
		main = this;
		
		
		new AdminCommands(this);
		
        new guiListeners(this);
		
		new cmdKit(this);
		new cmdLoad(this);
		//Kit.initialize();
		
		Inventories.createFile();
		Arenas.createFile();
		GUI.createFile();
		//Inventories.load();
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public static Main getMain(){
		return main;
	}
	
	
}
