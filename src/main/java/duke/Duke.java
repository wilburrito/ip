package duke;

import java.util.Arrays;

public class Duke {
    public static boolean active;
    public static TaskList taskList = new TaskList();
    public static int listIndex = 0;

    /**
     * awaken() awakens duke.Duke and allows one to input commands to duke.Duke.
     */
    public static void awaken() {

        //load previous list data here maybe

        taskList = new TaskList(Storage.loadData());

        Duke.active = true;

        Ui.sendStartMessage();

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (active) {
            String input = scanner.nextLine();
            boolean cont = Parser.interpretCommand(input);
            if (!cont) {
                break;
            }
        }
    }

    /**
     * deletes a task from the list that duke.Duke creates.
     * @param taskToBeDeleted the index of the task to be deleted.
     * @throws DukeException An exception stemming from incorrect or awkward input to duke.Duke.
     */
    public static void deleteTask(String taskToBeDeleted) throws DukeException {
        int taskNumber = Integer.parseInt(taskToBeDeleted);

        if (taskList.get(taskNumber - 1) == null) {
            throw new DukeException(
                    "____________________________________________________________\n" +
                            "☹ OOPS!!! The task you chose to delete does not exist. Use the 'list' command to check the items in your list.\n" +
                            "____________________________________________________________"
            );
        }
        TaskItem removedTask = taskList.get(taskNumber - 1);
        taskList.remove(taskNumber - 1);
        int taskListSize = taskList.size();
        Ui.deletedTaskMessage(removedTask, taskListSize);

    }


    /**
     * markAsFinished marks items on duke.Duke's list as completed. Completed tasks will have a checkbox "[X]".
     * @param taskItemNumber the index of the task to be marked as finished.
     * @throws DukeException An exception stemming from incorrect or awkward input to duke.Duke.
     */
    public static void markAsFinished(String taskItemNumber) throws DukeException {
        int taskNumber = Integer.parseInt(taskItemNumber);
        if (taskList.get(taskNumber - 1) == null) {
            throw new DukeException(
                    "____________________________________________________________\n" +
                            "☹ OOPS!!! The task you chose does not exist. Use the 'list' command to check the items in your list.\n" +
                            "____________________________________________________________"
            );
        }
        taskList.get(taskNumber - 1).completeTask();
        Ui.completedTaskMessage(taskList.get(taskNumber - 1));
    }

    /**
     * addToList adds a taskItem of type duke.TaskItem to the list.
     * @param taskItem a duke.TaskItem that is to be added to duke.Duke's list.
     */
    public static void addToList(TaskItem taskItem) {
        Duke.taskList.add(taskItem);
        Duke.listIndex = taskList.size();
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println(taskItem.toString());
        if (listIndex == 1) System.out.println("Now you have " + 1 + " task in the list.");
        if (listIndex > 1) System.out.println("Now you have " + (Duke.listIndex) + " tasks in your list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * prints the list upon inputting the 'list' command.
     */
    public static void printList() {
        int number = 1;
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i) != null) {
                System.out.println(number + "." + taskList.get(i).toString());

                number++;
            }
        }
        System.out.println("____________________________________________________________");
    }

    public static TaskList findTask(String keyword) {
        /*
        TaskList matchingTasks = new TaskList();
        int number = 1;

        for (int i = 0; i < taskList.size(); i++) {
            TaskItem task = taskList.get(i);
            String taskDescrption = task.describeTaskItem();
            String[] splicedTaskDescription = taskDescrption.split(" ");
            boolean matched = false;
            splicedTaskDescription = (String[]) Arrays.stream(splicedTaskDescription).filter(x -> {
               if (x.equals(keyword)) {
                   return true;
               } else {
                   return false;
               }
            }).toArray();

            if (splicedTaskDescription.length > 0) {
                matched = true;
            }

            if (matched) {
                matchingTasks.add(task);
            }
        }

        if (matchingTasks.size() == 0) {
            System.out.println("____________________________________________________________\n" +
                    "☹ OOPS!!! No tasks match your search.\n" +
                    "____________________________________________________________");
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("Here is what I found:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println(number + "." + matchingTasks.get(i).toString());
                number++;
            }
        }
        */
        return taskList.findTask(keyword);

    }

    /**
     * main method.
     * @param args input from the user to control duke.Duke.
     */
    public static void main(String[] args) {
        Duke.awaken();
    }
}
