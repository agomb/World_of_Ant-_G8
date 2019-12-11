

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class for the Character class.
 *
 * @author  Crouzet G8
 * @version 1
 */
public class CharacterTest
{   
    Character charac;
    /**
     * Default constructor for test class CharacterTest
     */
    public CharacterTest()
    {
        
    }

    /**
     * Sets up the different element needed for the different test
     */
    @Before
    public void setUp()
    {
        charac=new Character("Patric"); //creation of a character named "Patric"
    }
    
    /**
     * Test if the name is invalid/empty
     * This test will allways be false except if the name is incorrect and different from the default name
     */
    @Test
    public void testNameInValid()
    {
        assertEquals(charac.getName(),""); //verification if the name getted is an empty name
    }
    
    /**
     * Test if the name is valid
     * This test will be true except if the name is incorrect or equals to the default name
     */
    @Test
    public void testNameValid()
    {
        assertEquals(charac.getName(),"Patric"); //verification if the name getted is identical to the given name at the creation
    }
    
    /**
     * Test if the name is the default name
     * This test will be true except if the name is incorrect and different from the default name
     */
    @Test
    public void testNameDefaultValid()
    {
        charac=new Character(); //creation of a charater with an empty name
        assertEquals("Standard", charac.getName()); //verification if the name getted is identical to the default name
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