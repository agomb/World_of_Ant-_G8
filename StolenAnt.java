/**
 * The stolen ant class is one of the two player class
 * This class can steal object in a room, gain and lose vp when cruched by a human or hitted by a deliveroo ant
 * A stolen ant have by default 100 vp and need to be given a name
 * 
 * @Default vp == 100
 * 
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version (un numéro de version ou une date)
 */
public class StolenAnt extends Player
{
    
    /**
     * Constructeur d'objets de classe StolenAnt
     * give the natural vp(vital point)
     */
    public StolenAnt(String sName, Room playerRoom)
    {
        super(sName,playerRoom);
    }
    
    
    /**
     * drop delivery stolen in his depot
     * @override 
     */
    public void drop()
    {
        if ( getCurrentRoom() == getDepot()){
            super.drop();
        };
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