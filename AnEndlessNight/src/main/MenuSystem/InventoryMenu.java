package main.MenuSystem;
import java.io.IOException;
import java.util.ArrayList;

import main.Game;
import main.GameInput;
import main.CombatSystem.Armor;
import main.CombatSystem.Hero;
import main.InventorySystem.Artifact;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.Weapon;
import main.RoomSystem.Room;

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
		ArrayList<Artifact> items = new ArrayList<>();
		
		for(InventoryItem inventoryItem : Game.getHero().getPlayerInventory())
		{
			items.add(inventoryItem.getItem());
		}
		
		if(Game.getHero().getEquippedArmor() != null)
		{
			items.add(Game.getHero().getEquippedArmor());
		}
		// if not the fists
		if( ! Game.getHero().getEquippedWeapon().getName().equalsIgnoreCase("fists"))
		{
			items.add(Game.getHero().getEquippedWeapon());
		}

		//prompt the user to indicate which item they want more information on.
		System.out.println("Which item would you like to look at?");
		//display all the items to the user
		for(int i =0;i<items.size();i++)
		{
			System.out.println((i) + ". " +items.get(i).getName());
		}
		//get the users input
		int input = GameInput.getInt();
		//check to make sure that the input falls within the scope of the array
		if(input >=0 && items != null && input <items.size())
		{
			
			Artifact chosenItem = items.get(input);
			System.out.println("\t" + chosenItem.getDescription());
			System.out.println();
			
			//print out contextual help
			if(chosenItem instanceof Consumable)
			{
				System.out.println("\tThis looks like something you could use to improve your condition.");
				System.out.println();
			}
			else 
			{
				System.out.println("\tThis looks like something you'd equip for battle.");
				System.out.println();
			}
			
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
		for(int i = 0; i< items.size();i++)
		{
			System.out.println(i + ". " + items.get(i).getItem().getName());
		}
		int input = GameInput.getInt();
		
			if(input >=0 && input < items.size())
			{
				System.out.println("\t" + "Your bags feel lighter as you drop items into the room.");
				System.out.println();
				Room room = Game.getHero().getRoom();
				room.getArtifactList().add(items.get(input).getItem());
				Game.getHero().removeArtifactFromInventory(items.get(input).getItem());
			}
			else
			{
				System.out.println("You mutter to yourself.");
			}
	}

	/**
	 * Unequips an item from the hero
	 * @throws IOException
	 */
	public void unEquipItem() throws IOException 
	{
		
		Hero gameHero = Game.getHero();
		
		ArrayList<Artifact> equippedItems = new ArrayList<>();
		
		// add armor to equipped items
		if(gameHero.getEquippedArmor() != null)
		{
			equippedItems.add(gameHero.getEquippedArmor());
		}
		
		// if equipped weapon is not fists
		if( ! gameHero.getEquippedWeapon().getName().equalsIgnoreCase("fists"))
		{
			equippedItems.add(gameHero.getEquippedWeapon());
		}
		
		// if no items equipped, return
		if(equippedItems.size() == 0)
		{
			System.out.println("\tYou have nothing equipped.");
			System.out.println();
			return;
		}
		
		boolean validInput = false;
		
		// print all options and prompt for which to unequip
		do
		{
			try
			{
				System.out.println("What would you like to remove?");
				
				// print all options
				for(int i = 0; i < equippedItems.size(); i++)
				{
					System.out.println( (i + 1) + ". " + equippedItems.get(i).getName());
				}
				
				int userChoice = GameInput.getInt();
				
				// decrement user choice for zero index
				userChoice = userChoice - 1;
				
				if(userChoice >= 0 && userChoice < equippedItems.size())
				{
					validInput = true;
					
					Artifact chosenItem = equippedItems.get(userChoice);
					
					if(chosenItem instanceof Weapon)
					{
						gameHero.unequipWeapon();
					}
					else
					{
						gameHero.unequipArmor();
					}
					
					System.out.println("\tYou unequip your " + chosenItem.getName() + ".");
				}
				else 
				{
					// not valid input
					throw new IOException();
				}
				
			}
			catch(IOException ioe)
			{
				System.out.println("\tYou mutter to yourself, trying to remember what you wanted to do...");
				System.out.println();
			}
		} while( ! validInput);
		
	}

	/**
	 * Prompts the user to specify which item they would like to equip.
	 * @throws IOException
	 */
	public void equipItem() throws IOException 
	{
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		ArrayList<InventoryItem> temp = new ArrayList<InventoryItem>();
		
		//add all armor and weapons to the temp array list
		for(int i = 0; i <items.size();i++)
		{
			if(items.get(i).getItem() instanceof Weapon || items.get(i).getItem() instanceof Armor)
			{
				temp.add(items.get(i));
			}
			
		}
		//if temp is empty get out of the method
		if(temp.isEmpty())
		{
			System.out.println("\t You lack things to equip!");
			System.out.println();
			return;
		}
		
		System.out.println("Which item would you like to equip");
		
		// output all of the armor and weapons to the user
		for(int i =0; i < temp.size(); i++)
		{
			System.out.println((i) + ". " +items.get(i).getItem().getName());
		}
		int input = GameInput.getInt();

		if(input >= 0 && input < temp.size())
		{
			if(temp.get(input).getItem() instanceof Weapon)
			{
				if(Game.getHero().getEquippedWeapon().getName().equals("Fists"))
				{
					Game.getHero().setEquippedWeapon((Weapon) temp.get(input).getItem());
					Game.getHero().removeArtifactFromInventory(Game.getHero().getEquippedWeapon());
					System.out.println("\t You feel stronger after equipping " + Game.getHero().getEquippedWeapon().getName());
					System.out.println();
				}
				else
				{
					System.out.println("\t You remember the words of your mentor,"
							+ "\tto get you have to give. Try unequipping before you equip.");
					System.out.println();
				}
			}
			
			else 
			{
				if(Game.getHero().getEquippedArmor() == null)
				{
					Game.getHero().setEquippedArmor((Armor) temp.get(input).getItem());
					Game.getHero().removeArtifactFromInventory(Game.getHero().getEquippedArmor());
					System.out.println("\t You feel safer after equipping " + Game.getHero().getEquippedArmor().getName());
					System.out.println();
				}
				else
				{
					System.out.println("\t You remember the words of your mentor"
							+ "\t To get you gotta give. Try unequipping before you equip.");
					System.out.println();
				}
			}

		}
		else
		{
			System.out.println("You mutter to yourself");
			System.out.println();
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
		for(int i =0;i < items.size();i++)
		{
			System.out.println(i + ". " + items.get(i).getItem().getName());
		}
		int input = GameInput.getInt();


		if(input >=0 && input < items.size())
		{
			if(items.get(input).getItem() instanceof Weapon)
			{
				System.out.println("\t How does one use a weapon out in combat?");
				System.out.println();
			}
			else if(items.get(input).getItem() instanceof Armor)
			{
				System.out.println("\t How does one use armor out of combat?");
				System.out.println();
			}
			else if(items.get(input).getItem() instanceof Consumable)
			{
				Consumable use = (Consumable) items.get(input).getItem();
				Game.getHero().useConsumable(use);
				System.out.println("\t You feel your wounds melt away as if by magic."
						+ "\t Not bad for something you found on the floor!");
				System.out.println();
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
					System.out.println(toString());
				}
				else if(input.equals("2"))
				{
					unEquipItem();
					System.out.println(toString());

				}
				else if(input.equals("3"))
				{
					dropItem();
					System.out.println(toString());
				}
				else if(input.equals("4"))
				{
					viewItem();
					System.out.println(toString());
				}
				else if(input.equals("5"))
				{
					useItem();
					System.out.println(toString());
				}
				else if(input.equals("6"))
				{
					inInventory = false;
					System.out.println("\tYou close your bag, standing back up.");
					System.out.println();
					MenuLoader.loadGameMenu(this);
				}
				else
				{
					System.out.println(input + " is utter nonsense");
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
