package Game;

/***
 * Keeps track of item information for the player inventory. 
 * Holds the Artifact as well as a reference to how many of that item the player is holding.
 * @author Aaron
 *
 */

public class InventoryItem 
{
	
	private Artifact item;
	private int count;
	private int maxStack;
	
	/***
	 * Creates an inventory item with a count of one, and 
	 * specifies the largest amount this item can have.
	 * @param item The item associated with this object.
	 */
	public InventoryItem(Artifact item, int maxCount)
	{
		this.item = item;
		this.count = 1;
		this.maxStack = maxCount;
	}
	
	public int getCount() 
	{
		return count;
	}
	public void setCount(int count) 
	{
		this.count = count;
	}
	public int getMaxStack() 
	{
		return this.maxStack;
	}
	public void setMaxStack(int count) 
	{
		this.maxStack = count;
	}
	public Artifact getItem() 
	{
		return item;
	}
	public void incrementCount() throws InventoryStackFullError 
	{
		if(this.count == maxStack) 
		{
			throw new InventoryStackFullError();
		}
		else 
		{
			incrementCount();
		}
	}
	public boolean equals(InventoryItem inItem) 
	{
		return this.item.equals(inItem.item);
	}
}
