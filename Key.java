/**
 * Key is create with a name ans an id to be associate to a lock to open it if is closed, and if the key belongs at the lock.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */

public class Key extends Item
{
    
    /**
     * Create a key 
     * @param kName allows to give a name to the object
     * @param ide allows to put an id to the key
     */
    public Key(String kName)
    {
        super(kName);
    }

}