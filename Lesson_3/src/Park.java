// Задание 3. Создать класс Park с внутренним классом,
// с помощью объектов которого можно хранить информацию об аттракционах,
// времени их работы и стоимости.
public static class Park {
    String name;
    String address;
    String phone_number;
    public Park(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }
}

public static class Attraction {
    private String attractionInfo;
    private String openHours;
    private int price;

    public Attraction(String attractionInfo, String openHours, int price) {
        this.attractionInfo = attractionInfo;
        this.openHours = openHours;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Информация об аттракционе: " + attractionInfo);
        System.out.println("Время работы: " + openHours);
        System.out.println("Стоимость: " + price);
    }
}
public static void main(String[] args) {
    Park park = new Park("Парк", "адресс","654-32-10");
    Attraction attraction1 = new Attraction("Название аттракциона", "10:00 - 18:00", 750);
    attraction1.printInfo();
}



