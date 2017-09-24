package model.locations;

import controller.Controller;
import controller.Door;

import javax.swing.*;
import java.awt.*;


public class HallLocation extends Location {
  Controller controller;


    public HallLocation(Controller controller) {

        this.controller=controller;
        doorUpOne = new Door(445, 130, 10, 3);
        moveZone = new Rectangle(330, 135, 240, 590);
        player = controller.player;

        x=200;
        y=30;
        width=500;
        height=800;
        mapTexture = new ImageIcon("res/hall.png");
    }

    public void update() {

        player.getZones();

        if (!controller.activeWithMom())
        {
            controller.dialogWithMomInHoll=false;
            controller.player.dialogWithMomCounter=0;
        }


        if (Math.sqrt(Math.pow((446 - player.playerRect.getX() + 5), 2) + Math.pow((437 - player.playerRect.getY() + 2), 2)) < 60) {
            player.setOldXY();
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }
        if (player.playerRect.intersects(controller.mom.rectMom)&&controller.momInHoll) {
            player.setOldXY();
        }

        if (player.playerRect.intersects(doorUpOne.door)) {
            controller.location=controller.gameMap.map.get(doorUpOne);
            player.x = 320;
            player.y = 515;
            if(controller.kidInHoll) controller.stageKidIsLost();
        }

    }
}