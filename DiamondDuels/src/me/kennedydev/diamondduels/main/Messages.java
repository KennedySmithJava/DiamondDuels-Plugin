package me.kennedydev.diamondduels.main;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {

	static Character colorCodeChar = '&';
	static String prefix = "&7(&bD&3Duels&7) » &r ";

	public static String worldLocation = "&7World: &b%world% &7X: &b%x% &7Y: &b%y% &7Z: &b%z%";

	// Arenas
	public static String arenaSuccessCreate = "&aArena &b%arena_name% &asuccessfully created with the displayname %arena_displayname%&b.";
	public static String arenaSuccessDelete = "&aArena &b%arena_name% &asuccessfully removed.";
	public static String arenaSuccessRename = "&aChanged the displayname of &b%arena_name% &ato &b%arena_displayname%&b.";

	public static String arenaSuccessSetSpawn1 = "&aSpawn Location &b1 &aset for arena: &b%arena_name% ";
	public static String arenaSuccessSetSpawn2 = "&aSpawn Location &b2 &aset for arena: &b%arena_name% ";
	public static String arenaSuccessReplaceSpawn1 = "&aSpawn Location &b1 &areplaced for &b%arena_name% ";
	public static String arenaSuccessReplaceSpawn2 = "&aSpawn Location &b2 &areplaced for &b%arena_name% ";

	public static String arenaErrorSetName = "&cPlease specify the arena's &6name&7. &7&oCorrect command format: /dd arena create [name] [displayname]";
	public static String arenaErrorSetDisplayname = "&cPlease specify the arena's &6displayname&7. &7&oCorrect command format: /dd create [name] [displayname]";
	public static String arenaErrorInvalidArguments = "&cInvalid Command Arguements. &7&oCorrect command format: /dd arena create [name] [displayname]";
	public static String arenaErrorAlreadyCreated = "&cArena &b%arena_name% &chas already been created with the displayname &b%arena_displayname%.";
	public static String arenaErrorDoesNotExist = "&cArena &b%arena_name%&c does not exist.";

	public static String arenaErrorSpawnNotSet = "&cThe arena &b%arena_name% &cdoes have a spawn set.";
	public static String arenaErrorSpawnNotSetCommand = "&7Use &7&o/dd arena setspawn1 %arena_name%";
	public static String arenaErrorSpawn1NotSet = "&cSpawn 1 has not been set. &7&o/dd arena setspawn1 [arena]";
	public static String arenaErrorSpawn2NotSet = "&cSpawn 2 has not been set. &7&o/dd arena setspawn2 [arena]";
	public static String arenaErrorRenameSetDisplayname = "&cPlease specify the arena's new &6displayname&7. &7&oCorrect command format: /dd rename [arena] [newDisplayname]";

	public static String arenaErrorDeleteSpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena delete [name]";
	public static String arenaErrorRenameSpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena rename [name]";
	public static String arenaErrorInfoSpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena info [name]";
	public static String arenaErrorSetspawn1SpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena setspawn1 [name]";
	public static String arenaErrorSetspawn2SpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena setspawn2 [name]";
	public static String arenaErrorTpSpecifyArena = "&cPlease specify an arena name. &7&oCorrect command format: /dd arena tp [name]";

	public static String arenaListTitle = "&7&m── &r &b&lArena List &7&m ──────────────────";
	public static String arenaListTotalEntries = "&7Total Arenas: &b%value%";
	public static String arenaListEntry = "&e%entry_number%. &7Arena: &b%arena_name% &7Displayname: &b%arena_displayname%&b";

	public static String arenaInfoTitle = "&7&m── &r &b&lArena Info &7&m ─────────────────";
	public static String arenaInfoName = "&7Arena: &b%arena_name%&b";
	public static String arenaInfoDisplayname = "&7Display Name: &b%arena_displayname%&b";
	public static String arenaInfoSpawn1 = "&bSpawn 1&7: World: &b%world% &7X: &b%x% &7Y: &b%y% &7Z: &b%z%";
	public static String arenaInfoSpawn2 = "&bSpawn 2&7: World: &b%world% &7X: &b%x% &7Y: &b%y% &7Z: &b%z%";

	public static String guiAdditionalEditInfo = "&7You can add lore, enchantments, and more to this slot with &7&o/dd gui edit [slot]";

	public static String guiErrorSlotDoesNotExist = "No item exists at slot %slot%";

	public static String guiSuccessSetSlot = "&aSuccessfully set slot &b%slot% &ato &b%material% &aunder the name &b%display_name% &awith the type &b%type%&7";
	public static String guiSuccessDelete = "Successfully deleted items stored in %slot%";

	public static void send(String message, Player messageReciever, String... arguements) {

		if (arguements.length > 0) {
			messageReciever.sendMessage(ChatColor.translateAlternateColorCodes(colorCodeChar,
					prefix + placeholderHandle(message, arguements)));
			return;
		}

		messageReciever.sendMessage(ChatColor.translateAlternateColorCodes(colorCodeChar, prefix + message));

	}

	public static void sendNoPrefix(String message, Player messageReciever, String... arguements) {
		if (arguements.length > 0) {
			messageReciever
					.sendMessage(ChatColor.translateAlternateColorCodes(colorCodeChar, placeholderHandle(message, arguements)));
			return;
		}
		messageReciever.sendMessage(ChatColor.translateAlternateColorCodes(colorCodeChar, message));
	}

	public void broadcast(String message) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(colorCodeChar, message));
	}

	public static String clr_plc(String message, String[] args) {

		// TODO: Handle message placeholder arguements:
		// "placeholder:value"

		// IF ARGUEMENT TYPE = ARENA

		if (args[0] == "arena") {

			if (args.length < 3) {
				String arenaName = args[1];

				String output = StringUtils.replaceEach(message, new String[] { "%arena_name%" },
						new String[] { arenaName, });
				return output;
			}

			if (args.length < 4) {
				String arenaName = args[1];
				String arenaDisplayName = args[2];
				String output = StringUtils.replaceEach(message, new String[] { "%arena_name%", "%arena_displayname%" },
						new String[] { arenaName, arenaDisplayName });
				return output;
			}

		}

		if (args[0] == "location") {

			String world = args[1];
			String x = args[2];
			String y = args[3];
			String z = args[4];

			String output = StringUtils.replaceEach(message, new String[] { "%world%", "%x%", "%y%", "%z%" },
					new String[] { world, x, y, z });

			return output;
		}

		if (args[0] == "locationWithRotation") {

			String world = args[1];
			String x = args[2];
			String y = args[3];
			String z = args[4];
			String pitch = args[5];
			String yaw = args[6];

			String output = StringUtils.replaceEach(message,
					new String[] { "%world%", "%x%", "%y%", "%z%", "%pitch%", "%yaw%" },
					new String[] { world, x, y, z, pitch, yaw });

			return output;
		}

		if (args[0] == "list") {

			String arenaName = args[1];
			String arenaDisplayName = args[2];
			String listEntry = args[3];

			String output = StringUtils.replaceEach(message,
					new String[] { "%arena_name%", "%arena_displayname%", "%entry_number%" },
					new String[] { arenaName, arenaDisplayName, listEntry });

			return output;

		}

		if (args[0] == "value") {

			String value = args[1];

			String output = StringUtils.replaceEach(message, new String[] { "%value%" }, new String[] { value, });

			return output;

		}

		if (args[0] == "slot") {

			String slot = args[1];
			String material = args[2];
			String displayname = args[3];

			String output = StringUtils.replaceEach(message, new String[] { "%slot%", "%material%", "%display_name%" },
					new String[] { slot, material, displayname });

			return output;

		}

		String output = "Invalid placeholder replacement arguments";
		return output;

	}

	public static String placeholderHandle(String message, String... args) {
    	
    	String output = message;
    	
    	for(String placeholder : args) {
    		String[] e = placeholder.split(":");
    		
        	output = StringUtils.replaceEach(output, new String[]{e[0].toLowerCase()}, new String[]{e[1]});
    	}
		return output;
    }

	public static String ph(String pt1, String pt2) {
		return "%" + pt1 + "%" + ":" + pt2;
	}
}
