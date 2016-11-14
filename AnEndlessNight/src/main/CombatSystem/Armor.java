package main.CombatSystem;
import main.InventorySystem.Artifact;

public class Armor extends Artifact 
{
	private int defense;

	/**
	 * Creates an Armor object requires a Name, Description, artifactID, puzzleID, and a defense parameter.
	 * @param name
	 * @param description
	 * @param artifactID
	 * @param defense
	 */
	public Armor(String name, String description, int artifactID, int defense) 
	{
		super(name, description, artifactID);
		this.defense = defense;
	}
	
	/**
	 * Returns the defense attribute for the armor class. 
	 * @return the defense stat of the armor
	 */
	public int getDefense() 
	{
		return defense;
	}

}
