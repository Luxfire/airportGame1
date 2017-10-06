package model.locations;

import controller.Controller;
import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10.09.2017.
 */
public class RegHallLocation extends Location {
Controller controller;
    public Rectangle doorDownOne;
    public Rectangle doorDownTwo;
    public Rectangle doorUpOne;
    public Rectangle doorUpTwo;
   public RegHallLocation(Controller controller) {
       this.controller = controller;
       player = controller.player;

        moveZone = new Rectangle(180, 305, 540, 290);

        doorDownOne = new Rectangle(320, 597, 10, 50);
        doorDownTwo = new Rectangle(570, 597, 10, 50);

        doorUpOne = new Rectangle(320, 300, 10, 3);
        doorUpTwo = new Rectangle(570, 300, 10, 3);

       x=50;
       y=200;
       width=800;
       height=500;
       mapTexture = new ImageIcon("res/receptionHall.png");
    }


    public void update() {

        controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne)) {
            controller.changeLocation(doorDownOne);
            player.x = 425;
            player.y = 65;
        }
        if (player.playerRect.intersects(doorDownTwo)) {
            controller.changeLocation(doorDownTwo);;
            player.x = 425;
            player.y = 310;
        }

        if (player.playerRect.intersects(doorUpOne)) {
            controller.changeLocation(doorUpOne);
            player.x = 320;
            player.y = 615;
        }
        if (player.playerRect.intersects(doorUpTwo)) {
            controller.changeLocation(doorUpTwo);
            player.x = 570;
            player.y = 615;
        }

        if (!player.playerRect.intersects(moveZone)) {
           player.setOldXY();
        }

    }
}