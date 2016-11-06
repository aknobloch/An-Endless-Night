package main.MenuSystem;

import java.io.IOException;

import main.Game;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.EscapeController;
import main.CombatSystem.Monster;

public class CombatMenu extends AbstractMenu {


	public CombatMenu(MenuLoader menuLoader) {
		super(menuLoader);
	}

	@Override
	void mainPrompt() {
		
		Monster currentMonster = Game.getHero().getRoom().getMonster();
		System.out.println("A " + currentMonster.getName() + " stares you down.");
		System.out.println("What is your next move?");
		System.out.println();
		System.out.println("1. Attack Monster");
		System.out.println("2. Brace Yourself");
		System.out.println("3. Attempt to Flee");
		System.out.println("4. Use Item");
		System.out.println();
		
		
		int userChoice = -1;
		boolean validInput = false;
		
		do {
			try {
				
				userChoice = GameInput.getInt();
				validInput = true;
				
			} catch (IOException e) {
				
				System.out.println("You mumble incoherently. You should be wary of nonsensical babbling, ");
				System.out.println("else you be labeled insane.");
				System.out.println();
				validInput = false;
				
			}
			
		} while( ! validInput);
		
		if(userChoice == 1) {
			
			attack(currentMonster);
			
		}
		else if(userChoice == 2) {
			
			defend(currentMonster);
			
		}
		else if(userChoice == 3) {
			
			flee(currentMonster);
			
		}
		else if(userChoice == 4) {
			// TODO: handle item use
		}
		else {
			// something went wrong
			this.mainPrompt();
		}
		
	}

	private void defend(Monster currentMonster) {
		
		
		
	}

	private void flee(Monster battleMonster) {
		
		EscapeController escape = new EscapeController();
		
		// 
		if(escape.attemptEscape()) {
		
			System.out.println("You feign an attack, and dart off while the " + battleMonster.getName() + " attempts to brace itself.");
			System.out.println();
			MenuLoader.loadGameMenu(this);
			
		}
		else {
			
			System.out.println("You try to escape, but the " + battleMonster.getName() + " is too fast.");
			
			DamageHandler combat = new DamageHandler();
			int heroHealth = combat.attackHero();
			
			if(heroHealth <= 0) {
				
				heroDeath();
				
			}
			else {
				
				System.out.println("It attacks you, leaving you with " + heroHealth + " left.");
				System.out.println();
				
			}
			
		}
	}

	private void heroDeath() {
		
		System.out.println("Your knees crumple and your vision fades as your wounds become too much to bear.");
		System.out.println();
		MenuLoader.loadStartMenu(this);
		
	}

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		
	}

}
