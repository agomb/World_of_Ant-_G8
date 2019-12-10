
/**
 *  The Character class is the super class corresponding to all the entities inside the game.
 * The entities can be either a player or a human (Non Player Character)
 * This classe gives a name to the entity (object)
 *
 * @author G8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 20/11/2019
 */
public class Character
{
    private String name; //name of the entity

    /**
     * Constructor of the Character class.
     * Constructs an instance of an entity and give it a name who is a string
     * But if the name given is empty or no name if given the default name would be "Standard".
     * 
     * @default name = "Standard"
     */
    public Character(String cName)
    {
        if(cName =="")//verify the given name
            cName = "Standard"; //apply the default name if no name or an empty name is given.
        else
            name = cName;
    }
    
    public Character()
    {
        name = "Standard"; //apply the default name if no name or an empty name is given.

    }
    
    /**
     * return the name of the character
     * @return the name of the character who is a String
     */
    public String getName()
    {
        return name;
    }

}