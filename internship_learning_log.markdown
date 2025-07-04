# 📘 ElevateLabs Java Internship: Learning Log

## 🗓️ Daily Log

### ✅ Day 1: Java Fundamentals
**Date:** 23/04/2025  
**Task:** Build a basic Java program (e.g., calculator/string manipulations)  
**Concepts Practiced:**
- Java syntax and structure
- Data types, variables
- Loops and conditional statements
- Functions and method calls

**Key Learnings:**
- Refreshed Java basics with `if-else`, `switch`, and `for`/`while` loops
- Understood static methods and function calling inside `main()`

**Challenges:**
- Initially struggled with understanding parameter passing
- Took time to align logic in a clean and readable format

**Outcome:**
- Created a working CLI-based calculator/string tool
- Gained confidence in Java syntax and control flow

---

### ✅ Day 2: Java Strings & Loops
**Date:** 24/06/2025  
**Task:** String palindrome, reverse, character count

**Concepts Practiced:**
- Java `String` and `StringBuilder` classes
- `.equals()`, `.charAt()`, `.length()` methods
- For loops and enhanced `for-each`

**Key Learnings:**
- Difference between `==` and `.equals()` for string comparison
- Efficient string reversal using `StringBuilder`
- Explored input validation and edge case handling

**Challenges:**
- Managed character-indexing bugs during loop

**Outcome:**
- Developed robust string logic functions
- Built confidence in string manipulation techniques

---

### ✅ Day 3: OOP & Library Management System
**Date:** 26/06/2025  
**Task:** Build a Library Management System using Java OOP

**Concepts Practiced:**
- Classes and objects
- Encapsulation, method overriding
- ArrayLists and basic CRUD operations

**Key Learnings:**
- Clean object-oriented design via `Book`, `User`, and `Library` classes
- Validated inputs (duplicate ISBN/user ID)
- Mastered array-based operations (add, update, view)

**Challenges:**
- Managing `Scanner` input mixing (`nextLine()` issues)
- Designing `issueBook()` and `returnBook()` logic cleanly

**Outcome:**
- Created a fully functional library system
- Emphasized clarity, feedback messages, and edge case coverage

---

### ✅ Day 4: File I/O – Notes Management App
**Date:** 27/06/2025  
**Task:** CLI Notes App using `FileReader`/`FileWriter`

**Concepts Practiced:**
- File handling in Java
- `try-with-resources`
- Reading/writing lists with `Files.readAllLines` & `Files.write`
- Exception handling

**Key Learnings:**
- Implemented persistent note storage with append/overwrite modes
- Understood how to use `FileWriter` safely with auto-close
- Managed updates and deletions from text files

**Challenges:**
- Handling `Scanner` nextLine bugs across loops
- Designing an interactive CLI for consistent UX

**Outcome:**
- Finalized a working CRUD Notes App
- Achieved full understanding of basic Java file operations

---

### ✅ Day 5: Bank Management System
**Date:** 30/06/2025  
**Task:** Simulate banking operations using Java OOP

**Concepts Practiced:**
- Class design (`Account` class)
- Deposit, withdrawal, balance tracking
- Maintaining transaction history via `ArrayList`

**Key Learnings:**
- Simulated real-life logic using methods and object states
- Implemented checks (e.g., insufficient funds)
- Designed clean CLI interaction with dynamic data storage

**Challenges:**
- Designing input-driven transaction system
- Edge case handling: invalid amount, duplicate accounts

**Outcome:**
- Developed reusable methods for account operations
- Strong grip on OOP logic mimicking real-world use cases

---

### ✅ Day 6: GUI To-Do App (Swing Basics)
**Date:** 01/07/2025  
**Task:** Create a GUI-based To-Do App using Java Swing

**Concepts Practiced:**
- Java Swing (`JFrame`, `JPanel`, `JButton`, `JTextField`)
- Action listeners and layout managers
- UI event handling

**Key Learnings:**
- GUI design using component-based layout
- Handling user events cleanly via lambda expressions
- Improved app responsiveness and component styling

**Challenges:**
- Managing layout alignment and resizing
- Preventing duplicate/blank entries

**Outcome:**
- Built an interactive to-do GUI application
- Gained confidence in Java’s AWT/Swing toolkit

---

### ✅ Day 7: JDBC Employee Database App
**Date:** 02/07/2025  
**Task:** CLI-based CRUD on Employee records using JDBC + MySQL

**Concepts Practiced:**
- JDBC setup and connection via `Connection`, `PreparedStatement`
- SQL operations: INSERT, SELECT, UPDATE, DELETE
- Exception and SQL error handling

**Key Learnings:**
- Integrated MySQL with Java backend
- Used prepared statements to avoid SQL injection
- Designed a modular CLI app for database operations

**Challenges:**
- Initial JDBC setup with MySQL Workbench
- Data consistency and primary key validation

**Outcome:**
- Full CRUD database app working via CLI
- Real-world feel of DB-backed app development

---

### ✅ Day 8: Smart Java Quiz App
**Date:** 04/07/2025  
**Task:** Build an interactive CLI-based Quiz App with enhanced features

**Concepts Practiced:**
- Advanced OOP (`Question` class, encapsulated fields)
- List randomization, retry logic, and input validation
- UX enhancement: colored outputs, retry options, answer feedback

**Key Learnings:**
- Used `Collections.shuffle()` for randomized question order
- Added detailed scoring logic (+1/-1) and feedback
- Showed correct answer on wrong attempts, improved retry UX

**Enhancements Implemented:**
- Show correct answer after incorrect submission
- Retry option if score ≤ 4
- Shuffled question order on retry
- Modular feedback using `showAnalysis()`

**Outcome:**
- Completed submission-ready, real-world quiz app
- Delivered well-commented, GitHub-pushed codebase
- Improved CLI UI/UX for educational tools

---

## 📅 Weekly Reflection (Week 1: 23/06/2025–29/06/2025)

**Overall Progress:**
- Gained strong grasp over Java basics, OOP, and file handling
- Transitioned smoothly from core Java to intermediate CLI applications
- Practiced clean code structure, exception handling, and user interaction

**New Tools/Concepts Explored:**
- Java File I/O (`FileWriter`, `Files` API)
- Encapsulation in class design
- Edge case validation

**What Went Well:**
- Each task reinforced a core concept with practical use
- GitHub repo is clean and well-structured per-day

**Areas for Improvement:**
- Avoid `Scanner` closing inside methods (causes input loss)
- Aim to modularize logic early (separate UI from logic classes)

**Next Week Goals:**
- Prepare for data structures or advanced file/database storage
- Try using OOP + file I/O together 
- Revise common interview questions per concept

---

## 📅 Weekly Reflection (Week 2: 30/06/2025–04/07/2025)

**Overall Progress:**
- Transitioned from basic CLI apps to JDBC and GUI
- Enhanced OOP understanding with real-world inspired apps
- Focused on code reusability, clean interaction, and robust error handling

**New Tools/Concepts Explored:**
- Java Swing for GUIs
- JDBC for database integration
- `Collections.shuffle()`, `PreparedStatement`, and class modularity

**What Went Well:**
- Each app felt life-like and had proper validation
- Scalable code practices: separate logic, UI, and flow
- Polished, presentable GitHub repo with working builds

**Areas for Improvement:**
- GUI styling still basic — needs exploration of layout managers
- JDBC queries can be modularized into DAO classes for scalability

**Next Week Goals:**
- Dive deeper into Java Collections and file/database interaction
- Attempt small-scale MVC pattern in a Java CLI/GUI app
- Explore exception propagation, unit testing (JUnit), and JavaDocs