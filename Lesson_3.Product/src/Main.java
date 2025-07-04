public class Main {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("HONOR X8b", "13.04.2023", "Honor Device Co.", "China", 14999, false);
        productsArray[2] = new Product("Apple iPhone 13", "14.09.2021", "Apple", "USA", 65999, true);
        productsArray[3] = new Product("Xiaomi Redmi 13", "15.06.2023", "Xiaomi Corp.", "China", 13499, true);
        productsArray[4] = new Product("HUAWEI Pura 70", "25.11.2024", "Huawei Technologies Co. Ltd.", "China", 55999, false);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}