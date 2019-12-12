

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DelievrooAntTest.
 *
 * @author G8 Alix
 * @version (2019-20-11)
 */
public class DelievrooAntTest
{
    DelivrooAnt delive;
    /**
     * Default constructor for test class DelievrooAntTest
     */
    public DelievrooAntTest()
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
        delive = new DelievrooAnt(""); //create an empty field (new delivered) 
    }
    
    
    @Test
    /**
     * Set are use to modify the HP number
     * it is not possible to have hp bellow 0 or more than 100
     * this test is to check if the HP bellow 0 are not taking in account 
     */
    public void testSetHp()
    {
        delive.setHp(-100); //number of HP
        assertEquals(delive.getHp(),0); //check if HP equal 0 is delivered
    }
    
    @Test
    /**
     * Set are use to modify the HP number
     * it is not possible to have hp bellow 0 or more than 100
     * this test is to check if the HP more than 100 are not taking in account 
     */
    public void testSetHp1()
    {
        delive.setHp(200); //number of HP
        assertEquals(delive.getHp(),0); //check if HP equal 0 is delivered
    }
    
    @Test
    /**
     * getHP is a getter. 
     * return the hp of the stolen ant which is a integer. Check if the HP are equal to 100
     */
    public void testGetHp()
    {
        delive.getHp(); //return the HP
        assertEquals(delive.getHp(),100); // check if HP equal 100 is delivred
    }
    
    @Test
    /**
     * allow the delivery ant to hit the Stolen Ant
     * Check if the delive meet the stolen Ant (to hit it)
     */
    public void testhitStolette()
    {
        delive.hitStolette(); //fighting the delivred
    }
    
}