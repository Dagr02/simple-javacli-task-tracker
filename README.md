## Task tracker
Simple java CLI to track and manage tasks. 


### Commands
```bash
    # Adding a new task
    java -jar task-cli.jar add "Buy groceries"
    # Output: Task added

    # Updating and deleting tasks
    java -jar task-cli.jar update 1 "Buy groceries and cook dinner"
    java -jar task-cli.jar delete 1

    # Marking a task as in progress or done
    java -jar task-cli.jar mark-in-progress 1
    java -jar task-cli.jar mark-done 1

    # Listing all tasks
    java -jar task-cli.jar list

    # Listing tasks by status
    java -jar task-cli.jar list done
    java -jar task-cli.jar list todo
    java -jar task-cli.jar list in-progress

```
