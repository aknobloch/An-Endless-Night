package main.CombatSystem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import main.InventorySystem.Artifact;

/**
 * 
 * @author Caleb and Aaron
 *
 */
public class MonsterFactory 
{
	//TODO create map for monsters and the rooms they can appear in.
	private String[] monsterNameA = {"Maneki-neko","Karakasa", "Futakuchi-onna", "Kappa", "Tanuki", "Yatagarasu", "Oni", "Shisa", "Tengu", "Kitsune", "Ryu"};
	private ArrayList<String> monsterDropList;
	private ArrayList<ArrayList<Artifact>> monsterItemAssignments;

	public MonsterFactory()
	{
		monsterDropList = new ArrayList<String>();
		monsterItemAssignments = new ArrayList<ArrayList<Artifact>>();

		for (int i = 0; i < monsterNameA.length; i++)
		{
			try 
			{
				getItemForMonster(monsterNameA[i]);
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		MonsterGenerator(monsterItemAssignments);
	}

	public static Monster getMonsterForRoom(int roomID) {
		
		return new Monster(0, 100, 5, "Generic Monster", 100, null, false);
		
	}
	
	public void getItemForMonster(String generatedMonster) throws FileNotFoundException 
	{
		File f = new File("MonstersNames.txt");
		Scanner scan = new Scanner(f);

		while(scan.hasNextLine()) 
		{
			String line = scan.nextLine();
			String[] parts = line.split(" ");

			if(parts[0].equals(generatedMonster)) 
			{
				for(int i = 1; i < parts.length; i = i + 2) 
				{
					Random r = new Random();

					int percentChance = Integer.parseInt(parts[i + 1]);
					int randomNum = r.nextInt(100);

					if(randomNum < percentChance)
					{
						monsterDropList.add(parts[i + 1]);
					}
				}
				monsterItemAssignments.add(readArtifacts(monsterDropList));
			}
		}
		scan.close();
	}

	public ArrayList<Artifact> readArtifacts(ArrayList<String> artifact) 
	{
		// open up artifacts.dat and read into an arrayList of artifacts.
		ArrayList<Artifact> theList = new ArrayList<Artifact>();
		ObjectInputStream input = null;

		try
		{
			input = new ObjectInputStream(new FileInputStream("artifacts.dat"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		// now read from the file- get the Artifact and return it
		try
		{
			while (true)
			{
				Artifact a = (Artifact) input.readObject();
				for (int i = 0; i < artifact.size(); i++)
				{
					if (a.getArtifactID() == Integer.parseInt(artifact.get(i)))
					{
						theList.add(a);
					}
				}
			}
		} catch (EOFException e)
		{
			// file ended done reading - do nothing
		} catch (IOException e)
		{
			System.out.println("Problem reading from file");
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			System.out.println("Corrupted file - regenerate");
			e.printStackTrace();
		}

		try 
		{
			input.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

		return theList;
	}

	public void MonsterGenerator(ArrayList<ArrayList<Artifact>> artifactAl)
	{
		ArrayList<Monster> monsterList = new ArrayList<Monster>();

		Monster mon = new Monster(1, 1, 0, "Maneki-neko", 0.01, artifactAl.get(0), false);
		monsterList.add(mon);
		mon = new Monster(2, 15, 3, "Karakasa", 0.30, artifactAl.get(1), false);
		monsterList.add(mon);
		mon = new Monster(3, 25, 5, "Futakuchi-onna", 0.40, artifactAl.get(2), false);
		monsterList.add(mon);
		mon = new Monster(4, 35, 8, "Kappa", 0.30, artifactAl.get(3), false);
		monsterList.add(mon);
		mon = new Monster(5, 40, 10, "Tanuki", 0.40, artifactAl.get(4), false);
		monsterList.add(mon);
		mon = new Monster(6, 25, 8, "Yatagarasu", 0.20, artifactAl.get(5), false);
		monsterList.add(mon);
		mon = new Monster(7, 60, 15, "Oni", 0.50, artifactAl.get(6), false);
		monsterList.add(mon);
		mon = new Monster(8, 70, 18, "Shisa", 0.50, artifactAl.get(7), false);
		monsterList.add(mon);
		mon = new Monster(9, 65, 15, "Tengu", 1.00, artifactAl.get(8), true);
		monsterList.add(mon);
		mon = new Monster(10, 100, 20, "Kitsune", 1.00, artifactAl.get(9), true);
		monsterList.add(mon);
		mon = new Monster(11, 200, 25, "Ryu", 1.00, artifactAl.get(10), true);
		monsterList.add(mon);

		// open file for writing
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("monsters.dat"));

			// write each Monster in turn
			for (int i = 0; i < monsterList.size(); i++)
			{
				Monster myMonster = monsterList.get(i);
				output.writeObject(myMonster);
			}
			// done writing close file
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem writing to monster.dat");
		}
	}
}
