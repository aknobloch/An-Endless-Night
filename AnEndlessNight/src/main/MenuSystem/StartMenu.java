package main.MenuSystem;

import java.io.IOException;

import main.Game;
import main.GameInput;

/**
 * 
 * @author 
 *
 */
public class StartMenu extends AbstractMenu
{
	private String menu;
	
	public StartMenu(MenuLoader menuLoader)
	{
		super(menuLoader);
		menu = "Please Enter A number based on your command \n"
				+ "1. Start New Game \n"
				+ "2. Load Game \n"
				+ "3. Exit System";
		
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
		return "Please Enter A number based on your command \n"
				+ "1. Start New Game \n"
				+ "2. Load Game \n"
				+ "3. Exit System";
	}

	@Override
	public void mainPrompt()
	{    
		// IF YOU MESS WITH THIS I WILL LITERALLY KILL YOU I SPENT WAY TOO MUCH TIME ON THIS
		System.out.println("\n\n");
		System.out.println(" _______  _              _______  _        ______   _        _______  _______  _______        _       _________ _______          _________\n" +
						   "(  ___  )( (    /|      (  ____ \\( (    /|(  __  \\ ( \\      (  ____ \\(  ____ \\(  ____ \\      ( (    /|\\__   __/(  ____ \\|\\     /|\\__   __/\n" +
						   "| (   ) ||  \\  ( |      | (    \\/|  \\  ( || (  \\  )| (      | (    \\/| (    \\/| (    \\/      |  \\  ( |   ) (   | (    \\/| )   ( |   ) (   \n" +
						   "| (___) ||   \\ | |      | (__    |   \\ | || |   ) || |      | (__    | (_____ | (_____       |   \\ | |   | |   | |      | (___) |   | |   \n" +
						   "|  ___  || (\\ \\) |      |  __)   | (\\ \\) || |   | || |      |  __)   (_____  )(_____  )      | (\\ \\) |   | |   | | ____ |  ___  |   | |   \n" +
						   "| (   ) || | \\   |      | (      | | \\   || |   ) || |      | (            ) |      ) |      | | \\   |   | |   | | \\_  )| (   ) |   | |   \n" +
						   "| )   ( || )  \\  |      | (____/\\| )  \\  || (__/  )| (____/\\| (____/\\/\\____) |/\\____) |      | )  \\  |___) (___| (___) || )   ( |   | |   \n" +
						   "|/     \\||/    )_)      (_______/|/    )_)(______/ (_______/(_______/\\_______)\\_______)      |/    )_)\\_______/(_______)|/     \\|   )_(   \n" +
						   "                                                                                                                                  ");
		System.out.println("\n\n");
		System.out.println(toString());
		
		String input;
		
		try 
		{
			input = GameInput.getString();
			
			if(input.equals("1"))
			{
				startNewGame();
				MenuLoader.loadGameMenu(this);
			}
			else if(input.equals("2"))
			{
				loadGame();
				MenuLoader.loadGameMenu(this);
			}
			else if(input.equals("3"))
			{
				exitGame();
			}
			else
			{
				System.out.println("Your input did not match one of our options"
						+ "please try agian");
				mainPrompt();
			}
		} catch (IOException e) 
		{
			System.out.println("You entered bad data try agian");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Issue loaidng game");
		}
	}

	@Override
	public void onDestroy() 
	{
		System.out.println("we need to put the back story here if you are reading this we did not put in a back story");
		
	}
}
