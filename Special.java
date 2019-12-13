/**
 * This class create a special item which can give a bonus or a malus to the player. 
 * It reduces or increase the vital or honor point.
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbé, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class Special extends Item
{
    // this attribute give bonus, which will be used to modify hp or vp.
    private int impact;
    /**
     * Constructor of the Special class
     *Instanciate a special object, by giving a name and a bonus value (which can be positive or negative).
     * @param sName which allows to give a name to the object
     * @param aBonus which will be used to modify hp or vp.
     */
    public Special(String sName)
    {
        super(sName);
        if(sName.equals("bonus")){
            impact = 15;
        }else if(sName.equals("malus")){
            impact = -15;
        }
    }

    /**
     * Give the value of the bonus.
     * @return bonus, which will be used to modify hp or vp.
     */
    public int getImpact()
    {
        return impact; //retunr an integer
    }
}