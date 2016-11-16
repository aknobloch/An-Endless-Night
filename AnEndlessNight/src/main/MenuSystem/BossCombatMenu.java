package main.MenuSystem;

import java.io.IOException;
import java.util.Random;

import main.Game;
import main.GameInput;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.Hero;
import main.CombatSystem.Monster;
import main.CombatSystem.StatusCondition;

public class BossCombatMenu extends CombatMenu 
{
	
	// keeps track of ryu's rain storm
	public static int ryuRainStormTurns = 0;
	
	public BossCombatMenu(MenuLoader menuLoader) 
	{
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
			System.out.println("                     MAIN MENU - SECOND FLOOR                     ");
			System.out.println("==================================================================");
			System.out.println();

			// if it is Kitsune, go into dialogue
			// if kitsune tricks player, death and return.
			// otherwise this will complete and launch main prompt for combat.
			if( kitsuneTricksPlayer() ) 
			{
				heroDeath();
				return;
			}
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

	private void tenguAttack() 
	{
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

	private boolean kitsuneTricksPlayer() 
	{
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

		while(! Game.solvedKitsune) 
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

						return true;
					}
					else if(userChoice == 2)
					{
						System.out.println("\tKitsune giggles, blushing profusely.");
						System.out.println();
						System.out.println("\t\"Sorry, I usually am not so...forward.\"");
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
					System.out.println("\t\"There is a time and a place");
					System.out.println("\tfor everything. And there are more pressing");
					System.out.println("\tissues at hand. Feel free to rest here for");
					System.out.println("\tthe night if you would like.\"");
					System.out.println();

					System.out.println("Rest for the night? ( + 10 Max Health, -5 Defense )");
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.println();

					int userChoice = GameInput.getInt();

					if(userChoice == 1)
					{

						System.out.println("\tYou yawn and fall into the bed,");
						System.out.println("\tweary from hours of battle. As you");
						System.out.println("\tslip into sleep, you begin to have");
						System.out.println("\ta strange dream. A fox with many tails");
						System.out.println("\tis gnawing at your flesh, chewing your");
						System.out.println("\tinnards. It feels so real you can smell");
						System.out.println("\tthe blood, and feel the pain.");
						System.out.println();

						return true;

					}
					else if(userChoice == 2)
					{
						System.out.println("\tKitsune looks troubled, and slightly annoyed.");
						System.out.println("\tShe scrunches her eyebrows and frowns,");
						System.out.println("\tobviously not used to dealing with rejection.");
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
				 * KITSUNES FINAL ATTEMPT
				 */
				if(kitsuneAttempt == 3)
				{
					System.out.println("\t\"Well, then. Can I at the least offer you");
					System.out.println("\tsome more tea before you continue on?\"");
					System.out.println();

					System.out.println("Would you like some tea? ( +5 Health )");
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.println();

					int userChoice = GameInput.getInt();

					if(userChoice == 1)
					{

						System.out.println("\tYou take a cup of hot tea, enjoying it's");
						System.out.println("\tcontrast with the crisp, cool air. ");
						System.out.println();
						System.out.println("\tSuddenly, your throat tightens. Clutching at your");
						System.out.println("\tneck, you reach out for help, but find none.");
						System.out.println();
						System.out.println("\tThe last thing you see is a wicked grin cross Kitsune's face.");
						System.out.println();

						return true;

					}
					else if(userChoice == 2)
					{
						System.out.println("\tKitsune lets out a blood-curdling shriek, her mouth");
						System.out.println("\topening wider and wider still, stretching back behind");
						System.out.println("\ther head, engulfing her face. Her body begins to twist");
						System.out.println("\tand morph. Orange-red tails sprout out from behind her body.");
						System.out.println("\tShe collapses, fur emerging from all parts of her body.");
						System.out.println();
						System.out.println("\tStanding up, she grins manically, revealing a full set of sharp teeth.");
						System.out.println();

						Game.solvedKitsune = true;

						try 
						{
							Thread.sleep(1000);
						} catch (InterruptedException e) 
						{
							// do nothing
						}

						System.out.println();
						System.out.println("==================================================================");
						System.out.println("                           BOSS BATTLE                            ");
						System.out.println("==================================================================");
						System.out.println();

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
		}

		// if reached this point, kitsune did not trick player
		return false;
	}

	private void kitsuneAttack() 
	{
		// if kitsune's health is greater than 50, she has a 50% chance of howling
		if(Game.getHero().getRoom().getMonster().getHealth() > 50 && Math.random() <= .5)
		{
			System.out.println("\tKitsune crouches, bearing her sharp teeth.");
			System.out.println("\tTilting her head back, she lets loose a loud");
			System.out.println("\thowl. Despite yourself, you can't help but tremble");
			System.out.println("\tin fear at the monstrosity before you.");
			System.out.println();

			Game.getHero().addStatusCondition(StatusCondition.KITSUNE_DEBUFF);
		}
		// otherwise, gnaw attack
		else
		{
			System.out.println("\tKitsune lunges at you, her powerful jaw hungrily");
			System.out.println("\tsnapping at your neck.");
			System.out.println();

			attackHero(20);
		}
	}

	private void ryuAttack() 
	{
		
		Monster ryu = Game.getHero().getRoom().getMonster();
		Hero hero = Game.getHero();
		
		// increases storm count if currently debuffed
		if(hero.getStatusConditions().contains(StatusCondition.RYU_DEBUFF))
		{
			ryuRainStormTurns++;
		}
		
		// if storm has lasted 2 turns, roll to remove buff and reset counter
		if(ryuRainStormTurns >= 2)
		{
			// if has lasted 5 turns, remove. or if roll is successful.
			if(ryuRainStormTurns >= 5 || Math.random() > 0.5)
			{
				ryuRainStormTurns = 0;
				hero.removeStatusCondition(StatusCondition.RYU_DEBUFF);
			}
		}
		
		/*
		 * RAIN STORM
		 */
		// if not currently debuffed and ryu's health is above 50, has a 30 percent chance of making rain
		if( ! hero.getStatusConditions().contains(StatusCondition.RYU_DEBUFF) 
				&& ryu.getHealth() > 50 
				&& Math.random() < 0.3)
		{
			System.out.println("\tRyu growls and twists, the storm seeming to throb");
			System.out.println("\tin response. The rainfall increases, blocking your");
			System.out.println("\tvision and weighing you down. It will be harder to");
			System.out.println("\tconnect a solid hit on Ryu in this terrible storm.");
			System.out.println();
			
			hero.addStatusCondition(StatusCondition.RYU_DEBUFF);
		}
		/*
		 * LIGHTNING BOLT
		 */
		else 
		{
			
			DamageHandler combatHandler = new DamageHandler();
			
			System.out.println("\tRyu curls back and lets loose a roar, his voice");
			System.out.println("\tcracking the sky like thunder. The heavens open up");
			System.out.println("\tin response, lightning pouring forth from the clouds,");
			System.out.println("\tdescending upon you.");
			System.out.println();
			
			// first get number of lightning bolts
			Random randomGenerator = new Random();
			
			int numberOfBolts = randomGenerator.nextInt(4) + 2;
			int heroHealth = hero.getHealth();
			
			// for each bolt, 50% chance of hitting
			for(int i = 0; i < numberOfBolts; i++)
			{
				if(Math.random() < 0.5)
				{
					System.out.println("\tA lightning bolt strikes you!");
					System.out.println();
					
					heroHealth = combatHandler.guaranteedAttackHero(25);
					
				}
			}
			
			if(heroHealth <= 0)
			{
				System.out.println("\tThe strength of Ryu was too much to bear.");
				System.out.println("\tYou collapse to your knees as the Old One");
				System.out.println("\troars with the voice of thunder.");
				System.out.println();
				heroDeath();
			}
			else 
			{
				System.out.println("\tYou've managed to survive the onslaught,");
				System.out.println("\tbut how much of it was sheer luck?");
				System.out.println();
				System.out.println("\tYou have " + heroHealth + " health remaining.");
				System.out.println();
			}
			
		}
		
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
