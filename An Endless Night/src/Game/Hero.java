package Game;

import java.util.ArrayList;
/***
 * The hero object represent the main protaganist of the game, 
 * and models the data associated with them.
 * 
 * @author Aaron & Caleb
 *
 */
public class Hero extends Character {

<<<<<<< HEAD
	private ArrayList<String> statusConditions;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private int defenseValue;
	private ArrayList<Artifact> playerInventory;
	
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
=======
	private String StatusCondition;

	private Weapon EquipedWeapon;

	private Armor EquippedArmor;

	private int Defense;

	private Artifact Inventory;

	private Monster monster;

	private Artifact artifact;

	private Puzzle puzzle;

	private Room room;

	private Game game;

	public void useItem() {

	}

	public void changeLocation() {

	}

	public void itemPickUp() {

	}

	public void fleeEncounter() {

	}

	public void equipArmor() {

>>>>>>> 71e7af26e94ea259e87227158d0f5810f4883fb5
	}
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public int getDefenseValue() {
		return defenseValue;
	}
	public void setDefenseValue(int defenseValue) {
		this.defenseValue = defenseValue;
	}
	public ArrayList<String> getStatusConditions() {
		return statusConditions;
	}
	public void addStatusCondition(String statusCondition) {
		this.statusConditions.add(statusCondition);
	}
	public ArrayList<Artifact> getPlayerInventory() {
		return playerInventory;
	}
	public void addArtifactToInventory(Artifact item) {
		this.playerInventory.add(item);
	}
	
	

	

}
