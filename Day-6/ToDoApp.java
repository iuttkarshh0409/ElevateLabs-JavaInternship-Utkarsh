import java.awt.*;
import javax.swing.*;

public class ToDoApp extends JFrame {
    private final DefaultListModel<String> taskListModel;
    private final JList<String> taskList;
    private final JTextField taskInput;
    private final JButton addButton, deleteButton, closeButton, updateStatusButton;
    private final JLabel welcomeLabel, inputLabel, statusLabel;
    private final JComboBox<String> statusDropdown;

    public ToDoApp() {
        setTitle("ToDo App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());

        // Top Welcome Label
        welcomeLabel = new JLabel("Welcome to ToDo Application", JLabel.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(welcomeLabel, BorderLayout.NORTH);

        // Task List & Scroll Pane
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Your added tasks:"));

        // Center Panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        inputLabel = new JLabel("Add a note:");
        taskInput = new JTextField();
        taskInput.setBackground(new Color(255, 255, 204)); // light yellow

        addButton = new JButton("Add a Task");
        deleteButton = new JButton("Delete a Task");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(taskInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Status Section
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel("Set Task Status:");
        statusDropdown = new JComboBox<>(new String[]{"Pending", "Completed"});
        updateStatusButton = new JButton("Update Status");

        JPanel statusInputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        statusInputPanel.add(statusDropdown);
        statusInputPanel.add(updateStatusButton);

        statusPanel.add(statusLabel, BorderLayout.NORTH);
        statusPanel.add(statusInputPanel, BorderLayout.CENTER);

        // Close Button
        closeButton = new JButton("Close App");
        JPanel closePanel = new JPanel();
        closePanel.add(closeButton);

        bottomPanel.add(statusPanel, BorderLayout.NORTH);
        bottomPanel.add(closePanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Actions
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        updateStatusButton.addActionListener(e -> updateStatus());
        closeButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task + " [Pending]");
            taskInput.setText("");
            JOptionPane.showMessageDialog(this, "Task added successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Task cannot be empty.");
        }
    }

    private void deleteTask() {
        int selected = taskList.getSelectedIndex();
        if (selected != -1) {
            taskListModel.remove(selected);
            JOptionPane.showMessageDialog(this, "Task deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.");
        }
    }

    private void updateStatus() {
        int selected = taskList.getSelectedIndex();
        if (selected != -1) {
            String taskText = taskListModel.getElementAt(selected);
            String updatedTask = taskText.replaceAll("\\[.*?\\]$", "") + "[" + statusDropdown.getSelectedItem() + "]";
            taskListModel.setElementAt(updatedTask, selected);
            JOptionPane.showMessageDialog(this, "Task updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to update.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
