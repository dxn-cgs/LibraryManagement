package libraryManager;

import java.time.*;

/**
 * Class:
 * Author: SAM (not linke)
 * LastEdited:
 * Description: Represents a book in the library system.
 *              Stores book details and handles check-in/check-out functionality with due date tracking.
 */
public class Book {
    private static int id;
    private static String title;
    private static String author;
    private boolean borrowed;
    private Member borrowedBy;
    private LocalDate returnBy;

    private static int nextId = 0;

    public Book(String title, String author) {
        this.id = nextId;
        this.title = title;
        this.author = author;
        this.borrowed = false;
        this.borrowedBy = null;
        this.returnBy = null;

        this.nextId += 1;
    }

    public static int getId() {
        return id;
    }

    public static String getTitle() {
        return title;
    }

    public static String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Member getBorrowedBy() {
        return this.borrowedBy;
    }

    public LocalDate getReturnBy() {
        return returnBy;
    }

    public String getStatus() {
        if (borrowed) {
            return "BORROWED";
        } else {
            return "AVAILABLE";
        }
    }

    /**
     * This method checks out a book and assigns a member that borrowed it
     * Prevents user from borrowing if member has overdue books
     * @author Sam and Linke
     * @param member is the member who is borrowing the book
     */
    public void checkOut(Member member) {
        if (!member.getOverdueBooks().isEmpty()) {
            throw new IllegalStateException("Member has overdue books");
        }

        member.checkOutBook(this);
        this.borrowed = true;
        this.borrowedBy = member;
        this.returnBy = LocalDate.now().plusDays(14);
    }

    /**
     * This method checks in a book and sets its status as borrowed to false,
     * as well as setting who it is borrowed to null
     * @author Sam and Linke
     */
    public void checkIn(Book book) {
        this.borrowed = false;
        this.borrowedBy = null;
    }

    /**
     * Set the due date of the book some time in the past
     * For testing purposes only
     * @author Mr Nam
     */
    static void setAsOverdue(Book book) {
        if (!book.isBorrowed()) {
            throw new IllegalStateException("The book is not borrowed yet");
        }

        book.returnBy = LocalDate.now().minusDays(7);
    }

}
