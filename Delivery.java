/**
 * This class allows to instanciate a delivery which can be deliver by a ant.
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */

public class Delivery extends Item
{
    //goal is the room where the delivery should be droped.
    private Room goal;

    /**
     * Create the delivery with a name and its destination
     * @param dName allows to give a name to the object
     * @param goalR is the room goal to drop the object.
     */
    public Delivery(String dName, Room goalR)
    {
        super(dName);
        goal = goalR;
    }
    
     /**
     * Give the room goal of the delivery
     * @return goal, the room goal of the delivery
     */
    public Room getGoal()
    {
        return goal;
    }
}