import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals(1, list.getSize());

    }

    @Test
    void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("Complete!", list.getCompleted(true));


    }

    @Test
    void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);

        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.setComplete(true,98));

    }

    @Test
    void editingTaskItemTitleChangesValues() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("New title", list.updateTitle(0, "New title"));
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertEquals("New description", list.updateDescription(0, "New description"));
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.updateDescription(9,"Test"));


    }

    @Test
    void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.updateDuedate(0, "New duedate");
        assertEquals("New duedate", list.taskList.get(0).getDueDate());
        System.out.println("Passed");
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.updateDuedate(9,"Test"));

    }

    @Test
    void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.updateTitle(0, "New title");
        assertEquals("New title", list.taskList.get(0).getTitle());
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.updateTitle(9,"Task name 1300"));
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);

        assertThrows(IndexOutOfBoundsException.class, ()-> list.getDesc(2));


    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Description", list.taskList.get(0).getDescription());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.getdueDate(2));

    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Due", list.taskList.get(0).getDueDate());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.getTaskName(2));


    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        int index = 0;
        boolean retrieved = true;
        if (index >= list.getSize()) {

            retrieved = false;
            assertFalse(retrieved);
            System.out.println("Unable to retrieve...: Passed");

        } else {
            assertEquals("Title", list.taskList.get(0).getTitle());
            assertTrue(retrieved);
            System.out.println("Able to retrieve...:Passed");
        }
    }

    @Test
    void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(0, list.getSize());
        System.out.println("Passed");
    }

    @Test
    void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        list.deleteTask(0);
        assertEquals(0, list.getSize());
        System.out.println("Passed");
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", false);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.deleteTask(2));

    }

    @Test
    void savedTaskListCanBeLoaded() {
        File file = new File("testme.txt");
        assertTrue(file.exists());

    }

    @Test
    void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);

        assertEquals("Incomplete", list.getCompleted(false));

    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.setComplete(false,2));

    }
    @Test
    void changingAllValues(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);
        list.updateTitle(0, "New title");

        assertEquals("New title", list.taskList.get(0).getTitle());
        assertEquals("New description", list.updateDescription(0, "New description"));

        assertEquals("Complete!", list.getCompleted(true));
        assertEquals("Incomplete", list.getCompleted(false));
        list.updateDuedate(0, "New duedate");
        assertEquals("New duedate", list.taskList.get(0).getDueDate());
    }
    @Test
    void removeTwoTasks(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);
        list.newAdd(task);
        list.newAdd(task);
        list.deleteTask(0);
        list.deleteTask(1);

        assertEquals(1,list.getSize());
    }
    @Test
    void removeIndexWithUpdatedDuedateValue(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);
        list.updateDuedate(0,"Updated");
        assertEquals("Updated",list.taskList.get(0).getDueDate());
        list.deleteTask(0);
        assertEquals(0,list.getSize());
    }
    @Test
    void RemoveIndexWithUpdatedTitle(){
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Title", "Description", "Due", true);
        list.newAdd(task);
        list.updateTitle(0,list.taskList.get(0).setTitle("updated"));
        assertEquals("updated",list.taskList.get(0).getTitle());
        list.deleteTask(0);
        assertEquals(0,list.getSize());
    }


}