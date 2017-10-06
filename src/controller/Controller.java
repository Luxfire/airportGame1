package controller;

import model.*;
import model.locations.Location;

import java.awt.*;

/**
 * Created by user on 19.09.2017.
 */
public class Controller {
    public Player player;
    public Mom mom;
    public Kid kid;
    public Location location;
    public GameMap gameMap;
    public TaskManager taskManager;


    public Controller() {
        player = new Player();
        mom = new Mom();
        kid = new Kid();
        gameMap = new GameMap(this);
        location = gameMap.hallLocation;
        taskManager = new TaskManager(this);
    }


    public boolean activeWithMom() {
        return player.activeZone.intersects(mom.rectMom);
    }

    public boolean activeWithKid() {
        return player.activeZone.intersects(kid.rectKid);
    }

    public void changeLocation(Rectangle door) {
        gameMap.map.get(door).changeLocation(this);
    }

    public void startTask() {
        taskManager.isStart = true;
    }
}
