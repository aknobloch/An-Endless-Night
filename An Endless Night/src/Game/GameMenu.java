package Game;

import java.util.ArrayList;

public class GameMenu {
	
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
	
	public void searchRoom(Room x)
	{
		System.out.println(x.getDescription());
		System.out.println("The you notice the following items in this room ");
		
		for(int i = 0; i < x.getArtifact().size();i++)
		{
			System.out.println(x.getArtifact().get(i).getName());
		}
	}
	
	public void changeRooms(Room x)
	{
		ArrayList<Door> doors = x.getDoors();
		
	}
}
