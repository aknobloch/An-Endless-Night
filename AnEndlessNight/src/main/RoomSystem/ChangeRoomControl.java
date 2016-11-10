package main.RoomSystem;

import java.util.ArrayList;

import main.Game;

/**
 * author: Jory Alexander
 */

public class ChangeRoomControl 
{
	public static boolean changeRoom(String destination)
	{
		ArrayList<Room> rooms = Game.getRooms();
		
		for(Room x : rooms)
		{
			if(x.getName().equals(destination))
			{
				Game.getHero().setLastRoom(Game.getHero().getRoom());
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
