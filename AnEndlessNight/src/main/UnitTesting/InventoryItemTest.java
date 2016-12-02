package main.UnitTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.InventorySystem.Artifact;
import main.InventorySystem.InventoryItem;
import main.InventorySystem.InventoryStackFullError;

/**
 * This class test the InventoryItem functions to ensure they work properly.
 * @author Aaron
 *
 */
public class InventoryItemTest {
	
	/**
	 * Tests the increment count
	 * @throws InventoryStackFullError 
	 */
	@Test
	public void testIncrementCount() throws InventoryStackFullError 
	{
		Artifact testArtifact = new Artifact("Test Item", null, 0);
		// testItem starts with a count of one
		InventoryItem testItem = new InventoryItem(testArtifact, 5);
		
		testItem.incrementCount();
		
		// test that count is now 2
		assertEquals(testItem.getCount(), 2);
		
	}
	/**
	 * Tests the increment count for expected exception.
	 * @throws InventoryStackFullError
	 */
	@Test(expected=InventoryStackFullError.class)
	public void testIncrementCountException() throws InventoryStackFullError 
	{
		Artifact testArtifact = new Artifact("Test Item", null, 0);
		// testItem starts with a count of one
		InventoryItem testItem = new InventoryItem(testArtifact, 1);
		
		testItem.incrementCount(); // now 2, which should be out of bounds
	}
	
	/**
	 * Test to make sure decrement count works properly.
	 */
	@Test
	public void testDecrementCount()
	{
		Artifact testArtifact = new Artifact("Test Item", null, 0);
		// testItem starts with a count of one
		InventoryItem testItem = new InventoryItem(testArtifact, 1);
		
		testItem.decrementCount();
		
		assertEquals(testItem.getCount(), 0);
		
	}
	
	@Test
	public void testEqualsTrue()
	{
		Artifact testArtifact = new Artifact("Test Item", null, 0);
		// testItem starts with a count of one
		InventoryItem testItem = new InventoryItem(testArtifact, 1);
		
		// create new inventory item with same artifact
		Artifact duplicateArtifact = new Artifact("Duplicate Item", null, 0);
		InventoryItem duplicateItem = new InventoryItem(duplicateArtifact, 1);
		
		assertTrue(testItem.equals(duplicateItem));
		
	}
	
	@Test
	public void testEqualsFalse() 
	{
		Artifact testArtifact = new Artifact("Test Item", null, 0);
		// testItem starts with a count of one
		InventoryItem testItem = new InventoryItem(testArtifact, 1);
		
		// create new inventory item with different artifact
		Artifact newArtifact = new Artifact("New Test Item", null, 1);
		InventoryItem newItem = new InventoryItem(newArtifact, 1);

		assertFalse(testItem.equals(newItem));
	}
	
}
