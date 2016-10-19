package Game;

import java.util.ArrayList;

public class SearchRoomControl 
{
	
	public static void searchRoom()
	{
		ArrayList<Room> r1 = Game.getRooms();
		int location = Game.getHero().getLocation();
		for(int i = 0;i < r1.size();i++)
		{
			if(location == r1.get(i).getRoomID())
			{
				System.out.println(r1.get(i).getDescription());
				
				ArrayList<Artifact> items = r1.get(i).getArtifact();
				
				System.out.println("You notice the following artifacts: ");
				
				for(int j = 0; j< items.size();j++)
				{
					System.out.println(items.get(i).getName());
				}
				break;
			}
		}
		
	}

}
