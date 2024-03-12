import java.util.Scanner;

public class CommandLineCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean exit = false;
        
        System.out.println("Welcome to Command Line Calculator!");
        System.out.println("Enter 'exit' to quit the calculator.");

        while (!exit) {
            System.out.print("Enter expression (e.g., 5 + 3): ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                exit = true;
                break;
            }
            
            try {
                result = evaluateExpression(input);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("Exiting calculator. Goodbye!");
        scanner.close();
    }

    private static double evaluateExpression(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid expression format. Please use format: operand1 operator operand2");
        }

        double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator. Supported operators are +, -, *, and /");
        }
    }
}
