package view.locations;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class WaitingHallLocation extends Location {
Controller controller;
   public WaitingHallLocation(Controller controller) {
        this.controller=controller;
        this.player = controller.player;

        moveZone = new Rectangle(180, 205, 540, 490);

        doorDownOne = new Rectangle(320, 697, 10, 50);
        doorDownTwo = new Rectangle(570, 697, 10, 50);
        doorRight = new Rectangle(745, 425, 10, 50);
        doorUpOne = new Rectangle(445, 200, 10, 3);
    }


    public void paint(Graphics g) {
        g.drawImage(new ImageIcon("res/waitingHall.png").getImage(), 50, 100, 800, 700, null);

        player.drawPlayer(g);
        if (controller.momInWaitingHall) controller.mom.drawMom(g);
        if(controller.kidInWaitingHall) controller.kid.drawKid(g);
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
        if (player.playerRect.intersects(doorUpOne)) {
            player.currLocale = 5;
            player.x = 425;
            player.y = 645;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}
