import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * Décrivez votre classe Begin_Interface ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class InterfaceBegin extends JFrame implements ActionListener 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    protected JPanel pan1, pan2n, pan3, pan4, pan5, panWelcome, panG, b2;
    protected JLabel monLabel, myLab1, photo1, photo2, label; 
    protected JButton sto, del;
    protected Icon monIcone, monIcone2, monIcone3;
    private Game game;
    
    /**
     * Constructeur d'objets de classe Begin_Interface
     */
    public InterfaceBegin()
    {
        super("MY MENU");
        game = new Game();
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
        
        sto = new JButton("Stolen Ant");
        sto.setBackground(Color.yellow);
        sto.setPreferredSize(new Dimension(150, 150));
        sto.addActionListener(this);
        
        del = new JButton("Deliveroo Ant");
        del.setBackground(Color.magenta);
        del.setPreferredSize(new Dimension(150, 150));
        del.addActionListener(this);
        
        b2.add(sto, BorderLayout.WEST);
        b2.add(del, BorderLayout.CENTER);
        
        // Game rules panel
        pan5 = new JPanel();
        pan4 = new JPanel();
        pan3 = new JPanel();
        pan3.setPreferredSize(new Dimension(500, 150));
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
        panG.setLayout( new BorderLayout(1,250));
        panG.setOpaque(false);
        panG.add(panWelcome, BorderLayout.PAGE_START);
        panG.add(b2, BorderLayout.CENTER);
        panG.add(pan5, BorderLayout.PAGE_END);
        
        // adding all in the frame
        this.add(panG);
        this.setSize(1600,900);
        this.setLocationRelativeTo(null); // object position at the center
        this.setUndecorated(true);
        this.setVisible(true);

        
    }
    
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
