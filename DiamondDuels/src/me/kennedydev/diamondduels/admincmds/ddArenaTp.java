package me.kennedydev.diamondduels.admincmds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaTp {

	public ddArenaTp(String arenaName, Player sender) {

		
		if(!Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorDoesNotExist, sender, Messages.ph("arena_name", arenaName));
			return;
		}
		
		
		try {

			World world = Bukkit.getWorld((String) Arenas.getSpawnpointWorldName(arenaName, "spawnpoint1"));
			double x = Arenas.getSpawnpointX(arenaName, "spawnpoint1");
			double y = Arenas.getSpawnpointY(arenaName, "spawnpoint1"); 
			double z = Arenas.getSpawnpointZ(arenaName, "spawnpoint1");
			float pitch;
			float yaw;
			
			Location teleportTo = new Location(world, x + 0.5, y + 0.5, z);
			sender.teleport(teleportTo);
			
		}catch(NullPointerException e) {
			Messages.send(Messages.arenaErrorSpawnNotSet, sender, Messages.ph("arena_name", arenaName));
			Messages.sendNoPrefix(Messages.arenaErrorSpawnNotSetCommand, sender, "arena", arenaName);
			return;
		}catch(IllegalArgumentException e) {
			Messages.send(Messages.arenaErrorSpawnNotSet, sender, Messages.ph("arena_name", arenaName));
			Messages.sendNoPrefix(Messages.arenaErrorSpawnNotSetCommand, sender, Messages.ph("arena_name", arenaName));
			return;
		}
		

		
		
		
	}
	

}
