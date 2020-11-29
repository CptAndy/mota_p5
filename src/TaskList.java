import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {
    final List<TaskItem> taskList;

    public void print() {
        for (TaskItem task : taskList
        ) {
            System.out.println("----------------------------------------------");
            System.out.println("Name...: " + task.getTitle());
            System.out.println("Description...: " + task.getDescription());
            System.out.println("Duedate...: " + task.getDueDate());
            System.out.println("Status...: " + task.absoluteStatus());

        }

    }

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void newAdd(TaskItem task) {

        taskList.add(task);
    }

    public void setComplete(boolean isCompleted, int index) {
        taskList.get(index).setCompletionStatus(isCompleted);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public int getSize() {
        return taskList.size();
    }

    String getCompleted(boolean isCompleted) {
        if (isCompleted) {
            return "Complete!";
        } else {
            return "Incomplete";
        }
    }

    public String updateTitle(int index, String updatedTitle) {
        return taskList.get(index).setTitle(updatedTitle);
    }

    public String updateDescription(int index, String updatedDescription) {
        return taskList.get(index).setDescription(updatedDescription);
    }

    public String updateDuedate(int index, String updatedDuedate) {
        return taskList.get(index).setDueDate(updatedDuedate);
    }

    public String getDesc(int index) {
        return taskList.get(index).getDescription();
    }

    public String getdueDate(int index) {
        return taskList.get(index).getDueDate();
    }

    public String getTaskName(int index) {
        return taskList.get(index).getTitle();
    }
}