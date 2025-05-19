package libraryManager;

import java.util.*;

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

    public void borrowBook(Book book) {
        // to complete
    }

    public List<Book> getOverdueBooks() {
        // to complete
        List<Book> temp = new ArrayList<>();
        temp.add(new Book(0, "SampleOverdueBook", "SampleAuthor"));
        return temp;
    }
}
