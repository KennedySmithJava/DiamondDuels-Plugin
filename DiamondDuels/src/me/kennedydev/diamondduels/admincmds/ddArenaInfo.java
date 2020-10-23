package me.kennedydev.diamondduels.admincmds;

import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaInfo {

	public ddArenaInfo(String arenaName, Player sender) {
		
		if(!Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorDoesNotExist, sender, "arena", arenaName);
			return;
		}
		
		Messages.sendNoPrefix(Messages.arenaInfoTitle, sender);
		Messages.sendNoPrefix(Messages.arenaInfoName, sender, "arena", arenaName);
		Messages.sendNoPrefix(Messages.arenaInfoDisplayname, sender, "arena", arenaName, Arenas.getArenaDisplayname(arenaName));
		
		if(Arenas.locationsSet(arenaName, "spawnpoint1")) {
			String xSpawn1 = String.valueOf(Arenas.getSpawnpointX(arenaName, "spawnpoint1"));
			String ySpawn1 = String.valueOf(Arenas.getSpawnpointY(arenaName, "spawnpoint1"));
			String zSpawn1 = String.valueOf(Arenas.getSpawnpointZ(arenaName, "spawnpoint1"));
			String worldSpawn1 = String.valueOf(Arenas.getSpawnpointWorldName(arenaName, "spawnpoint1"));
			String pitchSpawn1;
			String yawSpawn1;
			
			Messages.sendNoPrefix(Messages.arenaInfoSpawn1, sender, 
					Messages.ph("world", worldSpawn1), 
					Messages.ph("x", xSpawn1), 
					Messages.ph("y", ySpawn1),
					Messages.ph("z", zSpawn1),
					Messages.ph("pitch", "0"),
					Messages.ph("yaw", "0")
					);
		}
		if(!Arenas.locationsSet(arenaName, "spawnpoint1")) {
			Messages.sendNoPrefix(Messages.arenaErrorSpawn1NotSet, sender);
		}
		
		if(Arenas.locationsSet(arenaName, "spawnpoint2")) {
			String xSpawn2 = String.valueOf(Arenas.getSpawnpointX(arenaName, "spawnpoint2"));
			String ySpawn2 = String.valueOf(Arenas.getSpawnpointY(arenaName, "spawnpoint2"));
			String zSpawn2 = String.valueOf(Arenas.getSpawnpointZ(arenaName, "spawnpoint2"));
			String worldSpawn2 = String.valueOf(Arenas.getSpawnpointWorldName(arenaName, "spawnpoint2"));
			String pitchSpawn2;
			String yawSpawn2;
			Messages.sendNoPrefix(Messages.arenaInfoSpawn2, sender, 
					Messages.ph("world", worldSpawn2), 
					Messages.ph("x", xSpawn2), 
					Messages.ph("y", ySpawn2),
					Messages.ph("z", zSpawn2),
					Messages.ph("pitch", "0"),
					Messages.ph("yaw", "0")
					);
		}
		if(!Arenas.locationsSet(arenaName, "spawnpoint2")) {
			Messages.sendNoPrefix(Messages.arenaErrorSpawn2NotSet, sender);
		}

		
	}

	
	
	
}
