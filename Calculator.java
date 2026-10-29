import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult = 0.0;
        boolean keepRunning = true;

        System.out.println("=== CLI Calculator - SPRINT 2 ===");
        System.out.println("Special commands:");
        System.out.println(" - 'ans': uses the previous result as operand");
        System.out.println(" - 'clear' or 'c': resets accumulator and last result to 0.0");
        System.out.println(" - 'sqrt': computes square root (unary operation)");
        System.out.println(" - '^': computes power (base and exponent)");
        System.out.println(" - 'exit': terminates the program");

        while (keepRunning) {
            System.out.print("\nEnter first operand (number, 'ans', 'clear', or 'exit'): ");
            String input1 = scanner.next();

            // Program exit check
            if (input1.equalsIgnoreCase("exit")) {
                keepRunning = false;
                break;
            }

            // US05: Calculation reset
            if (input1.equalsIgnoreCase("clear") || input1.equalsIgnoreCase("c")) {
                lastResult = 0.0;
                System.out.println("State reset. Last result set back to 0.0.");
                continue;
            }

            // Parsing first operand
            double op1 = 0.0;
            if (input1.equalsIgnoreCase("ans")) {
                op1 = lastResult;
            } else {
                try {
                    op1 = Double.parseDouble(input1);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid real number or recognized command.");
                    continue;
                }
            }

            System.out.print("Enter operator (+, -, *, /, ^, sqrt): ");
            String operator = scanner.next();

            double result = 0.0;
            boolean validOperation = true;

            // US07: Unary operator branch (square root)
            if (operator.equalsIgnoreCase("sqrt")) {
                if (op1 < 0) {
                    System.out.println("Mathematical Error: Cannot calculate square root of a negative number.");
                    validOperation = false;
                } else {
                    result = Math.sqrt(op1);
                }
            } else {
                // Binary operators requiring a second operand
                System.out.print("Enter second operand (number or 'ans'): ");
                String input2 = scanner.next();

                double op2 = 0.0;
                if (input2.equalsIgnoreCase("ans")) {
                    op2 = lastResult;
                } else {
                    try {
                        op2 = Double.parseDouble(input2);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid second operand.");
                        continue;
                    }
                }

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
                    case "^":
                        // US07: Power
                        result = Math.pow(op1, op2);
                        if (Double.isNaN(result) || Double.isInfinite(result)) {
                            System.out.println("Mathematical Error: Power result is undefined or infinite.");
                            validOperation = false;
                        }
                        break;
                    default:
                        System.out.println("Error: Unsupported operator.");
                        validOperation = false;
                }
            }

            // If calculation succeeded, display and update accumulator state
            if (validOperation) {
                System.out.println("Result: " + result);
                lastResult = result;
            }
        }

        scanner.close();
        System.out.println("Calculator terminated.");
    }
}