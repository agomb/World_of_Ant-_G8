import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
/**
 * This is the Begin_Interface class.
 * This class is the interface used at the beginning of the game to present 
 * It contains the rules of the game 
 * It contains also two buttons : these two buttons allow the player to choose which kind of character he/she wants to be. 
 * 
 * @author G8 - Marion Guernoté, Dylan Mielot, Fanny Barbé, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
 * @version 11/12/2019
 */
public class InterfaceBegin extends JFrame implements ActionListener 
{
    private JPanel pan1, pan2n, pan3, pan4, pan5, panWelcome, panG, b2; //panel attributes of the class
    private JLabel monLabel, myLab1, photo1, photo2, label; //label attributes of the class
    private JButton sto, del; //button attributes of the class
    private Icon monIcone, monIcone2, monIcone3; //Icone attributes of the class
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
        
        //Create the different icone and label of the panel
        myLab1 = new JLabel("Welcome to the world of ant choose your player", JLabel.CENTER);
        monIcone = new ImageIcon (new ImageIcon ("Ant.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        photo1 = new JLabel (monIcone, JLabel.CENTER);        
        monIcone2 = new ImageIcon (new ImageIcon ("Ant.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        photo2 = new JLabel (monIcone2, JLabel.CENTER);        
        
        //Add the different containers in the panel
        panWelcome.add(photo1);
        panWelcome.add(myLab1);       
        panWelcome.add(photo2);
        
        //Create the panel with the buttons to choose the type of player
        b2 = new JPanel();
        b2.setOpaque(false);
        
        //Stolen Ant player button
        sto = new JButton("Stolen ant (unable)");
        //sto.setBackground(Color.yellow);
        sto.setPreferredSize(new Dimension(150, 150));
        sto.addActionListener(this);
        sto.setEnabled(false);
        
        //Deliveroo Ant player button
        del = new JButton("DELIVEROO ANT");
        del.setBackground(Color.MAGENTA);
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
        label.setFont(new Font("Serif", Font.PLAIN, 25)); //to change the police
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
        
        // General Panel to display others panels
        panG = new JPanel();
        panG.setLayout( new BorderLayout(1,80));
        panG.setOpaque(false);
        panG.add(panWelcome, BorderLayout.PAGE_START);
        panG.add(b2, BorderLayout.CENTER);
        panG.add(pan5, BorderLayout.PAGE_END);
        
        // adding all in the frame
        this.add(panG);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null); // object position at the center
        this.setUndecorated(true);
        this.setVisible(true);

        
    }
    
    /**
     * The different actions performed when the player click on a button. Those listener are related two the two buttons
     * @param e is the event when a player click on a button
     */
     public void actionPerformed(ActionEvent e) 
     {     
        if(e.getSource() == sto){
            game.createPlayer(true); //when the player choose to be a stolen ant 
        }
        else if(e.getSource() == del){ 
            game.createPlayer(false); //when a player choose to be a deliveroo ant        
        }   
        this.setVisible(false);
        this.dispose();  
        InterfaceGame ig = new InterfaceGame(game);               
    } 
}