package main.RoomSystem;

import main.CombatSystem.Monster;
import main.InventorySystem.Artifact;

public class RoomLibrary 
{
	private int roomID;
	private String roomDesc;
	private int doorID;
	private String doorDesc;
	private Door door;
	private Monster monster = null;
	private Artifact artifact;
	
	public RoomLibrary(int roomID, String roomDesc, int doorID,
			String doorDesc, Door door, Monster monster, Artifact artifact) 
	{
		this.roomID = roomID;
		this.roomDesc = roomDesc;
		this.doorID = doorID;
		this.doorDesc = doorDesc;
		this.door = door;
		this.monster = monster;
		this.artifact = artifact;
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
	
	
}
