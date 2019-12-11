
/**
 * The Lock class describe if a door or a chest is locked and how to unlocked it.
 * @Default isLocked == true
 * 
 * @author Crouzet G8
 * @version 19/11/2019
 */

public class Lock
{
    private int idKey; //The id of key needed to open the chest/door
    private Key akey; //The key linked to the lock
    private boolean isLocked; //status of the door/chest =>open or close (close by default)
   
    public Lock(Key akey)
    {
        this.akey = akey; //attribution of the key object
        isLocked = true; //set the status of the object true if locked and false if unlocked
    }
    
    /**
     * @parameter aKey who is the id a key
     * if you give the correct key it will unlock the object
     * else return an error (boolean)
     * @return 
     * true => operation was done succesfluly and the door/chest is opened
     * false => operation failed and the door/chest is not opened
     **/
    
    public boolean unlock(Key theKey)
    {
        if(isLocked == true && akey == theKey)
        {
            isLocked = false;
            return true;
        }
        else if(isLocked == true && akey != theKey)
        {
            return false;
        }
        else if(isLocked == false)
        {
            return true;
        }
        else
            return false;
    }
    
    /**
     * Return the status of the object true if locked and false if unlocked
     * Containt inside the isLocked attributes
     * @return boolean islocked
     */
    public boolean getIsLocked()
    {
        return isLocked;
    }
}
