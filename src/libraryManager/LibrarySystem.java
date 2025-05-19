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

    //ignore these, vars are used for styling
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public LibrarySystem() {
        this.bookList = new BookList();
        this.memberList = new MemberList();
    }

    /**
     *
     * @param book The book we are trying to find
     * @return Member: the member which owns the book
     */
    private Member getBorrowerOf(Book book) {
        // to complete
        return new Member(0, "Sample Member");
    }

    /**
     * Prints out all books we have in our library and displays if they are available
     * @author Jun
     * @param books List of books we have in the library
     */
    private void printBooks(List<Book> books) {
        // to complete
        System.out.println("\nList of all books:");
        System.out.println("---------------------------------------");
        System.out.println(ANSI_YELLOW + "ID   STATUS     TITLE (AUTHOR)" + ANSI_RESET);
        for (Book book : books) {
            System.out.printf("%-4d %-10s %s (%s)\n", book.getId(), book.getStatus(), book.getTitle(), book.getAuthor());
        }
    }

    /**
     * Prints out all members of our library.
     * @param members
     */
    private void printMembers(List<Member> members) {
        // to complete
        System.out.println("\nList of all members:");
        System.out.println("---------------------------------------");

    }

    /**
     *
     * Main loop which the program will run on
     * @author Jun
     */
    public void run() {
        // to complete
        while (true) {
            System.out.println("Welcome to the CGS Library Manager!");
            System.out.print("- Manage [b]ooks\n- [R]egister a new member\n- Save and [e]xit");

            String choice = inputString("Select an Option: ").toLowerCase();
            switch (choice) {
                case "b":
                    printBooks(this.bookList.getBooks());
                    break;
                case "r":
                    printMembers(this.memberList.getMembers());
                    break;
                case "e":
                    break;
            }
        }

    }
}
