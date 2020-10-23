package me.kennedydev.diamondduels.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

import me.kennedydev.diamondduels.admincmds.ddArenaTp;
import me.kennedydev.diamondduels.files.GUI;
import me.kennedydev.diamondduels.main.Main;

public class guiListeners implements Listener {

    public guiListeners(Main plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }   
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != GUI.getGUI()) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        
        
        String slot = String.valueOf(e.getRawSlot() + 1); 
        
        if(GUI.isArena(slot)) {
        	
        	if(GUI.isArenaSet(slot)) {
        		
            	String arena = GUI.getArena(slot);
            	new ddArenaTp(arena, p);
        		
        	}

        	
        }
        
        if(!GUI.isArena(slot)) {
        }
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == GUI.getGUI()) {
          e.setCancelled(true);
        }
    }
	
}
