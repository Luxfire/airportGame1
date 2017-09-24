package model.locations; /**
 * Created by user on 10.09.2017.
 */

import controller.Controller;
import controller.Door;

import javax.swing.*;
import java.awt.*;

public class PersonalsHallLocation extends Location {
  Controller controller;
   public PersonalsHallLocation(Controller controller) {
        this.controller=controller;
       player = controller.player;

        moveZone = new Rectangle(330, 380, 240, 140);
        doorUpOne = new Door(445, 375, 10, 3);

       x=200;
       y=275;
       width=500;
       height=350;
       mapTexture = new ImageIcon("res/personalRoom.png");
    }


    public void update() {

        controller.player.getZones();

        if (player.playerRect.intersects(doorUpOne.door)) {
            controller.location=controller.gameMap.map.get(doorUpOne);
            player.x = 570;
            player.y = 515;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }
    }
}