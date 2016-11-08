package main.MenuSystem;

import java.io.IOException;
import java.util.ArrayList;

import main.Game;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.EscapeController;
import main.CombatSystem.Monster;
import main.CombatSystem.StatusCondition;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;

/**
 * 
 * @author Aaron
 *
 */
public class CombatMenu extends AbstractMenu 
{

	static boolean battleContinuing;

	public CombatMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	@Override
	void mainPrompt() 
	{
		
		Monster currentMonster = Game.getHero().getRoom().getMonster();
		System.out.println("A " + currentMonster.getName() + " stares you down.");
		battleContinuing = true;
		
		
		while(battleContinuing) 
		{
			
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
				try 
				{

					userChoice = GameInput.getInt();
					validInput = true;

				} 
				catch (IOException e) 
				{

					System.out.println("You mumble incoherently. You should be wary of nonsensical babbling, ");
					System.out.println("else you be labeled insane.");
					System.out.println();
					validInput = false;

				}

			} while( ! validInput);

			if(userChoice == 1) 
			{

				attack(currentMonster);

			}
			else if(userChoice == 2) 
			{

				defend(currentMonster);

			}
			else if(userChoice == 3) 
			{

				flee(currentMonster);

			}
			else if(userChoice == 4) 
			{
				
				CombatInventoryMenu.openMenu();
				
			}
			else 
			{
				// something went wrong
				this.mainPrompt();
			}
		}
		
	}

	private void attack(Monster currentMonster) 
	{
		
		DamageHandler combatManager = new DamageHandler();
		System.out.println("You raise your " + Game.getHero().getEquippedWeapon().getName() + 
						   " and bring it down on the " + currentMonster.getName());
		
		int monsterAttackResult = combatManager.attackMonster();
		
		if(monsterAttackResult == 0) 
		{
			System.out.println("Your attack barely grazes the creature, leaving it undamaged.");
			System.out.println();
			monsterAttack();
		}
		else if(monsterAttackResult == -1) 
		{
			System.out.println("Your attack sinks deep into the " + currentMonster.getName() + 
							   ", mortally wounding it.");
			System.out.println("Its body slumps over as the last breath escapes its body.");
			System.out.println();
			
			battleContinuing = false;
			MenuLoader.loadGameMenu(this);
		}
		else 
		{
			System.out.println("Your weapon vibrates as it strikes the creature, wounding it.");
			System.out.println("The creature has " + monsterAttackResult + " health remaining.");
			System.out.println();
			monsterAttack();
		}
		
	}

	private void defend(Monster currentMonster) 
	{
		
		Game.getHero().addStatusCondition(StatusCondition.DEFENSE_BUFF);
		
		System.out.println("You brace yourself for an attack.");
		
		monsterAttack();
		
		Game.getHero().removeStatusCondition(StatusCondition.DEFENSE_BUFF);
		
	}

	private void flee(Monster battleMonster) {
		
		EscapeController escape = new EscapeController();
		
		// 
		if(escape.attemptEscape()) 
		{
		
			System.out.println("You feign an attack, and dart off while the " + battleMonster.getName() + " attempts to brace itself.");
			System.out.println();
			battleContinuing = false;
			MenuLoader.loadGameMenu(this);
			
		}
		else 
		{
			
			System.out.println("You try to escape, but the " + battleMonster.getName() + " is too fast.");
			
			monsterAttack();
			
		}
	}

	private void monsterAttack() 
	{
		
		System.out.println("The creature attacks!");
		
		DamageHandler combat = new DamageHandler();
		int combatResult = combat.attackHero();
		
		if(combatResult == -1) 
		{
			
			battleContinuing = false;
			heroDeath();
			
		}
		else if(combatResult == 0) 
		{
			
			System.out.println("The creature lunges, but you swiftly dodge.");
			System.out.println();
			
		}
		else 
		{
			
			System.out.println("It attacks you, leaving you with " + combatResult + " health left.");
			System.out.println();
			
		}
		
	}

	private void heroDeath() 
	{
		
		System.out.println("Your knees crumple and your vision fades as your wounds become too much to bear.");
		System.out.println();
		battleContinuing = false;
		MenuLoader.loadStartMenu(this);
		
	}

	@Override
	void onDestroy() 
	{
		// TODO Auto-generated method stub
		
	}

}
