package org.taskTracker.fileManager;

import org.taskTracker.model.Task;

import java.util.List;

public interface FileResourceManager {
    String load();
    void store(List<Task> content);
}
