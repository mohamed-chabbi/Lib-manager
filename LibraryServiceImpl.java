import java.util.*;

public class LibraryServiceImpl implements LibraryService {

    private Map<Integer, Book> booksMap = new HashMap<>();
    private Map<Integer, Member> membersMap = new HashMap<>();

    @Override
    public void addBook(Book book) throws DuplicateItemException {
        if (booksMap.containsKey(book.getID())) {
            throw new DuplicateItemException("this book already exist");
        }
        booksMap.put(book.getID(), book);
    }

    @Override
    public void addMember(Member member) throws DuplicateItemException {
        if (membersMap.containsKey(member.getID())) {
            throw new DuplicateItemException("this member already exist");
        }
        membersMap.put(member.getID(), member);
    }

    @Override
    public void borrowBook(int bookId, int memberId) throws Exception {
        if (!booksMap.containsKey(bookId)) {
            throw new BookNotFoundException("Book ID " + bookId + " not found");
        }
        if (!membersMap.containsKey(memberId)) {
            throw new MemberNotFoundException("Member ID " + memberId + " not found");
        }
        Member member = membersMap.get(memberId);
        if (member.getBorrowedCount() >= 3) {
            throw new MemberLimitExceededException("Member already has 3 books");
        }

        Book book = booksMap.get(bookId);
        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("book is borrowed");
        } else {
            member.setBorrowedBookIds(book.getID());
            book.setBorrowedBy(memberId);
            // No setIsBorrowed – borrowed status derived from borrowedBy != -1
        }
    }

    @Override
    public void returnBook(int bookId, int memberId) throws Exception {
        if (!booksMap.containsKey(bookId)) {
            throw new BookNotFoundException("Book ID " + bookId + " not found");
        }
        if (!membersMap.containsKey(memberId)) {
            throw new MemberNotFoundException("Member ID " + memberId + " not found");
        }

        Book book = booksMap.get(bookId);
        if (!book.isBorrowed()) {
            throw new Exception("Book is not currently borrowed");
        }

        int borrowedBy = book.getBorrowedBy();
        if (borrowedBy != memberId) {
            throw new Exception("Book was borrowed by a different member");
        }

        Member member = membersMap.get(memberId);
        member.getBorrowedBookIds().remove(Integer.valueOf(bookId));

        book.setBorrowedBy(-1);
        System.out.println("Book returned successfully.");
    }

    @Override
    public List<Book> listAllBooks() {
        return new ArrayList<>(booksMap.values());
    }

    @Override
    public List<Member> listAllMembers() {
        return new ArrayList<>(membersMap.values());
    }

    @Override
    public List<Book> searchBooksByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksMap.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}