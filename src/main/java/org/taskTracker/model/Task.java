package org.taskTracker.model;

import org.taskTracker.fileManager.JSONWriteable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements JSONWriteable{
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

    public static Task fromJSON(String JSONString){
        JSONString = cleanJSON(JSONString);
        String[] JSONArray = JSONString.split(",");

        String id = cleanFieldAndReturnValueString(JSONArray[0], false);
        String description = cleanFieldAndReturnValueString(JSONArray[1], false);
        String statusVal = cleanFieldAndReturnValueString(JSONArray[2], false);
        String createdAtStr = cleanFieldAndReturnValueString(JSONArray[3], true);
        String updatedAtStr = cleanFieldAndReturnValueString(JSONArray[4], true);

        Status status = Status.valueOf(statusVal.toUpperCase());

        Task task = new Task(description);
        task.id = Integer.parseInt(id);
        task.status = status;
        task.createdAt = LocalDateTime.parse(createdAtStr, dateFormatter);
        task.updatedAt = LocalDateTime.parse(updatedAtStr, dateFormatter);

        return task;
    }

    private static String cleanJSON(String JSONString){
        JSONString = JSONString
                .replace("{", "")
                .replace("}","")
                .replace("\"","")
                .replace("\t","")
                .replace("\n","");
        return JSONString;
    }

    private static String cleanFieldAndReturnValueString(String field, boolean date){
        if(date){
            return field.split("[a-z]:")[1].strip();
        };
        return field.split(":")[1].strip();
    }

    @Override
    public String toString(){
        return "\"id\": \"" + id + "\", " +
                "\"description\": \"" + description + "\", " +
                "\"status\": \"" + status.getValue() + "\", " +
                "\"createdAt\": \"" + createdAt + "\", " +
                "\"updatedAt\": \"" + updatedAt + "\"" +
                "\n";
    }

}
