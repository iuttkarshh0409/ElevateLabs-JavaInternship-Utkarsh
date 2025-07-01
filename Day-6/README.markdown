# 📋 ToDo App

A **GUI-based ToDo Application** built in **Java** using **Swing** for a user-friendly interface. This application allows users to manage tasks by adding, deleting, and updating their status (Pending/Completed). Developed as part of the **Elevate Labs Java Developer Internship** to practice GUI development and event-driven programming.

---

## 💻 Features

- ✅ **Add Task**: Input and add tasks to a scrollable list with a default "Pending" status.
- ✅ **Delete Task**: Remove selected tasks from the list.
- ✅ **Update Task Status**: Change the status of a selected task to "Pending" or "Completed".
- ✅ **Task List Display**: View all tasks in a scrollable list with their current status.
- ✅ **User-Friendly Interface**: Clean layout with labeled inputs, buttons, and visual feedback via dialog boxes.
- ✅ **Graceful Exit**: Close the application using a dedicated button.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **IDE**: Visual Studio Code
- **GUI Framework**: Java Swing (`javax.swing`)
- **Key Libraries**: `java.awt`, `javax.swing` for GUI components
- **Event Handling**: Action listeners for button interactions
- **Components**: `JFrame`, `JList`, `JTextField`, `JButton`, `JComboBox`, `JLabel`, `JScrollPane`

---

## 📂 Project Structure

```
ToDoApp
├── ToDoApp.java  # Main Java application with GUI and logic
└── README.md     # Project documentation
```

### 📌 Class
- **ToDoApp**: Extends `JFrame` to create the GUI, manage task operations, and handle user interactions.

---

## 🔍 How It Works

- **Add Task**: Users enter a task in a text field, and it’s added to the list with a "Pending" status if non-empty.
- **Delete Task**: Users select a task from the list and delete it with confirmation via a dialog box.
- **Update Task Status**: Users select a task, choose a status (Pending/Completed) from a dropdown, and update it.
- **Task List**: Displays tasks in a scrollable `JList` with their status (e.g., "Task [Pending]").
- **GUI Layout**:
  - **North**: Welcome label.
  - **Center**: Task input field, task list, and Add/Delete buttons.
  - **South**: Status dropdown, Update Status button, and Close button.
- **Feedback**: Dialog boxes (`JOptionPane`) provide success or error messages for all actions.

---

## ✅ Key Features & Improvements

| Feature/Improvement            | Description                                              |
|-------------------------------|----------------------------------------------------------|
| Input Validation              | Prevents empty tasks from being added                    |
| Selection Validation          | Ensures a task is selected for deletion or status update |
| User Feedback                 | Dialog boxes for success/error messages                  |
| Clean GUI Design              | Organized layout with borders, colors, and clear labels  |
| Status Management             | Supports toggling between Pending and Completed states   |
| Scrollable Task List          | Handles large task lists with a scroll pane              |

---

## 🚀 Sample Execution

1. Launch the application to see a window titled "ToDo App".
2. **Add a Task**:
   - Enter "Buy groceries" in the text field.
   - Click "Add a Task" → Task appears as "Buy groceries [Pending]".
   - Dialog: "Task added successfully."
3. **Update Status**:
   - Select "Buy groceries [Pending]" from the list.
   - Choose "Completed" from the dropdown and click "Update Status".
   - Task updates to "Buy groceries [Completed]".
   - Dialog: "Task updated successfully."
4. **Delete Task**:
   - Select a task and click "Delete a Task".
   - Task is removed, with a dialog: "Task deleted successfully."
5. **Close App**: Click "Close App" to exit.

### 📸 Screenshot (Conceptual)
- **Window**: 400x600 pixels, with a centered "Welcome to ToDo Application" title.
- **Task List**: Scrollable list showing tasks (e.g., "Task 1 [Pending]", "Task 2 [Completed]").
- **Input Field**: Light yellow background for task entry.
- **Buttons**: Add, Delete, Update Status, and Close buttons with clear labels.

---

## 📎 Concepts Practiced

- **GUI Development**: Building a desktop application with Java Swing components (`JFrame`, `JList`, `JButton`, etc.).
- **Event-Driven Programming**: Handling user actions with `ActionListener`.
- **Data Management**: Using `DefaultListModel` to dynamically manage the task list.
- **Input Validation**: Checking for empty inputs and valid task selections.
- **User Experience**: Providing visual feedback via dialog boxes and a clean interface layout.
- **Layout Management**: Using `BorderLayout`, `GridLayout`, and borders for structured UI design.

---

## 🔐 Edge Case Handling

| Case                              | Behavior                                              |
|-----------------------------------|-------------------------------------------------------|
| Empty task input                  | Rejected with dialog: "Task cannot be empty."         |
| No task selected for deletion     | Dialog: "Please select a task to delete."             |
| No task selected for status update| Dialog: "Please select a task to update."             |
| Large task list                   | Scrollable list handles multiple tasks seamlessly     |

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: dubeyutkarsh101@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.