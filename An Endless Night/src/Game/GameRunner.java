package Game;

import java.util.Scanner;

public class GameRunner 
{

	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		StartMenu start = new StartMenu();
		boolean tracker = true;
		String userIn = "";
		while(tracker)
		{
			System.out.println(start.toString());
			userIn = input.next();
			if(userIn.equals("1"))
			{
				start.startNewGame();
				System.out.println("A new Game has been started");
				tracker = false;
			}
			else if(userIn.equals("2"))
			{
				start.loadGame();
				System.out.println("Game has been loaded");
				tracker = false;
			}
			else if(userIn.equals("3"))
			{
				tracker = false;
				start.exitGame();
			}
			else
			{
				System.out.println("Invalid Input! \n Please try agian");
			}
		}
	}

}
