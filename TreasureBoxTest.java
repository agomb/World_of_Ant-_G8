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
    List <Key> key;
    List <Special> special;
    Lock lock;
    TreasureBox treasureB;

     /**
     * Test if getters work correctly.
     */
    @Test
    public void testBoxLocked()
    {
        Key key = new Key("1", 1);
        Key key2 = new Key("2", 2);
        lock = new Lock(key);
        
        List <Key> keys = new ArrayList<Key>(); 
        keys.add(key2);
        
        List <Special> specials = new ArrayList<Special>(); 
        Special special1 = new Special("bh", 5);
        specials.add(special1);
        
        treasureB = new TreasureBox("Toto", keys, specials, lock);
        assertEquals(keys, treasureB.getKey());
        assertEquals(specials, treasureB.getSpecial());
    }
    
     /**
     * Test if items are removed correctly.
     */
    @Test
    public void testRemove()
    {
        Key key = new Key("1", 1);
        Key key2 = new Key("2", 2);
        lock = new Lock(key);
        
        List <Key> keys = new ArrayList<Key>(); 
        keys.add(key2);
        
        List <Special> specials = new ArrayList<Special>(); 
        Special special1 = new Special("bh", 5);
        specials.add(special1);
        
        treasureB = new TreasureBox("Toto", keys, specials, lock);
        
        treasureB.removeItem();
        
        List <Key> k = treasureB.getKey();
        List <Special> s = treasureB.getSpecial();
        
        assertEquals(0, k.size());
        assertEquals(0, s.size());
    }
    
}
