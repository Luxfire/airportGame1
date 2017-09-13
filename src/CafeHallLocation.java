
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 10.09.2017.
 */
public class CafeHallLocation extends JPanel {
    Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorLeft;
    java.util.List<Rectangle> hallTexturs= new ArrayList<>();

    CafeHallLocation(Player player,MainFrame mainFrame)
    {
        this.player=player;
        this.mainFrame=mainFrame;
        moveZone = new Rectangle(230,210,440,410);
        doorLeft = new Rectangle(200,445,3,10);
    }


    public void paint(Graphics g)
    {
        g.drawRect(200,200,500,500);
        g.drawRect(100,425,100,50);

        player.drawPlayer(g);

        player.playerRect = new Rectangle(player.x,player.y,player.width,player.height);

        if (player.playerRect.intersects(doorLeft)) {player.currLocale=3;player.x=630;player.y=405;}
        if(!player.playerRect.intersects(moveZone)) {player.x=player.xOld;player.y=player.yOld;}

        player.update();
        mainFrame.frame.repaint();
    }
}
