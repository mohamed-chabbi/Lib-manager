
import java.util.*;

public interface LibraryService {

    public void addBook(Book book) throws DuplicateItemException;

    public void addMember(Member member) throws DuplicateItemException;

    public void borrowBook(int bookId, int memberId) throws Exception;

    public void returnBook(int bookId, int memberId) throws Exception;

    public List<Book> listAllBooks();

    public List<Member> listAllMembers();

    public List<Book> searchBooksByTitle(String keyword);

}
