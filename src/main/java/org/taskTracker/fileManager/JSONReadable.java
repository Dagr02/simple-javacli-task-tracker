package org.taskTracker.fileManager;

public interface JSONReadable<T>{
    T fromJSON(String json);
}
