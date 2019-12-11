import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Room is the class that represents each accessible room in the game
 * There is two levels : level up and level down.
 * Level up represents the surface (human houses)
 * and the level down represents ants gallery.
 *
 * @author Group 8 (Angélique and Dylan)
 * @version 13/11/2019
 */
public class Room
{
    
    private List<Human> human;
    private List<Item> item;
    
    private HashMap<String, Door> exits;  // Sring = north,east,south,west **************************
    private String description;
    
    /**
     * Adds a description to the room
     * @param rDescription is a description of the room.
     */
    public Room(String rDescription)
    {
       //exits = new HashMap<>();
       description = rDescription;
       exits = new HashMap<String, Door>();
       //the Hashmap is empty, when a door is created, it is added as an exit in the Hashmap
       
       List<Human> human = new ArrayList<Human>();
       List<Item> item = new ArrayList<Item>();
       
    }

    /**
     * displays the possible exits in the room.
     * @ return List<String> the list of exit that exists (directions)
     */
    //public List<String> getExit()
    //{
    //    List<String> theExits = new ArrayList<String>();
    //    return theExits;
    //}
    
    /**
     * displays the possible exits in the room.
     * @ return List<String> the list of exit that exists (directions)
     */
    public void checkExits()
    {
        // Disable all exits
        // GameInterface.control.disableAllButtons();
        
        // Make the exits available clickable
        System.out.println("Exits available :\n");
        for(Map.Entry e : this.exits.entrySet())
        {
            System.out.println(e.getKey()+"\n");
        }
    }
    
    /**
     * Use the direction to selecct the exit door
     * @ return Door the door that correspond to the given exit direction
     */
    public Door chooseExit(Room currentRoom, String theDirection)
    {
        for(Map.Entry<String, Door> e : currentRoom.exits.entrySet())
        {
            if(e.getKey() == theDirection)
            {
                return e.getValue();
            }
        }
        return null;
    }
    
    /**
     * Add a door as exit in the room
     * @param exitDoor is the exit door, direction is the direction where the exit is in the room 
     */
    public void addExit(Room r, String direction, Door exitDoor)
    {
        r.exits.put(direction, exitDoor);
    }
    
    /**
     * return the description of the room
     * @return description is the description of the room
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * displays the available items in the room.
     *
     */
    public List<Item> getItem()
    {
        return item;
    }
    
    /**
     * displays the boxin the room.
     *
     */
    public TreasureBox getBox()
    {
         for ( Item i : item) {
             if(i instanceof TreasureBox){  
                 return ( (TreasureBox)i);
             }     
         }
         return null; 
    }
    
     /**
     * displays the boxin the room.
     *
     */
    public Delivery getDelivery()
    {
         for ( Item i : item) {
             if(i instanceof Delivery){  
                 return ( (Delivery)i);
             }     
         }
         return null; 
    }
    
    /**
     * adds an item
     *
     *@param anItem The item added in the room
     */
    public void addItem(Item anItem)
    {
        
    }
    
    /**
     * remove an item from the room (When it's picked up by an ant).
     *
     * @param anItem the item removed in the room
     */
    public void removeItem(Item anItem)
    {
        
    }
}