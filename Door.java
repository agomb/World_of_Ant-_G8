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
    private Lock lock; 
    /**
     * Constructeurs d'objets de classe Door
     */
    public Door(Room r1, String direction1, Room r2, String direction2)
    {
        room1 = r1;
        room2 = r2;
    }
    
    public void createDoor(Room r1, String direction1, Room r2, String direction2){
        room1.addExit(direction1, this);
        room2.addExit(direction2, this);
    }
    
    /**
     * This method return the next room to move to but if the door is locked and you don't have the right key it will return a error type
     * This error need to be catch by the calling method
     *
     * 
     * @return     error or the next room
     */
    public Room cross()
    {
       return room2;
    }
}