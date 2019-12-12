import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 * This class print the life, bag current capacity of the player and the time left.
 *
 * @author Dylan Thibault G8
 * @version 27/11/2019
 */
public class InfoBar extends JPanel 
{
    private InterfaceGame myGameInterface;
    private Player player;
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
        bagCunter.setString("Bag capacity :"+currentcapacity + "/"+14);
        bagCunter.setStringPainted(true);
        bagCunter.setValue(currentcapacity);
        bagCunter.setMaximum(14);
        bagCunter.setSize(200, 100);
        bagCunter.setVisible(true);
        
        life = new JProgressBar();
        life.setBackground(Color.WHITE);
        life.setString("Current life :"+currentlife + "/"+100);
        life.setStringPainted(true);
        life.setValue(currentlife);
        life.setMaximum(100);
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
                    jop1.showMessageDialog(null, "Time out", "You don't have time anymore", JOptionPane.INFORMATION_MESSAGE);
                    //this section is used when the time is up and finish the game
                    
                    
                }
            }
        };
        
        
        start();//start the timer
        this.add(bagCunter);
        this.add(life);
        this.add(time);
        this.setLayout(new GridLayout(1,4));
        this.setVisible(true);
    
    
    }
    
    /**
     * Start the timer
     */
    public void start()
    {
        timer.scheduleAtFixedRate(task,1000,1000);
    }
    
    /**
     * Modify the frame when a specific action is used and the time pass
     */
    public void actualisation(Player player)
    {
        currentcapacity = myGameInterface.getGame().getPlayer().getBag().size();
        bagCunter.setString("Bag capacity :"+currentcapacity + "/"+14);
        
        currentlife = myGameInterface.getGame().getPlayer().getHp();
        life.setString("Current life :"+currentlife + "/"+100);
        
    }

    
}
