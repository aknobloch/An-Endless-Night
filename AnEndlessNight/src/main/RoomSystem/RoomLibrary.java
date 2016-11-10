package main.RoomSystem;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import main.CombatSystem.MonsterFactory;
import main.InventorySystem.Artifact;

/**
 * author: Estephanie Gonzalez
 */

public class RoomLibrary 
{
	public static ArrayList<Room> roomGen()
	{
		ArrayList<Integer> doors = new ArrayList<Integer>();
		ArrayList<Door> doorObj = new ArrayList<Door>();

		ArrayList<Integer> rooms = new ArrayList<Integer>();
		ArrayList<Room> roomObj = new ArrayList<Room>();

		ArrayList<Artifact> artifactList = new ArrayList<Artifact>();

		//FLOOR 1 Doors

		// 100 = door "00" 
		// 117 = door "17" and so on 
		doors.add(100);
		doors.add(101);
		Door d_01 = new Door(doors, 101);
		doorObj.add(d_01);
		doors.clear();

		doors.add(101);
		doors.add(102);
		Door d_02 = new Door(doors, 102);
		doorObj.add(d_02);
		doors.clear();

		doors.add(101);
		doors.add(105);
		Door d_03 = new Door(doors, 103);
		doorObj.add(d_03);
		doors.clear();

		doors.add(105);
		doors.add(107);
		Door d_04 = new Door(doors, 104);
		doorObj.add(d_04);
		doors.clear();

		doors.add(101);
		doors.add(107);
		Door d_05 = new Door(doors, 105);
		doorObj.add(d_05);
		doors.clear();

		doors.add(100);
		doors.add(109);
		Door d_06 = new Door(doors, 106);
		doorObj.add(d_06);
		doors.clear();

		doors.add(105);
		doors.add(109);
		Door d_07 = new Door(doors, 107);
		doorObj.add(d_07);
		doors.clear();

		doors.add(104);
		doors.add(117);
		Door d_08 = new Door(doors, 108);
		doorObj.add(d_08);
		doors.clear();

		doors.add(105);
		doors.add(117);
		Door d_09 = new Door(doors, 109);
		doorObj.add(d_09);
		doors.clear();

		doors.add(116);
		doors.add(117);
		Door d_10 = new Door(doors, 110);
		doorObj.add(d_10);
		doors.clear();

		doors.add(104);
		doors.add(116);
		Door d_11 = new Door(doors, 111);
		doorObj.add(d_11);
		doors.clear();

		doors.add(105);
		doors.add(116);
		Door d_12 = new Door(doors, 112);
		doorObj.add(d_12);
		doors.clear();

		doors.add(100);
		doors.add(116);
		Door d_13 = new Door(doors, 113);
		doorObj.add(d_13);
		doors.clear();

		doors.add(103);
		doors.add(104);
		Door d_14 = new Door(doors, 114);
		doorObj.add(d_14);
		doors.clear();

		doors.add(104);
		doors.add(108);
		Door d_15 = new Door(doors, 115);
		doorObj.add(d_15);
		doors.clear();

		doors.add(103);
		doors.add(108);
		Door d_16 = new Door(doors, 116);
		doorObj.add(d_16);
		doors.clear();

		doors.add(102);
		doors.add(106);
		Door d_17 = new Door(doors, 117);
		doorObj.add(d_17);
		doors.clear();

		doors.add(102);
		doors.add(106);
		Door d_18 = new Door(doors, 118);
		doorObj.add(d_18);
		doors.clear();

		doors.add(102);
		doors.add(103);
		Door d_19 = new Door(doors, 119);
		doorObj.add(d_19);
		doors.clear();

		doors.add(103);
		doors.add(113);
		Door d_20 = new Door(doors, 120);
		doorObj.add(d_20);
		doors.clear();

		doors.add(103);
		Door d_21 = new Door(doors, 121);
		doorObj.add(d_21);
		doors.clear();

		doors.add(100);
		doors.add(110);
		Door d_22 = new Door(doors, 122);
		doorObj.add(d_22);
		doors.clear();

		doors.add(110);
		Door d_23 = new Door(doors, 123);
		doorObj.add(d_23);
		doors.clear();

		doors.add(110);
		doors.add(112);
		Door d_24 = new Door(doors, 124);
		doorObj.add(d_24);
		doors.clear();

		doors.add(100);
		doors.add(114);
		Door d_25 = new Door(doors, 125);
		doorObj.add(d_25);
		doors.clear();

		doors.add(113);
		doors.add(114);
		Door d_26 = new Door(doors, 126);
		doorObj.add(d_26);
		doors.clear();

		doors.add(100);
		doors.add(113);
		Door d_27 = new Door(doors, 127);
		doorObj.add(d_27);
		doors.clear();

		doors.add(114);
		doors.add(115);
		Door d_28 = new Door(doors, 128);
		doorObj.add(d_28);
		doors.clear();

		doors.add(100);
		doors.add(102);
		Door d_29 = new Door(doors, 129);
		doorObj.add(d_29);
		doors.clear();

		doors.add(666);
		doors.add(120);
		Door d_TD = new Door(doors, 666);
		doorObj.add(d_TD);
		doors.clear();

		//DOORS FLOOR 2
		doors.add(118);
		doors.add(126);
		Door d_30 = new Door(doors, 130);
		doorObj.add(d_30);
		doors.clear();

		doors.add(126);
		doors.add(127);
		Door d_31 = new Door(doors, 131);
		doorObj.add(d_31);
		doors.clear();

		doors.add(124);
		doors.add(126);
		Door d_32 = new Door(doors, 132);
		doorObj.add(d_32);
		doors.clear();

		doors.add(124);
		doors.add(125);
		Door d_33 = new Door(doors, 133);
		doorObj.add(d_33);
		doors.clear();

		doors.add(121);
		doors.add(126);
		Door d_34 = new Door(doors, 134);
		doorObj.add(d_34);
		doors.clear();

		doors.add(122);
		doors.add(126);
		Door d_35 = new Door(doors, 135);
		doorObj.add(d_35);
		doors.clear();

		doors.add(123);
		doors.add(122);
		Door d_36 = new Door(doors, 136);
		doorObj.add(d_36);
		doors.clear();

		doors.add(121);
		doors.add(122);
		Door d_37 = new Door(doors, 137);
		doorObj.add(d_37);
		doors.clear();

		doors.add(119);
		doors.add(126);
		Door d_38 = new Door(doors, 138);
		doorObj.add(d_38);
		doors.clear();

		doors.add(119);
		doors.add(120);
		Door d_39 = new Door(doors, 139);
		doorObj.add(d_39);
		doors.clear();

		doors.add(126);
		Door d_F1 = new Door(doors, 601);
		doorObj.add(d_F1);
		doors.clear();

		doors.add(126);
		doors.add(128);
		Door d_F2 = new Door(doors, 602);
		doorObj.add(d_F2);
		doors.clear();

		//DOORS FLOOR 3

		doors.add(129);
		doors.add(128);
		Door d_40 = new Door(doors, 140);
		doorObj.add(d_40);
		doors.clear();

		//ARTIFACTS

		// open up artifacts.dat and read into an arrayList of artifacts.
		ObjectInputStream input = null;

		try
		{
			input = new ObjectInputStream(new FileInputStream("artifacts.dat"));
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("can't find artifacts.dat");
		}

		// now read from the file- get the Artifact and return it
		try
		{
			while (true)
			{
				Artifact a = (Artifact) input.readObject();
				for (int i = 0; i < 19; i++)
				{
					artifactList.add(a);
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

		//PUZZLES

		Puzzle puz_01 = new Puzzle("I have no eyes, but I once did see. I once had thoughts, but now I’m white and empty. What am I?", "A Skull", false, 0, "Bones!", 1, 3);
		Puzzle puz_02 = new Puzzle("When you have me, you want to share me. When you share me, you no longer have me. What am I?", "A Secret", false, 0, "I am not known or seen or not to be known or seen by others", 2, 3);
		Puzzle puz_03 = new Puzzle("The more of me you take, the more of me you leave behind. What am I?", "Footsteps", false, 0, "Think quick on your feet!", 3, 3);
		Puzzle puz_04 = new Puzzle("What flies without wings?", "Time", false, 0, "Not a living thing", 4, 3);
		Puzzle puz_05 = new Puzzle("What constellation is currently seen in the night skies?", "Monoceros", false, 0, "Must Interact with the “Celestial Globe” for answer.", 5, 3);
		Puzzle puz_06 = new Puzzle("An old man was murdered and left his wealth behind.\nIn his will, he stated that each of his four children would split his gold coins. \nThey should be divided as follows:\nThe eldest should receive 1/2 of the gold pieces.\nThe 2nd child would receive 1/4, and then 3rd child would get 1/5 of the gold.\nFinally, he states that the youngest will get the remaining 49 gold coins. \nHow many gold coins did the old man have at death?", "980 coins", false, 0, "Remaining fraction", 6, 3);
		Puzzle puz_07 = new Puzzle("You come across a servant’s diary. \nInside it describes the theft of her favorite locket. \nShe knows it was one of the other servants. \nShe asks each servant who took the locket. \nTheir responses were..\nServant 1: It wasn’t Servant 5, it was servant 2!\nServant 2: It wasn’t Servant 3, it wasn’t Servant 5!\nServant 3: It was Servant 5, it wasn’t Servant 1!\nServant 4: It was Servant 3, it was Servant 2!\nServant 5: It was Servant 4, it wasn’t Servant 1!\nEach servant was known to tell exactly one lie.\nWhich servant took her locket?", "Servant 3", false, 0, "Ask 2 and 4", 7, 3);

		//ROOMS FLOOR 1

		// d_01, d_06, d_13, d_22, d_25, d_27, d_29, d_F1
		ArrayList<Door> rm_00_doors = new ArrayList<>();
		rm_00_doors.add(d_01);
		rm_00_doors.add(d_06);
		rm_00_doors.add(d_13);
		rm_00_doors.add(d_22);
		rm_00_doors.add(d_25);
		rm_00_doors.add(d_27);
		rm_00_doors.add(d_29);
		rm_00_doors.add(d_F1);
		Room rm_00 = new Room("Large Hallway with wooden floors and pillars", rm_00_doors, 100, false, "Main Hallway", null, MonsterFactory.setRoomMonster(00), null);
		roomObj.add(rm_00);
		rooms.clear();

		// d_01, d_02, d_03, d_05
		// art_18
		ArrayList<Door> rm_01_doors = new ArrayList<>();
		rm_01_doors.add(d_01);
		rm_01_doors.add(d_02);
		rm_01_doors.add(d_03);
		rm_01_doors.add(d_05);
		Room rm_01 = new Room("The entrance garden, it contains a few trees and hydrangea flowers.", rm_01_doors, 101, false, "South Garden", null, MonsterFactory.setRoomMonster(1), artifactList.get(18));
		roomObj.add(rm_01);
		rooms.clear();

		// d_02, d_17, d_19, d_29
		// art_08
		ArrayList<Door> rm_02_doors = new ArrayList<>();
		rm_02_doors.add(d_02);
		rm_02_doors.add(d_17);
		rm_02_doors.add(d_19);
		rm_02_doors.add(d_29);
		Room rm_02 = new Room("A plain garden with bamboo trees.", rm_02_doors, 102, false, "West Garden", puz_01, null, artifactList.get(8));
		roomObj.add(rm_02);
		rooms.clear();

		// d_14, d_16, d_18, d_19, d_20, d_21
		// art_06
		ArrayList<Door> rm_03_doors = new ArrayList<>();
		rm_03_doors.add(d_14);
		rm_03_doors.add(d_16);
		rm_03_doors.add(d_18);
		rm_03_doors.add(d_19);
		rm_03_doors.add(d_20);
		rm_03_doors.add(d_21);
		Room rm_03 = new Room("A garden with a small pond filled with lotus flowers", rm_03_doors, 103, false, "North Garden", null, MonsterFactory.setRoomMonster(3), artifactList.get(6));
		roomObj.add(rm_03);
		rooms.clear();

		// d_08, d_11, d_14, d_15
		ArrayList<Door> rm_04_doors = new ArrayList<>();
		rm_04_doors.add(d_08);
		rm_04_doors.add(d_11);
		rm_04_doors.add(d_14);
		rm_04_doors.add(d_15);
		Room rm_04 = new Room("A garden normally used an outside training, it has a cherry blossom tree in the middle.", rm_04_doors, 104, false, "Northeast Garden", null, MonsterFactory.setRoomMonster(4), null);
		roomObj.add(rm_04);
		rooms.clear();

		// d_03, d_04, d_07, d_09, d_12
		ArrayList<Door> rm_05_doors = new ArrayList<>();
		rm_05_doors.add(d_03);
		rm_05_doors.add(d_04);
		rm_05_doors.add(d_07);
		rm_05_doors.add(d_09);
		rm_05_doors.add(d_12);
		Room rm_05 = new Room("A garden with beautiful stone and plant arrangement ", rm_05_doors, 105, false, "Southeast Garden", null, MonsterFactory.setRoomMonster(5), null);
		roomObj.add(rm_05);
		rooms.clear();

		// d_17, d_18
		// art_16
		ArrayList<Door> rm_06_doors = new ArrayList<>();
		rm_06_doors.add(d_17);
		rm_06_doors.add(d_18);
		Room rm_06 = new Room("Many tools lie here, most of them are used to care for the gardens. There’s a ladder here.", rm_06_doors, 106, false, "Northwest Shed", null, MonsterFactory.setRoomMonster(6), artifactList.get(16));
		roomObj.add(rm_06);
		rooms.clear();

		// d_04, d_05
		// art_04
		ArrayList<Door> rm_07_doors = new ArrayList<>();
		rm_07_doors.add(d_04);
		rm_07_doors.add(d_05);
		Room rm_07 = new Room("Multiple tools that are used to care the garden and a bucket", rm_07_doors, 107, false, "Southeast Shed", puz_02, null, artifactList.get(4));
		roomObj.add(rm_07);
		rooms.clear();

		// d_15, d_16
		// art_01
		ArrayList<Door> rm_08_doors = new ArrayList<>();
		rm_08_doors.add(d_15);
		rm_08_doors.add(d_16);
		Room rm_08 = new Room("Beautifully crafted deck, looks like a gazebo. It has the best view of the moon.", rm_08_doors, 108, false, "Moon viewing deck", null, MonsterFactory.setRoomMonster(8), artifactList.get(1));
		roomObj.add(rm_08);
		rooms.clear();

		// d_06, d_07
		// art_05
		ArrayList<Door> rm_09_doors = new ArrayList<>();
		rm_09_doors.add(d_06);
		rm_09_doors.add(d_07);
		Room rm_09 = new Room("Tables are clothed with fine materials and everything is neatly placed.", rm_09_doors, 109, false, "Tea Room", null, MonsterFactory.setRoomMonster(9), artifactList.get(5));
		roomObj.add(rm_09);
		rooms.clear();

		// d_22, d_23, d_24
		ArrayList<Door> rm_10_doors = new ArrayList<>();
		rm_10_doors.add(d_22);
		rm_10_doors.add(d_23);
		rm_10_doors.add(d_24);
		Room rm_10 = new Room("A room before then outdoor bath. Guest and travelers here wash themselves before bathing.", rm_10_doors, 110, false, "Wash Room", null, MonsterFactory.setRoomMonster(10), null);
		roomObj.add(rm_10);
		rooms.clear();

		// d_23
		ArrayList<Door> rm_11_doors = new ArrayList<>();
		rm_11_doors.add(d_23);
		Room rm_11 = new Room("An unexpectedly clean room.", rm_11_doors, 111, false, "Toilet", null, MonsterFactory.setRoomMonster(11), null);
		roomObj.add(rm_11);
		rooms.clear();

		// d_24
		// art_09
		ArrayList<Door> rm_12_doors = new ArrayList<>();
		rm_12_doors.add(d_24);
		Room rm_12 = new Room("An outdoor bath, it looks like someone recently used it.", rm_12_doors, 112, false, "Outdoor Bath", null, MonsterFactory.setRoomMonster(12), artifactList.get(9));
		roomObj.add(rm_12);
		rooms.clear();

		// d_20, d_26, d_27
		// art_11
		ArrayList<Door> rm_13_doors = new ArrayList<>();
		rm_13_doors.add(d_20);
		rm_13_doors.add(d_26);
		rm_13_doors.add(d_27);
		Room rm_13 = new Room("A small table lies in the middle of the room. The room is large enough to fit two big families.", rm_13_doors, 113, false, "Dining Room", puz_04, null, artifactList.get(11));
		roomObj.add(rm_13);
		rooms.clear();

		// d_25, d_26, d_28 
		// art_12
		ArrayList<Door> rm_14_doors = new ArrayList<>();
		rm_14_doors.add(d_25);
		rm_14_doors.add(d_26);
		rm_14_doors.add(d_28);
		Room rm_14 = new Room("Many baskets lay around with fruits in them. On the table is a knife and some red meat.", rm_14_doors, 114, false, "Kitchen", null, MonsterFactory.setRoomMonster(14), artifactList.get(12));
		roomObj.add(rm_14);
		rooms.clear();

		// d_28, d_TD  
		//art_14
		ArrayList<Door> rm_15_doors = new ArrayList<>();
		rm_15_doors.add(d_28);
		rm_15_doors.add(d_TD);
		Room rm_15 = new Room("A small room used to store foods to last one winter. Contains a lot of closed baskets of food.", rm_15_doors, 115, false, "Pantry", null, MonsterFactory.setRoomMonster(15), artifactList.get(14));
		roomObj.add(rm_15);
		rooms.clear();

		// d_10, d_11, d_12, d_13
		ArrayList<Door> rm_16_doors = new ArrayList<>();
		rm_16_doors.add(d_10);
		rm_16_doors.add(d_11);
		rm_16_doors.add(d_12);
		rm_16_doors.add(d_13);
		Room rm_16 = new Room("A hallway with 2 doors and 2 wooden steps, not really interesting here.", rm_16_doors, 116, false, "Small Hallway", null, MonsterFactory.setRoomMonster(16), null);
		roomObj.add(rm_16);
		rooms.clear();

		// d_08, d_09, d_10
		// art_13
		ArrayList<Door> rm_17_doors = new ArrayList<>();
		rm_17_doors.add(d_08);
		rm_17_doors.add(d_09);
		rm_17_doors.add(d_10);
		Room rm_17 = new Room("A large training hall to practice kendo. The floors are clean and there is an odd smell", rm_17_doors, 117, false, "Dojo (Training Hall)", puz_03, null, artifactList.get(13));
		roomObj.add(rm_17);
		rooms.clear();

		//ROOMS FLOOR 2

		// d_30
		ArrayList<Door> rm_18_doors = new ArrayList<>();
		rm_18_doors.add(d_30);
		Room rm_18 = new Room("A vast view of the outside the castle with a hallway that splits the two gardens.", rm_18_doors, 118, false, "Dojo Roof", null, MonsterFactory.setRoomMonster(18), null);
		roomObj.add(rm_18);
		rooms.clear();

		// d_38, d_39
		// art_15
		ArrayList<Door> rm_19_doors = new ArrayList<>();
		rm_19_doors.add(d_38);
		rm_19_doors.add(d_39);
		Room rm_19 = new Room("An L-shaped room with at least a quarter of the room taken up for an unnecessarily big closet...", rm_19_doors, 119, false, "Servant Room", null, MonsterFactory.setRoomMonster(19), artifactList.get(15));
		roomObj.add(rm_19);
		rooms.clear();

		// d_39, d_TD
		// art_02
		ArrayList<Door> rm_20_doors = new ArrayList<>();
		rm_20_doors.add(d_39);
		rm_20_doors.add(d_TD);
		Room rm_20 = new Room("The closet is big enough that it could be mistaken for another guest room. Clothes are hanged and multiple dressers are on the mats. On the wall facing south hangs a sword like weapon. You noticed a trap door underneath the tatami mats and a string attached...", rm_20_doors, 120, false, "Servant Closet", puz_07, null, artifactList.get(2));
		roomObj.add(rm_20);
		rooms.clear();

		// d_34, d_37
		ArrayList<Door> rm_21_doors = new ArrayList<>();
		rm_21_doors.add(d_34);
		rm_21_doors.add(d_37);
		Room rm_21 = new Room("A considerable medium size room with tatami mats and a neatly placed futon in the middle against the west wall.", rm_21_doors, 121, false, "Guest room 1", null, MonsterFactory.setRoomMonster(21), null);
		roomObj.add(rm_21);
		rooms.clear();

		// d_35, d_36, d_37
		// art_17
		ArrayList<Door> rm_22_doors = new ArrayList<>();
		rm_22_doors.add(d_35);
		rm_22_doors.add(d_36);
		rm_22_doors.add(d_37);
		Room rm_22 = new Room("The second guest room is a smaller sized room compared to the guest room to make room for the closet. The layout is the same with a futon on top of tatami mats.", rm_22_doors, 122, false, "Guest Room 2", null, MonsterFactory.setRoomMonster(22), artifactList.get(17));
		roomObj.add(rm_22);
		rooms.clear();

		// d_36
		ArrayList<Door> rm_23_doors = new ArrayList<>();
		rm_23_doors.add(d_36);
		Room rm_23 = new Room("A small room, small in width and the length is long. It’s able to hold a dozen of clothes for guests that plans to stay for more than a few weeks.", rm_23_doors, 123, false, "Guest room 2 - Closet", null, MonsterFactory.setRoomMonster(23), null);
		roomObj.add(rm_23);
		rooms.clear();

		// d_32, d_33
		// art_10
		ArrayList<Door> rm_24_doors = new ArrayList<>();
		rm_24_doors.add(d_32);
		rm_24_doors.add(d_33);
		Room rm_24 = new Room("A luxurious bed in the middle of the room. The wall contains some decorative ornaments and beside that is a closet door.", rm_24_doors, 124, false, "Bedroom", null, MonsterFactory.setRoomMonster(24), artifactList.get(10));
		roomObj.add(rm_24);
		rooms.clear();

		// d_33
		// art_03
		ArrayList<Door> rm_25_doors = new ArrayList<>();
		rm_25_doors.add(d_33);
		Room rm_25 = new Room("A small room enough to fit two adults. It contains some clothes.", rm_25_doors, 125, false, "Bedroom Closet", null, MonsterFactory.setRoomMonster(25), artifactList.get(3));
		roomObj.add(rm_25);
		rooms.clear();

		// d_30, d_31, d_32, d_34, d_35, d_38, d_F1, d_F2
		ArrayList<Door> rm_26_doors = new ArrayList<>();
		rm_26_doors.add(d_30);
		rm_26_doors.add(d_31);
		rm_26_doors.add(d_32);
		rm_26_doors.add(d_34);
		rm_26_doors.add(d_35);
		rm_26_doors.add(d_38);
		rm_26_doors.add(d_F1);
		rm_26_doors.add(d_F2);
		Room rm_26 = new Room("An enormous hallway that leads to multiple rooms: servant, guests, bedroom, study room, and a roof that leads outside on top of the dojo.", rm_26_doors, 126, false, "Second Floor Hall Way", null, MonsterFactory.setRoomMonster(26), null);
		roomObj.add(rm_26);
		rooms.clear();

		// d_31
		//art_11
		ArrayList<Door> rm_27_doors = new ArrayList<>();
		rm_27_doors.add(d_31);
		Room rm_27 = new Room("The largest room on floor 2. It contains multiple pages lying on the ground with a table and some books. It looks like a mess.", rm_27_doors, 127, false, "Study Room", puz_06, null, artifactList.get(11));
		roomObj.add(rm_27);
		rooms.clear();

		//ROOMS FLOOR 3

		// d_40, d_F2
		// art_07
		ArrayList<Door> rm_28_doors = new ArrayList<>();
		rm_28_doors.add(d_40);
		rm_28_doors.add(d_F2);
		Room rm_28 = new Room("A large, circular, room with large windows and instruments to view the heavens.", rm_28_doors, 128, false, "Observatory", puz_05, null, artifactList.get(7));
		roomObj.add(rm_28);
		rooms.clear();

		// d_40
		ArrayList<Door> rm_29_doors = new ArrayList<>();
		rm_29_doors.add(d_40);
		Room rm_29 = new Room("A large open platform protruding from the back of the house, with a bamboo railing of intricate lattice work.", rm_29_doors, 129, false, "Third Floor Balcony", null, MonsterFactory.setRoomMonster(29), null);
		roomObj.add(rm_29);
		rooms.clear();

		return roomObj;
	}
}
