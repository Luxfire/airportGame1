
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 10.09.2017.
 */
public class StreetHallLocation extends JPanel {
    Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorDown;
    ControlLocation controlLocation;
    java.util.List<Rectangle> hallTexturs = new ArrayList<>();

    StreetHallLocation(Player player, MainFrame mainFrame, ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        this.player = player;
        this.mainFrame = mainFrame;
        moveZone = new Rectangle(180, 155, 540, 590);
        doorDown = new Rectangle(445, 747, 10, 50);
    }


    public void paint(Graphics g) {
        g.drawRect(150, 150, 600, 600);
        g.drawRect(425, 750, 50, 100);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorDown)) {
            player.currLocale = 3;
            player.x = 445;
            player.y = 160;
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
