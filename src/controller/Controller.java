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

    public boolean dialogWithMomInHoll = false;

    public boolean momInHoll=true;
    public boolean momInWaitingHall=false;

    public boolean kidInHoll=true;
    public boolean kidInPersonalHall=false;
    public boolean kidInWaitingHall=false;



    public Controller()
    {
        player = new Player();
        mom = new Mom();
        kid = new Kid();

    }

    public void stageKidIsLost()
    {
        kidInHoll=false;
        kidInPersonalHall=true;
        kid.x=450;
        kid.y=450;
    }

    public boolean activeWithMom()
    {
        return player.activeZone.intersects(mom.rectMom);
    }
}
