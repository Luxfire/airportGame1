package view;

import model.Player;
import controller.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 06.09.2017.
 */
public class KeyListen extends KeyAdapter {

    public Player player;
    public Controller controller;

    KeyListen(Controller controller) {
        this.controller = controller;
        player = controller.player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            player.left = true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            player.right = true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

            player.up = true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = true;
            player.moved = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_0) {
            System.out.print(player.x);
            System.out.print(player.y);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
            player.moved = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
            player.moved = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up = false;
            player.moved = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down = false;
            player.moved = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (controller.dialogWithMomInHoll)
            {
                if (player.dialogWithMomCounter <= player.dialogWithMom.size() - 1) player.dialogWithMomCounter++;
                if (player.dialogWithMomCounter == player.dialogWithMom.size() - 1) {
                    controller.dialogWithMomInHoll = false;
                    controller.momInHoll = false;
                    controller.momInWaitingHall = true;
                    controller.mom.changeYForWait();
                }
            }
        }


        if (e.getKeyCode() == KeyEvent.VK_E)
        {
            if (controller.activeWithMom()&&controller.momInHoll&&controller.kidInPersonalHall) controller.dialogWithMomInHoll=true;

            if(controller.kidInPersonalHall&&controller.activeWithKid()&&controller.location==controller.gameMap.personalsHallLocation&&controller.momInWaitingHall)
            {
                controller.kidInWaitingHall=true;
                controller.kidInPersonalHall=false;
            }
        }


        if(e.getKeyCode()==KeyEvent.VK_R)
        {
            if(controller.kidInHoll) controller.stageKidIsLost();
          /*  player.x=450;
            player.y=450;
            controller.location=controller.gameMap.waitingHallLocation;*/
        }
    }
}
