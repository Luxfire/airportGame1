package model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by user on 02.09.2017.
 */
public class Player {

    public int x = 327;
    public int y = 601;
    public int width = 30;
    public int height = 80;
    public int xOld;
    public int yOld;
    public int moveSpeed = 0;
    public int animationSpeed = 0;
    public int currLocale = 0;
    public boolean moved = false;
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    public List<String> spriteDown = new ArrayList<String>();
    public List<String> spriteUp = new ArrayList<String>();
    public List<String> spriteLeft = new ArrayList<String>();
    public List<String> spriteRight = new ArrayList<String>();
    public int spriteCounter = 0;
    public Rectangle playerRect;

    public Player() {

        spriteDown.add("res/down1.png");
        spriteDown.add("res/down2.png");
        spriteDown.add("res/down3.png");
        spriteDown.add("res/down4.png");

        spriteUp.add("res/up1.png");
        spriteUp.add("res/up2.png");
        spriteUp.add("res/up3.png");
        spriteUp.add("res/up4.png");

        spriteLeft.add("res/left1.png");
        spriteLeft.add("res/left2.png");
        spriteLeft.add("res/left3.png");
        spriteLeft.add("res/left4.png");

        spriteRight.add("res/right1.png");
        spriteRight.add("res/right2.png");
        spriteRight.add("res/right3.png");
        spriteRight.add("res/right4.png");

        xOld = x;
        yOld = y;

    }

    ;

    public void update() {
        playerRect = new Rectangle(x, y+75, width, height-75);
        xOld = x;
        yOld = y;


        if (moved) {
            if (moveSpeed == 1) {
                if (down) {
                    y++;
                    moveSpeed = 0;
                }
                if (right) {
                    x++;
                    moveSpeed = 0;
                }
                if (left) {
                    x--;
                    moveSpeed = 0;
                }
                if (up) {
                    y--;
                    moveSpeed = 0;
                }
            }
            if (animationSpeed == 30) {
                spriteCounter++;
                animationSpeed = 0;
            }
            if (spriteCounter > 3) spriteCounter = 0;
            moveSpeed++;
            animationSpeed++;
        }
    }

    public void drawPlayer(Graphics g) {
        if (down && !left && !right)
            g.drawImage(new ImageIcon(spriteDown.get(spriteCounter)).getImage(), x, y, width, height, null);
        if (up && !left && !right)
            g.drawImage(new ImageIcon(spriteUp.get(spriteCounter)).getImage(), x, y, width, height, null);
        if (right)
            g.drawImage(new ImageIcon(spriteRight.get(spriteCounter)).getImage(), x, y, 20, height, null);
        if (left)
            g.drawImage(new ImageIcon(spriteLeft.get(spriteCounter)).getImage(), x, y, 20, height, null);
        if (!up && !down && !left && !right)
            g.drawImage(new ImageIcon(spriteDown.get(0)).getImage(), x, y, width, height, null);

    }
}




