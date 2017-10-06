package model.tasks;

import controller.Controller;
/**
 * Created by user on 06.10.2017.
 */
public class TaskThree extends Task {

    public TaskThree (Controller controller)
    {
        this.controller=controller;
    }

    public void update()
    {

        if(controller.activeWithKid()&&controller.player.isActive&&controller.location==controller.gameMap.personalsHallLocation)
        {
            controller.kid.kidInWaitingHall=true;
            controller.kid.kidInPersonalHall=false;
        }

    }
}
