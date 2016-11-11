package main.InventorySystem;


import java.io.Serializable;

/**
 * author: Estephanie Gonzalez, Jory Alexander, Caleb Sears
 */

public class Artifact implements Serializable
{
	private String Name;
	private String Description;
	private int ArtifactID;
	private int PuzzleID;
	
	public Artifact(String name, String description, int artifactID, int puzzleID) 
	{
		Name = name;
		Description = description;
		ArtifactID = artifactID;
		PuzzleID = puzzleID;
	}

	public int getPuzzleID() {
		return PuzzleID;
	}

	public String getName() 
	{
		return Name;
	}

	public String getDescription() 
	{
		return Description;
	}

	public int getArtifactID() 
	{
		return ArtifactID;
	}
	
	public boolean equals(Artifact inItem) 
	{
		
		if(this.ArtifactID == inItem.ArtifactID) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
