package libraryManager;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookListTest {

    /**
     *
     * @author all by sam
     */

    @Test
    void shouldCreateBookList() {
        BookList bookList = new BookList();
        assertNotNull(bookList.getBooks());
        assertTrue(bookList.getBooks().isEmpty());
    }

    @Test
    void shouldGetBookById() {
        BookList bookList = new BookList();
        bookList.addBook("Test Book", "Test Author");

        Book book = bookList.getBookById(0);
        assertNotNull(book);
        assertEquals("Test Book", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals(0, book.getId());
    }

    @Test
    void shouldAddBook() {
        BookList bookList = new BookList();
        bookList.addBook("Another Book", "Another Author");

        List<Book> books = bookList.getBooks();
        assertEquals(1, books.size());
        assertEquals("Another Book", books.get(0).getTitle());
        assertEquals(0, books.get(0).getId());
    }

    @Test
    void shouldFilter() {
        BookList bookList = new BookList();
        bookList.addBook("Available Book", "Author A");
        bookList.addBook("Borrowed Book", "Author B");

        Book borrowedBook = bookList.getBookById(1);
        Member member = new Member(0, "John Doe");

        borrowedBook.checkOut(member);

        List<Book> borrowedBooks = bookList.filterBooks(true);
        List<Book> availableBooks = bookList.filterBooks(false);

        assertEquals(1, borrowedBooks.size());
        assertEquals("Borrowed Book", borrowedBooks.get(0).getTitle());

        assertEquals(1, availableBooks.size());
        assertEquals("Available Book", availableBooks.get(0).getTitle());
    }


}