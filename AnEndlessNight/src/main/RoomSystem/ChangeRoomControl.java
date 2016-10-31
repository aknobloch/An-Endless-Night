package main.RoomSystem;

import java.util.ArrayList;

import main.Game;

public class ChangeRoomControl 
{
	public static boolean changeRoom(String destination)
	{
		ArrayList<Room> rooms = Game.getRooms();
		
		for(Room x : rooms)
		{
			if(x.getName().equals(destination))
			{
				Game.getHero().setLocation(x);
				if(x.getMonster()!= null)
				{
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	

}
