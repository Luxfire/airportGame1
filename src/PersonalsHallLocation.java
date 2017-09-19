/**
 * Created by user on 10.09.2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PersonalsHallLocation extends Location {

    PersonalsHallLocation(Controller controller) {

       player = controller.player;

        moveZone = new Rectangle(330, 380, 240, 140);
        doorUpOne = new Rectangle(445, 375, 10, 3);
    }


    public void paint(Graphics g) {
        g.drawRect(300, 375, 300, 150);
        g.drawRect(425, 275, 50, 100);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorUpOne)) {
            player.currLocale = 1;
            player.x = 570;
            player.y = 515;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }
    }
}