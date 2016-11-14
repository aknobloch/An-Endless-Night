package main.RoomSystem;

import java.util.ArrayList;

import main.Game;
import main.InventorySystem.Artifact;

/**
 * 
 * @author Jory Alexander
 *
 */
public class SearchRoomControl 
{		
	public static ArrayList<String> searchRoom()
	{
		Room location = Game.getHero().getRoom();
		ArrayList<Artifact> artifacts = location.getArtifactList();
		
		ArrayList<String> descriptions = new ArrayList<>();
		
		descriptions.add(location.getDescription());
		
		if(artifacts != null) 
		{
			for(Artifact x: artifacts)
			{
				descriptions.add(x.getName());
			}
		}
		return descriptions;
	}
}
