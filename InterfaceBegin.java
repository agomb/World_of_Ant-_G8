import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * This is the Begin_Interface class.
 * This class is the interface used at the start of the game to present 
 * the rule of the game and which type of ant the layer will be.
 *
 * @author G8
 * @version 11/12/2019
 */
public class InterfaceBegin extends JFrame implements ActionListener 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    protected JPanel pan1, pan2n, pan3, pan4, pan5, panWelcome, panG, b2; //This is all the different JPanel
    protected JLabel monLabel, myLab1, photo1, photo2, label; //This is all the different JLabel
    protected JButton sto, del; //This is the button to choose the type of ant
    protected Icon monIcone, monIcone2, monIcone3; //This is for the image of interface
    private Game game; //This is the game containing all its variable
    
    /**
     * Constructor of the class Begin_Interface
     */
    public InterfaceBegin()
    {
        //super("MY MENU");
        game = new Game(); //start the game
        this.setContentPane(new BcGdMenu());
        
        //Welcome panel
        panWelcome = new JPanel();
        panWelcome.setBackground(Color.ORANGE); 
        panWelcome.setLayout(new BoxLayout(panWelcome, BoxLayout.LINE_AXIS));
        
        myLab1 = new JLabel("Welcome to the world of ant choose your player", JLabel.CENTER);
        monIcone = new ImageIcon (new ImageIcon ("Ant.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        photo1 = new JLabel (monIcone, JLabel.CENTER);        
        monIcone2 = new ImageIcon (new ImageIcon ("Ant.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        photo2 = new JLabel (monIcone2, JLabel.CENTER);        
        panWelcome.add(photo1);
        panWelcome.add(myLab1);       
        panWelcome.add(photo2);
        
        //Player choice panel
        b2 = new JPanel();
        b2.setOpaque(false);
        
        sto = new JButton("STOLEN ANT");
        sto.setBackground(Color.yellow);
        sto.setPreferredSize(new Dimension(150, 150));
        sto.addActionListener(this);
        
        del = new JButton("DELIVEROO ANT");
        del.setBackground(Color.magenta);
        del.setPreferredSize(new Dimension(150, 150));
        del.addActionListener(this);
        
        b2.add(sto, BorderLayout.WEST);
        b2.add(del, BorderLayout.CENTER);
        
        // Game rules panel
        pan5 = new JPanel();
        pan4 = new JPanel();
        pan3 = new JPanel();
        pan3.setPreferredSize(new Dimension(400, 150));
        pan3.setLayout(new GridLayout(6,1));
        label = new JLabel("Game rules :", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 25));
        pan3.add(label);
        pan3.add(new JLabel("- Minimum number of packages to deliver or steal in the given time."));
        pan3.add(new JLabel("   Possible game-over:"));
        pan3.add(new JLabel ("- Stolen Ant : Losing all life points"));
        pan3.add(new JLabel ("- Deliveroo Ant : Losing all of her honor points "));       
        pan4.add(pan3);
        pan5.add(pan4);
        
        pan3.setBackground(Color.white);
        pan4.setBackground(Color.red);
        pan5.setOpaque(false);
        
        // General Panel for display others panels
        panG = new JPanel();
        panG.setLayout( new BorderLayout(1,80));
        panG.setOpaque(false);
        panG.add(panWelcome, BorderLayout.PAGE_START);
        panG.add(b2, BorderLayout.CENTER);
        panG.add(pan5, BorderLayout.PAGE_END);
        
        // adding all in the frame
        this.add(panG);
        this.setSize(800,600);
        this.setLocationRelativeTo(null); // object position at the center
        this.setUndecorated(false);
        this.setVisible(true);

        
    }
    /**
     * The different actions performed when a button is clicked
     */
     public void actionPerformed(ActionEvent e) {     

         if(e.getSource() == sto){
            game.createPlayer(true);  
        }
        else if(e.getSource() == del){ 
            game.createPlayer(false);          
        }   
        

        this.setVisible(false);
        this.dispose();
        
        InterfaceGame ig = new InterfaceGame(game);
                
    }
   
    
}