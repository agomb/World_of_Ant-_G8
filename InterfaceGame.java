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
    private JPanel panInterfaceGame, panInterfaceGameBas, panInterfaceGameCentre, transparent, panInterfaceInfo; 
    private JButton blanc ;


    /**
     * Constructor for objects of class GameInterface
     * @Parameter Game g
     */
    public InterfaceGame(Game g)
    {
        super();
        game =g;

        
        this.info = new InfoBar(this);
        this.control = new ControlDirection(this);
        this.doable = new Doable(this);
        this.map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        this.message = new InterfaceInfo(this);

        
        //First JPanel located at the left center of the panel.
        //this panel commands the meassages and all the different actions a player can do
        panInterfaceGameCentre = new JPanel(); 
        panInterfaceGameCentre.setBackground(Color.WHITE);
        panInterfaceGameCentre.setLayout(new GridLayout(2,0)); 
        panInterfaceGameCentre.add(this.message); 
        panInterfaceGameCentre.add(this.doable); 

        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);

        //second JPanel located at bottom of the panel,
        //this panel controls the direction 
        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);
        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        blanc = new JButton();
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(control); 

        //third JPanel located at the center and represents the map 
        panInterfaceGame = new JPanel(); 
        panInterfaceGame.setBackground(Color.WHITE);
        panInterfaceGame.add(this.map); 

        //fourth Jpanel that containt all of the others.
        panInterfaceInfo = new JPanel(); 
        panInterfaceInfo.setBackground(Color.WHITE);
        panInterfaceInfo.add(this.info); 
        

        this.setLayout(new BorderLayout()); 
        this.add(panInterfaceInfo, BorderLayout.NORTH); 
        this.add(panInterfaceGameCentre, BorderLayout.WEST); 

        this.add(panInterfaceGame, BorderLayout.CENTER); 
        this.add(panInterfaceGameBas, BorderLayout.SOUTH); 
        //getLayout().setBackground(Color.WHITE);

        this.setSize(1000,800);
        this.setLocationRelativeTo(null); // object position at the center
        this.setVisible(true);

    }
    
    public Game getGame(){
        return this.game;
    }
   
    public InterfaceVisual getVisual(){
        return this.map;
    }
    
    public InterfaceInfo getInfo(){
        return this.message;
    }
    
     public InfoBar getBar(){
        return this.info;
    }
    
    public Doable getDoable(){
        return this.doable;
    }
    
    public ControlDirection getDirection(){
        return this.control;
    }
    
    public void showMap(JPanel panel) {
        map.removeAll();
        panInterfaceGame.add(panel);
        panInterfaceGame.revalidate();
        panInterfaceGame.repaint();
    }
    
    
    public void showControl(JPanel panel1) {
        control.removeAll();
        

        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        blanc = new JButton();
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(panel1); 
        
        panInterfaceGameBas.revalidate();
        panInterfaceGameBas.repaint();
    }
    
    
    public void main()
    {
        
    }

}
