package me.kennedydev.diamondduels.admincmds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.Arenas;
import me.kennedydev.diamondduels.main.Messages;

public class ddArenaSetSpawn1 {

	public ddArenaSetSpawn1(String arenaName, Player sender) {
		
		
		if(!Arenas.arenaExists(arenaName)) {
			Messages.send(Messages.arenaErrorDoesNotExist, sender, Messages.ph("arena_name", arenaName));
			return;
		}
		
		Location location = sender.getLocation();
		
		World world = location.getWorld();
		String worldName = world.getName();
		double posX = location.getBlockX();
		double posY = location.getBlockY();
		double posZ = location.getBlockZ();
		
		float pitch = location.getPitch();
		float yaw = location.getYaw();
		
		Arenas.setSpawn1(arenaName, worldName, posX, posY, posZ);
		
		Messages.send(Messages.arenaSuccessSetSpawn1, sender, Messages.ph("arena_name", arenaName));
		
		Messages.sendNoPrefix(Messages.worldLocation, sender, 
				Messages.ph("world", worldName), 
				Messages.ph("x", String.valueOf(posX)), 
				Messages.ph("y", String.valueOf(posY)), 
				Messages.ph("z", String.valueOf(posZ))
				);
		
	}

	
	
	
	//Check if spawn 2 is set, if not, send message
	
	
}
