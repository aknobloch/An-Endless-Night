package main.MenuSystem;


import java.io.IOException;

import main.Game;
import main.GameInput;

/**
 * 
 * @author Jory Alexander and Caleb Sears
 *
 */

public class PuzzleMenu extends AbstractMenu
{
	
	private String description = "1. Enter Answer"
			+ "\n2. View Hint"
			+ "\n3. View Riddle"
			+ "\n4. Go back";
	
	private boolean inPuzzle;

	public PuzzleMenu(MenuLoader menuLoader) 
	{
		super(menuLoader);
		// TODO Auto-generated constructor stub
	}
	
	private void flee() 
	{
		System.out.println("You walk back head hurting from thinking.");
		
		Game.getHero().bounceBack();
	}

	private void viewRiddle() 
	{
		System.out.println(Game.getHero().getRoom().getPuzzle().getDescription());
	}

	private void getHint() 
	{
		System.out.println("\n\t" + Game.getHero().getRoom().getPuzzle().getHint() + "\n");
	}

	private void answer() 
	{
		try 
		{
			System.out.println("Enter your answer:");
			System.out.println();
			
			String answer = GameInput.getString();
			// first remove case
			answer = answer.toLowerCase();
			
			// remove case on this as well, just to be sure.
			String solution = Game.getHero().getRoom().getPuzzle().getSolution().toLowerCase();
			
			// then do a contains. that way the user can enter 
			// things that don't EXACTLY match and still get it correct.
			// for instance, on the first riddle they could enter
			// "a skull" or just "skull" or "what is a skull" etc
			if(answer.contains(solution))
			{
				Game.getHero().getRoom().getPuzzle().setIsSolved(true);
				System.out.println("Your brilliance astounds even yourself");
				inPuzzle = false;
				MenuLoader.loadGameMenu(this);
			}
			else
			{
				System.out.println("The room seems to not like your muttering");
				Game.getHero().getRoom().getPuzzle().incrementAttemptsMade();
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	void mainPrompt() 
	{
		inPuzzle = true;
		viewRiddle();
		
		while(inPuzzle)
		{
			try 
			{
				System.out.println(description);
				int input = GameInput.getInt();
				if(input == 1)
				{
					answer();
					if(Game.getHero().getRoom().getPuzzle().getAttemptsAllowed() == Game.getHero().getRoom().getPuzzle().getAttemptsMade())
					{
						System.out.println("\tYour constant attempts have fried the ancient artifact. Your way is now unblocked however, you feel "
								+ "\n\tas if you missed out on a huge oportunity.\n");
						inPuzzle = false;
						MenuLoader.loadGameMenu(this);
					}
				}
				else if(input == 2)
				{
					getHint();
				}
				else if(input == 3)
				{
					viewRiddle();
				}
				else if(input == 4)
				{
					flee();
					inPuzzle=false;
					MenuLoader.loadGameMenu(this);
				}
				else
				{
					System.out.println("You mumble to yourself");
				}
			} catch (IOException e) 
			{
				System.out.println("You mumble nonsense");
			}
		}
	}
	@Override
	void onDestroy() 
	{}
}
