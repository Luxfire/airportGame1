package model.locations;

import controller.Controller;
import model.Door;

import javax.swing.*;
import java.awt.*;

public class WaitingHallLocation extends Location {
Controller controller;
   public WaitingHallLocation(Controller controller) {
        this.controller=controller;
        this.player = controller.player;

        moveZone = new Rectangle(180, 205, 540, 490);

        doorDownOne = new Door(320, 697, 10, 50);
        doorDownTwo = new Door(570, 697, 10, 50);
          doorRight = new Door(745, 425, 10, 50);
          doorUpOne = new Door(445, 200, 10, 3);

       x=50;
       y=100;
       width=800;
       height=700;
       mapTexture = new ImageIcon("res/waitingHall.png");
    }


    public void update() {


       controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne.door)) {
            controller.location=controller.gameMap.map.get(doorDownOne);
            player.x = 320;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorDownTwo.door)) {
            controller.location=controller.gameMap.map.get(doorDownTwo);
            player.x = 570;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorRight.door)) {
            controller.location=controller.gameMap.map.get(doorRight);
            player.x = 205;
            player.y = 400;
        }
        if (player.playerRect.intersects(doorUpOne.door)) {
            controller.location=controller.gameMap.map.get(doorUpOne);
            player.x = 425;
            player.y = 645;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}
