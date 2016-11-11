package main.MenuSystem;

import java.io.IOException;
import java.util.ArrayList;

import main.Game;
import main.GameInput;
import main.RoomSystem.Door;
import main.RoomSystem.Room;
import main.RoomSystem.SearchRoomControl;

/**
 * The main game menu. Allows user to perform a variety of core functions.
 * 
 * @author Aaron
 *
 */
public class GameMenu extends AbstractMenu
{
	
	// keep track of if the player is still interacting with this system.
	static boolean continuing = true;
	
	public GameMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}
	
	@Override
	void mainPrompt() {
		
		int userInput;
		continuing = true;
		
		do 
		{
			try 
			{
			System.out.println("What would you like to do?");
			System.out.println("1. Search Room");
			System.out.println("2. Move Rooms");
			System.out.println("3. Manage Inventory");
			System.out.println("4. View Score");
			System.out.println("5. Help");
			System.out.println("6. Save Game");
			System.out.println("7. View Journal");
			System.out.println("8. Exit Game");
			
			userInput = GameInput.getInt();
			
			if(userInput == 1)
			{
				searchRoom();
			}
			else if(userInput == 2)
			{
				moveRooms();
			}
			else if(userInput == 3)
			{
				viewInventory();
			}
			else if(userInput == 4)
			{
				viewScore();
			}
			else if(userInput == 5)
			{
				viewHelp();
			}
			else if(userInput == 6)
			{
				saveGame();
			}
			else if(userInput == 7)
			{
				continuing = false;
				MenuLoader.loadJournalMenu(this);
			}
			else if(userInput == 8)
			{
				exitGame();
			}
			else 
			{
				// invalid input
				throw new IOException();
			}
			
			}
			catch(IOException ioe)
			{
				System.out.println("\tYou mumble to yourself, but the only reply is an echo from the walls.");
				System.out.println();
			}
			
		} while(continuing);
		
		
	}
	
	/**
	 * Searches the current room, displaying the location name, a description as well as 
	 * a list of the items located in the room.
	 */
	private void searchRoom()
	{
		ArrayList<String> descriptions = SearchRoomControl.searchRoom();
		
		System.out.println("\tYou must be in the " + Game.getHero().getRoom().getName().toLowerCase() + ".");
		System.out.println();
		System.out.println("\tLooking around, you observe the following: \n\t" + descriptions.get(0));
		System.out.println();
		
		// if there are items, print items list
		if(descriptions.size() > 1) {
			System.out.println("\tYou notice the following items:");
			for(int i = 1; i < descriptions.size();i++)
			{
				System.out.println("\t" + descriptions.get(i));
			}
		}
		// otherwise...
		else 
		{
			System.out.println("\tThere doesn't appear to be anything else notable.");
		}
		
		System.out.println();
	}
	
	/**
	 * Allows the player to chose a room from the possible choices of rooms.
	 * If the player moves to a room with a monster, it initiates combat.
	 * Otherwise, it just loads another game menu for that room.
	 */
	private void moveRooms() {
		
		boolean validInput = false;
		
		// stores the possible rooms
		ArrayList<Room> possibleRooms = new ArrayList<>();
		
		// get all the doors in the room
		for(Door door : Game.getHero().getRoom().getDoors())
		{
			// for every door, get the possible rooms.
			for(Room connectedRoom : door.getConnectedRooms())
			{
				// for each of those rooms, add it to the possible rooms
				// if it is not actually the current room.
				if(connectedRoom.getRoomID() != Game.getHero().getRoom().getRoomID())
				{
					possibleRooms.add(connectedRoom);
				}
			}
		}
		
		// start getting input
		do 
		{
			try 
			{
				
				System.out.println("Where would you like to move to?");
				// first option is always to go back
				System.out.println("0. Stay here");
				
				// show all possible rooms
				for(int i = 0; i < possibleRooms.size(); i++) 
				{
					System.out.println( (i + 1) + ". " + possibleRooms.get(i).getName());
				}
				System.out.println();
				
				int userChoice = GameInput.getInt();
				
				// if not a valid choice
				if(userChoice < 0 || userChoice > possibleRooms.size()) 
				{
					throw new IOException();
				}
				else 
				{
					validInput = true;
				}
				
				// if the user decided to stay here, exit this method.
				if(userChoice == 0) {
					return;
				}
				
				// decrement user choice to account for zero-index
				userChoice = userChoice - 1;
				
				// if the next room has a monster, change location and open combat
				if(possibleRooms.get(userChoice).getMonster() != null)
				{
					continuing = false;
					Game.getHero().move(possibleRooms.get(userChoice));
					System.out.println("\tAs you move into the next room, you encounter a monster!");
					System.out.println("\tIt attacks!");
					MenuLoader.loadCombatMenu(this);
				}
				// otherwise, just open the main menu again for the next room
				else 
				{
					continuing = false;
					Game.getHero().move(possibleRooms.get(userChoice));
					MenuLoader.loadGameMenu(this);
				}
				
			}
			catch(IOException ioe) 
			{
				System.out.println("\tYou wander around aimlessly before realizing there is no passage there.");
				System.out.println();
			}
			
		} while( ! validInput);
		
	}
	
	/**
	 * Opens an inventory menu.
	 */
	private void viewInventory() 
	{
		continuing = false;
		MenuLoader.loadInventoryMenu(this);
	}
	
	/**
	 * Displays the current score.
	 */
	private void viewScore() {
		
		System.out.println("\tYou're not often one to track your progress with such meaningless numbers,");
		System.out.println("\tbut this is an exception. You have " + Game.getScore() + " imaginary points.");
		System.out.println();
		
	}
	
	/**
	 * Shows a help guide.
	 */
	private void viewHelp() {
		// TODO Help guide
		
	}
	
	/**
	 * Attempts to allow the user to save the game. It gives them three attempts to enter a file name,
	 * and write to the file. If it does not work after three attempts, boots them back to the game menu.
	 */
	private void saveGame() {
		
		boolean validInput = false;
		// after three failed save attempts, boot back to game menu.
		int saveAttempts = 0;
		
		do 
		{
			try
			{
				System.out.println("\tIn order to immortalize your legacy, tell the Old Ones your name.");
				
				String fileName = GameInput.getString();
				
				Game.saveGame(fileName);
				
				System.out.println("\tThe Old Ones approved your request. Your legacy is now written for generations past and present.");
				validInput = true;
				
			} catch(IOException ioe) 
			{
				saveAttempts++;
				System.out.println("\tThe Old Ones denied your request.");
				if(saveAttempts > 3) 
				{
					System.out.println("\tTrying again is not going to help right now.");
					System.out.println();
					return;
				}
			}
		}
		while( ! validInput);
		
		System.out.println();
		
	}
	
	/** 
	 * Prompts to make sure user would like exit, then exits.
	 */
	private void exitGame() {
		
		boolean validInput = false;
		
		do 
		{
			
			try 
			{
				System.out.println("Are you sure you would like to quit?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				
				int userChoice = GameInput.getInt();
				
				if(userChoice == 1)
				{
					continuing = false;
					System.out.println("\tYour vision fades...");
					System.out.println();
					MenuLoader.loadStartMenu(this);
				}
				else if(userChoice == 2)
				{
					return;
				}
				else 
				{
					// not valid
					throw new IOException();
				}
				
			}
			catch(IOException ioe)
			{
				System.out.println("\tNot a valid input, please try again.");
				System.out.println();
			}
			
		} while( ! validInput);
		
	}
	
	@Override
	void onDestroy() {}

}
