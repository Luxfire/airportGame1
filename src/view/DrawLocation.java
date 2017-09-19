package view;

import controller.Controller;
import view.locations.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 19.09.2017.
 */
public class DrawLocation extends JPanel
{   Controller controller;
    MainFrame mainFrame;
    List<Location> locationList;
    public DrawLocation(Controller controller,MainFrame mainFrame)
    {
        this.controller=controller;
        this.mainFrame = mainFrame;
        locationList = new ArrayList<>();
        locationList.add(new HallLocation(controller));
        locationList.add(new RegHallLocation(controller));
        locationList.add(new PersonalsHallLocation(controller));
        locationList.add(new WaitingHallLocation(controller));
        locationList.add(new CafeHallLocation(controller));
        locationList.add(new StreetHallLocation(controller));
    }

    public void paint(Graphics g)
    {
        locationList.get(controller.player.currLocale).paint(g);
        controller.player.update();
        mainFrame.frame.repaint();
    }

}