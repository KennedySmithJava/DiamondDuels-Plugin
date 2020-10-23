package me.kennedydev.diamondduels.admincmds;

import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaDelete {

	public ddArenaDelete(String arenaName, Player sender) {
		
		if(!Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorDoesNotExist, sender, Messages.ph("arena_name", arenaName));
			return;
		}
		
		Arenas.deleteArena(arenaName);
		
		Messages.send(Messages.arenaSuccessDelete, sender, Messages.ph("arena_name", arenaName));
	}

	
	
	
}
