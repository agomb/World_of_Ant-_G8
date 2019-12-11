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
    
    private Special spe;

    /**
     * Test if getters work correctly.
     */
    @Test
    public void testgetImpactBonus()
    {
        
        spe = new Special("bonus");
        assertEquals(15,spe.getImpact() );
    }
    /**
     * Test if getters work correctly.
     */
    @Test
    public void testgetImpact()
    {
        
        spe = new Special("malus");
        assertEquals(-15,spe.getImpact() );
    }
   
    
}