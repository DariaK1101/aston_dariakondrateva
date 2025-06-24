// Создать класс "Товар" с полями: название, дата производства, производитель,
// страна происхождения, цена, состояние бронирования покупателем.
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    int price;
    boolean orderStatus;

    public Product(String name, String productionDate, String manufacturer, String country, int price,
                   boolean orderStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.orderStatus = orderStatus;
    }


    public void printInfo() {
        System.out.println("Информация о товаре:");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + orderStatus + "\n");
    }

    public static void main(String[] args) {
        Product product = new Product("Samsung Ultra", "01.04.2024", "Samsung Corp.", "Korea", 5599, true);
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("HONOR X8b", "13.04.2023", "Honor Device Co.", "China", 14999, false);
        productsArray[2] = new Product("Apple iPhone 13", "14.09.2021", "Apple", "USA", 65999, true);
        productsArray[3] = new Product("Xiaomi Redmi 13", "15.06.2023", "Xiaomi Corp.", "China", 13499, true);
        productsArray[4] = new Product("HUAWEI Pura 70", "25.11.2024", "Huawei Technologies Co. Ltd.", "China", 55999, false);
        productsArray[0].printInfo();
        productsArray[1].printInfo();
        productsArray[2].printInfo();
        productsArray[3].printInfo();
        productsArray[4].printInfo();
    }
}



