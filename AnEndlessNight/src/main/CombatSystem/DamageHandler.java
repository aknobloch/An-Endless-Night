package main.CombatSystem;

import java.util.Random;

import main.Game;
import main.RoomSystem.Room;

/***
 * The DamageHandler class is used to facilitate the interaction between 
 * monsters and the hero in combat. It selects the hero and the monster involved
 * in the interaction during construction by contextually selecting
 * based on the current room the hero is located in. 
 * 
 * @author Aaron
 *
 */
public class DamageHandler 
{

	private Hero gameHero;
	private Monster battleMonster;
	private Room battleRoom;
	
	/***
	 * Constructs a damage handler for the current battle. The Hero
	 * and the opposing monster are both automatically derived from 
	 * the current room that the Hero is in.
	 */
	public DamageHandler() 
	{
		
		gameHero = Game.getHero();
		battleRoom = gameHero.getRoom();
		battleMonster = battleRoom.getMonster();
		
	}
	
	/***
	 * Attacks the hero. This method calculates the appropriate damage 
	 * to applies it to the hero.
	 * 
	 * @return 	The remaining health of the hero, zero if the attack missed 
	 * 			and -1 if the hero died.
	 * 			
	 */
	public int attackHero()
	{
		
		// Kitsune tail buff makes attacks have a 15% chance of missing
		if(gameHero.getStatusConditions().contains(StatusCondition.KITSUNE_TAIL)) 
		{
			Random r = new Random();
			if(r.nextInt(20) <= 2) 
			{
				return 0;
			}
		}
		
		int damage = battleMonster.getStrength() - gameHero.getDefense();
		int remainingHealth = gameHero.attack(damage);
		
		if(remainingHealth <= 0) 
		{
			// TODO: Handle case if hero dies
			return -1;
		}
		else 
		{
			return remainingHealth;
		}
		
	}
	
	/***
	 * This method calculates the appropriate level of damage and attacks the 
	 * monster with it. 
	 * 
	 * @return The remaining health of the monster, zero if the attack missed 
	 * 			and -1 if the monster died.
	 */
	public int attackMonster() 
	{
		
		int damage = gameHero.getStrength() + gameHero.getEquippedWeapon().getStrength();
		
		// Kitsune debuff reduces game hero attack strength by 5%
		if(gameHero.getStatusConditions().contains(StatusCondition.KITSUNE_DEBUFF)) 
		{
			damage = (int) (damage - (damage * .05));
		}
		
		// Ryu debuff reduces game hero attack strength by 25%
		if(gameHero.getStatusConditions().contains(StatusCondition.RYU_DEBUFF)) 
		{
			damage = (int) (damage - (damage * .25));
		}
		
		int remainingHealth = battleMonster.attack(damage);
		
		if(remainingHealth <= 0) 
		{
			// TODO: Handle case if monster dies
			return -1;
		}
		else 
		{
			return remainingHealth;
		}
	}
}
