package org.example.test;

public class EvenAndOddNumbers {
    public boolean isEven(int a) {
        if(a % 2 == 0) {
            return true;
        }
        return false;
    }
    public boolean isOdd(int a) {
        if(a % 2 == 1) {
            return true;
        }
        return false;
    }

    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }
}
