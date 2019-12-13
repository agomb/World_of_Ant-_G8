/**
 * This class represent the player when it is a deliveroo ant.
 * This deliveroo ant can deliver its delivery only in human room (on the gorund)
 * It can pick up the delivery only in the begin room
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 20/11/2019
 */
public class DeliverooAnt extends Player

{
    /**
     * Constructor of the DeliverooAnt class
     * give the natural hp(honor point)
     * @param name : name of the player
     * @playerRoom : start in the begin room
     */
    public DeliverooAnt(String dName, Room playerRoom) 
    {
        super(dName,playerRoom); 
        playerRoom.checkExits();
    }

    /**
     * Allow the delivery ant to hit the Stolen Ant
     */
    public void hitStolette(StolenAnt theStolen)
    {
        theStolen.setHp(-50); //when the stolen is hit by the deliveroo ant, it loose Hp
    }
    
    /**
     * Take a delivery in the begin room
     * @parameter loot which is the deliveries to deliverin human room 
     * @override 
     */
    public void pickUpDelivery(Delivery loot)
    {
        if ( getCurrentRoom() == getBeginRoom()){ //check if the current room is th begin room
            super.pickUpDelivery(loot); //pick up the delivery in the begin room
        }        
    }
        
    /**
     * Drop delivery in its destination room
     * @override 
     */
    public Item drop()
    {
        for ( Item i : getBag() ) { //check all the items in the bag
            if(i instanceof Delivery){  
                Delivery d = (Delivery)i; // if an item is the delivery
                if ( getCurrentRoom() == d.getGoal()){ //check if it is the goal room
                    i=super.drop(); //drop the item when there are all the conditions
                    return d;
                }
            }     
        }
        return null;
    }
}
