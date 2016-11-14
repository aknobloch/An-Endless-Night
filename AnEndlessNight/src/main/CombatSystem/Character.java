package main.CombatSystem;

import java.io.Serializable;

import main.RoomSystem.Room;

/***
 * The character is the super class of all NPC's and the Hero. 
 * It defines common functionality between all. 
 * @author Aaron
 *
 */
public abstract class Character implements Serializable
{
	protected int characterID;
	protected int health;
	protected int strength;
	protected String name;
	protected Room currentRoom;

	/***
	 * Constructs a Character from the specified params.
	 * @param ID  The ID of the character.
	 * @param health The health of the character.
	 * @param strength The strength of the character (before modifiers).
	 * @param name The human readable name of the character.
	 */
	protected Character(int ID, int health, int strength, String name) 
	{
		this.characterID = ID;
		this.health = health;
		this.strength = strength;
		this.name = name;
	}

	/***
	 * Attacks the character with the amount of damage specified. Subtracts
	 * the amount specified from the current health.
	 * @param amount The amount to attack the character with.
	 * @return The amount of health left after the attack.
	 */
	public int attack(int amount) 
	{
		if(amount < 0)
		{
			amount = 0;
		}
		this.health = health - amount;
		return health;
	}

	/**
	 * Returns the ID of this character.
	 * @return The ID of the character.
	 */
	public int getID() 
	{
		return this.characterID;
	}

	/**
	 * Returns the health of the character.
	 * @return The health of the character.
	 */
	public int getHealth() 
	{
		return this.health;
	}

	/***
	 * Heals the Character the specified amount. Adds the amount 
	 * to the Character's health.
	 * @param amount The amount to add to the health value.
	 * @return The amount of remaining health after adding param value.
	 */
	public int heal(int amount) 
	{
		this.health = health + amount;
		return health;
	}

	/**
	 * Returns the strength of the character.
	 * @return The strength of the character.
	 */
	public int getStrength() 
	{
		return this.strength;
	}

	/**
	 * Returns the human-readable name of the character.
	 * @return The name of the character.
	 */
	public String getName() 
	{
		return this.name;
	}

	/***
	 * Returns the room that this Character
	 * is currently in.
	 * @return Room object hero is currently in
	 */
	public Room getRoom() 
	{
		return this.currentRoom;
	}

	/**
	 * Sets the current location of the character to the paramartized 
	 * Room. 
	 * @param newRoom The new room to place this character in.
	 */
	public void move(Room newRoom) 
	{
		// TODO: error handling if room id does not exist or 
		//       is not logically feasible
		this.currentRoom = newRoom;
	}
}
