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
        thief = new StolenAnt("");
    }
    
    @Test
    /**
     * Test if the setVp method actualise correctly the vp by the given value
     * this test is true when the vp returned is at 50
     */
    public void testSetVpMinusValid()
    {
        thief.setVp(-50);
        assertEquals(thief.getVp(),50);
    }
    @Test
    /**
     * Test if the setVp method actualise correctly the vp by the given value
     * this test is false if the vp returned stay 100
     */
    public void testSetVpMinusInValid()
    {
        thief.setVp(-50);
        assertEquals(thief.getVp(),100);
    }
    @Test
    /**
     * Test if the setVp method actualise correctly the vp by the given value
     * this test is true if the vp become 75.
     */
    public void testSetVpPlusValid()
    {   
        thief.setVp(-75);
        thief.setVp(50);
        assertEquals(thief.getVp(),75);
    }
    @Test
    /**
     * Test if the setVp method actualise correctly the vp by the given value
     * this test is false if the vp returned stay 100
     */
    public void testSetVpPlusInvalid()
    {   
        thief.setVp(-75);
        thief.setVp(50);
        assertEquals(thief.getVp(),100);
    }
    @Test
    /**
     * Test if the getVp return the correct value
     * This test is true if the return value is 100
     */
    public void testGetVpValid()
    {
        
        assertEquals(thief.getVp(),100);
    }
    @Test
    /**
     * Test if the getVp return the correct value
     * This test is true if the return value is different than 100
     */
    public void testGetVpInvalid()
    {
        
        assertNotEquals(thief.getVp(),100);
    }
}