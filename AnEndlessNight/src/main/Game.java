
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
import main.CombatSystem.StatusCondition;
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
	// keeps track if user has seen past kitsunes disguise yet.
	public static boolean solvedKitsune = false;

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
			
			newHero.teleport(newMap.get(1));
			
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

	/**
	 * Activates cheat mode.
	 */
	public static void godMode() 
	{
		game.hero.godMode(game);
	}

	public static void mortalMode() 
	{
		game.hero.mortalMode(game);
	}

	public static void printHelp() {
		
		System.out.println("******~~~~~------------------MENU INFORMATION------------------~~~~~******");
		System.out.println("\n");
		/*
		 * MENU INFORMATION GOES HERE
		 */
		
		System.out.println("Start Menu:");
		System.out.println();
		System.out.println("\tThe start menu is the first menu encountered when starting the");
		System.out.println("\tgame. It allows the player to start a new game or load a previously");
		System.out.println("\tsaved game.");
		System.out.println("\n");
		
		System.out.println("Game Menu:");
		System.out.println();
		System.out.println("\tThe game menu is the main hub of An Endless Night,");
		System.out.println("\tand provides the player with the means for navigating");
		System.out.println("\tthe world. It allows the user to move and search rooms,");
		System.out.println("\tview their player and hero's status, as well as save and");
		System.out.println("\texit their game. It also serves as the sole entry point");
		System.out.println("\tfor the Inventory Menu as well as the Journal Menu.");
		System.out.println("\n");
		
		System.out.println("Combat Menu:");
		System.out.println();
		System.out.println("\tThe combat menu is the only menu accessible to the player");
		System.out.println("\twhile currently enganged in combat. It allows the player to");
		System.out.println("\tattack a monster, brace themselves for an attack, attempt to");
		System.out.println("\tflee the encounter (taking them to the previous room), and to");
		System.out.println("\tuse any consumable items.");
		System.out.println("\n");
		
		System.out.println("Inventory Menu:");
		System.out.println();
		System.out.println("\tThe inventory menu is the menu responsible for allowing the");
		System.out.println("\tplayer to access and manage their hero's inventory. It allows");
		System.out.println("\tthe player to equip and unequip armors and weapons, drop items");
		System.out.println("\tinto the room, view the descriptions of items in their inventory,");
		System.out.println("\tand to use a consumable item in their inventory.");
		System.out.println("\n");
		
		System.out.println("Journal Menu:");
		System.out.println();
		System.out.println("\tThe journal menu allows the user to document their experiences");
		System.out.println("\tin the game. It can be used to keep a log of travels, and ");
		System.out.println("\tdocument anything else the player would like. It allows the player");
		System.out.println("\tto add and remove entries from the journal, as well as read");
		System.out.println("\tall entries currently in the journal.");
		System.out.println("\n");
		
		System.out.println("Puzzle Menu:");
		System.out.println();
		System.out.println("\tThe puzzle menu is the menu shown when the player encounters a puzzle.");
		System.out.println("\tIt allows them to enter in an attempt at a puzzle, as well as view a");
		System.out.println("\thint. Exiting the puzzle without completing it returns the player");
		System.out.println("\tto the previous room.");
		
		/*
		 * NOTHING GOES PAST HERE
		 */
		System.out.println("\n");
		System.out.println("******~~~~~----------------------------------------------------~~~~~******");
		
	}
}
