package main.MenuSystem;

/**
 * Provides the template for all menu classes.
 * @author Aaron
 *
 */
public abstract class AbstractMenu {
	
	
	@SuppressWarnings("unused")
	private AbstractMenu() {
		// prevents subclasses from trying to make a default constructor.
	}
	
	/**
	 * Creates a new main menu. Accepts a MenuLoader, which is the only 
	 * class that can instantiate a menu. If you are seeing this message, chances
	 * are that you are trying to create a menu. And you're probably scratching your 
	 * head as to why you cannot. Try using MenuLoader.loadDesiredMenu();
	 */
	public AbstractMenu(MenuLoader menuLoader) {
		
	}
	
	
	/**
	 * This is the entry point for your menu. It should print any welcoming messages, 
	 * and start the IO for the user. Do NOT create a new Scanner for input! Use 
	 * the GameInput class.
	 */
	abstract void mainPrompt();
	
	/**
	 * This is the closing point for your menu. It should close any resources, finalize any
	 * score and do any last minute output that is needed. As soon as this function is done,
	 * the next menu will immediately take over output.
	 */
	abstract void onDestroy();
	
	
}
