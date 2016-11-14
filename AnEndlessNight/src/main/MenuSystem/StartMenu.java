package main.MenuSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Game;
import main.GameInput;

/**
 * Start menu allows user to start a new game, load a existing file or exit.
 * @author Aaron
 *
 */
public class StartMenu extends AbstractMenu
{
	private static final String INTRO_STORY = "\tYour eyelids struggle to open, the dried blood caking them shut.\n" +
											  "\tYou look around, the room is filled with blood and bodies.\n" +
											  "\tPulling yourself to your feet, you say a quick prayer to the Old Ones.\n" +
											  "\tYou only hope that you can find a way out of here...";
	private static boolean inMainMenu = true;
	
	public StartMenu(MenuLoader menuLoader)
	{
		super(menuLoader);
	}
	
	/**
	 * The main prompt of this menu. Displays core options.
	 */
	@Override
	public void mainPrompt()
	{    
		inMainMenu = true;
		
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
		
		
		// Reads all excess junk from stdin
		try 
		{
			while(System.in.available() > 0) 
			{
				System.in.read();
			}
		} catch (IOException e) 
		{
			// do nothing
		}
		do
		{
			try
			{
				System.out.println("What would you like to do?");
				System.out.println("1. New Game");
				System.out.println("2. Load Game");
				System.out.println("3. Exit");
				
				int userChoice = GameInput.getInt();
				
				if(userChoice == 1) 
				{
					inMainMenu = false;
					
					displayOpeningStory();

					// Reads all excess junk from stdin
					// This is neccessary because if the user just spams enter
					// through the beginning story, any excess "enters" will cause
					// an error in the main loop of this menu and cause a bunch of
					// "not valid input"'s to be printed while it reads all the
					// excess enters that the user spammed.
					try 
					{
						while(System.in.available() > 0) 
						{
							System.in.read();
						}
					} catch (IOException e) 
					{
						// do nothing
					}
					System.out.println(INTRO_STORY);
					// initialize game
					Game.initializeGame();
					// load first game menu
					MenuLoader.loadGameMenu(this);
				}
				else if(userChoice == 2)
				{
					loadGame();
				}
				else if(userChoice == 3)
				{
					System.out.println("\tThanks for playing!");
					System.exit(0);
				}
				else 
				{
					// not a valid input
					throw new IOException();
				}
				
			}
			catch(IOException ioe)
			{
				System.out.println("\tNot a valid option, please try again.");
				System.out.println();
			}
		}
		while(inMainMenu);
	}

	
	/**
	 * Searches through the root directory, adding all files with a .gsave extension. It then
	 * prompts the user to select one of the found files (if there were any). After selection
	 * it loads the game file and then launches the user into the last room menu.
	 */
	private void loadGame() 
	{
		// get the files
		File rootDirectory = new File(".");
		
		ArrayList<File> existingSaveGames = new ArrayList<>();
		
		// go through all files in root. if it is a save file, add it to list
		for(File focusFile : rootDirectory.listFiles())
		{
			if(focusFile.getName().contains(".gsave")) 
			{
				existingSaveGames.add(focusFile);
			}
		}
		
		// if none found
		if(existingSaveGames.size() == 0)
		{
			System.out.println("\tThere were no save games found. If you believe this is incorrect,");
			System.out.println("\tensure that the .gsave file is located in the root directory of the source code folder.");
			System.out.println();
			return;
		}
		
		boolean validInput = false;
		do
		{
			try
			{
				System.out.println("Which file would you like to load?");
				// first option is to go back
				System.out.println("0. Exit to main menu");
				
				// list all possible files
				for(int i = 0; i < existingSaveGames.size(); i++)
				{
					File currentFile = existingSaveGames.get(i);
					System.out.println( (i + 1) + ". " + currentFile.getName().substring(0, currentFile.getName().indexOf(".gsave")));
				}
				
				int userChoice = GameInput.getInt();
				
				// if not a valid input
				if(userChoice < 0 || userChoice > existingSaveGames.size())
				{
					throw new IOException();
				}
				
				// if user chose to exit
				if(userChoice == 0)
				{
					return;
				}
				
				// decrement to account for zero-index array.
				userChoice = userChoice - 1;
				
				// load the game from memory
				Game.loadGame(existingSaveGames.get(userChoice));
				
				// if that went succesfully....
				validInput = true;
				inMainMenu = false;
				System.out.println("\tYou rub your eyes as you slowly wake up.");
				System.out.println("\tSighing, you push yourself to your feet.");
				System.out.println("\tIf only you could find a way out of this endless labyrinth...");
				MenuLoader.loadGameMenu(this);
			} 
			catch(ClassNotFoundException cnf)
			{
				System.out.println("\tWe're sorry, that file must be corrupted.");
				return;
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("\tWe're sorry, that file must be corrupted.");
				return;
			}
			catch(IOException ioe)
			{
				System.out.println("\tNot a valid file. Please try again.");
			}
			
		} while( ! validInput);
	}

