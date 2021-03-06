package main.InventorySystem;


public class Consumable extends Artifact 
{
	private int healAmount;

	/**
	 * Creates a consumable object
	 * @param name
	 * @param description
	 * @param artifactID
	 * @param healAmount
	 */
	public Consumable(String name, String description, int artifactID, int healAmount) 
	{
		super(name, description, artifactID);

		this.healAmount = healAmount;
	}

	/**
	 * Gets the Amount healed by consumable
	 * @return
	 */
	public int getHealAmount() 
	{
		return healAmount;
	}
}
