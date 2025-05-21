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
    private int nextId;
    private List<Book> books;

    public BookList() {
        this.nextId = 0;
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
     * Creates a book instance and adds it to the list
     * @author Leo and Mr Nam
     * @param title the title of the book
     * @param author the author of the book
     */
    public void addBook(String title, String author) {
        books.add(new Book(nextId, title, author));
        this.nextId += 1;
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
