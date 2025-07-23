package org.taskTracker.model;

import org.taskTracker.fileManager.JSONWriteable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements JSONWriteable {
    private static int prevId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task(String description){
        id = prevId++;
        this.description = description;
        this.status = Status.TODO;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public Task(){}

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus(){
        return status.getValue();
    }

    public void setStatus(String status){
        this.status = Status.valueOf(status);
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toJSON(){
        return "\t\t\t{ " +
                "\n\t\t\t\"id\": \"" + id + "\"," +
                "\n\t\t\t\"description\": \"" + description + "\"," +
                "\n\t\t\t\"status\": \"" + status.getValue() + "\"," +
                "\n\t\t\t\"createdAt\": \"" + createdAt + "\"," +
                "\n\t\t\t\"updatedAt\": \"" + updatedAt + "\"" +
                "\n\t\t\t}" ;
    }

}
