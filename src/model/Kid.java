package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 15.09.2017.
 */
public class Kid {

    public int x = 380;
    public int y = 180;
    public int width = 15;
    public int height = 30;
    public ImageIcon imageMom = new ImageIcon("res/kid.png");

    public Kid(){}

    public void drawKid(Graphics g)
    {
        g.drawImage(imageMom.getImage(), x, y, width, height, null);
    }



}