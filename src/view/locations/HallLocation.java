package view.locations;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class HallLocation extends Location {
  Controller controller;


    public HallLocation(Controller controller) {
        this.controller=controller;
        doorUpOne = new Rectangle(445, 130, 10, 3);
        moveZone = new Rectangle(330, 135, 240, 590);
        player = controller.player;
    }

    public void paint(Graphics g) {

        g.drawImage(new ImageIcon("res/hall.png").getImage(), 200, 30, 500, 800, null);


        if (controller.kidInHoll) controller.kid.drawKid(g);
        if(controller.mom.y+controller.mom.height<player.y+player.height) {
            if (controller.momInHoll) controller.mom.drawMom(g);
            player.drawPlayer(g);
        }else
        {
            player.drawPlayer(g);
            if (controller.momInHoll) controller.mom.drawMom(g);
        }

        if (controller.dialogWithMomInHoll&&controller.activeWithMom())
        {
            controller.player.drawDialogWithMom(g);
        }else
        {
            controller.dialogWithMomInHoll=false;
            controller.player.dialogWithMomCounter=0;
        }

        player.getZones();

        if (Math.sqrt(Math.pow((446 - player.playerRect.getX() + 5), 2) + Math.pow((437 - player.playerRect.getY() + 2), 2)) < 60) {
            player.setOldXY();
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }
        if (player.playerRect.intersects(controller.mom.rectMom)&&controller.momInHoll) {
            player.setOldXY();
        }

        if (player.playerRect.intersects(doorUpOne)) {
            player.currLocale = 1;
            player.x = 320;
            player.y = 515;
            if(controller.kidInHoll) controller.stageKidIsLost();
        }

    }
}