package org.taskTracker;

import org.taskTracker.fileManager.FileResourceManagerImpl;
import org.taskTracker.model.Status;
import org.taskTracker.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.setDescription(description);
        System.out.println("Task updated");
    }

    public void delete(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        tasks.remove(task);
        System.out.println("Task removed");
    }

    public void markInProgress(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.setStatus(Status.IN_PROGRESS.getValue());
        System.out.println("Task updated");
    }

    public void markDone(String id){
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.setStatus(Status.DONE.getValue());
        System.out.println("Task updated");
    }

    private Optional<Task> findTask(String id){
        return tasks.stream().filter((task) -> task.getId() == Integer.parseInt(id)).findFirst();
    }

    public void list(){
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void list(String statusVal){
        List<Task> filteredTasks = findTasksByStatus(statusVal);

        if(filteredTasks.isEmpty()){
            System.out.println("No tasks found with that status");
            return;
        }
        
        for(Task task : filteredTasks){
            System.out.println(task.toString());
        }
    }
    
    private List<Task> findTasksByStatus(String status){
        if(Status.exists(status)) {
            return tasks.stream()
                    .filter((task) -> task.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void save(){
        fileResourceManager.store(tasks);
    }


}
