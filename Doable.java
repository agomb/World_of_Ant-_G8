import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color; 

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
        myButtonDrop.addActionListener(this);
        
        myButtonDelivery = new JButton("Boxe"); //create button Boxe
        ImageIcon icon1 = new ImageIcon("close1.png");
        myButtonDelivery = new JButton(icon1); //create the button with images
        myButtonDelivery.addActionListener(this);
        
        
        myButtonTreasure = new JButton("Treasure"); //create button Treasure
        Icon icon2 = new ImageIcon("coffre1.png");
        myButtonTreasure = new JButton(icon2); //create the button with images
        myButtonTreasure.addActionListener(this);
        
        myButtonHit = new JButton("Hit");
        myButtonHit.addActionListener(this);
        
          
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
               
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() ){
            myButtonDrop.setEnabled(false); // function for don't clic on the button
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() ){
            myButtonDrop.setEnabled(false); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); // function for don't clic on the button
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); // function for don't clic on the button
        }    
       
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() == null ){
            myButtonTreasure.setEnabled(false); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getComputer().getCurrentRoom() ){
            myButtonHit.setEnabled(false); // function for don't clic on the button
        }
    }
    
    public void disableAllButtons()
    {
        myButtonDrop.setEnabled(false);
        myButtonDelivery.setEnabled(false);
        myButtonTreasure.setEnabled(false);
        myButtonHit.setEnabled(false);
    }
    
    /**
     * This method allows to enable a button
     * 
     */
    public void enableButton()
    {
        disableAllButtons();    
        List<String> exitsAvailable = new ArrayList<String>();
        exitsAvailable = myGameInterface.getGame().getPlayer().getCurrentRoom().checkExits();
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() ){
            for(String bName : exitsAvailable)
            {
                if(bName.equals("Down"))
                   myButtonDrop.setEnabled(true);
            }
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() ){
            myButtonDrop.setEnabled(true); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() != null){
            myButtonDelivery.setEnabled(true); // function for don't clic on the button
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() != null){
            myButtonDelivery.setEnabled(true); // function for don't clic on the button
        }    
       
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() != null ){
            myButtonTreasure.setEnabled(true); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getComputer().getCurrentRoom() ){
            myButtonHit.setEnabled(true); // function for don't clic on the button
        }
    }
    /**
     * All gestion of the different actions done by the buttons
     */

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == myButtonDrop)
        {
             myGameInterface.getGame().getPlayer().drop();
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
             
             myGameInterface.getInfo().updateInfoDrop();
             myGameInterface.getInfo().enableButton();
             myGameInterface.getInfo().updateUI();
             
                         
             myGameInterface.getDoable().disableAllButtons();
             myGameInterface.getDoable().enableButton();
             myGameInterface.getDoable().updateUI();
             
             myGameInterface.getDirection().updateUI();
             myGameInterface.getBar().updateUI();
             myGameInterface.getVisual().updateUI();
             myGameInterface.getDoable().updateUI();
        }
        else if(e.getSource() == myButtonDelivery )
        {

             Delivery d = myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery(); 
          
             myGameInterface.getGame().getPlayer().pickUpDelivery(d);
             myGameInterface.getGame().getPlayer().getCurrentRoom().removeItem(d);

             
             //myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());   
             
             myGameInterface.getBar().updateUI();
        }
        else if(e.getSource() == myButtonTreasure )
        {
             System.out.println( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
             myGameInterface.getGame().getPlayer().pickUpBox(myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
             
             myGameInterface.showMap(myGameInterface.getVisual());
             myGameInterface.getVisual().visualizeRoom(myGameInterface.getGame().getPlayer());
            
             myGameInterface.getDirection().updateUI();
             myGameInterface.getBar().updateUI();
             myGameInterface.getVisual().updateUI();
             
             myGameInterface.getInfo().updateInfoBox();

             myGameInterface.getInfo().updateUI();
             
                         
             myGameInterface.getDoable().disableAllButtons();
             myGameInterface.getDoable().enableButton();

             myGameInterface.getDoable().updateUI();
        }
        
        else if(e.getSource() == myButtonHit )
        {
            DeliverooAnt p = (DeliverooAnt)myGameInterface.getGame().getPlayer();
            StolenAnt s = (StolenAnt)myGameInterface.getGame().getPlayer();     
            p.hitStolette(s);
            
            myGameInterface.getDirection().updateUI();
             myGameInterface.getBar().updateUI();
             myGameInterface.getVisual().updateUI();
             myGameInterface.getDoable().updateUI();
        }
    }
}