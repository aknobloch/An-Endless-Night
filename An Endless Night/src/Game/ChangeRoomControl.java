package Game;

import java.util.ArrayList;

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
