package main.RoomSystem;

import java.util.ArrayList;

import main.Game;

/**
 * 
 * @author Jory Alexander, Estephanie Gonzalez
 *
 */

public class Door 
{

	private ArrayList<Integer> connectedRooms = new ArrayList<Integer>();
	private int doorID;
	//private boolean locked;
	
	public Door(ArrayList<Integer> connectedRooms, int doorID) 
	{
		this.connectedRooms = connectedRooms;
		this.doorID = doorID;
	}

	public ArrayList<Integer> getConnectedRoomId() 
	{
		return connectedRooms;
	}

	public int getDoorID() 
	{
		return doorID;
	}
	
	public ArrayList<Room> getConnectedRooms()
	{
		ArrayList<Integer> ids = getConnectedRoomId();
		ArrayList<Room> gameRooms = Game.getRooms();
		ArrayList<Room> connectedRooms = new ArrayList<Room>();
		for(Integer x: ids)
		{
			for(Room y: gameRooms)
			{
				if(y.getRoomID() == x)
				{
					connectedRooms.add(y);
				}
			}
		}
		return connectedRooms;
	}
}
