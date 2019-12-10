
/**
 * This class allows to be able to create an item.  
 *
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 19/11/2019
 */
public class Item
{
    // This variables gives name to item
    private String nameItem;

    /**
     * This constructor create an item object and give him a name.
     * @param iName allows to give a name to the object
     */
    public Item(String iName)
    {
        if (nameItem.length() > 0 )
        {
            nameItem = iName;
        } 
    }
    
     /**
     * Give the name of the object.
     * @return the name of the object.
     */
    public String getName()
    {
      return nameItem;
    }
    
    
}