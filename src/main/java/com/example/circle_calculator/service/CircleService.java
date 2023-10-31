package com.example.circle_calculator.service;

public class CircleService {

    public double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
