import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private String name = "John";
    private String number = "12355";

    @Test
    void newContactTest() {

        //expect
        Contact actual = PhoneBook.newContact(name, number);

        assertEquals(name, actual.name);
        assertEquals(number, actual.phoneNumber);
    }

    @Test
    void searchNumberTest() {
        String forSearch = "1030";

        PhoneBook phonebook = new PhoneBook();
        Contact contact = phonebook.newContact("Jimbo", "1030");
        phonebook.newGroup("Work");
        PhoneBook.phoneBookRecord(contact, "Work");

        assertEquals("1030", PhoneBook.searchNumber(forSearch).getNumber());
    }

    @Test
    void searchNumberTestU() {
        String forSearch = "999999";

        PhoneBook phonebook = new PhoneBook();
        Contact contact = phonebook.newContact("Jimbo", "1030");
        phonebook.newGroup("Work");
        PhoneBook.phoneBookRecord(contact, "Work");

        assertNull(PhoneBook.searchNumber(forSearch));
    }
}