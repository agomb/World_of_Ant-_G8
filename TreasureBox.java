import java.util.ArrayList;
import java.util.List;
/**
 * This is a box which can contain keys and special item. It can also be locked.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbé, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class TreasureBox extends Item
{
    private Special specialBox; // list of special item contained in the box
    private Lock lockBox; // lock which will allows to open the box
    private Key keyBox;
    
    /**
     * Constructor of empty Treasure box
     * @param tName allows to give a name to the object
     */
    public TreasureBox(String tName)
    {
        super(tName);
    }
    
    /**
     * Create a treasure box without lock 
     * @param tName allows to give a name to the object
     * @param key allows to put keys on the box
     * @param specials allows to put specia item on the box
     */
    public TreasureBox(String tName, Key theKey, Special theSpecial)
    {
        super(tName);
        keyBox = theKey;
        specialBox = theSpecial;
    }
    
    /**
    * Create a treasure box with lock 
    * @param tName allows to give a name to the object
    * @param key allows to put keys on the box
    * @param specials allows to put specia item on the box
    * @param aLock allows to attribute an unique lock at the box to open it
    */
    public TreasureBox(String tName, Key theKey, Special theSpecial, Lock aLock)
    {
        super(tName);
        keyBox = theKey;
        specialBox = theSpecial;
        lockBox = aLock;
    }
    
    /**
     * Give the special item on the box
     * @return keys, the list of items on the box
     */
     public Special getSpecial()
    {
        return specialBox;
    }
    

     /**
     * Give the special item on the box
     * @return keys, the list of items on the box
     */
     public Key getKey()
    {
        return keyBox;
    }
    
  
    public Lock getLock()
    {
        return lockBox;
    }
    
    /**
     * Give the special item on the box
     * @return keys, the list of items on the box
     */
     public String getDescription()
    {
       String s = "In this box there is : \n " ;
       if (specialBox.getImpact() < 0 ){
               s = s + " a malus, you loose ";  
       }
       else{
               s = s + " a bonus, you win ";
       }
       s = s +  Integer.toString(specialBox.getImpact()) + "hp \n" ;     
 
       s = s + "You pick up 1 key";
        
       return s;
    } 
    
    /**
     * Remove all the item and key contain inside the treasure box
     * 
     */
    public void removeItem()
    {
       keyBox = null;
       specialBox = null;
    } 
}