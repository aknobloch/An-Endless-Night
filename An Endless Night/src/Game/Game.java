package Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public final class Game {

	private static Game game;
	private ArrayList<Room> rooms;
	private Hero hero;

	private Game(ArrayList<Room> rooms, Hero hero)
	{
		this.rooms = rooms;
		this.hero = hero;
	}

	public static Hero getHero() {
		return game.hero;
	}
	
	public static boolean initializeGame(ArrayList<Room> rooms, Hero hero) {
		
		if(game == null) {
			game = new Game(rooms, hero);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static ArrayList<Room> getRooms() {
		
		return game.rooms;
		
	}
	
	public static boolean loadGame() throws Exception
	{
		if(game != null) throw new Exception();
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(new FileInputStream("Endless.dat"));
			
			while(true)
			{
				game = (Game) input.readObject();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There is no Endless Knight Save Data on this Computer a new game will be created for you");
			return false;
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Thats a bummur your save data is corrupt a new game will be created for you");
			return false;
		}
		return true;
		
	}

}
