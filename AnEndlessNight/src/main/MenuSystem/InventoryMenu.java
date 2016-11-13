package main.MenuSystem;
import main.Game;
import main.CombatSystem.*;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.Weapon;
import main.RoomSystem.Room;

import java.io.IOException;
import java.util.ArrayList;

public class InventoryMenu extends AbstractMenu
{
	public InventoryMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	private String description = 
			"\n1. Equip Item"
			+ "\n2. Unequip Item"
			+ "\n3. Drop Item"
			+ "\n4. View Item"
			+ "\n5. Use Item"
			+ "\n6. Main Menu";

	public void viewItem() throws IOException 
	{
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		
		System.out.println("Which item would you like to look at?");
		for(InventoryItem x: items)
		{
			System.out.println(x.getItem().getName());
		}
		String input = GameInput.getString();
		
		for(InventoryItem x: items)
		{
			if(x.getItem().getName().equals(input))
			{
				System.out.println(x.getItem().getDescription());
			}
		}
	}

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

	public void unEquipItem() throws IOException 
	{
		System.out.println("Which item would you like to unequip?");
		
		System.out.println(Game.getHero().getEquippedArmor().getName());
		System.out.println(Game.getHero().getEquippedWeapon().getName());
		
		String input = GameInput.getString();
		
		if(Game.getHero().getEquippedArmor().equals(input))
		{
			Game.getHero().unequipArmor();
		}
		else if(Game.getHero().getEquippedWeapon().equals(input))
		{
			Game.getHero().unequipWeapon();
		}
		else
		{
			System.out.println("You foolishly look around before realizing that you dont have anything by the name of " + input + " equipped.");
		}
	}

	public void equipItem() throws IOException 
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
				if(x.getItem() instanceof Weapon)
				{
					Game.getHero().setEquippedWeapon((Weapon) x.getItem());
				}
				else if(x.getItem() instanceof Armor)
				{
					Game.getHero().setEquippedArmor((Armor) x.getItem());
				}
			}
		}
	}
	public void useItem() throws IOException 
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
				if(x.getItem() instanceof Weapon)
				{
					System.out.println("How does one use a weapon not in combat?");
				}
				else if(x.getItem() instanceof Armor)
				{
					System.out.println("How does one use armor out of combat?");
				}
				else if(x.getItem() instanceof Consumable)
				{
					Consumable use = (Consumable) x.getItem();
					int currentHealth = Game.getHero().getHealth();
					System.out.println("Your Health is now at " + Game.getHero().getHealth());
				}
			}
		}
	}

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
