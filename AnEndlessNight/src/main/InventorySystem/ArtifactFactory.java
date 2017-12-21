package main.InventorySystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import main.CombatSystem.Armor;


/**
 * Class: MonsterFactory.java
 *
 * @author Caleb Sears
 * @version 4.0
 *          <p>
 * Course : ITEC 3860 Fall 2016
 * Written: Nov 14, 2016
 *
 *
 *  This class  This class generates artifacts
 *
 *  Purpose: is to create artifacts
 *  
 */
/**
 * @author lonnies
 *
 */
/**
 * @author lonnies
 *
 */
public class ArtifactFactory 
{
	private static String[] artifactNameArray = 
		{
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

	private static ArrayList<Artifact> keyArtifactsList;
	private static ArrayList<Weapon> weaponsList;
	private static ArrayList<Consumable> consumablesList ;
	private static ArrayList<Armor> armorsList ;
	private static ArrayList<Artifact> artifactsList ;

	private ArtifactFactory(){}

	/**
	 * This initializes all of the Artifacts in the game.
	 */
	public static void initializeArtifacts() 
	{
		artifactsList = new ArrayList<Artifact>();
		armorsList = new ArrayList<Armor>();
		consumablesList = new ArrayList<Consumable>();
		weaponsList = new ArrayList<Weapon>();
		keyArtifactsList = new ArrayList<Artifact>();

		for (int i = 0; i < artifactNameArray.length; i++)
		{
			try 
			{
				File f = new File("ArtifactID.txt");
				Scanner scan = new Scanner(f);

				while(scan.hasNextLine()) 
				{
					String line = scan.nextLine();
					String[] parts = line.split("  ");

					if(parts[0].equals(artifactNameArray[i])) 
					{
						int itemID = Integer.parseInt(parts[2]);
						String itemDesc = parts[3];
						int healAmount;
						int strength;
						int defense;
						Artifact item = new Artifact(artifactNameArray[i], itemDesc, itemID);

						switch (parts[1])
						{
						case "Key":
							item = new Artifact(artifactNameArray[i], itemDesc, itemID);
							keyArtifactsList.add(item);
							artifactsList.add(item);
							break;
						case "Consumable": 
							healAmount = Integer.parseInt(parts[4]);
							item = new Consumable(artifactNameArray[i], itemDesc, itemID, healAmount);
							consumablesList.add((Consumable) item);
							artifactsList.add(item);
							break;
						case "Weapon": 
							strength = Integer.parseInt(parts[4]);
							item = new Weapon(artifactNameArray[i], itemDesc, itemID, strength);
							weaponsList.add((Weapon) item);
							artifactsList.add(item);
							break;
						case "Armor": 
							defense = Integer.parseInt(parts[4]);
							item = new Armor(artifactNameArray[i], itemDesc, itemID, defense);
							armorsList.add((Armor) item);
							artifactsList.add(item);
							break;
						}
					}
				}
				scan.close();
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the artifactsList
	 */
	public static ArrayList<Artifact> getArtifactsList() 
	{
		if(artifactsList.isEmpty()) 
		{
			initializeArtifacts();
		}

		return artifactsList;
	}
}
