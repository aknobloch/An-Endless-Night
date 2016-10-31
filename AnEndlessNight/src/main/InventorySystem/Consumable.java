package main.InventorySystem;

public class Consumable extends Artifact 
{

	private int healAmount;
	
	public Consumable(String name, String description, int artifactID,int healAmount) 
	{
		super(name, description, artifactID);
		
		this.healAmount = healAmount;
	}

	public int getHealAmount() 
	{
		return healAmount;
	}

}
