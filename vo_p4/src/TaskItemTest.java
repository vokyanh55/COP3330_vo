import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void gettingTaskItemTitle(){
        TaskItem task1 = new TaskItem("Task 1", "First task", "2020-01-01");
        assertEquals("Task 1", task1.getTitle());
    }

    @Test
    public void gettingTaskItemDescription(){
        TaskItem task1 = new TaskItem("Task 1", "First task", "2020-01-01");
        assertEquals("First task", task1.getDescription());
    }

    @Test
    public void gettingTaskItemDueDate(){
        TaskItem task1 = new TaskItem("Task 1", "First task", "2020-01-01");
        assertEquals("2020-01-01", task1.getDd());
    }

    @Test



}