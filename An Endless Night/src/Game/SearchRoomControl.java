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
			System.out.println(x.getDescription());
		}
			
		
		
	}

}
