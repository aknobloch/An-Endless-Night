package Game;

/***
 * Keeps track of item information for the player inventory. 
 * Holds the Artifact as well as a reference to how many of that item the player is holding.
 * @author Aaron
 *
 */

public class InventoryItem {
	
	private Artifact item;
	private int count;
	
	/***
	 * Creates an inventory item with a count of one.
	 * @param item The item associated with this object.
	 */
	public InventoryItem(Artifact item) {
		this.item = item;
		this.count = 1;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Artifact getItem() {
		return item;
	}
	public void incrementCount() {
		this.count++;
	}
	public boolean equals(InventoryItem inItem) {
		return this.item.equals(inItem.item);
	}
	
}
