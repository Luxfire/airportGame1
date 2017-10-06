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
    public Rectangle rectKid;
    public boolean kidInHoll = true;
    public boolean kidInPersonalHall = false;
    public boolean kidInWaitingHall = false;

    public Kid() {
    }

    public void coordinateInPesronal()
    {
        x = 450;
        y = 450;
    }

}