import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class HallLocation extends JPanel
{   Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorUp;
    List<Rectangle> hallTexturs= new ArrayList<>();

    HallLocation(Player player, MainFrame mainFrame)
    {
        doorUp = new Rectangle(445,30,10,33);
        moveZone = new Rectangle(330,140,240,510);
        this.player=player;
        this.mainFrame=mainFrame;
    }
    public void paint(Graphics g)
    {


        g.drawImage(new ImageIcon("res/mom.png").getImage(),350,150,30,60,null);
        g.drawImage(new ImageIcon("res/kid.png").getImage(),380,180,15,30,null);

        g.drawRect(300,130,300,600);
        g.drawRect(425,30,50,100);

         player.drawPlayer(g);
        player.playerRect = new Rectangle(player.x,player.y,player.width,player.height);
        if(!player.playerRect.intersects(moveZone)) {player.x=player.xOld;player.y=player.yOld;}

        if (player.playerRect.intersects(doorUp)) {player.currLocale=1;player.x=320;player.y=515;}
        player.update();
        mainFrame.frame.repaint();
    }
}