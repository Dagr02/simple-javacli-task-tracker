package org.taskTracker;

import org.taskTracker.model.Status;

import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskCLIManager manager = new TaskCLIManager();
        if(args.length < 1){
            System.out.println("task-cli <command> [arguments]");
            System.out.println("Commands: add | update | delete | mark-in-progress | mark-done | list <done | todo | in progress>");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if(args.length < 2){
                    System.out.println("Invalid input. task-sli add <description>");
                    return;
                }
                manager.add(args[1]);
                break;
            case "update":
                if(args.length < 2){
                    System.out.println("Invalid input. task-sli update <id> <description>");
                    return;
                }
                manager.update(args[1],args[2]);
                break;
            case "delete":
                break;
            case "mark-in-progress":
                break;
            case "mark-done":
                break;
            case "list":
                if(args.length < 2){
                    manager.list();
                }else{
                    Status status = Status.valueOf(args[1]);
                }
                break;
        }
        manager.save();
    }
}