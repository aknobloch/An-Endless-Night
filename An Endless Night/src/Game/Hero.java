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

	public enum StatusCondition {
		// TODO: Add possible status conditions
	}
	
	private ArrayList<StatusCondition> statusConditions;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
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
	
	public ArrayList<StatusCondition> getStatusConditions() {
		return statusConditions;
	}
	
	public void addStatusCondition(StatusCondition newCondition) {
		this.statusConditions.add(newCondition);
	}
	
	public ArrayList<Artifact> getPlayerInventory() {
		return playerInventory;
	}
	
	public void addArtifactToInventory(Artifact item) {
		this.playerInventory.add(item);
	}
	
	

	

}
