package org.taskTracker.fileManager;

public interface FileResourceManager {
    String load(String path);
    void store(String path, String content);
}
