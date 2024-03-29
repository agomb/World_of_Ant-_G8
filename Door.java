import java.util.ArrayList;
import java.util.List;
/**
 * The class door is to create all the exits and lock associated 
 *
 * @author G8
 * @version 13/12/2019
 */
public class Door
{
    private Room room1;
    private Room room2;
    private Lock theLock; 
    private Key theKey;
    private List<Key> keyDoors;
    /**
     * Constructor of the door class without a lock
     * @param room1, room2 : are the two room between which a door is created
     * @param direction1, direction2 : are the different direction (east, north, west or south)
     */
    public Door(Room r1, String direction1, Room r2, String direction2)
    {
        room1 = r1;
        room2 = r2;
        theLock = null;
    }
    
    /**
     * Constructor of the door class with a lock
     * @param room1, room2 : are the two room between which a door is created
     * @param direction1, direction2 : are the different direction (east, north, west or south)
     * @param lockDoor 
     */
    public Door(Room r1, String direction1, Room r2, String direction2, Key keyDoor, Lock lockDoor)
    {
        room1 = r1;
        room2 = r2;
        theKey = keyDoor;
        theLock = lockDoor;
    }
    
    /**
     * Method that allows to create a door without a lock
     * @param the two rooms 
     * @param the two directions depending on which side if the door the player is
    */
    public static void createDoor(Room r1, String direction1, Room r2, String direction2)
    {
        Door createdDoor = new Door(r1, direction1, r2, direction2); //creation of the door
        r1.addExit(r1,direction1, createdDoor); //add the door on the first room 
        r2.addExit(r2,direction2, createdDoor); //add the door on the second room
    }
    
    /**
     * Method that allows to create a door with a lock
     * @param the two rooms 
     * @param the two directions depending on which side if the door the player is
    */
    public static void createDoor(Room r1, String direction1, Room r2, String direction2, Key keyDoor, Lock lockDoor)
    {
        Door createdDoor = new Door(r1, direction1, r2, direction2, keyDoor, lockDoor);//creation of the door with a lock
        r1.addExit(r1,direction1, createdDoor);
        r2.addExit(r2,direction2, createdDoor);
    }
    
    public Lock getLockDoor()
    {
        return theLock; //return the lock of the door
    }
    
    /**
     * This method return the next room to move to but if the door is locked and you don't have the right key it will return a error type
     * This error need to be catch by the calling method
     *
     * @return  the room where the player is after using the door (or the same if it's locked)
     * @param currentRoom the room where the player is
     * @param bag its bag to know if he has the key
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