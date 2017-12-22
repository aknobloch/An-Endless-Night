package main.CombatSystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import main.FileLoader;
import main.InventorySystem.Artifact;
import main.InventorySystem.ArtifactFactory;


/**
 * Class: MonsterFactory.java
 *
 * @author Caleb Sears and Aaron
 * @version 4.0
 *          <p>
 * Course : ITEC 3860 Fall 2016
 * Written: Nov 14, 2016
 *
 *
 *  This class  This class generates monsters
 *
 *  Purpose: is to create Monsters
 *  
 */

public class MonsterFactory 
{
	private static String[] monsterNameArray = 
		{
				"Maneki-neko",
				"Karakasa", 
				"Futakuchi-onna", 
				"Kappa", 
				"Tanuki", 
				"Yatagarasu", 
				"Oni", 
				"Shisa", 
				"Tengu", 
				"Kitsune", 
				"Ryu"
		};

	private static ArrayList<ArrayList<Artifact>> monsterItemAssignments;
	private static ArrayList<Monster> monsterList;

	// prevents instantiation
	private MonsterFactory() 
	{}

	/**
	 * This method creates all the monsters in the game.
	 */
	public static void initializeFactory() 
	{
		monsterItemAssignments = new ArrayList<ArrayList<Artifact>>();
		monsterList = new ArrayList<Monster>();

		// test to make sure the monster is the correct monster in the text file.
		for (int j = 0; j < monsterNameArray.length; j++)
		{
			String monsterNames = new FileLoader().getFileContents("MonstersNames.txt");

			// read through file to get the artifactID and its percent chance of dropping.
			for(String monster : monsterNames.split("\n"))
			{
				String[] parts = monster.split(" ");

				if (parts[0].equals(monsterNameArray[j]))
				{
					ArrayList<String> monsterDropList = new ArrayList<String>();

					// calculate if the monster will drop any of its possible items.
					for (int i = 1; i < parts.length; i = i + 2)
					{
						Random r = new Random();

						int percentChance = Integer.parseInt(parts[i + 1]);
						int randomNum = r.nextInt(100);

						// add a monster's drop items to an string array list
						if (randomNum < percentChance)
						{
							monsterDropList.add(parts[i]);
						}
					}

					// add items that each monster will drop to an artifact array lists.
					ArrayList<Artifact> artifactList = new ArrayList<Artifact>();

					while (!monsterDropList.isEmpty())
					{
						int itemForMonster = Integer.parseInt(monsterDropList.remove(0));

						Artifact a = ArtifactFactory.getArtifactsList().get(itemForMonster - 1);

						artifactList.add(a);
					}

					// add items that each monster will drop to an array list of artifact array lists.
					monsterItemAssignments.add(artifactList);
				}
			}
		}

		// adds monsters to the monsterList
		Monster mon = new Monster(1, 1, 0, "Maneki-neko", 5, monsterItemAssignments.get(0), false);
		monsterList.add(mon);
		mon = new Monster(2, 15, 3, "Karakasa", 20, monsterItemAssignments.get(1), false);
		monsterList.add(mon);
		mon = new Monster(3, 25, 5, "Futakuchi-onna", 20, monsterItemAssignments.get(2), false);
		monsterList.add(mon);
		mon = new Monster(4, 35, 8, "Kappa", 30, monsterItemAssignments.get(3), false);
		monsterList.add(mon);
		mon = new Monster(5, 40, 10, "Tanuki", 20, monsterItemAssignments.get(4), false);
		monsterList.add(mon);
		mon = new Monster(6, 25, 8, "Yatagarasu", 50, monsterItemAssignments.get(5), false);
		monsterList.add(mon);
		mon = new Monster(7, 60, 15, "Oni", 40, monsterItemAssignments.get(6), false);
		monsterList.add(mon);
		mon = new Monster(8, 70, 18, "Shisa", 50, monsterItemAssignments.get(7), false);
		monsterList.add(mon);
		mon = new Monster(9, 65, 15, "Tengu", 100, monsterItemAssignments.get(8), true);
		monsterList.add(mon);
		mon = new Monster(10, 100, 20, "Kitsune", 100, monsterItemAssignments.get(9), true);
		monsterList.add(mon);
		mon = new Monster(11, 200, 25, "Ryu", 100, monsterItemAssignments.get(10), true);
		monsterList.add(mon);
	}

	/**
	 * Method: setRoomMonster
	 * 
	 * This method takes a room id, selects the propper monster, and returns that monster
	 * 
	 * @param roomID
	 * @return Monster
	 */
	public static Monster setRoomMonster(int roomID) // roomID must not be 01 format.
	{
		if(monsterList == null) 
		{
			initializeFactory();
		}

		int winningMonster = 0;

		// identifies the winningMonster
		switch (roomID)
		{
		case 18: winningMonster = 8; //boss 1
		break;
		case 24: winningMonster = 9; //boss 2
		break;
		case 29: winningMonster = 10; //boss 3
		break;
		default: 
			for (int i = 0; i < monsterList.size()-3; i++) // -3 to prevent bosses from being selected.
			{
				Random r = new Random();

				int percentChance = (int) monsterList.get(i).getProbabilityOfAppearance();
				int randomNum = r.nextInt(100);

				if(randomNum < percentChance)
				{
					winningMonster = i;
					i = monsterList.size();
				}
			};
			break;
		}

		return new Monster(monsterList.get(winningMonster));
	}
}
