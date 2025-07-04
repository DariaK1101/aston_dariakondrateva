interface Shape {
    String getName();

    String getFillColor();

    String getBorderColor();

    default double calculatePerimeter() {
        return 0.0;
    }

    double calculateArea();

    default void printColorInfo() {
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}