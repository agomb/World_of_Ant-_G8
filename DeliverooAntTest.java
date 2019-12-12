

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DeliverooAntTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeliverooAntTest
{
    DeliverooAnt delive;
    Room testRoom;
    StolenAnt theStolen;
    Delivery loot;
    /**
     * Default constructor for test class DeliverooAntTest
     */
    public DeliverooAntTest()
    {
        testRoom = new Room("roomTest");
        delive = new DeliverooAnt("delive",testRoom);
        theStolen =new StolenAnt("thief",testRoom);
        Delivery loot = new Delivery("loot",testRoom);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {   testRoom = new Room("roomTest");
        delive = new DeliverooAnt("delive",testRoom);
        theStolen =new StolenAnt("thief",testRoom);
        
        loot = new Delivery("loot",testRoom);
    }
    @Test
    /**
     * 
     */
    public void testhitStolette()
    {
        delive.hitStolette(theStolen);
        assertEquals(50,theStolen.getHp());
    }
    
    @Test
    /**
     * 
     */
    public void testpickUpDelivery()
    {
        
        delive.pickUpDelivery(loot);
        
        if(( 1 == delive.getBag().size() )&& ( delive.getBag().get(0).getName()  == "loot" ) ) 
        {    
            assertEquals(1 , delive.getBag().size());
        }
    }    
    @Test
    /**
     * 
     */
    public void testdrop()
    {
        delive.pickUpDelivery(loot);
        delive.drop();
        assertEquals(0 , delive.getBag().size());
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
