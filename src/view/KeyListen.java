package view;

import controller.Controller;
import model.Player;

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

        if (e.getKeyCode() == KeyEvent.VK_E) {

            controller.player.isActive = true;
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

                if (player.dialogWithMomCounter < player.dialogWithMom.size() - 1&&controller.player.dialogWithMomInHoll) player.dialogWithMomCounter++;
        }


        if (e.getKeyCode() == KeyEvent.VK_E) {
            controller.player.isActive = false;
        }


        if (e.getKeyCode() == KeyEvent.VK_R) {
            if (!controller.taskManager.isStart) {
                controller.startTask();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            controller.location = controller.gameMap.waitingHallLocation;
            player.x = 400;
            player.y = 400;
        }

    }
}
