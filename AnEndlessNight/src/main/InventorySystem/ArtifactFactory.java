package main.InventorySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import main.CombatSystem.Armor;

/*
 * By: Caleb
 */
public class ArtifactFactory 
{
	
	private static String[] artifactNameArray = {

			"Magic Mirror",
			"Katana",
			"Odachi",
			"Bo/Jo",
			"Healing Potion",
			"Journal",
			"Celestial Globe",
			"Study Room Key",
			"Kegutsu",
			"Kikko",
			"Mempo",
			"Kaiken",
			"Kusarigama",
			"Daruma Doll",
			"Kokeshi Doll", 
			"Ladder",
			"Tengu's Fan",
			"Kitsune's Tail"
		};

	private static ArrayList<Artifact> artifactsList = new ArrayList<Artifact>();

	public static void initializeArtifacts() 
	{
		for (int i = 0; i < artifactNameArray.length; i++)
		{
			try 
			{
				getArtifactInfo(artifactNameArray[i]);
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		writeToFile(artifactsList);
	}

	private static void getArtifactInfo(String artifactName) throws FileNotFoundException 
	{
		File f = new File("ArtifactID.txt");
		Scanner scan = new Scanner(f);

		while(scan.hasNextLine()) 
		{
			String line = scan.nextLine();
			String[] parts = line.split("  ");

			if(parts[0].equals(artifactName)) 
			{
					int itemID = Integer.parseInt(parts[2]);
					String itemDesc = parts[3];
					int healAmount;
					int strength;
					int defense;
					int puzzleID;
					boolean isKey = false;
					Artifact item = new Artifact(artifactName, itemDesc, itemID);

					if (artifactName.matches("Study Room Key"))
					{
						isKey = true;
					}

					switch (parts[1])
					{
					case "Key":
						//TODO add puzzleID to ArtifactID.txt
						puzzleID = Integer.parseInt(parts[4]);
						item = new KeyArtifact(artifactName, itemDesc, itemID, puzzleID, isKey);
						break;
					case "Consumable": 
						healAmount = Integer.parseInt(parts[4]);
						item = new Consumable(artifactName, itemDesc, itemID, healAmount);
						break;
					case "Weapon": 
						strength = Integer.parseInt(parts[4]);
						item = new Weapon(artifactName, itemDesc, itemID, strength);
						break;
					case "Armor": 
						//TODO add defense values into ArtifactID.txt
						defense = Integer.parseInt(parts[4]);
						item = new Armor(artifactName, itemDesc, itemID, defense);
						break;
					case "Armor and Key": 
						//TODO figure out what to do here.
						item = new Artifact(artifactName, itemDesc, itemID);
						break;
					}
					artifactsList.add(item);
				
			}
		}
		scan.close();
	}

	private static void writeToFile(ArrayList<Artifact> artifactsList)
	{
		// open file for writing
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("artifacts.dat"));

			// write each Artifact in turn
			for (int i = 0; i < artifactsList.size(); i++)
			{
				Artifact myArtifact = artifactsList.get(i);
				output.writeObject(myArtifact);
			}
			// done writing close file
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem writing to artifacts.dat");
		}
	}
}
