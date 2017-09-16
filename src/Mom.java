import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 15.09.2017.
 */
public class Mom {

    int x = 350;
    int y = 150;
    int width = 30;
    int height = 60;
    Rectangle rectMom = new Rectangle(360,200,10,10);
    ImageIcon imageMom = new ImageIcon("res/mom.png");

    public Mom(){}

    public void drawMom(Graphics g)
    {
        g.drawImage(imageMom.getImage(), x, y, width, height, null);
    }



}
