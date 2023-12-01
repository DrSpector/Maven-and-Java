import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class WorkflowTableTest {

	
	Immigrant a,b,c;
	WorkflowTable wft;
	public static void main(String[] args)
	{	
		
		
		org.junit.runner.JUnitCore.main("DataEntryTest");
	}

	//Initialize some Immigrant Objects to test with.
	@Before
	public void testInit()
	{
		
		a = new Immigrant("Jeff","Stevens","A54f6");
		b = new Immigrant("Waldo","Warrenton","GF4TR");
		
	}

	/**
 * This test method, setNext1, tests the setNext method in the context of a workflow
 * represented by the 'wft' object. The method is expected to:
 * 1. Set the next step in the workflow using the 'setNext' method with object 'a'.
 *    The expected result is 0, indicating that the setNext operation was successful.
 * 2. Set the next step in the workflow using the 'setNext' method with object 'b'.
 *    The expected result is 1, indicating that the setNext operation was successful.
 * 3. Remove the first two steps from the workflow using the 'removeFirst' method.
 *    This simulates progressing through the workflow.
 * 
 * Note: The actual implementation of the setNext and removeFirst methods in the
 * workflow class ('wft') is assumed to be correct and functioning as intended.
 */

	//setNext returns an ID
	@Test
	public void setNext1()
	{
		assertEquals(0,wft.setNext(a));
		assertEquals(1,wft.setNext(b));
		wft.removeFirst();
		wft.removeFirst();
	}
/**
 * This test method, setNext2, tests the setNext method in the context of a workflow
 * represented by the 'wft' object. The method is expected to:
 * 1. Attempt to set the next step in the workflow using the 'setNext' method with a null object.
 *    The expected result is not equal to -1, indicating that the setNext operation was allowed.
 * 2. Remove the first step from the workflow using the 'removeFirst' method.
 * 
 */
	//setNext returns -1 if given a bad item to add
	@Test
	public void setNext2()
	{
		
		assertNotEquals(-1,wft.setNext(null));
		wft.removeFirst();
	}

	//Peeking at wft should return a
	@Test
	public void getFirst1()
	{
		wft.setNext(a);
		assertEquals(a,wft.getFirst());
		wft.removeFirst();
	}
	
/**
 * This test method, getFirst1, tests the getFirst method in the context of a workflow
 * represented by the 'wft' object. The method is expected to:
 * 1. Set the next step in the workflow using the 'setNext' method with object 'a'.
 * 2. Peek at the first step in the workflow using the 'getFirst' method and verify
 *    that the returned object is equal to 'a'.
 * 3. Remove the first step from the workflow using the 'removeFirst' method.
 */
	//Peeking at wft should not return b
	@Test
	public void getFirst2()
	{
		wft.setNext(a);
		wft.setNext(b);
		assertNotEquals(b,wft.getFirst());
		assertEquals(a,wft.getFirst());
		wft.removeFirst();		
		wft.removeFirst();
	}
	

/**
 * This test method, removeFirst1, tests the removeFirst method in the context
 * of a workflow represented by the 'wft' object. The method is expected to:
 * 1. Set the next steps in the workflow using the 'setNext' method with objects 'a' and 'b'.
 * 2. Remove the first step from the workflow using the 'removeFirst' method and verify
 *    that the returned object is equal to 'a'.
 * 3. Assert that the current first step in the workflow is not equal to 'a'.
 * 4. Remove the next step from the workflow using the 'removeFirst' method.
 */
	//Popping wft should return a. a should then no longer be in wft
	@Test
	public void removeFirst1()
	{
		wft.setNext(a);
		wft.setNext(b);
		assertEquals(a, wft.removeFirst());
		assertNotEquals(a,wft.getFirst());
		wft.removeFirst();
		
	}
/**
 * This test method, removeFirst2, tests the removeFirst method in the context
 * of a workflow represented by the 'wft' object. The method is expected to:
 * 1. Set the next steps in the workflow using objects 'a' and 'b'.
 * 2. Remove the first step from the workflow using the 'removeFirst' method.
 * 3. Verify that the returned object is equal to 'a'.
 * 4. Remove the next step from the workflow using the 'removeFirst' method.
 * 5. Assert that the current first step in the workflow is not equal to 'b'.
 */
	//Popping wft should now return b. a should then no longer be in wft
	@Test
	public void removeFirst2()
	{
		wft.setNext(a);
		wft.setNext(b);
		wft.removeFirst();
		assertEquals(b,wft.removeFirst());
		assertNotEquals(b,wft.getFirst());
	}
/**
 * This test method, getFirst3, tests the getFirst method in the context of a workflow
 * represented by the 'wft' object. The method is expected to:
 * 1. Set the next step in the workflow using the 'setNext' method with object 'a'.
 * 2. Remove the first step from the workflow using the 'removeFirst' method.
 * 3. Verify that the result of calling 'getFirst' is null, indicating that the
 *    workflow is empty after the removal.
 */
	//wft should be empty, null should be returned when peeked.
	@Test
	public void getFirst3()
	{
		wft.setNext(a);
		wft.removeFirst();
		assertNull(wft.getFirst());
	}

/**
 * This test method, removeFirst3, tests the removeFirst method in the context
 * of a workflow represented by the 'wft' object. The method is expected to:
 * 1. Set the next step in the workflow using the 'setNext' method with object 'a'.
 * 2. Remove the first step from the workflow using the 'removeFirst' method.
 * 3. Verify that the result of calling 'removeFirst' is null, indicating that
 *    the workflow is empty after the removal.
 */
	//wft should be empty, null should be returned when popped.
	@Test
	public void removeFirst3()
	{
		wft.setNext(a);
		wft.removeFirst();
		assertNull(wft.removeFirst());
	}
	
	
}
