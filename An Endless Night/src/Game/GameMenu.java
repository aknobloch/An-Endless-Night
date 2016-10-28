package Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameMenu 
{

	
	private String description;

	public GameMenu()
	{
		description = "Please Enter a number based on your Command \n"
				+ "1. Search Room \n"
				+ "2. Move Rooms \n"
				+ "3. View Inventory \n"
				+ "4. View Score \n"
				+ "5. View Help \n";

		
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

	public void changeRooms()
	{
		ArrayList<Door> doors = Game.getHero().getRoom().getDoors();
		Set<Room> room = new HashSet<Room>();
		for(Door potentials: doors)
		{
			room.addAll(potentials.getConnectedRooms());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Which room would you like to move to? \n"
				+ "please math the name of the room");
		for(Room x: room)
		{
			System.out.println(x.getName());
		}
		String choice = input.next();
		
		ChangeRoomControl.changeRoom(choice);
		input.close();
	}

	public void showScore()
	{
		System.out.println("Your current score is: " + Game.getScore());
	}

}
