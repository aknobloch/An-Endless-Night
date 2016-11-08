package main.InventorySystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Journal implements Serializable {
	
	ArrayList<String> entries;
	
	public Journal()
	{
		entries = new ArrayList<String>();
	}
	
	public void addEntry(String entry)
	{
		entries.add(entry);
	}
	
	public void removeEntry(int x)
	{
		entries.remove(x);
	}
	
	public ArrayList<String> getEntries()
	{
		return entries;
	}

}
