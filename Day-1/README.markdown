# 📊 Java Console Calculator – Day 1  
**Elevate Labs Java Developer Internship – Task 1**  
_Repository: `ELEVATELABS-JAVAINTERNSHIP-UTKARSH/Day-1`_

A robust and user-friendly **Java console calculator application** developed as **Task 1** for the **Elevate Labs** internship. This project showcases fundamental Java principles, including **static methods**, **exception handling**, **input validation**, and **interactive looping**, adhering to professional software development practices.

---

## 🎯 Task Objective

Create a Java console calculator that:
- Accepts two integer inputs.
- Supports basic arithmetic operations (`+`, `-`, `*`, `/`).
- Displays results or relevant error messages.
- Runs in a loop until the user opts to exit.

---

## 📁 Repository Structure

```
ELEVATELABS-JAVAINTERNSHIP-UTKARSH/
└── Day-1/
    ├── .gitignore          # Excludes .class files
    ├── Calculator.java     # Main source code
    └── README.md           # Project documentation
```

> **Note:** `.class` files are excluded from version control via `.gitignore` to ensure only source files are tracked.

---

## 🛠️ Technologies Used

- **Java**: JDK 17+
- **IDE**: VS Code 
- **Environment**: Console/Terminal
- **Tools**: `javac`, `java` CLI

---

## ✅ Edge Case Handling

| Scenario                    | Status | Handling Mechanism                          |
|-----------------------------|--------|---------------------------------------------|
| Non-integer input           | ✅     | `InputMismatchException` with retry prompt  |
| Division by zero            | ✅     | Custom error message, skips computation     |
| Invalid operator            | ✅     | Error message with loop continuation        |
| Input buffer issues         | ✅     | `sc.nextLine()` for cleanup                 |
| Continuous operation        | ✅     | Loop persists until user exit               |
| Modular code structure      | ✅     | Logic encapsulated in `CalcFxn` class       |

---

## 🚀 Getting Started

1. Clone the repository and navigate to the `Day-1` folder:
   ```bash
   cd ELEVATELABS-JAVAINTERNSHIP-UTKARSH/Day-1
   ```
2. Compile the source code:
   ```bash
   javac Calculator.java
   ```
3. Run the application:
   ```bash
   java Calculator
   ```

---

## ✨ Features

- **Modular Design**: Logic separated into `CalcFxn` class for maintainability.
- **Robust Validation**: Handles invalid inputs gracefully.
- **User-Friendly**: Clear console prompts and error messages.
- **Well-Documented**: Clean, commented code for readability.
- **Reusable**: Easily extensible for additional functionality.

---

## 🧠 Key Java Concepts Demonstrated

- Static methods and class organization
- `Scanner` for user input
- Exception handling with `try-catch`
- Looping with `do-while`
- Conditional logic via `switch-case`
- Division-by-zero edge case management
- Java platform independence

---

## 📋 Task Requirements Checklist

| Requirement                     | Status |
|---------------------------------|--------|
| Console-based calculator        | ✅     |
| Input/output handling           | ✅     |
| Edge case management            | ✅     |
| User-defined methods            | ✅     |
| GitHub repository setup         | ✅     |
| `.gitignore` configuration      | ✅     |
| `.class` files excluded         | ✅     |
| Comprehensive README            | ✅     |

---

## 👨‍💻 Author

**Utkarsh Dubey**  
Java Developer Intern – Elevate Labs  
🔗 [GitHub](https://github.com/iuttkarshh0409) | [LinkedIn](https://www.linkedin.com/in/utkarsh-dubey-227098352/)

---

## 📄 License

This project is open for educational use under the **Elevate Labs Internship guidelines**. Reuse or fork with proper attribution.

---

✅ **Day 1 Task Completed**  
📅 **Submission Date**: June 23, 2025