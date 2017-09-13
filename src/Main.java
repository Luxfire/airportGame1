import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        KeyListen keyListen = new KeyListen(player);
        MainFrame mainFrame = new MainFrame(keyListen);
        ControlLocation controlLocation = new ControlLocation(player,mainFrame);
    }
}


class ControlLocation
{   Player player;
    MainFrame mainFrame;

    List<JPanel> locationList = new ArrayList<>();

    public ControlLocation(Player player, MainFrame mainFrame) {
        this.player = player;
        this.mainFrame = mainFrame;
        HallLocation hallLocation = new HallLocation(player,mainFrame);
        locationList.add(hallLocation);
        locationList.add(new RegHallLocation(player, mainFrame));
        locationList.add(new PersonalsHallLocation(player, mainFrame));
        locationList.add(new WaitingHallLocation(player, mainFrame));
        locationList.add(new CafeHallLocation(player,mainFrame));
        locationList.add(new StreetHallLocation(player,mainFrame));


        mainFrame.frame.add(hallLocation);

        ControlingLocation controlingLocation = new ControlingLocation(player,mainFrame,locationList);
        controlingLocation.start();
    }
}






class ControlingLocation extends Thread
{  Player player;
   MainFrame mainFrame;
   List<JPanel> locationList;

    public ControlingLocation(Player player, MainFrame mainFrame,List<JPanel> locationList) {
        this.player = player;
        this.mainFrame = mainFrame;
        this.locationList=locationList;
    }

@Override
    public void run()
    {

       while (mainFrame.frame.isActive())
        {
         if(player.currLocale!=player.oldLocale)
         {
         mainFrame.frame.remove(locationList.get(player.oldLocale));
         mainFrame.frame.add(locationList.get(player.currLocale));
         player.oldLocale = player.currLocale;
         mainFrame.frame.revalidate();
         mainFrame.frame.repaint();
         }
        }
    }
}
