package duke;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> arrayList;

    /**
     * Default constructor to create an empty TaskList.
     */
    public TaskList() {
        this.arrayList = new ArrayList<>();
    }

    /**
     * Used to create a TaskList from a given ArrayList of TaskItems.
     * @param arrayList an ArrayList of TaskItems that should be in the TaskList.
     */
    public TaskList(ArrayList<TaskItem> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Adds a TaskItem to the TaskList.
     * @param task
     */
    public void add(TaskItem task) {
        arrayList.add(task);
    }

    /**
     * Returns the size of the TaskList.
     * @return size of the TaskList.
     */
    public int size() {
        return arrayList.size();
    }

    /**
     * Gets a TaskItem from the TaskList given the index of its position in the TaskList.
     * @param index The index of the TaskItem in the TaskList.
     * @return The TaskItem at the specified index.
     */
    public TaskItem get(int index) {
        return arrayList.get(index);
    }

    /**
     * Removes a TaskItem from the TaskList.
     * @param index the index of the TaskItem that is to be removed.
     */
    public void remove(int index) {
        this.arrayList.remove(index);

    }


}
