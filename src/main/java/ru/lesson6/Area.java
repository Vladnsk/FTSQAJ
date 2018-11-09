package ru.lesson6;

import java.util.Scanner;

public class Area {
    public static double areaOfSquare(double side) {
        if(side <= 0) {
            throw new ArithmeticException();
        } else {
            return side * side;
        }
    }

    public static double areaOfTriangle(double base, double height) {
        if(base <= 0 || height <= 0) {
            throw new ArithmeticException();
        } else {
            return 0.5 * base * height;
        }
    }

    public static double areaOfCircle(double radius) {
        if(radius <= 0) {
            throw new ArithmeticException();
        } else {
            return Math.PI * radius * radius;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Radius? ");
        System.out.println("Result = " + areaOfCircle(scanner.nextDouble()));
    }
}
