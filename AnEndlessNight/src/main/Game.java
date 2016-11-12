
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
 * @author Aaron
 *
 */
public final class Game implements Serializable
{
	private static Game game;
	private ArrayList<Room> rooms;
	private Hero hero;
	private int score;
	private Journal journal;

	private Game(ArrayList<Room> rooms, Hero hero)
	{
		this.rooms = rooms;
		this.hero = hero;
		this.score = 0;
		this.journal = new Journal();
	}

	/**
	 * Returns the hero associated with this game.
	 * 
	 * @return The hero associated with this game.
	 */
	public static Hero getHero() 
	{
		return game.hero;
	}
	
	/**
	 * Initializes the game. If the game does not exist, it creates a new one.
	 * If the game is already in existence, returns false.
	 * 
	 * @return True if the game was initialized. False if a game already exists.
	 */
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
	
	/**
	 * Get the room objects (in their current state) of all the rooms in this 
	 * Game. This is read-only, it's contents cannot be modified.
	 * 
	 * @return A copy of the rooms for this Game.
	 */
	public static ArrayList<Room> getRooms() 
	{
		return new ArrayList<Room>(game.rooms);
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

	/**
	 * Gets the current score.
	 * 
	 * @return The current score for this game.
	 */
	public static int getScore() 
	{
		return game.score;
	}
	
	/**
	 * Increments score by the given amount. If the amount given is negative,
	 * does not do anything.
	 * 
	 * @param points The points to increment by.
	 */
	public static void incrementScore(int points)
	{
		if(points <= 0)
		{
			return;
		}
		game.score += points;
	}
	
	/**
	 * Gets the Journal for modification and reading.
	 * 
	 * @return The journal for this hero.
	 */
	public static Journal getJournal()
	{
		return game.journal;
	}
	
	/***
	 * Resets the game.
	 */
	public static void reset() 
	{
		game = null;
	}
}
