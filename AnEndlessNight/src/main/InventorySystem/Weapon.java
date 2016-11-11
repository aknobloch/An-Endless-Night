package main.InventorySystem;


public class Weapon extends Artifact 
{
	private int strength;

	public Weapon(String name, String description, int artifactID, int puzzleID, int strength) 
	{
		super(name, description, artifactID, puzzleID);
		this.strength = strength;
	}
	
	public int getStrength() 
	{
		return strength;
	}

}
