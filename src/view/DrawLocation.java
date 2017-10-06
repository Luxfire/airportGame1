package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;


/**
 * Created by user on 19.09.2017.
 */
public class DrawLocation extends JPanel
{   Controller controller;
    MainFrame mainFrame;

    public DrawLocation(Controller controller,MainFrame mainFrame)
    {
        this.controller=controller;
        this.mainFrame = mainFrame;

    }

    public void paint(Graphics g)
    {
        if(controller.location==controller.gameMap.hallLocation)drawHall(g);
        if(controller.location==controller.gameMap.regHallLocation)drawRegHall(g);
        if(controller.location==controller.gameMap.personalsHallLocation)drawPersonalHall(g);
        if(controller.location==controller.gameMap.cafeHallLocation)drawCafeHall(g);
        if(controller.location==controller.gameMap.waitingHallLocation)drawWaitHall(g);
        if(controller.location==controller.gameMap.streetHallLocation)drawStreet(g);
        drawPlayer(g);
        controller.location.update();
        controller.player.update();
        controller.taskManager.update();
        mainFrame.frame.repaint();
    }


    public void drawHall(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);
        if (controller.kid.kidInHoll) drawKid(g);
        if (controller.mom.momInHoll)drawMom(g);
        if (controller.player.dialogWithMomInHoll) drawDialogWithMom(g);
    }

    public void drawRegHall(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);
    }

    public void drawPersonalHall(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);
        if(controller.kid.kidInPersonalHall) drawKid(g);
    }

    public void drawWaitHall(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);
        if (controller.mom.momInWaitingHall) drawMom(g);
        if(controller.kid.kidInWaitingHall) drawKid(g);

    }
    public void drawCafeHall(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);

    }
    public void drawStreet(Graphics g)
    {
        g.drawImage(controller.location.mapTexture.getImage(),controller.location.x,controller.location.y,controller.location.width,controller.location.height,null);

    }

    public void drawPlayer(Graphics g) {
        if (controller.player.down && !controller.player.left && !controller.player.right)
            g.drawImage(new ImageIcon(controller.player.spriteDown.get(controller.player.spriteCounter)).getImage(), controller.player.x, controller.player.y, controller.player.width, controller.player.height, null);
        if (controller.player.up && !controller.player.left && !controller.player.right)
            g.drawImage(new ImageIcon(controller.player.spriteUp.get(controller.player.spriteCounter)).getImage(), controller.player.x, controller.player.y, controller.player.width, controller.player.height, null);
        if (controller.player.right)
            g.drawImage(new ImageIcon(controller.player.spriteRight.get(controller.player.spriteCounter)).getImage(), controller.player.x, controller.player.y, 20, controller.player.height, null);
        if (controller.player.left)
            g.drawImage(new ImageIcon(controller.player.spriteLeft.get(controller.player.spriteCounter)).getImage(), controller.player.x, controller.player.y, 20, controller.player.height, null);
        if (!controller.player.up && !controller.player.down && !controller.player.left && !controller.player.right)
            g.drawImage(new ImageIcon(controller.player.spriteDown.get(0)).getImage(), controller.player.x, controller.player.y, controller.player.width, controller.player.height, null);

    }

    public void drawMom(Graphics g)
    {
        g.drawImage(controller.mom.imageMom.getImage(), controller.mom.x, controller.mom.y, controller.mom.width, controller.mom.height, null);
    }
    public void drawKid(Graphics g) {
        controller.kid.rectKid = new Rectangle(controller.kid.x,controller.kid.y,controller.kid.width,controller.kid.height);
        g.drawImage(controller.kid.imageMom.getImage(), controller.kid.x, controller.kid.y, controller.kid.width, controller.kid.height, null);
    }

    public void drawDialogWithMom(Graphics g)
    {
        g.drawImage(new ImageIcon(controller.player.dialogWithMom.get(controller.player.dialogWithMomCounter)).getImage(), 0, 800, 800,100 , null);
    }
}