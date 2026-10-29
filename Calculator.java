import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult = 0.0;
        boolean keepRunning = true;

        System.out.println("=== CLI Calculator - SPRINT 1 ===");
        System.out.println("Type 'exit' to quit, 'ans' to use the last result.");

        while (keepRunning) {
            System.out.print("\nEnter first operand (number, 'ans' or 'exit'): ");
            String input1 = scanner.next();

            // Check to exit the program
            if (input1.equalsIgnoreCase("exit") || input1.equalsIgnoreCase("quit")) {
                keepRunning = false;
                break;
            }

            // First operand handling
            double op1 = 0.0;
            if (input1.equalsIgnoreCase("ans")) {
                op1 = lastResult;
            } else {
                try {
                    op1 = Double.parseDouble(input1);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number.");
                    continue; // Restart the loop
                }
            }

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Enter second operand (number or 'ans'): ");
            String input2 = scanner.next();
            
            // Second operand handling
            double op2 = 0.0;
            if (input2.equalsIgnoreCase("ans")) {
                op2 = lastResult;
            } else {
                try {
                    op2 = Double.parseDouble(input2);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number.");
                    continue; // Restart the loop
                }
            }

            // Calculate result
            double result = 0.0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = op1 / op2;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    validOperation = false;
            }

            // If the operation was successful, print and save the result
            if (validOperation) {
                System.out.println("Result: " + result);
                lastResult = result;
            }
        }
        
        scanner.close();
        System.out.println("Calculator terminated.");
    }
}
