package libraryManager;

import java.util.*;

/**
 * Class:
 * Author: Sam and Leo
 * LastEdited:
 * Description: Manages a collection of Book objects.
 *              Provides methods to add, retrieve, and filter books by various criteria.
 */
public class BookList {
    private List<Book> books;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    /**
     * This method finds the book by an inputted id
     * If book isn't found, throw error
     * @author Sam and Leo
     * @param id the id of the book to find
     * @return returns the book if the id is valid, else throws an exception
     */
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new IllegalStateException("There is no book with that ID");
    }

    /**
     * This method checks if the book trying to be added is already in the list, and if it isn't, adds the book
     * @author Leo
     * @param book a book object in the booklist
     */
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                throw new IllegalArgumentException("A book with this ID already exists");
            }
        }
        books.add(book);
    }

    /**
     * Filters books from the booklist on the inputted boolean
     * @author Sam
     * @param isBorrowed boolean to find (list of borrowed books or not borrowed books)
     * @return returns filtered list
     */
    public List<Book> filterBooks(boolean isBorrowed) {
        List<Book> filtered = new ArrayList<>();
        for (Book book : books) {
            if (book.isBorrowed() == isBorrowed){
                filtered.add(book);
            }
        }
        return filtered;
    }
}
