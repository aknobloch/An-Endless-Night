package main.RoomSystem;

import java.util.ArrayList;

import main.CombatSystem.Monster;
import main.InventorySystem.Artifact;

public class RoomLibrary 
{

	public ArrayList<Room> roomGen()
	{
		ArrayList<Integer> doors = new ArrayList<Integer>();
		ArrayList<Door> doorObj = new ArrayList<Door>();
		
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

		doors.add(100);
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
		
		//FLOOR 2
		doors.add();
		Door d_TD = new Door(doors, 666);
		doorObj.add(d_TD);
		doors.clear();
		
		Room room0 = new Room("Large Hallway with wooden floors and pillars", );
		return roomGen();
		
	}
	
}

//output to a .dat file
//generate method and load method 


//FLOOR 1
//Rm_00 Main Hallway  "Large Hallway with wooden floors and pillars"
//Rm_01 South Garden "The entrance garden, it contains a few trees and hydrangea flowers"
//Rm_02 West Garden "A plain garden with bamboo trees."
//Rm_03 North Garden "A garden with a small pond filled with lotus flowers"
//Rm_04 Northeast Garden "A garden normally used an outside training, it has a cherry blossom tree in the middle."
//Rm_05 Southeast Garden "A garden with beautiful stone and plant arrangement"
//Rm_06 Northwest Shed "Many tools lie here, most of them are used to care for the gardens. There’s a ladder here"
//Rm_07 Southeast Shed "Multiple tools that are used to care the garden and a bucket"
//Rm_08 Moon viewing Deck "Beautifully crafted deck, looks like a gazebo. It has the best view of the moon." 
//Rm_09 Tea Room "Tables are clothed with fine materials and everything is neatly placed."
//Rm_10 Wash Room "A room before then outdoor bath. Guest and travelers here wash themselves before bathing."
//Rm_11 Toilet "An unexpected clean room"
//Rm_12 Outdoor Bath "An outdoor bath, it looks like someone recently used it."
//Rm_13 Dining Room "A small table lies in the middle of the room. The room is large enough to fit two big families."
//Rm_14 Kitchen "Many baskets lay around with fruits in them. On the table is a knife and some red meat."
//Rm_15 Pantry "A small room used to store foods to last one winter. Contains a lot of closed baskets of food."
//Rm_16 Small Hallway "A hallway with 2 doors and 2 wooden steps,  not really interesting here."
//Rm_17 Training Hall "A large training hall to practice kendo. The floors are clean and there is an odd smell."

//FLOOR 2 
//Rm_18 Dojo Roof "A vast view of the outside the castle with a hallway that splits the two gardens."
//Rm_19 Servant Room "An L-shaped room with at least a quarter of the room taken up for an unnecessarily big closet..."
//Rm_20 Servant Closet "The closet is big enough that it could be mistaken for another guest room. Clothes are hanged and multiple dressers are on the mats. On the wall facing south hangs a sword like weapon. You noticed a trap door underneath the tatami mats and a string attached..."
//Rm_21 Guest 1 Room "A considerable medium size room with tatami mats and a neatly placed futon in the middle against the west wall."
//Rm_22 Guest 2 Room "The second guest room is a smaller sized room compared to the guest room to make room for the closet. The layout is the same with a futon on top of tatami mats"
//Rm_23 Guest 2 Closet "A small room, small in width and the length is long. It’s able to hold a dozen of clothes for guests that plans to stay for more than a few weeks."
//Rm_24 Bedroom "A luxurious bed in the middle of the room. The wall contains some decorative ornaments and beside that is a closet door."
//Rm_25 Bedroom closet "A small room enough to fit two adults. It contains some clothes"
//Rm_26 F2 Hallway "An enormous hallway that leads to multiple rooms: servant, guests, bedroom, study room, and a roof that leads outside on top of the dojo."
//Rm_27 Study Room "The largest room on floor 2. It contains multiple pages lying on the ground with a table and some books. It looks like a mess"

//FLOOR 3
//Rm_28 Observatory "A large, circular, room with large windows and instruments to view the heavens."
//Rm_29 F3 Balcony "A large open platform protruding from the back of the house, with a bamboo railing of intricate lattice work."


