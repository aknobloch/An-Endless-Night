package main.MenuSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import main.Game;
import main.GameInput;
import main.InventorySystem.Artifact;
import main.InventorySystem.InventoryItem;
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
	void mainPrompt() 
	{
		int userInput;
		continuing = true;

		do 
		{
			try 
			{
				System.out.println("What would you like to do?");
				System.out.println("1. Move Rooms");
				System.out.println("2. Search Room");
				System.out.println("3. Manage Inventory");
				System.out.println("4. View Stats");
				System.out.println("5. View Journal");
				System.out.println("6. Save Game");
				System.out.println("7. Exit Game");

				userInput = GameInput.getInt();

				if(userInput == 1)
				{
					moveRooms();
				}
				else if(userInput == 2)
				{
					searchRoom();	
				}
				else if(userInput == 3)
				{
					viewInventory();
				}
				else if(userInput == 4)
				{
					viewStats();
				}
				else if(userInput == 5)
				{
					continuing = false;
					MenuLoader.loadJournalMenu(this);
				}
				else if(userInput == 6)
				{
					saveGame();
				}
				else if(userInput == 7)
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
	 * Allows the user to pick up items in the room. Displays all available items, and
	 * prompts the user to select one. Attempts to add the item to the inventory, 
	 * and  then displays appropriate message to the user. 
	 */
	private void getRoomItems() 
	{
		ArrayList<Artifact> roomItems = Game.getHero().getRoom().getArtifactList();

		boolean gatheringItems = true;

		// keeps track if a user picked up an item or not.
		// this just helps modify output to be cleaner below.
		boolean pickedUpItem = false;

		do
		{
			try 
			{
				// return immediately if no items are in the room.
				if(roomItems == null || roomItems.size() == 0)
				{
					if(pickedUpItem)
					{
						System.out.println("\tYou can't find anything else in the room worth picking up.");
					}
					else 
					{
						System.out.println("\tYou can't find anything in the room worth picking up.");
					}
					System.out.println();
					gatheringItems = false;
					return;
				}

				System.out.println("\tThere might be something here worth taking...");
				System.out.println();

				System.out.println("What would you like to pick up?");

				// print all items in room for selection
				for(int i = 0; i < roomItems.size(); i++)
				{
					System.out.println( (i + 1) + ". " + roomItems.get(i).getName());
				}

				System.out.println((roomItems.size() + 1) + ". Return to last menu");
				System.out.println();

				int userChoice = GameInput.getInt();

				// if user's choice is not in range
				if(userChoice < 0 || userChoice > roomItems.size() + 1)
				{
					throw new IOException();
				}

				// if last option (exit menu)
				if(userChoice == roomItems.size() + 1)
				{
					gatheringItems = false;
					return;
				}
				else 
				{
					// decrement choice by one to account for zero-index
					userChoice = userChoice - 1;

					// pick up item, add to inventory and remove from room
					String resultMessage = Game.getHero().addArtifactToInventory(roomItems.get(userChoice));
					if(resultMessage.equals("You place the item safely in your bag."))
					{
						Game.getHero().getRoom().getArtifactList().remove(userChoice);
					}

					pickedUpItem = true;

					System.out.println("\t" + resultMessage);
					System.out.println();
				}

			}
			catch(IOException ioe)
			{
				System.out.println("\tYou reach out to grab what you were hoping to find,");
				System.out.println("\tbut it is not there. Perhaps you are going mad...");
				System.out.println();
			}
		} while(gatheringItems);
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

		// if there are items...
		if(descriptions.size() > 1) 
		{
			getRoomItems();
			// after they are done getting room items, return
			return;
		}
		// otherwise...
		else 
		{
			System.out.println("\tThere doesn't appear to be anything else notable.");
			System.out.println();
		}
	}

	/**
	 * Allows the player to chose a room from the possible choices of rooms.
	 * If the player moves to a room with a monster, it initiates combat.
	 * Otherwise, it just loads another game menu for that room.
	 */
	private void moveRooms() 
	{
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
				if(userChoice == 0) 
				{
					return;
				}

				// decrement user choice to account for zero-index
				userChoice = userChoice - 1;
				
				// check for study room key
				// room 127 is the study room
				if(possibleRooms.get(userChoice).getRoomID() == 127)
				{
					boolean hasKey = false;
					
					for(InventoryItem item : Game.getHero().getPlayerInventory())
					{
						// this is the study room key
						if(item.getItem().getArtifactID() == 8)
						{
							hasKey = true;
						}
					}
					
					// if the user doesn't have the key, display locked status and exit
					if( ! hasKey)
					{
						System.out.println("\tYou try to open the door, but it is locked.");
						System.out.println("\tPerhaps there is a key somewhere...");
						System.out.println();
						return;
					}
					else 
					{
						System.out.println("\tYou use the study room key to open the door.");
						System.out.println();
					}
				}
				
				// account for puzzles
				if(possibleRooms.get(userChoice).getPuzzle() != null)
				{
					System.out.println("\tYou start to walk into the next room, but a demonic");
					System.out.println("\tvoice begins cackling madly.");
					
					continuing = false;
					Game.getHero().move(possibleRooms.get(userChoice));

					MenuLoader.loadPuzzleMenu(this);
					return;
				}

				// if the next room has a monster, change location and open combat
				if(possibleRooms.get(userChoice).getMonster() != null)
				{
					continuing = false;
					Game.getHero().move(possibleRooms.get(userChoice));

					// if the monster is Kitsune, she is in disguise. 
					// in this case we do not want to output the standard boss message
					if(Game.getHero().getRoom().getMonster().getID() == 10)
					{
						System.out.println("\tYou walk bravely into the next room.");
						System.out.println();
						MenuLoader.loadBossCombatMenu(this);
						return;
					}

					// switch input up to keep things interesting.
					double switchNumber = Math.random();
					if(switchNumber <= .3) 
					{
						System.out.println("\tAs you move into the next room, you encounter a monster!");
					}
					else if(switchNumber <= .7)
					{
						System.out.println("\tAs you walk into the next room, you notice a beast...");
					}
					else 
					{
						System.out.println("\tYou venture into the next room. You can hear a creature gnawing on flesh.");
					}

					System.out.println();
					MenuLoader.loadCombatMenu(this);
				}
				// otherwise, just open the main menu again for the next room
				else 
				{
					continuing = false;
					Game.getHero().move(possibleRooms.get(userChoice));

					// switch input up to keep things interesting.
					double switchNumber = Math.random();
					if(switchNumber <= .3) 
					{
						System.out.println("\tYou walk bravely into the next room.");
					}
					else if(switchNumber <= .7)
					{
						System.out.println("\tYou step cautiously into the next room.");
					}
					else 
					{
						System.out.println("\tWeapon ready, you venture into the next room.");
					}

					System.out.println();
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
		System.out.println("\tYou kneel down, opening your bag.");
		System.out.println();
		
		MenuLoader.loadInventoryMenu(this);
	}

	/**
	 * Displays the current score.
	 */
	private void viewStats() 
	{
		System.out.println("\tYou're not often one to track your progress with");
		System.out.println("\tsuch meaningless numbers, but this is an exception. ");
		System.out.println();
		
		// if weapon is equipped
		if( ! Game.getHero().getEquippedWeapon().getName().equalsIgnoreCase("fists"))
		{
			System.out.println("\tYou have " + Game.getHero().getEquippedWeapon().getName() + " equipped as a weapon.");
		}
		else 
		{
			System.out.println("\tYou have no weapon equipped.");
		}
		
		// if armor is equipped
		if(Game.getHero().getEquippedArmor() != null)
		{
			System.out.println("\tYou have " + Game.getHero().getEquippedWeapon().getName() + " equipped for armor.");
		}
		else
		{
			System.out.println("\tYou have no armor equipped.");
		}
		
		System.out.println("\tYou have " + Game.getHero().getHealth() + " health left.");
		System.out.println("\tYou have " + Game.getScore() + " points accrued.");
		System.out.println("\tYou have killed " + Game.getMonsterDeaths() + " demons.");
		System.out.println("\tYou have killed " + Game.getBossDeaths() + " bosses.");
		System.out.println("\tYou have discovered " + Game.getRoomsDiscovered() + " rooms.");
		System.out.println("\tYou have died " + Game.getHeroDeaths() + " times.");
		System.out.println();
	}

	/**
	 * Attempts to allow the user to save the game. It gives them three attempts to enter a file name,
	 * and write to the file. If it does not work after three attempts, boots them back to the game menu.
	 */
	private void saveGame() 
	{
		boolean validInput = false;
		// after three failed save attempts, boot back to game menu.
		int saveAttempts = 0;

		do 
		{
			try
			{
				System.out.println("\tIn order to immortalize your legacy, tell the Old Ones your name.");

				String fileName = GameInput.getString();
				
				// check if the save file already exists.
				for(File existingFile : new File(".").listFiles())
				{
					String existingFileName = existingFile.getName();
					if(existingFileName.endsWith(".gsave"))
					{
						// if the existing file has the same name 
						if(existingFileName.substring(0, existingFileName.indexOf(".gsave")).equals(fileName))
						{
							boolean madeDecision = false;
							while( ! madeDecision)
							{
								System.out.println("A file with this name already exists.");
								System.out.println("Would you like to overwrite?");
								
								System.out.println("1. Yes");
								System.out.println("2. No");
								System.out.println();
							
								try {
									int overwriteChoice = GameInput.getInt();
									
									if(overwriteChoice == 2)
									{
										System.out.println("\tYou decide your legacy should not be rewritten yet.");
										System.out.println();
										return;
									}
									else if(overwriteChoice == 1)
									{
										madeDecision = true;
									}
									else 
									{
										throw new IOException();
									}
								}
								catch(IOException ioe)
								{
									System.out.println("Input not recognized.");
								}
							}
							
						}
					}
				}
				
				Game.saveGame(fileName);

				System.out.println("\tThe Old Ones approved your request.");
				System.out.println("\tYour legacy is now written for generations past and present.");
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
	private void exitGame() 
	{
		boolean validInput = true;

		while(validInput) 
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
					validInput=false;
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
	void onDestroy() 
	{}
}
