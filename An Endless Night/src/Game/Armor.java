package Game;

public class Armor extends Artifact 
{
	private int defense;

	public Armor(String name, String description, int artifactID, int defense) 
	{
		super(name, description, artifactID);
		this.defense = defense;
	}

	public int getDefense() 
	{
		return defense;
	}

}
