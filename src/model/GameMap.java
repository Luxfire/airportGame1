package model;

import controller.Controller;
import model.Door;
import model.locations.*;

import java.awt.*;
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
    public Map<Rectangle, Door> map;

    public GameMap(Controller controller)
    {
        this.controller = controller;
        hallLocation = new HallLocation(controller);
        regHallLocation = new RegHallLocation(controller);
        cafeHallLocation = new CafeHallLocation(controller);
        personalsHallLocation = new PersonalsHallLocation(controller);
        streetHallLocation = new StreetHallLocation(controller);
        waitingHallLocation = new WaitingHallLocation(controller);

        Door doorHallReg = new Door(hallLocation,regHallLocation);
        Door doorPersonalReg = new Door(personalsHallLocation, regHallLocation);
        Door doorRegWait = new Door(regHallLocation,waitingHallLocation);
        Door doorWaitBar = new Door(waitingHallLocation,cafeHallLocation);
        Door doorWaitStreet = new Door(waitingHallLocation,streetHallLocation);

        map = new HashMap<>();
        map.put(hallLocation.doorUpOne,doorHallReg);
        map.put(regHallLocation.doorDownOne,doorHallReg);
        map.put(regHallLocation.doorDownTwo,doorPersonalReg);
        map.put(regHallLocation.doorUpOne,doorRegWait);
        map.put(regHallLocation.doorUpTwo,doorRegWait);
        map.put(personalsHallLocation.doorUpOne,doorPersonalReg);
        map.put(waitingHallLocation.doorDownOne,doorRegWait);
        map.put(waitingHallLocation.doorDownTwo,doorRegWait);
        map.put(waitingHallLocation.doorRight,doorWaitBar);
        map.put(waitingHallLocation.doorUpOne,doorWaitStreet);
        map.put(cafeHallLocation.doorLeft,doorWaitBar);
        map.put(streetHallLocation.doorDownOne,doorWaitStreet);
    }
}


