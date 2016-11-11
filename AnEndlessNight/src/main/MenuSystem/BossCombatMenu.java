package main.MenuSystem;

import main.Game;
import main.CombatSystem.Monster;

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
		// TODO Auto-generated method stub
		System.out.println("Need to implement tengu fight.");
		super.monsterAttack();
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
