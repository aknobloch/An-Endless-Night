package Game;
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
	private double probabilityOfDroppingItem;
	private Artifact droppedItem;
	private boolean isBoss;
	
	public Monster(int ID, int health, int strength, String name, double appearanceProbability, Artifact droppedItem, double probabilityOfDroppingItem, boolean isBoss) 
	{
		super(ID, health, strength, name);
		this.probabilityOfAppearance = appearanceProbability;
		this.droppedItem = droppedItem;
		this.isBoss = isBoss;
	}
	
	public double getProbabilityOfDroppingItem() 
	{
		return this.probabilityOfDroppingItem;
	}

	public double getProbabilityOfAppearance() 
	{
		return this.probabilityOfAppearance;
	}
	
	public Artifact getDroppedItem() 
	{
		return this.droppedItem;
	}

	public boolean isBoss() 
	{
		return this.isBoss;
	}

	

}
