package view.locations;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10.09.2017.
 */
public class RegHallLocation extends Location {

   public RegHallLocation(Controller controller) {
       player = controller.player;

        moveZone = new Rectangle(180, 305, 540, 290);

        doorDownOne = new Rectangle(320, 597, 10, 50);
        doorDownTwo = new Rectangle(570, 597, 10, 50);

        doorUpOne = new Rectangle(320, 300, 10, 3);
        doorUpTwo = new Rectangle(570, 300, 10, 3);
    }


    public void paint(Graphics g) {
        g.drawImage(new ImageIcon("res/receptionHall.png").getImage(), 50, 200, 800, 500, null);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorDownOne)) {
            player.currLocale = 0;
            player.x = 425;
            player.y = 65;
        }
        if (player.playerRect.intersects(doorDownTwo)) {
            player.currLocale = 2;
            player.x = 425;
            player.y = 310;
        }

        if (player.playerRect.intersects(doorUpOne)) {
            player.currLocale = 3;
            player.x = 320;
            player.y = 615;
        }
        if (player.playerRect.intersects(doorUpTwo)) {
            player.currLocale = 3;
            player.x = 570;
            player.y = 615;
        }

        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}