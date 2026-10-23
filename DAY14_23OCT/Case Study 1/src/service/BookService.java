package service;

import dao.BookDAO;
import entity.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private final BookDAO dao = new BookDAO();

    public List<Book> getAllBooks() throws SQLException {
        return dao.getAllBooks();
    }

    public List<Book> searchBooks(String keyword)
            throws SQLException {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException(
                    "Search keyword is required.");
        }
        return dao.searchBooks(keyword.trim());
    }

    public void addBook(Book book) throws SQLException {
        if (book == null ||
                book.getTitle() == null ||
                book.getTitle().isBlank() ||
                book.getAuthor() == null ||
                book.getAuthor().isBlank()) {
            throw new IllegalArgumentException(
                    "Title and author are required.");
        }

        if (book.getTotalCopies() < 0) {
            throw new IllegalArgumentException(
                    "Copies cannot be negative.");
        }

        dao.addBook(book);
    }

    public void updateBook(int id, String title, String author, String category)throws SQLException {
        if (title == null || title.isBlank() ||
                author == null || author.isBlank()) {
            throw new IllegalArgumentException(
                    "Title and author are required.");
        }

        dao.updateBook(id, title, author, category);
    }

    public void deleteBook(int id) throws SQLException {
        dao.deleteBook(id);
    }
}