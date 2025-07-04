import java.util.ArrayList;
import java.util.List;

class Park {
    private String parkName;
    private List<Attraction> attractions;


    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String openHours, double price) {
        attractions.add(new Attraction(name, openHours, price));
    }


    public void showAttractions() {
        System.out.println("Аттракционы парка \"" + parkName + "\":");
        System.out.println();
        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }


    private class Attraction {
        private String name;
        private String openHours;
        private double price;


        public Attraction(String name, String openHours, double price) {
            this.name = name;
            this.openHours = openHours;
            this.price = price;
        }


        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + openHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }
}