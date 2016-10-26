package Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class MonsterFactory 
{
	private Artifact[] itemArray;
	private double[] itemPercentChanceArray;
	private ArrayList<String> monsterNameAL;
	private MonsterGenerator mg;

	public MonsterFactory()
	{
		readFile();
		for (int i = 0; i < monsterNameAL.size(); i++)
		{
			if (monsterNameAL.get(i) == "Maneki-neko")
			{
				//TODO: pull from actual artifact text.
				Artifact[] itemArray = {
						new Artifact(" art05", null, 0), new Artifact(" art14", null, 0), new Artifact(" art15", null, 0)
				};
				double[] itemPercentChanceArray = {
						.10, .60, .30
				};
			}else 
				if (monsterNameAL.get(i) == "Karakasa")
				{
					Artifact[] itemArray = { new Artifact(" art05", null, 0)};
					double[] itemPercentChanceArray = {.15};
				}else
					if (monsterNameAL.get(i) == "Futakuchi-onna")
					{
						Artifact[] itemArray = { new Artifact(" art05", null, 0)};
						double[] itemPercentChanceArray = {.15};
					}else
						if (monsterNameAL.get(i) == "Kappa")
						{
							Artifact[] itemArray = { new Artifact(" art05", null, 0)};
							double[] itemPercentChanceArray = {.15};
						}else
							if (monsterNameAL.get(i) == "Tanuki")
							{
								Artifact[] itemArray = { new Artifact(" art05", null, 0)};
								double[] itemPercentChanceArray = {.20};
							}else
								if (monsterNameAL.get(i) == "Yatagarasu")
								{
									Artifact[] itemArray = { new Artifact(" art05", null, 0)};
									double[] itemPercentChanceArray = {.15};
								}else
									if (monsterNameAL.get(i) == "Oni")
									{
										Artifact[] itemArray = { new Artifact(" art05", null, 0)};
										double[] itemPercentChanceArray = {.25};
									}else
										if (monsterNameAL.get(i) == "Shisa")
										{
											Artifact[] itemArray = { new Artifact(" art05", null, 0)};
											double[] itemPercentChanceArray = {.30};
										}else
											if (monsterNameAL.get(i) == "Tengu")
											{
												Artifact[] itemArray = { new Artifact(" art14", null, 0),
														new Artifact(" art05", null, 0), new Artifact(" art17", null, 0)};
												double[] itemPercentChanceArray = {1, 1, 1};
											}else
												if (monsterNameAL.get(i) == "Kitsune")
												{
													Artifact[] itemArray = { new Artifact(" art14", null, 0), 
															new Artifact(" art05", null, 0), new Artifact(" art18", null, 0)};
													double[] itemPercentChanceArray = {1, 1, 1};
												}

			mg = new MonsterGenerator(itemArray, itemPercentChanceArray);
		}
	}

	public void readFile()
	{
		try {
			for (String line : Files.readAllLines(Paths.get("MonsterNames.txt")))
			{
				for (String part : line.split("\\s+")) 
				{
					String monsterName = part;
					monsterNameAL.add(monsterName);
				}
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public MonsterGenerator getMg() {
		return mg;
	}
	
	/*
	 * this rolls the dice to decide what artifacts a monster will drop
	 */
	public Artifact[] decider()
	{
		Artifact[] a = itemArray;
		for (int i = 0; i < itemArray.length; i++)
		{
			double itemPercentChance = itemPercentChanceArray[i];
			Random r = new Random();
			
			if(r.nextInt(100) < itemPercentChance) 
			{
				
			}
		}
		return a;
	}

}
