package org.example.verizon;

// Write a java program to take 2 numbers as input,
// Add these 2 numbers if both are even or odd. If not throw an error.
// Use Run time polymorphism to define an interface and method overriding

// 1 = even
// 0 = odd


//Write a java method to implement this formula on a given list (a,b) => a+b
//Example input: List(4,3,5,6,7) expected output: List(7,8,11,13)


//Write a java method to convert any java data objects into Map[Key, Value]
//You can use Lambdas to pass the tranformation logic


public class AddEvenOrOddNumbers {
    public static void main(String[] args) throws Exception {
        int num1 = 10;
        int num2 = 12;

        int result = isEvenOrOdd(num1, num2);
        System.out.println(result);

    }

    public static int isEvenOrOdd(int num1, int num2) throws Exception {
        if((num1 % 2 == 0 && num2 % 2 == 0) || (num1 % 2 == 1 && num2 % 2 == 1)) {
            return num1 + num2;
        }
        else  {
            throw new Exception("Cannot add values");
        }
    }
}
