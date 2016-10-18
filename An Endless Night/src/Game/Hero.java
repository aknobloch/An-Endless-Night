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
	
	
	public Hero(int ID, int health, int strength, int defense, String name) {
		super(ID, health, strength, defense, name);
		statusConditions = new ArrayList<>();
		equippedWeapon = null;
		equippedArmor = null;
		playerInventory = new ArrayList<>();
	}
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	
	public void setEquippedWeapon(Weapon equippedWeapon) {
		// TODO: handle case if weapon is already equipped
		this.equippedWeapon = equippedWeapon;
	}
	
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	
	public void setEquippedArmor(Armor equippedArmor) {
		// TODO: handle case if armor is already equipped
		this.equippedArmor = equippedArmor;
	}
	
	public ArrayList<StatusCondition> getStatusConditions() {
		return statusConditions;
	}
	
	public void addStatusCondition(StatusCondition newCondition) {
		if( ! this.statusConditions.contains(newCondition)) {
			statusConditions.add(newCondition);
		}
	}
	
	public void removeStatusCondition(StatusCondition condition) {
		if(this.statusConditions.contains(condition)) {
			statusConditions.remove(condition);
		}
	}
	
	public ArrayList<Artifact> getPlayerInventory() {
		return playerInventory;
	}
	
	public void addArtifactToInventory(Artifact item) {
		// TODO: handle case if inventory is full
		this.playerInventory.add(item);
	}
	
	

	

}
