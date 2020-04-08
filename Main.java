import com.todolist.controllers.TaskController;
import com.todolist.models.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static void showOptions() {
        System.out.println("1. get all task");
        System.out.println("2. get task by name");
        System.out.println("3. create task");
        System.out.println("4. update task");
        System.out.println("5. delete task");
        System.out.println("6. exit");
    }

    private static void showTasksFormatted(Task[] tasks) {
        System.out.print("id\tname\tcompleted\tcreated on\tcompleted on\teadline");
        System.out.println();
        for(Task task : tasks) {
            System.out.print(task.getId() + "\t");
            if(task.getIsDone())
                System.out.print("yes" + "\t");
            else
                System.out.print("no" + "\t");
            System.out.print(task.getTaskCreated().toString() + "\t");
            if(task.getIsDone())
                System.out.print(task.getTaskCompleted().toString() + "\t");
            else
                System.out.print("not completed yet" + "\t");
            System.out.println(task.getDeadline());
        }       
    }

    private static void showTasksFormatted(Task task) {
        System.out.print("id\tname\tcompleted\tcreated on\tcompleted on\teadline");
        System.out.println();
        System.out.print(task.getId() + "\t");
        if(task.getIsDone())
            System.out.print("yes" + "\t");
        else
            System.out.print("no" + "\t");
        System.out.print(task.getTaskCreated().toString() + "\t");
        if(task.getIsDone())
            System.out.print(task.getTaskCompleted().toString() + "\t");
        else
            System.out.print("not completed yet" + "\t");
        System.out.println(task.getDeadline());     
    }

    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        Scanner scanner = new Scanner(System.in);
        int option;

        Task task;
        Task[] tasks;
        String taskName, deadline;
        Date dl = null;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        do {
            showOptions();
            option = scanner.nextInt();

            switch(option) {
                case 1:
                tasks = taskController.getAll();
                if(tasks.length == 0)
                    System.out.println("empty");
                else { 
                    showTasksFormatted(tasks);
                    System.out.println();
                }
                break;

                case 2:
                taskName = "hello";//scanner.nextLine();
                task = taskController.read(taskName);
                if(task == null)
                    System.out.println("not task by this name");
                else {
                    showTasksFormatted(task);
                    System.out.println(); 
                }
                break;

                case 3:
                taskName = "go for a walk"; //scanner.nextLine();
                deadline = "04/04/2020"; //scanner.nextLine();
                try {
                    dl = dateFormat.parse(deadline);
                }
                catch(Exception e) {

                }
                task = new Task(taskName, dl);
                taskController.create(task);
                System.out.println("task created");
                break;

                case 4:
                taskName = "go for a walk";//scanner.nextLine();
                String field = "task name"; //scanner.nextLine();

                if(taskController.read(taskName) != null)
                    if(field.equals("task name")) {
                        task = taskController.read(taskName);
                        String name = "corona"; //scanner.nextLine();
                        task.setTaskName(name);
                        taskController.update(task);
                        System.out.println("update completed");
                    }
                    else if(field.equals("is done")) {
                        task = taskController.read(taskName);
                        task.setIsDone(!task.getIsDone());
                        taskController.update(task);
                        System.out.println("update completed");
                    }
                    else {
                        task = taskController.read(taskName);
                        deadline = scanner.nextLine();
                        dl = new Date(deadline);
                        task.setDeadline(dl);
                        taskController.update(task);
                        System.out.println("update completed");
                    }
                else
                    System.out.println("not task by this name");
                break;

                case 5:
                taskName = scanner.nextLine();
                if(taskController.read(taskName) != null) {
                    task = taskController.read(taskName);
                    taskController.delete(task.getId());
                    System.out.println("deletion completed");
                }
                else
                    System.out.println("no task by this name");
                break;

                default:
                System.out.println("exiting the application");
            }

        } while(option != 6);
    }
}