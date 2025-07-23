package org.taskTracker;

import org.taskTracker.fileManager.FileResourceManagerImpl;
import org.taskTracker.fileManager.JSONReader;
import org.taskTracker.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskCLIManager {
    private List<Task> tasks;
    private FileResourceManagerImpl fileResourceManager;
    private JSONReader jsonReader;

    public TaskCLIManager(){
        this.tasks = new ArrayList<>();
        this.fileResourceManager = new FileResourceManagerImpl();
        this.jsonReader = new JSONReader();
        init();
    }

    private void init(){
        //load file if exists.
    }

    public void add(String description){
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added");
    }

    public void update(String id, String description){

    }

    public void save(){
        System.out.println("File saved");
        fileResourceManager.store(tasks);
    }


}
