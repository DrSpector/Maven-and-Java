import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class WorkflowTableTest {

	WorkflowTable wft;
	Immigrant a,b,c;
	
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

	

	//setNext returns an ID
	@Test
	public void setNext1()
	{
		assertEquals(1,wft.setNext(a));
	}

	//setNext returns -1 if given a bad item to add
	@Test
	public void setNext2()
	{
		assertNotEquals(-1,wft.setNext(null));
	}

	//Peeking at wft should return a
	@Test
	public void getFirst1()
	{
		
		assertEquals(a,wft.getFirst());
	}
	//Peeking at wft should not return b
	@Test
	public void getFirst2()
	{
		wft.setNext(b);
		assertNotEquals(b,wft.getFirst());
	}
	
	//Test that a is still in index 0
	@Test
	public void getFirst3()
	{
		assertEquals(a,wft.getFirst());
	}
	
	//Popping wft should return a. a should then no longer be in wft
	@Test
	public void removeFirst1()
	{
		assertEquals(a, wft.removeFirst());
		assertNotEquals(a,wft.getFirst());
		
	}

	//Popping wft should now return b. a should then no longer be in wft
	@Test
	public void removeFirst2()
	{
		assertEquals(b,wft.removeFirst());
		assertNotEquals(b,wft.getFirst());
	}
	
	//wft should be empty, null should be returned when peeked.
	@Test
	public void getFirst4()
	{
		assertNull(wft.getFirst());
	}

	//wft should be empty, null should be returned when popped.
	@Test
	public void removeFirst4()
	{
		assertNull(wft.removeFirst());
	}
	
	
}
