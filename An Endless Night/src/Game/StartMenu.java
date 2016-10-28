package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu extends AbstractMenu
{
	private String menu = "Please Enter A number based on your command \n"
				+ "1. Start New Game \n"
				+ "2. Load Game \n"
				+ "3. Exit System";
	
	public StartMenu(AbstractMenu callingMenu)
	{
		super(callingMenu);
	}
	// TODO Make A populated arrayList of rooms 
	public void startNewGame()
	{
		Game.initializeGame();
	}
	
	public void loadGame() throws Exception
	{
		System.out.println("Please enter the name of the name of your save file");
		String file = GameInput.getString();
		boolean x = Game.loadGame(file);
		
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

	public void mainPrompt()
	{
		System.out.println(toString());
		
		String input;
		boolean check = false;
		
		
		try {
			input = GameInput.getString();
			
			if(input == "1")
			{
				startNewGame();
				new MainMenu(this);
			}
			else if(input == "2")
			{
				loadGame();
				new MainMenu(this);
			}
			else if(input == "3")
			{
				exitGame();
			}
			else
			{
				System.out.println("Your input did not match one of our options"
						+ "please try agian");
				mainPrompt();
			}
		} catch (IOException e) {
			System.out.println("You entered bad data");
		}
		
		
	}

	@Override
	public void onDestroy() {
		System.out.println("we need to put the back story here if you are reading this we did not put in a back story");
		
	}

}
