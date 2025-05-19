package libraryManager;

import java.util.*;
import java.time.LocalDate;


/**
 * Class:
 * Author:
 * LastEdited:
 * Description: [What this class does in 1–2 sentences.]
 */
public class Member {
    private int id;
    private String name;
    private List<Book> borrowedBooks;


    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;

    }

    public void checkOutBook(Book book) {
        this.borrowedBooks.add(book);
    }

    /**
     * Return a borrowed book from the borrowedBooks list, otherwise throw an error
     * @author
     * @param book
     */
    public void checkInBook(Book book) {
        for (Book b : this.borrowedBooks) {
            if (b.getId() == book.getId()) {
                this.borrowedBooks.remove(book);
                return;
            }
        }
        // throw an exception when the specified book is not found
        throw new IllegalArgumentException("Book is not found.");
    }

    public List<Book> getOverdueBooks() {
        List<Book> overdueBooks = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Book b: this.borrowedBooks){
            if(b.getReturnBy().isBefore(today)){
                overdueBooks.add(b);
            }
        }
        return overdueBooks;
    }
}
