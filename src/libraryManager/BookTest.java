package libraryManager;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldCreateBook() {
        Book b = new Book(1, "Frankenstein", "Mary Shelley");

        assertEquals("Frankenstein", b.getTitle());
        assertEquals("Mary Shelley", b.getAuthor());
    }

    @Test
    void shouldCheckOut() {
        Book b = new Book(2, "Frankenstein 2", "Mary Shelley 2");
        b.checkOut(new Member(0, "John"));
        assertEquals(true, b.isBorrowed());
        assertEquals("John", b.getBorrowedBy().getName());
        assertEquals(LocalDate.now().plusDays(14),b.getReturnBy());
    }

    @Test
    void shouldCheckIn() {
        Book b = new Book(3, "Frankenstein 3", "Mary Shelley 3");
        assertEquals(false, b.isBorrowed());
        assertEquals(null, b.getBorrowedBy());
    }

    @Test
    void shouldSetAsOverdue() {
        Book b = new Book (4, "Frankenstein 4", "Mary Shelley 4");
        b.checkOut(new Member(300, "John"));
        Book.setAsOverdue(b);
        assertEquals(LocalDate.now().minusDays(7), b.getReturnBy());
    }


}