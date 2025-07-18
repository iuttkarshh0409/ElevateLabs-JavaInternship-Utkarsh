# 📒 Notes Management Application

A command-line based **Notes Manager** built in **Java** using **File I/O operations**. Developed as part of **Day 4** of the **Elevate Labs Java Developer Internship** to practice `FileReader` and `FileWriter` in a real-world scenario.

---

## 💻 Features

- ✅ **Add Notes**: Append new notes to `notes.txt`.
- ✅ **View Notes**: Display all saved notes as a numbered list.
- ✅ **Update Notes**: Select a note by index to modify its content.
- ✅ **Delete Notes**: Remove a specific note by index.
- ✅ **Continue Prompt**: Option to continue or exit after each action (Y/N).
- ✅ **Graceful Exit**: Terminates with a thank-you message.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **IDE**: Visual Studio Code
- **Interface**: Terminal (Command Line Interface)
- **File I/O**: `FileWriter`, `Files.readAllLines()`, `Files.write()`
- **Exception Handling**: `IOException`, `NumberFormatException`

---

## 📂 Project Structure

```
NotesManagementApplication
├── NotesManagementApplication.java  # Main Java application
├── notes.txt                        # Auto-generated file for storing notes
└── README.md                        # Project documentation
```

---

## 🔍 How It Works

- **Adding a Note**: Appends user input as a new line in `notes.txt`.
- **Viewing Notes**: Reads and displays all lines from `notes.txt` with line numbers.
- **Updating a Note**: Lists notes, prompts for an index, and updates the selected note.
- **Deleting a Note**: Lists notes, removes the selected note, and rewrites `notes.txt`.

---

## ✅ Improvements Over Basic Version

| Improvement            | Description                                              |
|------------------------|----------------------------------------------------------|
| Input Validation       | Handles invalid indices and non-numeric inputs            |
| Empty File Checks      | Alerts if no notes are available for view/update/delete   |
| Continue Prompt        | Prompts user to continue or exit after each action       |
| Code Refactoring       | Uses constants (`FILE_NAME`), modular method structure    |
| User Messages          | Clear success, error, and status messages for all actions |

---

## 🚀 Sample Execution

```
---- Welcome to Notes Management Application ----

Application Menu:
1. Add a Note
2. Update a Note
3. Delete a Note
4. View Notes
5. Exit

Enter your choice: 1
Enter your note: Buy groceries
Note added successfully!
Please view notes to see the changes.

Do you want to continue using the application? (Y/N): y
```

---

## 📎 Concepts Practiced

- **File Handling**: `FileWriter`, `Files`, `Paths` for reading/writing notes.
- **Exception Handling**: `try-with-resources` and `catch` for robust error management.
- **User Interaction**: `Scanner` for command-line input.
- **Data Manipulation**: String and List operations for note management.
- **Defensive Programming**: Input validation and edge case handling.

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: utkarshdubey0409@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.