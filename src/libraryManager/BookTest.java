package libraryManager;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldCreateBook() {
        Book b = new Book ("Frankenstein", "Mary Shelley");

        assertEquals("Frankenstein", Book.getTitle());
        assertEquals("Mary Shelley", Book.getAuthor());
    }

    @Test
    void shouldCheckOut() {
        Book b = new Book("Frankenstein 2", "Mary Shelley 2");
        b.checkOut(new Member("John"));
        assertEquals(true, b.isBorrowed());
        assertEquals("John", b.getBorrowedBy().getName());
        assertEquals(LocalDate.now().plusDays(14),b.getReturnBy());
    }

    @Test
    void shouldCheckIn() {
        Book b = new Book("Frankenstein 3", "Mary Shelley 3");
        assertEquals(false, b.isBorrowed());
        assertEquals(null, b.getBorrowedBy());
    }

    @Test
    void shouldSetAsOverdue() {
        Book b = new Book ("Frankenstein 4", "Mary Shelley 4");
        b.checkOut(new Member(300, "John"));
        Book.setAsOverdue(b);
        assertEquals(LocalDate.now().minusDays(7), b.getReturnBy());
    }


}