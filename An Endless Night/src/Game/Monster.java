package Game;
/***
 * Monster is a beast that appears in rooms based on it's probability of
 * appearance. They are optionally engageable, and upon defeat drop an artifact.
 * @author Aaron
 *
 */
public class Monster extends Character {

	private double probabilityOfAppearance;
	private Artifact droppedItem;
	
	public Monster(int ID, int health, int strength, int defense, String name, double appearanceProbability, Artifact droppedItem) {
		super(ID, health, strength, defense, name);
		this.probabilityOfAppearance = appearanceProbability;
		this.droppedItem = droppedItem;
	}
	
	public double getProbabilityOfAppearance() {
		return this.probabilityOfAppearance;
	}
	
	public Artifact getDroppedItem() {
		return this.droppedItem;
	}

	

}
