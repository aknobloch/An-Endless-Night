package main.InventorySystem;

import java.io.IOException;

@SuppressWarnings("serial")
/**
 * An error indicating that an InventoryItem cannot hold any more items,
 * of that the "stack" has reached it's limit.
 * @author Aaron
 *
 */
public class InventoryStackFullError extends IOException 
{

	/**
	 * Creates a new InventoryFullError with a default message.
	 */
	public InventoryStackFullError() 
	{
		super("This inventory item cannot hold any more. Try setting the maxCount");
	}
}
