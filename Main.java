
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(123, "John C Maxwell", "self improvment 101"));
        books.add(new Book(144, "John C Maxwell", "Five levels of Leadership"));
        books.add(new Book(155, "James Clear", "Atomic habits"));
        books.add(new Book(166, "John C Maxwell", "Make Today Count"));
        books.add(new Book(123, "John C Maxwell", "Failing Forward"));
    
        int a = Menu.menu();
    System.out.println(LibraryService.addBook(books , new Book(123, "John C Maxwell", "Failing Forward")));
    }
}