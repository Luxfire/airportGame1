import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by user on 06.09.2017.
 */
public class KeyListen extends KeyAdapter {
    Player player;

    KeyListen(Player player)
    {
        this.player = player;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            player.left =true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            player.right =true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

            player.up =true;
            player.moved = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down =true;
            player.moved = true;
        }

        if (e.getKeyCode()==KeyEvent.VK_0) {player.currLocale=3;player.x=400;player.y=400;}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left =false;
            player.moved=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right =false;
            player.moved=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.up =false;
            player.moved=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down =false;
            player.moved=false;
        }
    }
}