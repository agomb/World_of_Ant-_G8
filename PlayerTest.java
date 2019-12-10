

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class PlayerTest.
 *
 * @author  Thibault Crouzet, Angelique Gombert G8
 * @version (a version number or a date)
 */
public class PlayerTest
{
    Player thePlayer;
    ArrayList<Item> bag;
    Item helmet;
    
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
        // two rooms are created, they will be separated by the door "testedDoor"
        Room r1test = new Room("c'est la cuisine pour tester");
        Item helmet = new Item("Casque");
        r1test.addItem(helmet);
        Room r2test = new Room("c'est la chambre pour tester");
        // the door is created between r1test (east exit) and r2test (west exit)
        Door testedDoor = new Door(r1test, "east", r2test, "west"); 
        
        thePlayer = new Player("persoDeTest"); // creation of a test character
        bag = new ArrayList<Item>(); // creation of the bag (items list)
        bag.add(new Item("Hache")); // an item is added in the bag
        thePlayer.setCurrentRoom(r1test);
    }
    
    @Test
    public void testNameInValid()
    {
        assertEquals("",thePlayer.getName());
        //assertEquals(expected, actuals);
    }
    
    /**
     * This test if the Player is correctly created
     */
    @Test
    public void testGetterValid()
    {
        assertEquals("persoDeTest",thePlayer.getName());
    }
    
    @Test
    public void testMoveRoom()
    {
        // the player is in room r1test
        Room roomBefore = thePlayer.getCurrentRoom();
        thePlayer.moveRoom();
        // the player is now in room r2test
        Room roomAfter = thePlayer.getCurrentRoom();
        assertEquals(roomAfter.getDescr(), roomBefore.getDescr());
    }
    
    @Test
    public void testPickUp()
    {
        thePlayer.pickUp(helmet);
        //helmet is in the bag
        //fail();
        //assertEquals();
    }
    
    @Test
    public void testDrop()
    {
        thePlayer.drop("");
        fail("Not yet implemented");
        //assertEquals();
    }
    //private List<Item> bag;
    //private int sizeBag;
    @Test
    public void testGetSizeBag()
    {
        
        //fail("Not yet implemented");
        assertEquals(thePlayer.getSizeBag(),20);
    }
    @Test
    public void testGetBag()
    {
        
        //fail("Not yet implemented");
        assertEquals(thePlayer.getBag(),null);
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