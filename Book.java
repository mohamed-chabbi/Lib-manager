
public class Book {

    private int ID;
    private String title;
    private String author;
    private boolean isBorrowed;
    private int borrowedBy;

    public Book(int ID, String author, String title) {
        this.ID = ID;
        this.author = author;
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public int  getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(int  borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("ID=").append(ID);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", isBorrowed=").append(isBorrowed);
        sb.append(", borrowedBy=").append(borrowedBy);
        sb.append('}');
        return sb.toString();
    }

}
