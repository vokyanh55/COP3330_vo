import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactItemTest {
    @Test
    void creationFailsWIthAllBlankValues(){
        ContactItem contact1 = new ContactItem("","","","");
        assertEquals("", contact1.getFirst());
    }

    @Test
    void creationSucceedsWithBlankEmail(){
        ContactItem contact1 = new ContactItem ("Anh", "Vo", "123-456-7899","");
        assertEquals("", contact1.getEmail());
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        ContactItem contact1 = new ContactItem ("", "Vo", "123-456-7899","anh@something");
        assertEquals("", contact1.getFirst());
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        ContactItem contact1 = new ContactItem ("Anh", "", "123-456-7899","anh@something");
        assertEquals("", contact1.getLast());
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        ContactItem contact1 = new ContactItem ("Anh", "Vo", "","anh@something");
        assertEquals("", contact1.getPhone());
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        ContactItem contact1 = new ContactItem ("Anh", "Vo", "123-456-7899","anh@something");
        assertEquals("Name: Anh Vo\nPhone: 123-456-7899\nEmail: anh@something" , contact1.toString());
    }

    @Test
    void editingFailsWithAllBlankValues(){
        ContactItem contact2 = new ContactItem ("", "", "","");
        assertEquals("" , contact2.getFirst());
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        ContactItem contact2 = new ContactItem ("Anh", "Vo", "123-456-7899","");
        assertEquals("", contact2.getEmail());
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactItem contact2 = new ContactItem ("", "Vo", "123-456-7899","anh@something");
        assertEquals("", contact2.getFirst());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactItem contact2 = new ContactItem ("Anh", "", "123-456-7899","anh@something");
        assertEquals("", contact2.getLast());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactItem contact2 = new ContactItem ("Anh", "Vo", "","anh@something");
        assertEquals("", contact2.getPhone());
    }

    @Test
    void testToString(){
        ContactItem contact2 = new ContactItem ("John", "Doe", "123-456-7890","John@something");
        assertEquals("Name: John Doe\nPhone: 123-456-7890\nEmail: John@something" , contact2.toString());
    }



}