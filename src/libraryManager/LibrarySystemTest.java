package libraryManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {

    @Test
    void shouldSaveAndLoad() {
        LibrarySystem ls = new LibrarySystem();

        ls.save();
        ls.load();
    }
}