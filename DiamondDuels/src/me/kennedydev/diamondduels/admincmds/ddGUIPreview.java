package me.kennedydev.diamondduels.admincmds;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.kennedydev.diamondduels.files.GUI;
import me.kennedydev.diamondduels.main.Messages;

public class ddGUIPreview {

	public ddGUIPreview(Player sender) {

		GUI.openGUI(sender);
		
		Bukkit.broadcastMessage(Messages.placeholderHandle("Test value one: %test1% Test value two %test2% Test value three %t%", Messages.ph("test", "test"), Messages.ph("test", "test"), "%t%:pow"));
		
	}
	
}
