package main.MenuSystem;

import java.io.IOException;

public class InventoryMenu extends AbstractMenu
{
	
	public InventoryMenu(AbstractMenu lastMenu) {
		super(lastMenu);
		// TODO Auto-generated constructor stub
	}

	private String description = 
			"Please Enter a number based on your Command \n"
			+ "1. Equip Item \n"
			+ "2. Drop Item \n"
			+ "3. View Item \n"
			+ "4. View Help \n";

	@Override
	void mainPrompt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		
	}
		

}
