package me.kennedydev.duels;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Duel {

	
	Duel duel;
	
	public Duel(String id, Player player1, Player player2) {
		
		if(!player1.isOnline()) {
			Bukkit.broadcastMessage(player1.getDisplayName() + " has left before the match start.");
			return;
		}
		
		if(!player2.isOnline()) {
			Bukkit.broadcastMessage(player2.getDisplayName() + " has left before the match start.");
			return;
		}
		
		
		
		
		
		//Check if players are already in a duel somehow
		
		//add duel file to config 
		//save duel config
		
		//Identify bets -> Opens GUI to select item or money bet 
		
		
		
		this.duel = this;
		
		
		
		/*
		  	on-start:				%player1% || %player2% || 
			on-next-round:			%player1% || %player2% || %previous_killed%	|| %previous_killer%	
			on-kill:				%player1% || %player2% || %killed%			|| %killer%	 
			on-win:					%player1% || %player2% || %winner%			|| %loser% 
			on-loss:				%player1% || %player2% || %winner%			|| %loser%  
			on-draw:				%player1% || %player2% || 
			on-disconnect:			%player1% || %player2% || %online%			|| %offline% 
			on-both-disconnect:		%player1% || %player2% ||
			on-end:					%player1% || %player2% || %winner%			|| %loser% 
				  
				  
			on-start:	  
			    - event: lock_players  
			     
			    - event: inventory_kit_player1 
				- event: inventory_kit_player2 
				- event: inventory_userkit_player1 
				- event: inventory_userkit_player2 
				
				
			    - command: /title %player2% Starting in 3....
			    - command: /title %player1% Starting in 3....
			    - wait: 1s
			    - command: /title %player2% Starting in 2....
			    - command: /title %player1% Starting in 2....
			    - wait: 1s
			    - command: /title %player2% Starting in 1....
			    - command: /title %player1% Starting in 1....
			    - wait: 1s
			    - command: /title %player2% FIGHT!
			    - command: /title %player1% FIGHT!
			    
			    - event: unlock_players  
			    
			on-next-round:
			  
			    - event: lock_players  
			    
				- event: give_kit_player1 
				- event: give_kit_player2  
				
			    - command: /title %player2% Starting in 3....
			    - command: /title %player1% Starting in 3....
			    - wait: 1s
			    - command: /title %player2% Starting in 2....
			    - command: /title %player1% Starting in 2....
			    - wait: 1s
			    - command: /title %player2% Starting in 1....
			    - command: /title %player1% Starting in 1....
			    - wait: 1s
			    - command: /title %player2% FIGHT!
			    - command: /title %player1% FIGHT!
			    
			    - event: unlock_players  
			    
			on-kill:
			  
			    - command: /tellraw %killer% "You killed %killed%!"
				- command: /tellraw %killed% "You were killed by %killer%!"
			    
			    - event: add_stat_kill_killer
				- event: add_stat_death_killed
				- event: next_round
			    
	 		on-win:
			  
			    - command: /title %winner% You won!
			    - command: /summon %winner% fireworks
			    - wait: 12s
			    - event: tp_return_winner
				- event: inventory_return_winner
			    - bet_give_money_winner
			    - bet_give_items_winner		   
			      			
			on-loss:
			  
			    - command: /effect %loser% blindness 2 1
			    - command: /title %loser% You lost!  	
			    - event: spectator_loser
				- event: fly_toggle_loser	
			    - wait: 12s
			    - event: tp_return_loser
				- event: inventory_return_loser 	
	    		- event: fly_toggle_loser	
			    
			on-draw:
			  
			    - command: /title %player1% Draw! 	 
				- command: /title %player1% Draw! 	
				- event: bet_return_money    
				- event: bet_return_items      
				
			on-disconnect:
			  
			    - event: ending_win_online 	
			    
			on-both-disconnect:
			
			    - event: ending_draw     
			    
			on-end: //Not exclusive to any duel ending event
			  
			    - command: /dd deul lockPlayers  	
			      
			    
			  //// Methods:
			  //// command: [command] //Runs command from console
			  //// sudo-command-[playerType]: [command] //Runs command from playerType
			  //// wait: [seconds] // Adds delay between methods
			  //// event: [eventName] 
			 
			 
			  //// Player Types:
			  //// player1
			  //// player2
			  //// online //Can only be used on disconnect event
			  //// offline //Can only be used on disconnect event
			  //// winner //Can only be used on win/loose event
			  //// winner //Can only be used on win/loose event	    
			    
			  //// Ending events:
			  //// ending_win_[playerType] //Creates new one-win event Sets winner to [player]
			  //// ending_loose_[playerType] //Creates new on-loose event. Sets loser to [player]
			  //// spectator_[playerType] // 
			   
			  //// Teleport events: 
			  //// tp_return_[playerType]
		 	  //// tp_spawn_[playerType]		 
			  //// tp_spawnpoint1_[playerType]  
			  //// tp_spawnpoint2_[playerType]			    
			  
			  //// Inventory events:
			  //// inventory_return_[playerType] //Returns player's saved inventory
			  //// inventory_kit_[playerType] //If enabled, gives kit to user
			  //// inventory_userkit_[playerType] //If enabled, gives custom user kit to user
			  //// inventory_clear_[playerType]
			
		      ////Betting events:
			  ////bet_return_money //Returns money bets to owners
			  ////bet_return_items //Returns item bets to owners
			  ////bet_give_money_[playerType] //Gives money pool to [playerType]
			  ////bet_give_items_[playerType] //Gives item pool to [playerType]

			  //// Misc events:
			  //// spectator_[playerType] //Makes player invisible
			  //// fly_toggle_[playerType] //Toggles flight for player
			  //// switch_players //Switches player1 to player2 and vice versa

			    
			    
		*/
	}
	
}
