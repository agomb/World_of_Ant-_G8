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
  /**
   * This method allows to add a background to the start interface
   * @param g is linked to the Graphics package to add a background
   */
  public void paintComponent(Graphics g){
    try {
      Image img = ImageIO.read(new File("bg_image.jpg"));
      //g.drawImage(img, 0, 0, this);
      //For font image
      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }                
  }               
}