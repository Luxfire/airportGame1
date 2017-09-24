package model.locations;

import controller.Controller;
import controller.Door;

import javax.swing.*;
import java.awt.*;


/**
 * Created by user on 10.09.2017.
 */
public class StreetHallLocation extends Location {
    Controller controller;
  Rectangle stairs =new Rectangle(400,50,60,150);
    public StreetHallLocation(Controller controller) {
       this.controller = controller;
        player = controller.player;

        moveZone = new Rectangle(180, 280, 540, 465);
        doorDownOne = new Door(445, 747, 10, 50);

        x=50;
        y=50;
        width=800;
        height=800;
        mapTexture = new ImageIcon("res/street.png");
    }


    public void update() {

        controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne.door)) {
            controller.location=controller.gameMap.map.get(doorDownOne);
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
