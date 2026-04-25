import java.util.Scanner;

public class Menu {

    public static int menu() {
        System.out.println("1.Add book\n2.Add member\n3.Borrew book\nReturn book\n5.List all books\n6.List all members\n7.Search book by title\n8.Exit");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                throw new AssertionError();
        }
    }
}
