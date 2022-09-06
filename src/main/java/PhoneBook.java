import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    static Map<String, List<Contact>> phonebook = new HashMap<>();

    public void newGroup(String groupName) {
        phonebook.put(groupName, new ArrayList<>());
    }

    public static void phoneBookRecord(Contact contact, String... groupName) {
        for (String name : groupName) {
            phonebook.get(name).add(contact);
        }
    }

    public static Contact newContact(String contactName, String contactNumber) {
        return new Contact(contactName, contactNumber);
    }

    public String toString() {
        StringBuilder buildingBook = new StringBuilder();
        for (Map.Entry<String, List<Contact>> group : phonebook.entrySet()) {
            buildingBook.append(group.getKey()).append(":\n");
            for (Contact contact : group.getValue()) {
                buildingBook.append(contact).append("\n");
            }
        }
        return buildingBook.toString();
    }

    public static List<Contact> searchGroup(String searchedGroup) {
        return phonebook.get(searchedGroup);
    }

    public static Contact searchNumber(String searchedNumber) {
        for (List<Contact> values : phonebook.values()) {
            for (Contact value : values) {
                if (value.getNumber().equals(searchedNumber)) {
                    return value;
                }
            }
        }
        return null;
    }
}