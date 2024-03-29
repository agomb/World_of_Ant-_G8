import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;  
/**
 * This class print the messages and informations for the player
 *
 * @author G8
 * @version 11/12/2019
 */
public class InterfaceInfo extends JPanel implements ActionListener
{
    // instance variables - replace the example below with your own
    private InterfaceGame myGameInterface;
    private JLabel title, content;
    //private JFrame myFrame;
    private ArrayList<String> information; // array of messages to display
    private JButton next, previous; //button to go on the next or the previous message
    private int i; //the indice of the message displayed
    private JPanel compoundBorders, action, finalPanel;    
    private Border compound, paneEdge, raisedbevel, loweredbevel, empty;
    
    /**
     * Allow to create the information interface which will display messages from the game
     * @param anInterface allows to linked the class InterfaceInfo to the class InterfaceInfo
     */
    public InterfaceInfo(InterfaceGame anInterface)
    {
        myGameInterface = anInterface;
        i = 0; //initialize the number of messages
        information = new ArrayList<String>();

        content = new JLabel("There is no message yet", JLabel.CENTER); //message printed when there are no others messages
        
          
         // Create a label to display the interface name
        title = new JLabel("Message        ", JLabel.CENTER);
        title.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,35));
        title.setBackground(Color.WHITE);
        
        //Create different border to design        
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        
        //let space around border
        paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);
         
        //Create a panel to put our border with the messages inside
        compoundBorders = new JPanel();
        compoundBorders.setBackground(Color.WHITE);
        //set the border
        compoundBorders.setBorder(paneEdge);
        compoundBorders.setLayout(new BoxLayout(compoundBorders,BoxLayout.Y_AXIS));     
        //create a double border
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        // add contents inside border
        addCompForBorder(compound, content ,compoundBorders);
        
        
        //Create a panel to put button next and previous
        action = new JPanel();
        action.setBackground(Color.WHITE);
        next = new JButton("Next");
        next.addActionListener(this);
        next.setBackground(Color.WHITE);
        previous = new JButton("Previous");
        previous.addActionListener(this);
        previous.setBackground(Color.WHITE);
        
        action.setLayout(new GridLayout(1,2)); 
        action.add(previous);
        action.add(next);

        //Create a final panel to put tittle, messages, and buttons
        finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));         
        finalPanel.add(title);
        //finalPanel.add(content);
        finalPanel.add(compoundBorders);
        finalPanel.add(action);
        finalPanel.setBackground(Color.WHITE);
        
        this.enableButton();
               
        this.add (finalPanel);
        
        this.setVisible(true); 
        this.setSize(250, 100);
    }

    /**
     * This method allows to disable all buttons
     * when this method is used, the user cannot click on the buttons
     */
    public void disableAllButtons()
    {
        next.setEnabled(false);
        previous.setEnabled(false);
    }
    
    /**
     * This method allows to enable a button
     * 
     */
    public void enableButton()
    {
        disableAllButtons();    
        
        if(information.size() > 0 && i != information.size()  )
        {
            next.setEnabled(true);
        }
        if(i > 1)
        {
            previous.setEnabled(true);
        }

       
    }
    
    /**
     * Add a new message to the list of message
     * @parameter String theMessage => correspond to the new message
     */
    private void setMessage(String theMessage){      
        information.add(theMessage);
    }
    
    /**
     * Update the message list when a treasure box is picked up 
    */
    public void updateInfoBox(TreasureBox box){
        information.add(box.getDescription());
    }
    
    /**
     * Update the message list when a delivery is droped
    */
    public void updateInfoDrop(){
        Character c = myGameInterface.getGame().getPlayer();
        Player p = (Player)c; 
        Delivery t = p.getCurrentRoom().getDelivery();
        this.information.add("You drop a delivery");
    }
    
    
    /**
     * Update the message list when we move to another room
    */
    public void updateInfoRoom(){
        Character c = myGameInterface.getGame().getPlayer();
        Player p = (Player)c; 
        this.information.add("You are in the room: " + p.getCurrentRoom().getDescription());
    }
    
    /**
     * Update the message list when we try to open a door which is locked
    */
    public void updateInfoDoorLock(Room before, Room after){
        Character c = myGameInterface.getGame().getPlayer();
        Player p = (Player)c; 
        if ( before.getDescription() == after.getDescription() ){
            this.information.add("You haven't the key which open this door");
        }
    }
    
    /**
     * Update the message list when we try to open a box which is locked
    */
    public void updateInfoBoxLock(){
        Character c = myGameInterface.getGame().getPlayer();
        Player p = (Player)c; 
        if ( p.getCurrentRoom().getBox().getLock().getIsLocked() == true){
            this.information.add("You haven't the key which open this box");
        }
    }
    
    /**
     * Return the message
     * @return String
     */
    private String getMessage(){      
        return(information.get(i));
    }
    
    /**
     * Print the next message
     * Verify if there is only one message, or if you are at the end of the list
     */
    public void nextMessage()
    {       
            if(information.size() <= 1 )
            {
                content.setText(getMessage());
                next.setEnabled(false);
            }
            else
            {
                if(i==information.size()-1)
                {
                    
                    next.setEnabled(false);
                    if(information.size() > 1 )
                    {
                        previous.setEnabled(true);
                    }
                    
                }
                else
                {
                    
                    i++;
                    next.setEnabled(true);
                    if(i==information.size()-1)
                    {
                        next.setEnabled(false);
                        
                    }
                    if(information.size() > 1 && i > 0 )
                        {
                            previous.setEnabled(true);
                        }
                }
                content.setText(getMessage());
            }
            
           
    }
    /**
     * Print the previous message
     * Verify if there is only one message, or if you are at the start of the list
     */
    private void previousMessage()
    {       
            if(information.size() <= 1 )
            {
                content.setText(getMessage());
                previous.setEnabled(false);
            }
            else
            {
                if(i==0)
                {
                    
                    previous.setEnabled(false);
                    if(information.size() > 1 && i <= information.size() )
                    {
                        next.setEnabled(true);
                    }
                    
                }
                else
                {
                    i--;
                    content.setText(getMessage());
                    
                    previous.setEnabled(true);
                    if(i==0)
                    {
                    
                        previous.setEnabled(false);
                        
                    }
                    if(information.size() > 1 && i <= information.size() )
                        {
                            next.setEnabled(true);
                        }
                }
                content.setText(getMessage());
            }
            
            
    }
    
    /**
     * Print the next or previous message 
     */
     public void actionPerformed(ActionEvent e) {     
        if(e.getSource() == next){
            
            nextMessage();
        }
        else if(e.getSource() == previous){ 
            
            previousMessage();
            
        }   
        
        
    }

    /**
     * Allow to display text inside border
     */
    private void addCompForBorder(Border border,
                          JLabel description,
                          Container container) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        comp.add(description);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }

}
