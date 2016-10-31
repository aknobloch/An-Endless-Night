package main.CombatSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Caleb and Aaron
 *
 */
public class MonsterFactory 
{
	private String[] monsterNameA = {"Maneki-neko","Karakasa", "Futakuchi-onna", "Kappa", "Tanuki", "Yatagarasu", "Oni", "Shisa", "Tengu", "Kitsune", "Ryu"};
	//TODO change from String to Artifact
	private ArrayList<String> monsterDropList;

	public MonsterFactory()
	{
		monsterDropList = new ArrayList<String>();

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
						monsterDropList.add(parts[i+1]);
					}
				}
			}
		}
	}
}
