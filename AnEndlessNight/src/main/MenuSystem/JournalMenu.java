package main.MenuSystem;

import java.io.IOException;
import java.util.ArrayList;

import main.Game;

/**
 * author: Jory Alexander
 */

public class JournalMenu extends AbstractMenu
{
	String description = "1. Read Journal"
			+ "\n2. Write Entry"
			+ "\n3. Remove Entry"
			+ "\n4. Main Menu";

	public JournalMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
	}

	public void readJournal() 
	{
		Game.getJournal();
		ArrayList<String> entries = Game.getJournal().getEntries();
		
		for(int i = 0; i < entries.size();i++)
		{
			System.out.println((i+1) + ". " + entries.get(i));
		}
	}

	public void writeEntry()
	{
		System.out.println("You think carefully about what to write"
				+ "before putting pen to paper");
		
		String input;
		try 
		{
			input = GameInput.getString();
			Game.getJournal().addEntry(input);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeEntry() 
	{
		System.out.println("You look through your journal and think about which entry you would like to remove.");
		readJournal();
		
		System.out.println("You consider the entry number that is no longer useful");
		
		try 
		{
			int input = GameInput.getInt();
			Game.getJournal().removeEntry(input);
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString()
	{
		return description;
	}
	@Override
	void mainPrompt() 
	{
		System.out.println(toString());
		boolean check = true;
		while(check)
		{
			try 
			{
				String input = GameInput.getString();
				
				if(input.equals("1"))
				{
					readJournal();
				}
				else if(input.equals("2"))
				{
					writeEntry();
				}
				else if(input.equals("3"))
				{
					removeEntry();
				}
				else if(input.equals("4"))
				{
					check = false;
					MenuLoader.loadGameMenu(this);
				}
				else
				{
					System.out.println("You mumble nonsense to yourself. You think to yourself that you should not say nonsense into the void");
				}
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	void onDestroy() 
	{}
}
