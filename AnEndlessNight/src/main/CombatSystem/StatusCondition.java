package main.CombatSystem;

/***
 * Enumerated types of all the status effects that can possibly 
 * effect the Hero.
 * @author Aaron
 *
 */

public enum StatusCondition
{
	/*
	 * IMMOBOLIZED:		Described by Mon_02.
	 * 					Makes the hero unable to perform action for one turn.
	 * 
	 * KITSUNE_DEBUFF:	Described by Boss_02.
	 * 					Lowers the hero's attack strength by 5%
	 * 
	 * RYU_DEBUFF:		Described by Boss_03.
	 * 					Lowers the hero's attack strength by 25%
	 * 
	 * TENGU_FAN:		Described by Art_17.
	 * 					Increases the chance of escaping battle by 10%
	 * 
	 * KITSUNE_TAIL:	Described by Art_18.
	 * 					All attacks have a 15% chance of missing player.
	 * 
	 * DEFENSE_BUFF: 	All attacks do less damage. Activated by defending in combat.
	 * 
	 * HEAVY_BOOTS:     Boots that cause immunity from Tengu
	 */
	IMMOBILIZED, KITSUNE_DEBUFF, RYU_DEBUFF,
	TENGU_FAN, KITSUNE_TAIL, DEFENSE_BUFF, HEAVY_BOOTS;
}

