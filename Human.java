/**
 * The Human class is the class corresponding to the Non Player Character.
 * Those humans cannot move from their respectives rooms
 * The human has a name and can crush the stolen ant
 * 
 * @author Group 8 - Marion Guernoté, Dylan Mielot, Fanny Barbe, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 1
 */
public class Human extends Character
{
    /**
     * Constructor of the Human class
     * Use the constructor of the Charater class
     * @parameter theName who is a String and verified by the constructor of the Character class.
     */
    public Human(String theName)
    {
        super(theName);
        
    }
    public Human()
    {
        super("Standard");
        
    }
    /**
     * Inflic 25 dammage to the life of the StolenAnt
     * @param thief who represent the Stolen Ant and who will be cruch by the human
     * 
     */
    public void crush(StolenAnt thief)
    {   
        thief.setHp(-25); //call the setVp method of the stolen ant. This method will reduce the thief Vp by 25 without going beyond 0
    }
}
