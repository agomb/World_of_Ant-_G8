

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class of the Human class.
 *
 * @author  Crouzet G8
 * @version 1
 */
public class HumanTest
{
    Human theHuman;
    StolenAnt thief;
    /**
     * Default constructor for test class HumanTest
     */
    public HumanTest()
    {
    }

    /**
     * Sets up the different element needed for the different test
     */
    @Before
    public void setUp()
    {
        theHuman=new Human("Bob"); //the human who will be used inside the tests
        thief = new StolenAnt("Bob"); //the stolen ant needed to used the crush method
    }
    @Test
    /**
     * Test if the name is invalid/empty
     * This test will allways be false except if the name is incorrect and different from the default name
     */
    public void testNameInValid()
    {
        assertEquals(theHuman.getName(),"");
        
    }
    @Test
    /**
     * Test if the name is valid
     * This test will be true except if the name is incorrect or equals to the default name
     */
    public void testNameValid()
    {
        assertEquals(theHuman.getName(),"Bob");
        
    }
    @Test
    /**
     * Test if the name is the default name
     * This test will be true except if the name is incorrect and different from the default name
     */
    public void testNameDefaultValid()
    {
        theHuman=new Human(); //creation of a human with an empty name
        assertEquals("Standard",theHuman.getName()); //verification if the name getted is identical to the default name
    }
    
    @Test
    /**
     * Test if the stolen had lose 25 vp (vital point)
     * At the end the stolen ant should have 75vp
     */
    public void TestCrush()
    {   
        theHuman.crush(thief);
        assertEquals(thief.getVp(),75);
               
    }
    @Test
    /**
     * Test if the stolen had lose all of its vp (vital point)
     * At the end the stolen ant should have 0 vp
     */
    public void TestCrushToDeath()
    {   
        theHuman.crush(thief);
        theHuman.crush(thief);  
        theHuman.crush(thief);
        theHuman.crush(thief);
        assertEquals(thief.getVp(),0);
        
        
    }
    @Test
    /**
     * Test if the stolen had lose all of its vp (vital point) and no more
     * At the end the stolen ant should have 0 vp and no negatif vp
     */
    public void TestCrushBeyondDeath()
    {   
        theHuman.crush(thief);
        theHuman.crush(thief);  
        theHuman.crush(thief);
        theHuman.crush(thief);
        theHuman.crush(thief);
        
        assertEquals(thief.getVp(),0);
        //The Vp can not be a negative
    }
}
