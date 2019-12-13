import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * The Interface_Visual class represents the different rooms of the game. 
 * Those rooms are differents depending on what is inside. It can be possible to be in a room whitout anything on the underground
 * It can be possible to be in a room that contains a treasure box or a room that contains a scale to go on the human ground (on the underground). 
 * Finally, there are room on the ground with only human or with human and a treausre box. 
 *
 * @author G8
 * @version 11/12/2019
 */
public class InterfaceVisual extends JPanel
{
    private InterfaceGame myGameInterface; 
    /**
     * Constructeur d'objets de classe Interface_Visual
     */
    public InterfaceVisual(Room myRoom, Player myPlayer, InterfaceGame theInterface)
    {
        visualizeRoom(myPlayer); 
    }

    /**
     * Visualize the room where the player is.
     * @param Player myPlayer
     */
    public String getPictureRoom(Player myPlayer)
    {
       if((myPlayer.getCurrentRoom().getDescription() == "PlayerRoom") && (myPlayer instanceof DeliverooAnt )){
            return "delivery_room";
       }else if(myPlayer.getCurrentRoom().getDescription() == "PlayerRoom" && (myPlayer instanceof StolenAnt )){
            return "thief_room";
       }else if(myPlayer.getCurrentRoom().getBox() != null && !myPlayer.getCurrentRoom().getDescription().matches("^[a-zA-Z]")){ 
            return "box_room";
       }else if(myPlayer.getCurrentRoom().getDescription() == "3" || myPlayer.getCurrentRoom().getDescription() == "7" || myPlayer.getCurrentRoom().getDescription() == "10" ||myPlayer.getCurrentRoom().getDescription() == "15" || myPlayer.getCurrentRoom().getDescription() == "18" || myPlayer.getCurrentRoom().getDescription() == "21" || myPlayer.getCurrentRoom().getDescription() == "29"){
            return "up_room";
        }else if(myPlayer.getCurrentRoom().getBox() != null && myPlayer.getCurrentRoom().getDescription().matches("^[a-zA-Z]")){ 
            return "box_human_room";
        }else if (myPlayer.getCurrentRoom().getDescription().matches("^[a-zA-Z]")){ 
            return "human_room";
       } else{
            return "galerie";
       }
        
       //}else if((myGameInterface.getGame().getComputer().getCurrentRoom().getDescription() == myPlayer.getCurrentRoom().getDescription()) && (myPlayer instanceof StolenAnt)){
       //return getPictureRoom(myPlayer)+"_fourmi1";else if((myGameInterface.getGame().getComputer().getCurrentRoom().getDescription() == myPlayer.getCurrentRoom().getDescription()) && (myPlayer instanceof DeliverooAnt)){
       //  System.out.println("3");
       //  return getPictureRoom(myPlayer)+"_fourmi2";
       // }else if(myPlayer.getCurrentRoom().getDescription() == "1" || myPlayer.getCurrentRoom().getDescription() == "6" || myPlayer.getCurrentRoom().getDescription() == "20" || myPlayer.getCurrentRoom().getDescription() == "27" || myPlayer.getCurrentRoom().getDescription() == "10"){
       //     System.out.println("bug");
       //     return "up_room";
    }
    
    /**
     * Created the panel containt the map
     * @param myPlayer allows to selected the right room to display it 
     */
    public void visualizeRoom(Player myPlayer)
    {
        Icon iconRoom = new ImageIcon(new ImageIcon(getPictureRoom(myPlayer)+".jpg").getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT));
        JLabel myPicture = new JLabel(iconRoom, JLabel.CENTER);
        this.add(myPicture);
        this.setSize(1200,1200);
    }
}
