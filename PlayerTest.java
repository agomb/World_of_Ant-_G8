

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class PlayerTest.
 *
 * @author  Thibault Crouzet, Angelique Gombert G8
 * @version 2
 */
public class PlayerTest
{
    Player thePlayer;
    ArrayList<Item> bag;
    Item helmet;
    Delivery loot;
    Room r1test,r2test;
    Door testDoor;
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
        r1test = new Room("c'est la cuisine pour tester");
        
        r2test = new Room("c'est la chambre pour tester");
        
        testDoor = new Door(r1test, "East", r2test , "West" );
        
        testDoor.createDoor(r1test, "East", r2test , "West" );
        
        
        helmet = new Item("Casque");
        r1test.addItem(helmet);
        
        // the door is created between r1test (east exit) and r2test (west exit)
        //Door testedDoor = new Door(r1test, "east", r2test, "west"); 
        
        thePlayer = new Player("persoDeTest",r1test); // creation of a test character
        
        loot = new Delivery("loot",r1test);
        
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
    /**
     * This test if the player is moving between room correctly
     */
    public void testMoveRoom()
    {
        // the player is in room r1test
        Room roomBefore = thePlayer.getCurrentRoom();
        System.out.println(roomBefore);
        thePlayer.moveRoom("East");
        // the player is now in room r2test
        Room roomAfter = thePlayer.getCurrentRoom();
        assertNotEquals(roomAfter.getDescription(), roomBefore.getDescription());
    }
    
    @Test
    /**
     * This test if the player can pick up the delivery item correctly 
     */
    public void testPickUp()
    {
        thePlayer.pickUpDelivery(loot);
        
        if(loot != null )//the object containing the delivery cannot be null
        {
            assertEquals("loot" , thePlayer.getBag().get(0).getName() );
        }
    }
    @Test
    /**
     * This test if the player can pick up the delivery item correctly 
     */
    public void testPickUpBox()
    {   Key theKey = new Key("blue");
        Special theSpecial = new Special("malus");
        TreasureBox chest = new TreasureBox("chest", theKey, theSpecial );
        thePlayer.pickUpBox(chest);
        
        if(loot != null )//the object containing the delivery cannot be null
        {
            assertEquals( 100 , thePlayer.getHp() );
        }
    }
    
    @Test
    /**
     * This test verify that an item is correctly dropped (and can be returned to be add to the room)
     */
    public void testDropReturn()
    {
        thePlayer.pickUpDelivery(loot);
        
        assertEquals(loot , thePlayer.drop() );
    }
    @Test
    /**
     * This test verify that an item is correctly remove from the bag of the player
     */
    public void testDropRemove()
    {
        thePlayer.pickUpDelivery(loot);
        thePlayer.drop();
        assertEquals(0 ,thePlayer.getBag().size());
    }
    
    @Test
    /**
     * Return the maximal size for the bag
     */
    public void testGetSizeBag()
    {
        assertEquals(thePlayer.getSizeBag(),14);
    }
    @Test
    /**
     * Return the bag verified by his size
     */
    public void testGetBag()
    {
        thePlayer.pickUpDelivery(loot);
        thePlayer.pickUpDelivery(loot);
        thePlayer.pickUpDelivery(loot);
        
        assertNotEquals(thePlayer.getBag(), null );
        assertNotEquals(thePlayer.getSizeBag(), 3 );
    }
    
    @Test
    /**
     * Test if the player loses the correct amount of hp
     */
    public void testsetHpLose()
    {
        thePlayer.setHp(-20);
        assertEquals(80, thePlayer.getHp());
    }
    @Test
    /**
     * Test if the player gain the correct amount of hp
     */
    public void testsetHpGain()
    {
        thePlayer.setHp(-50);
        thePlayer.setHp(25);
        assertEquals(75, thePlayer.getHp());
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