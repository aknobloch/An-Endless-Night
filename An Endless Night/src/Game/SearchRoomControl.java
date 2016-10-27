package Game;

import java.util.ArrayList;

public class SearchRoomControl 
{

	public static ArrayList<String> searchRoom()
	{
		Room location = Game.getHero().getRoom();
		ArrayList<Artifact> artifacts = location.getArtifact();
		
		System.out.println(location.getDescription());
		
		ArrayList<String> descriptions = new ArrayList<>();
		
		descriptions.add(location.getDescription());
		
		for(Artifact x: artifacts)
		{
			descriptions.add(x.getName());
		}
		return descriptions;


	}

}
