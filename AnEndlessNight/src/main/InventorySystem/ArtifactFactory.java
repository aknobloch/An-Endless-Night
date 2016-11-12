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
				"Tengu�s Fan",
				"Kitsune�s Tail"
		};

	private static ArrayList<Artifact> keyArtifactsList;
	private static ArrayList<Weapon> weaponsList;
	private static ArrayList<Consumable> consumablesList ;
	private static ArrayList<Armor> armorsList ;
	private static ArrayList<Artifact> artifactsList ;

	private ArtifactFactory(){}

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
						int puzzleID;
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
							//TODO add defense values into ArtifactID.txt
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

	public static ArrayList<Artifact> getArtifactsList() 
	{
		if(artifactsList.isEmpty()) 
		{
			initializeArtifacts();
		}

		return artifactsList;
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
