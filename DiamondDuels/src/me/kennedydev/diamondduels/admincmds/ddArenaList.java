package me.kennedydev.diamondduels.admincmds;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaList {

	public ddArenaList(Player sender) {

		Messages.sendNoPrefix(Messages.arenaListTitle, sender);
		
		int entryNum = 0;
		int totalArenas = 0;
		
		ArrayList<String> arenas = Arenas.getArenaList();
		
		for(@SuppressWarnings("unused") String arena : arenas) {
			
			totalArenas = totalArenas + 1;
		}
		
		Messages.sendNoPrefix(Messages.arenaListTotalEntries, sender, Messages.ph("value", String.valueOf(totalArenas)));
		
		
		for(String arena : arenas) {
			
			entryNum = entryNum + 1;
			Messages.sendNoPrefix(Messages.arenaListEntry, sender, 
					Messages.ph("arena_name", arena), 
					Messages.ph("arena_displayname", Arenas.getArenaDisplayname(arena)), 
					Messages.ph("entry_number", String.valueOf(entryNum)));
		}
		
		
	}

}
