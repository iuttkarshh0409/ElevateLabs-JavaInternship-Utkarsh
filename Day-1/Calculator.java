import java.util.*;

class CalcFxn {
    static int a, b;

    public static int add() {
        return a + b;
    }

    public static int subtract() {
        return a - b;
    }

    public static int product() {
        return a * b;
    }

    public static double division() {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.\nNote: Please enter a non-zero divisor.");
        }
        return (double) a / b;
    }
}

class Calculator extends CalcFxn {
    public static void main(String[] args) {
        char option = ' ';
        char choice = ' ';
        Scanner sc = new Scanner(System.in);

        System.out.println("----Welcome to Calculator Application----\n");

        do {
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println();
                    System.out.println("Please enter two numbers to access Calculator Menu...\n");

                    System.out.print("Enter first number: ");
                    a = sc.nextInt();

                    System.out.print("Enter second number: ");
                    b = sc.nextInt();

                    validInput = true; 
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input!\nNote: Please retry with only integer as input(s) again.");
                    sc.nextLine(); // 
                }
            }

            System.out.println("\n---Calculator Menu---\n");
            System.out.println("Press + for Addition");
            System.out.println("Press - for Subtraction");
            System.out.println("Press * for Product");
            System.out.println("Press / for Division");

            try {
                sc.nextLine(); 
                System.out.print("\nEnter your choice: ");
                option = sc.nextLine().charAt(0);
            } catch (Exception e) {
                System.out.println("Invalid operator input!");
                continue;
            }

            System.out.println();

            switch (option) {
                case '+':
                    System.out.println("Result of Addition: " + add());
                    break;
                case '-':
                    System.out.println("Result of Subtraction: " + subtract());
                    break;
                case '*':
                    System.out.println("Result of Product: " + product());
                    break;
                case '/':
                    if (b != 0) {
                        System.out.println("Result of Division: " + division());
                    } else {
                        division(); 
                    }
                    break;
                default:
                    System.out.println("Error: Invalid input of operator!\nNote: Please try +, -, *, or /.");
            }

            System.out.println();
            System.out.print("Do you want to use the Application again? (Y/N): ");
            choice = sc.nextLine().charAt(0);

        } while (choice == 'Y' || choice == 'y');

        System.out.println("\n----Thank You for using Calculator Application----");
        System.out.println("Exiting the program...");
        sc.close();
    }
}
