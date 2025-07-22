package org.taskTracker.fileManager;

import org.taskTracker.model.Task;

public class JSONReader implements JSONReadable<Task> {
    @Override
    public Task fromJSON(String json){
        return new Task();
    }
}
