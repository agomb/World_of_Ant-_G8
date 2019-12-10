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
     * Test that an item is correctly initialised (name).
     */
    @Test
    public void testName()
    {
        item = new Item("Toto");
        assertEquals("Toto", item.getName());
    }

} 
   
   


