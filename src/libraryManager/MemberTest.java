package libraryManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    public void shouldReturnOverDueBooks() {
        Member myMember = new Member(1,"D");

        Book book = new Book(0, "Test Book", "Test Author");
        book.checkOut(myMember);
        Book.setAsOverdue(book);

        assertEquals(book, myMember.getOverdueBooks().get(0));
    }

    @Test
    public void shouldReturnBorrowedBook() {
        BookList borrowed = new BookList();
        Book book = new Book(1,"Testbook", "Test Author");
        book.checkIn();

    }
}