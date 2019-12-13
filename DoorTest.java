import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    private Door testDoor,lockDoor;
    private Lock alock;
    
    /**
     * A door can be linked to an only key which allow to open this one. Attribute a specific key to a door.
     */
    private Key keytest; 
    
    
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
        keytest = new Key("keytest");
        alock  = new Lock(keytest);
        testDoor = new Door(room1,"East",room2,"West");
        lockDoor = new Door(room1,"sud",room2,"nord",keytest,alock);
    }
    @Test
    /**
     * Test if we can get the lock of he locked door
     */
    public void testGetLockDoor()
    {
        assertEquals(alock, lockDoor.getLockDoor() );
    }
    
    @Test
    /**
     * Test if we can created the exit of the 2 room that the door linked
     * 
     */
    public void testCreateDoorNoLock()
    {
        testDoor.createDoor(room1,"East",room2,"West");
        
        assertNotEquals( null ,room1.checkExits() );
    }
    @Test
    /**
     * Test if we can created the exit of the 2 room that the door linked but the door has a lock
     * 
     */
    public void testCreateDoorLock()
    {
        testDoor.createDoor(room1,"East",room2,"West" ,keytest , alock  );
        
        assertNotEquals( null ,room1.checkExits() );
    }
        
    @Test
    /**
     * Test if we can pass trough the door by the current room
     * 
     */
    public void testCrossDoor()
    {
        
        assertEquals( room2 ,testDoor.crossDoor(room1) );
    }
    @Test
    /**
     * Test if we can pass trough the door by opposite room
     * 
     */
    public void testCrossDoorOpposite()
    {
        
        assertEquals( room1 ,testDoor.crossDoor(room2) );
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

