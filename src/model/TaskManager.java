package model;

import controller.Controller;
import model.tasks.Task;
import model.tasks.TaskOne;
import model.tasks.TaskThree;
import model.tasks.TaskTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.10.2017.
 */
public class TaskManager {
    public int currTask = 0;
    public boolean isStart=false;
    public List<Task> taskList = new ArrayList<>();
    public TaskManager(Controller controller)
    {

        taskList.add(new TaskOne(controller));
        taskList.add(new TaskTwo(controller));
        taskList.add(new TaskThree(controller));
    }

    public void update()
    {
        if(isTask()&&isStart)
        {
            taskList.get(currTask).update();
            if (taskList.get(currTask).isFinished) {
                currTask++;
            }
        }
    }

    public boolean isTask()
    {
        if(currTask<taskList.size()) return true;
        else return false;
    }
}
