package main.MenuSystem;

/**
 * Provides the template for all menu classes.
 * @author Aaron
 *
 */
public abstract class AbstractMenu {
	
	
	/**
	 * Creates a new main menu. 
	 */
	public AbstractMenu(AbstractMenu lastMenu) {
		
		
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
	
	/**
	 * Calls the onDestroy() method.
	 */
	public final void exitMenu() {
		
		this.onDestroy();
		
	}
	
}
