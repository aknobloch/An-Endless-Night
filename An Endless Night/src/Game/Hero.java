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

	private ArrayList<String> statusConditions;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private int defenseValue;
	private ArrayList<Artifact> playerInventory;
	
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
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
