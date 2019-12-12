import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class DeliveryTest
{
   
    private Room goal;
    private Delivery delivery;

    
     /**
     * Test that an item is correctly initialised ().
     */
    @Test
    public void testDelivery()
    {
        Room room = new Room("Room 1");
        delivery = new Delivery("Toto", room);
        assertEquals(room, delivery.getGoal());
    }
    

}