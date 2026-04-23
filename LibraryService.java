
import java.util.*;

public interface  LibraryService {
void addBook(Book book) throws DuplicateItemException;

void addMember(Member member) throws DuplicateItemException;

void borrowBook(int bookId, int memberId) throws Exception;

void returnBook(int bookId, int memberId) throws Exception;

List<Book> listAllBooks();

List<Member> listAllMembers();

List<Book> searchBooksByTitle(String keyword);

void saveData() throws Exception;

void loadData() throws Exception;
}
