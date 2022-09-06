public class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return " " + name + ", " + phoneNumber;
    }

    public String getNumber() {
        return phoneNumber;
    }
}