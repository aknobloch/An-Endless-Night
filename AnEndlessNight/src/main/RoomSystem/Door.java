package main.RoomSystem;

import java.io.Serializable;
import java.util.ArrayList;

import main.Game;

/**
 * 
 * @author Jory Alexander, Estephanie Gonzalez
 *
 */

public class Door implements Serializable
{

	private ArrayList<Integer> connectedRooms = new ArrayList<Integer>();
	private int doorID;
	
	public Door(ArrayList<Integer> connectedRooms, int doorID) 
	{
		this.connectedRooms = connectedRooms;
		this.doorID = doorID;
	}
	
	public int getDoorID() 
	{
		return doorID;
	}
	
	public ArrayList<Room> getConnectedRooms()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		for(int roomId : connectedRooms) {
			
			for(Room focusRoom : Game.getRooms()) {
				
				if(focusRoom.getRoomID() == roomId) {
				
					rooms.add(focusRoom);
					
				}
			}
		}
		
		return rooms;
	}
}
