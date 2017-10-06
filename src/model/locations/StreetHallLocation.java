package model.locations;

import controller.Controller;
import javax.swing.*;
import java.awt.*;


/**
 * Created by user on 10.09.2017.
 */
public class StreetHallLocation extends Location {
    Controller controller;
    public Rectangle doorDownOne;
  Rectangle stairs =new Rectangle(400,50,60,150);
    public StreetHallLocation(Controller controller) {
       this.controller = controller;
        player = controller.player;

        moveZone = new Rectangle(180, 280, 540, 465);
        doorDownOne = new Rectangle(445, 747, 10, 50);

        x=50;
        y=50;
        width=800;
        height=800;
        mapTexture = new ImageIcon("res/street.png");
    }


    public void update() {

        controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne)) {
            controller.changeLocation(doorDownOne);
            player.x = 445;
            player.y = 160;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }
        if (player.playerRect.intersects(stairs)) player.setOldXY();
    }
}
