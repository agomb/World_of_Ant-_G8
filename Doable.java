
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * This class is 
 * 
 * @author Group 8 (Alix and Dylan) 
 * @version 2019-11-26
 */
public class Doable extends JPanel implements ActionListener //creation class (public)
{
    private JButton myButtonDrop, myButtonDelivery, myButtonTreasure, myButtonHit;
    private InterfaceGame myGameInterface;
    
    
    public Doable(InterfaceGame anInterface) 
    {
        myGameInterface = anInterface;
        
        //create button drop

        myButtonDrop = new JButton("Drop");
        myButtonDrop.addActionListener(this);

        myButtonDrop = new JButton("DROP");
        myButtonDrop.setBackground(Color.WHITE);

        
        myButtonDelivery = new JButton("Boxe"); //create button Boxe
        ImageIcon icon1 = new ImageIcon("close1.png");
        myButtonDelivery = new JButton(icon1); //create the button with images

        myButtonDelivery.addActionListener(this);
        
        myButtonDelivery.setBackground(Color.BLACK);
        
        myButtonTreasure = new JButton("Treasure"); //create button Treasure
        Icon icon2 = new ImageIcon("coffre1.png");
        myButtonTreasure = new JButton(icon2); //create the button with images
        myButtonTreasure.addActionListener(this);
        
        myButtonHit = new JButton("Hit");
        myButtonHit.addActionListener(this);
        
        myButtonTreasure.setBackground(Color.YELLOW);
        
        myButtonHit = new JButton("Hit");
        myButtonHit.setBackground(Color.WHITE);

          
        //JPanel myPanel_Doable = new JPanel(); // create the panel
        this.setLayout(new GridLayout(3,1)); //create the localisation of the button
        this.add(myButtonDrop); // add the button in panel
        this.add(myButtonDelivery); // add the button in panel
        this.add(myButtonTreasure); // add the button in panel
        
        if (myGameInterface.getGame().getPlayer() instanceof DeliverooAnt){
            this.add(myButtonHit); 
        }
        
        this.setVisible(true); // set visible the windows
        this.setSize(150, 100); // set the size of the windows
               
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() ){
            myButtonDrop.setEnabled(false); // function for don't clic on the button
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() ){
            myButtonDrop.setEnabled(false); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer() instanceof DeliverooAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); // function for don't clic on the button
        }else if ( myGameInterface.getGame().getPlayer() instanceof StolenAnt && myGameInterface.getGame().getPlayer().getCurrentRoom() == myGameInterface.getGame().getPlayer().getDepot() && myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery() == null){
            myButtonDelivery.setEnabled(false); // function for don't clic on the button
        }    
       
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom().getBox() == null ){
            myButtonTreasure.setEnabled(false); // function for don't clic on the button
        }
        
        if ( myGameInterface.getGame().getPlayer().getCurrentRoom() != myGameInterface.getGame().getComputer().getCurrentRoom() ){
            myButtonHit.setEnabled(false); // function for don't clic on the button
        }
    }
    

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == myButtonDrop)
        {
            myGameInterface.getGame().getPlayer().drop();
            myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
            myGameInterface.getBar().updateUI();
            myGameInterface.getVisual().updateUI();
        }
        else if(e.getSource() == myButtonDelivery )
        {
             Delivery d = myGameInterface.getGame().getPlayer().getCurrentRoom().getDelivery(); 
          
             myGameInterface.getGame().getPlayer().pickUpDelivery(d);
             myGameInterface.getGame().getPlayer().getCurrentRoom().removeItem(d);

             
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());   
             myGameInterface.getBar().updateUI();
             myGameInterface.getVisual().updateUI();
        }
        else if(e.getSource() == myButtonTreasure )
        {
             myGameInterface.getGame().getPlayer().pickUpBox(myGameInterface.getGame().getPlayer().getCurrentRoom().getBox());
             myGameInterface.getBar().actualisation(myGameInterface.getGame().getPlayer());
             myGameInterface.getBar().updateUI();
             myGameInterface.getVisual().updateUI();
             myGameInterface.getInfo().updateInfoBox();
        }
        
        else if(e.getSource() == myButtonHit )
        {
            DeliverooAnt p = (DeliverooAnt)myGameInterface.getGame().getPlayer();
            StolenAnt s = (StolenAnt)myGameInterface.getGame().getPlayer();      
            p.hitStolette(s);
        }
    }
}