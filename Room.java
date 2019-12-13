import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Room is the class that represents each accessible room in the game
 * There are two levels : level up and level down.
 * Level up represents the surface (human houses)
 * and the level down represents ants gallery.
 *
 * @author Group 8 
 * @version 13/11/2019
 */
public class Room
{
    private List<Human> human;
    private List<Item> item;
    private HashMap<String, Door> exits;  // Sring = north,east,south,west **************************
    private String description;
    /**
     * Constructor of the Room class
     * Adds a description to the room
     * @param rDescription is a description of the room.
     */
    public Room(String rDescription)
    {
       description = rDescription;
       exits = new HashMap<String, Door>(); //the Hashmap is empty, when a door is created, it is added as an exit in the Hashmap
       human = new ArrayList<Human>();
       item = new ArrayList<Item>();       
    }

    /**
     * Displays the possible exits in the room.
     * @ return List<String> : the list of exit that exists (directions)
     */
    public Door getDoor(String direction)
    {
        for(Map.Entry<String, Door> e : this.exits.entrySet())
        {
            if(direction.equals(e.getKey()))
                return e.getValue();
        }
        return null;
    }
    
    /**
     * Chekc the available exits
     * @ return List<String> the list of possible exits
     */
    public List<String> checkExits()
    {
        // Enable the button to click on (when exits available) 
        List<String> exitsAvailable = new ArrayList<String>();
        for(Map.Entry<String, Door> e : this.exits.entrySet())
        {
            //System.out.println(e.getKey()+"\n");
            exitsAvailable.add(e.getKey());
        }
        return exitsAvailable;
    }
    
    /**
     * Use the direction to choose an exit door available
     * @ return Door the door that correspond to the given exit direction
     */
    public Door chooseExit(Room currentRoom, String theDirection)
    {
        for(Map.Entry<String, Door> e : currentRoom.exits.entrySet()) //check all the key/value couple of the hashmap
        {
            if(e.getKey() == theDirection) 
            {
                return e.getValue(); //return the value of the searched exit 
            }
        }
        return null; //return nothing when the exit is not find
    }
    
    /**
     * Add a door as an exit in the room
     * @param r : current room
     * @param exitDoor : the exit door
     * @param direction : the direction where the exit is in the room 
     */
    public void addExit(Room r, String direction, Door exitDoor)
    {
        r.exits.put(direction, exitDoor); //allows to add an exits to the Hashmap
    }
    
    /**
     * return the description of the room
     * @return description 
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * This method retunr the list of item
     *@return item
     */
    public List<Item> getItem()
    {
        return item;
    }
    
    /**
     * displays the item in the treasure box.
     *
     */
    public TreasureBox getBox()
    {
         for ( Item i : item) {
             if(i instanceof TreasureBox){  
                 return ((TreasureBox)i);
             }     
         }
         return null; 
    }
    
    /**
     * displays the delivered box in the room.
     *
     */
    public Delivery getDelivery()
    {
         for ( Item i : item) { //check all the items of the list
             if(i instanceof Delivery){  // if the item correspond to the delivery
                 return ( (Delivery)i); //return the delivery
             }     
         }
         return null; 
    }
    
    /**
     * Adds an item
     *
     *@param anItem The item added in the room
     */
    public void addItem(Item anItem)
    {
        item.add(anItem); //add the item
    }
    
    /**
     * Remove an item from the room (When it's picked up by the stolen ant).
     *
     * @param anItem the item removed in the room
     */
    public void removeItem(Item anItem)
    {
        item.remove(anItem); //remove the item
    }
}