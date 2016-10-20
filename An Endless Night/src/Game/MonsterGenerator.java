package Game;

import java.util.ArrayList;

/**
 * @author Caleb Sears
 *
 */

public class MonsterGenerator 
{
	public static void main(String[] args)
    {
	ArrayList<Monster> monsterList = new ArrayList<Monster>();

	// TODO: add defense and artifacts
    Monster mon = new Monster(1, 1, 0, 0, "Maneki-neko", 0.01, new Artifact art14, 0.60, false);
    monsterList.add(mon);
    mon = new Monster(2, 15, 3, 0, "Karakasa", 0.30, new Artifact art05, 0.15, false);
    monsterList.add(mon);
    mon = new Monster(3, 25, 5, 0, "Futakuchi-onna", 0.40, new Artifact art05, 0.15, false);
    monsterList.add(mon);
    mon = new Monster(4, 35, 8, 0, "Kappa", 0.30, new Artifact art05, 0.15, false);
    monsterList.add(mon);
    mon = new Monster(5, 40, 10, 0, "Tanuki", 0.40, new Artifact art05, 0.20, false);
    monsterList.add(mon);
    mon = new Monster(6, 25, 8, 0, "Yatagarasu", 0.20, new Artifact art05, 0.15, false);
    monsterList.add(mon);
    mon = new Monster(7, 60, 15, 0, "Oni", 0.50, new Artifact art05, 0.25, false);
    monsterList.add(mon);
    mon = new Monster(8, 70, 18, 0, "Shisa", 0.50, new Artifact art05, 0.30, false);
    monsterList.add(mon);
    mon = new Monster(9, 65, 15, 0, "Tengu", 1.00, new Artifact art17, 1.00, true);
    monsterList.add(mon);
    mon = new Monster(10, 100, 20, 0, "Kitsune", 1.00, new Artifact art18, 1.00, true);
    monsterList.add(mon);
    mon = new Monster(11, 200, 25, 0, "Ryu", 1.00, new Artifact art05, 0.00, true);
    monsterList.add(mon);
    }
}