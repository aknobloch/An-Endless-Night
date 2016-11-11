package main.MenuSystem;

import java.io.IOException;

import main.GameInput;

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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                           BOSS BATTLE                            ");
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
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
		
		try {
			Thread.sleep(MENU_PAUSE_TIME);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		System.out.println();
		System.out.println("==================================================================");
		System.out.println("                             PUZZLE                               ");
		System.out.println("==================================================================");
		System.out.println();
		
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
	
		System.out.println("\n\n");
		System.out.println("\tThe road before you must be endless.");
		System.out.println();
		
		// pause for dramatic effect!
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
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
		
		try {
			GameInput.getString();
		} catch (IOException e) {
			// do nothing
		}
		
		System.out.println("\tWithin short time, your encampment arrives at the old, decrepit building. The knocking ");
		System.out.println("\tof Hachiro echoes through the otherwise still night air. You pray that the habitants have ");
		System.out.println("\talready prepared a kotatsu, for the cold winter night chills your very bones. ");
		System.out.println();
		System.out.println("Press enter to continue.");
		System.out.println();
		
		try {
			GameInput.getString();
		} catch (IOException e) {
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
		
		try {
			GameInput.getString();
		} catch (IOException e) {
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
		
		try {
			GameInput.getString();
		} catch (IOException e) {
			// do nothing
		}
		
		System.out.println("\tDarkness envelops you…");
		
		// pause for dramatic effect!
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		startMenu.mainPrompt();
	}

	
}
