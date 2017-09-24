package model.locations;

import controller.Controller;
import model.Door;

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
        doorLeft = new Door(200, 425, 3, 50);

        x=100;
        y=100;
        width=700;
        height=700;
        mapTexture = new ImageIcon("res/bar.png");
    }


    public void update() {


        controller.player.getZones();

        if (player.playerRect.intersects(doorLeft.door)) {
            controller.location=controller.gameMap.map.get(doorLeft);;
            player.x = 630;
            player.y = 405;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}
