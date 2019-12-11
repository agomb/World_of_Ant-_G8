import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This class create the interface.
 * @author Group8 (Alix and Dylan) 
 * @version 2019-11-26
 */

public class ControlDirection extends JPanel implements ActionListener 
{   
    private JButton northButton, southButton, eastButton, westButton, upButton, downButton ;
    private InterfaceGame myGameInterface;
    
    public ControlDirection (InterfaceGame anInterface){
        super();
        myGameInterface = anInterface;
        
        
        //Creation of Buttons
        northButton = new JButton("↑");
        southButton = new JButton("↓");
        eastButton = new JButton("→");
        westButton = new JButton("←");
        upButton = new JButton("Up");
        downButton = new JButton("Down");
        
        //panelArround
        //JPanel myPanel_control = new JPanel();
        this.setLayout(new GridLayout(3,3));
        this.add(northButton);
        this.add(southButton);
        this.add(eastButton);
        this.add(westButton);
      
        //panelCenter 
        JPanel myPanel_control1 = new JPanel();
        myPanel_control1.setLayout(new GridLayout(2,1));
        myPanel_control1.add(upButton);
        myPanel_control1.add(downButton);
        
        //Frame
        
        this.setLayout(new BorderLayout());
        this.add(northButton, BorderLayout.NORTH);
        this.add(eastButton, BorderLayout.EAST);
        this.add(westButton, BorderLayout.WEST);
        this.add(southButton, BorderLayout.SOUTH);
        this.add(myPanel_control1, BorderLayout.CENTER);
        
        disableAllButtons();
        enableButton();
    }
    
    /**
     *  This method allows to make all the direction buttons disabled
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
     * This method allows to enable a button
     * 
     */
    public void enableButton()
    {
        List<String> exitsAvailable = new ArrayList<String>();
        exitsAvailable = myGameInterface.getGame().getPlayer().getCurrentRoom().checkExits();
        for(String bName : exitsAvailable)
        {
            System.out.println("ça marche pas");
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
     * 
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == northButton)
        {
            
        }
        else if(e.getSource() == southButton )
        {
            
        }
        else if(e.getSource() == eastButton )
        {

        }
        else if(e.getSource() == westButton )
        {

        }
        else if(e.getSource() == upButton )
        {

        }
        else if(e.getSource() == downButton )
        {

        }
    }
}