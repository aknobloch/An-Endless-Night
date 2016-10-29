package Game;

import java.io.IOException;

public class InventoryMenu extends AbstractMenu {
	
	private String description = "1. View Equipped items \n"
			+ "2. View inventory"
			+ "3. Equip item\n"
			+ "4. Unequip item \n"
			+ "5. Inspect item\n"
			+ "6. Return to Game Menu\n";

	public String toString()
	{
		return description;
	}
	public InventoryMenu(AbstractMenu lastMenu) {
		super(lastMenu);
		// TODO Auto-generated constructor stub
	}

	@Override
	void mainPrompt() {
		
		System.out.println(toString());
		
		try {
			String input = GameInput.getString();
			
			if(input.equals("1"))
			{
				viewEquippedItems();
				new InventoryMenu(this);
			}
			else if(input.equals("2"))
			{
				viewInventory();
				new InventoryMenu(this);
			}
			else if(input.equals("3"))
			{
				equipItem();
				new InventoryMenu(this);
			}
			else if(input.equals("4"))
			{
				unequipItem();
				new InventoryMenu(this);
			}
			else if(input.equals("5"))
			{
				inspectItem();
				new InventoryMenu(this);
			}
			else if(input.equals("6"))
			{
				new GameMenu(this);
			}
			else
			{
				System.out.println("That does not match an option");
				new InventoryMenu(this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void inspectItem() {
		// TODO Auto-generated method stub
		
	}
	public void unequipItem() {
		// TODO Auto-generated method stub
		
	}
	public void equipItem() {
		// TODO Auto-generated method stub
		
	}
	public void viewInventory() {
		// TODO Auto-generated method stub
		
	}
	public void viewEquippedItems() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

}
