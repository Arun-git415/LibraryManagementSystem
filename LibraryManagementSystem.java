2import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author + (isBorrowed ? " (Borrowed)" : "");
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private int nextId;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        nextId = 1;
    }

    public void addBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
        System.out.println("Book added: " + title);
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                System.out.println("Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.borrow();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
