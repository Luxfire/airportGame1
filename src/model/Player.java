package model;
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

    public boolean isActive = false;
    public boolean moved = false;

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    public List<String> spriteDown = new ArrayList();
    public List<String> spriteUp = new ArrayList();
    public List<String> spriteLeft = new ArrayList();
    public List<String> spriteRight = new ArrayList();
    public int spriteCounter = 0;

    public List<String> dialogWithMom = new ArrayList();
    public int dialogWithMomCounter=0;
    public boolean dialogWithMomInHoll = false;

    public Rectangle playerRect;
    public Rectangle activeZone;

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

        dialogWithMom.add("res/right1.png");
        dialogWithMom.add("res/right2.png");
        dialogWithMom.add("res/right3.png");
        dialogWithMom.add("res/right4.png");

        xOld = x;
        yOld = y;

    }

    public void update() {
        xOld = x;
        yOld = y;

        getZones();
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


    public void setOldXY()
    {
        x=xOld;
        y=yOld;
    }

    public void getZones()
    {
        playerRect = new Rectangle(x, y+75, width, height-75);
        activeZone = new Rectangle(x-30,y+50,90,60);
    }
}





