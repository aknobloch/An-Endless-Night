package main.CombatSystem;
import main.InventorySystem.Artifact;

public class Armor extends Artifact 
{
	private int defense;

	public Armor(String name, String description, int artifactID, int puzzleID, int defense) 
	{
		super(name, description, artifactID, puzzleID);
		this.defense = defense;
	}

	public int getDefense() 
	{
		return defense;
	}

}
