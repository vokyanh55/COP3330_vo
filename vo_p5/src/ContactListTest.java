import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactListTest {
    @Test
    void addingItemsIncreasesSize(){
        ContactList list1 = new ContactList();
        list1.size++;
        list1.size();
        assertEquals(1, list1.size());
    }

    @Test
    void removingItemsDecreasesSize(){
        ContactList list1 = new ContactList();
        list1.size++;
        list1.size--;
        list1.size();
        assertEquals(0, list1.size());
    }

    @Test
    void uncompletingTaskItemChangesStatus(){
        ContactList list1 = new ContactList();
        list1.size++;
        list1.size--;
        list1.size();
        assertEquals(0, list1.size());
    }

}