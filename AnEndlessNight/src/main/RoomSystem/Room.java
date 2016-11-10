package main.RoomSystem;

import java.io.Serializable;
import java.util.ArrayList;

import main.CombatSystem.Monster;
import main.InventorySystem.Artifact;

/**
 * author: Estephanie Gonzalez, Jory Alexander
 */

public class Room implements Serializable 
{
	private String description;
	private ArrayList<Door> doors = new ArrayList<Door>();
	private int roomID;
	private boolean visited;
	private String name;
	private Puzzle puzzle;
	private Monster monster;
	private ArrayList<Artifact> artifactList;

	public Room(String description, ArrayList<Door> doors, int roomID, boolean visited, String name, 
			Puzzle puzzle, Monster monster, ArrayList<Artifact> artifacts) 
	{
		this.description = description;
		this.doors = doors;
		this.roomID = roomID;
		this.visited = visited;
		this.name = name;
		this.puzzle = puzzle;
		this.monster = monster;
		this.artifactList = artifactList;
	}

	public Monster getMonster() 
	{
		return monster;
	}

	public void setMonster(Monster monster) 
	{
		this.monster = monster;
	}

	public Puzzle getPuzzle() 
	{
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) 
	{
		this.puzzle = puzzle;
	}

	public String getDescription() 
	{
		return description;
	}

	public ArrayList<Door> getDoors() 
	{
		return doors;
	}

	public ArrayList<Artifact> getArtifactList() 
	{
		return artifactList;
	}

	public int getRoomID() 
	{
		return roomID;
	}

	public boolean getVisited() 
	{
		return visited;
	}

	public void setVisited(boolean visited) 
	{
		this.visited = visited;
	}

	public String getName() 
	{
		return name;
	}
}
