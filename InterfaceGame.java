import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    
    protected JPanel panInterfaceGame, panInterfaceGameBas, panInterfaceGameCentre, transparent;
    
    /**
     * Constructor for objects of class GameInterface
     */
    public InterfaceGame(Game g)
    {
        super();
        game =g;
        
        InfoBar info = new InfoBar(this);
        ControlDirection control = new ControlDirection(this);
        Doable doable = new Doable(this);
        InterfaceVisual map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        InterfaceInfo message = new InterfaceInfo(this);
        
        panInterfaceGameCentre = new JPanel(); 
        panInterfaceGameCentre.setLayout(new GridLayout(2,0)); 
        panInterfaceGameCentre.add(message); 
        panInterfaceGameCentre.add(doable); 
        
        panInterfaceGameBas = new JPanel(); 
        panInterfaceGameBas.setLayout(new GridLayout(0,2));
        JButton blanc = new JButton();
        blanc.setBorderPainted(false); 
        blanc.setContentAreaFilled(false);
        blanc.setFocusPainted(false); 
        panInterfaceGameBas.add(blanc);
        panInterfaceGameBas.add(control); 
        
        
        panInterfaceGame = new JPanel(); 
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
        
        /*
        InfoBar info = new InfoBar(this);    
        control = new ControlDirection(this);
        
        doable = new Doable(this);
        
        map = new InterfaceVisual(getGame().getPlayer().getCurrentRoom(),getGame().getPlayer(), this);
        
        message = new InterfaceInfo(this);
        
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        
        
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        this.add( info , c);
        
        
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        this.add( message , c );//GridBagLayout.FIRST_LINE_START);
        
        c.fill = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 2;
        this.add( doable , c ); //GridBagLayout.WEST);
        //this.add( doable , BorderLayout.AFTER_LAST_LINE);
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        this.add( map , c ); // GridBagLayout.CENTER);
        
        c.fill = GridBagConstraints.LINE_END;
        c.gridx = 2;
        c.gridy = 2;
        this.add( control , c ); //GridBagLayout.EAST);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        */
       
        
    
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
