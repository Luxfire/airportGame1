package controller;

import model.Kid;
import model.Mom;
import model.Player;

/**
 * Created by user on 19.09.2017.
 */
public class Controller {
    public Player player;
    public Mom mom;
    public Kid kid;
    public Controller()
    {
        player = new Player();
        mom = new Mom();
        kid = new Kid();

    }
}
