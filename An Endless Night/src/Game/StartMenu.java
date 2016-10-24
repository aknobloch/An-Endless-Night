package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu 
{
	private String menu;
	
	public StartMenu()
	{
		menu = "Please Enter A number based on your command \n"
				+ "1. Start New Game \n"
				+ "2. Load Game \n"
				+ "3. Exit System";
	}
	
	// TODO Make A populated arrayList of rooms 
	public void startNewGame()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		Hero h1 = new Hero(12345,20,5,0,"Allen");
		Game.initializeGame(rooms, h1);
	}
	
	public void loadGame() throws Exception
	{
		boolean x = Game.loadGame();
		
		if(x == true)
		{
			System.out.println("Game loaded");
		}
		else
		{
			startNewGame();
		}
		
		
	}
	
	public void exitGame()
	{
		System.exit(0);
	}
	
	public String toString()
	{
		return menu;
	}

}
