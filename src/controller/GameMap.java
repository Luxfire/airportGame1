package controller;

import model.locations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 24.09.2017.
 */
public class GameMap {

    public HallLocation hallLocation;
    public RegHallLocation regHallLocation;
    public CafeHallLocation cafeHallLocation;
    public PersonalsHallLocation personalsHallLocation;
    public StreetHallLocation streetHallLocation;
    public WaitingHallLocation waitingHallLocation;

    public Controller controller;
    public Map<Door, Location> map;

    public GameMap(Controller controller)
    {
        this.controller = controller;
        hallLocation = new HallLocation(controller);
        regHallLocation = new RegHallLocation(controller);
        cafeHallLocation = new CafeHallLocation(controller);
        personalsHallLocation = new PersonalsHallLocation(controller);
        streetHallLocation = new StreetHallLocation(controller);
        waitingHallLocation = new WaitingHallLocation(controller);

        map = new HashMap<>();
        map.put(hallLocation.doorUpOne,regHallLocation);
        map.put(regHallLocation.doorDownOne,hallLocation);
        map.put(regHallLocation.doorDownTwo,personalsHallLocation);
        map.put(regHallLocation.doorUpOne,waitingHallLocation);
        map.put(regHallLocation.doorUpTwo,waitingHallLocation);
        map.put(personalsHallLocation.doorUpOne,regHallLocation);
        map.put(waitingHallLocation.doorDownOne,regHallLocation);
        map.put(waitingHallLocation.doorDownTwo,regHallLocation);
        map.put(waitingHallLocation.doorRight,cafeHallLocation);
        map.put(waitingHallLocation.doorUpOne,streetHallLocation);
        map.put(cafeHallLocation.doorLeft,waitingHallLocation);
        map.put(streetHallLocation.doorDownOne,waitingHallLocation);
    }
}


