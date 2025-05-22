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
    private final String saveLocation;

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
        this.saveLocation = "save.json";
    }

    /**
     *
     * @param book The book we are trying to find
     * @author Jun
     * @return Member: the member which owns the book
     */
    private Member getBorrowerOf(Book book) {
        int id = inputInt("Enter the book ID");
        return new Member(0, "Sample Member");
    }

    /**
     * Prints out all books we have in our library and displays if they are available
     * @author Jun
     * @param books List of books we have in the library
     */
    private void printBooks(List<Book> books) {
        System.out.println("\nList of all books:");
        System.out.println("---------------------------------------");
        System.out.println(ANSI_YELLOW + "ID   STATUS     TITLE (AUTHOR)" + ANSI_RESET);
        for (Book book : books) {
            System.out.printf("%-4d %-10s %s (%s)\n", book.getId(), book.getStatus(), book.getTitle(), book.getAuthor());
        }
    }

    private void borrowBook() {
        int bookID = inputInt("Enter the book ID:");
        Book book = bookList.getBookById(bookID);
        int memberID = inputInt("Enter the member ID:");
        Member member = memberList.getMemberById(memberID);

        if(!book.isBorrowed()) {
            book.checkOut(member);
            member.checkOutBook(book);
            System.out.print(ANSI_RED + " " + book.getTitle() + ANSI_RESET);
            System.out.print(" is now loaned to " + ANSI_PURPLE + member.getName() + ANSI_RESET + "\n");
        } else {
            System.out.println("Book is currently on loan");
        }
    }

    private void returnBook() {
        int bookID = inputInt("Enter the book ID:");
        Book book = bookList.getBookById(bookID);
        int memberID = inputInt("Enter the member ID:");
        Member member = memberList.getMemberById(memberID);

        if(book.isBorrowed()) {
            book.checkIn(); // this is enough!
//            book.checkIn(book);
//            member.checkInBook(book);
            System.out.print(ANSI_GREEN + book.getTitle() + ANSI_RESET);
            System.out.print(" has now been returned from " + ANSI_BLUE + member.getName() + ANSI_RESET + "\n");
        }
    }

    /**
     * Handles our book menu for the user
     * @author Jun
     */
    private void handleBookMenu() {
        printBooks(this.bookList.getBooks());
        System.out.println("- [B]orrow a book");
        System.out.println("- [R]eturn a book");
        System.out.println(" [E]xit the menu");

        String choice = inputString("Select an option: ").toLowerCase();
        switch (choice) {
            case "b":
                borrowBook();
                break;
            case "r":
                returnBook();
                break;
            default:
                break;
        }
    }

    /**
     * Prints out all members of our library.
     * @author Jun
     * @param members
     */
    private void printMembers(List<Member> members) {
        System.out.println("\nList of all members:");
        System.out.println("---------------------------------------");
        System.out.printf("%-5s %-20s\n", "ID", "NAME");
        for (Member member : members) {
            System.out.printf("%-5d %-20s\n", member.getId(), member.getName());
        }
    }

    private void handleMemberMenu() {
        printMembers(this.memberList.getMembers());
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
            System.out.print("- Manage [b]ooks\n- Manage [m]embers\n- Save and [e]xit");

            String choice = inputString("Select an Option: ").toLowerCase();
            switch (choice) {
                case "b":
                    handleBookMenu();
                    break;
                case "m":
                    printMembers(this.memberList.getMembers());
                    break;
                case "e":
                    System.out.println("to do");
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * saves current system as a JSON file
     * @author Mr Nam
     */
    public void save() {
        SaveLoad sl = new SaveLoad(this.saveLocation);
        sl.save(this);
    }

    /**
     * loads saved states from the save file
     * @author Mr Nam
     */
    public void load() {
        SaveLoad sl = new SaveLoad(this.saveLocation);
        LibrarySystem loaded = sl.load(this.getClass());
        this.memberList = loaded.memberList;
        this.bookList = loaded.bookList;
    }
}
