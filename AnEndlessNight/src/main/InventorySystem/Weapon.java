package main.InventorySystem;


public class Weapon extends Artifact 
{
	private int strength;

	public Weapon(String name, String description, int artifactID, int strength) 
	{
		super(name, description, artifactID);
		this.strength = strength;
	}
	
	public int getStrength() 
	{
		return strength;
	}

}
