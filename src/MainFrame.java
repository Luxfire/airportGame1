import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainFrame {
    JFrame frame;

    public MainFrame(Controller controller) {

        frame = new JFrame("Аэропорт");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addKeyListener(new KeyListen(controller.player));
        frame.add(new DrawLocation(controller,this));
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class DrawLocation extends JPanel
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