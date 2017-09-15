import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        KeyListen keyListen = new KeyListen(player);
        MainFrame mainFrame = new MainFrame(keyListen);
        ControlLocation controlLocation = new ControlLocation(player, mainFrame);
    }
}


class ControlLocation {
    Player player;
    MainFrame mainFrame;
    List<JPanel> locationList = new ArrayList<>();

    public ControlLocation(Player player, MainFrame mainFrame) {
        this.player = player;
        this.mainFrame = mainFrame;
        Mom mom = new Mom();
        Kid kid = new Kid();
        locationList.add(new HallLocation(kid,mom,player, mainFrame, this));
        locationList.add(new RegHallLocation(player, mainFrame, this));
        locationList.add(new PersonalsHallLocation(player, mainFrame, this));
        locationList.add(new WaitingHallLocation(player, mainFrame, this));
        locationList.add(new CafeHallLocation(player, mainFrame, this));
        locationList.add(new StreetHallLocation(player, mainFrame, this));

        mainFrame.frame.add(locationList.get(player.currLocale));
        mainFrame.frame.revalidate();

    }

    public void checkLocation() {
        if (player.currLocale != player.oldLocale) {
            mainFrame.frame.remove(locationList.get(player.oldLocale));
            mainFrame.frame.add(locationList.get(player.currLocale));
            player.oldLocale = player.currLocale;
            mainFrame.frame.revalidate();

        }
    }
}
