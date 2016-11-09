package main.InventorySystem;

public class KeyArtifact extends Artifact 
{
	private int puzzleID;
	private boolean isKey;

	public KeyArtifact(String name, String description, int artifactID, int puzzleID, boolean isKey) 
	{
		super(name, description, artifactID);
		this.puzzleID = puzzleID;
		this.isKey = isKey;
	}

	public int getPuzzleID() 
	{
		return puzzleID;
	}

	public boolean isKey() 
	{
		return isKey;
	}
}
