package main.MenuSystem;

import java.io.IOException;

public class InventoryMenu extends AbstractMenu
{
	public InventoryMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	private String description = 
			"Please Enter a number based on your Command \n"
			+ "1. Equip Item \n"
			+ "2. Unequip Item \n"
			+ "3. Drop Item \n"
			+ "4. View Item \n"
			+ "5. Main Menu";

	private void viewItem() 
	{
		// TODO Auto-generated method stub
		
	}

	private void dropItem() 
	{
		// TODO Auto-generated method stub
		
	}

	private void unEquipItem() 
	{
		// TODO Auto-generated method stub
		
	}

	private void equipItem() 
	{
		// TODO Auto-generated method stub
		
	}

	public String toString()
	{
		return description;
	}
	@Override
	void mainPrompt() 
	{
		
		System.out.println(toString());
		
		try {
			
			String input = GameInput.getString();
			
			if(input.equals("1"))
			{
				equipItem();
				MenuLoader.loadInventoryMenu(this);
			}
			else if(input.equals("2"))
			{
				unEquipItem();
				MenuLoader.loadInventoryMenu(this);
			}
			else if(input.equals("3"))
			{
				dropItem();
				MenuLoader.loadInventoryMenu(this);
			}
			else if(input.equals("4"))
			{
				viewItem();
				MenuLoader.loadInventoryMenu(this);
			}
			else if(input.equals("5"))
			{
				MenuLoader.loadGameMenu(this);
			}
			else
			{
				System.out.println(input + " is not a valid input please");
				MenuLoader.loadInventoryMenu(this);
			}
		} catch (IOException e) {
			System.out.println("Issue reading input");
			MenuLoader.loadInventoryMenu(this);
		}
	}

	@Override
	void onDestroy() 
	{
		// TODO Auto-generated method stub
		
	}
}
