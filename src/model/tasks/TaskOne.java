package model.tasks;

import controller.Controller;
/**
 * Created by user on 06.10.2017.
 */
public class TaskOne extends Task {


    public TaskOne (Controller controller)
    {
        this.controller=controller;
    }

    public void update()
    {
            stageKidIsLost();
            isFinished = true;
    }

    public void stageKidIsLost() {
        controller.kid.kidInHoll = false;
        controller.kid.kidInPersonalHall = true;
        controller.kid.coordinateInPesronal();
    }
}
