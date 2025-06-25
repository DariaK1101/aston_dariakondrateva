//Задание 2. Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
// круг, прямоугольник, треугольник.
//Задать для каждой фигуры цвет заливки и цвет границы.
//Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
//Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.

public class Figures {
    public static void main(String[] args) {
        System.out.println("Фигуры");
        Shape circle = new Circle(3.5, "Жёлтый", "Фиолетовый");
        Shape rectangle = new Rectangle(12, 15, "Красный", "Розовый");
        Shape triangle = new Triangle(10, 14, 9, "Оранжевый", "Зелёный");

        System.out.println("Круг:");
        circle.printCharacteristics();

        System.out.println("\nПрямоугольник:");
        rectangle.printCharacteristics();

        System.out.println("\nТреугольник:");
        triangle.printCharacteristics();
    }

    interface Shape {
        double getPerimeter();
        double getArea();
        String getFillColor();
        String getBorderColor();

        default void printCharacteristics() {
            System.out.println("Периметр: " + getPerimeter());
            System.out.println("Площадь: " + getArea());
            System.out.println("Цвет фона: " + getFillColor());
            System.out.println("Цвет границ: " + getBorderColor());
        }
    }

    static class Circle implements Shape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    static class Rectangle implements Shape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    static class Triangle implements Shape {
        private double sideA;
        private double sideB;
        private double sideC;
        private String fillColor;
        private String borderColor;

        public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double getArea() {
            double s = getPerimeter() / 2.0;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }
}

