import java.util.ArrayList;
import java.util.List;
/**
 * Keys are created to door locked and treasure box locked. 
 * These keys allows to open the locked box and door.
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */

public class Key extends Item
{
  private Key keyDoor;
  /**
     * Constructor : Create a key 
     * @param kName allows to give a name to the object
     */
    public Key(String kName)
    {
        super(kName);
    }
      
  /**
     * Get the keys
     * @return keys
     */
    public Key getKey()
    {
        return keyDoor;
    }
}