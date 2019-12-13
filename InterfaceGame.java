import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
/**
 * The InterfaceGame class is the main interface.It is the frame which regroups all the panels
 *
 * @author G8  - Marion Guernoté, Dylan Mielot, Fanny Barbé, Alix Nagot, Ambre Dumontet, Angélique Gombert, Thibault Crouzet
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
    private JPanel panInterfaceGame, panInterfaceGameBas, panInterfaceGameCentre, transparent, panInterfaceInfo; 
    private JButton blanc ;


    /**
     * Constructor for objects of class GameInterface
     * The constructor regroups all the panels
     * @Parameter Game g
     */
    public InterfaceGame(Game g)
    {
        super();
        game =g;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create the different panels in the frame
        this.info = new InfoBar(this);
        this.control = new ControlDirection(this);
        this.doable = new Doable(this);
        this.map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        this.message = new InterfaceInfo(this);

        //First JPanel located at the left of the frame.
        //this panel commands the meassages and all the different actions that a player can do
        panInterfaceGameCentre = new JPanel(); 
        panInterfaceGameCentre.setBackground(Color.WHITE);
        panInterfaceGameCentre.setLayout(new GridLayout(2,0)); 
        panInterfaceGameCentre.add(this.message); 
        panInterfaceGameCentre.add(this.doable); 
        
        //The second panel located at bottom of the frame contains the control direction,
        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);        
        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);
        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        blanc = new JButton(); //create a button enabled to use 
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(control); 

        //The third JPanel located at the center of the frame and represents the different rooms of the game 
        panInterfaceGame = new JPanel(); 
        panInterfaceGame.setBackground(Color.WHITE);
        panInterfaceGame.add(this.map); 

        //The fourth Jpanel regroups the information such as timer, bag capacity and life points
        panInterfaceInfo = new JPanel(); 
        panInterfaceInfo.setBackground(Color.WHITE);
        panInterfaceInfo.add(this.info); 
        
        //Here all the pabels are added to the frame
        this.setLayout(new BorderLayout()); 
        this.add(panInterfaceInfo, BorderLayout.NORTH); 
        this.add(panInterfaceGameCentre, BorderLayout.WEST); 
        this.add(panInterfaceGame, BorderLayout.CENTER); 
        this.add(panInterfaceGameBas, BorderLayout.SOUTH); 
        //getLayout().setBackground(Color.WHITE);

        this.setSize(1000,800);//size of the frame
        this.setLocationRelativeTo(null); // object position at the center
        this.setVisible(true); //allows the frame to be visible

    }
    
    /**
     * Allows to return the game
     * @return the game
     */
    public Game getGame(){
        return this.game;
    }
   
    /**
     * Allows to return the panel which contains the picture of the map
     * @return panel of the map
     */
    public InterfaceVisual getVisual(){
        return this.map; //return the interface with the map
    }
    
    /**
     * Allows to return the panel of messages
     * @return panel of messages
     */
    public InterfaceInfo getInfo(){
        return this.message; //return the interface with messages and informations about the room
    }
    
    /**
     * Allows to return the panel of timer, health and bag capacity
     * @return panel of timer, health and bag capacity
     */
    public InfoBar getBar(){
        return this.info; //retunr the interface with bag capacity, timer and points
    }
    
    /**
     * Allows to return the panel of action
     * @return panel of action : doable
     */
    public Doable getDoable(){
        return this.doable; //return the interface that allows the player to do something
    }
    
    /**
     * Allows to return the panel of control direction
     * @return panel of direction
     */
    public ControlDirection getDirection(){
        return this.control; //return the interface with the direction 
    }
    
    /**
     * The showMap method allows to update the map panel when an action is performed. 
     * @param panel 
     */
    public void showMap(JPanel panel) {
        map.removeAll(); //remove all the things containing in the panel
        panInterfaceGame.add(panel); //add the new panel
        panInterfaceGame.revalidate();
        panInterfaceGame.repaint();//repaint the panel with the new one
    }
   
}
