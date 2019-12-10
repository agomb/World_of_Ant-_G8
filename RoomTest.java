import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  Angelique, Dylan
 * @version 13/11/2019
 */
public class RoomTest
{
    Room cuisine;
    Room room2;
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cuisine = new Room("Cuisine");
        room2 = new Room("tunnel");
    }
    @Test
    /**
     * 
     */
    public void testgetExit()
    {
        assertEquals(cuisine.getExit(),null);
    }
    
    @Test
    /**
     * 
     */
    public void testaddExit()
    {   
        
        Lock alock  = new Lock(3);
        Door theDoor = new Door(cuisine,"south",room2,"north",alock);
        
        cuisine.addExit(theDoor, "south");
        assertEquals(cuisine.getExit(),null);
    }
    @Test
    /**
     * 
     */
    public void testgetDescr()
    {   
        assertEquals(cuisine.getDescr(),"cuisine");
    }
    
    @Test
    /**
     * 
     */
    public void testgetItem()
    {   
        assertEquals(cuisine.getItem(),null);
    }
    
    @Test
    /**
     * 
     */
    public void testaddItem()
    {   Item anItem = new Item("test");
        cuisine.addItem(anItem);
        assertEquals(cuisine.getItem(),null);
    }
    
    
    /**
     * 
     */
    public void testremoveItem(Item anItem)
    {
        
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}