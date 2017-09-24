package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 15.09.2017.
 */
public class Mom {

    public int x = 350;
    public int y = 150;
    public int width = 30;
    public int height = 60;
    public Rectangle rectMom = new Rectangle(360,200,10,10);
    public ImageIcon imageMom = new ImageIcon("res/mom.png");

    public Mom(){}


    public void changeYForWait()
    {
        y=400;
    }

}
