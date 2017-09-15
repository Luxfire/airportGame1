/**
 * Created by user on 10.09.2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PersonalsHallLocation extends JPanel {
    Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorUp;
    ControlLocation controlLocation;
    java.util.List<Rectangle> hallTexturs = new ArrayList<>();

    PersonalsHallLocation(Player player, MainFrame mainFrame, ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        this.player = player;
        this.mainFrame = mainFrame;
        moveZone = new Rectangle(330, 385, 240, 60);
        doorUp = new Rectangle(445, 275, 10, 33);
    }


    public void paint(Graphics g) {
        g.drawRect(300, 375, 300, 150);
        g.drawRect(425, 275, 50, 100);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y, player.width, player.height);

        if (player.playerRect.intersects(doorUp)) {
            player.currLocale = 1;
            player.x = 570;
            player.y = 515;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

        player.update();
        mainFrame.frame.repaint();
        controlLocation.checkLocation();
    }
}