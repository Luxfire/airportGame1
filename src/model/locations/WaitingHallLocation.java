package model.locations;

import controller.Controller;
import model.Door;

import javax.swing.*;
import java.awt.*;

public class WaitingHallLocation extends Location {
    Controller controller;
    public Rectangle doorDownOne;
    public Rectangle doorDownTwo;
    public Rectangle doorRight;
    public Rectangle doorUpOne;

    public WaitingHallLocation(Controller controller) {
        this.controller = controller;
        this.player = controller.player;

        moveZone = new Rectangle(180, 205, 540, 490);

        doorDownOne = new Rectangle(320, 697, 10, 50);
        doorDownTwo = new Rectangle(570, 697, 10, 50);
        doorRight = new Rectangle(745, 425, 10, 50);
        doorUpOne = new Rectangle(445, 200, 10, 3);

        x = 50;
        y = 100;
        width = 800;
        height = 700;
        mapTexture = new ImageIcon("res/waitingHall.png");
    }


    public void update() {


        controller.player.getZones();

        if (player.playerRect.intersects(doorDownOne)) {
            controller.changeLocation(doorDownOne);
            player.x = 320;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorDownTwo)) {
            controller.changeLocation(doorDownTwo);
            player.x = 570;
            player.y = 260;
        }
        if (player.playerRect.intersects(doorRight)) {
            controller.changeLocation(doorRight);
            player.x = 205;
            player.y = 400;
        }
        if (player.playerRect.intersects(doorUpOne)) {
            controller.changeLocation(doorUpOne);
            player.x = 425;
            player.y = 645;
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

    }
}
