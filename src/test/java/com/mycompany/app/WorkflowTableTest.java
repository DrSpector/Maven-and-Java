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

	

	//setNext returns an ID
	@Test
	public void setNext1()
	{
		assertEquals(0,wft.setNext(a));
		assertEquals(1,wft.setNext(b));
		wft.removeFirst();
		wft.removeFirst();
	}

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
	
	//wft should be empty, null should be returned when peeked.
	@Test
	public void getFirst3()
	{
		wft.setNext(a);
		wft.removeFirst();
		assertNull(wft.getFirst());
	}

	//wft should be empty, null should be returned when popped.
	@Test
	public void removeFirst3()
	{
		wft.setNext(a);
		wft.removeFirst();
		assertNull(wft.removeFirst());
	}
	
	
}
