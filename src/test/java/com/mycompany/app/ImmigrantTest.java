import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ImmigrantTest {
	private Immigrant immigrant = null;
	private Immigrant immigrant3 = null;
	Database database = new Database();
	public static void main(String[] args)
    {
        org.junit.runner.JUnitCore.main("ImmigrantTest");
    }
	
    @Before
    public void setUp() {
    	immigrant = new Immigrant("John", "Doe", "123456");
	    database.setImmigrant(immigrant);
	    database.setImmigrant(new Immigrant("Joe","Deck","0987654"));

    }
/**
* This test method, testCreateImmigrant, is designed to validate the functionality
* of the createImmigrant method in the Immigrant class. The test covers the following scenarios:
* 1. Creating an immigrant with valid data.
* 2. Verifying the correctness of the immigrant's attributes.
* 3. Creating an immigrant with specific data using the Immigrant constructor.
* 4. Creating an immigrant with null values using the Immigrant constructor.
* 5. Ensuring that the 'status' attribute is initialized to an empty string.
*
* Note: The actual implementation of the createImmigrant method is assumed to be handled
* appropriately, and any dependencies, such as Database.getImmigrant, are mocked or managed
* for testing purposes.
*/
    @Test
    public void testCreateImmigrant() {
        //Assuming Database.getImmigrant is a mock or is handled appropriately in testing
        //Immigrant createdImmigrant = immigrant.createImmigrant("John", "Doe", "123456");
        
        assertNotNull(immigrant);
        assertEquals(null, immigrant3);
        
        assertEquals("John", immigrant.getFirstName());
        assertEquals("Doe", immigrant.getLastName());
        assertEquals("123456", immigrant.getAlienID());
        //add NOV 25 DL
        assertEquals("", immigrant.getStatus());
        
        immigrant3 = new Immigrant("Joe", "Deck", "0987654");
        assertEquals("Joe", immigrant3.getFirstName());
        assertEquals("Deck", immigrant3.getLastName());
        assertEquals("0987654", immigrant3.getAlienID());
        //add NOV 25 DL
        assertEquals("", immigrant3.getStatus());

        immigrant3 = new Immigrant(null, null, null);
        assertEquals(null, immigrant3.getFirstName());
        assertEquals(null, immigrant3.getLastName());
        assertEquals(null, immigrant3.getAlienID());
        assertEquals("", immigrant3.getStatus());
    }
/**
 * This test method, testCreateImmigrant1, verifies the behavior of the createImmigrant1
 * method in the Immigrant class. The method is expected to create an Immigrant object
 * with the specified parameters and handle null values appropriately. The test covers
 * the following scenarios:
 * 1. Creating an Immigrant with a null first name.
 * 2. Creating an Immigrant with a null last name.
 * 3. Creating an Immigrant with a null alien ID.
 * 4. Creating an Immigrant with valid parameters (non-null values).
 *    The created Immigrant object is assigned to the 'immigrant3' variable for further validation.
 * 
 * Note: The actual implementation of the createImmigrant1 method is assumed to handle null values
 * appropriately and return null if any of the required parameters is null.
 */
	@Test
    public void testCreateImmigrant1() {

	immigrant = Immigrant.createImmigrant1(null,"lorem","ipsum");
	assertNull(immigrant);

	immigrant = Immigrant.createImmigrant1("lorem",null,"ipsum");
	assertNull(immigrant);

	immigrant = Immigrant.createImmigrant1("lorem","ipsum",null);
	assertNull(immigrant);

    immigrant3 = Immigrant.createImmigrant1("0987654", "Joe","Deck");
	assertNotNull(immigrant3);
    assertEquals("Joe", immigrant3.getFirstName());
    assertEquals("Deck", immigrant3.getLastName());
    assertEquals("0987654", immigrant3.getAlienID());
        
    }
/**
 * This test method, testValidateInfo, validates the behavior of the validateInfo
 * method in the Immigrant class. The method is designed to check whether the
 * necessary fields (first name, last name, and alien ID) are non-null.
 * The test covers the following scenarios:
 * 1. Validating an Immigrant with non-null values for all fields.
 * 2. Validating an Immigrant with a null first name.
 * 3. Validating an Immigrant with a null last name.
 * 4. Validating an Immigrant with a null alien ID.
 * 5. Validating an Immigrant with null values for both first and last names and a non-null alien ID.
 * 6. Validating an Immigrant with null values for all fields.
 * 
 * Note: The actual implementation of the validateInfo method is assumed to return true only
 * if all required fields (except status) are non-null.
 */
    // Any of the field except status cannot be null.
    @Test
    public void testValidateInfo() {
        assertTrue(immigrant.validateInfo());
        
        // Test with null values
        immigrant = new Immigrant(null, "Doe", "123456");
        assertFalse(immigrant.validateInfo());
        
        immigrant = new Immigrant("John", null, "123456");
        assertFalse(immigrant.validateInfo());
        
        immigrant = new Immigrant("John", "Doe", null);
        assertFalse(immigrant.validateInfo());

        //add NOV 25 2023 DL

        immigrant = new Immigrant(null, null, "12346");
        assertFalse(immigrant.validateInfo());

        immigrant = new Immigrant(null, null, null);
        assertFalse(immigrant.validateInfo());
        
    }
/**
 * This test method, testCompareTo, evaluates the behavior of the compareTo method
 * in the Immigrant class. The method is expected to compare two Immigrant objects
 * based on their first names in alphabetical order. The test covers the following scenarios:
 * 1. Comparing an Immigrant with a first name ("John") that comes after another Immigrant
 *    with a different first name ("Alice"). The expected result is greater than 0.
 * 2. Comparing an Immigrant with the same first name ("John") as another Immigrant. 
 *    The expected result is 0 since the first names are identical.
 * 
 * Note: The actual implementation of the compareTo method is assumed to compare
 * Immigrant objects based on their first names and return the appropriate result.
 */
    @Test
    public void testCompareTo() {
        Immigrant immigrant2 = new Immigrant("Alice", "Smith", "789012");
        assertTrue(immigrant.compareTo(immigrant2) > 0); // John comes after Alice in alphabetical order

        // Test with the same first name
        immigrant2 = new Immigrant("John", "Smith", "789012");
        assertTrue(immigrant.compareTo(immigrant2) == 0); // Same first name, should return 0
    }
/**
 * This test method, testSetStatus, verifies the functionality of the setStatus
 * method in the Immigrant class. The method is designed to set the status of
 * an Immigrant and ensure that the status is updated correctly. The test covers
 * the following scenarios:
 * 1. Checking that the status is initially an empty string.
 * 2. Setting the status to "Pending" and confirming the update.
 * 3. Setting the status to "Approved" and confirming the update.
 * 
 * Note: The actual implementation of the setStatus method is assumed to correctly
 * update the 'status' attribute of the Immigrant object.
 */
    @Test
    public void testSetStatus() {
        //status should be empty string intially
        assertEquals(immigrant.getStatus(),"");
		
		
        immigrant.setStatus("Pending");
        assertEquals("Pending", immigrant.getStatus());
        
        immigrant.setStatus("Approved");
        assertEquals("Approved", immigrant.getStatus());
    }
/**
 * This test method, testEquals, evaluates the correctness of the equals method
 * in the Immigrant class. The method is expected to compare two Immigrant objects
 * for equality based on their first name, last name, and alien ID. The test covers
 * the following scenarios:
 * 1. Comparing two identical Immigrant objects. The expected result is true.
 * 2. Comparing two different Immigrant objects with a different first name.
 *    The expected result is false.
 * 3. Comparing two different Immigrant objects with a different last name.
 *    The expected result is false.
 * 4. Comparing two different Immigrant objects with a different alien ID.
 *    The expected result is false.
 * 
 * Note: The actual implementation of the equals method is assumed to correctly
 * compare Immigrant objects based on their first name, last name, and alien ID.
 */
	@Test
	public void testEquals()
	{
		Immigrant immigrant4 = new Immigrant("John", "Doe", "123456");
		assertTrue(immigrant4.equals(new Immigrant("John", "Doe", "123456")));

        //add NOV 25 DL
        //Test two different immigrant.
		assertFalse(immigrant4.equals(new Immigrant("Bob", "Doe", "123456")));

        assertFalse(immigrant4.equals(new Immigrant("John", "Joe", "123456")));

        assertFalse(immigrant4.equals(new Immigrant("John", "Doe", "123457")));
	}

}
