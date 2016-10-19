package Game;

import java.util.ArrayList;

public class Door 
{

	private ArrayList<Integer> connectedRooms = new ArrayList<Integer>();
	private int doorID;
	
	public Door(ArrayList<Integer> connectedRooms, int doorID) 
	{
		this.connectedRooms = connectedRooms;
		this.doorID = doorID;
	}

	public ArrayList<Integer> getConnectedRooms() 
	{
		return connectedRooms;
	}

	public int getDoorID() 
	{
		return doorID;
	}

}
