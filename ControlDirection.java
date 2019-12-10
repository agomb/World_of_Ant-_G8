import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
     * @param   bName   The button name 
     */
    public void enableButton(String bName)
    {
        bName.toLowerCase(); //make sure that the string don't have upper case to compare it
        if(bName.equals("north"))
            northButton.setEnabled(true);
        if(bName.equals("south"))
            southButton.setEnabled(true);
        if(bName.equals("east"))
            eastButton.setEnabled(true);
        if(bName.equals("west"))
            westButton.setEnabled(true);
        if(bName.equals("up"))
            upButton.setEnabled(true);
        if(bName.equals("down"))
            downButton.setEnabled(true);
    }
    
    /**
     * 
     */
    public void actionPerformed(ActionEvent e)
    {
        
    }
}