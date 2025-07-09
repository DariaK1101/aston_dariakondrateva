package org.example;

public class TriangleArea {
    public static double compute(double base, double height) {
        if (base <= 0 || height <= 0) throw new IllegalArgumentException("Неверные значения!");
        return (base * height) / 2.0;
    }
}