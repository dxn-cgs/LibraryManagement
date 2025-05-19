package libraryManager;

import static jets.Jets.*;
import java.util.*;

/**
 * Class:
 * Author:
 * LastEdited:
 * Description: [What this class does in 1–2 sentences.]
 */
public class LibrarySystem {
    private BookList bookList;
    private MemberList memberList;

    public LibrarySystem() {
        this.bookList = new BookList();
        this.memberList = new MemberList();
    }

    private Member getBorrowerOf(Book book) {
        // to complete
        return new Member(0, "Sample Member");
    }

    private void printBooks(List<Book> books) {
        // to complete
    }

    private void printMembers(List<Member> members) {
        // to complete
    }

    public void run() {
        // to complete
    }
}
