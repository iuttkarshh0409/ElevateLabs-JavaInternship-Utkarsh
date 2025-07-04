import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String USER = "root";
    private static final String PASS = "Raam@12345";

    private Connection conn;
    private final Scanner sc;

    public EmployeeDBApp() {
        sc = new Scanner(System.in);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("\nConnected to MySQL database successfully.\n");
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to database!!\nExiting...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void printHeader() {
        System.out.println("|------            Welcome to Employee Management Application            -----|");
    }

    private void printMenu() {
        System.out.println("\nApplication Menu:");
        System.out.println("[1] Add an Employee");
        System.out.println("[2] View Employees");
        System.out.println("[3] Update an Employee");
        System.out.println("[4] Delete an Employee");
        System.out.println("[5] Exit");
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void addEmployee() {
        try {
            String name = getValidName();
            String email = getValidEmail();
            double salary = getValidSalary();

            String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setDouble(3, salary);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0
                ? "\n>>> Employee added successfully!"
                : "\n>>> Error: Failed to add employee!!");
        } catch (SQLException e) {
            System.out.println("\n>>> Error while adding employee!!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void viewEmployees() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("|                   Employee Records              |");
        System.out.println("---------------------------------------------------");

        String sql = "SELECT * FROM employees ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");

                System.out.printf("ID: %d | Name: %s | Email: %s | Salary: INR %,.2f%n", id, name, email, salary);
            }
            if (!hasRecords) {
                System.out.println("Error: No employees' records found!!");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving employee records!!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void updateEmployee() {
        try {
            int id = getValidId("\n>> Enter Employee ID to update: ");

            String checkSql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("\n>>> Error: No employee found with the given ID!!");
                return;
            }
            // Get current values
            String currentName = rs.getString("name");
            String currentEmail = rs.getString("email");
            double currentSalary = rs.getDouble("salary");

            System.out.println("\n-- Current details of Employee ID " + id + " --");
            System.out.printf("ID: %d | Name: %s | Email: %s | Salary: INR %,.2f%n", id, currentName, currentEmail, currentSalary);

            System.out.print("\nAre you sure you want to update this employees' records? (y/n): ");
            String confirm = sc.nextLine().trim().toLowerCase();
            if (!confirm.equals("y")) {
               System.out.println(">>> Updation aborted!");
               return;
        }

            System.out.println("\n-- Enter updated details for Employee ID " + id + " --");
            String name = getValidName();
            String email = getValidEmail();
            double salary = getValidSalary();

            String updateSql = "UPDATE employees SET name = ?, email = ?, salary = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, name);
            updateStmt.setString(2, email);
            updateStmt.setDouble(3, salary);
            updateStmt.setInt(4, id);

            int rows = updateStmt.executeUpdate();
            System.out.println(rows > 0
                ? "\n>>> Employee updated successfully."
                : "\n>>> Error: Failed to update employee!!");
        } catch (SQLException e) {
            System.out.println("\n>>> Error while updating employee!!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
public void deleteEmployee() {
    try {
        int id = getValidId("\n>> Enter Employee ID to delete: ");

        
        String checkSql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setInt(1, id);
        ResultSet rs = checkStmt.executeQuery();

        if (!rs.next()) {
            System.out.println("\n>>> Error: No employee found with the given ID!!");
            return;
        }

        String name = rs.getString("name");
        String email = rs.getString("email");
        double salary = rs.getDouble("salary");

        System.out.println("\n-- Details of Employee ID " + id + " --");
        System.out.printf("ID: %d | Name: %s | Email: %s | Salary: INR %,.2f%n", id, name, email, salary);

        System.out.print("\nAre you sure you want to delete this employees' records? (y/n): ");
        String confirm = sc.nextLine().trim().toLowerCase();
        if (!confirm.equals("y")) {
            System.out.println(">>> Deletion aborted!");
            return;
        }

        // Proceed with deletion
        String deleteSql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
        deleteStmt.setInt(1, id);

        int rows = deleteStmt.executeUpdate();
        System.out.println(rows > 0
            ? "\n>>> Employee deleted successfully."
            : "\n>>> Error: Could not delete employee!!");
    } catch (SQLException e) {
        System.out.println("\n>>> Error while deleting employee!!");
        e.printStackTrace();
    }
}


    private String getValidName() {
        while (true) {
            System.out.print("\n>> Enter Employee Name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be blank!!");
            } else if (!name.matches("^[A-Za-z ]+$")) {
                System.out.println("Error: Name must contain only alphabets and spaces!!");
            } else {
                return name;
            }
        }
    }

    private String getValidEmail() {
        while (true) {
            System.out.print(">> Enter Email: ");
            String email = sc.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Error: Email cannot be blank!!");
            } else if (!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {
                System.out.println("Error: Invalid email!!\nNote: Format must be username@gmail.com.");
            } else {
                return email;
            }
        }
    }

    private double getValidSalary() {
        while (true) {
            System.out.print(">> Enter Salary: ");
            String salaryInput = sc.nextLine().trim();

            if (salaryInput.isEmpty()) {
            System.out.println("Error: Salary cannot be blank!!");
            continue;
        }


            try {
                double salary = Double.parseDouble(salaryInput);
                if (salary <= 0) {
                    System.out.println("Error: Salary must be a non-zero positive number!!");
                } else {
                    return salary;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric salary!!");
            }
        }
    }

    private int getValidId(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
            System.out.println("Error: ID cannot be blank!!");
            continue;
        }
            try {
                int id = Integer.parseInt(input);
                if (id <= 0) {
                    System.out.println("Error: ID must be a positive integer!!");
                } else {
                    return id;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric ID!!");
            }
        }
    }

    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    public void runApp() {
        connect();
        boolean continueApp = true;

        while (continueApp) {
            printHeader();
            printMenu();

            int choice = getValidId("\n>> Enter your choice: ");
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> {
                    System.out.println("\nThank you for using Employee Management Application.\nPlease visit Again!\nExiting the application...");
                    continueApp = false;
                }
                default -> System.out.println("Error: Invalid input!\nNote: Please enter a number from 1 to 5.");
            }

            if (continueApp) {
                System.out.print("\nDo you want to continue using the application? (y/n): ");
                String again = sc.nextLine().trim().toLowerCase();
                if (!again.equals("y")) {
                    System.out.println("\nThank you for using Employee Management Application.\nPlease visit Again!\nExiting the application...");
                    continueApp = false;
                }
            }
        }

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection!!");
            e.printStackTrace();
        }

        sc.close();
    }

    public static void main(String[] args) {
        EmployeeDBApp app = new EmployeeDBApp();
        app.runApp();
    }
}
