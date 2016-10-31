package main.InventorySystem;

/***
 * Keeps track of item information for the player inventory. 
 * Holds the Artifact as well as a reference to how many of that item the player is holding.
 * @author Aaron
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
	
	/**
	 * Returns the count of the current InventoryItem.
	 * @return The count, or "stack" of the associated artifact
	 */
	public int getCount() 
	{
		return count;
	}
	
	/**
	 * Gets the max number of items that this InventoryItem is allowed to have.
	 * @return The max number of items that this InventoryItem is allowed to have.
	 */
	public int getMaxStack() 
	{
		return this.maxStack;
	}
	
	/**
	 * Sets the max number of items that this InventoryItem can have.
	 * @param count The max number that this InventoryItem should be able to hold.
	 */
	public void setMaxStack(int count) 
	{
		this.maxStack = count;
	}
	
	/**
	 * Gets the Artifact associated with this InventoryItem.
	 * @return The Artifact associated with this InventoryItem.
	 */
	public Artifact getItem() 
	{
		return item;
	}
	
	/**
	 * Attempts to increment the count, or stack number, of this InventoryItem.
	 * @throws InventoryStackFullError If the InventoryItem cannot hold any more of the item
	 * according to the maxStack attribute.
	 */
	public void incrementCount() throws InventoryStackFullError 
	{
		if(this.count == maxStack) 
		{
			throw new InventoryStackFullError();
		}
		else 
		{
			this.count++;
		}
	}
	
	/**
	 * Checks to see if two InventoryItems are equal. Equality is based on the Artifact
	 * that the InventoryItem holds. If the Artifacts of the two are the same, they are 
	 * considered equal.
	 * 
	 * @param inItem The item to check against.
	 * @return True if the InventoryItem artifacts are the same, false otherwise.
	 */
	public boolean equals(InventoryItem inItem) 
	{
		return this.item.equals(inItem.item);
	}
}
