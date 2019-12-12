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
    private Room depot; //his room where he can store his delivery
    private int hp; //the hp of the player
    
    
    /**
     * Create a player by giving a name and instantiate the current room 
     */
    public Player(String pName, Room playerRoom)
    {
        super(pName);
        bag = new ArrayList<Item>();
        sizeBag = 20; 
        currentRoom = playerRoom;
        depot = playerRoom;
        hp = 100;
    }
    
    /**
     * Change the room where the player is
     * @param roomToMove the room where the player go
     */
    public void setCurrentRoom(Room roomToMove)
    {
        currentRoom = roomToMove;
    }
    
    /**
     * return the inventory of the player
     * @return bag which
     * is a list of Item
     */
    public List<Item> getBag()
    {
        return bag;
    }
    
    /**
     * return the depot room
     * @return depot which is the room where ant can pick up if it's a deliveroo and drop if it's a stolen
     */
    public Room getDepot()
    {
        return depot;
    }
    
    /**
     * return the maximum size of the inventory
     * return sizeBag whho is a integer representing the maximum size of the inventory
     */
    public int getSizeBag()
    {
        return sizeBag;
    }
    
    /**
     * Return the room where the player is
     * @ return the current room where the player is
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Allow the ant to move between the rooms by crossing a door among the exits available
     */
    public void moveRoom(String direction)
    {
        // get the door that correspond to the exit direction
        Door exitDoor = currentRoom.getDoor(direction);
        // search the future room
        Room futureRoom = exitDoor.crossDoor(currentRoom); // renvoie la piece dans laquelle on sort en travarsant l'exitDoor
        setCurrentRoom(futureRoom); // la room dans laquelle on se trouve devient la room de sortie
    }
    
    /**
     * Take a delivery in the Room and put it in the bag
     * @parameter loot who is an item in the room who is a item class
     * 
     */
    public void pickUpDelivery(Delivery loot)
    {
        if (bag.size() < getSizeBag() && loot !=null){
            bag.add(loot); 
        }
    }
    
    /**
     * Open a treasure box and pick up items
     * @parameter loot who is an item in the room who is a item class
     * 
     */
    public void pickUpBox(TreasureBox box)
    {
       if (box.getLock() != null){ //if the box has locked
            if (box.getLock().getIsLocked() == true) // if it is locked
            {
                System.out.println("lock");
                for ( int i = 0 ; i< bag.size() ; i++) // search the key in the bag
                {
                    Item a = bag.get(i);
                    if(a instanceof Key){  // if the player has the key
                        box.getLock().unlock((Key)a); // use the key
                        bag.remove(i); // remove the key from the bag
                        break;
                    } 
                }
                if (box.getLock().getIsLocked() == true) //if it is still locked because there is not the key in the bag
                {
                    System.out.println("Box locked, you need the key");
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
           //setHp(box.getSpecial().getImpact());
    
           if (box.getKey() != null && bag.size() < getSizeBag())
           {
                bag.add(box.getKey());
                this.currentRoom.removeItem(box);
           } 
       }
    }
    
    /**
     * Drop an item in the room
     * @parameter  thedropName reprensent the name of the item that will be droped is the room
     * @return thedrop is the item that is droped in the room
     */
    public Item drop()
    {
        for ( Item i : bag) {
            if(i instanceof Delivery){  
                 bag.remove(i);
                 return i;
            } 
            
        }
        return null;
    }


    /**
     * modify the hp
     * cannot pass the hp bellow 0 or more that 100
     * @parameter thehp represent how much the delievroo ant will lose or gain hp
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
     * @parameter thehp represent how much hp the delievroo ant will gain
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
     * lose hp
     * cannot pass the hp bellow 0
     * @parameter thehp represent how much hp the delievroo ant will lose
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
     * @return the hp of the stolen ant who is a integer
     */
    public int getHp()
    {
        // Insérez votre code ici
        return hp;
    } 
}