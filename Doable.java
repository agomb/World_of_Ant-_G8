import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * This class is all the button corespond to the diffeerent action that a player can do except the movement
 * 
 * @author Group 8 (Alix and Dylan) 
 * @version 2019-11-26
 */
public class Doable extends JPanel implements ActionListener //creation class (public)
{
    private JButton myButtonDrop, myButtonDelivery, myButtonTreasure, myButtonHit;
    private InterfaceGame myGameInterface;
    
    
    public Doable(InterfaceGame anInterface) 
    {
        myGameInterface = anInterface;
        
        //create button drop
        myButtonDrop = new JButton("Drop");
        
        myButtonDelivery = new JButton("Boxe"); //create button Boxe
        ImageIcon icon1 = new ImageIcon(new ImageIcon("close.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        myButtonDelivery = new JButton(icon1); //create the button with images
        
        
        myButtonTreasure = new JButton("Treasure"); //create button Treasure
        Icon icon2 = new ImageIcon(new ImageIcon("coffre.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        myButtonTreasure = new JButton(icon2); //create the button with images
        
        myButtonHit = new JButton("Hit");
          
        //JPanel myPanel_Doable = new JPanel(); // create the panel
        this.setLayout(new GridLayout(3,1)); //create the localisation of the button
        this.add(myButtonDrop); // add the button in panel
        this.add(myButtonDelivery); // add the button in panel
        this.add(myButtonTreasure); // add the button in panel
        
        if (myGameInterface.getGame().getPlayer() instanceof DeliverooAnt){
            this.add(myButtonHit); 
        }
        
        this.setVisible(true); // set visible the windows
        this.setSize(150, 100); // set the size of the windows
               
        
        myButtonDrop.setEnabled(false); // function for don't clic on the button
        myButtonTreasure.setEnabled(false); // function for don't clic on the button
    }
    
    /**
     * All gestion of the different actions done by the buttons
     */

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == myButtonDrop)
        {
            myGameInterface.getGame().getPlayer().drop();
            myGameInterface.getVisual().updateUI();
        }
        else if(e.getSource() == myButtonDelivery )
        {
             myGameInterface.getGame().getPlayer().pickUpDelivery(myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery());
             myGameInterface.getVisual().updateUI();
        }
        else if(e.getSource() == myButtonTreasure )
        {
             myGameInterface.getGame().getPlayer().pickUpBox(myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
             myGameInterface.getVisual().updateUI();
             myGameInterface.getInfo().updateInfo();
        }
        
        else if(e.getSource() == myButtonHit )
        {
            DeliverooAnt p = (DeliverooAnt)myGameInterface.getGame().getPlayer();
            StolenAnt s = (StolenAnt)myGameInterface.getGame().getPlayer();
                  
            p.hitStolette(s);
        }
    }
}