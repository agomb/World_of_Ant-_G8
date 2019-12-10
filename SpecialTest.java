import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test SpecialTest.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 *
 */
public class SpecialTest
{
    // Variable of the SpecialTest class
    private int bonus;
    private Special spe;

    /**
     * Test if getters work correctly.
     */
    @Test
    public void testSpecial()
    {
        bonus = 5;
        spe = new Special("Toto", bonus);
        assertEquals(bonus, spe.getBonus());
    }
    
   
    
}