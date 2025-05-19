package libraryManager;

import java.util.*;

/**
 * Class:
 * Author:
 * LastEdited:
 * Description: [What this class does in 1–2 sentences.]
 */
public class BookList {
    private List<Book> books;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(String id) {
        // to complete
        return new Book(0, "Sample Book", "Sample Author");
    }

    public void addBook(Book book) {
        // to complete
    }

    public List<Book> filterBooks(boolean isAvailable) {
        // to complete
        List<Book> temp = new ArrayList<>();
        temp.add(new Book(0, "Sample Filtered Book", "Sample Author"));
        return temp;
    }
}
