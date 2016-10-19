package Game;

import java.io.IOException;

@SuppressWarnings("serial")
public class InventoryStackFullError extends IOException 
{

	public InventoryStackFullError() 
	{
		super("This inventory item cannot hold any more. Try setting the maxCount");
	}
	
}
