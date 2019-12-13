import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    private Room room1;
    private Room room2;
    private Lock theLock; 
    private Key theKey;
    private List<Key> keyDoors;
    /**
     * Constructeurs d'objets de classe Door
     */
    public Door(Room r1, String direction1, Room r2, String direction2)
    {
        room1 = r1;
        room2 = r2;
        theLock = null;
    }
    
    /**
     * Constructeurs d'objets de classe Door

     */
    public Door(Room r1, String direction1, Room r2, String direction2, Key keyDoor, Lock lockDoor)
    {
        room1 = r1;
        room2 = r2;
        theKey = keyDoor;
        theLock = lockDoor;
    }
    
    /**
     * Constructeurs d'objets de classe Door

    */
    public static void createDoor(Room r1, String direction1, Room r2, String direction2)
    {
        Door createdDoor = new Door(r1, direction1, r2, direction2);
        r1.addExit(r1,direction1, createdDoor);
        r2.addExit(r2,direction2, createdDoor);
    }
    
    /**
     * Constructeurs d'objets de classe Door
    */
    public static void createDoor(Room r1, String direction1, Room r2, String direction2, Key keyDoor, Lock lockDoor)
    {
        Door createdDoor = new Door(r1, direction1, r2, direction2, keyDoor, lockDoor);
        r1.addExit(r1,direction1, createdDoor);
        r2.addExit(r2,direction2, createdDoor);
    }
    
    public Lock getLockDoor()
    {
        return theLock;
    }
    
    /**
     * This method return the next room to move to but if the door is locked and you don't have the right key it will return a error type
     * This error need to be catch by the calling method
     *
     * 
     * @return     error or the next room
     */
    public Room crossDoor(Room currentRoom, List<Item> bag)
    {
        if (getLockDoor() == null || getLockDoor().getIsLocked() == false ){
           if (room1 == currentRoom)
                return room2;
           else 
                return room1;
        }
        else
        {
            if (getLockDoor().getIsLocked() == true) // if it is locked
            {
                for ( int i = 0 ; i< bag.size() ; i++) // search the key in the bag
                {
                    Item a = bag.get(i);
                    if(a instanceof Key){  // if the player has the key
                        getLockDoor().unlock((Key)a); // use the key
                        if ( getLockDoor().getIsLocked() == false ){
                            bag.remove(i); // remove the key from the bag
                            break;
                        }
                    } 
                }
                if (getLockDoor().getIsLocked() == true) //if it is still locked because there is not the key in the bag
                {
                    if (room1 == currentRoom)
                        return room1;
                    else 
                        return room2;
                       
                }
                else
                {
                    if (room1 == currentRoom)
                        return room2;
                    else 
                        return room1;
                }
            }          
        }
       
        if (room1 == currentRoom)
            return room1;
        else 
            return room2;
    }
}