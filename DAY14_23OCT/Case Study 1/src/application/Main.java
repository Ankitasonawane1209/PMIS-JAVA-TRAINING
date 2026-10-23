package application;

import entity.Book;
import entity.BorrowRecord;
import entity.User;
import service.BookService;
import service.UserService;
import service.BorrowService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final BookService books = new BookService();
    private static final UserService users = new UserService();
    private static final BorrowService borrowing = new BorrowService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = readInt("Choose option: ");

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    private static void login() {
        int id = readInt("Enter User ID: ");

        try {
            User user = users.loginById(id);

            if (user == null) {
                System.out.println("User not found.");
                return;
            }

            System.out.println("Welcome, " + user.getName());

            if ("LIBRARIAN".equals(user.getRole())) {
                librarianMenu();
            } else if ("MEMBER".equals(user.getRole())) {
                memberMenu(user.getUserId());
            } else {
                System.out.println("Unknown role.");
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    private static void librarianMenu() {
        while (true) {
            System.out.println("\n===== LIBRARIAN MENU =====");
            System.out.println("1. View Books");
            System.out.println("2. Search Books");
            System.out.println("3. Add Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. View Users");
            System.out.println("7. View Borrow Records");
            System.out.println("8. Logout");

            int choice = readInt("Choose option: ");

            try {
                switch (choice) {
                    case 1:
                        showBooks(books.getAllBooks());
                        break;

                    case 2:
                        searchBooks();
                        break;

                    case 3:
                        addBook();
                        break;

                    case 4:
                        updateBook();
                        break;

                    case 5:
                        books.deleteBook(
                                readInt("Enter Book ID: "));
                        break;

                    case 6:
                        for (User u : users.getAllUsers()) {
                            System.out.println(
                                    u.getUserId() + " | " +
                                            u.getName() + " | " +
                                            u.getEmail() + " | " +
                                            u.getRole());
                        }
                        break;

                    case 7:
                        borrowing.viewAllRecords();
                        break;

                    case 8:
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (SQLException | IllegalArgumentException e) {
                showError(e);
            }
        }
    }

    private static void memberMenu(int memberId) {
        while (true) {
            System.out.println("\n===== MEMBER MENU =====");
            System.out.println("1. View Books");
            System.out.println("2. Search Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowing History");
            System.out.println("6. Logout");

            int choice = readInt("Choose option: ");

            try {
                switch (choice) {
                    case 1:
                        showBooks(books.getAllBooks());
                        break;

                    case 2:
                        searchBooks();
                        break;

                    case 3:
                        borrowing.borrowBook(
                                memberId, readInt("Enter Book ID: "));
                        break;

                    case 4:
                        borrowing.returnBook(
                                memberId,
                                readInt("Enter Borrow Record ID: "));
                        break;

                    case 5:
                        List<BorrowRecord> history =
                                borrowing.getHistory(memberId);

                        for (BorrowRecord r : history) {
                            System.out.println(
                                    "Record: " + r.getRecordId() +
                                            " | Book ID: " + r.getBookId() +
                                            " | Borrowed: " + r.getBorrowDate() +
                                            " | Due: " + r.getDueDate() +
                                            " | Returned: " + r.getReturnDate() +
                                            " | Status: " + r.getStatus());
                        }

                        if (history.isEmpty()) {
                            System.out.println(
                                    "No borrowing history.");
                        }
                        break;

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (SQLException | IllegalArgumentException e) {
                showError(e);
            }
        }
    }

    private static void showBooks(List<Book> list) {
        if (list.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book b : list) {
            System.out.println(b);
        }
    }

    private static void searchBooks() throws SQLException {
        System.out.print("Enter title, author, or book ID: ");
        showBooks(books.searchBooks(sc.nextLine().trim()));
    }

    private static void addBook() throws SQLException {
        int id = readInt("Book ID: ");
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        int quantity = readInt("Total copies: ");

        if (quantity < 0) {
            System.out.println("Copies cannot be negative.");
            return;
        }

        Book book = new Book(id, title, author, category,
                quantity, quantity);
        books.addBook(book);
    }

    private static void updateBook() throws SQLException {
        int id = readInt("Book ID: ");
        System.out.print("New title: ");
        String title = sc.nextLine();
        System.out.print("New author: ");
        String author = sc.nextLine();
        System.out.print("New category: ");
        String category = sc.nextLine();

        books.updateBook(id, title, author, category);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    private static void showError(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}