package main.RoomSystem;

import java.util.ArrayList;

import main.Game;
import main.InventorySystem.Artifact;

public class SearchRoomControl 
{
	// TODO: Throws null pointer if no artifacts are in room.
	// 		 Needs to handle, and notify GameMenu/User if no artifacts in room. 
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
