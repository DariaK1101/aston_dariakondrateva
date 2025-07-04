
public class Main {
    public static void main(String[] args) {

        Park park = new Park("Диво Остров");


        park.addAttraction("Колесо обозрения", "10:00 - 22:00", 800);
        park.addAttraction("Американские горки", "11:00 - 20:00", 1250);
        park.addAttraction("Карусель", "10:00 - 19:00", 500);
        park.addAttraction("Лабиринт", "10:00 - 19:00", 500);

        park.showAttractions();
    }
}