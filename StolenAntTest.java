import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StolenAntTest.
 *
 * @author  Crouzet G8
 * @version (a version number or a date)
 */
public class StolenAntTest
{   
    StolenAnt thief;
    Delivery loot;
    Room r1test;
    /**
     * Default constructor for test class StolenAntTest
     */
    public StolenAntTest()
    {
    }

    /**
     * Sets up the different parameters needed for the test.
     * thief who is a stolen ant object
     */
    @Before
    public void setUp()
    {
        r1test = new Room("c'est la cuisine pour tester");
        thief = new StolenAnt("thief",r1test);
        loot = new Delivery("loot",r1test);
    }
    
    @Test
    /**
     * Test if the item is picked up and added to the bag
     */
    public void testpPickUpDelivery()
    {
        thief.pickUpDelivery(loot);
        
        if(loot != null )//the object containing the delivery cannot be null
        {
            assertEquals("loot" , thief.getBag().get(0).getName() );
        }
    
    
    }
    @Test
    /**
     * Test if the item is picked up and added to the bag then that the delivery ant loses hp
     */
    public void testpPickUpDeliveryDamage()
    {
        
        DeliverooAnt delive = new DeliverooAnt("delive",r1test);
        thief.pickUpDelivery(loot,delive);
        
        assertEquals( 95 , delive.getHp() );
            
    
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