import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class GameInterface here.
 *
 * @author CROUZET G8
 * @version 27/11/2019
 */
public class InterfaceGame extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private Player player;
    private Game game;
    
    //new Player("test", new Room("test"))
    /**
     * Constructor for objects of class GameInterface
     */
    public InterfaceGame(Game g)
    {
        super();
        game = g;
        
        InfoBar info = new InfoBar(this);
        
        ControlDirection control = new ControlDirection(this);
        
        Doable doable = new Doable(this); 
        
        InterfaceVisual map = new InterfaceVisual(this);// need to be replace by InterfaceVisuel
        
        InterfaceInfo message = new InterfaceInfo(this);
        
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
    
    
    }
    
    public Game getGame(){
        return game;
    }
   
    public void main()
    {
        
        
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
