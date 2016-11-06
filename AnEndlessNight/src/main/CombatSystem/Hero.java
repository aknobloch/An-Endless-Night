package main.CombatSystem;

import java.util.ArrayList;
import java.util.Map;

import main.InventorySystem.Artifact;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.InventoryStackFullError;
import main.InventorySystem.Weapon;
/***
 * The hero object represent the main protaganist of the game, 
 * and models the data associated with them.
 * 
 * @author Aaron
 *
 */
public class Hero extends Character 
{
	private ArrayList<StatusCondition> statusConditions;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private ArrayList<InventoryItem> playerInventory;
	// the maximum number of UNIQUE items a player can hold
	private final int MAX_INVENTORY = 15;
	// max stack of a single item a player can hold
	private final int MAX_STACK = 5;
	private int defense;
	
	/***
	 * Constructs a Hero based on the listed parameters.
	 * A Hero starts with no equipped weapon or armor, 
	 * and a defense value of zero. 
	 * 
	 * @param ID - Unique ID associated with this Hero
	 * @param health - Starting health of this Hero
	 * @param strength - Starting strength of Hero
	 * @param name - Human-readable name of this Hero
	 */
	public Hero(int health, int strength) 
	{
		super(1, health, strength,"Steve");
		statusConditions = new ArrayList<>();
		equippedWeapon = null;
		equippedArmor = null;
		playerInventory = new ArrayList<>();
		defense = 0;
	}
	
	/***
	 * Gets the currently equipped weapon.
	 * @return The currently equipped weapon, or null if there is no weapon equipped.
	 */
	public Weapon getEquippedWeapon()
	{
		return equippedWeapon;
	}
	
	/***
	 * Sets the equipped weapon to the paramaratized weapon.
	 * If a weapon is currently equipped, it is unequipped.
	 * 
	 * @param equippedWeapon The weapon to equip.
	 */
	public void setEquippedWeapon(Weapon equippedWeapon) 
	{
		if(this.equippedWeapon != null) 
		{
			this.unequipWeapon();
		}
		
		this.equippedWeapon = equippedWeapon;
		this.strength = this.strength + equippedWeapon.getStrength();
	}
	
	/***
	 * Unequips the currently equipped weapon, if there is one.
	 * Reduces strength by the value of the equipped weapon, and
	 * attempts to move the equipped weapon into inventory.
	 */
	public void unequipWeapon() {
		
		if(equippedWeapon == null) 
		{
			return;
		}
		
		this.strength = this.strength - equippedWeapon.getStrength();
		this.addArtifactToInventory(equippedWeapon);
		this.equippedWeapon = null;
	}
	
	/***
	 * Gets the currently equipped armor.
	 * @return The equipped armor, or null if there is no armor equipped.
	 */
	public Armor getEquippedArmor() 
	{
		return equippedArmor;
	}
	
	/**
	 * Equips the paramartized armor. If an armor is already equipped,
	 * it is unequipped. Sets the defense of the Hero equal to 
	 * the defense value of the newly equipped armor.
	 * 
	 * @param equippedArmor The armor to equip.
	 */
	public void setEquippedArmor(Armor equippedArmor) 
	{
		if(this.equippedArmor != null) 
		{
			this.unequipArmor();
		}
		
		this.equippedArmor = equippedArmor;
		this.defense = this.equippedArmor.getDefense();
	}
	
	/**
	 * Unequips the currently equipped weapon. Attempts to place
	 * the armor into the inventory and sets the defense of the
	 * hero to zero.
	 */
	public void unequipArmor() 
	{
		if(equippedArmor == null)
		{
			return;
		}
		this.addArtifactToInventory(this.equippedArmor);
		this.defense = 0;
		this.equippedArmor = null;
	}
	
	/**
	 * Gets all the status conditions currently afflicting the Hero.
	 * @return An ArrayList<StatusCondition> of all the conditions
	 * currently afflicting the Hero.
	 */
	public ArrayList<StatusCondition> getStatusConditions() 
	{
		return statusConditions;
	}
	
	/**
	 * Adds the paramartized status condition to the Hero.
	 * @param newCondition The condition to add.
	 */
	public void addStatusCondition(StatusCondition newCondition) 
	{
		if( ! this.statusConditions.contains(newCondition)) 
		{
			statusConditions.add(newCondition);
		}
	}
	
	/**
	 * Removes the paramartized status condition from the Hero.
	 * @param condition The status condition to remove.
	 */
	public void removeStatusCondition(StatusCondition condition) 
	{
		if(this.statusConditions.contains(condition)) 
		{
			statusConditions.remove(condition);
		}
	}
	
	/**
	 * Gets the inventory of the Hero.
	 * @return An ArrayList<InventoryItem> representing the player's inventory.
	 */
	public ArrayList<InventoryItem> getPlayerInventory() 
	{
		// TODO: Handle outside modification of inventory.
		return playerInventory;
	}
	
	/**
	 * Attempts to add the paramartized artifact to the players inventory.
	 * @param newItem The artifact to add.
	 */
	public void addArtifactToInventory(Artifact newItem) 
	{
		
		if(playerInventory.size() >= MAX_INVENTORY) 
		{
			// TODO: handle case if inventory is full
		}
		else 
		{
			
			// check if item already exists in player inventory. if so, try to increment the count
			for(InventoryItem item : playerInventory) 
			{
				
				if(item.equals(newItem)) 
				{
					try 
					{
						item.incrementCount();
						
					} catch(InventoryStackFullError isfe) 
					{
						// TODO: What happens if inventory stack is full?
					}
				}
			}
			
			playerInventory.add(new InventoryItem(newItem, MAX_STACK));
		}
	}
	
	/**
	 * Gets the current defense of the hero.
	 * @return The current defense of the hero.
	 */
	public int getDefense() 
	{
		return this.defense;
	}
	
	/**
	 * Override method of the Character.attack(int amount). When the hero is attacked,
	 * the damage inflicted is reduced by the current defense value of the Hero.
	 * 
	 * @param The amount to attack the hero with.
	 * @return The remaining health of the hero.
	 */
	@Override
	public int attack(int damage) {
		
		damage = damage - this.defense;
		return super.attack(damage);
		
	}
}