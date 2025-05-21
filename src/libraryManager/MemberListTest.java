package libraryManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberListTest {

    @Test
    void shouldAddAMember() {
        Member a = new Member(0, "Test Member");
        assertEquals(0, a.getId());
        assertEquals("Test Member", a.getName());
    }

    @Test
    void shouldNotAddAMemberWithExistingId() {
        Member a = new Member(0, "Test Member");
        Member b = new Member(0,"Test Member2");
        if(a.getId() == b.getId()){
            throw new RuntimeException("cannot have 2 identical id's");
        }

    }
}