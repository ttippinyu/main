package integration;

import org.junit.jupiter.api.Test;
import spinbox.containers.lists.TaskList;
import spinbox.entities.items.tasks.Task;
import spinbox.entities.items.tasks.Todo;
import spinbox.exceptions.FileCreationException;
import spinbox.exceptions.SpinBoxException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskListIntegrationTest {
    @Test
    void testTaskList_addingTasks() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("task1"));
        taskList.add(new Todo("task2"));
        taskList.add(new Todo("task3"));

        List<Task> checkList = new ArrayList<>();
        checkList.add(new Todo("task1"));
        checkList.add(new Todo("task2"));
        checkList.add(new Todo("task3"));

        assertEquals(checkList.toString(), taskList.getList().toString());
    }

    @Test
    void testTaskList_removingTasks() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("task1"));
        taskList.add(new Todo("task2"));
        taskList.add(new Todo("task3"));

        List<Task> checkList = new ArrayList<>();
        checkList.add(new Todo("task1"));
        checkList.add(new Todo("task2"));
        checkList.add(new Todo("task3"));

        taskList.remove(1);
        checkList.remove(1);

        assertEquals(checkList.toString(), taskList.getList().toString());
    }

    @Test
    void testTaskList_getTask() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("task1"));
        taskList.add(new Todo("task2"));
        taskList.add(new Todo("task3"));

        Task task = taskList.get(1);

        assertEquals("[T][NOT DONE] task2", task.toString());
    }

    @Test
    void testTaskList_update() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("task1"));
        taskList.add(new Todo("task2"));
        taskList.add(new Todo("task3"));

        Task task = taskList.get(1);
        assertEquals("[T][NOT DONE] task2", task.toString());

        taskList.update(1, true);
        task = taskList.get(2);

        assertEquals("[T][DONE] task2", task.toString());
    }

    @Test
    void testTaskList_contains() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("a"));
        taskList.add(new Todo("b"));
        taskList.add(new Todo("c"));

        List<String> containsList = taskList.containsKeyword("a");
        List<String> checkList = new ArrayList<>();

        checkList.add("Here are the tasks that contain a in your module:");
        checkList.add("1. [T][NOT DONE] a");

        assertTrue(checkList.equals(containsList));
    }

    @Test
    void testTaskList_sort() throws SpinBoxException {
        TaskList taskList = new TaskList("testTaskList");
        taskList.add(new Todo("task3"));
        taskList.add(new Todo("task1"));
        taskList.add(new Todo("task2"));

        List<Task> checkList = new ArrayList<>();
        checkList.add(new Todo("task1"));
        checkList.add(new Todo("task2"));
        checkList.add(new Todo("task3"));

        assertEquals(checkList.toString(), taskList.getList().toString());
    }

}
