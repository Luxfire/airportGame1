import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class HallLocation extends JPanel {
    Player player;
    MainFrame mainFrame;
    Rectangle moveZone;
    Rectangle doorUp;
    ControlLocation controlLocation;
    Mom mom;
    Kid kid;
    List<Rectangle> hallTexturs = new ArrayList<>();

    HallLocation(Kid kid,Mom mom,Player player, MainFrame mainFrame, ControlLocation controlLocation) {
        this.kid=kid;
        this.mom=mom;
        this.controlLocation = controlLocation;
        doorUp = new Rectangle(445, 130, 10, 3);
        moveZone = new Rectangle(330, 135, 240, 590);
        this.player = player;
        this.mainFrame = mainFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(new ImageIcon("res/hall.png").getImage(), 200, 30, 500, 800, null);
      if(player.y<130) {
          player.drawPlayer(g);
          mom.drawMom(g);
          kid.drawKid(g);
      }
      else {
          mom.drawMom(g);
          kid.drawKid(g);
          player.drawPlayer(g);
      }
        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);

        if(Math.sqrt(Math.pow((446-player.playerRect.getX()+5),2)+Math.pow((437-player.playerRect.getY()+2),2))<60)
        {
            player.x = player.xOld;
            player.y = player.yOld;
        }

        if (!player.playerRect.intersects(moveZone)) {
            player.x = player.xOld;
            player.y = player.yOld;
        }

        if (player.playerRect.intersects(doorUp)) {
            player.currLocale = 1;
            player.x = 320;
            player.y = 515;
        }
        if (player.playerRect.intersects(mom.rectMom)) {
            player.x = player.xOld;
            player.y = player.yOld;}
        player.update();
        mainFrame.frame.repaint();
        controlLocation.checkLocation();

    }
}