# 🧾 Student Record Management System – Day 2
**Elevate Labs Java Developer Internship – Task 2**  
**Repository**: [ElevateLabs-JavaInternship-Utkarsh](https://github.com/ElevateLabs-JavaInternship-Utkarsh)

A modular, console-based Java application for managing student records. Developed as Task 2 for the Elevate Labs internship, this project demonstrates object-oriented programming, dynamic data structures, menu-driven CLI interaction, and robust input validation.

## 🎯 Task Objective
Design a Java application that:
- Accepts and stores student details (ID, Name, Marks).
- Allows the user to add, view, update, and delete student records.
- Supports ID-based operations with basic validation checks.
- Operates in a loop until the user opts to exit.

## 📁 Repository Structure
```
ELEVATELABS-JAVAINTERNSHIP-UTKARSH/
└── Day-2/
    ├── .gitignore                   # Excludes .class files
    ├── StudentManagementSystem.java # Main source code
    └── README.md                    # Project documentation
```
`.class` files are excluded using `.gitignore` to keep the repository clean and source-only.

## 🛠️ Technologies Used
- **Java**: JDK 17+
- **IDE**: VS Code
- **Environment**: Console/Terminal
- **Tools**: `javac`, `java` CLI

## ✅ Feature & Validation Table
| Feature                     | Status | Implementation Details                     |
|-----------------------------|--------|--------------------------------------------|
| Add a student               | ✅     | ID uniqueness & input validation           |
| View all students           | ✅     | Sorted by ID (ascending)                  |
| Update existing student     | ✅     | Partial update (name/marks)                |
| Delete student by ID        | ✅     | Checks ID existence                       |
| Alphabetic name validation  | ✅     | Rejects numeric names                     |
| Marks input validation      | ✅     | Restricts to integers                     |
| Looping for continuous use  | ✅     | Normalized (Y/N) check                    |
| Exit with closing message   | ✅     | Graceful shutdown                         |
| Robust error messages       | ✅     | User guidance provided                    |
| Dynamic list handling       | ✅     | Via `ArrayList<Student>`                  |

## 🚀 Getting Started
1. Clone the repository and navigate to the `Day-2` folder:
   ```bash
   cd ELEVATELABS-JAVAINTERNSHIP-UTKARSH/Day-2
   ```
2. Compile the source code:
   ```bash
   javac StudentManagementSystem.java
   ```
3. Run the application:
   ```bash
   java StudentManagementSystem
   ```

## ✨ Features
- **Encapsulated Design**: `Student` class with private fields and public accessors.
- **Sorted Output**: Records displayed in ascending order of ID.
- **Error Handling**: Graceful recovery from invalid or duplicate inputs.
- **Interactive UI**: Clear CLI menu and input prompts.
- **Scalable**: Easy to extend with additional features (like search/filter).

## 🧠 Key Java Concepts Demonstrated
- Object-Oriented Programming (class, encapsulation)
- `ArrayList` for dynamic storage
- `Scanner` for user input handling
- Validation & Regex for name checking
- Looping & branching (`do-while`, `switch-case`)
- Graceful shutdown and `Scanner` closure

## 📋 Task Requirements Checklist
| Requirement                              | Status |
|------------------------------------------|--------|
| Student class with encapsulated fields   | ✅     |
| Menu-based options for CRUD operations   | ✅     |
| Validations for ID, name, and marks      | ✅     |
| Sorted display of student list           | ✅     |
| `.gitignore` and clean repo setup        | ✅     |
| Comprehensive README documentation       | ✅     |

## 👨‍💻 Author
**Utkarsh Dubey**  
Java Developer Intern – Elevate Labs  
🔗 [GitHub](https://github.com/utkarsh-dubey) | [LinkedIn](https://linkedin.com/in/utkarsh-dubey)

## 📄 License
This project is shared for academic and training use under the Elevate Labs Internship guidelines. Reuse is permitted with proper credit.

## ✅ Day 2 Task Completed
**📅 Submission Date**: June 25, 2025