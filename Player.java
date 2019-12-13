import java.util.ArrayList;
import java.util.List;
/**
 * This super-class allow to create a character which gonna be played by user
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbé, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version (un numéro de version ou une date)
 */
public class Player extends Character
{
    private List<Item> bag; //simulate the inventory of the ant
    private int sizeBag; // the maximum size of the bag
    private Room currentRoom; // the room where the player is
    private Room beginRoom; //his room where he can store his delivery
    private int hp; //the hp of the player
    /**
     * Create a player by giving a name and instantiate the current room 
     */
    public Player(String pName, Room playerRoom)
    {
        super(pName);
        bag = new ArrayList<Item>();
        sizeBag = 14; 
        currentRoom = playerRoom;
        beginRoom = playerRoom;
        hp = 100;
    }
    
    /**
     * Change the room where the player is
     * @param roomToMove the room where the player go
     */
    public void setCurrentRoom(Room roomToMove)
    {
        currentRoom = roomToMove; //allows the player to move
    }
    
    /**
     * return the inventory of the player
     * @return bag which is a list of Item
     */
    public List<Item> getBag()
    {
        return bag; //return the list of items
    }
    
    /**
     * Return the being room
     * @return beginRoom which is the room where an ant can pick up if it is a deliveroo and drop if it is a stolen ant
     */
    public Room getBeginRoom()
    {
        return beginRoom;
    }
    
    /**
     * return the maximum size of the inventory
     * @return sizeBag which is an integer representing the maximum size of the bag
     */
    public int getSizeBag()
    {
        return sizeBag; //return the size of the bag
    }
    
    /**
     * Return the room where the player is
     * @return the current room where the player is
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Allow the ant to move between the rooms by crossing a door among the exits available
     * @param direction : direction where the player wants to go
     */
    public void moveRoom(String direction)
    {
        //Get the door that correspond to the exit direction
        Door exitDoor = currentRoom.getDoor(direction);

        // search the future room
        Room futureRoom = exitDoor.crossDoor(currentRoom, bag); // renvoie la piece dans laquelle on sort en travarsant l'exitDoor
        setCurrentRoom(futureRoom); // la room dans laquelle on se trouve devient la room de sortie
    }
    
    /**
     * Take a delivery in the Room and put it in the bag
     * @param loot which is an item in the room 
     * 
     */
    public void pickUpDelivery(Delivery loot)
    {
        if (bag.size() < getSizeBag() && loot !=null){ //check if there is enough place in the bag
            bag.add(loot); //add a delivery to the bag
        }
    }
    
    /**
     * Open a treasure box and pick up items
     * @param loot who is an item in the room who is a item class
     * 
     */
    public void pickUpBox(TreasureBox box)
    {
       if (box.getLock() != null){ //if the box has locked
            if (box.getLock().getIsLocked() == true) // if it is locked
            {
                for ( int i = 0 ; i< bag.size() ; i++) // search the key in the bag
                {
                    Item a = bag.get(i);
                    if(a instanceof Key){  // if the player has the key
                        box.getLock().unlock((Key)a); // use the key
                        if ( box.getLock().getIsLocked() == false ){
                            bag.remove(i); // remove the key from the bag
                            break;
                        }
                    } 
                }
                
                if (box.getLock().getIsLocked() == false) //if it is still locked because there is not the key in the bag
                {
                     if (box.getKey() != null && bag.size() < getSizeBag())
                     {
                         bag.add(box.getKey());
                         this.currentRoom.removeItem(box);
                     } 
                     if(box.getSpecial() != null && bag.size() < getSizeBag())
                     {
                         setHp(box.getSpecial().getImpact());
                         this.currentRoom.removeItem(box);
                     }
                }
            } 
            else //if it is open
            {
                //setHp(box.getSpecial().getImpact()); need to look for the impact
                if (box.getKey() != null && bag.size() < getSizeBag()) // if the box is not empty
                {
                    bag.add(box.getKey()); 
                    this.currentRoom.removeItem(box);
                }
                else
                {
                    System.out.println("The box is empty");
                }
            }
       }
       else // if there is no lock
       {
           if (box.getKey() != null && bag.size() < getSizeBag())
           {
                bag.add(box.getKey());
                this.currentRoom.removeItem(box);
           } 
           if(box.getSpecial() != null && bag.size() < getSizeBag())
           {
                setHp(box.getSpecial().getImpact());
                this.currentRoom.removeItem(box);
           }
       }
    }
    
    /**
     * Drop an item in the room
     * @param  thedropName reprensent the name of the item that will be droped is the room
     * @return thedrop is the item that is droped in the room
     */
    public Item drop()
    {
        for ( Item i : bag) { //check all the items of the bag
            if(i instanceof Delivery){  
                this.getCurrentRoom().addItem(i); 
                bag.remove(i); //remove the item of the bag
                 return i;
            } 
        }
        
        return null;
    }

    /**
     * Modify the hp
     * cannot pass the hp bellow 0 or more that 100
     * @param thehp represent how much the delievroo ant will lose or gain hp
     */
    public void setHp(int thehp)
    {
        if(thehp > 0)
        {
            addHp(thehp);
        }
        else
        {
            loseHp(thehp);
        }
    }
    
    /**
     * Add Hp to the delivroo ant
     * cannot pass the hp more that 100
     * @param thehp represent how much hp the delievroo ant will gain
     */
    public void addHp(int theHp)
    {
        if((this.hp + theHp) >= 100)
        {
            this.hp = 100;
        }
        else 
        {
            this.hp += theHp;
        }
    }
    
    /**
     * Lose hp
     * cannot pass the hp bellow 0
     * @param thehp represent how much hp the delievroo ant will lose
     */
    public void loseHp(int theHp)
    {
        if((this.hp + theHp) <= 0)
        {
            this.hp = 0;
        }
        else 
        {
            this.hp += theHp;
        }
    }
    
    /**
     * return the hp
     * @return the hp of the stolen ant 
     */
    public int getHp()
    {
        return hp; //return the hp 
    } 
}