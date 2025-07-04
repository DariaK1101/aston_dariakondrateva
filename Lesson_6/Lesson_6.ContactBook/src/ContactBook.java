import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactBook {
    private static Map<String, List<String>> contact;


    public ContactBook() {
        contact = new HashMap<>();
    }

    // Добавление нового контакта:
    public void add(String lastName, String phoneNumber) {
        List<String> phones = contact.getOrDefault(lastName, new ArrayList<>());
        phones.add(phoneNumber);
        contact.put(lastName, phones);
    }

    // Поиск телефонов по фамилии:
    public List<String> get(String lastName) {
        return contact.getOrDefault(lastName, new ArrayList<>());
    }


    public static void main(String[] args) {
        ContactBook ct = new ContactBook();

        ct.add("Иванов", "+79213034210");
        ct.add("Иванов", "+79057653213");
        ct.add("Петров", "+79817095543");
        ct.add("Михеева", "+79817095543");

        System.out.println("Телефоны Иванова: " + ct.get("Иванов"));
        System.out.println("Телефоны Петрова: " + ct.get("Петров"));
        System.out.println("Телефоны Михеевой: " + ct.get("Михеева"));
        System.out.println("Телефоны Антропова: " + ct.get("Антропов"));
    }
}


