package me.kennedydev.diamondduels.admincmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.GUI;
import me.kennedydev.diamondduels.main.Messages;

public class ddGUISetslot {

	public ddGUISetslot(Player sender, String slot, String material, String name) {
		// TODO Auto-generated constructor stub
		
		
		GUI.newItem(slot, material, name);
		
		Messages.send(Messages.guiSuccessSetSlot, sender, "slot", slot, material, name);
		Messages.send(Messages.guiAdditionalEditInfo, sender);
	}

	
	
	
	
	
}
