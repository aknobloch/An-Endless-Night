package main.MenuSystem;

/***
 * Helps manage menu creation and destruction. Ensure that menus are closed 
 * and the flow of control between different menus is guaranteed. This is 
 * the only class that should be able to create menus
 * 
 * @author Aaron
 *
 */
public class MenuLoader {
	
	// the one, the only....
	public static final MenuLoader johnCena = new MenuLoader();
	
	public static final CombatMenu combatMenu = new CombatMenu(johnCena);
	public static final GameMenu gameMenu = new GameMenu(johnCena);
	public static final InventoryMenu inventoryMenu = new InventoryMenu(johnCena);
	public static final JournalMenu journalMenu = new JournalMenu(johnCena);
	public static final StartMenu startMenu = new StartMenu(johnCena);
	
	/**
	 * You should not be able to instantiate this class. All menus, however, require that 
	 * you pass in an object of this class. This ensures that menus are not created or managed
	 * except through this class.
	 */
	private MenuLoader() {
		// prevent instantiation.
	}

	/***
	 * Loads the game menu. The onDestroy() method will first be called for the
	 * menu that called this object, and then the mainPrompt() will be called for the
	 * desired menu. 
	 * 
	 * @param currentMenu The currentMenu. For all foreseeable cases, the parameter for 
	 * this method should be "this". 
	 */
	public static void loadCombatMenu(AbstractMenu currentMenu) {
		
		currentMenu.onDestroy();
		new Thread(new Runnable() {

			@Override
			public void run() {
				
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
	public static void loadGameMenu(AbstractMenu currentMenu) {
		
		currentMenu.onDestroy();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
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
	public static void loadInventoryMenu(AbstractMenu currentMenu) {
		
		currentMenu.onDestroy();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
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
	public static void loadJournalMenu(AbstractMenu currentMenu) {
		
		currentMenu.onDestroy();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
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
	public static void loadStartMenu(AbstractMenu currentMenu) {
		
		currentMenu.onDestroy();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				startMenu.mainPrompt();
				
			}
			
		}).start();
		
	}
	
	/***
	 * Starts the game by calling invoking the mainPrompt function of the start menu.
	 */
	public static void startGame() {
		
		startMenu.mainPrompt();
		
	}
	
}
