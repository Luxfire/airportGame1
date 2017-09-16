import javax.swing.*;
import java.awt.*;
import java.util.*;

public class WaitingHallLocation extends JPanel {
    Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorDownOne;
    Rectangle doorDownTwo;
    Rectangle doorRight;
    Rectangle doorUp;
    ControlLocation controlLocation;
    java.util.List<Rectangle> hallTexturs = new ArrayList<>();

    WaitingHallLocation(Player player, MainFrame mainFrame, ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        this.player = player;
        this.mainFrame = mainFrame;
        moveZone = new Rectangle(180, 205, 540, 490);

        doorDownOne = new Rectangle(320, 697, 10, 50);
        doorDownTwo = new Rectangle(570, 697, 10, 50);
        doorRight = new Rectangle(745, 445, 10, 10);
        doorUp = new Rectangle(445, 200, 10, 3);
    }


    public void paint(Graphics g) {
        g.drawRect(150, 200, 600, 500);

        g.drawRect(300, 700, 50, 100);
        g.drawRect(550, 700, 50, 100);

        g.drawRect(750, 425, 100, 50);
        g.drawRect(425, 100, 50, 100);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorDownOne)) {
            player.currLocale = 1;
            player.x = 320;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorDownTwo)) {
            player.currLocale = 1;
            player.x = 570;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorRight)) {
            player.currLocale = 4;
            player.x = 205;
            player.y = 400;
        }
        if (player.playerRect.intersects(doorUp)) {
            player.currLocale = 5;
            player.x = 425;
            player.y = 645;
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
