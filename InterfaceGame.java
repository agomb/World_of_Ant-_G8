import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
/**
 * The InterfaceGame class correspond to the game when is playing
 *
 * @author G8
 * @version 27/11/2019
 */
public class InterfaceGame extends JFrame 
{
    // instance variables
    private Game game;
    private ControlDirection control;
    private Doable doable;
    private InterfaceVisual map;
    private InterfaceInfo message;
    private InfoBar info;
    private JPanel panInterfaceGame, panInterfaceGameBas, panInterfaceGameCentre, transparent;    


    /**
     * Constructor for objects of class GameInterface
     * @Parameter Game g
     */
    public InterfaceGame(Game g)
    {
        super();
        game =g;

        info = new InfoBar(this);

        control = new ControlDirection(this);
        doable = new Doable(this);
        map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        message = new InterfaceInfo(this);

        
        //First JPanel located at the left center of the panel.
        //this panel commands the meassages and all the different actions a player can do
        panInterfaceGameCentre = new JPanel(); 
        panInterfaceGameCentre.setBackground(Color.WHITE);
        panInterfaceGameCentre.setLayout(new GridLayout(2,0)); 
        panInterfaceGameCentre.add(message); 
        panInterfaceGameCentre.add(doable); 

        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);

        //second JPanel located at bottom of the panel,
        //this panel controls the direction 
        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);
        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        JButton blanc = new JButton();
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(control); 

        //third JPanel located at the center and represents the map 
        panInterfaceGame = new JPanel(); 
        panInterfaceGame.setBackground(Color.WHITE);
        panInterfaceGame.add(info); 
        panInterfaceGame.add(map); 

        //fourth Jpanel that containt all of the others.

        this.setLayout(new BorderLayout()); 
        this.add(info, BorderLayout.NORTH); 
        this.add(panInterfaceGameCentre, BorderLayout.WEST); 
        this.add(map, BorderLayout.CENTER); 
        this.add(panInterfaceGameBas, BorderLayout.SOUTH);
        this.setBackground(Color.RED);
        
        this.setSize(1000,800);
        this.setLocationRelativeTo(null); // object position at the center
        this.setVisible(true);

    }
    
    public Game getGame(){
        return game;
    }
   
    public InterfaceVisual getVisual(){
        return map;
    }
    
    public InterfaceInfo getInfo(){
        return message;
    }
    
    public void main()
    {
        
    }

}
