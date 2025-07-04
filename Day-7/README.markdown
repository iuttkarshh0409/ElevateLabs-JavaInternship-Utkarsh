# 👷 Employee Management Application

A command-line based **Employee Management Application** built in **Java** using **JDBC** to interact with a **MySQL** database. This application allows users to manage employee records by adding, viewing, updating, and deleting entries. Developed as part of the **Elevate Labs Java Developer Internship** to practice database connectivity and CRUD operations.

---

## 💻 Features

- ✅ **Add Employee**: Insert new employee records with name, email, and salary.
- ✅ **View Employees**: Display all employee records in a formatted list.
- ✅ **Update Employee**: Modify existing employee details (name, email, salary) by ID with confirmation.
- ✅ **Delete Employee**: Remove employee records by ID with confirmation.
- ✅ **Interactive Menu**: Menu-driven interface with input validation and continue/exit options.
- ✅ **Graceful Exit**: Closes database connection and terminates with a thank-you message.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **IDE**: Visual Studio Code
- **Interface**: Terminal (Command Line Interface)
- **Database**: MySQL (JDBC connectivity)
- **Key Libraries**: `java.sql` for JDBC operations, `java.util.Scanner` for user input
- **Exception Handling**: `SQLException` for database errors, `NumberFormatException` for invalid inputs

---

## 📂 Project Structure

```
EmployeeDBApp
├── EmployeeDBApp.java  # Main Java application with database logic
└── README.md           # Project documentation
```

### 📌 Database Setup
- **Database Name**: `employeedb`
- **Table Name**: `employees`
- **Table Schema**:
  ```sql
  CREATE DATABASE employeedb;
  USE employeedb;
  CREATE TABLE employees (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL,
      salary DOUBLE NOT NULL
  );
  ```
- **Connection Details**:
  - URL: `jdbc:mysql://localhost:1234/employeedb`  #hardcoded due to security reasons
  - User: `sampleUsername`  #hardcoded due to security reasons
  - Password: `samplePassword`  #hardcoded due to security reasons

---

## 🔍 How It Works

- **Database Connection**: Establishes a connection to the MySQL database using JDBC.
- **Add Employee**: Prompts for name, email (Gmail format), and salary, then inserts into the `employees` table.
- **View Employees**: Retrieves and displays all records from the `employees` table, sorted by ID.
- **Update Employee**: Prompts for an ID, displays current details, confirms update, and modifies the record.
- **Delete Employee**: Prompts for an ID, displays details, confirms deletion, and removes the record.
- **Menu Interaction**: Provides a numbered menu (1–5) with input validation and a continue prompt (Y/N).
- **Input Validation**: Ensures valid names (alphabets only), emails (Gmail format), salaries (positive numbers), and IDs (positive integers).

---

## ✅ Key Features & Improvements

| Feature/Improvement            | Description                                              |
|-------------------------------|----------------------------------------------------------|
| Input Validation              | Validates names, emails, salaries, and IDs                |
| Email Format Check            | Enforces `username@gmail.com` format                     |
| Confirmation Prompts          | Requires confirmation (Y/N) for updates and deletions     |
| Error Handling                | Handles SQL and input errors with meaningful messages    |
| Database Connection           | Secure connection with graceful closure                  |
| Formatted Output              | Displays employee records in a clear, tabular format      |
| Continue Prompt               | Allows users to continue or exit after each action       |

---

## 🚀 Sample Execution

```
|------            Welcome to Employee Management Application            -----|

Application Menu:
[1] Add an Employee
[2] View Employees
[3] Update an Employee
[4] Delete an Employee
[5] Exit

>> Enter your choice: 1

>> Enter Employee Name: Utkarsh Dubey
>> Enter Email: dubeyutkarsh101@gmail.com@gmail.com
>> Enter Salary: 373328

>>> Employee added successfully!

Do you want to continue using the application? (y/n): y

>> Enter your choice: 2

---------------------------------------------------
|                   Employee Records              |
---------------------------------------------------
ID: 1 | Name: Utkarsh Dubey | Email: dubeyutkarsh101@gmail.com | Salary: INR 3,73,328.00
```

---

## 📎 Concepts Practiced

- **Database Connectivity**: JDBC for connecting to MySQL and performing CRUD operations.
- **SQL Queries**: Using `PreparedStatement` for secure query execution and `Statement` for simple queries.
- **Input Validation**: Ensuring valid inputs for names, emails, salaries, and IDs using regex and checks.
- **Exception Handling**: Managing `SQLException` and `NumberFormatException` for robust error handling.
- **User Interaction**: `Scanner` for command-line input with a menu-driven interface.
- **Defensive Programming**: Validation for empty inputs, invalid formats, and non-existent IDs.

---

## 🔐 Edge Case Handling

| Case                              | Behavior                                              |
|-----------------------------------|-------------------------------------------------------|
| Empty name input                  | Rejected with "Name cannot be blank"                  |
| Invalid name (non-alphabetic)     | Rejected with "Name must contain only alphabets"      |
| Empty or invalid email            | Rejected with Gmail format requirement                |
| Non-positive or invalid salary     | Rejected with "Salary must be a positive number"      |
| Non-positive or invalid ID        | Rejected with "ID must be a positive integer"         |
| Non-existent ID for update/delete | Rejected with "No employee found with the given ID"   |
| Invalid menu option (not 1–5)     | Rejected with "Please enter a number from 1 to 5"     |
| Database connection failure       | Exits with error message and stack trace             |

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: utkarsh0907.edu@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.