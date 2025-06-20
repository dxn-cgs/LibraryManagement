package libraryManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    public void shouldCheckInAndCheckOutBook() {
        Member testMemb = new Member(0, "Test Member");
        Book book = new Book(0, "Test Book", "Test Author");
        testMemb.checkOutBook(book);
        assertEquals(book, testMemb.getBorrowedBooks().get(0));
        testMemb.checkInBook(book);
        assertEquals(true, testMemb.getBorrowedBooks().isEmpty());
    }

    @Test
    public void shouldReturnOverDueBooks() {
        Member myMember = new Member(0, "D");

        Book book = new Book(0, "Test Book", "Test Author");
        book.checkOut(myMember);

        // have to call this internal method to set the due date past today
        // just for testing
        Book.setAsOverdue(book);

        assertEquals(book, myMember.getOverdueBooks().get(0));
    }
    
    @Test 
    public void shouldReturnBorrowedBooks(){
        Member myMember = new Member(4,"Marry Sherry");

        Book book = new Book(0, "frankenstein", "mary shelley");
        
        book.checkOut(myMember);



    }
}