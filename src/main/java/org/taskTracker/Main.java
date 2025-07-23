package org.taskTracker;

import org.taskTracker.model.Status;

import java.util.Arrays;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskCLIManager manager = new TaskCLIManager();
        if(args.length < 1){
            System.out.println("task-cli <command> [arguments]");
            System.out.println("Commands: add <description> | update <id> <description> | delete <id> | mark-in-progress <id> | mark-done <id> | list <done | todo | in progress>");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if(args.length < 2){
                    System.out.println("Invalid input. task-cli add <description>");
                    return;
                }
                manager.add(args[1]);
                break;
            case "update":
                if(args.length < 2){
                    System.out.println("Invalid input. task-cli update <id> <description>");
                    return;
                }
                manager.update(args[1],args[2]);
                break;
            case "delete":
                if(args.length < 2){
                    System.out.println("Invalid input. task-cli delete <id>");
                    return;
                }
                manager.delete(args[1]);
                break;
            case "mark-in-progress":
                if(args.length < 2){
                    System.out.println("Invalid input. task-cli mark-in-progress <id>");
                    return;
                }
                manager.markInProgress(args[1]);
                break;
            case "mark-done":
                if(args.length < 2){
                    System.out.println("Invalid input. task-cli mark-done <id>");
                    return;
                }
                manager.markDone(args[1]);
                break;
            case "list":
                if(args.length < 2){
                    manager.list();
                }else{
                    String status = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                    manager.list(status);
                }
                break;
        }
        manager.save();
    }
}