package ru.lesson5;

public class Math {
    public static double root(double input) {
        if(input < 0) {
            throw new ArithmeticException();
        } else {
            return java.lang.Math.sqrt(input);
        }
    }

    public static double square(double input) {
        return java.lang.Math.pow(input, 2);
    }

    public static double cos(double input) {
        return java.lang.Math.cos(input);
    }

    public static int factorial(int input) {
        if (input >= 0) {
            if (input == 0) {
                return 0;
            } else {
                int result = 1;
                for (int i = 0; i < input; i++) {
                    result *= i + 1;
                }
                return result;
            }
        } else {
            throw new ArithmeticException();
        }
    }

    public static int factorialRec(int input) {
        if(input < 0) {
            throw new ArithmeticException();
        }
        if(input == 0) {
            return 0;
        }
        if (input == 1)
            return 1;
        else {
            return input * factorialRec(input - 1);
        }
    }

    public static void main(String args[]) {
        System.out.println("Hello world!");
    }
}
