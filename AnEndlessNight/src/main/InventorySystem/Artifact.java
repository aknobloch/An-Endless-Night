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
	
	/**
	 * Creates an Artifact object
	 * @param name
	 * @param description
	 * @param artifactID
	 * @param puzzleID
	 */
	public Artifact(String name, String description, int artifactID, int puzzleID) 
	{
		Name = name;
		Description = description;
		ArtifactID = artifactID;
		PuzzleID = puzzleID;
	}

	/**
	 *  Gets the puzzleID attribute
	 * @return The puzzleID
	 */
	public int getPuzzleID() {
		return PuzzleID;
	}

	/**
	 * gets the Name attribute of the artifact. 
	 * @return The name of the Artifact
	 */
	public String getName() 
	{
		return Name;
	}

	/**
	 * gets the Artifact description
	 * @return 
	 */
	public String getDescription() 
	{
		return Description;
	}
	
	/**
	 * Gets the ArtifactID of the artifact
	 * @return
	 */
	public int getArtifactID() 
	{
		return ArtifactID;
	}
	
	/**
	 * Determines if two artifacts are the same 
	 * @param inItem
	 * @return
	 */
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
