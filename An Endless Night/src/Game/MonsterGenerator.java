package Game;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Caleb Sears
 *
 */

public class MonsterGenerator 
{
	public MonsterGenerator(ArrayList<Artifact> artifactAl)
	{
		ArrayList<Monster> monsterList = new ArrayList<Monster>();

		// TODO: artifacts
		Monster mon = new Monster(1, 1, 0, "Maneki-neko", 0.01, artifactAl, false);
		monsterList.add(mon);
		mon = new Monster(2, 15, 3, "Karakasa", 0.30, artifactAl, false);
		monsterList.add(mon);
		mon = new Monster(3, 25, 5, "Futakuchi-onna", 0.40, artifactAl, false);
		monsterList.add(mon);
		mon = new Monster(4, 35, 8, "Kappa", 0.30, item[3], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(5, 40, 10, "Tanuki", 0.40, item[4], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(6, 25, 8, "Yatagarasu", 0.20, item[5], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(7, 60, 15, "Oni", 0.50, item[6], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(8, 70, 18, "Shisa", 0.50, item[7], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(9, 65, 15, "Tengu", 1.00, item[8], itemPercentChance[0], true);
		monsterList.add(mon);
		mon = new Monster(10, 100, 20, "Kitsune", 1.00, item[0], itemPercentChance[0], true);
		monsterList.add(mon);
		mon = new Monster(11, 200, 25, "Ryu", 1.00, item[0], itemPercentChance[0], true);
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
			System.out.println("Problem writing to file");
		}

	}
}