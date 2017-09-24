package view.locations;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10.09.2017.
 */
public class CafeHallLocation extends Location {
Controller controller;
    public CafeHallLocation(Controller controller) {
       this.controller=controller;
        player = controller.player;

        moveZone = new Rectangle(230, 205, 440, 490);
        doorLeft = new Rectangle(200, 425, 3, 50);
    }


    public void paint(Graphics g) {

        g.drawImage(new ImageIcon("res/bar.png").getImage(), 100, 100, 700, 700, null);
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
