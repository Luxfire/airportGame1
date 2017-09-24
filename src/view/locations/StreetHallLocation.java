package view.locations;

import controller.Controller;

import javax.swing.*;
import java.awt.*;


/**
 * Created by user on 10.09.2017.
 */
public class StreetHallLocation extends Location {
  Rectangle stairs =new Rectangle(400,50,60,150);
    public StreetHallLocation(Controller controller) {

        player = controller.player;

        moveZone = new Rectangle(180, 280, 540, 465);
        doorDownOne = new Rectangle(445, 747, 10, 50);
    }


    public void paint(Graphics g) {

        g.drawImage(new ImageIcon("res/street.png").getImage(), 50, 50, 800, 800, null);


        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if (player.playerRect.intersects(doorDownOne)) {
            player.currLocale = 3;
            player.x = 445;
            player.y = 160;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }
        if (player.playerRect.intersects(stairs)) player.setOldXY();
    }
}
