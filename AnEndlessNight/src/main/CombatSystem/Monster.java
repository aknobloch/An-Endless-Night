package main.CombatSystem;


import java.util.ArrayList;
import main.InventorySystem.Artifact;

/***
 * Monster is a beast that appears in rooms based on it's probability of
 * appearance. They are optionally engageable, and upon defeat drop an artifact.
 * @author Aaron and Caleb
 *
 */
public class Monster extends Character
{
 // TODO turn droppedItem into an arrayList of possibly dropped items.
	private double probabilityOfAppearance;
	private ArrayList<Artifact> droppedItem;
	private boolean isBoss;

	/***
	 * Constructs a Monster based off the parameterized values.
	 * @param ID The unique ID of the Monster.
	 * @param health The base health of the Monster.
	 * @param strength The base strength of the Monster.
	 * @param name The human-readable name of the Monster.
	 * @param appearanceProbability The probability of the Monster appearing in a Room.
	 * @param droppedItem The item(s) that the Monster could possibly drop.
	 * @param isBoss Whether or not this Monster is a boss.
	 */
	public Monster(int ID, int health, int strength, String name, double appearanceProbability, ArrayList<Artifact> droppedItem, boolean isBoss)
	{ 
		super(ID, health, strength, name);
		this.probabilityOfAppearance = appearanceProbability;
		this.droppedItem = droppedItem;
		this.isBoss = isBoss;
	}

	/**
	 * Gets the probability of this Monster appearing.
	 * @return The probability of this Monster appearing.
	 */
	public double getProbabilityOfAppearance() 
	{
		return this.probabilityOfAppearance;
	}
	
	/**
	 * Gets the item that the Monster drops.
	 * @return The item that the Monster drops.
	 */
	public ArrayList<Artifact> getDroppedItem() 
	{
		return this.droppedItem;
	}

	/**
	 * Gets whether or not this Monster is a boss.
	 * @return Whether or not this Monster is a boss.
	 */
	public boolean isBoss() 
	{
		return this.isBoss;
	}
}
