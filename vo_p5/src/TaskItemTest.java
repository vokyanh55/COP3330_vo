import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskItemTest {
    @Test
    void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem task1 = new TaskItem ("Task 1", "", "");
        assertEquals("", task1.getDd());
    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem task1 = new TaskItem ("", "", "");
        assertEquals("", task1.getTitle());
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem task1 = new TaskItem ("Task 1", "", "2020-01-01");
        assertEquals("2020-01-01", task1.getDd());
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem task1 = new TaskItem ("Task 1", "", "2020-01-01");
        assertEquals("Task 1", task1.getTitle());
    }

    @Test
    public void gettingTaskItemTitle(){
        TaskItem task2 = new TaskItem("Task 2", "My Second task", "2021-01-01");
        assertEquals("Task 2", task2.getTitle());
    }

    @Test
    public void gettingTaskItemDescription(){
        TaskItem task2 = new TaskItem("Task 2", "My second task", "2021-01-01");
        assertEquals("My second task", task2.getDescription());
    }

    @Test
    public void gettingTaskItemDueDate(){
        TaskItem task2 = new TaskItem("Task 2", "My second task", "2021-01-01");
        assertEquals("2021-01-01", task2.getDd());
    }
}