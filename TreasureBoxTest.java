import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe-test TreasureBoxTest.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class TreasureBoxTest
{
    //Attributes of the treasureBox class.
    TreasureBox chest1, chest2;
    Key keychest1, keychest2;
    Special bonus, malus;
    Lock lockChest;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        keychest1 = new Key("keychest1");
        keychest2 = new Key("keychest2");
        keychest2 = null;
        lockChest = new Lock(keychest1);
        bonus = new Special("bonus");
        malus = new Special("malus");
        //Test the first constructor
        chest1 = new TreasureBox("chest1", keychest1, bonus);
        //Test the second constructor
        chest2 = new TreasureBox("chest2", keychest2, malus, lockChest );
    }
    
    /**
    * Test if getters work correctly.
    * Get the Key of the treasure chest
    * if there is no key the result is null
    */
    @Test
    public void testGetKey()
    {
        assertEquals(keychest1, chest1.getKey() );
    }
    @Test
    public void testGetKeyNull()
    {
        assertEquals(null, chest2.getKey() );
    }
    
    /**
    * Test if getters work correctly.
    * Get the Special item of the treasure chest
    * 
    */
    @Test
    public void testGetSpecialBonus()
    {
        assertEquals(bonus, chest1.getSpecial() );
    }
    @Test
    public void testGetSpecialMalus()
    {
        assertEquals(malus, chest2.getSpecial() );
    }
    
    /**
    * Test if getters work correctly.
    * Get the lock of the treasure chest
    * 
    */
    @Test
    public void testGetLock()
    {
        assertEquals( lockChest, chest2.getLock() );
    }
    @Test
    public void testGetLockNull()
    {
        assertEquals( null, chest1.getLock() );
    }
    
    /**
    * Test if getters work correctly.
    * Get the description what is inside of the treasure chest
    * Get a string
    */
    @Test
    public void testGetDescriptionBonus()
    {
        assertEquals( "In this box there is : \n  a bonus, you win 15hp \nYou pick up 1 key", chest1.getDescription() );
    }
    @Test
    public void testGetDescriptionMalus()
    {
        chest2 = new TreasureBox("chest2", keychest1, malus, lockChest );
        assertEquals( "In this box there is : \n  a malus, you loose -15hp \nYou pick up 1 key", chest2.getDescription() );
    }
    
    /**
    * Test if getters work correctly.
    * Remove the item and key inside the treasure of the chest
    */
    @Test
    public void testRemoveItem()
    {
        chest1.removeItem();
        assertEquals( null , chest1.getKey() );
        assertEquals( null , chest1.getSpecial() );
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
