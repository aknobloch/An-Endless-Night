package Game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameMenu extends AbstractMenu
{

	
	private String description = 
			"Please Enter a number based on your Command \n"
			+ "1. Search Room \n"
			+ "2. Move Rooms \n"
			+ "3. View Inventory \n"
			+ "4. View Score \n"
			+ "5. View Help \n"
			+ "6. Save Game \n"
			+ "7. Exit Game \n";

	public GameMenu(AbstractMenu callingMenu)
	{
		super(callingMenu);

		
	}

	public String toString()
	{
		return description;
	}

	public void searchRoom()
	{
		ArrayList<String> descriptions = SearchRoomControl.searchRoom();
		
		System.out.println(descriptions.get(0));
		System.out.println();
		System.out.println("You notice the following items:");
		for(int i = 1; i < descriptions.size();i++)
		{
			System.out.println(descriptions.get(i));
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
				+ "please math the name of the room");
		for(Room x: room)
		{
			System.out.println(x.getName());
		}
		String choice;
		try {
			choice = GameInput.getString();
			isMonster = ChangeRoomControl.changeRoom(choice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input");
		}
		return isMonster;
		
		
	}
	/**
	 * opens the inventory menu
	 */
	public void openInventory() {
		new InventoryMenu(this);
		
	}
	
	public void help() {
		System.out.println("In order to input to the game enter the number next"
				+ "to the option that you would like to perform");
		
	}

	public void showScore()
	{
		System.out.println("Your current score is: " + Game.getScore());
	}
	
	public void exitGame() {
		System.exit(0);
		
	}

	private void saveGame() {
		String input = "";
		
		System.out.println("What would you like to name your save file?");
		try {
			input = GameInput.getString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Input");
			return;
		}
		input = input +".dat";
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(input));
			
			out.writeObject(Game.getHero());
			out.writeObject(Game.getRooms());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void mainPrompt() {

		System.out.println(toString());
		
		String input;
		
		try {
			input = GameInput.getString();
			
			if(input.equals("1"))
			{
				searchRoom();
				new GameMenu(this);
			}
			else if(input.equals("2"))
			{
				 boolean isMonster = changeRooms();
				
				if(isMonster)
				{
					new CombatMenu(this);
				}
				else
				{
					new GameMenu(this);
				}
			}
			else if(input.equals("3"))
			{
				openInventory();
			}
			else if(input.equals("4"))
			{
				showScore();
				new GameMenu(this);
			}
			else if(input.equals("5"))
			{
				help();
				new GameMenu(this);
			}
			else if(input.equals("6"))
			{
				saveGame();
				new GameMenu(this);
			}
			else if(input.equals("7"))
			{
				exitGame();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("You entered bad input");
		}
		
	}


	

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		
	}

}
