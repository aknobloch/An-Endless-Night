package Game;

import java.util.ArrayList;

public class GameMenu 
{
	
	private Game game;
	private String description;
	
	public GameMenu(Game game)
	{
		description = "Please Enter a number based on your Command \n"
				+ "1. Search Room \n"
				+ "2. Move Rooms \n"
				+ "3. View Inventory \n"
				+ "4. View Score \n"
				+ "5. View Help \n";
		
		this.game = game;
	}
	
	public String toString()
	{
		return description;
	}
	
	public void searchRoom()
	{
		SearchRoomControl.searchRoom();
	}
	
	public void changeRooms(Room x)
	{
		ChangeRoomControl.changeRoom();
	}
}
