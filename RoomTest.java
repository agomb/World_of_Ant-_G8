import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * The test for class Room.
 *
 * @author  Angelique, Dylan
 * @version 13/11/2019
 */
public class RoomTest
{
    Room room1;
    Room room2;
    
    Door testDoor;
    
    Key keytest;
    
    Lock alock;
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
        room1 = new Room("cuisine");
        room2 = new Room("tunnel");
        keytest = new Key("keytest");
        alock  = new Lock(keytest);
        testDoor = new Door(room1,"East",room2,"West");
        
    }
    @Test
    /**
     *  Test if we can an exit to the room
     */
    public void testCheckExits()
    {   
        List<String> exitlist = new ArrayList<String>();
        assertEquals( exitlist ,room1.checkExits() );
    }
    
    @Test
    /**
     *  Test if we can an exit to the room
     */
    public void testaddExit()
    {   
        room1.addExit(room1,"East",testDoor);
        assertNotEquals( null ,room1.checkExits() );
    }
    @Test
    /**
     * Test if we can get the description of the room
     */
    public void testgetDescr()
    {   
        assertEquals(room1.getDescription(),"cuisine");
    }
    
    @Test
    /**
     * Test if we can get the list of item inside the room
     */
    public void testgetItem()
    {   List<Item> listitem = new ArrayList<Item>();
        assertEquals(room1.getItem(),listitem);
    }
    
    @Test
    /**
     * Test if we can add an item to the room
     */
    public void testaddItem()
    {   
        Item anItem = new Item("test");
        room1.addItem(anItem);
        assertNotEquals(room1.getItem(),null);
    }
    
    @Test
    /**
     * Test if we can remove an item inside the room
     */
    public void testremoveItem()
    {
        List<Item> listitem = new ArrayList<Item>(); //create an empty list of item
        Item anItem = new Item("test");
        room1.addItem(anItem);
        room1.removeItem(anItem);
        
        assertEquals(room1.getItem(),listitem);
    }
    
    
    @Test
    /**
     *  Test if we can choose an exit of the room
     */
    public void testChooseExit()
    {   
        room1.addExit(room1,"East",testDoor);
        assertEquals( testDoor ,room1.chooseExit(room1,"East") );
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