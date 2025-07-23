package org.taskTracker.fileManager;

import org.taskTracker.model.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileResourceManagerImpl implements FileResourceManager{
    private final Path FILE_PATH = Path.of("tasks.json");

    @Override
    public List<Task> load(){
        List<Task> taskHistory = new ArrayList<>();

        try{
            String file = Files.readString(FILE_PATH);
            String[] taskList = file
                    .replace("\"Tasks\":","")
                    .replace("[", "")
                    .replace("]","")
                    .strip()
                    .split("},");

            for(String task : taskList){
                if(!task.endsWith("}")){
                    task += "}";
                }
                taskHistory.add(Task.fromJSON(task));
            }

        }catch (IOException e){
            throw new RuntimeException("Oops error reading file");
        }

        return taskHistory;
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
