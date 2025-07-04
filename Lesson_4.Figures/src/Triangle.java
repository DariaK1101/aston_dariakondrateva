class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getName() {
        return "Треугольник";
    }

    @Override
    public double calculateArea() {
        double semiPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
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