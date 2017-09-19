package view.locations;

import controller.Controller;

import java.awt.*;

/**
 * Created by user on 10.09.2017.
 */
public class CafeHallLocation extends Location {

    public CafeHallLocation(Controller controller) {

        player = controller.player;

        moveZone = new Rectangle(230, 205, 440, 490);
        doorLeft = new Rectangle(200, 445, 3, 10);
    }


    public void paint(Graphics g) {
        g.drawRect(200, 200, 500, 500);
        g.drawRect(100, 425, 100, 50);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorLeft)) {
            player.currLocale = 3;
            player.x = 630;
            player.y = 405;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}
