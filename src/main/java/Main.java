import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws Exception {
        PhoneBook phonebook = new PhoneBook();
        groups(phonebook);
        contacts(phonebook);
        MissedCalls newCalls = new MissedCalls(); // задаём пропущенные звонки для демонстрации
        registredCalls(newCalls);
        System.out.println("Missed calls:  ");
        newCalls.printMissedCalls(phonebook);
    }

    public static void registredCalls(MissedCalls newCalls) throws InterruptedException {
        newCalls.newOne(LocalDateTime.now(), "1030");
        newCalls.newOne(LocalDateTime.now(), "0220");
        newCalls.newOne(LocalDateTime.now(), "5009");
        newCalls.newOne(LocalDateTime.now(), "1234");
    }

    public static void groups(PhoneBook phonebook) {
        phonebook.newGroup("Family");
        phonebook.newGroup("Friends");
        phonebook.newGroup("Work");
    }

    public static void contacts(PhoneBook phonebook) {
        phonebook.phoneBookRecord(phonebook.newContact("Ann", "0220"), "Friends");
        phonebook.phoneBookRecord(phonebook.newContact("Hue", "1030"), "Work", "Friends");
        phonebook.phoneBookRecord(phonebook.newContact("Sue", "5009"), "Friends", "Family");
        phonebook.phoneBookRecord(phonebook.newContact("Jon", "0870"), "Family");
        phonebook.phoneBookRecord(phonebook.newContact("Son", "0830"), "Family", "Friends", "Work");
    }
}
