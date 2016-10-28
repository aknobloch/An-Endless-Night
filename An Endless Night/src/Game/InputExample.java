package Game;

import java.io.IOException;

public class InputExample {
	
	public static void main(String[] args) 
	{
		
		double userInput;
		boolean valid = false;
		
		do {
			
			System.out.println("Please enter a double.");
			
			try {
				
				userInput = GameInput.getDouble();
				valid = true;
				
			} catch (IOException e) 
			{
				valid = false;
				System.out.print("Not a valid input. ");
				
				GameInput.advanceScanner();
			}
			
		} while( ! valid);
		
	}
	
}
