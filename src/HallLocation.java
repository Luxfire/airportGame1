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
        doorUp = new Rectangle(445, 30, 10, 33);
        moveZone = new Rectangle(300+30, 130+5, 240, 590);
        this.player = player;
        this.mainFrame = mainFrame;
    }

    public void paint(Graphics g) {

        g.drawRect(300, 130, 300, 600);
        g.drawRect(425, 30, 50, 100);
        mom.drawMom(g);
        kid.drawKid(g);
        player.drawPlayer(g);



        player.playerRect = new Rectangle(player.x, player.y+75, player.width, player.height-75);
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