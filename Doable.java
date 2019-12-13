
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color; 
/**
 * This class is the interface which contains all the buttons available for the player. 
 * Depending on which player it is, there are different buttons available (drop, pick up, take delivery)
 * 
 * @author Group 8  
 * @version 2019-11-26
 */
public class Doable extends JPanel implements ActionListener 
{
    private JButton myButtonDrop, myButtonDelivery, myButtonTreasure, myButtonHit;
    private InterfaceGame myGameInterface;
    /**
     * Constructor of the class doable. 
     * In this constructor are created all the buttons of the interface and the associated events.
     * @param anInterface links the Doable buttons to the interface of the game
     */
    public Doable(InterfaceGame anInterface) 
    {
        myGameInterface = anInterface;
        
        //create the button drop
        myButtonDrop = new JButton("Drop");
        myButtonDrop.addActionListener(this);
        
        myButtonDelivery = new JButton("Boxe"); //create button Delivery to pick up the delivery at the beginning of the game to deliver it
        ImageIcon icon1 = new ImageIcon("close1.png"); 
        myButtonDelivery = new JButton(icon1); 
        myButtonDelivery.addActionListener(this); //add the listener to the button
        
        myButtonTreasure = new JButton("Treasure"); //create button Treasure to open a treasure box when it is possible
        Icon icon2 = new ImageIcon("coffre1.png");
        myButtonTreasure = new JButton(icon2); //create the button with images
        myButtonTreasure.addActionListener(this); //add the listener to the button
        
        myButtonHit = new JButton("Hit");

        myButtonHit.addActionListener(this);
       
          
        //JPanel myPanel_Doable = new JPanel(); // create the panel
        this.setLayout(new GridLayout(4,1)); //create the localisation of the button
        this.add(myButtonDrop); // add the button in panel
        this.add(myButtonDelivery); // add the button in panel
        this.add(myButtonTreasure); // add the button in panel
        
        if (myGameInterface.getGame().getPlayer() instanceof DeliverooAnt){
            this.add(myButtonHit); 
        }
        
        this.setVisible(true); // set visible the windows
        this.setSize(150, 100); // set the size of the windows
               
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getBeginRoom() ){
            myButtonDrop.setEnabled(false); // enabled the player to drop a delivery when it is not the good room to drop it 
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getBeginRoom() ){
            myButtonDrop.setEnabled(false); // enabled the player to drop a delivery when it is not the good room to drop it 
        }
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getBeginRoom() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); // enabled the player to take a delivery when it is not the delivery room (the begin room 
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getBeginRoom() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); 
        }    
       
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() == null ){
            myButtonTreasure.setEnabled(false); // enabled the player to take a treasure box when there is no box in the room 
        }
        
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getComputer().getCurrentRoom() ){
            myButtonHit.setEnabled(false); 
        }
    }
    
    /**
     * The function allows to disable all the button of the Interface doable
     */
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
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getBeginRoom() ){
            for(String bName : exitsAvailable)
            {
                if(bName.equals("Down"))
                   myButtonDrop.setEnabled(true);
            }
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getBeginRoom() ){
            myButtonDrop.setEnabled(true); 
        }
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getBeginRoom() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() != null){
            myButtonDelivery.setEnabled(true); 
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getBeginRoom() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() != null){
            myButtonDelivery.setEnabled(true); 
        }    
       
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() != null ){
            myButtonTreasure.setEnabled(true);
        }
        
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getComputer().getCurrentRoom() ){
            myButtonHit.setEnabled(true); 
        }
    }
    
    /**
     * This method contains the listeners for all the buttons of the Doable interface 
     * @param e is the event that happened when a player click on a button
     */

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == myButtonDrop) //Action for the drop button
        {
             myGameInterface.getGame().getPlayer().drop();
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
             
             //Update the buttons
             myGameInterface.getInfo().updateInfoDrop();
             myGameInterface.getInfo().nextMessage();
             myGameInterface.getInfo().enableButton();
             myGameInterface.getInfo().updateUI();
                        
             myGameInterface.getDoable().disableAllButtons();
             myGameInterface.getDoable().enableButton();
             myGameInterface.getDoable().updateUI();
             
             myGameInterface.showMap(myGameInterface.getVisual());
             myGameInterface.getVisual().visualizeRoom(myGameInterface.getGame().getPlayer());
            

             myGameInterface.getBar().updateUI();
     
        }
        else if(e.getSource() == myButtonDelivery) //Action for the delivery button
        {
             Delivery d = myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery(); 
             
             myGameInterface.getGame().getPlayer().pickUpDelivery(d);
             myGameInterface.getGame().getPlayer().getCurrentRoom().removeItem(d);

             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());   
             myGameInterface.getBar().updateUI();

             myGameInterface.getDoable().disableAllButtons();
             myGameInterface.getDoable().enableButton();
             myGameInterface.getDoable().updateUI();
        }
        else if(e.getSource() == myButtonTreasure) //Action for the TreasureBox button
        {
              
             if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox().getLock() == null)
             {
                 myGameInterface.getInfo().updateInfoBox(myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
                 myGameInterface.getInfo().nextMessage();
                 myGameInterface.getInfo().updateUI();
             }   
             
             myGameInterface.getGame().getPlayer().pickUpBox(myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
             
             
             if (myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() != null && myGameInterface.getGame().getPlayer().getCurrentRoom().getBox().getLock().getIsLocked() == true)
             {  
                myGameInterface.getInfo().updateInfoBoxLock();
                myGameInterface.getInfo().nextMessage();
                myGameInterface.getInfo().updateUI();
             }
             
             
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
             myGameInterface.getBar().updateUI();
             
             myGameInterface.showMap(myGameInterface.getVisual());
             myGameInterface.getVisual().visualizeRoom(myGameInterface.getGame().getPlayer());
            
             myGameInterface.getDirection().updateUI();
                         
             
             myGameInterface.getDoable().enableButton();
             myGameInterface.getDoable().updateUI();
        }
        
        else if(e.getSource() == myButtonHit) //Action for the hit button
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