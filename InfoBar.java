import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Write a description of class InfoBar here.
 *
 * @author Dylan Thibault G8
 * @version 27/11/2019
 */
public class InfoBar extends JPanel 
{
    private InterfaceGame myGameInterface;
    
    private JProgressBar bagCunter;
    private JProgressBar life;
    
    
    private JLabel time;
    private int timeLimit = 300;
    
    private Timer timer = new Timer();
    private TimerTask task;
    
    private static JOptionPane jop1;
    
    private int currentcapacity,currentlife,secondes;
  
    /**
     * Constructor for objects of class InfoBar
     * Created the 3 different bars :
     * -the bag capacity
     * -the life/honor point
     * -the time left in second
     */
    public InfoBar(InterfaceGame anInterface)
    {
        super();
        myGameInterface = anInterface;
        
        
        //getting the bag capacity and life/honor point attribute of the player
        
        
        currentcapacity = myGameInterface.getGame().getPlayer().getBag().size();
        currentlife = myGameInterface.getGame().getPlayer().getHp();
        
        
        
        bagCunter = new JProgressBar();
        bagCunter.setBackground(Color.WHITE);
        bagCunter.setString("Bag capacity :"+currentcapacity + "/"+20);
        bagCunter.setStringPainted(true);
        bagCunter.setValue(currentcapacity);
        bagCunter.setMaximum(20);
        bagCunter.setSize(200, 100);
        //bagCunter.setBackground(Color.orange); //modify orange to an other color if you want
        bagCunter.setVisible(true);
        
        
        
        
        life = new JProgressBar();
        life.setBackground(Color.WHITE);
        life.setString("Current life :"+currentlife + "/"+100);
        life.setStringPainted(true);
        life.setValue(currentlife);
        life.setMaximum(100);
        //life.setBackground(Color.red); //modify red to an other color if you want
        life.setVisible(true);
        
        
        
        //the timer section who start at 300s (5minutes)      
        time = new JLabel();
        time.setBackground(Color.WHITE);
        
        task = new TimerTask() {
            public void run() {
                if(timeLimit > 0)
                {
                    timeLimit--;
                
                    time.setText("time left : " + timeLimit);
                    actualisation(myGameInterface.getGame().getPlayer());
                }
                else
                {
                    actualisation(myGameInterface.getGame().getPlayer());
                    time.setText("The End Game");
                    timer.cancel();
                    timer.purge();
                    jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Game Over", "The Game has ended", JOptionPane.INFORMATION_MESSAGE);

                    
                    
                }
            }
        };
        
        
        start();//start the timer
        
        
        
        this.add(bagCunter);
        this.add(life);
        this.add(time);
        
        this.setLayout(new GridLayout(1,3));
        
        this.setVisible(true);
    
    
    }

    public void start()
    {
        timer.scheduleAtFixedRate(task,1000,1000);
    }
    
    /**
     * Modify the frame when a specific action is used
     */
    public void actualisation(Player player)
    {
        currentcapacity = myGameInterface.getGame().getPlayer().getBag().size();
        bagCunter.setString("Bag capacity : "+ currentcapacity + "/"+20);
        
        currentlife = myGameInterface.getGame().getPlayer().getHp();
        life.setString("Current life : "+currentlife + "/"+100);
        
    }
    
    
    
}
