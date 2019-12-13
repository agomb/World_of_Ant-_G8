import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * This class create the interface to control the direction of the ant (player).
 * @author Group8 (Alix and Dylan) 
 * @version 2019-11-26
 */

public class ControlDirection extends JPanel implements ActionListener 
{   
   private JButton northButton, southButton, eastButton, westButton, upButton, downButton ; // the different button for each direction including up and down
   private InterfaceGame myGameInterface;
   private JPanel myPanelControl1;   
   /**
     * The constructor of the panel that will control the direction to move
     * @param anInterface links the panel with the direction with the InterfaceGame
     */
    public ControlDirection (InterfaceGame anInterface){
        super();
        myGameInterface = anInterface;
        
        //Creation of Buttons
        northButton = new JButton("↑");
        northButton.setBackground(Color.WHITE);
        northButton.addActionListener(this);
        southButton = new JButton("↓");
        southButton.setBackground(Color.WHITE);
        southButton.addActionListener(this);
        eastButton = new JButton("→");
        eastButton.setBackground(Color.WHITE);
        eastButton.addActionListener(this);
        westButton = new JButton("←");
        westButton.setBackground(Color.WHITE);
        westButton.addActionListener(this);
        upButton = new JButton("UP");
        upButton.setBackground(Color.WHITE);
        upButton.addActionListener(this);
        downButton = new JButton("DOWN");
        downButton.setBackground(Color.WHITE);
        downButton.addActionListener(this);

        //Creation of a GridLayout panel to add the buttons
        this.setLayout(new GridLayout(3,3));
        this.add(northButton);
        this.add(southButton);
        this.add(eastButton);
        this.add(westButton);
      
        
        myPanelControl1 = new JPanel();
        myPanelControl1.setLayout(new GridLayout(2,1));
        myPanelControl1.add(upButton);
        myPanelControl1.add(downButton);
        
        //Add all the buttons to the final panel
        this.setLayout(new BorderLayout());
        this.add(northButton, BorderLayout.NORTH);
        this.add(eastButton, BorderLayout.EAST);
        this.add(westButton, BorderLayout.WEST);
        this.add(southButton, BorderLayout.SOUTH);
        this.add(myPanelControl1, BorderLayout.CENTER);
        
        disableAllButtons();
        enableButton();
        
        this.setVisible(true);
    }
    
   /**
     *  This method disable all the buttons
     */
    public void disableAllButtons()
    {
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
        upButton.setEnabled(false);
        downButton.setEnabled(false);
    }
    
   /**
     * This method enable the different buttons
     * 
     */
    public void enableButton()
    {
        List<String> exitsAvailable = new ArrayList<String>();
        exitsAvailable = myGameInterface.getGame().getPlayer().getCurrentRoom().checkExits();
        for(String bName : exitsAvailable)
        {
            if(bName.equals("North"))
                northButton.setEnabled(true);
            if(bName.equals("South"))
                southButton.setEnabled(true);
            if(bName.equals("East"))
                eastButton.setEnabled(true);
            if(bName.equals("West"))
                westButton.setEnabled(true);
            if(bName.equals("Up"))
                upButton.setEnabled(true);
            if(bName.equals("Down"))
                downButton.setEnabled(true);
        }
    }
    
   /**
     * Add a listener to eahc buttons to allows the player to move in the posible direction
     */
    public void actionPerformed(ActionEvent e)
    {
        Room before = myGameInterface.getGame().getPlayer().getCurrentRoom();
        if(e.getSource() == northButton)
        {
            myGameInterface.getGame().getPlayer().moveRoom("North");
        }
        else if(e.getSource() == southButton )
        {
            myGameInterface.getGame().getPlayer().moveRoom("South");
        }
        else if(e.getSource() == eastButton )
        {
            myGameInterface.getGame().getPlayer().moveRoom("East");
        }
        else if(e.getSource() == westButton )
        {
            myGameInterface.getGame().getPlayer().moveRoom("West");
        }
        else if(e.getSource() == upButton )
        {
            myGameInterface.getGame().getPlayer().moveRoom("Up");
        }
        else if(e.getSource() == downButton )
        {
            myGameInterface.getGame().getPlayer().moveRoom("Down");
        }
        
        Room after = myGameInterface.getGame().getPlayer().getCurrentRoom();  
            
            myGameInterface.showMap(myGameInterface.getVisual());
            myGameInterface.getVisual().visualizeRoom(myGameInterface.getGame().getPlayer());
            
            myGameInterface.getDirection().disableAllButtons();
            myGameInterface.getDirection().enableButton();
            myGameInterface.getDirection().updateUI();       
            
            myGameInterface.getDoable().disableAllButtons();
            myGameInterface.getDoable().enableButton();
            myGameInterface.getDoable().updateUI();
            
            myGameInterface.getInfo().updateInfoDoorLock(before, after);
            if (before.getDescription() == after.getDescription())
            {
                myGameInterface.getInfo().nextMessage();
            }
            else 
            {
                myGameInterface.getInfo().updateInfoRoom();
                myGameInterface.getInfo().nextMessage();
            }   
            myGameInterface.getInfo().enableButton();
            myGameInterface.getInfo().updateUI();
          
            myGameInterface.getBar().updateUI();
            
            System.out.println(" Current room : "+myGameInterface.getGame().getPlayer().getCurrentRoom().getDescription());
    }
}