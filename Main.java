import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // ========== PRELOAD MANY BOOKS FOR TESTING ==========
        try {
            service.addBook(new Book(1, "George Orwell", "1984"));
            service.addBook(new Book(2, "Harper Lee", "To Kill a Mockingbird"));
            service.addBook(new Book(3, "F. Scott Fitzgerald", "The Great Gatsby"));
            service.addBook(new Book(4, "Jane Austen", "Pride and Prejudice"));
            service.addBook(new Book(5, "J.D. Salinger", "The Catcher in the Rye"));
            service.addBook(new Book(6, "Herman Melville", "Moby Dick"));
            service.addBook(new Book(7, "Leo Tolstoy", "War and Peace"));
            service.addBook(new Book(8, "Mark Twain", "Adventures of Huckleberry Finn"));
            service.addBook(new Book(9, "Charles Dickens", "Great Expectations"));
            service.addBook(new Book(10, "Bram Stoker", "Dracula"));
            System.out.println("10 test books loaded successfully.");
        } catch (DuplicateItemException e) {
            System.out.println("Error loading test books: " + e.getMessage());
        }

        // ========== MAIN MENU LOOP ==========
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. List All Members");
            System.out.println("7. Search Books by Title");
            System.out.println("8. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        service.addBook(new Book(id, author, title));
                        System.out.println("Book added.");
                        break;
                    case 2:
                        System.out.print("ID: ");
                        int mid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        service.addMember(new Member(mid, name));
                        System.out.println("Member added.");
                        break;
                    case 3:
                        System.out.print("Book ID: ");
                        int bid = scanner.nextInt();
                        System.out.print("Member ID: ");
                        int memid = scanner.nextInt();
                        service.borrowBook(bid, memid);
                        System.out.println("Book borrowed.");
                        break;
                    case 4:
                        System.out.print("Book ID: ");
                        int rbid = scanner.nextInt();
                        System.out.print("Member ID: ");
                        int rmid = scanner.nextInt();
                        service.returnBook(rbid, rmid);
                        break;
                    case 5:
                        for (Book b : service.listAllBooks()) {
                            System.out.println(b);
                        }
                        break;
                    case 6:
                        for (Member m : service.listAllMembers()) {
                            System.out.println(m);
                        }
                        break;
                    case 7:
                        System.out.print("Keyword: ");
                        String keyword = scanner.nextLine();
                        List<Book> results = service.searchBooksByTitle(keyword);
                        if (results.isEmpty()) {
                            System.out.println("No books found.");
                        } else {
                            for (Book b : results) {
                                System.out.println(b);
                            }
                        }
                        break;
                    case 8:
                        System.out.println("Goodbye.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}