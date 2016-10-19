package Game;


public class Artifact 
{
	private String Name;
	private String Description;
	private int ArtifactID;
	
	public Artifact(String name, String description, int artifactID) 
	{
		Name = name;
		Description = description;
		ArtifactID = artifactID;
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
