package main.InventorySystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import main.CombatSystem.Armor;


/**
 * author: Caleb Sears
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
			"Tengu’s Fan",
			"Kitsune’s Tail"
	};

	private static ArrayList<Artifact> keyArtifactsList = new ArrayList<Artifact>();
	private static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
	private static ArrayList<Consumable> consumablesList = new ArrayList<Consumable>();
	private static ArrayList<Armor> armorsList = new ArrayList<Armor>();
	private static ArrayList<Artifact> artifactList = new ArrayList<Artifact>();
	
	private ArtifactFactory(){}

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
					int puzzleID = 0;
					Artifact item = new Artifact(artifactName, itemDesc, itemID, puzzleID);

					switch (parts[1])
					{
					case "Key":
						//TODO add puzzleID to ArtifactID.txt
						puzzleID = Integer.parseInt(parts[4]);
						item = new Artifact(artifactName, itemDesc, itemID, puzzleID);
						keyArtifactsList.add(item);
						artifactList.add(item);
						break;
					case "Consumable": 
						healAmount = Integer.parseInt(parts[4]);
						item = new Consumable(artifactName, itemDesc, itemID, puzzleID, healAmount);
						consumablesList.add((Consumable) item);
						artifactList.add(item);
						break;
					case "Weapon": 
						strength = Integer.parseInt(parts[4]);
						item = new Weapon(artifactName, itemDesc, itemID, puzzleID, strength);
						weaponsList.add((Weapon) item);
						artifactList.add(item);
						break;
					case "Armor": 
						//TODO add defense values into ArtifactID.txt
						defense = Integer.parseInt(parts[4]);
						item = new Armor(artifactName, itemDesc, itemID, puzzleID, defense);
						armorsList.add((Armor) item);
						artifactList.add(item);
						break;
					}
			}
		}
		scan.close();
	}
	
	public static ArrayList<Artifact> getArtifactsList() 
	{
		if(artifactList == null) 
		{
			initializeArtifacts();
		}
		
		return artifactList;
	}
	
	public static ArrayList<Artifact> getKeyArtifactsList() 
	{
		if(keyArtifactsList == null) 
		{
			initializeArtifacts();
		}
		
		return keyArtifactsList;
	}

	public static ArrayList<Weapon> getWeaponsList() 
	{
		if(weaponsList == null) 
		{
			initializeArtifacts();
		}
		
		return weaponsList;
	}

	public static ArrayList<Consumable> getConsumablesList() 
	{
		if(consumablesList == null) 
		{
			initializeArtifacts();
		}
		
		return consumablesList;
	}

	public static ArrayList<Armor> getArmorsList() 
	{
		if(armorsList == null) 
		{
			initializeArtifacts();
		}
		
		return armorsList;
	}
	
	public static Weapon getWeapon(int artID) 
	{
		if(weaponsList == null) 
		{
			initializeArtifacts();
		}
		
		for (int i = 0; i < weaponsList.size(); i++)
		{
			if (artID == weaponsList.get(i).getArtifactID())
			{
				return weaponsList.get(i);
			}
		}
		return null;
	}
	
	public static Armor getArmor(int artID) 
	{
		if(armorsList == null) 
		{
			initializeArtifacts();
		}
		
		for (int i = 0; i < armorsList.size(); i++)
		{
			if (artID == armorsList.get(i).getArtifactID())
			{
				return armorsList.get(i);
			}
		}
		return null;
	}
	
	public static Consumable getConsumable(int artID) 
	{
		if(consumablesList == null) 
		{
			initializeArtifacts();
		}
		
		for (int i = 0; i < consumablesList.size(); i++)
		{
			if (artID == consumablesList.get(i).getArtifactID())
			{
				return consumablesList.get(i);
			}
		}
		return null;
	}
	
	public static Artifact getKeyArtifact(int artID) 
	{
		if(keyArtifactsList == null) 
		{
			initializeArtifacts();
		}
		
		for (int i = 0; i < keyArtifactsList.size(); i++)
		{
			if (artID == keyArtifactsList.get(i).getArtifactID())
			{
				return keyArtifactsList.get(i);
			}
		}
		return null;
	}

}
