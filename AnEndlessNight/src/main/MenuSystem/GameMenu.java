package main.MenuSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import main.Game;
import main.RoomSystem.ChangeRoomControl;
import main.RoomSystem.Door;
import main.RoomSystem.Room;
import main.RoomSystem.SearchRoomControl;

public class GameMenu extends AbstractMenu
{
	public GameMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	private String description;

	public String toString()
	{
		return "Please Enter a number based on your Command \n"
				+ "1. Search Room \n"
				+ "2. Move Rooms \n"
				+ "3. View Inventory \n"
				+ "4. View Score \n"
				+ "5. View Help \n"
				+ "6. Save Game \n"
				+ "7. View Journal \n"
				+ "8. Exit Game \n";
	}

	public void searchRoom()
	{
		ArrayList<String> descriptions = SearchRoomControl.searchRoom();
		
		System.out.println(descriptions.get(0));
		System.out.println();
		// if there are items, print items list
		if(descriptions.size() >= 1) {
			System.out.println("You notice the following items:");
			for(int i = 1; i < descriptions.size();i++)
			{
				System.out.println(descriptions.get(i));
			}
		}
		// otherwise...
		else 
		{
			System.out.println("There doesn't appear to be anything else notable.");
		}
	}

	public boolean changeRooms()
	{
		ArrayList<Door> doors = Game.getHero().getRoom().getDoors();
		Set<Room> room = new HashSet<Room>();
		boolean isMonster = false;
		for(Door potentials: doors)
		{
			room.addAll(potentials.getConnectedRooms());
		}
		System.out.println("Which room would you like to move to? \n"
				+ "please type the name of the room");
		// TODO: No confirmation or error message. Text based input leaves 
		// lots of errors like misspelling, typo or case sensitivities. Probably best
		// to have a list of options. Option 1, 2, 3, etc.
		for(Room x: room)
		{
			System.out.println(x.getName());
		}
		String choice;
		try 
		{
			choice = GameInput.getString();
			isMonster = ChangeRoomControl.changeRoom(choice);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Invalid input");
		}
		return isMonster;
	}
	/**
	 * opens the inventory menu
	 */
	public void openInventory() {}
	
	public void help() 
	{
		System.out.println("In order to input to the game enter the number next"
				+ "to the option that you would like to perform");
	}

	public void showScore()
	{
		System.out.println("Your current score is: " + Game.getScore());
	}
	
	public void exitGame() 
	{
		System.exit(0);
	}

	public void saveGame() 
	{
		String input = "";
		
		System.out.println("What would you like to name your save file?");
		try 
		{
			input = GameInput.getString();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Invalid Input");
			return;
		}
		input = input +".dat";
		
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(input));
			
			out.writeObject(Game.getHero());
			out.writeObject(Game.getRooms());
			out.writeInt(Game.getScore());
			out.writeObject(Game.getJournal());
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	void mainPrompt() 
	{
		System.out.println(toString());
		
		String input;
		boolean check = true;
		while(check)
		{
			try 
			{
				input = GameInput.getString();
			
				if(input.equals("1"))
				{
					searchRoom();
					
				}
				else if(input.equals("2"))
				{
				 	boolean isMonster = changeRooms();
				
				 	if(isMonster)
				 		{
				 			check = false;
				 			MenuLoader.loadCombatMenu(this);
				 		}
				}
				else if(input.equals("3"))
				{
					check = false;
					MenuLoader.loadInventoryMenu(this);
				}	
				else if(input.equals("4"))
				{
					showScore();
				}
				else if(input.equals("5"))
				{
					help();
					;
				}
				else if(input.equals("6"))
				{
					saveGame();
					;
				}
				else if(input.equals("7"))
				{
					check = false;
					MenuLoader.loadJournalMenu(this);
				}
				else if(input.equals("8"))
				{
					check = false;
					exitGame();
				}
			} catch (IOException e) 
			{
				System.out.println("You mumble to yourself.");
			}
		}
	}

	@Override
	void onDestroy() {}
}
