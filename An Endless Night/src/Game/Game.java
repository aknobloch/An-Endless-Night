package Game;

import java.util.ArrayList;

public class Game {

	private ArrayList<Room> rooms = new ArrayList<>();

	private Hero hero;

	public Game(ArrayList<Room> rooms, Hero hero)
	{
		this.rooms = rooms;
		this.hero = hero;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;

	}

	public Hero getHero() {
		return hero;

	}

}
