package main.InventorySystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Journal implements Serializable 
{
	ArrayList<String> entries;

	/**
	 * Creates a Journal Object
	 */
	public Journal()
	{
		entries = new ArrayList<String>();
	}

	/**
	 * Adds an entry to the journal
	 * @param entry
	 */
	public void addEntry(String entry)
	{
		entries.add(entry);
	}

	/**
	 * Removes an entry from the journal
	 * @param x
	 */
	public void removeEntry(int x)
	{
		entries.remove(x);
	}

	/**
	 * Returns an arraylist of type string of journal entries.
	 * @return
	 */
	public ArrayList<String> getEntries()
	{
		return entries;
	}
}
