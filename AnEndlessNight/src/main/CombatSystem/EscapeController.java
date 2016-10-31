
package main.CombatSystem;

import java.util.Random;

import main.Game;

/** Handles calculating if the hero can successfully escape the battle.
 *  Besides if the monster is a boss, the hero has a base 15% chance of successfully
 *  escaping the battle. Certain items may alter this value. This class
 *  has a single method, attemptEscape() that returns true or false
 *  depending on if the escape attempt was successful or not.
 *  
 * @author Aaron
 *
 */
public class EscapeController 
{
	
	private Hero gameHero;
	private Monster battleMonster;
	
	/***
	 * Creates an EscapeController.
	 * Automatically determines the appropriate Hero and Monster
	 * based on the current Room. 
	 */
	public EscapeController() 
	{
		
		this.gameHero = Game.getHero();
		this.battleMonster = gameHero.getRoom().getMonster();
		
	}
	
	/***
	 * Attempts to escape the current battle.
	 * @return True if successful, false if failed.
	 */
	public boolean attemptEscape() 
	{
		
		if(battleMonster.isBoss()) 
		{
			return false;
		}
		
		Random r = new Random();
		int chance = 2; // equals 3/20, equates to 15%
		
		// tengu fan increases successful chance of escape by 10%
		if (gameHero.getStatusConditions().contains(StatusCondition.TENGU_FAN))
		{
			chance = chance + 2; // equals 4/20, equates to 25%
		}
		
		if(r.nextInt(20) <= chance) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
