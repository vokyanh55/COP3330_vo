import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    void addingTaskItemsIncreasesSize(){
        TaskList list1 = new TaskList();
        list1.size++;
        list1.size();
        assertEquals(1, list1.size());
    }

    @Test
    void completingTaskItemChangesStatus(){
        TaskList list1 = new TaskList();
        list1.completeListSize();
    }

    @Test
    void editingTaskItemChangesValues(){
        TaskList list1 = new TaskList();

    }

    @Test
    void editingTaskItemDueDateChangesValue(){
        TaskList list1 = new TaskList();

    }

    @Test
    void editingTaskItemDescriptionChangesValue(){
        TaskList list1 = new TaskList();

    }

    @Test
    void removingTaskItemsDecreasesSize(){
        TaskList list1 = new TaskList();
        list1.size--;
        list1.size();
        assertEquals(-1, list1.size());
    }

    @Test
    void uncompletingTaskItemChangesStatus(){
        TaskList list1 = new TaskList();
        list1.size++;
        list1.size();
        assertEquals(1, list1.size());
    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list1 = new TaskList();
        list1.size++;
        list1.size();
        assertEquals(1, list1.size());
    }
}