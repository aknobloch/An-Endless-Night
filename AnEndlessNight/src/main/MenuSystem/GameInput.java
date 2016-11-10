package main.MenuSystem;

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
	
	/***
	 * Gets a double input from the user.
	 * @return The next double that the user inputs.
	 * @throws IOException If the user does not enter a valid double, the scanner was closed or 
	 * 	any other exception occurred.
	 */
	public static double getDouble() throws IOException 
	{
		try 
		{
			double userInput = input.nextDouble();
			return userInput;
			
		} catch(Exception ex) 
		{
			throw new IOException();
		}
	}
	
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
			int userInput = input.nextInt();
			return userInput;
			
		} catch(Exception ex)
		{
			throw new IOException();
		}
	}
	
	/**
	 * Advances the scanner to the next line. This must be called if 
	 * you attempted to get input that was not valid. This is simply
	 * a call to Scanner.nextLine().
	 */
	public static void advanceScanner() 
	{
		try {
			input.nextLine();
		}
		catch(IndexOutOfBoundsException n) {
			System.out.println("caught");
		}
	}
}
