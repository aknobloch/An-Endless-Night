package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {
	
	private String menu;
	
	public StartMenu()
	{
		menu = "Please Enter A number based on your command \n"
				+ "1. Start New Game \n"
				+ "2. Load Game \n"
				+ "3. Exit System";
	}
	
	// TODO Make A populated arrayList of rooms 
	public Game startNewGame()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		Hero h1 = new Hero();
		Game g1 = new Game(rooms, h1);
		return g1;
	}
	
	public Game loadGame()
	{
		ObjectInputStream input;
		Game g1 = startNewGame();
		try {
			input = new ObjectInputStream(new FileInputStream("Endless.dat"));
			
			while(true)
			{
				g1 = (Game) input.readObject();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There is no Endless Knight Save Data on this Computer a new game will be created for you");
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Thats a bummur your save data is corrupt a new game will be created for you");
		}
		
		return g1;
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
