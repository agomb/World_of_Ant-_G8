/**
 * This class represent a delivroo ant, with hp.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 20/11/2019
 */
public class DeliverooAnt extends Player

{

    /**
     * Constructeur d'objets de classe Delievroo
     * give the natural hp(honor point)
     */
    public DeliverooAnt(String dName, Room playerRoom)
    {
        super(dName,playerRoom);      
    }

    /**
     * allow the delivery ant to hit the Stolen Ant
     */
    public void hitStolette(StolenAnt theStolen)
    {
        theStolen.setHp(-50);
        
    }
    
    /**
     * Take a delivery in his depot
     * @parameter loot which is deliveries to deliver. 
     * @override 
     */
    public void pickUpDelivery(Delivery loot)
    {
        if ( getCurrentRoom() == getDepot()){
            super.pickUpDelivery(loot);
        };
        
    }
    
    
    /**
     * drop delivery in his destination room
     * @override 
     */
    public void drop()
    {
        for ( Item i : getBag() ) {
            if(i instanceof Delivery){  
                Delivery d = (Delivery)i;
                if ( getCurrentRoom() == d.getGoal()){
                    getBag().remove(i);
                    break;
                }
            }     
        };
    }
}
