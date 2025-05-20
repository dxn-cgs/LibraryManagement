package libraryManager;

import java.util.*;

/**
 * Class:
 * Author:
 * LastEdited:
 * Description: [What this class does in 1–2 sentences.]
 */
public class MemberList {
    private int nextId;
    private List<Member> members;
    
    public MemberList() {
        this.nextId = 0;
        this.members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public Member getMemberById(int id) {
        for (Member member: this.members) {
            if (id == member.getId()) {
                return member;
            }
        }
        throw new NoSuchElementException("No member exists with the given id");
    }

    public void addMember(String name) {
        members.add(new Member(this.nextId, name));
        this.nextId += 1;
    }
}
