package model;

import controller.Controller;
import model.locations.Location;
/**
 * Created by user on 24.09.2017.
 */
public class Door {
    public Location locationLeft;
    public Location locationRight;

    public Door(Location locationLeft, Location locationRight) {
        this.locationLeft = locationLeft;
        this.locationRight = locationRight;
    }

    public void changeLocation(Controller controller)
    {
        if(locationLeft==controller.location) controller.location= locationRight;
        else controller.location = locationLeft;
    }
}
