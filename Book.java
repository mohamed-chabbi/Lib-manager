
public class Book {

    private int ID;
    private String title;
    private String author;
    private int borrowedBy;  

    public Book(int ID, String author, String title) {
        this.ID = ID;
        this.author = author;
        this.title = title;
        this.borrowedBy = -1;
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

    public int getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(int borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public boolean isBorrowed() {
        return borrowedBy != -1;
    }

    @Override
    public String toString() {
        return "Book{ID=" + ID + ", title=" + title + ", author=" + author
                + ", borrowedBy=" + (borrowedBy == -1 ? "none" : borrowedBy) + "}";
    }
}
