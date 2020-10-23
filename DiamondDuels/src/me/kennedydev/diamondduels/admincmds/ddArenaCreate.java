package me.kennedydev.diamondduels.admincmds;

import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaCreate {

	// /dd create [name] [displayname] - Creates a duel arena
	
	
	
	public ddArenaCreate(String arenaName, String displayName, Player sender) {
		
		
		if(Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorAlreadyCreated, sender, Messages.ph("arena_name", arenaName), Messages.ph("arena_displayname", displayName));
			return;
		}
		
		Arenas.addArena(arenaName, displayName, sender);
		
		Messages.send(Messages.arenaSuccessCreate, sender, Messages.ph("arena_name", arenaName), Messages.ph("arena_displayname", displayName));
		
	}

	

	
	//Check if already created
	

	
	
	
	
}
