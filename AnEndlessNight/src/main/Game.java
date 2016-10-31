
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import main.CombatSystem.Hero;
import main.RoomSystem.Room;

public final class Game 
{

	private static Game game;
	private ArrayList<Room> rooms;
	private Hero hero;
	private static int score;

	private Game(ArrayList<Room> rooms, Hero hero)
	{
		this.rooms = rooms;
		this.hero = hero;
		score = 0;
	}

	public static Hero getHero() 
	{
		return game.hero;
	}
	
	public static boolean initializeGame() 
	{
		
		if(game == null) 
		{
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
	
	public static boolean loadGame(String file) throws Exception
	{
		Hero h1;
		ArrayList<Room> rooms;
		if(game != null) throw new Exception();
		ObjectInputStream input;
		try 
		{
			input = new ObjectInputStream(new FileInputStream(file));
			h1  = (Hero) input.readObject();
			rooms = (ArrayList<Room>) input.readObject();
			game = new Game(rooms,h1);
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

	public void setScore(int score) 
	{
		this.score = score;
	}

}
