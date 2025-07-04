class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getName() {
        return "Круг";
    }


    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }


    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
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