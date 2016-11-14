package main.CombatSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import main.Game;
import main.InventorySystem.Artifact;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.InventoryStackFullError;
import main.InventorySystem.Weapon;
import main.RoomSystem.Room;
/***
 * The hero object represent the main protaganist of the game, 
 * and models the data associated with them.
 * 
 * @author Aaron
 *
 */
public class Hero extends Character implements Serializable
{
	private ArrayList<StatusCondition> statusConditions;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private ArrayList<InventoryItem> playerInventory;
	// the maximum number of UNIQUE items a player can hold
	private final int MAX_INVENTORY = 5;
	// max stack of a single item a player can hold
	private final int MAX_STACK = 5;
	private int defense;
	private Room lastRoom;
	private final static int MAX_HEALTH = 120;

	/***
	 * Constructs a Hero.
	 * A Hero starts with no equipped armor, 
	 * no weapon except for their fists,
	 * 120 health, 1 strength
	 * and a defense value of zero. 
	 */
	public Hero() 
	{
		super(1, MAX_HEALTH, 1,"Hyuang");
		statusConditions = new ArrayList<>();
		equippedWeapon = new Weapon("Fists", "Bare fists, bruised from battle.", -1, 1);
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

		// Art_17 is Tengu Fan
		if(equippedWeapon.getArtifactID() == 17)
		{
			this.statusConditions.add(StatusCondition.TENGU_FAN);
		}

		// Art_18 is Kitsune's Tail
		if(equippedWeapon.getArtifactID() == 18)
		{
			this.statusConditions.add(StatusCondition.KITSUNE_TAIL);
		}

		this.strength = this.strength + equippedWeapon.getStrength();
	}

	/***
	 * Unequips the currently equipped weapon, if there is one.
	 * Reduces strength by the value of the equipped weapon, and
	 * attempts to move the equipped weapon into inventory.
	 */
	public void unequipWeapon() 
	{
		if(equippedWeapon == null || equippedWeapon.getName().equalsIgnoreCase("Fists")) 
		{
			return;
		}

		this.strength = this.strength - equippedWeapon.getStrength();
		this.addArtifactToInventory(equippedWeapon);

		// Art_17 is Tengu Fan
		if(equippedWeapon.getArtifactID() == 17)
		{
			this.statusConditions.remove(StatusCondition.TENGU_FAN);
		}

		// Art_18 is Kitsune's Tail
		if(equippedWeapon.getArtifactID() == 18)
		{
			this.statusConditions.remove(StatusCondition.KITSUNE_TAIL);
		}

		this.equippedWeapon = new Weapon("Fists", "Bare fists, bruised from battle.", -1, 1);
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

		//Art_09 is Heavy Boots
		if(equippedWeapon.getArtifactID() == 9)
		{
			this.statusConditions.add(StatusCondition.HEAVY_BOOTS);
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

		//Art_09 is Heavy Boots
		if(equippedWeapon.getArtifactID() == 9)
		{
			this.statusConditions.remove(StatusCondition.HEAVY_BOOTS);
		}

		this.addArtifactToInventory(this.equippedArmor);
		this.defense = 0;
		this.equippedArmor = null;
	}

	/**
	 * Gets all the status conditions currently afflicting the Hero.
	 * 
	 * @return An ArrayList<StatusCondition> of all the conditions
	 * currently afflicting the Hero. Read only.
	 */
	public ArrayList<StatusCondition> getStatusConditions() 
	{
		return new ArrayList<StatusCondition>(statusConditions);
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
	 * Gets a copy of the inventory of the Hero. The array returned by this method is 
	 * a copy, and all modifications will not be persistent. It is read-only. All inventory management 
	 * should be done through the helper methods in the Hero class.
	 * 
	 * @return An ArrayList<InventoryItem> representing the player's inventory.
	 */
	public ArrayList<InventoryItem> getPlayerInventory() 
	{
		return new ArrayList<InventoryItem>(this.playerInventory);
	}

	/**
	 * Attempts to add the paramartized artifact to the players inventory.
	 * Returns a message indicating whether the item was successfully added, 
	 * or if there was a problem and it was placed in the room. The message
	 * is not formatted, i.e. tabs or new line characters.
	 * 
	 * @param newItem The artifact to add.
	 * @return A message to display to the user indicating how the method completed.
	 * The possible messages are as follows: <br>
	 * 'You try to cram the item in your bag, but it just won't fit.' <br>
	 * 'You can't fit any more of this item into your bag.' <br>
	 * 'You place the item safely in your bag.'
	 * 
	 */
	public String addArtifactToInventory(Artifact newItem) 
	{
		if(playerInventory.size() >= MAX_INVENTORY) 
		{
			return "You try to cram the item in your bag, but it just won't fit.";
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
						return "You can't fit any more of this item into your bag.";
					}
				}
			}

			playerInventory.add(new InventoryItem(newItem, MAX_STACK));
		}

