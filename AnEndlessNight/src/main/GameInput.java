package main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/***
 * GameInput provides a single, concise way to get input from the user.
 * It consolidates memory and handles format exceptions. It utilizes the 
 * Facade pattern. 
 * 
 * @author Aaron
 *
 */
public final class GameInput 
{
	public static final Scanner input = new Scanner(System.in);
	
	// not instantiable
	private GameInput() 
	{}
	
	/**
	 * Gets the next line of string input from the user.
	 * @return The line of input from the user.
	 * @throws IOException If the input is not valid, the scanner was closed or any other exception occured.
	 */
	public static String getString() throws IOException 
	{
		try 
		{	
			String userInput = input.nextLine();
			return userInput;

		} catch(Exception ex) 
		{	
			System.out.println();
			advanceScanner();
			throw new IOException();
		}
	}
	
	/***
	 * Gets a int input from the user.
	 * @return The next int that the user inputs.
	 * @throws IOException If the user does not enter a valid int, the scanner was closed or 
	 * 	any other exception occurred.
	 */
	public static int getInt() throws IOException 
	{
		try 
		{
			String userInput = input.nextLine();
			
			// cheat mode
			if(userInput.equals("MAKE ME A GOD")) 
			{
				Game.godMode();
			}
			
			// revert
			if(userInput.equals("MAKE ME A MORTAL"))
			{
				Game.mortalMode();
			}
			
			System.out.println();
			return Integer.parseInt(userInput);
			
		} catch(Exception ex)
		{
			System.out.println();
			throw new IOException();
		}
	}
	
	/**
	 * Advances the scanner to the next line. This must be called if 
	 * you attempted to get input that was not valid. This is simply
	 * a call to Scanner.nextLine().
	 */
	private static void advanceScanner() 
	{
		input.nextLine();
	}
}
