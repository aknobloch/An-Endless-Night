package main.MenuSystem;

import java.io.IOException;

import main.Game;
import main.GameInput;

/**
 * 
 * @author Jory Alexander
 *
 */

public class PuzzleMenu extends AbstractMenu
{
	
	private String description = "1. Enter Answer"
			+ "\n2. View Hint"
			+ "\n3. View Riddle"
			+ "\n4. Go back";

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
		System.out.println(Game.getHero().getRoom().getPuzzle().getHint());
	}

	private void answer() 
	{
		try 
		{
			String answer = GameInput.getString();
			
			String solution = Game.getHero().getRoom().getPuzzle().getSolution();
			
			if(answer.equals(solution))
			{
				Game.getHero().getRoom().getPuzzle().setIsSolved(true);
				System.out.println("Your brilliance astounds even yourself");
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
		boolean inPuzzle = true;
		
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
						System.out.println("Your costant attempts have fried the ancient artifact. Your way is now unblocked however, you feel "
								+ "as if you missed out on a huge oportunity.");
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
				// TODO Auto-generated catch block
				System.out.println("You mumble nonsense");
			}
		}
	}
	@Override
	void onDestroy() 
	{}
}
