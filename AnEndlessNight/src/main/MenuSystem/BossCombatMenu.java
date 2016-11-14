package main.MenuSystem;

import java.io.IOException;

import main.Game;
import main.GameInput;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.Monster;
import main.CombatSystem.StatusCondition;

public class BossCombatMenu extends CombatMenu {
	
	public BossCombatMenu(MenuLoader menuLoader) {
		super(menuLoader);
	}

	@Override
	protected void mainPrompt() 
	{
		// if the current monster is not Kitsune, display the boss battle splash
		if(Game.getHero().getRoom().getMonster().getID() != 10)
		{
			System.out.println();
			System.out.println("==================================================================");
			System.out.println("                           BOSS BATTLE                            ");
			System.out.println("==================================================================");
			System.out.println();
		}
		// otherwise, Kitsune is in disguise...
		else 
		{
			System.out.println();
			System.out.println("==================================================================");
			System.out.println("                             MAIN MENU                            ");
			System.out.println("==================================================================");
			System.out.println();
			
			// if it is Kitsune, go into dialogue
			kitsuneDialogue();
		}
		
		// regular combat menu can take over now...
		super.mainPrompt();
	}

	/**
	 * Monster attacks for bosses are special.
	 */
	@Override
	protected void monsterAttack() 
	{
		
		Monster currentMonster = Game.getHero().getRoom().getMonster();
		
		// This is the Tengu boss
		if(currentMonster.getID() == 9)
		{
			tenguAttack();
		}
		// This is the Kitsune
		else if(currentMonster.getID() == 10)
		{
			kitsuneAttack();
		}
		// Otherwise, must be Ryu
		else 
		{
			ryuAttack();
		}
		
	}

	private void tenguAttack() {
		
		
		// get probability of either attack
		// 60 percent for gust of wind, 40 for fan swipe
		
		/*
		 * GUST OF WIND
		 */
		if(Math.random() <= .60)
		{
			// if wearing heavy boots
			if(Game.getHero().getStatusConditions().contains(StatusCondition.HEAVY_BOOTS))
			{
				System.out.println("\tThe Tengu spins around, generating a monumental gust of");
				System.out.println("\twind with it's large feathered fans. The powerful winds");
				System.out.println("\tblow massive amounts of sand and debris towards you.");
				System.out.println();
				
				attackHero(10);
				
			}
			// otherwise
			else
			{
				System.out.println("\tThe Tengu spins around, generating a monumental gust of");
				System.out.println("\twind with it's large feathered fans. The powerful winds");
				System.out.println("\tsweep you from your feet, blowing you off the balcony.");
				System.out.println("\tIf only you had some way to stabalize yourself against ");
				System.out.println("\tsuch strong winds...");
				System.out.println();
				
				// 50% chance of landing in either the NE or SE Garden
				if(Math.random() <= 0.5) 
				{
					battleContinuing = false;
					Game.getHero().teleport(104);
					MenuLoader.loadGameMenu(this);
				}
				else 
				{
					battleContinuing = false;
					Game.getHero().teleport(105);
					MenuLoader.loadGameMenu(this);
				}
			}
		}
		
		
		/*
		 * FAN SWIPE
		 */
		else 
		{
			System.out.println("\tThe Tengu lunges at you, swiping furiously with it's");
			System.out.println("\tfan. Blades slice at your exposed skin and armor.");
			System.out.println();
			
			attackHero(15);
			
		}
	}
	
	private void kitsuneDialogue() {
		
		boolean userTooSmart = false;
		int kitsuneAttempt = 1;
		
		System.out.println("\tBefore you stands Kitsune, the twinkle in her eye");
		System.out.println("\tabsolutely entrancing. Shuddering, she explains how she");
		System.out.println("\tnarrowly escaped the demon attack earlier,");
		System.out.println("\tfinding rare solace in this desolate room.");
		System.out.println();
		System.out.println("\tYou enjoy a cup of tea, glad to find a moment of quiet.");
		System.out.println("\tMentioning how exhausted you are from battle,");
		System.out.println("\tKitsune pouts and falls back onto");
		System.out.println("\ta plush bed, motioning for you to join her.");
		System.out.println();
		
		do
		{
			try
			{
				/*
				 * KITSUNES FIRST ATTEMPT
				 */
				if(kitsuneAttempt == 1)
				{
					System.out.println("\t\"Surely the stresses of your battle can be....relieved\"");
					System.out.println("\tshe says, smiling.");
					System.out.println();
					
					System.out.println("Enjoy a night with Kitsune? ( + 20 Max Health, -5 Defense )");
					System.out.println("1. Yes");
					System.out.println("2. No");
					
					int userChoice = GameInput.getInt();
					
					if(userChoice == 1)
					{
						System.out.println("\tYou begin to kiss Kitsune, wrapping your");
						System.out.println("\tarms around her waist. Her tongue creeps into");
						System.out.println("\tyour mouth. Deeper...and deeper still.");
						System.out.println();
						System.out.println("\tYou begin to choke, your lungs burning for air.");
						System.out.println();
						System.out.println("\tThe world begins to fade...");
						System.out.println();
						heroDeath();
					}
					else if(userChoice == 2)
					{
						System.out.println("\tKitsune giggles, blushing profusely.");
						System.out.println();
						System.out.println("\tSorry, I usually am not so...forward.");
						System.out.println();
						
						// next attempt is made after the loop
						kitsuneAttempt++;
					}
					else 
					{
						throw new IOException();
					}
					
				}
				/*
				 * KITSUNES SECOND ATTEMPT
				 */
				if(kitsuneAttempt == 2)
				{
					System.out.println("\tI understand. There is a time and a place");
					System.out.println("\tfor everything. And there are more pressing");
					System.out.println("\tissues at hand. Feel free to rest here for");
					System.out.println("\tthe night if you would like.");
					System.out.println();
					
					System.out.println("Rest for the night? ( + 10 Max Health, -5 Defense )");
					System.out.println("1. Yes");
					System.out.println("2. No");
					
					int userChoice = GameInput.getInt();
					
					if(userChoice == 1)
					{
						
					}
					else if(userChoice == 2)
					{
						
						
						// next attempt is made after the loop
						kitsuneAttempt++;
					}
					else 
					{
						throw new IOException();
					}
					
				}
				
			}
			catch(IOException ioe)
			{
				System.out.println("\tKitsune tilts her head, looking at your curiously.");
				System.out.println("\t\"I'm sorry, could you repeat that?\"");
				System.out.println();
			}
			
		} while ( ! userTooSmart);
		
	}

	private void kitsuneAttack() {
		// TODO Auto-generated method stub
		System.out.println("Need to implement kitsune fight.");
		super.monsterAttack();
	}

	private void ryuAttack() {
		// TODO Auto-generated method stub
		System.out.println("Need to implement ryu fight.");
		super.monsterAttack();
	}
	
	private void attackHero(int attackAmount)
	{
		DamageHandler combat = new DamageHandler();
		int combatResult = combat.specialAttackHero(attackAmount);
		
		if(combatResult == -1) 
		{
			
			battleContinuing = false;
			System.out.println("\tYour knees crumple and your vision fades as your wounds become too much to bear.");
			System.out.println("\n\n\n");
			heroDeath();
			
		}
		else if(combatResult == 0) 
		{
			
			System.out.println("\tYou barely manage to dodge the attack.");
			System.out.println();
			
		}
		else 
		{
			
			System.out.println("\tIt hits you, leaving you with " + combatResult + " health left.");
			System.out.println();
			
		}
	}
	
}
