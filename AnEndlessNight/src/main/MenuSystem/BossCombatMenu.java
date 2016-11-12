package main.MenuSystem;

import main.Game;
import main.CombatSystem.DamageHandler;
import main.CombatSystem.Monster;
import main.CombatSystem.StatusCondition;

public class BossCombatMenu extends CombatMenu {
	
	public BossCombatMenu(MenuLoader menuLoader) {
		super(menuLoader);
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
		if(Math.random() <= 60)
		{
			// if wearing heavy boots
			if(Game.getHero().getStatusConditions().contains(StatusCondition.HEAVY_BOOTS))
			{
				System.out.println("\tThe Tengu spins around, generating a monumental gust of");
				System.out.println("\twind with it's large feathered fans. The powerful winds");
				System.out.println("\tblow massive amounts of sand, pegging you with shrapenel and debris. ");
				System.out.println();
				
				DamageHandler combatManager = new DamageHandler();
				
				int monsterAttackResult = combatManager.specialAttackHero(10);
				
				if(monsterAttackResult == 0) 
				{
					System.out.println("\tYour attack barely grazes the creature, leaving it undamaged.");
					System.out.println();
					monsterAttack();
				}
				else if(monsterAttackResult == -1) 
				{
					System.out.println("\tYour attack sinks deep into the Tengu, mortally wounding it.");
					System.out.println("\tIts body slumps over as the last breath escapes its body.");
					System.out.println();
					
					// TODO: Better score system
					Game.incrementScore(10);
					
					MenuLoader.loadGameMenu(this);
				}
				
				
			}
			// otherwise
			{
				System.out.println("\tThe Tengu spins around, generating a monumental gust of");
				System.out.println("\twind with it's large feathered fans. The powerful winds");
				System.out.println("\tsweep you from your feet, blowing you off the balcony.");
				System.out.println("\tIf only you had some way to stabalize yourself against ");
				System.out.println("\tsuch strong winds...");
				
				// 50% chance of landing in either the NE or SE Garden
				if(Math.random() <= 0.5) 
				{
					Game.getHero().teleport(104);
				}
				else 
				{
					Game.getHero().teleport(105);
				}
			}
		}
		
		
		/*
		 * FAN SWIPE
		 */
		else 
		{
			System.out.println("Fan swipe not yet coded.");
		}
		
		
		
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
	
}
