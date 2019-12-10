import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Décrivez votre classe Interface_Visual ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class InterfaceVisual extends JFrame
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private InterfaceGame myGameInterface; 
    
    /**
     * Constructeur d'objets de classe Interface_Visual
     */
    public InterfaceVisual(InterfaceGame theInterface)
    {
        visualizeRoom(theInterface.getGame().getChoosenPlayer()); 
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public String getPictureRoom(Player myPlayer)
    {
        if((myPlayer.getCurrentRoom().getDescription() == "PlayerRoom") && (myPlayer instanceof DeliverooAnt )){
            return "delivery_room.jpg";
        }else if(myPlayer.getCurrentRoom().getDescription() == "PlayerRoom" && (myPlayer instanceof StolenAnt )){
            return "thief_room.jpg";
        }else if(myPlayer.getCurrentRoom().getDescription() == "2" || myPlayer.getCurrentRoom().getDescription() == "6" || myPlayer.getCurrentRoom().getDescription() == "20" || myPlayer.getCurrentRoom().getDescription() == "27" || myPlayer.getCurrentRoom().getDescription() == "10"){
            return "box_room.jpg";
        }else if(myPlayer.getCurrentRoom().getDescription() == "3" || myPlayer.getCurrentRoom().getDescription() == "7" || myPlayer.getCurrentRoom().getDescription() == "15" || myPlayer.getCurrentRoom().getDescription() == "18" || myPlayer.getCurrentRoom().getDescription() == "21" || myPlayer.getCurrentRoom().getDescription() == "29"){
            return "up_room.jpg";
        }else if(myPlayer.getCurrentRoom().getDescription()== "A" || myPlayer.getCurrentRoom().getDescription() == "B" || myPlayer.getCurrentRoom().getDescription() == "D" || myPlayer.getCurrentRoom().getDescription() == "E"){
            return "human_room.jpg";
        }else if(myPlayer.getCurrentRoom().getDescription() == "C" || myPlayer.getCurrentRoom().getDescription() == "F" || myPlayer.getCurrentRoom().getDescription() == "G"){
            return "box_human_room.jpg";
        }else{
            return "room.jpg";
        }
    }
    
     /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void visualizeRoom(Player myPlayer)
    {
        JPanel visualPanel;
        Icon iconRoom = new ImageIcon(new ImageIcon(getPictureRoom(myPlayer)).getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        JLabel mypicture = new JLabel(iconRoom, JLabel.CENTER);
        visualPanel = new JPanel();
        visualPanel.add(mypicture);
        visualPanel.setSize(1200,1200);
    }
}
