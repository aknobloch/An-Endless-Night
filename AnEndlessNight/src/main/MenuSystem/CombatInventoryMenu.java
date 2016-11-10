package main.MenuSystem;

import java.io.IOException;
import java.util.ArrayList;

import main.Game;
import main.InventorySystem.Consumable;
import main.InventorySystem.InventoryItem;

public class CombatInventoryMenu 
{
	public static void openMenu() 
	{
		int userInput;
		boolean validInput = false;
		
		// populate an array of consumables
		ArrayList<Consumable> consumableList = new ArrayList<>();
		for(InventoryItem item : Game.getHero().getPlayerInventory()) 
		{
			if(item.getItem() instanceof Consumable) 
			{
				consumableList.add((Consumable)item.getItem());
			}
		}
		
		// break and return if no consumables
		if(consumableList.size() <= 0) 
		{
			System.out.println("You have no available consumable items.");
			System.out.println();
			return;
		}
		
		// prompt user for which item to use
		while( ! validInput ) 
		{
			System.out.println("Which item would you like to use?");
			for(int i = 0; i < consumableList.size(); i++) 
			{
				System.out.println((i+1) + ". " + consumableList.get(i).getName());
				// after the last item, print final option to return
				if(i == consumableList.size() - 1) 
				{
					System.out.println((i+2) + ". Return to combat");
				}
			}
			
			try 
			{
				userInput = GameInput.getInt();
				
				// if they chose one more than the list size, then they chose to return to combat
				if(userInput == consumableList.size() + 1) 
				{
					validInput = true;
					return;
				}
				else if(userInput > 0 && userInput <= consumableList.size())
				{
					// decrement by one to make up for index offset
					userInput = userInput - 1;
					Game.getHero().useConsumable(consumableList.get(userInput));
					validInput = true;
					return;
				}
				else 
				{
					throw new IOException();
				}
			} 
			catch (IOException e) 
			{
				System.out.println("You mumble incoherently. You should be wary of nonsensical babbling, ");
				System.out.println("else you be labeled insane.");
				System.out.println();
			}
		}
	}
}
