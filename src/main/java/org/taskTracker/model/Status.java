package org.taskTracker.model;

public enum Status {
    DONE("Done"),
    IN_PROGRESS("In progress"),
    TODO("Todo");

    private final String value;

    Status(String status){
        this.value = status;
    }

    public String getValue(){
        return value;
    }

}
