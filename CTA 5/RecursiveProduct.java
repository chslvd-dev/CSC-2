/**
 * RecursiveProduct.java
 * Reads 5 numbers from the user, then returns their product
 * using recursive methods for both input and multiplication.
 *
 * Critical Thinking Assignment, Module 5
 * Chris Jayson Salvadora
 */
import java.util.Scanner;

public class RecursiveProduct {

    private static final int COUNT = 5;

    // Recursively fills the array, 1 number per call
    public static void readNumbers(Scanner input, double[] numbers, int index) {
        if (index == numbers.length) {          // Base case: all 5 numbers entered
            return;
        }
        System.out.print("Enter number " + (index + 1) + ": ");
        while (!input.hasNextDouble()) {        // Reject non-numeric input
            System.out.print("Invalid. Enter a number: ");
            input.next();
        }
        numbers[index] = input.nextDouble();
        readNumbers(input, numbers, index + 1); // Recursive case: next position
    }

    // Recursively multiplies the numbers from index to the end
    public static double product(double[] numbers, int index) {
        if (index == numbers.length) {          // Base case: no numbers left
            return 1;
        }
        return numbers[index] * product(numbers, index + 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[COUNT];

        readNumbers(input, numbers, 0);
        System.out.println("Product of the 5 numbers: " + product(numbers, 0));

        input.close();
    }
}
