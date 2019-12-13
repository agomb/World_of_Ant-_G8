/**
 * The stolen ant class is one of the two player classes
 * This player can steal object in a room, gain and lose vp when cruched by a human or hitted by a deliveroo ant
 * A stolen ant have by default 100 vp.
 * A goal is to steal delivery in the different room
 * 
 * @Default vp == 100
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 13/12/2019
 */
public class StolenAnt extends Player //inherit from the player class
{
    /**
     * Constructeur d'objets de classe StolenAnt
     * give the natural vp(vital point)
     */
    public StolenAnt(String sName, Room playerRoom)
    {
        super(sName,playerRoom); // intialize the name and the room
    }
    
    /**
     * The stolen can only drop delivery in the begin room
     * @override 
     */
    public Item drop()
    {
        Item i;
        if ( getCurrentRoom() == getBeginRoom()){ //check if the current room is the begin room
            i=super.drop(); 
            return i; //if it is the begin room it is possible to drop
        };
        return null; //if it is not the beign room it can not drop
    }
 
    /**
     * Steal a delivery in all the map which make lost hp to the deliveroo ant
     * @parameter loot which is deliveries to deliver. 
     * @override 
     */
    public void pickUpDelivery(Delivery loot, DeliverooAnt deliveroo)
    {
        super.pickUpDelivery(loot);
        deliveroo.setHp(-5);
    }
    
}