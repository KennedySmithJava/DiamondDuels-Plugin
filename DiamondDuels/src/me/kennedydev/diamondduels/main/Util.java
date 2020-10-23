package me.kennedydev.diamondduels.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public class Util {

	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
    public static ArrayList<String> getMaterialList(){
    	ArrayList<Material> materials = new ArrayList<Material>(Arrays.asList(
    			Material.values()
    			));
    	
    	ArrayList<String> materialStrings = new ArrayList<String>();
    	
    	
    	for(Material material : materials) {
    		
    		materialStrings.add(material.name());
    	}
    	
    	return materialStrings;
    }
	
}