	public static void displayOpeningStory() 
	{
	
		System.out.println("\n\n");
		System.out.println("\tThe road before you must be endless.");
		System.out.println();
		
		// pause for dramatic effect!
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		
		System.out.println("\tAdjusting your bag, you pull out a drink of water to quench your thirst. The old priest ");
		System.out.println("\tahead of you, Hachiro, mutters a brief prayer to the Old Ones under his breath. ");
		System.out.println("\tHe turns to face you and the other samurai, announcing his intention to rest at the ");
		System.out.println("\tbuilding in the distance. The demons in the Akaishi mountains will still be there ");
		System.out.println("\twhen you arrive, and the samurai and other priests all need to be well rested to ");
		System.out.println("\tproperly face battle with any amount of hope for survival.");
		System.out.println();
		System.out.println("Press enter to continue.");
		System.out.println();
		
		try 
		{
			GameInput.getString();
		} catch (IOException e) 
		{
			// do nothing
		}
		
		System.out.println("\tWithin short time, your encampment arrives at the old, decrepit building. The knocking ");
		System.out.println("\tof Hachiro echoes through the otherwise still night air. You pray that the habitants have ");
		System.out.println("\talready prepared a kotatsu, for the cold winter night chills your very bones. ");
		System.out.println();
		System.out.println("Press enter to continue.");
		System.out.println();
		
		try 
		{
			GameInput.getString();
		} catch (IOException e) 
		{
			// do nothing
		}
		
		System.out.println("\tInterrupting your thoughts, the door slowly creaks open. Perhaps it is the fatigue of ");
		System.out.println("\tthe trip, but the blackness that is beyond the doors seems to creep out into the ");
		System.out.println("\tmoonlit field. A young woman, beautiful no doubt, steps forth from the darkness.");
		System.out.println("\tHer dress shimmers as if materializing before you, and her mouth smirks upward");
		System.out.println("\tin a smile. After speaking briefly with Hachiro, she introduces herself as Kitsune and");
		System.out.println("\tmotions for you and your encampment to come inside. One by one, your fellow travelers ");
		System.out.println("\tdisappear into the shadow.");
		System.out.println();
		System.out.println("Press enter to continue.");
		System.out.println();
		
		try 
		{
			GameInput.getString();
		} catch (IOException e) 
		{
			// do nothing
		}
		
		System.out.println("\tAs you step through the gate, it slams shut behind you with a deafening thud. You hear");
		System.out.println("\tKitsune let loose a blood-curdling shriek, and before you know it your encampment ");
		System.out.println("\tis surrounded by countless demons. You struggle to fight, but they are overpowering.");
		System.out.println("\tYou fight hard, but soon your wounds are too great and the color begins to fade from the world.");
		System.out.println("\tYour legs no longer support you, and your body slumps to the ground. As your vision fades,");
		System.out.println("\tyou are helpless to watch as priest and samurai alike fall dead to the demons’ power.");
		System.out.println();
		System.out.println("Press enter to continue.");
		System.out.println();
		
		try 
		{
			GameInput.getString();
		} catch (IOException e) 
		{
			// do nothing
		}
		
		System.out.println("\tDarkness envelops you…");
		System.out.println("\n\n\n\n");
		
		// pause for dramatic effect!
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
	}
	
	@Override
	public void onDestroy() 
	{}
}
