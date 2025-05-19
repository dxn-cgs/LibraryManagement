package libraryManager;

import java.time.LocalDate;

/**
 * Class:
 * Author:
 * LastEdited:
 * Description: [What this class does in 1–2 sentences.]
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean borrowed;
    private Member borrowedBy;
    private LocalDate returnBy;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
        this.borrowedBy = null;
        this.returnBy = null;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public LocalDate getReturnBy() {
        return returnBy;
    }

    public void checkOut(Member member, LocalDate returnBy) {
        // to complete
    }

    public void checkIn() {
        // to complete
    }
}
