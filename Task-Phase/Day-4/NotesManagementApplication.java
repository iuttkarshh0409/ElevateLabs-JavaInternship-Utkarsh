//pre-final version

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NotesManagementApplication {
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) throws IOException {
        char choice;
        char option='x';

        do {
            System.out.println("\n----   Welcome to Notes Management Application   ----");
            System.out.println("\nApplication Menu:");
            System.out.println("1. Add a Note");
            System.out.println("2. Update a Note");
            System.out.println("3. Delete a Note");
            System.out.println("4. View Notes");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            try {
                choice = sc.nextLine().charAt(0); 

                switch (choice) {
                    case '1' -> addNote();
                    case '2' -> updateNote();
                    case '3' -> deleteNote();
                    case '4' -> viewNotes();
                    case '5' -> exitApp();
                    default -> System.out.println("Invalid input detected! Please choose between 1-5.");
                }
                 System.out.print("\nDo you want to continue using the application? (Y/N): ");
                 option = sc.nextLine().charAt(0);   
                
                 if (option != 'y' && option != 'Y') {
                    exitApp(); 
                 }           
            } //try block ends here
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice! (1-5)");
                choice = 0; 
            } //catch block ends here
        } 
        while (true);
          
    }


static void exitApp() {
        System.out.println("\nThank you for using the Notes Management Application\nPlease visit Again!\nExiting the application...");
        System.exit(0);
    }

static void addNote() {

    System.out.print("Enter your note: ");
    String note = sc.nextLine();

    try (FileWriter writer = new FileWriter("notes.txt", true)) { 
        writer.write(note + "\n");
        System.out.println("\nNote added successfully!\nPlease view notes to see the changes.");
    } catch (IOException e) {
        System.out.println("Error adding a note: " + e.getMessage());
    }
}
static void updateNote() {

    try {
        List<String> notes = Files.readAllLines(Paths.get("notes.txt"));

        if (notes.isEmpty()) {
            System.out.println("\nError: No notes found to update.");
            return;
        }

        // Display existing notes
        System.out.println("\nExisting Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.print("\nEnter the index number of the note you want to update: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index >= notes.size()) {
            System.out.println("\nError: Invalid note number.");
            return;
        }

        System.out.print("Enter the updated note: ");
        String updatedNote = sc.nextLine();

        notes.set(index, updatedNote); // Update the selected line

        // Write updated notes back to file
        Files.write(Paths.get("notes.txt"), notes);
        System.out.println("\nNote updated successfully!\nPlease view notes to see the changes.");

    } catch (IOException e) {
        System.out.println("Error updating note: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input.\nNote: Please enter a number as input for index of note.");
    }
}


    static void deleteNote() {
    try {
        List<String> notes = Files.readAllLines(Paths.get(FILE_NAME));

        if (notes.isEmpty()) {
            System.out.println("\nError: No notes available to delete!");
            return;
        }

        // Display existing notes
        System.out.println("\nExisting Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.print("\nEnter the index number of the note you want to delete: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index >= notes.size()) {
            System.out.println("Invalid note number.");
            return;
        }

        String removedNote = notes.remove(index); // remove the note
        Files.write(Paths.get(FILE_NAME), notes); // write back updated list

        System.out.println("\nSuccessfully deleted note: \"" + removedNote + "\"+\nPlease view notes to see the changes.");

    } catch (IOException e) {
        System.out.println("Error accessing the file: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number.");
    }
}

    static void viewNotes() {

        try{
        List<String> notes = Files.readAllLines(Paths.get("notes.txt"));
        System.out.println("\nNotes saved:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    } catch(IOException e){
        System.out.print("Error displaying notes!"+e.getMessage());
    }
    }
}
