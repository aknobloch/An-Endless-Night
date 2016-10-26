package Game;

import java.util.ArrayList;
import java.util.Map;
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
	 * Constructs a Hero based on the listed parameters
	 * @param ID - Unique ID associated with this Hero
	 * @param health - Starting health of this Hero
	 * @param strength - Starting strength of Hero
	 * @param defense - Starting defense of Hero
	 * @param name - Human-readable name of this Hero
	 */
	public Hero(int ID, int health, int strength, int defense, String name) 
	{
		super(ID, health, strength, name);
		statusConditions = new ArrayList<>();
		equippedWeapon = null;
		equippedArmor = null;
		playerInventory = new ArrayList<>();
		defense = 0;
	}
	
	public Weapon getEquippedWeapon()
	{
		return equippedWeapon;
	}
	
	public void setEquippedWeapon(Weapon equippedWeapon) 
	{
		// TODO: handle case if weapon is already equipped
		this.equippedWeapon = equippedWeapon;
	}
	
	public Armor getEquippedArmor() 
	{
		return equippedArmor;
	}
	
	public void setEquippedArmor(Armor equippedArmor) 
	{
		if(this.equippedArmor != null) {
			this.unequipArmor();
		}
		
		this.equippedArmor = equippedArmor;
		this.defense = this.equippedArmor.getDefense();
	}
	
	public void unequipArmor() {
		this.addArtifactToInventory(this.equippedArmor);
		this.defense = 0;
	}
	
	public ArrayList<StatusCondition> getStatusConditions() 
	{
		return statusConditions;
	}
	
	public void addStatusCondition(StatusCondition newCondition) 
	{
		if( ! this.statusConditions.contains(newCondition)) 
		{
			statusConditions.add(newCondition);
		}
	}
	
	public void removeStatusCondition(StatusCondition condition) 
	{
		if(this.statusConditions.contains(condition)) 
		{
			statusConditions.remove(condition);
		}
	}
	
	public ArrayList<InventoryItem> getPlayerInventory() 
	{
		// TODO: Handle outside modification of inventory.
		return playerInventory;
	}
	
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
	
	public int getDefense() 
	{
		return this.defense;
	}
	
	@Override
	public int attack(int damage) {
		
		damage = damage - this.defense;
		return super.attack(damage);
		
	}
}
