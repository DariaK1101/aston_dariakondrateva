public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3.5, "Жёлтый", "Фиолетовый");
        Shape rectangle = new Rectangle(12, 15, "Красный", "Розовый");
        Shape triangle = new Triangle(10, 14, 9, "Оранжевый", "Зелёный");

        Shape[] shapes = {circle, rectangle, triangle};

        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getName());
            System.out.println("Периметр: " + shape.calculatePerimeter());
            System.out.println("Площадь: " + shape.calculateArea());
            shape.printColorInfo();
            System.out.println();

        }
    }
}