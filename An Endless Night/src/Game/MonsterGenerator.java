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
	public MonsterGenerator(Artifact[] item, double[] itemPercentChance)
	{
		ArrayList<Monster> monsterList = new ArrayList<Monster>();

		// TODO: add defense and artifacts
		Monster mon = new Monster(1, 1, 0, 0, "Maneki-neko", 0.01, item[0], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(2, 15, 3, 0, "Karakasa", 0.30, item[1], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(3, 25, 5, 0, "Futakuchi-onna", 0.40, item[2], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(4, 35, 8, 0, "Kappa", 0.30, item[3], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(5, 40, 10, 0, "Tanuki", 0.40, item[4], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(6, 25, 8, 0, "Yatagarasu", 0.20, item[5], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(7, 60, 15, 0, "Oni", 0.50, item[6], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(8, 70, 18, 0, "Shisa", 0.50, item[7], itemPercentChance[0], false);
		monsterList.add(mon);
		mon = new Monster(9, 65, 15, 0, "Tengu", 1.00, item[8], itemPercentChance[0], true);
		monsterList.add(mon);
		mon = new Monster(10, 100, 20, 0, "Kitsune", 1.00, item[0], itemPercentChance[0], true);
		monsterList.add(mon);
		mon = new Monster(11, 200, 25, 0, "Ryu", 1.00, item[0], itemPercentChance[0], true);
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