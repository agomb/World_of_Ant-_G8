import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class manages the menu backgroung
 *
 * @author (G8 - Angelique Gombert)
 * @version (1)
 */
public class BcGdMenu extends JPanel {
  public void paintComponent(Graphics g){
    try {
      Image img = ImageIO.read(new File("Ant.jpg"));
      //g.drawImage(img, 0, 0, this);
      //For font image
      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }                
  }               
}