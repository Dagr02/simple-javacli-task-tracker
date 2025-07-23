package org.taskTracker;

import org.taskTracker.fileManager.FileResourceManagerImpl;
import org.taskTracker.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskCLIManager {
    private List<Task> tasks;
    private FileResourceManagerImpl fileResourceManager;

    public TaskCLIManager(){
        this.tasks = new ArrayList<>();
        this.fileResourceManager = new FileResourceManagerImpl();
        init();
    }

    private void init(){
        this.tasks = fileResourceManager.load();
    }

    public void add(String description){
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added");
    }

    public void update(String id, String description){

    }

    public void list(){
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void save(){
        fileResourceManager.store(tasks);
    }


}
