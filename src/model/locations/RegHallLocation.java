package model.locations;

import controller.Controller;
import model.Door;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10.09.2017.
 */
public class RegHallLocation extends Location {
Controller controller;
   public RegHallLocation(Controller controller) {
       this.controller = controller;
       player = controller.player;

        moveZone = new Rectangle(180, 305, 540, 290);

        doorDownOne = new Door(320, 597, 10, 50);
        doorDownTwo = new Door(570, 597, 10, 50);

        doorUpOne = new Door(320, 300, 10, 3);
        doorUpTwo = new Door(570, 300, 10, 3);

       x=50;
       y=200;
       width=800;
       height=500;
       mapTexture = new ImageIcon("res/receptionHall.png");
    }


    public void update() {

        controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne.door)) {
            controller.location=controller.gameMap.map.get(doorDownOne);
            player.x = 425;
            player.y = 65;
        }
        if (player.playerRect.intersects(doorDownTwo.door)) {
            controller.location=controller.gameMap.map.get(doorDownTwo);
            player.x = 425;
            player.y = 310;
        }

        if (player.playerRect.intersects(doorUpOne.door)) {
            controller.location=controller.gameMap.map.get(doorUpOne);
            player.x = 320;
            player.y = 615;
        }
        if (player.playerRect.intersects(doorUpTwo.door)) {
            controller.location=controller.gameMap.map.get(doorUpTwo);
            player.x = 570;
            player.y = 615;
        }

        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}