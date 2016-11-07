package main.RoomSystem;

import java.util.ArrayList;

public class RoomLibrary 
{
	public ArrayList<Room> roomGen()
	{
		ArrayList<Integer> doors = new ArrayList<Integer>();
		ArrayList<Door> doorObj = new ArrayList<Door>();

		ArrayList<Integer> rooms = new ArrayList<Integer>();
		ArrayList<Room> roomObj = new ArrayList<Room>();

		//FLOOR 1
		//adding doors to rooms, 00 and 01 are the rooms the doors go into
		doors.add(100);
		doors.add(101);
		//passing in doors and doorID
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

		//FLOOR 2********
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

		Room rm_00 = new Room("Large Hallway with wooden floors and pillars", rm_00_doors, 100, false, "Main Hallway", null, null, null);
		roomObj.add(rm_00);
		rooms.clear();

		// d_01, d_02, d_03, d_05
		ArrayList<Door> rm_01_doors = new ArrayList<>();
		rm_01_doors.add(d_01);
		rm_01_doors.add(d_02);
		rm_01_doors.add(d_03);
		rm_01_doors.add(d_05);
		Room rm_01 = new Room("The entrance garden, it contains a few trees and hydrangea flowers.", rm_01_doors, 101, false, "South Garden", null, null, null);
		roomObj.add(rm_01);
		rooms.clear();

		// d_02, d_17, d_19, d_29
		ArrayList<Door> rm_02_doors = new ArrayList<>();
		rm_02_doors.add(d_02);
		rm_02_doors.add(d_17);
		rm_02_doors.add(d_19);
		rm_02_doors.add(d_29);
		Room rm_02 = new Room("A plain garden with bamboo trees.", rm_02_doors, 102, false, "West Garden", null, null, null);
		roomObj.add(rm_02);
		rooms.clear();

		// d_14, d_16, d_18, d_19, d_20, d_21
		ArrayList<Door> rm_03_doors = new ArrayList<>();
		rm_03_doors.add(d_14);
		rm_03_doors.add(d_16);
		rm_03_doors.add(d_18);
		rm_03_doors.add(d_19);
		rm_03_doors.add(d_20);
		rm_03_doors.add(d_21);
		Room rm_03 = new Room("A garden with a small pond filled with lotus flowers", rm_03_doors, 103, false, "North Garden", null, null, null);
		roomObj.add(rm_03);
		rooms.clear();

		// d_08, d_11, d_14, d_15
		ArrayList<Door> rm_04_doors = new ArrayList<>();
		rm_04_doors.add(d_08);
		rm_04_doors.add(d_11);
		rm_04_doors.add(d_14);
		rm_04_doors.add(d_15);
		Room rm_04 = new Room("A garden normally used an outside training, it has a cherry blossom tree in the middle.", rm_04_doors, 104, false, "Northeast Garden", null, null, null);
		roomObj.add(rm_04);
		rooms.clear();

		// d_03, d_04, d_07, d_09, d_12
		ArrayList<Door> rm_05_doors = new ArrayList<>();
		rm_05_doors.add(d_03);
		rm_05_doors.add(d_04);
		rm_05_doors.add(d_07);
		rm_05_doors.add(d_09);
		rm_05_doors.add(d_12);
		Room rm_05 = new Room("A garden with beautiful stone and plant arrangement ", rm_05_doors, 105, false, "Southeast Garden", null, null, null);
		roomObj.add(rm_05);
		rooms.clear();

		// d_17, d_18
		ArrayList<Door> rm_06_doors = new ArrayList<>();
		rm_06_doors.add(d_17);
		rm_06_doors.add(d_18);
		Room rm_06 = new Room("Many tools lie here, most of them are used to care for the gardens. There’s a ladder here.", rm_06_doors, 106, false, "Northwest Shed", null, null, null);
		roomObj.add(rm_06);
		rooms.clear();

		// d_04, d_05
		ArrayList<Door> rm_07_doors = new ArrayList<>();
		rm_07_doors.add(d_04);
		rm_07_doors.add(d_05);
		Room rm_07 = new Room("Multiple tools that are used to care the garden and a bucket", rm_07_doors, 107, false, "Southeast Shed", null, null, null);
		roomObj.add(rm_07);
		rooms.clear();

		// d_15, d_16
		ArrayList<Door> rm_08_doors = new ArrayList<>();
		rm_08_doors.add(d_15);
		rm_08_doors.add(d_16);
		Room rm_08 = new Room("Beautifully crafted deck, looks like a gazebo. It has the best view of the moon.", rm_08_doors, 108, false, "Moon viewing deck", null, null, null);
		roomObj.add(rm_08);
		rooms.clear();

		// d_06, d_07
		ArrayList<Door> rm_09_doors = new ArrayList<>();
		rm_09_doors.add(d_06);
		rm_09_doors.add(d_07);
		Room rm_09 = new Room("Tables are clothed with fine materials and everything is neatly placed.", rm_09_doors, 109, false, "Tea Room", null, null, null);
		roomObj.add(rm_09);
		rooms.clear();

		// d_22, d_23, d_24
		ArrayList<Door> rm_10_doors = new ArrayList<>();
		rm_10_doors.add(d_22);
		rm_10_doors.add(d_23);
		rm_10_doors.add(d_24);
		Room rm_10 = new Room("A room before then outdoor bath. Guest and travelers here wash themselves before bathing.", rm_10_doors, 110, false, "Wash Room", null, null, null);
		roomObj.add(rm_10);
		rooms.clear();

		// d_23
		ArrayList<Door> rm_11_doors = new ArrayList<>();
		rm_11_doors.add(d_23);
		Room rm_11 = new Room("An unexpectedly clean room.", rm_11_doors, 111, false, "Toilet", null, null, null);
		roomObj.add(rm_11);
		rooms.clear();

		// d_24
		ArrayList<Door> rm_12_doors = new ArrayList<>();
		rm_12_doors.add(d_24);
		Room rm_12 = new Room("An outdoor bath, it looks like someone recently used it.", rm_12_doors, 112, false, "Outdoor Bath", null, null, null);
		roomObj.add(rm_12);
		rooms.clear();
		
		// d_20, d_26, d_27
		ArrayList<Door> rm_13_doors = new ArrayList<>();
		rm_13_doors.add(d_20);
		rm_13_doors.add(d_26);
		rm_13_doors.add(d_27);
		Room rm_13 = new Room("A small table lies in the middle of the room. The room is large enough to fit two big families.", rm_13_doors, 113, false, "Dining Room", null, null, null);
		roomObj.add(rm_13);
		rooms.clear();

		Room rm_14 = new Room("Many baskets lay around with fruits in them. On the table is a knife and some red meat.", null, 114, false, "Kitchen", null, null, null);
		roomObj.add(rm_14);
		rooms.clear();

		Room rm_15 = new Room("A small room used to store foods to last one winter. Contains a lot of closed baskets of food.", null, 115, false, "Pantry", null, null, null);
		roomObj.add(rm_15);
		rooms.clear();

		Room rm_16 = new Room("A hallway with 2 doors and 2 wooden steps, not really interesting here.", null, 116, false, "Small Hallway", null, null, null);
		roomObj.add(rm_16);
		rooms.clear();

		Room rm_17 = new Room("A large training hall to practice kendo. The floors are clean and there is an odd smell", null, 117, false, "Dojo (Training Hall)", null, null, null);
		roomObj.add(rm_17);
		rooms.clear();

		//ROOMS FLOOR 2

		Room rm_18 = new Room("A vast view of the outside the castle with a hallway that splits the two gardens.", null, 118, false, "Dojo Roof", null, null, null);
		roomObj.add(rm_18);
		rooms.clear();

		Room rm_19 = new Room("An L-shaped room with at least a quarter of the room taken up for an unnecessarily big closet...", null, 119, false, "Servant Room", null, null, null);
		roomObj.add(rm_19);
		rooms.clear();

		Room rm_20 = new Room("The closet is big enough that it could be mistaken for another guest room. Clothes are hanged and multiple dressers are on the mats. On the wall facing south hangs a sword like weapon. You noticed a trap door underneath the tatami mats and a string attached...", null, 120, false, "Servant Closet", null, null, null);
		roomObj.add(rm_20);
		rooms.clear();

		Room rm_21 = new Room("A considerable medium size room with tatami mats and a neatly placed futon in the middle against the west wall.", null, 121, false, "Guest room 1", null, null, null);
		roomObj.add(rm_21);
		rooms.clear();

		Room rm_22 = new Room("The second guest room is a smaller sized room compared to the guest room to make room for the closet. The layout is the same with a futon on top of tatami mats.", null, 122, false, "Guest Room 2", null, null, null);
		roomObj.add(rm_22);
		rooms.clear();

		Room rm_23 = new Room("A small room, small in width and the length is long. It’s able to hold a dozen of clothes for guests that plans to stay for more than a few weeks.", null, 123, false, "Guest room 2 - Closet", null, null, null);
		roomObj.add(rm_23);
		rooms.clear();

		Room rm_24 = new Room("A luxurious bed in the middle of the room. The wall contains some decorative ornaments and beside that is a closet door.", null, 124, false, "Bedroom", null, null, null);
		roomObj.add(rm_24);
		rooms.clear();

		Room rm_25 = new Room("A small room enough to fit two adults. It contains some clothes.", null, 125, false, "Bedroom Closet", null, null, null);
		roomObj.add(rm_25);
		rooms.clear();

		Room rm_26 = new Room("An enormous hallway that leads to multiple rooms: servant, guests, bedroom, study room, and a roof that leads outside on top of the dojo.", null, 126, false, "Second Floor Hall Way", null, null, null);
		roomObj.add(rm_26);
		rooms.clear();

		Room rm_27 = new Room("The largest room on floor 2. It contains multiple pages lying on the ground with a table and some books. It looks like a mess.", null, 127, false, "Study Room", null, null, null);
		roomObj.add(rm_27);
		rooms.clear();

		//ROOMS FLOOR 3

		Room rm_28 = new Room("A large, circular, room with large windows and instruments to view the heavens.", null, 128, false, "Observatory", null, null, null);
		roomObj.add(rm_28);
		rooms.clear();

		Room rm_29 = new Room("A large open platform protruding from the back of the house, with a bamboo railing of intricate lattice work.", null, 129, false, "Third Floor Balcony", null, null, null);
		roomObj.add(rm_29);
		rooms.clear();


		return roomObj;
	}
}

//output to a .dat file
//generate method and load method 

