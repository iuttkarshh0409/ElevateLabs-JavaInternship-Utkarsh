# 📚 Library Management System – Day 3

Elevate Labs Java Developer Internship – Task 3

A robust, modular, and interactive console-based **Library Management System** developed in **Java** using **Object-Oriented Programming** principles. This application enables seamless management of book inventory and users, supporting features like issuing and returning books, user registration, and status tracking.

---

## 🛠️ Features

### 📘 Book Management
- Add books with unique ISBNs (validation enforced to prevent duplicates).
- Tracks book status: **Available** or **Issued**.
- Displays the complete book list with live status and issued user (if applicable).

### 👤 User Management
- Register users with unique User IDs (duplicate prevention enforced).
- Stores user details: User ID, Name, and Email.
- Lists all registered users with clear, formatted output.

### 🔄 Book Issuing & Returning
- Issue books only to **existing users**.
- Prevent re-issuing of already issued books until they are returned.
- Link books to the correct User ID upon issuing.
- Strict validation for returning books:
  - User must exist.
  - Book must be issued.
  - Only the user who issued the book can return it.
- User-friendly messages for all validations and edge cases.

### 🎛️ Interactive Console Menu
- Menu-driven interface with a loop until the user chooses to exit.
- Robust input handling for invalid menu options and number format errors.
- Graceful termination with proper resource cleanup (`Scanner.close()`).

---

## ✅ Improvements

All enhancements were implemented based on real-time testing:

| Improvement/Feature                   | Status |
|--------------------------------------|--------|
| Duplicate Book ISBN check            | ✅ Added validation with custom message |
| Duplicate User ID check              | ✅ Enforced in `addUser()` |
| User ID required for book return     | ✅ Strictly validated |
| Only book issuer can return it       | ✅ `issuedToUserID` matched during return |
| Proper message formatting            | ✅ User-friendly messages throughout |
| Menu input validation                | ✅ Default case handles incorrect input |
| Exception handling                   | ✅ Number format errors handled for ISBN and IDs |
| Display enhancements                 | ✅ Clear labels and formatted listings |

---

## 📂 Project Structure

```
LibraryManagementSystem/
├── LibraryManagementSystem.java  # Contains all classes: Book, User, Library, and main application
└── README.md                     # Project documentation
```

### Classes
- **Book**: Represents a book with attributes like ISBN, title, and status.
- **User**: Represents a registered user with User ID, Name, and Email.
- **Library**: Core logic for managing book inventory and users.
- **LibraryManagementSystem**: Main application with the console interface.

---

## 🚀 How to Run

1. Ensure **Java** (JDK 8+) is installed.
2. Compile the program:
   ```bash
   javac LibraryManagementSystem.java
   ```
3. Run the compiled class:
   ```bash
   java LibraryManagementSystem
   ```

---

## 📸 Sample Output

```
---- Library Management System Application ----

Application Menu:
1. Add a Book
2. Register a New User
3. Issue a Book
4. Return an Issued Book
5. View All Available Books
6. View Registered Users
7. Exit
Enter your choice:
```

---

## 🔐 Edge Case Handling

| Case                          | Behavior                     |
|-------------------------------|------------------------------|
| Add book with duplicate ISBN  | Rejected with message        |
| Add user with duplicate ID    | Rejected with message        |
| Issue book to non-existent user | Rejected with message      |
| Issue non-existent book       | Rejected with message        |
| Re-issue already issued book  | Rejected with message        |
| Return a book not issued      | Rejected with message        |
| Return by wrong user          | Rejected with message        |
| Menu option out of 1–7        | Handled gracefully           |
| Invalid number input          | Handled with try-catch       |

---

## 👨‍💻 Author

**Utkarsh Dubey**  
Java Developer Intern @ Elevate Labs  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 [GitHub](https://github.com/iuttkarshh0409)  
📧 [dubeyutkarsh101@gmail.com](mailto:dubeyutkarsh101@gmail.com)

---

## 📝 License

This project is open-source and free to use for educational and personal projects under the Elevate Labs Internship guidelines. Reuse is permitted with proper credit.

---

## ✅ Task Completed

**📅 Submission Date**: June 26, 2025