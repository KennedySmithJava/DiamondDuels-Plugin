package me.kennedydev.diamondduels.admincmds;

import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaRename {

	public ddArenaRename(String arenaName, String displayName, Player sender) {
		
		if(!Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorDoesNotExist, sender, Messages.ph("arena_name", arenaName));
			return;
		}
		
		Arenas.renameArena(arenaName, displayName);
		
		Messages.send(Messages.arenaSuccessRename, sender, Messages.ph("arena_name", arenaName), Messages.ph("arena_displayname", displayName));
		
		
	}

	
	
	
}
