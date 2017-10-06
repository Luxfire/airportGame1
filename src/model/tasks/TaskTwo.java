package model.tasks;

import controller.Controller;
/**
 * Created by user on 06.10.2017.
 */
public class TaskTwo extends Task {

    public TaskTwo (Controller controller)
    {
        this.controller=controller;
    }

    public void update()
    {
           if (controller.activeWithMom()&&controller.player.isActive) controller.player.dialogWithMomInHoll=true;

            if (controller.player.dialogWithMomCounter == controller.player.dialogWithMom.size()-1) {
                controller.mom.momInHoll = false;
                controller.mom.momInWaitingHall = true;
                controller.mom.changeYForWait();
                controller.player.dialogWithMomInHoll=false;
                isFinished = true;
            }

    }
}
