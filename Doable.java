import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * This class is 
 * 
 * @author Group 8 (Alix and Dylan) 
 * @version 2019-11-26
 */
public class Doable extends JPanel implements ActionListener //creation class (public)
{
    private Player player;
    private JButton myButtonDrop, myButtonBoxe, myButtonTreasure;
    private InterfaceGame myGameInterface;
    
    
    public Doable(InterfaceGame anInterface) 
    {
        myGameInterface = anInterface;
        
        //create button drop
        myButtonDrop = new JButton("Drop");
        
        myButtonBoxe = new JButton("Boxe"); //create button Boxe
        ImageIcon icon1 = new ImageIcon("close.jpg"); 
        myButtonBoxe = new JButton(icon1); //create the button with images
        
        
        myButtonTreasure = new JButton("Treasure"); //create button Treasure
        Icon icon2 = new ImageIcon("coffre.jpg");
        myButtonTreasure = new JButton(icon2); //create the button with images
        
        //JPanel myPanel_Doable = new JPanel(); // create the panel
        this.setLayout(new GridLayout(3,1)); //create the localisation of the button
        this.add(myButtonDrop); // add the button in panel
        this.add(myButtonBoxe); // add the button in panel
        this.add(myButtonTreasure); // add the button in panel
        
        
        this.setVisible(true); // set visible the windows
        this.setSize(150, 100); // set the size of the windows
               
        
        myButtonDrop.setEnabled(false); // function for don't clic on the button
        myButtonTreasure.setEnabled(false); // function for don't clic on the button
    }
    
    public void main()
    {
    
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == myButtonDrop)
        {
            player.drop();
        }
        else if(e.getSource() == myButtonBoxe )
        {
            //récupération des objects de la pièce
            //player.getCurrentRoom().getTreasure();
        }
        else if(e.getSource() == myButtonTreasure )
        {
            //récupération de trésore de la pièce
            //player.getCurrentRoom().getTreasure();
        }
    }
}