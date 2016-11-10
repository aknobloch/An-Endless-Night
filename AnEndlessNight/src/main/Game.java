
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import main.CombatSystem.Hero;
import main.InventorySystem.ArtifactFactory;
import main.InventorySystem.Journal;
import main.RoomSystem.Room;
import main.RoomSystem.RoomLibrary;
/**
 * 
 * @author Aaron and Jory
 *
 */
public final class Game implements Serializable
{
	private static Game game;
	private ArrayList<Room> rooms;
	private Hero hero;
	private static int score;
	private static Journal journal;

	private Game(ArrayList<Room> rooms, Hero hero)
	{
		this.rooms = rooms;
		this.hero = hero;
		score = 0;
		journal = new Journal();
	}

	public static Hero getHero() 
	{
		return game.hero;
	}
	
	public static boolean initializeGame() 
	{
		if(game == null) 
		{
			ArtifactFactory.initializeArtifacts();
			ArrayList<Room> newMap = RoomLibrary.roomGen();
			Hero newHero = new Hero();
			newHero.teleport(newMap.get(0));
			
			game = new Game(newMap, newHero);
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static ArrayList<Room> getRooms() 
	{
		return game.rooms;
	}
	
	/**
	 * Writes a file with the given filename.
	 * @param fileName The name of the file to write.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveGame(String fileName) throws FileNotFoundException, IOException
	{
		// TODO: Check if file with name already exists.
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".gsave"));
		out.writeObject(game);
		out.close();
	}
	
	/**
	 * Loads the game passed in.
	 * @param saveFile The file location of the game to load.
	 * 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void loadGame(File saveFile) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(saveFile));
		game = (Game) in.readObject();
		in.close();
		
	}

	public static int getScore() 
	{
		return score;
	}

	public static void setScore(int newScore) 
	{
		score = newScore;
	}
	
	public static Journal getJournal()
	{
		return journal;
	}
	
	public static void setJournal(Journal x)
	{
		journal = x;
	}
	
	public Game getGame()
	{
		return this;
	}
}
