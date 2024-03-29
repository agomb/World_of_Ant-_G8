/**
 * This is the mother class to create the different kind of items.   
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class Item
{
    // This variables gives name to the items
    private String nameItem;
    /**
     * This constructor create an item object and give him a name.
     * @param iName allows to give a name to the object
     */
    public Item(String iName)
    {
        if (iName.length() > 0 )
        {
            nameItem = iName;
        }
        else nameItem = "item";
    }
    
    /**
     * Give the name of the object.
     * @return the name of the object.
     */
    public String getName()
    {
      return nameItem; //return the name of the items
    }
}