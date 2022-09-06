// В классе списка пропущенных вызовов должен быть метод, принимающий телефонную книгу и выводящий на экран все пропущенные вызовы в том порядке, в котором они поступали, при этом для номеров для которых есть контакт должно быть выведено на экран имя звонившего, а не номер.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

class MissedCalls {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss (dd MMMM yyyy)");
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void newOne(LocalDateTime time, String number) throws InterruptedException {
        missedCalls.put(time, number);
        Thread.sleep(1000);
    }

    public void printMissedCalls(PhoneBook phonebook) {
        for (LocalDateTime timey : missedCalls.keySet()) {
            String number = missedCalls.get(timey);
            Contact foundContact = phonebook.searchNumber(number);
            if (foundContact != null) {
                System.out.println(foundContact + " called at " + timey.format(formatter));
            } else {
                System.out.println(" Unknown number, " + number + " called at " + timey.format(formatter));
            }
        }
    }
}