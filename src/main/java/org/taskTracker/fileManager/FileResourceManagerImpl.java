package org.taskTracker.fileManager;

import org.taskTracker.model.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileResourceManagerImpl implements FileResourceManager{
    private final Path FILE_PATH = Path.of("tasks.json");

    @Override
    public String load(){
        List<Task> taskHistory = new ArrayList<>();

        return "";
    }

    @Override
    public void store(List<Task> content){
        StringBuilder builder = new StringBuilder();
        builder.append("{\n\t\"Tasks\": \n\t\t[\n ");
        for(int i = 0; i < content.size(); i++){
            builder.append(content.get(i).toJSON());
            if(i != content.size() -1){
                builder.append(",\n");
            }
        }

        builder.append("\n\t\t]\n }");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH.toFile()))){
            writer.write(builder.toString());
        } catch (IOException e){
            throw new RuntimeException("Something went wrong writing the file");
        }
    }

}
