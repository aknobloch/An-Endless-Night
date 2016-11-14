package main.InventorySystem;


public class Weapon extends Artifact 
{
	private int strength;

	/**
	 * creats a Weapon object
	 * @param name
	 * @param description
	 * @param artifactID
	 * @param strength
	 */
	public Weapon(String name, String description, int artifactID, int strength) 
	{
		super(name, description, artifactID);
		this.strength = strength;
	}
	
	/**
	 * Returns the Strength awarded from this weapon. 
	 * @return
	 */
	public int getStrength() 
	{
		return strength;
	}

}
