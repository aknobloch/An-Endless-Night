package main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
			System.out.println();
			
			if(userInput.equalsIgnoreCase("help")) 
			{
				Game.printHelp();
			}

			clearInputBuffer();
			
			return userInput;

		} catch(Exception ex) 
		{	
			System.out.println();
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
			System.out.println();

			// cheat mode
			if(userInput.equals("MAKE ME A GOD")) 
			{
				Game.godMode();
				System.out.println();
				System.out.println("\tYour eyes roll back, shimmering in the light.");
				System.out.println("\tThe power of Old Ones past and present fills you.");
			}

			// revert
			if(userInput.equals("MAKE ME A MORTAL"))
			{
				Game.mortalMode();
				System.out.println();
				System.out.println("\tCrumpling to your knees, you gasp for breath.");
				System.out.println("\tYou had forgotten how weak humans were....");
			}

			// teleport
			if(userInput.startsWith("TELEPORT"))
			{
				int roomID = Integer.parseInt(userInput.substring(userInput.indexOf(" ") + 1));

				System.out.println();
				System.out.println("\tIn the blink of an eye, you find yourself in new surroundings.");

				Game.getHero().teleport(roomID);
			}
			
			// help
			if(userInput.equalsIgnoreCase("help"))
			{
				Game.printHelp();
			}

			clearInputBuffer();

			return Integer.parseInt(userInput);

		} catch(Exception ex)
		{
			System.out.println();
			throw new IOException();
		}
	}


	/**
	 * Clears the input by reading excess input until a newline is reached.
	 */
	private static void clearInputBuffer()
	{
		try
		{
			char excessInput;
			do
			{
				excessInput = (char) System.in.read();
			}
			while (excessInput != '\n');
		}
		catch(IOException ioe) {}

	}
}
