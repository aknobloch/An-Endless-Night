package main.MenuSystem;
import main.Game;
import main.GameInput;
import main.CombatSystem.*;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.Weapon;
import main.RoomSystem.Room;

import java.io.IOException;
import java.util.ArrayList;

public class InventoryMenu extends AbstractMenu
{
	private String description = 
			"1. Equip Item \n"
			+ "2. Unequip Item \n"
			+ "3. Drop Item \n"
			+ "4. View Item \n"
			+ "5. Use Item \n"
			+ "6. Main Menu";
	/**
	 * Creates an Inventory Menu object
	 * @param menuLoader
	 */
	public InventoryMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	
	/**
	 * Displays items contained in the heros inventory
	 * @throws IOException
	 */
	public void viewItem() throws IOException 
	{
		// get the current hero inventory
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		
		//prompt the user to indicate which item they want more information on.
		System.out.println("Which item would you like to look at?");
		//display all the items to the user
		for(int i =0;i<items.size();i++)
		{
			System.out.println((i+1) + ". " +items.get(i).getItem().getName());
		}
		//get the users input
		int input = GameInput.getInt();
		//check to make sure that the input falls within the scope of the array
		if(input >=0 && items != null && input <items.size())
		{
			
			System.out.println(items.get(input).getItem().getDescription());;
		}
	}

	/**
	 * Prompts he user to specify which item they would like to drop into a room
	 * @throws IOException
	 */
	public void dropItem() throws IOException 
	{
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		System.out.println("Which item would you like to drop");
		for(InventoryItem x: items)
		{
			System.out.println(x.getItem().getName());
		}
		String input = GameInput.getString();
		
		for(InventoryItem x: items)
		{
			if(x.getItem().getName().equals(input))
			{
				System.out.println(input + " has been dropped in the room");
				Room room = Game.getHero().getRoom();
				room.getArtifactList().add(x.getItem());
				items.remove(x);
			}
		}
	}

	/**
	 * Unequips an item from the hero
	 * @throws IOException
	 */
	public void unEquipItem() throws IOException 
	{
		System.out.println("Which item would you like to unequip?");
		if(Game.getHero().getEquippedArmor() != null)
		{	
			System.out.println("1. " + Game.getHero().getEquippedArmor().getName());
		}
		if(Game.getHero().getEquippedWeapon() != null)
		{
			System.out.println("2. " + Game.getHero().getEquippedWeapon().getName());
		}
		int input = GameInput.getInt();
		
		if(input == 1)
		{
			Game.getHero().unequipArmor();
		}
		else if(input == 2)
		{
			Game.getHero().unequipWeapon();
		}
		else
		{
			System.out.println("You foolishly look around before realizing that you dont have anything by the name of " + input + " equipped.");
		}
	}

	/**
	 * Prompts the user to specify which item they would like to equip.
	 * @throws IOException
	 */
	public void equipItem() throws IOException 
	{
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		System.out.println("Which item would you like to equip");
		for(int i = 0; i <items.size();i++)
		{
			System.out.println((i) + ". " +items.get(i).getItem().getName());
		}
		int input = GameInput.getInt();
		
		if(input >= 0 && input < items.size())
		{
			
				if(items.get(input).getItem() instanceof Weapon)
				{
					Game.getHero().setEquippedWeapon((Weapon) items.get(input).getItem());
					Game.getHero().removeArtifactFromInventory(Game.getHero().getEquippedWeapon());
				}
				else if(items.get(input).getItem() instanceof Armor)
				{
					Game.getHero().setEquippedArmor((Armor) items.get(input).getItem());
					Game.getHero().removeArtifactFromInventory(Game.getHero().getEquippedArmor());
				}
			
		}
	}
	/**
	 * Prompts the user to specify which item they would like to use then consumes it
	 * @throws IOException
	 */
	public void useItem() throws IOException 
	{
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		System.out.println("Which item would you like to use");
		for(InventoryItem x: items)
		{
			System.out.println(x.getItem().getName());
		}
		String input = GameInput.getString();
		
		for(InventoryItem x: items)
		{
			if(x.getItem().getName().equals(input))
			{
				if(x.getItem() instanceof Weapon)
				{
					System.out.println("How does one use a weapon out in combat?");
				}
				else if(x.getItem() instanceof Armor)
				{
					System.out.println("How does one use armor out of combat?");
				}
				else if(x.getItem() instanceof Consumable)
				{
					Consumable use = (Consumable) x.getItem();
					Game.getHero().useConsumable(use);
				}
			}
		}
	}

	/**
	 * returns a string containing the description.
	 */
	public String toString()
	{
		return description;
	}
	@Override
	void mainPrompt() 
	{
		boolean inInventory = true;
		
		System.out.println("You take a look at your belongings. What would you like to do?");
		System.out.println(toString());
		while(inInventory)
		{
			try 
			{
				String input = GameInput.getString();
			
				if(input.equals("1"))
				{
					equipItem();
				}
				else if(input.equals("2"))
				{
					unEquipItem();
				}
				else if(input.equals("3"))
				{
					dropItem();
				}
				else if(input.equals("4"))
				{
					viewItem();
				}
				else if(input.equals("5"))
				{
					useItem();
				}
				else if(input.equals("6"))
				{
					inInventory = false;
					MenuLoader.loadGameMenu(this);
				}
				else
				{
					System.out.println(input + " is not a valid input please");
				}
			} catch (IOException e) 
			{
				System.out.println("Issue reading input");
			}
		}
	}
	@Override
	void onDestroy() 
	{}
}
