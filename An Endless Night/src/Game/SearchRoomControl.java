package Game;

import java.util.ArrayList;

public class SearchRoomControl 
{

	public static void searchRoom()
	{
		Room location = Game.getHero().getRoom();
		ArrayList<Artifact> artifacts = location.getArtifact();
		
		System.out.println(location.getDescription());
		
		System.out.println("The items found in this room are:");
		for(Artifact x: artifacts)
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
