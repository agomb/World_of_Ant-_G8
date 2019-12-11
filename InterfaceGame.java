import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
/**
 * Write a description of class GameInterface here.
 *
 * @author CROUZET G8
 * @version 27/11/2019
 */
public class InterfaceGame extends JFrame 
{
    // instance variables - replace the example below with your own
    private Game game;
    private ControlDirection control;
    private Doable doable;
    private InterfaceVisual map;  
    private InterfaceInfo message;

    private InfoBar info;
    private JPanel panInterfaceGame, panInterfaceGameBas, panInterfaceGameCentre, transparent;
    
    /**
     * Constructor for objects of class GameInterface
     */
    public InterfaceGame(Game g)
    {
        super();
        game =g;

        info = new InfoBar(this);

        InfoBar info = new InfoBar(this);
        ControlDirection control = new ControlDirection(this);
        Doable doable = new Doable(this);
        InterfaceVisual map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        InterfaceInfo message = new InterfaceInfo(this);
        
        panInterfaceGameCentre = new JPanel(); 
        panInterfaceGameCentre.setBackground(Color.WHITE);
        panInterfaceGameCentre.setLayout(new GridLayout(2,0)); 
        panInterfaceGameCentre.add(message); 
        panInterfaceGameCentre.add(doable); 
        
        panInterfaceGameBas = new JPanel();
        panInterfaceGameBas.setBackground(Color.WHITE);
        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        JButton blanc = new JButton();
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(control); 
        
        panInterfaceGame = new JPanel(); 
        panInterfaceGame.setBackground(Color.WHITE);
        panInterfaceGame.add(info); 
        panInterfaceGame.add(map); 
        
        this.setLayout(new BorderLayout()); 
        this.add(info, BorderLayout.NORTH); 
        this.add(panInterfaceGameCentre, BorderLayout.WEST); 
        this.add(map, BorderLayout.CENTER); 
        this.add(panInterfaceGameBas, BorderLayout.SOUTH); 

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
    
    public InfoBar getBar(){
        return info;
    }
}
