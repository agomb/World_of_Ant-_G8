import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 /**
 * This is a class test for the Item class
 *
 *@author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */

public class ItemTest
{
    private Item item;
    
    /**
     * Default constructor for test class StolenAntTest
     */
    public ItemTest()
    {
    }

    /**
     * Sets up the different parameters needed for the test.
     * thief who is a stolen ant object
     */
    @Before
    public void setUp()
    {
        item = new Item("Toto");
    }
     /**
     * Test that an item is correctly initialised (name).
     */
    @Test
    public void testName()
    {
        
        assertEquals("Toto", item.getName());
    }
     /**
     * Test that an item is correctly initialised (name).
     * The name can not have a size of 0 
     */
    @Test
    public void testNameStringSizeNull()
    {
        item = new Item("");
        assertEquals("item", item.getName());
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
   
   


