package main.MenuSystem;

import java.io.IOException;

import main.Game;

/***
 * Helps manage menu creation and destruction. Ensure that menus are closed 
 * and the flow of control between different menus is guaranteed. This is 
 * the only class that should be able to create menus
 * 
 * @author Aaron
 *
 */
public class MenuLoader 
{
	// the one, the only....
	private static final MenuLoader johnCena = new MenuLoader();

	private static final CombatMenu combatMenu = new CombatMenu(johnCena);
	private static final GameMenu gameMenu = new GameMenu(johnCena);
	private static final InventoryMenu inventoryMenu = new InventoryMenu(johnCena);
	private static final JournalMenu journalMenu = new JournalMenu(johnCena);
	private static final StartMenu startMenu = new StartMenu(johnCena);
	private static final PuzzleMenu puzzleMenu = new PuzzleMenu(johnCena);
	private static final BossCombatMenu bossMenu = new BossCombatMenu(johnCena);

	// the amount of time to wait before launching a new menu.
	private static final long MENU_PAUSE_TIME = 1500;
	//TODO
	//private static final long MENU_PAUSE_TIME = 1250;
	/**
	 * You should not be able to instantiate this class. All menus, however, require that 
	 * you pass in an object of this class. This ensures that menus are not created or managed
	 * except through this class.
	 */
	private MenuLoader() 
	{
		// prevent instantiation.
	}

	/***
	 * Loads the combat menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadCombatMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		// move into boss combat menu
		if(Game.getHero().getRoom().getMonster().isBoss())
		{
			MenuLoader.loadBossCombatMenu(currentMenu);
			return;
		}

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		clearInput();
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             COMBAT                               ");
		System.out.println("==================================================================");
		System.out.println();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				combatMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the combat menu for bosses. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadBossCombatMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		clearInput();
		// no menu display, that is handled in the BossCombatMenu

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				bossMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the game menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadGameMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		clearInput();

		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             MAIN MENU                            ");
		System.out.println("==================================================================");
		System.out.println();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				gameMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the inventory menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadInventoryMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		clearInput();
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             INVENTORY                            ");
		System.out.println("==================================================================");
		System.out.println();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				inventoryMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the journal menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadJournalMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}
		clearInput();
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             JOURNAL                              ");
		System.out.println("==================================================================");
		System.out.println();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				journalMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the start menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadStartMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();
		clearInput();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				startMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Loads the puzzle menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadPuzzleMenu(AbstractMenu currentMenu) 
	{
		currentMenu.onDestroy();

		try 
		{
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) 
		{
			// do nothing
		}

		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             PUZZLE                               ");
		System.out.println("==================================================================");
		System.out.println();
		clearInput();

		new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{
				puzzleMenu.mainPrompt();
			}
		}).start();
	}

	/***
	 * Starts the game by calling invoking the mainPrompt function of the start menu.
	 */
	public static void startGame() 
	{
		clearInput();
		startMenu.mainPrompt();
	}

	/**
	 * Attempts to clear the input from excessive spamming.
	 */
	public static void clearInput() 
	{
		// Reads all excess junk from stdin
		// This is neccessary because if the user just spams enter
		// any excess "enters" will cause
		// an error in the main loop of this menu and cause a bunch of
		// "not valid input"'s to be printed while it reads all the
		// excess enters that the user spammed.
		try {
			while(System.in.available() > 0) 
			{
				System.in.read();
			}
		} catch (IOException e) 
		{
			// do nothing
		}
	}
}