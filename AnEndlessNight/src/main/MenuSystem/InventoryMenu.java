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
					+ "4. View Item in Inventory \n"
					+ "5. View Equipped Items \n"
					+ "6. Use Item \n"
					+ "7. Main Menu";
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
		// get all items the player has in its inventory
		ArrayList<InventoryItem> items = Game.getHero().getPlayerInventory();
		//check to see if the players inventory is empty if so leave stop.
		if(items.isEmpty())
		{
			System.out.println("\t Your inventory is empty");
			return;
		}
		else
		{
			while(true)
			{
				System.out.println("Which item would you like more information on?");
				//output all of the items contained within the players inventory
				for(int i =0;i < items.size();i++)
				{
					System.out.println(i + ". " + items.get(i).getItem().getName());
				}
				// get the players input
				int input = GameInput.getInt();
				//check to see that it falls within the range of appropreate input
				if(input >=0 && input < items.size())
				{
					if(items.get(input).getItem() instanceof Weapon)
					{
						Weapon temp = (Weapon) items.get(input).getItem();
						System.out.println("\t " + temp.getDescription());
						System.out.println("\t Strength " + temp.getStrength());
						System.out.println("\t Perhaps this can be equipped for battle!");
						System.out.println();
						return;
					}
					else if(items.get(input).getItem() instanceof Armor)
					{
						Armor temp = (Armor) items.get(input).getItem();
						System.out.println("\t " + temp.getDescription());
						System.out.println("\t Defense " + temp.getDefense());
						System.out.println("\t Perhaps this can be equipped for battle!");
						System.out.println();
						return;
						
					}
					else
					{
						System.out.println("\t " + items.get(input).getItem().getDescription());
						System.out.println();
						return;
					}
				}
				else
				{
					System.out.println("\t You mutter to yourself, trying to remember what you wanted to do...");
					System.out.println();
				}
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
		
		if(items.isEmpty())
		{
			System.out.println("Your inventory is empty");
			System.out.println();
			return;
		}
		
		while(true)
		{
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
					Game.getHero().removeArtifactFromInventory(items.get(input).getItem());
					return;
				}
				else
				{	
					System.out.println("You mutter to yourself, trying to remember what you wanted to do...");
				}
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
		
		
		while(true)
		{
			System.out.println("Which item would you like to equip");
		
			// output all of the armor and weapons to the user
			for(int i =0; i < temp.size(); i++)
			{
				System.out.println((i) + ". " +temp.get(i).getItem().getName());
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
						return;
					}
					else
					{
						System.out.println("\t You remember the words of your mentor,"
								+ "\tto get you have to give. Try unequipping before you equip.");
						System.out.println();
						return;
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
						return;
					}
					else
					{
						System.out.println("\t You remember the words of your mentor"
								+ "\t To get you gotta give. Try unequipping before you equip.");
						System.out.println();
						return;
					}
				}
			
			}
			else
			{
				System.out.println("You mutter to yourself, trying to remember what you wanted to do....");
				System.out.println();
				
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
	 * Shows the heros equipped items and then displays more informaton about them. 
	 * @throws IOException 
	 */
	private void viewEquippedItems() throws IOException {
		ArrayList<Artifact> items = new ArrayList<Artifact>();
		
		if(Game.getHero().getEquippedArmor() != null)
		{
			items.add(Game.getHero().getEquippedArmor());
		}
		
		if(!Game.getHero().getEquippedWeapon().getName().equals("Fists"))
		{
			items.add(Game.getHero().getEquippedWeapon());
		}
		
		if(items.isEmpty())
		{
			System.out.println("\t You have nothing equipped.");
			System.out.println();
			return;
		}
		
		while(true)
		{
			System.out.println("Which item would you like more information on");
			
			
			for(int i = 0; i < items.size();i++)
			{
				System.out.println( i + ". " + items.get(i).getName());
			}
			
			int input = GameInput.getInt();
			
			if(input >= 0 && input < items.size())
			{
				if(items.get(input) instanceof Armor)
				{
					Armor temp = (Armor) items.get(input);
					System.out.println("\t" + temp.getDescription());
					System.out.println("\t Defense " + temp.getDefense());
					System.out.println();
					return;
				}
				else if(items.get(input) instanceof Weapon)
				{
					Weapon temp = (Weapon) items.get(input);
					System.out.println("\t" + temp.getDescription());
					System.out.println("\t Strength " + temp.getStrength());
					System.out.println();
					return;
				}
				else
				{
					System.out.println("\t Yout mutter to yourself, trying to remember what you wanted to do...");
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
					viewEquippedItems();
					System.out.println(toString());
				}
				else if(input.equals("6"))
				{
					useItem();
					System.out.println(toString());
				}
				else if(input.equals("7"))
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
