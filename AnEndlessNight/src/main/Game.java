
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
			newHero.setLocation(newMap.get(0));
			
			game = new Game(newMap, newHero);
			return true;
		}
		else {
			return false;
		}
	}
	
	public static ArrayList<Room> getRooms() 
	{
		
		return game.rooms;
		
	}
	
	public static boolean loadGame(String file) throws Exception
	{
		Hero h1;
		ArrayList<Room> rooms;
		Journal oldJournal;
		if(game != null) throw new Exception();
		ObjectInputStream input;
		try 
		{
			input = new ObjectInputStream(new FileInputStream(file));
			h1  = (Hero) input.readObject();
			rooms = (ArrayList<Room>) input.readObject();
			oldJournal = (Journal) input.readObject();
			game = new Game(rooms,h1);
			score = input.readInt();
			setScore(score);
			setJournal(oldJournal);
		} catch (FileNotFoundException e) 
		{
			System.out.println("There is no Endless Knight Save Data on this Computer a new game will be created for you");
			return false;
		} catch (IOException e) 
		{
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Thats a bummer your save data is corrupt a new game will be created for you");
			return false;
		}
		return true;
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