		// if reaches this point, item was added properly
		return "You place the item safely in your bag.";
	}

	/**
	 * Removes the given artifact from inventory. If the item is stacked, this
	 * method decrements a stack of the item. If there is only one instance, the 
	 * item is removed from the inventory. In either case, an instance of the 
	 * item is placed in the current room. A message is then returned indicating 
	 * that the item either was not found or the item was placed in room. The message
	 * is not formatted, i.e. tabs or newline characters.
	 * 
	 * @param itemToRemove The item to remove
	 * @return  A message to display to the user that the item either was not found or the item was placed in room.
	 * The potential messages are as follows: <br>
	 * 'You take out the <item name> from your bag and place it in the room.' <br>
	 * 'You dig through your bag, searching for the <item name>, but can't find it.' 
	 * 
	 */
	public String removeArtifactFromInventory(Artifact itemToRemove)
	{
		for(InventoryItem item : playerInventory)
		{
			if(item.getItem().equals(itemToRemove))
			{
				// first decrement the stack
				int newStackAmount = item.decrementCount();

				// if the stack is now zero, remove item
				if(newStackAmount <= 0) 
				{
					playerInventory.remove(item);
				}

				// after the above, place an instance of the artifact in the current room
				this.getRoom().getArtifactList().add(itemToRemove);

				// return message
				return "You take out the " + itemToRemove.getName() + " from your bag and place it in the room.";
			}
		}

		// if reaches this far, the item wasn't found.
		return "You dig through your bag, searching for the " + itemToRemove.getName() + ", but can't find it.";
	}

	/**
	 * Uses a consumable item. This method adds the health of the item to the 
	 * Hero, and handles decrementing stacks and removing items if no more left.
	 * 
	 * @param usedItem The item to use.
	 */
	public void useConsumable(Consumable usedItem) 
	{
		for(InventoryItem item : playerInventory) 
		{
			// if item is in the inventory, decrement count
			if(item.getItem().equals(usedItem)) 
			{
				this.heal(usedItem.getHealAmount());
				int countLeft = item.decrementCount();
				// if none left after decrement, remove.
				if(countLeft <= 0) 
				{
					playerInventory.remove(item);
					return;
				}
			}
		}
	}

	@Override
	public int heal(int amount) 
	{
		int remainingHealth = super.heal(amount);

		if(remainingHealth > MAX_HEALTH)
		{
			this.health = MAX_HEALTH;
		}

		return this.health;
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
	public int attack(int damage) 
	{
		damage = damage - this.defense;
		return super.attack(damage);
	}

	/**
	 * Set the last room that the hero was in. This 
	 * 
	 * @param lastRoom The room that the hero is leaving.
	 */
	public void setLastRoom(Room lastRoom)
	{
		this.lastRoom = lastRoom;
	}

	/**
	 * Gets the last room that the Hero was in. There are a few cases where this 
	 * will return the current room. If the Hero was bounce-backed in the last turn, or if
	 * the hero was teleported, then this method will return the current room.
	 * 
	 * @return The last room that the Hero was logically in.
	 */
	public Room getLastRoom()
	{
		return lastRoom;
	}

	/**
	 * Teleports the Hero to a new location. Do not use this method unless you have
	 * a very specific, very pressing need. 
	 * 
	 * @param newLocation The new location to place the hero. Sets the current room and last
	 * room of the player to be the new location to avoid logical errors.
	 */
	public void teleport(Room newLocation) 
	{
		this.currentRoom = newLocation;
		// the last room should not be the actual last room, that could
		// create problems. Therefore, last room is set for the current room.
		this.lastRoom = currentRoom;
	}

	/**
	 * Overload. Teleports the Hero to the given location specified by the room ID.
	 * If it cannot find the room, it places the hero in the main hallway.
	 * 
	 * @param roomID The new room to place the hero.
	 */
	public void teleport(int roomID)
	{
		for(Room focusRoom : Game.getRooms())
		{
			if(focusRoom.getRoomID() == roomID)
			{
				this.move(focusRoom);
				this.lastRoom = focusRoom;
				return;
			}
		}

		// if we get here, room wasn't found. default to main hallways
		teleport(100);
	}

	/** 
	 * Bounces the hero back to the last location. This method does not alter the last room.
	 * Therefore, after this method is called the last location and current room will be the 
	 * same until the Hero moves again.
	 */
	public void bounceBack() 
	{
		this.currentRoom = lastRoom;
	}

	/**
	 * Moves the player to a new location, and ensures that the last location is recorded as well.
	 * For all typical moves, this is the method that should be called.
	 */
	public void move(Room newRoom) 
	{
		// temp because if moving does not work properly, 
		// we don't want to set last location yet.
		Room temp = this.currentRoom;

		super.move(newRoom);

		// if super.move() returns properly, then 
		// set the last location to be the old one.
		this.lastRoom = temp;
	}

	/**
	 * Cheat mode. Only activated by the game object, in other words
	 * the user must type in "MAKE ME A GOD" to activate this.
	 * @param gameObject
	 */
	public void godMode(Game gameObject)
	{
		this.health = Integer.MAX_VALUE;
		this.strength = 500;
		this.defense = Integer.MAX_VALUE;
	}

	public void mortalMode(Game game) 
	{
		this.health = 150;
		this.strength = this.equippedWeapon.getStrength() + 1;
		this.defense = this.equippedArmor.getDefense();
	}
} 
