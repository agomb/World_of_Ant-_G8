import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DoorTest.
 *
 * @author  Marion Guernoté and Alix Nagot
 * @version 13/11/2019
 */
public class DoorTest
{
     /**
     * The list of room contains the two rooms linked to a door. 
     * That will always be a list of 2 rooms, not less, not more.
     */
    private Room room1;
    private Room room2;
    private Door theDoor;
    private Lock alock;
    
    /**
     * A door can be linked to an only key which allow to open this one. Attribute a specific key to a door.
     */
    private Key key; 
    
    
    public DoorTest()
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
        room1 = new Room("cuisine");
        room2 = new Room("tunnel");
        alock  = new Lock(3);
        theDoor = new Door(room1,"sud",room2,"nord",alock);
    }
    @Test
    /**
     * 
     */
    public void testCrossInvalid()
    {
        assertEquals(theDoor.cross(),room1);
    
    }
    
    @Test
    /**
     * 
     */
    public void testCrossValid()
    {
        assertEquals(theDoor.cross(),room2);
    
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

