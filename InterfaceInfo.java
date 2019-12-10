import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.*;
import javax.swing.*;
import java.util.ArrayList;
  
/**
 * Write a description of class Interface_info here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     */
    public InterfaceInfo(InterfaceGame anInterface)
    {
        myGameInterface = anInterface;
        i = 0; //initialize the number of messages
        information = new ArrayList<String>();
        content = new JLabel("There is no message yet", JLabel.CENTER);
        
        /**
        setMessage("message 1");
        setMessage("message 2");
        setMessage("message 3");
        setMessage("message 4");
        setMessage("message 5");
        setMessage("message 6");
        setMessage("message 7");
        setMessage("message 8");
        **/
        
        
         // Create a label to display the interface name
        title = new JLabel("Message", JLabel.CENTER);
        title.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,35));
        
        //Create different border to design        
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        //let space around border
        paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);
         
        //Create a panel to put our border with the messages inside
        compoundBorders = new JPanel();
        
        //set the border
        compoundBorders.setBorder(paneEdge);
        compoundBorders.setLayout(new BoxLayout(compoundBorders,BoxLayout.Y_AXIS));     
        //create a double border
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        // add contents inside border
        addCompForBorder(compound, content ,compoundBorders);
        
        
        //Create a panel to put button next and previous
        action = new JPanel();
        next = new JButton("Next");
        next.addActionListener(this);
        previous = new JButton("Previous");
        previous.addActionListener(this);
        
        action.setLayout(new GridLayout(1,2)); 
        action.add(previous);
        action.add(next);

        //Create a final panel to put tittle, messages, and buttons
        finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));         
        finalPanel.add(title);
        finalPanel.add(compoundBorders);
        finalPanel.add(action);
        
        previous.setEnabled(false);
        
        if(information.size() < 1 )
        {
            next.setEnabled(false);
        }
        else if(information.size() == 1 )
        {
            content.setText(getMessage());
            next.setEnabled(false);
        }
        else
        {
            content.setText(getMessage()); 
            
        }
        
               
        this.add (finalPanel);
        
        this.setVisible(true); 
        this.setSize(250, 100);
    }

    private void setMessage(String theMessage){      
        information.add(theMessage);
    }
    
    
    private String getMessage(){      
        return(information.get(i));
    }
    
    private void nextMessage()
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
    private   void addCompForBorder(Border border,
                          JLabel description,
                          Container container) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        comp.add(description);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }


}
