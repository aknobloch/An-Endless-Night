package main.MenuSystem;

import java.io.IOException;
import java.util.NoSuchElementException;

import main.Game;
import main.GameInput;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.EscapeController;
import main.CombatSystem.Monster;
import main.CombatSystem.StatusCondition;

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
		System.out.println("\tA " + currentMonster.getName() + " stares you down.");
		System.out.println();
		battleContinuing = true;


		while(battleContinuing) 
		{

			int userChoice = -1;
			
			try 
			{

				System.out.println("What is your next move?");
				System.out.println();
				System.out.println("1. Attack Monster");
				System.out.println("2. Brace Yourself");
				System.out.println("3. Attempt to Flee");
				System.out.println("4. Use Item");
				System.out.println();

				userChoice = GameInput.getInt();

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
					throw new IOException();
				}
			}

			catch (IOException e) 
			{

				System.out.println("\tYou mumble incoherently. You should be wary of nonsensical babbling, ");
				System.out.println("\telse you be labeled insane.");
				System.out.println();

			}
		}
	}
		

	private void attack(Monster currentMonster) 
	{
		
		DamageHandler combatManager = new DamageHandler();
		System.out.println("\tYou raise your " + Game.getHero().getEquippedWeapon().getName().toLowerCase() + 
						   " and bring it down on the " + currentMonster.getName());
		
		int monsterAttackResult = combatManager.attackMonster();
		
		if(monsterAttackResult == 0) 
		{
			System.out.println("\tYour attack barely grazes the creature, leaving it undamaged.");
			System.out.println();
			monsterAttack();
		}
		else if(monsterAttackResult == -1) 
		{
			System.out.println("\tYour attack sinks deep into the " + currentMonster.getName() + 
							   ", mortally wounding it.");
			System.out.println("\tIts body slumps over as the last breath escapes its body.");
			System.out.println();
			
			
			
			battleContinuing = false;
			MenuLoader.loadGameMenu(this);
		}
		else 
		{
			System.out.println("\tYour weapon vibrates as it strikes the creature, wounding it.");
			System.out.println("\tThe creature has " + monsterAttackResult + " health remaining.");
			System.out.println();
			monsterAttack();
		}
		
	}

	private void defend(Monster currentMonster) 
	{
		
		Game.getHero().addStatusCondition(StatusCondition.DEFENSE_BUFF);
		
		System.out.println("\tYou brace yourself for an attack.");
		
		monsterAttack();
		
		Game.getHero().removeStatusCondition(StatusCondition.DEFENSE_BUFF);
		
	}

	private void flee(Monster battleMonster) {
		
		EscapeController escape = new EscapeController();
		
		// 
		if(escape.attemptEscape()) 
		{
		
			System.out.println("\tYou feign an attack, and dart off while the " + battleMonster.getName() + " attempts to brace itself.");
			System.out.println();
			battleContinuing = false;
			// move hero back to last room.
			Game.getHero().bounceBack();
			MenuLoader.loadGameMenu(this);
			
		}
		else 
		{
			
			System.out.println("\tYou try to escape, but the " + battleMonster.getName() + " is too fast.");
			
			monsterAttack();
			
		}
	}

	private void monsterAttack() 
	{
		
		System.out.println("\tThe creature attacks!");
		System.out.println();
		
		DamageHandler combat = new DamageHandler();
		int combatResult = combat.attackHero();
		
		if(combatResult == -1) 
		{
			
			battleContinuing = false;
			heroDeath();
			
		}
		else if(combatResult == 0) 
		{
			
			System.out.println("\tThe creature lunges, but you swiftly dodge.");
			System.out.println();
			
		}
		else 
		{
			
			System.out.println("\tIt attacks you, leaving you with " + combatResult + " health left.");
			System.out.println();
			
		}
		
	}

	private void heroDeath() 
	{
		
		System.out.println("\tYour knees crumple and your vision fades as your wounds become too much to bear.");
		System.out.println();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		// TOUCH THIS SHIT I FUCKING DARE YOU :)
		System.out.println("      #############               \n" +
						   "    ##            *##             \n" +
						   "   #               **#            \n" +
						   "  #                ***#            @@@@@@@@   @@@@@@   @@@@@@@@@@   @@@@@@@@      @@@@@@   @@@  @@@  @@@@@@@@  @@@@@@@   \n" +
						   " #                 ****#          @@@@@@@@@  @@@@@@@@  @@@@@@@@@@@  @@@@@@@@     @@@@@@@@  @@@  @@@  @@@@@@@@  @@@@@@@@  \n" +
						   "#                  *****#         !@@        @@!  @@@  @@! @@! @@!  @@!          @@!  @@@  @@!  @@@  @@!       @@!  @@@  \n" +
						   "#   ###           ###***#         !@!        !@!  @!@  !@! !@! !@!  !@!          !@!  @!@  !@!  @!@  !@!       !@!  @!@  \n" +
						   "#  # ####       #### #**#         !@! @!@!@  @!@!@!@!  @!! !!@ @!@  @!!!:!       @!@  !@!  @!@  !@!  @!!!:!    @!@!!@!  \n" +
						   "#  #     #     #     #**#         !!! !!@!!  !!!@!!!!  !@!  !  !@!  !!!!!:       !@!  !!!  !@!  !!!  !!!!!:    !!@!@!    \n" +
						   "#   #####  # #  #####***#         :!!   !!:  !!:  !!!  !!:     !!:  !!:          !!:  !!!  :!:  !!:  !!:       !!: :!!   \n" +
						   "#         #   #  *******#         :!:   !::  :!:  !:!  :!:     :!:  :!:          :!:  !:!   ::!!:!   :!:       :!:  !:!  \n" +
						   " ### #           **# ###           ::: ::::  ::   :::  :::     ::    :: ::::     ::::: ::    ::::     :: ::::  ::   :::  \n" +
						   "     #             #               :: :: :    :   : :   :      :    : :: ::       : :  :      :      : :: ::    :   : :  \n" +
						   "     # - - - - - - #              \n" +
						   "      | | | | | | |               ");
		
		
		battleContinuing = false;
		MenuLoader.loadStartMenu(this);
		
	}

	@Override
	void onDestroy() 
	{
		// TODO Auto-generated method stub
		
	}

}
