package main.CombatSystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import main.InventorySystem.Artifact;
import main.InventorySystem.ArtifactFactory;


/**
 * 
 * @author Caleb and Aaron
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

	// generates Monsters
	public static void initializeFactory() 
	{
		monsterItemAssignments = new ArrayList<ArrayList<Artifact>>();
		monsterList = new ArrayList<Monster>();

		for (int j = 0; j < monsterNameArray.length; j++)
		{
			try 
			{
				File f = new File("MonstersNames.txt");
				Scanner scan = new Scanner(f);

				while(scan.hasNextLine()) 
				{
					String line = scan.nextLine();
					String[] parts = line.split(" ");

					if(parts[0].equals(monsterNameArray[j])) 
					{
						ArrayList<String> monsterDropList = new ArrayList<String>();

						for (int i = 1; i < parts.length; i = i + 2) 
						{
							Random r = new Random();

							int percentChance = Integer.parseInt(parts[i + 1]);
							int randomNum = r.nextInt(100);

							if(randomNum < percentChance)
							{
								monsterDropList.add(parts[i]);
							}

						}

						ArrayList<Artifact> artifactList = new ArrayList<Artifact>();

						while (!monsterDropList.isEmpty())
						{
							int itemForMonster = Integer.parseInt(monsterDropList.remove(0));

							Artifact a = ArtifactFactory.getArtifactsList().get(itemForMonster - 1);

							artifactList.add(a);

						}

						monsterItemAssignments.add(artifactList);
					}
				}

				scan.close();

			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}

		// adds monsters to the monsterList
		Monster mon = new Monster(1, 1, 1, "Maneki-neko", 1, monsterItemAssignments.get(0), false);
		monsterList.add(mon);
		mon = new Monster(2, 15, 3, "Karakasa", 30, monsterItemAssignments.get(1), false);
		monsterList.add(mon);
		mon = new Monster(3, 25, 5, "Futakuchi-onna", 40, monsterItemAssignments.get(2), false);
		monsterList.add(mon);
		mon = new Monster(4, 35, 8, "Kappa", 30, monsterItemAssignments.get(3), false);
		monsterList.add(mon);
		mon = new Monster(5, 40, 10, "Tanuki", 40, monsterItemAssignments.get(4), false);
		monsterList.add(mon);
		mon = new Monster(6, 25, 8, "Yatagarasu", 20, monsterItemAssignments.get(5), false);
		monsterList.add(mon);
		mon = new Monster(7, 60, 15, "Oni", 50, monsterItemAssignments.get(6), false);
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

	public static Monster setRoomMonster(int roomID) // roomID must not be 01 format.
	{
		if(monsterList == null) 
		{
			initializeFactory();
		}

		int winningMonster = 0;

		switch (roomID)
		{
		case 18: winningMonster = 8; 
		break;
		case 24: winningMonster = 9;
		break;
		case 29: winningMonster = 10;
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

		return monsterList.get(winningMonster);
	}
}
