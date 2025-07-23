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

    public static boolean exists(String value){
        try {
            fromValue(value);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }


    public static Status fromValue(String value){
        for(Status status : values()){
            if(status.getValue().equalsIgnoreCase(value)){
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

}
