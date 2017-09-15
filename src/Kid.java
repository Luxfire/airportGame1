import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 15.09.2017.
 */
public class Kid {

    int x = 380;
    int y = 180;
    int width = 15;
    int height = 30;
    ImageIcon imageMom = new ImageIcon("res/kid.png");

    public Kid(){}

    public void drawKid(Graphics g)
    {
        g.drawImage(imageMom.getImage(), x, y, width, height, null);
    }



}