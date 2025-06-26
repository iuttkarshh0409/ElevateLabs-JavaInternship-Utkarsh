//final version
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int ISBN;
    private String title;
    private String author;
    private boolean isIssued;
    private int issuedToUserID = -1;

    Book(int ISBN, String title, String author){
        this.ISBN= ISBN;
        this.title= title;
        this.author= author;
        this.isIssued= false;
    }

    // Getters and Setters methods
    public int getISBN(){
        return ISBN;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isIssued(){
        return  isIssued;
    }

    public int getIssuedToUserID() {
    return issuedToUserID;
    }

    public void setIssued(boolean  issued){
        this.isIssued= issued;
    }

    public void setIssuedToUserID(int userID) {
    this.issuedToUserID = userID;
    }

     @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Title: " + title + ", Author: " + author +
        ", Status: " + (isIssued ? "Issued to UserID: " + issuedToUserID : "Available");

    }
}

class User {
    private int userID;
    private String name;
    private String email;

    public User(int userID, String name, String email) {
        this.userID= userID;
        this.name= name;
        this.email= email;
    }

    // Getters and Setters
    public int getUserID() {
        return  userID;
    }

    public void setUserID(int userID) {
        this.userID= userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + ", Name: " + name + ", Email: " + email;
    }
}



class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { //method to add a book to library inventory
        if (findBookByISBN(book.getISBN()) != null) {
        System.out.println("\nError: Book with entered ISBN already exists!\nNote: Please use a unique ISBN.");
        return;
    }
        books.add(book);
        System.out.println("\nSuccess: Book added to the library!");
    }

    public void addUser(User user) {  // method to add a new user to the library system
        if (findUserByID(user.getUserID()) != null) {
        System.out.println("\nError: User ID already exists!\nNote: Please use a unique ID.");
        return;
    }
        users.add(user);
        System.out.println("\nSuccess: User registered in the library system!");
    }

    public void issueBook(int isbn, int userID) { // method to issue a book to a user
        Book book = findBookByISBN(isbn);
        User user = findUserByID(userID);

        if (book == null) {
            System.out.println("\nError: Book with ISBN " + isbn + " not found in the System!\nNote: Please add the Book to the library or re-check the ISBN and try again. ");
        } else if (user == null) {
            System.out.println("\nError: User with ID " + userID + " not found!\nNote: Please register the user or re-check the ID and try again.");
        } else if (book.isIssued()) {
            System.out.println("\nAlert: Book is already issued by another user!\nNote: Please wait for the borrower to return.");
        } else {
            book.setIssued(true);
            book.setIssuedToUserID(userID);
            System.out.println("\nCongratulatons! Book successfully issued to " + user.getName());
        }
    }

    public void returnBook(int isbn, int userID) {
    Book book = findBookByISBN(isbn);
    User user = findUserByID(userID);

    if (book == null) {
        System.out.println("Error: Book not found!");
    } else if (user == null) {
        System.out.println("Error: User not found!");
    } else if (!book.isIssued()) {
        System.out.println("Alert: Book is not currently issued by the user!");
    } else if (book.getIssuedToUserID() != userID) {
        System.out.println("Error: This book was not issued to user ID " + userID);
    } else {
        book.setIssued(false);
        book.setIssuedToUserID(-1);
        System.out.println("\nSuccess: Book returned by " + user.getName());
    }
}

    public void displayBooks() { //method to display all books of the inventory
        if (books.isEmpty()) {
            System.out.println("Alert: No books are currently available in the library.");
        } else {
            System.out.println("\nList of Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayUsers() { //method to display all registered users in the library
        if (users.isEmpty()) {
            System.out.println("Alert: No users are currently registered in the System!\nRegister a user and try again.");
        } else {
            System.out.println("\nList of Users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private Book findBookByISBN(int isbn) { // method to find a book by ISBN
        for (Book book : books) {
            if (book.getISBN() == isbn) {
                return book;
            }
        }
        return null;
    }

    private User findUserByID(int userID) { //method to find a user by userID
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }
}


public class LibraryManagementSystem{

         static Scanner sc = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        String option;
        char choice;

        System.out.println("\n---- Library Management System Application ----");

        do {
            // Display menu
            System.out.println("\n\nApplication Menu:");
            System.out.println("\n1. Add a Book");
            System.out.println("2. Register a  new User");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return an issued Book");
            System.out.println("5. View all available Books");
            System.out.println("6. View registered Users");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            choice = sc.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    addBookToLibrary();
                    break;
                case '2':
                    addUserToLibrary();
                    break;
                case '3':
                    issueBookToUser();
                    break;
                case '4':
                    returnBookToLibrary();
                    break;
                case '5':
                    library.displayBooks();
                    break;
                case '6':
                    library.displayUsers();
                    break;
                case '7':
                    exitApp();
                    return;
                default:
                    System.out.println("Error: Invalid choice!\nNote: Please enter 1-7.");
            }

            System.out.print("\nDo you want to continue using the application? (Y/N): ");
            option = sc.nextLine().trim().toLowerCase();

        } while (option.equals("y"));

        exitApp();
    }

    static void exitApp() {
        System.out.println("\nThank you for using the Library Management System!\nPlease visit again.");
        System.out.println("\nExiting the aplication...");
        sc.close();
    }

    static void addBookToLibrary() {
    try {
        System.out.print("\nEnter ISBN: ");
        int isbn = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        Book book = new Book(isbn, title, author);
        library.addBook(book);
    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input format!\nNote: ISBN must be a number.");
    }
}

 static void addUserToLibrary() {
    try {
        System.out.print("\nEnter User ID: ");
        int userid = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter E-mail: ");
        String email = sc.nextLine();

        User user = new User(userid, name, email);
        library.addUser(user);
    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input detected!");
    }
}

     static void issueBookToUser() {
    try {
        System.out.print("\nEnter ISBN of the Book: ");
        int isbn = Integer.parseInt(sc.nextLine());

        System.out.print("Enter User ID: ");
        int userID = Integer.parseInt(sc.nextLine());

        library.issueBook(isbn, userID);

    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input!\nNote: Please enter valid.");
    }
}

static void returnBookToLibrary() {
    try {
        System.out.print("Enter ISBN of the Book to return: ");
        int isbn = Integer.parseInt(sc.nextLine());

        System.out.print("Enter your User ID: ");
        int userID = Integer.parseInt(sc.nextLine());

        library.returnBook(isbn, userID);

    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid input! Please enter valid numeric values.");
    }
}
    }

