/**
 * Created by stud on 01.03.2019.
 */
public class Main {
    public static void main(String[] args) {
        BooksLibrary lib = new BooksLibrary();
        Book testBook = new Book("Second book", "Pushka", 1799);
        lib.booklist.add(new Book("First book", "Author1", 2000));
        lib.booklist.add(new Book("Second book", "Author2", 2000));
        lib.booklist.add(new Book("Third book", "AncientAuthor", 1622));
        lib.booklist.add(testBook);
        lib.booklist.add(new Book("This is book", "Pushka", 1812));
        System.out.println(lib.getBooksByYear(2000));
        System.out.println(lib.getBooksByName("Second book"));
        System.out.println(lib.getBooksByAuthor("Pushka"));
        lib.delete(testBook);
        System.out.println("Удалили книгу");
        System.out.println(lib.getBooksByAuthor("Pushka"));
    }
}
