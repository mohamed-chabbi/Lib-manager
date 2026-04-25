
import java.io.Serializable;
import java.util.*;

public class Member implements Serializable {

    private int ID;
    private String name;
    private List<Integer> borrowedBookIds = new ArrayList<>();

    public Member(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public int getBorrowedCount() {
        return borrowedBookIds.size();
    }

    public void setBorrowedBookIds(int bookID) {
        this.borrowedBookIds.add(bookID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Member{");
        sb.append("ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", borrowedBookIds=").append(borrowedBookIds);
        sb.append('}');
        return sb.toString();
    }

}
