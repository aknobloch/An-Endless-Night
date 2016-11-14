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
