import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter and Setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char choice;
        String option;

        System.out.println("\n----  Student Record Management System Application  ----");

        do {
            System.out.println("\nApplication Menu:");
            System.out.println("1. Add a Student");
            System.out.println("2. View the Students list");
            System.out.println("3. Update a Student");
            System.out.println("4. Delete a Student");
            System.out.println("5. Exit the Application");
            System.out.println("\nPlease select an option from the Menu!");
            System.out.print("Enter your choice: ");

            choice = sc.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    addStudent();
                    break;
                case '2':
                    viewStudents();
                    break;
                case '3':
                    updateStudent();
                    break;
                case '4':
                    deleteStudent();
                    break;
                case '5':
                    exitApp();
                    return; 
                default:
                    System.out.println("Error: Invalid choice!\nNote: Please enter 1-5 as the initial input.");
            }

            // Ask to continue only if user didn’t choose Exit (i.e., case '5')
            System.out.print("\nDo you want to continue using the Application? (Y/N): ");
            option = sc.nextLine().trim().toLowerCase();

        } while (option.equals("y"));

        exitApp(); 
    }

    static void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (findStudentById(id) != null) {
                System.out.println("Error: Student with this ID already exists in the System!\nNote: Please input another ID or modify the existing one.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            if (name.isBlank() || !name.matches("^[a-zA-Z ]+$")) {
                System.out.println("Error: Name must contain alphabetic characters only!\nNote: Enter only alphabets and spaces as input for the name.");
                return;
            }

            System.out.print("Enter student marks (out of 100): ");
            int marks = Integer.parseInt(sc.nextLine());

            students.add(new Student(id, name, marks));
            System.out.println("Student added successfully to the System!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input format!\nNote: Please enter valid integers for ID and marks.");
        }
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("Error: No student records found!\nNote: Please enter at least one student record to view the List.");
            return;
        }

        Collections.sort(students, Comparator.comparingInt(Student::getId));

        System.out.println("\nList of Students (Sorted by ID):");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void updateStudent() {
        try {
            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(sc.nextLine());

            Student s = findStudentById(id);
            if (s == null) {
                System.out.println("Error: Student with ID " + id + " not found.\nNote: Please double-check your input");
                return;
            }

            System.out.print("Enter new name (leave blank to keep unchanged): ");
            String newName = sc.nextLine();
            if (!newName.isBlank()) {
                s.setName(newName);
            }

            System.out.print("Enter new marks (Enter -1 to keep unchanged): ");
            int newMarks = Integer.parseInt(sc.nextLine());
            if (newMarks >= 0) {
                s.setMarks(newMarks);
            }

            System.out.println("Success: Student record updated in the System!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!\nNote: Please enter valid integers in the input.");
        }
    }

    static void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());

            Student s = findStudentById(id);
            if (s == null) {
                System.out.println("Error: Student with ID " + id + " not found!\nNote: double-check your input.");
                return;
            }

            students.remove(s);
            System.out.println("Success: Student record deleted from the System.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!\nNote: Please enter a valid integer in input for ID.");
        }
    }

    static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    static void exitApp() {
        System.out.print("\nThank you for using Student Management System Application");
        System.out.print("\nPlease visit again!");
        System.out.print("\n\nExiting the application...");
        sc.close();
    }
}
