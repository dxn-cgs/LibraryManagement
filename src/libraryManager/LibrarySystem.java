package libraryManager;

import com.google.gson.reflect.TypeToken;

import static jets.Jets.*;
import java.util.*;

import static libraryManager.ColoredString.color;

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

    public LibrarySystem() {
        this.bookList = new BookList();
        this.memberList = new MemberList();
        this.saveLocation = "save.json";
    }

    /**
     * TODO: complete this
     * @author
     * @return Member: the member which owns the book
     */
    private Member getBorrowerOf(int id) {
        Book book = bookList.getBookById(id);
        return book.getBorrowedBy();
    }

    /**
     * Prints out all books we have in our library and displays if they are available
     * @author Jun
     * @param books List of books we have in the library
     */
    private void printBooks(List<Book> books) {
        System.out.println("\nList of all books:");
        System.out.println("---------------------------------------");
        System.out.println(color("ID   STATUS     TITLE (AUTHOR)", "yellow"));
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
            System.out.print(" " + color(book.getTitle(), "red"));
            System.out.print(" is now loaned to " + color(member.getName(), "purple") + "\n");
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
            book.checkIn();
            System.out.print(color(book.getTitle(), "green"));
            System.out.print(" has now been returned from " + color(member.getName(), "blue") + "\n");
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

    private void listBorrowedBooks() {
        int id = inputInt("Enter the member ID: ");
        Member member = memberList.getMemberById(id);
        printBooks(member.getBorrowedBooks());
    }

    /**
     * Creates a new list of books that are available from all books
     * @author leo
     * @param isBorrowed
     * @param books
     * @return filtered list of books
     */
    private List<Book> filterByAvailableBooks(boolean isBorrowed, List<Book> books) {
        List<Book> filtered = new ArrayList<>();
        for (Book book : books) {
            if (book.isBorrowed() == isBorrowed){
                filtered.add(book);
            }
        }
        return filtered;
    }

    private void createMember() {
        int characterLimit = 32;
        while (true) {
            String name = inputString("Please enter your name (32 characters or under):");
            if (name.length() < characterLimit) {
                memberList.addMember(name);
                System.out.println("Member created");
                return;
            } else {
                System.out.println("Name is too long");
            }
        }
    }

    private void handleMemberMenu() {
        printMembers(this.memberList.getMembers());
        System.out.println("- [C]reate a new member, ");
        System.out.println("- [V]iew a member's books");
        System.out.println("- [E]xit\n");

        String choice = inputString("\nSelect and Option: ").toLowerCase();

        switch(choice) {
            case "c":
                createMember();
                break;
            case "v":
                listBorrowedBooks();
                break;
            default:
                break;
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
        System.out.println("- [S]earch for a book");
        System.out.println("- [F]ind Available books");
        System.out.println(" [E]xit the menu");

        String choice = inputString("\nSelect an option: ").toLowerCase();
        switch (choice) {
            case "b":
                borrowBook();
                break;
            case "r":
                returnBook();
                break;
            case "s":
                int id = inputInt("Enter Book ID: ");
                Member member = getBorrowerOf(id);
                System.out.println("Book is loaned by " + member.getName());
            default:
                break;
        }
    }



    /**
     *
     * Main loop which the program will run on
     * @author Jun
     */
    public void run() {
        // load the books and members
        this.load();

        while (true) {
            System.out.println("Welcome to the CGS Library Manager!");
            System.out.print("- Manage [b]ooks\n- Manage [m]embers\n- Save and [e]xit");

            String choice = inputString("Select an Option: ").toLowerCase();
            switch (choice) {
                case "b":
                    handleBookMenu();
                    break;
                case "m":
                    handleMemberMenu();
                    break;
                case "e":
                    return;
                default:
                    break;
            }
        }

    }

    /**
     * loads saved states from the save file
     * @author Mr Nam
     */
    public void load() {
        SaveLoad sl = new SaveLoad(this.saveLocation);
        TypeToken<LibrarySystem> typeToken = new TypeToken<>(){};
        LibrarySystem loaded = sl.load(typeToken);
        this.memberList = loaded.memberList;
        this.bookList = loaded.bookList;
    }
}
